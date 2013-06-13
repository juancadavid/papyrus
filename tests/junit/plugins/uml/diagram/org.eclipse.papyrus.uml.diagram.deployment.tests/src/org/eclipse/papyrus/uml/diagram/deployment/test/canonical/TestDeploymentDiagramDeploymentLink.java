/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.deployment.CreateDeploymentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.junit.Test;

/**
 * The Class TestComponentDiagramLink.
 */
public class TestDeploymentDiagramDeploymentLink extends TestDeploymentLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateDeploymentDiagramCommand();
	}

	/**
	 * Test to manage Deployment
	 */

	@Test
	public void testToManageDeployment() {
		testToManageLink(UMLElementTypes.Node_2008, UMLElementTypes.Artifact_2006, UMLElementTypes.Deployment_4001, UMLElementTypes.Package_2009, true);
	}

}
