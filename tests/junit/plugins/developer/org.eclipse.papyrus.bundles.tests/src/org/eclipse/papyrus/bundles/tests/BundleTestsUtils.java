package org.eclipse.papyrus.bundles.tests;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.runtime.InternalPlatform;
import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.launch.EquinoxFactory;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.feature.Feature;
import org.eclipse.pde.internal.core.ifeature.IFeature;
import org.eclipse.pde.internal.core.ifeature.IFeatureChild;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.ui.internal.ide.AboutInfo;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class BundleTestsUtils {

	// This version number should be changed at each release
	public static final String PAPYRUS_VERSION = "0.9.0"; //$NON-NLS-1$

	public static final String INCUBATION = "(Incubation)"; //$NON-NLS-1$

	public static final String VENDOR_NAME = "Eclipse Modeling Project"; //$NON-NLS-1$

	public static final String BUNDLE_NAME = "Bundle-Name"; //$NON-NLS-1$

	public static final String BUNDLE_VENDOR = "Bundle-Vendor"; //$NON-NLS-1$

	public static final String BUNDLE_VERSION = "Bundle-Version"; //$NON-NLS-1$

	public static final String PAPYRUS_PREFIX = "org.eclipse.papyrus."; //$NON-NLS-1$

	public static final String BUNDLE_REQUIREDEXECUTIONENVIRONMENT = "Bundle-RequiredExecutionEnvironment"; //$NON-NLS-1$

	public static final String BUNDLE_IMPORT_PACKAGE = "Import-Package"; //$NON-NLS-1$

	public static final String JAVA_VERSION_5 = "J2SE-1.5"; //$NON-NLS-1$

	public static final String REQUIRE_BUNDLE = "Require-Bundle"; //$NON-NLS-1$

	private BundleTestsUtils() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @return the Bundle with a name beginning by {@link #PAPYRUS_PREFIX}
	 */
	public static List<Bundle> getPapyrusBundles() {
		final List<Bundle> papyrusBundle = new ArrayList<Bundle>();
		BundleContext context = InternalPlatform.getDefault().getBundleContext();
		org.osgi.framework.Bundle[] bundles = context.getBundles();
		for(int i = 0; i < bundles.length; i++) {
			String currentName = bundles[i].getSymbolicName();
			if(currentName.startsWith(PAPYRUS_PREFIX)) {
				papyrusBundle.add(bundles[i]);
			}
		}
		EquinoxFactory factory = new EquinoxFactory();

		return papyrusBundle;
	}

	/**
	 * 
	 * @param bundle
	 *        a bundle
	 * @return
	 *         <code>true</code> if the bundle represents a Java Project
	 */
	public static boolean isJavaProject(final Bundle bundle) {
		//we are looking for folders "org/eclipse/papyrus" that contains classes. If not, it is not a Java project 
		URL res = bundle.getResource("org/eclipse/papyrus"); //$NON-NLS-1$
		return res != null;
	}

	/**
	 * 
	 * @return
	 *         the list of the Papyrus features
	 */
	public static List<Feature> getPapyrusFeature() {
		final List<Feature> features = new ArrayList<Feature>();
		org.eclipse.pde.internal.core.FeatureModelManager manager = PDECore.getDefault().getFeatureModelManager();
		IFeatureModel[] models2 = manager.getModels();
		for(IFeatureModel iFeatureModel : models2) {
			final IFeature feature = iFeatureModel.getFeature();
			final String id = feature.getId();
			if(id.contains("papyrus")) { //$NON-NLS-1$
				features.add((Feature)feature);
			}
		}
		return features;
	}
}