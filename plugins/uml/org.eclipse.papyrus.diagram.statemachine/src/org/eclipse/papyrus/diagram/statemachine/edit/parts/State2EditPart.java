/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.AnnotateNodeStyleCommand;
import org.eclipse.papyrus.diagram.common.commands.RemoveEObjectReferencesFromDiagram;
import org.eclipse.papyrus.diagram.common.draw2d.LaneLayout;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.LaneLayoutEditPolicy;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.State2CanonicalEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.State2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class State2EditPart extends AbstractBorderedShapeEditPart implements
		PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public State2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new State2ItemSemanticEditPolicy());
		//		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
		//				new DragDropEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			@Override
			protected boolean shouldDeleteSemantic() {
				return false;
			}

			@Override
			protected Command getDeleteCommand(GroupRequest request) {
				Command command = super.getDeleteCommand(request);
				command = command
						.chain(new ICommandProxy(
								new RemoveEObjectReferencesFromDiagram(
										getEditingDomain(),
										State2EditPart.this.getDiagramView(),
										Collections
												.singletonList(resolveSemanticElement()))));
				return command;
			}
		});
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new State2CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy("LayoutEditPolicy", new LaneLayoutEditPolicy()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				// Commented to show the "virtual" link that links the two nodes
				// if (child instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart) {
				// 	return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
				// }
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		CompositeStateFigure figure = new CompositeStateFigureAux();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CompositeStateFigure getPrimaryShape() {
		return (CompositeStateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StateName3EditPart) {
			((StateName3EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureCompositeStateFigure_name());
			return true;
		}
		if (childEditPart instanceof StateName4EditPart) {
			((StateName4EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureCompositeStateStereotypesLabel());
			return true;
		}
		if (childEditPart instanceof Pseudostate11EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((Pseudostate11EditPart) childEditPart).getFigure(),
					locator);
			return true;
		}
		if (childEditPart instanceof Pseudostate12EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(
					((Pseudostate12EditPart) childEditPart).getFigure(),
					locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof Pseudostate11EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((Pseudostate11EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof Pseudostate12EditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((Pseudostate12EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof Pseudostate9EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof Pseudostate10EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof Pseudostate11EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof Pseudostate12EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof Pseudostate13EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		if (editPart instanceof Pseudostate14EditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		// return super.getContentPaneFor(editPart);
		return contentPane;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(200), getMapMode().DPtoLP(150));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * @generated NOT
	 * XXX: Support content pane in xPand custom templates
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return getPrimaryShape().getFigureCompositeStateFigure_Body();
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry
				.getType(StateName3EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() instanceof ShapeStyle) {
			super.handleNotificationEvent(event);

			// Propagate style
			for (Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if (!(obj instanceof GraphicalEditPart))
					continue;
				GraphicalEditPart ep = (GraphicalEditPart) obj;

				if (ep.resolveSemanticElement() != resolveSemanticElement())
					continue;

				ShapeStyle style = (ShapeStyle) ((View) ep.getModel())
						.getStyle(NotationPackage.eINSTANCE.getShapeStyle());
				if (style != null) {
					style.eSet((EStructuralFeature) event.getFeature(), event
							.getNewValue());
					ep.refresh();
				}
			}

		} else {
			super.handleNotificationEvent(event);
		}

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		DiagramEditPartsUtil
				.handleNotificationForDiagram(this, event, features);
	}

	/**
	 * @generated
	 */
	public class CompositeStateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureCompositeStateStereotypesLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureCompositeStateFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureCompositeStateFigure_Body;

		/**
		 * @generated
		 */
		public CompositeStateFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(18),
					getMapMode().DPtoLP(18)));
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.white);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure compositeStateFigure_NameContainer0 = new RectangleFigure();
			compositeStateFigure_NameContainer0.setFill(false);
			compositeStateFigure_NameContainer0.setOutline(false);

			GridData constraintCompositeStateFigure_NameContainer0 = new GridData();
			constraintCompositeStateFigure_NameContainer0.verticalAlignment = GridData.FILL;
			constraintCompositeStateFigure_NameContainer0.horizontalAlignment = GridData.FILL;
			constraintCompositeStateFigure_NameContainer0.horizontalIndent = 0;
			constraintCompositeStateFigure_NameContainer0.horizontalSpan = 1;
			constraintCompositeStateFigure_NameContainer0.verticalSpan = 1;
			constraintCompositeStateFigure_NameContainer0.grabExcessHorizontalSpace = true;
			constraintCompositeStateFigure_NameContainer0.grabExcessVerticalSpace = false;
			this.add(compositeStateFigure_NameContainer0,
					constraintCompositeStateFigure_NameContainer0);

			GridLayout layoutCompositeStateFigure_NameContainer0 = new GridLayout();
			layoutCompositeStateFigure_NameContainer0.numColumns = 1;
			layoutCompositeStateFigure_NameContainer0.makeColumnsEqualWidth = true;
			layoutCompositeStateFigure_NameContainer0.horizontalSpacing = 0;
			layoutCompositeStateFigure_NameContainer0.verticalSpacing = 0;
			layoutCompositeStateFigure_NameContainer0.marginWidth = 3;
			layoutCompositeStateFigure_NameContainer0.marginHeight = 3;
			compositeStateFigure_NameContainer0
					.setLayoutManager(layoutCompositeStateFigure_NameContainer0);

			fFigureCompositeStateStereotypesLabel = new WrappingLabel();
			fFigureCompositeStateStereotypesLabel.setText("");

			fFigureCompositeStateStereotypesLabel
					.setFont(FFIGURECOMPOSITESTATESTEREOTYPESLABEL_FONT);

			GridData constraintFFigureCompositeStateStereotypesLabel = new GridData();
			constraintFFigureCompositeStateStereotypesLabel.verticalAlignment = GridData.CENTER;
			constraintFFigureCompositeStateStereotypesLabel.horizontalAlignment = GridData.CENTER;
			constraintFFigureCompositeStateStereotypesLabel.horizontalIndent = 0;
			constraintFFigureCompositeStateStereotypesLabel.horizontalSpan = 1;
			constraintFFigureCompositeStateStereotypesLabel.verticalSpan = 1;
			constraintFFigureCompositeStateStereotypesLabel.grabExcessHorizontalSpace = true;
			constraintFFigureCompositeStateStereotypesLabel.grabExcessVerticalSpace = false;
			compositeStateFigure_NameContainer0.add(
					fFigureCompositeStateStereotypesLabel,
					constraintFFigureCompositeStateStereotypesLabel);

			fFigureCompositeStateFigure_name = new WrappingLabel();
			fFigureCompositeStateFigure_name.setText("");

			fFigureCompositeStateFigure_name
					.setFont(FFIGURECOMPOSITESTATEFIGURE_NAME_FONT);

			GridData constraintFFigureCompositeStateFigure_name = new GridData();
			constraintFFigureCompositeStateFigure_name.verticalAlignment = GridData.CENTER;
			constraintFFigureCompositeStateFigure_name.horizontalAlignment = GridData.CENTER;
			constraintFFigureCompositeStateFigure_name.horizontalIndent = 0;
			constraintFFigureCompositeStateFigure_name.horizontalSpan = 1;
			constraintFFigureCompositeStateFigure_name.verticalSpan = 1;
			constraintFFigureCompositeStateFigure_name.grabExcessHorizontalSpace = true;
			constraintFFigureCompositeStateFigure_name.grabExcessVerticalSpace = true;
			compositeStateFigure_NameContainer0.add(
					fFigureCompositeStateFigure_name,
					constraintFFigureCompositeStateFigure_name);

			fFigureCompositeStateFigure_Body = new RectangleFigure();
			fFigureCompositeStateFigure_Body.setOutline(false);
			fFigureCompositeStateFigure_Body
					.setForegroundColor(ColorConstants.black);

			GridData constraintFFigureCompositeStateFigure_Body = new GridData();
			constraintFFigureCompositeStateFigure_Body.verticalAlignment = GridData.FILL;
			constraintFFigureCompositeStateFigure_Body.horizontalAlignment = GridData.FILL;
			constraintFFigureCompositeStateFigure_Body.horizontalIndent = 0;
			constraintFFigureCompositeStateFigure_Body.horizontalSpan = 1;
			constraintFFigureCompositeStateFigure_Body.verticalSpan = 1;
			constraintFFigureCompositeStateFigure_Body.grabExcessHorizontalSpace = true;
			constraintFFigureCompositeStateFigure_Body.grabExcessVerticalSpace = true;
			this.add(fFigureCompositeStateFigure_Body,
					constraintFFigureCompositeStateFigure_Body);

			LaneLayout layoutFFigureCompositeStateFigure_Body = new LaneLayout();

			fFigureCompositeStateFigure_Body
					.setLayoutManager(layoutFFigureCompositeStateFigure_Body);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCompositeStateFigure_name() {
			return fFigureCompositeStateFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureCompositeStateFigure_Body() {
			return fFigureCompositeStateFigure_Body;
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		@Override
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCompositeStateStereotypesLabel() {
			return fFigureCompositeStateStereotypesLabel;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURECOMPOSITESTATESTEREOTYPESLABEL_FONT = new Font(
			Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FFIGURECOMPOSITESTATEFIGURE_NAME_FONT = new Font(Display
			.getCurrent(), "SANS", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	public class CompositeStateFigureAux extends CompositeStateFigure {
		/**
		 * @generated
		 */
		private WrappingLabel figureStereotypeLabel;

		/**
		 * @generated
		 */
		private IFigure stereotypeParent;

		/**
		 * @generated
		 */
		public CompositeStateFigureAux() {
			super();
			stereotypeParent = super.getFigureCompositeStateStereotypesLabel()
					.getParent();
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			if (stereotypeParent.getChildren().contains(
					super.getFigureCompositeStateStereotypesLabel())) {
				stereotypeParent.getChildren().remove(
						super.getFigureCompositeStateStereotypesLabel());
			}

			figureStereotypeLabel = new WrappingLabel() {
				@Override
				public void setText(String text) {
					if (stereotypeParent == null || text == null) {
						super.setText(text);
						return;
					}

					if (text.equals("")) {
						super.setText(text);
						if (stereotypeParent.getChildren().contains(this)) {
							stereotypeParent.remove(this);
						}
					} else {
						super.setText(text);
						if (!stereotypeParent.getChildren().contains(this)) {
							stereotypeParent.add(this, 0);
						}
					}
				}
			};
			figureStereotypeLabel.setText("");

			Font stereotypeLabelFont = new Font(Display.getCurrent(), "SANS",
					9, SWT.NORMAL);
			figureStereotypeLabel.setFont(stereotypeLabelFont);

			figureStereotypeLabel.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(2), getMapMode().DPtoLP(2), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2)));

			GridData stereotypeLabelConstraint = new GridData();
			stereotypeLabelConstraint.verticalAlignment = GridData.CENTER;
			stereotypeLabelConstraint.horizontalAlignment = GridData.CENTER;
			stereotypeLabelConstraint.horizontalIndent = 0;
			stereotypeLabelConstraint.horizontalSpan = 1;
			stereotypeLabelConstraint.verticalSpan = 1;
			stereotypeLabelConstraint.grabExcessHorizontalSpace = true;
			stereotypeLabelConstraint.grabExcessVerticalSpace = false;
			stereotypeParent.add(figureStereotypeLabel,
					stereotypeLabelConstraint, 0);
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCompositeStateStereotypesLabel() {
			return figureStereotypeLabel;
		}
	}

	/**
	 * @generated not
	 */
	@Override
	protected void reorderChild(EditPart child, int index) {
		// Save the constraint of the child so that it does not
		// get lost during the remove and re-add.
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		//the only change is here! getContentPaneFor() is used instead of getContentPane()
		LayoutManager layout = getContentPaneFor((IGraphicalEditPart) child)
				.getLayoutManager();
		Object constraint = null;
		if (layout != null)
			constraint = layout.getConstraint(childFigure);

		super.reorderChild(child, index);
		setLayoutConstraint(child, childFigure, constraint);
	}

	/**
	 * @generated
	 */
	protected EAnnotation getAppearenceEAnnotation() {
		EAnnotation eAnn = getPrimaryView().getEAnnotation(
				AnnotateNodeStyleCommand.APPEARANCE_EANNOTATION_NAME);
		return eAnn;
	}

	/**
	 * @generated
	 */
	private List<EObject> changesFromDefaultStyle() {
		EAnnotation eAnn = getAppearenceEAnnotation();
		if (eAnn == null)
			return new ArrayList<EObject>();
		else
			return eAnn.getReferences();
	}

	/**
	 * @generated
	 */
	public static boolean isLabel(IFigure figure) {
		if (figure instanceof Label) {
			return true;
		}
		if (figure instanceof WrappingLabel) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean isFigureFromChildEditPart(IFigure figure) {
		for (Iterator i = getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if (obj instanceof AbstractGraphicalEditPart) {
				AbstractGraphicalEditPart gEP = (AbstractGraphicalEditPart) obj;
				if (gEP.getFigure() == figure) {
					// Check if semantic elements are different
					if (gEP instanceof GraphicalEditPart
							&& ((GraphicalEditPart) gEP)
									.resolveSemanticElement() == resolveSemanticElement()) {
						return false;
					}
					return true;
				} else {
					// Check if it is a child figure of the editpart
					for (java.lang.Object child : gEP.getChildren()) {
						if (child instanceof GraphicalEditPart) {
							GraphicalEditPart childEP = (GraphicalEditPart) child;
							if (childEP.getFigure() == figure) {
								if (childEP.resolveSemanticElement() != resolveSemanticElement())
									return true;
								else
									return false;
							}
						}
					}
				} // end else
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		// Only update if the Node doesn't have the default style
		if (changesFromDefaultStyle().contains(
				NotationPackage.Literals.FILL_STYLE__FILL_COLOR)) {
			setOwnedFiguresBackgroundColor(getFigure(), color);
		} else
			super.setBackgroundColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresBackgroundColor(IFigure parent, Color color) {
		parent.setBackgroundColor(color);
		for (Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if (obj instanceof IFigure
					&& !isFigureFromChildEditPart((IFigure) obj)) {
				setOwnedFiguresBackgroundColor((IFigure) obj, color);
			}
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		// Only update if the Node doesn't have the default style
		if (changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresForegroundColor(getFigure(), color);
		} else
			super.setForegroundColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresForegroundColor(IFigure parent, Color color) {
		if (!isLabel(parent))
			parent.setForegroundColor(color);
		for (Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if (obj instanceof IFigure && !isLabel((IFigure) obj)
					&& !isFigureFromChildEditPart((IFigure) obj)) {
				setOwnedFiguresForegroundColor((IFigure) obj, color);
			}
		}
	}

	/**
	 * @generated
	 */

	@Override
	protected void setFontColor(Color color) {
		// Only update if the Node doesn't have the default style
		if (changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresFontColor(getFigure(), color);
		} else
			super.setFontColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresFontColor(IFigure parent, Color color) {
		if (isLabel(parent))
			parent.setForegroundColor(color);
		for (Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if (obj instanceof IFigure && isLabel((IFigure) obj)
					&& !isFigureFromChildEditPart((IFigure) obj)) {
				setOwnedFiguresFontColor((IFigure) obj, color);
			}
		}
	}

}
