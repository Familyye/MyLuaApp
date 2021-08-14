// Generated from D:/android studio project/MyLuaApp2/LuaAnalysis/src/main/java/com/dingyi/lua/analysis/parser\Lua.g4 by ANTLR 4.9.1
package com.dingyi.lua.analysis.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LuaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, NAME=64, NORMALSTRING=65, CHARSTRING=66, 
		LONGSTRING=67, INT=68, HEX=69, FLOAT=70, HEX_FLOAT=71, COMMENT=72, LINE_COMMENT=73, 
		WS=74, SHEBANG=75;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "NAME", "NORMALSTRING", 
			"CHARSTRING", "LONGSTRING", "NESTED_STR", "INT", "HEX", "FLOAT", "HEX_FLOAT", 
			"ExponentPart", "HexExponentPart", "EscapeSequence", "DecimalEscape", 
			"HexEscape", "UtfEscape", "Digit", "HexDigit", "COMMENT", "LINE_COMMENT", 
			"WS", "SHEBANG"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'break'", "'continue'", "'goto'", "'do'", "'end'", 
			"'while'", "'repeat'", "'until'", "'if'", "'then'", "'for'", "','", "'in'", 
			"'function'", "'local'", "'switch'", "'when'", "'else'", "'lambda'", 
			"'defer'", "'elseif'", "'default'", "'case'", "':'", "'<'", "'>'", "'return'", 
			"'::'", "'@'", "'.'", "'nil'", "'false'", "'true'", "'...'", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'or'", "'and'", "'<='", "'>='", "'~='", 
			"'=='", "'..'", "'+'", "'-'", "'*'", "'/'", "'%'", "'//'", "'&'", "'|'", 
			"'~'", "'<<'", "'>>'", "'not'", "'#'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "NAME", "NORMALSTRING", "CHARSTRING", "LONGSTRING", 
			"INT", "HEX", "FLOAT", "HEX_FLOAT", "COMMENT", "LINE_COMMENT", "WS", 
			"SHEBANG"
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


	public LuaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lua.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2M\u029c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3/"+
		"\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\39\39\3:\3:\3;\3;\3<\3<\3<\3="+
		"\3=\3=\3>\3>\3>\3>\3?\3?\3@\3@\3A\3A\7A\u019c\nA\fA\16A\u019f\13A\3B\3"+
		"B\3B\7B\u01a4\nB\fB\16B\u01a7\13B\3B\3B\3C\3C\3C\7C\u01ae\nC\fC\16C\u01b1"+
		"\13C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\7E\u01bf\nE\fE\16E\u01c2\13E"+
		"\3E\5E\u01c5\nE\3F\6F\u01c8\nF\rF\16F\u01c9\3G\3G\3G\6G\u01cf\nG\rG\16"+
		"G\u01d0\3H\6H\u01d4\nH\rH\16H\u01d5\3H\3H\7H\u01da\nH\fH\16H\u01dd\13"+
		"H\3H\5H\u01e0\nH\3H\3H\6H\u01e4\nH\rH\16H\u01e5\3H\5H\u01e9\nH\3H\6H\u01ec"+
		"\nH\rH\16H\u01ed\3H\3H\5H\u01f2\nH\3I\3I\3I\6I\u01f7\nI\rI\16I\u01f8\3"+
		"I\3I\7I\u01fd\nI\fI\16I\u0200\13I\3I\5I\u0203\nI\3I\3I\3I\3I\6I\u0209"+
		"\nI\rI\16I\u020a\3I\5I\u020e\nI\3I\3I\3I\6I\u0213\nI\rI\16I\u0214\3I\3"+
		"I\5I\u0219\nI\3J\3J\5J\u021d\nJ\3J\6J\u0220\nJ\rJ\16J\u0221\3K\3K\5K\u0226"+
		"\nK\3K\6K\u0229\nK\rK\16K\u022a\3L\3L\3L\3L\5L\u0231\nL\3L\3L\3L\3L\5"+
		"L\u0237\nL\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\3M\5M\u0244\nM\3N\3N\3N\3N\3"+
		"N\3O\3O\3O\3O\3O\6O\u0250\nO\rO\16O\u0251\3O\3O\3P\3P\3Q\3Q\3R\3R\3R\3"+
		"R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\7S\u0269\nS\fS\16S\u026c\13S\3S\3S"+
		"\7S\u0270\nS\fS\16S\u0273\13S\3S\3S\7S\u0277\nS\fS\16S\u027a\13S\3S\3"+
		"S\7S\u027e\nS\fS\16S\u0281\13S\5S\u0283\nS\3S\3S\3S\5S\u0288\nS\3S\3S"+
		"\3T\6T\u028d\nT\rT\16T\u028e\3T\3T\3U\3U\3U\7U\u0296\nU\fU\16U\u0299\13"+
		"U\3U\3U\3\u01c0\2V\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089"+
		"\2\u008bF\u008dG\u008fH\u0091I\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2"+
		"\u009d\2\u009f\2\u00a1\2\u00a3J\u00a5K\u00a7L\u00a9M\3\2\23\5\2C\\aac"+
		"|\6\2\62;C\\aac|\4\2$$^^\4\2))^^\4\2ZZzz\4\2GGgg\4\2--//\4\2RRrr\f\2$"+
		"$))^^cdhhppttvvxx||\3\2\62\64\3\2\62;\5\2\62;CHch\6\2\f\f\17\17??]]\4"+
		"\2\f\f\17\17\5\2\f\f\17\17]]\4\3\f\f\17\17\5\2\13\f\16\17\"\"\2\u02c1"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2"+
		"\2\2\u0091\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\3\u00ab\3\2\2\2\5\u00ad\3\2\2\2\7\u00af\3\2\2\2\t\u00b5\3\2\2"+
		"\2\13\u00be\3\2\2\2\r\u00c3\3\2\2\2\17\u00c6\3\2\2\2\21\u00ca\3\2\2\2"+
		"\23\u00d0\3\2\2\2\25\u00d7\3\2\2\2\27\u00dd\3\2\2\2\31\u00e0\3\2\2\2\33"+
		"\u00e5\3\2\2\2\35\u00e9\3\2\2\2\37\u00eb\3\2\2\2!\u00ee\3\2\2\2#\u00f7"+
		"\3\2\2\2%\u00fd\3\2\2\2\'\u0104\3\2\2\2)\u0109\3\2\2\2+\u010e\3\2\2\2"+
		"-\u0115\3\2\2\2/\u011b\3\2\2\2\61\u0122\3\2\2\2\63\u012a\3\2\2\2\65\u012f"+
		"\3\2\2\2\67\u0131\3\2\2\29\u0133\3\2\2\2;\u0135\3\2\2\2=\u013c\3\2\2\2"+
		"?\u013f\3\2\2\2A\u0141\3\2\2\2C\u0143\3\2\2\2E\u0147\3\2\2\2G\u014d\3"+
		"\2\2\2I\u0152\3\2\2\2K\u0156\3\2\2\2M\u0158\3\2\2\2O\u015a\3\2\2\2Q\u015c"+
		"\3\2\2\2S\u015e\3\2\2\2U\u0160\3\2\2\2W\u0162\3\2\2\2Y\u0165\3\2\2\2["+
		"\u0169\3\2\2\2]\u016c\3\2\2\2_\u016f\3\2\2\2a\u0172\3\2\2\2c\u0175\3\2"+
		"\2\2e\u0178\3\2\2\2g\u017a\3\2\2\2i\u017c\3\2\2\2k\u017e\3\2\2\2m\u0180"+
		"\3\2\2\2o\u0182\3\2\2\2q\u0185\3\2\2\2s\u0187\3\2\2\2u\u0189\3\2\2\2w"+
		"\u018b\3\2\2\2y\u018e\3\2\2\2{\u0191\3\2\2\2}\u0195\3\2\2\2\177\u0197"+
		"\3\2\2\2\u0081\u0199\3\2\2\2\u0083\u01a0\3\2\2\2\u0085\u01aa\3\2\2\2\u0087"+
		"\u01b4\3\2\2\2\u0089\u01c4\3\2\2\2\u008b\u01c7\3\2\2\2\u008d\u01cb\3\2"+
		"\2\2\u008f\u01f1\3\2\2\2\u0091\u0218\3\2\2\2\u0093\u021a\3\2\2\2\u0095"+
		"\u0223\3\2\2\2\u0097\u0236\3\2\2\2\u0099\u0243\3\2\2\2\u009b\u0245\3\2"+
		"\2\2\u009d\u024a\3\2\2\2\u009f\u0255\3\2\2\2\u00a1\u0257\3\2\2\2\u00a3"+
		"\u0259\3\2\2\2\u00a5\u0262\3\2\2\2\u00a7\u028c\3\2\2\2\u00a9\u0292\3\2"+
		"\2\2\u00ab\u00ac\7=\2\2\u00ac\4\3\2\2\2\u00ad\u00ae\7?\2\2\u00ae\6\3\2"+
		"\2\2\u00af\u00b0\7d\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3"+
		"\7c\2\2\u00b3\u00b4\7m\2\2\u00b4\b\3\2\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7"+
		"\7q\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7k\2\2\u00ba"+
		"\u00bb\7p\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7g\2\2\u00bd\n\3\2\2\2\u00be"+
		"\u00bf\7i\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7q\2\2"+
		"\u00c2\f\3\2\2\2\u00c3\u00c4\7f\2\2\u00c4\u00c5\7q\2\2\u00c5\16\3\2\2"+
		"\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7f\2\2\u00c9\20\3"+
		"\2\2\2\u00ca\u00cb\7y\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7k\2\2\u00cd"+
		"\u00ce\7n\2\2\u00ce\u00cf\7g\2\2\u00cf\22\3\2\2\2\u00d0\u00d1\7t\2\2\u00d1"+
		"\u00d2\7g\2\2\u00d2\u00d3\7r\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7c\2\2"+
		"\u00d5\u00d6\7v\2\2\u00d6\24\3\2\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7"+
		"p\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7n\2\2\u00dc\26"+
		"\3\2\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7h\2\2\u00df\30\3\2\2\2\u00e0"+
		"\u00e1\7v\2\2\u00e1\u00e2\7j\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7p\2\2"+
		"\u00e4\32\3\2\2\2\u00e5\u00e6\7h\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7"+
		"t\2\2\u00e8\34\3\2\2\2\u00e9\u00ea\7.\2\2\u00ea\36\3\2\2\2\u00eb\u00ec"+
		"\7k\2\2\u00ec\u00ed\7p\2\2\u00ed \3\2\2\2\u00ee\u00ef\7h\2\2\u00ef\u00f0"+
		"\7w\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7e\2\2\u00f2\u00f3\7v\2\2\u00f3"+
		"\u00f4\7k\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7p\2\2\u00f6\"\3\2\2\2\u00f7"+
		"\u00f8\7n\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7e\2\2\u00fa\u00fb\7c\2\2"+
		"\u00fb\u00fc\7n\2\2\u00fc$\3\2\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7y\2"+
		"\2\u00ff\u0100\7k\2\2\u0100\u0101\7v\2\2\u0101\u0102\7e\2\2\u0102\u0103"+
		"\7j\2\2\u0103&\3\2\2\2\u0104\u0105\7y\2\2\u0105\u0106\7j\2\2\u0106\u0107"+
		"\7g\2\2\u0107\u0108\7p\2\2\u0108(\3\2\2\2\u0109\u010a\7g\2\2\u010a\u010b"+
		"\7n\2\2\u010b\u010c\7u\2\2\u010c\u010d\7g\2\2\u010d*\3\2\2\2\u010e\u010f"+
		"\7n\2\2\u010f\u0110\7c\2\2\u0110\u0111\7o\2\2\u0111\u0112\7d\2\2\u0112"+
		"\u0113\7f\2\2\u0113\u0114\7c\2\2\u0114,\3\2\2\2\u0115\u0116\7f\2\2\u0116"+
		"\u0117\7g\2\2\u0117\u0118\7h\2\2\u0118\u0119\7g\2\2\u0119\u011a\7t\2\2"+
		"\u011a.\3\2\2\2\u011b\u011c\7g\2\2\u011c\u011d\7n\2\2\u011d\u011e\7u\2"+
		"\2\u011e\u011f\7g\2\2\u011f\u0120\7k\2\2\u0120\u0121\7h\2\2\u0121\60\3"+
		"\2\2\2\u0122\u0123\7f\2\2\u0123\u0124\7g\2\2\u0124\u0125\7h\2\2\u0125"+
		"\u0126\7c\2\2\u0126\u0127\7w\2\2\u0127\u0128\7n\2\2\u0128\u0129\7v\2\2"+
		"\u0129\62\3\2\2\2\u012a\u012b\7e\2\2\u012b\u012c\7c\2\2\u012c\u012d\7"+
		"u\2\2\u012d\u012e\7g\2\2\u012e\64\3\2\2\2\u012f\u0130\7<\2\2\u0130\66"+
		"\3\2\2\2\u0131\u0132\7>\2\2\u01328\3\2\2\2\u0133\u0134\7@\2\2\u0134:\3"+
		"\2\2\2\u0135\u0136\7t\2\2\u0136\u0137\7g\2\2\u0137\u0138\7v\2\2\u0138"+
		"\u0139\7w\2\2\u0139\u013a\7t\2\2\u013a\u013b\7p\2\2\u013b<\3\2\2\2\u013c"+
		"\u013d\7<\2\2\u013d\u013e\7<\2\2\u013e>\3\2\2\2\u013f\u0140\7B\2\2\u0140"+
		"@\3\2\2\2\u0141\u0142\7\60\2\2\u0142B\3\2\2\2\u0143\u0144\7p\2\2\u0144"+
		"\u0145\7k\2\2\u0145\u0146\7n\2\2\u0146D\3\2\2\2\u0147\u0148\7h\2\2\u0148"+
		"\u0149\7c\2\2\u0149\u014a\7n\2\2\u014a\u014b\7u\2\2\u014b\u014c\7g\2\2"+
		"\u014cF\3\2\2\2\u014d\u014e\7v\2\2\u014e\u014f\7t\2\2\u014f\u0150\7w\2"+
		"\2\u0150\u0151\7g\2\2\u0151H\3\2\2\2\u0152\u0153\7\60\2\2\u0153\u0154"+
		"\7\60\2\2\u0154\u0155\7\60\2\2\u0155J\3\2\2\2\u0156\u0157\7*\2\2\u0157"+
		"L\3\2\2\2\u0158\u0159\7+\2\2\u0159N\3\2\2\2\u015a\u015b\7]\2\2\u015bP"+
		"\3\2\2\2\u015c\u015d\7_\2\2\u015dR\3\2\2\2\u015e\u015f\7}\2\2\u015fT\3"+
		"\2\2\2\u0160\u0161\7\177\2\2\u0161V\3\2\2\2\u0162\u0163\7q\2\2\u0163\u0164"+
		"\7t\2\2\u0164X\3\2\2\2\u0165\u0166\7c\2\2\u0166\u0167\7p\2\2\u0167\u0168"+
		"\7f\2\2\u0168Z\3\2\2\2\u0169\u016a\7>\2\2\u016a\u016b\7?\2\2\u016b\\\3"+
		"\2\2\2\u016c\u016d\7@\2\2\u016d\u016e\7?\2\2\u016e^\3\2\2\2\u016f\u0170"+
		"\7\u0080\2\2\u0170\u0171\7?\2\2\u0171`\3\2\2\2\u0172\u0173\7?\2\2\u0173"+
		"\u0174\7?\2\2\u0174b\3\2\2\2\u0175\u0176\7\60\2\2\u0176\u0177\7\60\2\2"+
		"\u0177d\3\2\2\2\u0178\u0179\7-\2\2\u0179f\3\2\2\2\u017a\u017b\7/\2\2\u017b"+
		"h\3\2\2\2\u017c\u017d\7,\2\2\u017dj\3\2\2\2\u017e\u017f\7\61\2\2\u017f"+
		"l\3\2\2\2\u0180\u0181\7\'\2\2\u0181n\3\2\2\2\u0182\u0183\7\61\2\2\u0183"+
		"\u0184\7\61\2\2\u0184p\3\2\2\2\u0185\u0186\7(\2\2\u0186r\3\2\2\2\u0187"+
		"\u0188\7~\2\2\u0188t\3\2\2\2\u0189\u018a\7\u0080\2\2\u018av\3\2\2\2\u018b"+
		"\u018c\7>\2\2\u018c\u018d\7>\2\2\u018dx\3\2\2\2\u018e\u018f\7@\2\2\u018f"+
		"\u0190\7@\2\2\u0190z\3\2\2\2\u0191\u0192\7p\2\2\u0192\u0193\7q\2\2\u0193"+
		"\u0194\7v\2\2\u0194|\3\2\2\2\u0195\u0196\7%\2\2\u0196~\3\2\2\2\u0197\u0198"+
		"\7`\2\2\u0198\u0080\3\2\2\2\u0199\u019d\t\2\2\2\u019a\u019c\t\3\2\2\u019b"+
		"\u019a\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2"+
		"\2\2\u019e\u0082\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u01a5\7$\2\2\u01a1"+
		"\u01a4\5\u0097L\2\u01a2\u01a4\n\4\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a2"+
		"\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\u01a8\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01a9\7$\2\2\u01a9\u0084\3\2"+
		"\2\2\u01aa\u01af\7)\2\2\u01ab\u01ae\5\u0097L\2\u01ac\u01ae\n\5\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ad\u01ac\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2"+
		"\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2"+
		"\u01b3\7)\2\2\u01b3\u0086\3\2\2\2\u01b4\u01b5\7]\2\2\u01b5\u01b6\5\u0089"+
		"E\2\u01b6\u01b7\7_\2\2\u01b7\u0088\3\2\2\2\u01b8\u01b9\7?\2\2\u01b9\u01ba"+
		"\5\u0089E\2\u01ba\u01bb\7?\2\2\u01bb\u01c5\3\2\2\2\u01bc\u01c0\7]\2\2"+
		"\u01bd\u01bf\13\2\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c2\3\2\2\2\u01c0\u01c1"+
		"\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c3\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c3"+
		"\u01c5\7_\2\2\u01c4\u01b8\3\2\2\2\u01c4\u01bc\3\2\2\2\u01c5\u008a\3\2"+
		"\2\2\u01c6\u01c8\5\u009fP\2\u01c7\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9"+
		"\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u008c\3\2\2\2\u01cb\u01cc\7\62"+
		"\2\2\u01cc\u01ce\t\6\2\2\u01cd\u01cf\5\u00a1Q\2\u01ce\u01cd\3\2\2\2\u01cf"+
		"\u01d0\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u008e\3\2"+
		"\2\2\u01d2\u01d4\5\u009fP\2\u01d3\u01d2\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5"+
		"\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01db\7\60"+
		"\2\2\u01d8\u01da\5\u009fP\2\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db"+
		"\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2"+
		"\2\2\u01de\u01e0\5\u0093J\2\u01df\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0"+
		"\u01f2\3\2\2\2\u01e1\u01e3\7\60\2\2\u01e2\u01e4\5\u009fP\2\u01e3\u01e2"+
		"\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6"+
		"\u01e8\3\2\2\2\u01e7\u01e9\5\u0093J\2\u01e8\u01e7\3\2\2\2\u01e8\u01e9"+
		"\3\2\2\2\u01e9\u01f2\3\2\2\2\u01ea\u01ec\5\u009fP\2\u01eb\u01ea\3\2\2"+
		"\2\u01ec\u01ed\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01ef"+
		"\3\2\2\2\u01ef\u01f0\5\u0093J\2\u01f0\u01f2\3\2\2\2\u01f1\u01d3\3\2\2"+
		"\2\u01f1\u01e1\3\2\2\2\u01f1\u01eb\3\2\2\2\u01f2\u0090\3\2\2\2\u01f3\u01f4"+
		"\7\62\2\2\u01f4\u01f6\t\6\2\2\u01f5\u01f7\5\u00a1Q\2\u01f6\u01f5\3\2\2"+
		"\2\u01f7\u01f8\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa"+
		"\3\2\2\2\u01fa\u01fe\7\60\2\2\u01fb\u01fd\5\u00a1Q\2\u01fc\u01fb\3\2\2"+
		"\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0202"+
		"\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0203\5\u0095K\2\u0202\u0201\3\2\2"+
		"\2\u0202\u0203\3\2\2\2\u0203\u0219\3\2\2\2\u0204\u0205\7\62\2\2\u0205"+
		"\u0206\t\6\2\2\u0206\u0208\7\60\2\2\u0207\u0209\5\u00a1Q\2\u0208\u0207"+
		"\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b"+
		"\u020d\3\2\2\2\u020c\u020e\5\u0095K\2\u020d\u020c\3\2\2\2\u020d\u020e"+
		"\3\2\2\2\u020e\u0219\3\2\2\2\u020f\u0210\7\62\2\2\u0210\u0212\t\6\2\2"+
		"\u0211\u0213\5\u00a1Q\2\u0212\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214"+
		"\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\5\u0095"+
		"K\2\u0217\u0219\3\2\2\2\u0218\u01f3\3\2\2\2\u0218\u0204\3\2\2\2\u0218"+
		"\u020f\3\2\2\2\u0219\u0092\3\2\2\2\u021a\u021c\t\7\2\2\u021b\u021d\t\b"+
		"\2\2\u021c\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021f\3\2\2\2\u021e"+
		"\u0220\5\u009fP\2\u021f\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u021f"+
		"\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0094\3\2\2\2\u0223\u0225\t\t\2\2\u0224"+
		"\u0226\t\b\2\2\u0225\u0224\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0228\3\2"+
		"\2\2\u0227\u0229\5\u009fP\2\u0228\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a"+
		"\u0228\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u0096\3\2\2\2\u022c\u022d\7^"+
		"\2\2\u022d\u0237\t\n\2\2\u022e\u0230\7^\2\2\u022f\u0231\7\17\2\2\u0230"+
		"\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0232\3\2\2\2\u0232\u0237\7\f"+
		"\2\2\u0233\u0237\5\u0099M\2\u0234\u0237\5\u009bN\2\u0235\u0237\5\u009d"+
		"O\2\u0236\u022c\3\2\2\2\u0236\u022e\3\2\2\2\u0236\u0233\3\2\2\2\u0236"+
		"\u0234\3\2\2\2\u0236\u0235\3\2\2\2\u0237\u0098\3\2\2\2\u0238\u0239\7^"+
		"\2\2\u0239\u0244\5\u009fP\2\u023a\u023b\7^\2\2\u023b\u023c\5\u009fP\2"+
		"\u023c\u023d\5\u009fP\2\u023d\u0244\3\2\2\2\u023e\u023f\7^\2\2\u023f\u0240"+
		"\t\13\2\2\u0240\u0241\5\u009fP\2\u0241\u0242\5\u009fP\2\u0242\u0244\3"+
		"\2\2\2\u0243\u0238\3\2\2\2\u0243\u023a\3\2\2\2\u0243\u023e\3\2\2\2\u0244"+
		"\u009a\3\2\2\2\u0245\u0246\7^\2\2\u0246\u0247\7z\2\2\u0247\u0248\5\u00a1"+
		"Q\2\u0248\u0249\5\u00a1Q\2\u0249\u009c\3\2\2\2\u024a\u024b\7^\2\2\u024b"+
		"\u024c\7w\2\2\u024c\u024d\7}\2\2\u024d\u024f\3\2\2\2\u024e\u0250\5\u00a1"+
		"Q\2\u024f\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251\u024f\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\7\177\2\2\u0254\u009e\3"+
		"\2\2\2\u0255\u0256\t\f\2\2\u0256\u00a0\3\2\2\2\u0257\u0258\t\r\2\2\u0258"+
		"\u00a2\3\2\2\2\u0259\u025a\7/\2\2\u025a\u025b\7/\2\2\u025b\u025c\7]\2"+
		"\2\u025c\u025d\3\2\2\2\u025d\u025e\5\u0089E\2\u025e\u025f\7_\2\2\u025f"+
		"\u0260\3\2\2\2\u0260\u0261\bR\2\2\u0261\u00a4\3\2\2\2\u0262\u0263\7/\2"+
		"\2\u0263\u0264\7/\2\2\u0264\u0282\3\2\2\2\u0265\u0283\3\2\2\2\u0266\u026a"+
		"\7]\2\2\u0267\u0269\7?\2\2\u0268\u0267\3\2\2\2\u0269\u026c\3\2\2\2\u026a"+
		"\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u0283\3\2\2\2\u026c\u026a\3\2"+
		"\2\2\u026d\u0271\7]\2\2\u026e\u0270\7?\2\2\u026f\u026e\3\2\2\2\u0270\u0273"+
		"\3\2\2\2\u0271\u026f\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0274\3\2\2\2\u0273"+
		"\u0271\3\2\2\2\u0274\u0278\n\16\2\2\u0275\u0277\n\17\2\2\u0276\u0275\3"+
		"\2\2\2\u0277\u027a\3\2\2\2\u0278\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279"+
		"\u0283\3\2\2\2\u027a\u0278\3\2\2\2\u027b\u027f\n\20\2\2\u027c\u027e\n"+
		"\17\2\2\u027d\u027c\3\2\2\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2\2\2\u027f"+
		"\u0280\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2\2\u0282\u0265\3\2"+
		"\2\2\u0282\u0266\3\2\2\2\u0282\u026d\3\2\2\2\u0282\u027b\3\2\2\2\u0283"+
		"\u0287\3\2\2\2\u0284\u0285\7\17\2\2\u0285\u0288\7\f\2\2\u0286\u0288\t"+
		"\21\2\2\u0287\u0284\3\2\2\2\u0287\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289"+
		"\u028a\bS\2\2\u028a\u00a6\3\2\2\2\u028b\u028d\t\22\2\2\u028c\u028b\3\2"+
		"\2\2\u028d\u028e\3\2\2\2\u028e\u028c\3\2\2\2\u028e\u028f\3\2\2\2\u028f"+
		"\u0290\3\2\2\2\u0290\u0291\bT\3\2\u0291\u00a8\3\2\2\2\u0292\u0293\7%\2"+
		"\2\u0293\u0297\7#\2\2\u0294\u0296\n\17\2\2\u0295\u0294\3\2\2\2\u0296\u0299"+
		"\3\2\2\2\u0297\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u029a\3\2\2\2\u0299"+
		"\u0297\3\2\2\2\u029a\u029b\bU\2\2\u029b\u00aa\3\2\2\2*\2\u019d\u01a3\u01a5"+
		"\u01ad\u01af\u01c0\u01c4\u01c9\u01d0\u01d5\u01db\u01df\u01e5\u01e8\u01ed"+
		"\u01f1\u01f8\u01fe\u0202\u020a\u020d\u0214\u0218\u021c\u0221\u0225\u022a"+
		"\u0230\u0236\u0243\u0251\u026a\u0271\u0278\u027f\u0282\u0287\u028e\u0297"+
		"\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}