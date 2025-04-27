package com.algorithms.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestSubstringTest {
  LongestSubstring systemUnderTest = new LongestSubstring();

  static Stream<Arguments> longestLengthProvider() {
    return Stream.of(
        Arguments.of(null, 0),
        Arguments.of("", 0),
        Arguments.of(" ", 0),
        Arguments.of("abcabcbb", 3),
        Arguments.of("bbbbb", 1),
        Arguments.of("pwwkew", 3)
    );
  }

  @ParameterizedTest(name = "`{0}` longest substring should be {1}")
  @MethodSource("longestLengthProvider")
  void should_return_length_of_longest_substring_without_repeating(String input, int expectedLength) {
    var length = systemUnderTest.longestSubstring(input);

    assertThat(length).isEqualTo(expectedLength);
  }
}