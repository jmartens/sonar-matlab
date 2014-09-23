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
package org.sonar.matlab.toolkit;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.impl.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.colorizer.KeywordsTokenizer;
import org.sonar.colorizer.Tokenizer;
import org.sonar.matlab.MatlabConfiguration;
import org.sonar.matlab.api.MatlabKeyword;
import org.sonar.matlab.parser.MatlabParser;
import org.sonar.sslr.toolkit.AbstractConfigurationModel;
import org.sonar.sslr.toolkit.ConfigurationProperty;
import org.sonar.sslr.toolkit.Validators;

import java.nio.charset.Charset;
import java.util.List;

public class MatlabConfigurationModel extends AbstractConfigurationModel {

  private static final Logger LOG = LoggerFactory.getLogger(MatlabConfigurationModel.class);

  private static final String CHARSET_PROPERTY_KEY = "sonar.sourceEncoding";

  @VisibleForTesting
  ConfigurationProperty charsetProperty = new ConfigurationProperty("Charset", CHARSET_PROPERTY_KEY,
    getPropertyOrDefaultValue(CHARSET_PROPERTY_KEY, "UTF-8"),
    Validators.charsetValidator());

  @Override
  public Charset getCharset() {
    return Charset.forName(charsetProperty.getValue());
  }

  @Override
  public List<ConfigurationProperty> getProperties() {
    return ImmutableList.of(charsetProperty);
  }

  @Override
  public Parser<Grammar> doGetParser() {
    return MatlabParser.create(getConfiguration());
  }

  @Override
  public List<Tokenizer> doGetTokenizers() {
    return ImmutableList.of(
      (Tokenizer) new KeywordsTokenizer("<span class=\"k\">", "</span>", MatlabKeyword.keywordValues()));
  }

  @VisibleForTesting
  MatlabConfiguration getConfiguration() {
    return new MatlabConfiguration(Charset.forName(charsetProperty.getValue()));
  }

  @VisibleForTesting
  static String getPropertyOrDefaultValue(String propertyKey, String defaultValue) {
    String propertyValue = System.getProperty(propertyKey);

    if (propertyValue == null) {
      LOG.info("The property \"" + propertyKey + "\" is not set, using the default value \"" + defaultValue + "\".");
      return defaultValue;
    } else {
      LOG.info("The property \"" + propertyKey + "\" is set, using its value \"" + propertyValue + "\".");
      return propertyValue;
    }
  }

}