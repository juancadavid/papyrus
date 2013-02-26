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
package org.eclipse.papyrus.diagram.composite.custom.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.edit.parts.DurationObservationNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.DurationObservationStereotypeLabelEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.TimeObservationNameEditPart;
import org.eclipse.papyrus.diagram.composite.edit.parts.TimeObservationStereotypeLabelEditPart;
import org.eclipse.papyrus.diagram.composite.part.UMLVisualIDRegistry;

/**
 * This edit policy replaces the GMF generated edit policy for Observations.
 * In particular it installs {@link ExternalLabelPrimaryDragRoleEditPolicy} on
 * children that are external label.
 * The code generated by GMF can be found in {@link TimeObservationEditPart#createLayoutEditPolicy()}.
 */
public class ObservationLayoutEditPolicy extends LayoutEditPolicy {

	protected EditPolicy createChildEditPolicy(EditPart child) {
		View childView = (View)child.getModel();
		switch(UMLVisualIDRegistry.getVisualID(childView)) {
		case DurationObservationNameEditPart.VISUAL_ID:
		case DurationObservationStereotypeLabelEditPart.VISUAL_ID:
		case TimeObservationNameEditPart.VISUAL_ID:
		case TimeObservationStereotypeLabelEditPart.VISUAL_ID:
			return new ExternalLabelPrimaryDragRoleEditPolicy();
		}
		EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(result == null) {
			result = new NonResizableEditPolicy();
		}
		return result;
	}

	protected Command getMoveChildrenCommand(Request request) {
		return null;
	}

	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}
}