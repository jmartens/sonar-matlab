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
package org.sonar.matlab.parser.compound_statements;

import org.junit.Before;
import org.junit.Test;
import org.sonar.matlab.api.MatlabGrammar;
import org.sonar.matlab.parser.MatlabTestUtils;
import org.sonar.matlab.parser.RuleTest;

import static org.sonar.sslr.tests.Assertions.assertThat;

public class ClassDefTest extends RuleTest {

  @Before
  public void init() {
    setRootRule(MatlabGrammar.CLASSDEF);
  }

  @Test
  public void realLife() {
    assertThat(p).matches(MatlabTestUtils.appendNewLine("class Foo: pass"));
    assertThat(p).matches(MatlabTestUtils.appendNewLine("class Foo(argument): pass"));
    assertThat(p).matches(MatlabTestUtils.appendNewLine("class Foo(argument=value): pass"));
  }

}
