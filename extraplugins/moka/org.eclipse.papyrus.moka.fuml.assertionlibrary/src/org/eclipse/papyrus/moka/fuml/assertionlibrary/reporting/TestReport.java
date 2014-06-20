/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting;

import org.eclipse.uml2.uml.Classifier;

public class TestReport {

	protected Classifier context;

	protected String label;

	protected TestDecision verdict;

	protected Class<?> assertionType;

	public TestReport(Classifier context, String label, TestDecision verdict, Class<?> assertionType) {
		this.context = context;
		this.label = label;
		this.verdict = verdict;
		this.assertionType = assertionType;
	}

	public String getLabel() {
		return label;
	}

	public Classifier getContext() {
		return context;
	}

	public TestDecision getVerdict() {
		return verdict;
	}

	public Class<?> getAssertionType() {
		return this.assertionType;
	}
}
