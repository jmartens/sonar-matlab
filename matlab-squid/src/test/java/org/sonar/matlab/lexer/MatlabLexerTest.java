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
package org.sonar.matlab.lexer;

import com.google.common.base.Charsets;
import com.sonar.sslr.api.GenericTokenType;
import com.sonar.sslr.impl.Lexer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sonar.matlab.MatlabConfiguration;
import org.sonar.matlab.api.MatlabKeyword;
import org.sonar.matlab.api.MatlabPunctuator;
import org.sonar.matlab.api.MatlabTokenType;

import static com.sonar.sslr.test.lexer.LexerMatchers.hasComment;
import static com.sonar.sslr.test.lexer.LexerMatchers.hasToken;
import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class MatlabLexerTest {

  private static Lexer lexer;

  @BeforeClass
  public static void init() {
    lexer = MatlabLexer.create(new MatlabConfiguration(Charsets.UTF_8));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#comments
   */
  @Test
  public void comments() {
    assertThat(lexer.lex("# My comment \n new line"), hasComment("# My comment "));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#string-literals
   */
  @Test
  public void shortstring_literals() {
    assertThat("empty", lexer.lex("''"), hasToken("''", MatlabTokenType.STRING));
    assertThat("empty", lexer.lex("\"\""), hasToken("\"\"", MatlabTokenType.STRING));

    assertThat(lexer.lex("'hello world'"), hasToken("'hello world'", MatlabTokenType.STRING));
    assertThat("stringprefix", lexer.lex("r'hello world'"), hasToken("r'hello world'", MatlabTokenType.STRING));
    assertThat("stringprefix", lexer.lex("R'hello world'"), hasToken("R'hello world'", MatlabTokenType.STRING));
    assertThat(lexer.lex("\"hello world\""), hasToken("\"hello world\"", MatlabTokenType.STRING));
    assertThat("stringprefix", lexer.lex("r\"hello world\""), hasToken("r\"hello world\"", MatlabTokenType.STRING));
    assertThat("stringprefix", lexer.lex("R\"hello world\""), hasToken("R\"hello world\"", MatlabTokenType.STRING));

    assertThat("2.7.3 stringprefix", lexer.lex("u'hello world'"), hasToken("u'hello world'", MatlabTokenType.STRING));
    assertThat("2.7.3 stringprefix", lexer.lex("ur'hello world'"), hasToken("ur'hello world'", MatlabTokenType.STRING));

    assertThat("escaped single quote", lexer.lex("'\\''"), hasToken("'\\''", MatlabTokenType.STRING));
    assertThat("escaped double quote", lexer.lex("\"\\\"\""), hasToken("\"\\\"\"", MatlabTokenType.STRING));

    assertThat("unterminated", lexer.lex("'"), hasToken("'", GenericTokenType.UNKNOWN_CHAR));
    assertThat("unterminated", lexer.lex("\""), hasToken("\"", GenericTokenType.UNKNOWN_CHAR));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#string-literals
   */
  @Test
  public void longstring_literals() {
    assertThat("empty", lexer.lex("''''''"), hasToken("''''''", MatlabTokenType.STRING));
    assertThat("empty", lexer.lex("\"\"\"\"\"\""), hasToken("\"\"\"\"\"\"", MatlabTokenType.STRING));

    assertThat("multiline", lexer.lex("'''\n'''"), hasToken("'''\n'''", MatlabTokenType.STRING));
    assertThat("multiline", lexer.lex("\"\"\"\n\"\"\""), hasToken("\"\"\"\n\"\"\"", MatlabTokenType.STRING));

    assertThat("stringprefix", lexer.lex("r'''\n'''"), hasToken("r'''\n'''", MatlabTokenType.STRING));
    assertThat("stringprefix", lexer.lex("r\"\"\"\n\"\"\""), hasToken("r\"\"\"\n\"\"\"", MatlabTokenType.STRING));

    assertThat("2.7.3 stringprefix", lexer.lex("u'''\n'''"), hasToken("u'''\n'''", MatlabTokenType.STRING));
    assertThat("2.7.3 stringprefix", lexer.lex("ur'''\n'''"), hasToken("ur'''\n'''", MatlabTokenType.STRING));
    assertThat("2.7.3 stringprefix", lexer.lex("u\"\"\"\n\"\"\""), hasToken("u\"\"\"\n\"\"\"", MatlabTokenType.STRING));
    assertThat("2.7.3 stringprefix", lexer.lex("ur\"\"\"\n\"\"\""), hasToken("ur\"\"\"\n\"\"\"", MatlabTokenType.STRING));

    assertThat("escaped single quote", lexer.lex("'''\\''''"), hasToken("'''\\''''", MatlabTokenType.STRING));
    assertThat("escaped double quote", lexer.lex("\"\"\"\\\"\"\"\""), hasToken("\"\"\"\\\"\"\"\"", MatlabTokenType.STRING));

    assertThat("unterminated", lexer.lex("'''"), hasToken("'", GenericTokenType.UNKNOWN_CHAR));
    assertThat("unterminated", lexer.lex("\"\"\""), hasToken("\"", GenericTokenType.UNKNOWN_CHAR));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#string-literals
   */
  @Test
  public void bytes_literal() {
    assertThat(lexer.lex("br'hello world'"), hasToken("br'hello world'", MatlabTokenType.STRING));
    assertThat(lexer.lex("br\"hello world\""), hasToken("br\"hello world\"", MatlabTokenType.STRING));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#string-literals
   */
  @Test
  public void longbytes_literal() {
    assertThat(lexer.lex("b'''\n'''"), hasToken("b'''\n'''", MatlabTokenType.STRING));
    assertThat(lexer.lex("b\"\"\"\n\"\"\""), hasToken("b\"\"\"\n\"\"\"", MatlabTokenType.STRING));

    assertThat(lexer.lex("br'''\n'''"), hasToken("br'''\n'''", MatlabTokenType.STRING));
    assertThat(lexer.lex("br\"\"\"\n\"\"\""), hasToken("br\"\"\"\n\"\"\"", MatlabTokenType.STRING));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#integer-and-long-integer-literals
   */
  @Test
  public void integer_literals() {
    assertThat(lexer.lex("7"), hasToken("7", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("0o177"), hasToken("0o177", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("0b100110111"), hasToken("0b100110111", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("0xdeadbeef"), hasToken("0xdeadbeef", MatlabTokenType.NUMBER));

    assertThat("2.7.3 long decimal integer", lexer.lex("9L"), hasToken("9L", MatlabTokenType.NUMBER));
    assertThat("2.7.3 long octal integer", lexer.lex("0x77L"), hasToken("0x77L", MatlabTokenType.NUMBER));
    assertThat("2.7.3 long binary integer", lexer.lex("0b11L"), hasToken("0b11L", MatlabTokenType.NUMBER));
    assertThat("2.7.3 long hex integer", lexer.lex("0xffL"), hasToken("0xffL", MatlabTokenType.NUMBER));

    assertThat("2.7.3 octal integer", lexer.lex("0700"), hasToken("0700", MatlabTokenType.NUMBER));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#floating-point-literals
   */
  @Test
  public void floating_point_literals() {
    assertThat(lexer.lex("3.14"), hasToken("3.14", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("10."), hasToken("10.", MatlabTokenType.NUMBER));
    assertThat(lexer.lex(".001"), hasToken(".001", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("1e100"), hasToken("1e100", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("3.14e-10"), hasToken("3.14e-10", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("0e0"), hasToken("0e0", MatlabTokenType.NUMBER));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#imaginary-literals
   */
  @Test
  public void imaginary_literals() {
    assertThat(lexer.lex("3.14j"), hasToken("3.14j", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("10.j"), hasToken("10.j", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("10j"), hasToken("10j", MatlabTokenType.NUMBER));
    assertThat(lexer.lex(".001j"), hasToken(".001j", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("1e100j"), hasToken("1e100j", MatlabTokenType.NUMBER));
    assertThat(lexer.lex("3.14e-10j"), hasToken("3.14e-10j", MatlabTokenType.NUMBER));
    assertThat("uppercase suffix", lexer.lex("10J"), hasToken("10J", MatlabTokenType.NUMBER));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#identifiers
   */
  @Test
  public void identifiers_and_keywords() {
    assertThat(lexer.lex("True"), hasToken("True", MatlabKeyword.TRUE));
    assertThat(lexer.lex("identifier"), hasToken("identifier", GenericTokenType.IDENTIFIER));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#operators
   * http://docs.matlab.org/reference/lexical_analysis.html#delimiters
   */
  @Test
  public void operators_and_delimiters() {
    assertThat(lexer.lex("<<"), hasToken("<<", MatlabPunctuator.LEFT_OP));
    assertThat(lexer.lex("+="), hasToken("+=", MatlabPunctuator.PLUS_ASSIGN));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#blank-lines
   */
  @Test
  public void blank_lines() {
    assertThat(lexer.lex("    # comment\n")).hasSize(1);
    assertThat(lexer.lex("    \n")).hasSize(1);
    assertThat(lexer.lex("    ")).hasSize(1);
    assertThat(lexer.lex("line\n\n")).hasSize(3);
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#indentation
   */
  @Test
  public void indent_dedent() {
    assertThat(lexer.lex("    STATEMENT\n  STATEMENT"), allOf(hasToken("    ", MatlabTokenType.INDENT), hasToken("  ", MatlabTokenType.DEDENT)));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#implicit-line-joining
   */
  @Test
  public void implicit_line_joining() {
    assertThat(lexer.lex("month_names = ['January', \n 'December']"), not(hasToken("\n", MatlabTokenType.NEWLINE)));
  }

  /**
   * http://docs.matlab.org/reference/lexical_analysis.html#explicit-line-joining
   */
  @Test
  public void explicit_line_joining() {
    assertThat(lexer.lex("line\r\nline"), hasToken(MatlabTokenType.NEWLINE));
    assertThat(lexer.lex("line\rline"), hasToken(MatlabTokenType.NEWLINE));
    assertThat(lexer.lex("line\nline"), hasToken(MatlabTokenType.NEWLINE));

    assertThat(lexer.lex("line\\\r\nline"), not(hasToken(MatlabTokenType.NEWLINE)));
    assertThat(lexer.lex("line\\\rline"), not(hasToken(MatlabTokenType.NEWLINE)));
    assertThat(lexer.lex("line\\\nline"), not(hasToken(MatlabTokenType.NEWLINE)));

    assertThat(lexer.lex("line\\\n    line")).hasSize(3);
  }

}
