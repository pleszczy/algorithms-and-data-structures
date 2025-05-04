package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchMatrixTest {
  private final SearchMatrix systemUnderTest = new SearchMatrix();

  static Stream<Arguments> matrixProvider() {
    return Stream.of(
        Arguments.of(new int[][] {
            {1, 2, 4, 8},
            {10, 11, 12, 13},
            {14, 20, 30, 40}
        }, 10, Named.of("should contain", true)),
        Arguments.of(new int[][] {
            {1, 2, 4, 8},
            {10, 11, 12, 13},
            {14, 20, 30, 40}
        }, 15, Named.of("should NOT contain", false))
    );
  }

  @ParameterizedTest(name = "{0} {2} target {1}")
  @MethodSource("matrixProvider")
  void should_return_length_of_longest_substring_without_repeating(int[][] matrix, int target, boolean expectedFound) {
    var actualFound = systemUnderTest.searchMatrixBruteForce(matrix, target);

    assertThat(actualFound).isEqualTo(expectedFound);
  }

  @ParameterizedTest(name = "{0} {2} target {1}")
  @MethodSource("matrixProvider")
  void should_return_length_of_longest_substring_without_repeating_optimized_1(int[][] matrix, int target, boolean expectedFound) {
    var actualFound = systemUnderTest.searchMatrixBruteForceOptimized1(matrix, target);

    assertThat(actualFound).isEqualTo(expectedFound);
  }

  @ParameterizedTest(name = "`{0}` {2} target {1}")
  @MethodSource("matrixProvider")
  void should_return_length_of_longest_substring_without_repeating_optimized_2(int[][] matrix, int target, boolean expectedFound) {
    var actualFound = systemUnderTest.searchMatrixOptimized2(matrix, target);

    assertThat(actualFound).isEqualTo(expectedFound);
  }
}