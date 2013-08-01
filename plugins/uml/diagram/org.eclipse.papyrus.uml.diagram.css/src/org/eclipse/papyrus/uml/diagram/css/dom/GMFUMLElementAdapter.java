/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.css.dom;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.css.dom.GMFElementAdapter;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * DOM Element Adapter for UML Elements
 * 
 * Supports applied stereotypes and stereotype properties
 * 
 * @author Camille Letavernier
 * 
 */
public class GMFUMLElementAdapter extends GMFElementAdapter {

	public static final String APPLIED_STEREOTYPES_PROPERTY = "appliedStereotypes"; //$NON-NLS-1$

	/**
	 * The CSS Separator for qualifiers, when we must use CSS ID
	 * When we can use CSS String, we use the standard UML "::" qualifier separator
	 * 
	 * NOTE: Separator "__" does not work
	 */
	public static final String QUALIFIER_SEPARATOR = "--"; //$NON-NLS-1$

	static {
		//UML
		diagramNameMappings.put("CompositeStructure", "CompositeDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("Package", "PackageDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLActivityDiagram", "ActivityDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLClassDiagram", "ClassDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLCommunicationDiagram", "CommunicationDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLComponentDiagram", "ComponentDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLDeploymentDiagram", "DeploymentDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLProfileDiagram", "ProfileDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLSequenceDiagram", "SequenceDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLStateMachineDiagram", "StateMachineDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("UseCase", "UseCaseDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLTimingDiagram", "TimingDiagram"); //$NON-NLS-1$
		diagramNameMappings.put("PapyrusUMLInteractionOverviewDiagram", "InteractionOverviewDiagram"); //$NON-NLS-1$

		//SysML
		diagramNameMappings.put("BlockDefinition", "BlockDiagram");
		diagramNameMappings.put("InternalBlock", "InternalBlockDiagram");
		diagramNameMappings.put("PapyrusSysMLRequirement", "RequirementDiagram");
		diagramNameMappings.put("Parametric", "ParametricDiagram");
	}

	public GMFUMLElementAdapter(View view, ExtendedCSSEngine engine) {
		super(view, engine);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Applied Stereotypes are manipulated as DOM Attributes
	 */
	@Override
	protected String doGetAttribute(String attr) {
		//Semantic properties
		String parentValue = super.doGetAttribute(attr);
		if(parentValue != null) {
			return parentValue;
		}

		if(semanticElement instanceof Element) {
			//Applied stereotypes
			Element currentElement = (Element)semanticElement;
			if(APPLIED_STEREOTYPES_PROPERTY.equals(attr)) {
				List<String> appliedStereotypes = new LinkedList<String>();
				for(Stereotype stereotype : currentElement.getAppliedStereotypes()) {
					appliedStereotypes.add(stereotype.getName());
					appliedStereotypes.add(stereotype.getQualifiedName());
				}
				if(!appliedStereotypes.isEmpty()) {
					return ListHelper.deepToString(appliedStereotypes, " ");
				}
			}

			for(EObject stereotypeApplication : currentElement.getStereotypeApplications()) {
				EStructuralFeature feature = stereotypeApplication.eClass().getEStructuralFeature(attr);
				if(feature != null) {
					Object value = stereotypeApplication.eGet(feature);
					if(value != null) {
						return value.toString();
					}
				}
			}

			if(attr.contains(QUALIFIER_SEPARATOR)) {
				List<String> qualifiers = ListHelper.asList(attr.split(QUALIFIER_SEPARATOR)); //Writable list

				String propertyName = qualifiers.remove(qualifiers.size() - 1); //Last element is the property name
				//Remaining strings can be used to build the Stereotype's qualified name

				String stereotypeName = ListHelper.deepToString(qualifiers, "::");

				Stereotype appliedStereotype = currentElement.getAppliedStereotype(stereotypeName);

				if(appliedStereotype != null) {
					EObject stereotypeApplication = currentElement.getStereotypeApplication(appliedStereotype);
					EStructuralFeature feature = stereotypeApplication.eClass().getEStructuralFeature(propertyName);
					if(feature != null) {
						Object value = stereotypeApplication.eGet(feature);
						if(value != null) {
							return value.toString();
						}
					}
				}
			}
		}

		return null;
	}
}
