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

import com.google.common.base.Predicate;
import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.api.Token;
import com.sonar.sslr.api.Trivia;
import org.sonar.check.BelongsToProfile;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.matlab.api.MatlabGrammar;
import org.sonar.squidbridge.checks.SquidCheck;
import org.sonar.sslr.ast.AstSelect;

@Rule(
  key = "S108",
  priority = Priority.MAJOR)
@BelongsToProfile(title = CheckList.SONAR_WAY_PROFILE, priority = Priority.MAJOR)
public class EmptyNestedBlockCheck extends SquidCheck<Grammar> {

  private static final Predicate<AstNode> NOT_PASS_PREDICATE = new NotPassPredicate();
  private static final String MESSAGE = "Either remove or fill this block of code.";

  @Override
  public void init() {
    subscribeTo(MatlabGrammar.SUITE);
  }

  @Override
  public void visitNode(AstNode suiteNode) {
    if (suiteNode.getParent().is(MatlabGrammar.FUNCDEF, MatlabGrammar.CLASSDEF) || isInExcept(suiteNode)) {
      return;
    }

    AstSelect suite = suiteNode.select();
    AstSelect stmtLists = suite.children(MatlabGrammar.STMT_LIST);
    if (stmtLists.isEmpty()) {
      AstSelect statementSelect = suite.children(MatlabGrammar.STATEMENT);
      if (statementSelect.children(MatlabGrammar.COMPOUND_STMT).isNotEmpty()) {
        return;
      }
      stmtLists = statementSelect.children(MatlabGrammar.STMT_LIST);
    }

    AstSelect nonPassSimpleStatements = stmtLists
      .children(MatlabGrammar.SIMPLE_STMT)
      .children()
      .filter(NOT_PASS_PREDICATE);
    if (nonPassSimpleStatements.isEmpty() && !containsComment(suiteNode)) {
      getContext().createLineViolation(this, MESSAGE, stmtLists.get(0));
    }
  }

  private boolean isInExcept(AstNode suiteNode) {
    return suiteNode.getParent().is(MatlabGrammar.TRY_STMT)
      && suiteNode.getPreviousSibling().getPreviousSibling().is(MatlabGrammar.EXCEPT_CLAUSE);
  }

  private boolean containsComment(AstNode suiteNode) {
    for (Token token : suiteNode.getTokens()) {
      for (Trivia trivia : token.getTrivia()) {
        if (trivia.isComment()) {
          return true;
        }
      }
    }
    return false;
  }

  private static class NotPassPredicate implements Predicate<AstNode> {

    @Override
    public boolean apply(AstNode node) {
      return node.getType() != MatlabGrammar.PASS_STMT;
    }

  }

}
