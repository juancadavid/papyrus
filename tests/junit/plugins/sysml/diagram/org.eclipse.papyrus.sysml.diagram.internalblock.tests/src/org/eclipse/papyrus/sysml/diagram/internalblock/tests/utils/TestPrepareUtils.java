/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramCommandStack;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getEditPart;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getTransactionalEditingDomain;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.utils.GMFCommandUtils;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


public class TestPrepareUtils {

	public static void changeVisibility(View view) throws Exception {
		SetCommand changeVisibilityCommand = new SetCommand(getTransactionalEditingDomain(), view, NotationPackage.eINSTANCE.getView_Visible(), !view.isVisible());
		//getCommandStack().execute(new EMFtoGEFCommandWrapper(changeVisibilityCommand));
		getTransactionalEditingDomain().getCommandStack().execute(changeVisibilityCommand);
	}

	public static EObject createElement(IElementType elementType, View containerView) throws Exception {
		return createElement(elementType, containerView.getElement());
	}

	@SuppressWarnings("unchecked")
	public static EObject createElement(IElementType elementType, EObject container) throws Exception {
		CreateElementRequest createElementRequest = new CreateElementRequest(getTransactionalEditingDomain(), container, elementType);

		EObject typeOwner = EMFCoreUtil.getContainer(container, UMLPackage.eINSTANCE.getPackage());
		
		if (elementType == SysMLElementTypes.ACTOR_PART_PROPERTY) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), typeOwner, UMLElementTypes.ACTOR);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(typeOwner).getEditCommand(createTypeRequest);
			getDiagramCommandStack().execute(new ICommandProxy(createTypeCommand));
			
			// If container is a Property, substitute container by the Property type
			if (container instanceof Property) {
				container = ((Property) container).getType();
				createElementRequest.setContainer(container);
			}
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
		
		} else if (elementType == SysMLElementTypes.PART_PROPERTY) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), typeOwner, SysMLElementTypes.BLOCK);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(typeOwner).getEditCommand(createTypeRequest);
			getDiagramCommandStack().execute(new ICommandProxy(createTypeCommand));
			
			// If container is a Property, substitute container by the Property type
			if (container instanceof Property) {
				container = ((Property) container).getType();
				createElementRequest.setContainer(container);
			}
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
		
		} else if (elementType == SysMLElementTypes.REFERENCE_PROPERTY) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), typeOwner, SysMLElementTypes.BLOCK);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(typeOwner).getEditCommand(createTypeRequest);
			getDiagramCommandStack().execute(new ICommandProxy(createTypeCommand));
			
			// If container is a Property, substitute container by the Property type
			if (container instanceof Property) {
				container = ((Property) container).getType();
				createElementRequest.setContainer(container);
			}
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
				
		} else if (elementType == SysMLElementTypes.VALUE_PROPERTY) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), typeOwner, UMLElementTypes.DATA_TYPE);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(typeOwner).getEditCommand(createTypeRequest);
			getDiagramCommandStack().execute(new ICommandProxy(createTypeCommand));
			
			// If container is a Property, substitute container by the Property type
			if (container instanceof Property) {
				container = ((Property) container).getType();
				createElementRequest.setContainer(container);
			}
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
				
		} else if (elementType == SysMLElementTypes.FLOW_PORT_NA) {
			// Create type
			CreateElementRequest createTypeRequest = new CreateElementRequest(getTransactionalEditingDomain(), typeOwner, SysMLElementTypes.FLOW_SPECIFICATION);
			ICommand createTypeCommand = ElementEditServiceUtils.getCommandProvider(typeOwner).getEditCommand(createTypeRequest);
			getDiagramCommandStack().execute(new ICommandProxy(createTypeCommand));
			
			// If container is a Property, substitute container by the Property type
			if (container instanceof Property) {
				container = ((Property) container).getType();
				createElementRequest.setContainer(container);
			}
			createElementRequest.getParameters().put(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getTypedElement_Type(), GMFCommandUtils.getCommandEObjectResult(createTypeCommand)));
				
		}
		
		ICommand createElementCommand = ElementEditServiceUtils.getCommandProvider(container).getEditCommand(createElementRequest);
		getDiagramCommandStack().execute(new ICommandProxy(createElementCommand));
		
		return GMFCommandUtils.getCommandEObjectResult(createElementCommand);
	}

	public static void setBlockEncapsulated(final Element block) throws Exception {
		AbstractTransactionalCommand setCommand = new AbstractTransactionalCommand(getTransactionalEditingDomain(), "Set Block isEncapsulated", null) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Block blockApp = UMLUtil.getStereotypeApplication(block, Block.class);
				blockApp.setIsEncapsulated(true);
				return CommandResult.newOKCommandResult(block);
			}
		};
		getDiagramCommandStack().execute(new ICommandProxy(setCommand));
	}
	
	public static EObject createLink(IElementType elementType, EObject source, EObject target) throws Exception {
		CreateRelationshipRequest createRelationshipRequest = new CreateRelationshipRequest(getTransactionalEditingDomain(), source, target, elementType);
		
		ICommand createRelationshipCommand = ElementEditServiceUtils.getCommandProvider(elementType).getEditCommand(createRelationshipRequest);
		getDiagramCommandStack().execute(new ICommandProxy(createRelationshipCommand));
		
		return GMFCommandUtils.getCommandEObjectResult(createRelationshipCommand);
	}
	
	public static EObject createConnectorLink(final EncapsulatedClassifier container, final ConnectableElement sourceRole, final Property sourcePartWithPort, final ConnectableElement targetRole, final Property targetPartWithPort) throws Exception {
		
		AbstractTransactionalCommand createConnectorCommand = new AbstractTransactionalCommand(getTransactionalEditingDomain(), "Create connector", null) {
			
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Connector connector = container.createOwnedConnector("ConnectorTest");
				
				ConnectorEnd connectorEndSrc = connector.createEnd();
				connectorEndSrc.setRole(sourceRole);
				connectorEndSrc.setPartWithPort(sourcePartWithPort);
				
				ConnectorEnd connectorEndTgt = connector.createEnd();
				connectorEndTgt.setRole(targetRole);
				connectorEndTgt.setPartWithPort(targetPartWithPort);
				
				return CommandResult.newOKCommandResult(connector);
			}
			
		};

		getDiagramCommandStack().execute(new ICommandProxy(createConnectorCommand));
		
		return GMFCommandUtils.getCommandEObjectResult(createConnectorCommand);
	}
	
	public static View createGraphicalNode(IElementType elementType, String graphicalType, View containerView) throws Exception {
		EObject newObject = createElement(elementType, containerView);

		// Add view
		ViewDescriptor viewDescriptor = new ViewDescriptor(new SemanticAdapter(newObject, null), Node.class, graphicalType, ViewUtil.APPEND, true, Activator.DIAGRAM_PREFERENCES_HINT);
		CreateCommand createViewCommand = new CreateCommand(getTransactionalEditingDomain(), viewDescriptor, containerView);
		getDiagramCommandStack().execute(new ICommandProxy(createViewCommand));

		EReference[] erefs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> views = (Collection<View>)EMFCoreUtil.getReferencers(newObject, erefs);

		return (View)views.toArray()[0];
	}
	
	public static View createGraphicalNode(IElementType elementType, EObject semanticContainer, String graphicalType, View containerView) throws Exception {

		EObject newObject = createElement(elementType, semanticContainer);

		// Add view
		ViewDescriptor viewDescriptor = new ViewDescriptor(new SemanticAdapter(newObject, null), Node.class, graphicalType, ViewUtil.APPEND, true, Activator.DIAGRAM_PREFERENCES_HINT);
		CreateCommand createViewCommand = new CreateCommand(getTransactionalEditingDomain(), viewDescriptor, containerView);
		getDiagramCommandStack().execute(new ICommandProxy(createViewCommand));

		EReference[] erefs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> views = (Collection<View>)EMFCoreUtil.getReferencers(newObject, erefs);

		return (View)views.toArray()[0];
	}
	
	public static View createGraphicalLink(IElementType elementType, String graphicalType, View containerView, EditPart sourceEP, EditPart targetEP) throws Exception {
		CreateConnectionViewRequest request = createConnectionRequest(elementType, sourceEP, targetEP);

		Command command = targetEP.getCommand(request);
		Assert.assertNotNull("Command to create graphical link should not be null", command);
		Assert.assertTrue("Command should be executable", command.canExecute());

		getDiagramCommandStack().execute(command);

		IAdaptable viewAdapter = (IAdaptable)request.getNewObject();
		View newView = (View)viewAdapter.getAdapter(View.class);
		Assert.assertNotNull("View should not be null", newView);

		EReference[] erefs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> views = (Collection<View>)EMFCoreUtil.getReferencers(newView, erefs);

		return (View)views.toArray()[0];

	}
	
	public static CreateConnectionViewRequest createConnectionRequest(IElementType type, EditPart source, EditPart target) {
		CreateConnectionViewRequest connectionRequest = CreateViewRequestFactory.getCreateConnectionRequest(type, Activator.DIAGRAM_PREFERENCES_HINT);

		connectionRequest.setSourceEditPart(null);
		connectionRequest.setTargetEditPart(source);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_START);
		source.getCommand(connectionRequest);

		// Now, setup the request in preparation to get the
		// connection end
		// command.
		connectionRequest.setSourceEditPart(source);
		connectionRequest.setTargetEditPart(target);
		connectionRequest.setType(RequestConstants.REQ_CONNECTION_END);
		return connectionRequest;
	}
	

	public static View dropFromModelExplorer(IElementType elementType, View containerView) throws Exception {
		EObject newObject = createElement(elementType, containerView);
		return dropFromModelExplorer(newObject, containerView);
	}

	public static View dropFromModelExplorer(EObject eObject, View containerView) throws Exception {

		// Find container EditPart (for command creation)
		EditPart containerEditPart = getEditPart(containerView);

		// Prepare drop request
		DropObjectsRequest dropRequest = new DropObjectsRequest();
		ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(eObject);
		dropRequest.setObjects(list);
		dropRequest.setLocation(new Point(20, 20));

		// Get drop command
		Command command = containerEditPart.getCommand(dropRequest);
		getDiagramCommandStack().execute(command);

		EReference[] erefs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> views = (Collection<View>)EMFCoreUtil.getReferencers(eObject, erefs);

		return (View)views.toArray()[0];
	}
}
