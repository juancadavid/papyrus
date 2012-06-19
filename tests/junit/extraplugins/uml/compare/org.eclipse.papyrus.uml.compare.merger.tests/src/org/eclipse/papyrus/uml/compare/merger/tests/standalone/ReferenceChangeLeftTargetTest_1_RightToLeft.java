package org.eclipse.papyrus.uml.compare.merger.tests.standalone;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.osgi.util.NLS;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ReferenceChangeLeftTargetTest_1_RightToLeft extends AbstractStandaloneCompareTest {

	private static final String MODEL_PATH = "referenceChangeLeftTarget_1/";

	@BeforeClass
	public static void init() throws CoreException, IOException {
		AbstractStandaloneCompareTest.init(MODEL_PATH, false);
	}

	@Test
	@Override
	public void testMergeAllCommandExecutatibility() throws InterruptedException {
		mergeTestAllExecutability(false);
	}

	@Test
	public void testDifferences() throws InterruptedException {
		super.testDifferences();
	}

	@Override
	public void testLastDiffElements(List<DiffElement> diffElements) {
		//There are 2 differences, because it is cross-reference
		Assert.assertTrue("We should find 2 differences", diffElements.size() == 2);
		for(DiffElement current : diffElements) {
			Assert.assertTrue(current instanceof DiffGroup);
			DiffGroup group = (DiffGroup)current;
			Assert.assertTrue("The DiffGroup should contains only 1 DiffElement", group.getSubDiffElements().size() == 1);
			DiffElement diffElement = group.getSubDiffElements().get(0);
			Assert.assertTrue(NLS.bind("The DiffElement is not a {0}", ReferenceChangeLeftTarget.class), diffElement instanceof ReferenceChangeLeftTarget);
		}
	}

}
