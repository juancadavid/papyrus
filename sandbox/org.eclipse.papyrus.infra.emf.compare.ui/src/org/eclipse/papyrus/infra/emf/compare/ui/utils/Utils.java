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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;


/**
 * 
 * This class provides useful methods for the papyrus Viewer for EMF-Compare
 * 
 */
public class Utils {

	private Utils() {
		//nothing to do
	}

	/**
	 * 
	 * @param input
	 *        an input
	 * @param metamodels
	 *        the list of the referenced metamodels
	 * @return
	 *         if the parameter metamodels is <code>null</code>, this method initialied it
	 *         it returns the parameter metamodels filled with the metamodels referenced in the input
	 */
	public static final Collection<EPackage> getMetamodelForCustomization(final Object input, Collection<EPackage> metamodels) {
		if(metamodels == null) {
			metamodels = new HashSet<EPackage>();
		}
		if(input != null) {
			Assert.isTrue(input instanceof ModelCompareInput);
			Resource res = ((ModelCompareInput)input).getLeftResource();
			metamodels.addAll(EMFHelper.getMetamodels(res));
			res = ((ModelCompareInput)input).getRightResource();
			metamodels.addAll(EMFHelper.getMetamodels(res));

			List<DiffElement> diffs = ((ModelCompareInput)input).getDiffAsList();
			for(DiffElement current : diffs) {
				metamodels.add(current.eClass().getEPackage());
			}
		}
		return metamodels;
	}

	
}
