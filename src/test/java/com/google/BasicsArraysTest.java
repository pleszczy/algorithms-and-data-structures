package com.google;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BasicsArraysTest {
  @Test
  void should_insert_value_into_middle_of_array() {
    var array = new int[] {1, 2, 3, 5, 6, 7};
    var sut = new BasicsArrays();

    assertThat(sut.insertMiddle(array, 3, 4))
        .containsExactly(1, 2, 3, 4, 5, 6);
  }

  @Test
  void should_remove_duplicated_values_in_a_sorted_array() {
    var input = new int[] {1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 7};
    var expected = new int[] {1, 2, 3, 4, 5, 6, 7};
    var sut = new BasicsArrays();

    var noOfUniques = sut.removeDuplicates(input);

    assertThat(noOfUniques).isEqualTo(expected.length);
    for (int i = 0; i < noOfUniques; i++) {
      assert input[i] == expected[i];
    }
  }

  @Test
  void should_remove_duplicated_values_in_a_sorted_array_using_optimal_solution() {
    var input = new int[] {1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 7};
    var expected = new int[] {1, 2, 3, 4, 5, 6, 7};
    var sut = new BasicsArrays();

    var noOfUniques = sut.removeDuplicatesOptimal(input);

    assertThat(noOfUniques).isEqualTo(expected.length);
    for (int i = 0; i < noOfUniques; i++) {
      assert input[i] == expected[i];
    }
  }

  @Test
  void should_remove_duplicated_values_in_a_sorted_array_using_optimal_solution_for_2_element_input() {
    var input = new int[] {1, 2};
    var expected = new int[] {1, 2};
    var sut = new BasicsArrays();

    var noOfUniques = sut.removeDuplicatesOptimal(input);

    assertThat(noOfUniques).isEqualTo(expected.length);
    for (int i = 0; i < noOfUniques; i++) {
      assert input[i] == expected[i];
    }
  }

  @Test
  void should_remove_duplicated_values_in_a_sorted_array_using_optimal_solution_for_2_element_empty() {
    var input = new int[] {};
    var sut = new BasicsArrays();

    var noOfUniques = sut.removeDuplicatesOptimal(input);

    assertThat(noOfUniques).isEqualTo(0);
  }

  @Test
  void should_remove_value() {
    var input = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
    var valueToRemove = 2;
    var sut = new BasicsArrays();

    var k = sut.removeElement(input, valueToRemove);

    assertThat(k).isEqualTo(5);
    assertThat(input).contains(0, 1, 3, 0, 4);
  }

  @Test
  void should_concatenate_arrays() {
    var input = new int[] {1, 3, 2, 1};
    var expected = new int[] {1, 3, 2, 1, 1, 3, 2, 1};
    var sut = new BasicsArrays();

    var actual = sut.getConcatenation(input);

    assertThat(actual).isEqualTo(expected);
  }
}