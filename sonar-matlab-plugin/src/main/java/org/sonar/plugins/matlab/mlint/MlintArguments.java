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

  private static final Pattern MLINT_VERSION_PATTERN = Pattern.compile(".*mlint[^ ]* ([0-9\\.]+).*");
  private static final String[] ARGS_MLINT_0_X = {"-i", "y", "-f", "parseable", "-r", "n"};
  private static final String[] ARGS_MLINT_1_X = {"--msg-template", "{path}:{line}: [{msg_id}({symbol}), {obj}] {msg}", "-r", "n"};

  private final String[] arguments;

  public MlintArguments(Command command) {
    String mlintVersion = mlintVersion(command);
    this.arguments = mlintVersion.startsWith("0") ? ARGS_MLINT_0_X : ARGS_MLINT_1_X;
  }

  private static String mlintVersion(Command command) {
    long timeout = 10000;
    CommandStreamConsumer out = new CommandStreamConsumer();
    CommandStreamConsumer err = new CommandStreamConsumer();
    CommandExecutor.create().execute(command, out, err, timeout);
    Iterable<String> outputLines = Iterables.concat(out.getData(), err.getData());
    for (String outLine : outputLines) {
      Matcher matcher = MLINT_VERSION_PATTERN.matcher(outLine);
      if (matcher.matches()) {
        return matcher.group(1);
      }
    }
    String message =
      "Failed to determine mlint version with command: \"" + command.toCommandLine()
        + "\", received " + Iterables.size(outputLines) + " line(s) of output:\n" + Joiner.on('\n').join(outputLines);
    throw new IllegalArgumentException(message);
  }

  public String[] arguments() {
    return arguments;
  }

}
