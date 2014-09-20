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

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import org.sonar.api.utils.command.Command;
import org.sonar.api.utils.command.CommandExecutor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MlintArguments {

  private static final String[] ARGS_MLINT = {"-id", "-notok"};

  private final String[] arguments;

  public MlintArguments(Command command) {
    this.arguments = ARGS_MLINT;
  }

  public String[] arguments() {
    return arguments;
  }

}
