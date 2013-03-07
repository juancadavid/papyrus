/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.model.CDOPackageRegistryPopulator;
import org.eclipse.emf.cdo.common.protocol.CDOProtocolConstants;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.common.util.NotAuthenticatedException;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.spi.cdo.CDOMergingConflictResolver;
import org.eclipse.equinox.security.storage.EncodingUtils;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.net4j.util.container.Container;
import org.eclipse.net4j.util.container.ContainerEvent;
import org.eclipse.net4j.util.container.IContainerDelta;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.security.CredentialsProviderFactory;
import org.eclipse.net4j.util.security.ICredentialsProvider2;
import org.eclipse.papyrus.cdo.core.CommitException;
import org.eclipse.papyrus.cdo.core.IResourceSetDisposalApprover;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareModelSet;
import org.eclipse.papyrus.cdo.core.resource.PapyrusCDOResourceFactory;
import org.eclipse.papyrus.cdo.internal.core.repositories.Repository;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * This is the PapyrusRepository type. Enjoy.
 */
public class PapyrusRepository
		extends Container<CDOResourceNode>
		implements IInternalPapyrusRepository, IAdaptable {

	private static final String SECURE_STORE_PATH = "/" + Activator.PLUGIN_ID
		+ "/repositories";

	private static final CDOResourceNode[] NO_RESOURCE_NODES = new CDOResourceNode[0];

	private final IManagedContainer container;

	private final Repository model;

	private CDOSession session;

	private BiMap<ResourceSet, CDOView> readOnlyViews = HashBiMap.create();

	private BiMap<ResourceSet, CDOTransaction> transactions = HashBiMap
		.create();

	private IListener viewListener;

	private CDOView masterView;

	private volatile CDOResourceNode[] topResourceNodes;

	private IListener masterViewListener;

	private final CompositeResourceSetDisposalApprover approvers = new CompositeResourceSetDisposalApprover();

	public PapyrusRepository(IManagedContainer container, Repository model) {
		this.container = container;
		this.model = model;

		activate();
	}

	public String getName() {
		return model.getName();
	}

	public void setName(String name) {
		if (Strings.isNullOrEmpty(name)) {
			throw new IllegalArgumentException("null or empty name");
		}

		model.setName(name);
	}

	public String getURL() {
		return model.getURL();
	}

	public String getUsername() {
		return getSecureStorageValue("username");
	}

	public void setUsername(String username) {
		if (username != null) {
			username = username.trim();
			if (username.length() == 0) {
				username = null;
			}
		}

		setSecureStorageValue("username", username, false);
	}

	public String getPassword() {
		return getSecureStorageValue("password");
	}

	private String getSecureStorageValue(String key) {
		String result = null;

		ISecurePreferences store = SecurePreferencesFactory.getDefault();
		String path = getSecureStorePath();
		if (store.nodeExists(path)) {
			store = store.node(path);

			try {
				result = store.get(key, null);
			} catch (StorageException e) {
				Activator.log.error(String.format(
					"Failed to load repository %s from secure storage.", key),
					e);
			}
		}

		return result;
	}

	private String getSecureStorePath() {
		return String.format("%s/%s", SECURE_STORE_PATH,
			EncodingUtils.encodeSlashes(getURL()));
	}

	public void setPassword(String password) {
		setSecureStorageValue("password", password, true);
	}

	private void setSecureStorageValue(String key, String value, boolean encrypt) {
		ISecurePreferences store = SecurePreferencesFactory.getDefault().node(
			getSecureStorePath());
		try {
			if (value == null) {
				store.remove(key);
			} else {
				store.put(key, value, encrypt);
			}
		} catch (StorageException e) {
			Activator.log.error(String.format(
				"Failed to store repository %s in secure storage.", key), e);
		}
	}

	public void clearCredentials() {
		ISecurePreferences store = SecurePreferencesFactory.getDefault();
		String path = getSecureStorePath();
		if (store.nodeExists(path)) {
			store.node(path).removeNode();
		}
	}

	public boolean isConnected() {
		return (session != null) && !session.isClosed();
	}

	public void connect() {
		if (!isConnected()) {
			ICredentialsProvider2 creds = getCredentialsProvider();
			Object oldCreds = null;
			if (creds != null) {
				oldCreds = container.putElement(
					CredentialsProviderFactory.PRODUCT_GROUP, "interactive",
					null, creds);
			}

			try {
				for (;;) {
					try {
						session = (CDOSession) container.getElement(
							"org.eclipse.emf.cdo.sessions", "cdo", getURL());
						CDOUtil.setLegacyModeDefault(true);
					} catch (NotAuthenticatedException e) {
						// user cancelled the credentials dialog. That's OK
						break;
					} catch (SecurityException e) {
						// wrong credentials. If the user stored them, purge and
						// try again
						clearCredentials();

						if (creds instanceof IInteractiveCredentialsProvider) {
							((IInteractiveCredentialsProvider) creds)
								.reportCredentialsFailure(e);
						}

						continue;
					}
					break;
				}

				if (session != null) {
					configure(session);

					// open the master view for the UI
					createReadOnlyView(new ResourceSetImpl());
				}
			} finally {
				if (creds != null) {
					if (oldCreds != null) {
						container.putElement(
							CredentialsProviderFactory.PRODUCT_GROUP,
							"interactive", null, oldCreds);
					} else {
						container/* IPluginContainer.INSTANCE */.removeElement(
							CredentialsProviderFactory.PRODUCT_GROUP,
							"interactive", null);
					}
				}
			}
		}
	}

	private ICredentialsProvider2 getCredentialsProvider() {
		ICredentialsProvider2 result = null;

		ICredentialsProviderFactory factory = PapyrusRepositoryManager.INSTANCE
			.getCredentialsProviderFactory();
		if (factory != null) {
			result = factory.createCredentialsProvider(this);
		}

		return result;
	}

	public void disconnect()
			throws CommitException {

		if (isConnected()) {
			ImmutableList<ResourceSet> dirty = ImmutableList.copyOf(Iterables
				.filter(transactions.keySet(), new Predicate<ResourceSet>() {

					public boolean apply(ResourceSet input) {
						return transactions.get(input).isDirty();
					}
				}));

			switch (approvers.disposalRequested(this, dirty)) {
				case SAVE :
					for (ResourceSet next : dirty) {
						commit(next);
					}

					// intentional fall-through (save then close)
				case CLOSE :
					for (CDOView next : ImmutableList.copyOf(transactions
						.values())) {

						doClose(next);
					}
					for (CDOView next : ImmutableList.copyOf(readOnlyViews
						.values())) {

						doClose(next);
					}

					session.close();
					session = null;
					break;
				default : // NONE
					break;
			}
		}
	}

	protected void checkConnected() {
		if (!isConnected()) {
			throw new IllegalStateException("not connected");
		}
	}

	public Collection<ResourceSet> getReadOnlyViews() {
		return Collections.unmodifiableCollection(readOnlyViews.keySet());
	}

	public ResourceSet createReadOnlyView(ResourceSet resourceSet) {
		checkConnected();

		CDOUtil.setLegacyModeDefault(true); // legacy mode is per-thread
		CDOView view = session.openView(resourceSet);
		configure(view);
		ResourceSet result = view.getResourceSet();
		readOnlyViews.put(result, view);

		if (masterView == null) {
			masterView = view;
			topResourceNodes = getElements();
			adaptMasterView(view);

			if (topResourceNodes.length > 0) {
				fireElementsAddedEvent(topResourceNodes);
			} else {
				fireEvent(); // just refresh my presentation
			}
		}

		return result;
	}

	public Collection<ResourceSet> getTransactions() {
		return Collections.unmodifiableCollection(transactions.keySet());
	}

	public ResourceSet createTransaction(ResourceSet resourceSet) {
		checkConnected();

		CDOUtil.setLegacyModeDefault(true); // legacy mode is per-thread
		CDOTransaction transaction = session.openTransaction(resourceSet);
		configure(transaction);
		ResourceSet result = transaction.getResourceSet();
		transactions.put(result, transaction);

		return result;
	}

	public CDOSession getCDOSession() {
		return session;
	}

	public CDOView getMasterView() {
		return masterView;
	}

	public CDOView getCDOView(ResourceSet resourceSet) {
		CDOView result = readOnlyViews.get(resourceSet);

		if (result == null) {
			result = transactions.get(resourceSet);
		}

		return result;
	}

	protected void removeCDOView(ResourceSet resourceSet) {
		readOnlyViews.remove(resourceSet);
		transactions.remove(resourceSet);
	}

	CDOTransaction checkTransaction(CDOView view) {
		if (!(view instanceof CDOTransaction)) {
			throw new IllegalArgumentException("not a transaction");
		}

		return (CDOTransaction) view;
	}

	public void commit(ResourceSet transaction)
			throws CommitException {
		CDOView cdoView = getCDOView(transaction);

		try {
			checkTransaction(cdoView).commit();
		} catch (org.eclipse.emf.cdo.util.CommitException e) {
			throw new CommitException(e);
		}
	}

	public void rollback(ResourceSet transaction) {
		CDOView cdoView = getCDOView(transaction);
		checkTransaction(cdoView).rollback();
	}

	public void close(ResourceSet view) {
		CDOView cdoView = getCDOView(view);

		if (cdoView != null) {
			doClose(cdoView);
		}
	}

	protected void doClose(CDOView view) {
		try {
			if (view == masterView) {
				unadaptMasterView(view);
				masterView = null;
				CDOResourceNode[] removedNodes = topResourceNodes;
				topResourceNodes = null;
				if ((removedNodes != null) && (removedNodes.length > 0)) {
					fireElementsRemovedEvent(removedNodes);
				} else {
					fireEvent(); // just refresh my presentation
				}
			}
		} finally {
			unadaptView(view);
			removeCDOView(view.getResourceSet());
			view.close();
		}
	}

	public Repository getModel() {
		return model;
	}

	protected void configure(CDOSession newSession) {
		CDOUtil.setLegacyModeDefault(true);
		CDOPackageRegistryPopulator.populate(newSession.getPackageRegistry());
	}

	protected void configure(CDOView newReadOnlyView) {
		adaptView(newReadOnlyView);

		commonViewConfiguration(newReadOnlyView);

		// TODO: Do we need to set any other options?
	}

	protected void commonViewConfiguration(CDOView newView) {
		// CDO's default resource factory inspects the current thread's stack
		// trace to see whether the getResource(...) method of a set of known
		// ResourceSet implementation classes is in progress. We have a
		// ResourceSet implementation that CDO doesn't know about, so we need
		// our own factory
		ResourceSet rset = newView.getResourceSet();
		if (rset instanceof CDOAwareModelSet) {
			rset.getResourceFactoryRegistry()
				.getProtocolToFactoryMap()
				.put(CDOProtocolConstants.PROTOCOL_NAME,
					new PapyrusCDOResourceFactory((CDOAwareModelSet) rset));
		}
	}

	protected void configure(CDOTransaction newTransaction) {
		adaptView(newTransaction);

		commonViewConfiguration(newTransaction);

		newTransaction.options().addConflictResolver(
			new CDOMergingConflictResolver());
		// TODO: Do we need to set any other options?
	}

	private IListener getViewListener() {
		if (viewListener == null) {
			viewListener = new LifecycleEventAdapter() {

				@Override
				protected void onDeactivated(ILifecycle lifecycle) {
					readOnlyViews.inverse().remove(lifecycle);
					transactions.inverse().remove(lifecycle);
				}
			};
		}

		return viewListener;
	}

	private void adaptView(CDOView view) {
		view.addListener(getViewListener());
	}

	private void unadaptView(CDOView view) {
		view.removeListener(getViewListener());
	}

	private IListener getMasterViewListener() {
		if (masterViewListener == null) {
			masterViewListener = new IListener() {

				public void notifyEvent(IEvent event) {
					if (event instanceof CDOViewInvalidationEvent) {
						CDOViewInvalidationEvent inval = (CDOViewInvalidationEvent) event;
						translateMasterViewInvalidationEvent(inval);
					}
				}
			};
		}

		return masterViewListener;
	}

	private void adaptMasterView(CDOView view) {
		view.addListener(getMasterViewListener());
	}

	private void unadaptMasterView(CDOView view) {
		view.removeListener(getMasterViewListener());
	}

	public void addResourceSetDisposalApprover(
			IResourceSetDisposalApprover approver) {

		approvers.addApprover(approver);
	}

	public void removeResourceSetDisposalApprover(
			IResourceSetDisposalApprover approver) {

		approvers.removeApprover(approver);
	}

	//
	// IContainer protocol
	//

	@Override
	public boolean isEmpty() {
		return !isActive() || !isConnected() || (masterView == null)
			|| masterView.isEmpty();
	}

	public CDOResourceNode[] getElements() {
		CDOResourceNode[] result = NO_RESOURCE_NODES;

		if (masterView != null) {
			if (topResourceNodes == null) {
				topResourceNodes = masterView.getElements();
			}
			result = topResourceNodes;
		}

		return result;
	}

	@Override
	protected void doAfterActivate()
			throws Exception {

		super.doAfterActivate();

		model.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				fireEvent();
			}

			@Override
			public boolean isAdapterForType(Object type) {
				return type == PapyrusRepository.class;
			}
		});
	}

	@Override
	protected void doBeforeDeactivate()
			throws Exception {

		Adapter adapter = EcoreUtil.getExistingAdapter(model,
			PapyrusRepository.class);
		if (adapter != null) {
			model.eAdapters().remove(adapter);
		}

		super.doBeforeDeactivate();
	}

	private void translateMasterViewInvalidationEvent(
			CDOViewInvalidationEvent event) {

		for (Map.Entry<CDOObject, CDORevisionDelta> next : event
			.getRevisionDeltas().entrySet()) {

			if (next.getKey() instanceof CDOResourceNode) {
				CDOResourceNode resNode = (CDOResourceNode) next.getKey();

				if (resNode.isRoot()) {
					// the event doesn't provide a revision delta, so calculate
					// a delta

					Set<CDOResourceNode> currentNodes = Sets
						.newLinkedHashSet(Arrays.asList(getElements()));
					Set<CDOResourceNode> newNodes = Sets
						.newLinkedHashSet(Iterables.filter(
							((CDOResource) resNode).getContents(),
							CDOResourceNode.class));

					Set<CDOResourceNode> removed = Sets.difference(
						currentNodes, newNodes);
					Set<CDOResourceNode> added = Sets.difference(newNodes,
						currentNodes);

					ContainerEvent<CDOResourceNode> cEvent = new ContainerEvent<CDOResourceNode>(
						this);
					for (CDOResourceNode r : removed) {
						cEvent.addDelta(r, IContainerDelta.Kind.REMOVED);
					}
					for (CDOResourceNode a : added) {
						cEvent.addDelta(a, IContainerDelta.Kind.ADDED);
					}

					// re-calculate elements from the view
					topResourceNodes = resNode.cdoView().getElements();

					fireEvent(cEvent);
					break;
				}
			}
		}

	}

	//
	// IAdaptable protocol
	//

	public Object getAdapter(@SuppressWarnings("rawtypes")
	Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}
}