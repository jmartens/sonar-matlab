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

import org.junit.Test;
import org.sonar.matlab.MatlabAstScanner;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.squidbridge.checks.CheckMessagesVerifier;

import java.io.File;

public class TooManyParametersCheckTest {

  @Test
  public void test() {
    TooManyParametersCheck check = new TooManyParametersCheck();
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/checks/tooManyParameters.py"), check);
    CheckMessagesVerifier.verify(file.getCheckMessages())
      .next().atLine(3).withMessage("Lambda has 8 parameters, which is greater than the 7 authorized.")
      .next().atLine(8).withMessage("Function \"incorrect_function\" has 8 parameters, which is greater than the 7 authorized.")
      .next().atLine(15).withMessage("Method \"incorrect_method\" has 8 parameters, which is greater than the 7 authorized.")
      .noMore();
  }

}
