/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.properties.util.EMFHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEvent;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Helper class for UML
 * 
 * @author Camille Letavernier
 */
public class UMLUtil {

	/**
	 * Retrieve the UML semantic element from the given Object
	 * 
	 * @param source
	 *        The Object to resolve
	 * @return
	 *         The UML semantic element, or null if it couldn't be resolved
	 */
	public static Element resolveUMLElement(Object source) {
		EObject eElement = null;
		if(source instanceof EObject) {
			eElement = (EObject)source;
		}
		if(source instanceof IAdaptable) {
			eElement = (EObject)((IAdaptable)source).getAdapter(EObject.class);
		}

		if(EMFHelper.isInstance(eElement, "Element", umlMetamodel)) { //$NON-NLS-1$
			return (Element)eElement;
		}

		return null;
	}

	/**
	 * Tests if a class is a subclass of another class. The classes are described
	 * by their className, in the UML Metamodel.
	 * 
	 * @param className
	 * @param superclassName
	 * @return
	 *         True if the class className is a subclass of the class superclassName
	 */
	public static boolean isSubClass(String className, String superclassName) {
		EClass eClass = (EClass)umlMetamodel.getEClassifier(className);
		EClass superClass = (EClass)umlMetamodel.getEClassifier(superclassName);
		return superClass.isSuperTypeOf(eClass);
	}

	/**
	 * Retrieve the IGraphicalEditPart from the given Object
	 * 
	 * @param source
	 *        The object to resolve
	 * @return
	 *         The IGraphicalEditPart, or null if it couldn't be resolved
	 */
	public static IGraphicalEditPart resolveEditPart(Object source) {
		if(source instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart)source;
		}

		if(source instanceof IAdaptable) {
			return (IGraphicalEditPart)((IAdaptable)source).getAdapter(IGraphicalEditPart.class);
		}

		return null;
	}

	/**
	 * Retrieve the EditingDomain for the given source object
	 * 
	 * @param source
	 * @return
	 *         The source object's editing domain, or null if it couldn't be found
	 */
	public static EditingDomain resolveEditingDomain(Object source) {
		return AdapterFactoryEditingDomain.getEditingDomainFor(resolveUMLElement(source));
	}

	/**
	 * @return the UML EPackage
	 */
	public static EPackage getUMLMetamodel() {
		return umlMetamodel;
	}

	/**
	 * Search the given stereotype (By name) on the given UML Element.
	 * If the search is not strict, the name may be the qualified name of a
	 * sub-stereotype of an applied stereotype
	 * 
	 * @param umlElement
	 *        The UML Element on which the stereotype is applied
	 * @param stereotypeName
	 *        The qualified name of the stereotype
	 * @param strict
	 *        If set to true, only a stereotype matching the exact qualified name
	 *        will be returned. Otherwise, any subtype of the given stereotype may be
	 *        returned. Note that if more than one stereotype is a substype of the
	 *        given stereotype, the first matching stereotype is returned.
	 * @return
	 *         The first matching stereotype, or null if none was found
	 */
	public static Stereotype getAppliedStereotype(Element umlElement, String stereotypeName, boolean strict) {
		Stereotype stereotype = umlElement.getAppliedStereotype(stereotypeName);
		if(strict || stereotype != null) {
			return stereotype;
		}

		stereotype = umlElement.getApplicableStereotype(stereotypeName);
		if(stereotype == null) {
			return null;
		}

		for(Stereotype appliedStereotype : umlElement.getAppliedStereotypes()) {
			if(getAllSuperStereotypes(appliedStereotype).contains(stereotype)) {
				return appliedStereotype;
			}
		}

		return null;
	}

	/**
	 * Returns a collection of all super stereotypes of the given stereotype
	 * (Including itself)
	 * 
	 * @param stereotype
	 * @return
	 *         A collection of all super stereotypes
	 */
	public static Collection<Stereotype> getAllSuperStereotypes(Stereotype stereotype) {
		Set<Stereotype> result = new HashSet<Stereotype>();
		if(stereotype != null) {
			getAllSuperStereotypes(stereotype, result);
		}
		return result;
	}

	private static void getAllSuperStereotypes(Stereotype stereotype, Set<Stereotype> result) {
		result.add(stereotype);
		for(Classifier superClassifier : stereotype.getGenerals()) {
			if(superClassifier instanceof Stereotype && !result.contains(superClassifier)) {
				getAllSuperStereotypes((Stereotype)superClassifier, result);
			}
		}
	}

	/**
	 * Retrieves the UML Class associated to the given Message
	 * 
	 * @param message
	 * @return the UML Class associated to the given Message
	 */
	public static org.eclipse.uml2.uml.Class getContextClassForMessage(Message message) {
		MessageOccurrenceSpecification receiveEvent = (MessageOccurrenceSpecification)message.getReceiveEvent();

		if(receiveEvent == null) {
			return null;
		}

		return getContextClassForMessageOccurrence(receiveEvent);
	}

	/**
	 * Retrieves the UML Class associated to the given MessageOccurrenceSpecification
	 * 
	 * @param messageOccurrence
	 * @return the UML Class associated to the given MessageOccurrenceSpecification
	 */
	public static org.eclipse.uml2.uml.Class getContextClassForMessageOccurrence(MessageOccurrenceSpecification messageOccurrence) {
		List<Lifeline> lifelines = messageOccurrence.getCovereds();
		if(lifelines.isEmpty()) {
			return null; //We can't find the context
		} else if(lifelines.size() == 1) {
			Lifeline lifeline = lifelines.get(0);
			ConnectableElement element = lifeline.getRepresents();
			if(element == null) {
				return null;
			}
			Type type = element.getType();
			if(type instanceof org.eclipse.uml2.uml.Class) {
				org.eclipse.uml2.uml.Class clazz = (org.eclipse.uml2.uml.Class)type;
				return clazz;
			} else {
				return null; //The type is not a Class
			}
		} else {
			return null; //Too many contexts : which one should we choose ?
		}
	}

	/**
	 * Finds the UML Class associated to the given MessageEvent
	 * 
	 * @param event
	 * @return the Class associated to the given MessageEvent
	 */
	public static Class getContextClassForMessageEvent(MessageEvent event) {
		Collection<EStructuralFeature.Setting> settings = PapyrusEcoreUtils.getUsages(event);
		if(settings.isEmpty()) {
			return null;
		}

		if(settings.size() == 1) {
			EObject referer = settings.iterator().next().getEObject();
			if(referer instanceof MessageOccurrenceSpecification) {
				return UMLUtil.getContextClassForMessageOccurrence((MessageOccurrenceSpecification)referer);
			} else {
				return null;
			}
		}

		MessageOccurrenceSpecification referer = null;
		EObject newReferer = null;

		for(EStructuralFeature.Setting setting : settings) {
			newReferer = setting.getEObject();
			if(!(newReferer instanceof MessageOccurrenceSpecification)) {
				continue;
			}

			if(referer == null || referer == newReferer) {
				referer = (MessageOccurrenceSpecification)newReferer;
			} else {
				referer = null;
				break;
			}
		}

		if(referer == null) {
			return null;
		}

		return UMLUtil.getContextClassForMessageOccurrence(referer);
	}

	/**
	 * Returns an IObservableValue for the given feature and EObject
	 * 
	 * If the EditingDomain is set, the IObservableValue will use the Papyrus ServiceEdit ;
	 * otherwise, a standard EMFObservableValue will be used
	 * 
	 * @param source
	 *        The EObject to observe
	 * @param feature
	 *        The feature to observe
	 * @param domain
	 *        The editing domain on which the commands will be executed. If null, direct
	 *        object modifications will be used.
	 * @return
	 *         The IObservableValue
	 */
	public static IObservableValue getObservableValue(EObject source, EStructuralFeature feature, EditingDomain domain) {
		return domain == null ? EMFProperties.value(feature).observe(source) : new PapyrusObservableValue(source, feature, domain);
	}

	private static EPackage umlMetamodel = UMLPackage.eINSTANCE;
}
