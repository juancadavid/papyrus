/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.structure.functionmodeling.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.AnalysisFunctionType;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.eastadl.utils.EASTResource;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Analysis Function Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.AnalysisFunctionTypeImpl#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnalysisFunctionTypeImpl extends FunctionTypeImpl implements AnalysisFunctionType {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AnalysisFunctionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case FunctionmodelingPackage.ANALYSIS_FUNCTION_TYPE__PART:
			return getPart();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case FunctionmodelingPackage.ANALYSIS_FUNCTION_TYPE__PART:
			return !getPart().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FunctionmodelingPackage.Literals.ANALYSIS_FUNCTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Image getIcon() {

		if (getBase_Class() != null) {
			Stereotype st = getBase_Class().getAppliedStereotype(EASTResource.ANALYSISFUNCTIONTYPE_ID);
			EList<Image> images = st.getIcons();

			if (isIsElementary()) {
				return images.get(1);
			} else {
				return images.get(0);
			}
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public EList<AnalysisFunctionPrototype> getPart() {
		EList<AnalysisFunctionPrototype> parts = new BasicEList<AnalysisFunctionPrototype>();
		AnalysisFunctionPrototype currentFunctionPrototype;

		if (getBase_Class() != null) {
			// Parse owned Properties
			Iterator<Property> itDep = getBase_Class().getAttributes().iterator();
			while (itDep.hasNext()) {
				Property currentProperty = itDep.next();

				currentFunctionPrototype = UMLUtil.getStereotypeApplication(currentProperty,
						AnalysisFunctionPrototype.class);

				if (currentFunctionPrototype != null) {
					parts.add(currentFunctionPrototype);
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<AnalysisFunctionPrototype>(AnalysisFunctionPrototype.class, parts.size(), parts
				.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isIsElementary() {
		return ((getPart().size() == 0) && (getConnector().size() == 0));
	}
} // AnalysisFunctionTypeImpl
