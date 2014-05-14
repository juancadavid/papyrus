package org.eclipse.papyrus.tests.framework.m2t.xtend.templates

import java.util.Calendar
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.uml2.uml.Activity
import org.eclipse.uml2.uml.CallOperationAction
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.InputPin
import org.eclipse.uml2.uml.InstanceSpecification
import org.eclipse.uml2.uml.InstanceValue
import org.eclipse.uml2.uml.Operation
import org.eclipse.uml2.uml.ValuePin

class TestLinkTemplate {

	def static generate(Class clazz) {
		val template = '''
			/*****************************************************************************
			 * Copyright (c) �Calendar.getInstance().get(Calendar.YEAR)� CEA LIST.
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
			package �TemplateQueries.packageRootName(clazz)�.test.canonical;
			
			import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
			import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
			import org.eclipse.papyrus.commands.ICreationCommand;
			
			import �TemplateQueries.packageRootName(clazz)�.test.I�TemplateQueries.getDiagramName(clazz)�TestsConstants;
			import org.eclipse.papyrus.diagram.tests.canonical.�clazz.generalizations.head.general.name�;
			import �TemplateQueries.packageRootName(clazz)�.Create�TemplateQueries.getDiagramName(clazz)�Command;
			import �TemplateQueries.packageRootName(clazz)�.providers.UMLElementTypes;
			�FOR linkEditPart : clazz.ownedAttributes.filter[getAppliedStereotype("utp::SUT") != null].map[
				defaultValue as InstanceValue].map[instance]�
				import �TemplateQueries.packageRootName(clazz)�.edit.parts.�Queries.getStringSlotValue(linkEditPart,
				'editPartClassName')�;
			�ENDFOR�
			import org.eclipse.uml2.uml.UMLPackage;
			import org.junit.Test;
			
			// TODO: Auto-generated Javadoc
			/**
			 * The Class �clazz.name�.
			 */
			public class �clazz.name� extends �clazz.generalizations.head.general.name� {
				
				
				@Override
				protected ICreationCommand getDiagramCommandCreation() {
					return new Create�TemplateQueries.getDiagramName(clazz)�Command();
				}
				 
				@Override
				protected String getProjectName() {
					return I�TemplateQueries.getDiagramName(clazz)�TestsConstants.PROJECT_NAME;
				}
			
				@Override
				protected String getFileName() {
					return I�TemplateQueries.getDiagramName(clazz)�TestsConstants.FILE_NAME;
				}
			
				�FOR Operation testCaseOperation : clazz.ownedOperations.filter[getAppliedStereotype("utp::TestCase") != null]�
					�var instanceSpec = (testCaseOperation.ownedParameters.head.defaultValue as InstanceValue).instance�
					/**
					 * Test to manage component �TemplateQueries.getComponentName(instanceSpec)�.
					 */
					@Test
					public void �testCaseOperation.name�() {
						�testToManageLink(testCaseOperation.methods.head as Activity, clazz)�
					}
				�ENDFOR�
			}	
		'''
		return template;
	}

	static def String testToManageLink(Activity method, Class clazz) {
		val action = method.ownedNodes.head as CallOperationAction
		var source = ((action.arguments.findFirst[name == 'source'] as ValuePin).value as InstanceValue).instance
		var target = ((action.arguments.findFirst[name == 'target'] as ValuePin).value as InstanceValue).instance
		var link = ((action.arguments.findFirst[name == 'link'] as ValuePin).value as InstanceValue).instance
		val sourceType = Queries.getStringSlotValue(source, 'editPartClassName')
		val targetType = Queries.getStringSlotValue(target, 'editPartClassName')
		val linkType = Queries.getStringSlotValue(link, 'editPartClassName')
		
		val container = Queries.getStringSlotValue(Queries.getDefaultValueInstanceSpecification(clazz, 'containerEditPart'), 'editPartClassName')
		val template = '''
			testToManageLink(UMLElementTypes.getElementType(�sourceType�.VISUAL_ID), UMLElementTypes.getElementType(�targetType�.VISUAL_ID), UMLElementTypes.getElementType(�linkType�.VISUAL_ID), UMLElementTypes.getElementType(�container�.VISUAL_ID), true);
		'''
		return template
	}
}
