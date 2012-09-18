package org.eclipse.papyrus.uml.compare.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	/** The Constant PLUGIN_ID. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.compare.ui"; //$NON-NLS-1$

	// The shared instance
	/** The plugin. */
	private static Activator plugin;

	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Log error.
	 *
	 * @param e the e
	 */
	public static void logError(Throwable e) {
		logError(Messages.Activator_log_error_message, e);
	}

	/**
	 * Log error.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public static void logError(String message, Throwable e) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, message, e);
		getDefault().getLog().log(status);
	}

	/**
	 * Log info.
	 *
	 * @param message the message
	 */
	public static void logInfo(String message) {
		IStatus status = new Status(IStatus.INFO, PLUGIN_ID, message);
		getDefault().getLog().log(status);
	}


}