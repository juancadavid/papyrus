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
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationClassHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ClassLinkMappingHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelPackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * The Class ClassDiagramDragDropEditPolicy.
 */
public class ClassDiagramDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	public static final String CONTAINED_CLASS_DROP_TO_COMPARTMENT = "ContainedClassDropToCompartment";

	/**
	 * Instantiates a new class diagram drag drop edit policy.
	 */
	public ClassDiagramDragDropEditPolicy() {
		super(ClassLinkMappingHelper.getInstance());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> droppableElementsVisualID = new HashSet<Integer>();

		droppableElementsVisualID.add(Dependency2EditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationClassEditPart.VISUAL_ID);
		droppableElementsVisualID.add(AssociationNodeEditPart.VISUAL_ID);
		droppableElementsVisualID.add(ClassEditPart.VISUAL_ID);
		droppableElementsVisualID.add(PackageEditPart.VISUAL_ID);
		droppableElementsVisualID.add(ModelEditPartTN.VISUAL_ID);
		droppableElementsVisualID.add(PackageEditPartCN.VISUAL_ID);
		droppableElementsVisualID.add(Class5EditPart.VISUAL_ID);
		droppableElementsVisualID.add(ModelEditPartCN.VISUAL_ID);

		return droppableElementsVisualID;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID, int linkVISUALID) {
		if(linkVISUALID == InterfaceRealizationEditPart.VISUAL_ID) {
			return dropInterfaceRealization(dropRequest, semanticLink, linkVISUALID);
		}

		switch(nodeVISUALID) {
		case Dependency2EditPart.VISUAL_ID:
			return dropDependency(dropRequest, semanticLink, nodeVISUALID);
		case AssociationClassEditPart.VISUAL_ID:
			return dropAssociationClass(dropRequest, semanticLink, nodeVISUALID);
		case AssociationNodeEditPart.VISUAL_ID:
			return dropAssociation(dropRequest, semanticLink, nodeVISUALID);
		case Class5EditPart.VISUAL_ID:
		case PackageEditPartCN.VISUAL_ID:
		case ModelEditPartCN.VISUAL_ID:
			return dropElementWithContainmentLinkIntoContainer(dropRequest, semanticLink, nodeVISUALID);
		case ModelEditPartTN.VISUAL_ID:
		case ClassEditPart.VISUAL_ID:
		case PackageEditPart.VISUAL_ID:
			return dropElementWithContainedElementIntoDiagram(dropRequest, semanticLink, nodeVISUALID);
		default:
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * gets a drop command
	 * 
	 * @param request
	 *        the request
	 * @return command
	 */
	protected Command getDropCommand(ChangeBoundsRequest request) {
		Command cmd = getDropWithContainmentCommand(request);
		if(cmd != null) {
			return cmd;
		}
		return super.getDropCommand(request);
	}

	private boolean canHaveContainmentLink() {
		return getHost() instanceof PackagePackageableElementCompartment2EditPart || getHost() instanceof PackagePackageableElementCompartmentEditPart || getHost() instanceof ModelEditPart || getHost() instanceof ModelPackageableElementCompartmentEditPart || getHost() instanceof ModelPackageableElementCompartment2EditPart;
	}

	private Command getDropWithContainmentCommand(ChangeBoundsRequest request) {
		if(!canHaveContainmentLink()) {
			return null;
		}
		if (request.getEditParts().size() > 1) {
			// process several edit parts
			return null;
		}
		View hostView = (View)getHost().getModel();
		EObject hostElement = hostView.getElement();
		for(Object next : request.getEditParts()) {
			EditPart ep = (EditPart)next;
			View movedView = (View)ep.getModel();
			if(isMoveToParent(hostView, movedView)) {
				return getDropObjectsCommand(castToDropObjectsRequest(request));
			} else if(isMoveToChild(hostView, movedView)) {
				CompoundCommand cmd = new CompoundCommand();
				Element parent = (Element)ViewUtil.resolveSemanticElement((View)getHost().getParent().getParent().getModel());
				Element child1 = (Element)hostElement;
				Element child2 = (Element)ViewUtil.resolveSemanticElement(movedView);
				cmd.add(new ICommandProxy(getMoveCommand(getEditingDomain(), parent, child1, child2)));
				cmd.add(getDropObjectsCommand(castToDropObjectsRequest(request)));
				return cmd;
			} else if (ContainmentHelper.hasIncomingContainmentLink(movedView)) {
				CompoundCommand cmd = new CompoundCommand();
				Element parent = (Element)hostElement;
				Element child1 = (Element)movedView.getElement();
				cmd.add(new ICommandProxy(getMoveCommand(getEditingDomain(), parent, child1)));
				cmd.add(getDropObjectsCommand(castToDropObjectsRequest(request)));
				return cmd;
			}else if (ContainmentHelper.hasOutgoingContainmentLink(movedView)) {
				// move contained element into a correct place
				return UnexecutableCommand.INSTANCE;
			}
		}
		return null;
	}

	private AbstractTransactionalCommand getMoveCommand(TransactionalEditingDomain domain, final Element parent, final Element child1, final Element child2) {
		return new AbstractTransactionalCommand(domain, "Move Element", Collections.emptyList()) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				ContainmentHelper helper = new ContainmentHelper(getEditingDomain());

				helper.move(child1, parent);
				helper.move(child2, child1);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private AbstractTransactionalCommand getMoveCommand(TransactionalEditingDomain domain, final Element parent, final Element child1) {
		return new AbstractTransactionalCommand(domain, "Move Element", Collections.emptyList()) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				ContainmentHelper helper = new ContainmentHelper(getEditingDomain());

				helper.move(child1, parent);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private boolean isMoveToChild(View hostView, View movedElementView) {
		return EcoreUtil.isAncestor(movedElementView.getElement(), hostView.getElement());
	}

	private boolean isMoveToParent(View hostView, View movedElementView) {
		return hostView.getElement().equals(movedElementView.getElement().eContainer());
		//		return EcoreUtil.isAncestor(hostView.getElement(), movedElementView.getElement());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLinkWithClassVisualID(EObject domainElement) {
		return UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNodeVisualID(View containerView, EObject domainElement) {
		return UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IElementType getUMLElementType(int elementID) {
		return UMLElementTypes.getElementType(elementID);
	}

	/**
	 * this method has in charge to create command for create an association if the number of
	 * endtype is superior of 2 a multi association is dropped. if the number of endtype this is
	 * binary association that is dropped.
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropAssociation(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection endtypes = ClassLinkMappingHelper.getInstance().getSource(semanticLink);
		if(endtypes.size() == 2) {
			Element source = (Element)endtypes.toArray()[0];
			Element target = (Element)endtypes.toArray()[1];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4001, dropRequest.getLocation(), semanticLink));
		}
		if(endtypes.size() > 2) {
			MultiAssociationHelper associationHelper = new MultiAssociationHelper(getEditingDomain());
			return associationHelper.dropMutliAssociation((Association)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		}
		return UnexecutableCommand.INSTANCE;

	}

	/**
	 * this method send a Command that create views for associationClass
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropAssociationClass(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		AssociationClassHelper associationClassHelper = new AssociationClassHelper(getEditingDomain());
		return associationClassHelper.dropAssociationClass((AssociationClass)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
	}

	/**
	 * this method send a command to create views to display
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the semantic link
	 * @param nodeVISUALID
	 *        the node visualid
	 * 
	 * @return the command
	 */
	protected Command dropDependency(DropObjectsRequest dropRequest, Element semanticLink, int nodeVISUALID) {
		Collection sources = ClassLinkMappingHelper.getInstance().getSource(semanticLink);
		Collection targets = ClassLinkMappingHelper.getInstance().getTarget(semanticLink);
		if(sources.size() == 1 && targets.size() == 1) {
			Element source = (Element)sources.toArray()[0];
			Element target = (Element)targets.toArray()[0];
			return new ICommandProxy(dropBinaryLink(new CompositeCommand("drop Association"), source, target, 4008, dropRequest.getLocation(), semanticLink));
		}
		if(sources.size() > 1 || targets.size() > 1) {
			MultiDependencyHelper dependencyHelper = new MultiDependencyHelper(getEditingDomain());
			return dependencyHelper.dropMutliDependency((Dependency)semanticLink, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Use to drop a class from the outline to the diagram
	 * 
	 * @param dropRequest
	 *        is the request for the drop, never be null
	 * @param semanticObject
	 *        is the class dropped
	 * @param nodeVISUALID
	 *        is the visual ID of the class
	 * @return a command to execute
	 */

	protected Command dropElementWithContainedElementIntoDiagram(DropObjectsRequest dropRequest, Element semanticObject, int nodeVISUALID) {
		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
		Element owner = (Element)semanticObject.getOwner();
		EditPart ownerEditPart = containmentHelper.findEditPartFor(getViewer().getEditPartRegistry(), owner);
		if(ownerEditPart != null) {
			return containmentHelper.outlineDropContainedClass((PackageableElement)semanticObject, getViewer(), getDiagramPreferencesHint(), dropRequest.getLocation(), ((GraphicalEditPart)getHost()).getNotationView());
		} else {
			return new ICommandProxy(getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), semanticObject));
		}

	}

	/**
	 * Use to drop a class from the diagram to the nestedClassifierCompartment
	 * 
	 * @param dropRequest
	 *        is the request for the drop, never be null
	 * @param droppedElement
	 *        is the class dropped
	 * @param nodeVISUALID
	 *        is the visual ID of the class
	 * @return a command to execute
	 */
	protected Command dropElementWithContainmentLinkIntoContainer(DropObjectsRequest dropRequest, Element droppedElement, int nodeVISUALID) {
		ContainmentHelper containmentHelper = new ContainmentHelper(getEditingDomain());
		CompositeCommand cc = new CompositeCommand(CONTAINED_CLASS_DROP_TO_COMPARTMENT);
		cc = getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation(), droppedElement);

		View droppedView = (View)containmentHelper.findEditPartFor(getViewer().getEditPartRegistry(), droppedElement).getModel();

		containmentHelper.deleteIncomingContainmentLinksFor(cc, droppedView);

		// Delete the dropped element existing outside the compartment
		cc.add(new DeleteCommand(getEditingDomain(), droppedView));
		return new ICommandProxy(cc);
	}



	/**
	 * this method is used to drop an interface realization into the class diagra�
	 * 
	 * @param dropRequest
	 *        the drop request
	 * @param semanticLink
	 *        the element that is the interfaceRealization
	 * @param linkVISUALID
	 *        the visualID of the interfaceRealization
	 * @return the command containing the creation of the view for interface realization
	 */
	protected Command dropInterfaceRealization(DropObjectsRequest dropRequest, Element semanticLink, int linkVISUALID) {
		Collection<?> sources = linkmappingHelper.getSource(semanticLink);
		Collection<?> targets = linkmappingHelper.getTarget(semanticLink);
		if(sources.size() == 0 || targets.size() == 0) {
			return UnexecutableCommand.INSTANCE;
		}

		Element source = (Element)sources.toArray()[0];
		Element target = (Element)targets.toArray()[0];
		CompositeCommand cc = new CompositeCommand("");
		dropBinaryLink(cc, source, target, linkVISUALID, dropRequest.getLocation(), semanticLink);
		return new ICommandProxy(cc);
	}


}
