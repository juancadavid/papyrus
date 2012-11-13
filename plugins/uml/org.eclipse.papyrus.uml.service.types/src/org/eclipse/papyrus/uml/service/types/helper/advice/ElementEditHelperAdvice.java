/*****************************************************************************
 * Copyright (c) 2012 Atos .
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Arthur daussy - arthur.daussy@atos.net - 374607: [model explorer] moving a model element in another model does not move associated diagrams
 * Olivier M�lois - olivier.melois@atos.net - bug 374916
 *
 **/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.adaptor.gmf.MoveOpenableCommand;
import org.eclipse.papyrus.diagram.common.commands.MoveStereotypeApplicationsCommand;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.notation.NotationModel;
import org.eclipse.papyrus.resource.notation.NotationUtils;
import org.eclipse.papyrus.resource.sasheditor.DiModel;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.service.types.Activator;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Element;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;

/**
 * The edit helper advice for all uml element
 * 
 * @author adaussy
 * 
 */
public class ElementEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * This case will handle moving an element from a resource to another (use case : control mode).
	 * This will move into the new resource :
	 * -> The stereotypes linked to this element and its descendant
	 * -> The diagrams linked to this element and its descendant
	 */
	@Override
	protected ICommand getAfterMoveCommand(MoveRequest request) {
		Map<?, ?> elementsToMove = request.getElementsToMove();
		EObject targetContainer = request.getTargetContainer();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(getEditingDomain(targetContainer), "Move related elements to new resource");////$NON-NLS-1$

		for(Object o : elementsToMove.keySet()) {
			EObject sourceEObject = null;
			if(o instanceof EObject) {
				sourceEObject = (EObject)o;
			} else if(o instanceof IAdaptable) {
				sourceEObject = (EObject)((IAdaptable)o).getAdapter(EObject.class);
			}

			if(sourceEObject != null && targetContainer != null && sourceEObject.eResource() != null && targetContainer.eResource() != null) {
				final Resource eResource = sourceEObject.eResource();
				Resource containerEResource = targetContainer.eResource();
				/*
				 * Test if the moving element is going to be in a new resource
				 */
				if(!eResource.equals(containerEResource) && !AdapterFactoryEditingDomain.isControlled(sourceEObject)) {
					/*
					 * Move related diagrams
					 */
					ICommand moveDiagramsCommand = getMoveDiagramsCommand(targetContainer, sourceEObject);
					if(moveDiagramsCommand != null && moveDiagramsCommand.canExecute()) {
						cc.compose(moveDiagramsCommand);
					}
					/*
					 * Move related stereotypes.
					 */
					addAllMoveStereotypeCommand(cc, sourceEObject, targetContainer);
					/*
					 * Move tables.
					 */
					addAllMoveTableCommand(cc, sourceEObject, targetContainer);
				}
			}
		}

		if(!cc.isEmpty()) {
			return cc;
		}

		return null;
	}

	/**
	 * Adds commands to move all tables that might not
	 * 
	 * @param cc
	 *        the compound command to witch the new move commands have to be added.
	 * @param sourceEObject
	 *        the object the user wants to move.
	 * @param .
	 */
	protected void addAllMoveTableCommand(CompositeTransactionalCommand cc, EObject sourceEObject, EObject targetContainer) {

		/*
		 * All the tables in the tree that comes from sourceEObject.
		 */
		Iterable<EObject> allDescendingPapyrusTables = ElementUtil.createDescendantTablesIterable(sourceEObject);

		/*
		 * Trying to move every table.
		 */
		for(EObject descendant : allDescendingPapyrusTables) {
			if(descendant instanceof PapyrusTableInstance) {
				PapyrusTableInstance papyrusTable = (PapyrusTableInstance)descendant;
				this.addMoveTableCommand(cc, papyrusTable, targetContainer);
			}
		}

	}

	/**
	 * Adds a command that moves a table to the composite command.
	 */
	protected void addMoveTableCommand(CompositeTransactionalCommand cc, PapyrusTableInstance papyrusTable, EObject targetContainer) {
		//The command has to move both the table and its table2.
		TableInstance2 papyrusTable2 = papyrusTable.getTable();

		Resource resource = targetContainer.eResource();
		TransactionalEditingDomain editingDomain = getEditingDomain(targetContainer);
		/*
		 * Has the resource been loaded, and is it in read only mode ?
		 */
		if(!resource.isLoaded() || editingDomain.isReadOnly(resource)) {
			return;
		}

		//Getting the right resource so that the table is placed at the right location.
		Resource rightTargetContainerResource = getProperTableContainingResource(targetContainer);
		if(rightTargetContainerResource != null) {
			MoveOpenableCommand mvTabCmd = new MoveOpenableCommand(editingDomain, "moving table", papyrusTable, rightTargetContainerResource);//$NON-NLS-1$
			if(mvTabCmd != null && mvTabCmd.canExecute()) {
				cc.compose(mvTabCmd);
			}
			MoveOpenableCommand mvTab2Cmd = new MoveOpenableCommand(editingDomain, "moving table2", papyrusTable2, rightTargetContainerResource);//$NON-NLS-1$
			if(mvTab2Cmd != null && mvTab2Cmd.canExecute()) {
				cc.compose(mvTab2Cmd);
			}
		}
	}

	protected void addAllMoveStereotypeCommand(CompositeTransactionalCommand cc, final EObject sourceEObject, EObject container) {
		/*
		 * Iterator of all descendant contained in the same resource as the source
		 */
		UnmodifiableIterator<EObject> descendantElementIterator = Iterators.filter(sourceEObject.eAllContents(), new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return input.eResource() != null && input.eResource().equals(sourceEObject.eResource());
			}
		});
		/*
		 * Iterator of the source element
		 */
		UnmodifiableIterator<EObject> elementIterator = Iterators.singletonIterator(sourceEObject);
		/*
		 * unifiedIterator = (elementIterator) U (descendantElementIterator)
		 */
		Iterator<EObject> unifiedIterator = Iterators.concat(elementIterator, descendantElementIterator);
		while(unifiedIterator.hasNext()) {
			/*
			 * Move related diagrams
			 */
			EObject next = unifiedIterator.next();
			ICommand modeStereotypeCommand = getMoveStereotypeCommand(container, next);
			if(modeStereotypeCommand != null && modeStereotypeCommand.canExecute()) {
				cc.compose(modeStereotypeCommand);
			}
		}
	}

	/**
	 * Moves all the stereotype of an element into a new resource
	 * 
	 * @param container
	 * @param sourceEObject
	 * @return
	 */
	protected ICommand getMoveStereotypeCommand(EObject container, EObject obj) {
		if(obj instanceof Element) {
			Element element = (Element)obj;
			EList<EObject> stereotypeApplications = element.getStereotypeApplications();
			if(stereotypeApplications != null && !stereotypeApplications.isEmpty()) {
				Resource eResource = container.eResource();
				if(eResource != null) {
					if(eResource.isLoaded()) {
						return new MoveStereotypeApplicationsCommand(getEditingDomain(container), element, eResource);
					} else {
						return new UnexecutableCommand(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The new containing resource is not loaded"));////$NON-NLS-1$
					}
				}
			}
		}
		return null;
	}

	/**
	 * Moves all the diagrams descending from an element into a new resource.
	 */
	protected ICommand getMoveDiagramsCommand(EObject container, EObject sourceEObject) {
		/*
		 * Get all diagram from source EObject (its diagram and its descendant)
		 */
		List<Diagram> initialDiagrams = NotationUtils.getAllDescendantDiagramsInResource(sourceEObject, getProperDiagramContainingResource(sourceEObject));

		/*
		 * Get the notation model of the container
		 * 1. If not loaded unexecutable command
		 */
		Resource diagramContainer = getProperDiagramContainingResource(container);
		if(diagramContainer == null) {
			return new UnexecutableCommand(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Unable to find a notation model to store diagram elements"));////$NON-NLS-1$
		}
		TransactionalEditingDomain editingDomain = getEditingDomain(container);
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, "Move related diagrams in new resource");////$NON-NLS-1$
		for(Diagram d : initialDiagrams) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Move ");
			stringBuilder.append(d.getName());
			stringBuilder.append("into a new resource");
			cc.compose(new MoveOpenableCommand(editingDomain, stringBuilder.toString(), d, diagramContainer));
		}
		return cc;
	}

	/**
	 * Get the editing domain from an {@link EObject}
	 * 
	 * @param eObject
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain(EObject eObject) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(editingDomain instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain)editingDomain;
		}
		throw new RuntimeException("Unable to retrieve the transactionnal editin domain");////$NON-NLS-1$
	}

	/**
	 * Gets the right associated resource to seek diagrams.
	 */
	protected Resource getProperDiagramContainingResource(EObject eObject) {
		ResourceSet rs = eObject.eResource().getResourceSet();
		Resource rightResource = null;
		if(rs instanceof ModelSet) {
			ModelSet diResourceSet = (ModelSet)rs;
			rightResource = diResourceSet.getAssociatedResource(eObject, NotationModel.NOTATION_FILE_EXTENSION);
		}
		return rightResource;
	}

	/**
	 * Gets the right associated resource to seek tables.
	 */
	protected Resource getProperTableContainingResource(EObject eObject) {
		ResourceSet rs = eObject.eResource().getResourceSet();
		Resource rightResource = null;
		if(rs instanceof ModelSet) {
			ModelSet diResourceSet = (ModelSet)rs;
			rightResource = diResourceSet.getAssociatedResource(eObject, DiModel.DI_FILE_EXTENSION);
		}
		return rightResource;
	}

}