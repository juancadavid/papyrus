/**
 */
package org.eclipse.papyrus.RobotML;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

// TODO: Auto-generated Javadoc
/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Flow Direction Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLPackage#getDataFlowDirectionKind()
 * @model
 * @generated
 */
public enum DataFlowDirectionKind implements Enumerator {
	/**
	 * The '<em><b>In</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_VALUE
	 * @generated
	 * @ordered
	 */
	IN(0, "in", "in"),

	/**
	 * The '<em><b>Out</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUT_VALUE
	 * @generated
	 * @ordered
	 */
	OUT(1, "out", "out"),

	/**
	 * The '<em><b>Inout</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INOUT_VALUE
	 * @generated
	 * @ordered
	 */
	INOUT(2, "inout", "inout");

	/**
	 * The '<em><b>In</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>In</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IN
	 * @model name="in"
	 * @generated
	 * @ordered
	 */
	public static final int IN_VALUE = 0;

	/**
	 * The '<em><b>Out</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Out</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUT
	 * @model name="out"
	 * @generated
	 * @ordered
	 */
	public static final int OUT_VALUE = 1;

	/**
	 * The '<em><b>Inout</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inout</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INOUT
	 * @model name="inout"
	 * @generated
	 * @ordered
	 */
	public static final int INOUT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Data Flow Direction Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DataFlowDirectionKind[] VALUES_ARRAY =
		new DataFlowDirectionKind[] {
			IN,
			OUT,
			INOUT,
		};

	/**
	 * A public read-only list of all the '<em><b>Data Flow Direction Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DataFlowDirectionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Data Flow Direction Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param literal the literal
	 * @return the data flow direction kind
	 * @generated
	 */
	public static DataFlowDirectionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataFlowDirectionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Flow Direction Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param name the name
	 * @return the by name
	 * @generated
	 */
	public static DataFlowDirectionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataFlowDirectionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Flow Direction Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the value
	 * @return the data flow direction kind
	 * @generated
	 */
	public static DataFlowDirectionKind get(int value) {
		switch (value) {
			case IN_VALUE: return IN;
			case OUT_VALUE: return OUT;
			case INOUT_VALUE: return INOUT;
		}
		return null;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
	private final int value;

	/** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
	private final String name;

	/** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value the value
	 * @param name the name
	 * @param literal the literal
	 * @generated
	 */
	private DataFlowDirectionKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the value
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the name
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->.
	 *
	 * @return the literal
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the string
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //DataFlowDirectionKind
