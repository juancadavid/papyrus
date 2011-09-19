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
package org.eclipse.papyrus.sysml.activities.provider;

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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.Optional;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.SysMLItemProviderAdapter;
import org.eclipse.papyrus.sysml.provider.SysmlEditPlugin;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.sysml.activities.Optional} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class OptionalItemProvider extends SysMLItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	/**
	 * This is used to store all the property descriptors for aclass stereotyped with a block.
	 * Derived classes should add descriptors to this vector.
	 */
	protected List<IItemPropertyDescriptor> itemPropertyDescriptorsForparameter;

	/**
	 * Pattern prefix of optional
	 * 
	 * @generated
	 */
	private static Pattern OPTIONAL_PREFIX_PATTERN = Pattern.compile("(optional, |<<optional>>|, optional)");

	/**
	 * Get the prefix pattern of PARAMETER_PREFIX_PATTERN
	 * 
	 * @generated
	 */
	private static Pattern PARAMETER_PREFIX_PATTERN = Pattern.compile("Parameter");

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OptionalItemProvider(AdapterFactory adapterFactory) {
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

			addBase_ParameterPropertyDescriptor(object);
		}

		/**
		 * Handle Parameter stereotyped by Optional
		 */
		if(object instanceof org.eclipse.uml2.uml.Parameter) {
			if(itemPropertyDescriptorsForparameter == null) {
				ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
				final List<IItemPropertyDescriptor> propertyDescriptors = ite.getPropertyDescriptors(this);
				itemPropertyDescriptorsForparameter = new ArrayList<IItemPropertyDescriptor>();
				itemPropertyDescriptorsForparameter.addAll(propertyDescriptors);
			}
			return itemPropertyDescriptorsForparameter;

		}

		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Base Parameter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBase_ParameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_Optional_base_Parameter_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Optional_base_Parameter_feature", "_UI_Optional_type"), ActivitiesPackage.Literals.OPTIONAL__BASE_PARAMETER, true, false, true, null, null, null));
	}

	/**
	 * This returns Optional.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		Object composedImage = overlayImage(object, getResourceLocator().getImage("full/obj16/Optional"));
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
		Optional optional_ = null;

		if(object instanceof org.eclipse.uml2.uml.Parameter) {
			Stereotype ste = ((org.eclipse.uml2.uml.Parameter)object).getAppliedStereotype(SysmlResource.OPTIONAL_ID);
			if(ste != null) {
				IItemLabelProvider ite = (IItemLabelProvider)((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
				String result = ite.getText(object);
				result = OPTIONAL_PREFIX_PATTERN.matcher(result).replaceFirst("");
				return PARAMETER_PREFIX_PATTERN.matcher(result).replaceFirst("Optional");
			}

		}

		if(optional_ == null) {
			optional_ = (Optional)object;
		}

		return getString("_UI_Optional_type");
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

		/**
		 * Handle Parameter stereotyped by Optional
		 */

		if(notification.getFeatureID(org.eclipse.uml2.uml.Parameter.class) != Notification.NO_FEATURE_ID) {
			ItemProviderAdapter ite = ((IComposableAdapterFactory)adapterFactory).getIRootAdapterFactory().getItemProvider(UMLPackage.Literals.PARAMETER);
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
