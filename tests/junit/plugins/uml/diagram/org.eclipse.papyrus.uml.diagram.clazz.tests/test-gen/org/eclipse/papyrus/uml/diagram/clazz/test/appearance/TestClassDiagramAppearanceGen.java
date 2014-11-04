/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * This file has been generated automatically in the Papyrus Test Framework.
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.test.appearance;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.junit.framework.classification.GeneratedTest;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InformationItemEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.appearance.AppearanceNodeTest;
import org.junit.Test;

/**
 * The Class TestClassDiagramAppearanceGen.
 */
public class TestClassDiagramAppearanceGen extends AppearanceNodeTest {

	@Override
	public GraphicalEditPart getContainerEditPart() {
		return getDiagramEditPart();
	}
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}
	
	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to manage component PrimitiveType.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodePrimitiveTypeEditPart() {
		testAppearance(UMLElementTypes.getElementType(PrimitiveTypeEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Interface.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeInterfaceEditPart() {
		testAppearance(UMLElementTypes.getElementType(InterfaceEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Comment.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeCommentEditPart() {
		testAppearance(UMLElementTypes.getElementType(CommentEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Class.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeClassEditPart() {
		testAppearance(UMLElementTypes.getElementType(ClassEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Enumeration.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeEnumerationEditPart() {
		testAppearance(UMLElementTypes.getElementType(EnumerationEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Component.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeComponentEditPart() {
		testAppearance(UMLElementTypes.getElementType(ComponentEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Package.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodePackageEditPart() {
		testAppearance(UMLElementTypes.getElementType(PackageEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component InformationItem.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeInformationItemEditPart() {
		testAppearance(UMLElementTypes.getElementType(InformationItemEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Model.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeModelEditPartTN() {
		testAppearance(UMLElementTypes.getElementType(ModelEditPartTN.VISUAL_ID));
	}
	/**
	 * Test to manage component DataType.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeDataTypeEditPart() {
		testAppearance(UMLElementTypes.getElementType(DataTypeEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Constraint.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeConstraintEditPart() {
		testAppearance(UMLElementTypes.getElementType(ConstraintEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component TimeObservation.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeTimeObservationEditPart() {
		testAppearance(UMLElementTypes.getElementType(TimeObservationEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component Signal.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeSignalEditPart() {
		testAppearance(UMLElementTypes.getElementType(SignalEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component InstanceSpecification.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeInstanceSpecificationEditPart() {
		testAppearance(UMLElementTypes.getElementType(InstanceSpecificationEditPart.VISUAL_ID));
	}
	/**
	 * Test to manage component DurationObservation.
	 */
	@Test
	@GeneratedTest
	public void testAppearanceNodeDurationObservationEditPart() {
		testAppearance(UMLElementTypes.getElementType(DurationObservationEditPart.VISUAL_ID));
	}
}
