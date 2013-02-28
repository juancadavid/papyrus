/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.compare.diff.metamodel.impl.AttributeChangeImpl;
import org.eclipse.emf.compare.util.AdapterUtils;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;
import org.eclipse.swt.graphics.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Value Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#getSubDiffElements <em>Sub Diff Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#getIsHiddenBy <em>Is Hidden By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#isConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#isRemote <em>Remote</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#getLeftElement <em>Left Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeImpl#getRightElement <em>Right Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TaggedValueChangeImpl extends UMLDiffExtensionImpl implements TaggedValueChange {
	/**
	 * The cached value of the '{@link #getSubDiffElements() <em>Sub Diff Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubDiffElements()
	 * @generated
	 * @ordered
	 */
	protected EList<DiffElement> subDiffElements;
	/**
	 * The cached value of the '{@link #getIsHiddenBy() <em>Is Hidden By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsHiddenBy()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDiffExtension> isHiddenBy;
	/**
	 * The default value of the '{@link #isConflicting() <em>Conflicting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConflicting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONFLICTING_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isConflicting() <em>Conflicting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConflicting()
	 * @generated
	 * @ordered
	 */
	protected boolean conflicting = CONFLICTING_EDEFAULT;
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final DifferenceKind KIND_EDEFAULT = DifferenceKind.ADDITION;
	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected DifferenceKind kind = KIND_EDEFAULT;
	/**
	 * The default value of the '{@link #isRemote() <em>Remote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemote()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOTE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isRemote() <em>Remote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemote()
	 * @generated
	 * @ordered
	 */
	protected boolean remote = REMOTE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attribute;
	/**
	 * The cached value of the '{@link #getLeftElement() <em>Left Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftElement()
	 * @generated
	 * @ordered
	 */
	protected EObject leftElement;
	/**
	 * The cached value of the '{@link #getRightElement() <em>Right Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightElement()
	 * @generated
	 * @ordered
	 */
	protected EObject rightElement;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaggedValueChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.TAGGED_VALUE_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getSubDiffElements() {
		if (subDiffElements == null) {
			subDiffElements = new EObjectContainmentEList<DiffElement>(DiffElement.class, this, UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS);
		}
		return subDiffElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDiffExtension> getIsHiddenBy() {
		if (isHiddenBy == null) {
			isHiddenBy = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDiffExtension>(AbstractDiffExtension.class, this, UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY, DiffPackage.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS);
		}
		return isHiddenBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConflicting() {
		return conflicting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferenceKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemote() {
		return remote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemote(boolean newRemote) {
		boolean oldRemote = remote;
		remote = newRemote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_CHANGE__REMOTE, oldRemote, remote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(EAttribute newAttribute) {
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLeftElement() {
		if (leftElement != null && leftElement.eIsProxy()) {
			InternalEObject oldLeftElement = (InternalEObject)leftElement;
			leftElement = eResolveProxy(oldLeftElement);
			if (leftElement != oldLeftElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT, oldLeftElement, leftElement));
			}
		}
		return leftElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetLeftElement() {
		return leftElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftElement(EObject newLeftElement) {
		EObject oldLeftElement = leftElement;
		leftElement = newLeftElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT, oldLeftElement, leftElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRightElement() {
		if (rightElement != null && rightElement.eIsProxy()) {
			InternalEObject oldRightElement = (InternalEObject)rightElement;
			rightElement = eResolveProxy(oldRightElement);
			if (rightElement != oldRightElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT, oldRightElement, rightElement));
			}
		}
		return rightElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRightElement() {
		return rightElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightElement(EObject newRightElement) {
		EObject oldRightElement = rightElement;
		rightElement = newRightElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT, oldRightElement, rightElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage() {
		AdapterFactoryLabelProvider adapterProvider = new AdapterFactoryLabelProvider(AdapterUtils.getAdapterFactory());
		Image labelImage = adapterProvider.getImage(getAttribute());
		return labelImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsHiddenBy()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS:
				return ((InternalEList<?>)getSubDiffElements()).basicRemove(otherEnd, msgs);
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY:
				return ((InternalEList<?>)getIsHiddenBy()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS:
				return getSubDiffElements();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY:
				return getIsHiddenBy();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__CONFLICTING:
				return isConflicting();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__KIND:
				return getKind();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__REMOTE:
				return isRemote();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT:
				if (resolve) return getLeftElement();
				return basicGetLeftElement();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT:
				if (resolve) return getRightElement();
				return basicGetRightElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				getSubDiffElements().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				getIsHiddenBy().addAll((Collection<? extends AbstractDiffExtension>)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__REMOTE:
				setRemote((Boolean)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT:
				setLeftElement((EObject)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT:
				setRightElement((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__REMOTE:
				setRemote(REMOTE_EDEFAULT);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE:
				setAttribute((EAttribute)null);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT:
				setLeftElement((EObject)null);
				return;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT:
				setRightElement((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS:
				return subDiffElements != null && !subDiffElements.isEmpty();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY:
				return isHiddenBy != null && !isHiddenBy.isEmpty();
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__CONFLICTING:
				return conflicting != CONFLICTING_EDEFAULT;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__KIND:
				return kind != KIND_EDEFAULT;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__REMOTE:
				return remote != REMOTE_EDEFAULT;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE:
				return attribute != null;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT:
				return leftElement != null;
			case UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT:
				return rightElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DiffElement.class) {
			switch (derivedFeatureID) {
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS: return DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS;
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY: return DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY;
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__CONFLICTING: return DiffPackage.DIFF_ELEMENT__CONFLICTING;
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__KIND: return DiffPackage.DIFF_ELEMENT__KIND;
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__REMOTE: return DiffPackage.DIFF_ELEMENT__REMOTE;
				default: return -1;
			}
		}
		if (baseClass == AttributeChange.class) {
			switch (derivedFeatureID) {
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE: return DiffPackage.ATTRIBUTE_CHANGE__ATTRIBUTE;
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT: return DiffPackage.ATTRIBUTE_CHANGE__LEFT_ELEMENT;
				case UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT: return DiffPackage.ATTRIBUTE_CHANGE__RIGHT_ELEMENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DiffElement.class) {
			switch (baseFeatureID) {
				case DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS: return UMLDiffPackage.TAGGED_VALUE_CHANGE__SUB_DIFF_ELEMENTS;
				case DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY: return UMLDiffPackage.TAGGED_VALUE_CHANGE__IS_HIDDEN_BY;
				case DiffPackage.DIFF_ELEMENT__CONFLICTING: return UMLDiffPackage.TAGGED_VALUE_CHANGE__CONFLICTING;
				case DiffPackage.DIFF_ELEMENT__KIND: return UMLDiffPackage.TAGGED_VALUE_CHANGE__KIND;
				case DiffPackage.DIFF_ELEMENT__REMOTE: return UMLDiffPackage.TAGGED_VALUE_CHANGE__REMOTE;
				default: return -1;
			}
		}
		if (baseClass == AttributeChange.class) {
			switch (baseFeatureID) {
				case DiffPackage.ATTRIBUTE_CHANGE__ATTRIBUTE: return UMLDiffPackage.TAGGED_VALUE_CHANGE__ATTRIBUTE;
				case DiffPackage.ATTRIBUTE_CHANGE__LEFT_ELEMENT: return UMLDiffPackage.TAGGED_VALUE_CHANGE__LEFT_ELEMENT;
				case DiffPackage.ATTRIBUTE_CHANGE__RIGHT_ELEMENT: return UMLDiffPackage.TAGGED_VALUE_CHANGE__RIGHT_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (conflicting: ");
		result.append(conflicting);
		result.append(", kind: ");
		result.append(kind);
		result.append(", remote: ");
		result.append(remote);
		result.append(')');
		return result.toString();
	}

} //TaggedValueChangeImpl