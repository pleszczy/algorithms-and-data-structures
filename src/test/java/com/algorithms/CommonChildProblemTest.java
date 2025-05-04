package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CommonChildProblemTest {
  CommonChildProblem systemUnderTest = new CommonChildProblem();

  static Stream<Arguments> fixtures() {
    return Stream.of(
        Arguments.of("HARRY", "SALLY", 2),
        Arguments.of("AA", "BB", 0),
        Arguments.of("SHINCHAN", "NOHARAAA", 3),
        Arguments.of("ABCDEF", "FBDAMN", 2)
    );
  }

  @ParameterizedTest(name = "Length of a common child of `{0}` and `{1}` should be {1}")
  @MethodSource("fixtures")
  void should_calculate_diagonal_difference(String firstString, String secondString, int expectedLength) {
    var actualLength = systemUnderTest.commonChild(firstString, secondString);

    assertThat(actualLength).isEqualTo(expectedLength);
  }


}