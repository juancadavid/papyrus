/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editparts.AppliedStereotypeCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.editparts.AppliedStereotypeMultilinePropertyEditPart;
import org.eclipse.papyrus.diagram.common.editparts.AppliedStereotypePropertyEditPart;
import org.eclipse.papyrus.diagram.common.editparts.AppliedStereotypesCommentEditPart;
import org.eclipse.papyrus.diagram.common.editparts.AppliedStereotypesCommentLinkEditPart;

/**
 * Edit part provider in charge of providing the parts related to stereotype properties Display 
 */
public class StereotypePropertiesEditPartProvider extends AbstractEditPartProvider {

	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public StereotypePropertiesEditPartProvider() {
		super();
		
		nodeMap.put(AppliedStereotypeCompartmentEditPart.ID, AppliedStereotypeCompartmentEditPart.class);
		nodeMap.put(AppliedStereotypePropertyEditPart.ID, AppliedStereotypeMultilinePropertyEditPart.class);
		nodeMap.put(AppliedStereotypesCommentEditPart.ID, AppliedStereotypesCommentEditPart.class);
		edgeMap.put(AppliedStereotypesCommentLinkEditPart.ID, AppliedStereotypesCommentLinkEditPart.class);
		
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View newView = ((IEditPartOperation)operation).getView();
			if(newView == null) {
				return false;
			}

			String graphicalType = newView.getType();

			if((newView instanceof Node) && (!nodeMap.containsKey(graphicalType))) {
				return false;
			}

			if((newView instanceof Edge) && (!edgeMap.containsKey(graphicalType))) {
				return false;
			}
		}

		return super.provides(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	protected Class<?> getNodeEditPartClass(View view) {
		return nodeMap.get(view.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	protected Class<?> getEdgeEditPartClass(View view) {
		return edgeMap.get(view.getType());
	}
}