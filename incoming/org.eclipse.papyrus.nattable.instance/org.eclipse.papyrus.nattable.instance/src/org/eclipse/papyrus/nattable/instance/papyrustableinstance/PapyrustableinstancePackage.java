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
package org.eclipse.papyrus.nattable.instance.papyrustableinstance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrustableinstanceFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrustableinstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrustableinstance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/Table/0.8.0/papyrustableinstance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "papyrustableinstance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrustableinstancePackage eINSTANCE = org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrustableinstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl <em>Papyrus Table Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrustableinstancePackageImpl#getPapyrusTableInstance()
	 * @generated
	 */
	int PAPYRUS_TABLE_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Is Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED = 2;

	/**
	 * The feature id for the '<em><b>Filling Java Queries Class Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__FILLING_JAVA_QUERIES_CLASS_NAME = 3;

	/**
	 * The feature id for the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE__TABLE = 4;

	/**
	 * The number of structural features of the '<em>Papyrus Table Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_TABLE_INSTANCE_FEATURE_COUNT = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance <em>Papyrus Table Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Table Instance</em>'.
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance
	 * @generated
	 */
	EClass getPapyrusTableInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getName()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getType()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized <em>Is Synchronized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Synchronized</em>'.
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_IsSynchronized();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getFillingJavaQueriesClassName <em>Filling Java Queries Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Filling Java Queries Class Name</em>'.
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getFillingJavaQueriesClassName()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EAttribute getPapyrusTableInstance_FillingJavaQueriesClassName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table</em>'.
	 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance#getTable()
	 * @see #getPapyrusTableInstance()
	 * @generated
	 */
	EReference getPapyrusTableInstance_Table();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrustableinstanceFactory getPapyrustableinstanceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl <em>Papyrus Table Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrusTableInstanceImpl
		 * @see org.eclipse.papyrus.nattable.instance.papyrustableinstance.impl.PapyrustableinstancePackageImpl#getPapyrusTableInstance()
		 * @generated
		 */
		EClass PAPYRUS_TABLE_INSTANCE = eINSTANCE.getPapyrusTableInstance();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__NAME = eINSTANCE.getPapyrusTableInstance_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__TYPE = eINSTANCE.getPapyrusTableInstance_Type();

		/**
		 * The meta object literal for the '<em><b>Is Synchronized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__IS_SYNCHRONIZED = eINSTANCE.getPapyrusTableInstance_IsSynchronized();

		/**
		 * The meta object literal for the '<em><b>Filling Java Queries Class Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAPYRUS_TABLE_INSTANCE__FILLING_JAVA_QUERIES_CLASS_NAME = eINSTANCE.getPapyrusTableInstance_FillingJavaQueriesClassName();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_TABLE_INSTANCE__TABLE = eINSTANCE.getPapyrusTableInstance_Table();

	}

} //PapyrustableinstancePackage
