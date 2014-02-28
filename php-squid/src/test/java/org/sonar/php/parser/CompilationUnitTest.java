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
package org.sonar.php.parser;

import org.junit.Before;
import org.junit.Test;
import org.sonar.sslr.tests.Assertions;

public class CompilationUnitTest extends RuleTest {

  @Before
  public void setUp() {
    setRootRule(PHPGrammar.COMPILATION_UNIT);
  }

  @Test
  public void test() {
    Assertions.assertThat(p)
      .matches("<?php")

      .matches("html <?php")
      .matches("html <?")
      .matches("html <?= ")

      .matches("<?php ?> html")
      .matches("<?php ?> html <?php")
      .matches("<?php ?> html <?php ?> html")

        // comment ends end of PHP block
      .matches("<?php { // comment ?> <?php } ?>");
  }

}
