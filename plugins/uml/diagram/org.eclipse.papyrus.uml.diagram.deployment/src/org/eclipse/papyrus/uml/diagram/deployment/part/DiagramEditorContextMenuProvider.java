/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

	/**
	 * @generated
	 */
	private IWorkbenchPart part;

	/**
	 * @generated
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;

	}

	/**
	 * @generated
	 */
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		try {
			TransactionUtil.getEditingDomain((EObject)getViewer().getContents().getModel()).runExclusive(new Runnable() {

				public void run() {
					ContributionItemService.getInstance().contributeToPopupMenu(DiagramEditorContextMenuProvider.this, part);
					menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);

				}
			});
		} catch (Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError("Error building context menu", e);
		}
	}
}