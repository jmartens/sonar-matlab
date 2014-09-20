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

import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.utils.SonarException;
import org.sonar.api.utils.command.Command;
import org.sonar.api.utils.command.CommandExecutor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MlintIssuesAnalyzer {

  private static final Logger LOG = LoggerFactory.getLogger(MlintSensor.class);

  // To avoid burdening of users with rule clones we map the ids.
  // This workaround can die as soon as mlints <= 0.23.X become obsolete.
  private static final Map<String, String> ID_MAP = ImmutableMap.<String, String>builder()
    .build();

  private static final String FALLBACK_MLINT = "mlint";
  private static final Pattern PATTERN = Pattern.compile("^L\\s(\\d+)\\s\\(C\\s(\\d+)\\-?(\\d+)?\\)\\:\\s(\\w+)\\:\\s(.*)$");

  private String mlint = null;
  private String mlintConfigParam = null;
  private MlintArguments mlintArguments;

  MlintIssuesAnalyzer(String mlintPath, String mlintConfigPath) {
    this(mlintPath, mlintConfigPath, new MlintArguments(Command.create(mlintPathWithDefault(mlintPath))));
  }

  MlintIssuesAnalyzer(String mlintPath, String mlintConfigPath, MlintArguments arguments) {
    mlint = mlintPathWithDefault(mlintPath);

    if (mlintConfigPath != null) {
      if (!new File(mlintConfigPath).exists()) {
        throw new SonarException("Cannot find the mlint configuration file: " + mlintConfigPath);
      }
      mlintConfigParam = "--rcfile=" + mlintConfigPath;
    }
    
    mlintArguments = arguments;
  }

  private static String mlintPathWithDefault(String mlintPath) {
    if (mlintPath != null) {
      if (!new File(mlintPath).exists()) {
        throw new SonarException("Cannot find the mlint executable: " + mlintPath);
      }
      return mlintPath;
    }
    return FALLBACK_MLINT;
  }

  public List<Issue> analyze(String path, Charset charset, File out) throws IOException {
    Command command = Command.create(mlint).addArguments(mlintArguments.arguments()).addArgument(path);

    if (mlintConfigParam != null) {
      command.addArgument(mlintConfigParam);
    }

    LOG.debug("Calling command: '{}'", command.toString());

    long timeoutMS = 300000; // =5min
    CommandStreamConsumer stdOut = new CommandStreamConsumer();
    CommandStreamConsumer stdErr = new CommandStreamConsumer();
    CommandExecutor.create().execute(command, stdOut, stdErr, timeoutMS);

    // the error stream can contain a line like 'no custom config found, using default'
    // any bigger output on the error stream is likely a mlint malfunction
    if (stdErr.getData().size() > 1) {
      LOG.warn("Output on the error channel detected: this is probably due to a problem on mlint's side.");
      LOG.warn("Content of the error stream: \n\"{}\"", StringUtils.join(stdErr.getData(), "\n"));
    }

    Files.write(StringUtils.join(stdErr.getData(), "\n"), out, charset);

    // mlint seems to write everything to sdtout instead of stderr... sigh
    return parseOutput(stdErr.getData(), path);
  }

  protected List<Issue> parseOutput(List<String> lines, String path) {
    // Parse the output of mlint. Example of the format:
    //
    // complexity/code_chunks.py:62: [W0104, list_compr] Statement seems to have no effect
    // complexity/code_chunks.py:64: [C0111, list_compr_filter] Missing docstring
    // ...

    List<Issue> issues = new LinkedList<Issue>();

    int linenr;
    String filename = null;
    String ruleid = null;
    String objname = null;
    String descr = null;

    if (!lines.isEmpty()) {
      for (String line : lines) {
        if (line.length() > 0) {
          if (!isDetail(line)) {
            Matcher m = PATTERN.matcher(line);
            if (m.matches() && m.groupCount() >= 4) {
              filename = path;
              linenr = Integer.valueOf(m.group(1));
              ruleid = m.group(4);
              descr = m.group(5);
              issues.add(new Issue(filename, linenr, ruleid, descr));
            } else {
              LOG.debug("Cannot parse the line: {}", line);
            }
          } else {
            LOG.trace("Classifying as detail and ignoring line '{}'", line);
          }
        }
      }
    }

    return issues;
  }

  private String ruleId(String ruleAndMessageIds) {
    String ruleid = ruleAndMessageIds;
    int parenthesisIndex = ruleid.indexOf('(');
    if (parenthesisIndex > -1) {
      ruleid = ruleid.substring(0, parenthesisIndex);
    }
    if (ID_MAP.containsKey(ruleid)) {
      ruleid = ID_MAP.get(ruleid);
    }
    return ruleid;
  }

  private boolean isDetail(String line) {
    char first = line.charAt(0);
    return first == ' ' || first == '\t' || first == '\n';
  }

}
