/*
 * SonarQube Python Plugin
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
package org.sonar.python.checks;

import com.sonar.sslr.api.AstAndTokenVisitor;
import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.api.Token;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.check.RuleProperty;
import org.sonar.squidbridge.checks.SquidCheck;

@Rule(
  key = "LineLength",
  priority = Priority.MINOR)
public class LineLengthCheck extends SquidCheck<Grammar> implements AstAndTokenVisitor {

  private static final int DEFAULT_MAXIMUM_LINE_LENHGTH = 80;

  @RuleProperty(
    key = "maximumLineLength",
    defaultValue = "" + DEFAULT_MAXIMUM_LINE_LENHGTH)
  public int maximumLineLength = DEFAULT_MAXIMUM_LINE_LENHGTH;

  public int getMaximumLineLength() {
    return maximumLineLength;
  }

  private Token previousToken;

  @Override
  public void visitFile(AstNode astNode) {
    previousToken = null;
  }

  @Override
  public void leaveFile(AstNode astNode) {
    previousToken = null;
  }

  public void visitToken(Token token) {
    if (!token.isGeneratedCode()) {
      if (previousToken != null && previousToken.getLine() != token.getLine()) {
        // Note that AbstractLineLengthCheck doesn't support tokens which span multiple lines - see SONARPLUGINS-2025
        String[] lines = previousToken.getValue().split("\r?\n|\r", -1);
        int length = previousToken.getColumn();
        for (int line = 0; line < lines.length; line++) {
          length += lines[line].length();
          if (length > getMaximumLineLength()) {
            // Note that method from AbstractLineLengthCheck generates other message - see SONARPLUGINS-1809
            getContext().createLineViolation(this,
              "The line contains {0,number,integer} characters which is greater than {1,number,integer} authorized.",
              previousToken.getLine(),
              length,
              getMaximumLineLength());
          }
          length = 0;
        }
      }
      previousToken = token;
    }
  }

}
