package org.eclipse.papyrus.sysml.modelexplorer.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.service.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.diagram.common.commands.CreateFlowPortWithFlowSpecificationConfigureCommandFactory;

/**
 * <pre>
 * Command handler for FlowPort non atomic creation
 *
 * </pre>
 * @generated
 */
public class FlowPort_NAHandler extends FlowPortHandler {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command buildCommand() {

		if(getCommandContext() == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = getCommandContext().getContainer();
		EReference reference = getCommandContext().getReference();

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		CreateElementRequest createRequest = null;
		if(reference == null) {
			createRequest = new CreateElementRequest(container, getElementTypeToCreate());
		} else {
			createRequest = new CreateElementRequest(container, getElementTypeToCreate(), reference);
		}
		createRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new CreateFlowPortWithFlowSpecificationConfigureCommandFactory());

		// Retrieve create command from the Element Edit service
		ICommand createGMFCommand = provider.getEditCommand(createRequest);
		Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		return emfCommand;
	}
}

