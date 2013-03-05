/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.validation.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.services.validation.EValidatorAdapter;
import org.eclipse.papyrus.infra.services.validation.ValidationTool;
import org.eclipse.papyrus.infra.services.validation.ValidationUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract validation command
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
abstract public class AbstractValidateCommand extends AbstractTransactionalCommand {

	protected TransactionalEditingDomain domain;

	protected EObject selectedElement;

	/**
	 * Current diagnostic within a validation run
	 */
	protected Diagnostic diagnostic;

	/**
	 * Creates a new ImportLibraryFromRepositoryCommand
	 * 
	 * @param editingDomain
	 *        editing domain that manages the changed objects
	 * @param runnable
	 *        process that executes the modifications
	 * @param label
	 *        the label of the command
	 * @param description
	 *        description of the command
	 */

	public AbstractValidateCommand(String label, TransactionalEditingDomain domain, EObject selectedElement) {
		super(domain, label, Collections.EMPTY_LIST);
		this.domain = domain;
		this.selectedElement = selectedElement;
	}

	/**
	 * @return The resource on which markers should be applied.
	 */
	protected Resource getValidationResource() {
		return ValidationUtils.getValidationResource(selectedElement);
	}

	protected void runValidation(final EObject validateElement) {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		IRunnableWithProgress runValidationWithProgress = new IRunnableWithProgress()
		{

			public void run(final IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException
			{
				try {
					diagnostic = validate(progressMonitor, validateElement);
				}
				finally {
					progressMonitor.done();
				}
			}
		};

		IRunnableWithProgress createMarkersWithProgress = new IRunnableWithProgress()
		{

			public void run(final IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException
			{
				try {
					handleDiagnostic(progressMonitor, diagnostic, validateElement, shell);
				}
				finally {
					progressMonitor.done();
				}
			}
		};

		createMarkersWithProgress = new ValidationTool(validateElement)
			.wrap(createMarkersWithProgress);

		try {
			// runs the operation, and shows progress.
			diagnostic = null;
			new ProgressMonitorDialog(shell).run(true, true, runValidationWithProgress);
			if(diagnostic != null) {
				// don't fork this dialog, i.e. run it in the UI thread. This avoids that the diagrams are constantly refreshing *while*
				// markers/decorations are changing. This greatly enhances update performance. See also bug 400593
				new ProgressMonitorDialog(shell).run(false, true, createMarkersWithProgress);
			}
		} catch (Exception exception) {
			EMFEditUIPlugin.INSTANCE.log(exception);
		}
	}

	/**
	 * This simply executes the command.
	 */
	protected Diagnostic validate(IProgressMonitor progressMonitor, EObject validateElement)
	{
		int validationSteps = 0;
		for(Iterator<?> i = validateElement.eAllContents(); i.hasNext(); i.next()) {
			++validationSteps;
		}

		progressMonitor.beginTask("", validationSteps);
		AdapterFactory adapterFactory =
			domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain)domain).getAdapterFactory() : null;
		Diagnostician diagnostician = createDiagnostician(adapterFactory, progressMonitor);

		BasicDiagnostic diagnostic = diagnostician.createDefaultDiagnostic(validateElement);
		Map<Object, Object> context = diagnostician.createDefaultContext();

		progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object[]{ diagnostician.getObjectLabel(validateElement) }));
		diagnostician.validate(validateElement, diagnostic, context);

		if(progressMonitor.isCanceled()) {
			return null;
		}
		return diagnostic;
	}

	protected Diagnostician createDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor)
	{
		return new Diagnostician() {

			protected EValidatorAdapter validatorAdapter = new EValidatorAdapter();

			@Override
			public String getObjectLabel(EObject eObject) {
				if(adapterFactory != null && !eObject.eIsProxy())
				{
					IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
					if(itemLabelProvider != null) {
						return itemLabelProvider.getText(eObject);
					}
				}
				return super.getObjectLabel(eObject);
			}

			@Override
			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
				progressMonitor.worked(1);

				// copied from superclass, difference: use EValidatorAdapter instead of first value from eValidatorRegistry
				// fix of bug 397518

				boolean circular = context.get(EObjectValidator.ROOT_OBJECT) == eObject;
				boolean result = validatorAdapter.validate(eClass, eObject, diagnostics, context);
				if((result || diagnostics != null) && !circular)
				{
					result &= doValidateContents(eObject, diagnostics, context);
				}
				return result;
			}
		};

	}

	protected void handleDiagnostic(IProgressMonitor monitor, Diagnostic diagnostic, final EObject validateElement, final Shell shell)
	{
		// Do not show a dialog, as in the original version since the user sees the result directly
		// in the model explorer
		Resource resource = getValidationResource();
		// final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		if(resource != null) {
			if(validateElement != null) {
				SubMonitor sub = SubMonitor.convert(monitor, 2);
				
				ValidationTool vt = new ValidationTool(validateElement, resource);
				int markersToCreate = diagnostic.getChildren().size();

				sub.beginTask("Delete existing markers", 1);
				flushDisplayEvents(shell.getDisplay());

				vt.deleteSubMarkers(sub.newChild(1));

				monitor.setTaskName("Create markers (total: " + markersToCreate + " markers) and refresh diagrams"); //$NON-NLS-1$
				flushDisplayEvents(shell.getDisplay());

				vt.createMarkers(diagnostic, sub.newChild(1));
				
				sub.done();
			}
		}
	}

	protected void flushDisplayEvents(Display display) {
		while (display.readAndDispatch());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return (selectedElement != null);
	}
}
