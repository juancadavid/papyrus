package org.eclipse.papyrus.diagram.communication.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.parser.CommentParser;
import org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.diagram.communication.custom.parser.LifelineCustomParsers;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintNameEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationLabelEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationStereotypeLabelEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationNameEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationStereotypeLabelEditPartCN;
import org.eclipse.papyrus.diagram.communication.parsers.MessageFormatParser;
import org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser interactionName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getInteractionName_5001Parser() {
		if(interactionName_5001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("sd: {0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			interactionName_5001Parser = parser;
		}
		return interactionName_5001Parser;
	}

	/**
	 * @generated
	 */
	private LifelineCustomParsers lifelineName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getLifelineName_5002Parser() {
		if(lifelineName_5002Parser == null) {
			lifelineName_5002Parser = new LifelineCustomParsers();
		}
		return lifelineName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser constraintName_5064Parser;

	/**
	 * @generated
	 */
	private IParser getConstraintName_5064Parser() {
		if(constraintName_5064Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			constraintName_5064Parser = parser;
		}
		return constraintName_5064Parser;
	}

	/**
	 * @generated
	 */
	private CommentParser commentBody_5150Parser;

	/**
	 * @generated
	 */
	private IParser getCommentBody_5150Parser() {
		if(commentBody_5150Parser == null) {
			commentBody_5150Parser = new CommentParser();
		}
		return commentBody_5150Parser;
	}

	/**
	 * @generated
	 */
	private IParser timeObservationName_5153Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_5153Parser() {
		if(timeObservationName_5153Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			timeObservationName_5153Parser = parser;
		}
		return timeObservationName_5153Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser timeObservationName_5154Parser;

	/**
	 * @generated
	 */
	private IParser getTimeObservationName_5154Parser() {
		if(timeObservationName_5154Parser == null) {
			timeObservationName_5154Parser = new AppliedStereotypeParser();
		}
		return timeObservationName_5154Parser;
	}

	/**
	 * @generated
	 */
	private IParser durationObservationName_5155Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationName_5155Parser() {
		if(durationObservationName_5155Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			durationObservationName_5155Parser = parser;
		}
		return durationObservationName_5155Parser;
	}

	/**
	 * @generated
	 */
	private AppliedStereotypeParser durationObservationName_5156Parser;

	/**
	 * @generated
	 */
	private IParser getDurationObservationName_5156Parser() {
		if(durationObservationName_5156Parser == null) {
			durationObservationName_5156Parser = new AppliedStereotypeParser();
		}
		return durationObservationName_5156Parser;
	}

	/**
	 * @generated
	 */
	private IParser messageName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getMessageName_6001Parser() {
		if(messageName_6001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			messageName_6001Parser = parser;
		}
		return messageName_6001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case InteractionNameEditPart.VISUAL_ID:
			return getInteractionName_5001Parser();
		case LifelineNameEditPart.VISUAL_ID:
			return getLifelineName_5002Parser();
		case ConstraintNameEditPartCN.VISUAL_ID:
			return getConstraintName_5064Parser();
		case CommentBodyEditPartCN.VISUAL_ID:
			return getCommentBody_5150Parser();
		case TimeObservationNameEditPartCN.VISUAL_ID:
			return getTimeObservationName_5153Parser();
		case TimeObservationStereotypeLabelEditPartCN.VISUAL_ID:
			return getTimeObservationName_5154Parser();
		case DurationObservationLabelEditPartCN.VISUAL_ID:
			return getDurationObservationName_5155Parser();
		case DurationObservationStereotypeLabelEditPartCN.VISUAL_ID:
			return getDurationObservationName_5156Parser();
		case MessageNameEditPart.VISUAL_ID:
			return getMessageName_6001Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String)hint.getAdapter(String.class);
		if(vid != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(vid));
		}
		View view = (View)hint.getAdapter(View.class);
		if(view != null) {
			return getParser(UMLVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation)operation).getHint();
			if(UMLElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if(IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
