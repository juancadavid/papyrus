/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen;

import org.eclipse.papyrus.cpp.codegen.utils.GenUtils;
import org.eclipse.uml2.uml.Element;

public class StdStereo {

	public final static String create = "Create";

	public final static String destroy = "Destroy";

	/**
	 * In the UML 2.4 plugin, the Standard profile is split into an L2 and an L3 profile
	 */
	public final static String[] namespaces = {
		"Standard", "StandardProfileL2"
	};

	/**
	 * Check whether a stereotype of the standard profile is applied
	 * 
	 * @param element
	 *        The element to check
	 * @param stdName
	 *        the non qualified name of a stereotype within the standard
	 *        profile
	 * @return
	 */
	public static boolean isApplied(Element element, String stdName) {
		for(String namespace : namespaces) {
			if(GenUtils.hasStereotype(element, namespace + "::" + stdName)) {
				return true;
			}
		}
		return false;
	}
}