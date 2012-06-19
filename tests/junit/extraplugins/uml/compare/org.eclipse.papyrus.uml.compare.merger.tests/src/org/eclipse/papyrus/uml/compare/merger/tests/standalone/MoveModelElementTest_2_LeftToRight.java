package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class MoveModelElementTest_2_LeftToRight extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "moveModelElement_2/";

	@BeforeClass
	public static void init() throws CoreException, IOException {
		AbstractStandaloneCompareTest.init(MODEL_PATH);
	}

	@Test
	@Override
	public void testMergeCommandExecutatibility() throws InterruptedException {
		mergeTest(true);
	}


	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Override
	public void testLastDiffElements(List<DiffElement> diffElements) {
		Assert.assertTrue("The DiffElement is not a DiffGroup", diffElements.size() == 5);
		for(DiffElement current : diffElements) {
			Assert.assertTrue(current instanceof DiffGroup);
			DiffGroup group = (DiffGroup)current;
			Assert.assertTrue("The DiffGroup should contains only 1 DiffElement", group.getSubDiffElements().size() == 1);
			DiffElement element = group.getSubDiffElements().get(0);
			Assert.assertTrue(element instanceof MoveModelElement);
		}
	}
}
