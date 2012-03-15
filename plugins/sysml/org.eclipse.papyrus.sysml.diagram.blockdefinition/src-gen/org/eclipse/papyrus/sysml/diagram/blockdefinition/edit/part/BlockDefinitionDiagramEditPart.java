/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultContainerNodeEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultCreationEditPolicy;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultXYLayoutEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.DiagramSemanticEditPolicy;

public class BlockDefinitionDiagramEditPart extends DiagramEditPart {

	public BlockDefinitionDiagramEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new DuplicatePasteEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DiagramSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DefaultContainerNodeEditPolicy());
		// installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new DuplicatePasteEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DefaultXYLayoutEditPolicy());

	}
}
