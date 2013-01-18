/*
* generated by Xtext
*/
package org.eclipse.papyrus.collaborationuse.editor.xtext.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.eclipse.papyrus.collaborationuse.editor.xtext.services.UmlCollaborationUseGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlCollaborationUseParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private UmlCollaborationUseGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollaborationUseRule_Group(this, this, 0, inst);
			case 1: return new TypeRule_Group(this, this, 1, inst);
			case 2: return new QualifiedName_Group(this, this, 2, inst);
			case 3: return new MultiplicityRule_Group(this, this, 3, inst);
			case 4: return new BoundSpecification_ValueAssignment(this, this, 4, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule CollaborationUseRule ****************
 *
 * CollaborationUseRule:
 * 	visibility=VisibilityKind name=ID ":" (type=TypeRule | "<Undefined>");
 *
 **/

// visibility=VisibilityKind name=ID ":" (type=TypeRule | "<Undefined>")
protected class CollaborationUseRule_Group extends GroupToken {
	
	public CollaborationUseRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getCollaborationUseRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollaborationUseRule_Alternatives_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getCollaborationUseRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// visibility=VisibilityKind
protected class CollaborationUseRule_VisibilityAssignment_0 extends AssignmentToken  {
	
	public CollaborationUseRule_VisibilityAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollaborationUseRuleAccess().getVisibilityAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("visibility",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("visibility");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getCollaborationUseRuleAccess().getVisibilityVisibilityKindEnumRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// name=ID
protected class CollaborationUseRule_NameAssignment_1 extends AssignmentToken  {
	
	public CollaborationUseRule_NameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollaborationUseRuleAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollaborationUseRule_VisibilityAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getCollaborationUseRuleAccess().getNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// ":"
protected class CollaborationUseRule_ColonKeyword_2 extends KeywordToken  {
	
	public CollaborationUseRule_ColonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollaborationUseRuleAccess().getColonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollaborationUseRule_NameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// type=TypeRule | "<Undefined>"
protected class CollaborationUseRule_Alternatives_3 extends AlternativesToken {

	public CollaborationUseRule_Alternatives_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Alternatives getGrammarElement() {
		return grammarAccess.getCollaborationUseRuleAccess().getAlternatives_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollaborationUseRule_TypeAssignment_3_0(lastRuleCallOrigin, this, 0, inst);
			case 1: return new CollaborationUseRule_UndefinedKeyword_3_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// type=TypeRule
protected class CollaborationUseRule_TypeAssignment_3_0 extends AssignmentToken  {
	
	public CollaborationUseRule_TypeAssignment_3_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getCollaborationUseRuleAccess().getTypeAssignment_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypeRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeRuleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getCollaborationUseRuleAccess().getTypeTypeRuleParserRuleCall_3_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new CollaborationUseRule_ColonKeyword_2(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "<Undefined>"
protected class CollaborationUseRule_UndefinedKeyword_3_1 extends KeywordToken  {
	
	public CollaborationUseRule_UndefinedKeyword_3_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getCollaborationUseRuleAccess().getUndefinedKeyword_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new CollaborationUseRule_ColonKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}



/************ end Rule CollaborationUseRule ****************/


/************ begin Rule TypeRule ****************
 *
 * TypeRule:
 * 	path=QualifiedName? type=[uml::Collaboration];
 *
 **/

// path=QualifiedName? type=[uml::Collaboration]
protected class TypeRule_Group extends GroupToken {
	
	public TypeRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTypeRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypeRule_TypeAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTypeRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// path=QualifiedName?
protected class TypeRule_PathAssignment_0 extends AssignmentToken  {
	
	public TypeRule_PathAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeRuleAccess().getPathAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedName_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("path",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("path");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTypeRuleAccess().getPathQualifiedNameParserRuleCall_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index, consumed);
		}	
	}	
}

// type=[uml::Collaboration]
protected class TypeRule_TypeAssignment_1 extends AssignmentToken  {
	
	public TypeRule_TypeAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeRuleAccess().getTypeAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new TypeRule_PathAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 1, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getTypeRuleAccess().getTypeCollaborationCrossReference_1_0(); 
				return obj;
			}
		}
		return null;
	}

}


/************ end Rule TypeRule ****************/


/************ begin Rule QualifiedName ****************
 *
 * QualifiedName:
 * 	path=[uml::Namespace] "::" remaining=QualifiedName?;
 *
 **/

// path=[uml::Namespace] "::" remaining=QualifiedName?
protected class QualifiedName_Group extends GroupToken {
	
	public QualifiedName_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getQualifiedNameAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedName_RemainingAssignment_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new QualifiedName_ColonColonKeyword_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getQualifiedNameRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// path=[uml::Namespace]
protected class QualifiedName_PathAssignment_0 extends AssignmentToken  {
	
	public QualifiedName_PathAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNameAccess().getPathAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("path",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("path");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0(); 
				return obj;
			}
		}
		return null;
	}

}

// "::"
protected class QualifiedName_ColonColonKeyword_1 extends KeywordToken  {
	
	public QualifiedName_ColonColonKeyword_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedName_PathAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// remaining=QualifiedName?
protected class QualifiedName_RemainingAssignment_2 extends AssignmentToken  {
	
	public QualifiedName_RemainingAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new QualifiedName_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("remaining",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("remaining");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getQualifiedNameRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new QualifiedName_ColonColonKeyword_1(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


/************ end Rule QualifiedName ****************/


/************ begin Rule MultiplicityRule ****************
 *
 * MultiplicityRule:
 * 	"[" bounds+=BoundSpecification (".." bounds+=BoundSpecification)? "]";
 *
 **/

// "[" bounds+=BoundSpecification (".." bounds+=BoundSpecification)? "]"
protected class MultiplicityRule_Group extends GroupToken {
	
	public MultiplicityRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicityRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRule_RightSquareBracketKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getMultiplicityRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "["
protected class MultiplicityRule_LeftSquareBracketKeyword_0 extends KeywordToken  {
	
	public MultiplicityRule_LeftSquareBracketKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getMultiplicityRuleAccess().getLeftSquareBracketKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// bounds+=BoundSpecification
protected class MultiplicityRule_BoundsAssignment_1 extends AssignmentToken  {
	
	public MultiplicityRule_BoundsAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BoundSpecification_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("bounds",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("bounds");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBoundSpecificationRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new MultiplicityRule_LeftSquareBracketKeyword_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// (".." bounds+=BoundSpecification)?
protected class MultiplicityRule_Group_2 extends GroupToken {
	
	public MultiplicityRule_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getMultiplicityRuleAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRule_BoundsAssignment_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// ".."
protected class MultiplicityRule_FullStopFullStopKeyword_2_0 extends KeywordToken  {
	
	public MultiplicityRule_FullStopFullStopKeyword_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getMultiplicityRuleAccess().getFullStopFullStopKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRule_BoundsAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// bounds+=BoundSpecification
protected class MultiplicityRule_BoundsAssignment_2_1 extends AssignmentToken  {
	
	public MultiplicityRule_BoundsAssignment_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getMultiplicityRuleAccess().getBoundsAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new BoundSpecification_ValueAssignment(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("bounds",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("bounds");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getBoundSpecificationRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getMultiplicityRuleAccess().getBoundsBoundSpecificationParserRuleCall_2_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new MultiplicityRule_FullStopFullStopKeyword_2_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}


// "]"
protected class MultiplicityRule_RightSquareBracketKeyword_3 extends KeywordToken  {
	
	public MultiplicityRule_RightSquareBracketKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getMultiplicityRuleAccess().getRightSquareBracketKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new MultiplicityRule_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new MultiplicityRule_BoundsAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}


/************ end Rule MultiplicityRule ****************/


/************ begin Rule BoundSpecification ****************
 *
 * BoundSpecification:
 * 	value=UnlimitedLiteral;
 *
 **/

// value=UnlimitedLiteral
protected class BoundSpecification_ValueAssignment extends AssignmentToken  {
	
	public BoundSpecification_ValueAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getBoundSpecificationAccess().getValueAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getBoundSpecificationRule().getType().getClassifier())
			return null;
		if((value = eObjectConsumer.getConsumable("value",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("value");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0();
			return obj;
		}
		return null;
	}

}

/************ end Rule BoundSpecification ****************/

}