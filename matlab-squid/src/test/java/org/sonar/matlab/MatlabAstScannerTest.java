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
package org.sonar.matlab;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.sonar.sslr.api.Grammar;
import org.junit.Test;
import org.sonar.matlab.api.MatlabMetric;
import org.sonar.squidbridge.AstScanner;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.squidbridge.api.SourceProject;
import org.sonar.squidbridge.indexer.QueryByType;

import java.io.File;

import static org.fest.assertions.Assertions.assertThat;

public class MatlabAstScannerTest {

  @Test
  public void files() {
    AstScanner<Grammar> scanner = MatlabAstScanner.create(new MatlabConfiguration(Charsets.UTF_8));
    scanner.scanFiles(ImmutableList.of(new File("src/test/resources/metrics/lines.py"), new File("src/test/resources/metrics/comments.m")));
    SourceProject project = (SourceProject) scanner.getIndex().search(new QueryByType(SourceProject.class)).iterator().next();
    assertThat(project.getInt(MatlabMetric.FILES)).isEqualTo(2);
  }

  @Test
  public void comments() {
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/metrics/comments.m"));
    assertThat(file.getInt(MatlabMetric.COMMENT_LINES)).isEqualTo(1);
    assertThat(file.getNoSonarTagLines()).contains(3).hasSize(1);
  }

  @Test
  public void lines() {
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/metrics/lines.py"));
    assertThat(file.getInt(MatlabMetric.LINES)).isEqualTo(6);
  }

  @Test
  public void lines_of_code() {
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/metrics/lines_of_code.py"));
    assertThat(file.getInt(MatlabMetric.LINES_OF_CODE)).isEqualTo(1);
  }

  @Test
  public void statements() {
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/metrics/statements.py"));
    assertThat(file.getInt(MatlabMetric.STATEMENTS)).isEqualTo(1);
  }

  @Test
  public void functions() {
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/metrics/functions.py"));
    assertThat(file.getInt(MatlabMetric.FUNCTIONS)).isEqualTo(1);
  }

  @Test
  public void classes() {
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/metrics/classes.py"));
    assertThat(file.getInt(MatlabMetric.CLASSES)).isEqualTo(1);
  }

  @Test
  public void complexity() {
    SourceFile file = MatlabAstScanner.scanSingleFile(new File("src/test/resources/metrics/complexity.py"));
    assertThat(file.getInt(MatlabMetric.COMPLEXITY)).isEqualTo(10);
  }

}
