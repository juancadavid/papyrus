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
 *   Atos - Initial API and implementation
 *   Arthur daussy (Atos) arthur.daussy@atos.net - Bug : 365405: [State Machine Diagram] Behaviours (Entry,exit,do) on states should have their own mechanisms
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.listeners;

import java.util.Collections;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * This listener will handle the creation of visual for element for behavior (/do /entry /exit).
 * 
 * @author Arthur Daussy
 * 
 */
public class StateBehaviorsListener extends AbstractModifcationTriggerListener {

	protected static NotificationFilter filter;
	
	@Override
	public NotificationFilter getFilter() {
		if (filter == null){
			filter = NotificationFilter.createFeatureFilter(UMLPackage.Literals.STATE__DO_ACTIVITY).or(NotificationFilter.createFeatureFilter(UMLPackage.Literals.STATE__EXIT)).or(NotificationFilter.createFeatureFilter(UMLPackage.Literals.STATE__ENTRY));
		}
		return filter;
	}


	/**
	 * Handle modification on behavior attribute of state (entry , exit , do activity)
	 * 
	 * @param notif
	 */
	@Override
	protected CompositeCommand getModificationCommand(Notification notif) {
		Request dropRequest = null;
		Request deleteRequest = null;
		if(notif.getEventType() == Notification.SET) {
			Object object = notif.getNewValue();

			Object oldObject = notif.getOldValue();
			final StateEditPart stateEditPart = getContainingEditPart(notif.getNotifier());
			if (stateEditPart != null){
				
				if(object instanceof Behavior) {
					//Get the request to create the editPart
					dropRequest = getCreateRequest(object, stateEditPart);
				}
				//Get the request to delete the editPart
				deleteRequest = getDeleteRequest(oldObject, stateEditPart);
				//handle both request if needed
				CompositeCommand cc = new CompositeCommand("Modification command triggered by modedication of one of the behaviros of selected state");//$NON-NLS-0$
				org.eclipse.gef.commands.Command cmd1 = getCommandFromRequest(dropRequest, stateEditPart);
				/**
				 * Create Command
				 */
				if(cmd1 != null && cmd1.canExecute()) {
					cc.compose(new CommandProxy(cmd1));
				}
				/**
				 * Delete Command
				 */
				org.eclipse.gef.commands.Command cmd2 = getCommandFromRequest(deleteRequest, stateEditPart);
				if(cmd2 != null && cmd2.canExecute()) {
					cc.compose(new CommandProxy(cmd2));
				}
				/**
				 * Refresh layout
				 */
				ChangeBoundsRequest chReq = new ChangeBoundsRequest(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_REFRESH);
				chReq.setEditParts(stateEditPart);
				chReq.setMoveDelta(new Point(0, 0));
				Command cmd3 = stateEditPart.getCommand(chReq);
				if(cmd3 != null && cmd3.canExecute()) {
					cc.compose(new CommandProxy(cmd3));
				}
				return cc;
			}
		}
		return null;
	}

	/**
	 * Handle the request passed in argument
	 * 1. Look for the command
	 * 2. Execute the command
	 * 
	 * @param request
	 */
	protected org.eclipse.gef.commands.Command getCommandFromRequest(Request request, IGraphicalEditPart editPart) {
		if(request != null) {
			return editPart.getCommand(request);
		}
		return null;
	}

	/**
	 * Get the request to delete the EditPart of corresponding behavior
	 * 
	 * @param notif
	 * @param request
	 *        (
	 * @return
	 */
	private Request getDeleteRequest(Object oldObject, StateEditPart stateEditPart) {
		Request request = null;
		//When unset the feature
		if(oldObject instanceof Behavior) {
			Behavior oldBehavior = (Behavior)oldObject;
			IGraphicalEditPart iGrapEditPart = getChildByEObject(oldBehavior, stateEditPart, false);
			if(iGrapEditPart != null) {
				request = new GroupRequest(RequestConstants.REQ_DELETE);
				((GroupRequest)request).setEditParts(iGrapEditPart);
			}
		}
		return request;
	}

	private Request getCreateRequest(Object object, StateEditPart stateEditPart) {
		Request request;
		Behavior behavior = (Behavior)object;
		request = new DropObjectsRequest();
		((DropObjectsRequest)request).setLocation(new Point(1, 1));
		((DropObjectsRequest)request).setObjects(Collections.singletonList(behavior));
		return request;
	}

	/**
	 * Get the containing edit part (stateEditPart)
	 * 
	 * @param oldBehavior
	 * @return
	 */
	protected StateEditPart getContainingEditPart(Object toTest) {
		//If not EObject found return null;
		if(toTest == null && toTest instanceof EObject) {
			return null;
		}
		IGraphicalEditPart found = getChildByEObject((EObject)toTest, getDiagramEditPart(), false);
		if(found instanceof StateEditPart) {
			return (StateEditPart)found;
		}
		return null;
	}




}
