/*******************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Juan Cadavid <juan.cadavid@cea.fr> implementation
 *     Christian W. Damus (CEA) - bug 437217 - control-mode strategy changes interfere with later tests
 *     
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.tests.control;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.controlmode.tests.Messages;
import org.eclipse.papyrus.infra.services.controlmode.tests.StrategyChooserFixture;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.HandlerUtils;
import org.eclipse.papyrus.junit.utils.ModelExplorerUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.osgi.framework.Bundle;

public abstract class AbstractControlModeTest extends AbstractPapyrusTest {

	protected static final String COMMAND_ID = "org.eclipse.papyrus.infra.services.controlmode.createsubmodel"; //$NON-NLS-1$

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();
	
	protected IMultiDiagramEditor editor = null;

	protected Model model;

	@Before
	public void setUp() {
		//Set the current resource loading strategy to the default
		houseKeeper.cleanUpLater(new StrategyChooserFixture(0));
		
		try {
			initTests(Activator.getDefault().getBundle());
		} catch (CoreException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		}
	}

	protected static ModelExplorerView view;

	protected static IFile modelFile;

	protected static Bundle bundle;

	protected static SWTWorkbenchBot bot;

	public AbstractControlModeTest() {
		super();
	}

	@After
	public void after() throws CoreException {
		GenericUtils.closeAllEditors();
		GenericUtils.cleanWorkspace();
		ProjectUtils.removeAllProjectFromTheWorkspace();
	}

	protected abstract void initTests(final Bundle bundle) throws CoreException, IOException;

	protected void controlAndSave(IMultiDiagramEditor editor, Model model, List<PackageableElement> elements, Command cmd) {
		try {
			HandlerUtils.executeCommand(cmd);

		} catch (Throwable e) {
			String s = "*********************************************\n";
			do {
				StackTraceElement[] stackTrace = e.getStackTrace();
				s += e.getLocalizedMessage() + "\n";
				for(StackTraceElement stackTraceElement : stackTrace) {
					s += stackTraceElement.toString() + "\n";
				}
				s += "-------------------------------------------------\n";
			} while((e = e.getCause()) != null);
			fail(s);

		}
		ISaveAndDirtyService saveService;
		try {
			saveService = editor.getServicesRegistry().getService(ISaveAndDirtyService.class);
			saveService.doSave(new NullProgressMonitor());
		} catch (ServiceException e) {
			fail(e.getMessage());

		}

		// Execute save
		// Assert that the parent package is controlled
		PackageableElement submodel = elements.get(0);
		Assert.assertNotEquals("The controlled submodel's resource equals its parent's", model.eResource(), submodel.eResource());

		// Assert that the model and submodel belong to different
		// resources
		Assert.assertNotEquals(Messages.AbstractControlModeTest_1, model, submodel);
	}

	/**
	 * Select the first subpackage of the root package in the model explorer
	 * 
	 * @return
	 */
	protected List<PackageableElement> selectElementToControl() {
		editor = houseKeeper.openPapyrusEditor(modelFile);
		
		try {
			AbstractControlModeTest.view = ModelExplorerUtils.openModelExplorerView();
		} catch (Exception e) {

			fail(e.getMessage());
		}
		model = (Model)ModelExplorerUtils.getRootInModelExplorer(view);
		List<PackageableElement> elements = new ArrayList<PackageableElement>();
		for(PackageableElement packageableElement : model.getPackagedElements()) {
			if(packageableElement instanceof org.eclipse.uml2.uml.Package) {
				elements.add(packageableElement);
			}
		}
		ModelExplorerUtils.setSelectionInTheModelexplorer(view, elements);
		return elements;
	}

}
