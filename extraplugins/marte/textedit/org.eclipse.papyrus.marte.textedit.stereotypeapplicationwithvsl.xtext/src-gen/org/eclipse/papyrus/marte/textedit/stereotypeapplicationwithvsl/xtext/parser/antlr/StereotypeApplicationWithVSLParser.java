/*
* generated by Xtext
*/
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.services.StereotypeApplicationWithVSLGrammarAccess;

public class StereotypeApplicationWithVSLParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private StereotypeApplicationWithVSLGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.parser.antlr.internal.InternalStereotypeApplicationWithVSLParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.parser.antlr.internal.InternalStereotypeApplicationWithVSLParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "StereotypeApplicationsRule";
	}
	
	public StereotypeApplicationWithVSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(StereotypeApplicationWithVSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}