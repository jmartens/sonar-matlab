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

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Grammar;
import org.sonar.squidbridge.checks.SquidCheck;
import org.sonar.check.BelongsToProfile;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.matlab.api.MatlabTokenType;

@Rule(
  key = "LongIntegerWithLowercaseSuffixUsage",
  priority = Priority.MAJOR)
@BelongsToProfile(title = CheckList.SONAR_WAY_PROFILE, priority = Priority.MAJOR)
public class LongIntegerWithLowercaseSuffixUsageCheck extends SquidCheck<Grammar> {

  @Override
  public void init() {
    subscribeTo(MatlabTokenType.NUMBER);
  }

  @Override
  public void visitNode(AstNode astNode) {
    String value = astNode.getTokenValue();
    if (value.charAt(value.length() - 1) == 'l') {
      getContext().createLineViolation(this, "Replace suffix in long integers from lower case \"l\" to upper case \"L\".", astNode);
    }
  }

}
