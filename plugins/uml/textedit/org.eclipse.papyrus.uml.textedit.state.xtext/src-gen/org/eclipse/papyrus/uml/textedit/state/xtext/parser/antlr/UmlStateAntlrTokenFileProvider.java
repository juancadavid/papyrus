/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.state.xtext.parser.antlr;

import java.io.InputStream;

import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class UmlStateAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/eclipse/papyrus/uml/textedit/state/xtext/parser/antlr/internal/InternalUmlState.tokens");
	}
}
