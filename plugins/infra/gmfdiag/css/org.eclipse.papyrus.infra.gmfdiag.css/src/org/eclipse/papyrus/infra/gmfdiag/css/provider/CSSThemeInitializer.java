/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.provider;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.IThemeInitializer;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;

/**
 * A class to skip the PreferenceInitializer when the CSS support is enabled.
 * 
 * @author Camille Letavernier
 */
public class CSSThemeInitializer implements IThemeInitializer {

	/**
	 * Return false when the CSS support is enabled
	 */
	public boolean usePreferenceInitializer(View view) {
		return !(view.eResource() instanceof CSSNotationResource);
	}

}