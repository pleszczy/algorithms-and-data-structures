package com.algorithms.sorting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MergeSortTest {
  private final MergeSort systemUnderTest = new MergeSort();

  @Test
  void should_sort_list_of_integers() {
    var unsorted = List.of(9, 8, 1, 6, 2, 4, 3, 5, 10, 7);

    var sorted = systemUnderTest.sort(unsorted);

    assertThat(sorted)
        .hasSize(10)
        .containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  }
}