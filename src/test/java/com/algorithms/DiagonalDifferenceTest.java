package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiagonalDifferenceTest {
  private final DiagonalDifference systemUnderTest = new DiagonalDifference();

  static Stream<Arguments> diagonalDifferenceCases() {
    return Stream.of(
        Arguments.of(List.of(
            List.of(1, 2, 3),
            List.of(4, 5, 6),
            List.of(9, 8, 9)
        ), 2),
        Arguments.of(List.of(
            List.of(1, 2, 3, 4),
            List.of(5, 6, 7, 8),
            List.of(9, 10, 11, 12),
            List.of(13, 14, 15, 16)
        ), 0),
        Arguments.of(List.of(
            List.of(1, 2, 9, 4),
            List.of(5, 6, 7, 8),
            List.of(9, 10, 11, 12),
            List.of(22, 14, 15, 17)
        ), 8)
    );
  }

  @ParameterizedTest(name = "`{0}` diagonal difference should be {1}")
  @MethodSource("diagonalDifferenceCases")
  void should_calculate_diagonal_difference(List<List<Integer>> input, int expectedDifference) {
    var diagonalDifference = systemUnderTest.diagonalDifference(input);

    assertThat(diagonalDifference).isEqualTo(expectedDifference);
  }
}