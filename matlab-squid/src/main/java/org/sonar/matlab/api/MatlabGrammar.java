/*
 * SonarQube Matlab Plugin
 * Copyright (C) 2011 SonarSource and Waleri Enns
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.matlab.api;

import org.sonar.sslr.grammar.GrammarRuleKey;
import org.sonar.sslr.grammar.LexerfulGrammarBuilder;

import static com.sonar.sslr.api.GenericTokenType.EOF;
import static com.sonar.sslr.api.GenericTokenType.IDENTIFIER;
import static org.sonar.matlab.api.MatlabTokenType.DEDENT;
import static org.sonar.matlab.api.MatlabTokenType.INDENT;
import static org.sonar.matlab.api.MatlabTokenType.NEWLINE;
import static org.sonar.matlab.api.MatlabTokenType.NUMBER;
import static org.sonar.matlab.api.MatlabPunctuator.*;
import static org.sonar.matlab.api.MatlabKeyword.*;

public enum MatlabGrammar implements GrammarRuleKey {
/*  FACTOR,
  TRAILER,
  SUBSCRIPTLIST,
  SUBSCRIPT,
  SLICEOP,
  TESTLIST_COMP,
  DICTORSETMAKER,

  ARGLIST,
  ARGUMENT,

  NAME,
  VARARGSLIST,
  FPDEF,
  FPLIST,

  TEST,
  TESTLIST,

  COMP_FOR,
  COMP_ITER,
  COMP_IF,
  TEST_NOCOND,
  EXPRLIST,
  EXPR,
  STAR_EXPR,

  TESTLIST_STAR_EXPR,

  YIELD_EXPR,

  // Expressions

  ATOM,

  POWER,

  A_EXPR,
  M_EXPR,

  SHIFT_EXPR,

  XOR_EXPR,
  AND_EXPR,
  OR_EXPR,

  COMPARISON,
  COMP_OPERATOR,

  OR_TEST,
  AND_TEST,
  NOT_TEST,

  LAMBDEF,
  LAMBDEF_NOCOND,

  // Simple statements

  SIMPLE_STMT,
  EXPRESSION_STMT,
  PRINT_STMT,
  EXEC_STMT,
  ASSERT_STMT,

  AUGASSIGN,

  PASS_STMT,
  DEL_STMT,
  RETURN_STMT,
  YIELD_STMT,
  RAISE_STMT,
  BREAK_STMT,
  CONTINUE_STMT,

  IMPORT_STMT,
  IMPORT_NAME,
  IMPORT_FROM,
  IMPORT_AS_NAME,
  DOTTED_AS_NAME,
  IMPORT_AS_NAMES,
  DOTTED_AS_NAMES,

  GLOBAL_STMT,
  NONLOCAL_STMT,

  // Compound statements

  COMPOUND_STMT,
  SUITE,*/
  STATEMENT,
/*  STMT_LIST,

  IF_STMT,
  WHILE_STMT,
  FOR_STMT,

  TRY_STMT,
  EXCEPT_CLAUSE,

  WITH_STMT,
  WITH_ITEM,

  FUNCDEF,
  DECORATORS,
  DECORATOR,
  DOTTED_NAME,
  FUNCNAME,
*/
  // Top-level components

  FILE_INPUT, 
  
  CLASS_BLOCK, 
  CLASSDEF,
  CLASSNAME,
  CLASS_ATTRIBUTE, 
  CLASS_ATTRIBUTE_BOOLEAN, 
  CLASS_ATTRIBUTES_CLASSES, 
  
  METHODS_BLOCK, 
  METHODSDEF, 
  METHODS_ATTRIBUTE, 
  METHODS_ATTRIBUTE_BOOLEAN, 
  METHODS_ACCESS_TYPE, 
  
  PROPERTIES_BLOCK, 
  PROPERTIESDEF, 
  PROPERTIES_ATTRIBUTE, 
  PROPERTIES_ATTRIBUTE_BOOLEAN, 
  PROPERTIES_ACCESS_TYPE, 
  
  EVENTS_BLOCK, 
  
  ENUMS_BLOCK, 
  ENUM; 

  public static LexerfulGrammarBuilder create() {
    LexerfulGrammarBuilder b = LexerfulGrammarBuilder.create();

    b.rule(FILE_INPUT).is(b.zeroOrMore(b.firstOf(NEWLINE, STATEMENT)), EOF);

    grammar(b);
    compoundStatements(b);
    simpleStatements(b);
    expressions(b);

    b.setRootRule(FILE_INPUT);
    b.buildWithMemoizationOfMatchesForAllRules();

    return b;
  }

  public static void grammar(LexerfulGrammarBuilder b) {

	/*
	 * Matlab rule set
	 */
	/*
	 * // Parameter definition b.rule(PARAMETERLIST).is(
	 * b.zeroOrMore(PARAMETER, b.optional(COMMA, PARAMETER)));
	 * b.rule(PARAMETER).is( b.sequence(b.optional(RBRACKET), b.firstOf("~",
	 * "TODO: add possible datatypes"), b.optional(LBRACKET)));
	 */

	/*
	 * Block defintion to match all blocks that start with a opening keyword
	 * and is closed with the end keyword
	 */
	// b.rule(BLOCK).is(CLASSDEF, b.zeroOrMore(NEWLINE), "end");

	b.rule(STATEMENT).is(
			b.firstOf(NEWLINE, IDENTIFIER, CLASS_BLOCK));
	
//		b.rule(BLOCK).is(b.firstOf(ENUMS_BLOCK, EVENTS_BLOCK, METHODS_BLOCK, PROPERTIES_BLOCK));

	/*
	 * Class definition
	 * 
	 * @see
	 * http://www.mathworks.nl/help/matlab/matlab_oop/class-definition.html
	 * 
	 * For example of a Matlab class definition
	 * 
	 * @see
	 * http://www.mathworks.nl/help/matlab/matlab_oop/a-class-code-listing.html
	 */		
	b.rule(CLASSDEF).is(CLASSDEF_KW,
			b.optional(LPARENTHESIS, CLASS_ATTRIBUTE, RPARENTHESIS), IDENTIFIER,
			b.optional(MatlabPunctuator.LT, HANDLE));

	/*
	 *  Class attributes
	 *  @see http://www.mathworks.nl/help/matlab/matlab_oop/class-attributes.html
	 *  
	 *  Class attributes that only allow TRUE/FALSE:
	 *  - abstract
	 *  - constructonload
	 *  - handlecompatible
	 *  - hidden
	 *  - static
	 *  - sealed
	 */
	b.rule(CLASS_ATTRIBUTE_BOOLEAN).is(
			b.firstOf(b.sequence(b.firstOf(ABSTRACT, CONSTRUCTONLOAD, HANDLECOMPATIBLE, HIDDEN, SEALED),
					ASSIGN, b.firstOf(TRUE, FALSE)), b.firstOf(ABSTRACT, CONSTRUCTONLOAD, HANDLECOMPATIBLE, HIDDEN, SEALED)));

	/*
	 * Allowed subclasses
	 */
	b.rule(CLASS_ATTRIBUTES_CLASSES).is(b.firstOf(ALLOWEDSUBCLASSES, INFERIORCLASSES));		

	/*
	 * Aggregate of all method attributes
	 */
	b.rule(CLASS_ATTRIBUTE).is(b.firstOf(CLASS_ATTRIBUTE_BOOLEAN, CLASS_ATTRIBUTES_CLASSES));

	
	b.rule(CLASS_BLOCK).is(CLASSDEF, NEWLINE, INDENT, b.oneOrMore(b.firstOf(METHODS_BLOCK, PROPERTIES_BLOCK, EVENTS_BLOCK, ENUMS_BLOCK), NEWLINE), DEDENT, END);

	/*
	 * Method definition
	 * @see http://www.mathworks.nl/help/matlab/matlab_oop/method-attributes.html
	 */
	b.rule(METHODSDEF).is(
			METHODS,
			b.optional(LPARENTHESIS, METHODS_ATTRIBUTE,
					b.zeroOrMore(COMMA, METHODS_ATTRIBUTE), RPARENTHESIS));
	
	/*
	 *  Method attributes that only allow TRUE/FALSE:
	 *  - abstract
	 *  - hidden
	 *  - sealed
	 *  - static
	 */
	b.rule(METHODS_ATTRIBUTE_BOOLEAN).is(
			b.firstOf(b.sequence(b.firstOf(ABSTRACT, HIDDEN, SEALED, STATIC),
					ASSIGN, b.firstOf(TRUE, FALSE)), b.firstOf(ABSTRACT,
					HIDDEN, SEALED, STATIC)));

	/*
	 * Methods access type:
	 * - public
	 * - protected
	 * - private
	 */
	b.rule(METHODS_ACCESS_TYPE).is(ACCESS, ASSIGN, b.firstOf(PUBLIC, PROTECTED, PRIVATE));

	/*
	 * Aggregate of all method attributes
	 */
	b.rule(METHODS_ATTRIBUTE).is(b.firstOf(METHODS_ATTRIBUTE_BOOLEAN, METHODS_ACCESS_TYPE));
	
	b.rule(METHODS_BLOCK).is(METHODSDEF, NEWLINE, b.optional(INDENT, b.oneOrMore(IDENTIFIER, NEWLINE), DEDENT), END);

	/*
	 * Properties
	 * @see http://www.mathworks.nl/help/matlab/matlab_oop/defining-properties.html
	 */
	b.rule(PROPERTIESDEF).is(
			PROPERTIES,
			b.optional(LPARENTHESIS, PROPERTIES_ATTRIBUTE,
					b.zeroOrMore(COMMA, PROPERTIES_ATTRIBUTE), RPARENTHESIS));
	
	/*
	 * Properties attributes
	 * @see http://www.mathworks.nl/help/matlab/matlab_oop/property-attributes.html
	 * 
	 *  Properties attributes that only allow TRUE/FALSE:
	 *  - abortset 
	 *  - abstract
	 *  - constant
	 *  - dependant
	 *  - getobservanle
	 *  - setobservable
	 *  - hidden
	 *  - transient
	 *  
	 */
	b.rule(PROPERTIES_ATTRIBUTE_BOOLEAN).is(
			b.firstOf(
					b.sequence(
							b.firstOf(
									ABORTSET, ABSTRACT, 
									CONSTANT, DEPENDANT, 
									GETOBSERVABLE, SETOBSERVABLE, 
									HIDDEN, TRANSIENT
									), 
									ASSIGN, 
									b.firstOf(TRUE, FALSE)
							), 
					b.firstOf(
							ABORTSET, ABSTRACT, 
							CONSTANT, DEPENDANT, 
							GETOBSERVABLE, SETOBSERVABLE, 
							HIDDEN, TRANSIENT
							)
					)
			);

	/*
	 * Properties set-/get- and access type:
	 * - public
	 * - protected
	 * - private
	 */
	b.rule(PROPERTIES_ACCESS_TYPE).is(b.firstOf(ACCESS, GETACCESS, SETACCESS), ASSIGN, b.firstOf(PUBLIC, PROTECTED, PRIVATE));

	/*
	 * Aggregate of all properties attributes
	 */
	b.rule(PROPERTIES_ATTRIBUTE).is(b.firstOf(PROPERTIES_ATTRIBUTE_BOOLEAN, PROPERTIES_ACCESS_TYPE));
	//		b.rule(METHODS_BLOCK).is(METHODSDEF, NEWLINE, b.optional(b.oneOrMore(INDENT, IDENTIFIER, NEWLINE), DEDENT), END);

	b.rule(PROPERTIES_BLOCK).is(PROPERTIESDEF, NEWLINE, b.optional(INDENT, b.oneOrMore(IDENTIFIER, ASSIGN, IDENTIFIER, NEWLINE), DEDENT), END);

	/*
	 *  Data types
	 */
	/*
	 * Enum
	 * @see http://www.mathworks.nl/help/matlab/ref/enumeration.html
	 */
	b.rule(ENUM).is(IDENTIFIER, b.optional(LPARENTHESIS, NUMBER, RPARENTHESIS));
	b.rule(ENUMS_BLOCK).is(ENUMERATION, NEWLINE, b.optional(INDENT, b.oneOrMore(ENUM, NEWLINE), DEDENT), END);
	
	b.rule(EVENTS_BLOCK).is(EVENTS, NEWLINE, b.optional(INDENT, b.oneOrMore(IDENTIFIER, NEWLINE), DEDENT), END);

	
	/*
	 * b.rule(CLASSNAME).is(NAME);
	 * b.rule(CLASS_ATTRIBUTES).is("ConstructOnLoad");
	 */
	  
	  
/*
    b.rule(EXPRESSION_STMT).is(
      TESTLIST_STAR_EXPR,
      b.firstOf(
        b.sequence(AUGASSIGN, b.firstOf(YIELD_EXPR, TESTLIST)),
        b.zeroOrMore("=", b.firstOf(YIELD_EXPR, TESTLIST_STAR_EXPR))));
    b.rule(TESTLIST_STAR_EXPR).is(b.firstOf(TEST, STAR_EXPR), b.zeroOrMore(",", b.firstOf(TEST, STAR_EXPR)), b.optional(","));
    b.rule(AUGASSIGN).is(b.firstOf("+=", "-=", "*=", "/=", "//=", "%=", "**=", ">>=", "<<=", "&=", "^=", "|="));

    b.rule(TEST).is(b.firstOf(
      b.sequence(OR_TEST, b.optional("if", OR_TEST, "else", TEST)),
      LAMBDEF));
    b.rule(TEST_NOCOND).is(b.firstOf(OR_TEST, LAMBDEF_NOCOND));
    b.rule(LAMBDEF).is("lambda", b.optional(VARARGSLIST), ":", TEST);
    b.rule(LAMBDEF_NOCOND).is("lambda", b.optional(VARARGSLIST), ":", TEST_NOCOND);

    b.rule(STAR_EXPR).is("*", EXPR);
    b.rule(EXPR).is(XOR_EXPR, b.zeroOrMore("|", XOR_EXPR));

    b.rule(FACTOR).is(b.firstOf(
      b.sequence(b.firstOf("+", "-", "~"), FACTOR),
      POWER)).skipIfOneChild();
    b.rule(POWER).is(ATOM, b.zeroOrMore(TRAILER), b.optional("**", FACTOR)).skipIfOneChild();
    b.rule(ATOM).is(b.firstOf(
      b.sequence("(", b.optional(b.firstOf(YIELD_EXPR, TESTLIST_COMP)), ")"),
      b.sequence("[", b.optional(TESTLIST_COMP), "]"),
      b.sequence("{", b.optional(DICTORSETMAKER), "}"),
      b.sequence("`", TEST, b.zeroOrMore(",", TEST), "`"),
      NAME,
      MatlabTokenType.NUMBER,
      b.oneOrMore(MatlabTokenType.STRING),
      "...",
      MatlabKeyword.NAN,
      MatlabKeyword.TRUE,
      MatlabKeyword.FALSE));
    b.rule(TESTLIST_COMP).is(b.firstOf(TEST, STAR_EXPR), b.firstOf(COMP_FOR, b.sequence(b.zeroOrMore(",", b.firstOf(TEST, STAR_EXPR)), b.optional(","))));
    b.rule(TRAILER).is(b.firstOf(
      b.sequence("(", b.optional(ARGLIST), ")"),
      b.sequence("[", SUBSCRIPTLIST, "]"),
      b.sequence(".", NAME)));
    b.rule(SUBSCRIPTLIST).is(SUBSCRIPT, b.zeroOrMore(",", SUBSCRIPT), b.optional(","));
    b.rule(SUBSCRIPT).is(b.firstOf(
      b.sequence(".", ".", "."),
      b.sequence(b.optional(TEST), ":", b.optional(TEST), b.optional(SLICEOP)),
      TEST));
    b.rule(SLICEOP).is(":", b.optional(TEST));
    b.rule(EXPRLIST).is(b.firstOf(EXPR, STAR_EXPR), b.zeroOrMore(",", b.firstOf(EXPR, STAR_EXPR)), b.optional(","));
    b.rule(TESTLIST).is(TEST, b.zeroOrMore(",", TEST), b.optional(","));
    b.rule(DICTORSETMAKER).is(b.firstOf(
      b.sequence(TEST, ":", TEST, b.firstOf(COMP_FOR, b.sequence(b.zeroOrMore(",", TEST, ":", TEST), b.optional(",")))),
      b.sequence(TEST, b.firstOf(COMP_FOR, b.sequence(b.zeroOrMore(",", TEST), b.optional(","))))));

    b.rule(ARGLIST).is(b.firstOf(
      b.sequence(b.zeroOrMore(ARGUMENT, ","), "*", TEST, b.zeroOrMore(",", ARGUMENT), b.optional(",", "**", TEST)),
      b.sequence(b.zeroOrMore(ARGUMENT, ","), "**", TEST),
      b.optional(ARGUMENT, b.zeroOrMore(",", ARGUMENT), b.optional(","))));
    b.rule(ARGUMENT).is(b.firstOf(
      b.sequence(TEST, "=", TEST),
      b.sequence(TEST, b.optional(COMP_FOR))));
    b.rule(COMP_ITER).is(b.firstOf(COMP_FOR, COMP_IF));
    b.rule(COMP_FOR).is("for", EXPRLIST, "in", TESTLIST, b.optional(COMP_ITER));
    b.rule(COMP_IF).is("if", TEST_NOCOND, b.optional(COMP_ITER));

    b.rule(YIELD_EXPR).is("yield", b.optional(TESTLIST));

    b.rule(NAME).is(IDENTIFIER);
    b.rule(VARARGSLIST).is(b.firstOf(
      b.sequence(b.zeroOrMore(FPDEF, b.optional("=", TEST), ","), b.firstOf(b.sequence("*", NAME, b.optional(",", "**", NAME)), b.sequence("**", NAME))),
      b.sequence(FPDEF, b.optional("=", TEST), b.zeroOrMore(",", FPDEF, b.optional("=", TEST)), b.optional(","))));
    b.rule(FPDEF).is(b.firstOf(
      NAME,
      b.sequence("(", FPLIST, ")")));
    b.rule(FPLIST).is(FPDEF, b.zeroOrMore(",", FPDEF), b.optional(","));*/
  }

  /**
   * Expressions
   * http://docs.matlab.org/reference/expressions.html
   */
  public static void expressions(LexerfulGrammarBuilder b) {
/*    b.rule(M_EXPR).is(FACTOR, b.zeroOrMore(b.firstOf("*", "//", "/", "%"), FACTOR)).skipIfOneChild();
    b.rule(A_EXPR).is(M_EXPR, b.zeroOrMore(b.firstOf("+", "-"), M_EXPR)).skipIfOneChild();

    b.rule(SHIFT_EXPR).is(A_EXPR, b.zeroOrMore(b.firstOf("<<", ">>"), A_EXPR)).skipIfOneChild();

    b.rule(AND_EXPR).is(SHIFT_EXPR, b.zeroOrMore("&", SHIFT_EXPR)).skipIfOneChild();
    b.rule(XOR_EXPR).is(AND_EXPR, b.zeroOrMore("^", AND_EXPR)).skipIfOneChild();
    b.rule(OR_EXPR).is(XOR_EXPR, b.zeroOrMore("|", XOR_EXPR)).skipIfOneChild();

    b.rule(COMPARISON).is(OR_EXPR, b.zeroOrMore(COMP_OPERATOR, OR_EXPR)).skipIfOneChild();
    b.rule(COMP_OPERATOR).is(b.firstOf(
      "<",
      ">",
      "==",
      ">=",
      "<=",
      "!=",
      "<>",
      b.sequence("is", b.optional("not")),
      b.sequence(b.optional("not"), "in")));

    b.rule(OR_TEST).is(AND_TEST, b.zeroOrMore("or", AND_TEST)).skipIfOneChild();
    b.rule(AND_TEST).is(NOT_TEST, b.zeroOrMore("and", NOT_TEST)).skipIfOneChild();
    b.rule(NOT_TEST).is(b.firstOf(COMPARISON, b.sequence("not", NOT_TEST))).skipIfOneChild();*/
  }

  /**
   * Simple statements
   * http://docs.matlab.org/reference/simple_stmts.html
   */
  public static void simpleStatements(LexerfulGrammarBuilder b) {
/*    b.rule(SIMPLE_STMT).is(b.firstOf(
      PRINT_STMT,
      EXEC_STMT,
      EXPRESSION_STMT,
      ASSERT_STMT,
      PASS_STMT,
      DEL_STMT,
      RETURN_STMT,
      YIELD_STMT,
      RAISE_STMT,
      BREAK_STMT,
      CONTINUE_STMT,
      IMPORT_STMT,
      GLOBAL_STMT,
      NONLOCAL_STMT));

    b.rule(PRINT_STMT).is("print", b.nextNot("("), b.firstOf(
      b.sequence(">>", TEST, b.optional(b.oneOrMore(",", TEST), b.optional(","))),
      b.optional(TEST, b.zeroOrMore(",", TEST), b.optional(","))));

    b.rule(EXEC_STMT).is("exec", b.nextNot("("), EXPR, b.optional("in", TEST, b.optional(",", TEST)));

    b.rule(ASSERT_STMT).is("assert", TEST, b.optional(",", TEST));

    b.rule(PASS_STMT).is("pass");
    b.rule(DEL_STMT).is("del", EXPRLIST);
    b.rule(RETURN_STMT).is("return", b.optional(TESTLIST));
    b.rule(YIELD_STMT).is(YIELD_EXPR);
    b.rule(RAISE_STMT).is("raise", b.optional(TEST, b.optional(b.firstOf(b.sequence("from", TEST), b.sequence(",", TEST, b.optional(",", TEST))))));
    b.rule(BREAK_STMT).is("break");
    b.rule(CONTINUE_STMT).is("continue");

    b.rule(IMPORT_STMT).is(b.firstOf(IMPORT_NAME, IMPORT_FROM));
    b.rule(IMPORT_NAME).is("import", DOTTED_AS_NAMES);
    b.rule(IMPORT_FROM).is("from", b.firstOf(b.sequence(b.zeroOrMore("."), DOTTED_NAME), b.oneOrMore(".")), "import",
      b.firstOf("*", b.sequence("(", IMPORT_AS_NAMES, ")"), IMPORT_AS_NAMES));
    b.rule(IMPORT_AS_NAME).is(NAME, b.optional("as", NAME));
    b.rule(DOTTED_AS_NAME).is(DOTTED_NAME, b.optional("as", NAME));
    b.rule(IMPORT_AS_NAMES).is(IMPORT_AS_NAME, b.zeroOrMore(",", IMPORT_AS_NAME), b.optional(","));
    b.rule(DOTTED_AS_NAMES).is(DOTTED_AS_NAME, b.zeroOrMore(",", DOTTED_AS_NAME));

    b.rule(GLOBAL_STMT).is("global", NAME, b.zeroOrMore(",", NAME));
    b.rule(NONLOCAL_STMT).is("nonlocal", NAME, b.zeroOrMore(",", NAME));*/
  }

  /**
   * Compound statements
   * http://docs.matlab.org/reference/compound_stmts.html
   */
  public static void compoundStatements(LexerfulGrammarBuilder b) {
/*    b.rule(COMPOUND_STMT).is(b.firstOf(
      IF_STMT,
      WHILE_STMT,
      FOR_STMT,
      TRY_STMT,
      WITH_STMT,
      FUNCDEF,
      CLASSDEF));
    b.rule(SUITE).is(b.firstOf(
      b.sequence(STMT_LIST, NEWLINE),
      b.sequence(NEWLINE, INDENT, b.oneOrMore(STATEMENT), DEDENT)));
    b.rule(STATEMENT).is(b.firstOf(
      b.sequence(STMT_LIST, NEWLINE),
      COMPOUND_STMT,
      STMT_LIST));
    b.rule(STMT_LIST).is(SIMPLE_STMT, b.zeroOrMore(";", SIMPLE_STMT), b.optional(";"));

    b.rule(IF_STMT).is("if", TEST, ":", SUITE, b.zeroOrMore("elif", TEST, ":", SUITE), b.optional("else", ":", SUITE));
    b.rule(WHILE_STMT).is("while", TEST, ":", SUITE, b.optional("else", ":", SUITE));
    b.rule(FOR_STMT).is("for", EXPRLIST, "in", TESTLIST, ":", SUITE, b.optional("else", ":", SUITE));

    b.rule(TRY_STMT).is("try", ":", SUITE, b.firstOf(
      b.sequence(b.zeroOrMore(EXCEPT_CLAUSE, ":", SUITE),
        b.optional("else", ":", SUITE),
        b.optional("finally", ":", SUITE)),
      b.sequence("finally", ":", SUITE)));

    b.rule(EXCEPT_CLAUSE).is("except", b.optional(TEST, b.optional(b.firstOf("as", ","), TEST)));

    b.rule(WITH_STMT).is("with", WITH_ITEM, b.zeroOrMore(",", WITH_ITEM), ":", SUITE);
    b.rule(WITH_ITEM).is(TEST, b.optional("as", EXPR));

    b.rule(FUNCDEF).is(b.optional(DECORATORS), "def", FUNCNAME, "(", b.optional(VARARGSLIST), ")", ":", SUITE);
    b.rule(FUNCNAME).is(NAME);

    b.rule(DECORATORS).is(b.oneOrMore(DECORATOR));
    b.rule(DECORATOR).is("@", DOTTED_NAME, b.optional("(", b.optional(ARGLIST), ")"), NEWLINE);
    b.rule(DOTTED_NAME).is(NAME, b.zeroOrMore(".", NAME));

    b.rule(CLASSDEF).is(b.optional(DECORATORS), "class", CLASSNAME, b.optional("(", b.optional(ARGLIST), ")"), ":", SUITE);
    b.rule(CLASSNAME).is(NAME);*/
  }

}
