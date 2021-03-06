/*****************************************************************************
 * Copyright (c) 2013, 2014 Cedric Dumoulin, CEA, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 442526
 *
 *****************************************************************************/

package org.eclipse.papyrus.integrationtests.editor;


/**
 * @author cedric dumoulin
 *
 */
public class DiagramCreationException extends ExecutionException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 */
	public DiagramCreationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 * @param cause
	 */
	public DiagramCreationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 */
	public DiagramCreationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 *
	 * @param cause
	 */
	public DiagramCreationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
