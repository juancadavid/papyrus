/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) vincent.hemery@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.core.resourceloading.util.LoadingUtils;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.swt.widgets.Display;

/**
 * Handler for the load resource action. This actions load a resource in the
 * model set, which is not yet loaded (due to resource loading strategy).
 */
public class LoadHandler extends GraphicalCommandHandler {

	/**
	 * Get the command to load resource of selected model object
	 * 
	 * @see org.eclipse.papyrus.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * @return the load command
	 * @throws ExecutionException
	 */
	protected Command getCommand() throws ExecutionException {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<IGraphicalEditPart> selection = getSelectedElements();
		if(editingDomain != null && editingDomain.getResourceSet() instanceof ModelSet && selection.size() > 0) {
			final ModelSet modelSet = (ModelSet)editingDomain.getResourceSet();
			CompoundCommand command = new CompoundCommand();
			
			List<URI> handledURI = new ArrayList<URI>();
			for(IGraphicalEditPart selPart : selection) {
				View view = (View)((IAdaptable)selPart).getAdapter(View.class);
				if(view != null) {
					EObject sel = view.getElement();
					// check for partially not loaded edge
					if(view instanceof Edge) {
						View target = ((Edge)view).getTarget();
						if(target != null && ViewUtil.resolveSemanticElement(target) == null) {
							// there is a backslash decorator
							EObject linked = target.getElement();
							if(linked != null && linked.eIsProxy()) {
								InternalEObject internal = (InternalEObject)linked;
								final URI uriProxy = internal.eProxyURI().trimFragment();
								final URI uriTrim = uriProxy.trimFileExtension();
								if(!handledURI.contains(uriTrim)) {
									handledURI.add(uriTrim);
									Command cmd = new Command() {

										@Override
										public void redo() {
											ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
											dialog.open();
											IProgressMonitor monitor = dialog.getProgressMonitor();

											LoadingUtils.loadWithAssociatedResources(uriProxy, modelSet, true, monitor);

											monitor.done();
											dialog.close();
										}

										@Override
										public void execute() {
											redo();
										}

										@Override
										public boolean canExecute() {
											return true;
										}
									};
									command.add(cmd);
								}
							}
						}
					}
					if(sel != null && sel.eIsProxy()) {
						InternalEObject internal = (InternalEObject)sel;
						final URI uriProxy = internal.eProxyURI().trimFragment();
						final URI uriTrim = uriProxy.trimFileExtension();
						if(!handledURI.contains(uriTrim)) {
							handledURI.add(uriTrim);
							Command cmd = new Command() {

								@Override
								public void redo() {
									ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
									dialog.open();
									IProgressMonitor monitor = dialog.getProgressMonitor();

									LoadingUtils.loadWithAssociatedResources(uriProxy, modelSet, false, monitor);

									monitor.done();
									dialog.close();
								}

								@Override
								public void execute() {
									redo();
								}

								@Override
								public boolean canExecute() {
									return true;
								}
							};
							command.add(cmd);
						}
					}
				}
			}
			return command;
		}
		return UnexecutableCommand.INSTANCE;
	}

}