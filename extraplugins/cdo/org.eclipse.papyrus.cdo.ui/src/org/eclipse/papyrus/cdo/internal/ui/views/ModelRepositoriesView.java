/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.ui.views.ContainerItemProvider;
import org.eclipse.net4j.util.ui.views.ContainerView;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.actions.AbstractRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.AddRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.ConnectRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.CreateFolderAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.DeleteModelAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.DisconnectRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.LinkWithEditorAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.OpenPapyrusModelAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.RemoveRepositoryAction;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.dialogs.PropertyDialogAction;

/**
 * This is the ModelRepositoriesView type. Enjoy.
 */
public class ModelRepositoriesView
		extends ContainerView {

	public final static String ID = "org.eclipse.papyrus.cdo.ui.ModelRepositoriesView"; //$NON-NLS-1$

	public static final int LINK_WITH_EDITOR_PROPERTY = 0x10000;

	private static final String STATE_LINKING = "linkWithEditor";

	private final IInternalPapyrusRepositoryManager repositoryManager;

	private AddRepositoryAction addRepositoryAction;

	private LinkWithEditorAction linkWithEditorAction;

	private AbstractRepositoryAction connectRepositoryAction;

	private AbstractRepositoryAction disconnectRepositoryAction;

	private RemoveRepositoryAction removeRepositoryAction;

	private OpenPapyrusModelAction openModelAction;

	private PropertyDialogAction propertyDialogAction;

	private CreateFolderAction createFolderAction;

	private DeleteModelAction deleteModelAction;

	private boolean isLinkWithEditor;

	private LinkingHelper linkingHelper;

	public ModelRepositoriesView() {
		super();

		repositoryManager = (IInternalPapyrusRepositoryManager) PapyrusRepositoryManager.INSTANCE;
	}

	@Override
	protected IContainer<?> getContainer() {
		return (IContainer<?>) repositoryManager;
	}

	@Override
	public void init(IViewSite site, IMemento memento)
			throws PartInitException {

		super.init(site, memento);

		// link by default
		Boolean linking = (memento == null)
			? Boolean.TRUE
			: memento.getBoolean(STATE_LINKING);
		setLinkWithEditor(!Boolean.FALSE.equals(linking));
	}

	@Override
	public void saveState(IMemento memento) {
		memento.putBoolean(STATE_LINKING, isLinkWithEditor());
		super.saveState(memento);
	}

	public boolean isLinkWithEditor() {
		return isLinkWithEditor;
	}

	public void setLinkWithEditor(boolean link) {
		if (isLinkWithEditor != link) {
			isLinkWithEditor = link;

			if (linkingHelper != null) {
				linkingHelper.setLinkWithEditor(link);
			}

			firePropertyChange(LINK_WITH_EDITOR_PROPERTY);
		}
	}

	@Override
	protected Control createUI(Composite parent) {
		createActions();

		return super.createUI(parent);
	}

	@Override
	protected void createdUI() {
		super.createdUI();

		linkingHelper = new LinkingHelper(getSite(), repositoryManager,
			getViewer());
		linkingHelper.setLinkWithEditor(isLinkWithEditor());

		ISelectionProvider selectionProvider = getSite().getSelectionProvider();
		selectionProvider.addSelectionChangedListener(openModelAction);
		selectionProvider.addSelectionChangedListener(connectRepositoryAction);
		selectionProvider
			.addSelectionChangedListener(disconnectRepositoryAction);
		selectionProvider.addSelectionChangedListener(removeRepositoryAction);
		selectionProvider.addSelectionChangedListener(createFolderAction);
		selectionProvider.addSelectionChangedListener(deleteModelAction);

		// have to create this one after building the UI
		propertyDialogAction = new PropertyDialogAction(getSite(),
			selectionProvider);
		propertyDialogAction
			.setActionDefinitionId(IWorkbenchCommandConstants.FILE_PROPERTIES);
	}

	protected void createActions() {
		addRepositoryAction = new AddRepositoryAction(this);
		linkWithEditorAction = new LinkWithEditorAction(this);
		connectRepositoryAction = new ConnectRepositoryAction(this);
		disconnectRepositoryAction = new DisconnectRepositoryAction(this);
		removeRepositoryAction = new RemoveRepositoryAction(this);
		openModelAction = new OpenPapyrusModelAction(this);
		createFolderAction = new CreateFolderAction(this);
		deleteModelAction = new DeleteModelAction(this);
		
		getViewSite().getActionBars().setGlobalActionHandler(
			ActionFactory.DELETE.getId(), deleteModelAction);

	}

	@Override
	protected void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addRepositoryAction);
		manager.add(linkWithEditorAction);

		super.fillLocalToolBar(manager);
	}

	@Override
	protected void fillContextMenu(IMenuManager manager,
			ITreeSelection selection) {

		manager.add(new GroupMarker("createActions"));

		if (!selection.isEmpty()) {
			Object selected = selection.getFirstElement();

			if (selected instanceof DIModel) {
				manager.add(openModelAction);
				manager.add(deleteModelAction);
			}

			if (selected instanceof IPapyrusRepository) {
				if (((IPapyrusRepository) selected).isConnected()) {
					manager.add(createFolderAction);
				}

				manager.add(connectRepositoryAction);
				manager.add(disconnectRepositoryAction);

				manager.add(removeRepositoryAction);
				manager.add(propertyDialogAction);
			}
		}

		super.fillContextMenu(manager, selection);
	}

	@Override
	protected void doubleClicked(Object object) {
		if (object instanceof DIModel) {
			invoke(openModelAction);
		} else if (object instanceof IPapyrusRepository) {
			invoke(connectRepositoryAction);
		} else {
			super.doubleClicked(object);
		}
	}

	protected void invoke(Action action) {
		if (action.isEnabled()) {
			action.run();
		}
	}

	@Override
	protected ContainerItemProvider<IContainer<Object>> createContainerItemProvider() {
		return new ModelRepositoryItemProvider(getSite().getPage());
	}

}