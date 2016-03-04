/* The following code was generated by JFlex 1.6.1 */

//Yee Chong Tan, Theo Turner, Jasmine Lu

//user code
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/Lexer.lex</tt>
 */
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\3\2\0\1\2\22\0\1\4\1\40\1\24\1\25"+
    "\2\6\1\41\1\0\1\64\1\65\1\46\1\44\1\72\1\45\1\14"+
    "\1\23\1\13\11\10\1\55\1\73\1\56\1\57\1\60\2\6\4\5"+
    "\1\17\1\12\1\20\1\5\1\15\4\5\1\16\3\5\1\21\1\5"+
    "\1\11\6\5\1\66\1\6\1\67\1\47\1\22\1\6\1\27\1\35"+
    "\1\32\1\50\1\53\1\43\1\5\1\33\1\30\2\5\1\37\1\26"+
    "\1\31\1\36\1\51\1\54\1\34\1\52\1\42\1\63\1\61\1\62"+
    "\3\5\1\70\1\1\1\71\1\6\uff7e\0\1\7\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\22\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\2\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\6\1\10\1\4\1\11\1\5\1\3\10\4"+
    "\1\12\1\5\2\4\1\13\1\14\1\15\1\16\1\17"+
    "\3\4\1\20\1\21\1\22\1\23\2\4\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\2\0"+
    "\1\6\2\0\1\4\2\0\1\35\2\4\1\36\1\37"+
    "\4\4\1\40\1\4\1\41\1\42\3\4\1\43\4\4"+
    "\1\44\3\4\1\45\1\46\1\47\1\50\2\4\2\0"+
    "\1\51\1\4\2\0\2\4\1\52\1\4\1\53\3\4"+
    "\1\54\1\4\1\55\6\4\1\56\5\4\1\0\1\57"+
    "\1\4\1\60\1\61\1\4\1\62\1\63\1\64\2\4"+
    "\1\65\1\66\1\4\1\67\1\70\1\71\2\4\1\72"+
    "\2\4\1\73\1\74\1\75\1\4\1\76\1\77\1\100"+
    "\1\4\1\0\1\4\1\0\1\4\1\0\1\4\1\0"+
    "\1\4\1\0\1\4\1\0\1\4\1\0\1\4\1\100";

  private static int [] zzUnpackAction() {
    int [] result = new int[165];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\74\0\170\0\264\0\360\0\170\0\u012c\0\170"+
    "\0\u0168\0\u01a4\0\u012c\0\u01e0\0\170\0\u021c\0\u0258\0\u0294"+
    "\0\u02d0\0\u030c\0\u0348\0\u0384\0\u03c0\0\u03fc\0\u0438\0\u0474"+
    "\0\u04b0\0\u04ec\0\u0528\0\u0564\0\u05a0\0\170\0\170\0\170"+
    "\0\170\0\u05dc\0\u0618\0\u0654\0\u0690\0\u06cc\0\u0708\0\u0744"+
    "\0\u0780\0\u07bc\0\u07f8\0\170\0\170\0\170\0\170\0\170"+
    "\0\170\0\170\0\170\0\170\0\u0834\0\u0870\0\u08ac\0\u08e8"+
    "\0\u0924\0\u0960\0\u099c\0\u0294\0\170\0\u09d8\0\u0a14\0\u0a50"+
    "\0\u012c\0\u0a8c\0\u0ac8\0\u0b04\0\u0b40\0\u012c\0\u0b7c\0\170"+
    "\0\170\0\u0bb8\0\u0bf4\0\u0c30\0\u012c\0\u0c6c\0\u0ca8\0\u0ce4"+
    "\0\u0d20\0\u012c\0\u0d5c\0\u0d98\0\u0dd4\0\170\0\170\0\170"+
    "\0\170\0\u0e10\0\u0e4c\0\u0e88\0\u0ec4\0\u08e8\0\u0f00\0\u0f3c"+
    "\0\u0f78\0\u0fb4\0\u0ff0\0\u012c\0\u102c\0\u012c\0\u1068\0\u10a4"+
    "\0\u10e0\0\u012c\0\u111c\0\u012c\0\u1158\0\u1194\0\u11d0\0\u120c"+
    "\0\u1248\0\u1284\0\u012c\0\u12c0\0\u12fc\0\u1338\0\u1374\0\u13b0"+
    "\0\u13ec\0\u012c\0\u1428\0\u012c\0\u012c\0\u1464\0\u012c\0\u012c"+
    "\0\u012c\0\u14a0\0\u14dc\0\u012c\0\u012c\0\u1518\0\u012c\0\u012c"+
    "\0\u012c\0\u1554\0\u1590\0\u012c\0\u15cc\0\u1608\0\u012c\0\u012c"+
    "\0\u012c\0\u1644\0\u012c\0\u012c\0\u1680\0\u16bc\0\u16f8\0\u1734"+
    "\0\u1770\0\u17ac\0\u17e8\0\u1824\0\u1860\0\u189c\0\u18d8\0\u1914"+
    "\0\u1950\0\u198c\0\u19c8\0\u1a04\0\170";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[165];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\2\6\1\7\1\10\1\11\1\12"+
    "\2\13\1\14\1\15\1\16\4\7\1\10\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\7\1\25\1\7\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\7"+
    "\1\46\1\47\1\50\1\51\1\52\1\53\1\7\1\54"+
    "\1\55\1\56\1\57\1\60\1\61\1\62\1\63\74\3"+
    "\75\0\1\64\75\0\1\6\75\0\1\7\2\0\4\7"+
    "\1\0\6\7\3\0\12\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\17\0\1\65\73\0\1\66\1\67\2\0"+
    "\1\67\1\70\66\0\1\66\1\71\2\0\1\71\1\70"+
    "\64\0\1\7\2\0\4\7\1\0\1\7\1\72\4\7"+
    "\3\0\12\7\2\0\2\7\4\0\5\7\4\0\3\7"+
    "\35\0\1\73\46\0\24\74\1\75\47\74\2\21\2\6"+
    "\70\21\5\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\1\7\1\76\10\7\2\0\2\7\4\0\5\7\4\0"+
    "\3\7\15\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\11\7\1\77\2\0\2\7\4\0\5\7\4\0\3\7"+
    "\15\0\1\7\2\0\4\7\1\0\6\7\3\0\3\7"+
    "\1\100\6\7\2\0\1\7\1\101\4\0\5\7\4\0"+
    "\3\7\15\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\5\7\1\102\4\7\2\0\2\7\4\0\5\7\4\0"+
    "\3\7\15\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\1\7\1\103\10\7\2\0\2\7\4\0\3\7\1\104"+
    "\1\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\10\7\1\105\1\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\12\7\2\0\2\7\4\0\1\106\4\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\2\7\4\0\3\7\1\107\1\7"+
    "\4\0\3\7\67\0\1\110\55\0\1\111\37\0\1\7"+
    "\2\0\4\7\1\0\6\7\3\0\5\7\1\112\2\7"+
    "\1\113\1\7\2\0\2\7\4\0\1\114\4\7\4\0"+
    "\3\7\15\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\2\7\1\115\5\7\1\116\1\117\2\0\2\7\4\0"+
    "\1\120\4\7\4\0\3\7\15\0\1\7\2\0\4\7"+
    "\1\0\6\7\3\0\2\7\1\121\5\7\1\122\1\7"+
    "\2\0\2\7\4\0\5\7\4\0\3\7\15\0\1\7"+
    "\2\0\4\7\1\0\6\7\3\0\6\7\1\123\3\7"+
    "\2\0\2\7\4\0\5\7\4\0\3\7\15\0\1\7"+
    "\2\0\4\7\1\0\6\7\3\0\12\7\2\0\2\7"+
    "\4\0\3\7\1\124\1\7\4\0\3\7\15\0\1\7"+
    "\2\0\4\7\1\0\6\7\3\0\11\7\1\125\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\65\0\1\126\75\0"+
    "\1\127\73\0\1\130\73\0\1\131\21\0\1\7\2\0"+
    "\4\7\1\0\6\7\3\0\10\7\1\132\1\7\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\15\0\1\7\2\0"+
    "\4\7\1\0\6\7\3\0\5\7\1\133\4\7\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\17\0\1\134\73\0"+
    "\1\135\74\0\1\67\2\0\1\67\1\70\67\0\1\136"+
    "\2\0\1\136\70\0\1\71\2\0\1\71\1\70\64\0"+
    "\1\7\2\0\1\7\1\137\2\7\1\0\6\7\3\0"+
    "\12\7\2\0\2\7\4\0\5\7\4\0\3\7\10\0"+
    "\25\140\1\141\46\140\5\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\2\7\1\142\7\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\2\7\1\143\7\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\12\7\2\0\1\144\1\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\1\7\1\145\10\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\1\146\1\7\4\0\5\7\4\0"+
    "\3\7\15\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\1\7\1\147\10\7\2\0\1\150\1\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\10\7\1\151\1\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\3\7\1\152\6\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\2\7\4\0\3\7\1\153\1\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\2\7\4\0\1\7\1\154\3\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\2\7\4\0\3\7\1\155\1\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\6\7\1\156\3\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\10\7\1\157\1\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\2\7\4\0\3\7\1\160\1\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\4\7\1\161\5\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\2\7\1\162\7\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\2\7\4\0\4\7\1\163\4\0"+
    "\3\7\15\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\2\7\1\164\7\7\2\0\2\7\4\0\2\7\1\165"+
    "\2\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\2\7\1\166\7\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\2\7\1\167\7\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\10\3\0\2\10\2\0"+
    "\5\10\4\0\12\10\2\0\2\10\4\0\5\10\4\0"+
    "\3\10\17\0\1\10\71\0\1\7\2\0\4\7\1\0"+
    "\2\7\1\170\3\7\3\0\12\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\10\0\25\140\1\171\46\140\23\0"+
    "\1\6\1\0\1\141\53\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\3\7\1\172\6\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\1\7\1\173\10\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\6\7\1\174\3\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\12\7\2\0\2\7\4\0\1\175\4\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\6\7"+
    "\3\0\12\7\2\0\2\7\4\0\5\7\4\0\2\7"+
    "\1\176\15\0\1\7\2\0\4\7\1\0\6\7\3\0"+
    "\11\7\1\177\2\0\2\7\4\0\5\7\4\0\3\7"+
    "\15\0\1\7\2\0\4\7\1\0\6\7\3\0\3\7"+
    "\1\200\6\7\2\0\2\7\4\0\5\7\4\0\3\7"+
    "\15\0\1\7\2\0\4\7\1\0\6\7\3\0\12\7"+
    "\2\0\1\7\1\201\4\0\5\7\4\0\3\7\15\0"+
    "\1\7\2\0\4\7\1\0\6\7\3\0\1\7\1\202"+
    "\10\7\2\0\2\7\4\0\5\7\4\0\3\7\15\0"+
    "\1\7\2\0\4\7\1\0\6\7\3\0\1\7\1\203"+
    "\10\7\2\0\2\7\4\0\5\7\4\0\3\7\15\0"+
    "\1\7\2\0\4\7\1\0\6\7\3\0\12\7\2\0"+
    "\1\7\1\204\4\0\5\7\4\0\3\7\15\0\1\7"+
    "\2\0\4\7\1\0\6\7\3\0\12\7\2\0\1\205"+
    "\1\7\4\0\5\7\4\0\3\7\15\0\1\7\2\0"+
    "\4\7\1\0\6\7\3\0\3\7\1\206\6\7\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\15\0\1\7\2\0"+
    "\4\7\1\0\6\7\3\0\12\7\2\0\1\7\1\207"+
    "\4\0\5\7\4\0\3\7\15\0\1\7\2\0\4\7"+
    "\1\0\6\7\3\0\12\7\2\0\2\7\4\0\3\7"+
    "\1\210\1\7\4\0\3\7\15\0\1\7\2\0\4\7"+
    "\1\0\6\7\3\0\12\7\2\0\2\7\4\0\1\211"+
    "\4\7\4\0\3\7\15\0\1\7\2\0\4\7\1\0"+
    "\6\7\3\0\11\7\1\212\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\15\0\1\7\2\0\4\7\1\0\3\7"+
    "\1\213\2\7\3\0\12\7\2\0\2\7\4\0\5\7"+
    "\4\0\3\7\10\0\23\140\1\6\1\140\1\171\46\140"+
    "\5\0\1\7\2\0\4\7\1\0\6\7\3\0\12\7"+
    "\2\0\2\7\4\0\2\7\1\214\2\7\4\0\3\7"+
    "\15\0\1\7\2\0\4\7\1\0\6\7\3\0\6\7"+
    "\1\215\3\7\2\0\2\7\4\0\5\7\4\0\3\7"+
    "\15\0\1\7\2\0\4\7\1\0\6\7\3\0\11\7"+
    "\1\216\2\0\2\7\4\0\5\7\4\0\3\7\15\0"+
    "\1\7\2\0\4\7\1\0\6\7\3\0\12\7\2\0"+
    "\1\217\1\7\4\0\5\7\4\0\3\7\15\0\1\7"+
    "\2\0\4\7\1\0\6\7\3\0\12\7\2\0\1\220"+
    "\1\7\4\0\5\7\4\0\3\7\15\0\1\7\2\0"+
    "\4\7\1\0\6\7\3\0\12\7\2\0\2\7\4\0"+
    "\3\7\1\221\1\7\4\0\3\7\15\0\1\7\2\0"+
    "\4\7\1\0\2\7\1\222\3\7\3\0\12\7\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\15\0\1\7\2\0"+
    "\4\7\1\0\6\7\3\0\3\7\1\223\6\7\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\15\0\1\7\2\0"+
    "\4\7\1\0\6\7\3\0\11\7\1\224\2\0\2\7"+
    "\4\0\5\7\4\0\3\7\15\0\1\7\2\0\4\7"+
    "\1\0\4\7\1\225\1\7\3\0\12\7\2\0\2\7"+
    "\4\0\5\7\4\0\3\7\15\0\1\7\2\0\4\7"+
    "\1\0\5\7\1\226\1\227\2\0\12\7\2\0\2\7"+
    "\4\0\5\7\4\0\3\7\15\0\1\7\2\0\4\7"+
    "\1\0\1\230\5\7\3\0\12\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\25\0\1\231\63\0\1\7\2\0"+
    "\4\7\1\0\1\7\1\232\4\7\3\0\12\7\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\26\0\1\233\62\0"+
    "\1\7\2\0\1\7\1\234\2\7\1\0\6\7\3\0"+
    "\12\7\2\0\2\7\4\0\5\7\4\0\3\7\21\0"+
    "\1\235\67\0\1\7\2\0\4\7\1\0\2\7\1\236"+
    "\3\7\3\0\12\7\2\0\2\7\4\0\5\7\4\0"+
    "\3\7\27\0\1\237\61\0\1\7\2\0\4\7\1\0"+
    "\3\7\1\240\2\7\3\0\12\7\2\0\2\7\4\0"+
    "\5\7\4\0\3\7\30\0\1\241\60\0\1\7\2\0"+
    "\4\7\1\0\2\7\1\242\3\7\3\0\12\7\2\0"+
    "\2\7\4\0\5\7\4\0\3\7\27\0\1\243\61\0"+
    "\1\7\2\0\4\7\1\0\4\7\1\244\1\7\3\0"+
    "\12\7\2\0\2\7\4\0\5\7\4\0\3\7\31\0"+
    "\1\245\57\0\1\7\2\0\4\7\1\0\6\7\1\227"+
    "\2\0\12\7\2\0\2\7\4\0\5\7\4\0\3\7"+
    "\10\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6720];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\2\1\1\11\1\1\1\11\4\1\1\11"+
    "\20\1\4\11\12\1\11\11\2\0\1\1\2\0\1\1"+
    "\2\0\1\11\12\1\2\11\14\1\4\11\2\1\2\0"+
    "\2\1\2\0\27\1\1\0\35\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\1\1\1\0"+
    "\1\1\1\0\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[165];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
	StringBuffer string = new StringBuffer();
	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline, yycolumn, value);
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 188) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Illegal character <"+yytext()+">");
            }
          case 65: break;
          case 2: 
            { /* IGNORE */
            }
          case 66: break;
          case 3: 
            { /* ignore */
            }
          case 67: break;
          case 4: 
            { return symbol(sym.ID);
            }
          case 68: break;
          case 5: 
            { return symbol(sym.CHARACTER);
            }
          case 69: break;
          case 6: 
            { return symbol(sym.INTEGER);
            }
          case 70: break;
          case 7: 
            { return symbol(sym.BOOLEAN_CONSTANT);
            }
          case 71: break;
          case 8: 
            { return symbol(sym.DOT);
            }
          case 72: break;
          case 9: 
            { return symbol(sym.DIVIDE);
            }
          case 73: break;
          case 10: 
            { return symbol(sym.NOT);
            }
          case 74: break;
          case 11: 
            { return symbol(sym.PLUS);
            }
          case 75: break;
          case 12: 
            { return symbol(sym.MINUS);
            }
          case 76: break;
          case 13: 
            { return symbol(sym.TIMES);
            }
          case 77: break;
          case 14: 
            { return symbol(sym.EXPONENT);
            }
          case 78: break;
          case 15: 
            { return symbol(sym.D);
            }
          case 79: break;
          case 16: 
            { return symbol(sym.COLON);
            }
          case 80: break;
          case 17: 
            { return symbol(sym.LESS);
            }
          case 81: break;
          case 18: 
            { return symbol(sym.ASS);
            }
          case 82: break;
          case 19: 
            { return symbol(sym.MORE);
            }
          case 83: break;
          case 20: 
            { return symbol(sym.OBRACKET);
            }
          case 84: break;
          case 21: 
            { return symbol(sym.CBRACKET);
            }
          case 85: break;
          case 22: 
            { return symbol(sym.OSQUAREBRACKET);
            }
          case 86: break;
          case 23: 
            { return symbol(sym.CSQUAREBRACKET);
            }
          case 87: break;
          case 24: 
            { return symbol(sym.OCURLYBRACKET);
            }
          case 88: break;
          case 25: 
            { return symbol(sym.CCURLYBRACKET);
            }
          case 89: break;
          case 26: 
            { return symbol(sym.COMMA);
            }
          case 90: break;
          case 27: 
            { return symbol(sym.SEMICOLON);
            }
          case 91: break;
          case 28: 
            { return symbol(sym.OR);
            }
          case 92: break;
          case 29: 
            { return symbol(sym.STRING);
            }
          case 93: break;
          case 30: 
            { return symbol(sym.IN);
            }
          case 94: break;
          case 31: 
            { return symbol(sym.IF);
            }
          case 95: break;
          case 32: 
            { return symbol(sym.ENDDO);
            }
          case 96: break;
          case 33: 
            { return symbol(sym.NOTEQUAL);
            }
          case 97: break;
          case 34: 
            { return symbol(sym.AND);
            }
          case 98: break;
          case 35: 
            { return symbol(sym.ENDIF);
            }
          case 99: break;
          case 36: 
            { return symbol(sym.DO);
            }
          case 100: break;
          case 37: 
            { return symbol(sym.CONCATENATE);
            }
          case 101: break;
          case 38: 
            { return symbol(sym.LESSEQ);
            }
          case 102: break;
          case 39: 
            { return symbol(sym.EQUAL);
            }
          case 103: break;
          case 40: 
            { return symbol(sym.MOREEQ);
            }
          case 104: break;
          case 41: 
            { return symbol(sym.FLOATING_POINT);
            }
          case 105: break;
          case 42: 
            { return symbol(sym.INT);
            }
          case 106: break;
          case 43: 
            { return symbol(sym.RAT);
            }
          case 107: break;
          case 44: 
            { return symbol(sym.LEN);
            }
          case 108: break;
          case 45: 
            { return symbol(sym.TOP);
            }
          case 109: break;
          case 46: 
            { return symbol(sym.SEQ);
            }
          case 110: break;
          case 47: 
            { return symbol(sym.MAIN);
            }
          case 111: break;
          case 48: 
            { return symbol(sym.CHAR);
            }
          case 112: break;
          case 49: 
            { return symbol(sym.READ);
            }
          case 113: break;
          case 50: 
            { return symbol(sym.BOOL);
            }
          case 114: break;
          case 51: 
            { return symbol(sym.THEN);
            }
          case 115: break;
          case 52: 
            { return symbol(sym.TDEF);
            }
          case 116: break;
          case 53: 
            { return symbol(sym.FDEF);
            }
          case 117: break;
          case 54: 
            { return symbol(sym.DICT);
            }
          case 118: break;
          case 55: 
            { return symbol(sym.ELSEIF);
            }
          case 119: break;
          case 56: 
            { return symbol(sym.ELSE);
            }
          case 120: break;
          case 57: 
            { return symbol(sym.VOID);
            }
          case 121: break;
          case 58: 
            { return symbol(sym.ALIAS);
            }
          case 122: break;
          case 59: 
            { return symbol(sym.FLOAT);
            }
          case 123: break;
          case 60: 
            { return symbol(sym.PRINT);
            }
          case 124: break;
          case 61: 
            { return symbol(sym.WHILE);
            }
          case 125: break;
          case 62: 
            { return symbol(sym.RETURN);
            }
          case 126: break;
          case 63: 
            { return symbol(sym.FORALL);
            }
          case 127: break;
          case 64: 
            { return symbol(sym.RATIONAL);
            }
          case 128: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
