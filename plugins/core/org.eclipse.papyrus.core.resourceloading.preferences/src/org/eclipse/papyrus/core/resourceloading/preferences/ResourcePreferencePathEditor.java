/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Devernay (Atos) laurent.devernay@atos.net
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.preferences;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class ResourcePreferencePathEditor extends ListEditor {

	public ResourcePreferencePathEditor(String name, String labelText, Composite parent) {
		super(name, labelText, parent);
	}

	@Override
	protected String getNewInputObject() {
		String labelText = getLabelText();
		ResourceDialog dialog = new ResourceDialog(getShell(), labelText, SWT.OPEN | SWT.SINGLE);
		if (dialog.open() == ResourceDialog.OK) {
			URI uri = URI.createURI(dialog.getURIText());
			return uri.trimFileExtension().toString();
		}
		return null;
	}
	
    protected String createList(String[] items) {
        StringBuffer path = new StringBuffer("");//$NON-NLS-1$
        for (String item : items) {
        	if (item != null && !"".equals(item)) {
        		path.append(item);
        		path.append(',');
        	}
        }
        if (path.length() > 0) {
        	path.setLength(path.length() - 1);
        }
        return path.toString();
    }

	@Override
	protected void doLoad() {
		if(getList() != null) {
			getList().removeAll();
		}
		super.doLoad();
	}

	@Override
	protected void doLoadDefault() {
		if(getList() != null) {
			getList().removeAll();
		}
		super.doLoadDefault();
	}

    protected String[] parseString(String stringList) {
        return stringList.split(",");
    }

}