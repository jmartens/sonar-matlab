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
package org.sonar.matlab.metrics;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Grammar;
import org.sonar.matlab.api.MatlabGrammar;
import org.sonar.matlab.api.MatlabKeyword;
import org.sonar.matlab.api.MatlabMetric;
import org.sonar.squidbridge.SquidAstVisitor;

public class ComplexityVisitor extends SquidAstVisitor<Grammar> {

  @Override
  public void init() {
    subscribeTo(
      // Entry points
      MatlabGrammar.FUNCDEF,

      // Branching nodes
      // Note that IF_STMT covered by MatlabKeyword.IF below
      MatlabGrammar.WHILE_STMT,
      MatlabGrammar.FOR_STMT,
      MatlabGrammar.RETURN_STMT,
      MatlabGrammar.RAISE_STMT,
      MatlabGrammar.EXCEPT_CLAUSE,

      // Expressions
      MatlabKeyword.IF,
      MatlabKeyword.AND,
      MatlabKeyword.OR);
  }

  @Override
  public void visitNode(AstNode astNode) {
    getContext().peekSourceCode().add(MatlabMetric.COMPLEXITY, 1);
  }

}
