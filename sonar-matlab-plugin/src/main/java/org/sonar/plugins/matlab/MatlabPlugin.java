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

import com.google.common.collect.ImmutableList;
import org.sonar.api.SonarPlugin;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;
import org.sonar.plugins.matlab.colorizer.MatlabColorizer;
import org.sonar.plugins.matlab.coverage.MatlabCoverageSensor;
import org.sonar.plugins.matlab.cpd.MatlabCpdMapping;
import org.sonar.plugins.matlab.mlint.MlintConfiguration;
import org.sonar.plugins.matlab.mlint.MlintRuleRepository;
import org.sonar.plugins.matlab.mlint.MlintSensor;
import org.sonar.plugins.matlab.xunit.MatlabXunitSensor;

import java.util.List;

public class MatlabPlugin extends SonarPlugin {

  public static final String FILE_SUFFIXES_KEY = "sonar.matlab.file.suffixes";

  public List getExtensions() {
    return ImmutableList.of(

        PropertyDefinition.builder(FILE_SUFFIXES_KEY)
          .name("File Suffixes")
          .description("Comma-separated list of suffixes of Matlab files to analyze.")
          .category("Matlab")
          .onQualifiers(Qualifiers.PROJECT)
          .defaultValue("py")
          .build(),

        Matlab.class,
        MatlabSourceImporter.class,
        MatlabColorizer.class,
        MatlabCpdMapping.class,

        MatlabSquidSensor.class,
        MatlabRuleRepository.class,
        MatlabDefaultProfile.class,

        MatlabCommonRulesEngine.class,

        // mlint
        MlintConfiguration.class,
        MlintSensor.class,
        MlintRuleRepository.class,

        MatlabXunitSensor.class,
        MatlabCoverageSensor.class);
  }

}
