/*
* generated by Xtext
*/
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class StereotypeApplicationWithVSLAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/papyrus/stereotypeapplicationwithvsl/editor/xtext/parser/antlr/internal/InternalStereotypeApplicationWithVSL.tokens");
	}
}