/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 * Emilien Perico (Atos Origin) - add tags for links with keywords
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

	public static String ElementImportParser_undefined_value;

	public static String IconStylePreferencePage_cheerful_style;

	public static String IconStylePreferencePage_eclipse_style;

	public static String IconStylePreferencePage_icon_style_group;

	public static String ModelElementSelectionPageMessage;

	public static String UMLNewDiagramFileWizard_RootSelectionPageSelectionTitle;

	public static String UMLNewDiagramFileWizard_RootSelectionPageNoSelectionMessage;

	public static String UMLNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage;

	public static String UMLNewDiagramFileWizard_CreationPageName;

	public static String UMLNewDiagramFileWizard_CreationPageTitle;

	public static String UMLNewDiagramFileWizard_CreationPageDescription;

	public static String UMLNewDiagramFileWizard_RootSelectionPageName;

	public static String UMLNewDiagramFileWizard_RootSelectionPageTitle;

	public static String UMLNewDiagramFileWizard_RootSelectionPageDescription;

	public static String UMLNewDiagramFileWizard_InitDiagramCommand;

	public static String UMLDiagramEditorUtil_CreateDiagramProgressTask;

	public static String UMLDiagramEditorUtil_CreateDiagramCommandLabel;

	public static String UMLInitDiagramFileAction_InitDiagramFileResourceErrorDialogTitle;

	public static String UMLInitDiagramFileAction_InitDiagramFileResourceErrorDialogMessage;

	public static String UMLInitDiagramFileAction_InitDiagramFileWizardTitle;

	public static String UMLNewDiagramFileWizard_DiagramKindTitle;

	public static String UMLNewDiagramFileWizard_DiagramKindDescription;

	public static String RotateAction_rotate_command;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	/** Label to be displayed on {@link org.eclipse.uml2.uml.Abstraction} links */
	public static String AppliedStereotypeLabel_AbstractionTag;

	/** Label to be displayed on {@link org.eclipse.uml2.uml.PackageImport} links */
	public static String AppliedStereotypeLabel_PackageImportTag;

	/** Label to be displayed on {@link org.eclipse.uml2.uml.PackageMerge} links */
	public static String AppliedStereotypeLabel_PackageMergeTag;

	/** Label to be displayed on {@link org.eclipse.uml2.uml.Usage} links */
	public static String AppliedStereotypeLabel_UsageTag;

	// ///////////////////////// Palette Customisation /////////////////////////////////////
	/** Tooltip for the add button */
	public static String PapyrusPaletteCustomizerDialog_AddButtonTooltip;

	/** Tooltip for the remove button */
	public static String PapyrusPaletteCustomizerDialog_RemoveButtonTooltip;

	/** LAbel for the standard group */
	public static String StandardGroup_Label;

	/** label for the palette action in the palette viewer menu */
	public static String Palette_Action_Label;

	/** tooltip for the palette action in the palette viewer menu */
	public static String Palette_Action_Tooltip;

	/** label for the available palettes viewer */
	public static String Available_Palettes;

	/** label for the palette tree viewer */
	public static String Palette_Viewer;

	/** label for the palette name in the wizard */
	public static String Local_Palette_Name;

	/** label for the palette id in the wizard */
	public static String Local_Palette_Id;

	/** label for the editor id in the palette wizard */
	public static String Local_Palette_Editor_Id;

	/** tooltip for the palette name in the palette wizard */
	public static String Local_Palette_Name_Tooltip;

	/** tooltip for the palette id in the palette wizard */
	public static String Local_Palette_Id_Tooltip;

	/** tooltip for the editor id in the palette wizard */
	public static String Local_Palette_Editor_Id_Tooltip;

	/** label for the provider priority in the palette wizard */
	public static String Local_Palette_Priority;

	/** tooltip for the provider priority in the palette wizard */
	public static String Local_Palette_Priority_Tooltip;

	/** label for the advanced button, when advanced are not shown */
	public static String Dialog_Advanced_Button_Closed;

	/** label for the advanced button, when advanced are shown */
	public static String Dialog_Advanced_Button_Opened;

	/** Error message for the wizard page, when priority is not correctly filled */
	public static String Local_Palette_Error_Priority;

	/** Error message for the wizard page, when palette ID is not correctly filled */
	public static String Local_Palette_Error_PaletteId;

	/** Error message for the wizard page, when name is not correctly filled */
	public static String Local_Palette_Error_Name;

	/** Error message for the wizard page, when Editor ID is not correctly filled */
	public static String Local_Palette_Error_EditorId;

	/** Name of the information page */
	public static String Local_Palette_InfoPage_Name;

	/** Title of the information page */
	public static String Local_Palette_InfoPage_Title;

	/** Name of the content page */
	public static String Local_Palette_ContentPage_Name;

	/** Title of the content page */
	public static String Local_Palette_ContentPage_Title;

	/** name of the available tools group */
	public static String Local_Palette_Available_Tools;

	/** tooltip for the show/hide drawer button */
	public static String Local_Palette_ShowDrawers_Tooltip;

	/** tooltip for the show/hide drawer button */
	public static String Local_Palette_ShowTools_Tooltip;

	/** palette preview label */
	public static String Local_Palette_Palette_Preview;

	/** Title for dialog box when palette to delete is not a local palette */
	public static String Dialog_Not_Local_Palette_Title;

	/** Message for dialog box when palette to delete is not a local palette */
	public static String Dialog_Not_Local_Palette_Message;

	/** tooltip for the delete palette button */
	public static String Dialog_Delete_Palette_Tooltip;

	/** tooltip for the create palette button */
	public static String Dialog_Create_Palette_Tooltip;

	/** tooltip for the create drawer button */
	public static String Local_Palette_Create_Drawer_Tooltip;

	/** name of the drawer wizard page */
	public static String Wizard_Drawer_Page_Name;

	/** title of the drawer wizard page */
	public static String Wizard_Drawer_Page_Title;

	/** error on the name in the drawer wizard */
	public static String Wizard_Drawer_Error_Name;

	/** error on the id in the drawer wizard */
	public static String Wizard_Drawer_Error_Id;

	/** error on the icon in the drawer wizard */
	public static String Wizard_Drawer_Error_Icon;

	/** label for the id field */
	public static String Wizard_Drawer_Id;

	/** tooltip for the id field */
	public static String Wizard_Drawer_Id_Tooltip;

	/** label for the name field */
	public static String Wizard_Drawer_Name;

	/** tooltip for the name field */
	public static String Wizard_Drawer_Name_Tooltip;

	/** tooltip for the icon field */
	public static String Wizard_Drawer_Icon_Tooltip;

	/** name for the icon field */
	public static String Wizard_Drawer_Icon;

}
