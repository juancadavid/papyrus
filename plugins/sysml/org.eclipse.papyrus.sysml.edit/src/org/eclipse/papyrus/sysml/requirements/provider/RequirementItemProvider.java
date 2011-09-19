/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.requirements.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.requirements.Requirement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class RequirementItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This is used to store all the property descriptors for aclass stereotyped with a block.
	 * Derived classes should add descriptors to this vector.
	 */
	protected List<IItemPropertyDescriptor> itemPropertyDescriptorsForclass;

	/**
	 * Pattern prefix of requirement
	 * 
	 * @generated
	 */
	private static Pattern REQUIREMENT_PREFIX_PATTERN = Pattern.compile("(requirement, |<<requirement>>|, requirement)");

	/**
	 * Get the prefix pattern of CLASS_PREFIX_PATTERN
	 * 
	 * @generated
	 */
	private static Pattern CLASS_PREFIX_PATTERN = Pattern.compile("Class");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequirementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTextPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addDerivedPropertyDescriptor(object);
			addDerivedFromPropertyDescriptor(object);
			addSatisfiedByPropertyDescriptor(object);
			addRefinedByPropertyDescriptor(object);
			addTracedToPropertyDescriptor(object);
			addVerifiedByPropertyDescriptor(object);
			addMasterPropertyDescriptor(object);
			addBase_ClassPropertyDescriptor(object);
		}

		/**
		 * Handle Class stereotyped by Requirement
		 */
		if(object instanceof org.eclipse.uml2.uml.Class) {
			if(itemPropertyDescriptorsForclass == null) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
				final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);
				itemPropertyDescriptorsForclass = new ArrayList<IItemPropertyDescriptor>();
				itemPropertyDescriptorsForclass.addAll(propertyDescriptors);
			}
			return itemPropertyDescriptorsForclass;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTextPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_text_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_text_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__TEXT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_id_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_id_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__ID, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Derived feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDerivedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_derived_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_derived_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__DERIVED, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Derived From feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDerivedFromPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_derivedFrom_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_derivedFrom_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__DERIVED_FROM, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Satisfied By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSatisfiedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_satisfiedBy_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_satisfiedBy_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__SATISFIED_BY, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Refined By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRefinedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_refinedBy_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_refinedBy_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__REFINED_BY, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Traced To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTracedToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_tracedTo_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_tracedTo_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__TRACED_TO, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Verified By feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVerifiedByPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_verifiedBy_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_verifiedBy_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__VERIFIED_BY, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Master feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMasterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_master_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_master_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__MASTER, false, false, false, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Base Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Requirement_base_Class_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Requirement_base_Class_feature", "_UI_Requirement_type"), RequirementsPackage.Literals.REQUIREMENT__BASE_CLASS, true, false, true, null, null, null));
	}

	/**
	 * This returns Requirement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Requirement"));
		if(object instanceof NamedElement) {
			ComposedImage aux = new ComposedImage(Collections.singletonList(composedImage));
			return (Object)composeVisibilityImage(object, aux);
		}
		return composedImage;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		/**
		 * Handle Stereotype item and stereoted element
		 */
		Requirement requirement_ = null;

		if(object instanceof org.eclipse.uml2.uml.Class) {
			Stereotype ste = ((org.eclipse.uml2.uml.Class)object).getAppliedStereotype(SysmlResource.REQUIREMENT_ID);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
				String result = ite.getText(object);
				result = REQUIREMENT_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return CLASS_PREFIX_PATTERN.matcher(result).replaceFirst("Requirement");
			}

		}

		if(requirement_ == null) {
			requirement_ = (Requirement)object;
		}

		String label = ((Requirement)requirement_).getId();
		return label == null || label.length() == 0 ? getString("_UI_Requirement_type") : getString("_UI_Requirement_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch(notification.getFeatureID(Requirement.class)) {
		case RequirementsPackage.REQUIREMENT__TEXT:
		case RequirementsPackage.REQUIREMENT__ID:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}

		/**
		 * Handle Class stereotyped by Requirement
		 */

		if(notification.getFeatureID(org.eclipse.uml2.uml.Class.class) != Notification.NO_FEATURE_ID) {
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.CLASS);
			ite.notifyChanged(notification);
			return;

		}

		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SysmlEditPlugin.INSTANCE;
	}
}
