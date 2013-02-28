/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.handlers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.filter.IUmlElementCommandFilter;
import org.eclipse.papyrus.uml.service.types.filter.UmlElementCommandFilter;
import org.eclipse.papyrus.uml.service.types.utils.ICommandContext;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;



/**
 * Default handler for Create command used in the ModelExplorer contextual ("Create new child") menu.
 * 
 */
public abstract class AbstractCreateCommandHandler extends AbstractCommandHandler {

	protected abstract IElementType getElementTypeToCreate();

	protected IUmlElementCommandFilter filter = new UmlElementCommandFilter();

	/** Current createCommand for selection (updated in {@link AbstractCreateCommandHandler#isEnabled()}) */
	protected Command createCommand;

	protected CreateElementRequest createRequest;


	/**
	 * <pre>
	 * 
	 * Build the create command for an element creation in the selected container.
	 * The create command is given by the {@link IElementEditService} of selected 
	 * element.
	 * 
	 * @return the composite creation command for current selection
	 * 
	 * </pre>
	 */
	protected Command buildCommand() {
		ICommandContext commandContext = getCommandContext();
		if(commandContext == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = commandContext.getContainer();

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		ICommand createGMFCommand = provider.getEditCommand(createRequest);
		Command emfCommand = new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(createGMFCommand);
		return emfCommand;
	}

	protected CreateElementRequest buildRequest() {
		ICommandContext commandContext = getCommandContext();
		if(commandContext != null) {
			EObject container = commandContext.getContainer();
			EReference reference = commandContext.getReference();
			boolean nullReference = reference == null;
			return nullReference ? new CreateElementRequest(getEditingDomain(), container, getElementTypeToCreate()) : new CreateElementRequest(getEditingDomain(), container, getElementTypeToCreate(), reference);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.handlers.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return current command (only built here when the stored command is null)
	 */
	@Override
	protected Command getCommand() {
		if(createRequest == null) {
			createRequest = buildRequest();
		}

		if(createCommand == null) {
			createCommand = buildCommand();
		}

		return createCommand;
	}

	protected IWorkbenchPart getActiveWorkbenchPart() {
		IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		return activePart;
	}

	@Override
	public boolean isEnabled() {
		//it is required!
		createRequest = buildRequest();
		createCommand = buildCommand();
		if(!filter.getVisibleCommands().contains(getElementTypeToCreate())) {
			return false;
		}
		return super.isEnabled();
	}

	@Override
	public boolean isVisible() {
		if(!filter.getVisibleCommands().contains(getElementTypeToCreate())) {
			return false;
		}
		return super.isVisible();
	}
}