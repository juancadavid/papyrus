/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.results;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusQuery;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.papyrus.views.search.utils.MatchUtils;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.IEditorMatchAdapter;
import org.eclipse.search.ui.text.IFileMatchAdapter;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.MatchFilter;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;

import com.swtdesigner.ResourceManager;

public class PapyrusSearchResult extends AbstractTextSearchResult implements IEditorMatchAdapter, IFileMatchAdapter {

	MatchFilter[] possibleMatchFilter;



	private PapyrusQuery searchQuery;

	public PapyrusSearchResult(PapyrusQuery query) {
		this.searchQuery = query;
		possibleMatchFilter = new MatchFilter[0];
	}

	public PapyrusQuery getQuery() {
		return searchQuery;
	}


	public void setPossibleMatchFilter(MatchFilter[] possibleMatchFilter) {
		this.possibleMatchFilter = possibleMatchFilter;
	}

	@Override
	public MatchFilter[] getAllMatchFilters() {
		return possibleMatchFilter;

	}

	public String getLabel() {

		return getMatchCount() + Messages.PapyrusSearchResult_0 + searchQuery.getSearchQueryText() + Messages.PapyrusSearchResult_1;
	}

	public String getTooltip() {

		return Messages.PapyrusSearchResult_2;
	}

	public ImageDescriptor getImageDescriptor() {
		return ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/PapyrusSearch.png"); //$NON-NLS-1$
	}

	@Override
	public IEditorMatchAdapter getEditorMatchAdapter() {
		return this;
	}

	@Override
	public IFileMatchAdapter getFileMatchAdapter() {
		return this;
	}

	public Match[] computeContainedMatches(AbstractTextSearchResult result, IFile file) {
		Set<Match> results = new HashSet<Match>();
		Set<AbstractResultEntry> allMatches = MatchUtils.getMatches(result, true);
		for(AbstractResultEntry modelMatch : allMatches) {
			Object element = modelMatch.getElement();
			if(element instanceof ScopeEntry) {
				if(((ScopeEntry)element).getResource().equals(file)) {
					results.add(modelMatch);
				}
			}
		}
		Match[] arrayResult = new Match[results.size()];

		return results.toArray(arrayResult);
	}

	public IFile getFile(Object element) {
		//		if(element instanceof EObject) {
		//			Resource eResource = ((EObject)element).eResource();
		//			IFile resource = ModelUtils.getIFile(eResource);
		//			if(resource != null) {
		//				try {
		//					ModelSet modelSet = ModelUtils.openFile(resource);
		//					SashModel sashModel = (SashModel)modelSet.getModelChecked(SashModel.MODEL_ID);
		//					IFile diResource = ModelUtils.getIFile(sashModel.getResource());
		//
		//					return diResource;
		//				} catch (ModelMultiException e) {
		//					Activator.log.warn(Messages.PapyrusSearchResult_4 + resource);
		//					return null;
		//				} catch (NotFoundException e) {
		//					Activator.log.warn(Messages.PapyrusSearchResult_5 + resource);
		//					return null;
		//				}
		//			}
		//		}
		return null;
	}

	public boolean isShownInEditor(Match match, IEditorPart editor) {

		return false;
	}

	public Match[] computeContainedMatches(AbstractTextSearchResult result, IEditorPart editor) {
		Set<Object> results = new HashSet<Object>();

		Set<AbstractResultEntry> allMatches = MatchUtils.getMatches(result, true);
		for(AbstractResultEntry modelMatch : allMatches) {
			Object element = modelMatch.getElement();
			if(element instanceof ScopeEntry) {
				if(((ScopeEntry)element).getResource().equals(ResourceUtil.getResource(editor.getEditorInput()))) {
					results.add(modelMatch);
				}
			}
		}

		Match[] arrayResult = new Match[results.size()];

		return results.toArray(arrayResult);
	}

}
