package com.algorithms.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Named.named;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTest {
  BinarySearch systemUnderTest = new BinarySearch();

  static Arguments testCase(int[] inputArray, int target, int expectedIndex) {
    return Arguments.of(
        inputArray,
        named("target %d".formatted(target), target),
        named("index %d".formatted(expectedIndex), expectedIndex)
    );
  }

  static Stream<Arguments> matrixProvider() {
    return Stream.of(
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 11, -1),
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 4),
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3, 2),
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8, 7),
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 5, 4),
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3, 2),
        testCase(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 8, 7)
    );
  }

  @ParameterizedTest(name = "When searching for {1} in {0} should return {2}")
  @MethodSource("matrixProvider")
  void should_return_correct_index_for_search(int[] inputArray, int target, int expectedIndex) {
    var foundIndex = systemUnderTest.search(inputArray, target);
    assertThat(foundIndex).isEqualTo(expectedIndex);
  }

  @ParameterizedTest(name = "When searching for {1} in {0} should return {2}")
  @MethodSource("matrixProvider")
  void should_return_correct_index_for_search_using_loop(int[] inputArray, int target, int expectedIndex) {
    var foundIndex = systemUnderTest.searchUsingLoop(inputArray, target);
    assertThat(foundIndex).isEqualTo(expectedIndex);
  }
}