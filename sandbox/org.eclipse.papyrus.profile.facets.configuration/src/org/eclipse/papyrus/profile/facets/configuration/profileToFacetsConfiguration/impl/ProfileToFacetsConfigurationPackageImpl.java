/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfiguration;
import org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfigurationFactory;
import org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfigurationPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfileToFacetsConfigurationPackageImpl extends EPackageImpl implements ProfileToFacetsConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profileToFacetsConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.profile.facets.configuration.profileToFacetsConfiguration.ProfileToFacetsConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProfileToFacetsConfigurationPackageImpl() {
		super(eNS_URI, ProfileToFacetsConfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ProfileToFacetsConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProfileToFacetsConfigurationPackage init() {
		if (isInited) return (ProfileToFacetsConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(ProfileToFacetsConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		ProfileToFacetsConfigurationPackageImpl theProfileToFacetsConfigurationPackage = (ProfileToFacetsConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProfileToFacetsConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProfileToFacetsConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProfileToFacetsConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theProfileToFacetsConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProfileToFacetsConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProfileToFacetsConfigurationPackage.eNS_URI, theProfileToFacetsConfigurationPackage);
		return theProfileToFacetsConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfileToFacetsConfiguration() {
		return profileToFacetsConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProfileToFacetsConfiguration_Profile() {
		return (EReference)profileToFacetsConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileToFacetsConfiguration_BasePackage() {
		return (EAttribute)profileToFacetsConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileToFacetsConfiguration_Header() {
		return (EAttribute)profileToFacetsConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileToFacetsConfiguration_JavaFolder() {
		return (EAttribute)profileToFacetsConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfileToFacetsConfiguration_ModelFolder() {
		return (EAttribute)profileToFacetsConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileToFacetsConfigurationFactory getProfileToFacetsConfigurationFactory() {
		return (ProfileToFacetsConfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		profileToFacetsConfigurationEClass = createEClass(PROFILE_TO_FACETS_CONFIGURATION);
		createEReference(profileToFacetsConfigurationEClass, PROFILE_TO_FACETS_CONFIGURATION__PROFILE);
		createEAttribute(profileToFacetsConfigurationEClass, PROFILE_TO_FACETS_CONFIGURATION__BASE_PACKAGE);
		createEAttribute(profileToFacetsConfigurationEClass, PROFILE_TO_FACETS_CONFIGURATION__HEADER);
		createEAttribute(profileToFacetsConfigurationEClass, PROFILE_TO_FACETS_CONFIGURATION__JAVA_FOLDER);
		createEAttribute(profileToFacetsConfigurationEClass, PROFILE_TO_FACETS_CONFIGURATION__MODEL_FOLDER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(profileToFacetsConfigurationEClass, ProfileToFacetsConfiguration.class, "ProfileToFacetsConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProfileToFacetsConfiguration_Profile(), theUMLPackage.getProfile(), null, "profile", null, 1, 1, ProfileToFacetsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfileToFacetsConfiguration_BasePackage(), ecorePackage.getEString(), "basePackage", null, 1, 1, ProfileToFacetsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfileToFacetsConfiguration_Header(), theEcorePackage.getEString(), "header", null, 0, 1, ProfileToFacetsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfileToFacetsConfiguration_JavaFolder(), ecorePackage.getEString(), "javaFolder", "src-gen", 1, 1, ProfileToFacetsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfileToFacetsConfiguration_ModelFolder(), theEcorePackage.getEString(), "modelFolder", "resources", 1, 1, ProfileToFacetsConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ProfileToFacetsConfigurationPackageImpl