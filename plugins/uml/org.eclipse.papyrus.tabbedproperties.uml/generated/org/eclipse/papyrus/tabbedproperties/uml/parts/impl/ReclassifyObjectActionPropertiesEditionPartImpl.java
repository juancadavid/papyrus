/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ReclassifyObjectActionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ReclassifyObjectActionPropertiesEditionPart {

	protected EMFListEditUtil ownedCommentEditUtil;
	protected ReferencesTable<? extends EObject> ownedComment;
	protected List<ViewerFilter> ownedCommentBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> ownedCommentFilters = new ArrayList<ViewerFilter>();
	protected Text name;
	protected EMFComboViewer visibility;
	protected EMFListEditUtil clientDependencyEditUtil;
	protected ReferencesTable<? extends EObject> clientDependency;
	protected List<ViewerFilter> clientDependencyBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> clientDependencyFilters = new ArrayList<ViewerFilter>();
	protected Button isLeaf;
	protected EMFListEditUtil outgoingEditUtil;
	protected ReferencesTable<? extends EObject> outgoing;
	protected List<ViewerFilter> outgoingBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> outgoingFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil incomingEditUtil;
	protected ReferencesTable<? extends EObject> incoming;
	protected List<ViewerFilter> incomingBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> incomingFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil inPartitionEditUtil;
	protected ReferencesTable<? extends EObject> inPartition;
	protected List<ViewerFilter> inPartitionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> inPartitionFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil inInterruptibleRegionEditUtil;
	protected ReferencesTable<? extends EObject> inInterruptibleRegion;
	protected List<ViewerFilter> inInterruptibleRegionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> inInterruptibleRegionFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil redefinedNodeEditUtil;
	protected ReferencesTable<? extends EObject> redefinedNode;
	protected List<ViewerFilter> redefinedNodeBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> redefinedNodeFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil handlerEditUtil;
	protected ReferencesTable<? extends EObject> handler;
	protected List<ViewerFilter> handlerBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> handlerFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil localPreconditionEditUtil;
	protected ReferencesTable<? extends EObject> localPrecondition;
	protected List<ViewerFilter> localPreconditionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> localPreconditionFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil localPostconditionEditUtil;
	protected ReferencesTable<? extends EObject> localPostcondition;
	protected List<ViewerFilter> localPostconditionBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> localPostconditionFilters = new ArrayList<ViewerFilter>();
	protected Button isReplaceAll;
	protected EMFListEditUtil oldClassifierEditUtil;
	protected ReferencesTable<? extends EObject> oldClassifier;
	protected List<ViewerFilter> oldClassifierBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> oldClassifierFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil newClassifierEditUtil;
	protected ReferencesTable<? extends EObject> newClassifier;
	protected List<ViewerFilter> newClassifierBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> newClassifierFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ReclassifyObjectActionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createPropertiesGroup(view);

		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentAdvancedTableComposition(propertiesGroup);
		createNameText(propertiesGroup);
		createVisibilityEMFComboViewer(propertiesGroup);
		createClientDependencyAdvancedReferencesTable(propertiesGroup);
		createIsLeafCheckbox(propertiesGroup);
		createOutgoingAdvancedReferencesTable(propertiesGroup);
		createIncomingAdvancedReferencesTable(propertiesGroup);
		createInPartitionAdvancedReferencesTable(propertiesGroup);
		createInInterruptibleRegionAdvancedReferencesTable(propertiesGroup);
		createRedefinedNodeAdvancedReferencesTable(propertiesGroup);
		createHandlerAdvancedTableComposition(propertiesGroup);
		createLocalPreconditionAdvancedTableComposition(propertiesGroup);
		createLocalPostconditionAdvancedTableComposition(propertiesGroup);
		createIsReplaceAllCheckbox(propertiesGroup);
		createOldClassifierAdvancedReferencesTable(propertiesGroup);
		createNewClassifierAdvancedReferencesTable(propertiesGroup);
	}
	/**
	 * @param container
	 */
	protected void createOwnedCommentAdvancedTableComposition(Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {			
			public void handleAdd() { addToOwnedComment();}
			public void handleEdit(Comment element) { editOwnedComment(element); }
			public void handleMove(Comment element, int oldIndex, int newIndex) { moveOwnedComment(element, oldIndex, newIndex); }
			public void handleRemove(Comment element) { removeFromOwnedComment(element); }
			public void navigateTo(Comment element) { }
		});
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.ownedComment, UMLViewsRepository.SWT_KIND));
		this.ownedComment.createControls(parent);
		GridData ownedCommentData = new GridData(GridData.FILL_HORIZONTAL);
		ownedCommentData.horizontalSpan = 3;
		this.ownedComment.setLayoutData(ownedCommentData);
	}

	/**
	 * 
	 */
	protected void moveOwnedComment(Comment element, int oldIndex, int newIndex) {
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.moveElement(element, oldIndex, newIndex);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToOwnedComment() {

		// Start of user code addToOwnedComment() method body
		Comment eObject = UMLFactory.eINSTANCE.createComment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
							eObject, resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.addElement(propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.ownedComment, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedComment(Comment element) {

		// Start of user code removeFromOwnedComment() method body
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.removeElement(element);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.ownedComment, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedComment(Comment element) {

		// Start of user code editOwnedComment() method body
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.ownedComment, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ReclassifyObjectActionPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.ReclassifyObjectAction.name, UMLViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.name, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createVisibilityEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, UMLMessages.ReclassifyObjectActionPropertiesEditionPart_VisibilityLabel, propertiesEditionComponent.isRequired(UMLViewsRepository.ReclassifyObjectAction.visibility, UMLViewsRepository.SWT_KIND));
		visibility = new EMFComboViewer(parent);
		visibility.setContentProvider(new ArrayContentProvider());
		visibility.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData visibilityData = new GridData(GridData.FILL_HORIZONTAL);
		visibility.getCombo().setLayoutData(visibilityData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.visibility, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createClientDependencyAdvancedReferencesTable(Composite parent) {
		this.clientDependency = new ReferencesTable<Dependency>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_ClientDependencyLabel, new ReferencesTableListener<Dependency>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Dependency> dialog = new TabElementTreeSelectionDialog<Dependency>(resourceSet, clientDependencyFilters, clientDependencyBusinessFilters,
				"Dependency", UMLPackage.eINSTANCE.getDependency(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!clientDependencyEditUtil.getVirtualList().contains(elem))
								clientDependencyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.clientDependency,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						clientDependency.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(Dependency element) { editClientDependency(element); }
			public void handleMove(Dependency element, int oldIndex, int newIndex) { moveClientDependency(element, oldIndex, newIndex); }
			public void handleRemove(Dependency element) { removeFromClientDependency(element); }
			public void navigateTo(Dependency element) { }
		});
		this.clientDependency.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.clientDependency, UMLViewsRepository.SWT_KIND));
		this.clientDependency.createControls(parent);
		GridData clientDependencyData = new GridData(GridData.FILL_HORIZONTAL);
		clientDependencyData.horizontalSpan = 3;
		this.clientDependency.setLayoutData(clientDependencyData);
		this.clientDependency.disableMove();
	}

	/**
	 * 
	 */
	protected void moveClientDependency(Dependency element, int oldIndex, int newIndex) {
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.moveElement(element, oldIndex, newIndex);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.clientDependency, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromClientDependency(Dependency element) {

		// Start of user code removeFromClientDependency() method body
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		clientDependencyEditUtil.removeElement(element);
		clientDependency.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.clientDependency, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editClientDependency(Dependency element) {

		// Start of user code editClientDependency() method body
		EObject editedElement = clientDependencyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				clientDependencyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				clientDependency.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.clientDependency, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createIsLeafCheckbox(Composite parent) {
		isLeaf = new Button(parent, SWT.CHECK);
		isLeaf.setText(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_IsLeafLabel);
		GridData isLeafData = new GridData(GridData.FILL_HORIZONTAL);
		isLeafData.horizontalSpan = 2;
		isLeaf.setLayoutData(isLeafData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.isLeaf, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createOutgoingAdvancedReferencesTable(Composite parent) {
		this.outgoing = new ReferencesTable<ActivityEdge>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_OutgoingLabel, new ReferencesTableListener<ActivityEdge>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, outgoingFilters, outgoingBusinessFilters,
				"ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!outgoingEditUtil.getVirtualList().contains(elem))
								outgoingEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.outgoing,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						outgoing.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(ActivityEdge element) { editOutgoing(element); }
			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) { moveOutgoing(element, oldIndex, newIndex); }
			public void handleRemove(ActivityEdge element) { removeFromOutgoing(element); }
			public void navigateTo(ActivityEdge element) { }
		});
		this.outgoing.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.outgoing, UMLViewsRepository.SWT_KIND));
		this.outgoing.createControls(parent);
		GridData outgoingData = new GridData(GridData.FILL_HORIZONTAL);
		outgoingData.horizontalSpan = 3;
		this.outgoing.setLayoutData(outgoingData);
		this.outgoing.disableMove();
	}

	/**
	 * 
	 */
	protected void moveOutgoing(ActivityEdge element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromOutgoing(ActivityEdge element) {

		// Start of user code removeFromOutgoing() method body
		EObject editedElement = outgoingEditUtil.foundCorrespondingEObject(element);
		outgoingEditUtil.removeElement(element);
		outgoing.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.outgoing, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOutgoing(ActivityEdge element) {

		// Start of user code editOutgoing() method body
		EObject editedElement = outgoingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				outgoingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				outgoing.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.outgoing, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createIncomingAdvancedReferencesTable(Composite parent) {
		this.incoming = new ReferencesTable<ActivityEdge>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_IncomingLabel, new ReferencesTableListener<ActivityEdge>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<ActivityEdge> dialog = new TabElementTreeSelectionDialog<ActivityEdge>(resourceSet, incomingFilters, incomingBusinessFilters,
				"ActivityEdge", UMLPackage.eINSTANCE.getActivityEdge(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!incomingEditUtil.getVirtualList().contains(elem))
								incomingEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.incoming,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						incoming.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(ActivityEdge element) { editIncoming(element); }
			public void handleMove(ActivityEdge element, int oldIndex, int newIndex) { moveIncoming(element, oldIndex, newIndex); }
			public void handleRemove(ActivityEdge element) { removeFromIncoming(element); }
			public void navigateTo(ActivityEdge element) { }
		});
		this.incoming.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.incoming, UMLViewsRepository.SWT_KIND));
		this.incoming.createControls(parent);
		GridData incomingData = new GridData(GridData.FILL_HORIZONTAL);
		incomingData.horizontalSpan = 3;
		this.incoming.setLayoutData(incomingData);
		this.incoming.disableMove();
	}

	/**
	 * 
	 */
	protected void moveIncoming(ActivityEdge element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromIncoming(ActivityEdge element) {

		// Start of user code removeFromIncoming() method body
		EObject editedElement = incomingEditUtil.foundCorrespondingEObject(element);
		incomingEditUtil.removeElement(element);
		incoming.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.incoming, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editIncoming(ActivityEdge element) {

		// Start of user code editIncoming() method body
		EObject editedElement = incomingEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				incomingEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				incoming.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.incoming, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createInPartitionAdvancedReferencesTable(Composite parent) {
		this.inPartition = new ReferencesTable<ActivityPartition>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_InPartitionLabel, new ReferencesTableListener<ActivityPartition>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<ActivityPartition> dialog = new TabElementTreeSelectionDialog<ActivityPartition>(resourceSet, inPartitionFilters, inPartitionBusinessFilters,
				"ActivityPartition", UMLPackage.eINSTANCE.getActivityPartition(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!inPartitionEditUtil.getVirtualList().contains(elem))
								inPartitionEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.inPartition,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						inPartition.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(ActivityPartition element) { editInPartition(element); }
			public void handleMove(ActivityPartition element, int oldIndex, int newIndex) { moveInPartition(element, oldIndex, newIndex); }
			public void handleRemove(ActivityPartition element) { removeFromInPartition(element); }
			public void navigateTo(ActivityPartition element) { }
		});
		this.inPartition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.inPartition, UMLViewsRepository.SWT_KIND));
		this.inPartition.createControls(parent);
		GridData inPartitionData = new GridData(GridData.FILL_HORIZONTAL);
		inPartitionData.horizontalSpan = 3;
		this.inPartition.setLayoutData(inPartitionData);
		this.inPartition.disableMove();
	}

	/**
	 * 
	 */
	protected void moveInPartition(ActivityPartition element, int oldIndex, int newIndex) {
		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		inPartitionEditUtil.moveElement(element, oldIndex, newIndex);
		inPartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.inPartition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromInPartition(ActivityPartition element) {

		// Start of user code removeFromInPartition() method body
		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		inPartitionEditUtil.removeElement(element);
		inPartition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.inPartition, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editInPartition(ActivityPartition element) {

		// Start of user code editInPartition() method body
		EObject editedElement = inPartitionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				inPartitionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				inPartition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.inPartition, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createInInterruptibleRegionAdvancedReferencesTable(Composite parent) {
		this.inInterruptibleRegion = new ReferencesTable<InterruptibleActivityRegion>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_InInterruptibleRegionLabel, new ReferencesTableListener<InterruptibleActivityRegion>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<InterruptibleActivityRegion> dialog = new TabElementTreeSelectionDialog<InterruptibleActivityRegion>(resourceSet, inInterruptibleRegionFilters, inInterruptibleRegionBusinessFilters,
				"InterruptibleActivityRegion", UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!inInterruptibleRegionEditUtil.getVirtualList().contains(elem))
								inInterruptibleRegionEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.inInterruptibleRegion,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						inInterruptibleRegion.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(InterruptibleActivityRegion element) { editInInterruptibleRegion(element); }
			public void handleMove(InterruptibleActivityRegion element, int oldIndex, int newIndex) { moveInInterruptibleRegion(element, oldIndex, newIndex); }
			public void handleRemove(InterruptibleActivityRegion element) { removeFromInInterruptibleRegion(element); }
			public void navigateTo(InterruptibleActivityRegion element) { }
		});
		this.inInterruptibleRegion.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.inInterruptibleRegion, UMLViewsRepository.SWT_KIND));
		this.inInterruptibleRegion.createControls(parent);
		GridData inInterruptibleRegionData = new GridData(GridData.FILL_HORIZONTAL);
		inInterruptibleRegionData.horizontalSpan = 3;
		this.inInterruptibleRegion.setLayoutData(inInterruptibleRegionData);
		this.inInterruptibleRegion.disableMove();
	}

	/**
	 * 
	 */
	protected void moveInInterruptibleRegion(InterruptibleActivityRegion element, int oldIndex, int newIndex) {
		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		inInterruptibleRegionEditUtil.moveElement(element, oldIndex, newIndex);
		inInterruptibleRegion.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.inInterruptibleRegion, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromInInterruptibleRegion(InterruptibleActivityRegion element) {

		// Start of user code removeFromInInterruptibleRegion() method body
		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		inInterruptibleRegionEditUtil.removeElement(element);
		inInterruptibleRegion.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.inInterruptibleRegion, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editInInterruptibleRegion(InterruptibleActivityRegion element) {

		// Start of user code editInInterruptibleRegion() method body
		EObject editedElement = inInterruptibleRegionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				inInterruptibleRegionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				inInterruptibleRegion.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.inInterruptibleRegion, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createRedefinedNodeAdvancedReferencesTable(Composite parent) {
		this.redefinedNode = new ReferencesTable<ActivityNode>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_RedefinedNodeLabel, new ReferencesTableListener<ActivityNode>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<ActivityNode> dialog = new TabElementTreeSelectionDialog<ActivityNode>(resourceSet, redefinedNodeFilters, redefinedNodeBusinessFilters,
				"ActivityNode", UMLPackage.eINSTANCE.getActivityNode(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!redefinedNodeEditUtil.getVirtualList().contains(elem))
								redefinedNodeEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.redefinedNode,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						redefinedNode.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(ActivityNode element) { editRedefinedNode(element); }
			public void handleMove(ActivityNode element, int oldIndex, int newIndex) { moveRedefinedNode(element, oldIndex, newIndex); }
			public void handleRemove(ActivityNode element) { removeFromRedefinedNode(element); }
			public void navigateTo(ActivityNode element) { }
		});
		this.redefinedNode.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.redefinedNode, UMLViewsRepository.SWT_KIND));
		this.redefinedNode.createControls(parent);
		GridData redefinedNodeData = new GridData(GridData.FILL_HORIZONTAL);
		redefinedNodeData.horizontalSpan = 3;
		this.redefinedNode.setLayoutData(redefinedNodeData);
		this.redefinedNode.disableMove();
	}

	/**
	 * 
	 */
	protected void moveRedefinedNode(ActivityNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromRedefinedNode(ActivityNode element) {

		// Start of user code removeFromRedefinedNode() method body
		EObject editedElement = redefinedNodeEditUtil.foundCorrespondingEObject(element);
		redefinedNodeEditUtil.removeElement(element);
		redefinedNode.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.redefinedNode, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editRedefinedNode(ActivityNode element) {

		// Start of user code editRedefinedNode() method body
		EObject editedElement = redefinedNodeEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				redefinedNodeEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				redefinedNode.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.redefinedNode, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	/**
	 * @param container
	 */
	protected void createHandlerAdvancedTableComposition(Composite parent) {
		this.handler = new ReferencesTable<ExceptionHandler>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_HandlerLabel, new ReferencesTableListener<ExceptionHandler>() {			
			public void handleAdd() { addToHandler();}
			public void handleEdit(ExceptionHandler element) { editHandler(element); }
			public void handleMove(ExceptionHandler element, int oldIndex, int newIndex) { moveHandler(element, oldIndex, newIndex); }
			public void handleRemove(ExceptionHandler element) { removeFromHandler(element); }
			public void navigateTo(ExceptionHandler element) { }
		});
		this.handler.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.handler, UMLViewsRepository.SWT_KIND));
		this.handler.createControls(parent);
		GridData handlerData = new GridData(GridData.FILL_HORIZONTAL);
		handlerData.horizontalSpan = 3;
		this.handler.setLayoutData(handlerData);
	}

	/**
	 * 
	 */
	protected void moveHandler(ExceptionHandler element, int oldIndex, int newIndex) {
		EObject editedElement = handlerEditUtil.foundCorrespondingEObject(element);
		handlerEditUtil.moveElement(element, oldIndex, newIndex);
		handler.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.handler, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToHandler() {

		// Start of user code addToHandler() method body
		ExceptionHandler eObject = UMLFactory.eINSTANCE.createExceptionHandler();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
							eObject, resourceSet));
			if (propertiesEditionObject != null) {
				handlerEditUtil.addElement(propertiesEditionObject);
				handler.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.handler, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromHandler(ExceptionHandler element) {

		// Start of user code removeFromHandler() method body
		EObject editedElement = handlerEditUtil.foundCorrespondingEObject(element);
		handlerEditUtil.removeElement(element);
		handler.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.handler, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editHandler(ExceptionHandler element) {

		// Start of user code editHandler() method body
		EObject editedElement = handlerEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				handlerEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				handler.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.handler, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	/**
	 * @param container
	 */
	protected void createLocalPreconditionAdvancedTableComposition(Composite parent) {
		this.localPrecondition = new ReferencesTable<Constraint>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_LocalPreconditionLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToLocalPrecondition();}
			public void handleEdit(Constraint element) { editLocalPrecondition(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveLocalPrecondition(element, oldIndex, newIndex); }
			public void handleRemove(Constraint element) { removeFromLocalPrecondition(element); }
			public void navigateTo(Constraint element) { }
		});
		this.localPrecondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.localPrecondition, UMLViewsRepository.SWT_KIND));
		this.localPrecondition.createControls(parent);
		GridData localPreconditionData = new GridData(GridData.FILL_HORIZONTAL);
		localPreconditionData.horizontalSpan = 3;
		this.localPrecondition.setLayoutData(localPreconditionData);
	}

	/**
	 * 
	 */
	protected void moveLocalPrecondition(Constraint element, int oldIndex, int newIndex) {
		EObject editedElement = localPreconditionEditUtil.foundCorrespondingEObject(element);
		localPreconditionEditUtil.moveElement(element, oldIndex, newIndex);
		localPrecondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.localPrecondition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToLocalPrecondition() {

		// Start of user code addToLocalPrecondition() method body
		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
							eObject, resourceSet));
			if (propertiesEditionObject != null) {
				localPreconditionEditUtil.addElement(propertiesEditionObject);
				localPrecondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.localPrecondition, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromLocalPrecondition(Constraint element) {

		// Start of user code removeFromLocalPrecondition() method body
		EObject editedElement = localPreconditionEditUtil.foundCorrespondingEObject(element);
		localPreconditionEditUtil.removeElement(element);
		localPrecondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.localPrecondition, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editLocalPrecondition(Constraint element) {

		// Start of user code editLocalPrecondition() method body
		EObject editedElement = localPreconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				localPreconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				localPrecondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.localPrecondition, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	/**
	 * @param container
	 */
	protected void createLocalPostconditionAdvancedTableComposition(Composite parent) {
		this.localPostcondition = new ReferencesTable<Constraint>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_LocalPostconditionLabel, new ReferencesTableListener<Constraint>() {			
			public void handleAdd() { addToLocalPostcondition();}
			public void handleEdit(Constraint element) { editLocalPostcondition(element); }
			public void handleMove(Constraint element, int oldIndex, int newIndex) { moveLocalPostcondition(element, oldIndex, newIndex); }
			public void handleRemove(Constraint element) { removeFromLocalPostcondition(element); }
			public void navigateTo(Constraint element) { }
		});
		this.localPostcondition.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.localPostcondition, UMLViewsRepository.SWT_KIND));
		this.localPostcondition.createControls(parent);
		GridData localPostconditionData = new GridData(GridData.FILL_HORIZONTAL);
		localPostconditionData.horizontalSpan = 3;
		this.localPostcondition.setLayoutData(localPostconditionData);
	}

	/**
	 * 
	 */
	protected void moveLocalPostcondition(Constraint element, int oldIndex, int newIndex) {
		EObject editedElement = localPostconditionEditUtil.foundCorrespondingEObject(element);
		localPostconditionEditUtil.moveElement(element, oldIndex, newIndex);
		localPostcondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.localPostcondition, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));	
	}

	/**
	 * 
	 */
	protected void addToLocalPostcondition() {

		// Start of user code addToLocalPostcondition() method body
		Constraint eObject = UMLFactory.eINSTANCE.createConstraint();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
							eObject, resourceSet));
			if (propertiesEditionObject != null) {
				localPostconditionEditUtil.addElement(propertiesEditionObject);
				localPostcondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.localPostcondition, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromLocalPostcondition(Constraint element) {

		// Start of user code removeFromLocalPostcondition() method body
		EObject editedElement = localPostconditionEditUtil.foundCorrespondingEObject(element);
		localPostconditionEditUtil.removeElement(element);
		localPostcondition.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.localPostcondition, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editLocalPostcondition(Constraint element) {

		// Start of user code editLocalPostcondition() method body
		EObject editedElement = localPostconditionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				localPostconditionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				localPostcondition.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.localPostcondition, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createIsReplaceAllCheckbox(Composite parent) {
		isReplaceAll = new Button(parent, SWT.CHECK);
		isReplaceAll.setText(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_IsReplaceAllLabel);
		GridData isReplaceAllData = new GridData(GridData.FILL_HORIZONTAL);
		isReplaceAllData.horizontalSpan = 2;
		isReplaceAll.setLayoutData(isReplaceAllData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.isReplaceAll, UMLViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createOldClassifierAdvancedReferencesTable(Composite parent) {
		this.oldClassifier = new ReferencesTable<Classifier>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_OldClassifierLabel, new ReferencesTableListener<Classifier>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, oldClassifierFilters, oldClassifierBusinessFilters,
				"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!oldClassifierEditUtil.getVirtualList().contains(elem))
								oldClassifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.oldClassifier,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						oldClassifier.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(Classifier element) { editOldClassifier(element); }
			public void handleMove(Classifier element, int oldIndex, int newIndex) { moveOldClassifier(element, oldIndex, newIndex); }
			public void handleRemove(Classifier element) { removeFromOldClassifier(element); }
			public void navigateTo(Classifier element) { }
		});
		this.oldClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.oldClassifier, UMLViewsRepository.SWT_KIND));
		this.oldClassifier.createControls(parent);
		GridData oldClassifierData = new GridData(GridData.FILL_HORIZONTAL);
		oldClassifierData.horizontalSpan = 3;
		this.oldClassifier.setLayoutData(oldClassifierData);
		this.oldClassifier.disableMove();
	}

	/**
	 * 
	 */
	protected void moveOldClassifier(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromOldClassifier(Classifier element) {

		// Start of user code removeFromOldClassifier() method body
		EObject editedElement = oldClassifierEditUtil.foundCorrespondingEObject(element);
		oldClassifierEditUtil.removeElement(element);
		oldClassifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.oldClassifier, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOldClassifier(Classifier element) {

		// Start of user code editOldClassifier() method body
		EObject editedElement = oldClassifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				oldClassifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				oldClassifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.oldClassifier, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}
	protected void createNewClassifierAdvancedReferencesTable(Composite parent) {
		this.newClassifier = new ReferencesTable<Classifier>(UMLMessages.ReclassifyObjectActionPropertiesEditionPart_NewClassifierLabel, new ReferencesTableListener<Classifier>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Classifier> dialog = new TabElementTreeSelectionDialog<Classifier>(resourceSet, newClassifierFilters, newClassifierBusinessFilters,
				"Classifier", UMLPackage.eINSTANCE.getClassifier(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!newClassifierEditUtil.getVirtualList().contains(elem))
								newClassifierEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReclassifyObjectActionPropertiesEditionPartImpl.this, UMLViewsRepository.ReclassifyObjectAction.newClassifier,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						newClassifier.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(Classifier element) { editNewClassifier(element); }
			public void handleMove(Classifier element, int oldIndex, int newIndex) { moveNewClassifier(element, oldIndex, newIndex); }
			public void handleRemove(Classifier element) { removeFromNewClassifier(element); }
			public void navigateTo(Classifier element) { }
		});
		this.newClassifier.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.ReclassifyObjectAction.newClassifier, UMLViewsRepository.SWT_KIND));
		this.newClassifier.createControls(parent);
		GridData newClassifierData = new GridData(GridData.FILL_HORIZONTAL);
		newClassifierData.horizontalSpan = 3;
		this.newClassifier.setLayoutData(newClassifierData);
		this.newClassifier.disableMove();
	}

	/**
	 * 
	 */
	protected void moveNewClassifier(Classifier element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromNewClassifier(Classifier element) {

		// Start of user code removeFromNewClassifier() method body
		EObject editedElement = newClassifierEditUtil.foundCorrespondingEObject(element);
		newClassifierEditUtil.removeElement(element);
		newClassifier.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ReclassifyObjectActionPropertiesEditionPartImpl.this,
				UMLViewsRepository.ReclassifyObjectAction.newClassifier, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editNewClassifier(Classifier element) {

		// Start of user code editNewClassifier() method body
		EObject editedElement = newClassifierEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				newClassifierEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				newClassifier.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ReclassifyObjectActionPropertiesEditionPartImpl.this,
						UMLViewsRepository.ReclassifyObjectAction.newClassifier, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization

		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			ownedCommentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedCommentEditUtil = new EMFListEditUtil(current, feature);
		this.ownedComment.setInput(ownedCommentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateOwnedComment(EObject newValue)
	 */
	public void updateOwnedComment(EObject newValue) {
		if(ownedCommentEditUtil != null){
			ownedCommentEditUtil.reinit(newValue);
			ownedComment.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}

	public void setMessageForOwnedComment(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedComment() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForName(String msg, int msgLevel) {

	}

	public void unsetMessageForName() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getVisibility()
	 */
	public Enumerator getVisibility() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) visibility.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initVisibility(EEnum eenum, Enumerator current)
	 */
	public void initVisibility(EEnum eenum, Enumerator current) {
		visibility.setInput(eenum.getELiterals());
		visibility.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#setVisibility(Enumerator newValue)
	 */
	public void setVisibility(Enumerator newValue) {
		visibility.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForVisibility(String msg, int msgLevel) {

	}

	public void unsetMessageForVisibility() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getClientDependencyToAdd()
	 */
	public List getClientDependencyToAdd() {
		return clientDependencyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getClientDependencyToRemove()
	 */
	public List getClientDependencyToRemove() {
		return clientDependencyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getClientDependencyTable()
	 */
	public List getClientDependencyTable() {
		return clientDependencyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initClientDependency(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initClientDependency(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			clientDependencyEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			clientDependencyEditUtil = new EMFListEditUtil(current, feature);
		this.clientDependency.setInput(clientDependencyEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateClientDependency(EObject newValue)
	 */
	public void updateClientDependency(EObject newValue) {
		if(clientDependencyEditUtil != null){
			clientDependencyEditUtil.reinit(newValue);
			clientDependency.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterClientDependency(ViewerFilter filter)
	 */
	public void addFilterToClientDependency(ViewerFilter filter) {
		clientDependencyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterClientDependency(ViewerFilter filter)
	 */
	public void addBusinessFilterToClientDependency(ViewerFilter filter) {
		clientDependencyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInClientDependencyTable(EObject element)
	 */
	public boolean isContainedInClientDependencyTable(EObject element) {
		return clientDependencyEditUtil.contains(element);
	}

	public void setMessageForClientDependency(String msg, int msgLevel) {

	}

	public void unsetMessageForClientDependency() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getIsLeaf()
	 */
	public Boolean getIsLeaf() {
		return Boolean.valueOf(isLeaf.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#setIsLeaf(Boolean newValue)
	 */
	public void setIsLeaf(Boolean newValue) {
		if (newValue != null) {
			isLeaf.setSelection(newValue.booleanValue());
		} else {
			isLeaf.setSelection(false);
		}
	}

	public void setMessageForIsLeaf(String msg, int msgLevel) {

	}

	public void unsetMessageForIsLeaf() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOutgoingToAdd()
	 */
	public List getOutgoingToAdd() {
		return outgoingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOutgoingToRemove()
	 */
	public List getOutgoingToRemove() {
		return outgoingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOutgoingTable()
	 */
	public List getOutgoingTable() {
		return outgoingEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initOutgoing(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOutgoing(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			outgoingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			outgoingEditUtil = new EMFListEditUtil(current, feature);
		this.outgoing.setInput(outgoingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateOutgoing(EObject newValue)
	 */
	public void updateOutgoing(EObject newValue) {
		if(outgoingEditUtil != null){
			outgoingEditUtil.reinit(newValue);
			outgoing.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterOutgoing(ViewerFilter filter)
	 */
	public void addFilterToOutgoing(ViewerFilter filter) {
		outgoingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterOutgoing(ViewerFilter filter)
	 */
	public void addBusinessFilterToOutgoing(ViewerFilter filter) {
		outgoingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInOutgoingTable(EObject element)
	 */
	public boolean isContainedInOutgoingTable(EObject element) {
		return outgoingEditUtil.contains(element);
	}

	public void setMessageForOutgoing(String msg, int msgLevel) {

	}

	public void unsetMessageForOutgoing() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getIncomingToAdd()
	 */
	public List getIncomingToAdd() {
		return incomingEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getIncomingToRemove()
	 */
	public List getIncomingToRemove() {
		return incomingEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getIncomingTable()
	 */
	public List getIncomingTable() {
		return incomingEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initIncoming(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initIncoming(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			incomingEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			incomingEditUtil = new EMFListEditUtil(current, feature);
		this.incoming.setInput(incomingEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateIncoming(EObject newValue)
	 */
	public void updateIncoming(EObject newValue) {
		if(incomingEditUtil != null){
			incomingEditUtil.reinit(newValue);
			incoming.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterIncoming(ViewerFilter filter)
	 */
	public void addFilterToIncoming(ViewerFilter filter) {
		incomingFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterIncoming(ViewerFilter filter)
	 */
	public void addBusinessFilterToIncoming(ViewerFilter filter) {
		incomingBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInIncomingTable(EObject element)
	 */
	public boolean isContainedInIncomingTable(EObject element) {
		return incomingEditUtil.contains(element);
	}

	public void setMessageForIncoming(String msg, int msgLevel) {

	}

	public void unsetMessageForIncoming() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getInPartitionToAdd()
	 */
	public List getInPartitionToAdd() {
		return inPartitionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getInPartitionToRemove()
	 */
	public List getInPartitionToRemove() {
		return inPartitionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getInPartitionTable()
	 */
	public List getInPartitionTable() {
		return inPartitionEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initInPartition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInPartition(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			inPartitionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			inPartitionEditUtil = new EMFListEditUtil(current, feature);
		this.inPartition.setInput(inPartitionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateInPartition(EObject newValue)
	 */
	public void updateInPartition(EObject newValue) {
		if(inPartitionEditUtil != null){
			inPartitionEditUtil.reinit(newValue);
			inPartition.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterInPartition(ViewerFilter filter)
	 */
	public void addFilterToInPartition(ViewerFilter filter) {
		inPartitionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterInPartition(ViewerFilter filter)
	 */
	public void addBusinessFilterToInPartition(ViewerFilter filter) {
		inPartitionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInInPartitionTable(EObject element)
	 */
	public boolean isContainedInInPartitionTable(EObject element) {
		return inPartitionEditUtil.contains(element);
	}

	public void setMessageForInPartition(String msg, int msgLevel) {

	}

	public void unsetMessageForInPartition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getInInterruptibleRegionToAdd()
	 */
	public List getInInterruptibleRegionToAdd() {
		return inInterruptibleRegionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getInInterruptibleRegionToRemove()
	 */
	public List getInInterruptibleRegionToRemove() {
		return inInterruptibleRegionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getInInterruptibleRegionTable()
	 */
	public List getInInterruptibleRegionTable() {
		return inInterruptibleRegionEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInInterruptibleRegion(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			inInterruptibleRegionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			inInterruptibleRegionEditUtil = new EMFListEditUtil(current, feature);
		this.inInterruptibleRegion.setInput(inInterruptibleRegionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateInInterruptibleRegion(EObject newValue)
	 */
	public void updateInInterruptibleRegion(EObject newValue) {
		if(inInterruptibleRegionEditUtil != null){
			inInterruptibleRegionEditUtil.reinit(newValue);
			inInterruptibleRegion.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterInInterruptibleRegion(ViewerFilter filter)
	 */
	public void addFilterToInInterruptibleRegion(ViewerFilter filter) {
		inInterruptibleRegionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterInInterruptibleRegion(ViewerFilter filter)
	 */
	public void addBusinessFilterToInInterruptibleRegion(ViewerFilter filter) {
		inInterruptibleRegionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInInInterruptibleRegionTable(EObject element)
	 */
	public boolean isContainedInInInterruptibleRegionTable(EObject element) {
		return inInterruptibleRegionEditUtil.contains(element);
	}

	public void setMessageForInInterruptibleRegion(String msg, int msgLevel) {

	}

	public void unsetMessageForInInterruptibleRegion() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getRedefinedNodeToAdd()
	 */
	public List getRedefinedNodeToAdd() {
		return redefinedNodeEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getRedefinedNodeToRemove()
	 */
	public List getRedefinedNodeToRemove() {
		return redefinedNodeEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getRedefinedNodeTable()
	 */
	public List getRedefinedNodeTable() {
		return redefinedNodeEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initRedefinedNode(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initRedefinedNode(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			redefinedNodeEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			redefinedNodeEditUtil = new EMFListEditUtil(current, feature);
		this.redefinedNode.setInput(redefinedNodeEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateRedefinedNode(EObject newValue)
	 */
	public void updateRedefinedNode(EObject newValue) {
		if(redefinedNodeEditUtil != null){
			redefinedNodeEditUtil.reinit(newValue);
			redefinedNode.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterRedefinedNode(ViewerFilter filter)
	 */
	public void addFilterToRedefinedNode(ViewerFilter filter) {
		redefinedNodeFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterRedefinedNode(ViewerFilter filter)
	 */
	public void addBusinessFilterToRedefinedNode(ViewerFilter filter) {
		redefinedNodeBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInRedefinedNodeTable(EObject element)
	 */
	public boolean isContainedInRedefinedNodeTable(EObject element) {
		return redefinedNodeEditUtil.contains(element);
	}

	public void setMessageForRedefinedNode(String msg, int msgLevel) {

	}

	public void unsetMessageForRedefinedNode() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getHandlerToAdd()
	 */
	public List getHandlerToAdd() {
		return handlerEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getHandlerToRemove()
	 */
	public List getHandlerToRemove() {
		return handlerEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getHandlerToEdit()
	 */
	public Map getHandlerToEdit() {
		return handlerEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getHandlerToMove()
	 */
	public List getHandlerToMove() {
		return handlerEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getHandlerTable()
	 */
	public List getHandlerTable() {
		return handlerEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initHandler(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initHandler(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			handlerEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			handlerEditUtil = new EMFListEditUtil(current, feature);
		this.handler.setInput(handlerEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateHandler(EObject newValue)
	 */
	public void updateHandler(EObject newValue) {
		if(handlerEditUtil != null){
			handlerEditUtil.reinit(newValue);
			handler.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterHandler(ViewerFilter filter)
	 */
	public void addFilterToHandler(ViewerFilter filter) {
		handlerFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterHandler(ViewerFilter filter)
	 */
	public void addBusinessFilterToHandler(ViewerFilter filter) {
		handlerBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInHandlerTable(EObject element)
	 */
	public boolean isContainedInHandlerTable(EObject element) {
		return handlerEditUtil.contains(element);
	}

	public void setMessageForHandler(String msg, int msgLevel) {

	}

	public void unsetMessageForHandler() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPreconditionToAdd()
	 */
	public List getLocalPreconditionToAdd() {
		return localPreconditionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPreconditionToRemove()
	 */
	public List getLocalPreconditionToRemove() {
		return localPreconditionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPreconditionToEdit()
	 */
	public Map getLocalPreconditionToEdit() {
		return localPreconditionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPreconditionToMove()
	 */
	public List getLocalPreconditionToMove() {
		return localPreconditionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPreconditionTable()
	 */
	public List getLocalPreconditionTable() {
		return localPreconditionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initLocalPrecondition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initLocalPrecondition(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			localPreconditionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			localPreconditionEditUtil = new EMFListEditUtil(current, feature);
		this.localPrecondition.setInput(localPreconditionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateLocalPrecondition(EObject newValue)
	 */
	public void updateLocalPrecondition(EObject newValue) {
		if(localPreconditionEditUtil != null){
			localPreconditionEditUtil.reinit(newValue);
			localPrecondition.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterLocalPrecondition(ViewerFilter filter)
	 */
	public void addFilterToLocalPrecondition(ViewerFilter filter) {
		localPreconditionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterLocalPrecondition(ViewerFilter filter)
	 */
	public void addBusinessFilterToLocalPrecondition(ViewerFilter filter) {
		localPreconditionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInLocalPreconditionTable(EObject element)
	 */
	public boolean isContainedInLocalPreconditionTable(EObject element) {
		return localPreconditionEditUtil.contains(element);
	}

	public void setMessageForLocalPrecondition(String msg, int msgLevel) {

	}

	public void unsetMessageForLocalPrecondition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPostconditionToAdd()
	 */
	public List getLocalPostconditionToAdd() {
		return localPostconditionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPostconditionToRemove()
	 */
	public List getLocalPostconditionToRemove() {
		return localPostconditionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPostconditionToEdit()
	 */
	public Map getLocalPostconditionToEdit() {
		return localPostconditionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPostconditionToMove()
	 */
	public List getLocalPostconditionToMove() {
		return localPostconditionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getLocalPostconditionTable()
	 */
	public List getLocalPostconditionTable() {
		return localPostconditionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initLocalPostcondition(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initLocalPostcondition(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			localPostconditionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			localPostconditionEditUtil = new EMFListEditUtil(current, feature);
		this.localPostcondition.setInput(localPostconditionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateLocalPostcondition(EObject newValue)
	 */
	public void updateLocalPostcondition(EObject newValue) {
		if(localPostconditionEditUtil != null){
			localPostconditionEditUtil.reinit(newValue);
			localPostcondition.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterLocalPostcondition(ViewerFilter filter)
	 */
	public void addFilterToLocalPostcondition(ViewerFilter filter) {
		localPostconditionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterLocalPostcondition(ViewerFilter filter)
	 */
	public void addBusinessFilterToLocalPostcondition(ViewerFilter filter) {
		localPostconditionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInLocalPostconditionTable(EObject element)
	 */
	public boolean isContainedInLocalPostconditionTable(EObject element) {
		return localPostconditionEditUtil.contains(element);
	}

	public void setMessageForLocalPostcondition(String msg, int msgLevel) {

	}

	public void unsetMessageForLocalPostcondition() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getIsReplaceAll()
	 */
	public Boolean getIsReplaceAll() {
		return Boolean.valueOf(isReplaceAll.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#setIsReplaceAll(Boolean newValue)
	 */
	public void setIsReplaceAll(Boolean newValue) {
		if (newValue != null) {
			isReplaceAll.setSelection(newValue.booleanValue());
		} else {
			isReplaceAll.setSelection(false);
		}
	}

	public void setMessageForIsReplaceAll(String msg, int msgLevel) {

	}

	public void unsetMessageForIsReplaceAll() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOldClassifierToAdd()
	 */
	public List getOldClassifierToAdd() {
		return oldClassifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOldClassifierToRemove()
	 */
	public List getOldClassifierToRemove() {
		return oldClassifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getOldClassifierTable()
	 */
	public List getOldClassifierTable() {
		return oldClassifierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initOldClassifier(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOldClassifier(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			oldClassifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			oldClassifierEditUtil = new EMFListEditUtil(current, feature);
		this.oldClassifier.setInput(oldClassifierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateOldClassifier(EObject newValue)
	 */
	public void updateOldClassifier(EObject newValue) {
		if(oldClassifierEditUtil != null){
			oldClassifierEditUtil.reinit(newValue);
			oldClassifier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterOldClassifier(ViewerFilter filter)
	 */
	public void addFilterToOldClassifier(ViewerFilter filter) {
		oldClassifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterOldClassifier(ViewerFilter filter)
	 */
	public void addBusinessFilterToOldClassifier(ViewerFilter filter) {
		oldClassifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInOldClassifierTable(EObject element)
	 */
	public boolean isContainedInOldClassifierTable(EObject element) {
		return oldClassifierEditUtil.contains(element);
	}

	public void setMessageForOldClassifier(String msg, int msgLevel) {

	}

	public void unsetMessageForOldClassifier() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getNewClassifierToAdd()
	 */
	public List getNewClassifierToAdd() {
		return newClassifierEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getNewClassifierToRemove()
	 */
	public List getNewClassifierToRemove() {
		return newClassifierEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#getNewClassifierTable()
	 */
	public List getNewClassifierTable() {
		return newClassifierEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#initNewClassifier(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initNewClassifier(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			newClassifierEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			newClassifierEditUtil = new EMFListEditUtil(current, feature);
		this.newClassifier.setInput(newClassifierEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#updateNewClassifier(EObject newValue)
	 */
	public void updateNewClassifier(EObject newValue) {
		if(newClassifierEditUtil != null){
			newClassifierEditUtil.reinit(newValue);
			newClassifier.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addFilterNewClassifier(ViewerFilter filter)
	 */
	public void addFilterToNewClassifier(ViewerFilter filter) {
		newClassifierFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#addBusinessFilterNewClassifier(ViewerFilter filter)
	 */
	public void addBusinessFilterToNewClassifier(ViewerFilter filter) {
		newClassifierBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ReclassifyObjectActionPropertiesEditionPart#isContainedInNewClassifierTable(EObject element)
	 */
	public boolean isContainedInNewClassifierTable(EObject element) {
		return newClassifierEditUtil.contains(element);
	}

	public void setMessageForNewClassifier(String msg, int msgLevel) {

	}

	public void unsetMessageForNewClassifier() {

	}








	// Start of user code additional methods

	// End of user code

}