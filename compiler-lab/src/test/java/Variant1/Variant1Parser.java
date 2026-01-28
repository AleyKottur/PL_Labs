package Variant1;
// Generated from Variant1.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Variant1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__41=1, T__40=2, T__39=3, T__38=4, T__37=5, T__36=6, T__35=7, T__34=8, 
		T__33=9, T__32=10, T__31=11, T__30=12, T__29=13, T__28=14, T__27=15, T__26=16, 
		T__25=17, T__24=18, T__23=19, T__22=20, T__21=21, T__20=22, T__19=23, 
		T__18=24, T__17=25, T__16=26, T__15=27, T__14=28, T__13=29, T__12=30, 
		T__11=31, T__10=32, T__9=33, T__8=34, T__7=35, T__6=36, T__5=37, T__4=38, 
		T__3=39, T__2=40, T__1=41, T__0=42, BoolLiteral=43, StringLiteral=44, 
		CharLiteral=45, HexLiteral=46, BitLiteral=47, DecLiteral=48, Identifier=49, 
		Whitespace=50;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'char'", "'!='", "'||'", "'while'", "'{'", "';'", 
		"'>>'", "'<<'", "'&&'", "'byte'", "'='", "'}'", "'^'", "'if'", "'<='", 
		"'break'", "'uint'", "'int'", "'&'", "'do'", "'('", "'*'", "','", "'ulong'", 
		"'long'", "'>='", "'['", "'|'", "'<'", "'=='", "']'", "'~'", "'>'", "'bool'", 
		"'!'", "'string'", "'%'", "'else'", "')'", "'+'", "'-'", "BoolLiteral", 
		"StringLiteral", "CharLiteral", "HexLiteral", "BitLiteral", "DecLiteral", 
		"Identifier", "Whitespace"
	};
	public static final int
		RULE_source = 0, RULE_sourceItem = 1, RULE_funcDef = 2, RULE_funcSignature = 3, 
		RULE_argDefList = 4, RULE_argDef = 5, RULE_typeRef = 6, RULE_builtinType = 7, 
		RULE_block = 8, RULE_statement = 9, RULE_varDecl = 10, RULE_varInitList = 11, 
		RULE_varInit = 12, RULE_varDeclAssign = 13, RULE_varInitListAssign = 14, 
		RULE_varInitAssign = 15, RULE_ifStmt = 16, RULE_whileStmt = 17, RULE_doWhileStmt = 18, 
		RULE_breakStmt = 19, RULE_exprStmt = 20, RULE_expr = 21, RULE_exprList = 22, 
		RULE_binOp = 23, RULE_unOp = 24, RULE_literal = 25;
	public static final String[] ruleNames = {
		"source", "sourceItem", "funcDef", "funcSignature", "argDefList", "argDef", 
		"typeRef", "builtinType", "block", "statement", "varDecl", "varInitList", 
		"varInit", "varDeclAssign", "varInitListAssign", "varInitAssign", "ifStmt", 
		"whileStmt", "doWhileStmt", "breakStmt", "exprStmt", "expr", "exprList", 
		"binOp", "unOp", "literal"
	};

	@Override
	public String getGrammarFileName() { return "Variant1.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Variant1Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SourceContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Variant1Parser.EOF, 0); }
		public SourceItemContext sourceItem(int i) {
			return getRuleContext(SourceItemContext.class,i);
		}
		public List<SourceItemContext> sourceItem() {
			return getRuleContexts(SourceItemContext.class);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_source);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__31) | (1L << T__24) | (1L << T__23) | (1L << T__17) | (1L << T__16) | (1L << T__7) | (1L << T__5) | (1L << Identifier))) != 0)) {
				{
				{
				setState(52); sourceItem();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58); match(EOF);
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

	public static class SourceItemContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public SourceItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitSourceItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceItemContext sourceItem() throws RecognitionException {
		SourceItemContext _localctx = new SourceItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sourceItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); funcDef();
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

	public static class FuncDefContext extends ParserRuleContext {
		public FuncSignatureContext funcSignature() {
			return getRuleContext(FuncSignatureContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); funcSignature();
			setState(65);
			switch (_input.LA(1)) {
			case T__36:
				{
				setState(63); block();
				}
				break;
			case T__35:
				{
				setState(64); match(T__35);
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

	public static class FuncSignatureContext extends ParserRuleContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Variant1Parser.Identifier, 0); }
		public ArgDefListContext argDefList() {
			return getRuleContext(ArgDefListContext.class,0);
		}
		public FuncSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcSignature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitFuncSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncSignatureContext funcSignature() throws RecognitionException {
		FuncSignatureContext _localctx = new FuncSignatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(67); typeRef(0);
				}
				break;
			}
			setState(70); match(Identifier);
			setState(71); match(T__20);
			setState(73);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__31) | (1L << T__24) | (1L << T__23) | (1L << T__17) | (1L << T__16) | (1L << T__7) | (1L << T__5) | (1L << Identifier))) != 0)) {
				{
				setState(72); argDefList();
				}
			}

			setState(75); match(T__2);
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

	public static class ArgDefListContext extends ParserRuleContext {
		public List<ArgDefContext> argDef() {
			return getRuleContexts(ArgDefContext.class);
		}
		public ArgDefContext argDef(int i) {
			return getRuleContext(ArgDefContext.class,i);
		}
		public ArgDefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argDefList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitArgDefList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgDefListContext argDefList() throws RecognitionException {
		ArgDefListContext _localctx = new ArgDefListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_argDefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); argDef();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(78); match(T__18);
				setState(79); argDef();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ArgDefContext extends ParserRuleContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Variant1Parser.Identifier, 0); }
		public ArgDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitArgDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgDefContext argDef() throws RecognitionException {
		ArgDefContext _localctx = new ArgDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_argDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(85); typeRef(0);
				}
				break;
			}
			setState(88); match(Identifier);
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

	public static class TypeRefContext extends ParserRuleContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Variant1Parser.Identifier, 0); }
		public TypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitTypeRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRefContext typeRef() throws RecognitionException {
		return typeRef(0);
	}

	private TypeRefContext typeRef(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeRefContext _localctx = new TypeRefContext(_ctx, _parentState);
		TypeRefContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_typeRef, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			switch (_input.LA(1)) {
			case T__40:
			case T__31:
			case T__24:
			case T__23:
			case T__17:
			case T__16:
			case T__7:
			case T__5:
				{
				setState(91); builtinType();
				}
				break;
			case Identifier:
				{
				setState(92); match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeRefContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeRef);
					setState(95);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(96); match(T__14);
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__18) {
						{
						{
						setState(97); match(T__18);
						}
						}
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(103); match(T__10);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class BuiltinTypeContext extends ParserRuleContext {
		public BuiltinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitBuiltinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinTypeContext builtinType() throws RecognitionException {
		BuiltinTypeContext _localctx = new BuiltinTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__31) | (1L << T__24) | (1L << T__23) | (1L << T__17) | (1L << T__16) | (1L << T__7) | (1L << T__5))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class BlockContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(T__36);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__40) | (1L << T__37) | (1L << T__36) | (1L << T__31) | (1L << T__27) | (1L << T__25) | (1L << T__24) | (1L << T__23) | (1L << T__21) | (1L << T__20) | (1L << T__17) | (1L << T__16) | (1L << T__9) | (1L << T__7) | (1L << T__6) | (1L << T__5) | (1L << T__1) | (1L << T__0) | (1L << BoolLiteral) | (1L << StringLiteral) | (1L << CharLiteral) | (1L << HexLiteral) | (1L << BitLiteral) | (1L << DecLiteral) | (1L << Identifier))) != 0)) {
				{
				{
				setState(112); statement();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118); match(T__29);
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

	public static class StatementContext extends ParserRuleContext {
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public DoWhileStmtContext doWhileStmt() {
			return getRuleContext(DoWhileStmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120); varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121); ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122); whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123); doWhileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124); breakStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(125); exprStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(126); block();
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

	public static class VarDeclContext extends ParserRuleContext {
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public VarInitListContext varInitList() {
			return getRuleContext(VarInitListContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); typeRef(0);
			setState(130); varInitList();
			setState(131); match(T__35);
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

	public static class VarInitListContext extends ParserRuleContext {
		public List<VarInitContext> varInit() {
			return getRuleContexts(VarInitContext.class);
		}
		public VarInitContext varInit(int i) {
			return getRuleContext(VarInitContext.class,i);
		}
		public VarInitListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varInitList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitVarInitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarInitListContext varInitList() throws RecognitionException {
		VarInitListContext _localctx = new VarInitListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varInitList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); varInit();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(134); match(T__18);
				setState(135); varInit();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class VarInitContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Variant1Parser.Identifier, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varInit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitVarInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarInitContext varInit() throws RecognitionException {
		VarInitContext _localctx = new VarInitContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(Identifier);
			setState(144);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(142); match(T__30);
				setState(143); expr(0);
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

	public static class VarDeclAssignContext extends ParserRuleContext {
		public VarInitListAssignContext varInitListAssign() {
			return getRuleContext(VarInitListAssignContext.class,0);
		}
		public VarDeclAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclAssign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitVarDeclAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclAssignContext varDeclAssign() throws RecognitionException {
		VarDeclAssignContext _localctx = new VarDeclAssignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varDeclAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); varInitListAssign();
			setState(147); match(T__35);
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

	public static class VarInitListAssignContext extends ParserRuleContext {
		public VarInitAssignContext varInitAssign() {
			return getRuleContext(VarInitAssignContext.class,0);
		}
		public VarInitListAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varInitListAssign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitVarInitListAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarInitListAssignContext varInitListAssign() throws RecognitionException {
		VarInitListAssignContext _localctx = new VarInitListAssignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varInitListAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); varInitAssign();
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

	public static class VarInitAssignContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Variant1Parser.Identifier, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarInitAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varInitAssign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitVarInitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarInitAssignContext varInitAssign() throws RecognitionException {
		VarInitAssignContext _localctx = new VarInitAssignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varInitAssign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(Identifier);
			setState(154);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(152); match(T__30);
				setState(153); expr(0);
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

	public static class IfStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(T__27);
			setState(157); match(T__20);
			setState(158); expr(0);
			setState(159); match(T__2);
			setState(160); statement();
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(161); match(T__3);
				setState(162); statement();
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

	public static class WhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(T__37);
			setState(166); match(T__20);
			setState(167); expr(0);
			setState(168); match(T__2);
			setState(169); statement();
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

	public static class DoWhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DoWhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitDoWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStmtContext doWhileStmt() throws RecognitionException {
		DoWhileStmtContext _localctx = new DoWhileStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_doWhileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); match(T__21);
			setState(172); block();
			setState(173); match(T__37);
			setState(174); match(T__20);
			setState(175); expr(0);
			setState(176); match(T__2);
			setState(177); match(T__35);
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

	public static class BreakStmtContext extends ParserRuleContext {
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(T__25);
			setState(180); match(T__35);
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

	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); expr(0);
			setState(183); match(T__35);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallContext extends ExprContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexerContext extends ExprContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IndexerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitIndexer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LitContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode Identifier() { return getToken(Variant1Parser.Identifier, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryContext extends ExprContext {
		public BinOpContext binOp() {
			return getRuleContext(BinOpContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryContext extends ExprContext {
		public UnOpContext unOp() {
			return getRuleContext(UnOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitParen(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			switch (_input.LA(1)) {
			case T__9:
			case T__6:
			case T__1:
			case T__0:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(186); unOp();
				setState(187); expr(6);
				}
				break;
			case T__20:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189); match(T__20);
				setState(190); expr(0);
				setState(191); match(T__2);
				}
				break;
			case Identifier:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193); match(Identifier);
				}
				break;
			case BoolLiteral:
			case StringLiteral:
			case CharLiteral:
			case HexLiteral:
			case BitLiteral:
			case DecLiteral:
				{
				_localctx = new LitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(198); binOp();
						setState(199); expr(8);
						}
						break;
					case 2:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(202); match(T__30);
						setState(206);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(203); expr(0);
								}
								} 
							}
							setState(208);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
						}
						}
						break;
					case 3:
						{
						_localctx = new CallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(210); match(T__20);
						setState(212);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << BoolLiteral) | (1L << StringLiteral) | (1L << CharLiteral) | (1L << HexLiteral) | (1L << BitLiteral) | (1L << DecLiteral) | (1L << Identifier))) != 0)) {
							{
							setState(211); exprList();
							}
						}

						setState(214); match(T__2);
						}
						break;
					case 4:
						{
						_localctx = new IndexerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(216); match(T__14);
						setState(218);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0) | (1L << BoolLiteral) | (1L << StringLiteral) | (1L << CharLiteral) | (1L << HexLiteral) | (1L << BitLiteral) | (1L << DecLiteral) | (1L << Identifier))) != 0)) {
							{
							setState(217); exprList();
							}
						}

						setState(220); match(T__10);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); expr(0);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(227); match(T__18);
				setState(228); expr(0);
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class BinOpContext extends ParserRuleContext {
		public BinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitBinOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinOpContext binOp() throws RecognitionException {
		BinOpContext _localctx = new BinOpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_binOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__39) | (1L << T__38) | (1L << T__34) | (1L << T__33) | (1L << T__32) | (1L << T__28) | (1L << T__26) | (1L << T__22) | (1L << T__19) | (1L << T__15) | (1L << T__13) | (1L << T__12) | (1L << T__11) | (1L << T__8) | (1L << T__4) | (1L << T__1) | (1L << T__0))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class UnOpContext extends ParserRuleContext {
		public UnOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitUnOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnOpContext unOp() throws RecognitionException {
		UnOpContext _localctx = new UnOpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__6) | (1L << T__1) | (1L << T__0))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode HexLiteral() { return getToken(Variant1Parser.HexLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(Variant1Parser.StringLiteral, 0); }
		public TerminalNode CharLiteral() { return getToken(Variant1Parser.CharLiteral, 0); }
		public TerminalNode BoolLiteral() { return getToken(Variant1Parser.BoolLiteral, 0); }
		public TerminalNode BitLiteral() { return getToken(Variant1Parser.BitLiteral, 0); }
		public TerminalNode DecLiteral() { return getToken(Variant1Parser.DecLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Variant1Visitor ) return ((Variant1Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BoolLiteral) | (1L << StringLiteral) | (1L << CharLiteral) | (1L << HexLiteral) | (1L << BitLiteral) | (1L << DecLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		case 6: return typeRef_sempred((TypeRefContext)_localctx, predIndex);
		case 21: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 7);
		case 2: return precpred(_ctx, 8);
		case 3: return precpred(_ctx, 4);
		case 4: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean typeRef_sempred(TypeRefContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\64\u00f3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\4\5\4D\n\4\3\5\5\5G\n\5\3\5\3\5\3\5\5\5L\n\5\3\5\3\5\3\6\3\6\3\6"+
		"\7\6S\n\6\f\6\16\6V\13\6\3\7\5\7Y\n\7\3\7\3\7\3\b\3\b\3\b\5\b`\n\b\3\b"+
		"\3\b\3\b\7\be\n\b\f\b\16\bh\13\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\t\3\t\3"+
		"\n\3\n\7\nt\n\n\f\n\16\nw\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0082\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u008b\n\r\f\r\16\r"+
		"\u008e\13\r\3\16\3\16\3\16\5\16\u0093\n\16\3\17\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\21\5\21\u009d\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00a6\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00c6\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\7\27\u00cf\n\27\f\27\16\27\u00d2\13\27\3\27\3\27\3\27\5\27\u00d7\n\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00dd\n\27\3\27\7\27\u00e0\n\27\f\27\16\27\u00e3"+
		"\13\27\3\30\3\30\3\30\7\30\u00e8\n\30\f\30\16\30\u00eb\13\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\33\2\4\16,\34\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\2\6\b\2\4\4\r\r\24\25\33\34%%\'\'\16\2\3\3\5"+
		"\6\n\f\20\20\22\22\26\26\31\31\35\35\37!$$((+,\5\2##&&+,\3\2-\62\u00f7"+
		"\29\3\2\2\2\4>\3\2\2\2\6@\3\2\2\2\bF\3\2\2\2\nO\3\2\2\2\fX\3\2\2\2\16"+
		"_\3\2\2\2\20o\3\2\2\2\22q\3\2\2\2\24\u0081\3\2\2\2\26\u0083\3\2\2\2\30"+
		"\u0087\3\2\2\2\32\u008f\3\2\2\2\34\u0094\3\2\2\2\36\u0097\3\2\2\2 \u0099"+
		"\3\2\2\2\"\u009e\3\2\2\2$\u00a7\3\2\2\2&\u00ad\3\2\2\2(\u00b5\3\2\2\2"+
		"*\u00b8\3\2\2\2,\u00c5\3\2\2\2.\u00e4\3\2\2\2\60\u00ec\3\2\2\2\62\u00ee"+
		"\3\2\2\2\64\u00f0\3\2\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2"+
		"\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\2\2\3=\3\3\2\2\2>?\5\6\4\2?\5\3"+
		"\2\2\2@C\5\b\5\2AD\5\22\n\2BD\7\t\2\2CA\3\2\2\2CB\3\2\2\2D\7\3\2\2\2E"+
		"G\5\16\b\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\63\2\2IK\7\30\2\2JL\5\n\6"+
		"\2KJ\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7*\2\2N\t\3\2\2\2OT\5\f\7\2PQ\7\32"+
		"\2\2QS\5\f\7\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\13\3\2\2\2VT\3"+
		"\2\2\2WY\5\16\b\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\63\2\2[\r\3\2\2\2"+
		"\\]\b\b\1\2]`\5\20\t\2^`\7\63\2\2_\\\3\2\2\2_^\3\2\2\2`l\3\2\2\2ab\f\3"+
		"\2\2bf\7\36\2\2ce\7\32\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3"+
		"\2\2\2hf\3\2\2\2ik\7\"\2\2ja\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\17"+
		"\3\2\2\2nl\3\2\2\2op\t\2\2\2p\21\3\2\2\2qu\7\b\2\2rt\5\24\13\2sr\3\2\2"+
		"\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7\17\2\2y\23\3"+
		"\2\2\2z\u0082\5\26\f\2{\u0082\5\"\22\2|\u0082\5$\23\2}\u0082\5&\24\2~"+
		"\u0082\5(\25\2\177\u0082\5*\26\2\u0080\u0082\5\22\n\2\u0081z\3\2\2\2\u0081"+
		"{\3\2\2\2\u0081|\3\2\2\2\u0081}\3\2\2\2\u0081~\3\2\2\2\u0081\177\3\2\2"+
		"\2\u0081\u0080\3\2\2\2\u0082\25\3\2\2\2\u0083\u0084\5\16\b\2\u0084\u0085"+
		"\5\30\r\2\u0085\u0086\7\t\2\2\u0086\27\3\2\2\2\u0087\u008c\5\32\16\2\u0088"+
		"\u0089\7\32\2\2\u0089\u008b\5\32\16\2\u008a\u0088\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\31\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0092\7\63\2\2\u0090\u0091\7\16\2\2\u0091\u0093\5"+
		",\27\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\33\3\2\2\2\u0094"+
		"\u0095\5\36\20\2\u0095\u0096\7\t\2\2\u0096\35\3\2\2\2\u0097\u0098\5 \21"+
		"\2\u0098\37\3\2\2\2\u0099\u009c\7\63\2\2\u009a\u009b\7\16\2\2\u009b\u009d"+
		"\5,\27\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d!\3\2\2\2\u009e"+
		"\u009f\7\21\2\2\u009f\u00a0\7\30\2\2\u00a0\u00a1\5,\27\2\u00a1\u00a2\7"+
		"*\2\2\u00a2\u00a5\5\24\13\2\u00a3\u00a4\7)\2\2\u00a4\u00a6\5\24\13\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6#\3\2\2\2\u00a7\u00a8\7\7\2\2"+
		"\u00a8\u00a9\7\30\2\2\u00a9\u00aa\5,\27\2\u00aa\u00ab\7*\2\2\u00ab\u00ac"+
		"\5\24\13\2\u00ac%\3\2\2\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\5\22\n\2\u00af"+
		"\u00b0\7\7\2\2\u00b0\u00b1\7\30\2\2\u00b1\u00b2\5,\27\2\u00b2\u00b3\7"+
		"*\2\2\u00b3\u00b4\7\t\2\2\u00b4\'\3\2\2\2\u00b5\u00b6\7\23\2\2\u00b6\u00b7"+
		"\7\t\2\2\u00b7)\3\2\2\2\u00b8\u00b9\5,\27\2\u00b9\u00ba\7\t\2\2\u00ba"+
		"+\3\2\2\2\u00bb\u00bc\b\27\1\2\u00bc\u00bd\5\62\32\2\u00bd\u00be\5,\27"+
		"\b\u00be\u00c6\3\2\2\2\u00bf\u00c0\7\30\2\2\u00c0\u00c1\5,\27\2\u00c1"+
		"\u00c2\7*\2\2\u00c2\u00c6\3\2\2\2\u00c3\u00c6\7\63\2\2\u00c4\u00c6\5\64"+
		"\33\2\u00c5\u00bb\3\2\2\2\u00c5\u00bf\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c4\3\2\2\2\u00c6\u00e1\3\2\2\2\u00c7\u00c8\f\t\2\2\u00c8\u00c9\5\60"+
		"\31\2\u00c9\u00ca\5,\27\n\u00ca\u00e0\3\2\2\2\u00cb\u00cc\f\n\2\2\u00cc"+
		"\u00d0\7\16\2\2\u00cd\u00cf\5,\27\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3"+
		"\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00e0\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d4\f\6\2\2\u00d4\u00d6\7\30\2\2\u00d5\u00d7\5"+
		".\30\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00e0\7*\2\2\u00d9\u00da\f\5\2\2\u00da\u00dc\7\36\2\2\u00db\u00dd\5."+
		"\30\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00e0\7\"\2\2\u00df\u00c7\3\2\2\2\u00df\u00cb\3\2\2\2\u00df\u00d3\3\2"+
		"\2\2\u00df\u00d9\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2-\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e9\5,\27\2"+
		"\u00e5\u00e6\7\32\2\2\u00e6\u00e8\5,\27\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea/\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\t\3\2\2\u00ed\61\3\2\2\2\u00ee\u00ef\t\4\2"+
		"\2\u00ef\63\3\2\2\2\u00f0\u00f1\t\5\2\2\u00f1\65\3\2\2\2\309CFKTX_flu"+
		"\u0081\u008c\u0092\u009c\u00a5\u00c5\u00d0\u00d6\u00dc\u00df\u00e1\u00e9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}