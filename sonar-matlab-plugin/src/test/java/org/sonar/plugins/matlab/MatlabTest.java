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
package org.sonar.plugins.matlab;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.sonar.api.config.Settings;

import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class MatlabTest {

  @Test
  public void test() {
    Matlab language = new Matlab(new Settings());
    assertThat(language.getKey()).isEqualTo("py");
    assertThat(language.getName()).isEqualTo("Matlab");
    assertThat(language.getFileSuffixes()).hasSize(1).contains("py");
  }

  @Test
  public void custom_file_suffixes() {
    Map<String, String> props = Maps.newHashMap();
    props.put(MatlabPlugin.FILE_SUFFIXES_KEY, "py,matlab");

    Settings settings = new Settings();
    settings.addProperties(props);

    Matlab language = new Matlab(settings);
    assertThat(language.getFileSuffixes()).hasSize(2).contains("matlab");
  }
}
