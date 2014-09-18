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
package org.sonar.matlab.parser.toplevel;

import org.junit.Before;
import org.junit.Test;
import org.sonar.matlab.api.MatlabGrammar;
import org.sonar.matlab.parser.RuleTest;

import static org.sonar.sslr.tests.Assertions.assertThat;

public class FileInputTest extends RuleTest {

  @Before
  public void init() {
    setRootRule(MatlabGrammar.FILE_INPUT);
  }

  @Test
  public void ok() {
    p.getGrammar().rule(MatlabGrammar.STATEMENT).mock();

    assertThat(p).matches("STATEMENT");
    assertThat(p).matches("STATEMENT STATEMENT");
    assertThat(p).matches("\n");
    assertThat(p).matches("STATEMENT\nSTATEMENT");
  }

}
