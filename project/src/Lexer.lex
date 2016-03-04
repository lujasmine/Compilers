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

LINE_TERMINATOR   = [\r|\n|\r\n]
WHITESPACE      = \r|\n|\r\n|" "|"\t"
LETTER      = [a-zA-Z]
PUNCTUATION   = " "|[!-&]|[(-~]
CHARACTER     = "’"{LETTER}|{PUNCTUATION}|{DIGIT}"’"
DIGIT       = [0-9]
BOOLEAN_CONSTANT  = ("T"|"F")
INPUTCHARACTER = [^\r\n]

INTEGER     = 0|[1-9][0-9]*
FLOATING_POINT    = {DIGIT}+"."{DIGIT}+
RATIONAL    = (INTEGER"_")?INTEGER"/"INTEGER|INTEGER
STRING      = "\"" ~"\""

COMMENT = {TRADITIONALCOMMENT} | {NORMALCOMMENT}
TRADITIONALCOMMENT   = "/#" [^#] ~"#/" | "/#" "#" + "/"
NORMALCOMMENT     = "#" {INPUTCHARACTER}* {LINE_TERMINATOR}?

IDENTIFIER  = {LETTER}({LETTER}|{DIGIT}|"_")*

%state STRING

%%

//regular expression rules

<YYINITIAL> {
  
  /* comments */
  {COMMENT}   { /* ignore */ }
  
  /* whitespace */
  {WHITESPACE}  { /* ignore */ }
  {LINE_TERMINATOR}   { /* IGNORE */ }

  "main"      { return symbol(sym.MAIN); }
  "char"      { return symbol(sym.CHAR); }

  "bool"      { return symbol(sym.BOOL); }

  "!"       { return symbol(sym.NOT); }
  "&&"      { return symbol(sym.AND); }
  "||"      { return symbol(sym.OR); }

  "int"     { return symbol(sym.INT); }
  "float"     { return symbol(sym.FLOAT); }
  "rat"     { return symbol(sym.RAT); }

  "+"       { return symbol(sym.PLUS); }
  "-"       { return symbol(sym.MINUS); }
  "*"       { return symbol(sym.TIMES); }
  "/"       { return symbol(sym.DIVIDE); }
  "^"       { return symbol(sym.EXPONENT); }

  "dict"      { return symbol(sym.DICT); }
  "top"     { return symbol(sym.TOP); }
  "seq"     { return symbol(sym.SEQ); }
  "in"      { return symbol(sym.IN); }
  "d"       { return symbol(sym.D); }
  "len"     { return symbol(sym.LEN); }
  "::"      { return symbol(sym.CONCATENATE); }
  "<"       { return symbol(sym.LESS); }
  "<="      { return symbol(sym.LESSEQ); }
  ">"       { return symbol(sym.MORE); }
  ">="      { return symbol(sym.MOREEQ); }
  "=="      { return symbol(sym.EQUAL); }
  "!="      { return symbol(sym.NOTEQUAL); }

  "tdef"      { return symbol(sym.TDEF); }
  "fdef"      { return symbol(sym.FDEF); }
  "void"      { return symbol(sym.VOID); }

  "alias"     { return symbol(sym.ALIAS); }

  "="       { return symbol(sym.ASS); }

  "."       { return symbol(sym.DOT); }

  "if"      { return symbol(sym.IF); }
  "else"      { return symbol(sym.ELSE); }
  "while"     { return symbol(sym.WHILE); }
  "forall"    { return symbol(sym.FORALL); }
  "then"      { return symbol(sym.THEN); }
  "fi"      { return symbol(sym.ENDIF); }
  "elif"      { return symbol(sym.ELSEIF); }
  "do"      { return symbol(sym.DO); }
  "od"      { return symbol(sym.ENDDO); }
  "return"    { return symbol(sym.RETURN); }
  "read"      { return symbol(sym.READ); }
  "print"     { return symbol(sym.PRINT); }
  "in"      { return symbol(sym.IN); }

  "("       { return symbol(sym.OBRACKET); }
  ")"       { return symbol(sym.CBRACKET); }
  "["       { return symbol(sym.OSQUAREBRACKET); }
  "]"       { return symbol(sym.CSQUAREBRACKET); }
  "{"       { return symbol(sym.OCURLYBRACKET); }
  "}"       { return symbol(sym.CCURLYBRACKET); }

  ","       { return symbol(sym.COMMA); }
  ":"       { return symbol(sym.COLON); }
  ";"       { return symbol(sym.SEMICOLON); }


  {BOOLEAN_CONSTANT}  { return symbol(sym.BOOLEAN_CONSTANT); }

  {INTEGER}   { return symbol(sym.INTEGER); }
  {FLOATING_POINT}  { return symbol(sym.FLOATING_POINT); }
  {RATIONAL}    { return symbol(sym.RATIONAL); }
  {IDENTIFIER}  { return symbol(sym.ID); }
  {CHARACTER}   { return symbol(sym.CHARACTER); }
  {STRING}    { return symbol(sym.STRING); }
}

[^]       { throw new Error("Illegal character <"+yytext()+">"); }
