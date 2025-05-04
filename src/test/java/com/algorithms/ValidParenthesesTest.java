package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {
  private final ValidParentheses systemUnderTest = new ValidParentheses();

  @Test
  void should_be_invalid() {
    var actual = systemUnderTest.isValid("(]");

    assertThat(actual).isFalse();
  }

  @Test
  void should_be_valid_example_1() {
    var actual = systemUnderTest.isValid("()[]{}");

    assertThat(actual).isTrue();
  }

  @Test
  void should_be_valid_example_2() {
    var actual = systemUnderTest.isValid("()");

    assertThat(actual).isTrue();
  }

  @Test
  void should_be_valid_example_3() {
    var actual = systemUnderTest.isValid("{[]}");

    assertThat(actual).isTrue();
  }
}