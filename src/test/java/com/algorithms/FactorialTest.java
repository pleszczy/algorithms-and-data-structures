package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactorialTest {
  private final Factorial systemUnderTest = new Factorial();

  @Test
  void should_return_factorial_using_recursion() {
    var factorial = systemUnderTest.factorialRecursive(5);

    assertThat(factorial).isEqualTo(120);
  }

  @Test
  void should_return_factorial_using_loop() {
    var factorial = systemUnderTest.factorialIterative(5);

    assertThat(factorial).isEqualTo(120);
  }

  @Test
  void should_return_factorial_using_reduce() {
    var factorial = systemUnderTest.factorialReducing(5);

    assertThat(factorial).isEqualTo(120);
  }
}