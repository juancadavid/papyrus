/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElementFactory;

public class MessageStyleElementFactory extends AbstractModelElementFactory<MessageStyleElementFactory.MessageStyleModelElement> {

	@Override
	protected MessageStyleModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		View view = NotationHelper.findView(sourceElement);
		if (view != null && view instanceof Edge) {
			return new MessageStyleModelElement((Edge) view, context);
		}
		return null;
	}

	@Override
	protected void updateModelElement(MessageStyleModelElement modelElement, Object newSourceElement) {
		View view = NotationHelper.findView(newSourceElement);
		if (!(view instanceof Edge)) {
			throw new IllegalArgumentException("Cannot resolve Edge selection: " + newSourceElement);
		}
		modelElement.source = (Edge) view;
	}

	static class MessageStyleModelElement extends AbstractModelElement {

		protected DataContextElement context;

		protected Edge source;

		public MessageStyleModelElement(Edge source, DataContextElement context) {
			this.context = context;
			this.source = source;
		}

		@Override
		protected IObservable doGetObservable(String propertyPath) {
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
			Style style = null;
			if (context.getName().equals("LineStyle")) {
				style = source.getStyle(NotationPackage.Literals.LINE_STYLE);
			} else if (context.getName().equals("FontStyle")) {
				style = source.getStyle(NotationPackage.Literals.FONT_STYLE);
			}
			if (style != null) {
				EStructuralFeature feature = style.eClass().getEStructuralFeature(propertyPath);
				return new PapyrusObservableValue(style, feature, domain);
			}
			return null;
		}
	}
}
