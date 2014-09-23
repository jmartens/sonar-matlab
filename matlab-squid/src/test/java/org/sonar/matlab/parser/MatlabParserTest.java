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
package org.sonar.matlab.parser;

import com.google.common.base.Charsets;
import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.impl.Parser;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.sonar.matlab.MatlabConfiguration;

import java.io.File;
import java.util.Collection;

public class MatlabParserTest {

  private final Parser<Grammar> parser = MatlabParser.create(new MatlabConfiguration(Charsets.UTF_8));

  @Test
  public void test() {
    Collection<File> files = listFiles();
    for (File file : files) {
      parser.parse(file);
    }
  }

  private static Collection<File> listFiles() {
    File dir = new File("src/test/resources/parser/");
    return FileUtils.listFiles(dir, new String[]{"m"}, true);
  }

}