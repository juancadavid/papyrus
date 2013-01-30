/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class ConstraintCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public ConstraintCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static ConstraintCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new ConstraintCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public ConstraintCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return getNamespace(container);
		}
		return getNamespace(eObject);
	}

	/**
	 * @generated NOT
	 */
	public boolean canExecute() {
		return getElementToEdit() instanceof Namespace;
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		Constraint newElement = UMLFactory.eINSTANCE.createConstraint();

		Namespace owner = (Namespace) getElementToEdit();
		owner.getOwnedRules().add(newElement);

		ElementInitializers.getInstance().init_Constraint_3008(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	protected Namespace getNamespace(EObject element) {
		if(element instanceof Namespace)
			return (Namespace) element;
		
		if(element instanceof Lifeline){
			return ((Lifeline) element).getInteraction();
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Constraint newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}