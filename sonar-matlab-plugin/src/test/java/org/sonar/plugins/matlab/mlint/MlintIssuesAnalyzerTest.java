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

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.sonar.api.utils.SonarException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class MlintIssuesAnalyzerTest {
	
  @Test
  public void shouldParseCorrectly() {
/*
    String resourceName = "/org/sonar/plugins/matlab/mlint/sample_mlint_output.txt";
    String pathName = getClass().getResource(resourceName).getPath();
    String mlintConfigPath = null;
    String mlintPath = null;
    List<String> lines = readFile(pathName);
    List<Issue> issues = analyzer(mlintPath, mlintConfigPath).parseOutput(lines);
    assertThat(issues.size()).isEqualTo(21);
*/
	Pattern PATTERN = Pattern.compile("^L\\s(\\d+)\\s\\(C\\s(\\d+)\\-?(\\d+)?\\)\\:\\s(\\w+)\\:\\s(.*)$");
	Matcher m = null;
	
	String line1 = "L 1 (C 1-3): ENDCT: An END might be missing, possibly matching FOR.";
	m = PATTERN.matcher(line1);
	assertThat(m.groupCount()).isEqualTo(5);

	String line2 = "L 1 (C 1): ENDCT: An END might be missing, possibly matching FOR.";
	m = PATTERN.matcher(line2);
	assertThat(m.groupCount()).isEqualTo(4);
  }
/*
  @Test
  public void shouldParseCorrectlyNewFormat() {
    String resourceName = "/org/sonar/plugins/matlab/mlint/sample_mlint_output_new_format.txt";
    String pathName = getClass().getResource(resourceName).getPath();
    String mlintConfigPath = null;
    String mlintPath = null;
    List<String> lines = readFile(pathName);
    List<Issue> issues = analyzer(mlintPath, mlintConfigPath).parseOutput(lines);
    assertThat(issues.size()).isEqualTo(1);
    assertThat(issues.get(0).getRuleId()).isEqualTo("C0111");
  }

  @Test
  public void shouldParseCorrectlyOutputWithWindowsPaths() {
    String resourceName = "/org/sonar/plugins/matlab/mlint/sample_mlint_output_with_win_paths.txt";
    String pathName = getClass().getResource(resourceName).getPath();
    String mlintConfigPath = null;
    String mlintPath = null;
    List<String> lines = readFile(pathName);
    List<Issue> issues = analyzer(mlintPath, mlintConfigPath).parseOutput(lines);
    assertThat(issues.size()).isEqualTo(1);
  }

  @Test
  public void shouldMapIssuesIdsCorrectly() {
    String resourceOld = "/org/sonar/plugins/matlab/mlint/sample_mlint_output_oldids.txt";
    String resourceNew = "/org/sonar/plugins/matlab/mlint/sample_mlint_output_newids.txt";
    String pathNameOld = getClass().getResource(resourceOld).getPath();
    String pathNameNew = getClass().getResource(resourceNew).getPath();
    String mlintConfigPath = null;
    String mlintPath = null;
    List<String> linesOld = readFile(pathNameOld);
    List<String> linesNew = readFile(pathNameNew);
    List<Issue> issuesOld = analyzer(mlintPath, mlintConfigPath).parseOutput(linesOld);
    List<Issue> issuesNew = analyzer(mlintPath, mlintConfigPath).parseOutput(linesNew);
    assertThat(getIds(issuesOld)).isEqualTo(getIds(issuesNew));
  }

  @Test
  public void shouldWorkWithValidCustomConfig() {
    String resourceName = "/org/sonar/plugins/matlab/mlint/mlintrc_sample";
    String mlintConfigPath = getClass().getResource(resourceName).getPath();
    String mlintPath = null;
    analyzer(mlintPath, mlintConfigPath);
  }

  @Test(expected = SonarException.class)
  public void shouldFailIfGivenInvalidConfig() {
    String mlintConfigPath = "xx_path_that_doesnt_exist_xx";
    String mlintPath = null;
    analyzer(mlintPath, mlintConfigPath);
  }

  @Test
  public void shouldInstantiateWhenGivenValidParams() {
    String mlintrcResource = "/org/sonar/plugins/matlab/mlint/mlintrc_sample";
    String mlintrcPath = getClass().getResource(mlintrcResource).getPath();
    String executableResource = "/org/sonar/plugins/matlab/mlint/executable";
    String executablePath = getClass().getResource(executableResource).getPath();
    final String[] VALID_PARAMETERS =
      {
        null, null,
        executablePath, null,
        null, mlintrcPath,
        executablePath, mlintrcPath
      };

    int numberOfParams = VALID_PARAMETERS.length;
    for(int i = 0; i<numberOfParams-1; i+=2){
      try{
        analyzer(VALID_PARAMETERS[i], VALID_PARAMETERS[i + 1]);
      } catch (SonarException se) {
        assert(false);
      }
    }
  }


  @Test
  public void shouldFailIfGivenInvalidParams() {
    final String NOT_EXISTING_PATH = "notexistingpath";
    final String[] INVALID_PARAMETERS =
      {
        null, NOT_EXISTING_PATH,
        NOT_EXISTING_PATH, null,
        NOT_EXISTING_PATH, NOT_EXISTING_PATH
      };

    int numberOfParams = INVALID_PARAMETERS.length;
    for(int i = 0; i<numberOfParams-1; i+=2){
      try{
        analyzer(INVALID_PARAMETERS[i], INVALID_PARAMETERS[i + 1]);
        assert(false);
      } catch (SonarException se) {}
    }
  }

  private List<String> readFile(String path) {
    List<String> lines = new LinkedList<String>();

    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(path));
      String s = null;

      while ((s = reader.readLine()) != null) {
        lines.add(s);
      }
    } catch (IOException e) {
      System.err.println("Cannot read the file '" + path + "'");
    } finally {
    	IOUtils.closeQuietly(reader);
    }

    return lines;
  }

  private List<String> getIds(List<Issue> issues){
    List<String> ids = new LinkedList<String>();
    for(Issue issue: issues) ids.add(issue.getRuleId());
    return ids;
  }

  private MlintIssuesAnalyzer analyzer(String mlintPath, String mlintConfigPath) {
    MlintArguments arguments = mock(MlintArguments.class);
    return new MlintIssuesAnalyzer(mlintPath, mlintConfigPath, arguments);
  }
*/
}
