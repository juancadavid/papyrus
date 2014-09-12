/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.umlrt.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.migration.rsa.umlrt.AbstractEvent;
import org.eclipse.papyrus.migration.rsa.umlrt.Capsule;
import org.eclipse.papyrus.migration.rsa.umlrt.CapsulePart;
import org.eclipse.papyrus.migration.rsa.umlrt.Coregion;
import org.eclipse.papyrus.migration.rsa.umlrt.InEvent;
import org.eclipse.papyrus.migration.rsa.umlrt.OutEvent;
import org.eclipse.papyrus.migration.rsa.umlrt.Protocol;
import org.eclipse.papyrus.migration.rsa.umlrt.ProtocolContainer;
import org.eclipse.papyrus.migration.rsa.umlrt.RTConnector;
import org.eclipse.papyrus.migration.rsa.umlrt.RTHistorystate;
import org.eclipse.papyrus.migration.rsa.umlrt.RTPort;
import org.eclipse.papyrus.migration.rsa.umlrt.RTRedefinableElement;
import org.eclipse.papyrus.migration.rsa.umlrt.Trigger;
import org.eclipse.papyrus.migration.rsa.umlrt.UMLRealTimePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.migration.rsa.umlrt.UMLRealTimePackage
 * @generated
 */
public class UMLRealTimeSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static UMLRealTimePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public UMLRealTimeSwitch() {
		if (modelPackage == null) {
			modelPackage = UMLRealTimePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case UMLRealTimePackage.ABSTRACT_EVENT: {
			AbstractEvent abstractEvent = (AbstractEvent) theEObject;
			T result = caseAbstractEvent(abstractEvent);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.CAPSULE: {
			Capsule capsule = (Capsule) theEObject;
			T result = caseCapsule(capsule);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.CAPSULE_PART: {
			CapsulePart capsulePart = (CapsulePart) theEObject;
			T result = caseCapsulePart(capsulePart);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.COREGION: {
			Coregion coregion = (Coregion) theEObject;
			T result = caseCoregion(coregion);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.IN_EVENT: {
			InEvent inEvent = (InEvent) theEObject;
			T result = caseInEvent(inEvent);
			if (result == null) {
				result = caseAbstractEvent(inEvent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.OUT_EVENT: {
			OutEvent outEvent = (OutEvent) theEObject;
			T result = caseOutEvent(outEvent);
			if (result == null) {
				result = caseAbstractEvent(outEvent);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.PROTOCOL: {
			Protocol protocol = (Protocol) theEObject;
			T result = caseProtocol(protocol);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.PROTOCOL_CONTAINER: {
			ProtocolContainer protocolContainer = (ProtocolContainer) theEObject;
			T result = caseProtocolContainer(protocolContainer);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.RT_CONNECTOR: {
			RTConnector rtConnector = (RTConnector) theEObject;
			T result = caseRTConnector(rtConnector);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.RT_HISTORYSTATE: {
			RTHistorystate rtHistorystate = (RTHistorystate) theEObject;
			T result = caseRTHistorystate(rtHistorystate);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.RT_PORT: {
			RTPort rtPort = (RTPort) theEObject;
			T result = caseRTPort(rtPort);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.RT_REDEFINABLE_ELEMENT: {
			RTRedefinableElement rtRedefinableElement = (RTRedefinableElement) theEObject;
			T result = caseRTRedefinableElement(rtRedefinableElement);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case UMLRealTimePackage.TRIGGER: {
			Trigger trigger = (Trigger) theEObject;
			T result = caseTrigger(trigger);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractEvent(AbstractEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capsule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capsule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapsule(Capsule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capsule Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capsule Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapsulePart(CapsulePart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Coregion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Coregion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCoregion(Coregion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInEvent(InEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutEvent(OutEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocol(Protocol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protocol Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protocol Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProtocolContainer(ProtocolContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RT Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RT Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRTConnector(RTConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RT Historystate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RT Historystate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRTHistorystate(RTHistorystate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RT Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RT Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRTPort(RTPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RT Redefinable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RT Redefinable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRTRedefinableElement(RTRedefinableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrigger(Trigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 *
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // UMLRealTimeSwitch
