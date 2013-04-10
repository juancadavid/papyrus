/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This edit policy replaces the GMF generated edit policy for Port.
 * In particular it installs {@link ExternalLabelPrimaryDragRoleEditPolicy} on
 * children that are external label.
 * The code generated by GMF can be found in {@link PinEditPart#createLayoutEditPolicy()}.
 */
public class PinLayoutEditPolicy extends LayoutEditPolicy {

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		View childView = (View)child.getModel();
		
			return new ExternalLabelPrimaryDragRoleEditPolicy();
	}

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}
}