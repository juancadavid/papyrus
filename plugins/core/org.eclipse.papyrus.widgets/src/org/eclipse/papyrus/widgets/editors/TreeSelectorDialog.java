/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.editors;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.widgets.Activator;
import org.eclipse.papyrus.widgets.providers.IAdaptableContentProvider;
import org.eclipse.papyrus.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * A Dialog for selecting values. The values are displayed as a Tree. If only
 * some of the values of this Tree should be selectable, you should pass a {@link IHierarchicContentProvider} to this dialog.
 * 
 * @author Camille Letavernier
 * 
 */
public class TreeSelectorDialog extends SelectionDialog implements ITreeSelectorDialog {

	private ILabelProvider labelProvider;

	private ITreeContentProvider contentProvider;

	private TreeViewer treeViewer;

	private Label descriptionLabel;

	private Object input = null;

	private final Set<ICommitListener> commitListeners = new HashSet<ICommitListener>();

	private AbstractObservableValue viewerObservable;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        The parent shell in which this dialog will be opened
	 */
	public TreeSelectorDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Sets the label provider for this dialog
	 * 
	 * @param provider
	 */
	public void setLabelProvider(ILabelProvider provider) {
		labelProvider = provider;
		if(treeViewer != null) {
			treeViewer.setLabelProvider(labelProvider);
		}
	}

	/**
	 * Sets the ContentProvider for this dialog
	 * The ContentProvider may be a {@link IHierarchicContentProvider}
	 * 
	 * @param provider
	 *        The content provider for this dialog. May be a {@link IHierarchicContentProvider}
	 */
	public void setContentProvider(ITreeContentProvider provider) {
		contentProvider = provider;
		if(treeViewer != null) {
			treeViewer.setContentProvider(contentProvider);
			if(treeViewer.getInput() == null) {
				doSetInput();
			}
			List<?> initialSelection = getInitialElementSelections();
			if(!initialSelection.isEmpty()) {
				treeViewer.setSelection(new StructuredSelection(initialSelection.get(0)), true);
			}
		}
		if(contentProvider instanceof ICommitListener) {
			commitListeners.add((ICommitListener)contentProvider);
		}
		if(provider instanceof IChangeListener) {
			getStructuredViewerObservable().addChangeListener((IChangeListener)provider);
		}
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	@Override
	public void create() {
		super.create();

		descriptionLabel = new Label(getDialogArea(), SWT.WRAP);
		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		treeViewer = new TreeViewer(getDialogArea(), SWT.BORDER);
		treeViewer.addFilter(new PatternFilter());

		if(labelProvider != null) {
			treeViewer.setLabelProvider(labelProvider);
		}
		if(contentProvider != null) {
			treeViewer.setContentProvider(contentProvider);
			if(treeViewer.getInput() == null) {
				//It's important that we do this before setting the input
				//This lets it initialize
				getStructuredViewerObservable().setValue(treeViewer);
				doSetInput();
			}

			List<?> initialSelection = getInitialElementSelections();
			if(!initialSelection.isEmpty() && initialSelection.get(0) != null) {
				treeViewer.setSelection(new StructuredSelection(initialSelection.get(0)), true);
			}
		}

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();

				Object selectedElement = null;
				if(selection instanceof IStructuredSelection && !selection.isEmpty()) {
					IStructuredSelection sSelection = (IStructuredSelection)selection;
					selectedElement = sSelection.getFirstElement();
				}

				if(contentProvider instanceof IHierarchicContentProvider) {
					boolean isValidValue = ((IHierarchicContentProvider)contentProvider).isValidValue(selectedElement);
					if(isValidValue) {
						setResult(Collections.singletonList(selectedElement));
					} else {
						setResult(Collections.EMPTY_LIST);
					}
					getOkButton().setEnabled(isValidValue);
				}
			}
		});

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if(getOkButton().isEnabled()) {
					okPressed();
				}
			}

		});

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 300;
		data.minimumWidth = 300;
		treeViewer.getTree().setLayoutData(data);

		if(contentProvider instanceof IGraphicalContentProvider) {
			IGraphicalContentProvider graphicalContentProvider = (IGraphicalContentProvider)contentProvider;

			Composite beforeTreeComposite = new Composite(getDialogArea(), SWT.NONE);
			beforeTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			beforeTreeComposite.setLayout(new FillLayout());
			graphicalContentProvider.createBefore(beforeTreeComposite);

			beforeTreeComposite.moveAbove(treeViewer.getTree());

			Composite afterTreeComposite = new Composite(getDialogArea(), SWT.NONE);
			afterTreeComposite.setLayout(new FillLayout());
			afterTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			graphicalContentProvider.createAfter(afterTreeComposite);
		}

		treeViewer.setSelection(new StructuredSelection(getAdaptedInitialSelection()));

		getShell().setDefaultButton(null);
		getButton(OK).setFocus();
		getShell().setImage(Activator.getDefault().getImage("/icons/papyrus.png")); //$NON-NLS-1$
		getShell().pack();
	}

	/**
	 * Sets the description for this Dialog. The description is displayed on
	 * top of the dialog
	 * 
	 * @param description
	 *        The description for this dialog
	 */
	public void setDescription(String description) {
		descriptionLabel.setText(description);
	}

	/**
	 * Get the TreeViewer used by this dialog
	 * 
	 * @return
	 *         The TreeViewer associated to this dialog
	 */
	protected TreeViewer getViewer() {
		return treeViewer;
	}

	/**
	 * Sets the input object for this dialog's TreeViewer
	 * 
	 * @param input
	 */
	public void setInput(Object input) {
		this.input = input;
	}

	public List<Object> getAdaptedInitialSelection() {
		if(contentProvider instanceof IAdaptableContentProvider) {
			List<Object> result = new LinkedList<Object>();
			for(Object object : getInitialElementSelections()) {
				result.add(((IAdaptableContentProvider)contentProvider).getContainerValue(object));
			}
			return result;
		} else {
			return super.getInitialElementSelections();
		}
	}

	private void doSetInput() {
		if(input == null) {
			//Default non-null input for IStaticContentProvider (input-independent)
			treeViewer.setInput(""); //$NON-NLS-1$
		} else {
			treeViewer.setInput(input);
		}
	}

	@Override
	public void okPressed() {
		for(ICommitListener listener : commitListeners) {
			listener.commit(null);
		}
		super.okPressed();
	}

	public AbstractObservableValue getStructuredViewerObservable() {
		if(viewerObservable == null) {
			viewerObservable = new AbstractObservableValue() {

				public Object getValueType() {
					return StructuredViewer.class;
				}

				@Override
				protected Object doGetValue() {
					return treeViewer;
				}

				@Override
				protected void doSetValue(final Object value) {
					fireValueChange(new ValueDiff() {

						@Override
						public Object getOldValue() {
							return null;
						}

						@Override
						public Object getNewValue() {
							return value;
						}
					});
				}

			};
		}
		return viewerObservable;
	}
}