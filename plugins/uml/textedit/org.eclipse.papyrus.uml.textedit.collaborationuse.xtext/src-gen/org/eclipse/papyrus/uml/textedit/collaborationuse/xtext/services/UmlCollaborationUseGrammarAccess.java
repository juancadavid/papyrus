/*
* generated by Xtext
*/

package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.services;

import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class UmlCollaborationUseGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class CollaborationUseRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CollaborationUseRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVisibilityAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cVisibilityVisibilityKindEnumRuleCall_0_0 = (RuleCall)cVisibilityAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cColonKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Alternatives cAlternatives_3 = (Alternatives)cGroup.eContents().get(3);
		private final Assignment cTypeAssignment_3_0 = (Assignment)cAlternatives_3.eContents().get(0);
		private final RuleCall cTypeTypeRuleParserRuleCall_3_0_0 = (RuleCall)cTypeAssignment_3_0.eContents().get(0);
		private final Keyword cUndefinedKeyword_3_1 = (Keyword)cAlternatives_3.eContents().get(1);
		
		//CollaborationUseRule:
		//	visibility=VisibilityKind name=ID ":" (type=TypeRule | "<Undefined>");
		public ParserRule getRule() { return rule; }

		//visibility=VisibilityKind name=ID ":" (type=TypeRule | "<Undefined>")
		public Group getGroup() { return cGroup; }

		//visibility=VisibilityKind
		public Assignment getVisibilityAssignment_0() { return cVisibilityAssignment_0; }

		//VisibilityKind
		public RuleCall getVisibilityVisibilityKindEnumRuleCall_0_0() { return cVisibilityVisibilityKindEnumRuleCall_0_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//":"
		public Keyword getColonKeyword_2() { return cColonKeyword_2; }

		//type=TypeRule | "<Undefined>"
		public Alternatives getAlternatives_3() { return cAlternatives_3; }

		//type=TypeRule
		public Assignment getTypeAssignment_3_0() { return cTypeAssignment_3_0; }

		//TypeRule
		public RuleCall getTypeTypeRuleParserRuleCall_3_0_0() { return cTypeTypeRuleParserRuleCall_3_0_0; }

		//"<Undefined>"
		public Keyword getUndefinedKeyword_3_1() { return cUndefinedKeyword_3_1; }
	}

	public class TypeRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TypeRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cPathAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cPathQualifiedNameParserRuleCall_0_0 = (RuleCall)cPathAssignment_0.eContents().get(0);
		private final Assignment cTypeAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cTypeCollaborationCrossReference_1_0 = (CrossReference)cTypeAssignment_1.eContents().get(0);
		private final RuleCall cTypeCollaborationIDTerminalRuleCall_1_0_1 = (RuleCall)cTypeCollaborationCrossReference_1_0.eContents().get(1);
		
		//TypeRule:
		//	path=QualifiedName? type=[uml::Collaboration];
		public ParserRule getRule() { return rule; }

		//path=QualifiedName? type=[uml::Collaboration]
		public Group getGroup() { return cGroup; }

		//path=QualifiedName?
		public Assignment getPathAssignment_0() { return cPathAssignment_0; }

		//QualifiedName
		public RuleCall getPathQualifiedNameParserRuleCall_0_0() { return cPathQualifiedNameParserRuleCall_0_0; }

		//type=[uml::Collaboration]
		public Assignment getTypeAssignment_1() { return cTypeAssignment_1; }

		//[uml::Collaboration]
		public CrossReference getTypeCollaborationCrossReference_1_0() { return cTypeCollaborationCrossReference_1_0; }

		//ID
		public RuleCall getTypeCollaborationIDTerminalRuleCall_1_0_1() { return cTypeCollaborationIDTerminalRuleCall_1_0_1; }
	}
	
	
	private CollaborationUseRuleElements pCollaborationUseRule;
	private TypeRuleElements pTypeRule;
	
	private final GrammarProvider grammarProvider;

	private UmlCommonGrammarAccess gaUmlCommon;

	@Inject
	public UmlCollaborationUseGrammarAccess(GrammarProvider grammarProvider,
		UmlCommonGrammarAccess gaUmlCommon) {
		this.grammarProvider = grammarProvider;
		this.gaUmlCommon = gaUmlCommon;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public UmlCommonGrammarAccess getUmlCommonGrammarAccess() {
		return gaUmlCommon;
	}

	
	//CollaborationUseRule:
	//	visibility=VisibilityKind name=ID ":" (type=TypeRule | "<Undefined>");
	public CollaborationUseRuleElements getCollaborationUseRuleAccess() {
		return (pCollaborationUseRule != null) ? pCollaborationUseRule : (pCollaborationUseRule = new CollaborationUseRuleElements());
	}
	
	public ParserRule getCollaborationUseRuleRule() {
		return getCollaborationUseRuleAccess().getRule();
	}

	//TypeRule:
	//	path=QualifiedName? type=[uml::Collaboration];
	public TypeRuleElements getTypeRuleAccess() {
		return (pTypeRule != null) ? pTypeRule : (pTypeRule = new TypeRuleElements());
	}
	
	public ParserRule getTypeRuleRule() {
		return getTypeRuleAccess().getRule();
	}

	//QualifiedName:
	//	path=[uml::Namespace] "::" remaining=QualifiedName?;
	public UmlCommonGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaUmlCommon.getQualifiedNameAccess();
	}
	
	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	//enum VisibilityKind:
	//	public="+" | private="-" | protected="#" | package="~";
	public UmlCommonGrammarAccess.VisibilityKindElements getVisibilityKindAccess() {
		return gaUmlCommon.getVisibilityKindAccess();
	}
	
	public EnumRule getVisibilityKindRule() {
		return getVisibilityKindAccess().getRule();
	}

	//MultiplicityRule:
	//	"[" bounds+=BoundSpecification (".." bounds+=BoundSpecification)? "]";
	public UmlCommonGrammarAccess.MultiplicityRuleElements getMultiplicityRuleAccess() {
		return gaUmlCommon.getMultiplicityRuleAccess();
	}
	
	public ParserRule getMultiplicityRuleRule() {
		return getMultiplicityRuleAccess().getRule();
	}

	//BoundSpecification:
	//	value=UnlimitedLiteral;
	public UmlCommonGrammarAccess.BoundSpecificationElements getBoundSpecificationAccess() {
		return gaUmlCommon.getBoundSpecificationAccess();
	}
	
	public ParserRule getBoundSpecificationRule() {
		return getBoundSpecificationAccess().getRule();
	}

	//UnlimitedLiteral returns ecore::EString:
	//	INT | "*";
	public UmlCommonGrammarAccess.UnlimitedLiteralElements getUnlimitedLiteralAccess() {
		return gaUmlCommon.getUnlimitedLiteralAccess();
	}
	
	public ParserRule getUnlimitedLiteralRule() {
		return getUnlimitedLiteralAccess().getRule();
	}

	//enum Direction:
	//	IN="in" | OUT="out" | INOUT="inout" | RETURN="return";
	public UmlCommonGrammarAccess.DirectionElements getDirectionAccess() {
		return gaUmlCommon.getDirectionAccess();
	}
	
	public EnumRule getDirectionRule() {
		return getDirectionAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaUmlCommon.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaUmlCommon.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaUmlCommon.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaUmlCommon.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaUmlCommon.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaUmlCommon.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaUmlCommon.getANY_OTHERRule();
	} 
}