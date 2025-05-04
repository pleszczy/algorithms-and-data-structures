package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MergeSortedListsTest {
  private final MergeSortedLists systemUnderTest = new MergeSortedLists();

  @Test
  void should_merge_two_sorted_lists() {
    var listA = List.of(1, 3, 5, 7, 9, 11, 14, 20, 21, 22, 23);
    var listB = List.of(2, 4, 6, 8, 10, 15, 19);

    var sortedLists = systemUnderTest.mergeSortedLists(listA, listB);

    assertThat(sortedLists).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 19, 20, 21, 22, 23);
  }
}