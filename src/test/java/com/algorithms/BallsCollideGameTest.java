package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BallsCollideGameTest {
  private final BallsCollideGame systemUnderTest = new BallsCollideGame();

  static Stream<Arguments> remainingBalls() {
    return Stream.of(
        Arguments.of(List.of(1, -1, 1, -1, 1), List.of(1, 2, 3, 4, 5), List.of(1, 3, 4)),
        Arguments.of(List.of(1, 1, -1, -1, -1, -1, 1), List.of(1, 2, 3, 4, 5, 6, 7), List.of(2, 3, 4, 5, 6))
    );
  }

  @ParameterizedTest(name = "For directions: {0} and strengths: {1} the reaming ball indexes should be {2}")
  @MethodSource("remainingBalls")
  void should_return_indexes_of_remaining_balls(List<Integer> directions, List<Integer> strengths, List<Integer> remainingBallsIndexes) {
    var survivingBallsIndexes = systemUnderTest.ballsCollide(directions, strengths);

    assertThat(survivingBallsIndexes).containsExactlyElementsOf(remainingBallsIndexes);
  }
}