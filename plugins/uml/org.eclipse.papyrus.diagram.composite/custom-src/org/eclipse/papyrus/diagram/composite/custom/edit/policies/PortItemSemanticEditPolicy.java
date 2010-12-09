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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.composite.custom.edit.command.ConnectorCreateCommand;
import org.eclipse.papyrus.diagram.composite.custom.edit.command.RoleBindingCreateCommand;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * <pre>
 * This class provides a custom edit policy used to replace the SEMANTIC_ROLE 
 * generated for the Port element (when used in CompositeStructure Diagram)
 * </pre>
 */
public class PortItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.composite.edit.policies.PortItemSemanticEditPolicy {

	/**
	 * <pre>
	 * Forbid direct destruction of Port in case the graphical parent is not
	 * the semantic parent.  
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		EObject graphicalParent = ((GraphicalEditPart)getHost().getParent()).resolveSemanticElement();
		EObject semanticParent = req.getElementToDestroy().eContainer();

		if(graphicalParent != semanticParent) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getDestroyElementCommand(req);
	}

	/**
	 * <pre>
	 * Calls a custom creation command to allow the creation of a Connector connected to a Port
	 * on its source end. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Connector_4013 == req.getElementType()) {
			return getGEFWrapper(new ConnectorCreateCommand(req, req.getSource(), null));
		}
		if(UMLElementTypes.Dependency_4017 == req.getElementType()) {
			return getGEFWrapper(new RoleBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}

	/**
	 * <pre>
	 * Calls a custom creation command to allow the creation of a Connector connected to a Port
	 * on its target end. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if(UMLElementTypes.Connector_4013 == req.getElementType()) {
			return getGEFWrapper(new ConnectorCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if(UMLElementTypes.Dependency_4017 == req.getElementType()) {
			return getGEFWrapper(new RoleBindingCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}
}
