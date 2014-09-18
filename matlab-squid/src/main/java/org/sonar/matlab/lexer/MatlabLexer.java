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
package org.sonar.matlab.lexer;

import com.sonar.sslr.impl.Lexer;
import com.sonar.sslr.impl.channel.BlackHoleChannel;
import com.sonar.sslr.impl.channel.IdentifierAndKeywordChannel;
import com.sonar.sslr.impl.channel.PunctuatorChannel;
import com.sonar.sslr.impl.channel.UnknownCharacterChannel;
import org.sonar.matlab.MatlabConfiguration;
import org.sonar.matlab.api.MatlabKeyword;
import org.sonar.matlab.api.MatlabPunctuator;
import org.sonar.matlab.api.MatlabTokenType;

import static com.sonar.sslr.impl.channel.RegexpChannelBuilder.and;
import static com.sonar.sslr.impl.channel.RegexpChannelBuilder.commentRegexp;
import static com.sonar.sslr.impl.channel.RegexpChannelBuilder.o2n;
import static com.sonar.sslr.impl.channel.RegexpChannelBuilder.regexp;

public final class MatlabLexer {

  private MatlabLexer() {
  }

  private static final String EXP = "([Ee][+-]?+[0-9_]++)";
  private static final String BYTES_PREFIX = "(br|bR|b|Br|BR|B)";
  private static final String IMAGINARY_SUFFIX = "(j|J)";
  private static final String LONG_INTEGER_SUFFIX = "(l|L)";

  public static Lexer create(MatlabConfiguration conf) {
    LexerState lexerState = new LexerState();

    return Lexer.builder()
        .withCharset(conf.getCharset())
        .withFailIfNoChannelToConsumeOneCharacter(true)

        .withChannel(new NewLineChannel(lexerState))

        .withChannel(new IndentationChannel(lexerState))
        .withPreprocessor(new IndentationPreprocessor(lexerState))

        .withChannel(new BlackHoleChannel("\\s"))

        // http://docs.matlab.org/reference/lexical_analysis.html#comments
        .withChannel(commentRegexp("#[^\\n\\r]*+"))

        // http://docs.matlab.org/reference/lexical_analysis.html#string-literals
        .withChannel(new StringLiteralsChannel())

        // http://docs.matlab.org/release/3.2/reference/lexical_analysis.html#string-and-bytes-literals
        .withChannel(regexp(MatlabTokenType.STRING, BYTES_PREFIX + "\'([^\'\\\\]*+(\\\\[\\s\\S])?+)*+\'"))
        .withChannel(regexp(MatlabTokenType.STRING, BYTES_PREFIX + "\"([^\"\\\\]*+(\\\\[\\s\\S])?+)*+\""))

        // http://docs.matlab.org/reference/lexical_analysis.html#floating-point-literals
        // http://docs.matlab.org/reference/lexical_analysis.html#imaginary-literals
        .withChannel(regexp(MatlabTokenType.NUMBER, "[0-9]++\\.[0-9]*+" + EXP + "?+" + IMAGINARY_SUFFIX + "?+"))
        .withChannel(regexp(MatlabTokenType.NUMBER, "\\.[0-9]++" + EXP + "?+" + IMAGINARY_SUFFIX + "?+"))
        .withChannel(regexp(MatlabTokenType.NUMBER, "[0-9]++" + EXP + IMAGINARY_SUFFIX + "?+"))
        .withChannel(regexp(MatlabTokenType.NUMBER, "[0-9]++" + IMAGINARY_SUFFIX))

        // http://docs.matlab.org/reference/lexical_analysis.html#integer-and-long-integer-literals
        .withChannel(regexp(MatlabTokenType.NUMBER, "0[oO]?+[0-7]++" + LONG_INTEGER_SUFFIX + "?+"))
        .withChannel(regexp(MatlabTokenType.NUMBER, "0[xX][0-9a-fA-F]++" + LONG_INTEGER_SUFFIX + "?+"))
        .withChannel(regexp(MatlabTokenType.NUMBER, "0[bB][01]++" + LONG_INTEGER_SUFFIX + "?+"))
        .withChannel(regexp(MatlabTokenType.NUMBER, "[1-9][0-9]*+" + LONG_INTEGER_SUFFIX + "?+"))
        .withChannel(regexp(MatlabTokenType.NUMBER, "0++" + LONG_INTEGER_SUFFIX + "?+"))

        // http://docs.matlab.org/reference/lexical_analysis.html#identifiers
        .withChannel(new IdentifierAndKeywordChannel(and("[a-zA-Z_]", o2n("\\w")), true, MatlabKeyword.values()))

        // http://docs.matlab.org/reference/lexical_analysis.html#operators
        // http://docs.matlab.org/reference/lexical_analysis.html#delimiters
        .withChannel(new PunctuatorChannel(MatlabPunctuator.values()))

        .withChannel(new UnknownCharacterChannel())

        .build();
  }
}
