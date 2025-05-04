package com.algorithms.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class InsertionSortTest {
  private final InsertionSort systemUnderTest = new InsertionSort();

  @Test
  void should_sort_list_of_integers() {
    var unsorted = List.of(9, 8, 1, 6, 2, 4, 3, 3, 5, 10, 1, 7, 0);

    var sorted = systemUnderTest.sort(unsorted);

    assertThat(sorted).isEqualTo(List.of(0, 1, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10));
  }

  @Test
  void should_handle_empty_lists() {
    var unsorted = Collections.<Integer>emptyList();

    var sorted = systemUnderTest.sort(unsorted);

    assertThat(sorted).isEqualTo(Collections.<Integer>emptyList());
  }
}