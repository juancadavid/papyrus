/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.tests.nested;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.metamodel.AttributeOrderChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Package;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractNestedAttributeOrderChangeTest extends AbstractNestedCompareTest {

	private static final String MODEL_PATH = "attributeOrderChange_1/";

	public static void init(final boolean leftToRight) throws CoreException, IOException, ModelMultiException, ServiceException {
		AbstractNestedCompareTest.init(MODEL_PATH, leftToRight);
		AbstractCompareTest.leftElement = (Class)AbstractNestedCompareTest.root.getOwnedMember("OpaqueBehavior1"); //$NON-NLS-1$
		AbstractCompareTest.rightElement = (Class)((Package)root.getPackagedElement("Package1")).getOwnedMember("OpaqueBehavior1"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue(NLS.bind("The number of DiffElement is not correct : we would like {0} DiffElement, and we found {1}", new Object[]{ 1, diffElements.size() }), diffElements.size() == 1);
		final DiffElement diffElement = diffElements.get(0);
		Assert.assertTrue(NLS.bind("The last DiffElement is not a {0}", AttributeOrderChange.class), diffElement instanceof AttributeOrderChange);
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Test
	public void mergeTestAllExecutability() throws InterruptedException {
		super.mergeTestAllExecutability();
	}

	@Override
	@Test
	public void testCommandExecution() throws InterruptedException, IOException {
		super.testCommandExecution();
	}

	@Test
	public void testModificationOnDiFile() {
		super.testModificationOnDiFile(false);
	}


	@Test
	public void testModificationOnNotationFile() {
		super.testModificationOnNotationFile(false);
	}


	@Test
	public void testModificationOnUMLFile() {
		super.testModificationOnUMLFile(true);
		final EList<String> rightLanguages = ((OpaqueBehavior)rightElement).getLanguages();
		final EList<String> leftLanguages = ((OpaqueBehavior)leftElement).getLanguages();
		Assert.assertEquals(3, leftLanguages.size());
		Assert.assertEquals(3, rightLanguages.size());
		for(int i = 0; i < 3; i++) {
			Assert.assertEquals(rightLanguages.get(i), leftLanguages.get(i));
		}
		if(leftToRight) {
			rightLanguages.get(0).equals("C");
			rightLanguages.get(1).equals("C++");
			rightLanguages.get(2).equals("Java");
		} else {
			rightLanguages.get(0).equals("C");
			rightLanguages.get(1).equals("Java");
			rightLanguages.get(2).equals("C++");
		}
	}


	@Override
	@Test
	public void saveTest() throws IOException {
		super.saveTest();
	}

	@Override
	@Test
	public void testResult() throws InterruptedException {
		super.testResult();
	}

	@Override
	@Test
	public void testXMIID() {
		//nothing to do
	}

	@Override
	@Test
	public void testUndo() throws IOException, InterruptedException {
		super.testUndo();
	}

	@Override
	@Test
	public void testRedo() throws IOException, InterruptedException {
		super.testRedo();
	}

	@Test
	public void testOneDiffCommandExecution() throws IOException, InterruptedException {
		super.testOneDiffCommandExecution();
	}

}
