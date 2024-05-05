package com.google;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class
FindPairMatchingSumTest {
  @Test
  void should_not_find_a_matching_pair() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.solution(new int[] {1, 2, 3, 9}, 8);

    assertThat(matchingPairs).isEmpty();
  }

  @Test
  void should_find_a_matching_pair() {
   var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.solution(new int[] {1, 2, 4, 4}, 8);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 4);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.solution(new int[] {1, 2, 4, 4, 5, 6}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent_in_unordered_numbers() {
   var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.solution(new int[] {6, 2, 5, 4, 2, 1}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }

  @Test
  void should_not_find_a_matching_pair_binary_search() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.fasterSolution(new int[] {1, 2, 3, 9}, 8);

    assertThat(matchingPairs).isEmpty();
  }

  @Test
  void should_find_a_matching_pair_binary_search() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.fasterSolution(new int[] {1, 2, 4, 4}, 8);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 4);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent_binary_search() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.fasterSolution(new int[] {1, 2, 4, 4, 5, 6}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }

  @Test
  void should_not_find_a_matching_pair_optimal_solution() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolution(new int[] {1, 2, 3, 9}, 8);

    assertThat(matchingPairs).isEmpty();
  }

  @Test
  void should_not_find_a_matching_pair_with_huge_sum_optimal_solution() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolution(new int[] {1, 2, 3, 9}, 999);

    assertThat(matchingPairs).isEmpty();
  }

  @Test
  void should_not_find_a_matching_pair_with_negative_sum_optimal_solution() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolution(new int[] {1, 2, 3, 9}, -999);

    assertThat(matchingPairs).isEmpty();
  }


  @Test
  void should_find_a_matching_pair_optimal_solution() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolution(new int[] {1, 2, 4, 4}, 8);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 4);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent_optimal_solution() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolution(new int[] {1, 2, 4, 4, 5, 6}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }

 @Test
  void should_find_a_matching_pair_optimal_solution_2() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolutionForUnorderedInput(new int[] {1, 2, 4, 4}, 8);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 4);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent_optimal_solution_2() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolutionForUnorderedInput(new int[] {1, 2, 4, 4, 5, 6}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }

  @Test
  void should_find_a_matching_pair_not_adjacent_in_unordered_numbers_optimal_solution_2() {
    var systemUnderTest = new FindPairMatchingSum();

    var matchingPairs = systemUnderTest.optimalSolutionForUnorderedInput(new int[] {6, 2, 5, 4, 2, 1}, 10);

    assertThat(matchingPairs).containsExactlyInAnyOrder(4, 6);
  }
}