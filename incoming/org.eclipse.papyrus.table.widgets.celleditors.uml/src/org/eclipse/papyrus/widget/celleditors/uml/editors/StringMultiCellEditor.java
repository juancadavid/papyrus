/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.widget.celleditors.uml.editors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.celleditors.IListener;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.ecore.composite.StringMultiComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A cell editor for String
 */
public class StringMultiCellEditor implements IModelCellEditor {

	/**
	 * The StringMultiComposite
	 */
	private StringMultiComposite<String> composite = null;

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor#activateCell(org.eclipse.swt.widgets.Composite, java.lang.Object,
	 *      org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EObject)
	 * 
	 * @param parent
	 * @param originalValue
	 * @param editHandler
	 * @param feature
	 * @param source
	 * @return
	 */
	public Control activateCell(final Composite parent, final Object originalValue, final IModelCellEditHandler editHandler, final EStructuralFeature feature, final EObject source) {
		composite = new StringMultiComposite<String>(parent, originalValue);

		composite.addCommitListener(new IListener() {

			public void handleEvent() {
				editHandler.commit();
			}
		});
		return composite;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor#getValue()
	 * 
	 * @return
	 */
	public Object getValue() {
		return composite.getValue();
	}
}
