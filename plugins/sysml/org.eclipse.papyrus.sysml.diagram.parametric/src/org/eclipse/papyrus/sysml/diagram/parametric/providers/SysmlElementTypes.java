/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.resource.ResourcePackage;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.CommentEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.CommentLinkEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConnectorEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ParametricEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.Property2EditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class SysmlElementTypes {

	/**
	 * @generated
	 */
	private SysmlElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Resource_1000 = getElementType("org.eclipse.papyrus.sysml.diagram.parametric.Resource_1000"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ConstraintProperty_2003 = getElementType("org.eclipse.papyrus.sysml.diagram.parametric.ConstraintProperty_2003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_2005 = getElementType("org.eclipse.papyrus.sysml.diagram.parametric.Property_2005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Comment_2006 = getElementType("org.eclipse.papyrus.sysml.diagram.parametric.Comment_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Property_3002 = getElementType("org.eclipse.papyrus.sysml.diagram.parametric.Property_3002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Connector_4001 = getElementType("org.eclipse.papyrus.sysml.diagram.parametric.Connector_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType CommentAnnotatedElement_4002 = getElementType("org.eclipse.papyrus.sysml.diagram.parametric.CommentAnnotatedElement_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if(imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if(element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature)element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if(eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if(eType instanceof EClass && !((EClass)eType).isAbstract()) {
				element = eType;
			}
		}
		if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			if(!eClass.isAbstract()) {
				return SysmlDiagramEditorPlugin.getInstance().getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if(imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if(image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if(imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if(element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if(elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();
			elements.put(Resource_1000, ResourcePackage.eINSTANCE.getResource());
			elements.put(ConstraintProperty_2003, ConstraintsPackage.eINSTANCE.getConstraintProperty());
			elements.put(Property_2005, UMLPackage.eINSTANCE.getProperty());
			elements.put(Comment_2006, UMLPackage.eINSTANCE.getComment());
			elements.put(Property_3002, UMLPackage.eINSTANCE.getProperty());
			elements.put(Connector_4001, UMLPackage.eINSTANCE.getConnector());
			elements.put(CommentAnnotatedElement_4002, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
		}
		return (ENamedElement)elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if(KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Resource_1000);
			KNOWN_ELEMENT_TYPES.add(ConstraintProperty_2003);
			KNOWN_ELEMENT_TYPES.add(Property_2005);
			KNOWN_ELEMENT_TYPES.add(Comment_2006);
			KNOWN_ELEMENT_TYPES.add(Property_3002);
			KNOWN_ELEMENT_TYPES.add(Connector_4001);
			KNOWN_ELEMENT_TYPES.add(CommentAnnotatedElement_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch(visualID) {
		case ParametricEditPart.VISUAL_ID:
			return Resource_1000;
		case ConstraintPropertyEditPart.VISUAL_ID:
			return ConstraintProperty_2003;
		case PropertyEditPart.VISUAL_ID:
			return Property_2005;
		case CommentEditPart.VISUAL_ID:
			return Comment_2006;
		case Property2EditPart.VISUAL_ID:
			return Property_3002;
		case ConnectorEditPart.VISUAL_ID:
			return Connector_4001;
		case CommentLinkEditPart.VISUAL_ID:
			return CommentAnnotatedElement_4002;
		}
		return null;
	}
}