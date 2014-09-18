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
package org.sonar.matlab.checks;

import com.google.common.collect.ImmutableMap;
import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Grammar;
import org.sonar.check.BelongsToProfile;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.matlab.api.MatlabGrammar;
import org.sonar.matlab.api.MatlabPunctuator;
import org.sonar.squidbridge.checks.SquidCheck;

import java.util.List;
import java.util.Map;

@Rule(
  key = "S1721",
  priority = Priority.MAJOR)
@BelongsToProfile(title = CheckList.SONAR_WAY_PROFILE, priority = Priority.MAJOR)
public class UselessParenthesisAfterKeywordCheck extends SquidCheck<Grammar> {

  private static final Map<MatlabGrammar, String> KEYWORDS_FOLLOWED_BY_TEST = ImmutableMap.of(
    MatlabGrammar.ASSERT_STMT, "assert",
    MatlabGrammar.RAISE_STMT, "raise",
    MatlabGrammar.WHILE_STMT, "while");

  @Override
  public void init() {
    subscribeTo(
      MatlabGrammar.ASSERT_STMT,
      MatlabGrammar.DEL_STMT,
      MatlabGrammar.IF_STMT,
      MatlabGrammar.FOR_STMT,
      MatlabGrammar.RAISE_STMT,
      MatlabGrammar.RETURN_STMT,
      MatlabGrammar.WHILE_STMT,
      MatlabGrammar.YIELD_EXPR,
      MatlabGrammar.EXCEPT_CLAUSE,
      MatlabGrammar.NOT_TEST);
  }

  @Override
  public void visitNode(AstNode node) {
    String keyword = KEYWORDS_FOLLOWED_BY_TEST.get(node.getType());
    if (keyword != null) {
      checkParenthesis(node.getFirstChild(MatlabGrammar.TEST), keyword, node);
    } else if (node.is(MatlabGrammar.DEL_STMT)) {
      checkParenthesis(node.getFirstChild(MatlabGrammar.EXPRLIST), "del", node);
    } else if (node.is(MatlabGrammar.IF_STMT)) {
      List<AstNode> testNodes = node.getChildren(MatlabGrammar.TEST);
      checkParenthesis(testNodes.get(0), "if", node);
      if (testNodes.size() > 1) {
        checkParenthesis(testNodes.get(1), "elif", testNodes.get(1));
      }
    } else if (node.is(MatlabGrammar.FOR_STMT)) {
      checkParenthesis(node.getFirstChild(MatlabGrammar.EXPRLIST), "for", node);
      checkParenthesis(node.getFirstChild(MatlabGrammar.TESTLIST), "in", node);
    } else if (node.is(MatlabGrammar.RETURN_STMT)) {
      checkParenthesis(node.getFirstChild(MatlabGrammar.TESTLIST), "return", node);
    } else if (node.is(MatlabGrammar.YIELD_EXPR)) {
      checkParenthesis(node.getFirstChild(MatlabGrammar.TESTLIST), "yield", node);
    } else if (node.is(MatlabGrammar.EXCEPT_CLAUSE)) {
      visitExceptClause(node);
    } else if (node.is(MatlabGrammar.NOT_TEST)) {
      visitNotTest(node);
    }
  }

  private void visitNotTest(AstNode node) {
    boolean hasUselessParenthesis = node.select()
      .children(MatlabGrammar.ATOM)
      .children(MatlabGrammar.TESTLIST_COMP)
      .children(MatlabGrammar.TEST)
      .children(MatlabGrammar.ATOM, MatlabGrammar.COMPARISON)
      .isNotEmpty();
    if (hasUselessParenthesis) {
      checkParenthesis(node.getFirstChild().getNextSibling(), "not", node);
    }
  }

  private void visitExceptClause(AstNode node) {
    int nbTests = node.select()
      .children(MatlabGrammar.TEST)
      .children(MatlabGrammar.ATOM)
      .children(MatlabGrammar.TESTLIST_COMP)
      .children(MatlabGrammar.TEST)
      .size();
    if (nbTests == 1) {
      checkParenthesis(node.getFirstChild(MatlabGrammar.TEST), "except", node);
    }
  }

  private void checkParenthesis(AstNode child, String keyword, AstNode errorNode) {
    if (child != null && child.getToken().getType() == MatlabPunctuator.LPARENTHESIS && isOnASingleLine(child)) {
      getContext().createLineViolation(this,
        "Remove the parentheses after this \"{0}\" keyword", errorNode, keyword);
    }
  }

  private boolean isOnASingleLine(AstNode node) {
    return node.getTokenLine() == node.getLastToken().getLine();
  }

}
