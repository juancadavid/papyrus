/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tatiana Fesenko(CEA) - [313179] Refactor CreateModelWizard
 *******************************************************************************/
package org.eclipse.papyrus.wizards;

import static org.eclipse.papyrus.wizards.Activator.log;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * Create new model file and initialize a selected diagram. This wizard create
 * several files : *.di : the DI file to store Di diagrams and references all
 * external diagrams like GMF diagrams. *.notation : the file to store pure GMF
 * diagrams *.uml : the standard UML file to store UML semantics elements.
 * (Model, Package, Class,...)
 * 
 * Those files can be used with the PapyrusEditor (see plugin.xml).
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public abstract class CreateModelWizard extends Wizard implements INewWizard {

	/** New model file page for the file */
	private NewModelFilePage newModelFilePage;

	/** Select kind of new diagram the wizard must create */
	private SelectDiagramKindPage selectDiagramKindPage;

	/** Select the root element containing the new diagram */
	private SelectRootElementPage selectRootElementPage;

	// fjcano #293135 :: support model templates
	/** Select a template to initialize the model with */
	private SelectTemplateWizardPage selectTemplateWizardPage;

	/** Current workbench */
	private IWorkbench workbench;

	/**
	 * The URI of the selected domain model. Do not create a new uml model, but
	 * use the selected
	 */
	private URI domainModelURI;

	/**
	 * ResourceSet used to link all Resource (Model and DI)
	 */
	private DiResourceSet diResourceSet;

	public CreateModelWizard() {
		this(null);
	}

	public CreateModelWizard(URI domainModelURI) {
		super();
		setWindowTitle("New Papyrus Model");
		this.domainModelURI = domainModelURI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(newModelFilePage);
		// fjcano #293135 :: support model templates
		addPage(selectTemplateWizardPage);
		addPage(selectDiagramKindPage);
		if(domainModelURI != null) {
			addPage(selectRootElementPage);
		}
	}

	/**
	 * Initializes this creation wizard using the passed workbench and object
	 * selection.
	 * <p>
	 * This method is called after the no argument constructor and before other methods are called.
	 * </p>
	 * 
	 * @param workbench
	 *        the current workbench
	 * @param selection
	 *        the current object selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.diResourceSet = new DiResourceSet();
		IFile file = getSelectedFile(selection);
		// builds a new Papyrus Model for an existing domain model
		if(isSupportedDomainModelFile(file)) {
			this.domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			this.newModelFilePage = new NewModelFilePage("Create a new Papyrus model", "Create a new Papyrus model from an existing semantic model", selection, true);
			this.newModelFilePage.setFileName(getDiagramFileName(file));

			// I don't understand a need to load the model during initialization, 
			// I rather expect it to be loaded when wizard is finished and executed or
			// when the page that needs the model is initialized 
			Resource resource = diResourceSet.loadModelResource(file);

			EObject diagramRoot = resource.getContents().get(0);
			this.selectRootElementPage = new SelectRootElementPage("Select the root element", diagramRoot);
		}
		if(domainModelURI == null) {
			this.newModelFilePage = new NewModelFilePage("Create a new Papyrus model", "Create a new empty Papyrus model", selection, false);
		}
		selectDiagramKindPage = new SelectDiagramKindPage("Select kind of diagram");
		// fjcano #293135 :: support model templates
		selectTemplateWizardPage = getSelectTemplateWizardPage();
	}
	
	protected SelectTemplateWizardPage getSelectTemplateWizardPage() {
		return new SelectTemplateWizardPage(Activator.PLUGIN_ID, null, null); 
	}

	/**
	 * This method will be invoked, when the "Finish" button is pressed.
	 * 
	 * @return <code>true</code> if everything runs without problems, <code>false</code> if an exception must be caught.
	 * 
	 */
	@Override
	public boolean performFinish() {
		// create a new file, result != null if successful
		final IFile newFile = newModelFilePage.createNewFile();
		selectTemplateWizardPage.initializeModelResource(diResourceSet, newFile, getModelContentType(), getModelFileExtension());
		if(newFile == null) {
			return false;
		}

		EObject root = domainModelURI != null ? selectRootElementPage.getModelElement() : null;
		selectDiagramKindPage.createDiagram(diResourceSet, root);

		IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
		if(page != null) {
			try {
				IDE.openEditor(page, newFile, true);
			} catch (PartInitException e) {
				log.error(e);
				return false;
			}
		}

		return true;
	}

	/**
	 * Suggests a name of diagram file for the domain model file
	 */
	protected String getDiagramFileName(IFile domainModel) {
		String diModelFileName = (domainModel.getLocation().removeFileExtension().lastSegment());
		diModelFileName += ".di";
		return diModelFileName;
	}

	/**
	 * Returns true is the file can be served as a model model for the diagram
	 */
	protected boolean isSupportedDomainModelFile(IFile file) {
		return file != null && getModelFileExtension().equals(file.getFileExtension());
	}

	/**
	 * Returns the first file from the given selection
	 */
	private IFile getSelectedFile(IStructuredSelection selection) {
		if(selection != null && !selection.isEmpty() && selection.getFirstElement() instanceof IFile) {
			return (IFile)selection.getFirstElement();
		}
		return null;
	}

	/**
	 * Gets the model content type.
	 * 
	 * @return the model content type
	 */
	protected abstract String getModelContentType();

	/**
	 * Gets the model file extension.
	 * 
	 * @return the model file extension
	 */
	protected abstract String getModelFileExtension();

}
