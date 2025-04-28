package com.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class BucketSortTest {
  BucketSort systemUnderTest = new BucketSort();

  @Test
  void should_sort_list_of_integers() {
    var unsorted = List.of(9, 8, 1, 6, 2, 4, 3, 3, 5, 10, 10, 7);

    var sorted = systemUnderTest.sort(unsorted, 10);

    assertEquals(List.of(1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 10), sorted);
  }

  @Test
  void should_sort_list_of_integers_improved_version() {
    var unsorted = List.of(69, 42, 119, 58, 200, 1, 0, -99, -200);

    var sorted = systemUnderTest.sortImproved(unsorted);

    assertEquals(List.of(-200, -99, 0, 1, 42, 58, 69, 119, 200), sorted);
  }


}