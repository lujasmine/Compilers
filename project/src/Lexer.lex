//Yee Chong Tan, Theo Turner, Jasmine Lu

//user code
import java_cup.runtime.*;

%%

//JLex directives

%class Lexer
%unicode
%cup
%line
%column 

%{
	StringBuffer string = new StringBuffer();
	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline, yycolumn, value);
	}
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]

//TODO 
//define letter, punctuation, digit (which are char)

//TODO check declarations for comments
/* comments */
Comment = {MultiLineComment} | {NormalComment}
MultiLineComment   = "/#" [^*] ~"#/"
NormalComment     = "/#" {InputCharacter}* {LineTerminator}?

//TODO check declaration for identifier
IDENTIFIER  = {LETTER}({LETTER}|{DIGIT}|"_")*
//OR??
Identifier = [:jletter:] [:jletterdigit:]* /* NEED UNDERSCORES */

//TODO check this declaration/ what is it?? (can't find this in spec)
DecIntegerLiteral = 0 | [1-9][0-9]*

%state STRING

%%

//regular expression rules

//TODO what are keywords for?
/* keywords */
<YYINITIAL> "abstract"           { return symbol(sym.ABSTRACT); }
<YYINITIAL> "boolean"            { return symbol(sym.BOOLEAN); }
<YYINITIAL> "break"              { return symbol(sym.BREAK); }

<YYINITIAL> {
	/* identifiers */
	{Identifier}                   { return symbol(sym.IDENTIFIER); }
	
	/* literals */
	{DecIntegerLiteral}            { return symbol(sym.INTEGER_LITERAL); }
	\"                             { string.setLength(0); yybegin(STRING); }

	//TODO
	//main

	//TODO
	/* primitives */
	//bool --> !, &&, ||
	//int, rat, float --> +, _, *, /, ^
	//char

	//TODO
	/* aggregrate */
	//dict --> in d len 
	//seq --> in (above), ::, len (above), s

	//TODO
	/* comparison */
	// <, <=, == (below), !=

	/* operators */
	"="                            { return symbol(sym.EQ); }
	"=="                           { return symbol(sym.EQEQ); }
	"+"                            { return symbol(sym.PLUS); }
	
	//TODO
	/* declarations */
	//tdef, fdef, alias?

	//TODO
	/* expressions */
	//.

	//TODO
	/* statements */
	//if, else, while, forall, then, fi, elif, do, od, return
	//read, print

	//TODO other characters - i.e. brackets, curly brackets, <, > anything that has been missed

	/* comments */
	{Comment}                      { /* ignore */ }
	
	/* whitespace */
	{WhiteSpace}                   { /* ignore */ }
}

<STRING> {
	\"                             { yybegin(YYINITIAL);
					 return symbol(sym.STRING_LITERAL,
					 string.toString()); }
	[^\n\r\"\\]+                   { string.append( yytext() ); }
	\\t                            { string.append('\t'); }
	\\n                            { string.append('\n'); }
	
	\\r                            { string.append('\r'); }
	\\\"                           { string.append('\"'); }
	\\                             { string.append('\\'); }
}

/* error fallback */
[^]			{ throw new Error("Illegal character <"+yytext()+">"); }
