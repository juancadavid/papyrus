package org.eclipse.papyrus.alf.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.papyrus.alf.services.AlfGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAlfParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INTEGERVALUE", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER", "'testExpression'", "'testAssignmentExpression'", "'testStatement'", "'testBlock'", "'*'", "'++'", "'--'", "'::'", "'<'", "','", "'>'", "'=>'", "'('", "')'", "'?'", "':'", "'||'", "'&&'", "'|'", "'^'", "'&'", "'=='", "'!='", "'instanceof'", "'hastype'", "'<='", "'>='", "'<<'", "'>>'", "'>>>'", "'+'", "'-'", "'/'", "'%'", "'!'", "'$'", "'~'", "'.'", "'['", "']'", "'->'", "'reduce'", "'ordered'", "'isUnique'", "'null'", "'this'", "'super'", "'new'", "'{'", "'..'", "'}'", "'allInstances'", "'/*@'", "'inline'", "'*/'", "'//@'", "';'", "'let'", "'='", "'if'", "'else'", "'or'", "'switch'", "'case'", "'default'", "'while'", "'do'", "'for'", "'in'", "'break'", "'return'", "'accept'", "'classify'", "'from'", "'to'", "'true'", "'false'", "'createLink'", "'destroyLink'", "'clearAssoc'", "'select'", "'reject'", "'collect'", "'iterate'", "'forAll'", "'exists'", "'one'", "'isolated'", "'determined'", "'assured'", "'parallel'", "'+='", "'-='", "'*='", "'%='", "'/='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'>>>='"
    };
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int RULE_INTEGERVALUE=4;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=9;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalAlfParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAlfParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAlfParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g"; }



     	private AlfGrammarAccess grammarAccess;
     	
        public InternalAlfParser(TokenStream input, AlfGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Test";	
       	}
       	
       	@Override
       	protected AlfGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTest"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:68:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:69:2: (iv_ruleTest= ruleTest EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:70:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest75);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:77:1: ruleTest returns [EObject current=null] : ( (otherlv_0= 'testExpression' ( (lv_expression_1_0= ruleExpression ) ) )* (otherlv_2= 'testAssignmentExpression' ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) ) )* (otherlv_4= 'testStatement' ( (lv_statements_5_0= ruleStatement ) ) )* (otherlv_6= 'testBlock' ( (lv_block_7_0= ruleBlock ) ) ) ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_1_0 = null;

        EObject lv_assignExpression_3_0 = null;

        EObject lv_statements_5_0 = null;

        EObject lv_block_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:80:28: ( ( (otherlv_0= 'testExpression' ( (lv_expression_1_0= ruleExpression ) ) )* (otherlv_2= 'testAssignmentExpression' ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) ) )* (otherlv_4= 'testStatement' ( (lv_statements_5_0= ruleStatement ) ) )* (otherlv_6= 'testBlock' ( (lv_block_7_0= ruleBlock ) ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:81:1: ( (otherlv_0= 'testExpression' ( (lv_expression_1_0= ruleExpression ) ) )* (otherlv_2= 'testAssignmentExpression' ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) ) )* (otherlv_4= 'testStatement' ( (lv_statements_5_0= ruleStatement ) ) )* (otherlv_6= 'testBlock' ( (lv_block_7_0= ruleBlock ) ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:81:1: ( (otherlv_0= 'testExpression' ( (lv_expression_1_0= ruleExpression ) ) )* (otherlv_2= 'testAssignmentExpression' ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) ) )* (otherlv_4= 'testStatement' ( (lv_statements_5_0= ruleStatement ) ) )* (otherlv_6= 'testBlock' ( (lv_block_7_0= ruleBlock ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:81:2: (otherlv_0= 'testExpression' ( (lv_expression_1_0= ruleExpression ) ) )* (otherlv_2= 'testAssignmentExpression' ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) ) )* (otherlv_4= 'testStatement' ( (lv_statements_5_0= ruleStatement ) ) )* (otherlv_6= 'testBlock' ( (lv_block_7_0= ruleBlock ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:81:2: (otherlv_0= 'testExpression' ( (lv_expression_1_0= ruleExpression ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:81:4: otherlv_0= 'testExpression' ( (lv_expression_1_0= ruleExpression ) )
            	    {
            	    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleTest123); 

            	        	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestExpressionKeyword_0_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:85:1: ( (lv_expression_1_0= ruleExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:86:1: (lv_expression_1_0= ruleExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:86:1: (lv_expression_1_0= ruleExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:87:3: lv_expression_1_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getExpressionExpressionParserRuleCall_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleTest144);
            	    lv_expression_1_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expression",
            	            		lv_expression_1_0, 
            	            		"Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:103:4: (otherlv_2= 'testAssignmentExpression' ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:103:6: otherlv_2= 'testAssignmentExpression' ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleTest159); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTestAccess().getTestAssignmentExpressionKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:107:1: ( (lv_assignExpression_3_0= ruleAssignmentCompletion ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:108:1: (lv_assignExpression_3_0= ruleAssignmentCompletion )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:108:1: (lv_assignExpression_3_0= ruleAssignmentCompletion )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:109:3: lv_assignExpression_3_0= ruleAssignmentCompletion
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getAssignExpressionAssignmentCompletionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssignmentCompletion_in_ruleTest180);
            	    lv_assignExpression_3_0=ruleAssignmentCompletion();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"assignExpression",
            	            		lv_assignExpression_3_0, 
            	            		"AssignmentCompletion");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:125:4: (otherlv_4= 'testStatement' ( (lv_statements_5_0= ruleStatement ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:125:6: otherlv_4= 'testStatement' ( (lv_statements_5_0= ruleStatement ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleTest195); 

            	        	newLeafNode(otherlv_4, grammarAccess.getTestAccess().getTestStatementKeyword_2_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:129:1: ( (lv_statements_5_0= ruleStatement ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:130:1: (lv_statements_5_0= ruleStatement )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:130:1: (lv_statements_5_0= ruleStatement )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:131:3: lv_statements_5_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getStatementsStatementParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleTest216);
            	    lv_statements_5_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_5_0, 
            	            		"Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:147:4: (otherlv_6= 'testBlock' ( (lv_block_7_0= ruleBlock ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:147:6: otherlv_6= 'testBlock' ( (lv_block_7_0= ruleBlock ) )
            {
            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleTest231); 

                	newLeafNode(otherlv_6, grammarAccess.getTestAccess().getTestBlockKeyword_3_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:151:1: ( (lv_block_7_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:152:1: (lv_block_7_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:152:1: (lv_block_7_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:153:3: lv_block_7_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getTestAccess().getBlockBlockParserRuleCall_3_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleTest252);
            lv_block_7_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_7_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleLITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:177:1: entryRuleLITERAL returns [EObject current=null] : iv_ruleLITERAL= ruleLITERAL EOF ;
    public final EObject entryRuleLITERAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLITERAL = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:178:2: (iv_ruleLITERAL= ruleLITERAL EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:179:2: iv_ruleLITERAL= ruleLITERAL EOF
            {
             newCompositeNode(grammarAccess.getLITERALRule()); 
            pushFollow(FOLLOW_ruleLITERAL_in_entryRuleLITERAL289);
            iv_ruleLITERAL=ruleLITERAL();

            state._fsp--;

             current =iv_ruleLITERAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLITERAL299); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLITERAL"


    // $ANTLR start "ruleLITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:186:1: ruleLITERAL returns [EObject current=null] : (this_BOOLEAN_LITERAL_0= ruleBOOLEAN_LITERAL | this_NUMBER_LITERAL_1= ruleNUMBER_LITERAL | this_STRING_LITERAL_2= ruleSTRING_LITERAL ) ;
    public final EObject ruleLITERAL() throws RecognitionException {
        EObject current = null;

        EObject this_BOOLEAN_LITERAL_0 = null;

        EObject this_NUMBER_LITERAL_1 = null;

        EObject this_STRING_LITERAL_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:189:28: ( (this_BOOLEAN_LITERAL_0= ruleBOOLEAN_LITERAL | this_NUMBER_LITERAL_1= ruleNUMBER_LITERAL | this_STRING_LITERAL_2= ruleSTRING_LITERAL ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:190:1: (this_BOOLEAN_LITERAL_0= ruleBOOLEAN_LITERAL | this_NUMBER_LITERAL_1= ruleNUMBER_LITERAL | this_STRING_LITERAL_2= ruleSTRING_LITERAL )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:190:1: (this_BOOLEAN_LITERAL_0= ruleBOOLEAN_LITERAL | this_NUMBER_LITERAL_1= ruleNUMBER_LITERAL | this_STRING_LITERAL_2= ruleSTRING_LITERAL )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 87:
            case 88:
                {
                alt4=1;
                }
                break;
            case RULE_INTEGERVALUE:
            case 16:
                {
                alt4=2;
                }
                break;
            case RULE_STRING:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:191:5: this_BOOLEAN_LITERAL_0= ruleBOOLEAN_LITERAL
                    {
                     
                            newCompositeNode(grammarAccess.getLITERALAccess().getBOOLEAN_LITERALParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBOOLEAN_LITERAL_in_ruleLITERAL346);
                    this_BOOLEAN_LITERAL_0=ruleBOOLEAN_LITERAL();

                    state._fsp--;

                     
                            current = this_BOOLEAN_LITERAL_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:201:5: this_NUMBER_LITERAL_1= ruleNUMBER_LITERAL
                    {
                     
                            newCompositeNode(grammarAccess.getLITERALAccess().getNUMBER_LITERALParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNUMBER_LITERAL_in_ruleLITERAL373);
                    this_NUMBER_LITERAL_1=ruleNUMBER_LITERAL();

                    state._fsp--;

                     
                            current = this_NUMBER_LITERAL_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:211:5: this_STRING_LITERAL_2= ruleSTRING_LITERAL
                    {
                     
                            newCompositeNode(grammarAccess.getLITERALAccess().getSTRING_LITERALParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSTRING_LITERAL_in_ruleLITERAL400);
                    this_STRING_LITERAL_2=ruleSTRING_LITERAL();

                    state._fsp--;

                     
                            current = this_STRING_LITERAL_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLITERAL"


    // $ANTLR start "entryRuleBOOLEAN_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:227:1: entryRuleBOOLEAN_LITERAL returns [EObject current=null] : iv_ruleBOOLEAN_LITERAL= ruleBOOLEAN_LITERAL EOF ;
    public final EObject entryRuleBOOLEAN_LITERAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBOOLEAN_LITERAL = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:228:2: (iv_ruleBOOLEAN_LITERAL= ruleBOOLEAN_LITERAL EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:229:2: iv_ruleBOOLEAN_LITERAL= ruleBOOLEAN_LITERAL EOF
            {
             newCompositeNode(grammarAccess.getBOOLEAN_LITERALRule()); 
            pushFollow(FOLLOW_ruleBOOLEAN_LITERAL_in_entryRuleBOOLEAN_LITERAL435);
            iv_ruleBOOLEAN_LITERAL=ruleBOOLEAN_LITERAL();

            state._fsp--;

             current =iv_ruleBOOLEAN_LITERAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBOOLEAN_LITERAL445); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOLEAN_LITERAL"


    // $ANTLR start "ruleBOOLEAN_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:236:1: ruleBOOLEAN_LITERAL returns [EObject current=null] : ( ( (lv_value_0_0= ruleBooleanValue ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleBOOLEAN_LITERAL() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;

        EObject lv_suffix_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:239:28: ( ( ( (lv_value_0_0= ruleBooleanValue ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:240:1: ( ( (lv_value_0_0= ruleBooleanValue ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:240:1: ( ( (lv_value_0_0= ruleBooleanValue ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:240:2: ( (lv_value_0_0= ruleBooleanValue ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:240:2: ( (lv_value_0_0= ruleBooleanValue ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:241:1: (lv_value_0_0= ruleBooleanValue )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:241:1: (lv_value_0_0= ruleBooleanValue )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:242:3: lv_value_0_0= ruleBooleanValue
            {
             
            	        newCompositeNode(grammarAccess.getBOOLEAN_LITERALAccess().getValueBooleanValueEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleBooleanValue_in_ruleBOOLEAN_LITERAL491);
            lv_value_0_0=ruleBooleanValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBOOLEAN_LITERALRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"BooleanValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:258:2: ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==49||LA5_0==52) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:259:1: (lv_suffix_1_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:259:1: (lv_suffix_1_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:260:3: lv_suffix_1_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getBOOLEAN_LITERALAccess().getSuffixSuffixExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleBOOLEAN_LITERAL512);
                    lv_suffix_1_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBOOLEAN_LITERALRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_1_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOLEAN_LITERAL"


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:284:1: entryRuleNUMBER_LITERAL returns [EObject current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final EObject entryRuleNUMBER_LITERAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNUMBER_LITERAL = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:285:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:286:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
             newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            pushFollow(FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL549);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;

             current =iv_ruleNUMBER_LITERAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMBER_LITERAL559); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNUMBER_LITERAL"


    // $ANTLR start "ruleNUMBER_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:293:1: ruleNUMBER_LITERAL returns [EObject current=null] : (this_INTEGER_LITERAL_0= ruleINTEGER_LITERAL | this_UNLIMITED_LITERAL_1= ruleUNLIMITED_LITERAL ) ;
    public final EObject ruleNUMBER_LITERAL() throws RecognitionException {
        EObject current = null;

        EObject this_INTEGER_LITERAL_0 = null;

        EObject this_UNLIMITED_LITERAL_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:296:28: ( (this_INTEGER_LITERAL_0= ruleINTEGER_LITERAL | this_UNLIMITED_LITERAL_1= ruleUNLIMITED_LITERAL ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:297:1: (this_INTEGER_LITERAL_0= ruleINTEGER_LITERAL | this_UNLIMITED_LITERAL_1= ruleUNLIMITED_LITERAL )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:297:1: (this_INTEGER_LITERAL_0= ruleINTEGER_LITERAL | this_UNLIMITED_LITERAL_1= ruleUNLIMITED_LITERAL )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_INTEGERVALUE) ) {
                alt6=1;
            }
            else if ( (LA6_0==16) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:298:5: this_INTEGER_LITERAL_0= ruleINTEGER_LITERAL
                    {
                     
                            newCompositeNode(grammarAccess.getNUMBER_LITERALAccess().getINTEGER_LITERALParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_ruleNUMBER_LITERAL606);
                    this_INTEGER_LITERAL_0=ruleINTEGER_LITERAL();

                    state._fsp--;

                     
                            current = this_INTEGER_LITERAL_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:308:5: this_UNLIMITED_LITERAL_1= ruleUNLIMITED_LITERAL
                    {
                     
                            newCompositeNode(grammarAccess.getNUMBER_LITERALAccess().getUNLIMITED_LITERALParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleUNLIMITED_LITERAL_in_ruleNUMBER_LITERAL633);
                    this_UNLIMITED_LITERAL_1=ruleUNLIMITED_LITERAL();

                    state._fsp--;

                     
                            current = this_UNLIMITED_LITERAL_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNUMBER_LITERAL"


    // $ANTLR start "entryRuleINTEGER_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:324:1: entryRuleINTEGER_LITERAL returns [EObject current=null] : iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF ;
    public final EObject entryRuleINTEGER_LITERAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleINTEGER_LITERAL = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:325:2: (iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:326:2: iv_ruleINTEGER_LITERAL= ruleINTEGER_LITERAL EOF
            {
             newCompositeNode(grammarAccess.getINTEGER_LITERALRule()); 
            pushFollow(FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL668);
            iv_ruleINTEGER_LITERAL=ruleINTEGER_LITERAL();

            state._fsp--;

             current =iv_ruleINTEGER_LITERAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTEGER_LITERAL678); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTEGER_LITERAL"


    // $ANTLR start "ruleINTEGER_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:333:1: ruleINTEGER_LITERAL returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGERVALUE ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleINTEGER_LITERAL() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_suffix_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:336:28: ( ( ( (lv_value_0_0= RULE_INTEGERVALUE ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:337:1: ( ( (lv_value_0_0= RULE_INTEGERVALUE ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:337:1: ( ( (lv_value_0_0= RULE_INTEGERVALUE ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:337:2: ( (lv_value_0_0= RULE_INTEGERVALUE ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:337:2: ( (lv_value_0_0= RULE_INTEGERVALUE ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:338:1: (lv_value_0_0= RULE_INTEGERVALUE )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:338:1: (lv_value_0_0= RULE_INTEGERVALUE )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:339:3: lv_value_0_0= RULE_INTEGERVALUE
            {
            lv_value_0_0=(Token)match(input,RULE_INTEGERVALUE,FOLLOW_RULE_INTEGERVALUE_in_ruleINTEGER_LITERAL720); 

            			newLeafNode(lv_value_0_0, grammarAccess.getINTEGER_LITERALAccess().getValueIntegerValueTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getINTEGER_LITERALRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"IntegerValue");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:355:2: ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==49||LA7_0==52) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:356:1: (lv_suffix_1_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:356:1: (lv_suffix_1_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:357:3: lv_suffix_1_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getINTEGER_LITERALAccess().getSuffixSuffixExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleINTEGER_LITERAL746);
                    lv_suffix_1_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getINTEGER_LITERALRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_1_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTEGER_LITERAL"


    // $ANTLR start "entryRuleUNLIMITED_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:381:1: entryRuleUNLIMITED_LITERAL returns [EObject current=null] : iv_ruleUNLIMITED_LITERAL= ruleUNLIMITED_LITERAL EOF ;
    public final EObject entryRuleUNLIMITED_LITERAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUNLIMITED_LITERAL = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:382:2: (iv_ruleUNLIMITED_LITERAL= ruleUNLIMITED_LITERAL EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:383:2: iv_ruleUNLIMITED_LITERAL= ruleUNLIMITED_LITERAL EOF
            {
             newCompositeNode(grammarAccess.getUNLIMITED_LITERALRule()); 
            pushFollow(FOLLOW_ruleUNLIMITED_LITERAL_in_entryRuleUNLIMITED_LITERAL783);
            iv_ruleUNLIMITED_LITERAL=ruleUNLIMITED_LITERAL();

            state._fsp--;

             current =iv_ruleUNLIMITED_LITERAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUNLIMITED_LITERAL793); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUNLIMITED_LITERAL"


    // $ANTLR start "ruleUNLIMITED_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:390:1: ruleUNLIMITED_LITERAL returns [EObject current=null] : ( ( (lv_value_0_0= '*' ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleUNLIMITED_LITERAL() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_suffix_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:393:28: ( ( ( (lv_value_0_0= '*' ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:394:1: ( ( (lv_value_0_0= '*' ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:394:1: ( ( (lv_value_0_0= '*' ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:394:2: ( (lv_value_0_0= '*' ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:394:2: ( (lv_value_0_0= '*' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:395:1: (lv_value_0_0= '*' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:395:1: (lv_value_0_0= '*' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:396:3: lv_value_0_0= '*'
            {
            lv_value_0_0=(Token)match(input,16,FOLLOW_16_in_ruleUNLIMITED_LITERAL836); 

                    newLeafNode(lv_value_0_0, grammarAccess.getUNLIMITED_LITERALAccess().getValueAsteriskKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUNLIMITED_LITERALRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "*");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:409:2: ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==49||LA8_0==52) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:410:1: (lv_suffix_1_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:410:1: (lv_suffix_1_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:411:3: lv_suffix_1_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUNLIMITED_LITERALAccess().getSuffixSuffixExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleUNLIMITED_LITERAL870);
                    lv_suffix_1_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUNLIMITED_LITERALRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_1_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUNLIMITED_LITERAL"


    // $ANTLR start "entryRuleSTRING_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:435:1: entryRuleSTRING_LITERAL returns [EObject current=null] : iv_ruleSTRING_LITERAL= ruleSTRING_LITERAL EOF ;
    public final EObject entryRuleSTRING_LITERAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSTRING_LITERAL = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:436:2: (iv_ruleSTRING_LITERAL= ruleSTRING_LITERAL EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:437:2: iv_ruleSTRING_LITERAL= ruleSTRING_LITERAL EOF
            {
             newCompositeNode(grammarAccess.getSTRING_LITERALRule()); 
            pushFollow(FOLLOW_ruleSTRING_LITERAL_in_entryRuleSTRING_LITERAL907);
            iv_ruleSTRING_LITERAL=ruleSTRING_LITERAL();

            state._fsp--;

             current =iv_ruleSTRING_LITERAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTRING_LITERAL917); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTRING_LITERAL"


    // $ANTLR start "ruleSTRING_LITERAL"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:444:1: ruleSTRING_LITERAL returns [EObject current=null] : ( ( (lv_value_0_0= RULE_STRING ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleSTRING_LITERAL() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        EObject lv_suffix_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:447:28: ( ( ( (lv_value_0_0= RULE_STRING ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:448:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:448:1: ( ( (lv_value_0_0= RULE_STRING ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:448:2: ( (lv_value_0_0= RULE_STRING ) ) ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:448:2: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:449:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:449:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:450:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSTRING_LITERAL959); 

            			newLeafNode(lv_value_0_0, grammarAccess.getSTRING_LITERALAccess().getValueSTRINGTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSTRING_LITERALRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:466:2: ( (lv_suffix_1_0= ruleSuffixExpression ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==49||LA9_0==52) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:467:1: (lv_suffix_1_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:467:1: (lv_suffix_1_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:468:3: lv_suffix_1_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSTRING_LITERALAccess().getSuffixSuffixExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleSTRING_LITERAL985);
                    lv_suffix_1_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSTRING_LITERALRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_1_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTRING_LITERAL"


    // $ANTLR start "entryRuleNameExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:492:1: entryRuleNameExpression returns [EObject current=null] : iv_ruleNameExpression= ruleNameExpression EOF ;
    public final EObject entryRuleNameExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:493:2: (iv_ruleNameExpression= ruleNameExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:494:2: iv_ruleNameExpression= ruleNameExpression EOF
            {
             newCompositeNode(grammarAccess.getNameExpressionRule()); 
            pushFollow(FOLLOW_ruleNameExpression_in_entryRuleNameExpression1022);
            iv_ruleNameExpression=ruleNameExpression();

            state._fsp--;

             current =iv_ruleNameExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameExpression1032); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameExpression"


    // $ANTLR start "ruleNameExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:501:1: ruleNameExpression returns [EObject current=null] : ( ( ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? ) ) ( (lv_suffix_8_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleNameExpression() throws RecognitionException {
        EObject current = null;

        Token lv_prefixOp_0_1=null;
        Token lv_prefixOp_0_2=null;
        Token lv_id_2_0=null;
        Token lv_id_4_0=null;
        Token lv_postfixOp_7_1=null;
        Token lv_postfixOp_7_2=null;
        EObject lv_path_1_0 = null;

        EObject lv_path_3_0 = null;

        EObject lv_invocationCompletion_5_0 = null;

        EObject lv_sequenceConstructionCompletion_6_0 = null;

        EObject lv_suffix_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:504:28: ( ( ( ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? ) ) ( (lv_suffix_8_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:1: ( ( ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? ) ) ( (lv_suffix_8_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:1: ( ( ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? ) ) ( (lv_suffix_8_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:2: ( ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? ) ) ( (lv_suffix_8_0= ruleSuffixExpression ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:2: ( ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) ) | ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=17 && LA15_0<=18)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:3: ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:3: ( ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:4: ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) ) ( (lv_path_1_0= ruleQualifiedNamePath ) )? ( (lv_id_2_0= RULE_ID ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:505:4: ( ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:506:1: ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:506:1: ( (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:507:1: (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:507:1: (lv_prefixOp_0_1= '++' | lv_prefixOp_0_2= '--' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==17) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==18) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:508:3: lv_prefixOp_0_1= '++'
                            {
                            lv_prefixOp_0_1=(Token)match(input,17,FOLLOW_17_in_ruleNameExpression1079); 

                                    newLeafNode(lv_prefixOp_0_1, grammarAccess.getNameExpressionAccess().getPrefixOpPlusSignPlusSignKeyword_0_0_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getNameExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "prefixOp", lv_prefixOp_0_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:520:8: lv_prefixOp_0_2= '--'
                            {
                            lv_prefixOp_0_2=(Token)match(input,18,FOLLOW_18_in_ruleNameExpression1108); 

                                    newLeafNode(lv_prefixOp_0_2, grammarAccess.getNameExpressionAccess().getPrefixOpHyphenMinusHyphenMinusKeyword_0_0_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getNameExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "prefixOp", lv_prefixOp_0_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:535:2: ( (lv_path_1_0= ruleQualifiedNamePath ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==RULE_ID) ) {
                        int LA11_1 = input.LA(2);

                        if ( (LA11_1==20) ) {
                            int LA11_3 = input.LA(3);

                            if ( (LA11_3==RULE_ID) ) {
                                int LA11_5 = input.LA(4);

                                if ( (LA11_5==23) ) {
                                    alt11=1;
                                }
                            }
                        }
                        else if ( (LA11_1==19) ) {
                            alt11=1;
                        }
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:536:1: (lv_path_1_0= ruleQualifiedNamePath )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:536:1: (lv_path_1_0= ruleQualifiedNamePath )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:537:3: lv_path_1_0= ruleQualifiedNamePath
                            {
                             
                            	        newCompositeNode(grammarAccess.getNameExpressionAccess().getPathQualifiedNamePathParserRuleCall_0_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifiedNamePath_in_ruleNameExpression1145);
                            lv_path_1_0=ruleQualifiedNamePath();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNameExpressionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"path",
                                    		lv_path_1_0, 
                                    		"QualifiedNamePath");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:553:3: ( (lv_id_2_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:554:1: (lv_id_2_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:554:1: (lv_id_2_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:555:3: lv_id_2_0= RULE_ID
                    {
                    lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameExpression1163); 

                    			newLeafNode(lv_id_2_0, grammarAccess.getNameExpressionAccess().getIdIDTerminalRuleCall_0_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNameExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"id",
                            		lv_id_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:572:6: ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:572:6: ( ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )? )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:572:7: ( (lv_path_3_0= ruleQualifiedNamePath ) )? ( (lv_id_4_0= RULE_ID ) ) ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )?
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:572:7: ( (lv_path_3_0= ruleQualifiedNamePath ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_ID) ) {
                        int LA12_1 = input.LA(2);

                        if ( (LA12_1==20) ) {
                            int LA12_3 = input.LA(3);

                            if ( (LA12_3==RULE_ID) ) {
                                int LA12_5 = input.LA(4);

                                if ( (LA12_5==23) ) {
                                    alt12=1;
                                }
                            }
                        }
                        else if ( (LA12_1==19) ) {
                            alt12=1;
                        }
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:573:1: (lv_path_3_0= ruleQualifiedNamePath )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:573:1: (lv_path_3_0= ruleQualifiedNamePath )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:574:3: lv_path_3_0= ruleQualifiedNamePath
                            {
                             
                            	        newCompositeNode(grammarAccess.getNameExpressionAccess().getPathQualifiedNamePathParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleQualifiedNamePath_in_ruleNameExpression1197);
                            lv_path_3_0=ruleQualifiedNamePath();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNameExpressionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"path",
                                    		lv_path_3_0, 
                                    		"QualifiedNamePath");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:590:3: ( (lv_id_4_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:591:1: (lv_id_4_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:591:1: (lv_id_4_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:592:3: lv_id_4_0= RULE_ID
                    {
                    lv_id_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameExpression1215); 

                    			newLeafNode(lv_id_4_0, grammarAccess.getNameExpressionAccess().getIdIDTerminalRuleCall_0_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNameExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"id",
                            		lv_id_4_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:608:2: ( ( (lv_invocationCompletion_5_0= ruleTuple ) ) | ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) ) | ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) ) )?
                    int alt14=4;
                    switch ( input.LA(1) ) {
                        case 24:
                            {
                            alt14=1;
                            }
                            break;
                        case 50:
                            {
                            int LA14_2 = input.LA(2);

                            if ( (LA14_2==51) ) {
                                int LA14_6 = input.LA(3);

                                if ( (LA14_6==60) ) {
                                    alt14=2;
                                }
                            }
                            else if ( ((LA14_2>=RULE_INTEGERVALUE && LA14_2<=RULE_ID)||(LA14_2>=16 && LA14_2<=18)||LA14_2==24||(LA14_2>=42 && LA14_2<=43)||(LA14_2>=46 && LA14_2<=48)||(LA14_2>=56 && LA14_2<=59)||(LA14_2>=87 && LA14_2<=88)) ) {
                                alt14=2;
                            }
                            }
                            break;
                        case 60:
                            {
                            alt14=2;
                            }
                            break;
                        case 17:
                        case 18:
                            {
                            alt14=3;
                            }
                            break;
                    }

                    switch (alt14) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:608:3: ( (lv_invocationCompletion_5_0= ruleTuple ) )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:608:3: ( (lv_invocationCompletion_5_0= ruleTuple ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:609:1: (lv_invocationCompletion_5_0= ruleTuple )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:609:1: (lv_invocationCompletion_5_0= ruleTuple )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:610:3: lv_invocationCompletion_5_0= ruleTuple
                            {
                             
                            	        newCompositeNode(grammarAccess.getNameExpressionAccess().getInvocationCompletionTupleParserRuleCall_0_1_2_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleTuple_in_ruleNameExpression1242);
                            lv_invocationCompletion_5_0=ruleTuple();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNameExpressionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"invocationCompletion",
                                    		lv_invocationCompletion_5_0, 
                                    		"Tuple");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:627:6: ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:627:6: ( (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:628:1: (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:628:1: (lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:629:3: lv_sequenceConstructionCompletion_6_0= ruleSequenceConstructionOrAccessCompletion
                            {
                             
                            	        newCompositeNode(grammarAccess.getNameExpressionAccess().getSequenceConstructionCompletionSequenceConstructionOrAccessCompletionParserRuleCall_0_1_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSequenceConstructionOrAccessCompletion_in_ruleNameExpression1269);
                            lv_sequenceConstructionCompletion_6_0=ruleSequenceConstructionOrAccessCompletion();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNameExpressionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"sequenceConstructionCompletion",
                                    		lv_sequenceConstructionCompletion_6_0, 
                                    		"SequenceConstructionOrAccessCompletion");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:646:6: ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:646:6: ( ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:647:1: ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:647:1: ( (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:648:1: (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:648:1: (lv_postfixOp_7_1= '++' | lv_postfixOp_7_2= '--' )
                            int alt13=2;
                            int LA13_0 = input.LA(1);

                            if ( (LA13_0==17) ) {
                                alt13=1;
                            }
                            else if ( (LA13_0==18) ) {
                                alt13=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 0, input);

                                throw nvae;
                            }
                            switch (alt13) {
                                case 1 :
                                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:649:3: lv_postfixOp_7_1= '++'
                                    {
                                    lv_postfixOp_7_1=(Token)match(input,17,FOLLOW_17_in_ruleNameExpression1295); 

                                            newLeafNode(lv_postfixOp_7_1, grammarAccess.getNameExpressionAccess().getPostfixOpPlusSignPlusSignKeyword_0_1_2_2_0_0());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getNameExpressionRule());
                                    	        }
                                           		setWithLastConsumed(current, "postfixOp", lv_postfixOp_7_1, null);
                                    	    

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:661:8: lv_postfixOp_7_2= '--'
                                    {
                                    lv_postfixOp_7_2=(Token)match(input,18,FOLLOW_18_in_ruleNameExpression1324); 

                                            newLeafNode(lv_postfixOp_7_2, grammarAccess.getNameExpressionAccess().getPostfixOpHyphenMinusHyphenMinusKeyword_0_1_2_2_0_1());
                                        

                                    	        if (current==null) {
                                    	            current = createModelElement(grammarAccess.getNameExpressionRule());
                                    	        }
                                           		setWithLastConsumed(current, "postfixOp", lv_postfixOp_7_2, null);
                                    	    

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:676:6: ( (lv_suffix_8_0= ruleSuffixExpression ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==49||LA16_0==52) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:677:1: (lv_suffix_8_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:677:1: (lv_suffix_8_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:678:3: lv_suffix_8_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getNameExpressionAccess().getSuffixSuffixExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleNameExpression1365);
                    lv_suffix_8_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNameExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_8_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameExpression"


    // $ANTLR start "entryRuleQualifiedNamePath"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:702:1: entryRuleQualifiedNamePath returns [EObject current=null] : iv_ruleQualifiedNamePath= ruleQualifiedNamePath EOF ;
    public final EObject entryRuleQualifiedNamePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedNamePath = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:703:2: (iv_ruleQualifiedNamePath= ruleQualifiedNamePath EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:704:2: iv_ruleQualifiedNamePath= ruleQualifiedNamePath EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNamePathRule()); 
            pushFollow(FOLLOW_ruleQualifiedNamePath_in_entryRuleQualifiedNamePath1402);
            iv_ruleQualifiedNamePath=ruleQualifiedNamePath();

            state._fsp--;

             current =iv_ruleQualifiedNamePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNamePath1412); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNamePath"


    // $ANTLR start "ruleQualifiedNamePath"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:711:1: ruleQualifiedNamePath returns [EObject current=null] : ( ( (lv_namespace_0_0= ruleUnqualifiedName ) ) otherlv_1= '::' )+ ;
    public final EObject ruleQualifiedNamePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_namespace_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:714:28: ( ( ( (lv_namespace_0_0= ruleUnqualifiedName ) ) otherlv_1= '::' )+ )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:715:1: ( ( (lv_namespace_0_0= ruleUnqualifiedName ) ) otherlv_1= '::' )+
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:715:1: ( ( (lv_namespace_0_0= ruleUnqualifiedName ) ) otherlv_1= '::' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1==20) ) {
                        int LA17_3 = input.LA(3);

                        if ( (LA17_3==RULE_ID) ) {
                            int LA17_5 = input.LA(4);

                            if ( (LA17_5==23) ) {
                                alt17=1;
                            }


                        }


                    }
                    else if ( (LA17_1==19) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:715:2: ( (lv_namespace_0_0= ruleUnqualifiedName ) ) otherlv_1= '::'
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:715:2: ( (lv_namespace_0_0= ruleUnqualifiedName ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:716:1: (lv_namespace_0_0= ruleUnqualifiedName )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:716:1: (lv_namespace_0_0= ruleUnqualifiedName )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:717:3: lv_namespace_0_0= ruleUnqualifiedName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQualifiedNamePathAccess().getNamespaceUnqualifiedNameParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnqualifiedName_in_ruleQualifiedNamePath1458);
            	    lv_namespace_0_0=ruleUnqualifiedName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQualifiedNamePathRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"namespace",
            	            		lv_namespace_0_0, 
            	            		"UnqualifiedName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleQualifiedNamePath1470); 

            	        	newLeafNode(otherlv_1, grammarAccess.getQualifiedNamePathAccess().getColonColonKeyword_1());
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNamePath"


    // $ANTLR start "entryRuleUnqualifiedName"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:745:1: entryRuleUnqualifiedName returns [EObject current=null] : iv_ruleUnqualifiedName= ruleUnqualifiedName EOF ;
    public final EObject entryRuleUnqualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnqualifiedName = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:746:2: (iv_ruleUnqualifiedName= ruleUnqualifiedName EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:747:2: iv_ruleUnqualifiedName= ruleUnqualifiedName EOF
            {
             newCompositeNode(grammarAccess.getUnqualifiedNameRule()); 
            pushFollow(FOLLOW_ruleUnqualifiedName_in_entryRuleUnqualifiedName1507);
            iv_ruleUnqualifiedName=ruleUnqualifiedName();

            state._fsp--;

             current =iv_ruleUnqualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnqualifiedName1517); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnqualifiedName"


    // $ANTLR start "ruleUnqualifiedName"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:754:1: ruleUnqualifiedName returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_templateBinding_1_0= ruleTemplateBinding ) )? ) ;
    public final EObject ruleUnqualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_templateBinding_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:757:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_templateBinding_1_0= ruleTemplateBinding ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:758:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_templateBinding_1_0= ruleTemplateBinding ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:758:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_templateBinding_1_0= ruleTemplateBinding ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:758:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_templateBinding_1_0= ruleTemplateBinding ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:758:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:759:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:759:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:760:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnqualifiedName1559); 

            			newLeafNode(lv_name_0_0, grammarAccess.getUnqualifiedNameAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnqualifiedNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:776:2: ( (lv_templateBinding_1_0= ruleTemplateBinding ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==20) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:777:1: (lv_templateBinding_1_0= ruleTemplateBinding )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:777:1: (lv_templateBinding_1_0= ruleTemplateBinding )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:778:3: lv_templateBinding_1_0= ruleTemplateBinding
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnqualifiedNameAccess().getTemplateBindingTemplateBindingParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTemplateBinding_in_ruleUnqualifiedName1585);
                    lv_templateBinding_1_0=ruleTemplateBinding();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnqualifiedNameRule());
                    	        }
                           		set(
                           			current, 
                           			"templateBinding",
                            		lv_templateBinding_1_0, 
                            		"TemplateBinding");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnqualifiedName"


    // $ANTLR start "entryRuleTemplateBinding"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:802:1: entryRuleTemplateBinding returns [EObject current=null] : iv_ruleTemplateBinding= ruleTemplateBinding EOF ;
    public final EObject entryRuleTemplateBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBinding = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:803:2: (iv_ruleTemplateBinding= ruleTemplateBinding EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:804:2: iv_ruleTemplateBinding= ruleTemplateBinding EOF
            {
             newCompositeNode(grammarAccess.getTemplateBindingRule()); 
            pushFollow(FOLLOW_ruleTemplateBinding_in_entryRuleTemplateBinding1622);
            iv_ruleTemplateBinding=ruleTemplateBinding();

            state._fsp--;

             current =iv_ruleTemplateBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBinding1632); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBinding"


    // $ANTLR start "ruleTemplateBinding"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:811:1: ruleTemplateBinding returns [EObject current=null] : (otherlv_0= '<' ( (lv_bindings_1_0= ruleNamedTemplateBinding ) ) (otherlv_2= ',' ( (lv_bindings_3_0= ruleNamedTemplateBinding ) ) )* otherlv_4= '>' ) ;
    public final EObject ruleTemplateBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_bindings_1_0 = null;

        EObject lv_bindings_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:814:28: ( (otherlv_0= '<' ( (lv_bindings_1_0= ruleNamedTemplateBinding ) ) (otherlv_2= ',' ( (lv_bindings_3_0= ruleNamedTemplateBinding ) ) )* otherlv_4= '>' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:815:1: (otherlv_0= '<' ( (lv_bindings_1_0= ruleNamedTemplateBinding ) ) (otherlv_2= ',' ( (lv_bindings_3_0= ruleNamedTemplateBinding ) ) )* otherlv_4= '>' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:815:1: (otherlv_0= '<' ( (lv_bindings_1_0= ruleNamedTemplateBinding ) ) (otherlv_2= ',' ( (lv_bindings_3_0= ruleNamedTemplateBinding ) ) )* otherlv_4= '>' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:815:3: otherlv_0= '<' ( (lv_bindings_1_0= ruleNamedTemplateBinding ) ) (otherlv_2= ',' ( (lv_bindings_3_0= ruleNamedTemplateBinding ) ) )* otherlv_4= '>'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleTemplateBinding1669); 

                	newLeafNode(otherlv_0, grammarAccess.getTemplateBindingAccess().getLessThanSignKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:819:1: ( (lv_bindings_1_0= ruleNamedTemplateBinding ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:820:1: (lv_bindings_1_0= ruleNamedTemplateBinding )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:820:1: (lv_bindings_1_0= ruleNamedTemplateBinding )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:821:3: lv_bindings_1_0= ruleNamedTemplateBinding
            {
             
            	        newCompositeNode(grammarAccess.getTemplateBindingAccess().getBindingsNamedTemplateBindingParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleNamedTemplateBinding_in_ruleTemplateBinding1690);
            lv_bindings_1_0=ruleNamedTemplateBinding();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTemplateBindingRule());
            	        }
                   		add(
                   			current, 
                   			"bindings",
                    		lv_bindings_1_0, 
                    		"NamedTemplateBinding");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:837:2: (otherlv_2= ',' ( (lv_bindings_3_0= ruleNamedTemplateBinding ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==21) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:837:4: otherlv_2= ',' ( (lv_bindings_3_0= ruleNamedTemplateBinding ) )
            	    {
            	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleTemplateBinding1703); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTemplateBindingAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:841:1: ( (lv_bindings_3_0= ruleNamedTemplateBinding ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:842:1: (lv_bindings_3_0= ruleNamedTemplateBinding )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:842:1: (lv_bindings_3_0= ruleNamedTemplateBinding )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:843:3: lv_bindings_3_0= ruleNamedTemplateBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTemplateBindingAccess().getBindingsNamedTemplateBindingParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedTemplateBinding_in_ruleTemplateBinding1724);
            	    lv_bindings_3_0=ruleNamedTemplateBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTemplateBindingRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"bindings",
            	            		lv_bindings_3_0, 
            	            		"NamedTemplateBinding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleTemplateBinding1738); 

                	newLeafNode(otherlv_4, grammarAccess.getTemplateBindingAccess().getGreaterThanSignKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateBinding"


    // $ANTLR start "entryRuleNamedTemplateBinding"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:871:1: entryRuleNamedTemplateBinding returns [EObject current=null] : iv_ruleNamedTemplateBinding= ruleNamedTemplateBinding EOF ;
    public final EObject entryRuleNamedTemplateBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTemplateBinding = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:872:2: (iv_ruleNamedTemplateBinding= ruleNamedTemplateBinding EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:873:2: iv_ruleNamedTemplateBinding= ruleNamedTemplateBinding EOF
            {
             newCompositeNode(grammarAccess.getNamedTemplateBindingRule()); 
            pushFollow(FOLLOW_ruleNamedTemplateBinding_in_entryRuleNamedTemplateBinding1774);
            iv_ruleNamedTemplateBinding=ruleNamedTemplateBinding();

            state._fsp--;

             current =iv_ruleNamedTemplateBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTemplateBinding1784); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedTemplateBinding"


    // $ANTLR start "ruleNamedTemplateBinding"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:880:1: ruleNamedTemplateBinding returns [EObject current=null] : ( ( (lv_formal_0_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_actual_2_0= ruleQualifiedNameWithBinding ) ) ) ;
    public final EObject ruleNamedTemplateBinding() throws RecognitionException {
        EObject current = null;

        Token lv_formal_0_0=null;
        Token otherlv_1=null;
        EObject lv_actual_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:883:28: ( ( ( (lv_formal_0_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_actual_2_0= ruleQualifiedNameWithBinding ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:884:1: ( ( (lv_formal_0_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_actual_2_0= ruleQualifiedNameWithBinding ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:884:1: ( ( (lv_formal_0_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_actual_2_0= ruleQualifiedNameWithBinding ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:884:2: ( (lv_formal_0_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_actual_2_0= ruleQualifiedNameWithBinding ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:884:2: ( (lv_formal_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:885:1: (lv_formal_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:885:1: (lv_formal_0_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:886:3: lv_formal_0_0= RULE_ID
            {
            lv_formal_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamedTemplateBinding1826); 

            			newLeafNode(lv_formal_0_0, grammarAccess.getNamedTemplateBindingAccess().getFormalIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNamedTemplateBindingRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"formal",
                    		lv_formal_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleNamedTemplateBinding1843); 

                	newLeafNode(otherlv_1, grammarAccess.getNamedTemplateBindingAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:906:1: ( (lv_actual_2_0= ruleQualifiedNameWithBinding ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:907:1: (lv_actual_2_0= ruleQualifiedNameWithBinding )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:907:1: (lv_actual_2_0= ruleQualifiedNameWithBinding )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:908:3: lv_actual_2_0= ruleQualifiedNameWithBinding
            {
             
            	        newCompositeNode(grammarAccess.getNamedTemplateBindingAccess().getActualQualifiedNameWithBindingParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleNamedTemplateBinding1864);
            lv_actual_2_0=ruleQualifiedNameWithBinding();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedTemplateBindingRule());
            	        }
                   		set(
                   			current, 
                   			"actual",
                    		lv_actual_2_0, 
                    		"QualifiedNameWithBinding");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedTemplateBinding"


    // $ANTLR start "entryRuleQualifiedNameWithBinding"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:932:1: entryRuleQualifiedNameWithBinding returns [EObject current=null] : iv_ruleQualifiedNameWithBinding= ruleQualifiedNameWithBinding EOF ;
    public final EObject entryRuleQualifiedNameWithBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedNameWithBinding = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:933:2: (iv_ruleQualifiedNameWithBinding= ruleQualifiedNameWithBinding EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:934:2: iv_ruleQualifiedNameWithBinding= ruleQualifiedNameWithBinding EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithBindingRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_entryRuleQualifiedNameWithBinding1900);
            iv_ruleQualifiedNameWithBinding=ruleQualifiedNameWithBinding();

            state._fsp--;

             current =iv_ruleQualifiedNameWithBinding; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithBinding1910); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithBinding"


    // $ANTLR start "ruleQualifiedNameWithBinding"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:941:1: ruleQualifiedNameWithBinding returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_binding_1_0= ruleTemplateBinding ) )? (otherlv_2= '::' ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) ) )? ) ;
    public final EObject ruleQualifiedNameWithBinding() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_2=null;
        EObject lv_binding_1_0 = null;

        EObject lv_remaining_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:944:28: ( ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_binding_1_0= ruleTemplateBinding ) )? (otherlv_2= '::' ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:945:1: ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_binding_1_0= ruleTemplateBinding ) )? (otherlv_2= '::' ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:945:1: ( ( (lv_id_0_0= RULE_ID ) ) ( (lv_binding_1_0= ruleTemplateBinding ) )? (otherlv_2= '::' ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:945:2: ( (lv_id_0_0= RULE_ID ) ) ( (lv_binding_1_0= ruleTemplateBinding ) )? (otherlv_2= '::' ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:945:2: ( (lv_id_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:946:1: (lv_id_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:946:1: (lv_id_0_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:947:3: lv_id_0_0= RULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedNameWithBinding1952); 

            			newLeafNode(lv_id_0_0, grammarAccess.getQualifiedNameWithBindingAccess().getIdIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameWithBindingRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:963:2: ( (lv_binding_1_0= ruleTemplateBinding ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==RULE_ID) ) {
                    int LA20_3 = input.LA(3);

                    if ( (LA20_3==23) ) {
                        alt20=1;
                    }
                }
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:964:1: (lv_binding_1_0= ruleTemplateBinding )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:964:1: (lv_binding_1_0= ruleTemplateBinding )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:965:3: lv_binding_1_0= ruleTemplateBinding
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameWithBindingAccess().getBindingTemplateBindingParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTemplateBinding_in_ruleQualifiedNameWithBinding1978);
                    lv_binding_1_0=ruleTemplateBinding();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQualifiedNameWithBindingRule());
                    	        }
                           		set(
                           			current, 
                           			"binding",
                            		lv_binding_1_0, 
                            		"TemplateBinding");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:981:3: (otherlv_2= '::' ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:981:5: otherlv_2= '::' ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleQualifiedNameWithBinding1992); 

                        	newLeafNode(otherlv_2, grammarAccess.getQualifiedNameWithBindingAccess().getColonColonKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:985:1: ( (lv_remaining_3_0= ruleQualifiedNameWithBinding ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:986:1: (lv_remaining_3_0= ruleQualifiedNameWithBinding )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:986:1: (lv_remaining_3_0= ruleQualifiedNameWithBinding )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:987:3: lv_remaining_3_0= ruleQualifiedNameWithBinding
                    {
                     
                    	        newCompositeNode(grammarAccess.getQualifiedNameWithBindingAccess().getRemainingQualifiedNameWithBindingParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleQualifiedNameWithBinding2013);
                    lv_remaining_3_0=ruleQualifiedNameWithBinding();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQualifiedNameWithBindingRule());
                    	        }
                           		set(
                           			current, 
                           			"remaining",
                            		lv_remaining_3_0, 
                            		"QualifiedNameWithBinding");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithBinding"


    // $ANTLR start "entryRuleTuple"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1011:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1012:2: (iv_ruleTuple= ruleTuple EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1013:2: iv_ruleTuple= ruleTuple EOF
            {
             newCompositeNode(grammarAccess.getTupleRule()); 
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple2051);
            iv_ruleTuple=ruleTuple();

            state._fsp--;

             current =iv_ruleTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple2061); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTuple"


    // $ANTLR start "ruleTuple"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1020:1: ruleTuple returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_tupleElements_2_0= ruleTupleElement ) ) (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_tupleElements_2_0 = null;

        EObject lv_tupleElements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1023:28: ( ( () otherlv_1= '(' ( ( (lv_tupleElements_2_0= ruleTupleElement ) ) (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )* )? otherlv_5= ')' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1024:1: ( () otherlv_1= '(' ( ( (lv_tupleElements_2_0= ruleTupleElement ) ) (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )* )? otherlv_5= ')' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1024:1: ( () otherlv_1= '(' ( ( (lv_tupleElements_2_0= ruleTupleElement ) ) (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )* )? otherlv_5= ')' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1024:2: () otherlv_1= '(' ( ( (lv_tupleElements_2_0= ruleTupleElement ) ) (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )* )? otherlv_5= ')'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1024:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1025:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTupleAccess().getTupleAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTuple2107); 

                	newLeafNode(otherlv_1, grammarAccess.getTupleAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1034:1: ( ( (lv_tupleElements_2_0= ruleTupleElement ) ) (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_INTEGERVALUE && LA23_0<=RULE_ID)||(LA23_0>=16 && LA23_0<=18)||LA23_0==24||(LA23_0>=42 && LA23_0<=43)||(LA23_0>=46 && LA23_0<=48)||(LA23_0>=56 && LA23_0<=59)||(LA23_0>=87 && LA23_0<=88)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1034:2: ( (lv_tupleElements_2_0= ruleTupleElement ) ) (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )*
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1034:2: ( (lv_tupleElements_2_0= ruleTupleElement ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1035:1: (lv_tupleElements_2_0= ruleTupleElement )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1035:1: (lv_tupleElements_2_0= ruleTupleElement )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1036:3: lv_tupleElements_2_0= ruleTupleElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getTupleAccess().getTupleElementsTupleElementParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTupleElement_in_ruleTuple2129);
                    lv_tupleElements_2_0=ruleTupleElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTupleRule());
                    	        }
                           		add(
                           			current, 
                           			"tupleElements",
                            		lv_tupleElements_2_0, 
                            		"TupleElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1052:2: (otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==21) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1052:4: otherlv_3= ',' ( (lv_tupleElements_4_0= ruleTupleElement ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleTuple2142); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getTupleAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1056:1: ( (lv_tupleElements_4_0= ruleTupleElement ) )
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1057:1: (lv_tupleElements_4_0= ruleTupleElement )
                    	    {
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1057:1: (lv_tupleElements_4_0= ruleTupleElement )
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1058:3: lv_tupleElements_4_0= ruleTupleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTupleAccess().getTupleElementsTupleElementParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTupleElement_in_ruleTuple2163);
                    	    lv_tupleElements_4_0=ruleTupleElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTupleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"tupleElements",
                    	            		lv_tupleElements_4_0, 
                    	            		"TupleElement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleTuple2179); 

                	newLeafNode(otherlv_5, grammarAccess.getTupleAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTuple"


    // $ANTLR start "entryRuleTupleElement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1086:1: entryRuleTupleElement returns [EObject current=null] : iv_ruleTupleElement= ruleTupleElement EOF ;
    public final EObject entryRuleTupleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleElement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1087:2: (iv_ruleTupleElement= ruleTupleElement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1088:2: iv_ruleTupleElement= ruleTupleElement EOF
            {
             newCompositeNode(grammarAccess.getTupleElementRule()); 
            pushFollow(FOLLOW_ruleTupleElement_in_entryRuleTupleElement2215);
            iv_ruleTupleElement=ruleTupleElement();

            state._fsp--;

             current =iv_ruleTupleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleElement2225); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleElement"


    // $ANTLR start "ruleTupleElement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1095:1: ruleTupleElement returns [EObject current=null] : ( (lv_argument_0_0= ruleExpression ) ) ;
    public final EObject ruleTupleElement() throws RecognitionException {
        EObject current = null;

        EObject lv_argument_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1098:28: ( ( (lv_argument_0_0= ruleExpression ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1099:1: ( (lv_argument_0_0= ruleExpression ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1099:1: ( (lv_argument_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1100:1: (lv_argument_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1100:1: (lv_argument_0_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1101:3: lv_argument_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getTupleElementAccess().getArgumentExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleTupleElement2270);
            lv_argument_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTupleElementRule());
            	        }
                   		set(
                   			current, 
                   			"argument",
                    		lv_argument_0_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleElement"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1125:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1126:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1127:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression2305);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression2315); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1134:1: ruleExpression returns [EObject current=null] : this_ConditionalTestExpression_0= ruleConditionalTestExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalTestExpression_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1137:28: (this_ConditionalTestExpression_0= ruleConditionalTestExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1139:5: this_ConditionalTestExpression_0= ruleConditionalTestExpression
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getConditionalTestExpressionParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleConditionalTestExpression_in_ruleExpression2361);
            this_ConditionalTestExpression_0=ruleConditionalTestExpression();

            state._fsp--;

             
                    current = this_ConditionalTestExpression_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleConditionalTestExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1155:1: entryRuleConditionalTestExpression returns [EObject current=null] : iv_ruleConditionalTestExpression= ruleConditionalTestExpression EOF ;
    public final EObject entryRuleConditionalTestExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalTestExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1156:2: (iv_ruleConditionalTestExpression= ruleConditionalTestExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1157:2: iv_ruleConditionalTestExpression= ruleConditionalTestExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalTestExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalTestExpression_in_entryRuleConditionalTestExpression2395);
            iv_ruleConditionalTestExpression=ruleConditionalTestExpression();

            state._fsp--;

             current =iv_ruleConditionalTestExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalTestExpression2405); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalTestExpression"


    // $ANTLR start "ruleConditionalTestExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1164:1: ruleConditionalTestExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalOrExpression ) ) (otherlv_1= '?' ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) ) otherlv_3= ':' ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) ) )? ) ;
    public final EObject ruleConditionalTestExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_whenTrue_2_0 = null;

        EObject lv_whenFalse_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1167:28: ( ( ( (lv_exp_0_0= ruleConditionalOrExpression ) ) (otherlv_1= '?' ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) ) otherlv_3= ':' ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1168:1: ( ( (lv_exp_0_0= ruleConditionalOrExpression ) ) (otherlv_1= '?' ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) ) otherlv_3= ':' ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1168:1: ( ( (lv_exp_0_0= ruleConditionalOrExpression ) ) (otherlv_1= '?' ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) ) otherlv_3= ':' ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1168:2: ( (lv_exp_0_0= ruleConditionalOrExpression ) ) (otherlv_1= '?' ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) ) otherlv_3= ':' ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1168:2: ( (lv_exp_0_0= ruleConditionalOrExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1169:1: (lv_exp_0_0= ruleConditionalOrExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1169:1: (lv_exp_0_0= ruleConditionalOrExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1170:3: lv_exp_0_0= ruleConditionalOrExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalTestExpressionAccess().getExpConditionalOrExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConditionalOrExpression_in_ruleConditionalTestExpression2451);
            lv_exp_0_0=ruleConditionalOrExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalTestExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"ConditionalOrExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1186:2: (otherlv_1= '?' ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) ) otherlv_3= ':' ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==26) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1186:4: otherlv_1= '?' ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) ) otherlv_3= ':' ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) )
                    {
                    otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleConditionalTestExpression2464); 

                        	newLeafNode(otherlv_1, grammarAccess.getConditionalTestExpressionAccess().getQuestionMarkKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1190:1: ( (lv_whenTrue_2_0= ruleConditionalTestExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1191:1: (lv_whenTrue_2_0= ruleConditionalTestExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1191:1: (lv_whenTrue_2_0= ruleConditionalTestExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1192:3: lv_whenTrue_2_0= ruleConditionalTestExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalTestExpressionAccess().getWhenTrueConditionalTestExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConditionalTestExpression_in_ruleConditionalTestExpression2485);
                    lv_whenTrue_2_0=ruleConditionalTestExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalTestExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"whenTrue",
                            		lv_whenTrue_2_0, 
                            		"ConditionalTestExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleConditionalTestExpression2497); 

                        	newLeafNode(otherlv_3, grammarAccess.getConditionalTestExpressionAccess().getColonKeyword_1_2());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1212:1: ( (lv_whenFalse_4_0= ruleConditionalTestExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1213:1: (lv_whenFalse_4_0= ruleConditionalTestExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1213:1: (lv_whenFalse_4_0= ruleConditionalTestExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1214:3: lv_whenFalse_4_0= ruleConditionalTestExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getConditionalTestExpressionAccess().getWhenFalseConditionalTestExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConditionalTestExpression_in_ruleConditionalTestExpression2518);
                    lv_whenFalse_4_0=ruleConditionalTestExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConditionalTestExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"whenFalse",
                            		lv_whenFalse_4_0, 
                            		"ConditionalTestExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalTestExpression"


    // $ANTLR start "entryRuleConditionalOrExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1238:1: entryRuleConditionalOrExpression returns [EObject current=null] : iv_ruleConditionalOrExpression= ruleConditionalOrExpression EOF ;
    public final EObject entryRuleConditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalOrExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1239:2: (iv_ruleConditionalOrExpression= ruleConditionalOrExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1240:2: iv_ruleConditionalOrExpression= ruleConditionalOrExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalOrExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalOrExpression_in_entryRuleConditionalOrExpression2556);
            iv_ruleConditionalOrExpression=ruleConditionalOrExpression();

            state._fsp--;

             current =iv_ruleConditionalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalOrExpression2566); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalOrExpression"


    // $ANTLR start "ruleConditionalOrExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1247:1: ruleConditionalOrExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleConditionalAndExpression ) ) (otherlv_1= '||' ( (lv_exp_2_0= ruleConditionalAndExpression ) ) )* ) ;
    public final EObject ruleConditionalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1250:28: ( ( ( (lv_exp_0_0= ruleConditionalAndExpression ) ) (otherlv_1= '||' ( (lv_exp_2_0= ruleConditionalAndExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1251:1: ( ( (lv_exp_0_0= ruleConditionalAndExpression ) ) (otherlv_1= '||' ( (lv_exp_2_0= ruleConditionalAndExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1251:1: ( ( (lv_exp_0_0= ruleConditionalAndExpression ) ) (otherlv_1= '||' ( (lv_exp_2_0= ruleConditionalAndExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1251:2: ( (lv_exp_0_0= ruleConditionalAndExpression ) ) (otherlv_1= '||' ( (lv_exp_2_0= ruleConditionalAndExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1251:2: ( (lv_exp_0_0= ruleConditionalAndExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1252:1: (lv_exp_0_0= ruleConditionalAndExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1252:1: (lv_exp_0_0= ruleConditionalAndExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1253:3: lv_exp_0_0= ruleConditionalAndExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpConditionalAndExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression2612);
            lv_exp_0_0=ruleConditionalAndExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"ConditionalAndExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1269:2: (otherlv_1= '||' ( (lv_exp_2_0= ruleConditionalAndExpression ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==28) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1269:4: otherlv_1= '||' ( (lv_exp_2_0= ruleConditionalAndExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleConditionalOrExpression2625); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConditionalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1273:1: ( (lv_exp_2_0= ruleConditionalAndExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1274:1: (lv_exp_2_0= ruleConditionalAndExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1274:1: (lv_exp_2_0= ruleConditionalAndExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1275:3: lv_exp_2_0= ruleConditionalAndExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getExpConditionalAndExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression2646);
            	    lv_exp_2_0=ruleConditionalAndExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"ConditionalAndExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalOrExpression"


    // $ANTLR start "entryRuleConditionalAndExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1299:1: entryRuleConditionalAndExpression returns [EObject current=null] : iv_ruleConditionalAndExpression= ruleConditionalAndExpression EOF ;
    public final EObject entryRuleConditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalAndExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1300:2: (iv_ruleConditionalAndExpression= ruleConditionalAndExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1301:2: iv_ruleConditionalAndExpression= ruleConditionalAndExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalAndExpressionRule()); 
            pushFollow(FOLLOW_ruleConditionalAndExpression_in_entryRuleConditionalAndExpression2684);
            iv_ruleConditionalAndExpression=ruleConditionalAndExpression();

            state._fsp--;

             current =iv_ruleConditionalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalAndExpression2694); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalAndExpression"


    // $ANTLR start "ruleConditionalAndExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1308:1: ruleConditionalAndExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleInclusiveOrExpression ) ) (otherlv_1= '&&' ( (lv_exp_2_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleConditionalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1311:28: ( ( ( (lv_exp_0_0= ruleInclusiveOrExpression ) ) (otherlv_1= '&&' ( (lv_exp_2_0= ruleInclusiveOrExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1312:1: ( ( (lv_exp_0_0= ruleInclusiveOrExpression ) ) (otherlv_1= '&&' ( (lv_exp_2_0= ruleInclusiveOrExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1312:1: ( ( (lv_exp_0_0= ruleInclusiveOrExpression ) ) (otherlv_1= '&&' ( (lv_exp_2_0= ruleInclusiveOrExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1312:2: ( (lv_exp_0_0= ruleInclusiveOrExpression ) ) (otherlv_1= '&&' ( (lv_exp_2_0= ruleInclusiveOrExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1312:2: ( (lv_exp_0_0= ruleInclusiveOrExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1313:1: (lv_exp_0_0= ruleInclusiveOrExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1313:1: (lv_exp_0_0= ruleInclusiveOrExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1314:3: lv_exp_0_0= ruleInclusiveOrExpression
            {
             
            	        newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpInclusiveOrExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression2740);
            lv_exp_0_0=ruleInclusiveOrExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"InclusiveOrExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1330:2: (otherlv_1= '&&' ( (lv_exp_2_0= ruleInclusiveOrExpression ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==29) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1330:4: otherlv_1= '&&' ( (lv_exp_2_0= ruleInclusiveOrExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleConditionalAndExpression2753); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConditionalAndExpressionAccess().getAmpersandAmpersandKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1334:1: ( (lv_exp_2_0= ruleInclusiveOrExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1335:1: (lv_exp_2_0= ruleInclusiveOrExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1335:1: (lv_exp_2_0= ruleInclusiveOrExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1336:3: lv_exp_2_0= ruleInclusiveOrExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getExpInclusiveOrExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression2774);
            	    lv_exp_2_0=ruleInclusiveOrExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"InclusiveOrExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalAndExpression"


    // $ANTLR start "entryRuleInclusiveOrExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1360:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1361:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1362:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
            {
             newCompositeNode(grammarAccess.getInclusiveOrExpressionRule()); 
            pushFollow(FOLLOW_ruleInclusiveOrExpression_in_entryRuleInclusiveOrExpression2812);
            iv_ruleInclusiveOrExpression=ruleInclusiveOrExpression();

            state._fsp--;

             current =iv_ruleInclusiveOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInclusiveOrExpression2822); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInclusiveOrExpression"


    // $ANTLR start "ruleInclusiveOrExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1369:1: ruleInclusiveOrExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleExclusiveOrExpression ) ) (otherlv_1= '|' ( (lv_exp_2_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1372:28: ( ( ( (lv_exp_0_0= ruleExclusiveOrExpression ) ) (otherlv_1= '|' ( (lv_exp_2_0= ruleExclusiveOrExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1373:1: ( ( (lv_exp_0_0= ruleExclusiveOrExpression ) ) (otherlv_1= '|' ( (lv_exp_2_0= ruleExclusiveOrExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1373:1: ( ( (lv_exp_0_0= ruleExclusiveOrExpression ) ) (otherlv_1= '|' ( (lv_exp_2_0= ruleExclusiveOrExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1373:2: ( (lv_exp_0_0= ruleExclusiveOrExpression ) ) (otherlv_1= '|' ( (lv_exp_2_0= ruleExclusiveOrExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1373:2: ( (lv_exp_0_0= ruleExclusiveOrExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1374:1: (lv_exp_0_0= ruleExclusiveOrExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1374:1: (lv_exp_0_0= ruleExclusiveOrExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1375:3: lv_exp_0_0= ruleExclusiveOrExpression
            {
             
            	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExpExclusiveOrExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression2868);
            lv_exp_0_0=ruleExclusiveOrExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"ExclusiveOrExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1391:2: (otherlv_1= '|' ( (lv_exp_2_0= ruleExclusiveOrExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==30) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1391:4: otherlv_1= '|' ( (lv_exp_2_0= ruleExclusiveOrExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleInclusiveOrExpression2881); 

            	        	newLeafNode(otherlv_1, grammarAccess.getInclusiveOrExpressionAccess().getVerticalLineKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1395:1: ( (lv_exp_2_0= ruleExclusiveOrExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1396:1: (lv_exp_2_0= ruleExclusiveOrExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1396:1: (lv_exp_2_0= ruleExclusiveOrExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1397:3: lv_exp_2_0= ruleExclusiveOrExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExpExclusiveOrExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression2902);
            	    lv_exp_2_0=ruleExclusiveOrExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"ExclusiveOrExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInclusiveOrExpression"


    // $ANTLR start "entryRuleExclusiveOrExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1421:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1422:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1423:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
            {
             newCompositeNode(grammarAccess.getExclusiveOrExpressionRule()); 
            pushFollow(FOLLOW_ruleExclusiveOrExpression_in_entryRuleExclusiveOrExpression2940);
            iv_ruleExclusiveOrExpression=ruleExclusiveOrExpression();

            state._fsp--;

             current =iv_ruleExclusiveOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExclusiveOrExpression2950); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExclusiveOrExpression"


    // $ANTLR start "ruleExclusiveOrExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1430:1: ruleExclusiveOrExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAndExpression ) ) (otherlv_1= '^' ( (lv_exp_2_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1433:28: ( ( ( (lv_exp_0_0= ruleAndExpression ) ) (otherlv_1= '^' ( (lv_exp_2_0= ruleAndExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1434:1: ( ( (lv_exp_0_0= ruleAndExpression ) ) (otherlv_1= '^' ( (lv_exp_2_0= ruleAndExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1434:1: ( ( (lv_exp_0_0= ruleAndExpression ) ) (otherlv_1= '^' ( (lv_exp_2_0= ruleAndExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1434:2: ( (lv_exp_0_0= ruleAndExpression ) ) (otherlv_1= '^' ( (lv_exp_2_0= ruleAndExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1434:2: ( (lv_exp_0_0= ruleAndExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1435:1: (lv_exp_0_0= ruleAndExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1435:1: (lv_exp_0_0= ruleAndExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1436:3: lv_exp_0_0= ruleAndExpression
            {
             
            	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExpAndExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression2996);
            lv_exp_0_0=ruleAndExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"AndExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1452:2: (otherlv_1= '^' ( (lv_exp_2_0= ruleAndExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==31) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1452:4: otherlv_1= '^' ( (lv_exp_2_0= ruleAndExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleExclusiveOrExpression3009); 

            	        	newLeafNode(otherlv_1, grammarAccess.getExclusiveOrExpressionAccess().getCircumflexAccentKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1456:1: ( (lv_exp_2_0= ruleAndExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1457:1: (lv_exp_2_0= ruleAndExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1457:1: (lv_exp_2_0= ruleAndExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1458:3: lv_exp_2_0= ruleAndExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getExpAndExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression3030);
            	    lv_exp_2_0=ruleAndExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"AndExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExclusiveOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1482:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1483:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1484:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression3068);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression3078); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1491:1: ruleAndExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleEqualityExpression ) ) (otherlv_1= '&' ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1494:28: ( ( ( (lv_exp_0_0= ruleEqualityExpression ) ) (otherlv_1= '&' ( (lv_exp_2_0= ruleEqualityExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1495:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) (otherlv_1= '&' ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1495:1: ( ( (lv_exp_0_0= ruleEqualityExpression ) ) (otherlv_1= '&' ( (lv_exp_2_0= ruleEqualityExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1495:2: ( (lv_exp_0_0= ruleEqualityExpression ) ) (otherlv_1= '&' ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1495:2: ( (lv_exp_0_0= ruleEqualityExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1496:1: (lv_exp_0_0= ruleEqualityExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1496:1: (lv_exp_0_0= ruleEqualityExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1497:3: lv_exp_0_0= ruleEqualityExpression
            {
             
            	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExpEqualityExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndExpression3124);
            lv_exp_0_0=ruleEqualityExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"EqualityExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1513:2: (otherlv_1= '&' ( (lv_exp_2_0= ruleEqualityExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==32) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1513:4: otherlv_1= '&' ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleAndExpression3137); 

            	        	newLeafNode(otherlv_1, grammarAccess.getAndExpressionAccess().getAmpersandKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1517:1: ( (lv_exp_2_0= ruleEqualityExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1518:1: (lv_exp_2_0= ruleEqualityExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1518:1: (lv_exp_2_0= ruleEqualityExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1519:3: lv_exp_2_0= ruleEqualityExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndExpressionAccess().getExpEqualityExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndExpression3158);
            	    lv_exp_2_0=ruleEqualityExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"EqualityExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1543:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1544:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1545:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression3196);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression3206); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1552:1: ruleEqualityExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleClassificationExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_exp_2_0= ruleClassificationExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1555:28: ( ( ( (lv_exp_0_0= ruleClassificationExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_exp_2_0= ruleClassificationExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1556:1: ( ( (lv_exp_0_0= ruleClassificationExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_exp_2_0= ruleClassificationExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1556:1: ( ( (lv_exp_0_0= ruleClassificationExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_exp_2_0= ruleClassificationExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1556:2: ( (lv_exp_0_0= ruleClassificationExpression ) ) ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_exp_2_0= ruleClassificationExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1556:2: ( (lv_exp_0_0= ruleClassificationExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1557:1: (lv_exp_0_0= ruleClassificationExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1557:1: (lv_exp_0_0= ruleClassificationExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1558:3: lv_exp_0_0= ruleClassificationExpression
            {
             
            	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpClassificationExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression3252);
            lv_exp_0_0=ruleClassificationExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"ClassificationExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1574:2: ( ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_exp_2_0= ruleClassificationExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=33 && LA31_0<=34)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1574:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) ) ( (lv_exp_2_0= ruleClassificationExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1574:3: ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1575:1: ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1575:1: ( (lv_op_1_1= '==' | lv_op_1_2= '!=' ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1576:1: (lv_op_1_1= '==' | lv_op_1_2= '!=' )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1576:1: (lv_op_1_1= '==' | lv_op_1_2= '!=' )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==33) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==34) ) {
            	        alt30=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1577:3: lv_op_1_1= '=='
            	            {
            	            lv_op_1_1=(Token)match(input,33,FOLLOW_33_in_ruleEqualityExpression3273); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getEqualityExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1589:8: lv_op_1_2= '!='
            	            {
            	            lv_op_1_2=(Token)match(input,34,FOLLOW_34_in_ruleEqualityExpression3302); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getEqualityExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1604:2: ( (lv_exp_2_0= ruleClassificationExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1605:1: (lv_exp_2_0= ruleClassificationExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1605:1: (lv_exp_2_0= ruleClassificationExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1606:3: lv_exp_2_0= ruleClassificationExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getExpClassificationExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression3339);
            	    lv_exp_2_0=ruleClassificationExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"ClassificationExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleClassificationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1630:1: entryRuleClassificationExpression returns [EObject current=null] : iv_ruleClassificationExpression= ruleClassificationExpression EOF ;
    public final EObject entryRuleClassificationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassificationExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1631:2: (iv_ruleClassificationExpression= ruleClassificationExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1632:2: iv_ruleClassificationExpression= ruleClassificationExpression EOF
            {
             newCompositeNode(grammarAccess.getClassificationExpressionRule()); 
            pushFollow(FOLLOW_ruleClassificationExpression_in_entryRuleClassificationExpression3377);
            iv_ruleClassificationExpression=ruleClassificationExpression();

            state._fsp--;

             current =iv_ruleClassificationExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassificationExpression3387); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassificationExpression"


    // $ANTLR start "ruleClassificationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1639:1: ruleClassificationExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) ) ( (lv_typeName_2_0= ruleNameExpression ) ) )? ) ;
    public final EObject ruleClassificationExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_typeName_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1642:28: ( ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) ) ( (lv_typeName_2_0= ruleNameExpression ) ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1643:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) ) ( (lv_typeName_2_0= ruleNameExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1643:1: ( ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) ) ( (lv_typeName_2_0= ruleNameExpression ) ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1643:2: ( (lv_exp_0_0= ruleRelationalExpression ) ) ( ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) ) ( (lv_typeName_2_0= ruleNameExpression ) ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1643:2: ( (lv_exp_0_0= ruleRelationalExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1644:1: (lv_exp_0_0= ruleRelationalExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1644:1: (lv_exp_0_0= ruleRelationalExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1645:3: lv_exp_0_0= ruleRelationalExpression
            {
             
            	        newCompositeNode(grammarAccess.getClassificationExpressionAccess().getExpRelationalExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleClassificationExpression3433);
            lv_exp_0_0=ruleRelationalExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassificationExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"RelationalExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1661:2: ( ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) ) ( (lv_typeName_2_0= ruleNameExpression ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=35 && LA33_0<=36)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1661:3: ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) ) ( (lv_typeName_2_0= ruleNameExpression ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1661:3: ( ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1662:1: ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1662:1: ( (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1663:1: (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1663:1: (lv_op_1_1= 'instanceof' | lv_op_1_2= 'hastype' )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==35) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==36) ) {
                        alt32=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1664:3: lv_op_1_1= 'instanceof'
                            {
                            lv_op_1_1=(Token)match(input,35,FOLLOW_35_in_ruleClassificationExpression3454); 

                                    newLeafNode(lv_op_1_1, grammarAccess.getClassificationExpressionAccess().getOpInstanceofKeyword_1_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getClassificationExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1676:8: lv_op_1_2= 'hastype'
                            {
                            lv_op_1_2=(Token)match(input,36,FOLLOW_36_in_ruleClassificationExpression3483); 

                                    newLeafNode(lv_op_1_2, grammarAccess.getClassificationExpressionAccess().getOpHastypeKeyword_1_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getClassificationExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1691:2: ( (lv_typeName_2_0= ruleNameExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1692:1: (lv_typeName_2_0= ruleNameExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1692:1: (lv_typeName_2_0= ruleNameExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1693:3: lv_typeName_2_0= ruleNameExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getClassificationExpressionAccess().getTypeNameNameExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNameExpression_in_ruleClassificationExpression3520);
                    lv_typeName_2_0=ruleNameExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClassificationExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"typeName",
                            		lv_typeName_2_0, 
                            		"NameExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1717:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1718:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1719:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression3558);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression3568); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1726:1: ruleRelationalExpression returns [EObject current=null] : ( ( (lv_left_0_0= ruleShiftExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_right_2_0= ruleShiftExpression ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        EObject lv_left_0_0 = null;

        EObject lv_right_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1729:28: ( ( ( (lv_left_0_0= ruleShiftExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_right_2_0= ruleShiftExpression ) ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1730:1: ( ( (lv_left_0_0= ruleShiftExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_right_2_0= ruleShiftExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1730:1: ( ( (lv_left_0_0= ruleShiftExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_right_2_0= ruleShiftExpression ) ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1730:2: ( (lv_left_0_0= ruleShiftExpression ) ) ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_right_2_0= ruleShiftExpression ) ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1730:2: ( (lv_left_0_0= ruleShiftExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1731:1: (lv_left_0_0= ruleShiftExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1731:1: (lv_left_0_0= ruleShiftExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1732:3: lv_left_0_0= ruleShiftExpression
            {
             
            	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getLeftShiftExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3614);
            lv_left_0_0=ruleShiftExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"left",
                    		lv_left_0_0, 
                    		"ShiftExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1748:2: ( ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_right_2_0= ruleShiftExpression ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==20||LA35_0==22||(LA35_0>=37 && LA35_0<=38)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1748:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) ) ( (lv_right_2_0= ruleShiftExpression ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1748:3: ( ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1749:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1749:1: ( (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1750:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1750:1: (lv_op_1_1= '<' | lv_op_1_2= '>' | lv_op_1_3= '<=' | lv_op_1_4= '>=' )
                    int alt34=4;
                    switch ( input.LA(1) ) {
                    case 20:
                        {
                        alt34=1;
                        }
                        break;
                    case 22:
                        {
                        alt34=2;
                        }
                        break;
                    case 37:
                        {
                        alt34=3;
                        }
                        break;
                    case 38:
                        {
                        alt34=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }

                    switch (alt34) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1751:3: lv_op_1_1= '<'
                            {
                            lv_op_1_1=(Token)match(input,20,FOLLOW_20_in_ruleRelationalExpression3635); 

                                    newLeafNode(lv_op_1_1, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignKeyword_1_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1763:8: lv_op_1_2= '>'
                            {
                            lv_op_1_2=(Token)match(input,22,FOLLOW_22_in_ruleRelationalExpression3664); 

                                    newLeafNode(lv_op_1_2, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignKeyword_1_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1775:8: lv_op_1_3= '<='
                            {
                            lv_op_1_3=(Token)match(input,37,FOLLOW_37_in_ruleRelationalExpression3693); 

                                    newLeafNode(lv_op_1_3, grammarAccess.getRelationalExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_3, null);
                            	    

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1787:8: lv_op_1_4= '>='
                            {
                            lv_op_1_4=(Token)match(input,38,FOLLOW_38_in_ruleRelationalExpression3722); 

                                    newLeafNode(lv_op_1_4, grammarAccess.getRelationalExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_0_3());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getRelationalExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_4, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1802:2: ( (lv_right_2_0= ruleShiftExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1803:1: (lv_right_2_0= ruleShiftExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1803:1: (lv_right_2_0= ruleShiftExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1804:3: lv_right_2_0= ruleShiftExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightShiftExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3759);
                    lv_right_2_0=ruleShiftExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"right",
                            		lv_right_2_0, 
                            		"ShiftExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1828:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1829:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1830:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
             newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression3797);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;

             current =iv_ruleShiftExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression3807); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1837:1: ruleShiftExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1840:28: ( ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1841:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1841:1: ( ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1841:2: ( (lv_exp_0_0= ruleAdditiveExpression ) ) ( ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1841:2: ( (lv_exp_0_0= ruleAdditiveExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1842:1: (lv_exp_0_0= ruleAdditiveExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1842:1: (lv_exp_0_0= ruleAdditiveExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1843:3: lv_exp_0_0= ruleAdditiveExpression
            {
             
            	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExpAdditiveExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3853);
            lv_exp_0_0=ruleAdditiveExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"AdditiveExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1859:2: ( ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=39 && LA37_0<=41)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1859:3: ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) ) ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1859:3: ( ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1860:1: ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1860:1: ( (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1861:1: (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1861:1: (lv_op_1_1= '<<' | lv_op_1_2= '>>' | lv_op_1_3= '>>>' )
                    int alt36=3;
                    switch ( input.LA(1) ) {
                    case 39:
                        {
                        alt36=1;
                        }
                        break;
                    case 40:
                        {
                        alt36=2;
                        }
                        break;
                    case 41:
                        {
                        alt36=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }

                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1862:3: lv_op_1_1= '<<'
                            {
                            lv_op_1_1=(Token)match(input,39,FOLLOW_39_in_ruleShiftExpression3874); 

                                    newLeafNode(lv_op_1_1, grammarAccess.getShiftExpressionAccess().getOpLessThanSignLessThanSignKeyword_1_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getShiftExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1874:8: lv_op_1_2= '>>'
                            {
                            lv_op_1_2=(Token)match(input,40,FOLLOW_40_in_ruleShiftExpression3903); 

                                    newLeafNode(lv_op_1_2, grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignKeyword_1_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getShiftExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1886:8: lv_op_1_3= '>>>'
                            {
                            lv_op_1_3=(Token)match(input,41,FOLLOW_41_in_ruleShiftExpression3932); 

                                    newLeafNode(lv_op_1_3, grammarAccess.getShiftExpressionAccess().getOpGreaterThanSignGreaterThanSignGreaterThanSignKeyword_1_0_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getShiftExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_1_3, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1901:2: ( (lv_exp_2_0= ruleAdditiveExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1902:1: (lv_exp_2_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1902:1: (lv_exp_2_0= ruleAdditiveExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1903:3: lv_exp_2_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getExpAdditiveExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3969);
                    lv_exp_2_0=ruleAdditiveExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
                    	        }
                           		add(
                           			current, 
                           			"exp",
                            		lv_exp_2_0, 
                            		"AdditiveExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1927:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1928:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1929:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression4007);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression4017); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1936:1: ruleAdditiveExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1939:28: ( ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1940:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1940:1: ( ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1940:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) ) ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1940:2: ( (lv_exp_0_0= ruleMultiplicativeExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1941:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1941:1: (lv_exp_0_0= ruleMultiplicativeExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1942:3: lv_exp_0_0= ruleMultiplicativeExpression
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression4063);
            lv_exp_0_0=ruleMultiplicativeExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"MultiplicativeExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1958:2: ( ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=42 && LA39_0<=43)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1958:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) ) ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1958:3: ( ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1959:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1959:1: ( (lv_op_1_1= '+' | lv_op_1_2= '-' ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1960:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1960:1: (lv_op_1_1= '+' | lv_op_1_2= '-' )
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( (LA38_0==42) ) {
            	        alt38=1;
            	    }
            	    else if ( (LA38_0==43) ) {
            	        alt38=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1961:3: lv_op_1_1= '+'
            	            {
            	            lv_op_1_1=(Token)match(input,42,FOLLOW_42_in_ruleAdditiveExpression4084); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1973:8: lv_op_1_2= '-'
            	            {
            	            lv_op_1_2=(Token)match(input,43,FOLLOW_43_in_ruleAdditiveExpression4113); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1988:2: ( (lv_exp_2_0= ruleMultiplicativeExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1989:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1989:1: (lv_exp_2_0= ruleMultiplicativeExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:1990:3: lv_exp_2_0= ruleMultiplicativeExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getExpMultiplicativeExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression4150);
            	    lv_exp_2_0=ruleMultiplicativeExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"MultiplicativeExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2014:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2015:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2016:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression4188);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression4198); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2023:1: ruleMultiplicativeExpression returns [EObject current=null] : ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        EObject lv_exp_0_0 = null;

        EObject lv_exp_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2026:28: ( ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2027:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2027:1: ( ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2027:2: ( (lv_exp_0_0= ruleUnaryExpression ) ) ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2027:2: ( (lv_exp_0_0= ruleUnaryExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2028:1: (lv_exp_0_0= ruleUnaryExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2028:1: (lv_exp_0_0= ruleUnaryExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2029:3: lv_exp_0_0= ruleUnaryExpression
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4244);
            lv_exp_0_0=ruleUnaryExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"exp",
                    		lv_exp_0_0, 
                    		"UnaryExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2045:2: ( ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==16||(LA41_0>=44 && LA41_0<=45)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2045:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) ) ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2045:3: ( ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2046:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2046:1: ( (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2047:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2047:1: (lv_op_1_1= '*' | lv_op_1_2= '/' | lv_op_1_3= '%' )
            	    int alt40=3;
            	    switch ( input.LA(1) ) {
            	    case 16:
            	        {
            	        alt40=1;
            	        }
            	        break;
            	    case 44:
            	        {
            	        alt40=2;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt40=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt40) {
            	        case 1 :
            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2048:3: lv_op_1_1= '*'
            	            {
            	            lv_op_1_1=(Token)match(input,16,FOLLOW_16_in_ruleMultiplicativeExpression4265); 

            	                    newLeafNode(lv_op_1_1, grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2060:8: lv_op_1_2= '/'
            	            {
            	            lv_op_1_2=(Token)match(input,44,FOLLOW_44_in_ruleMultiplicativeExpression4294); 

            	                    newLeafNode(lv_op_1_2, grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2072:8: lv_op_1_3= '%'
            	            {
            	            lv_op_1_3=(Token)match(input,45,FOLLOW_45_in_ruleMultiplicativeExpression4323); 

            	                    newLeafNode(lv_op_1_3, grammarAccess.getMultiplicativeExpressionAccess().getOpPercentSignKeyword_1_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            	        }
            	                   		addWithLastConsumed(current, "op", lv_op_1_3, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2087:2: ( (lv_exp_2_0= ruleUnaryExpression ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2088:1: (lv_exp_2_0= ruleUnaryExpression )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2088:1: (lv_exp_2_0= ruleUnaryExpression )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2089:3: lv_exp_2_0= ruleUnaryExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExpUnaryExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4360);
            	    lv_exp_2_0=ruleUnaryExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"exp",
            	            		lv_exp_2_0, 
            	            		"UnaryExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2113:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2114:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2115:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression4398);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression4408); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2122:1: ruleUnaryExpression returns [EObject current=null] : ( ( ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) ) )? ( (lv_exp_1_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        Token lv_op_0_4=null;
        Token lv_op_0_5=null;
        EObject lv_exp_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2125:28: ( ( ( ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) ) )? ( (lv_exp_1_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2126:1: ( ( ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) ) )? ( (lv_exp_1_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2126:1: ( ( ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) ) )? ( (lv_exp_1_0= rulePrimaryExpression ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2126:2: ( ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) ) )? ( (lv_exp_1_0= rulePrimaryExpression ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2126:2: ( ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=42 && LA43_0<=43)||(LA43_0>=46 && LA43_0<=48)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2127:1: ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2127:1: ( (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2128:1: (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2128:1: (lv_op_0_1= '!' | lv_op_0_2= '-' | lv_op_0_3= '+' | lv_op_0_4= '$' | lv_op_0_5= '~' )
                    int alt42=5;
                    switch ( input.LA(1) ) {
                    case 46:
                        {
                        alt42=1;
                        }
                        break;
                    case 43:
                        {
                        alt42=2;
                        }
                        break;
                    case 42:
                        {
                        alt42=3;
                        }
                        break;
                    case 47:
                        {
                        alt42=4;
                        }
                        break;
                    case 48:
                        {
                        alt42=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }

                    switch (alt42) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2129:3: lv_op_0_1= '!'
                            {
                            lv_op_0_1=(Token)match(input,46,FOLLOW_46_in_ruleUnaryExpression4453); 

                                    newLeafNode(lv_op_0_1, grammarAccess.getUnaryExpressionAccess().getOpExclamationMarkKeyword_0_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2141:8: lv_op_0_2= '-'
                            {
                            lv_op_0_2=(Token)match(input,43,FOLLOW_43_in_ruleUnaryExpression4482); 

                                    newLeafNode(lv_op_0_2, grammarAccess.getUnaryExpressionAccess().getOpHyphenMinusKeyword_0_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_2, null);
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2153:8: lv_op_0_3= '+'
                            {
                            lv_op_0_3=(Token)match(input,42,FOLLOW_42_in_ruleUnaryExpression4511); 

                                    newLeafNode(lv_op_0_3, grammarAccess.getUnaryExpressionAccess().getOpPlusSignKeyword_0_0_2());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_3, null);
                            	    

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2165:8: lv_op_0_4= '$'
                            {
                            lv_op_0_4=(Token)match(input,47,FOLLOW_47_in_ruleUnaryExpression4540); 

                                    newLeafNode(lv_op_0_4, grammarAccess.getUnaryExpressionAccess().getOpDollarSignKeyword_0_0_3());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_4, null);
                            	    

                            }
                            break;
                        case 5 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2177:8: lv_op_0_5= '~'
                            {
                            lv_op_0_5=(Token)match(input,48,FOLLOW_48_in_ruleUnaryExpression4569); 

                                    newLeafNode(lv_op_0_5, grammarAccess.getUnaryExpressionAccess().getOpTildeKeyword_0_0_4());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_0_5, null);
                            	    

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2192:3: ( (lv_exp_1_0= rulePrimaryExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2193:1: (lv_exp_1_0= rulePrimaryExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2193:1: (lv_exp_1_0= rulePrimaryExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2194:3: lv_exp_1_0= rulePrimaryExpression
            {
             
            	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getExpPrimaryExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression4607);
            lv_exp_1_0=rulePrimaryExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"exp",
                    		lv_exp_1_0, 
                    		"PrimaryExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2218:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2219:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2220:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression4643);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression4653); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2227:1: rulePrimaryExpression returns [EObject current=null] : ( (lv_prefix_0_0= ruleValueSpecification ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_prefix_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2230:28: ( ( (lv_prefix_0_0= ruleValueSpecification ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2231:1: ( (lv_prefix_0_0= ruleValueSpecification ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2231:1: ( (lv_prefix_0_0= ruleValueSpecification ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2232:1: (lv_prefix_0_0= ruleValueSpecification )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2232:1: (lv_prefix_0_0= ruleValueSpecification )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2233:3: lv_prefix_0_0= ruleValueSpecification
            {
             
            	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrefixValueSpecificationParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleValueSpecification_in_rulePrimaryExpression4698);
            lv_prefix_0_0=ruleValueSpecification();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"prefix",
                    		lv_prefix_0_0, 
                    		"ValueSpecification");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleSuffixExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2257:1: entryRuleSuffixExpression returns [EObject current=null] : iv_ruleSuffixExpression= ruleSuffixExpression EOF ;
    public final EObject entryRuleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuffixExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2258:2: (iv_ruleSuffixExpression= ruleSuffixExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2259:2: iv_ruleSuffixExpression= ruleSuffixExpression EOF
            {
             newCompositeNode(grammarAccess.getSuffixExpressionRule()); 
            pushFollow(FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression4733);
            iv_ruleSuffixExpression=ruleSuffixExpression();

            state._fsp--;

             current =iv_ruleSuffixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuffixExpression4743); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuffixExpression"


    // $ANTLR start "ruleSuffixExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2266:1: ruleSuffixExpression returns [EObject current=null] : (this_OperationCallExpression_0= ruleOperationCallExpression | this_PropertyCallExpression_1= rulePropertyCallExpression | this_LinkOperationExpression_2= ruleLinkOperationExpression | this_SequenceOperationExpression_3= ruleSequenceOperationExpression | this_SequenceReductionExpression_4= ruleSequenceReductionExpression | this_SequenceExpansionExpression_5= ruleSequenceExpansionExpression | this_ClassExtentExpression_6= ruleClassExtentExpression ) ;
    public final EObject ruleSuffixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OperationCallExpression_0 = null;

        EObject this_PropertyCallExpression_1 = null;

        EObject this_LinkOperationExpression_2 = null;

        EObject this_SequenceOperationExpression_3 = null;

        EObject this_SequenceReductionExpression_4 = null;

        EObject this_SequenceExpansionExpression_5 = null;

        EObject this_ClassExtentExpression_6 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2269:28: ( (this_OperationCallExpression_0= ruleOperationCallExpression | this_PropertyCallExpression_1= rulePropertyCallExpression | this_LinkOperationExpression_2= ruleLinkOperationExpression | this_SequenceOperationExpression_3= ruleSequenceOperationExpression | this_SequenceReductionExpression_4= ruleSequenceReductionExpression | this_SequenceExpansionExpression_5= ruleSequenceExpansionExpression | this_ClassExtentExpression_6= ruleClassExtentExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2270:1: (this_OperationCallExpression_0= ruleOperationCallExpression | this_PropertyCallExpression_1= rulePropertyCallExpression | this_LinkOperationExpression_2= ruleLinkOperationExpression | this_SequenceOperationExpression_3= ruleSequenceOperationExpression | this_SequenceReductionExpression_4= ruleSequenceReductionExpression | this_SequenceExpansionExpression_5= ruleSequenceExpansionExpression | this_ClassExtentExpression_6= ruleClassExtentExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2270:1: (this_OperationCallExpression_0= ruleOperationCallExpression | this_PropertyCallExpression_1= rulePropertyCallExpression | this_LinkOperationExpression_2= ruleLinkOperationExpression | this_SequenceOperationExpression_3= ruleSequenceOperationExpression | this_SequenceReductionExpression_4= ruleSequenceReductionExpression | this_SequenceExpansionExpression_5= ruleSequenceExpansionExpression | this_ClassExtentExpression_6= ruleClassExtentExpression )
            int alt44=7;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2271:5: this_OperationCallExpression_0= ruleOperationCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getOperationCallExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression4790);
                    this_OperationCallExpression_0=ruleOperationCallExpression();

                    state._fsp--;

                     
                            current = this_OperationCallExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2281:5: this_PropertyCallExpression_1= rulePropertyCallExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getPropertyCallExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression4817);
                    this_PropertyCallExpression_1=rulePropertyCallExpression();

                    state._fsp--;

                     
                            current = this_PropertyCallExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2291:5: this_LinkOperationExpression_2= ruleLinkOperationExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getLinkOperationExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleLinkOperationExpression_in_ruleSuffixExpression4844);
                    this_LinkOperationExpression_2=ruleLinkOperationExpression();

                    state._fsp--;

                     
                            current = this_LinkOperationExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2301:5: this_SequenceOperationExpression_3= ruleSequenceOperationExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getSequenceOperationExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleSequenceOperationExpression_in_ruleSuffixExpression4871);
                    this_SequenceOperationExpression_3=ruleSequenceOperationExpression();

                    state._fsp--;

                     
                            current = this_SequenceOperationExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2311:5: this_SequenceReductionExpression_4= ruleSequenceReductionExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getSequenceReductionExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSequenceReductionExpression_in_ruleSuffixExpression4898);
                    this_SequenceReductionExpression_4=ruleSequenceReductionExpression();

                    state._fsp--;

                     
                            current = this_SequenceReductionExpression_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2321:5: this_SequenceExpansionExpression_5= ruleSequenceExpansionExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getSequenceExpansionExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleSequenceExpansionExpression_in_ruleSuffixExpression4925);
                    this_SequenceExpansionExpression_5=ruleSequenceExpansionExpression();

                    state._fsp--;

                     
                            current = this_SequenceExpansionExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2331:5: this_ClassExtentExpression_6= ruleClassExtentExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSuffixExpressionAccess().getClassExtentExpressionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleClassExtentExpression_in_ruleSuffixExpression4952);
                    this_ClassExtentExpression_6=ruleClassExtentExpression();

                    state._fsp--;

                     
                            current = this_ClassExtentExpression_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuffixExpression"


    // $ANTLR start "entryRuleOperationCallExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2347:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2348:2: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2349:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
             newCompositeNode(grammarAccess.getOperationCallExpressionRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression4987);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();

            state._fsp--;

             current =iv_ruleOperationCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpression4997); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCallExpression"


    // $ANTLR start "ruleOperationCallExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2356:1: ruleOperationCallExpression returns [EObject current=null] : (otherlv_0= '.' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_operationName_1_0=null;
        EObject lv_tuple_2_0 = null;

        EObject lv_suffix_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2359:28: ( (otherlv_0= '.' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2360:1: (otherlv_0= '.' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2360:1: (otherlv_0= '.' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2360:3: otherlv_0= '.' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleOperationCallExpression5034); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationCallExpressionAccess().getFullStopKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2364:1: ( (lv_operationName_1_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2365:1: (lv_operationName_1_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2365:1: (lv_operationName_1_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2366:3: lv_operationName_1_0= RULE_ID
            {
            lv_operationName_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpression5051); 

            			newLeafNode(lv_operationName_1_0, grammarAccess.getOperationCallExpressionAccess().getOperationNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationCallExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"operationName",
                    		lv_operationName_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2382:2: ( (lv_tuple_2_0= ruleTuple ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2383:1: (lv_tuple_2_0= ruleTuple )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2383:1: (lv_tuple_2_0= ruleTuple )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2384:3: lv_tuple_2_0= ruleTuple
            {
             
            	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getTupleTupleParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTuple_in_ruleOperationCallExpression5077);
            lv_tuple_2_0=ruleTuple();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"tuple",
                    		lv_tuple_2_0, 
                    		"Tuple");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2400:2: ( (lv_suffix_3_0= ruleSuffixExpression ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==49||LA45_0==52) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2401:1: (lv_suffix_3_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2401:1: (lv_suffix_3_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2402:3: lv_suffix_3_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression5098);
                    lv_suffix_3_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_3_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationCallExpression"


    // $ANTLR start "entryRuleOperationCallExpressionWithoutDot"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2426:1: entryRuleOperationCallExpressionWithoutDot returns [EObject current=null] : iv_ruleOperationCallExpressionWithoutDot= ruleOperationCallExpressionWithoutDot EOF ;
    public final EObject entryRuleOperationCallExpressionWithoutDot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpressionWithoutDot = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2427:2: (iv_ruleOperationCallExpressionWithoutDot= ruleOperationCallExpressionWithoutDot EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2428:2: iv_ruleOperationCallExpressionWithoutDot= ruleOperationCallExpressionWithoutDot EOF
            {
             newCompositeNode(grammarAccess.getOperationCallExpressionWithoutDotRule()); 
            pushFollow(FOLLOW_ruleOperationCallExpressionWithoutDot_in_entryRuleOperationCallExpressionWithoutDot5135);
            iv_ruleOperationCallExpressionWithoutDot=ruleOperationCallExpressionWithoutDot();

            state._fsp--;

             current =iv_ruleOperationCallExpressionWithoutDot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCallExpressionWithoutDot5145); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCallExpressionWithoutDot"


    // $ANTLR start "ruleOperationCallExpressionWithoutDot"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2435:1: ruleOperationCallExpressionWithoutDot returns [EObject current=null] : ( ( (lv_operationName_0_0= RULE_ID ) ) ( (lv_tuple_1_0= ruleTuple ) ) ( (lv_suffix_2_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleOperationCallExpressionWithoutDot() throws RecognitionException {
        EObject current = null;

        Token lv_operationName_0_0=null;
        EObject lv_tuple_1_0 = null;

        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2438:28: ( ( ( (lv_operationName_0_0= RULE_ID ) ) ( (lv_tuple_1_0= ruleTuple ) ) ( (lv_suffix_2_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2439:1: ( ( (lv_operationName_0_0= RULE_ID ) ) ( (lv_tuple_1_0= ruleTuple ) ) ( (lv_suffix_2_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2439:1: ( ( (lv_operationName_0_0= RULE_ID ) ) ( (lv_tuple_1_0= ruleTuple ) ) ( (lv_suffix_2_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2439:2: ( (lv_operationName_0_0= RULE_ID ) ) ( (lv_tuple_1_0= ruleTuple ) ) ( (lv_suffix_2_0= ruleSuffixExpression ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2439:2: ( (lv_operationName_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2440:1: (lv_operationName_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2440:1: (lv_operationName_0_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2441:3: lv_operationName_0_0= RULE_ID
            {
            lv_operationName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOperationCallExpressionWithoutDot5187); 

            			newLeafNode(lv_operationName_0_0, grammarAccess.getOperationCallExpressionWithoutDotAccess().getOperationNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationCallExpressionWithoutDotRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"operationName",
                    		lv_operationName_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2457:2: ( (lv_tuple_1_0= ruleTuple ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2458:1: (lv_tuple_1_0= ruleTuple )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2458:1: (lv_tuple_1_0= ruleTuple )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2459:3: lv_tuple_1_0= ruleTuple
            {
             
            	        newCompositeNode(grammarAccess.getOperationCallExpressionWithoutDotAccess().getTupleTupleParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTuple_in_ruleOperationCallExpressionWithoutDot5213);
            lv_tuple_1_0=ruleTuple();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionWithoutDotRule());
            	        }
                   		set(
                   			current, 
                   			"tuple",
                    		lv_tuple_1_0, 
                    		"Tuple");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2475:2: ( (lv_suffix_2_0= ruleSuffixExpression ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==49||LA46_0==52) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2476:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2476:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2477:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationCallExpressionWithoutDotAccess().getSuffixSuffixExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpressionWithoutDot5234);
                    lv_suffix_2_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationCallExpressionWithoutDotRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_2_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationCallExpressionWithoutDot"


    // $ANTLR start "entryRulePropertyCallExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2501:1: entryRulePropertyCallExpression returns [EObject current=null] : iv_rulePropertyCallExpression= rulePropertyCallExpression EOF ;
    public final EObject entryRulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyCallExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2502:2: (iv_rulePropertyCallExpression= rulePropertyCallExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2503:2: iv_rulePropertyCallExpression= rulePropertyCallExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyCallExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression5271);
            iv_rulePropertyCallExpression=rulePropertyCallExpression();

            state._fsp--;

             current =iv_rulePropertyCallExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyCallExpression5281); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyCallExpression"


    // $ANTLR start "rulePropertyCallExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2510:1: rulePropertyCallExpression returns [EObject current=null] : (otherlv_0= '.' ( (lv_propertyName_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? ( (lv_suffix_5_0= ruleSuffixExpression ) )? ) ;
    public final EObject rulePropertyCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_propertyName_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_index_3_0 = null;

        EObject lv_suffix_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2513:28: ( (otherlv_0= '.' ( (lv_propertyName_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? ( (lv_suffix_5_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2514:1: (otherlv_0= '.' ( (lv_propertyName_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? ( (lv_suffix_5_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2514:1: (otherlv_0= '.' ( (lv_propertyName_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? ( (lv_suffix_5_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2514:3: otherlv_0= '.' ( (lv_propertyName_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )? ( (lv_suffix_5_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_rulePropertyCallExpression5318); 

                	newLeafNode(otherlv_0, grammarAccess.getPropertyCallExpressionAccess().getFullStopKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2518:1: ( (lv_propertyName_1_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2519:1: (lv_propertyName_1_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2519:1: (lv_propertyName_1_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2520:3: lv_propertyName_1_0= RULE_ID
            {
            lv_propertyName_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyCallExpression5335); 

            			newLeafNode(lv_propertyName_1_0, grammarAccess.getPropertyCallExpressionAccess().getPropertyNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyCallExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"propertyName",
                    		lv_propertyName_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2536:2: (otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==50) ) {
                int LA47_1 = input.LA(2);

                if ( ((LA47_1>=RULE_INTEGERVALUE && LA47_1<=RULE_ID)||(LA47_1>=16 && LA47_1<=18)||LA47_1==24||(LA47_1>=42 && LA47_1<=43)||(LA47_1>=46 && LA47_1<=48)||(LA47_1>=56 && LA47_1<=59)||(LA47_1>=87 && LA47_1<=88)) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2536:4: otherlv_2= '[' ( (lv_index_3_0= ruleExpression ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_50_in_rulePropertyCallExpression5353); 

                        	newLeafNode(otherlv_2, grammarAccess.getPropertyCallExpressionAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2540:1: ( (lv_index_3_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2541:1: (lv_index_3_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2541:1: (lv_index_3_0= ruleExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2542:3: lv_index_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getIndexExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_rulePropertyCallExpression5374);
                    lv_index_3_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_3_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,51,FOLLOW_51_in_rulePropertyCallExpression5386); 

                        	newLeafNode(otherlv_4, grammarAccess.getPropertyCallExpressionAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2562:3: ( (lv_suffix_5_0= ruleSuffixExpression ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==49||LA48_0==52) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2563:1: (lv_suffix_5_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2563:1: (lv_suffix_5_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2564:3: lv_suffix_5_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPropertyCallExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression5409);
                    lv_suffix_5_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPropertyCallExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_5_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyCallExpression"


    // $ANTLR start "entryRuleLinkOperationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2588:1: entryRuleLinkOperationExpression returns [EObject current=null] : iv_ruleLinkOperationExpression= ruleLinkOperationExpression EOF ;
    public final EObject entryRuleLinkOperationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkOperationExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2589:2: (iv_ruleLinkOperationExpression= ruleLinkOperationExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2590:2: iv_ruleLinkOperationExpression= ruleLinkOperationExpression EOF
            {
             newCompositeNode(grammarAccess.getLinkOperationExpressionRule()); 
            pushFollow(FOLLOW_ruleLinkOperationExpression_in_entryRuleLinkOperationExpression5446);
            iv_ruleLinkOperationExpression=ruleLinkOperationExpression();

            state._fsp--;

             current =iv_ruleLinkOperationExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkOperationExpression5456); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinkOperationExpression"


    // $ANTLR start "ruleLinkOperationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2597:1: ruleLinkOperationExpression returns [EObject current=null] : (otherlv_0= '.' ( (lv_kind_1_0= ruleLinkOperationKind ) ) ( (lv_tuple_2_0= ruleLinkOperationTuple ) ) ) ;
    public final EObject ruleLinkOperationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_kind_1_0 = null;

        EObject lv_tuple_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2600:28: ( (otherlv_0= '.' ( (lv_kind_1_0= ruleLinkOperationKind ) ) ( (lv_tuple_2_0= ruleLinkOperationTuple ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2601:1: (otherlv_0= '.' ( (lv_kind_1_0= ruleLinkOperationKind ) ) ( (lv_tuple_2_0= ruleLinkOperationTuple ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2601:1: (otherlv_0= '.' ( (lv_kind_1_0= ruleLinkOperationKind ) ) ( (lv_tuple_2_0= ruleLinkOperationTuple ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2601:3: otherlv_0= '.' ( (lv_kind_1_0= ruleLinkOperationKind ) ) ( (lv_tuple_2_0= ruleLinkOperationTuple ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleLinkOperationExpression5493); 

                	newLeafNode(otherlv_0, grammarAccess.getLinkOperationExpressionAccess().getFullStopKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2605:1: ( (lv_kind_1_0= ruleLinkOperationKind ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2606:1: (lv_kind_1_0= ruleLinkOperationKind )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2606:1: (lv_kind_1_0= ruleLinkOperationKind )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2607:3: lv_kind_1_0= ruleLinkOperationKind
            {
             
            	        newCompositeNode(grammarAccess.getLinkOperationExpressionAccess().getKindLinkOperationKindEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLinkOperationKind_in_ruleLinkOperationExpression5514);
            lv_kind_1_0=ruleLinkOperationKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLinkOperationExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"kind",
                    		lv_kind_1_0, 
                    		"LinkOperationKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2623:2: ( (lv_tuple_2_0= ruleLinkOperationTuple ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2624:1: (lv_tuple_2_0= ruleLinkOperationTuple )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2624:1: (lv_tuple_2_0= ruleLinkOperationTuple )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2625:3: lv_tuple_2_0= ruleLinkOperationTuple
            {
             
            	        newCompositeNode(grammarAccess.getLinkOperationExpressionAccess().getTupleLinkOperationTupleParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleLinkOperationTuple_in_ruleLinkOperationExpression5535);
            lv_tuple_2_0=ruleLinkOperationTuple();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLinkOperationExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"tuple",
                    		lv_tuple_2_0, 
                    		"LinkOperationTuple");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinkOperationExpression"


    // $ANTLR start "entryRuleLinkOperationTuple"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2649:1: entryRuleLinkOperationTuple returns [EObject current=null] : iv_ruleLinkOperationTuple= ruleLinkOperationTuple EOF ;
    public final EObject entryRuleLinkOperationTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkOperationTuple = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2650:2: (iv_ruleLinkOperationTuple= ruleLinkOperationTuple EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2651:2: iv_ruleLinkOperationTuple= ruleLinkOperationTuple EOF
            {
             newCompositeNode(grammarAccess.getLinkOperationTupleRule()); 
            pushFollow(FOLLOW_ruleLinkOperationTuple_in_entryRuleLinkOperationTuple5571);
            iv_ruleLinkOperationTuple=ruleLinkOperationTuple();

            state._fsp--;

             current =iv_ruleLinkOperationTuple; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkOperationTuple5581); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinkOperationTuple"


    // $ANTLR start "ruleLinkOperationTuple"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2658:1: ruleLinkOperationTuple returns [EObject current=null] : (otherlv_0= '(' ( (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement ) ) (otherlv_2= ',' ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleLinkOperationTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_linkOperationTupleElement_1_0 = null;

        EObject lv_linkOperationTupleElement_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2661:28: ( (otherlv_0= '(' ( (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement ) ) (otherlv_2= ',' ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) ) )* otherlv_4= ')' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2662:1: (otherlv_0= '(' ( (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement ) ) (otherlv_2= ',' ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) ) )* otherlv_4= ')' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2662:1: (otherlv_0= '(' ( (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement ) ) (otherlv_2= ',' ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) ) )* otherlv_4= ')' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2662:3: otherlv_0= '(' ( (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement ) ) (otherlv_2= ',' ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleLinkOperationTuple5618); 

                	newLeafNode(otherlv_0, grammarAccess.getLinkOperationTupleAccess().getLeftParenthesisKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2666:1: ( (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2667:1: (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2667:1: (lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2668:3: lv_linkOperationTupleElement_1_0= ruleLinkOperationTupleElement
            {
             
            	        newCompositeNode(grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLinkOperationTupleElement_in_ruleLinkOperationTuple5639);
            lv_linkOperationTupleElement_1_0=ruleLinkOperationTupleElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLinkOperationTupleRule());
            	        }
                   		add(
                   			current, 
                   			"linkOperationTupleElement",
                    		lv_linkOperationTupleElement_1_0, 
                    		"LinkOperationTupleElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2684:2: (otherlv_2= ',' ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==21) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2684:4: otherlv_2= ',' ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) )
            	    {
            	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleLinkOperationTuple5652); 

            	        	newLeafNode(otherlv_2, grammarAccess.getLinkOperationTupleAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2688:1: ( (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2689:1: (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2689:1: (lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2690:3: lv_linkOperationTupleElement_3_0= ruleLinkOperationTupleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLinkOperationTupleAccess().getLinkOperationTupleElementLinkOperationTupleElementParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLinkOperationTupleElement_in_ruleLinkOperationTuple5673);
            	    lv_linkOperationTupleElement_3_0=ruleLinkOperationTupleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLinkOperationTupleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"linkOperationTupleElement",
            	            		lv_linkOperationTupleElement_3_0, 
            	            		"LinkOperationTupleElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleLinkOperationTuple5687); 

                	newLeafNode(otherlv_4, grammarAccess.getLinkOperationTupleAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinkOperationTuple"


    // $ANTLR start "entryRuleLinkOperationTupleElement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2718:1: entryRuleLinkOperationTupleElement returns [EObject current=null] : iv_ruleLinkOperationTupleElement= ruleLinkOperationTupleElement EOF ;
    public final EObject entryRuleLinkOperationTupleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkOperationTupleElement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2719:2: (iv_ruleLinkOperationTupleElement= ruleLinkOperationTupleElement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2720:2: iv_ruleLinkOperationTupleElement= ruleLinkOperationTupleElement EOF
            {
             newCompositeNode(grammarAccess.getLinkOperationTupleElementRule()); 
            pushFollow(FOLLOW_ruleLinkOperationTupleElement_in_entryRuleLinkOperationTupleElement5723);
            iv_ruleLinkOperationTupleElement=ruleLinkOperationTupleElement();

            state._fsp--;

             current =iv_ruleLinkOperationTupleElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkOperationTupleElement5733); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinkOperationTupleElement"


    // $ANTLR start "ruleLinkOperationTupleElement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2727:1: ruleLinkOperationTupleElement returns [EObject current=null] : ( ( (lv_objectOrRole_0_0= RULE_ID ) ) ( (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )? otherlv_4= '=>' ( (lv_object_5_0= RULE_ID ) ) )? ) ;
    public final EObject ruleLinkOperationTupleElement() throws RecognitionException {
        EObject current = null;

        Token lv_objectOrRole_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_object_5_0=null;
        EObject lv_roleIndex_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2730:28: ( ( ( (lv_objectOrRole_0_0= RULE_ID ) ) ( (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )? otherlv_4= '=>' ( (lv_object_5_0= RULE_ID ) ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2731:1: ( ( (lv_objectOrRole_0_0= RULE_ID ) ) ( (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )? otherlv_4= '=>' ( (lv_object_5_0= RULE_ID ) ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2731:1: ( ( (lv_objectOrRole_0_0= RULE_ID ) ) ( (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )? otherlv_4= '=>' ( (lv_object_5_0= RULE_ID ) ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2731:2: ( (lv_objectOrRole_0_0= RULE_ID ) ) ( (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )? otherlv_4= '=>' ( (lv_object_5_0= RULE_ID ) ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2731:2: ( (lv_objectOrRole_0_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2732:1: (lv_objectOrRole_0_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2732:1: (lv_objectOrRole_0_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2733:3: lv_objectOrRole_0_0= RULE_ID
            {
            lv_objectOrRole_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLinkOperationTupleElement5775); 

            			newLeafNode(lv_objectOrRole_0_0, grammarAccess.getLinkOperationTupleElementAccess().getObjectOrRoleIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkOperationTupleElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"objectOrRole",
                    		lv_objectOrRole_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2749:2: ( (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )? otherlv_4= '=>' ( (lv_object_5_0= RULE_ID ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==23||LA51_0==50) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2749:3: (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )? otherlv_4= '=>' ( (lv_object_5_0= RULE_ID ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2749:3: (otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']' )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==50) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2749:5: otherlv_1= '[' ( (lv_roleIndex_2_0= ruleExpression ) ) otherlv_3= ']'
                            {
                            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleLinkOperationTupleElement5794); 

                                	newLeafNode(otherlv_1, grammarAccess.getLinkOperationTupleElementAccess().getLeftSquareBracketKeyword_1_0_0());
                                
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2753:1: ( (lv_roleIndex_2_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2754:1: (lv_roleIndex_2_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2754:1: (lv_roleIndex_2_0= ruleExpression )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2755:3: lv_roleIndex_2_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getLinkOperationTupleElementAccess().getRoleIndexExpressionParserRuleCall_1_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleLinkOperationTupleElement5815);
                            lv_roleIndex_2_0=ruleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getLinkOperationTupleElementRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"roleIndex",
                                    		lv_roleIndex_2_0, 
                                    		"Expression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleLinkOperationTupleElement5827); 

                                	newLeafNode(otherlv_3, grammarAccess.getLinkOperationTupleElementAccess().getRightSquareBracketKeyword_1_0_2());
                                

                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleLinkOperationTupleElement5841); 

                        	newLeafNode(otherlv_4, grammarAccess.getLinkOperationTupleElementAccess().getEqualsSignGreaterThanSignKeyword_1_1());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2779:1: ( (lv_object_5_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2780:1: (lv_object_5_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2780:1: (lv_object_5_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2781:3: lv_object_5_0= RULE_ID
                    {
                    lv_object_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLinkOperationTupleElement5858); 

                    			newLeafNode(lv_object_5_0, grammarAccess.getLinkOperationTupleElementAccess().getObjectIDTerminalRuleCall_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLinkOperationTupleElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"object",
                            		lv_object_5_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinkOperationTupleElement"


    // $ANTLR start "entryRuleSequenceOperationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2805:1: entryRuleSequenceOperationExpression returns [EObject current=null] : iv_ruleSequenceOperationExpression= ruleSequenceOperationExpression EOF ;
    public final EObject entryRuleSequenceOperationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceOperationExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2806:2: (iv_ruleSequenceOperationExpression= ruleSequenceOperationExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2807:2: iv_ruleSequenceOperationExpression= ruleSequenceOperationExpression EOF
            {
             newCompositeNode(grammarAccess.getSequenceOperationExpressionRule()); 
            pushFollow(FOLLOW_ruleSequenceOperationExpression_in_entryRuleSequenceOperationExpression5901);
            iv_ruleSequenceOperationExpression=ruleSequenceOperationExpression();

            state._fsp--;

             current =iv_ruleSequenceOperationExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceOperationExpression5911); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceOperationExpression"


    // $ANTLR start "ruleSequenceOperationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2814:1: ruleSequenceOperationExpression returns [EObject current=null] : (otherlv_0= '->' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleSequenceOperationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_operationName_1_0=null;
        EObject lv_tuple_2_0 = null;

        EObject lv_suffix_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2817:28: ( (otherlv_0= '->' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2818:1: (otherlv_0= '->' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2818:1: (otherlv_0= '->' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2818:3: otherlv_0= '->' ( (lv_operationName_1_0= RULE_ID ) ) ( (lv_tuple_2_0= ruleTuple ) ) ( (lv_suffix_3_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleSequenceOperationExpression5948); 

                	newLeafNode(otherlv_0, grammarAccess.getSequenceOperationExpressionAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2822:1: ( (lv_operationName_1_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2823:1: (lv_operationName_1_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2823:1: (lv_operationName_1_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2824:3: lv_operationName_1_0= RULE_ID
            {
            lv_operationName_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSequenceOperationExpression5965); 

            			newLeafNode(lv_operationName_1_0, grammarAccess.getSequenceOperationExpressionAccess().getOperationNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSequenceOperationExpressionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"operationName",
                    		lv_operationName_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2840:2: ( (lv_tuple_2_0= ruleTuple ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2841:1: (lv_tuple_2_0= ruleTuple )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2841:1: (lv_tuple_2_0= ruleTuple )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2842:3: lv_tuple_2_0= ruleTuple
            {
             
            	        newCompositeNode(grammarAccess.getSequenceOperationExpressionAccess().getTupleTupleParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTuple_in_ruleSequenceOperationExpression5991);
            lv_tuple_2_0=ruleTuple();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSequenceOperationExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"tuple",
                    		lv_tuple_2_0, 
                    		"Tuple");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2858:2: ( (lv_suffix_3_0= ruleSuffixExpression ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==49||LA52_0==52) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2859:1: (lv_suffix_3_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2859:1: (lv_suffix_3_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2860:3: lv_suffix_3_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSequenceOperationExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleSequenceOperationExpression6012);
                    lv_suffix_3_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSequenceOperationExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_3_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceOperationExpression"


    // $ANTLR start "entryRuleSequenceReductionExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2884:1: entryRuleSequenceReductionExpression returns [EObject current=null] : iv_ruleSequenceReductionExpression= ruleSequenceReductionExpression EOF ;
    public final EObject entryRuleSequenceReductionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceReductionExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2885:2: (iv_ruleSequenceReductionExpression= ruleSequenceReductionExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2886:2: iv_ruleSequenceReductionExpression= ruleSequenceReductionExpression EOF
            {
             newCompositeNode(grammarAccess.getSequenceReductionExpressionRule()); 
            pushFollow(FOLLOW_ruleSequenceReductionExpression_in_entryRuleSequenceReductionExpression6049);
            iv_ruleSequenceReductionExpression=ruleSequenceReductionExpression();

            state._fsp--;

             current =iv_ruleSequenceReductionExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceReductionExpression6059); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceReductionExpression"


    // $ANTLR start "ruleSequenceReductionExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2893:1: ruleSequenceReductionExpression returns [EObject current=null] : (otherlv_0= '->' otherlv_1= 'reduce' ( (lv_isOrdered_2_0= 'ordered' ) )? ( (lv_behavior_3_0= ruleQualifiedNameWithBinding ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleSequenceReductionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_isOrdered_2_0=null;
        EObject lv_behavior_3_0 = null;

        EObject lv_suffix_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2896:28: ( (otherlv_0= '->' otherlv_1= 'reduce' ( (lv_isOrdered_2_0= 'ordered' ) )? ( (lv_behavior_3_0= ruleQualifiedNameWithBinding ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2897:1: (otherlv_0= '->' otherlv_1= 'reduce' ( (lv_isOrdered_2_0= 'ordered' ) )? ( (lv_behavior_3_0= ruleQualifiedNameWithBinding ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2897:1: (otherlv_0= '->' otherlv_1= 'reduce' ( (lv_isOrdered_2_0= 'ordered' ) )? ( (lv_behavior_3_0= ruleQualifiedNameWithBinding ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2897:3: otherlv_0= '->' otherlv_1= 'reduce' ( (lv_isOrdered_2_0= 'ordered' ) )? ( (lv_behavior_3_0= ruleQualifiedNameWithBinding ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleSequenceReductionExpression6096); 

                	newLeafNode(otherlv_0, grammarAccess.getSequenceReductionExpressionAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleSequenceReductionExpression6108); 

                	newLeafNode(otherlv_1, grammarAccess.getSequenceReductionExpressionAccess().getReduceKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2905:1: ( (lv_isOrdered_2_0= 'ordered' ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==54) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2906:1: (lv_isOrdered_2_0= 'ordered' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2906:1: (lv_isOrdered_2_0= 'ordered' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2907:3: lv_isOrdered_2_0= 'ordered'
                    {
                    lv_isOrdered_2_0=(Token)match(input,54,FOLLOW_54_in_ruleSequenceReductionExpression6126); 

                            newLeafNode(lv_isOrdered_2_0, grammarAccess.getSequenceReductionExpressionAccess().getIsOrderedOrderedKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSequenceReductionExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "isOrdered", true, "ordered");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2920:3: ( (lv_behavior_3_0= ruleQualifiedNameWithBinding ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2921:1: (lv_behavior_3_0= ruleQualifiedNameWithBinding )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2921:1: (lv_behavior_3_0= ruleQualifiedNameWithBinding )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2922:3: lv_behavior_3_0= ruleQualifiedNameWithBinding
            {
             
            	        newCompositeNode(grammarAccess.getSequenceReductionExpressionAccess().getBehaviorQualifiedNameWithBindingParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleSequenceReductionExpression6161);
            lv_behavior_3_0=ruleQualifiedNameWithBinding();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSequenceReductionExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"behavior",
                    		lv_behavior_3_0, 
                    		"QualifiedNameWithBinding");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2938:2: ( (lv_suffix_4_0= ruleSuffixExpression ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==49||LA54_0==52) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2939:1: (lv_suffix_4_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2939:1: (lv_suffix_4_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2940:3: lv_suffix_4_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSequenceReductionExpressionAccess().getSuffixSuffixExpressionParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleSequenceReductionExpression6182);
                    lv_suffix_4_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSequenceReductionExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_4_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceReductionExpression"


    // $ANTLR start "entryRuleSequenceExpansionExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2964:1: entryRuleSequenceExpansionExpression returns [EObject current=null] : iv_ruleSequenceExpansionExpression= ruleSequenceExpansionExpression EOF ;
    public final EObject entryRuleSequenceExpansionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceExpansionExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2965:2: (iv_ruleSequenceExpansionExpression= ruleSequenceExpansionExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2966:2: iv_ruleSequenceExpansionExpression= ruleSequenceExpansionExpression EOF
            {
             newCompositeNode(grammarAccess.getSequenceExpansionExpressionRule()); 
            pushFollow(FOLLOW_ruleSequenceExpansionExpression_in_entryRuleSequenceExpansionExpression6219);
            iv_ruleSequenceExpansionExpression=ruleSequenceExpansionExpression();

            state._fsp--;

             current =iv_ruleSequenceExpansionExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceExpansionExpression6229); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceExpansionExpression"


    // $ANTLR start "ruleSequenceExpansionExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2973:1: ruleSequenceExpansionExpression returns [EObject current=null] : (this_SelectOrRejectOperation_0= ruleSelectOrRejectOperation | this_CollectOrIterateOperation_1= ruleCollectOrIterateOperation | this_ForAllOrExistsOrOneOperation_2= ruleForAllOrExistsOrOneOperation | this_IsUniqueOperation_3= ruleIsUniqueOperation ) ;
    public final EObject ruleSequenceExpansionExpression() throws RecognitionException {
        EObject current = null;

        EObject this_SelectOrRejectOperation_0 = null;

        EObject this_CollectOrIterateOperation_1 = null;

        EObject this_ForAllOrExistsOrOneOperation_2 = null;

        EObject this_IsUniqueOperation_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2976:28: ( (this_SelectOrRejectOperation_0= ruleSelectOrRejectOperation | this_CollectOrIterateOperation_1= ruleCollectOrIterateOperation | this_ForAllOrExistsOrOneOperation_2= ruleForAllOrExistsOrOneOperation | this_IsUniqueOperation_3= ruleIsUniqueOperation ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2977:1: (this_SelectOrRejectOperation_0= ruleSelectOrRejectOperation | this_CollectOrIterateOperation_1= ruleCollectOrIterateOperation | this_ForAllOrExistsOrOneOperation_2= ruleForAllOrExistsOrOneOperation | this_IsUniqueOperation_3= ruleIsUniqueOperation )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2977:1: (this_SelectOrRejectOperation_0= ruleSelectOrRejectOperation | this_CollectOrIterateOperation_1= ruleCollectOrIterateOperation | this_ForAllOrExistsOrOneOperation_2= ruleForAllOrExistsOrOneOperation | this_IsUniqueOperation_3= ruleIsUniqueOperation )
            int alt55=4;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==52) ) {
                switch ( input.LA(2) ) {
                case 92:
                case 93:
                    {
                    alt55=1;
                    }
                    break;
                case 96:
                case 97:
                case 98:
                    {
                    alt55=3;
                    }
                    break;
                case 55:
                    {
                    alt55=4;
                    }
                    break;
                case 94:
                case 95:
                    {
                    alt55=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2978:5: this_SelectOrRejectOperation_0= ruleSelectOrRejectOperation
                    {
                     
                            newCompositeNode(grammarAccess.getSequenceExpansionExpressionAccess().getSelectOrRejectOperationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSelectOrRejectOperation_in_ruleSequenceExpansionExpression6276);
                    this_SelectOrRejectOperation_0=ruleSelectOrRejectOperation();

                    state._fsp--;

                     
                            current = this_SelectOrRejectOperation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2988:5: this_CollectOrIterateOperation_1= ruleCollectOrIterateOperation
                    {
                     
                            newCompositeNode(grammarAccess.getSequenceExpansionExpressionAccess().getCollectOrIterateOperationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCollectOrIterateOperation_in_ruleSequenceExpansionExpression6303);
                    this_CollectOrIterateOperation_1=ruleCollectOrIterateOperation();

                    state._fsp--;

                     
                            current = this_CollectOrIterateOperation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:2998:5: this_ForAllOrExistsOrOneOperation_2= ruleForAllOrExistsOrOneOperation
                    {
                     
                            newCompositeNode(grammarAccess.getSequenceExpansionExpressionAccess().getForAllOrExistsOrOneOperationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleForAllOrExistsOrOneOperation_in_ruleSequenceExpansionExpression6330);
                    this_ForAllOrExistsOrOneOperation_2=ruleForAllOrExistsOrOneOperation();

                    state._fsp--;

                     
                            current = this_ForAllOrExistsOrOneOperation_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3008:5: this_IsUniqueOperation_3= ruleIsUniqueOperation
                    {
                     
                            newCompositeNode(grammarAccess.getSequenceExpansionExpressionAccess().getIsUniqueOperationParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleIsUniqueOperation_in_ruleSequenceExpansionExpression6357);
                    this_IsUniqueOperation_3=ruleIsUniqueOperation();

                    state._fsp--;

                     
                            current = this_IsUniqueOperation_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceExpansionExpression"


    // $ANTLR start "entryRuleSelectOrRejectOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3024:1: entryRuleSelectOrRejectOperation returns [EObject current=null] : iv_ruleSelectOrRejectOperation= ruleSelectOrRejectOperation EOF ;
    public final EObject entryRuleSelectOrRejectOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectOrRejectOperation = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3025:2: (iv_ruleSelectOrRejectOperation= ruleSelectOrRejectOperation EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3026:2: iv_ruleSelectOrRejectOperation= ruleSelectOrRejectOperation EOF
            {
             newCompositeNode(grammarAccess.getSelectOrRejectOperationRule()); 
            pushFollow(FOLLOW_ruleSelectOrRejectOperation_in_entryRuleSelectOrRejectOperation6392);
            iv_ruleSelectOrRejectOperation=ruleSelectOrRejectOperation();

            state._fsp--;

             current =iv_ruleSelectOrRejectOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectOrRejectOperation6402); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectOrRejectOperation"


    // $ANTLR start "ruleSelectOrRejectOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3033:1: ruleSelectOrRejectOperation returns [EObject current=null] : (otherlv_0= '->' ( (lv_op_1_0= ruleSelectOrRejectOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleSelectOrRejectOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_op_1_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_suffix_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3036:28: ( (otherlv_0= '->' ( (lv_op_1_0= ruleSelectOrRejectOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3037:1: (otherlv_0= '->' ( (lv_op_1_0= ruleSelectOrRejectOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3037:1: (otherlv_0= '->' ( (lv_op_1_0= ruleSelectOrRejectOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3037:3: otherlv_0= '->' ( (lv_op_1_0= ruleSelectOrRejectOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleSelectOrRejectOperation6439); 

                	newLeafNode(otherlv_0, grammarAccess.getSelectOrRejectOperationAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3041:1: ( (lv_op_1_0= ruleSelectOrRejectOperator ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3042:1: (lv_op_1_0= ruleSelectOrRejectOperator )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3042:1: (lv_op_1_0= ruleSelectOrRejectOperator )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3043:3: lv_op_1_0= ruleSelectOrRejectOperator
            {
             
            	        newCompositeNode(grammarAccess.getSelectOrRejectOperationAccess().getOpSelectOrRejectOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSelectOrRejectOperator_in_ruleSelectOrRejectOperation6460);
            lv_op_1_0=ruleSelectOrRejectOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectOrRejectOperationRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_1_0, 
                    		"SelectOrRejectOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3059:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3060:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3060:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3061:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectOrRejectOperation6477); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSelectOrRejectOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSelectOrRejectOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleSelectOrRejectOperation6494); 

                	newLeafNode(otherlv_3, grammarAccess.getSelectOrRejectOperationAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3081:1: ( (lv_expr_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3082:1: (lv_expr_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3082:1: (lv_expr_4_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3083:3: lv_expr_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getSelectOrRejectOperationAccess().getExprExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSelectOrRejectOperation6515);
            lv_expr_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectOrRejectOperationRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleSelectOrRejectOperation6527); 

                	newLeafNode(otherlv_5, grammarAccess.getSelectOrRejectOperationAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3103:1: ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==49||LA56_0==52) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3104:1: (lv_suffix_6_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3104:1: (lv_suffix_6_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3105:3: lv_suffix_6_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectOrRejectOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleSelectOrRejectOperation6548);
                    lv_suffix_6_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSelectOrRejectOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_6_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectOrRejectOperation"


    // $ANTLR start "entryRuleCollectOrIterateOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3129:1: entryRuleCollectOrIterateOperation returns [EObject current=null] : iv_ruleCollectOrIterateOperation= ruleCollectOrIterateOperation EOF ;
    public final EObject entryRuleCollectOrIterateOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectOrIterateOperation = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3130:2: (iv_ruleCollectOrIterateOperation= ruleCollectOrIterateOperation EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3131:2: iv_ruleCollectOrIterateOperation= ruleCollectOrIterateOperation EOF
            {
             newCompositeNode(grammarAccess.getCollectOrIterateOperationRule()); 
            pushFollow(FOLLOW_ruleCollectOrIterateOperation_in_entryRuleCollectOrIterateOperation6585);
            iv_ruleCollectOrIterateOperation=ruleCollectOrIterateOperation();

            state._fsp--;

             current =iv_ruleCollectOrIterateOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectOrIterateOperation6595); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectOrIterateOperation"


    // $ANTLR start "ruleCollectOrIterateOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3138:1: ruleCollectOrIterateOperation returns [EObject current=null] : (otherlv_0= '->' ( (lv_op_1_0= ruleCollectOrIterateOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleCollectOrIterateOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_op_1_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_suffix_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3141:28: ( (otherlv_0= '->' ( (lv_op_1_0= ruleCollectOrIterateOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3142:1: (otherlv_0= '->' ( (lv_op_1_0= ruleCollectOrIterateOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3142:1: (otherlv_0= '->' ( (lv_op_1_0= ruleCollectOrIterateOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3142:3: otherlv_0= '->' ( (lv_op_1_0= ruleCollectOrIterateOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleCollectOrIterateOperation6632); 

                	newLeafNode(otherlv_0, grammarAccess.getCollectOrIterateOperationAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3146:1: ( (lv_op_1_0= ruleCollectOrIterateOperator ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3147:1: (lv_op_1_0= ruleCollectOrIterateOperator )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3147:1: (lv_op_1_0= ruleCollectOrIterateOperator )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3148:3: lv_op_1_0= ruleCollectOrIterateOperator
            {
             
            	        newCompositeNode(grammarAccess.getCollectOrIterateOperationAccess().getOpCollectOrIterateOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleCollectOrIterateOperator_in_ruleCollectOrIterateOperation6653);
            lv_op_1_0=ruleCollectOrIterateOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectOrIterateOperationRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_1_0, 
                    		"CollectOrIterateOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3164:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3165:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3165:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3166:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCollectOrIterateOperation6670); 

            			newLeafNode(lv_name_2_0, grammarAccess.getCollectOrIterateOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCollectOrIterateOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleCollectOrIterateOperation6687); 

                	newLeafNode(otherlv_3, grammarAccess.getCollectOrIterateOperationAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3186:1: ( (lv_expr_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3187:1: (lv_expr_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3187:1: (lv_expr_4_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3188:3: lv_expr_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getCollectOrIterateOperationAccess().getExprExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleCollectOrIterateOperation6708);
            lv_expr_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectOrIterateOperationRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleCollectOrIterateOperation6720); 

                	newLeafNode(otherlv_5, grammarAccess.getCollectOrIterateOperationAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3208:1: ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==49||LA57_0==52) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3209:1: (lv_suffix_6_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3209:1: (lv_suffix_6_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3210:3: lv_suffix_6_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getCollectOrIterateOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleCollectOrIterateOperation6741);
                    lv_suffix_6_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCollectOrIterateOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_6_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectOrIterateOperation"


    // $ANTLR start "entryRuleForAllOrExistsOrOneOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3234:1: entryRuleForAllOrExistsOrOneOperation returns [EObject current=null] : iv_ruleForAllOrExistsOrOneOperation= ruleForAllOrExistsOrOneOperation EOF ;
    public final EObject entryRuleForAllOrExistsOrOneOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForAllOrExistsOrOneOperation = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3235:2: (iv_ruleForAllOrExistsOrOneOperation= ruleForAllOrExistsOrOneOperation EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3236:2: iv_ruleForAllOrExistsOrOneOperation= ruleForAllOrExistsOrOneOperation EOF
            {
             newCompositeNode(grammarAccess.getForAllOrExistsOrOneOperationRule()); 
            pushFollow(FOLLOW_ruleForAllOrExistsOrOneOperation_in_entryRuleForAllOrExistsOrOneOperation6778);
            iv_ruleForAllOrExistsOrOneOperation=ruleForAllOrExistsOrOneOperation();

            state._fsp--;

             current =iv_ruleForAllOrExistsOrOneOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForAllOrExistsOrOneOperation6788); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForAllOrExistsOrOneOperation"


    // $ANTLR start "ruleForAllOrExistsOrOneOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3243:1: ruleForAllOrExistsOrOneOperation returns [EObject current=null] : (otherlv_0= '->' ( (lv_op_1_0= ruleForAllOrExistsOrOneOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleForAllOrExistsOrOneOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_op_1_0 = null;

        EObject lv_expr_4_0 = null;

        EObject lv_suffix_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3246:28: ( (otherlv_0= '->' ( (lv_op_1_0= ruleForAllOrExistsOrOneOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3247:1: (otherlv_0= '->' ( (lv_op_1_0= ruleForAllOrExistsOrOneOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3247:1: (otherlv_0= '->' ( (lv_op_1_0= ruleForAllOrExistsOrOneOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3247:3: otherlv_0= '->' ( (lv_op_1_0= ruleForAllOrExistsOrOneOperator ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleForAllOrExistsOrOneOperation6825); 

                	newLeafNode(otherlv_0, grammarAccess.getForAllOrExistsOrOneOperationAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3251:1: ( (lv_op_1_0= ruleForAllOrExistsOrOneOperator ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3252:1: (lv_op_1_0= ruleForAllOrExistsOrOneOperator )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3252:1: (lv_op_1_0= ruleForAllOrExistsOrOneOperator )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3253:3: lv_op_1_0= ruleForAllOrExistsOrOneOperator
            {
             
            	        newCompositeNode(grammarAccess.getForAllOrExistsOrOneOperationAccess().getOpForAllOrExistsOrOneOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleForAllOrExistsOrOneOperator_in_ruleForAllOrExistsOrOneOperation6846);
            lv_op_1_0=ruleForAllOrExistsOrOneOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForAllOrExistsOrOneOperationRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_1_0, 
                    		"ForAllOrExistsOrOneOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3269:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3270:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3270:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3271:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleForAllOrExistsOrOneOperation6863); 

            			newLeafNode(lv_name_2_0, grammarAccess.getForAllOrExistsOrOneOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getForAllOrExistsOrOneOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleForAllOrExistsOrOneOperation6880); 

                	newLeafNode(otherlv_3, grammarAccess.getForAllOrExistsOrOneOperationAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3291:1: ( (lv_expr_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3292:1: (lv_expr_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3292:1: (lv_expr_4_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3293:3: lv_expr_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getForAllOrExistsOrOneOperationAccess().getExprExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleForAllOrExistsOrOneOperation6901);
            lv_expr_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForAllOrExistsOrOneOperationRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleForAllOrExistsOrOneOperation6913); 

                	newLeafNode(otherlv_5, grammarAccess.getForAllOrExistsOrOneOperationAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3313:1: ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==49||LA58_0==52) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3314:1: (lv_suffix_6_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3314:1: (lv_suffix_6_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3315:3: lv_suffix_6_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getForAllOrExistsOrOneOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleForAllOrExistsOrOneOperation6934);
                    lv_suffix_6_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForAllOrExistsOrOneOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_6_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForAllOrExistsOrOneOperation"


    // $ANTLR start "entryRuleIsUniqueOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3339:1: entryRuleIsUniqueOperation returns [EObject current=null] : iv_ruleIsUniqueOperation= ruleIsUniqueOperation EOF ;
    public final EObject entryRuleIsUniqueOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsUniqueOperation = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3340:2: (iv_ruleIsUniqueOperation= ruleIsUniqueOperation EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3341:2: iv_ruleIsUniqueOperation= ruleIsUniqueOperation EOF
            {
             newCompositeNode(grammarAccess.getIsUniqueOperationRule()); 
            pushFollow(FOLLOW_ruleIsUniqueOperation_in_entryRuleIsUniqueOperation6971);
            iv_ruleIsUniqueOperation=ruleIsUniqueOperation();

            state._fsp--;

             current =iv_ruleIsUniqueOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsUniqueOperation6981); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsUniqueOperation"


    // $ANTLR start "ruleIsUniqueOperation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3348:1: ruleIsUniqueOperation returns [EObject current=null] : (otherlv_0= '->' otherlv_1= 'isUnique' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleIsUniqueOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expr_4_0 = null;

        EObject lv_suffix_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3351:28: ( (otherlv_0= '->' otherlv_1= 'isUnique' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3352:1: (otherlv_0= '->' otherlv_1= 'isUnique' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3352:1: (otherlv_0= '->' otherlv_1= 'isUnique' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3352:3: otherlv_0= '->' otherlv_1= 'isUnique' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_expr_4_0= ruleExpression ) ) otherlv_5= ')' ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleIsUniqueOperation7018); 

                	newLeafNode(otherlv_0, grammarAccess.getIsUniqueOperationAccess().getHyphenMinusGreaterThanSignKeyword_0());
                
            otherlv_1=(Token)match(input,55,FOLLOW_55_in_ruleIsUniqueOperation7030); 

                	newLeafNode(otherlv_1, grammarAccess.getIsUniqueOperationAccess().getIsUniqueKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3360:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3361:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3361:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3362:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIsUniqueOperation7047); 

            			newLeafNode(lv_name_2_0, grammarAccess.getIsUniqueOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsUniqueOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleIsUniqueOperation7064); 

                	newLeafNode(otherlv_3, grammarAccess.getIsUniqueOperationAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3382:1: ( (lv_expr_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3383:1: (lv_expr_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3383:1: (lv_expr_4_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3384:3: lv_expr_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIsUniqueOperationAccess().getExprExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIsUniqueOperation7085);
            lv_expr_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIsUniqueOperationRule());
            	        }
                   		set(
                   			current, 
                   			"expr",
                    		lv_expr_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleIsUniqueOperation7097); 

                	newLeafNode(otherlv_5, grammarAccess.getIsUniqueOperationAccess().getRightParenthesisKeyword_5());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3404:1: ( (lv_suffix_6_0= ruleSuffixExpression ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==49||LA59_0==52) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3405:1: (lv_suffix_6_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3405:1: (lv_suffix_6_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3406:3: lv_suffix_6_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getIsUniqueOperationAccess().getSuffixSuffixExpressionParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleIsUniqueOperation7118);
                    lv_suffix_6_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIsUniqueOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_6_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsUniqueOperation"


    // $ANTLR start "entryRuleValueSpecification"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3430:1: entryRuleValueSpecification returns [EObject current=null] : iv_ruleValueSpecification= ruleValueSpecification EOF ;
    public final EObject entryRuleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3431:2: (iv_ruleValueSpecification= ruleValueSpecification EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3432:2: iv_ruleValueSpecification= ruleValueSpecification EOF
            {
             newCompositeNode(grammarAccess.getValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification7155);
            iv_ruleValueSpecification=ruleValueSpecification();

            state._fsp--;

             current =iv_ruleValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueSpecification7165); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueSpecification"


    // $ANTLR start "ruleValueSpecification"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3439:1: ruleValueSpecification returns [EObject current=null] : (this_NameExpression_0= ruleNameExpression | this_LITERAL_1= ruleLITERAL | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationExpression_4= ruleInstanceCreationExpression | this_ParenthesizedExpression_5= ruleParenthesizedExpression | this_NullExpression_6= ruleNullExpression ) ;
    public final EObject ruleValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject this_NameExpression_0 = null;

        EObject this_LITERAL_1 = null;

        EObject this_ThisExpression_2 = null;

        EObject this_SuperInvocationExpression_3 = null;

        EObject this_InstanceCreationExpression_4 = null;

        EObject this_ParenthesizedExpression_5 = null;

        EObject this_NullExpression_6 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3442:28: ( (this_NameExpression_0= ruleNameExpression | this_LITERAL_1= ruleLITERAL | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationExpression_4= ruleInstanceCreationExpression | this_ParenthesizedExpression_5= ruleParenthesizedExpression | this_NullExpression_6= ruleNullExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3443:1: (this_NameExpression_0= ruleNameExpression | this_LITERAL_1= ruleLITERAL | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationExpression_4= ruleInstanceCreationExpression | this_ParenthesizedExpression_5= ruleParenthesizedExpression | this_NullExpression_6= ruleNullExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3443:1: (this_NameExpression_0= ruleNameExpression | this_LITERAL_1= ruleLITERAL | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationExpression_4= ruleInstanceCreationExpression | this_ParenthesizedExpression_5= ruleParenthesizedExpression | this_NullExpression_6= ruleNullExpression )
            int alt60=7;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 17:
            case 18:
                {
                alt60=1;
                }
                break;
            case RULE_INTEGERVALUE:
            case RULE_STRING:
            case 16:
            case 87:
            case 88:
                {
                alt60=2;
                }
                break;
            case 57:
                {
                alt60=3;
                }
                break;
            case 58:
                {
                alt60=4;
                }
                break;
            case 59:
                {
                alt60=5;
                }
                break;
            case 24:
                {
                alt60=6;
                }
                break;
            case 56:
                {
                alt60=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3444:5: this_NameExpression_0= ruleNameExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getNameExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNameExpression_in_ruleValueSpecification7212);
                    this_NameExpression_0=ruleNameExpression();

                    state._fsp--;

                     
                            current = this_NameExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3454:5: this_LITERAL_1= ruleLITERAL
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getLITERALParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLITERAL_in_ruleValueSpecification7239);
                    this_LITERAL_1=ruleLITERAL();

                    state._fsp--;

                     
                            current = this_LITERAL_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3464:5: this_ThisExpression_2= ruleThisExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getThisExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleThisExpression_in_ruleValueSpecification7266);
                    this_ThisExpression_2=ruleThisExpression();

                    state._fsp--;

                     
                            current = this_ThisExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3474:5: this_SuperInvocationExpression_3= ruleSuperInvocationExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getSuperInvocationExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleSuperInvocationExpression_in_ruleValueSpecification7293);
                    this_SuperInvocationExpression_3=ruleSuperInvocationExpression();

                    state._fsp--;

                     
                            current = this_SuperInvocationExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3484:5: this_InstanceCreationExpression_4= ruleInstanceCreationExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getInstanceCreationExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleInstanceCreationExpression_in_ruleValueSpecification7320);
                    this_InstanceCreationExpression_4=ruleInstanceCreationExpression();

                    state._fsp--;

                     
                            current = this_InstanceCreationExpression_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3494:5: this_ParenthesizedExpression_5= ruleParenthesizedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getParenthesizedExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleValueSpecification7347);
                    this_ParenthesizedExpression_5=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3504:5: this_NullExpression_6= ruleNullExpression
                    {
                     
                            newCompositeNode(grammarAccess.getValueSpecificationAccess().getNullExpressionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleNullExpression_in_ruleValueSpecification7374);
                    this_NullExpression_6=ruleNullExpression();

                    state._fsp--;

                     
                            current = this_NullExpression_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueSpecification"


    // $ANTLR start "entryRuleNonLiteralValueSpecification"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3520:1: entryRuleNonLiteralValueSpecification returns [EObject current=null] : iv_ruleNonLiteralValueSpecification= ruleNonLiteralValueSpecification EOF ;
    public final EObject entryRuleNonLiteralValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonLiteralValueSpecification = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3521:2: (iv_ruleNonLiteralValueSpecification= ruleNonLiteralValueSpecification EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3522:2: iv_ruleNonLiteralValueSpecification= ruleNonLiteralValueSpecification EOF
            {
             newCompositeNode(grammarAccess.getNonLiteralValueSpecificationRule()); 
            pushFollow(FOLLOW_ruleNonLiteralValueSpecification_in_entryRuleNonLiteralValueSpecification7409);
            iv_ruleNonLiteralValueSpecification=ruleNonLiteralValueSpecification();

            state._fsp--;

             current =iv_ruleNonLiteralValueSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonLiteralValueSpecification7419); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonLiteralValueSpecification"


    // $ANTLR start "ruleNonLiteralValueSpecification"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3529:1: ruleNonLiteralValueSpecification returns [EObject current=null] : (this_NameExpression_0= ruleNameExpression | this_ParenthesizedExpression_1= ruleParenthesizedExpression | this_InstanceCreationExpression_2= ruleInstanceCreationExpression | this_ThisExpression_3= ruleThisExpression | this_SuperInvocationExpression_4= ruleSuperInvocationExpression ) ;
    public final EObject ruleNonLiteralValueSpecification() throws RecognitionException {
        EObject current = null;

        EObject this_NameExpression_0 = null;

        EObject this_ParenthesizedExpression_1 = null;

        EObject this_InstanceCreationExpression_2 = null;

        EObject this_ThisExpression_3 = null;

        EObject this_SuperInvocationExpression_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3532:28: ( (this_NameExpression_0= ruleNameExpression | this_ParenthesizedExpression_1= ruleParenthesizedExpression | this_InstanceCreationExpression_2= ruleInstanceCreationExpression | this_ThisExpression_3= ruleThisExpression | this_SuperInvocationExpression_4= ruleSuperInvocationExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3533:1: (this_NameExpression_0= ruleNameExpression | this_ParenthesizedExpression_1= ruleParenthesizedExpression | this_InstanceCreationExpression_2= ruleInstanceCreationExpression | this_ThisExpression_3= ruleThisExpression | this_SuperInvocationExpression_4= ruleSuperInvocationExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3533:1: (this_NameExpression_0= ruleNameExpression | this_ParenthesizedExpression_1= ruleParenthesizedExpression | this_InstanceCreationExpression_2= ruleInstanceCreationExpression | this_ThisExpression_3= ruleThisExpression | this_SuperInvocationExpression_4= ruleSuperInvocationExpression )
            int alt61=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 17:
            case 18:
                {
                alt61=1;
                }
                break;
            case 24:
                {
                alt61=2;
                }
                break;
            case 59:
                {
                alt61=3;
                }
                break;
            case 57:
                {
                alt61=4;
                }
                break;
            case 58:
                {
                alt61=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3534:5: this_NameExpression_0= ruleNameExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNonLiteralValueSpecificationAccess().getNameExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNameExpression_in_ruleNonLiteralValueSpecification7466);
                    this_NameExpression_0=ruleNameExpression();

                    state._fsp--;

                     
                            current = this_NameExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3544:5: this_ParenthesizedExpression_1= ruleParenthesizedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNonLiteralValueSpecificationAccess().getParenthesizedExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleNonLiteralValueSpecification7493);
                    this_ParenthesizedExpression_1=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3554:5: this_InstanceCreationExpression_2= ruleInstanceCreationExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNonLiteralValueSpecificationAccess().getInstanceCreationExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInstanceCreationExpression_in_ruleNonLiteralValueSpecification7520);
                    this_InstanceCreationExpression_2=ruleInstanceCreationExpression();

                    state._fsp--;

                     
                            current = this_InstanceCreationExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3564:5: this_ThisExpression_3= ruleThisExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNonLiteralValueSpecificationAccess().getThisExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleThisExpression_in_ruleNonLiteralValueSpecification7547);
                    this_ThisExpression_3=ruleThisExpression();

                    state._fsp--;

                     
                            current = this_ThisExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3574:5: this_SuperInvocationExpression_4= ruleSuperInvocationExpression
                    {
                     
                            newCompositeNode(grammarAccess.getNonLiteralValueSpecificationAccess().getSuperInvocationExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSuperInvocationExpression_in_ruleNonLiteralValueSpecification7574);
                    this_SuperInvocationExpression_4=ruleSuperInvocationExpression();

                    state._fsp--;

                     
                            current = this_SuperInvocationExpression_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonLiteralValueSpecification"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3590:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3591:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3592:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression7609);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression7619); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3599:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_expOrTypeCast_1_0= ruleExpression ) ) otherlv_2= ')' ( ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) ) | ( (lv_suffix_4_0= ruleSuffixExpression ) ) )? ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expOrTypeCast_1_0 = null;

        EObject lv_casted_3_0 = null;

        EObject lv_suffix_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3602:28: ( (otherlv_0= '(' ( (lv_expOrTypeCast_1_0= ruleExpression ) ) otherlv_2= ')' ( ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) ) | ( (lv_suffix_4_0= ruleSuffixExpression ) ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3603:1: (otherlv_0= '(' ( (lv_expOrTypeCast_1_0= ruleExpression ) ) otherlv_2= ')' ( ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) ) | ( (lv_suffix_4_0= ruleSuffixExpression ) ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3603:1: (otherlv_0= '(' ( (lv_expOrTypeCast_1_0= ruleExpression ) ) otherlv_2= ')' ( ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) ) | ( (lv_suffix_4_0= ruleSuffixExpression ) ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3603:3: otherlv_0= '(' ( (lv_expOrTypeCast_1_0= ruleExpression ) ) otherlv_2= ')' ( ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) ) | ( (lv_suffix_4_0= ruleSuffixExpression ) ) )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleParenthesizedExpression7656); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3607:1: ( (lv_expOrTypeCast_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3608:1: (lv_expOrTypeCast_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3608:1: (lv_expOrTypeCast_1_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3609:3: lv_expOrTypeCast_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpOrTypeCastExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression7677);
            lv_expOrTypeCast_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"expOrTypeCast",
                    		lv_expOrTypeCast_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleParenthesizedExpression7689); 

                	newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3629:1: ( ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) ) | ( (lv_suffix_4_0= ruleSuffixExpression ) ) )?
            int alt62=3;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID||(LA62_0>=17 && LA62_0<=18)||LA62_0==24||(LA62_0>=57 && LA62_0<=59)) ) {
                alt62=1;
            }
            else if ( (LA62_0==49||LA62_0==52) ) {
                alt62=2;
            }
            switch (alt62) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3629:2: ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3629:2: ( (lv_casted_3_0= ruleNonLiteralValueSpecification ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3630:1: (lv_casted_3_0= ruleNonLiteralValueSpecification )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3630:1: (lv_casted_3_0= ruleNonLiteralValueSpecification )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3631:3: lv_casted_3_0= ruleNonLiteralValueSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getCastedNonLiteralValueSpecificationParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNonLiteralValueSpecification_in_ruleParenthesizedExpression7711);
                    lv_casted_3_0=ruleNonLiteralValueSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"casted",
                            		lv_casted_3_0, 
                            		"NonLiteralValueSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3648:6: ( (lv_suffix_4_0= ruleSuffixExpression ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3648:6: ( (lv_suffix_4_0= ruleSuffixExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3649:1: (lv_suffix_4_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3649:1: (lv_suffix_4_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3650:3: lv_suffix_4_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleParenthesizedExpression7738);
                    lv_suffix_4_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_4_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleNullExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3674:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3675:2: (iv_ruleNullExpression= ruleNullExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3676:2: iv_ruleNullExpression= ruleNullExpression EOF
            {
             newCompositeNode(grammarAccess.getNullExpressionRule()); 
            pushFollow(FOLLOW_ruleNullExpression_in_entryRuleNullExpression7776);
            iv_ruleNullExpression=ruleNullExpression();

            state._fsp--;

             current =iv_ruleNullExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullExpression7786); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullExpression"


    // $ANTLR start "ruleNullExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3683:1: ruleNullExpression returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3686:28: ( ( () otherlv_1= 'null' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3687:1: ( () otherlv_1= 'null' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3687:1: ( () otherlv_1= 'null' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3687:2: () otherlv_1= 'null'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3687:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3688:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNullExpressionAccess().getNullExpressionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleNullExpression7832); 

                	newLeafNode(otherlv_1, grammarAccess.getNullExpressionAccess().getNullKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullExpression"


    // $ANTLR start "entryRuleThisExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3705:1: entryRuleThisExpression returns [EObject current=null] : iv_ruleThisExpression= ruleThisExpression EOF ;
    public final EObject entryRuleThisExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThisExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3706:2: (iv_ruleThisExpression= ruleThisExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3707:2: iv_ruleThisExpression= ruleThisExpression EOF
            {
             newCompositeNode(grammarAccess.getThisExpressionRule()); 
            pushFollow(FOLLOW_ruleThisExpression_in_entryRuleThisExpression7868);
            iv_ruleThisExpression=ruleThisExpression();

            state._fsp--;

             current =iv_ruleThisExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThisExpression7878); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisExpression"


    // $ANTLR start "ruleThisExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3714:1: ruleThisExpression returns [EObject current=null] : ( () otherlv_1= 'this' ( (lv_suffix_2_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleThisExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_suffix_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3717:28: ( ( () otherlv_1= 'this' ( (lv_suffix_2_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3718:1: ( () otherlv_1= 'this' ( (lv_suffix_2_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3718:1: ( () otherlv_1= 'this' ( (lv_suffix_2_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3718:2: () otherlv_1= 'this' ( (lv_suffix_2_0= ruleSuffixExpression ) )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3718:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3719:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getThisExpressionAccess().getThisExpressionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleThisExpression7924); 

                	newLeafNode(otherlv_1, grammarAccess.getThisExpressionAccess().getThisKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3728:1: ( (lv_suffix_2_0= ruleSuffixExpression ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==49||LA63_0==52) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3729:1: (lv_suffix_2_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3729:1: (lv_suffix_2_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3730:3: lv_suffix_2_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getThisExpressionAccess().getSuffixSuffixExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleThisExpression7945);
                    lv_suffix_2_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getThisExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_2_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisExpression"


    // $ANTLR start "entryRuleSuperInvocationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3754:1: entryRuleSuperInvocationExpression returns [EObject current=null] : iv_ruleSuperInvocationExpression= ruleSuperInvocationExpression EOF ;
    public final EObject entryRuleSuperInvocationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperInvocationExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3755:2: (iv_ruleSuperInvocationExpression= ruleSuperInvocationExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3756:2: iv_ruleSuperInvocationExpression= ruleSuperInvocationExpression EOF
            {
             newCompositeNode(grammarAccess.getSuperInvocationExpressionRule()); 
            pushFollow(FOLLOW_ruleSuperInvocationExpression_in_entryRuleSuperInvocationExpression7982);
            iv_ruleSuperInvocationExpression=ruleSuperInvocationExpression();

            state._fsp--;

             current =iv_ruleSuperInvocationExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperInvocationExpression7992); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuperInvocationExpression"


    // $ANTLR start "ruleSuperInvocationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3763:1: ruleSuperInvocationExpression returns [EObject current=null] : (otherlv_0= 'super' ( (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) ) | ( (lv_operationCall_5_0= ruleOperationCallExpression ) ) ) ) ;
    public final EObject ruleSuperInvocationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_className_2_0=null;
        Token otherlv_3=null;
        EObject lv_operationCallWithoutDot_4_0 = null;

        EObject lv_operationCall_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3766:28: ( (otherlv_0= 'super' ( (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) ) | ( (lv_operationCall_5_0= ruleOperationCallExpression ) ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3767:1: (otherlv_0= 'super' ( (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) ) | ( (lv_operationCall_5_0= ruleOperationCallExpression ) ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3767:1: (otherlv_0= 'super' ( (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) ) | ( (lv_operationCall_5_0= ruleOperationCallExpression ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3767:3: otherlv_0= 'super' ( (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) ) | ( (lv_operationCall_5_0= ruleOperationCallExpression ) ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleSuperInvocationExpression8029); 

                	newLeafNode(otherlv_0, grammarAccess.getSuperInvocationExpressionAccess().getSuperKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3771:1: ( (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) ) | ( (lv_operationCall_5_0= ruleOperationCallExpression ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==49) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RULE_ID) ) {
                    int LA64_2 = input.LA(3);

                    if ( (LA64_2==24) ) {
                        alt64=2;
                    }
                    else if ( (LA64_2==19) ) {
                        alt64=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3771:2: (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3771:2: (otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3771:4: otherlv_1= '.' ( (lv_className_2_0= RULE_ID ) ) otherlv_3= '::' ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) )
                    {
                    otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleSuperInvocationExpression8043); 

                        	newLeafNode(otherlv_1, grammarAccess.getSuperInvocationExpressionAccess().getFullStopKeyword_1_0_0());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3775:1: ( (lv_className_2_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3776:1: (lv_className_2_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3776:1: (lv_className_2_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3777:3: lv_className_2_0= RULE_ID
                    {
                    lv_className_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSuperInvocationExpression8060); 

                    			newLeafNode(lv_className_2_0, grammarAccess.getSuperInvocationExpressionAccess().getClassNameIDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuperInvocationExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"className",
                            		lv_className_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleSuperInvocationExpression8077); 

                        	newLeafNode(otherlv_3, grammarAccess.getSuperInvocationExpressionAccess().getColonColonKeyword_1_0_2());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3797:1: ( (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3798:1: (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3798:1: (lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3799:3: lv_operationCallWithoutDot_4_0= ruleOperationCallExpressionWithoutDot
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuperInvocationExpressionAccess().getOperationCallWithoutDotOperationCallExpressionWithoutDotParserRuleCall_1_0_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOperationCallExpressionWithoutDot_in_ruleSuperInvocationExpression8098);
                    lv_operationCallWithoutDot_4_0=ruleOperationCallExpressionWithoutDot();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSuperInvocationExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operationCallWithoutDot",
                            		lv_operationCallWithoutDot_4_0, 
                            		"OperationCallExpressionWithoutDot");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3816:6: ( (lv_operationCall_5_0= ruleOperationCallExpression ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3816:6: ( (lv_operationCall_5_0= ruleOperationCallExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3817:1: (lv_operationCall_5_0= ruleOperationCallExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3817:1: (lv_operationCall_5_0= ruleOperationCallExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3818:3: lv_operationCall_5_0= ruleOperationCallExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuperInvocationExpressionAccess().getOperationCallOperationCallExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleOperationCallExpression_in_ruleSuperInvocationExpression8126);
                    lv_operationCall_5_0=ruleOperationCallExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSuperInvocationExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operationCall",
                            		lv_operationCall_5_0, 
                            		"OperationCallExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuperInvocationExpression"


    // $ANTLR start "entryRuleInstanceCreationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3842:1: entryRuleInstanceCreationExpression returns [EObject current=null] : iv_ruleInstanceCreationExpression= ruleInstanceCreationExpression EOF ;
    public final EObject entryRuleInstanceCreationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceCreationExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3843:2: (iv_ruleInstanceCreationExpression= ruleInstanceCreationExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3844:2: iv_ruleInstanceCreationExpression= ruleInstanceCreationExpression EOF
            {
             newCompositeNode(grammarAccess.getInstanceCreationExpressionRule()); 
            pushFollow(FOLLOW_ruleInstanceCreationExpression_in_entryRuleInstanceCreationExpression8163);
            iv_ruleInstanceCreationExpression=ruleInstanceCreationExpression();

            state._fsp--;

             current =iv_ruleInstanceCreationExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceCreationExpression8173); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceCreationExpression"


    // $ANTLR start "ruleInstanceCreationExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3851:1: ruleInstanceCreationExpression returns [EObject current=null] : (otherlv_0= 'new' ( (lv_constructor_1_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_tuple_2_0= ruleTuple ) ) | ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? ) ;
    public final EObject ruleInstanceCreationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_constructor_1_0 = null;

        EObject lv_tuple_2_0 = null;

        EObject lv_sequenceConstuctionCompletion_3_0 = null;

        EObject lv_suffix_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3854:28: ( (otherlv_0= 'new' ( (lv_constructor_1_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_tuple_2_0= ruleTuple ) ) | ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3855:1: (otherlv_0= 'new' ( (lv_constructor_1_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_tuple_2_0= ruleTuple ) ) | ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3855:1: (otherlv_0= 'new' ( (lv_constructor_1_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_tuple_2_0= ruleTuple ) ) | ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3855:3: otherlv_0= 'new' ( (lv_constructor_1_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_tuple_2_0= ruleTuple ) ) | ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) ) ) ( (lv_suffix_4_0= ruleSuffixExpression ) )?
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleInstanceCreationExpression8210); 

                	newLeafNode(otherlv_0, grammarAccess.getInstanceCreationExpressionAccess().getNewKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3859:1: ( (lv_constructor_1_0= ruleQualifiedNameWithBinding ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3860:1: (lv_constructor_1_0= ruleQualifiedNameWithBinding )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3860:1: (lv_constructor_1_0= ruleQualifiedNameWithBinding )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3861:3: lv_constructor_1_0= ruleQualifiedNameWithBinding
            {
             
            	        newCompositeNode(grammarAccess.getInstanceCreationExpressionAccess().getConstructorQualifiedNameWithBindingParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleInstanceCreationExpression8231);
            lv_constructor_1_0=ruleQualifiedNameWithBinding();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceCreationExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"constructor",
                    		lv_constructor_1_0, 
                    		"QualifiedNameWithBinding");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3877:2: ( ( (lv_tuple_2_0= ruleTuple ) ) | ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==24) ) {
                alt65=1;
            }
            else if ( (LA65_0==50||LA65_0==60) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3877:3: ( (lv_tuple_2_0= ruleTuple ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3877:3: ( (lv_tuple_2_0= ruleTuple ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3878:1: (lv_tuple_2_0= ruleTuple )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3878:1: (lv_tuple_2_0= ruleTuple )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3879:3: lv_tuple_2_0= ruleTuple
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstanceCreationExpressionAccess().getTupleTupleParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTuple_in_ruleInstanceCreationExpression8253);
                    lv_tuple_2_0=ruleTuple();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstanceCreationExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"tuple",
                            		lv_tuple_2_0, 
                            		"Tuple");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3896:6: ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3896:6: ( (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3897:1: (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3897:1: (lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3898:3: lv_sequenceConstuctionCompletion_3_0= ruleSequenceConstructionCompletion
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstanceCreationExpressionAccess().getSequenceConstuctionCompletionSequenceConstructionCompletionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSequenceConstructionCompletion_in_ruleInstanceCreationExpression8280);
                    lv_sequenceConstuctionCompletion_3_0=ruleSequenceConstructionCompletion();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstanceCreationExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"sequenceConstuctionCompletion",
                            		lv_sequenceConstuctionCompletion_3_0, 
                            		"SequenceConstructionCompletion");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3914:3: ( (lv_suffix_4_0= ruleSuffixExpression ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==49||LA66_0==52) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3915:1: (lv_suffix_4_0= ruleSuffixExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3915:1: (lv_suffix_4_0= ruleSuffixExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3916:3: lv_suffix_4_0= ruleSuffixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getInstanceCreationExpressionAccess().getSuffixSuffixExpressionParserRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSuffixExpression_in_ruleInstanceCreationExpression8302);
                    lv_suffix_4_0=ruleSuffixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInstanceCreationExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"suffix",
                            		lv_suffix_4_0, 
                            		"SuffixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceCreationExpression"


    // $ANTLR start "entryRuleSequenceConstructionOrAccessCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3940:1: entryRuleSequenceConstructionOrAccessCompletion returns [EObject current=null] : iv_ruleSequenceConstructionOrAccessCompletion= ruleSequenceConstructionOrAccessCompletion EOF ;
    public final EObject entryRuleSequenceConstructionOrAccessCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceConstructionOrAccessCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3941:2: (iv_ruleSequenceConstructionOrAccessCompletion= ruleSequenceConstructionOrAccessCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3942:2: iv_ruleSequenceConstructionOrAccessCompletion= ruleSequenceConstructionOrAccessCompletion EOF
            {
             newCompositeNode(grammarAccess.getSequenceConstructionOrAccessCompletionRule()); 
            pushFollow(FOLLOW_ruleSequenceConstructionOrAccessCompletion_in_entryRuleSequenceConstructionOrAccessCompletion8339);
            iv_ruleSequenceConstructionOrAccessCompletion=ruleSequenceConstructionOrAccessCompletion();

            state._fsp--;

             current =iv_ruleSequenceConstructionOrAccessCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceConstructionOrAccessCompletion8349); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceConstructionOrAccessCompletion"


    // $ANTLR start "ruleSequenceConstructionOrAccessCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3949:1: ruleSequenceConstructionOrAccessCompletion returns [EObject current=null] : ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) ) ) | ( (lv_expression_3_0= ruleSequenceConstructionExpression ) ) ) ;
    public final EObject ruleSequenceConstructionOrAccessCompletion() throws RecognitionException {
        EObject current = null;

        Token lv_multiplicityIndicator_0_0=null;
        EObject lv_accessCompletion_1_0 = null;

        EObject lv_sequenceCompletion_2_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3952:28: ( ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) ) ) | ( (lv_expression_3_0= ruleSequenceConstructionExpression ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3953:1: ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) ) ) | ( (lv_expression_3_0= ruleSequenceConstructionExpression ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3953:1: ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) ) ) | ( (lv_expression_3_0= ruleSequenceConstructionExpression ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==50) ) {
                alt68=1;
            }
            else if ( (LA68_0==60) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3953:2: ( ( (lv_multiplicityIndicator_0_0= '[' ) ) ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3953:2: ( ( (lv_multiplicityIndicator_0_0= '[' ) ) ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3953:3: ( (lv_multiplicityIndicator_0_0= '[' ) ) ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3953:3: ( (lv_multiplicityIndicator_0_0= '[' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3954:1: (lv_multiplicityIndicator_0_0= '[' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3954:1: (lv_multiplicityIndicator_0_0= '[' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3955:3: lv_multiplicityIndicator_0_0= '['
                    {
                    lv_multiplicityIndicator_0_0=(Token)match(input,50,FOLLOW_50_in_ruleSequenceConstructionOrAccessCompletion8393); 

                            newLeafNode(lv_multiplicityIndicator_0_0, grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSequenceConstructionOrAccessCompletionRule());
                    	        }
                           		setWithLastConsumed(current, "multiplicityIndicator", true, "[");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3968:2: ( ( (lv_accessCompletion_1_0= ruleAccessCompletion ) ) | ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) ) )
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( ((LA67_0>=RULE_INTEGERVALUE && LA67_0<=RULE_ID)||(LA67_0>=16 && LA67_0<=18)||LA67_0==24||(LA67_0>=42 && LA67_0<=43)||(LA67_0>=46 && LA67_0<=48)||(LA67_0>=56 && LA67_0<=59)||(LA67_0>=87 && LA67_0<=88)) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==51) ) {
                        alt67=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 67, 0, input);

                        throw nvae;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3968:3: ( (lv_accessCompletion_1_0= ruleAccessCompletion ) )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3968:3: ( (lv_accessCompletion_1_0= ruleAccessCompletion ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3969:1: (lv_accessCompletion_1_0= ruleAccessCompletion )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3969:1: (lv_accessCompletion_1_0= ruleAccessCompletion )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3970:3: lv_accessCompletion_1_0= ruleAccessCompletion
                            {
                             
                            	        newCompositeNode(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getAccessCompletionAccessCompletionParserRuleCall_0_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAccessCompletion_in_ruleSequenceConstructionOrAccessCompletion8428);
                            lv_accessCompletion_1_0=ruleAccessCompletion();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSequenceConstructionOrAccessCompletionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"accessCompletion",
                                    		lv_accessCompletion_1_0, 
                                    		"AccessCompletion");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3987:6: ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3987:6: ( (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3988:1: (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3988:1: (lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:3989:3: lv_sequenceCompletion_2_0= rulePartialSequenceConstructionCompletion
                            {
                             
                            	        newCompositeNode(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getSequenceCompletionPartialSequenceConstructionCompletionParserRuleCall_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_rulePartialSequenceConstructionCompletion_in_ruleSequenceConstructionOrAccessCompletion8455);
                            lv_sequenceCompletion_2_0=rulePartialSequenceConstructionCompletion();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getSequenceConstructionOrAccessCompletionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"sequenceCompletion",
                                    		lv_sequenceCompletion_2_0, 
                                    		"PartialSequenceConstructionCompletion");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4006:6: ( (lv_expression_3_0= ruleSequenceConstructionExpression ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4006:6: ( (lv_expression_3_0= ruleSequenceConstructionExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4007:1: (lv_expression_3_0= ruleSequenceConstructionExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4007:1: (lv_expression_3_0= ruleSequenceConstructionExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4008:3: lv_expression_3_0= ruleSequenceConstructionExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSequenceConstructionOrAccessCompletionAccess().getExpressionSequenceConstructionExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSequenceConstructionExpression_in_ruleSequenceConstructionOrAccessCompletion8484);
                    lv_expression_3_0=ruleSequenceConstructionExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSequenceConstructionOrAccessCompletionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_3_0, 
                            		"SequenceConstructionExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceConstructionOrAccessCompletion"


    // $ANTLR start "entryRuleAccessCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4032:1: entryRuleAccessCompletion returns [EObject current=null] : iv_ruleAccessCompletion= ruleAccessCompletion EOF ;
    public final EObject entryRuleAccessCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAccessCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4033:2: (iv_ruleAccessCompletion= ruleAccessCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4034:2: iv_ruleAccessCompletion= ruleAccessCompletion EOF
            {
             newCompositeNode(grammarAccess.getAccessCompletionRule()); 
            pushFollow(FOLLOW_ruleAccessCompletion_in_entryRuleAccessCompletion8520);
            iv_ruleAccessCompletion=ruleAccessCompletion();

            state._fsp--;

             current =iv_ruleAccessCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAccessCompletion8530); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAccessCompletion"


    // $ANTLR start "ruleAccessCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4041:1: ruleAccessCompletion returns [EObject current=null] : ( ( (lv_accessIndex_0_0= ruleExpression ) ) otherlv_1= ']' ) ;
    public final EObject ruleAccessCompletion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_accessIndex_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4044:28: ( ( ( (lv_accessIndex_0_0= ruleExpression ) ) otherlv_1= ']' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4045:1: ( ( (lv_accessIndex_0_0= ruleExpression ) ) otherlv_1= ']' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4045:1: ( ( (lv_accessIndex_0_0= ruleExpression ) ) otherlv_1= ']' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4045:2: ( (lv_accessIndex_0_0= ruleExpression ) ) otherlv_1= ']'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4045:2: ( (lv_accessIndex_0_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4046:1: (lv_accessIndex_0_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4046:1: (lv_accessIndex_0_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4047:3: lv_accessIndex_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAccessCompletionAccess().getAccessIndexExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAccessCompletion8576);
            lv_accessIndex_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAccessCompletionRule());
            	        }
                   		set(
                   			current, 
                   			"accessIndex",
                    		lv_accessIndex_0_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleAccessCompletion8588); 

                	newLeafNode(otherlv_1, grammarAccess.getAccessCompletionAccess().getRightSquareBracketKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAccessCompletion"


    // $ANTLR start "entryRulePartialSequenceConstructionCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4075:1: entryRulePartialSequenceConstructionCompletion returns [EObject current=null] : iv_rulePartialSequenceConstructionCompletion= rulePartialSequenceConstructionCompletion EOF ;
    public final EObject entryRulePartialSequenceConstructionCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePartialSequenceConstructionCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4076:2: (iv_rulePartialSequenceConstructionCompletion= rulePartialSequenceConstructionCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4077:2: iv_rulePartialSequenceConstructionCompletion= rulePartialSequenceConstructionCompletion EOF
            {
             newCompositeNode(grammarAccess.getPartialSequenceConstructionCompletionRule()); 
            pushFollow(FOLLOW_rulePartialSequenceConstructionCompletion_in_entryRulePartialSequenceConstructionCompletion8624);
            iv_rulePartialSequenceConstructionCompletion=rulePartialSequenceConstructionCompletion();

            state._fsp--;

             current =iv_rulePartialSequenceConstructionCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePartialSequenceConstructionCompletion8634); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePartialSequenceConstructionCompletion"


    // $ANTLR start "rulePartialSequenceConstructionCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4084:1: rulePartialSequenceConstructionCompletion returns [EObject current=null] : (otherlv_0= ']' ( (lv_expression_1_0= ruleSequenceConstructionExpression ) ) ) ;
    public final EObject rulePartialSequenceConstructionCompletion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4087:28: ( (otherlv_0= ']' ( (lv_expression_1_0= ruleSequenceConstructionExpression ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4088:1: (otherlv_0= ']' ( (lv_expression_1_0= ruleSequenceConstructionExpression ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4088:1: (otherlv_0= ']' ( (lv_expression_1_0= ruleSequenceConstructionExpression ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4088:3: otherlv_0= ']' ( (lv_expression_1_0= ruleSequenceConstructionExpression ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_rulePartialSequenceConstructionCompletion8671); 

                	newLeafNode(otherlv_0, grammarAccess.getPartialSequenceConstructionCompletionAccess().getRightSquareBracketKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4092:1: ( (lv_expression_1_0= ruleSequenceConstructionExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4093:1: (lv_expression_1_0= ruleSequenceConstructionExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4093:1: (lv_expression_1_0= ruleSequenceConstructionExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4094:3: lv_expression_1_0= ruleSequenceConstructionExpression
            {
             
            	        newCompositeNode(grammarAccess.getPartialSequenceConstructionCompletionAccess().getExpressionSequenceConstructionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSequenceConstructionExpression_in_rulePartialSequenceConstructionCompletion8692);
            lv_expression_1_0=ruleSequenceConstructionExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPartialSequenceConstructionCompletionRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"SequenceConstructionExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePartialSequenceConstructionCompletion"


    // $ANTLR start "entryRuleSequenceConstructionCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4118:1: entryRuleSequenceConstructionCompletion returns [EObject current=null] : iv_ruleSequenceConstructionCompletion= ruleSequenceConstructionCompletion EOF ;
    public final EObject entryRuleSequenceConstructionCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceConstructionCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4119:2: (iv_ruleSequenceConstructionCompletion= ruleSequenceConstructionCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4120:2: iv_ruleSequenceConstructionCompletion= ruleSequenceConstructionCompletion EOF
            {
             newCompositeNode(grammarAccess.getSequenceConstructionCompletionRule()); 
            pushFollow(FOLLOW_ruleSequenceConstructionCompletion_in_entryRuleSequenceConstructionCompletion8728);
            iv_ruleSequenceConstructionCompletion=ruleSequenceConstructionCompletion();

            state._fsp--;

             current =iv_ruleSequenceConstructionCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceConstructionCompletion8738); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceConstructionCompletion"


    // $ANTLR start "ruleSequenceConstructionCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4127:1: ruleSequenceConstructionCompletion returns [EObject current=null] : ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_expression_2_0= ruleSequenceConstructionExpression ) ) ) ;
    public final EObject ruleSequenceConstructionCompletion() throws RecognitionException {
        EObject current = null;

        Token lv_multiplicityIndicator_0_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4130:28: ( ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_expression_2_0= ruleSequenceConstructionExpression ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4131:1: ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_expression_2_0= ruleSequenceConstructionExpression ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4131:1: ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_expression_2_0= ruleSequenceConstructionExpression ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4131:2: ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_expression_2_0= ruleSequenceConstructionExpression ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4131:2: ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==50) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4131:3: ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']'
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4131:3: ( (lv_multiplicityIndicator_0_0= '[' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4132:1: (lv_multiplicityIndicator_0_0= '[' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4132:1: (lv_multiplicityIndicator_0_0= '[' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4133:3: lv_multiplicityIndicator_0_0= '['
                    {
                    lv_multiplicityIndicator_0_0=(Token)match(input,50,FOLLOW_50_in_ruleSequenceConstructionCompletion8782); 

                            newLeafNode(lv_multiplicityIndicator_0_0, grammarAccess.getSequenceConstructionCompletionAccess().getMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSequenceConstructionCompletionRule());
                    	        }
                           		setWithLastConsumed(current, "multiplicityIndicator", true, "[");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleSequenceConstructionCompletion8807); 

                        	newLeafNode(otherlv_1, grammarAccess.getSequenceConstructionCompletionAccess().getRightSquareBracketKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4150:3: ( (lv_expression_2_0= ruleSequenceConstructionExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4151:1: (lv_expression_2_0= ruleSequenceConstructionExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4151:1: (lv_expression_2_0= ruleSequenceConstructionExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4152:3: lv_expression_2_0= ruleSequenceConstructionExpression
            {
             
            	        newCompositeNode(grammarAccess.getSequenceConstructionCompletionAccess().getExpressionSequenceConstructionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSequenceConstructionExpression_in_ruleSequenceConstructionCompletion8830);
            lv_expression_2_0=ruleSequenceConstructionExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSequenceConstructionCompletionRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_2_0, 
                    		"SequenceConstructionExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceConstructionCompletion"


    // $ANTLR start "entryRuleSequenceConstructionExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4176:1: entryRuleSequenceConstructionExpression returns [EObject current=null] : iv_ruleSequenceConstructionExpression= ruleSequenceConstructionExpression EOF ;
    public final EObject entryRuleSequenceConstructionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceConstructionExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4177:2: (iv_ruleSequenceConstructionExpression= ruleSequenceConstructionExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4178:2: iv_ruleSequenceConstructionExpression= ruleSequenceConstructionExpression EOF
            {
             newCompositeNode(grammarAccess.getSequenceConstructionExpressionRule()); 
            pushFollow(FOLLOW_ruleSequenceConstructionExpression_in_entryRuleSequenceConstructionExpression8866);
            iv_ruleSequenceConstructionExpression=ruleSequenceConstructionExpression();

            state._fsp--;

             current =iv_ruleSequenceConstructionExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceConstructionExpression8876); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceConstructionExpression"


    // $ANTLR start "ruleSequenceConstructionExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4185:1: ruleSequenceConstructionExpression returns [EObject current=null] : (otherlv_0= '{' ( (lv_sequenceElement_1_0= ruleSequenceElement ) ) ( (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )* | (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) ) ) otherlv_6= '}' ) ;
    public final EObject ruleSequenceConstructionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_sequenceElement_1_0 = null;

        EObject lv_sequenceElement_3_0 = null;

        EObject lv_rangeUpper_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4188:28: ( (otherlv_0= '{' ( (lv_sequenceElement_1_0= ruleSequenceElement ) ) ( (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )* | (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) ) ) otherlv_6= '}' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4189:1: (otherlv_0= '{' ( (lv_sequenceElement_1_0= ruleSequenceElement ) ) ( (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )* | (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) ) ) otherlv_6= '}' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4189:1: (otherlv_0= '{' ( (lv_sequenceElement_1_0= ruleSequenceElement ) ) ( (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )* | (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) ) ) otherlv_6= '}' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4189:3: otherlv_0= '{' ( (lv_sequenceElement_1_0= ruleSequenceElement ) ) ( (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )* | (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleSequenceConstructionExpression8913); 

                	newLeafNode(otherlv_0, grammarAccess.getSequenceConstructionExpressionAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4193:1: ( (lv_sequenceElement_1_0= ruleSequenceElement ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4194:1: (lv_sequenceElement_1_0= ruleSequenceElement )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4194:1: (lv_sequenceElement_1_0= ruleSequenceElement )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4195:3: lv_sequenceElement_1_0= ruleSequenceElement
            {
             
            	        newCompositeNode(grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementSequenceElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSequenceElement_in_ruleSequenceConstructionExpression8934);
            lv_sequenceElement_1_0=ruleSequenceElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSequenceConstructionExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"sequenceElement",
                    		lv_sequenceElement_1_0, 
                    		"SequenceElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4211:2: ( (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )* | (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==21||LA71_0==62) ) {
                alt71=1;
            }
            else if ( (LA71_0==61) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4211:3: (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )*
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4211:3: (otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==21) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4211:5: otherlv_2= ',' ( (lv_sequenceElement_3_0= ruleSequenceElement ) )
                    	    {
                    	    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleSequenceConstructionExpression8948); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getSequenceConstructionExpressionAccess().getCommaKeyword_2_0_0());
                    	        
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4215:1: ( (lv_sequenceElement_3_0= ruleSequenceElement ) )
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4216:1: (lv_sequenceElement_3_0= ruleSequenceElement )
                    	    {
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4216:1: (lv_sequenceElement_3_0= ruleSequenceElement )
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4217:3: lv_sequenceElement_3_0= ruleSequenceElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSequenceConstructionExpressionAccess().getSequenceElementSequenceElementParserRuleCall_2_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSequenceElement_in_ruleSequenceConstructionExpression8969);
                    	    lv_sequenceElement_3_0=ruleSequenceElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSequenceConstructionExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"sequenceElement",
                    	            		lv_sequenceElement_3_0, 
                    	            		"SequenceElement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4234:6: (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4234:6: (otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4234:8: otherlv_4= '..' ( (lv_rangeUpper_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,61,FOLLOW_61_in_ruleSequenceConstructionExpression8990); 

                        	newLeafNode(otherlv_4, grammarAccess.getSequenceConstructionExpressionAccess().getFullStopFullStopKeyword_2_1_0());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4238:1: ( (lv_rangeUpper_5_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4239:1: (lv_rangeUpper_5_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4239:1: (lv_rangeUpper_5_0= ruleExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4240:3: lv_rangeUpper_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSequenceConstructionExpressionAccess().getRangeUpperExpressionParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleSequenceConstructionExpression9011);
                    lv_rangeUpper_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSequenceConstructionExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"rangeUpper",
                            		lv_rangeUpper_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,62,FOLLOW_62_in_ruleSequenceConstructionExpression9025); 

                	newLeafNode(otherlv_6, grammarAccess.getSequenceConstructionExpressionAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceConstructionExpression"


    // $ANTLR start "entryRuleSequenceElement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4268:1: entryRuleSequenceElement returns [EObject current=null] : iv_ruleSequenceElement= ruleSequenceElement EOF ;
    public final EObject entryRuleSequenceElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceElement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4269:2: (iv_ruleSequenceElement= ruleSequenceElement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4270:2: iv_ruleSequenceElement= ruleSequenceElement EOF
            {
             newCompositeNode(grammarAccess.getSequenceElementRule()); 
            pushFollow(FOLLOW_ruleSequenceElement_in_entryRuleSequenceElement9061);
            iv_ruleSequenceElement=ruleSequenceElement();

            state._fsp--;

             current =iv_ruleSequenceElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequenceElement9071); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceElement"


    // $ANTLR start "ruleSequenceElement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4277:1: ruleSequenceElement returns [EObject current=null] : (this_Expression_0= ruleExpression | this_SequenceConstructionExpression_1= ruleSequenceConstructionExpression ) ;
    public final EObject ruleSequenceElement() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_0 = null;

        EObject this_SequenceConstructionExpression_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4280:28: ( (this_Expression_0= ruleExpression | this_SequenceConstructionExpression_1= ruleSequenceConstructionExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4281:1: (this_Expression_0= ruleExpression | this_SequenceConstructionExpression_1= ruleSequenceConstructionExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4281:1: (this_Expression_0= ruleExpression | this_SequenceConstructionExpression_1= ruleSequenceConstructionExpression )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( ((LA72_0>=RULE_INTEGERVALUE && LA72_0<=RULE_ID)||(LA72_0>=16 && LA72_0<=18)||LA72_0==24||(LA72_0>=42 && LA72_0<=43)||(LA72_0>=46 && LA72_0<=48)||(LA72_0>=56 && LA72_0<=59)||(LA72_0>=87 && LA72_0<=88)) ) {
                alt72=1;
            }
            else if ( (LA72_0==60) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4282:5: this_Expression_0= ruleExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSequenceElementAccess().getExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_ruleSequenceElement9118);
                    this_Expression_0=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4292:5: this_SequenceConstructionExpression_1= ruleSequenceConstructionExpression
                    {
                     
                            newCompositeNode(grammarAccess.getSequenceElementAccess().getSequenceConstructionExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSequenceConstructionExpression_in_ruleSequenceElement9145);
                    this_SequenceConstructionExpression_1=ruleSequenceConstructionExpression();

                    state._fsp--;

                     
                            current = this_SequenceConstructionExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceElement"


    // $ANTLR start "entryRuleClassExtentExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4308:1: entryRuleClassExtentExpression returns [EObject current=null] : iv_ruleClassExtentExpression= ruleClassExtentExpression EOF ;
    public final EObject entryRuleClassExtentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassExtentExpression = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4309:2: (iv_ruleClassExtentExpression= ruleClassExtentExpression EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4310:2: iv_ruleClassExtentExpression= ruleClassExtentExpression EOF
            {
             newCompositeNode(grammarAccess.getClassExtentExpressionRule()); 
            pushFollow(FOLLOW_ruleClassExtentExpression_in_entryRuleClassExtentExpression9180);
            iv_ruleClassExtentExpression=ruleClassExtentExpression();

            state._fsp--;

             current =iv_ruleClassExtentExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassExtentExpression9190); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassExtentExpression"


    // $ANTLR start "ruleClassExtentExpression"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4317:1: ruleClassExtentExpression returns [EObject current=null] : ( () otherlv_1= '.' otherlv_2= 'allInstances' otherlv_3= '(' otherlv_4= ')' ) ;
    public final EObject ruleClassExtentExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4320:28: ( ( () otherlv_1= '.' otherlv_2= 'allInstances' otherlv_3= '(' otherlv_4= ')' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4321:1: ( () otherlv_1= '.' otherlv_2= 'allInstances' otherlv_3= '(' otherlv_4= ')' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4321:1: ( () otherlv_1= '.' otherlv_2= 'allInstances' otherlv_3= '(' otherlv_4= ')' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4321:2: () otherlv_1= '.' otherlv_2= 'allInstances' otherlv_3= '(' otherlv_4= ')'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4321:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4322:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getClassExtentExpressionAccess().getClassExtentExpressionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleClassExtentExpression9236); 

                	newLeafNode(otherlv_1, grammarAccess.getClassExtentExpressionAccess().getFullStopKeyword_1());
                
            otherlv_2=(Token)match(input,63,FOLLOW_63_in_ruleClassExtentExpression9248); 

                	newLeafNode(otherlv_2, grammarAccess.getClassExtentExpressionAccess().getAllInstancesKeyword_2());
                
            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleClassExtentExpression9260); 

                	newLeafNode(otherlv_3, grammarAccess.getClassExtentExpressionAccess().getLeftParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleClassExtentExpression9272); 

                	newLeafNode(otherlv_4, grammarAccess.getClassExtentExpressionAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassExtentExpression"


    // $ANTLR start "entryRuleBlock"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4351:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4352:2: (iv_ruleBlock= ruleBlock EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4353:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock9308);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock9318); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4360:1: ruleBlock returns [EObject current=null] : (otherlv_0= '{' () ( (lv_sequence_2_0= ruleStatementSequence ) )? otherlv_3= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_sequence_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4363:28: ( (otherlv_0= '{' () ( (lv_sequence_2_0= ruleStatementSequence ) )? otherlv_3= '}' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4364:1: (otherlv_0= '{' () ( (lv_sequence_2_0= ruleStatementSequence ) )? otherlv_3= '}' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4364:1: (otherlv_0= '{' () ( (lv_sequence_2_0= ruleStatementSequence ) )? otherlv_3= '}' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4364:3: otherlv_0= '{' () ( (lv_sequence_2_0= ruleStatementSequence ) )? otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleBlock9355); 

                	newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4368:1: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4369:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlockAccess().getBlockAction_1(),
                        current);
                

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4374:2: ( (lv_sequence_2_0= ruleStatementSequence ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_ID && LA73_0<=RULE_SL_COMMENT)||(LA73_0>=17 && LA73_0<=18)||(LA73_0>=57 && LA73_0<=60)||LA73_0==64||(LA73_0>=67 && LA73_0<=69)||LA73_0==71||LA73_0==74||(LA73_0>=77 && LA73_0<=79)||(LA73_0>=81 && LA73_0<=84)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4375:1: (lv_sequence_2_0= ruleStatementSequence )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4375:1: (lv_sequence_2_0= ruleStatementSequence )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4376:3: lv_sequence_2_0= ruleStatementSequence
                    {
                     
                    	        newCompositeNode(grammarAccess.getBlockAccess().getSequenceStatementSequenceParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStatementSequence_in_ruleBlock9385);
                    lv_sequence_2_0=ruleStatementSequence();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBlockRule());
                    	        }
                           		set(
                           			current, 
                           			"sequence",
                            		lv_sequence_2_0, 
                            		"StatementSequence");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,62,FOLLOW_62_in_ruleBlock9398); 

                	newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatementSequence"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4404:1: entryRuleStatementSequence returns [EObject current=null] : iv_ruleStatementSequence= ruleStatementSequence EOF ;
    public final EObject entryRuleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementSequence = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4405:2: (iv_ruleStatementSequence= ruleStatementSequence EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4406:2: iv_ruleStatementSequence= ruleStatementSequence EOF
            {
             newCompositeNode(grammarAccess.getStatementSequenceRule()); 
            pushFollow(FOLLOW_ruleStatementSequence_in_entryRuleStatementSequence9434);
            iv_ruleStatementSequence=ruleStatementSequence();

            state._fsp--;

             current =iv_ruleStatementSequence; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatementSequence9444); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementSequence"


    // $ANTLR start "ruleStatementSequence"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4413:1: ruleStatementSequence returns [EObject current=null] : ( (lv_statements_0_0= ruleDocumentedStatement ) )+ ;
    public final EObject ruleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4416:28: ( ( (lv_statements_0_0= ruleDocumentedStatement ) )+ )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4417:1: ( (lv_statements_0_0= ruleDocumentedStatement ) )+
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4417:1: ( (lv_statements_0_0= ruleDocumentedStatement ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_SL_COMMENT)||(LA74_0>=17 && LA74_0<=18)||(LA74_0>=57 && LA74_0<=60)||LA74_0==64||(LA74_0>=67 && LA74_0<=69)||LA74_0==71||LA74_0==74||(LA74_0>=77 && LA74_0<=79)||(LA74_0>=81 && LA74_0<=84)) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4418:1: (lv_statements_0_0= ruleDocumentedStatement )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4418:1: (lv_statements_0_0= ruleDocumentedStatement )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4419:3: lv_statements_0_0= ruleDocumentedStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementSequenceAccess().getStatementsDocumentedStatementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDocumentedStatement_in_ruleStatementSequence9489);
            	    lv_statements_0_0=ruleDocumentedStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementSequenceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_0_0, 
            	            		"DocumentedStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementSequence"


    // $ANTLR start "entryRuleDocumentedStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4443:1: entryRuleDocumentedStatement returns [EObject current=null] : iv_ruleDocumentedStatement= ruleDocumentedStatement EOF ;
    public final EObject entryRuleDocumentedStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentedStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4444:2: (iv_ruleDocumentedStatement= ruleDocumentedStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4445:2: iv_ruleDocumentedStatement= ruleDocumentedStatement EOF
            {
             newCompositeNode(grammarAccess.getDocumentedStatementRule()); 
            pushFollow(FOLLOW_ruleDocumentedStatement_in_entryRuleDocumentedStatement9525);
            iv_ruleDocumentedStatement=ruleDocumentedStatement();

            state._fsp--;

             current =iv_ruleDocumentedStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentedStatement9535); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocumentedStatement"


    // $ANTLR start "ruleDocumentedStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4452:1: ruleDocumentedStatement returns [EObject current=null] : ( ( ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) ) )? ( (lv_statement_1_0= ruleStatement ) ) ) ;
    public final EObject ruleDocumentedStatement() throws RecognitionException {
        EObject current = null;

        Token lv_comment_0_1=null;
        Token lv_comment_0_2=null;
        EObject lv_statement_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4455:28: ( ( ( ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) ) )? ( (lv_statement_1_0= ruleStatement ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4456:1: ( ( ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) ) )? ( (lv_statement_1_0= ruleStatement ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4456:1: ( ( ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) ) )? ( (lv_statement_1_0= ruleStatement ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4456:2: ( ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) ) )? ( (lv_statement_1_0= ruleStatement ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4456:2: ( ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_ML_COMMENT && LA76_0<=RULE_SL_COMMENT)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4457:1: ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4457:1: ( (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4458:1: (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4458:1: (lv_comment_0_1= RULE_ML_COMMENT | lv_comment_0_2= RULE_SL_COMMENT )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==RULE_ML_COMMENT) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==RULE_SL_COMMENT) ) {
                        alt75=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }
                    switch (alt75) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4459:3: lv_comment_0_1= RULE_ML_COMMENT
                            {
                            lv_comment_0_1=(Token)match(input,RULE_ML_COMMENT,FOLLOW_RULE_ML_COMMENT_in_ruleDocumentedStatement9579); 

                            			newLeafNode(lv_comment_0_1, grammarAccess.getDocumentedStatementAccess().getCommentML_COMMENTTerminalRuleCall_0_0_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDocumentedStatementRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"comment",
                                    		lv_comment_0_1, 
                                    		"ML_COMMENT");
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4474:8: lv_comment_0_2= RULE_SL_COMMENT
                            {
                            lv_comment_0_2=(Token)match(input,RULE_SL_COMMENT,FOLLOW_RULE_SL_COMMENT_in_ruleDocumentedStatement9599); 

                            			newLeafNode(lv_comment_0_2, grammarAccess.getDocumentedStatementAccess().getCommentSL_COMMENTTerminalRuleCall_0_0_1()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getDocumentedStatementRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"comment",
                                    		lv_comment_0_2, 
                                    		"SL_COMMENT");
                            	    

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4492:3: ( (lv_statement_1_0= ruleStatement ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4493:1: (lv_statement_1_0= ruleStatement )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4493:1: (lv_statement_1_0= ruleStatement )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4494:3: lv_statement_1_0= ruleStatement
            {
             
            	        newCompositeNode(grammarAccess.getDocumentedStatementAccess().getStatementStatementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleStatement_in_ruleDocumentedStatement9629);
            lv_statement_1_0=ruleStatement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDocumentedStatementRule());
            	        }
                   		set(
                   			current, 
                   			"statement",
                    		lv_statement_1_0, 
                    		"Statement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocumentedStatement"


    // $ANTLR start "entryRuleInlineStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4518:1: entryRuleInlineStatement returns [EObject current=null] : iv_ruleInlineStatement= ruleInlineStatement EOF ;
    public final EObject entryRuleInlineStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInlineStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4519:2: (iv_ruleInlineStatement= ruleInlineStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4520:2: iv_ruleInlineStatement= ruleInlineStatement EOF
            {
             newCompositeNode(grammarAccess.getInlineStatementRule()); 
            pushFollow(FOLLOW_ruleInlineStatement_in_entryRuleInlineStatement9665);
            iv_ruleInlineStatement=ruleInlineStatement();

            state._fsp--;

             current =iv_ruleInlineStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInlineStatement9675); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInlineStatement"


    // $ANTLR start "ruleInlineStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4527:1: ruleInlineStatement returns [EObject current=null] : (otherlv_0= '/*@' otherlv_1= 'inline' otherlv_2= '(' ( (lv_langageName_3_0= RULE_ID ) ) otherlv_4= ')' ( (lv_body_5_0= RULE_STRING ) ) otherlv_6= '*/' ) ;
    public final EObject ruleInlineStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_langageName_3_0=null;
        Token otherlv_4=null;
        Token lv_body_5_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4530:28: ( (otherlv_0= '/*@' otherlv_1= 'inline' otherlv_2= '(' ( (lv_langageName_3_0= RULE_ID ) ) otherlv_4= ')' ( (lv_body_5_0= RULE_STRING ) ) otherlv_6= '*/' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4531:1: (otherlv_0= '/*@' otherlv_1= 'inline' otherlv_2= '(' ( (lv_langageName_3_0= RULE_ID ) ) otherlv_4= ')' ( (lv_body_5_0= RULE_STRING ) ) otherlv_6= '*/' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4531:1: (otherlv_0= '/*@' otherlv_1= 'inline' otherlv_2= '(' ( (lv_langageName_3_0= RULE_ID ) ) otherlv_4= ')' ( (lv_body_5_0= RULE_STRING ) ) otherlv_6= '*/' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4531:3: otherlv_0= '/*@' otherlv_1= 'inline' otherlv_2= '(' ( (lv_langageName_3_0= RULE_ID ) ) otherlv_4= ')' ( (lv_body_5_0= RULE_STRING ) ) otherlv_6= '*/'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_64_in_ruleInlineStatement9712); 

                	newLeafNode(otherlv_0, grammarAccess.getInlineStatementAccess().getSolidusAsteriskCommercialAtKeyword_0());
                
            otherlv_1=(Token)match(input,65,FOLLOW_65_in_ruleInlineStatement9724); 

                	newLeafNode(otherlv_1, grammarAccess.getInlineStatementAccess().getInlineKeyword_1());
                
            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleInlineStatement9736); 

                	newLeafNode(otherlv_2, grammarAccess.getInlineStatementAccess().getLeftParenthesisKeyword_2());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4543:1: ( (lv_langageName_3_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4544:1: (lv_langageName_3_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4544:1: (lv_langageName_3_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4545:3: lv_langageName_3_0= RULE_ID
            {
            lv_langageName_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInlineStatement9753); 

            			newLeafNode(lv_langageName_3_0, grammarAccess.getInlineStatementAccess().getLangageNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInlineStatementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"langageName",
                    		lv_langageName_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleInlineStatement9770); 

                	newLeafNode(otherlv_4, grammarAccess.getInlineStatementAccess().getRightParenthesisKeyword_4());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4565:1: ( (lv_body_5_0= RULE_STRING ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4566:1: (lv_body_5_0= RULE_STRING )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4566:1: (lv_body_5_0= RULE_STRING )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4567:3: lv_body_5_0= RULE_STRING
            {
            lv_body_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInlineStatement9787); 

            			newLeafNode(lv_body_5_0, grammarAccess.getInlineStatementAccess().getBodySTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInlineStatementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"body",
                    		lv_body_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,66,FOLLOW_66_in_ruleInlineStatement9804); 

                	newLeafNode(otherlv_6, grammarAccess.getInlineStatementAccess().getAsteriskSolidusKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInlineStatement"


    // $ANTLR start "entryRuleAnnotatedStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4595:1: entryRuleAnnotatedStatement returns [EObject current=null] : iv_ruleAnnotatedStatement= ruleAnnotatedStatement EOF ;
    public final EObject entryRuleAnnotatedStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotatedStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4596:2: (iv_ruleAnnotatedStatement= ruleAnnotatedStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4597:2: iv_ruleAnnotatedStatement= ruleAnnotatedStatement EOF
            {
             newCompositeNode(grammarAccess.getAnnotatedStatementRule()); 
            pushFollow(FOLLOW_ruleAnnotatedStatement_in_entryRuleAnnotatedStatement9840);
            iv_ruleAnnotatedStatement=ruleAnnotatedStatement();

            state._fsp--;

             current =iv_ruleAnnotatedStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotatedStatement9850); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotatedStatement"


    // $ANTLR start "ruleAnnotatedStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4604:1: ruleAnnotatedStatement returns [EObject current=null] : (otherlv_0= '//@' ( (lv_annotation_1_0= ruleAnnotation ) ) ( (lv_statement_2_0= ruleStatement ) ) ) ;
    public final EObject ruleAnnotatedStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_annotation_1_0 = null;

        EObject lv_statement_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4607:28: ( (otherlv_0= '//@' ( (lv_annotation_1_0= ruleAnnotation ) ) ( (lv_statement_2_0= ruleStatement ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4608:1: (otherlv_0= '//@' ( (lv_annotation_1_0= ruleAnnotation ) ) ( (lv_statement_2_0= ruleStatement ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4608:1: (otherlv_0= '//@' ( (lv_annotation_1_0= ruleAnnotation ) ) ( (lv_statement_2_0= ruleStatement ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4608:3: otherlv_0= '//@' ( (lv_annotation_1_0= ruleAnnotation ) ) ( (lv_statement_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleAnnotatedStatement9887); 

                	newLeafNode(otherlv_0, grammarAccess.getAnnotatedStatementAccess().getSolidusSolidusCommercialAtKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4612:1: ( (lv_annotation_1_0= ruleAnnotation ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4613:1: (lv_annotation_1_0= ruleAnnotation )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4613:1: (lv_annotation_1_0= ruleAnnotation )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4614:3: lv_annotation_1_0= ruleAnnotation
            {
             
            	        newCompositeNode(grammarAccess.getAnnotatedStatementAccess().getAnnotationAnnotationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleAnnotation_in_ruleAnnotatedStatement9908);
            lv_annotation_1_0=ruleAnnotation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAnnotatedStatementRule());
            	        }
                   		set(
                   			current, 
                   			"annotation",
                    		lv_annotation_1_0, 
                    		"Annotation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4630:2: ( (lv_statement_2_0= ruleStatement ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4631:1: (lv_statement_2_0= ruleStatement )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4631:1: (lv_statement_2_0= ruleStatement )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4632:3: lv_statement_2_0= ruleStatement
            {
             
            	        newCompositeNode(grammarAccess.getAnnotatedStatementAccess().getStatementStatementParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleStatement_in_ruleAnnotatedStatement9929);
            lv_statement_2_0=ruleStatement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAnnotatedStatementRule());
            	        }
                   		set(
                   			current, 
                   			"statement",
                    		lv_statement_2_0, 
                    		"Statement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotatedStatement"


    // $ANTLR start "entryRuleStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4656:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4657:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4658:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement9965);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement9975); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4665:1: ruleStatement returns [EObject current=null] : (this_AnnotatedStatement_0= ruleAnnotatedStatement | this_InlineStatement_1= ruleInlineStatement | this_BlockStatement_2= ruleBlockStatement | this_EmptyStatement_3= ruleEmptyStatement | this_LocalNameDeclarationStatement_4= ruleLocalNameDeclarationStatement | this_IfStatement_5= ruleIfStatement | this_SwitchStatement_6= ruleSwitchStatement | this_WhileStatement_7= ruleWhileStatement | this_DoStatement_8= ruleDoStatement | this_ForStatement_9= ruleForStatement | this_BreakStatement_10= ruleBreakStatement | this_ReturnStatement_11= ruleReturnStatement | this_AcceptStatement_12= ruleAcceptStatement | this_ClassifyStatement_13= ruleClassifyStatement | this_InvocationOrAssignementOrDeclarationStatement_14= ruleInvocationOrAssignementOrDeclarationStatement | this_SuperInvocationStatement_15= ruleSuperInvocationStatement | this_ThisInvocationStatement_16= ruleThisInvocationStatement | this_InstanceCreationInvocationStatement_17= ruleInstanceCreationInvocationStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_AnnotatedStatement_0 = null;

        EObject this_InlineStatement_1 = null;

        EObject this_BlockStatement_2 = null;

        EObject this_EmptyStatement_3 = null;

        EObject this_LocalNameDeclarationStatement_4 = null;

        EObject this_IfStatement_5 = null;

        EObject this_SwitchStatement_6 = null;

        EObject this_WhileStatement_7 = null;

        EObject this_DoStatement_8 = null;

        EObject this_ForStatement_9 = null;

        EObject this_BreakStatement_10 = null;

        EObject this_ReturnStatement_11 = null;

        EObject this_AcceptStatement_12 = null;

        EObject this_ClassifyStatement_13 = null;

        EObject this_InvocationOrAssignementOrDeclarationStatement_14 = null;

        EObject this_SuperInvocationStatement_15 = null;

        EObject this_ThisInvocationStatement_16 = null;

        EObject this_InstanceCreationInvocationStatement_17 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4668:28: ( (this_AnnotatedStatement_0= ruleAnnotatedStatement | this_InlineStatement_1= ruleInlineStatement | this_BlockStatement_2= ruleBlockStatement | this_EmptyStatement_3= ruleEmptyStatement | this_LocalNameDeclarationStatement_4= ruleLocalNameDeclarationStatement | this_IfStatement_5= ruleIfStatement | this_SwitchStatement_6= ruleSwitchStatement | this_WhileStatement_7= ruleWhileStatement | this_DoStatement_8= ruleDoStatement | this_ForStatement_9= ruleForStatement | this_BreakStatement_10= ruleBreakStatement | this_ReturnStatement_11= ruleReturnStatement | this_AcceptStatement_12= ruleAcceptStatement | this_ClassifyStatement_13= ruleClassifyStatement | this_InvocationOrAssignementOrDeclarationStatement_14= ruleInvocationOrAssignementOrDeclarationStatement | this_SuperInvocationStatement_15= ruleSuperInvocationStatement | this_ThisInvocationStatement_16= ruleThisInvocationStatement | this_InstanceCreationInvocationStatement_17= ruleInstanceCreationInvocationStatement ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4669:1: (this_AnnotatedStatement_0= ruleAnnotatedStatement | this_InlineStatement_1= ruleInlineStatement | this_BlockStatement_2= ruleBlockStatement | this_EmptyStatement_3= ruleEmptyStatement | this_LocalNameDeclarationStatement_4= ruleLocalNameDeclarationStatement | this_IfStatement_5= ruleIfStatement | this_SwitchStatement_6= ruleSwitchStatement | this_WhileStatement_7= ruleWhileStatement | this_DoStatement_8= ruleDoStatement | this_ForStatement_9= ruleForStatement | this_BreakStatement_10= ruleBreakStatement | this_ReturnStatement_11= ruleReturnStatement | this_AcceptStatement_12= ruleAcceptStatement | this_ClassifyStatement_13= ruleClassifyStatement | this_InvocationOrAssignementOrDeclarationStatement_14= ruleInvocationOrAssignementOrDeclarationStatement | this_SuperInvocationStatement_15= ruleSuperInvocationStatement | this_ThisInvocationStatement_16= ruleThisInvocationStatement | this_InstanceCreationInvocationStatement_17= ruleInstanceCreationInvocationStatement )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4669:1: (this_AnnotatedStatement_0= ruleAnnotatedStatement | this_InlineStatement_1= ruleInlineStatement | this_BlockStatement_2= ruleBlockStatement | this_EmptyStatement_3= ruleEmptyStatement | this_LocalNameDeclarationStatement_4= ruleLocalNameDeclarationStatement | this_IfStatement_5= ruleIfStatement | this_SwitchStatement_6= ruleSwitchStatement | this_WhileStatement_7= ruleWhileStatement | this_DoStatement_8= ruleDoStatement | this_ForStatement_9= ruleForStatement | this_BreakStatement_10= ruleBreakStatement | this_ReturnStatement_11= ruleReturnStatement | this_AcceptStatement_12= ruleAcceptStatement | this_ClassifyStatement_13= ruleClassifyStatement | this_InvocationOrAssignementOrDeclarationStatement_14= ruleInvocationOrAssignementOrDeclarationStatement | this_SuperInvocationStatement_15= ruleSuperInvocationStatement | this_ThisInvocationStatement_16= ruleThisInvocationStatement | this_InstanceCreationInvocationStatement_17= ruleInstanceCreationInvocationStatement )
            int alt77=18;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt77=1;
                }
                break;
            case 64:
                {
                alt77=2;
                }
                break;
            case 60:
                {
                alt77=3;
                }
                break;
            case 68:
                {
                alt77=4;
                }
                break;
            case 69:
                {
                alt77=5;
                }
                break;
            case 71:
                {
                alt77=6;
                }
                break;
            case 74:
                {
                alt77=7;
                }
                break;
            case 77:
                {
                alt77=8;
                }
                break;
            case 78:
                {
                alt77=9;
                }
                break;
            case 79:
                {
                alt77=10;
                }
                break;
            case 81:
                {
                alt77=11;
                }
                break;
            case 82:
                {
                alt77=12;
                }
                break;
            case 83:
                {
                alt77=13;
                }
                break;
            case 84:
                {
                alt77=14;
                }
                break;
            case RULE_ID:
            case 17:
            case 18:
                {
                alt77=15;
                }
                break;
            case 58:
                {
                alt77=16;
                }
                break;
            case 57:
                {
                alt77=17;
                }
                break;
            case 59:
                {
                alt77=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4670:5: this_AnnotatedStatement_0= ruleAnnotatedStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getAnnotatedStatementParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleAnnotatedStatement_in_ruleStatement10022);
                    this_AnnotatedStatement_0=ruleAnnotatedStatement();

                    state._fsp--;

                     
                            current = this_AnnotatedStatement_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4680:5: this_InlineStatement_1= ruleInlineStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getInlineStatementParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleInlineStatement_in_ruleStatement10049);
                    this_InlineStatement_1=ruleInlineStatement();

                    state._fsp--;

                     
                            current = this_InlineStatement_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4690:5: this_BlockStatement_2= ruleBlockStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockStatementParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBlockStatement_in_ruleStatement10076);
                    this_BlockStatement_2=ruleBlockStatement();

                    state._fsp--;

                     
                            current = this_BlockStatement_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4700:5: this_EmptyStatement_3= ruleEmptyStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getEmptyStatementParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleEmptyStatement_in_ruleStatement10103);
                    this_EmptyStatement_3=ruleEmptyStatement();

                    state._fsp--;

                     
                            current = this_EmptyStatement_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4710:5: this_LocalNameDeclarationStatement_4= ruleLocalNameDeclarationStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getLocalNameDeclarationStatementParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleLocalNameDeclarationStatement_in_ruleStatement10130);
                    this_LocalNameDeclarationStatement_4=ruleLocalNameDeclarationStatement();

                    state._fsp--;

                     
                            current = this_LocalNameDeclarationStatement_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4720:5: this_IfStatement_5= ruleIfStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement10157);
                    this_IfStatement_5=ruleIfStatement();

                    state._fsp--;

                     
                            current = this_IfStatement_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4730:5: this_SwitchStatement_6= ruleSwitchStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatementParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleSwitchStatement_in_ruleStatement10184);
                    this_SwitchStatement_6=ruleSwitchStatement();

                    state._fsp--;

                     
                            current = this_SwitchStatement_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4740:5: this_WhileStatement_7= ruleWhileStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement10211);
                    this_WhileStatement_7=ruleWhileStatement();

                    state._fsp--;

                     
                            current = this_WhileStatement_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4750:5: this_DoStatement_8= ruleDoStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getDoStatementParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleDoStatement_in_ruleStatement10238);
                    this_DoStatement_8=ruleDoStatement();

                    state._fsp--;

                     
                            current = this_DoStatement_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4760:5: this_ForStatement_9= ruleForStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getForStatementParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleForStatement_in_ruleStatement10265);
                    this_ForStatement_9=ruleForStatement();

                    state._fsp--;

                     
                            current = this_ForStatement_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4770:5: this_BreakStatement_10= ruleBreakStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBreakStatementParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleBreakStatement_in_ruleStatement10292);
                    this_BreakStatement_10=ruleBreakStatement();

                    state._fsp--;

                     
                            current = this_BreakStatement_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4780:5: this_ReturnStatement_11= ruleReturnStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement10319);
                    this_ReturnStatement_11=ruleReturnStatement();

                    state._fsp--;

                     
                            current = this_ReturnStatement_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4790:5: this_AcceptStatement_12= ruleAcceptStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getAcceptStatementParserRuleCall_12()); 
                        
                    pushFollow(FOLLOW_ruleAcceptStatement_in_ruleStatement10346);
                    this_AcceptStatement_12=ruleAcceptStatement();

                    state._fsp--;

                     
                            current = this_AcceptStatement_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4800:5: this_ClassifyStatement_13= ruleClassifyStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getClassifyStatementParserRuleCall_13()); 
                        
                    pushFollow(FOLLOW_ruleClassifyStatement_in_ruleStatement10373);
                    this_ClassifyStatement_13=ruleClassifyStatement();

                    state._fsp--;

                     
                            current = this_ClassifyStatement_13; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4810:5: this_InvocationOrAssignementOrDeclarationStatement_14= ruleInvocationOrAssignementOrDeclarationStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getInvocationOrAssignementOrDeclarationStatementParserRuleCall_14()); 
                        
                    pushFollow(FOLLOW_ruleInvocationOrAssignementOrDeclarationStatement_in_ruleStatement10400);
                    this_InvocationOrAssignementOrDeclarationStatement_14=ruleInvocationOrAssignementOrDeclarationStatement();

                    state._fsp--;

                     
                            current = this_InvocationOrAssignementOrDeclarationStatement_14; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4820:5: this_SuperInvocationStatement_15= ruleSuperInvocationStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getSuperInvocationStatementParserRuleCall_15()); 
                        
                    pushFollow(FOLLOW_ruleSuperInvocationStatement_in_ruleStatement10427);
                    this_SuperInvocationStatement_15=ruleSuperInvocationStatement();

                    state._fsp--;

                     
                            current = this_SuperInvocationStatement_15; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4830:5: this_ThisInvocationStatement_16= ruleThisInvocationStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getThisInvocationStatementParserRuleCall_16()); 
                        
                    pushFollow(FOLLOW_ruleThisInvocationStatement_in_ruleStatement10454);
                    this_ThisInvocationStatement_16=ruleThisInvocationStatement();

                    state._fsp--;

                     
                            current = this_ThisInvocationStatement_16; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4840:5: this_InstanceCreationInvocationStatement_17= ruleInstanceCreationInvocationStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getInstanceCreationInvocationStatementParserRuleCall_17()); 
                        
                    pushFollow(FOLLOW_ruleInstanceCreationInvocationStatement_in_ruleStatement10481);
                    this_InstanceCreationInvocationStatement_17=ruleInstanceCreationInvocationStatement();

                    state._fsp--;

                     
                            current = this_InstanceCreationInvocationStatement_17; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleAnnotation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4856:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4857:2: (iv_ruleAnnotation= ruleAnnotation EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4858:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
             newCompositeNode(grammarAccess.getAnnotationRule()); 
            pushFollow(FOLLOW_ruleAnnotation_in_entryRuleAnnotation10516);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;

             current =iv_ruleAnnotation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnnotation10526); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4865:1: ruleAnnotation returns [EObject current=null] : ( ( (lv_kind_0_0= ruleAnnotationKind ) ) (otherlv_1= '(' ( (lv_args_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )* otherlv_5= ')' )? ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_args_2_0=null;
        Token otherlv_3=null;
        Token lv_args_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_kind_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4868:28: ( ( ( (lv_kind_0_0= ruleAnnotationKind ) ) (otherlv_1= '(' ( (lv_args_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )* otherlv_5= ')' )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4869:1: ( ( (lv_kind_0_0= ruleAnnotationKind ) ) (otherlv_1= '(' ( (lv_args_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )* otherlv_5= ')' )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4869:1: ( ( (lv_kind_0_0= ruleAnnotationKind ) ) (otherlv_1= '(' ( (lv_args_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )* otherlv_5= ')' )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4869:2: ( (lv_kind_0_0= ruleAnnotationKind ) ) (otherlv_1= '(' ( (lv_args_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )* otherlv_5= ')' )?
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4869:2: ( (lv_kind_0_0= ruleAnnotationKind ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4870:1: (lv_kind_0_0= ruleAnnotationKind )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4870:1: (lv_kind_0_0= ruleAnnotationKind )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4871:3: lv_kind_0_0= ruleAnnotationKind
            {
             
            	        newCompositeNode(grammarAccess.getAnnotationAccess().getKindAnnotationKindEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAnnotationKind_in_ruleAnnotation10572);
            lv_kind_0_0=ruleAnnotationKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAnnotationRule());
            	        }
                   		set(
                   			current, 
                   			"kind",
                    		lv_kind_0_0, 
                    		"AnnotationKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4887:2: (otherlv_1= '(' ( (lv_args_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )* otherlv_5= ')' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==24) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4887:4: otherlv_1= '(' ( (lv_args_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )* otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleAnnotation10585); 

                        	newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4891:1: ( (lv_args_2_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4892:1: (lv_args_2_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4892:1: (lv_args_2_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4893:3: lv_args_2_0= RULE_ID
                    {
                    lv_args_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotation10602); 

                    			newLeafNode(lv_args_2_0, grammarAccess.getAnnotationAccess().getArgsIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAnnotationRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"args",
                            		lv_args_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4909:2: (otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) ) )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==21) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4909:4: otherlv_3= ',' ( (lv_args_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleAnnotation10620); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getAnnotationAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4913:1: ( (lv_args_4_0= RULE_ID ) )
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4914:1: (lv_args_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4914:1: (lv_args_4_0= RULE_ID )
                    	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4915:3: lv_args_4_0= RULE_ID
                    	    {
                    	    lv_args_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAnnotation10637); 

                    	    			newLeafNode(lv_args_4_0, grammarAccess.getAnnotationAccess().getArgsIDTerminalRuleCall_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getAnnotationRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"args",
                    	            		lv_args_4_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleAnnotation10656); 

                        	newLeafNode(otherlv_5, grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_1_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleBlockStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4943:1: entryRuleBlockStatement returns [EObject current=null] : iv_ruleBlockStatement= ruleBlockStatement EOF ;
    public final EObject entryRuleBlockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4944:2: (iv_ruleBlockStatement= ruleBlockStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4945:2: iv_ruleBlockStatement= ruleBlockStatement EOF
            {
             newCompositeNode(grammarAccess.getBlockStatementRule()); 
            pushFollow(FOLLOW_ruleBlockStatement_in_entryRuleBlockStatement10694);
            iv_ruleBlockStatement=ruleBlockStatement();

            state._fsp--;

             current =iv_ruleBlockStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlockStatement10704); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockStatement"


    // $ANTLR start "ruleBlockStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4952:1: ruleBlockStatement returns [EObject current=null] : ( (lv_block_0_0= ruleBlock ) ) ;
    public final EObject ruleBlockStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_block_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4955:28: ( ( (lv_block_0_0= ruleBlock ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4956:1: ( (lv_block_0_0= ruleBlock ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4956:1: ( (lv_block_0_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4957:1: (lv_block_0_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4957:1: (lv_block_0_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4958:3: lv_block_0_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getBlockStatementAccess().getBlockBlockParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleBlockStatement10749);
            lv_block_0_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBlockStatementRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_0_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockStatement"


    // $ANTLR start "entryRuleEmptyStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4982:1: entryRuleEmptyStatement returns [EObject current=null] : iv_ruleEmptyStatement= ruleEmptyStatement EOF ;
    public final EObject entryRuleEmptyStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4983:2: (iv_ruleEmptyStatement= ruleEmptyStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4984:2: iv_ruleEmptyStatement= ruleEmptyStatement EOF
            {
             newCompositeNode(grammarAccess.getEmptyStatementRule()); 
            pushFollow(FOLLOW_ruleEmptyStatement_in_entryRuleEmptyStatement10784);
            iv_ruleEmptyStatement=ruleEmptyStatement();

            state._fsp--;

             current =iv_ruleEmptyStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyStatement10794); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEmptyStatement"


    // $ANTLR start "ruleEmptyStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4991:1: ruleEmptyStatement returns [EObject current=null] : ( () otherlv_1= ';' ) ;
    public final EObject ruleEmptyStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4994:28: ( ( () otherlv_1= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4995:1: ( () otherlv_1= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4995:1: ( () otherlv_1= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4995:2: () otherlv_1= ';'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4995:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:4996:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEmptyStatementAccess().getEmptyStatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleEmptyStatement10840); 

                	newLeafNode(otherlv_1, grammarAccess.getEmptyStatementAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEmptyStatement"


    // $ANTLR start "entryRuleLocalNameDeclarationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5013:1: entryRuleLocalNameDeclarationStatement returns [EObject current=null] : iv_ruleLocalNameDeclarationStatement= ruleLocalNameDeclarationStatement EOF ;
    public final EObject entryRuleLocalNameDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalNameDeclarationStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5014:2: (iv_ruleLocalNameDeclarationStatement= ruleLocalNameDeclarationStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5015:2: iv_ruleLocalNameDeclarationStatement= ruleLocalNameDeclarationStatement EOF
            {
             newCompositeNode(grammarAccess.getLocalNameDeclarationStatementRule()); 
            pushFollow(FOLLOW_ruleLocalNameDeclarationStatement_in_entryRuleLocalNameDeclarationStatement10876);
            iv_ruleLocalNameDeclarationStatement=ruleLocalNameDeclarationStatement();

            state._fsp--;

             current =iv_ruleLocalNameDeclarationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalNameDeclarationStatement10886); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalNameDeclarationStatement"


    // $ANTLR start "ruleLocalNameDeclarationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5022:1: ruleLocalNameDeclarationStatement returns [EObject current=null] : (otherlv_0= 'let' ( (lv_varName_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_multiplicityIndicator_4_0= '[' ) ) otherlv_5= ']' )? otherlv_6= '=' ( (lv_init_7_0= ruleSequenceElement ) ) otherlv_8= ';' ) ;
    public final EObject ruleLocalNameDeclarationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_varName_1_0=null;
        Token otherlv_2=null;
        Token lv_multiplicityIndicator_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_type_3_0 = null;

        EObject lv_init_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5025:28: ( (otherlv_0= 'let' ( (lv_varName_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_multiplicityIndicator_4_0= '[' ) ) otherlv_5= ']' )? otherlv_6= '=' ( (lv_init_7_0= ruleSequenceElement ) ) otherlv_8= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5026:1: (otherlv_0= 'let' ( (lv_varName_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_multiplicityIndicator_4_0= '[' ) ) otherlv_5= ']' )? otherlv_6= '=' ( (lv_init_7_0= ruleSequenceElement ) ) otherlv_8= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5026:1: (otherlv_0= 'let' ( (lv_varName_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_multiplicityIndicator_4_0= '[' ) ) otherlv_5= ']' )? otherlv_6= '=' ( (lv_init_7_0= ruleSequenceElement ) ) otherlv_8= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5026:3: otherlv_0= 'let' ( (lv_varName_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleQualifiedNameWithBinding ) ) ( ( (lv_multiplicityIndicator_4_0= '[' ) ) otherlv_5= ']' )? otherlv_6= '=' ( (lv_init_7_0= ruleSequenceElement ) ) otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleLocalNameDeclarationStatement10923); 

                	newLeafNode(otherlv_0, grammarAccess.getLocalNameDeclarationStatementAccess().getLetKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5030:1: ( (lv_varName_1_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5031:1: (lv_varName_1_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5031:1: (lv_varName_1_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5032:3: lv_varName_1_0= RULE_ID
            {
            lv_varName_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLocalNameDeclarationStatement10940); 

            			newLeafNode(lv_varName_1_0, grammarAccess.getLocalNameDeclarationStatementAccess().getVarNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLocalNameDeclarationStatementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"varName",
                    		lv_varName_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleLocalNameDeclarationStatement10957); 

                	newLeafNode(otherlv_2, grammarAccess.getLocalNameDeclarationStatementAccess().getColonKeyword_2());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5052:1: ( (lv_type_3_0= ruleQualifiedNameWithBinding ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5053:1: (lv_type_3_0= ruleQualifiedNameWithBinding )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5053:1: (lv_type_3_0= ruleQualifiedNameWithBinding )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5054:3: lv_type_3_0= ruleQualifiedNameWithBinding
            {
             
            	        newCompositeNode(grammarAccess.getLocalNameDeclarationStatementAccess().getTypeQualifiedNameWithBindingParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleLocalNameDeclarationStatement10978);
            lv_type_3_0=ruleQualifiedNameWithBinding();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalNameDeclarationStatementRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_3_0, 
                    		"QualifiedNameWithBinding");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5070:2: ( ( (lv_multiplicityIndicator_4_0= '[' ) ) otherlv_5= ']' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==50) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5070:3: ( (lv_multiplicityIndicator_4_0= '[' ) ) otherlv_5= ']'
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5070:3: ( (lv_multiplicityIndicator_4_0= '[' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5071:1: (lv_multiplicityIndicator_4_0= '[' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5071:1: (lv_multiplicityIndicator_4_0= '[' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5072:3: lv_multiplicityIndicator_4_0= '['
                    {
                    lv_multiplicityIndicator_4_0=(Token)match(input,50,FOLLOW_50_in_ruleLocalNameDeclarationStatement10997); 

                            newLeafNode(lv_multiplicityIndicator_4_0, grammarAccess.getLocalNameDeclarationStatementAccess().getMultiplicityIndicatorLeftSquareBracketKeyword_4_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLocalNameDeclarationStatementRule());
                    	        }
                           		setWithLastConsumed(current, "multiplicityIndicator", true, "[");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,51,FOLLOW_51_in_ruleLocalNameDeclarationStatement11022); 

                        	newLeafNode(otherlv_5, grammarAccess.getLocalNameDeclarationStatementAccess().getRightSquareBracketKeyword_4_1());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,70,FOLLOW_70_in_ruleLocalNameDeclarationStatement11036); 

                	newLeafNode(otherlv_6, grammarAccess.getLocalNameDeclarationStatementAccess().getEqualsSignKeyword_5());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5093:1: ( (lv_init_7_0= ruleSequenceElement ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5094:1: (lv_init_7_0= ruleSequenceElement )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5094:1: (lv_init_7_0= ruleSequenceElement )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5095:3: lv_init_7_0= ruleSequenceElement
            {
             
            	        newCompositeNode(grammarAccess.getLocalNameDeclarationStatementAccess().getInitSequenceElementParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleSequenceElement_in_ruleLocalNameDeclarationStatement11057);
            lv_init_7_0=ruleSequenceElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLocalNameDeclarationStatementRule());
            	        }
                   		set(
                   			current, 
                   			"init",
                    		lv_init_7_0, 
                    		"SequenceElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,68,FOLLOW_68_in_ruleLocalNameDeclarationStatement11069); 

                	newLeafNode(otherlv_8, grammarAccess.getLocalNameDeclarationStatementAccess().getSemicolonKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalNameDeclarationStatement"


    // $ANTLR start "entryRuleIfStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5123:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5124:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5125:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement11105);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement11115); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5132:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_sequentialClausses_1_0= ruleSequentialClauses ) ) ( (lv_finalClause_2_0= ruleFinalClause ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_sequentialClausses_1_0 = null;

        EObject lv_finalClause_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5135:28: ( (otherlv_0= 'if' ( (lv_sequentialClausses_1_0= ruleSequentialClauses ) ) ( (lv_finalClause_2_0= ruleFinalClause ) )? ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5136:1: (otherlv_0= 'if' ( (lv_sequentialClausses_1_0= ruleSequentialClauses ) ) ( (lv_finalClause_2_0= ruleFinalClause ) )? )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5136:1: (otherlv_0= 'if' ( (lv_sequentialClausses_1_0= ruleSequentialClauses ) ) ( (lv_finalClause_2_0= ruleFinalClause ) )? )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5136:3: otherlv_0= 'if' ( (lv_sequentialClausses_1_0= ruleSequentialClauses ) ) ( (lv_finalClause_2_0= ruleFinalClause ) )?
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleIfStatement11152); 

                	newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5140:1: ( (lv_sequentialClausses_1_0= ruleSequentialClauses ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5141:1: (lv_sequentialClausses_1_0= ruleSequentialClauses )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5141:1: (lv_sequentialClausses_1_0= ruleSequentialClauses )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5142:3: lv_sequentialClausses_1_0= ruleSequentialClauses
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getSequentialClaussesSequentialClausesParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSequentialClauses_in_ruleIfStatement11173);
            lv_sequentialClausses_1_0=ruleSequentialClauses();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	        }
                   		set(
                   			current, 
                   			"sequentialClausses",
                    		lv_sequentialClausses_1_0, 
                    		"SequentialClauses");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5158:2: ( (lv_finalClause_2_0= ruleFinalClause ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==72) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5159:1: (lv_finalClause_2_0= ruleFinalClause )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5159:1: (lv_finalClause_2_0= ruleFinalClause )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5160:3: lv_finalClause_2_0= ruleFinalClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfStatementAccess().getFinalClauseFinalClauseParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFinalClause_in_ruleIfStatement11194);
                    lv_finalClause_2_0=ruleFinalClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"finalClause",
                            		lv_finalClause_2_0, 
                            		"FinalClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleSequentialClauses"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5184:1: entryRuleSequentialClauses returns [EObject current=null] : iv_ruleSequentialClauses= ruleSequentialClauses EOF ;
    public final EObject entryRuleSequentialClauses() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequentialClauses = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5185:2: (iv_ruleSequentialClauses= ruleSequentialClauses EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5186:2: iv_ruleSequentialClauses= ruleSequentialClauses EOF
            {
             newCompositeNode(grammarAccess.getSequentialClausesRule()); 
            pushFollow(FOLLOW_ruleSequentialClauses_in_entryRuleSequentialClauses11231);
            iv_ruleSequentialClauses=ruleSequentialClauses();

            state._fsp--;

             current =iv_ruleSequentialClauses; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequentialClauses11241); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequentialClauses"


    // $ANTLR start "ruleSequentialClauses"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5193:1: ruleSequentialClauses returns [EObject current=null] : ( ( (lv_conccurentClauses_0_0= ruleConcurrentClauses ) ) (otherlv_1= 'else' otherlv_2= 'if' ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) ) )* ) ;
    public final EObject ruleSequentialClauses() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_conccurentClauses_0_0 = null;

        EObject lv_conccurentClauses_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5196:28: ( ( ( (lv_conccurentClauses_0_0= ruleConcurrentClauses ) ) (otherlv_1= 'else' otherlv_2= 'if' ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5197:1: ( ( (lv_conccurentClauses_0_0= ruleConcurrentClauses ) ) (otherlv_1= 'else' otherlv_2= 'if' ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5197:1: ( ( (lv_conccurentClauses_0_0= ruleConcurrentClauses ) ) (otherlv_1= 'else' otherlv_2= 'if' ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5197:2: ( (lv_conccurentClauses_0_0= ruleConcurrentClauses ) ) (otherlv_1= 'else' otherlv_2= 'if' ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5197:2: ( (lv_conccurentClauses_0_0= ruleConcurrentClauses ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5198:1: (lv_conccurentClauses_0_0= ruleConcurrentClauses )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5198:1: (lv_conccurentClauses_0_0= ruleConcurrentClauses )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5199:3: lv_conccurentClauses_0_0= ruleConcurrentClauses
            {
             
            	        newCompositeNode(grammarAccess.getSequentialClausesAccess().getConccurentClausesConcurrentClausesParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConcurrentClauses_in_ruleSequentialClauses11287);
            lv_conccurentClauses_0_0=ruleConcurrentClauses();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSequentialClausesRule());
            	        }
                   		add(
                   			current, 
                   			"conccurentClauses",
                    		lv_conccurentClauses_0_0, 
                    		"ConcurrentClauses");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5215:2: (otherlv_1= 'else' otherlv_2= 'if' ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==72) ) {
                    int LA82_1 = input.LA(2);

                    if ( (LA82_1==71) ) {
                        alt82=1;
                    }


                }


                switch (alt82) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5215:4: otherlv_1= 'else' otherlv_2= 'if' ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) )
            	    {
            	    otherlv_1=(Token)match(input,72,FOLLOW_72_in_ruleSequentialClauses11300); 

            	        	newLeafNode(otherlv_1, grammarAccess.getSequentialClausesAccess().getElseKeyword_1_0());
            	        
            	    otherlv_2=(Token)match(input,71,FOLLOW_71_in_ruleSequentialClauses11312); 

            	        	newLeafNode(otherlv_2, grammarAccess.getSequentialClausesAccess().getIfKeyword_1_1());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5223:1: ( (lv_conccurentClauses_3_0= ruleConcurrentClauses ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5224:1: (lv_conccurentClauses_3_0= ruleConcurrentClauses )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5224:1: (lv_conccurentClauses_3_0= ruleConcurrentClauses )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5225:3: lv_conccurentClauses_3_0= ruleConcurrentClauses
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSequentialClausesAccess().getConccurentClausesConcurrentClausesParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConcurrentClauses_in_ruleSequentialClauses11333);
            	    lv_conccurentClauses_3_0=ruleConcurrentClauses();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSequentialClausesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"conccurentClauses",
            	            		lv_conccurentClauses_3_0, 
            	            		"ConcurrentClauses");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequentialClauses"


    // $ANTLR start "entryRuleConcurrentClauses"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5249:1: entryRuleConcurrentClauses returns [EObject current=null] : iv_ruleConcurrentClauses= ruleConcurrentClauses EOF ;
    public final EObject entryRuleConcurrentClauses() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcurrentClauses = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5250:2: (iv_ruleConcurrentClauses= ruleConcurrentClauses EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5251:2: iv_ruleConcurrentClauses= ruleConcurrentClauses EOF
            {
             newCompositeNode(grammarAccess.getConcurrentClausesRule()); 
            pushFollow(FOLLOW_ruleConcurrentClauses_in_entryRuleConcurrentClauses11371);
            iv_ruleConcurrentClauses=ruleConcurrentClauses();

            state._fsp--;

             current =iv_ruleConcurrentClauses; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcurrentClauses11381); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcurrentClauses"


    // $ANTLR start "ruleConcurrentClauses"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5258:1: ruleConcurrentClauses returns [EObject current=null] : ( ( (lv_nonFinalClause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) ) )* ) ;
    public final EObject ruleConcurrentClauses() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_nonFinalClause_0_0 = null;

        EObject lv_nonFinalClause_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5261:28: ( ( ( (lv_nonFinalClause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5262:1: ( ( (lv_nonFinalClause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5262:1: ( ( (lv_nonFinalClause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5262:2: ( (lv_nonFinalClause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5262:2: ( (lv_nonFinalClause_0_0= ruleNonFinalClause ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5263:1: (lv_nonFinalClause_0_0= ruleNonFinalClause )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5263:1: (lv_nonFinalClause_0_0= ruleNonFinalClause )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5264:3: lv_nonFinalClause_0_0= ruleNonFinalClause
            {
             
            	        newCompositeNode(grammarAccess.getConcurrentClausesAccess().getNonFinalClauseNonFinalClauseParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses11427);
            lv_nonFinalClause_0_0=ruleNonFinalClause();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConcurrentClausesRule());
            	        }
                   		add(
                   			current, 
                   			"nonFinalClause",
                    		lv_nonFinalClause_0_0, 
                    		"NonFinalClause");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5280:2: (otherlv_1= 'or' otherlv_2= 'if' ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) ) )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==73) ) {
                    alt83=1;
                }


                switch (alt83) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5280:4: otherlv_1= 'or' otherlv_2= 'if' ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) )
            	    {
            	    otherlv_1=(Token)match(input,73,FOLLOW_73_in_ruleConcurrentClauses11440); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConcurrentClausesAccess().getOrKeyword_1_0());
            	        
            	    otherlv_2=(Token)match(input,71,FOLLOW_71_in_ruleConcurrentClauses11452); 

            	        	newLeafNode(otherlv_2, grammarAccess.getConcurrentClausesAccess().getIfKeyword_1_1());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5288:1: ( (lv_nonFinalClause_3_0= ruleNonFinalClause ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5289:1: (lv_nonFinalClause_3_0= ruleNonFinalClause )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5289:1: (lv_nonFinalClause_3_0= ruleNonFinalClause )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5290:3: lv_nonFinalClause_3_0= ruleNonFinalClause
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConcurrentClausesAccess().getNonFinalClauseNonFinalClauseParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses11473);
            	    lv_nonFinalClause_3_0=ruleNonFinalClause();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConcurrentClausesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nonFinalClause",
            	            		lv_nonFinalClause_3_0, 
            	            		"NonFinalClause");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcurrentClauses"


    // $ANTLR start "entryRuleNonFinalClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5314:1: entryRuleNonFinalClause returns [EObject current=null] : iv_ruleNonFinalClause= ruleNonFinalClause EOF ;
    public final EObject entryRuleNonFinalClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonFinalClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5315:2: (iv_ruleNonFinalClause= ruleNonFinalClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5316:2: iv_ruleNonFinalClause= ruleNonFinalClause EOF
            {
             newCompositeNode(grammarAccess.getNonFinalClauseRule()); 
            pushFollow(FOLLOW_ruleNonFinalClause_in_entryRuleNonFinalClause11511);
            iv_ruleNonFinalClause=ruleNonFinalClause();

            state._fsp--;

             current =iv_ruleNonFinalClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonFinalClause11521); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonFinalClause"


    // $ANTLR start "ruleNonFinalClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5323:1: ruleNonFinalClause returns [EObject current=null] : (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_block_3_0= ruleBlock ) ) ) ;
    public final EObject ruleNonFinalClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_block_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5326:28: ( (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_block_3_0= ruleBlock ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5327:1: (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_block_3_0= ruleBlock ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5327:1: (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_block_3_0= ruleBlock ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5327:3: otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_block_3_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleNonFinalClause11558); 

                	newLeafNode(otherlv_0, grammarAccess.getNonFinalClauseAccess().getLeftParenthesisKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5331:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5332:1: (lv_condition_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5332:1: (lv_condition_1_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5333:3: lv_condition_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getNonFinalClauseAccess().getConditionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleNonFinalClause11579);
            lv_condition_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNonFinalClauseRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleNonFinalClause11591); 

                	newLeafNode(otherlv_2, grammarAccess.getNonFinalClauseAccess().getRightParenthesisKeyword_2());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5353:1: ( (lv_block_3_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5354:1: (lv_block_3_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5354:1: (lv_block_3_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5355:3: lv_block_3_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getNonFinalClauseAccess().getBlockBlockParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleNonFinalClause11612);
            lv_block_3_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNonFinalClauseRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_3_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonFinalClause"


    // $ANTLR start "entryRuleFinalClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5379:1: entryRuleFinalClause returns [EObject current=null] : iv_ruleFinalClause= ruleFinalClause EOF ;
    public final EObject entryRuleFinalClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinalClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5380:2: (iv_ruleFinalClause= ruleFinalClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5381:2: iv_ruleFinalClause= ruleFinalClause EOF
            {
             newCompositeNode(grammarAccess.getFinalClauseRule()); 
            pushFollow(FOLLOW_ruleFinalClause_in_entryRuleFinalClause11648);
            iv_ruleFinalClause=ruleFinalClause();

            state._fsp--;

             current =iv_ruleFinalClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFinalClause11658); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFinalClause"


    // $ANTLR start "ruleFinalClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5388:1: ruleFinalClause returns [EObject current=null] : (otherlv_0= 'else' ( (lv_block_1_0= ruleBlock ) ) ) ;
    public final EObject ruleFinalClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5391:28: ( (otherlv_0= 'else' ( (lv_block_1_0= ruleBlock ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5392:1: (otherlv_0= 'else' ( (lv_block_1_0= ruleBlock ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5392:1: (otherlv_0= 'else' ( (lv_block_1_0= ruleBlock ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5392:3: otherlv_0= 'else' ( (lv_block_1_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleFinalClause11695); 

                	newLeafNode(otherlv_0, grammarAccess.getFinalClauseAccess().getElseKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5396:1: ( (lv_block_1_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5397:1: (lv_block_1_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5397:1: (lv_block_1_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5398:3: lv_block_1_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getFinalClauseAccess().getBlockBlockParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFinalClause11716);
            lv_block_1_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFinalClauseRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_1_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFinalClause"


    // $ANTLR start "entryRuleSwitchStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5422:1: entryRuleSwitchStatement returns [EObject current=null] : iv_ruleSwitchStatement= ruleSwitchStatement EOF ;
    public final EObject entryRuleSwitchStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5423:2: (iv_ruleSwitchStatement= ruleSwitchStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5424:2: iv_ruleSwitchStatement= ruleSwitchStatement EOF
            {
             newCompositeNode(grammarAccess.getSwitchStatementRule()); 
            pushFollow(FOLLOW_ruleSwitchStatement_in_entryRuleSwitchStatement11752);
            iv_ruleSwitchStatement=ruleSwitchStatement();

            state._fsp--;

             current =iv_ruleSwitchStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchStatement11762); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStatement"


    // $ANTLR start "ruleSwitchStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5431:1: ruleSwitchStatement returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_switchClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' ) ;
    public final EObject ruleSwitchStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_expression_2_0 = null;

        EObject lv_switchClause_5_0 = null;

        EObject lv_defaultClause_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5434:28: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_switchClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5435:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_switchClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5435:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_switchClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5435:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_switchClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_74_in_ruleSwitchStatement11799); 

                	newLeafNode(otherlv_0, grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0());
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleSwitchStatement11811); 

                	newLeafNode(otherlv_1, grammarAccess.getSwitchStatementAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5443:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5444:1: (lv_expression_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5444:1: (lv_expression_2_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5445:3: lv_expression_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getSwitchStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchStatement11832);
            lv_expression_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleSwitchStatement11844); 

                	newLeafNode(otherlv_3, grammarAccess.getSwitchStatementAccess().getRightParenthesisKeyword_3());
                
            otherlv_4=(Token)match(input,60,FOLLOW_60_in_ruleSwitchStatement11856); 

                	newLeafNode(otherlv_4, grammarAccess.getSwitchStatementAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5469:1: ( (lv_switchClause_5_0= ruleSwitchClause ) )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==75) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5470:1: (lv_switchClause_5_0= ruleSwitchClause )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5470:1: (lv_switchClause_5_0= ruleSwitchClause )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5471:3: lv_switchClause_5_0= ruleSwitchClause
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSwitchStatementAccess().getSwitchClauseSwitchClauseParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSwitchClause_in_ruleSwitchStatement11877);
            	    lv_switchClause_5_0=ruleSwitchClause();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"switchClause",
            	            		lv_switchClause_5_0, 
            	            		"SwitchClause");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5487:3: ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==76) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5488:1: (lv_defaultClause_6_0= ruleSwitchDefaultClause )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5488:1: (lv_defaultClause_6_0= ruleSwitchDefaultClause )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5489:3: lv_defaultClause_6_0= ruleSwitchDefaultClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getSwitchStatementAccess().getDefaultClauseSwitchDefaultClauseParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSwitchDefaultClause_in_ruleSwitchStatement11899);
                    lv_defaultClause_6_0=ruleSwitchDefaultClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"defaultClause",
                            		lv_defaultClause_6_0, 
                            		"SwitchDefaultClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,62,FOLLOW_62_in_ruleSwitchStatement11912); 

                	newLeafNode(otherlv_7, grammarAccess.getSwitchStatementAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStatement"


    // $ANTLR start "entryRuleSwitchClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5517:1: entryRuleSwitchClause returns [EObject current=null] : iv_ruleSwitchClause= ruleSwitchClause EOF ;
    public final EObject entryRuleSwitchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5518:2: (iv_ruleSwitchClause= ruleSwitchClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5519:2: iv_ruleSwitchClause= ruleSwitchClause EOF
            {
             newCompositeNode(grammarAccess.getSwitchClauseRule()); 
            pushFollow(FOLLOW_ruleSwitchClause_in_entryRuleSwitchClause11948);
            iv_ruleSwitchClause=ruleSwitchClause();

            state._fsp--;

             current =iv_ruleSwitchClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchClause11958); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchClause"


    // $ANTLR start "ruleSwitchClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5526:1: ruleSwitchClause returns [EObject current=null] : ( ( (lv_switchCase_0_0= ruleSwitchCase ) ) ( (lv_switchCase_1_0= ruleSwitchCase ) )* ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) ) ;
    public final EObject ruleSwitchClause() throws RecognitionException {
        EObject current = null;

        EObject lv_switchCase_0_0 = null;

        EObject lv_switchCase_1_0 = null;

        EObject lv_statementSequence_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5529:28: ( ( ( (lv_switchCase_0_0= ruleSwitchCase ) ) ( (lv_switchCase_1_0= ruleSwitchCase ) )* ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5530:1: ( ( (lv_switchCase_0_0= ruleSwitchCase ) ) ( (lv_switchCase_1_0= ruleSwitchCase ) )* ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5530:1: ( ( (lv_switchCase_0_0= ruleSwitchCase ) ) ( (lv_switchCase_1_0= ruleSwitchCase ) )* ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5530:2: ( (lv_switchCase_0_0= ruleSwitchCase ) ) ( (lv_switchCase_1_0= ruleSwitchCase ) )* ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5530:2: ( (lv_switchCase_0_0= ruleSwitchCase ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5531:1: (lv_switchCase_0_0= ruleSwitchCase )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5531:1: (lv_switchCase_0_0= ruleSwitchCase )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5532:3: lv_switchCase_0_0= ruleSwitchCase
            {
             
            	        newCompositeNode(grammarAccess.getSwitchClauseAccess().getSwitchCaseSwitchCaseParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSwitchCase_in_ruleSwitchClause12004);
            lv_switchCase_0_0=ruleSwitchCase();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchClauseRule());
            	        }
                   		add(
                   			current, 
                   			"switchCase",
                    		lv_switchCase_0_0, 
                    		"SwitchCase");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5548:2: ( (lv_switchCase_1_0= ruleSwitchCase ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==75) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5549:1: (lv_switchCase_1_0= ruleSwitchCase )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5549:1: (lv_switchCase_1_0= ruleSwitchCase )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5550:3: lv_switchCase_1_0= ruleSwitchCase
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSwitchClauseAccess().getSwitchCaseSwitchCaseParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSwitchCase_in_ruleSwitchClause12025);
            	    lv_switchCase_1_0=ruleSwitchCase();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSwitchClauseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"switchCase",
            	            		lv_switchCase_1_0, 
            	            		"SwitchCase");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5566:3: ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5567:1: (lv_statementSequence_2_0= ruleNonEmptyStatementSequence )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5567:1: (lv_statementSequence_2_0= ruleNonEmptyStatementSequence )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5568:3: lv_statementSequence_2_0= ruleNonEmptyStatementSequence
            {
             
            	        newCompositeNode(grammarAccess.getSwitchClauseAccess().getStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchClause12047);
            lv_statementSequence_2_0=ruleNonEmptyStatementSequence();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchClauseRule());
            	        }
                   		set(
                   			current, 
                   			"statementSequence",
                    		lv_statementSequence_2_0, 
                    		"NonEmptyStatementSequence");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchClause"


    // $ANTLR start "entryRuleSwitchCase"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5592:1: entryRuleSwitchCase returns [EObject current=null] : iv_ruleSwitchCase= ruleSwitchCase EOF ;
    public final EObject entryRuleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchCase = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5593:2: (iv_ruleSwitchCase= ruleSwitchCase EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5594:2: iv_ruleSwitchCase= ruleSwitchCase EOF
            {
             newCompositeNode(grammarAccess.getSwitchCaseRule()); 
            pushFollow(FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase12083);
            iv_ruleSwitchCase=ruleSwitchCase();

            state._fsp--;

             current =iv_ruleSwitchCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchCase12093); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchCase"


    // $ANTLR start "ruleSwitchCase"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5601:1: ruleSwitchCase returns [EObject current=null] : (otherlv_0= 'case' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ':' ) ;
    public final EObject ruleSwitchCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5604:28: ( (otherlv_0= 'case' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ':' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5605:1: (otherlv_0= 'case' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ':' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5605:1: (otherlv_0= 'case' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ':' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5605:3: otherlv_0= 'case' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ':'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_75_in_ruleSwitchCase12130); 

                	newLeafNode(otherlv_0, grammarAccess.getSwitchCaseAccess().getCaseKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5609:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5610:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5610:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5611:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getSwitchCaseAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchCase12151);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchCaseRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleSwitchCase12163); 

                	newLeafNode(otherlv_2, grammarAccess.getSwitchCaseAccess().getColonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchCase"


    // $ANTLR start "entryRuleSwitchDefaultClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5639:1: entryRuleSwitchDefaultClause returns [EObject current=null] : iv_ruleSwitchDefaultClause= ruleSwitchDefaultClause EOF ;
    public final EObject entryRuleSwitchDefaultClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchDefaultClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5640:2: (iv_ruleSwitchDefaultClause= ruleSwitchDefaultClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5641:2: iv_ruleSwitchDefaultClause= ruleSwitchDefaultClause EOF
            {
             newCompositeNode(grammarAccess.getSwitchDefaultClauseRule()); 
            pushFollow(FOLLOW_ruleSwitchDefaultClause_in_entryRuleSwitchDefaultClause12199);
            iv_ruleSwitchDefaultClause=ruleSwitchDefaultClause();

            state._fsp--;

             current =iv_ruleSwitchDefaultClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchDefaultClause12209); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchDefaultClause"


    // $ANTLR start "ruleSwitchDefaultClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5648:1: ruleSwitchDefaultClause returns [EObject current=null] : (otherlv_0= 'default' otherlv_1= ':' ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) ) ;
    public final EObject ruleSwitchDefaultClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_statementSequence_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5651:28: ( (otherlv_0= 'default' otherlv_1= ':' ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5652:1: (otherlv_0= 'default' otherlv_1= ':' ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5652:1: (otherlv_0= 'default' otherlv_1= ':' ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5652:3: otherlv_0= 'default' otherlv_1= ':' ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) )
            {
            otherlv_0=(Token)match(input,76,FOLLOW_76_in_ruleSwitchDefaultClause12246); 

                	newLeafNode(otherlv_0, grammarAccess.getSwitchDefaultClauseAccess().getDefaultKeyword_0());
                
            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleSwitchDefaultClause12258); 

                	newLeafNode(otherlv_1, grammarAccess.getSwitchDefaultClauseAccess().getColonKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5660:1: ( (lv_statementSequence_2_0= ruleNonEmptyStatementSequence ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5661:1: (lv_statementSequence_2_0= ruleNonEmptyStatementSequence )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5661:1: (lv_statementSequence_2_0= ruleNonEmptyStatementSequence )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5662:3: lv_statementSequence_2_0= ruleNonEmptyStatementSequence
            {
             
            	        newCompositeNode(grammarAccess.getSwitchDefaultClauseAccess().getStatementSequenceNonEmptyStatementSequenceParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchDefaultClause12279);
            lv_statementSequence_2_0=ruleNonEmptyStatementSequence();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchDefaultClauseRule());
            	        }
                   		set(
                   			current, 
                   			"statementSequence",
                    		lv_statementSequence_2_0, 
                    		"NonEmptyStatementSequence");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchDefaultClause"


    // $ANTLR start "entryRuleNonEmptyStatementSequence"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5686:1: entryRuleNonEmptyStatementSequence returns [EObject current=null] : iv_ruleNonEmptyStatementSequence= ruleNonEmptyStatementSequence EOF ;
    public final EObject entryRuleNonEmptyStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonEmptyStatementSequence = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5687:2: (iv_ruleNonEmptyStatementSequence= ruleNonEmptyStatementSequence EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5688:2: iv_ruleNonEmptyStatementSequence= ruleNonEmptyStatementSequence EOF
            {
             newCompositeNode(grammarAccess.getNonEmptyStatementSequenceRule()); 
            pushFollow(FOLLOW_ruleNonEmptyStatementSequence_in_entryRuleNonEmptyStatementSequence12315);
            iv_ruleNonEmptyStatementSequence=ruleNonEmptyStatementSequence();

            state._fsp--;

             current =iv_ruleNonEmptyStatementSequence; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonEmptyStatementSequence12325); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonEmptyStatementSequence"


    // $ANTLR start "ruleNonEmptyStatementSequence"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5695:1: ruleNonEmptyStatementSequence returns [EObject current=null] : ( (lv_statement_0_0= ruleDocumentedStatement ) )+ ;
    public final EObject ruleNonEmptyStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5698:28: ( ( (lv_statement_0_0= ruleDocumentedStatement ) )+ )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5699:1: ( (lv_statement_0_0= ruleDocumentedStatement ) )+
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5699:1: ( (lv_statement_0_0= ruleDocumentedStatement ) )+
            int cnt87=0;
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( ((LA87_0>=RULE_ID && LA87_0<=RULE_SL_COMMENT)||(LA87_0>=17 && LA87_0<=18)||(LA87_0>=57 && LA87_0<=60)||LA87_0==64||(LA87_0>=67 && LA87_0<=69)||LA87_0==71||LA87_0==74||(LA87_0>=77 && LA87_0<=79)||(LA87_0>=81 && LA87_0<=84)) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5700:1: (lv_statement_0_0= ruleDocumentedStatement )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5700:1: (lv_statement_0_0= ruleDocumentedStatement )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5701:3: lv_statement_0_0= ruleDocumentedStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNonEmptyStatementSequenceAccess().getStatementDocumentedStatementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDocumentedStatement_in_ruleNonEmptyStatementSequence12370);
            	    lv_statement_0_0=ruleDocumentedStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNonEmptyStatementSequenceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statement",
            	            		lv_statement_0_0, 
            	            		"DocumentedStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt87 >= 1 ) break loop87;
                        EarlyExitException eee =
                            new EarlyExitException(87, input);
                        throw eee;
                }
                cnt87++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonEmptyStatementSequence"


    // $ANTLR start "entryRuleWhileStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5725:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5726:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5727:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement12406);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement12416); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5734:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_block_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5737:28: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5738:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5738:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5738:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,77,FOLLOW_77_in_ruleWhileStatement12453); 

                	newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleWhileStatement12465); 

                	newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5746:1: ( (lv_condition_2_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5747:1: (lv_condition_2_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5747:1: (lv_condition_2_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5748:3: lv_condition_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileStatement12486);
            lv_condition_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleWhileStatement12498); 

                	newLeafNode(otherlv_3, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5768:1: ( (lv_block_4_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5769:1: (lv_block_4_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5769:1: (lv_block_4_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5770:3: lv_block_4_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBlockBlockParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement12519);
            lv_block_4_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_4_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleDoStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5794:1: entryRuleDoStatement returns [EObject current=null] : iv_ruleDoStatement= ruleDoStatement EOF ;
    public final EObject entryRuleDoStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5795:2: (iv_ruleDoStatement= ruleDoStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5796:2: iv_ruleDoStatement= ruleDoStatement EOF
            {
             newCompositeNode(grammarAccess.getDoStatementRule()); 
            pushFollow(FOLLOW_ruleDoStatement_in_entryRuleDoStatement12555);
            iv_ruleDoStatement=ruleDoStatement();

            state._fsp--;

             current =iv_ruleDoStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoStatement12565); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoStatement"


    // $ANTLR start "ruleDoStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5803:1: ruleDoStatement returns [EObject current=null] : (otherlv_0= 'do' ( (lv_block_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleDoStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_block_1_0 = null;

        EObject lv_condition_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5806:28: ( (otherlv_0= 'do' ( (lv_block_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5807:1: (otherlv_0= 'do' ( (lv_block_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5807:1: (otherlv_0= 'do' ( (lv_block_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5807:3: otherlv_0= 'do' ( (lv_block_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_78_in_ruleDoStatement12602); 

                	newLeafNode(otherlv_0, grammarAccess.getDoStatementAccess().getDoKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5811:1: ( (lv_block_1_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5812:1: (lv_block_1_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5812:1: (lv_block_1_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5813:3: lv_block_1_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getDoStatementAccess().getBlockBlockParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleDoStatement12623);
            lv_block_1_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDoStatementRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_1_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,77,FOLLOW_77_in_ruleDoStatement12635); 

                	newLeafNode(otherlv_2, grammarAccess.getDoStatementAccess().getWhileKeyword_2());
                
            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleDoStatement12647); 

                	newLeafNode(otherlv_3, grammarAccess.getDoStatementAccess().getLeftParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5837:1: ( (lv_condition_4_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5838:1: (lv_condition_4_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5838:1: (lv_condition_4_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5839:3: lv_condition_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getDoStatementAccess().getConditionExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleDoStatement12668);
            lv_condition_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDoStatementRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleDoStatement12680); 

                	newLeafNode(otherlv_5, grammarAccess.getDoStatementAccess().getRightParenthesisKeyword_5());
                
            otherlv_6=(Token)match(input,68,FOLLOW_68_in_ruleDoStatement12692); 

                	newLeafNode(otherlv_6, grammarAccess.getDoStatementAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoStatement"


    // $ANTLR start "entryRuleForStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5871:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5872:2: (iv_ruleForStatement= ruleForStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5873:2: iv_ruleForStatement= ruleForStatement EOF
            {
             newCompositeNode(grammarAccess.getForStatementRule()); 
            pushFollow(FOLLOW_ruleForStatement_in_entryRuleForStatement12728);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;

             current =iv_ruleForStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForStatement12738); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5880:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_control_2_0= ruleForControl ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_control_2_0 = null;

        EObject lv_block_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5883:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_control_2_0= ruleForControl ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5884:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_control_2_0= ruleForControl ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5884:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_control_2_0= ruleForControl ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5884:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_control_2_0= ruleForControl ) ) otherlv_3= ')' ( (lv_block_4_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,79,FOLLOW_79_in_ruleForStatement12775); 

                	newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleForStatement12787); 

                	newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5892:1: ( (lv_control_2_0= ruleForControl ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5893:1: (lv_control_2_0= ruleForControl )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5893:1: (lv_control_2_0= ruleForControl )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5894:3: lv_control_2_0= ruleForControl
            {
             
            	        newCompositeNode(grammarAccess.getForStatementAccess().getControlForControlParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleForControl_in_ruleForStatement12808);
            lv_control_2_0=ruleForControl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForStatementRule());
            	        }
                   		set(
                   			current, 
                   			"control",
                    		lv_control_2_0, 
                    		"ForControl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleForStatement12820); 

                	newLeafNode(otherlv_3, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_3());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5914:1: ( (lv_block_4_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5915:1: (lv_block_4_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5915:1: (lv_block_4_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5916:3: lv_block_4_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getForStatementAccess().getBlockBlockParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleForStatement12841);
            lv_block_4_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForStatementRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_4_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleForControl"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5940:1: entryRuleForControl returns [EObject current=null] : iv_ruleForControl= ruleForControl EOF ;
    public final EObject entryRuleForControl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForControl = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5941:2: (iv_ruleForControl= ruleForControl EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5942:2: iv_ruleForControl= ruleForControl EOF
            {
             newCompositeNode(grammarAccess.getForControlRule()); 
            pushFollow(FOLLOW_ruleForControl_in_entryRuleForControl12877);
            iv_ruleForControl=ruleForControl();

            state._fsp--;

             current =iv_ruleForControl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForControl12887); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForControl"


    // $ANTLR start "ruleForControl"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5949:1: ruleForControl returns [EObject current=null] : ( ( (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition ) ) (otherlv_1= ',' ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) ) )* ) ;
    public final EObject ruleForControl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_loopVariableDefinition_0_0 = null;

        EObject lv_loopVariableDefinition_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5952:28: ( ( ( (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition ) ) (otherlv_1= ',' ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5953:1: ( ( (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition ) ) (otherlv_1= ',' ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5953:1: ( ( (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition ) ) (otherlv_1= ',' ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5953:2: ( (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition ) ) (otherlv_1= ',' ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5953:2: ( (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5954:1: (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5954:1: (lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5955:3: lv_loopVariableDefinition_0_0= ruleLoopVariableDefinition
            {
             
            	        newCompositeNode(grammarAccess.getForControlAccess().getLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleLoopVariableDefinition_in_ruleForControl12933);
            lv_loopVariableDefinition_0_0=ruleLoopVariableDefinition();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForControlRule());
            	        }
                   		add(
                   			current, 
                   			"loopVariableDefinition",
                    		lv_loopVariableDefinition_0_0, 
                    		"LoopVariableDefinition");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5971:2: (otherlv_1= ',' ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==21) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5971:4: otherlv_1= ',' ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) )
            	    {
            	    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleForControl12946); 

            	        	newLeafNode(otherlv_1, grammarAccess.getForControlAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5975:1: ( (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5976:1: (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5976:1: (lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:5977:3: lv_loopVariableDefinition_2_0= ruleLoopVariableDefinition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForControlAccess().getLoopVariableDefinitionLoopVariableDefinitionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLoopVariableDefinition_in_ruleForControl12967);
            	    lv_loopVariableDefinition_2_0=ruleLoopVariableDefinition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getForControlRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"loopVariableDefinition",
            	            		lv_loopVariableDefinition_2_0, 
            	            		"LoopVariableDefinition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForControl"


    // $ANTLR start "entryRuleLoopVariableDefinition"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6001:1: entryRuleLoopVariableDefinition returns [EObject current=null] : iv_ruleLoopVariableDefinition= ruleLoopVariableDefinition EOF ;
    public final EObject entryRuleLoopVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariableDefinition = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6002:2: (iv_ruleLoopVariableDefinition= ruleLoopVariableDefinition EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6003:2: iv_ruleLoopVariableDefinition= ruleLoopVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getLoopVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleLoopVariableDefinition_in_entryRuleLoopVariableDefinition13005);
            iv_ruleLoopVariableDefinition=ruleLoopVariableDefinition();

            state._fsp--;

             current =iv_ruleLoopVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoopVariableDefinition13015); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopVariableDefinition"


    // $ANTLR start "ruleLoopVariableDefinition"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6010:1: ruleLoopVariableDefinition returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_expression1_2_0= ruleExpression ) ) (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )? ) | ( ( (lv_type_5_0= ruleQualifiedNameWithBinding ) ) ( (lv_name_6_0= RULE_ID ) ) otherlv_7= ':' ( (lv_expression_8_0= ruleExpression ) ) ) ) ;
    public final EObject ruleLoopVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_name_6_0=null;
        Token otherlv_7=null;
        EObject lv_expression1_2_0 = null;

        EObject lv_expression2_4_0 = null;

        EObject lv_type_5_0 = null;

        EObject lv_expression_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6013:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_expression1_2_0= ruleExpression ) ) (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )? ) | ( ( (lv_type_5_0= ruleQualifiedNameWithBinding ) ) ( (lv_name_6_0= RULE_ID ) ) otherlv_7= ':' ( (lv_expression_8_0= ruleExpression ) ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6014:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_expression1_2_0= ruleExpression ) ) (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )? ) | ( ( (lv_type_5_0= ruleQualifiedNameWithBinding ) ) ( (lv_name_6_0= RULE_ID ) ) otherlv_7= ':' ( (lv_expression_8_0= ruleExpression ) ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6014:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_expression1_2_0= ruleExpression ) ) (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )? ) | ( ( (lv_type_5_0= ruleQualifiedNameWithBinding ) ) ( (lv_name_6_0= RULE_ID ) ) otherlv_7= ':' ( (lv_expression_8_0= ruleExpression ) ) ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ID) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==RULE_ID||(LA90_1>=19 && LA90_1<=20)) ) {
                    alt90=2;
                }
                else if ( (LA90_1==80) ) {
                    alt90=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6014:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_expression1_2_0= ruleExpression ) ) (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )? )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6014:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_expression1_2_0= ruleExpression ) ) (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )? )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6014:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_expression1_2_0= ruleExpression ) ) (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )?
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6014:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6015:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6015:1: (lv_name_0_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6016:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoopVariableDefinition13058); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getLoopVariableDefinitionAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLoopVariableDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,80,FOLLOW_80_in_ruleLoopVariableDefinition13075); 

                        	newLeafNode(otherlv_1, grammarAccess.getLoopVariableDefinitionAccess().getInKeyword_0_1());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6036:1: ( (lv_expression1_2_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6037:1: (lv_expression1_2_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6037:1: (lv_expression1_2_0= ruleExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6038:3: lv_expression1_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getExpression1ExpressionParserRuleCall_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleLoopVariableDefinition13096);
                    lv_expression1_2_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression1",
                            		lv_expression1_2_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6054:2: (otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==61) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6054:4: otherlv_3= '..' ( (lv_expression2_4_0= ruleExpression ) )
                            {
                            otherlv_3=(Token)match(input,61,FOLLOW_61_in_ruleLoopVariableDefinition13109); 

                                	newLeafNode(otherlv_3, grammarAccess.getLoopVariableDefinitionAccess().getFullStopFullStopKeyword_0_3_0());
                                
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6058:1: ( (lv_expression2_4_0= ruleExpression ) )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6059:1: (lv_expression2_4_0= ruleExpression )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6059:1: (lv_expression2_4_0= ruleExpression )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6060:3: lv_expression2_4_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getExpression2ExpressionParserRuleCall_0_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleLoopVariableDefinition13130);
                            lv_expression2_4_0=ruleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"expression2",
                                    		lv_expression2_4_0, 
                                    		"Expression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6077:6: ( ( (lv_type_5_0= ruleQualifiedNameWithBinding ) ) ( (lv_name_6_0= RULE_ID ) ) otherlv_7= ':' ( (lv_expression_8_0= ruleExpression ) ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6077:6: ( ( (lv_type_5_0= ruleQualifiedNameWithBinding ) ) ( (lv_name_6_0= RULE_ID ) ) otherlv_7= ':' ( (lv_expression_8_0= ruleExpression ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6077:7: ( (lv_type_5_0= ruleQualifiedNameWithBinding ) ) ( (lv_name_6_0= RULE_ID ) ) otherlv_7= ':' ( (lv_expression_8_0= ruleExpression ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6077:7: ( (lv_type_5_0= ruleQualifiedNameWithBinding ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6078:1: (lv_type_5_0= ruleQualifiedNameWithBinding )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6078:1: (lv_type_5_0= ruleQualifiedNameWithBinding )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6079:3: lv_type_5_0= ruleQualifiedNameWithBinding
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getTypeQualifiedNameWithBindingParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleLoopVariableDefinition13161);
                    lv_type_5_0=ruleQualifiedNameWithBinding();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_5_0, 
                            		"QualifiedNameWithBinding");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6095:2: ( (lv_name_6_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6096:1: (lv_name_6_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6096:1: (lv_name_6_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6097:3: lv_name_6_0= RULE_ID
                    {
                    lv_name_6_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLoopVariableDefinition13178); 

                    			newLeafNode(lv_name_6_0, grammarAccess.getLoopVariableDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLoopVariableDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_6_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,27,FOLLOW_27_in_ruleLoopVariableDefinition13195); 

                        	newLeafNode(otherlv_7, grammarAccess.getLoopVariableDefinitionAccess().getColonKeyword_1_2());
                        
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6117:1: ( (lv_expression_8_0= ruleExpression ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6118:1: (lv_expression_8_0= ruleExpression )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6118:1: (lv_expression_8_0= ruleExpression )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6119:3: lv_expression_8_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getExpressionExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleLoopVariableDefinition13216);
                    lv_expression_8_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_8_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopVariableDefinition"


    // $ANTLR start "entryRuleBreakStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6143:1: entryRuleBreakStatement returns [EObject current=null] : iv_ruleBreakStatement= ruleBreakStatement EOF ;
    public final EObject entryRuleBreakStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6144:2: (iv_ruleBreakStatement= ruleBreakStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6145:2: iv_ruleBreakStatement= ruleBreakStatement EOF
            {
             newCompositeNode(grammarAccess.getBreakStatementRule()); 
            pushFollow(FOLLOW_ruleBreakStatement_in_entryRuleBreakStatement13253);
            iv_ruleBreakStatement=ruleBreakStatement();

            state._fsp--;

             current =iv_ruleBreakStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBreakStatement13263); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreakStatement"


    // $ANTLR start "ruleBreakStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6152:1: ruleBreakStatement returns [EObject current=null] : ( () otherlv_1= 'break' otherlv_2= ';' ) ;
    public final EObject ruleBreakStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6155:28: ( ( () otherlv_1= 'break' otherlv_2= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6156:1: ( () otherlv_1= 'break' otherlv_2= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6156:1: ( () otherlv_1= 'break' otherlv_2= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6156:2: () otherlv_1= 'break' otherlv_2= ';'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6156:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6157:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBreakStatementAccess().getBreakStatementAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,81,FOLLOW_81_in_ruleBreakStatement13309); 

                	newLeafNode(otherlv_1, grammarAccess.getBreakStatementAccess().getBreakKeyword_1());
                
            otherlv_2=(Token)match(input,68,FOLLOW_68_in_ruleBreakStatement13321); 

                	newLeafNode(otherlv_2, grammarAccess.getBreakStatementAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreakStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6178:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6179:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6180:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             newCompositeNode(grammarAccess.getReturnStatementRule()); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement13357);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement13367); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturnStatement"


    // $ANTLR start "ruleReturnStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6187:1: ruleReturnStatement returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6190:28: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6191:1: (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6191:1: (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6191:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleReturnStatement13404); 

                	newLeafNode(otherlv_0, grammarAccess.getReturnStatementAccess().getReturnKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6195:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6196:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6196:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6197:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement13425);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReturnStatementRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,68,FOLLOW_68_in_ruleReturnStatement13437); 

                	newLeafNode(otherlv_2, grammarAccess.getReturnStatementAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleAcceptStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6225:1: entryRuleAcceptStatement returns [EObject current=null] : iv_ruleAcceptStatement= ruleAcceptStatement EOF ;
    public final EObject entryRuleAcceptStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAcceptStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6226:2: (iv_ruleAcceptStatement= ruleAcceptStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6227:2: iv_ruleAcceptStatement= ruleAcceptStatement EOF
            {
             newCompositeNode(grammarAccess.getAcceptStatementRule()); 
            pushFollow(FOLLOW_ruleAcceptStatement_in_entryRuleAcceptStatement13473);
            iv_ruleAcceptStatement=ruleAcceptStatement();

            state._fsp--;

             current =iv_ruleAcceptStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAcceptStatement13483); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAcceptStatement"


    // $ANTLR start "ruleAcceptStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6234:1: ruleAcceptStatement returns [EObject current=null] : ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) ) | ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) ) ) ) ;
    public final EObject ruleAcceptStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_clause_0_0 = null;

        EObject lv_simpleAccept_1_0 = null;

        EObject lv_compoundAccept_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6237:28: ( ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) ) | ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6238:1: ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) ) | ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6238:1: ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) ) | ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6238:2: ( (lv_clause_0_0= ruleAcceptClause ) ) ( ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) ) | ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6238:2: ( (lv_clause_0_0= ruleAcceptClause ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6239:1: (lv_clause_0_0= ruleAcceptClause )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6239:1: (lv_clause_0_0= ruleAcceptClause )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6240:3: lv_clause_0_0= ruleAcceptClause
            {
             
            	        newCompositeNode(grammarAccess.getAcceptStatementAccess().getClauseAcceptClauseParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAcceptClause_in_ruleAcceptStatement13529);
            lv_clause_0_0=ruleAcceptClause();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAcceptStatementRule());
            	        }
                   		set(
                   			current, 
                   			"clause",
                    		lv_clause_0_0, 
                    		"AcceptClause");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6256:2: ( ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) ) | ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==68) ) {
                alt91=1;
            }
            else if ( (LA91_0==60) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6256:3: ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6256:3: ( (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6257:1: (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6257:1: (lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6258:3: lv_simpleAccept_1_0= ruleSimpleAcceptStatementCompletion
                    {
                     
                    	        newCompositeNode(grammarAccess.getAcceptStatementAccess().getSimpleAcceptSimpleAcceptStatementCompletionParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSimpleAcceptStatementCompletion_in_ruleAcceptStatement13551);
                    lv_simpleAccept_1_0=ruleSimpleAcceptStatementCompletion();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAcceptStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"simpleAccept",
                            		lv_simpleAccept_1_0, 
                            		"SimpleAcceptStatementCompletion");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6275:6: ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6275:6: ( (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6276:1: (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6276:1: (lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6277:3: lv_compoundAccept_2_0= ruleCompoundAcceptStatementCompletion
                    {
                     
                    	        newCompositeNode(grammarAccess.getAcceptStatementAccess().getCompoundAcceptCompoundAcceptStatementCompletionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCompoundAcceptStatementCompletion_in_ruleAcceptStatement13578);
                    lv_compoundAccept_2_0=ruleCompoundAcceptStatementCompletion();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAcceptStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"compoundAccept",
                            		lv_compoundAccept_2_0, 
                            		"CompoundAcceptStatementCompletion");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAcceptStatement"


    // $ANTLR start "entryRuleSimpleAcceptStatementCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6301:1: entryRuleSimpleAcceptStatementCompletion returns [EObject current=null] : iv_ruleSimpleAcceptStatementCompletion= ruleSimpleAcceptStatementCompletion EOF ;
    public final EObject entryRuleSimpleAcceptStatementCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleAcceptStatementCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6302:2: (iv_ruleSimpleAcceptStatementCompletion= ruleSimpleAcceptStatementCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6303:2: iv_ruleSimpleAcceptStatementCompletion= ruleSimpleAcceptStatementCompletion EOF
            {
             newCompositeNode(grammarAccess.getSimpleAcceptStatementCompletionRule()); 
            pushFollow(FOLLOW_ruleSimpleAcceptStatementCompletion_in_entryRuleSimpleAcceptStatementCompletion13615);
            iv_ruleSimpleAcceptStatementCompletion=ruleSimpleAcceptStatementCompletion();

            state._fsp--;

             current =iv_ruleSimpleAcceptStatementCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleAcceptStatementCompletion13625); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleAcceptStatementCompletion"


    // $ANTLR start "ruleSimpleAcceptStatementCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6310:1: ruleSimpleAcceptStatementCompletion returns [EObject current=null] : ( () otherlv_1= ';' ) ;
    public final EObject ruleSimpleAcceptStatementCompletion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6313:28: ( ( () otherlv_1= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6314:1: ( () otherlv_1= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6314:1: ( () otherlv_1= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6314:2: () otherlv_1= ';'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6314:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6315:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleAcceptStatementCompletionAccess().getSimpleAcceptStatementCompletionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleSimpleAcceptStatementCompletion13671); 

                	newLeafNode(otherlv_1, grammarAccess.getSimpleAcceptStatementCompletionAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleAcceptStatementCompletion"


    // $ANTLR start "entryRuleCompoundAcceptStatementCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6332:1: entryRuleCompoundAcceptStatementCompletion returns [EObject current=null] : iv_ruleCompoundAcceptStatementCompletion= ruleCompoundAcceptStatementCompletion EOF ;
    public final EObject entryRuleCompoundAcceptStatementCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundAcceptStatementCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6333:2: (iv_ruleCompoundAcceptStatementCompletion= ruleCompoundAcceptStatementCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6334:2: iv_ruleCompoundAcceptStatementCompletion= ruleCompoundAcceptStatementCompletion EOF
            {
             newCompositeNode(grammarAccess.getCompoundAcceptStatementCompletionRule()); 
            pushFollow(FOLLOW_ruleCompoundAcceptStatementCompletion_in_entryRuleCompoundAcceptStatementCompletion13707);
            iv_ruleCompoundAcceptStatementCompletion=ruleCompoundAcceptStatementCompletion();

            state._fsp--;

             current =iv_ruleCompoundAcceptStatementCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompoundAcceptStatementCompletion13717); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompoundAcceptStatementCompletion"


    // $ANTLR start "ruleCompoundAcceptStatementCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6341:1: ruleCompoundAcceptStatementCompletion returns [EObject current=null] : ( ( (lv_block_0_0= ruleBlock ) ) (otherlv_1= 'or' ( (lv_acceptBlock_2_0= ruleAcceptBlock ) ) )* ) ;
    public final EObject ruleCompoundAcceptStatementCompletion() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_block_0_0 = null;

        EObject lv_acceptBlock_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6344:28: ( ( ( (lv_block_0_0= ruleBlock ) ) (otherlv_1= 'or' ( (lv_acceptBlock_2_0= ruleAcceptBlock ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6345:1: ( ( (lv_block_0_0= ruleBlock ) ) (otherlv_1= 'or' ( (lv_acceptBlock_2_0= ruleAcceptBlock ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6345:1: ( ( (lv_block_0_0= ruleBlock ) ) (otherlv_1= 'or' ( (lv_acceptBlock_2_0= ruleAcceptBlock ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6345:2: ( (lv_block_0_0= ruleBlock ) ) (otherlv_1= 'or' ( (lv_acceptBlock_2_0= ruleAcceptBlock ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6345:2: ( (lv_block_0_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6346:1: (lv_block_0_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6346:1: (lv_block_0_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6347:3: lv_block_0_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getCompoundAcceptStatementCompletionAccess().getBlockBlockParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleCompoundAcceptStatementCompletion13763);
            lv_block_0_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompoundAcceptStatementCompletionRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_0_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6363:2: (otherlv_1= 'or' ( (lv_acceptBlock_2_0= ruleAcceptBlock ) ) )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==73) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6363:4: otherlv_1= 'or' ( (lv_acceptBlock_2_0= ruleAcceptBlock ) )
            	    {
            	    otherlv_1=(Token)match(input,73,FOLLOW_73_in_ruleCompoundAcceptStatementCompletion13776); 

            	        	newLeafNode(otherlv_1, grammarAccess.getCompoundAcceptStatementCompletionAccess().getOrKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6367:1: ( (lv_acceptBlock_2_0= ruleAcceptBlock ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6368:1: (lv_acceptBlock_2_0= ruleAcceptBlock )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6368:1: (lv_acceptBlock_2_0= ruleAcceptBlock )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6369:3: lv_acceptBlock_2_0= ruleAcceptBlock
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompoundAcceptStatementCompletionAccess().getAcceptBlockAcceptBlockParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAcceptBlock_in_ruleCompoundAcceptStatementCompletion13797);
            	    lv_acceptBlock_2_0=ruleAcceptBlock();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompoundAcceptStatementCompletionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"acceptBlock",
            	            		lv_acceptBlock_2_0, 
            	            		"AcceptBlock");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompoundAcceptStatementCompletion"


    // $ANTLR start "entryRuleAcceptBlock"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6393:1: entryRuleAcceptBlock returns [EObject current=null] : iv_ruleAcceptBlock= ruleAcceptBlock EOF ;
    public final EObject entryRuleAcceptBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAcceptBlock = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6394:2: (iv_ruleAcceptBlock= ruleAcceptBlock EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6395:2: iv_ruleAcceptBlock= ruleAcceptBlock EOF
            {
             newCompositeNode(grammarAccess.getAcceptBlockRule()); 
            pushFollow(FOLLOW_ruleAcceptBlock_in_entryRuleAcceptBlock13835);
            iv_ruleAcceptBlock=ruleAcceptBlock();

            state._fsp--;

             current =iv_ruleAcceptBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAcceptBlock13845); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAcceptBlock"


    // $ANTLR start "ruleAcceptBlock"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6402:1: ruleAcceptBlock returns [EObject current=null] : ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( (lv_block_1_0= ruleBlock ) ) ) ;
    public final EObject ruleAcceptBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_clause_0_0 = null;

        EObject lv_block_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6405:28: ( ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( (lv_block_1_0= ruleBlock ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6406:1: ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( (lv_block_1_0= ruleBlock ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6406:1: ( ( (lv_clause_0_0= ruleAcceptClause ) ) ( (lv_block_1_0= ruleBlock ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6406:2: ( (lv_clause_0_0= ruleAcceptClause ) ) ( (lv_block_1_0= ruleBlock ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6406:2: ( (lv_clause_0_0= ruleAcceptClause ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6407:1: (lv_clause_0_0= ruleAcceptClause )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6407:1: (lv_clause_0_0= ruleAcceptClause )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6408:3: lv_clause_0_0= ruleAcceptClause
            {
             
            	        newCompositeNode(grammarAccess.getAcceptBlockAccess().getClauseAcceptClauseParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAcceptClause_in_ruleAcceptBlock13891);
            lv_clause_0_0=ruleAcceptClause();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAcceptBlockRule());
            	        }
                   		set(
                   			current, 
                   			"clause",
                    		lv_clause_0_0, 
                    		"AcceptClause");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6424:2: ( (lv_block_1_0= ruleBlock ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6425:1: (lv_block_1_0= ruleBlock )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6425:1: (lv_block_1_0= ruleBlock )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6426:3: lv_block_1_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getAcceptBlockAccess().getBlockBlockParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleAcceptBlock13912);
            lv_block_1_0=ruleBlock();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAcceptBlockRule());
            	        }
                   		set(
                   			current, 
                   			"block",
                    		lv_block_1_0, 
                    		"Block");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAcceptBlock"


    // $ANTLR start "entryRuleAcceptClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6450:1: entryRuleAcceptClause returns [EObject current=null] : iv_ruleAcceptClause= ruleAcceptClause EOF ;
    public final EObject entryRuleAcceptClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAcceptClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6451:2: (iv_ruleAcceptClause= ruleAcceptClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6452:2: iv_ruleAcceptClause= ruleAcceptClause EOF
            {
             newCompositeNode(grammarAccess.getAcceptClauseRule()); 
            pushFollow(FOLLOW_ruleAcceptClause_in_entryRuleAcceptClause13948);
            iv_ruleAcceptClause=ruleAcceptClause();

            state._fsp--;

             current =iv_ruleAcceptClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAcceptClause13958); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAcceptClause"


    // $ANTLR start "ruleAcceptClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6459:1: ruleAcceptClause returns [EObject current=null] : (otherlv_0= 'accept' otherlv_1= '(' ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_qualifiedNameList_4_0= ruleQualifiedNameList ) ) otherlv_5= ')' ) ;
    public final EObject ruleAcceptClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_qualifiedNameList_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6462:28: ( (otherlv_0= 'accept' otherlv_1= '(' ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_qualifiedNameList_4_0= ruleQualifiedNameList ) ) otherlv_5= ')' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6463:1: (otherlv_0= 'accept' otherlv_1= '(' ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_qualifiedNameList_4_0= ruleQualifiedNameList ) ) otherlv_5= ')' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6463:1: (otherlv_0= 'accept' otherlv_1= '(' ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_qualifiedNameList_4_0= ruleQualifiedNameList ) ) otherlv_5= ')' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6463:3: otherlv_0= 'accept' otherlv_1= '(' ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )? ( (lv_qualifiedNameList_4_0= ruleQualifiedNameList ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_83_in_ruleAcceptClause13995); 

                	newLeafNode(otherlv_0, grammarAccess.getAcceptClauseAccess().getAcceptKeyword_0());
                
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleAcceptClause14007); 

                	newLeafNode(otherlv_1, grammarAccess.getAcceptClauseAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6471:1: ( ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==RULE_ID) ) {
                int LA93_1 = input.LA(2);

                if ( (LA93_1==27) ) {
                    alt93=1;
                }
            }
            switch (alt93) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6471:2: ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':'
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6471:2: ( (lv_name_2_0= RULE_ID ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6472:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6472:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6473:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAcceptClause14025); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getAcceptClauseAccess().getNameIDTerminalRuleCall_2_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAcceptClauseRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleAcceptClause14042); 

                        	newLeafNode(otherlv_3, grammarAccess.getAcceptClauseAccess().getColonKeyword_2_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6493:3: ( (lv_qualifiedNameList_4_0= ruleQualifiedNameList ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6494:1: (lv_qualifiedNameList_4_0= ruleQualifiedNameList )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6494:1: (lv_qualifiedNameList_4_0= ruleQualifiedNameList )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6495:3: lv_qualifiedNameList_4_0= ruleQualifiedNameList
            {
             
            	        newCompositeNode(grammarAccess.getAcceptClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameList_in_ruleAcceptClause14065);
            lv_qualifiedNameList_4_0=ruleQualifiedNameList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAcceptClauseRule());
            	        }
                   		set(
                   			current, 
                   			"qualifiedNameList",
                    		lv_qualifiedNameList_4_0, 
                    		"QualifiedNameList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleAcceptClause14077); 

                	newLeafNode(otherlv_5, grammarAccess.getAcceptClauseAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAcceptClause"


    // $ANTLR start "entryRuleClassifyStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6523:1: entryRuleClassifyStatement returns [EObject current=null] : iv_ruleClassifyStatement= ruleClassifyStatement EOF ;
    public final EObject entryRuleClassifyStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifyStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6524:2: (iv_ruleClassifyStatement= ruleClassifyStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6525:2: iv_ruleClassifyStatement= ruleClassifyStatement EOF
            {
             newCompositeNode(grammarAccess.getClassifyStatementRule()); 
            pushFollow(FOLLOW_ruleClassifyStatement_in_entryRuleClassifyStatement14113);
            iv_ruleClassifyStatement=ruleClassifyStatement();

            state._fsp--;

             current =iv_ruleClassifyStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassifyStatement14123); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassifyStatement"


    // $ANTLR start "ruleClassifyStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6532:1: ruleClassifyStatement returns [EObject current=null] : (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( (lv_clause_2_0= ruleClassificationClause ) ) otherlv_3= ';' ) ;
    public final EObject ruleClassifyStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_expression_1_0 = null;

        EObject lv_clause_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6535:28: ( (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( (lv_clause_2_0= ruleClassificationClause ) ) otherlv_3= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6536:1: (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( (lv_clause_2_0= ruleClassificationClause ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6536:1: (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( (lv_clause_2_0= ruleClassificationClause ) ) otherlv_3= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6536:3: otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( (lv_clause_2_0= ruleClassificationClause ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleClassifyStatement14160); 

                	newLeafNode(otherlv_0, grammarAccess.getClassifyStatementAccess().getClassifyKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6540:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6541:1: (lv_expression_1_0= ruleExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6541:1: (lv_expression_1_0= ruleExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6542:3: lv_expression_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getClassifyStatementAccess().getExpressionExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleClassifyStatement14181);
            lv_expression_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassifyStatementRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6558:2: ( (lv_clause_2_0= ruleClassificationClause ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6559:1: (lv_clause_2_0= ruleClassificationClause )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6559:1: (lv_clause_2_0= ruleClassificationClause )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6560:3: lv_clause_2_0= ruleClassificationClause
            {
             
            	        newCompositeNode(grammarAccess.getClassifyStatementAccess().getClauseClassificationClauseParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleClassificationClause_in_ruleClassifyStatement14202);
            lv_clause_2_0=ruleClassificationClause();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassifyStatementRule());
            	        }
                   		set(
                   			current, 
                   			"clause",
                    		lv_clause_2_0, 
                    		"ClassificationClause");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,68,FOLLOW_68_in_ruleClassifyStatement14214); 

                	newLeafNode(otherlv_3, grammarAccess.getClassifyStatementAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassifyStatement"


    // $ANTLR start "entryRuleClassificationClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6588:1: entryRuleClassificationClause returns [EObject current=null] : iv_ruleClassificationClause= ruleClassificationClause EOF ;
    public final EObject entryRuleClassificationClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassificationClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6589:2: (iv_ruleClassificationClause= ruleClassificationClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6590:2: iv_ruleClassificationClause= ruleClassificationClause EOF
            {
             newCompositeNode(grammarAccess.getClassificationClauseRule()); 
            pushFollow(FOLLOW_ruleClassificationClause_in_entryRuleClassificationClause14250);
            iv_ruleClassificationClause=ruleClassificationClause();

            state._fsp--;

             current =iv_ruleClassificationClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassificationClause14260); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassificationClause"


    // $ANTLR start "ruleClassificationClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6597:1: ruleClassificationClause returns [EObject current=null] : ( ( ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) ) ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )? ) | ( ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )? ( (lv_classifyToClause_3_0= ruleClassificationToClause ) ) ) ) ;
    public final EObject ruleClassificationClause() throws RecognitionException {
        EObject current = null;

        EObject lv_classifyFromClause_0_0 = null;

        EObject lv_classifyToClause_1_0 = null;

        EObject lv_reclassyAllClause_2_0 = null;

        EObject lv_classifyToClause_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6600:28: ( ( ( ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) ) ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )? ) | ( ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )? ( (lv_classifyToClause_3_0= ruleClassificationToClause ) ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6601:1: ( ( ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) ) ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )? ) | ( ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )? ( (lv_classifyToClause_3_0= ruleClassificationToClause ) ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6601:1: ( ( ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) ) ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )? ) | ( ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )? ( (lv_classifyToClause_3_0= ruleClassificationToClause ) ) ) )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==85) ) {
                int LA96_1 = input.LA(2);

                if ( (LA96_1==RULE_ID) ) {
                    alt96=1;
                }
                else if ( (LA96_1==16) ) {
                    alt96=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA96_0==86) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6601:2: ( ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) ) ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )? )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6601:2: ( ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) ) ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )? )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6601:3: ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) ) ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )?
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6601:3: ( (lv_classifyFromClause_0_0= ruleClassificationFromClause ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6602:1: (lv_classifyFromClause_0_0= ruleClassificationFromClause )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6602:1: (lv_classifyFromClause_0_0= ruleClassificationFromClause )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6603:3: lv_classifyFromClause_0_0= ruleClassificationFromClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getClassificationClauseAccess().getClassifyFromClauseClassificationFromClauseParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassificationFromClause_in_ruleClassificationClause14307);
                    lv_classifyFromClause_0_0=ruleClassificationFromClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClassificationClauseRule());
                    	        }
                           		set(
                           			current, 
                           			"classifyFromClause",
                            		lv_classifyFromClause_0_0, 
                            		"ClassificationFromClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6619:2: ( (lv_classifyToClause_1_0= ruleClassificationToClause ) )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==86) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6620:1: (lv_classifyToClause_1_0= ruleClassificationToClause )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6620:1: (lv_classifyToClause_1_0= ruleClassificationToClause )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6621:3: lv_classifyToClause_1_0= ruleClassificationToClause
                            {
                             
                            	        newCompositeNode(grammarAccess.getClassificationClauseAccess().getClassifyToClauseClassificationToClauseParserRuleCall_0_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleClassificationToClause_in_ruleClassificationClause14328);
                            lv_classifyToClause_1_0=ruleClassificationToClause();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getClassificationClauseRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"classifyToClause",
                                    		lv_classifyToClause_1_0, 
                                    		"ClassificationToClause");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6638:6: ( ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )? ( (lv_classifyToClause_3_0= ruleClassificationToClause ) ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6638:6: ( ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )? ( (lv_classifyToClause_3_0= ruleClassificationToClause ) ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6638:7: ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )? ( (lv_classifyToClause_3_0= ruleClassificationToClause ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6638:7: ( (lv_reclassyAllClause_2_0= ruleReclassifyAllClause ) )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==85) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6639:1: (lv_reclassyAllClause_2_0= ruleReclassifyAllClause )
                            {
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6639:1: (lv_reclassyAllClause_2_0= ruleReclassifyAllClause )
                            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6640:3: lv_reclassyAllClause_2_0= ruleReclassifyAllClause
                            {
                             
                            	        newCompositeNode(grammarAccess.getClassificationClauseAccess().getReclassyAllClauseReclassifyAllClauseParserRuleCall_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleReclassifyAllClause_in_ruleClassificationClause14358);
                            lv_reclassyAllClause_2_0=ruleReclassifyAllClause();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getClassificationClauseRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"reclassyAllClause",
                                    		lv_reclassyAllClause_2_0, 
                                    		"ReclassifyAllClause");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6656:3: ( (lv_classifyToClause_3_0= ruleClassificationToClause ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6657:1: (lv_classifyToClause_3_0= ruleClassificationToClause )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6657:1: (lv_classifyToClause_3_0= ruleClassificationToClause )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6658:3: lv_classifyToClause_3_0= ruleClassificationToClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getClassificationClauseAccess().getClassifyToClauseClassificationToClauseParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassificationToClause_in_ruleClassificationClause14380);
                    lv_classifyToClause_3_0=ruleClassificationToClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClassificationClauseRule());
                    	        }
                           		set(
                           			current, 
                           			"classifyToClause",
                            		lv_classifyToClause_3_0, 
                            		"ClassificationToClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationClause"


    // $ANTLR start "entryRuleClassificationFromClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6682:1: entryRuleClassificationFromClause returns [EObject current=null] : iv_ruleClassificationFromClause= ruleClassificationFromClause EOF ;
    public final EObject entryRuleClassificationFromClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassificationFromClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6683:2: (iv_ruleClassificationFromClause= ruleClassificationFromClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6684:2: iv_ruleClassificationFromClause= ruleClassificationFromClause EOF
            {
             newCompositeNode(grammarAccess.getClassificationFromClauseRule()); 
            pushFollow(FOLLOW_ruleClassificationFromClause_in_entryRuleClassificationFromClause14417);
            iv_ruleClassificationFromClause=ruleClassificationFromClause();

            state._fsp--;

             current =iv_ruleClassificationFromClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassificationFromClause14427); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassificationFromClause"


    // $ANTLR start "ruleClassificationFromClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6691:1: ruleClassificationFromClause returns [EObject current=null] : (otherlv_0= 'from' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) ) ;
    public final EObject ruleClassificationFromClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_qualifiedNameList_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6694:28: ( (otherlv_0= 'from' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6695:1: (otherlv_0= 'from' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6695:1: (otherlv_0= 'from' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6695:3: otherlv_0= 'from' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) )
            {
            otherlv_0=(Token)match(input,85,FOLLOW_85_in_ruleClassificationFromClause14464); 

                	newLeafNode(otherlv_0, grammarAccess.getClassificationFromClauseAccess().getFromKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6699:1: ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6700:1: (lv_qualifiedNameList_1_0= ruleQualifiedNameList )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6700:1: (lv_qualifiedNameList_1_0= ruleQualifiedNameList )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6701:3: lv_qualifiedNameList_1_0= ruleQualifiedNameList
            {
             
            	        newCompositeNode(grammarAccess.getClassificationFromClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameList_in_ruleClassificationFromClause14485);
            lv_qualifiedNameList_1_0=ruleQualifiedNameList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassificationFromClauseRule());
            	        }
                   		set(
                   			current, 
                   			"qualifiedNameList",
                    		lv_qualifiedNameList_1_0, 
                    		"QualifiedNameList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationFromClause"


    // $ANTLR start "entryRuleClassificationToClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6725:1: entryRuleClassificationToClause returns [EObject current=null] : iv_ruleClassificationToClause= ruleClassificationToClause EOF ;
    public final EObject entryRuleClassificationToClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassificationToClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6726:2: (iv_ruleClassificationToClause= ruleClassificationToClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6727:2: iv_ruleClassificationToClause= ruleClassificationToClause EOF
            {
             newCompositeNode(grammarAccess.getClassificationToClauseRule()); 
            pushFollow(FOLLOW_ruleClassificationToClause_in_entryRuleClassificationToClause14521);
            iv_ruleClassificationToClause=ruleClassificationToClause();

            state._fsp--;

             current =iv_ruleClassificationToClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassificationToClause14531); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassificationToClause"


    // $ANTLR start "ruleClassificationToClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6734:1: ruleClassificationToClause returns [EObject current=null] : (otherlv_0= 'to' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) ) ;
    public final EObject ruleClassificationToClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_qualifiedNameList_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6737:28: ( (otherlv_0= 'to' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6738:1: (otherlv_0= 'to' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6738:1: (otherlv_0= 'to' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6738:3: otherlv_0= 'to' ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) )
            {
            otherlv_0=(Token)match(input,86,FOLLOW_86_in_ruleClassificationToClause14568); 

                	newLeafNode(otherlv_0, grammarAccess.getClassificationToClauseAccess().getToKeyword_0());
                
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6742:1: ( (lv_qualifiedNameList_1_0= ruleQualifiedNameList ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6743:1: (lv_qualifiedNameList_1_0= ruleQualifiedNameList )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6743:1: (lv_qualifiedNameList_1_0= ruleQualifiedNameList )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6744:3: lv_qualifiedNameList_1_0= ruleQualifiedNameList
            {
             
            	        newCompositeNode(grammarAccess.getClassificationToClauseAccess().getQualifiedNameListQualifiedNameListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameList_in_ruleClassificationToClause14589);
            lv_qualifiedNameList_1_0=ruleQualifiedNameList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassificationToClauseRule());
            	        }
                   		set(
                   			current, 
                   			"qualifiedNameList",
                    		lv_qualifiedNameList_1_0, 
                    		"QualifiedNameList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationToClause"


    // $ANTLR start "entryRuleReclassifyAllClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6768:1: entryRuleReclassifyAllClause returns [EObject current=null] : iv_ruleReclassifyAllClause= ruleReclassifyAllClause EOF ;
    public final EObject entryRuleReclassifyAllClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReclassifyAllClause = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6769:2: (iv_ruleReclassifyAllClause= ruleReclassifyAllClause EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6770:2: iv_ruleReclassifyAllClause= ruleReclassifyAllClause EOF
            {
             newCompositeNode(grammarAccess.getReclassifyAllClauseRule()); 
            pushFollow(FOLLOW_ruleReclassifyAllClause_in_entryRuleReclassifyAllClause14625);
            iv_ruleReclassifyAllClause=ruleReclassifyAllClause();

            state._fsp--;

             current =iv_ruleReclassifyAllClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReclassifyAllClause14635); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReclassifyAllClause"


    // $ANTLR start "ruleReclassifyAllClause"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6777:1: ruleReclassifyAllClause returns [EObject current=null] : ( () otherlv_1= 'from' otherlv_2= '*' ) ;
    public final EObject ruleReclassifyAllClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6780:28: ( ( () otherlv_1= 'from' otherlv_2= '*' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6781:1: ( () otherlv_1= 'from' otherlv_2= '*' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6781:1: ( () otherlv_1= 'from' otherlv_2= '*' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6781:2: () otherlv_1= 'from' otherlv_2= '*'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6781:2: ()
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6782:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReclassifyAllClauseAccess().getReclassifyAllClauseAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,85,FOLLOW_85_in_ruleReclassifyAllClause14681); 

                	newLeafNode(otherlv_1, grammarAccess.getReclassifyAllClauseAccess().getFromKeyword_1());
                
            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleReclassifyAllClause14693); 

                	newLeafNode(otherlv_2, grammarAccess.getReclassifyAllClauseAccess().getAsteriskKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReclassifyAllClause"


    // $ANTLR start "entryRuleQualifiedNameList"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6803:1: entryRuleQualifiedNameList returns [EObject current=null] : iv_ruleQualifiedNameList= ruleQualifiedNameList EOF ;
    public final EObject entryRuleQualifiedNameList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedNameList = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6804:2: (iv_ruleQualifiedNameList= ruleQualifiedNameList EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6805:2: iv_ruleQualifiedNameList= ruleQualifiedNameList EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameListRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameList_in_entryRuleQualifiedNameList14729);
            iv_ruleQualifiedNameList=ruleQualifiedNameList();

            state._fsp--;

             current =iv_ruleQualifiedNameList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameList14739); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameList"


    // $ANTLR start "ruleQualifiedNameList"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6812:1: ruleQualifiedNameList returns [EObject current=null] : ( ( (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding ) ) (otherlv_1= ',' ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) ) )* ) ;
    public final EObject ruleQualifiedNameList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_qualifiedName_0_0 = null;

        EObject lv_qualifiedName_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6815:28: ( ( ( (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding ) ) (otherlv_1= ',' ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) ) )* ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6816:1: ( ( (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding ) ) (otherlv_1= ',' ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) ) )* )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6816:1: ( ( (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding ) ) (otherlv_1= ',' ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) ) )* )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6816:2: ( (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding ) ) (otherlv_1= ',' ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) ) )*
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6816:2: ( (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6817:1: (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6817:1: (lv_qualifiedName_0_0= ruleQualifiedNameWithBinding )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6818:3: lv_qualifiedName_0_0= ruleQualifiedNameWithBinding
            {
             
            	        newCompositeNode(grammarAccess.getQualifiedNameListAccess().getQualifiedNameQualifiedNameWithBindingParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleQualifiedNameList14785);
            lv_qualifiedName_0_0=ruleQualifiedNameWithBinding();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQualifiedNameListRule());
            	        }
                   		add(
                   			current, 
                   			"qualifiedName",
                    		lv_qualifiedName_0_0, 
                    		"QualifiedNameWithBinding");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6834:2: (otherlv_1= ',' ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==21) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6834:4: otherlv_1= ',' ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) )
            	    {
            	    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleQualifiedNameList14798); 

            	        	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameListAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6838:1: ( (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding ) )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6839:1: (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding )
            	    {
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6839:1: (lv_qualifiedName_2_0= ruleQualifiedNameWithBinding )
            	    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6840:3: lv_qualifiedName_2_0= ruleQualifiedNameWithBinding
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQualifiedNameListAccess().getQualifiedNameQualifiedNameWithBindingParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedNameWithBinding_in_ruleQualifiedNameList14819);
            	    lv_qualifiedName_2_0=ruleQualifiedNameWithBinding();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQualifiedNameListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"qualifiedName",
            	            		lv_qualifiedName_2_0, 
            	            		"QualifiedNameWithBinding");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameList"


    // $ANTLR start "entryRuleInvocationOrAssignementOrDeclarationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6864:1: entryRuleInvocationOrAssignementOrDeclarationStatement returns [EObject current=null] : iv_ruleInvocationOrAssignementOrDeclarationStatement= ruleInvocationOrAssignementOrDeclarationStatement EOF ;
    public final EObject entryRuleInvocationOrAssignementOrDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvocationOrAssignementOrDeclarationStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6865:2: (iv_ruleInvocationOrAssignementOrDeclarationStatement= ruleInvocationOrAssignementOrDeclarationStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6866:2: iv_ruleInvocationOrAssignementOrDeclarationStatement= ruleInvocationOrAssignementOrDeclarationStatement EOF
            {
             newCompositeNode(grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule()); 
            pushFollow(FOLLOW_ruleInvocationOrAssignementOrDeclarationStatement_in_entryRuleInvocationOrAssignementOrDeclarationStatement14857);
            iv_ruleInvocationOrAssignementOrDeclarationStatement=ruleInvocationOrAssignementOrDeclarationStatement();

            state._fsp--;

             current =iv_ruleInvocationOrAssignementOrDeclarationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvocationOrAssignementOrDeclarationStatement14867); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvocationOrAssignementOrDeclarationStatement"


    // $ANTLR start "ruleInvocationOrAssignementOrDeclarationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6873:1: ruleInvocationOrAssignementOrDeclarationStatement returns [EObject current=null] : ( ( (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression ) ) ( ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) ) | ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) ) )? otherlv_3= ';' ) ;
    public final EObject ruleInvocationOrAssignementOrDeclarationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_typePart_OR_assignedPart_OR_invocationPart_0_0 = null;

        EObject lv_variableDeclarationCompletion_1_0 = null;

        EObject lv_assignmentCompletion_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6876:28: ( ( ( (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression ) ) ( ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) ) | ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) ) )? otherlv_3= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6877:1: ( ( (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression ) ) ( ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) ) | ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) ) )? otherlv_3= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6877:1: ( ( (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression ) ) ( ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) ) | ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) ) )? otherlv_3= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6877:2: ( (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression ) ) ( ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) ) | ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) ) )? otherlv_3= ';'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6877:2: ( (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6878:1: (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6878:1: (lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6879:3: lv_typePart_OR_assignedPart_OR_invocationPart_0_0= ruleNameExpression
            {
             
            	        newCompositeNode(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getTypePart_OR_assignedPart_OR_invocationPartNameExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNameExpression_in_ruleInvocationOrAssignementOrDeclarationStatement14913);
            lv_typePart_OR_assignedPart_OR_invocationPart_0_0=ruleNameExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule());
            	        }
                   		set(
                   			current, 
                   			"typePart_OR_assignedPart_OR_invocationPart",
                    		lv_typePart_OR_assignedPart_OR_invocationPart_0_0, 
                    		"NameExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6895:2: ( ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) ) | ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) ) )?
            int alt98=3;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==RULE_ID||LA98_0==50) ) {
                alt98=1;
            }
            else if ( (LA98_0==70||(LA98_0>=103 && LA98_0<=113)) ) {
                alt98=2;
            }
            switch (alt98) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6895:3: ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6895:3: ( (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6896:1: (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6896:1: (lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6897:3: lv_variableDeclarationCompletion_1_0= ruleVariableDeclarationCompletion
                    {
                     
                    	        newCompositeNode(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getVariableDeclarationCompletionVariableDeclarationCompletionParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariableDeclarationCompletion_in_ruleInvocationOrAssignementOrDeclarationStatement14935);
                    lv_variableDeclarationCompletion_1_0=ruleVariableDeclarationCompletion();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"variableDeclarationCompletion",
                            		lv_variableDeclarationCompletion_1_0, 
                            		"VariableDeclarationCompletion");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6914:6: ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6914:6: ( (lv_assignmentCompletion_2_0= ruleAssignmentCompletion ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6915:1: (lv_assignmentCompletion_2_0= ruleAssignmentCompletion )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6915:1: (lv_assignmentCompletion_2_0= ruleAssignmentCompletion )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6916:3: lv_assignmentCompletion_2_0= ruleAssignmentCompletion
                    {
                     
                    	        newCompositeNode(grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getAssignmentCompletionAssignmentCompletionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAssignmentCompletion_in_ruleInvocationOrAssignementOrDeclarationStatement14962);
                    lv_assignmentCompletion_2_0=ruleAssignmentCompletion();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getInvocationOrAssignementOrDeclarationStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"assignmentCompletion",
                            		lv_assignmentCompletion_2_0, 
                            		"AssignmentCompletion");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,68,FOLLOW_68_in_ruleInvocationOrAssignementOrDeclarationStatement14976); 

                	newLeafNode(otherlv_3, grammarAccess.getInvocationOrAssignementOrDeclarationStatementAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvocationOrAssignementOrDeclarationStatement"


    // $ANTLR start "entryRuleSuperInvocationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6944:1: entryRuleSuperInvocationStatement returns [EObject current=null] : iv_ruleSuperInvocationStatement= ruleSuperInvocationStatement EOF ;
    public final EObject entryRuleSuperInvocationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperInvocationStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6945:2: (iv_ruleSuperInvocationStatement= ruleSuperInvocationStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6946:2: iv_ruleSuperInvocationStatement= ruleSuperInvocationStatement EOF
            {
             newCompositeNode(grammarAccess.getSuperInvocationStatementRule()); 
            pushFollow(FOLLOW_ruleSuperInvocationStatement_in_entryRuleSuperInvocationStatement15012);
            iv_ruleSuperInvocationStatement=ruleSuperInvocationStatement();

            state._fsp--;

             current =iv_ruleSuperInvocationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperInvocationStatement15022); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuperInvocationStatement"


    // $ANTLR start "ruleSuperInvocationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6953:1: ruleSuperInvocationStatement returns [EObject current=null] : ( ( (lv__super_0_0= ruleSuperInvocationExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleSuperInvocationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv__super_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6956:28: ( ( ( (lv__super_0_0= ruleSuperInvocationExpression ) ) otherlv_1= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6957:1: ( ( (lv__super_0_0= ruleSuperInvocationExpression ) ) otherlv_1= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6957:1: ( ( (lv__super_0_0= ruleSuperInvocationExpression ) ) otherlv_1= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6957:2: ( (lv__super_0_0= ruleSuperInvocationExpression ) ) otherlv_1= ';'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6957:2: ( (lv__super_0_0= ruleSuperInvocationExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6958:1: (lv__super_0_0= ruleSuperInvocationExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6958:1: (lv__super_0_0= ruleSuperInvocationExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6959:3: lv__super_0_0= ruleSuperInvocationExpression
            {
             
            	        newCompositeNode(grammarAccess.getSuperInvocationStatementAccess().get_superSuperInvocationExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSuperInvocationExpression_in_ruleSuperInvocationStatement15068);
            lv__super_0_0=ruleSuperInvocationExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuperInvocationStatementRule());
            	        }
                   		set(
                   			current, 
                   			"_super",
                    		lv__super_0_0, 
                    		"SuperInvocationExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleSuperInvocationStatement15080); 

                	newLeafNode(otherlv_1, grammarAccess.getSuperInvocationStatementAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuperInvocationStatement"


    // $ANTLR start "entryRuleThisInvocationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6987:1: entryRuleThisInvocationStatement returns [EObject current=null] : iv_ruleThisInvocationStatement= ruleThisInvocationStatement EOF ;
    public final EObject entryRuleThisInvocationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThisInvocationStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6988:2: (iv_ruleThisInvocationStatement= ruleThisInvocationStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6989:2: iv_ruleThisInvocationStatement= ruleThisInvocationStatement EOF
            {
             newCompositeNode(grammarAccess.getThisInvocationStatementRule()); 
            pushFollow(FOLLOW_ruleThisInvocationStatement_in_entryRuleThisInvocationStatement15116);
            iv_ruleThisInvocationStatement=ruleThisInvocationStatement();

            state._fsp--;

             current =iv_ruleThisInvocationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleThisInvocationStatement15126); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisInvocationStatement"


    // $ANTLR start "ruleThisInvocationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6996:1: ruleThisInvocationStatement returns [EObject current=null] : ( ( (lv__this_0_0= ruleThisExpression ) ) ( (lv_assignmentCompletion_1_0= ruleAssignmentCompletion ) )? otherlv_2= ';' ) ;
    public final EObject ruleThisInvocationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv__this_0_0 = null;

        EObject lv_assignmentCompletion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:6999:28: ( ( ( (lv__this_0_0= ruleThisExpression ) ) ( (lv_assignmentCompletion_1_0= ruleAssignmentCompletion ) )? otherlv_2= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7000:1: ( ( (lv__this_0_0= ruleThisExpression ) ) ( (lv_assignmentCompletion_1_0= ruleAssignmentCompletion ) )? otherlv_2= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7000:1: ( ( (lv__this_0_0= ruleThisExpression ) ) ( (lv_assignmentCompletion_1_0= ruleAssignmentCompletion ) )? otherlv_2= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7000:2: ( (lv__this_0_0= ruleThisExpression ) ) ( (lv_assignmentCompletion_1_0= ruleAssignmentCompletion ) )? otherlv_2= ';'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7000:2: ( (lv__this_0_0= ruleThisExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7001:1: (lv__this_0_0= ruleThisExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7001:1: (lv__this_0_0= ruleThisExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7002:3: lv__this_0_0= ruleThisExpression
            {
             
            	        newCompositeNode(grammarAccess.getThisInvocationStatementAccess().get_thisThisExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleThisExpression_in_ruleThisInvocationStatement15172);
            lv__this_0_0=ruleThisExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getThisInvocationStatementRule());
            	        }
                   		set(
                   			current, 
                   			"_this",
                    		lv__this_0_0, 
                    		"ThisExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7018:2: ( (lv_assignmentCompletion_1_0= ruleAssignmentCompletion ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==70||(LA99_0>=103 && LA99_0<=113)) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7019:1: (lv_assignmentCompletion_1_0= ruleAssignmentCompletion )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7019:1: (lv_assignmentCompletion_1_0= ruleAssignmentCompletion )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7020:3: lv_assignmentCompletion_1_0= ruleAssignmentCompletion
                    {
                     
                    	        newCompositeNode(grammarAccess.getThisInvocationStatementAccess().getAssignmentCompletionAssignmentCompletionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAssignmentCompletion_in_ruleThisInvocationStatement15193);
                    lv_assignmentCompletion_1_0=ruleAssignmentCompletion();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getThisInvocationStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"assignmentCompletion",
                            		lv_assignmentCompletion_1_0, 
                            		"AssignmentCompletion");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,68,FOLLOW_68_in_ruleThisInvocationStatement15206); 

                	newLeafNode(otherlv_2, grammarAccess.getThisInvocationStatementAccess().getSemicolonKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisInvocationStatement"


    // $ANTLR start "entryRuleInstanceCreationInvocationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7048:1: entryRuleInstanceCreationInvocationStatement returns [EObject current=null] : iv_ruleInstanceCreationInvocationStatement= ruleInstanceCreationInvocationStatement EOF ;
    public final EObject entryRuleInstanceCreationInvocationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceCreationInvocationStatement = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7049:2: (iv_ruleInstanceCreationInvocationStatement= ruleInstanceCreationInvocationStatement EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7050:2: iv_ruleInstanceCreationInvocationStatement= ruleInstanceCreationInvocationStatement EOF
            {
             newCompositeNode(grammarAccess.getInstanceCreationInvocationStatementRule()); 
            pushFollow(FOLLOW_ruleInstanceCreationInvocationStatement_in_entryRuleInstanceCreationInvocationStatement15242);
            iv_ruleInstanceCreationInvocationStatement=ruleInstanceCreationInvocationStatement();

            state._fsp--;

             current =iv_ruleInstanceCreationInvocationStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceCreationInvocationStatement15252); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceCreationInvocationStatement"


    // $ANTLR start "ruleInstanceCreationInvocationStatement"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7057:1: ruleInstanceCreationInvocationStatement returns [EObject current=null] : ( ( (lv__new_0_0= ruleInstanceCreationExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleInstanceCreationInvocationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv__new_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7060:28: ( ( ( (lv__new_0_0= ruleInstanceCreationExpression ) ) otherlv_1= ';' ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7061:1: ( ( (lv__new_0_0= ruleInstanceCreationExpression ) ) otherlv_1= ';' )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7061:1: ( ( (lv__new_0_0= ruleInstanceCreationExpression ) ) otherlv_1= ';' )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7061:2: ( (lv__new_0_0= ruleInstanceCreationExpression ) ) otherlv_1= ';'
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7061:2: ( (lv__new_0_0= ruleInstanceCreationExpression ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7062:1: (lv__new_0_0= ruleInstanceCreationExpression )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7062:1: (lv__new_0_0= ruleInstanceCreationExpression )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7063:3: lv__new_0_0= ruleInstanceCreationExpression
            {
             
            	        newCompositeNode(grammarAccess.getInstanceCreationInvocationStatementAccess().get_newInstanceCreationExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceCreationExpression_in_ruleInstanceCreationInvocationStatement15298);
            lv__new_0_0=ruleInstanceCreationExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInstanceCreationInvocationStatementRule());
            	        }
                   		set(
                   			current, 
                   			"_new",
                    		lv__new_0_0, 
                    		"InstanceCreationExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,68,FOLLOW_68_in_ruleInstanceCreationInvocationStatement15310); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceCreationInvocationStatementAccess().getSemicolonKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceCreationInvocationStatement"


    // $ANTLR start "entryRuleVariableDeclarationCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7091:1: entryRuleVariableDeclarationCompletion returns [EObject current=null] : iv_ruleVariableDeclarationCompletion= ruleVariableDeclarationCompletion EOF ;
    public final EObject entryRuleVariableDeclarationCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclarationCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7092:2: (iv_ruleVariableDeclarationCompletion= ruleVariableDeclarationCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7093:2: iv_ruleVariableDeclarationCompletion= ruleVariableDeclarationCompletion EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationCompletionRule()); 
            pushFollow(FOLLOW_ruleVariableDeclarationCompletion_in_entryRuleVariableDeclarationCompletion15346);
            iv_ruleVariableDeclarationCompletion=ruleVariableDeclarationCompletion();

            state._fsp--;

             current =iv_ruleVariableDeclarationCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclarationCompletion15356); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclarationCompletion"


    // $ANTLR start "ruleVariableDeclarationCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7100:1: ruleVariableDeclarationCompletion returns [EObject current=null] : ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_variableName_2_0= RULE_ID ) ) ( (lv_initValue_3_0= ruleAssignmentCompletion ) ) ) ;
    public final EObject ruleVariableDeclarationCompletion() throws RecognitionException {
        EObject current = null;

        Token lv_multiplicityIndicator_0_0=null;
        Token otherlv_1=null;
        Token lv_variableName_2_0=null;
        EObject lv_initValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7103:28: ( ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_variableName_2_0= RULE_ID ) ) ( (lv_initValue_3_0= ruleAssignmentCompletion ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7104:1: ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_variableName_2_0= RULE_ID ) ) ( (lv_initValue_3_0= ruleAssignmentCompletion ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7104:1: ( ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_variableName_2_0= RULE_ID ) ) ( (lv_initValue_3_0= ruleAssignmentCompletion ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7104:2: ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )? ( (lv_variableName_2_0= RULE_ID ) ) ( (lv_initValue_3_0= ruleAssignmentCompletion ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7104:2: ( ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==50) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7104:3: ( (lv_multiplicityIndicator_0_0= '[' ) ) otherlv_1= ']'
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7104:3: ( (lv_multiplicityIndicator_0_0= '[' ) )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7105:1: (lv_multiplicityIndicator_0_0= '[' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7105:1: (lv_multiplicityIndicator_0_0= '[' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7106:3: lv_multiplicityIndicator_0_0= '['
                    {
                    lv_multiplicityIndicator_0_0=(Token)match(input,50,FOLLOW_50_in_ruleVariableDeclarationCompletion15400); 

                            newLeafNode(lv_multiplicityIndicator_0_0, grammarAccess.getVariableDeclarationCompletionAccess().getMultiplicityIndicatorLeftSquareBracketKeyword_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableDeclarationCompletionRule());
                    	        }
                           		setWithLastConsumed(current, "multiplicityIndicator", true, "[");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_ruleVariableDeclarationCompletion15425); 

                        	newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationCompletionAccess().getRightSquareBracketKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7123:3: ( (lv_variableName_2_0= RULE_ID ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7124:1: (lv_variableName_2_0= RULE_ID )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7124:1: (lv_variableName_2_0= RULE_ID )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7125:3: lv_variableName_2_0= RULE_ID
            {
            lv_variableName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableDeclarationCompletion15444); 

            			newLeafNode(lv_variableName_2_0, grammarAccess.getVariableDeclarationCompletionAccess().getVariableNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableDeclarationCompletionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"variableName",
                    		lv_variableName_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7141:2: ( (lv_initValue_3_0= ruleAssignmentCompletion ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7142:1: (lv_initValue_3_0= ruleAssignmentCompletion )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7142:1: (lv_initValue_3_0= ruleAssignmentCompletion )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7143:3: lv_initValue_3_0= ruleAssignmentCompletion
            {
             
            	        newCompositeNode(grammarAccess.getVariableDeclarationCompletionAccess().getInitValueAssignmentCompletionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAssignmentCompletion_in_ruleVariableDeclarationCompletion15470);
            lv_initValue_3_0=ruleAssignmentCompletion();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDeclarationCompletionRule());
            	        }
                   		set(
                   			current, 
                   			"initValue",
                    		lv_initValue_3_0, 
                    		"AssignmentCompletion");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclarationCompletion"


    // $ANTLR start "entryRuleAssignmentCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7167:1: entryRuleAssignmentCompletion returns [EObject current=null] : iv_ruleAssignmentCompletion= ruleAssignmentCompletion EOF ;
    public final EObject entryRuleAssignmentCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentCompletion = null;


        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7168:2: (iv_ruleAssignmentCompletion= ruleAssignmentCompletion EOF )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7169:2: iv_ruleAssignmentCompletion= ruleAssignmentCompletion EOF
            {
             newCompositeNode(grammarAccess.getAssignmentCompletionRule()); 
            pushFollow(FOLLOW_ruleAssignmentCompletion_in_entryRuleAssignmentCompletion15506);
            iv_ruleAssignmentCompletion=ruleAssignmentCompletion();

            state._fsp--;

             current =iv_ruleAssignmentCompletion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentCompletion15516); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentCompletion"


    // $ANTLR start "ruleAssignmentCompletion"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7176:1: ruleAssignmentCompletion returns [EObject current=null] : ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_1_0= ruleSequenceElement ) ) ) ;
    public final EObject ruleAssignmentCompletion() throws RecognitionException {
        EObject current = null;

        Enumerator lv_op_0_0 = null;

        EObject lv_rightHandSide_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7179:28: ( ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_1_0= ruleSequenceElement ) ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7180:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_1_0= ruleSequenceElement ) ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7180:1: ( ( (lv_op_0_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_1_0= ruleSequenceElement ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7180:2: ( (lv_op_0_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_1_0= ruleSequenceElement ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7180:2: ( (lv_op_0_0= ruleAssignmentOperator ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7181:1: (lv_op_0_0= ruleAssignmentOperator )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7181:1: (lv_op_0_0= ruleAssignmentOperator )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7182:3: lv_op_0_0= ruleAssignmentOperator
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentCompletionAccess().getOpAssignmentOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignmentCompletion15562);
            lv_op_0_0=ruleAssignmentOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentCompletionRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_0_0, 
                    		"AssignmentOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7198:2: ( (lv_rightHandSide_1_0= ruleSequenceElement ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7199:1: (lv_rightHandSide_1_0= ruleSequenceElement )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7199:1: (lv_rightHandSide_1_0= ruleSequenceElement )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7200:3: lv_rightHandSide_1_0= ruleSequenceElement
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentCompletionAccess().getRightHandSideSequenceElementParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSequenceElement_in_ruleAssignmentCompletion15583);
            lv_rightHandSide_1_0=ruleSequenceElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssignmentCompletionRule());
            	        }
                   		set(
                   			current, 
                   			"rightHandSide",
                    		lv_rightHandSide_1_0, 
                    		"SequenceElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentCompletion"


    // $ANTLR start "ruleBooleanValue"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7224:1: ruleBooleanValue returns [Enumerator current=null] : ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) ;
    public final Enumerator ruleBooleanValue() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7226:28: ( ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7227:1: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7227:1: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==87) ) {
                alt101=1;
            }
            else if ( (LA101_0==88) ) {
                alt101=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7227:2: (enumLiteral_0= 'true' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7227:2: (enumLiteral_0= 'true' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7227:4: enumLiteral_0= 'true'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_87_in_ruleBooleanValue15633); 

                            current = grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getBooleanValueAccess().getTRUEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7233:6: (enumLiteral_1= 'false' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7233:6: (enumLiteral_1= 'false' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7233:8: enumLiteral_1= 'false'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_88_in_ruleBooleanValue15650); 

                            current = grammarAccess.getBooleanValueAccess().getFALSEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getBooleanValueAccess().getFALSEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "ruleLinkOperationKind"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7243:1: ruleLinkOperationKind returns [Enumerator current=null] : ( (enumLiteral_0= 'createLink' ) | (enumLiteral_1= 'destroyLink' ) | (enumLiteral_2= 'clearAssoc' ) ) ;
    public final Enumerator ruleLinkOperationKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7245:28: ( ( (enumLiteral_0= 'createLink' ) | (enumLiteral_1= 'destroyLink' ) | (enumLiteral_2= 'clearAssoc' ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7246:1: ( (enumLiteral_0= 'createLink' ) | (enumLiteral_1= 'destroyLink' ) | (enumLiteral_2= 'clearAssoc' ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7246:1: ( (enumLiteral_0= 'createLink' ) | (enumLiteral_1= 'destroyLink' ) | (enumLiteral_2= 'clearAssoc' ) )
            int alt102=3;
            switch ( input.LA(1) ) {
            case 89:
                {
                alt102=1;
                }
                break;
            case 90:
                {
                alt102=2;
                }
                break;
            case 91:
                {
                alt102=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7246:2: (enumLiteral_0= 'createLink' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7246:2: (enumLiteral_0= 'createLink' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7246:4: enumLiteral_0= 'createLink'
                    {
                    enumLiteral_0=(Token)match(input,89,FOLLOW_89_in_ruleLinkOperationKind15695); 

                            current = grammarAccess.getLinkOperationKindAccess().getCREATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLinkOperationKindAccess().getCREATEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7252:6: (enumLiteral_1= 'destroyLink' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7252:6: (enumLiteral_1= 'destroyLink' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7252:8: enumLiteral_1= 'destroyLink'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_90_in_ruleLinkOperationKind15712); 

                            current = grammarAccess.getLinkOperationKindAccess().getDESTROYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLinkOperationKindAccess().getDESTROYEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7258:6: (enumLiteral_2= 'clearAssoc' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7258:6: (enumLiteral_2= 'clearAssoc' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7258:8: enumLiteral_2= 'clearAssoc'
                    {
                    enumLiteral_2=(Token)match(input,91,FOLLOW_91_in_ruleLinkOperationKind15729); 

                            current = grammarAccess.getLinkOperationKindAccess().getCLEAREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getLinkOperationKindAccess().getCLEAREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinkOperationKind"


    // $ANTLR start "ruleSelectOrRejectOperator"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7268:1: ruleSelectOrRejectOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'reject' ) ) ;
    public final Enumerator ruleSelectOrRejectOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7270:28: ( ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'reject' ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7271:1: ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'reject' ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7271:1: ( (enumLiteral_0= 'select' ) | (enumLiteral_1= 'reject' ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==92) ) {
                alt103=1;
            }
            else if ( (LA103_0==93) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7271:2: (enumLiteral_0= 'select' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7271:2: (enumLiteral_0= 'select' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7271:4: enumLiteral_0= 'select'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_92_in_ruleSelectOrRejectOperator15774); 

                            current = grammarAccess.getSelectOrRejectOperatorAccess().getSELECTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getSelectOrRejectOperatorAccess().getSELECTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7277:6: (enumLiteral_1= 'reject' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7277:6: (enumLiteral_1= 'reject' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7277:8: enumLiteral_1= 'reject'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_93_in_ruleSelectOrRejectOperator15791); 

                            current = grammarAccess.getSelectOrRejectOperatorAccess().getREJECTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getSelectOrRejectOperatorAccess().getREJECTEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectOrRejectOperator"


    // $ANTLR start "ruleCollectOrIterateOperator"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7287:1: ruleCollectOrIterateOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'collect' ) | (enumLiteral_1= 'iterate' ) ) ;
    public final Enumerator ruleCollectOrIterateOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7289:28: ( ( (enumLiteral_0= 'collect' ) | (enumLiteral_1= 'iterate' ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7290:1: ( (enumLiteral_0= 'collect' ) | (enumLiteral_1= 'iterate' ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7290:1: ( (enumLiteral_0= 'collect' ) | (enumLiteral_1= 'iterate' ) )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==94) ) {
                alt104=1;
            }
            else if ( (LA104_0==95) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7290:2: (enumLiteral_0= 'collect' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7290:2: (enumLiteral_0= 'collect' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7290:4: enumLiteral_0= 'collect'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_94_in_ruleCollectOrIterateOperator15836); 

                            current = grammarAccess.getCollectOrIterateOperatorAccess().getCOLLECTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCollectOrIterateOperatorAccess().getCOLLECTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7296:6: (enumLiteral_1= 'iterate' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7296:6: (enumLiteral_1= 'iterate' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7296:8: enumLiteral_1= 'iterate'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_95_in_ruleCollectOrIterateOperator15853); 

                            current = grammarAccess.getCollectOrIterateOperatorAccess().getITERATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCollectOrIterateOperatorAccess().getITERATEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectOrIterateOperator"


    // $ANTLR start "ruleForAllOrExistsOrOneOperator"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7306:1: ruleForAllOrExistsOrOneOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'forAll' ) | (enumLiteral_1= 'exists' ) | (enumLiteral_2= 'one' ) ) ;
    public final Enumerator ruleForAllOrExistsOrOneOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7308:28: ( ( (enumLiteral_0= 'forAll' ) | (enumLiteral_1= 'exists' ) | (enumLiteral_2= 'one' ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7309:1: ( (enumLiteral_0= 'forAll' ) | (enumLiteral_1= 'exists' ) | (enumLiteral_2= 'one' ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7309:1: ( (enumLiteral_0= 'forAll' ) | (enumLiteral_1= 'exists' ) | (enumLiteral_2= 'one' ) )
            int alt105=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt105=1;
                }
                break;
            case 97:
                {
                alt105=2;
                }
                break;
            case 98:
                {
                alt105=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7309:2: (enumLiteral_0= 'forAll' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7309:2: (enumLiteral_0= 'forAll' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7309:4: enumLiteral_0= 'forAll'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_96_in_ruleForAllOrExistsOrOneOperator15898); 

                            current = grammarAccess.getForAllOrExistsOrOneOperatorAccess().getFORALLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getForAllOrExistsOrOneOperatorAccess().getFORALLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7315:6: (enumLiteral_1= 'exists' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7315:6: (enumLiteral_1= 'exists' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7315:8: enumLiteral_1= 'exists'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_97_in_ruleForAllOrExistsOrOneOperator15915); 

                            current = grammarAccess.getForAllOrExistsOrOneOperatorAccess().getEXISTSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getForAllOrExistsOrOneOperatorAccess().getEXISTSEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7321:6: (enumLiteral_2= 'one' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7321:6: (enumLiteral_2= 'one' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7321:8: enumLiteral_2= 'one'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_98_in_ruleForAllOrExistsOrOneOperator15932); 

                            current = grammarAccess.getForAllOrExistsOrOneOperatorAccess().getONEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getForAllOrExistsOrOneOperatorAccess().getONEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForAllOrExistsOrOneOperator"


    // $ANTLR start "ruleAnnotationKind"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7331:1: ruleAnnotationKind returns [Enumerator current=null] : ( (enumLiteral_0= 'isolated' ) | (enumLiteral_1= 'determined' ) | (enumLiteral_2= 'assured' ) | (enumLiteral_3= 'parallel' ) ) ;
    public final Enumerator ruleAnnotationKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7333:28: ( ( (enumLiteral_0= 'isolated' ) | (enumLiteral_1= 'determined' ) | (enumLiteral_2= 'assured' ) | (enumLiteral_3= 'parallel' ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7334:1: ( (enumLiteral_0= 'isolated' ) | (enumLiteral_1= 'determined' ) | (enumLiteral_2= 'assured' ) | (enumLiteral_3= 'parallel' ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7334:1: ( (enumLiteral_0= 'isolated' ) | (enumLiteral_1= 'determined' ) | (enumLiteral_2= 'assured' ) | (enumLiteral_3= 'parallel' ) )
            int alt106=4;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt106=1;
                }
                break;
            case 100:
                {
                alt106=2;
                }
                break;
            case 101:
                {
                alt106=3;
                }
                break;
            case 102:
                {
                alt106=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7334:2: (enumLiteral_0= 'isolated' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7334:2: (enumLiteral_0= 'isolated' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7334:4: enumLiteral_0= 'isolated'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_99_in_ruleAnnotationKind15977); 

                            current = grammarAccess.getAnnotationKindAccess().getISOLATEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAnnotationKindAccess().getISOLATEDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7340:6: (enumLiteral_1= 'determined' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7340:6: (enumLiteral_1= 'determined' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7340:8: enumLiteral_1= 'determined'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_100_in_ruleAnnotationKind15994); 

                            current = grammarAccess.getAnnotationKindAccess().getDETERMINEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAnnotationKindAccess().getDETERMINEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7346:6: (enumLiteral_2= 'assured' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7346:6: (enumLiteral_2= 'assured' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7346:8: enumLiteral_2= 'assured'
                    {
                    enumLiteral_2=(Token)match(input,101,FOLLOW_101_in_ruleAnnotationKind16011); 

                            current = grammarAccess.getAnnotationKindAccess().getASSUREDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAnnotationKindAccess().getASSUREDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7352:6: (enumLiteral_3= 'parallel' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7352:6: (enumLiteral_3= 'parallel' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7352:8: enumLiteral_3= 'parallel'
                    {
                    enumLiteral_3=(Token)match(input,102,FOLLOW_102_in_ruleAnnotationKind16028); 

                            current = grammarAccess.getAnnotationKindAccess().getPARALLELEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getAnnotationKindAccess().getPARALLELEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationKind"


    // $ANTLR start "ruleAssignmentOperator"
    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7362:1: ruleAssignmentOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '%=' ) | (enumLiteral_5= '/=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) ) ;
    public final Enumerator ruleAssignmentOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;

         enterRule(); 
        try {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7364:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '%=' ) | (enumLiteral_5= '/=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) ) )
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7365:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '%=' ) | (enumLiteral_5= '/=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) )
            {
            // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7365:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '%=' ) | (enumLiteral_5= '/=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) )
            int alt107=12;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt107=1;
                }
                break;
            case 103:
                {
                alt107=2;
                }
                break;
            case 104:
                {
                alt107=3;
                }
                break;
            case 105:
                {
                alt107=4;
                }
                break;
            case 106:
                {
                alt107=5;
                }
                break;
            case 107:
                {
                alt107=6;
                }
                break;
            case 108:
                {
                alt107=7;
                }
                break;
            case 109:
                {
                alt107=8;
                }
                break;
            case 110:
                {
                alt107=9;
                }
                break;
            case 111:
                {
                alt107=10;
                }
                break;
            case 112:
                {
                alt107=11;
                }
                break;
            case 113:
                {
                alt107=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }

            switch (alt107) {
                case 1 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7365:2: (enumLiteral_0= '=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7365:2: (enumLiteral_0= '=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7365:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_70_in_ruleAssignmentOperator16073); 

                            current = grammarAccess.getAssignmentOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAssignmentOperatorAccess().getASSIGNEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7371:6: (enumLiteral_1= '+=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7371:6: (enumLiteral_1= '+=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7371:8: enumLiteral_1= '+='
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_103_in_ruleAssignmentOperator16090); 

                            current = grammarAccess.getAssignmentOperatorAccess().getPLUSASSIGNEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorAccess().getPLUSASSIGNEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7377:6: (enumLiteral_2= '-=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7377:6: (enumLiteral_2= '-=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7377:8: enumLiteral_2= '-='
                    {
                    enumLiteral_2=(Token)match(input,104,FOLLOW_104_in_ruleAssignmentOperator16107); 

                            current = grammarAccess.getAssignmentOperatorAccess().getMINUSASSIGNEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAssignmentOperatorAccess().getMINUSASSIGNEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7383:6: (enumLiteral_3= '*=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7383:6: (enumLiteral_3= '*=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7383:8: enumLiteral_3= '*='
                    {
                    enumLiteral_3=(Token)match(input,105,FOLLOW_105_in_ruleAssignmentOperator16124); 

                            current = grammarAccess.getAssignmentOperatorAccess().getMULTASSIGNEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getAssignmentOperatorAccess().getMULTASSIGNEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7389:6: (enumLiteral_4= '%=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7389:6: (enumLiteral_4= '%=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7389:8: enumLiteral_4= '%='
                    {
                    enumLiteral_4=(Token)match(input,106,FOLLOW_106_in_ruleAssignmentOperator16141); 

                            current = grammarAccess.getAssignmentOperatorAccess().getMODASSIGNEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getAssignmentOperatorAccess().getMODASSIGNEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7395:6: (enumLiteral_5= '/=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7395:6: (enumLiteral_5= '/=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7395:8: enumLiteral_5= '/='
                    {
                    enumLiteral_5=(Token)match(input,107,FOLLOW_107_in_ruleAssignmentOperator16158); 

                            current = grammarAccess.getAssignmentOperatorAccess().getDIVASSIGNEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getAssignmentOperatorAccess().getDIVASSIGNEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7401:6: (enumLiteral_6= '&=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7401:6: (enumLiteral_6= '&=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7401:8: enumLiteral_6= '&='
                    {
                    enumLiteral_6=(Token)match(input,108,FOLLOW_108_in_ruleAssignmentOperator16175); 

                            current = grammarAccess.getAssignmentOperatorAccess().getANDASSIGNEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getAssignmentOperatorAccess().getANDASSIGNEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7407:6: (enumLiteral_7= '|=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7407:6: (enumLiteral_7= '|=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7407:8: enumLiteral_7= '|='
                    {
                    enumLiteral_7=(Token)match(input,109,FOLLOW_109_in_ruleAssignmentOperator16192); 

                            current = grammarAccess.getAssignmentOperatorAccess().getORASSIGNEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getAssignmentOperatorAccess().getORASSIGNEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7413:6: (enumLiteral_8= '^=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7413:6: (enumLiteral_8= '^=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7413:8: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,110,FOLLOW_110_in_ruleAssignmentOperator16209); 

                            current = grammarAccess.getAssignmentOperatorAccess().getXORASSIGNEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getAssignmentOperatorAccess().getXORASSIGNEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7419:6: (enumLiteral_9= '<<=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7419:6: (enumLiteral_9= '<<=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7419:8: enumLiteral_9= '<<='
                    {
                    enumLiteral_9=(Token)match(input,111,FOLLOW_111_in_ruleAssignmentOperator16226); 

                            current = grammarAccess.getAssignmentOperatorAccess().getLSHIFTASSIGNEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getAssignmentOperatorAccess().getLSHIFTASSIGNEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7425:6: (enumLiteral_10= '>>=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7425:6: (enumLiteral_10= '>>=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7425:8: enumLiteral_10= '>>='
                    {
                    enumLiteral_10=(Token)match(input,112,FOLLOW_112_in_ruleAssignmentOperator16243); 

                            current = grammarAccess.getAssignmentOperatorAccess().getRSHIFTASSIGNEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getAssignmentOperatorAccess().getRSHIFTASSIGNEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7431:6: (enumLiteral_11= '>>>=' )
                    {
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7431:6: (enumLiteral_11= '>>>=' )
                    // ../org.eclipse.papyrus.alf/src-gen/org/eclipse/papyrus/alf/parser/antlr/internal/InternalAlf.g:7431:8: enumLiteral_11= '>>>='
                    {
                    enumLiteral_11=(Token)match(input,113,FOLLOW_113_in_ruleAssignmentOperator16260); 

                            current = grammarAccess.getAssignmentOperatorAccess().getURSHIFTASSIGNEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_11, grammarAccess.getAssignmentOperatorAccess().getURSHIFTASSIGNEnumLiteralDeclaration_11()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"

    // Delegated rules


    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA44_eotS =
        "\13\uffff";
    static final String DFA44_eofS =
        "\3\uffff\1\12\7\uffff";
    static final String DFA44_minS =
        "\1\61\3\6\7\uffff";
    static final String DFA44_maxS =
        "\1\64\1\133\1\142\1\161\7\uffff";
    static final String DFA44_acceptS =
        "\4\uffff\1\3\1\7\1\5\1\6\1\4\1\1\1\2";
    static final String DFA44_specialS =
        "\13\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\2\uffff\1\2",
            "\1\3\70\uffff\1\5\31\uffff\3\4",
            "\1\10\56\uffff\1\6\1\uffff\1\7\44\uffff\7\7",
            "\1\12\5\uffff\5\12\3\uffff\3\12\1\uffff\1\11\25\12\3\uffff"+
            "\4\12\10\uffff\2\12\5\uffff\1\12\1\uffff\1\12\16\uffff\2\12"+
            "\20\uffff\13\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "2270:1: (this_OperationCallExpression_0= ruleOperationCallExpression | this_PropertyCallExpression_1= rulePropertyCallExpression | this_LinkOperationExpression_2= ruleLinkOperationExpression | this_SequenceOperationExpression_3= ruleSequenceOperationExpression | this_SequenceReductionExpression_4= ruleSequenceReductionExpression | this_SequenceExpansionExpression_5= ruleSequenceExpansionExpression | this_ClassExtentExpression_6= ruleClassExtentExpression )";
        }
    }
 

    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleTest123 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTest144 = new BitSet(new long[]{0x000000000000F000L});
    public static final BitSet FOLLOW_13_in_ruleTest159 = new BitSet(new long[]{0x0000000000000000L,0x0003FF8000000040L});
    public static final BitSet FOLLOW_ruleAssignmentCompletion_in_ruleTest180 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_14_in_ruleTest195 = new BitSet(new long[]{0x1E00000000060040L,0x00000000001EE4B9L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleTest216 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleTest231 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleTest252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_entryRuleLITERAL289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLITERAL299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOLEAN_LITERAL_in_ruleLITERAL346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleLITERAL373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_LITERAL_in_ruleLITERAL400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBOOLEAN_LITERAL_in_entryRuleBOOLEAN_LITERAL435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBOOLEAN_LITERAL445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_ruleBOOLEAN_LITERAL491 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleBOOLEAN_LITERAL512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_ruleNUMBER_LITERAL606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUNLIMITED_LITERAL_in_ruleNUMBER_LITERAL633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTEGER_LITERAL_in_entryRuleINTEGER_LITERAL668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTEGER_LITERAL678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGERVALUE_in_ruleINTEGER_LITERAL720 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleINTEGER_LITERAL746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUNLIMITED_LITERAL_in_entryRuleUNLIMITED_LITERAL783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUNLIMITED_LITERAL793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleUNLIMITED_LITERAL836 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleUNLIMITED_LITERAL870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTRING_LITERAL_in_entryRuleSTRING_LITERAL907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTRING_LITERAL917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSTRING_LITERAL959 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleSTRING_LITERAL985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameExpression_in_entryRuleNameExpression1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameExpression1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleNameExpression1079 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18_in_ruleNameExpression1108 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNamePath_in_ruleNameExpression1145 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameExpression1163 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNamePath_in_ruleNameExpression1197 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameExpression1215 = new BitSet(new long[]{0x1016000001060002L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleNameExpression1242 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSequenceConstructionOrAccessCompletion_in_ruleNameExpression1269 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_17_in_ruleNameExpression1295 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_18_in_ruleNameExpression1324 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleNameExpression1365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNamePath_in_entryRuleQualifiedNamePath1402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNamePath1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnqualifiedName_in_ruleQualifiedNamePath1458 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleQualifiedNamePath1470 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ruleUnqualifiedName_in_entryRuleUnqualifiedName1507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnqualifiedName1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnqualifiedName1559 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleTemplateBinding_in_ruleUnqualifiedName1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBinding_in_entryRuleTemplateBinding1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBinding1632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleTemplateBinding1669 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleNamedTemplateBinding_in_ruleTemplateBinding1690 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleTemplateBinding1703 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleNamedTemplateBinding_in_ruleTemplateBinding1724 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_22_in_ruleTemplateBinding1738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTemplateBinding_in_entryRuleNamedTemplateBinding1774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTemplateBinding1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamedTemplateBinding1826 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNamedTemplateBinding1843 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleNamedTemplateBinding1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_entryRuleQualifiedNameWithBinding1900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithBinding1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedNameWithBinding1952 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_ruleTemplateBinding_in_ruleQualifiedNameWithBinding1978 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleQualifiedNameWithBinding1992 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleQualifiedNameWithBinding2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple2051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple2061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleTuple2107 = new BitSet(new long[]{0x0F01CC0003070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleTupleElement_in_ruleTuple2129 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_21_in_ruleTuple2142 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleTupleElement_in_ruleTuple2163 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_25_in_ruleTuple2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleElement_in_entryRuleTupleElement2215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleElement2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTupleElement2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalTestExpression_in_ruleExpression2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalTestExpression_in_entryRuleConditionalTestExpression2395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalTestExpression2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalOrExpression_in_ruleConditionalTestExpression2451 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleConditionalTestExpression2464 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleConditionalTestExpression_in_ruleConditionalTestExpression2485 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleConditionalTestExpression2497 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleConditionalTestExpression_in_ruleConditionalTestExpression2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalOrExpression_in_entryRuleConditionalOrExpression2556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalOrExpression2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression2612 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleConditionalOrExpression2625 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression2646 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleConditionalAndExpression_in_entryRuleConditionalAndExpression2684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalAndExpression2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression2740 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleConditionalAndExpression2753 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression2774 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleInclusiveOrExpression_in_entryRuleInclusiveOrExpression2812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInclusiveOrExpression2822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression2868 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_ruleInclusiveOrExpression2881 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression2902 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleExclusiveOrExpression_in_entryRuleExclusiveOrExpression2940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExclusiveOrExpression2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression2996 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleExclusiveOrExpression3009 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression3030 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression3068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndExpression3124 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleAndExpression3137 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndExpression3158 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression3196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression3252 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_33_in_ruleEqualityExpression3273 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_34_in_ruleEqualityExpression3302 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression3339 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_ruleClassificationExpression_in_entryRuleClassificationExpression3377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassificationExpression3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleClassificationExpression3433 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_35_in_ruleClassificationExpression3454 = new BitSet(new long[]{0x0000000000060040L});
    public static final BitSet FOLLOW_36_in_ruleClassificationExpression3483 = new BitSet(new long[]{0x0000000000060040L});
    public static final BitSet FOLLOW_ruleNameExpression_in_ruleClassificationExpression3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression3558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3614 = new BitSet(new long[]{0x0000006000500002L});
    public static final BitSet FOLLOW_20_in_ruleRelationalExpression3635 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_22_in_ruleRelationalExpression3664 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_37_in_ruleRelationalExpression3693 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_38_in_ruleRelationalExpression3722 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression3797 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression3807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3853 = new BitSet(new long[]{0x0000038000000002L});
    public static final BitSet FOLLOW_39_in_ruleShiftExpression3874 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_40_in_ruleShiftExpression3903 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_41_in_ruleShiftExpression3932 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression4007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression4063 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_42_in_ruleAdditiveExpression4084 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_43_in_ruleAdditiveExpression4113 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression4150 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression4188 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression4198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4244 = new BitSet(new long[]{0x0000300000010002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplicativeExpression4265 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_44_in_ruleMultiplicativeExpression4294 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_45_in_ruleMultiplicativeExpression4323 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression4360 = new BitSet(new long[]{0x0000300000010002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression4398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression4408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleUnaryExpression4453 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_43_in_ruleUnaryExpression4482 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_42_in_ruleUnaryExpression4511 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_47_in_ruleUnaryExpression4540 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_48_in_ruleUnaryExpression4569 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnaryExpression4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression4643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_rulePrimaryExpression4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_entryRuleSuffixExpression4733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuffixExpression4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuffixExpression4790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_ruleSuffixExpression4817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkOperationExpression_in_ruleSuffixExpression4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceOperationExpression_in_ruleSuffixExpression4871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceReductionExpression_in_ruleSuffixExpression4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceExpansionExpression_in_ruleSuffixExpression4925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassExtentExpression_in_ruleSuffixExpression4952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_entryRuleOperationCallExpression4987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpression4997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleOperationCallExpression5034 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpression5051 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleOperationCallExpression5077 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpression5098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpressionWithoutDot_in_entryRuleOperationCallExpressionWithoutDot5135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCallExpressionWithoutDot5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOperationCallExpressionWithoutDot5187 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleOperationCallExpressionWithoutDot5213 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleOperationCallExpressionWithoutDot5234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyCallExpression_in_entryRulePropertyCallExpression5271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyCallExpression5281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rulePropertyCallExpression5318 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyCallExpression5335 = new BitSet(new long[]{0x0016000000000002L});
    public static final BitSet FOLLOW_50_in_rulePropertyCallExpression5353 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePropertyCallExpression5374 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_rulePropertyCallExpression5386 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_rulePropertyCallExpression5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkOperationExpression_in_entryRuleLinkOperationExpression5446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkOperationExpression5456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleLinkOperationExpression5493 = new BitSet(new long[]{0x0000000000000000L,0x000000000E000000L});
    public static final BitSet FOLLOW_ruleLinkOperationKind_in_ruleLinkOperationExpression5514 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleLinkOperationTuple_in_ruleLinkOperationExpression5535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkOperationTuple_in_entryRuleLinkOperationTuple5571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkOperationTuple5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleLinkOperationTuple5618 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleLinkOperationTupleElement_in_ruleLinkOperationTuple5639 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_21_in_ruleLinkOperationTuple5652 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleLinkOperationTupleElement_in_ruleLinkOperationTuple5673 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_25_in_ruleLinkOperationTuple5687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkOperationTupleElement_in_entryRuleLinkOperationTupleElement5723 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkOperationTupleElement5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLinkOperationTupleElement5775 = new BitSet(new long[]{0x0004000000800002L});
    public static final BitSet FOLLOW_50_in_ruleLinkOperationTupleElement5794 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLinkOperationTupleElement5815 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleLinkOperationTupleElement5827 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleLinkOperationTupleElement5841 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLinkOperationTupleElement5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceOperationExpression_in_entryRuleSequenceOperationExpression5901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceOperationExpression5911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSequenceOperationExpression5948 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSequenceOperationExpression5965 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleSequenceOperationExpression5991 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleSequenceOperationExpression6012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceReductionExpression_in_entryRuleSequenceReductionExpression6049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceReductionExpression6059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSequenceReductionExpression6096 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleSequenceReductionExpression6108 = new BitSet(new long[]{0x0040000000000040L});
    public static final BitSet FOLLOW_54_in_ruleSequenceReductionExpression6126 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleSequenceReductionExpression6161 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleSequenceReductionExpression6182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceExpansionExpression_in_entryRuleSequenceExpansionExpression6219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceExpansionExpression6229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectOrRejectOperation_in_ruleSequenceExpansionExpression6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectOrIterateOperation_in_ruleSequenceExpansionExpression6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForAllOrExistsOrOneOperation_in_ruleSequenceExpansionExpression6330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsUniqueOperation_in_ruleSequenceExpansionExpression6357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectOrRejectOperation_in_entryRuleSelectOrRejectOperation6392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectOrRejectOperation6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSelectOrRejectOperation6439 = new BitSet(new long[]{0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_ruleSelectOrRejectOperator_in_ruleSelectOrRejectOperation6460 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectOrRejectOperation6477 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSelectOrRejectOperation6494 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSelectOrRejectOperation6515 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleSelectOrRejectOperation6527 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleSelectOrRejectOperation6548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectOrIterateOperation_in_entryRuleCollectOrIterateOperation6585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectOrIterateOperation6595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleCollectOrIterateOperation6632 = new BitSet(new long[]{0x0000000000000000L,0x00000000C0000000L});
    public static final BitSet FOLLOW_ruleCollectOrIterateOperator_in_ruleCollectOrIterateOperation6653 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCollectOrIterateOperation6670 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleCollectOrIterateOperation6687 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleCollectOrIterateOperation6708 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleCollectOrIterateOperation6720 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleCollectOrIterateOperation6741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForAllOrExistsOrOneOperation_in_entryRuleForAllOrExistsOrOneOperation6778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForAllOrExistsOrOneOperation6788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleForAllOrExistsOrOneOperation6825 = new BitSet(new long[]{0x0000000000000000L,0x0000000700000000L});
    public static final BitSet FOLLOW_ruleForAllOrExistsOrOneOperator_in_ruleForAllOrExistsOrOneOperation6846 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleForAllOrExistsOrOneOperation6863 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleForAllOrExistsOrOneOperation6880 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleForAllOrExistsOrOneOperation6901 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleForAllOrExistsOrOneOperation6913 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleForAllOrExistsOrOneOperation6934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsUniqueOperation_in_entryRuleIsUniqueOperation6971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsUniqueOperation6981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleIsUniqueOperation7018 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleIsUniqueOperation7030 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIsUniqueOperation7047 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleIsUniqueOperation7064 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIsUniqueOperation7085 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleIsUniqueOperation7097 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleIsUniqueOperation7118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueSpecification_in_entryRuleValueSpecification7155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueSpecification7165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameExpression_in_ruleValueSpecification7212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLITERAL_in_ruleValueSpecification7239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisExpression_in_ruleValueSpecification7266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationExpression_in_ruleValueSpecification7293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationExpression_in_ruleValueSpecification7320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleValueSpecification7347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_ruleValueSpecification7374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonLiteralValueSpecification_in_entryRuleNonLiteralValueSpecification7409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonLiteralValueSpecification7419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameExpression_in_ruleNonLiteralValueSpecification7466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleNonLiteralValueSpecification7493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationExpression_in_ruleNonLiteralValueSpecification7520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisExpression_in_ruleNonLiteralValueSpecification7547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationExpression_in_ruleNonLiteralValueSpecification7574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression7609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression7619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParenthesizedExpression7656 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression7677 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParenthesizedExpression7689 = new BitSet(new long[]{0x0E12000001060042L});
    public static final BitSet FOLLOW_ruleNonLiteralValueSpecification_in_ruleParenthesizedExpression7711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleParenthesizedExpression7738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_entryRuleNullExpression7776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullExpression7786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleNullExpression7832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisExpression_in_entryRuleThisExpression7868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThisExpression7878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleThisExpression7924 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleThisExpression7945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationExpression_in_entryRuleSuperInvocationExpression7982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperInvocationExpression7992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleSuperInvocationExpression8029 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleSuperInvocationExpression8043 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSuperInvocationExpression8060 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSuperInvocationExpression8077 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleOperationCallExpressionWithoutDot_in_ruleSuperInvocationExpression8098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCallExpression_in_ruleSuperInvocationExpression8126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationExpression_in_entryRuleInstanceCreationExpression8163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceCreationExpression8173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleInstanceCreationExpression8210 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleInstanceCreationExpression8231 = new BitSet(new long[]{0x1004000001000000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleInstanceCreationExpression8253 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSequenceConstructionCompletion_in_ruleInstanceCreationExpression8280 = new BitSet(new long[]{0x0012000000000002L});
    public static final BitSet FOLLOW_ruleSuffixExpression_in_ruleInstanceCreationExpression8302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceConstructionOrAccessCompletion_in_entryRuleSequenceConstructionOrAccessCompletion8339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceConstructionOrAccessCompletion8349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleSequenceConstructionOrAccessCompletion8393 = new BitSet(new long[]{0x0F09CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleAccessCompletion_in_ruleSequenceConstructionOrAccessCompletion8428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartialSequenceConstructionCompletion_in_ruleSequenceConstructionOrAccessCompletion8455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceConstructionExpression_in_ruleSequenceConstructionOrAccessCompletion8484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAccessCompletion_in_entryRuleAccessCompletion8520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAccessCompletion8530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAccessCompletion8576 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleAccessCompletion8588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePartialSequenceConstructionCompletion_in_entryRulePartialSequenceConstructionCompletion8624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePartialSequenceConstructionCompletion8634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rulePartialSequenceConstructionCompletion8671 = new BitSet(new long[]{0x1004000000000000L});
    public static final BitSet FOLLOW_ruleSequenceConstructionExpression_in_rulePartialSequenceConstructionCompletion8692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceConstructionCompletion_in_entryRuleSequenceConstructionCompletion8728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceConstructionCompletion8738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleSequenceConstructionCompletion8782 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleSequenceConstructionCompletion8807 = new BitSet(new long[]{0x1004000000000000L});
    public static final BitSet FOLLOW_ruleSequenceConstructionExpression_in_ruleSequenceConstructionCompletion8830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceConstructionExpression_in_entryRuleSequenceConstructionExpression8866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceConstructionExpression8876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSequenceConstructionExpression8913 = new BitSet(new long[]{0x1F05CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleSequenceElement_in_ruleSequenceConstructionExpression8934 = new BitSet(new long[]{0x6000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequenceConstructionExpression8948 = new BitSet(new long[]{0x1F05CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleSequenceElement_in_ruleSequenceConstructionExpression8969 = new BitSet(new long[]{0x4000000000200000L});
    public static final BitSet FOLLOW_61_in_ruleSequenceConstructionExpression8990 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSequenceConstructionExpression9011 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleSequenceConstructionExpression9025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceElement_in_entryRuleSequenceElement9061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequenceElement9071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSequenceElement9118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequenceConstructionExpression_in_ruleSequenceElement9145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassExtentExpression_in_entryRuleClassExtentExpression9180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassExtentExpression9190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleClassExtentExpression9236 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleClassExtentExpression9248 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleClassExtentExpression9260 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleClassExtentExpression9272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock9308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock9318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleBlock9355 = new BitSet(new long[]{0x5E000000000601C0L,0x00000000001EE4B9L});
    public static final BitSet FOLLOW_ruleStatementSequence_in_ruleBlock9385 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleBlock9398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatementSequence_in_entryRuleStatementSequence9434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatementSequence9444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentedStatement_in_ruleStatementSequence9489 = new BitSet(new long[]{0x1E000000000601C2L,0x00000000001EE4B9L});
    public static final BitSet FOLLOW_ruleDocumentedStatement_in_entryRuleDocumentedStatement9525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentedStatement9535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_COMMENT_in_ruleDocumentedStatement9579 = new BitSet(new long[]{0x1E00000000060040L,0x00000000001EE4B9L});
    public static final BitSet FOLLOW_RULE_SL_COMMENT_in_ruleDocumentedStatement9599 = new BitSet(new long[]{0x1E00000000060040L,0x00000000001EE4B9L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleDocumentedStatement9629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStatement_in_entryRuleInlineStatement9665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInlineStatement9675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleInlineStatement9712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleInlineStatement9724 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleInlineStatement9736 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInlineStatement9753 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleInlineStatement9770 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInlineStatement9787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_ruleInlineStatement9804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotatedStatement_in_entryRuleAnnotatedStatement9840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotatedStatement9850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleAnnotatedStatement9887 = new BitSet(new long[]{0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_ruleAnnotation_in_ruleAnnotatedStatement9908 = new BitSet(new long[]{0x1E00000000060040L,0x00000000001EE4B9L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleAnnotatedStatement9929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement9965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement9975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotatedStatement_in_ruleStatement10022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInlineStatement_in_ruleStatement10049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockStatement_in_ruleStatement10076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyStatement_in_ruleStatement10103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalNameDeclarationStatement_in_ruleStatement10130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement10157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchStatement_in_ruleStatement10184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement10211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoStatement_in_ruleStatement10238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForStatement_in_ruleStatement10265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBreakStatement_in_ruleStatement10292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement10319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAcceptStatement_in_ruleStatement10346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifyStatement_in_ruleStatement10373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvocationOrAssignementOrDeclarationStatement_in_ruleStatement10400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationStatement_in_ruleStatement10427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisInvocationStatement_in_ruleStatement10454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationInvocationStatement_in_ruleStatement10481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotation_in_entryRuleAnnotation10516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnnotation10526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnnotationKind_in_ruleAnnotation10572 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleAnnotation10585 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotation10602 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_21_in_ruleAnnotation10620 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAnnotation10637 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_25_in_ruleAnnotation10656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockStatement_in_entryRuleBlockStatement10694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlockStatement10704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleBlockStatement10749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyStatement_in_entryRuleEmptyStatement10784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyStatement10794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleEmptyStatement10840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalNameDeclarationStatement_in_entryRuleLocalNameDeclarationStatement10876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalNameDeclarationStatement10886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleLocalNameDeclarationStatement10923 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLocalNameDeclarationStatement10940 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleLocalNameDeclarationStatement10957 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleLocalNameDeclarationStatement10978 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_50_in_ruleLocalNameDeclarationStatement10997 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleLocalNameDeclarationStatement11022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleLocalNameDeclarationStatement11036 = new BitSet(new long[]{0x1F05CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleSequenceElement_in_ruleLocalNameDeclarationStatement11057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleLocalNameDeclarationStatement11069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement11105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement11115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleIfStatement11152 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleSequentialClauses_in_ruleIfStatement11173 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleFinalClause_in_ruleIfStatement11194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequentialClauses_in_entryRuleSequentialClauses11231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequentialClauses11241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcurrentClauses_in_ruleSequentialClauses11287 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleSequentialClauses11300 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleSequentialClauses11312 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleConcurrentClauses_in_ruleSequentialClauses11333 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleConcurrentClauses_in_entryRuleConcurrentClauses11371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcurrentClauses11381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses11427 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleConcurrentClauses11440 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleConcurrentClauses11452 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses11473 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleNonFinalClause_in_entryRuleNonFinalClause11511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonFinalClause11521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleNonFinalClause11558 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNonFinalClause11579 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleNonFinalClause11591 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleNonFinalClause11612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFinalClause_in_entryRuleFinalClause11648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFinalClause11658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleFinalClause11695 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFinalClause11716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchStatement_in_entryRuleSwitchStatement11752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchStatement11762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleSwitchStatement11799 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleSwitchStatement11811 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchStatement11832 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleSwitchStatement11844 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleSwitchStatement11856 = new BitSet(new long[]{0x4000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleSwitchClause_in_ruleSwitchStatement11877 = new BitSet(new long[]{0x4000000000000000L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleSwitchDefaultClause_in_ruleSwitchStatement11899 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleSwitchStatement11912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchClause_in_entryRuleSwitchClause11948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchClause11958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_ruleSwitchClause12004 = new BitSet(new long[]{0x1E000000000601C0L,0x00000000001EECB9L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_ruleSwitchClause12025 = new BitSet(new long[]{0x1E000000000601C0L,0x00000000001EECB9L});
    public static final BitSet FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchClause12047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase12083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchCase12093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleSwitchCase12130 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchCase12151 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSwitchCase12163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchDefaultClause_in_entryRuleSwitchDefaultClause12199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchDefaultClause12209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleSwitchDefaultClause12246 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleSwitchDefaultClause12258 = new BitSet(new long[]{0x1E000000000601C0L,0x00000000001EECB9L});
    public static final BitSet FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchDefaultClause12279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonEmptyStatementSequence_in_entryRuleNonEmptyStatementSequence12315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonEmptyStatementSequence12325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentedStatement_in_ruleNonEmptyStatementSequence12370 = new BitSet(new long[]{0x1E000000000601C2L,0x00000000001EE4B9L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement12406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement12416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleWhileStatement12453 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleWhileStatement12465 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileStatement12486 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleWhileStatement12498 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement12519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoStatement_in_entryRuleDoStatement12555 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoStatement12565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleDoStatement12602 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleDoStatement12623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleDoStatement12635 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleDoStatement12647 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDoStatement12668 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleDoStatement12680 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleDoStatement12692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForStatement_in_entryRuleForStatement12728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForStatement12738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleForStatement12775 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleForStatement12787 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleForControl_in_ruleForStatement12808 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleForStatement12820 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleForStatement12841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForControl_in_entryRuleForControl12877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForControl12887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoopVariableDefinition_in_ruleForControl12933 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleForControl12946 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleLoopVariableDefinition_in_ruleForControl12967 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleLoopVariableDefinition_in_entryRuleLoopVariableDefinition13005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoopVariableDefinition13015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoopVariableDefinition13058 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleLoopVariableDefinition13075 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLoopVariableDefinition13096 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleLoopVariableDefinition13109 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLoopVariableDefinition13130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleLoopVariableDefinition13161 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLoopVariableDefinition13178 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleLoopVariableDefinition13195 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLoopVariableDefinition13216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBreakStatement_in_entryRuleBreakStatement13253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBreakStatement13263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleBreakStatement13309 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleBreakStatement13321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement13357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement13367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleReturnStatement13404 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement13425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleReturnStatement13437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAcceptStatement_in_entryRuleAcceptStatement13473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAcceptStatement13483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAcceptClause_in_ruleAcceptStatement13529 = new BitSet(new long[]{0x1000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSimpleAcceptStatementCompletion_in_ruleAcceptStatement13551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundAcceptStatementCompletion_in_ruleAcceptStatement13578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleAcceptStatementCompletion_in_entryRuleSimpleAcceptStatementCompletion13615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleAcceptStatementCompletion13625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleSimpleAcceptStatementCompletion13671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompoundAcceptStatementCompletion_in_entryRuleCompoundAcceptStatementCompletion13707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompoundAcceptStatementCompletion13717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleCompoundAcceptStatementCompletion13763 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleCompoundAcceptStatementCompletion13776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_ruleAcceptBlock_in_ruleCompoundAcceptStatementCompletion13797 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleAcceptBlock_in_entryRuleAcceptBlock13835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAcceptBlock13845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAcceptClause_in_ruleAcceptBlock13891 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleAcceptBlock13912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAcceptClause_in_entryRuleAcceptClause13948 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAcceptClause13958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleAcceptClause13995 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleAcceptClause14007 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAcceptClause14025 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleAcceptClause14042 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameList_in_ruleAcceptClause14065 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleAcceptClause14077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifyStatement_in_entryRuleClassifyStatement14113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassifyStatement14123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleClassifyStatement14160 = new BitSet(new long[]{0x0F01CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleClassifyStatement14181 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_ruleClassificationClause_in_ruleClassifyStatement14202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleClassifyStatement14214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationClause_in_entryRuleClassificationClause14250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassificationClause14260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationFromClause_in_ruleClassificationClause14307 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_ruleClassificationToClause_in_ruleClassificationClause14328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReclassifyAllClause_in_ruleClassificationClause14358 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_ruleClassificationToClause_in_ruleClassificationClause14380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationFromClause_in_entryRuleClassificationFromClause14417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassificationFromClause14427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleClassificationFromClause14464 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameList_in_ruleClassificationFromClause14485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationToClause_in_entryRuleClassificationToClause14521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassificationToClause14531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleClassificationToClause14568 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameList_in_ruleClassificationToClause14589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReclassifyAllClause_in_entryRuleReclassifyAllClause14625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReclassifyAllClause14635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleReclassifyAllClause14681 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleReclassifyAllClause14693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameList_in_entryRuleQualifiedNameList14729 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameList14739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleQualifiedNameList14785 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleQualifiedNameList14798 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithBinding_in_ruleQualifiedNameList14819 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleInvocationOrAssignementOrDeclarationStatement_in_entryRuleInvocationOrAssignementOrDeclarationStatement14857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvocationOrAssignementOrDeclarationStatement14867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameExpression_in_ruleInvocationOrAssignementOrDeclarationStatement14913 = new BitSet(new long[]{0x0004000000000040L,0x0003FF8000000050L});
    public static final BitSet FOLLOW_ruleVariableDeclarationCompletion_in_ruleInvocationOrAssignementOrDeclarationStatement14935 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAssignmentCompletion_in_ruleInvocationOrAssignementOrDeclarationStatement14962 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleInvocationOrAssignementOrDeclarationStatement14976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationStatement_in_entryRuleSuperInvocationStatement15012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperInvocationStatement15022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationExpression_in_ruleSuperInvocationStatement15068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleSuperInvocationStatement15080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisInvocationStatement_in_entryRuleThisInvocationStatement15116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThisInvocationStatement15126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisExpression_in_ruleThisInvocationStatement15172 = new BitSet(new long[]{0x0000000000000000L,0x0003FF8000000050L});
    public static final BitSet FOLLOW_ruleAssignmentCompletion_in_ruleThisInvocationStatement15193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleThisInvocationStatement15206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationInvocationStatement_in_entryRuleInstanceCreationInvocationStatement15242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceCreationInvocationStatement15252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationExpression_in_ruleInstanceCreationInvocationStatement15298 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleInstanceCreationInvocationStatement15310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclarationCompletion_in_entryRuleVariableDeclarationCompletion15346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclarationCompletion15356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleVariableDeclarationCompletion15400 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleVariableDeclarationCompletion15425 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableDeclarationCompletion15444 = new BitSet(new long[]{0x0000000000000000L,0x0003FF8000000040L});
    public static final BitSet FOLLOW_ruleAssignmentCompletion_in_ruleVariableDeclarationCompletion15470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentCompletion_in_entryRuleAssignmentCompletion15506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentCompletion15516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignmentCompletion15562 = new BitSet(new long[]{0x1F05CC0001070070L,0x0000000001800000L});
    public static final BitSet FOLLOW_ruleSequenceElement_in_ruleAssignmentCompletion15583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleBooleanValue15633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleBooleanValue15650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleLinkOperationKind15695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleLinkOperationKind15712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleLinkOperationKind15729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_ruleSelectOrRejectOperator15774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleSelectOrRejectOperator15791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleCollectOrIterateOperator15836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleCollectOrIterateOperator15853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_ruleForAllOrExistsOrOneOperator15898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleForAllOrExistsOrOneOperator15915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleForAllOrExistsOrOneOperator15932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_ruleAnnotationKind15977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleAnnotationKind15994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_ruleAnnotationKind16011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleAnnotationKind16028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAssignmentOperator16073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleAssignmentOperator16090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleAssignmentOperator16107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleAssignmentOperator16124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleAssignmentOperator16141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleAssignmentOperator16158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleAssignmentOperator16175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleAssignmentOperator16192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleAssignmentOperator16209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleAssignmentOperator16226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleAssignmentOperator16243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleAssignmentOperator16260 = new BitSet(new long[]{0x0000000000000002L});

}