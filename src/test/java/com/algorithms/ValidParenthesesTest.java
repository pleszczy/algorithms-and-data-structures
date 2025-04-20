package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

  @Test
  void should_be_invalid() {
    var sut = new ValidParentheses();

    var actual = sut.isValid("(]");

    assertThat(actual).isFalse();
  }

  @Test
  void should_be_valid_example_1() {
    var sut = new ValidParentheses();

    var actual = sut.isValid("()[]{}");

    assertThat(actual).isTrue();
  }

  @Test
  void should_be_valid_example_2() {
    var sut = new ValidParentheses();

    var actual = sut.isValid("()");

    assertThat(actual).isTrue();
  }

  @Test
  void should_be_valid_example_3() {
    var sut = new ValidParentheses();

    var actual = sut.isValid("{[]}");

    assertThat(actual).isTrue();
  }
}