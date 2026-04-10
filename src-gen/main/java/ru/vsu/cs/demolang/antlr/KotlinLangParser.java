// Generated from C:/Users/iafil/OneDrive/Документы/course3/TK/DemoLang.java.antlr(ast)/src/main/java/ru/vsu/cs/demolang/antlr/KotlinLang.g4 by ANTLR 4.13.2
package ru.vsu.cs.demolang.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KotlinLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, VAL=17, 
		VAR=18, FUN=19, IF=20, ELSE=21, WHILE=22, FOR=23, RETURN=24, RANGE=25, 
		SAFE_CALL=26, ELVIS=27, NOT_NULL=28, NUMBER=29, ID=30, STRING=31, COMMENT=32, 
		LINE_COMMENT=33, WS=34, MUL=35, DIV=36, REM=37, ADD=38, SUB=39, GT=40, 
		GE=41, LT=42, LE=43, EQ=44, NE=45;
	public static final int
		RULE_prog = 0, RULE_declaration = 1, RULE_propertyDecl = 2, RULE_functionDecl = 3, 
		RULE_funcParam = 4, RULE_block = 5, RULE_type = 6, RULE_stmt = 7, RULE_assignment = 8, 
		RULE_returnStmt = 9, RULE_ifStmt = 10, RULE_whileStmt = 11, RULE_forStmt = 12, 
		RULE_expr = 13, RULE_primary = 14, RULE_unaryExpr = 15, RULE_prefixOp = 16, 
		RULE_postfixOp = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declaration", "propertyDecl", "functionDecl", "funcParam", "block", 
			"type", "stmt", "assignment", "returnStmt", "ifStmt", "whileStmt", "forStmt", 
			"expr", "primary", "unaryExpr", "prefixOp", "postfixOp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "';'", "'('", "','", "')'", "'{'", "'}'", "'break'", 
			"'continue'", "'in'", "'&&'", "'||'", "'++'", "'--'", "'!'", "'val'", 
			"'var'", "'fun'", "'if'", "'else'", "'while'", "'for'", "'return'", "'..'", 
			"'?.'", "'?:'", "'!!'", null, null, null, null, null, null, "'*'", "'/'", 
			"'%'", "'+'", "'-'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "VAL", "VAR", "FUN", "IF", "ELSE", "WHILE", 
			"FOR", "RETURN", "RANGE", "SAFE_CALL", "ELVIS", "NOT_NULL", "NUMBER", 
			"ID", "STRING", "COMMENT", "LINE_COMMENT", "WS", "MUL", "DIV", "REM", 
			"ADD", "SUB", "GT", "GE", "LT", "LE", "EQ", "NE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "KotlinLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KotlinLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(KotlinLangParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 553545352720L) != 0)) {
				{
				setState(38);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAL:
				case VAR:
				case FUN:
					{
					setState(36);
					declaration();
					}
					break;
				case T__3:
				case T__8:
				case T__9:
				case T__13:
				case T__14:
				case T__15:
				case IF:
				case WHILE:
				case FOR:
				case RETURN:
				case NUMBER:
				case ID:
				case STRING:
				case SUB:
					{
					setState(37);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public PropertyDeclContext propertyDecl() {
			return getRuleContext(PropertyDeclContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				propertyDecl();
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				functionDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public TerminalNode VAL() { return getToken(KotlinLangParser.VAL, 0); }
		public TerminalNode VAR() { return getToken(KotlinLangParser.VAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PropertyDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterPropertyDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitPropertyDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitPropertyDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDeclContext propertyDecl() throws RecognitionException {
		PropertyDeclContext _localctx = new PropertyDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_propertyDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==VAL || _la==VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(50);
			match(ID);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(51);
				match(T__0);
				setState(52);
				type();
				}
			}

			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(55);
				match(T__1);
				setState(56);
				expr(0);
				}
			}

			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(59);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(KotlinLangParser.FUN, 0); }
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<FuncParamContext> funcParam() {
			return getRuleContexts(FuncParamContext.class);
		}
		public FuncParamContext funcParam(int i) {
			return getRuleContext(FuncParamContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(FUN);
			setState(63);
			match(ID);
			setState(64);
			match(T__3);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(65);
				funcParam();
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(66);
					match(T__4);
					setState(67);
					funcParam();
					}
					}
					setState(72);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(75);
			match(T__5);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(76);
				match(T__0);
				setState(77);
				type();
				}
			}

			setState(80);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FuncParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterFuncParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitFuncParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitFuncParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncParamContext funcParam() throws RecognitionException {
		FuncParamContext _localctx = new FuncParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(83);
			match(T__0);
			setState(84);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__6);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 553545352720L) != 0)) {
				{
				setState(89);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
				case T__8:
				case T__9:
				case T__13:
				case T__14:
				case T__15:
				case IF:
				case WHILE:
				case FOR:
				case RETURN:
				case NUMBER:
				case ID:
				case STRING:
				case SUB:
					{
					setState(87);
					stmt();
					}
					break;
				case VAL:
				case VAR:
				case FUN:
					{
					setState(88);
					declaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				assignment();
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(99);
					match(T__2);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				expr(0);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(103);
					match(T__2);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				forStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				returnStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(110);
				match(T__8);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(111);
					match(T__2);
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(114);
				match(T__9);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(115);
					match(T__2);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(ID);
			setState(121);
			match(T__1);
			setState(122);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(KotlinLangParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(RETURN);
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(125);
				expr(0);
				}
				break;
			}
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(128);
				match(T__2);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(KotlinLangParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(KotlinLangParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(IF);
			setState(132);
			match(T__3);
			setState(133);
			expr(0);
			setState(134);
			match(T__5);
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
			case IF:
			case WHILE:
			case FOR:
			case RETURN:
			case NUMBER:
			case ID:
			case STRING:
			case SUB:
				{
				setState(135);
				stmt();
				}
				break;
			case T__6:
				{
				setState(136);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(139);
				match(ELSE);
				setState(142);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__3:
				case T__8:
				case T__9:
				case T__13:
				case T__14:
				case T__15:
				case IF:
				case WHILE:
				case FOR:
				case RETURN:
				case NUMBER:
				case ID:
				case STRING:
				case SUB:
					{
					setState(140);
					stmt();
					}
					break;
				case T__6:
					{
					setState(141);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(KotlinLangParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(WHILE);
			setState(147);
			match(T__3);
			setState(148);
			expr(0);
			setState(149);
			match(T__5);
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
			case IF:
			case WHILE:
			case FOR:
			case RETURN:
			case NUMBER:
			case ID:
			case STRING:
			case SUB:
				{
				setState(150);
				stmt();
				}
				break;
			case T__6:
				{
				setState(151);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(KotlinLangParser.FOR, 0); }
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(FOR);
			setState(155);
			match(T__3);
			setState(156);
			match(ID);
			setState(157);
			match(T__10);
			setState(158);
			expr(0);
			setState(159);
			match(T__5);
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
			case IF:
			case WHILE:
			case FOR:
			case RETURN:
			case NUMBER:
			case ID:
			case STRING:
			case SUB:
				{
				setState(160);
				stmt();
				}
				break;
			case T__6:
				{
				setState(161);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(KotlinLangParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(KotlinLangParser.DIV, 0); }
		public TerminalNode REM() { return getToken(KotlinLangParser.REM, 0); }
		public TerminalNode ADD() { return getToken(KotlinLangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(KotlinLangParser.SUB, 0); }
		public TerminalNode RANGE() { return getToken(KotlinLangParser.RANGE, 0); }
		public TerminalNode GT() { return getToken(KotlinLangParser.GT, 0); }
		public TerminalNode GE() { return getToken(KotlinLangParser.GE, 0); }
		public TerminalNode LT() { return getToken(KotlinLangParser.LT, 0); }
		public TerminalNode LE() { return getToken(KotlinLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(KotlinLangParser.EQ, 0); }
		public TerminalNode NE() { return getToken(KotlinLangParser.NE, 0); }
		public TerminalNode ELVIS() { return getToken(KotlinLangParser.ELVIS, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(165);
			unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(191);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(168);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240518168576L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(169);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(171);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(172);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(174);
						match(RANGE);
						setState(175);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(177);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(178);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(180);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(181);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(183);
						match(T__11);
						setState(184);
						expr(4);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(186);
						match(T__12);
						setState(187);
						expr(3);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(189);
						match(ELVIS);
						setState(190);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(KotlinLangParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(KotlinLangParser.STRING, 0); }
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primary);
		int _la;
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				match(ID);
				setState(199);
				match(T__3);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 553514024976L) != 0)) {
					{
					setState(200);
					expr(0);
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(201);
						match(T__4);
						setState(202);
						expr(0);
						}
						}
						setState(207);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(210);
				match(T__5);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				match(ID);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				match(T__3);
				setState(213);
				expr(0);
				setState(214);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode NOT_NULL() { return getToken(KotlinLangParser.NOT_NULL, 0); }
		public TerminalNode SAFE_CALL() { return getToken(KotlinLangParser.SAFE_CALL, 0); }
		public TerminalNode ID() { return getToken(KotlinLangParser.ID, 0); }
		public PrefixOpContext prefixOp() {
			return getRuleContext(PrefixOpContext.class,0);
		}
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PostfixOpContext postfixOp() {
			return getRuleContext(PostfixOpContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unaryExpr);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				primary();
				setState(219);
				match(NOT_NULL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				primary();
				setState(222);
				match(SAFE_CALL);
				setState(223);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				prefixOp();
				setState(226);
				unaryExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				primary();
				setState(229);
				postfixOp();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
				primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixOpContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(KotlinLangParser.SUB, 0); }
		public PrefixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterPrefixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitPrefixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitPrefixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOpContext prefixOp() throws RecognitionException {
		PrefixOpContext _localctx = new PrefixOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_prefixOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 549755928576L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixOpContext extends ParserRuleContext {
		public PostfixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).enterPostfixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KotlinLangListener ) ((KotlinLangListener)listener).exitPostfixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KotlinLangVisitor ) return ((KotlinLangVisitor<? extends T>)visitor).visitPostfixOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixOpContext postfixOp() throws RecognitionException {
		PostfixOpContext _localctx = new PostfixOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_postfixOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u00ef\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002:\b\u0002\u0001\u0002\u0003\u0002=\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003E\b"+
		"\u0003\n\u0003\f\u0003H\t\u0003\u0003\u0003J\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005Z\b\u0005\n\u0005\f\u0005]\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007e\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007i\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007q\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007u\b\u0007\u0003\u0007w\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u007f\b\t\u0001"+
		"\t\u0003\t\u0082\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u008a\b\n\u0001\n\u0001\n\u0001\n\u0003\n\u008f\b\n\u0003\n\u0091\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0099\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00a3\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00c0\b\r\n\r\f\r\u00c3\t\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u00cc\b\u000e\n\u000e\f\u000e\u00cf\t\u000e\u0003"+
		"\u000e\u00d1\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00d9\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00e9\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0000\u0001\u001a\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000\u0007\u0001\u0000"+
		"\u0011\u0012\u0001\u0000#%\u0001\u0000&\'\u0001\u0000(+\u0001\u0000,-"+
		"\u0002\u0000\u000e\u0010\'\'\u0001\u0000\u000e\u000f\u010b\u0000(\u0001"+
		"\u0000\u0000\u0000\u0002/\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000"+
		"\u0000\u0006>\u0001\u0000\u0000\u0000\bR\u0001\u0000\u0000\u0000\nV\u0001"+
		"\u0000\u0000\u0000\f`\u0001\u0000\u0000\u0000\u000ev\u0001\u0000\u0000"+
		"\u0000\u0010x\u0001\u0000\u0000\u0000\u0012|\u0001\u0000\u0000\u0000\u0014"+
		"\u0083\u0001\u0000\u0000\u0000\u0016\u0092\u0001\u0000\u0000\u0000\u0018"+
		"\u009a\u0001\u0000\u0000\u0000\u001a\u00a4\u0001\u0000\u0000\u0000\u001c"+
		"\u00d8\u0001\u0000\u0000\u0000\u001e\u00e8\u0001\u0000\u0000\u0000 \u00ea"+
		"\u0001\u0000\u0000\u0000\"\u00ec\u0001\u0000\u0000\u0000$\'\u0003\u0002"+
		"\u0001\u0000%\'\u0003\u000e\u0007\u0000&$\u0001\u0000\u0000\u0000&%\u0001"+
		"\u0000\u0000\u0000\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000+,\u0005\u0000\u0000\u0001,\u0001\u0001\u0000\u0000\u0000-0\u0003"+
		"\u0004\u0002\u0000.0\u0003\u0006\u0003\u0000/-\u0001\u0000\u0000\u0000"+
		"/.\u0001\u0000\u0000\u00000\u0003\u0001\u0000\u0000\u000012\u0007\u0000"+
		"\u0000\u000025\u0005\u001e\u0000\u000034\u0005\u0001\u0000\u000046\u0003"+
		"\f\u0006\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000069\u0001"+
		"\u0000\u0000\u000078\u0005\u0002\u0000\u00008:\u0003\u001a\r\u000097\u0001"+
		"\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000"+
		";=\u0005\u0003\u0000\u0000<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000"+
		"\u0000=\u0005\u0001\u0000\u0000\u0000>?\u0005\u0013\u0000\u0000?@\u0005"+
		"\u001e\u0000\u0000@I\u0005\u0004\u0000\u0000AF\u0003\b\u0004\u0000BC\u0005"+
		"\u0005\u0000\u0000CE\u0003\b\u0004\u0000DB\u0001\u0000\u0000\u0000EH\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IA\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KN\u0005\u0006"+
		"\u0000\u0000LM\u0005\u0001\u0000\u0000MO\u0003\f\u0006\u0000NL\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0003"+
		"\n\u0005\u0000Q\u0007\u0001\u0000\u0000\u0000RS\u0005\u001e\u0000\u0000"+
		"ST\u0005\u0001\u0000\u0000TU\u0003\f\u0006\u0000U\t\u0001\u0000\u0000"+
		"\u0000V[\u0005\u0007\u0000\u0000WZ\u0003\u000e\u0007\u0000XZ\u0003\u0002"+
		"\u0001\u0000YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000Z]\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\b\u0000"+
		"\u0000_\u000b\u0001\u0000\u0000\u0000`a\u0005\u001e\u0000\u0000a\r\u0001"+
		"\u0000\u0000\u0000bd\u0003\u0010\b\u0000ce\u0005\u0003\u0000\u0000dc\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ew\u0001\u0000\u0000\u0000"+
		"fh\u0003\u001a\r\u0000gi\u0005\u0003\u0000\u0000hg\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000iw\u0001\u0000\u0000\u0000jw\u0003\u0014\n\u0000"+
		"kw\u0003\u0016\u000b\u0000lw\u0003\u0018\f\u0000mw\u0003\u0012\t\u0000"+
		"np\u0005\t\u0000\u0000oq\u0005\u0003\u0000\u0000po\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000qw\u0001\u0000\u0000\u0000rt\u0005\n\u0000\u0000"+
		"su\u0005\u0003\u0000\u0000ts\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000uw\u0001\u0000\u0000\u0000vb\u0001\u0000\u0000\u0000vf\u0001\u0000"+
		"\u0000\u0000vj\u0001\u0000\u0000\u0000vk\u0001\u0000\u0000\u0000vl\u0001"+
		"\u0000\u0000\u0000vm\u0001\u0000\u0000\u0000vn\u0001\u0000\u0000\u0000"+
		"vr\u0001\u0000\u0000\u0000w\u000f\u0001\u0000\u0000\u0000xy\u0005\u001e"+
		"\u0000\u0000yz\u0005\u0002\u0000\u0000z{\u0003\u001a\r\u0000{\u0011\u0001"+
		"\u0000\u0000\u0000|~\u0005\u0018\u0000\u0000}\u007f\u0003\u001a\r\u0000"+
		"~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081"+
		"\u0001\u0000\u0000\u0000\u0080\u0082\u0005\u0003\u0000\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0013"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0014\u0000\u0000\u0084\u0085"+
		"\u0005\u0004\u0000\u0000\u0085\u0086\u0003\u001a\r\u0000\u0086\u0089\u0005"+
		"\u0006\u0000\u0000\u0087\u008a\u0003\u000e\u0007\u0000\u0088\u008a\u0003"+
		"\n\u0005\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u0090\u0001\u0000\u0000\u0000\u008b\u008e\u0005\u0015"+
		"\u0000\u0000\u008c\u008f\u0003\u000e\u0007\u0000\u008d\u008f\u0003\n\u0005"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008d\u0001\u0000\u0000"+
		"\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090\u008b\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0015\u0001\u0000\u0000"+
		"\u0000\u0092\u0093\u0005\u0016\u0000\u0000\u0093\u0094\u0005\u0004\u0000"+
		"\u0000\u0094\u0095\u0003\u001a\r\u0000\u0095\u0098\u0005\u0006\u0000\u0000"+
		"\u0096\u0099\u0003\u000e\u0007\u0000\u0097\u0099\u0003\n\u0005\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u0017\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0017\u0000\u0000\u009b"+
		"\u009c\u0005\u0004\u0000\u0000\u009c\u009d\u0005\u001e\u0000\u0000\u009d"+
		"\u009e\u0005\u000b\u0000\u0000\u009e\u009f\u0003\u001a\r\u0000\u009f\u00a2"+
		"\u0005\u0006\u0000\u0000\u00a0\u00a3\u0003\u000e\u0007\u0000\u00a1\u00a3"+
		"\u0003\n\u0005\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a3\u0019\u0001\u0000\u0000\u0000\u00a4\u00a5\u0006"+
		"\r\uffff\uffff\u0000\u00a5\u00a6\u0003\u001e\u000f\u0000\u00a6\u00c1\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\n\b\u0000\u0000\u00a8\u00a9\u0007\u0001"+
		"\u0000\u0000\u00a9\u00c0\u0003\u001a\r\t\u00aa\u00ab\n\u0007\u0000\u0000"+
		"\u00ab\u00ac\u0007\u0002\u0000\u0000\u00ac\u00c0\u0003\u001a\r\b\u00ad"+
		"\u00ae\n\u0006\u0000\u0000\u00ae\u00af\u0005\u0019\u0000\u0000\u00af\u00c0"+
		"\u0003\u001a\r\u0007\u00b0\u00b1\n\u0005\u0000\u0000\u00b1\u00b2\u0007"+
		"\u0003\u0000\u0000\u00b2\u00c0\u0003\u001a\r\u0006\u00b3\u00b4\n\u0004"+
		"\u0000\u0000\u00b4\u00b5\u0007\u0004\u0000\u0000\u00b5\u00c0\u0003\u001a"+
		"\r\u0005\u00b6\u00b7\n\u0003\u0000\u0000\u00b7\u00b8\u0005\f\u0000\u0000"+
		"\u00b8\u00c0\u0003\u001a\r\u0004\u00b9\u00ba\n\u0002\u0000\u0000\u00ba"+
		"\u00bb\u0005\r\u0000\u0000\u00bb\u00c0\u0003\u001a\r\u0003\u00bc\u00bd"+
		"\n\u0001\u0000\u0000\u00bd\u00be\u0005\u001b\u0000\u0000\u00be\u00c0\u0003"+
		"\u001a\r\u0002\u00bf\u00a7\u0001\u0000\u0000\u0000\u00bf\u00aa\u0001\u0000"+
		"\u0000\u0000\u00bf\u00ad\u0001\u0000\u0000\u0000\u00bf\u00b0\u0001\u0000"+
		"\u0000\u0000\u00bf\u00b3\u0001\u0000\u0000\u0000\u00bf\u00b6\u0001\u0000"+
		"\u0000\u0000\u00bf\u00b9\u0001\u0000\u0000\u0000\u00bf\u00bc\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u001b\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000\u00c4\u00d9\u0005\u001d"+
		"\u0000\u0000\u00c5\u00d9\u0005\u001f\u0000\u0000\u00c6\u00c7\u0005\u001e"+
		"\u0000\u0000\u00c7\u00d0\u0005\u0004\u0000\u0000\u00c8\u00cd\u0003\u001a"+
		"\r\u0000\u00c9\u00ca\u0005\u0005\u0000\u0000\u00ca\u00cc\u0003\u001a\r"+
		"\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d0\u00c8\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d9\u0005\u0006\u0000"+
		"\u0000\u00d3\u00d9\u0005\u001e\u0000\u0000\u00d4\u00d5\u0005\u0004\u0000"+
		"\u0000\u00d5\u00d6\u0003\u001a\r\u0000\u00d6\u00d7\u0005\u0006\u0000\u0000"+
		"\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8\u00c4\u0001\u0000\u0000\u0000"+
		"\u00d8\u00c5\u0001\u0000\u0000\u0000\u00d8\u00c6\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d3\u0001\u0000\u0000\u0000\u00d8\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d9\u001d\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u001c\u000e\u0000"+
		"\u00db\u00dc\u0005\u001c\u0000\u0000\u00dc\u00e9\u0001\u0000\u0000\u0000"+
		"\u00dd\u00de\u0003\u001c\u000e\u0000\u00de\u00df\u0005\u001a\u0000\u0000"+
		"\u00df\u00e0\u0005\u001e\u0000\u0000\u00e0\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0003 \u0010\u0000\u00e2\u00e3\u0003\u001e\u000f\u0000\u00e3"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e4\u00e5\u0003\u001c\u000e\u0000\u00e5"+
		"\u00e6\u0003\"\u0011\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e9"+
		"\u0003\u001c\u000e\u0000\u00e8\u00da\u0001\u0000\u0000\u0000\u00e8\u00dd"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e1\u0001\u0000\u0000\u0000\u00e8\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u001f"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0007\u0005\u0000\u0000\u00eb!\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0007\u0006\u0000\u0000\u00ed#\u0001\u0000"+
		"\u0000\u0000\u001d&(/59<FINY[dhptv~\u0081\u0089\u008e\u0090\u0098\u00a2"+
		"\u00bf\u00c1\u00cd\u00d0\u00d8\u00e8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}