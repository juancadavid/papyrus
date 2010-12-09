/*
* generated by Xtext
*/
grammar InternalUmlCommon;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package org.eclipse.papyrus.common.editor.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package org.eclipse.papyrus.common.editor.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.papyrus.common.editor.xtext.services.UmlCommonGrammarAccess;

}

@parser::members {
 
 	private UmlCommonGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(UmlCommonGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleQualifiedName
entryRuleQualifiedName 
:
{ before(grammarAccess.getQualifiedNameRule()); }
	 ruleQualifiedName
{ after(grammarAccess.getQualifiedNameRule()); } 
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getQualifiedNameAccess().getGroup()); }
(rule__QualifiedName__Group__0)
{ after(grammarAccess.getQualifiedNameAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}







// Entry rule entryRuleBoundSpecification
entryRuleBoundSpecification 
:
{ before(grammarAccess.getBoundSpecificationRule()); }
	 ruleBoundSpecification
{ after(grammarAccess.getBoundSpecificationRule()); } 
	 EOF 
;

// Rule BoundSpecification
ruleBoundSpecification
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); }
(rule__BoundSpecification__ValueAssignment)
{ after(grammarAccess.getBoundSpecificationAccess().getValueAssignment()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__QualifiedName__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__0__Impl
	rule__QualifiedName__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); }
(rule__QualifiedName__PathAssignment_0)
{ after(grammarAccess.getQualifiedNameAccess().getPathAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__1__Impl
	rule__QualifiedName__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); }

	'::' 

{ after(grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__QualifiedName__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__QualifiedName__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); }
(rule__QualifiedName__RemainingAssignment_2)?
{ after(grammarAccess.getQualifiedNameAccess().getRemainingAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}












rule__QualifiedName__PathAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); }
(
{ before(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); }
	RULE_ID{ after(grammarAccess.getQualifiedNameAccess().getPathNamespaceIDTerminalRuleCall_0_0_1()); }
)
{ after(grammarAccess.getQualifiedNameAccess().getPathNamespaceCrossReference_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__QualifiedName__RemainingAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); }
	ruleQualifiedName{ after(grammarAccess.getQualifiedNameAccess().getRemainingQualifiedNameParserRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}





rule__BoundSpecification__ValueAssignment
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); }
	RULE_UNLIMITEDLITERAL{ after(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralTerminalRuleCall_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_UNLIMITEDLITERAL : ('0'..'9' ('0'..'9')*|'*');

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


