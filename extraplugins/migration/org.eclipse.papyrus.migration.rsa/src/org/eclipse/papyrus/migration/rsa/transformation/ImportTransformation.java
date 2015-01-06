/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.transformation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.papyrus.m2m.qvto.TransformationUI;
import org.eclipse.papyrus.migration.rsa.Activator;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.Config;
import org.eclipse.papyrus.migration.rsa.RSAToPapyrusParameters.RSAToPapyrusParametersFactory;
import org.eclipse.papyrus.migration.rsa.blackbox.ProfileBaseHelper;
import org.eclipse.papyrus.migration.rsa.default_.DefaultPackage;
import org.eclipse.papyrus.migration.rsa.profilebase.ProfileBasePackage;
import org.eclipse.papyrus.uml.documentation.Documentation.DocumentationPackage;
import org.eclipse.papyrus.umlrt.statemachine.UMLRealTimeStateMach.UMLRealTimeStateMachPackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Executes a single RSA-to-Papyrus transformation
 *
 * @author Camille Letavernier
 *
 */
public class ImportTransformation {

	// SourceURI is the input
	protected final URI sourceURI;

	// targetURI is computed during the transformation
	protected URI targetURI;

	protected ModelExtent outUML, outNotation, outSashModel, inParameters, inPapyrusProfiles;

	protected ResourceSet resourceSet;

	protected boolean cacheTransformations;

	protected Job job;

	protected Resource umlResource;

	protected Config parameters;

	protected boolean complete = false;

	/** Source URI to Target URI map (For Models/Libraries/Fragments) */
	protected final Map<URI, URI> uriMappings = new HashMap<URI, URI>();

	/** Source URI to Target URI map (For Profiles) */
	protected final Map<URI, URI> profileURIMappings = new HashMap<URI, URI>();

	protected List<Diagram> diagramsToDelete = new LinkedList<Diagram>();

	// The cache can be used to increase performances (For small and medium sized models, most of the execution time is spent in loading the transformation)
	// Warning: using the cache prevents dynamic transformations (i.e. it should not be used in Debug Mode)
	protected static final Map<URI, TransformationExecutor> sharedTransformations = new HashMap<URI, TransformationExecutor>();

	// Separate local cache for preloading transformations if cacheTransformations = false (Mostly for debug purpose)
	protected final Map<URI, TransformationExecutor> localTransformations = new HashMap<URI, TransformationExecutor>();

	public ImportTransformation(URI sourceURI) {
		this(sourceURI, RSAToPapyrusParametersFactory.eINSTANCE.createConfig());
	}

	public ImportTransformation(URI sourceURI, Config config) {
		Assert.isNotNull(sourceURI);
		this.sourceURI = sourceURI;
		this.parameters = config;

		this.cacheTransformations = true;
	}

	public void run() {
		run(true);
	}

	/**
	 * Executes the transformation
	 *
	 * The transformation will be executed asynchronously in a Job
	 */
	public void run(final boolean isUserJob) {

		job = new Job("Import " + getModelName()) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				return ImportTransformation.this.run(monitor);
			}
		};

		job.setUser(isUserJob);

		job.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(IJobChangeEvent event) {
				complete = true;
				if (isUserJob) {
					if (event.getResult().getSeverity() == IStatus.OK) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), job.getName(), String.format("Model %s has been successfully imported", getModelName()));
							}
						});

					} else if (event.getResult().getSeverity() == IStatus.CANCEL) {
						Display.getDefault().asyncExec(new Runnable() {

							@Override
							public void run() {
								MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), job.getName(), String.format("Operation canceled: %s", getModelName()));
							}
						});
					} else {
						StatusManager.getManager().handle(event.getResult(), StatusManager.BLOCK);
					}
				}
			}

		});

		job.schedule();
	}

	public void waitForCompletion() {
		try {
			job.join();
		} catch (InterruptedException ex) {
			Activator.log.error(ex);
		}
	}

	public boolean isComplete() {
		return complete;
	}

	public IStatus getStatus() {
		if (job == null) { // If job hasn't been created, the operation has probably been canceled before the transformation is ran
			return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Operation canceled");
		}
		return job.getResult();
	}

	public Map<URI, URI> getURIMappings() {
		return uriMappings;
	}

	public Map<URI, URI> getProfileURIMappings() {
		return profileURIMappings;
	}

	public URI getTargetURI() {
		return targetURI;
	}

	/**
	 * Initializes the resource set, and resolve all dependencies
	 */
	protected void initResourceSet(IProgressMonitor monitor) {
		resourceSet = new ResourceSetImpl();
		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		resourceSet.getLoadOptions().put(XMLResource.OPTION_USE_PACKAGE_NS_URI_AS_LOCATION, Boolean.FALSE);

		monitor.subTask("Loading source model " + getModelName());

		try {
			resourceSet.getResource(sourceURI, true);
			loadInPapyrusProfiles();
		} catch (Exception ex) {
			Activator.log.error("An error occurred while loading " + getModelName(), ex);
		}

		monitor.subTask("Resolving all dependencies...");
	}

	/**
	 * Returns the number of elements to be migrated (i.e. diagrams to be migrated + specific non-trivial elements)
	 * Used to initialize the progress monitor
	 *
	 * @return
	 *         The total number of elements to be migrated
	 */
	protected int countSupportedElements() {
		int i = 0;

		ModelExtent extent = getInOutUMLModel();
		for (EObject eObject : extent.getContents()) {

			// We already called ResolveAll, there is no need to try resolution again
			TreeIterator<EObject> modelIterator = EcoreUtil.getAllContents(eObject, false);
			while (modelIterator.hasNext()) {
				EObject next = modelIterator.next();
				if (next instanceof Diagram) {
					Diagram diagram = (Diagram) next;
					if (isSupported(diagram)) {
						i++;
						diagramsToDelete.add(diagram);
					}
					modelIterator.prune(); // Don't navigate Diagram children
				} else if (next instanceof OpaqueExpression) {
					if (parameters.isConvertOpaqueExpressionToLiteralString()) {
						OpaqueExpression exp = (OpaqueExpression) next;
						if (needsConversion(exp)) {
							i++;
						}
					}
				}
			}
		}

		i += getAllTransformationURIs().size();

		return i;
	}

	/**
	 * Returns true if the OpaqueExpression is to be converted to a LiteralString
	 * OpaqueExpressions are converted to LiteralString when they have a single body with no language
	 *
	 * @param exp
	 * @return
	 */
	protected static boolean needsConversion(OpaqueExpression exp) {
		List<String> languages = exp.getLanguages();
		List<String> bodies = exp.getBodies();
		if (bodies.size() > 1) {
			return false;
		}

		if (languages.isEmpty() || (languages.size() == 1 && exp.getLanguages().get(0).isEmpty())) {
			return true;
		}

		return false;
	}

	protected static final Set<String> supportedDiagramIds = new HashSet<String>();

	protected static boolean isSupported(Diagram diagram) {
		return supportedDiagramIds.contains(diagram.getType());
	}

	// Preloads all required transformations (Either locally or statically, depending on the cache parameter)
	protected IStatus loadTransformations(IProgressMonitor monitor) {
		for (URI transformationURI : getAllTransformationURIs()) {
			try {
				// Don't use a subprogress monitor, since it may be confusing
				getTransformation(transformationURI, new NullProgressMonitor());
				monitor.worked(1);
			} catch (DiagnosticException ex) {
				return createStatusFromDiagnostic(ex.getDiagnostic());
			}
		}

		return Status.OK_STATUS;
	}

	// MemoryLeak: Don't rely on BasicDiagnostic.toIStatus
	// The source Diagnostic contains references to the QVTo ModelExtents, referencing the Model elements (used in #extractPapyrusProfiles())
	// When using the standard conversion, these references are not discarded
	protected static IStatus createStatusFromDiagnostic(Diagnostic diagnostic) {
		return new Status(diagnostic.getSeverity(),
				diagnostic.getSource(),
				diagnostic.getMessage(),
				diagnostic.getException());
	}

	/**
	 * Actually runs the transformation (in the current thread)
	 *
	 * @param monitor
	 * @return The transformation IStatus
	 */
	protected IStatus run(final IProgressMonitor monitor) {

		//
		// INITIALIZATION / LOADING
		//

		monitor.subTask("Loading source model " + getModelName());

		initResourceSet(monitor);

		int numberOfElements = countSupportedElements();

		monitor.beginTask("Importing " + getModelName(), numberOfElements);

		monitor.subTask("Loading transformations (This may take a few seconds for the first import)...");
		loadTransformations(monitor);


		List<ModelExtent> extents = getModelExtents();

		String statusMessage = String.format("Import %s", getModelName());
		MultiStatus generationStatus = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, statusMessage, null);

		ExecutionContext context = createExecutionContext(monitor, generationStatus);

		//
		// TRANSFORMATIONS
		//

		IStatus result; // Result of an individual transformation (Will be aggregated to the complete GenerationStatus)

		// UML RT (First operation, because it can transform Collaborations to Classes, which has some consequences on the diagram transformation)
		// TODO: Restore the UML RT transformation (Update to UML RT v3)
		result = importRTProfile(context, monitor);
		generationStatus.add(result);

		// Diagrams
		Collection<URI> transformations = getDiagramTransformationURIs();

		monitor.subTask("Importing diagrams...");
		for (URI transformationURI : transformations) {
			result = runTransformation(transformationURI, context, monitor, extents);
			generationStatus.add(result);
		}

		// Semantic model changes (Default language for OpaqueExpressions...)
		monitor.subTask("Importing semantic model...");
		result = runTransformation(getSemanticTransformationURI(), context, monitor, extents);
		generationStatus.add(result);

		if (!monitor.isCanceled()) {
			monitor.subTask("Handle additional profiles...");
			// Default.epx and ProfileBase.epx
			result = importRSAProfiles(context, monitor);
			generationStatus.add(result);
		}

		//
		// FRAGMENTS & SAVE
		//

		if (generationStatus.getSeverity() <= Diagnostic.WARNING) {

			monitor.subTask("Saving models...");
			URI notationModelURI = null;
			URI sashModelURI = null;
			// ResourceSet resourceSet = new ResourceSetImpl();

			targetURI = convertToPapyrus(sourceURI, UMLResource.FILE_EXTENSION);
			notationModelURI = convertToPapyrus(sourceURI, "notation"); // TODO use constant
			sashModelURI = convertToPapyrus(sourceURI, "di"); // TODO use constant

			if ("epx".equals(sourceURI.fileExtension())) {
				profileURIMappings.put(sourceURI, targetURI);
			}
			// Profile mappings are also library mappings
			uriMappings.put(sourceURI, targetURI);

			umlResource = createUMLResource(resourceSet, sourceURI, targetURI);

			List<EObject> outUMLObjects = getInOutUMLModel().getContents();

			umlResource.getContents().addAll(outUMLObjects);

			GMFResource notationResource = new GMFResource(notationModelURI); // GMF Resource content type?
			resourceSet.getResources().add(notationResource);
			List<EObject> outNotationObjects = getInoutNotationModel().getContents();
			notationResource.getContents().addAll(outNotationObjects);

			// Cleanup empty diagrams (FIXME: They should not be generated)
			List<EObject> contentsCopy = new LinkedList<EObject>(notationResource.getContents());
			for (EObject next : contentsCopy) {
				if (next instanceof Diagram) {
					Diagram diagram = (Diagram) next;
					if (diagram.getType() == null || "".equals(diagram.getType())) {
						delete(diagram);
					}
				}
			}

			XMIResource sashResource = new XMIResourceImpl(sashModelURI);
			resourceSet.getResources().add(sashResource);
			List<EObject> sashModelObjects = getOutSashModel().getContents();
			sashResource.getContents().addAll(sashModelObjects);

			configureResource(sashResource);
			configureResource(notationResource);
			configureResource((XMIResource) umlResource);

			// Handle orphaned elements: remove them and log a warning (Log temporarily disabled to avoid spamming the console)
			List<EObject> notationRootElements = new LinkedList<EObject>(notationResource.getContents());
			for (EObject rootElement : notationRootElements) {
				if (rootElement instanceof View) {
					View rootView = (View) rootElement;
					if (!(rootView instanceof Diagram)) {
						String objectType = rootView.getElement() == null ? "None" : rootView.getElement().eClass().getName();
						String viewType = rootView.getType() == null ? "None" : rootView.getType();
						// generationStatus.add(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "An orphaned view has been found after the migration. It will be removed. View Type: " + viewType + ", semantic type: " + objectType));

						delete(rootElement);
					}
				} else if (rootElement instanceof Style) {
					String styleType = rootElement.eClass().getName();
					// generationStatus.add(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "An orphaned style has been found after the migration. It will be removed. Style Type: " + styleType));

					delete(rootElement);
				}
			}

			Collection<Resource> resourcesToSave = handleFragments(umlResource, notationResource, sashResource);

			for (Resource resource : resourcesToSave) {
				List<EObject> rootElements = new LinkedList<EObject>(resource.getContents());
				for (EObject rootElement : rootElements) {
					EPackage ePackage = rootElement.eClass().getEPackage();
					if (ePackage == ProfileBasePackage.eINSTANCE || ePackage == DefaultPackage.eINSTANCE) {
						delete(rootElement);
					}
				}
			}

			handleDanglingURIs(resourcesToSave);

			for (Resource resource : resourcesToSave) {
				try {
					resource.save(null);
				} catch (Exception ex) {
					Activator.log.error(ex);
				}
			}

			for (Diagram diagram : diagramsToDelete) {
				EObject container = diagram.eContainer();
				delete(diagram);
				if (container instanceof EAnnotation) {
					delete(container);
				}
			}

			diagramsToDelete.clear();

			// unloadResourceSet(resourceSet);
		}

		unloadResourceSet(this.resourceSet);

		this.resourceSet = null;
		this.umlResource = null;
		this.outNotation = this.inParameters = this.outSashModel = this.outUML = null;

		monitor.done();
		return generationStatus;
	}

	protected void handleDanglingURIs(Collection<Resource> resourcesToSave) {
		ConfigHelper helper = new ConfigHelper(parameters);
		helper.computeURIMappings(resourcesToSave);
	}

	protected void unloadResourceSet(ResourceSet resourceSet) {
		EMFHelper.unload(resourceSet);
	}

	protected IStatus importRSAProfiles(ExecutionContext context, IProgressMonitor monitor) {
		URI transformationURI = getProfilesTransformationURI();

		List<ModelExtent> extents = new LinkedList<ModelExtent>();
		extents.add(getInOutUMLModel());
		extents.add(getInoutNotationModel());
		Diagnostic loadedProfiles = loadInPapyrusProfiles();
		extents.add(getInPapyrusProfiles());
		extents.add(getInProfileDefinitions());
		extents.add(getInConfig());

		TransformationExecutor executor;
		try {
			executor = getTransformation(transformationURI, monitor);
		} catch (DiagnosticException ex) {
			Diagnostic diagnostic = ex.getDiagnostic();

			Activator.log.warn(String.format("Cannot load the transformation : %s. Diagnostic: %s", transformationURI, diagnostic.getMessage()));
			return createStatusFromDiagnostic(diagnostic);
		}

		ExecutionDiagnostic transformationResult;
		synchronized (executor) {
			transformationResult = executor.execute(context, extents.toArray(new ModelExtent[0]));
			executor.cleanup();
		}

		IStatus loadedProfilesStatus = createStatusFromDiagnostic(loadedProfiles);
		IStatus transformationStatus = createStatusFromDiagnostic(transformationResult);

		int severity = Math.max(loadedProfiles.getSeverity(), transformationResult.getSeverity());

		String message;
		if (severity > IStatus.OK) {
			message = "The following errors occurred:";
		} else {
			message = "OK";
		}

		IStatus completeResult = new MultiStatus(Activator.PLUGIN_ID, severity, new IStatus[] { loadedProfilesStatus, transformationStatus }, message, null);

		return completeResult;
	}

	protected TransformationExecutor getTransformation(URI transformationURI, IProgressMonitor monitor) throws DiagnosticException {

		if (!cacheTransformations) {
			if (!localTransformations.containsKey(transformationURI)) {
				TransformationExecutor executor = loadTransformationExecutor(transformationURI, monitor);
				localTransformations.put(transformationURI, executor);
			}
			return localTransformations.get(transformationURI);
		}

		synchronized (sharedTransformations) {
			if (!sharedTransformations.containsKey(transformationURI)) {
				TransformationExecutor executor = loadTransformationExecutor(transformationURI, monitor);
				sharedTransformations.put(transformationURI, executor);
			}
			return sharedTransformations.get(transformationURI);
		}
	}

	// Static synchronized, as it seems that QVTo can't load 2 transformations at the same time, even in separate execution contexts
	protected static synchronized TransformationExecutor loadTransformationExecutor(URI transformationURI, IProgressMonitor monitor) throws DiagnosticException {
		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		Diagnostic diagnostic = executor.loadTransformation(monitor);

		if (diagnostic.getSeverity() != Diagnostic.OK) {
			throw new DiagnosticException(diagnostic);
		}

		return executor;
	}

	protected Properties readProfileBaseProperties() {
		URI propertiesURI = sourceURI.trimFileExtension().appendFileExtension("properties");

		Properties properties = new Properties();
		InputStream inputStream = null;

		try {
			URL url = new URL(propertiesURI.toString());
			inputStream = url.openStream();
			properties.load(inputStream);
		} catch (FileNotFoundException ex) {
			// Ignore: the file doesn't exist
		} catch (IOException ex) {
			Activator.log.error(ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					Activator.log.error(ex);
				}
			}
		}

		return properties;
	}

	protected IStatus importRTProfile(ExecutionContext context, IProgressMonitor monitor) {
		monitor.subTask("Importing RT Profile... ");

		URI transformationURI = getRTTransformationURI();

		List<ModelExtent> extents = new LinkedList<ModelExtent>();
		extents.add(getInOutUMLModel());
		extents.add(getInoutNotationModel());
		extents.add(getInPapyrusProfiles());
		extents.add(getInProfileDefinitions());
		extents.add(getInConfig());

		TransformationExecutor executor;
		try {
			executor = getTransformation(transformationURI, monitor);
		} catch (DiagnosticException ex) {
			Diagnostic diagnostic = ex.getDiagnostic();
			Activator.log.warn(String.format("Cannot load the transformation : %s. Diagnostic: %s", transformationURI, diagnostic.getMessage()));
			return createStatusFromDiagnostic(diagnostic);
		}

		ExecutionDiagnostic result;
		synchronized (executor) {
			result = executor.execute(context, extents.toArray(new ModelExtent[0]));
			executor.cleanup();
		}

		return createStatusFromDiagnostic(result);
	}

	protected ModelExtent getInProfileDefinitions() {
		return new BasicModelExtent(Arrays.asList(new EPackage[] {
				PapyrusDSMLValidationRulePackage.eINSTANCE,
				DocumentationPackage.eINSTANCE,
				org.eclipse.papyrus.umlrt.UMLRealTime.UMLRealTimePackage.eINSTANCE,
				UMLRealTimeStateMachPackage.eINSTANCE
		}));
	}

	protected ModelExtent getInPapyrusProfiles() {
		if (inPapyrusProfiles == null) {
			loadInPapyrusProfiles();
		}

		return inPapyrusProfiles;
	}

	/**
	 * Returns a Diagnostic. Diagnostic#data is the ModelExtent containing the loaded profiles
	 *
	 * @return
	 * @throws WrappedException
	 */
	protected Diagnostic loadInPapyrusProfiles() {
		if (inPapyrusProfiles != null) {
			return Diagnostic.OK_INSTANCE;
		}

		List<String> missingProfiles = new LinkedList<String>();

		List<EObject> allContents = new LinkedList<EObject>();
		try {
			URI validationProfileURI = URI.createURI("pathmap://DSMLValidation_PROFILES/PapyrusValidationRuleDSML.uml");
			Resource validationProfile = resourceSet.getResource(validationProfileURI, true);
			checkResource(validationProfile);
			allContents.addAll(validationProfile.getContents());
		} catch (WrappedException ex) {
			missingProfiles.add("Validation Rules Profile");
		}

		try {
			URI documentationProfileURI = URI.createURI("pathmap://PAPYRUS_DOCUMENTATION/Papyrus.profile.uml");
			Resource documentationProfile = resourceSet.getResource(documentationProfileURI, true);
			checkResource(documentationProfile);
			allContents.addAll(documentationProfile.getContents());
		} catch (WrappedException ex) {
			missingProfiles.add("Documentation Profile");
		}

		try {
			URI umlrtProfileURI = URI.createURI("pathmap://UML_RT_PROFILE/uml-rt.profile.uml");
			Resource umlrtProfile = resourceSet.getResource(umlrtProfileURI, true);
			checkResource(umlrtProfile);
			allContents.addAll(umlrtProfile.getContents());
		} catch (WrappedException ex) {
			missingProfiles.add("UML RT Profile");
		}

		try {
			URI umlrtSMProfileURI = URI.createURI("pathmap://UML_RT_PROFILE/UMLRealTimeSM-addendum.profile.uml");
			Resource umlrtSMProfile = resourceSet.getResource(umlrtSMProfileURI, true);
			checkResource(umlrtSMProfile);
			allContents.addAll(umlrtSMProfile.getContents());
		} catch (WrappedException ex) {
			missingProfiles.add("UML RT / StateMachine extension Profile");
		}

		EcoreUtil.resolveAll(resourceSet);

		inPapyrusProfiles = new BasicModelExtent(allContents);

		String message;
		int code;
		if (missingProfiles.isEmpty()) {
			message = "OK";
			code = Diagnostic.OK;
		} else {
			message = "The following Papyrus profiles cannot be found: " + ListHelper.deepToString(missingProfiles, ", ");
			code = Diagnostic.ERROR;
		}

		Diagnostic diagnostic = new BasicDiagnostic(code, Activator.PLUGIN_ID, code, message, null);

		return diagnostic;
	}

	protected void checkResource(Resource resource) {
		Assert.isTrue(!resource.getContents().isEmpty(), "The resource " + resource.getURI() + " is empty");
		for (EObject rootElement : resource.getContents()) {
			Assert.isTrue(!rootElement.eIsProxy());
		}
	}

	protected Resource createUMLResource(ResourceSet resourceSet, URI sourceResourceURI, URI targetResourceURI) {
		// Use the same resource to ensure that XMI IDs are maintained
		Resource resource = resourceSet.getResource(sourceResourceURI, false);
		resource.setURI(targetResourceURI);
		return resource;
	}

	protected ModelExtent getInConfig() {
		if (inParameters == null) {
			inParameters = new BasicModelExtent(Collections.singletonList(parameters));
		}
		return inParameters;
	}

	protected Collection<Resource> handleFragments(Resource umlResource, Resource notationResource, Resource sashResource) {
		Collection<Resource> result = new HashSet<Resource>();
		result.add(umlResource);
		result.add(notationResource);
		result.add(sashResource);

		ResourceSet resourceSet = umlResource.getResourceSet();

		Iterator<EObject> elementIterator = umlResource.getAllContents();

		Set<Resource> fragmentResources = new HashSet<Resource>();

		while (elementIterator.hasNext()) {
			EObject element = elementIterator.next();
			if (element.eResource() != umlResource && element.eResource().getContents().contains(element)) { // Controlled/Fragment root
				fragmentResources.add(element.eResource());
			}
		}

		for (Resource fragmentResource : fragmentResources) {
			URI papyrusFragmentURI = convertToPapyrus(fragmentResource.getURI(), UMLResource.FILE_EXTENSION);

			uriMappings.put(fragmentResource.getURI(), papyrusFragmentURI);

			Resource newResource = resourceSet.getResource(papyrusFragmentURI, false);
			if (newResource == null) {
				newResource = createUMLResource(resourceSet, fragmentResource.getURI(), papyrusFragmentURI);

				Resource fragmentNotationResource = new GMFResource(convertToPapyrus(papyrusFragmentURI, "notation"));
				Resource fragmentDiResource = new XMIResourceImpl(convertToPapyrus(papyrusFragmentURI, "di"));

				result.add(fragmentNotationResource);
				result.add(fragmentDiResource);

				resourceSet.getResources().add(fragmentNotationResource);
				resourceSet.getResources().add(fragmentDiResource);
			}

			newResource.getContents().addAll(fragmentResource.getContents());
			result.add(newResource);
		}

		deleteSourceRTStereotypes(fragmentResources);

		List<EObject> importedElements = new LinkedList<EObject>(notationResource.getContents());
		for (EObject notationElement : importedElements) {
			if (notationElement instanceof Diagram) {
				EObject semanticElement = ((Diagram) notationElement).getElement();
				if (semanticElement.eResource() != umlResource && semanticElement.eResource() != null) {

					URI notationFragmentURI = convertToPapyrus(semanticElement.eResource().getURI(), "notation");

					Resource newNotationResource = resourceSet.getResource(notationFragmentURI, false);
					if (newNotationResource == null) {
						newNotationResource = new GMFResource(notationFragmentURI);
						resourceSet.getResources().add(newNotationResource);
					}
					newNotationResource.getContents().add(notationElement);
					result.add(newNotationResource);
				}
			}
		}

		return result;
	}

	protected void deleteSourceRTStereotypes(Collection<Resource> fragmentResources) {
		Set<Resource> allResources = new HashSet<Resource>(fragmentResources);
		allResources.add(umlResource);

		for (Resource resource : allResources) {

			// For performance reasons, RSA RT Stereotypes have not been deleted during the QVTo transformation (Bug 444379)
			// Delete them as a post-action. Iterate on all controlled models and delete the RealTime stereotypes at the root of each resource
			List<EObject> resourceContents = new LinkedList<EObject>(resource.getContents());
			for (EObject rootElement : resourceContents) {
				if (rootElement.eClass().getEPackage() == org.eclipse.papyrus.migration.rsa.umlrt.UMLRealTimePackage.eINSTANCE) {
					delete(rootElement);
				}
			}
		}
	}

	protected URI convertToPapyrus(URI rsaURI, String extension) {
		if ("epx".equals(rsaURI.fileExtension())) { //$NON-NLS-1$
			// Profiles: myProfile.profile.uml, myProfile.profile.notation, ...
			return rsaURI.trimFileExtension().appendFileExtension("profile").appendFileExtension(extension); //$NON-NLS-1$
		} else {
			// Models and Fragments: myModel.uml, myFragment.uml, ...
			return rsaURI.trimFileExtension().appendFileExtension(extension);
		}
	}

	protected IStatus runTransformation(URI transformationURI, ExecutionContext context, IProgressMonitor monitor, List<ModelExtent> extents) {
		if (monitor.isCanceled()) {
			return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, "Operation canceled");
		}

		TransformationExecutor executor;
		try {
			executor = getTransformation(transformationURI, monitor);
		} catch (DiagnosticException ex) {
			Diagnostic diagnostic = ex.getDiagnostic();

			Activator.log.warn(String.format("Cannot load the transformation : %s. Diagnostic: %s", transformationURI, diagnostic.getMessage()));
			return createStatusFromDiagnostic(diagnostic);
		}

		ExecutionDiagnostic result;
		synchronized (executor) {
			result = executor.execute(context, extents.toArray(new ModelExtent[0]));
			executor.cleanup();
		}

		return createStatusFromDiagnostic(result);
	}

	protected ExecutionContext createExecutionContext(final IProgressMonitor monitor, final MultiStatus generationStatus) {
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$o
		context.setConfigProperty(TransformationUI.MONITOR, monitor);

		// context.setProgressMonitor(monitor);

		context.setLog(new WriterLog(new OutputStreamWriter(System.out)) {

			@Override
			public void log(String message) {
				super.log(message);
			}

			@Override
			public void log(String message, Object param) {
				super.log(message, param);
			}

			@Override
			public void log(int level, String message) {
				super.log(level, message);
				if (level >= 1) {
					generationStatus.merge(new Status(level, Activator.PLUGIN_ID, message));
				}

			}

			@Override
			public void log(int level, String message, Object param) {
				super.log(level, message, param);
				if (level >= 1) {
					generationStatus.merge(new Status(level, Activator.PLUGIN_ID, message + ", data:" + param));
				}
			}
		});

		initTransformationProperties(context);

		return context;
	}

	/**
	 * Initializes the ExecutionContext with configuration properties required by transformations
	 *
	 * This is a lightweight mechanism to avoid initializing ModelExtents for a single EObject reference, or for non-EMF values
	 *
	 * Typically used by blackbox methods
	 *
	 * @param context
	 */
	protected void initTransformationProperties(ExecutionContextImpl context) {
		// Load the *.properties file associated to ProfileBase
		context.setConfigProperty(ProfileBaseHelper.PROFILE_BASE_PROPERTIES, readProfileBaseProperties());

		// Load the InnerClassDiagramView (From viewpoints)
		URI innerClassDiagramViewURI = URI.createPlatformPluginURI("org.eclipse.papyrus.infra.viewpoints.policy/builtin/default.configuration", false);
		innerClassDiagramViewURI = innerClassDiagramViewURI.appendFragment("//@viewpoints.0/@modelKinds.0");

		context.setConfigProperty("InnerClassDiagramView", resourceSet.getEObject(innerClassDiagramViewURI, true));
	}

	protected void configureResource(XMIResource resource) {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>();

		// default save options.
		saveOptions.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		saveOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");

		// see bug 397987: [Core][Save] The referenced plugin models are saved using relative path
		saveOptions.put(XMLResource.OPTION_URI_HANDLER, new org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl.PlatformSchemeAware());

		resource.setEncoding("UTF-8");
		resource.getDefaultSaveOptions().putAll(saveOptions);
	}

	protected List<ModelExtent> getModelExtents() {
		List<ModelExtent> allExtents = new LinkedList<ModelExtent>();
		allExtents.add(getInOutUMLModel());
		allExtents.add(getInoutNotationModel());
		allExtents.add(getOutSashModel());
		allExtents.add(getInConfig());
		return allExtents;
	}

	protected ModelExtent getInOutUMLModel() {
		if (outUML == null) {
			try {
				Resource resource = resourceSet.getResource(sourceURI, true);
				outUML = new BasicModelExtent(resource.getContents());

			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}

		return outUML;
	}

	/* Notation model is initially empty, but will be filled successively by each transformation */
	protected ModelExtent getInoutNotationModel() {
		if (outNotation == null) {
			outNotation = new BasicModelExtent();
		}

		return outNotation;
	}

	protected ModelExtent getOutSashModel() {
		if (outSashModel == null) {
			outSashModel = new BasicModelExtent();
		}

		return outSashModel;
	}

	static {
		supportedDiagramIds.addAll(Arrays.asList(new String[] {
				"Class", // Includes Profiles
				"Object",
				"Activity",
				// "Component", //Not yet
				// "Sequence", // Not yet
				"Statechart",
				"Structure"
		}));
	}

	protected Collection<URI> getDiagramTransformationURIs() {
		return ListHelper.asList(new URI[] {
				getTransformationURI("RSAClassDiagram"),
				// getTransformationURI("RSASequenceDiagram"), //Disabled since Sequence Diagrams are not properly supported
				getTransformationURI("RSAStructureDiagram"),
				getTransformationURI("RSAActivityDiagram"),
				getTransformationURI("RSAStateMachineDiagram"),
				getTransformationURI("RSAProfileDiagram")
		});
	}

	protected URI getSemanticTransformationURI() {
		return getTransformationURI("RSAModelToPapyrus");
	}

	protected URI getRTTransformationURI() {
		return getTransformationURI("RSARTToPapyrusRT");
	}

	protected URI getProfilesTransformationURI() {
		return getTransformationURI("RSAProfilesToPapyrus");
	}

	protected Collection<URI> getAllTransformationURIs() {
		Collection<URI> allTransformations = getDiagramTransformationURIs();
		allTransformations.add(getRTTransformationURI());
		allTransformations.add(getProfilesTransformationURI());
		allTransformations.add(getSemanticTransformationURI());
		return allTransformations;
	}

	protected URI getTransformationURI(String transformationName) {
		return URI.createPlatformPluginURI(String.format("%s/transform/%s.qvto", Activator.PLUGIN_ID, transformationName), true); //$NON-NLS-1$
	}

	public String getModelName() {
		return URI.decode(sourceURI.lastSegment());
	}

	public void cancel() {
		job.cancel();
	}

	public void delete(EObject rootElement) {
		CacheAdapter adapter = CacheAdapter.getCacheAdapter(rootElement);
		if (adapter == null) {
			adapter = CacheAdapter.getInstance();
		}
		adapter.unsetTarget(rootElement);
		if (rootElement.eResource() != null) {
			rootElement.eResource().getContents().remove(rootElement);
		}
	}
}
