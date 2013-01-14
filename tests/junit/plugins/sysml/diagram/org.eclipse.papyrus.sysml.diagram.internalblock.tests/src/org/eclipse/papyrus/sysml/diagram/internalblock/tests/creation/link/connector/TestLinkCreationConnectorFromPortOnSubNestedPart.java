/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;
import org.junit.BeforeClass;

/**
 * JUnit tests for Connector link creation test (via palette tools).
 */
public class TestLinkCreationConnectorFromPortOnSubNestedPart extends AbstractLinkCreationFromElementTest {

	@BeforeClass
	public static void initSource() throws Exception {
		sourceView = portOnSubNestedPartContainer1_1_1SourceView;
	}

	@BeforeClass
	public static void initToolID() throws Exception {
		toolID = "internalblock.tool.connector";
	}

	@BeforeClass
	public static void initExpectedResults() throws Exception {

		// Initialize source creation results
		isCreationAllowed = new HashMap<View, Boolean>();

		isCreationAllowed.put(blockTargetView, false);

		isCreationAllowed.put(actorPartTargetView, true);
		isCreationAllowed.put(nestedActorPartTargetView, true);

		isCreationAllowed.put(portOnBlockTargetView, true);
		isCreationAllowed.put(portOnPartTargetView, true);
		isCreationAllowed.put(portOnNestedPartTargetView, true);

		isCreationAllowed.put(flowportOnBlockTargetView, true);
		isCreationAllowed.put(flowportOnPartTargetView, true);
		isCreationAllowed.put(flowportOnNestedPartTargetView, true);

		isCreationAllowed.put(partTargetView, true);
		isCreationAllowed.put(nestedPartTargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_2_1TargetView, true);
		isCreationAllowed.put(subNestedPartContainer1_1_2TargetView, true);

		isCreationAllowed.put(propertyTargetView, true);
		isCreationAllowed.put(nestedPropertyTargetView, true);

		isCreationAllowed.put(referenceTargetView, true);
		isCreationAllowed.put(nestedReferenceTargetView, true);

		isCreationAllowed.put(valueTargetView, true);
		isCreationAllowed.put(nestedValueTargetView, true);

		isCreationAllowed.put(commentTargetView, false);
		isCreationAllowed.put(commentCNTargetView, false);
		isCreationAllowed.put(constraintTargetView, false);
		isCreationAllowed.put(constraintCNTargetView, false);

		// Initialize nested property path for tests
		Property part = (Property)partContainer1.getElement();
		Property part2 = (Property)partContainer2.getElement();
		Property nestedPart = (Property)nestedPartContainer1_1.getElement();
		Property nestedPart1_2 = (Property)nestedPartContainer1_2.getElement();
		Property nestedPart2_1 = (Property)nestedPartContainer2_1.getElement();
		List<Property> subNestedPath = Arrays.asList(new Property[] {part, nestedPart});
		List<Property> nestedPath = Arrays.asList(new Property[]{ nestedPart }); 
		List<Property> nestedContainer1_2Path = Arrays.asList(new Property[]{ part2, nestedPart1_2 }); 
		List<Property> nestedContainer2_1Path = Arrays.asList(new Property[]{ nestedPart2_1 });
		List<Property> emptyPath = Collections.emptyList();

		expectedSourceNestedPath = new HashMap<View, List<Property>>();
		expectedTargetNestedPath = new HashMap<View, List<Property>>();

		for(View view : isCreationAllowed.keySet()) {
			expectedSourceNestedPath.put(view, emptyPath);
			expectedTargetNestedPath.put(view, emptyPath);
		}

		expectedSourceNestedPath.put(blockTargetView, subNestedPath);
		expectedSourceNestedPath.put(actorPartTargetView, subNestedPath);
		expectedSourceNestedPath.put(portOnBlockTargetView, subNestedPath);
		expectedSourceNestedPath.put(portOnPartTargetView, subNestedPath);
		expectedSourceNestedPath.put(flowportOnBlockTargetView, subNestedPath);
		expectedSourceNestedPath.put(flowportOnPartTargetView, subNestedPath);
		expectedSourceNestedPath.put(partTargetView, subNestedPath);
		expectedSourceNestedPath.put(propertyTargetView, subNestedPath);
		expectedSourceNestedPath.put(referenceTargetView, subNestedPath);
		expectedSourceNestedPath.put(valueTargetView, subNestedPath);
		
		expectedSourceNestedPath.put(nestedActorPartTargetView, nestedPath);
		expectedSourceNestedPath.put(nestedPartTargetView, nestedPath);
		expectedSourceNestedPath.put(nestedPropertyTargetView, nestedPath);
		expectedSourceNestedPath.put(nestedReferenceTargetView, nestedPath);
		expectedSourceNestedPath.put(nestedValueTargetView, nestedPath);
		
		expectedSourceNestedPath.put(portOnNestedPartTargetView, nestedPath);
		expectedSourceNestedPath.put(flowportOnNestedPartTargetView, nestedPath);
		
		expectedSourceNestedPath.put(subNestedPartContainer1_1_2TargetView, subNestedPath);
		expectedTargetNestedPath.put(subNestedPartContainer1_1_2TargetView, nestedContainer1_2Path);
		expectedSourceNestedPath.put(subNestedPartContainer1_2_1TargetView, Arrays.asList(nestedPart));
		expectedTargetNestedPath.put(subNestedPartContainer1_2_1TargetView, nestedContainer2_1Path);
		
		
		
	}

}