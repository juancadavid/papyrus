package org.eclipse.papyrus.diagram.statemachine.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.custom.figures.CustomShapeCompartmentFigure;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.uml2.uml.Region;

public class CustomRegionCompartmentEditPart extends RegionCompartmentEditPart {

	public CustomRegionCompartmentEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	public IFigure createFigure() {
		CustomShapeCompartmentFigure result = new CustomShapeCompartmentFigure(getCompartmentName(), getMapMode());
		result.setBorder(null);
		return result;
	}

	@Override
	protected void refreshVisuals() {
		// TODO Auto-generated method stub
		super.refreshVisuals();

		View regionView = (View) ((View) getModel()).eContainer();
		Region region = (Region) regionView.getElement();

		((CustomShapeCompartmentFigure) getFigure()).setToolTip(region.getName());

	}
}
