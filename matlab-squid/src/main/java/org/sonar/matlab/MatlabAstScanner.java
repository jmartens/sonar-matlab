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
import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.AstNodeType;
import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.impl.Parser;
import org.sonar.matlab.api.MatlabGrammar;
import org.sonar.matlab.api.MatlabKeyword;
import org.sonar.matlab.api.MatlabMetric;
import org.sonar.matlab.parser.MatlabParser;
import org.sonar.squidbridge.AstScanner;
import org.sonar.squidbridge.CommentAnalyser;
import org.sonar.squidbridge.SourceCodeBuilderCallback;
import org.sonar.squidbridge.SourceCodeBuilderVisitor;
import org.sonar.squidbridge.SquidAstVisitor;
import org.sonar.squidbridge.SquidAstVisitorContextImpl;
import org.sonar.squidbridge.api.SourceClass;
import org.sonar.squidbridge.api.SourceCode;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.squidbridge.api.SourceFunction;
import org.sonar.squidbridge.api.SourceProject;
import org.sonar.squidbridge.indexer.QueryByType;
import org.sonar.squidbridge.metrics.CommentsVisitor;
import org.sonar.squidbridge.metrics.ComplexityVisitor;
import org.sonar.squidbridge.metrics.CounterVisitor;
import org.sonar.squidbridge.metrics.LinesVisitor;

import java.io.File;
import java.util.Collection;

public final class MatlabAstScanner {

  private MatlabAstScanner() {
  }

  /**
   * Helper method for testing checks without having to deploy them on a Sonar instance.
   */
  public static SourceFile scanSingleFile(File file, SquidAstVisitor<Grammar>... visitors) {
    if (!file.isFile()) {
      throw new IllegalArgumentException("File '" + file + "' not found.");
    }
    AstScanner<Grammar> scanner = create(new MatlabConfiguration(Charsets.UTF_8), visitors);
    scanner.scanFile(file);
    Collection<SourceCode> sources = scanner.getIndex().search(new QueryByType(SourceFile.class));
    if (sources.size() != 1) {
      throw new IllegalStateException("Only one SourceFile was expected whereas " + sources.size() + " has been returned.");
    }
    return (SourceFile) sources.iterator().next();
  }

  public static AstScanner<Grammar> create(MatlabConfiguration conf, SquidAstVisitor<Grammar>... visitors) {
    final SquidAstVisitorContextImpl<Grammar> context = new SquidAstVisitorContextImpl<Grammar>(new SourceProject("Matlab Project"));
    final Parser<Grammar> parser = MatlabParser.create(conf);

    AstScanner.Builder<Grammar> builder = AstScanner.<Grammar>builder(context).setBaseParser(parser);

    /* Metrics */
    builder.withMetrics(MatlabMetric.values());

    /* Files */
    builder.setFilesMetric(MatlabMetric.FILES);

    /* Comments */
    builder.setCommentAnalyser(
      new CommentAnalyser() {
        @Override
        public boolean isBlank(String line) {
          for (int i = 0; i < line.length(); i++) {
            if (Character.isLetterOrDigit(line.charAt(i))) {
              return false;
            }
          }
          return true;
        }

        @Override
        public String getContents(String comment) {
          // Comment always starts with "#"
          return comment.substring(comment.indexOf('#'));
        }
      });



    /* Classes */
    builder.withSquidAstVisitor(new SourceCodeBuilderVisitor<Grammar>(new SourceCodeBuilderCallback() {
      public SourceCode createSourceCode(SourceCode parentSourceCode, AstNode astNode) {
        String functionName = astNode.getFirstChild(MatlabGrammar.CLASSNAME).getFirstChild().getTokenValue();
        SourceClass function = new SourceClass(functionName + ":" + astNode.getToken().getLine());
        function.setStartAtLine(astNode.getTokenLine());
        return function;
      }
    }, MatlabGrammar.CLASSDEF));

    builder.withSquidAstVisitor(CounterVisitor.<Grammar>builder()
      .setMetricDef(MatlabMetric.CLASSES)
      .subscribeTo(MatlabGrammar.CLASSDEF)
      .build());

    /* Functions */
    builder.withSquidAstVisitor(new SourceCodeBuilderVisitor<Grammar>(new SourceCodeBuilderCallback() {
      public SourceCode createSourceCode(SourceCode parentSourceCode, AstNode astNode) {
        String functionName = astNode.getFirstChild(MatlabGrammar.FUNCNAME).getFirstChild().getTokenValue();
        SourceFunction function = new SourceFunction(functionName + ":" + astNode.getToken().getLine());
        function.setStartAtLine(astNode.getTokenLine());
        return function;
      }
    }, MatlabGrammar.FUNCDEF));

    builder.withSquidAstVisitor(CounterVisitor.<Grammar>builder()
      .setMetricDef(MatlabMetric.FUNCTIONS)
      .subscribeTo(MatlabGrammar.FUNCDEF)
      .build());

    /* Metrics */
    builder.withSquidAstVisitor(new LinesVisitor<Grammar>(MatlabMetric.LINES));
    builder.withSquidAstVisitor(new MatlabLinesOfCodeVisitor<Grammar>(MatlabMetric.LINES_OF_CODE));
    AstNodeType[] complexityAstNodeType = new AstNodeType[]{
      // Entry points
      MatlabGrammar.FUNCDEF,

      // Branching nodes
      // Note that IF_STMT covered by MatlabKeyword.IF below
      MatlabGrammar.WHILE_STMT,
      MatlabGrammar.FOR_STMT,
      MatlabGrammar.RETURN_STMT,
      MatlabGrammar.RAISE_STMT,
      MatlabGrammar.EXCEPT_CLAUSE,

      // Expressions
      MatlabKeyword.IF,
      MatlabKeyword.AND,
      MatlabKeyword.OR
    };
    builder.withSquidAstVisitor(ComplexityVisitor.<Grammar>builder()
      .setMetricDef(MatlabMetric.COMPLEXITY)
      .subscribeTo(complexityAstNodeType)
      .build());

    builder.withSquidAstVisitor(CommentsVisitor.<Grammar>builder().withCommentMetric(MatlabMetric.COMMENT_LINES)
      .withNoSonar(true)
      .withIgnoreHeaderComment(conf.getIgnoreHeaderComments())
      .build());
    builder.withSquidAstVisitor(CounterVisitor.<Grammar>builder()
      .setMetricDef(MatlabMetric.STATEMENTS)
      .subscribeTo(MatlabGrammar.STATEMENT)
      .build());


    /* External visitors (typically Check ones) */
    for (SquidAstVisitor<Grammar> visitor : visitors) {
      builder.withSquidAstVisitor(visitor);
    }

    return builder.build();
  }

}
