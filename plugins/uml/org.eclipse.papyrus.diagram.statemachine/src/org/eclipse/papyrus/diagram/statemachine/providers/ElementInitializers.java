package org.eclipse.papyrus.diagram.statemachine.providers;

import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class ElementInitializers {

	/**
	 * Custom code
	 * 
	 * @param self
	 * @return
	 */
	private static String getName(org.eclipse.uml2.uml.Element self) {
		return NamedElementHelper.EINSTANCE.getNewUMLElementName(self
				.getOwner(), self.eClass());

	}

	/**
	 * @generated
	 */
	public static void init_Region_3000(Region instance) {
		try {
			Object value_0 = name_Region_3000(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Pseudostate_3004(Pseudostate instance) {
		try {
			Object value_0 = name_Pseudostate_3004(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_FinalState_3005(FinalState instance) {
		try {
			Object value_0 = name_FinalState_3005(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_State_3006(State instance) {
		try {
			Object value_0 = name_State_3006(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_Transition_5000(Transition instance) {
		try {
			Object value_0 = name_Transition_5000(instance);
			instance.setName((String) value_0);
		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static void init_StateMachine_2000(StateMachine instance) {
		try {
			Object value_0 = name_StateMachine_2000(instance);
			instance.setName((String) value_0);
			Region newInstance_1_0 = UMLFactory.eINSTANCE.createRegion();
			instance.getRegions().add(newInstance_1_0);
			Object value_1_0_0 = name_region_StateMachine_2000(newInstance_1_0);
			newInstance_1_0.setName((String) value_1_0_0);

		} catch (RuntimeException e) {
			UMLDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	private static String name_Region_3000(Region self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Pseudostate_3004(Pseudostate self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_FinalState_3005(FinalState self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_State_3006(State self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_Transition_5000(Transition self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_region_StateMachine_2000(Region self) {
		return getName(self);
	}

	/**
	 * @generated
	 */
	private static String name_StateMachine_2000(StateMachine self) {
		return getName(self);
	}

}
