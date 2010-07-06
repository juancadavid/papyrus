/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - refactor common behavior between diagrams
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - add the line 	ViewServiceUtil.forceLoad();
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.helper.ILinkMappingHelper;
import org.eclipse.papyrus.diagram.common.util.ViewServiceUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * This class is used to execute the drag and drop from the outline. It can manage the drop of nodes
 * and binary links.
 */
public abstract class CommonDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/** The specific drop. */
	private Set<Integer> specificDrop = null;

	/** The specified link mapping helper depending on the diagram */
	private ILinkMappingHelper linkmappingHelper;

	/**
	 * Instantiates a new custom diagram drag drop edit policy.
	 * 
	 * @param mappingHelper
	 *        the mapping helper
	 */
	public CommonDiagramDragDropEditPolicy(ILinkMappingHelper mappingHelper) {
		linkmappingHelper = mappingHelper;
	}

	/**
	 * Gets elements visual id that can be dropped in the diagram
	 */
	private Set<Integer> getSpecificDrop() {
		if(specificDrop == null) {
			specificDrop = getDroppableElementVisualId();
		}
		return specificDrop;
	}

	/**
	 * Gets the UML element type for the specified
	 * 
	 * @param elementID
	 *        the element id
	 * 
	 * @return the uML element type
	 */
	public abstract IElementType getUMLElementType(int elementID);

	public abstract int getNodeVisualID(View containerView, EObject domainElement);

	public abstract int getLinkWithClassVisualID(EObject domainElement);

	/**
	 * The list of visualID that the policy manages.
	 */
	protected abstract Set<Integer> getDroppableElementVisualId();

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected Command createViewsAndArrangeCommand(DropObjectsRequest dropRequest, List viewDescriptors) {
		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptors);
		createViewRequest.setLocation(dropRequest.getLocation());
		Command createCommand = getHost().getCommand(createViewRequest);
		return createCommand;
	}

	/**
	 * the method provides command to create the binary link into the diagram. If the source and the
	 * target views do not exist, these views will be created.
	 * 
	 * @param cc
	 *        the composite command that will contain the set of command to create the binary
	 *        link
	 * @param source
	 *        the source the element source of the link
	 * @param target
	 *        the target the element target of the link
	 * @param linkVISUALID
	 *        the link VISUALID used to create the view
	 * @param location
	 *        the location the location where the view will be be created
	 * @param semanticLink
	 *        the semantic link that will be attached to the view
	 * 
	 * @return the composite command
	 */
	public CompositeCommand dropBinaryLink(CompositeCommand cc, Element source, Element target, int linkVISUALID, Point location, Element semanticLink) {
		// look for editpart
		GraphicalEditPart sourceEditPart = (GraphicalEditPart)lookForEditPart(source);
		GraphicalEditPart targetEditPart = (GraphicalEditPart)lookForEditPart(target);

		// descriptor of the link
		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(getUMLElementType(linkVISUALID), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), getDiagramPreferencesHint());

		IAdaptable sourceAdapter = null;
		IAdaptable targetAdapter = null;
		if(sourceEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(source), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y + 100)); //$NON-NLS-1$
			cc.compose(setBoundsCommand);

			sourceAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();
		} else {
			sourceAdapter = new SemanticAdapter(null, sourceEditPart.getModel());
		}
		if(targetEditPart == null) {
			// creation of the node
			ViewDescriptor descriptor = new ViewDescriptor(new EObjectAdapter(target), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());

			// get the command and execute it.
			CreateCommand nodeCreationCommand = new CreateCommand(((IGraphicalEditPart)getHost()).getEditingDomain(), descriptor, ((View)getHost().getModel()));
			cc.compose(nodeCreationCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100)); //$NON-NLS-1$
			cc.compose(setBoundsCommand);
			targetAdapter = (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue();

		} else {
			targetAdapter = new SemanticAdapter(null, targetEditPart.getModel());
		}

		CommonDeferredCreateConnectionViewCommand aLinkCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)getUMLElementType(linkVISUALID)).getSemanticHint(), sourceAdapter, targetAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		aLinkCommand.setElement(semanticLink);
		cc.compose(aLinkCommand);
		return cc;

	}

	/**
	 * Gets the diagram preferences hint.
	 * 
	 * @return the diagram preferences hint
	 */
	protected PreferencesHint getDiagramPreferencesHint() {
		return ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint();
	}

	/**
	 * {@inheritedDoc}.
	 */
	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		/*
		 * when it's the first action after the opening of Papyrus, the viewService is not loaded!
		 * see bug 302555
		 * 
		 * Duration test for 100000 creations of DropCommand :
		 * Here 2 solutions :
		 * - call ViewServiceUtil.forceLoad(); for each drop -> ~2500ms
		 * 
		 * - test if the command cc can be executed at the end of the method, and if not :
		 * - call ViewServiceUtil.forceLoad();
		 * - and return getDropObjectsCommand(getDropObjectsCommand)
		 * -> ~4700ms
		 * 
		 * - for information : without call ViewServiceUtil.forceLoad();
		 * -> ~1600ms
		 * 
		 * It's better don't test if the command is executable!
		 */
		ViewServiceUtil.forceLoad();

		// Create a view request from the drop request and then forward getting
		// the command for that.
		CompositeCommand cc = new CompositeCommand("Drop"); //$NON-NLS-1$
		Iterator<?> iter = dropRequest.getObjects().iterator();
		if(dropRequest.getObjects().size() > 0 && dropRequest.getObjects().get(0) instanceof String) {
			return getDropFileCommand(dropRequest);
		}
		Point location = dropRequest.getLocation().getCopy();
		((GraphicalEditPart)getHost()).getContentPane().translateToRelative(location);
		((GraphicalEditPart)getHost()).getContentPane().translateFromParent(location);
		location.translate(((GraphicalEditPart)getHost()).getContentPane().getClientArea().getLocation().getNegated());
		while(iter.hasNext()) {
			EObject droppedObject = (EObject)iter.next();
			int nodeVISUALID = getNodeVisualID(((IGraphicalEditPart)getHost()).getNotationView(), droppedObject);
			int linkVISUALID = getLinkWithClassVisualID(droppedObject);
			if(getSpecificDrop().contains(nodeVISUALID) || getSpecificDrop().contains(linkVISUALID)) {
				dropRequest.setLocation(location);
				// TODO: add to composite command ?
				cc.add(new CommandProxy(getSpecificDropCommand(dropRequest, (Element)droppedObject, nodeVISUALID, linkVISUALID)));
				continue;
			}

			if(linkVISUALID == -1 && nodeVISUALID != -1) {
				// The element to drop is a node
				// Retrieve it's expected graphical parent
				EObject graphicalParent = ((GraphicalEditPart)getHost()).resolveSemanticElement();

				// Restrict the default node creation to the following cases:
				// . Take the containment relationship into consideration
				// . Release the constraint when GraphicalParent is a Package (Canvas for most
				// diagrams)
				if(graphicalParent instanceof Package) {
					cc.add(getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject));

				} else if((graphicalParent instanceof Element) && ((Element)graphicalParent).getOwnedElements().contains(droppedObject)) {
					cc.add(getDefaultDropNodeCommand(nodeVISUALID, location, droppedObject));

				} else {
					return UnexecutableCommand.INSTANCE;
				}

			} else if(linkVISUALID != -1) {
				Collection<?> sources = linkmappingHelper.getSource((Element)droppedObject);
				Collection<?> targets = linkmappingHelper.getTarget((Element)droppedObject);
				if(sources.size() == 0 || targets.size() == 0) {
					return UnexecutableCommand.INSTANCE;
				}
				// binary association
				Element source = (Element)sources.toArray()[0];
				Element target = (Element)targets.toArray()[0];
				dropBinaryLink(cc, source, target, linkVISUALID, dropRequest.getLocation(), (Element)droppedObject);
			}
		}

		return new ICommandProxy(cc);
	}

	/**
	 * This method returns the default drop command for node. Default here means the no
	 * consideration is made regarding the semantic elements, the expected figure is basically
	 * created where expected.
	 * 
	 * @param nodeVISUALID
	 *        the node visual identifier
	 * @param location
	 *        the drop location
	 * @param droppedObject
	 *        the object to drop
	 * @return a CompositeCommand for Drop
	 */
	protected CompositeCommand getDefaultDropNodeCommand(int nodeVISUALID, Point location, EObject droppedObject) {
		CompositeCommand cc = new CompositeCommand("Drop"); //$NON-NLS-1$
		IAdaptable elementAdapter = new EObjectAdapter(droppedObject);

		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)getUMLElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, getDiagramPreferencesHint());
		CreateCommand createCommand = new CreateCommand(getEditingDomain(), descriptor, ((View)(getHost().getModel())));
		cc.compose(createCommand);

		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)createCommand.getCommandResult().getReturnValue(), location); //$NON-NLS-1$
		cc.compose(setBoundsCommand);
		return cc;
	}

	/**
	 * Gets the editing domain.
	 * 
	 * @return the editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * for specific case of drop, the designers has to write the algorithm of its own drop. for
	 * example case of associationClass, multi dependency etc....
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param nodeVISUALID
	 *        the node visualid
	 * @param linkVISUALID
	 *        the link visualid
	 * @param semanticLink
	 *        the semantic link
	 * 
	 * @return the specific drop command
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the viewer.
	 * 
	 * @return the viewer
	 */
	protected EditPartViewer getViewer() {
		return ((IGraphicalEditPart)getHost()).getViewer();
	}

	/**
	 * Look for editPart from its semantic.
	 * 
	 * @param semantic
	 *        the semantic
	 * 
	 * @return the edits the part or null if not found
	 */
	private EditPart lookForEditPart(EObject semantic) {
		Collection<EditPart> editPartSet = getHost().getViewer().getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		EditPart existedEditPart = null;
		while(editPartIterator.hasNext() && existedEditPart == null) {
			EditPart currentEditPart = editPartIterator.next();

			if(isEditPartTypeAdapted(currentEditPart.getClass(), semantic.eClass()) && semantic.equals(((GraphicalEditPart)currentEditPart).resolveSemanticElement())) {
				existedEditPart = currentEditPart;
			}
		}
		return existedEditPart;
	}

	/**
	 * Check if the edit part type is the best one to represent an object of the given EClass type
	 * 
	 * @param editPartClass
	 *        the type of EditPart which may represent a semantic element
	 * @param eClass
	 *        the EClass type of the represented semantic element
	 * @return true if an edit part of this type should be selected
	 */
	private boolean isEditPartTypeAdapted(Class<? extends EditPart> editPartClass, EClass eClass) {
		if(DiagramEditPart.class.isAssignableFrom(editPartClass) || CompartmentEditPart.class.isAssignableFrom(editPartClass)) {
			// the edit part is disqualified, as a compartment or a diagram can not be dropped
			return false;
		} else if(GraphicalEditPart.class.isAssignableFrom(editPartClass)) {
			// check the edit part type against advised ones
			return isEditPartTypeSuitableForEClass(editPartClass.asSubclass(GraphicalEditPart.class), eClass);
		} else {
			// only a GraphicalEditPart must be selected
			return false;
		}
	}

	/**
	 * Check if an edit part type correctly represent a semantic element of the given EClass.
	 * Subclasses should implement this method to restrict the possibilities during drop of a link.
	 * If an edit part is not of a suitable type, returning false will eliminate it to represent the
	 * element as a source or target edit part. This can be used for example to disable label edit
	 * parts, which may represent the same model element as the main node.
	 * 
	 * @param editPartClass
	 *        the type of EditPart which must be checked
	 * @param eClass
	 *        the EClass type of the element which the edit part must represent
	 * @return the only edit part type which can be selected (return a common super type if several
	 *         edit parts can be chosen)
	 */
	protected boolean isEditPartTypeSuitableForEClass(Class<? extends GraphicalEditPart> editPartClass, EClass eClass) {
		return true;
	}

}
