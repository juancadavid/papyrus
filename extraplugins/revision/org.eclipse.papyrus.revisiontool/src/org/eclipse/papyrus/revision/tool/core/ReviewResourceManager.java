/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.revision.tool.core;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.revision.tool.Activator;
import org.eclipse.papyrus.revision.tool.preference.PreferenceConstants;
import org.eclipse.papyrus.revision.tool.ui.CreateAuthorDialog;
import org.eclipse.papyrus.revision.tool.ui.CreateOrSelectReviewModelDialog;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * this class is used to manage the resource about Review
 *
 */
public class ReviewResourceManager {

	protected Model UMLModel;
	protected ModelSet modelSet;
	protected Model reviewModel;
	protected Actor currentAuthor;


	/**
	 * used to get the the current workbenchPart
	 * @return
	 */
	protected IWorkbenchPart getBootstrapPart() {


		IWorkbenchPart part = null;
		try {
			IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if (activeWorkbenchWindow != null) {
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				if (activePage != null) {
					part = activePage.getActiveEditor();
				}
			}
		} catch (NullPointerException e) {
			// An element is not active yet
			return null;
		}
		if (isImportant(part)) {
			return part;
		}
		// The current active part is not for us.
		return null;
	}

	/**
	 * 
	 * @return the current Review model, maybe null
	 */
	public Model getCurrentReviewModel(){
		if( reviewModel==null){
			System.out.println("ReviewModel is null!, we must to create or load it.");
			CreateOrSelectReviewModelDialog dialog=new CreateOrSelectReviewModelDialog(new Shell(), this);
			dialog.open();

		}

		return reviewModel;
	}
	/**
	 * 
	 * @return the editing domain of papyrus
	 */
	public TransactionalEditingDomain getDomain(){
		return getCurrentModelSet().getTransactionalEditingDomain();
	}

	/**
	 *  used to add a review in the review model
	 */
	public void addAReview(){
		getCurrentReviewModel();
		final Actor theauthor=getCurrentAuthor();

		RecordingCommand cmd= new RecordingCommand(getDomain(), "createAReview") {
			@Override
			protected void doExecute() {
				Comment cmt= UMLFactory.eINSTANCE.createComment();
				cmt.setBody("Your review");
				reviewModel.getOwnedComments().add(cmt);
				Stereotype review= cmt.getApplicableStereotype(I_ReviewStereotype.REVIEW_STEREOTYPE);
				cmt.applyStereotype(review);
				cmt.setValue(review, I_ReviewStereotype.COMMENT_SUBJECT_ATT, "subject");
				Stereotype authorStereotype= theauthor.getApplicableStereotype(I_VersioningStereotype.AUTHOR_STEREOTYPE);
				cmt.setValue(review, I_VersioningStereotype.VERSIONINGELEMENT_AUTHOR_ATT, theauthor.getStereotypeApplication(authorStereotype));
			}
		};
		getDomain().getCommandStack().execute(cmd);

	}

	/**
	 * 
	 * @return the author construct from preferences
	 */
	public Actor getCurrentAuthor(){
		if(currentAuthor==null||currentAuthor.eContainer()==null){
			//1. test if the author of preferences is not anonymous
			final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			final String  authorNamefromPreference=store.getString(PreferenceConstants.AUTHOR_NAME);
			if( authorNamefromPreference.equals(PreferenceConstants.ANONYMOUS_AUTHOR)){
				CreateAuthorDialog authorDialog= new CreateAuthorDialog(new Shell());
				authorDialog.open();
			}
			final String  authorName=store.getString(PreferenceConstants.AUTHOR_NAME);
			final Model reviewModel=getCurrentReviewModel();
			NamedElement author=reviewModel.getPackagedElement(authorName);
			if( author==null||!(author instanceof Actor)){
				RecordingCommand cmd= new RecordingCommand(getDomain(), "createReviewModel") {
					@Override
					protected void doExecute() {
						currentAuthor=UMLFactory.eINSTANCE.createActor();
						currentAuthor.setName(authorName);
						reviewModel.getPackagedElements().add(currentAuthor);
						Stereotype authorStereotype= currentAuthor.getApplicableStereotype(I_VersioningStereotype.AUTHOR_STEREOTYPE);
						currentAuthor.applyStereotype(authorStereotype);
						currentAuthor.setValue(authorStereotype, I_VersioningStereotype.AUTHOR_LANGUAGE_ATT, store.getString(PreferenceConstants.AUTHOR_LANGUAGE));
						RGB authorColor=PreferenceConverter.getColor(store, PreferenceConstants.AUTHOR_COLOR);
						String colorString=authorColor.red+":"+authorColor.green+":"+authorColor.blue;
						currentAuthor.setValue(authorStereotype, I_VersioningStereotype.AUTHOR_COLOR_ATT, colorString);
					}
				};
				getDomain().getCommandStack().execute(cmd);
			}
			else{
				currentAuthor=(Actor)author;
			}
		}
		return currentAuthor;
	}
	/**
	 * used to load a review model
	 * @return the obtained review model
	 */
	public Model loadReviewModel(){
		ElementTreeSelectionDialog dialog= new ElementTreeSelectionDialog(Display.getDefault().getActiveShell(), new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
		dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());

		PatternFilter UMLPattern= new PatternFilter(){
			@Override
			public boolean isElementVisible(Viewer viewer, Object element) {
				if(viewer!=null){
					return super.isElementVisible(viewer, element);
				}
				return true;
			}};
			UMLPattern.setPattern("*.uml");
			dialog.setAllowMultiple(false);
			dialog.addFilter( UMLPattern);
			dialog.open();
			if(dialog.getResult().length>0){
				Object object=dialog.getResult()[0];
				System.err.println(object);
				if(object instanceof IFile){
					IFile aReviewModel=((IFile)object);
					Resource tmpResource =  getCurrentModelSet().getResource(URI.createPlatformResourceURI(aReviewModel.getFullPath().toOSString(), true),true);
					for (EObject contentEObject : tmpResource.getContents()) {
						if( contentEObject instanceof Model){
							reviewModel=(Model)contentEObject;
						}
					}
				}
			}
			return reviewModel;
	}
	/**
	 * create a review model
	 */
	public Model createReviewModel(final String reviewModelName){
		RecordingCommand cmd= new RecordingCommand(getDomain(), "createReviewModel") {
			@Override
			protected void doExecute() {
				URI umlModel_URI=getWorkingModel().eResource().getURI();
				String tmpURI=umlModel_URI.toString().replaceAll(umlModel_URI.lastSegment().toString(), reviewModelName+".uml");
				URI reviewURI=URI.createURI(tmpURI);
				Resource resource = getCurrentModelSet().createResource(reviewURI);
				reviewModel = UMLFactory.eINSTANCE.createModel();
				reviewModel.setName(reviewModelName);
				// apply profile  review
				{
					RegisteredProfile registeredProfile=(RegisteredProfile)RegisteredProfile.getRegisteredProfile("ReviewProfile");
					URI reviewProfileUri = registeredProfile.uri;
					final Resource modelResource = getCurrentModelSet().getResource(reviewProfileUri, true);
					Profile reviewProfile=(Profile) modelResource.getContents().get(0);
					reviewModel.applyProfile(reviewProfile);
					reviewModel.applyStereotype(reviewModel.getApplicableStereotype(I_ReviewStereotype.REVIEWREPOSITORY_STEREOTYPE));
					EObject stereappl=reviewModel.getStereotypeApplication(reviewModel.getApplicableStereotype(I_ReviewStereotype.REVIEWREPOSITORY_STEREOTYPE));
					resource.getContents().add(stereappl);
				}
				//aply profile versioning
				{
					RegisteredProfile registeredProfile=(RegisteredProfile)RegisteredProfile.getRegisteredProfile("VersioningProfile");
					URI reviewProfileUri = registeredProfile.uri;
					final Resource modelResource = getCurrentModelSet().getResource(reviewProfileUri, true);
					Profile reviewProfile=(Profile) modelResource.getContents().get(0);
					reviewModel.applyProfile(reviewProfile);
				}


				createInput();
				resource.getContents().add(reviewModel);

			}
		};
		getDomain().getCommandStack().execute(cmd);

		return reviewModel;
	}

	public void createInput(){
		//	Actor author= UMLFactory.eINSTANCE.createActor();
		//	author.setName("Durand T.");
		//	reviewModel.getPackagedElements().add(author);
		//	Stereotype authorStereotype= author.getApplicableStereotype(I_ReviewStereotype.AUTHOR_STEREOTYPE);
		//	author.applyStereotype(authorStereotype);
		//	author.setValue(authorStereotype, I_ReviewStereotype.AUTHOR_LANGUAGE_ATT, "Eng");
		//	author.setValue(authorStereotype, I_ReviewStereotype.AUTHOR_COLOR_ATT, "128:255:128");
		//
		//	Actor author2= UMLFactory.eINSTANCE.createActor();
		//	author2.setName("Raph R.");
		//	reviewModel.getPackagedElements().add(author2);
		//	Stereotype authorStereotype2= author2.getApplicableStereotype(I_ReviewStereotype.AUTHOR_STEREOTYPE);
		//	author2.applyStereotype(authorStereotype2);
		//	author.setValue(authorStereotype2, I_ReviewStereotype.AUTHOR_LANGUAGE_ATT, "Eng");
		//	author.setValue(authorStereotype2, I_ReviewStereotype.AUTHOR_COLOR_ATT, "128:250:255");
		//
		//
		//	Comment cmt= UMLFactory.eINSTANCE.createComment();
		//	cmt.setBody("I think that this class is not useful");
		//	reviewModel.getOwnedComments().add(cmt);
		//	Stereotype review= cmt.getApplicableStereotype(I_ReviewStereotype.REVIEW_STEREOTYPE);
		//	cmt.applyStereotype(review);
		//	cmt.setValue(review, I_ReviewStereotype.REVIEW_SUBJECT_ATT, "About Class color");
		//	cmt.setValue(review, I_ReviewStereotype.REVIEW_AUTHOR_ATT, author.getStereotypeApplication(authorStereotype));
		//
		//
		//	Comment cmt2= UMLFactory.eINSTANCE.createComment();
		//	cmt2.setBody("This class will be used for next extension.");
		//	cmt.getOwnedComments().add(cmt2);
		//
		//	cmt2.applyStereotype(review);
		//	cmt2.setValue(review, I_ReviewStereotype.REVIEW_SUBJECT_ATT, "About Class color");
		//	cmt2.setValue(review, I_ReviewStereotype.REVIEW_AUTHOR_ATT, author2.getStereotypeApplication(authorStereotype2));
		//
		//	Comment cmt3= UMLFactory.eINSTANCE.createComment();
		//	cmt3.setBody("Other blabla3");
		//	reviewModel.getOwnedComments().add(cmt3);
		//	cmt3.applyStereotype(review);
		//	cmt3.setValue(review, I_ReviewStereotype.REVIEW_SUBJECT_ATT, "Test3");
		//	cmt3.setValue(review, I_ReviewStereotype.REVIEW_AUTHOR_ATT, author.getStereotypeApplication(authorStereotype));
	}
	/**
	 * get the working model
	 * @return the model that is modified inside papyrus
	 */
	protected Model getWorkingModel(){
		if(UMLModel!=null){
			return UMLModel;
		}

		modelSet = getCurrentModelSet();
		UmlModel IUMLModel=(UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		try {
			UMLModel = (Model)IUMLModel.lookupRoot();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return UMLModel;
	}

	/**
	 * 
	 * @return the current model set of papyrus.
	 */
	public ModelSet getCurrentModelSet(){
		if(modelSet!=null){
			return modelSet;
		}
		IWorkbenchPart part=getBootstrapPart();
		if (part instanceof IMultiDiagramEditor){
			ServicesRegistry  registry=((IMultiDiagramEditor)part).getServicesRegistry();
			try {
				modelSet = registry.getService(ModelSet.class);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return modelSet;
	}

	/**
	 * @return current service registry
	 */
	public ServicesRegistry getServiceRegistry(){
		if(modelSet!=null){
			return null;
		}
		IWorkbenchPart part=getBootstrapPart();
		if (part instanceof IMultiDiagramEditor){
			ServicesRegistry  registry=((IMultiDiagramEditor)part).getServicesRegistry();
			return registry;
		}
		return null;
	}
	/**
	 * return true if the activated part is a {@link IMultiDiagramEditor}.
	 *
	 * @see org.eclipse.ui.part.PageBookView#isImportant(org.eclipse.ui.IWorkbenchPart)
	 *
	 * @param part
	 * @return
	 */
	protected boolean isImportant(IWorkbenchPart part) {


		if (part instanceof IMultiDiagramEditor) {
			return true;
		}

		return false;
	}
}
