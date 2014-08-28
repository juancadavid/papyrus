/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.common.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * DO not modify manually, this class was generated by a visual editor
 *
 */
public class AbstractChooseElement extends Dialog {

	protected Object result;

	protected Shell shlChooseElement;
	protected FilteredTree filtercontrol = null;

	protected Button btnSelect;

	protected Button btnCancel;

	/**
	 * Create the dialog.
	 *
	 * @param parent
	 * @param style
	 */
	public AbstractChooseElement(Shell parent, int style) {
		super(parent, SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 *
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlChooseElement.open();
		shlChooseElement.layout();
		Display display = getParent().getDisplay();
		while (!shlChooseElement.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	protected void createContents() {
		org.eclipse.swt.graphics.Rectangle rect = Display.getDefault().getBounds();

		shlChooseElement = new Shell(getParent(), getStyle());
		shlChooseElement.setSize(450, 300);
		shlChooseElement.setText("Choose element");
		shlChooseElement.setLayout(new FillLayout(SWT.HORIZONTAL));
		shlChooseElement.setLocation(new Point(rect.x + (rect.width / 2), rect.y + (rect.height / 2) - shlChooseElement.getSize().y));
		Composite contentComposite = new Composite(shlChooseElement, SWT.NONE);
		contentComposite.setLayout(null);

		btnSelect = new Button(contentComposite, SWT.NONE);

		btnSelect.setBounds(353, 235, 68, 23);
		btnSelect.setText("Select");

		btnCancel = new Button(contentComposite, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCancel.setBounds(262, 235, 68, 23);
		btnCancel.setText("Cancel");

		filtercontrol = new FilteredTree(contentComposite, SWT.BORDER, new PatternFilter(), true);
		filtercontrol.setBounds(10, 10, 424, 219);

	}
}
