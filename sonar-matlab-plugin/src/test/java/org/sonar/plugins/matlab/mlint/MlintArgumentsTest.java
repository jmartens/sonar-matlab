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
package org.sonar.plugins.matlab.mlint;

import org.apache.commons.lang.SystemUtils;
import org.junit.Test;
import org.sonar.api.utils.command.Command;

import static org.fest.assertions.Assertions.assertThat;

public class MlintArgumentsTest {

  private Command command(String toOutput) {
    if (SystemUtils.IS_OS_WINDOWS) {
      return Command.create("cmd.exe").addArguments(new String[] {"/c", "echo", toOutput});
    }
    return Command.create("echo").addArgument(toOutput);
  }

}
