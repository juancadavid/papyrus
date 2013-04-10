/**
 * Copyright CEA-LIST 2009
 * available under EPL 1.0 licence
 * 
 * This file is part of the Qompass tool chain (www.ec3m.net)
 * 
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */

package org.eclipse.papyrus.acceleo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.common.IAcceleoConstants;
import org.eclipse.acceleo.engine.AcceleoEnginePlugin;
import org.eclipse.acceleo.engine.AcceleoEvaluationException;
import org.eclipse.acceleo.engine.generation.AcceleoEngine;
import org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy;
import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.acceleo.model.mtl.ModuleElement;
import org.eclipse.acceleo.model.mtl.Template;
import org.eclipse.acceleo.model.mtl.resource.AcceleoResourceSetImpl;
import org.eclipse.acceleo.parser.AcceleoParser;
import org.eclipse.acceleo.parser.AcceleoSourceBuffer;
import org.eclipse.acceleo.parser.cst.ModuleImportsValue;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;

public class AcceleoDriver {

	/**
	 * URI of file that is currently evaluated
	 */
	public static final URI currentURI = URI.createURI("current." + IAcceleoConstants.EMTL_FILE_EXTENSION);

	public static void init() {
		engine = new AcceleoEngine();
		parser = new AcceleoParser();
		// some errors are silently captured inside the evaluation query (@see AcceleoEvaluationVisiton.visitExpression). Yet they produce
		// an event in the Acceleo log which is captured via this listener.
		AcceleoEnginePlugin.getDefault().getLog().addLogListener(new ILogListener() {

			public void logging(IStatus status, String plugin) {
				logEntries.add(status);

			}
		});
		acceleoResourceSet = new AcceleoResourceSetImpl();
		acceleoResourceSet.createResource(currentURI);
	}

	/**
	 * Execute a script passed as parameter. It will be executed in the context
	 * of a base script that declares the meta-model (UML2) and has additional
	 * imports (currently none).
	 * 
	 * @param template
	 *        The template in string form
	 * @param element
	 *        The UML element to which the template is applied
	 * @return the evaluated template
	 */
	public static String bind(String templateStr, Element element) throws AcceleoException {
		return evaluate(templateStr, element, null);
	}

	/**
	 * find an MTL file in a plugin. This functions assumes that the relative path (to a "bin" folder) within the
	 * plugin includes the plug-in name as a prefix
	 * 
	 * @param moduleName
	 *        qualified name within the plug-in (assuming that the associated file is located
	 *        in a sub-folder with the name "bin")
	 */
	public static URI findFileInPlugin(String moduleName) {
		String relativePath = moduleName.replace(IAcceleoConstants.NAMESPACE_SEPARATOR, File.separator);
		String segments[] = moduleName.split(IAcceleoConstants.NAMESPACE_SEPARATOR);

		for(int pass = 0; pass < 2; pass++) {
			// try bin directory in first pass (deployed plugins: don't use bin, devel: use bin).
			// Problem: resource is also found without bin, but resolving fails later
			String binSep = (pass == 0) ? "/bin/" : "/";
			for(int segmentLen = segments.length - 1; segmentLen > 1; segmentLen--) {
				String pluginNameCandidate = segments[0];
				for(int i = 1; i < segmentLen; i++) {
					pluginNameCandidate += "." + segments[i];
				}

				String fileNameCandidate = pluginNameCandidate + binSep + relativePath +
					"." + IAcceleoConstants.EMTL_FILE_EXTENSION;
				// String absoluteFileName = Utils.getAbsoluteFN(fileNameCandidate);
				// if(absoluteFileName != null) {
				// }

				URI uri = URI.createPlatformPluginURI(fileNameCandidate, true);
				try {
					Resource r = acceleoResourceSet.getResource(uri, true);
					if(r != null) {
						// use absolute path, if possible, i.e. if file exists at absolute path
						// this is required, since Acceleo references dependent file using a relative
						// path
						String absoluteFileName = Utils.getAbsoluteFN(uri.toString());
						if(absoluteFileName != null) {
							File fileCandidate = new File(absoluteFileName);
							if(fileCandidate.exists()) {
								// remove resource with "wrong" URI
								removeURIfromResourceSet(uri);
								return URI.createFileURI(fileCandidate.getAbsolutePath());
							}
						}
						return uri;
					}
				} catch (Exception e) {
					// the URI has been added to the resource set, although there is an exception.
					removeURIfromResourceSet(uri);
				}
			}
		}
		return null;
	}

	/**
	 * Small helper: remove a URI from the AcceleoResourceSet
	 * 
	 * @param uri
	 */
	protected static void removeURIfromResourceSet(URI uri) {
		for(Resource resource : acceleoResourceSet.getResources()) {
			if(resource.getURI() == uri) {
				acceleoResourceSet.getResources().remove(resource);
				break;
			}
		}
	}

	/**
	 * Evaluate an Acceleo template
	 * 
	 * @param ob
	 *        An opaque behavior whose first body contains an Acceleo template that should be evaluated
	 * @param element
	 *        The UML element to which the template is applied
	 * @param args
	 *        an array of arguments that are passed to the template. Each argument
	 *        must be either an EObject, a String, an Integer or a Boolean
	 *        (TODO: currently not evaluated)
	 * @return the evaluated template
	 * @return
	 * @throws AcceleoException
	 */
	public static String evaluate(OpaqueBehavior b, Element element, Object args[]) throws AcceleoException {
		// script = null;
		if(b.getBodies().size() > 0) {
			String body = b.getBodies().get(0);
			return evaluate(body, b.getQualifiedName(), element, args);
		}
		return null;
	}

	/**
	 * Evaluate an Acceleo template
	 * 
	 * @param template
	 *        The template in string form
	 * @param element
	 *        The UML element to which the template is applied
	 * @param args
	 *        an array of arguments that are passed to the template. Each argument
	 *        must be either an EObject, a String, an Integer or a Boolean
	 *        (TODO: currently not evaluated)
	 * @return the evaluated template
	 */
	public static String evaluate(String templateStr, Element element, Object args[]) throws AcceleoException {
		return evaluate(templateStr, "", element, args);
	}

	/**
	 * Evaluate an Acceleo template
	 * 
	 * @param templateStr
	 *        The acceleo template in string form
	 * @param templateName
	 *        The name under which a template can be identified, i.e. the file name
	 *        if the template is stored in a file and the qualified name of the model element (opaque
	 *        behavior) if the template is stored within the model.
	 * @param element
	 *        The UML element to which the template is applied
	 * @param args
	 *        an array of arguments that are passed to the template. Each argument
	 *        must be either an EObject, a String, an Integer or a Boolean
	 *        (TODO: currently not evaluated)
	 * @return the evaluated template
	 * @throws AcceleoException
	 */
	public static String evaluate(String templateStr, String templateName, Element element, Object args[]) throws AcceleoException {
		if(templateStr == null) {
			return null;
		}

		if(engine == null) {
			init();
		}

		// support non declaration of a template for default naming operations
		if(!(templateStr.startsWith("[import") || templateStr.startsWith("[template") || templateStr.startsWith("[module"))) {
			templateStr = "[template public dummy(ne : NamedElement)]\n" + templateStr + "\n[/template]\n";
		}

		// module names are not relevant, since passed templates can not be called by others
		if(!templateStr.startsWith("[module")) {
			templateStr = "[module dummyMod('http://www.eclipse.org/uml2/4.0.0/UML')/]\n\n" + templateStr;
		}

		// Strategy:
		//   1. Use AcceleoParser to transform text (OpaqueExpression) into Module
		//		=> list of dependencies via explicit import statements
		//   2. Use AcceleoEngine to resolve expression.

		// Strategy first: parse imports: verify, if already in resourceSet 

		AcceleoSourceBuffer sourceBuffer = new AcceleoSourceBuffer(new StringBuffer(templateStr));

		Resource resource = acceleoResourceSet.getResource(currentURI, false);

		try {
			EList<URI> depURIs = new BasicEList<URI>();
			logEntries.clear();
			// deps.add(outputURI);

			// check, if imports are already in resource set
			sourceBuffer.createCST();
			for(ModuleImportsValue importValue : sourceBuffer.getCST().getImports()) {
				String importedModuleName = importValue.getName();
				if(importedModuleName != null) {
					// String pathName = importedModuleName.replace(IAcceleoConstants.NAMESPACE_SEPARATOR, File.separator);

					URI depURI = findFileInPlugin(importedModuleName);
					if(depURI != null) {
						depURIs.add(depURI);
						// Resource r = acceleoResourceSet.getResource(depURI, true);
					}
					else {
						throw new AcceleoException("Could not find imported module:\n" + importedModuleName + "\n\n" +
							"The module (in compiled form, i.e. with .emtl) is searched in the path corresponding to its qualified name " +
							"(starting with the \"bin\" directory, if a source plugin) of dependend plug-ins. Verify that these have the " +
							"Acceleo nature");
					}
				}
			}

			// parse imported files - not required, EMTL files exist already
			// parser.parse(depInputFiles, outputURIs, new BasicEList<URI>(), null, new BasicMonitor());

			parser.parse(sourceBuffer, resource, depURIs);
			if(sourceBuffer.getProblems().getList() != null) {
				if(sourceBuffer.getProblems().getList().size() > 0) {
					// System.err.println(sourceBuffer.getProblems().getMessage());
					throw new AcceleoException("Acceleo problem: " + sourceBuffer.getProblems().getMessage() +
						"\n\nTemplate: " + templateName + "\n" + templateStr);
				}
			}
			String result = evaulateResource(resource, element, templateName, templateStr);
			if(result != null) {
				return result;
			}
		} catch (AcceleoEvaluationException e) {
			String elementStr = (element instanceof NamedElement ? ((NamedElement)element).getQualifiedName() : element.toString());
			throw new AcceleoException("Acceleo EvaluationException" + e + "\n\nPassed element: " + elementStr +
				"\n\nTemplate: " + templateName + "\n" + templateStr);
		}
		return "";
	}

	/**
	 * Evaluate a template within the given module. Assume that the template has the same name as
	 * the module. If this is not the case, use the function below
	 * 
	 * @param moduleName
	 *        a qualified Acceleo module name, elements are separated by '::'
	 * @param element
	 * @return
	 */
	public static String evaluateURI(String moduleName, Element element) {
		int index = moduleName.lastIndexOf("::");
		String templateName = (index == -1) ? moduleName : moduleName.substring(index + 2);
		return evaluateURI(moduleName, templateName, element);
	}


	public static String evaluateURI(String moduleName, String templateName, Element element) {
		//throws AcceleoException {
		if(engine == null) {
			init();
		}
		try {
			// return evaluateURI(URI.createURI("org.eclipse.papyrus.cpp.codegen" + "/" + uriStr.replace(".", "/") + "." + IAcceleoConstants.EMTL_FILE_EXTENSION), element);
			return evaluateURI(findFileInPlugin(moduleName), templateName, element);
		} catch (AcceleoException e) {
		}
		return null;
	}

	public static String evaluateURI(URI uri, String templateName, Element element) throws AcceleoException {

		if(engine == null) {
			init();
		}

		Resource resource = acceleoResourceSet.getResource(uri, true);
		if(resource != null) {
			return evaulateResource(resource, element, templateName, "");
		}
		return null;
	}

	protected static String evaulateResource(Resource resource, Element element, String templateName, String templateStr) throws AcceleoException {
		if(resource.getContents().size() > 0) {
			EObject result = resource.getContents().get(0);
			List<Object> arguments = new ArrayList<Object>();
			// The input model itself is a potential argument
			arguments.add(element);
			if(result instanceof Module) {
				Module module = (Module)result;
				for(ModuleElement me : module.getOwnedModuleElement()) {
					if((me instanceof Template) && me.getName().equals(templateName)) {
						logEntries.clear();
						Object stringResult = engine.evaluate((Template)me, arguments, new PreviewStrategy(), null);
						// System.err.println("result: " + stringResult);
						if(logEntries.size() > 0) {
							IStatus e = logEntries.get(0);
							Throwable exception = e.getException();
							String message = exception.getMessage();

							if(exception.getCause() instanceof InvocationTargetException) {
								Throwable targetException = ((InvocationTargetException)exception.getCause()).getTargetException();
								if(targetException != null) {
									message = targetException.getMessage();
								}
							}
							throw new AcceleoException("Acceleo evaluation problems (showing only first): " + message +
								"\n\nTemplate: " + templateName + "\n" + templateStr);

						}
						if(stringResult instanceof String) {
							return (String)stringResult;
						}
					}
				}
			}
		}
		return null;
	}

	protected static EList<IStatus> logEntries = new BasicEList<IStatus>();

	protected static AcceleoEngine engine = null;

	protected static ResourceSet acceleoResourceSet;

	protected static AcceleoParser parser;
}