/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;

/**
 * @generated
 */
public class ConnectorItemSemanticEditPolicy extends SysmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ConnectorItemSemanticEditPolicy() {
		super(SysmlElementTypes.Connector_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(true);
		List<EObject> todestroy = new ArrayList<EObject>();
		todestroy.add(req.getElementToDestroy());
		//cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
		cmd.add(new EMFtoGMFCommandWrapper(new DeleteCommand(getEditingDomain(), todestroy)));
		return getGEFWrapper(cmd.reduce());
		//return getGEFWrapper(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
	}
}