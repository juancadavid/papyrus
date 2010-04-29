/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.view;

import java.util.List;

import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.w3c.dom.Node;



/**
 * Abstract Descriptors that contains a list of constraints, has a unique identifier and holds a list of created containers
 */
public class AbstractConstrainedDescriptor {

	/** id of the dialog */
	protected final String id;

	/** list of constraints that applies to the dialog (kind of manipulated element, etc) */
	protected final List<IConstraintDescriptor> constraints;

	/** unparsed content node */
	protected Node contentNode;

	/** boolean that indicates that the content node has not been parsed yet */
	protected boolean unparsed = false;

	/** indicates if the parsing of the content node failed. not used currently, here to handle errors in a better way */
	protected boolean parseFailed = false;

	/** parser of the content node */
	protected final PropertyViewProviderParser parser;

	/**
	 * Creates a new AbstractConstrainedDescriptor.
	 * 
	 */
	public AbstractConstrainedDescriptor(String id, List<IConstraintDescriptor> constraints) {
		this.id = id;
		this.constraints = constraints;
		this.parser = null;
	}

	/**
	 * Creates a new AbstractConstrainedDescriptor.
	 * 
	 */
	public AbstractConstrainedDescriptor(String id, List<IConstraintDescriptor> constraints, Node contentNode, PropertyViewProviderParser parser) {
		this.id = id;
		this.constraints = constraints;
		this.contentNode = contentNode;
		this.parser = parser;
		unparsed = true;
	}

	/**
	 * Returns the list of containers descriptors
	 * 
	 * @return the list of containers descriptors
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return constraints;
	}

	/**
	 * Returns the id of this dialog descriptor
	 * 
	 * @return the id of this dialog descriptor
	 */
	public String getId() {
		return id;
	}

}
