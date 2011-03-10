/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;

import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Table Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#isIsSynchronized <em>Is Synchronized</em>}</li>
 *   <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getFillingJavaQueriesClassName <em>Filling Java Queries Class Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl#getTable <em>Table</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusTableInstanceImpl extends EObjectImpl implements PapyrusTableInstance {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsSynchronized() <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSynchronized()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SYNCHRONIZED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSynchronized() <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSynchronized()
	 * @generated
	 * @ordered
	 */
	protected boolean isSynchronized = IS_SYNCHRONIZED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFillingJavaQueriesClassName() <em>Filling Java Queries Class Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFillingJavaQueriesClassName()
	 * @generated
	 * @ordered
	 */
	protected EList<String> fillingJavaQueriesClassName;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected TableInstance table;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusTableInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrustableinstancePackage.Literals.PAPYRUS_TABLE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSynchronized() {
		return isSynchronized;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSynchronized(boolean newIsSynchronized) {
		boolean oldIsSynchronized = isSynchronized;
		isSynchronized = newIsSynchronized;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED, oldIsSynchronized, isSynchronized));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFillingJavaQueriesClassName() {
		if (fillingJavaQueriesClassName == null) {
			fillingJavaQueriesClassName = new EDataTypeUniqueEList<String>(String.class, this, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_JAVA_QUERIES_CLASS_NAME);
		}
		return fillingJavaQueriesClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableInstance getTable() {
		if (table != null && table.eIsProxy()) {
			InternalEObject oldTable = (InternalEObject)table;
			table = (TableInstance)eResolveProxy(oldTable);
			if (table != oldTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE, oldTable, table));
			}
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableInstance basicGetTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(TableInstance newTable) {
		TableInstance oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE, oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				return getName();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				return getType();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				return isIsSynchronized();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_JAVA_QUERIES_CLASS_NAME:
				return getFillingJavaQueriesClassName();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				if (resolve) return getTable();
				return basicGetTable();
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
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				setType((String)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				setIsSynchronized((Boolean)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_JAVA_QUERIES_CLASS_NAME:
				getFillingJavaQueriesClassName().clear();
				getFillingJavaQueriesClassName().addAll((Collection<? extends String>)newValue);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				setTable((TableInstance)newValue);
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
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				setIsSynchronized(IS_SYNCHRONIZED_EDEFAULT);
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_JAVA_QUERIES_CLASS_NAME:
				getFillingJavaQueriesClassName().clear();
				return;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				setTable((TableInstance)null);
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
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED:
				return isSynchronized != IS_SYNCHRONIZED_EDEFAULT;
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__FILLING_JAVA_QUERIES_CLASS_NAME:
				return fillingJavaQueriesClassName != null && !fillingJavaQueriesClassName.isEmpty();
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE__TABLE:
				return table != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", isSynchronized: ");
		result.append(isSynchronized);
		result.append(", fillingJavaQueriesClassName: ");
		result.append(fillingJavaQueriesClassName);
		result.append(')');
		return result.toString();
	}

} //PapyrusTableInstanceImpl
