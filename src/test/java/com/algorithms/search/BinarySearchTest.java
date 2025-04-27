package com.algorithms.search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BinarySearchTest {
  BinarySearch systemUnderTest = new BinarySearch();

  @Test
  void should_return_magic_index_if_element_was_not_found() {
    var foundIndex = systemUnderTest.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 11);

    assertThat(foundIndex).isEqualTo(-1);
  }

  @Test
  void should_return_index_of_an_element_in_middle_of_even_sorted_array() {
    var foundIndex = systemUnderTest.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);

    assertThat(foundIndex).isEqualTo(4);
  }

  @Test
  void should_return_index_of_an_element_in_start_of_even_sorted_array() {
    var foundIndex = systemUnderTest.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);

    assertThat(foundIndex).isEqualTo(2);
  }

  @Test
  void should_return_index_of_an_element_in_end_of_even_sorted_array() {
    var foundIndex = systemUnderTest.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8);

    assertThat(foundIndex).isEqualTo(7);
  }

  @Test
  void should_return_index_of_an_element_in_middle_of_odd_sorted_array() {
    var foundIndex = systemUnderTest.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 5);

    assertThat(foundIndex).isEqualTo(4);
  }

  @Test
  void should_return_index_of_an_element_in_start_of_odd() {
    var foundIndex = systemUnderTest.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);

    assertThat(foundIndex).isEqualTo(2);
  }

  @Test
  void should_return_index_of_an_element_in_end_of_odd_array() {
    var foundIndex = systemUnderTest.search(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 8);

    assertThat(foundIndex).isEqualTo(7);
  }

  @Test
  void should_find_a_number_that_matches() {
    var foundIndex = systemUnderTest.search(0, 100);

    assertThat(foundIndex).isEqualTo(10);
  }
}