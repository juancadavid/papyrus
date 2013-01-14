/**
 */
package Cpp.impl;

import Cpp.CppNoCodeGen;
import Cpp.CppPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>No Code Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Cpp.impl.CppNoCodeGenImpl#getBase_element <em>Base element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CppNoCodeGenImpl extends EObjectImpl implements CppNoCodeGen {
	/**
	 * The cached value of the '{@link #getBase_element() <em>Base element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_element()
	 * @generated
	 * @ordered
	 */
	protected Element base_element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CppNoCodeGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CppPackage.Literals.CPP_NO_CODE_GEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBase_element() {
		if (base_element != null && base_element.eIsProxy()) {
			InternalEObject oldBase_element = (InternalEObject)base_element;
			base_element = (Element)eResolveProxy(oldBase_element);
			if (base_element != oldBase_element) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CppPackage.CPP_NO_CODE_GEN__BASE_ELEMENT, oldBase_element, base_element));
			}
		}
		return base_element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetBase_element() {
		return base_element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_element(Element newBase_element) {
		Element oldBase_element = base_element;
		base_element = newBase_element;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CppPackage.CPP_NO_CODE_GEN__BASE_ELEMENT, oldBase_element, base_element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CppPackage.CPP_NO_CODE_GEN__BASE_ELEMENT:
				if (resolve) return getBase_element();
				return basicGetBase_element();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CppPackage.CPP_NO_CODE_GEN__BASE_ELEMENT:
				setBase_element((Element)newValue);
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
			case CppPackage.CPP_NO_CODE_GEN__BASE_ELEMENT:
				setBase_element((Element)null);
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
			case CppPackage.CPP_NO_CODE_GEN__BASE_ELEMENT:
				return base_element != null;
		}
		return super.eIsSet(featureID);
	}

} //CppNoCodeGenImpl