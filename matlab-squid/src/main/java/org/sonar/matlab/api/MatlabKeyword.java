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

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.TokenType;

/**
 * http://docs.matlab.org/reference/lexical_analysis.html#keywords
 */
public enum MatlabKeyword implements TokenType {

  FALSE("False"),
  NONE("None"),
  TRUE("True"),

  /**
   * Logical AND.
   */
  AND("and"),

  AS("as"),
  ASSERT("assert"),
  BREAK("break"),
  CLASS("class"),
  CONTINUE("continue"),
  DEF("def"),
  DEL("del"),
  ELIF("elif"),
  ELSE("else"),
  EXCEPT("except"),
  FINALLY("finally"),
  FOR("for"),
  FROM("from"),
  GLOBAL("global"),
  IF("if"),
  IMPORT("import"),
  IN("in"),
  IS("is"),
  LAMBDA("lambda"),
  NONLOCAL("nonlocal"),
  NOT("not"),

  /**
   * Logical OR.
   */
  OR("or"),

  PASS("pass"),
  RAISE("raise"),
  RETURN("return"),
  TRY("try"),
  WHILE("while"),
  WITH("with"),
  YIELD("yield");

  private final String value;

  private MatlabKeyword(String value) {
    this.value = value;
  }

  public String getName() {
    return name();
  }

  public String getValue() {
    return value;
  }

  public boolean hasToBeSkippedFromAst(AstNode node) {
    return false;
  }

  public static String[] keywordValues() {
    MatlabKeyword[] keywordsEnum = MatlabKeyword.values();
    String[] keywords = new String[keywordsEnum.length];
    for (int i = 0; i < keywords.length; i++) {
      keywords[i] = keywordsEnum[i].getValue();
    }
    return keywords;
  }

}
