/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/

package org.eclipse.papyrus.sasheditor.contentprovider.di;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;


/**
 * Interface providing method to manage pages in the Sash Windows system.
 * This interface provide basic access to the Sash Windows system.
 * 
 * @author dumoulin
 */
public interface IPageMngr {
	
	/**
	 * Add a Page identifier to the list of pages, do not open it. 
	 * 
	 * @param page The object identifying the page to add. This object will be passed to the 
	 * {@link IPageModelFactory#createIPageModel(EObject)}. This identifier is stored in the sash model.
	 * It should be a reference on a EMF object identifying the page.
	 */
	public void addPage(EObject pageIdentifier);
	
	/**
	 * Remove the page from the SashWindows system and from the list of page.
	 * The page will not be available anymore.
	 * @param pageIdentifier The object identifying the page
	 */
	public void removePage(EObject pageIdentifier);

	/**
	 * Close the page corresponding to the identifier.
	 * The identifier is removed from the Sash Windows, but not from the list of pages.
	 * @param pageIdentifier The object identifying the page
	 */
	public void closePage(EObject pageIdentifier);
	

	/**
	 * Open a Page corresponding to the identifier. If the page is not in the list of pages, add it.
	 * The identifier is first added to the current folder model. Then the Sash Windows should react and
	 * ask the {@link IPageModelFactory} to create the IPageModel. This later is then used to create the 
	 * SWT page.
	 * If 
	 * @param page The object identifying the page to add. This object will be passed to the 
	 * {@link IPageModelFactory#createIPageModel(EObject)}. This identifier is stored in the sash model.
	 * It should be a reference on a EMF object identifying the page.
	 */
	public void openPage(EObject pageIdentifier);
		
	/**
	 * Return all available page identifiers (open and closed pages).
	 * @return List of registered page identifiers.
	 */
	public List<Object> allPages();
	
}
