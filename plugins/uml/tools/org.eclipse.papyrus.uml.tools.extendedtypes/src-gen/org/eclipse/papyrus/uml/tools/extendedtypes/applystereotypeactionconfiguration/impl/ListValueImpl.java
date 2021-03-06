/**
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ListValueImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ListValueImpl extends FeatureValueImpl implements ListValue {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureValue> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ListValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplyStereotypeActionConfigurationPackage.Literals.LIST_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<FeatureValue> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<FeatureValue>(FeatureValue.class, this, ApplyStereotypeActionConfigurationPackage.LIST_VALUE__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ApplyStereotypeActionConfigurationPackage.LIST_VALUE__VALUES:
			return ((InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ApplyStereotypeActionConfigurationPackage.LIST_VALUE__VALUES:
			return getValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ApplyStereotypeActionConfigurationPackage.LIST_VALUE__VALUES:
			getValues().clear();
			getValues().addAll((Collection<? extends FeatureValue>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ApplyStereotypeActionConfigurationPackage.LIST_VALUE__VALUES:
			getValues().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ApplyStereotypeActionConfigurationPackage.LIST_VALUE__VALUES:
			return values != null && !values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ListValueImpl
