package org.eclipse.papyrus.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.engine.GenericMatchScope;
import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.engine.IMatchScope;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


public class PapyrusMatchEngine extends GenericMatchEngine {

	@Override
	public MatchModel resourceMatch(Resource leftResource, Resource rightResource, Map<String, Object> optionMap) throws InterruptedException {
		optionMap.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new PapyrusMatchScopeProvider(leftResource, rightResource));
		return super.resourceMatch(leftResource, rightResource, optionMap);
	}

	@Override
	protected AbstractSimilarityChecker prepareChecker() {
		return super.prepareChecker();
	}

	@Override
	protected List<EObject> getScopeInternalContents(EObject eObject, IMatchScope scope) {
		ArrayList<EObject> result = new ArrayList<EObject>(super.getScopeInternalContents(eObject, scope));
		result.addAll(getStereotypeApplications(eObject));
		return result;
	}

	private List<EObject> getStereotypeApplications(EObject eObject) {
		if(eObject instanceof Element) {
			return ((Element)eObject).getStereotypeApplications();
		} else {
			return Collections.emptyList();
		}
	}

	private static class PapyrusMatchScopeProvider extends GenericMatchScopeProvider {

		public PapyrusMatchScopeProvider(Resource leftResource, Resource rightResource) {
			super(leftResource, rightResource);
		}

		@Override
		public IMatchScope getLeftScope() {
			return new PapyrusMatchScope(super.getLeftScope());
		}

		@Override
		public IMatchScope getRightScope() {
			return new PapyrusMatchScope(super.getRightScope());
		}

	}

	private static class PapyrusMatchScope implements IMatchScope {

		private final IMatchScope myScope;

		private PapyrusMatchScope(IMatchScope scope) {
			myScope = scope;
		}

		public boolean isInScope(EObject eObject) {
			return myScope.isInScope(eObject) && !isStereotypeApplication(eObject);
		}

		public boolean isInScope(Resource resource) {
			return myScope.isInScope(resource);
		}

		private boolean isStereotypeApplication(EObject eObject) {
			return UMLUtil.getStereotype(eObject) != null;
		}
	}

}
