package com.google;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FindPairMatchingSumTest {
  @Test
  void should_not_find_a_matching_pair() {
    FindPairMatchingSum systemUnderTest = new FindPairMatchingSum();

    int[] matchingPairs = systemUnderTest.findPairSum(new int[] {1, 2, 3, 9}, 8);

    assertThat(matchingPairs).isEmpty();
  }

  @Test
  void should_find_a_matching_pair() {
    FindPairMatchingSum systemUnderTest = new FindPairMatchingSum();

    int[] matchingPairs = systemUnderTest.findPairSum(new int[] {1, 2, 4, 4}, 8);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 4);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent() {
    FindPairMatchingSum systemUnderTest = new FindPairMatchingSum();

    int[] matchingPairs = systemUnderTest.findPairSum(new int[] {1, 2, 4, 4, 5, 6}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent_in_unordered_numbers() {
    FindPairMatchingSum systemUnderTest = new FindPairMatchingSum();

    int[] matchingPairs = systemUnderTest.findPairSum(new int[] {6, 2, 5, 4, 2, 1}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }

  @Test
  void should_not_find_a_matching_pair_binary_search() {
    FindPairMatchingSum systemUnderTest = new FindPairMatchingSum();

    int[] matchingPairs = systemUnderTest.findPairSumUsingBinarySearch(new int[] {1, 2, 3, 9}, 8);

    assertThat(matchingPairs).isEmpty();
  }

  @Test
  void should_find_a_matching_pair_binary_search() {
    FindPairMatchingSum systemUnderTest = new FindPairMatchingSum();

    int[] matchingPairs = systemUnderTest.findPairSumUsingBinarySearch(new int[] {1, 2, 4, 4}, 8);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 4);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent_binary_search() {
    FindPairMatchingSum systemUnderTest = new FindPairMatchingSum();

    int[] matchingPairs =
        systemUnderTest.findPairSumUsingBinarySearch(new int[] {1, 2, 4, 4, 5, 6}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }
}