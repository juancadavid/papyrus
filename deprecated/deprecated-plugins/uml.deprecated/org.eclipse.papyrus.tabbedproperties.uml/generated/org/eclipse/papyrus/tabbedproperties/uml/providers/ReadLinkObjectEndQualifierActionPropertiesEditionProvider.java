/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.papyrus.tabbedproperties.uml.components.ElementPropertiesEditionComponent;
import org.eclipse.papyrus.tabbedproperties.uml.components.ReadLinkObjectEndQualifierActionBasePropertiesEditionComponent;
import org.eclipse.papyrus.tabbedproperties.uml.components.ReadLinkObjectEndQualifierActionPropertiesEditionComponent;
import org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ReadLinkObjectEndQualifierActionPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof ReadLinkObjectEndQualifierAction) && (UMLPackage.eINSTANCE.getReadLinkObjectEndQualifierAction() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if(eObject instanceof ReadLinkObjectEndQualifierAction) {
			return new ReadLinkObjectEndQualifierActionPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if(eObject instanceof ReadLinkObjectEndQualifierAction) {
			if(ReadLinkObjectEndQualifierActionBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new ReadLinkObjectEndQualifierActionBasePropertiesEditionComponent(eObject, editing_mode);
			if(ElementPropertiesEditionComponent.COMMENTS_PART.equals(part))
				return new ElementPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}