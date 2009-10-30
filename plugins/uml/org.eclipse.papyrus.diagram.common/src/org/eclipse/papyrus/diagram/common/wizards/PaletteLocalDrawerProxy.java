package org.eclipse.papyrus.diagram.common.wizards;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Proxy class for container entries
 */
public class PaletteLocalDrawerProxy extends PaletteContainerProxy {

	/** label of the drawer */
	protected String label;

	/** id of the drawer */
	protected String id;

	/** icon of the drawer */
	protected String imagePath;

	/**
	 * Creates a new PaletteContainer
	 * 
	 * @param drawer
	 *            the drawer to cache
	 */
	public PaletteLocalDrawerProxy(String name, String id, String imagePath) {
		super(null);
		this.label = name;
		this.id = id;
		this.imagePath = imagePath;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaletteContainer getEntry() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getPluginIconImage(Activator.ID, imagePath);
	}

	/**
	 * Returns the image path
	 * 
	 * @return the image path
	 */
	public String getImagePath() {
		return imagePath;
	}

}
