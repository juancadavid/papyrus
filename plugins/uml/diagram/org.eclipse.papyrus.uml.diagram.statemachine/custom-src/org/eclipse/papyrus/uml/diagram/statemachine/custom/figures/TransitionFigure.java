/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;

public class TransitionFigure extends UMLEdgeFigure {

	/**
	 * Creates a new UMLEdgeFigure.
	 */
	public TransitionFigure() {
		super();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure#resetStyle()
	 */
	@Override
	public void resetStyle() {
		PolylineDecoration dec = new PolylineDecoration();
		dec.setScale(15, 5);
		dec.setLineWidth(1);
		this.setTargetDecoration(dec);
	}
}
