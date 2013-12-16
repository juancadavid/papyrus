/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.robotml.diagram.architecture.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.robotml.diagram.architecture.edit.part.ArchitectureDiagramEditPart;

public class PortPreferencePage extends ArchitectureDiagramNodePreferencePage {

	public static String prefKey = ArchitectureDiagramEditPart.DIAGRAM_ID + "_Port";


	public PortPreferencePage() {
		super();
		setPreferenceKey(ArchitectureDiagramEditPart.DIAGRAM_ID + "_Port"); //$NON-NLS-1$
	}

	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(PreferencesConstantsHelper.getElementConstant(prefKey, PreferencesConstantsHelper.WIDTH), 20);
		store.setDefault(PreferencesConstantsHelper.getElementConstant(prefKey, PreferencesConstantsHelper.HEIGHT), 20);
	}

}
