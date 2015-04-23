/*
 * SonarQube PHP Plugin
 * Copyright (C) 2010 SonarSource and Akram Ben Aissi
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
package org.sonar.plugins.php.phpunit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.internal.DefaultFileSystem;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.resources.Project;

import static org.fest.assertions.Assertions.assertThat;

public class PhpUnitItCoverageResultParserTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private Project project;
  @Mock
  private SensorContext context;
  private PhpUnitCoverageResultParser parser;

  @Before
  public void setUp() throws Exception {
    parser = new PhpUnitItCoverageResultParser(context, new DefaultFileSystem());
  }

  @Test
  public void shouldSetMetrics() {
    assertThat(parser.lineCoverage).isEqualTo(CoreMetrics.IT_LINE_COVERAGE);
    assertThat(parser.linesToCover).isEqualTo(CoreMetrics.IT_LINES_TO_COVER);
    assertThat(parser.uncoveredLines).isEqualTo(CoreMetrics.IT_UNCOVERED_LINES);
    assertThat(parser.coverageLineHitsData).isEqualTo(CoreMetrics.IT_COVERAGE_LINE_HITS_DATA);
  }
}
