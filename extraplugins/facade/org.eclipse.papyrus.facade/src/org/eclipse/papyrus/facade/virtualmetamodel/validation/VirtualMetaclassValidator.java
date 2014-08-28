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
package org.eclipse.papyrus.facade.virtualmetamodel.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;

/**
 * A sample validator interface for {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface VirtualMetaclassValidator {
	boolean validate();

	boolean validateAbstract(boolean value);

	boolean validateAppliedStereotypes(EList<BaseMetaclass> value);

	boolean validateOperations(EList<VirtualOperation> value);

	boolean validateParents(EList<VirtualMetaclass> value);

	boolean validateProperties(EList<VirtualProperty> value);

	boolean validateStereotypeInterface(boolean value);
}
