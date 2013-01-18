/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico emilien.perico@atosorigin.com - manage loading strategies
 *
 *****************************************************************************/
package org.eclipse.papyrus.resource.additional;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.resource.IModel;
import org.eclipse.papyrus.resource.IModelSnippet;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelSnippetList;
import org.eclipse.papyrus.resource.ModelUtils;

public class AdditionalResourcesModel implements IModel {

	/**
	 * The associated ModelManager.
	 */
	private ModelSet modelSet;

	/**
	 * List of attached snippets.
	 */
	private ModelSnippetList snippets = new ModelSnippetList();

	/**
	 * Model ID.
	 */
	public static String MODEL_ID = "org.eclipse.papyrus.resource.additional";

	public void init(ModelSet modelManager) {
		this.modelSet = modelManager;
	}

	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * useless for additional resources
	 */
	public void createModel(IPath fullPath) {
		// do nothing
	}

	public void loadModel(IPath path) {
		// call registered snippets
		snippets.performStart(this);
	}

	public void importModel(IPath fullPathWithoutExtension) {
		loadModel(fullPathWithoutExtension);
	}

	public void saveModel() throws IOException {
		for(Resource r : modelSet.getResources()) {
			if(isAdditionalResource(getModelManager(), r.getURI())) {
				// only save referenced models not read-only and either platform or file
				if(r.isModified() && !modelSet.getTransactionalEditingDomain().isReadOnly(r) && !ModelUtils.haveLoadingError(r)) {
					try {
						r.save(Collections.EMPTY_MAP);
					} catch (IOException e) {
						Activator.log.error(e);
					}
				}
			}
		}
	}

	/**
	 * useless for additional resources
	 */
	public void changeModelPath(IPath fullPath) {
		// do nothing
	}

	public void unload() {
		// call registered snippets
		snippets.performDispose(this);

		// Unload remaining resources
		for(int i = 0; i < modelSet.getResources().size(); i++) {
			Resource next = modelSet.getResources().get(i);
			if(isAdditionalResource(getModelManager(), next.getURI())) {
				next.unload();
			}
		}
	}

	public void addModelSnippet(IModelSnippet snippet) {
		snippets.add(snippet);
	}

	/**
	 * @return the modelManager
	 */
	protected ModelSet getModelManager() {
		return modelSet;
	}

	/**
	 * Check is a resource is additional in the resource set
	 * 
	 * @param uri
	 *        the specified URI of the resource
	 * @return true if it is an additional resource
	 */
	public static boolean isAdditionalResource(ModelSet modelSet, URI uri) {
		if(uri != null && (uri.isPlatformResource() || uri.isFile())) {
			String platformString = uri.trimFileExtension().toPlatformString(false);
			return ((platformString == null) || !modelSet.getFilenameWithoutExtension().toString().equals(platformString.toString()));
		}
		return false;
	}

	public Set<IFile> getModifiedFiles() {
		HashSet<IFile> res = new HashSet<IFile>();
		for(Resource r : modelSet.getResources()) {
			if(isAdditionalResource(getModelManager(), r.getURI())) {
				if (!r.isTrackingModification() || r.isModified()) {
					IFile f = WorkspaceSynchronizer.getFile(r);
					if (f != null) {
						res.add(f);
					}
				}
			}
		}
		return res;
	}
}