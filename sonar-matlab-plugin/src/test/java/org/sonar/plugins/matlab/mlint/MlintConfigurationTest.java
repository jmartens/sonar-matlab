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

import org.junit.Before;
import org.junit.Test;
import org.sonar.api.config.Settings;
import org.sonar.api.scan.filesystem.ModuleFileSystem;

import java.io.File;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MlintConfigurationTest {

  private Settings settings;
  private MlintConfiguration mlintConfiguration;

  @Before
  public void setUp() throws Exception {
    settings = new Settings();
    mlintConfiguration = new MlintConfiguration(settings);
  }

  @Test
  public void shouldGetCorrectMlintPath() {
    ModuleFileSystem fs = mock(ModuleFileSystem.class);
    when(fs.baseDir()).thenReturn(new File("/projectroot"));

    assertThat(mlintConfiguration.getMlintConfigPath(fs)).isNull();

    settings.setProperty(MlintConfiguration.MLINT_CONFIG_KEY, (String) null);
    assertThat(mlintConfiguration.getMlintConfigPath(fs)).isNull();

    settings.setProperty(MlintConfiguration.MLINT_CONFIG_KEY, ".mlintrc");
    assertThat(mlintConfiguration.getMlintConfigPath(fs)).isEqualTo(new File("/projectroot/.mlintrc").getAbsolutePath());

    String absolutePath = new File("/absolute/.mlintrc").getAbsolutePath();
    settings.setProperty(MlintConfiguration.MLINT_CONFIG_KEY, absolutePath);
    assertThat(mlintConfiguration.getMlintConfigPath(fs)).isEqualTo(absolutePath);
  }

  @Test
  public void getMlintPath() {
    String path = "test/path";
    settings.setProperty(MlintConfiguration.MLINT_KEY, path);

    assertThat(mlintConfiguration.getMlintPath()).isEqualTo(path);
  }
}
