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
package org.sonar.plugins.matlab.colorizer;

import com.google.common.collect.Lists;
import org.sonar.api.web.CodeColorizerFormat;
import org.sonar.colorizer.KeywordsTokenizer;
import org.sonar.colorizer.StringTokenizer;
import org.sonar.colorizer.Tokenizer;
import org.sonar.plugins.matlab.Matlab;
import org.sonar.matlab.api.MatlabKeyword;

import java.util.List;

public final class MatlabColorizer extends CodeColorizerFormat {

  private List<Tokenizer> tokenizers;
  private static final String END_TAG = "</span>";
  public MatlabColorizer() {
    super(Matlab.KEY);
  }

  @Override
  public List<Tokenizer> getTokenizers() {
    if (tokenizers == null) {
      tokenizers = Lists.newArrayList();
      tokenizers.add(new KeywordsTokenizer("<span class=\"k\">", END_TAG, MatlabKeyword.keywordValues()));
      tokenizers.add(new MatlabDocStringTokenizer("<span class=\"s\">", END_TAG));
      tokenizers.add(new StringTokenizer("<span class=\"s\">", END_TAG));
      tokenizers.add(new MatlabDocTokenizer("<span class=\"cd\">", END_TAG));
    }
    return tokenizers;
  }

}
