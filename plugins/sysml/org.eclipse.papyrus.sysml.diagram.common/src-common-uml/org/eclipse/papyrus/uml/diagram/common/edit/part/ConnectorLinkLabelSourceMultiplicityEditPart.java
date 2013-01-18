/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.edit.part;

import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.LinkLabelDragEditPolicy;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * Edit Part for link label showing {@link Connector} source {@link ConnectorEnd} multiplicity.
 */
public class ConnectorLinkLabelSourceMultiplicityEditPart extends AbstractElementLabelEditPart {

	/** Constructor */
	public ConnectorLinkLabelSourceMultiplicityEditPart(View view) {
		super(view);
		addSnapBackLocation();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new LinkLabelDragEditPolicy());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getKeyPoint() {
		return ConnectionLocator.SOURCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject getParserElement() {
		EObject resolveSemanticElement = resolveSemanticElement();
		if(resolveSemanticElement instanceof Connector) {
			Connector connector = (Connector)resolveSemanticElement;
			if((getNotationView() != null) && (ViewUtil.getContainerView(getNotationView()) != null)) {
				View owner = ViewUtil.getContainerView(getNotationView());
				
				if((connector != null) && (connector.getEnds().size() == 2)) {
					return connector.getEnds().get(0);
				}
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isEditable() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabelRole() {
		return "SourceMultiplicity"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	public String getIconPathRole() {
		return ""; //$NON-NLS-1$
	}
}