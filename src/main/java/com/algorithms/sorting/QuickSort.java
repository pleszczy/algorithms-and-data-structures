package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the QuickSort algorithm
 * <p>
 * QuickSort selects a pivot (last element), partitions the list into elements less than or equal
 * to the pivot and those greater than it, then recursively applies the same process to each partition.
 * <p>
 * Example for input: [9, 8, 1, 6, 2, 4, 3, 5, 10, 7]
 * <p>
 * Step 1:
 * - Pivot = 7
 * - Elements <= 7: [1, 6, 2, 4, 3, 5]
 * - Elements > 7: [9, 8, 10]
 * <p>
 * Step 2 (left side - [1, 6, 2, 4, 3, 5], pivot = 5):
 * - Elements <= 5: [1, 2, 4, 3]
 * - Elements > 5: [6]
 * <p>
 * Step 3 (left side - [1, 2, 4, 3], pivot = 3):
 * - Elements <= 3: [1, 2]
 * - Elements > 3: [4]
 * <p>
 * Step 4 (left side - [1, 2], pivot = 2):
 * - Elements <= 2: [1]
 * - Elements > 2: []
 * <p>
 * Step 5 (right side - [9, 8, 10], pivot = 10):
 * - Elements <= 10: [9, 8]
 * - Elements > 10: []
 * <p>
 * Step 6 (left side - [9, 8], pivot = 8):
 * - Elements <= 8: []
 * - Elements > 8: [9]
 * <p>
 * Final sorted array:
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 */

public class QuickSort {

  public List<Integer> sort(List<Integer> input) {
    if (input.size() <= 1) {
      return input;
    }

    int pivot = pickPivotNaive(input);

    var less = new ArrayList<Integer>();
    var greater = new ArrayList<Integer>();

    for (int value : input) {
      if (value < pivot) {
        less.add(value);
      } else if (value > pivot) {
        greater.add(value);
      }
    }

    var sorted = new ArrayList<Integer>();
    sorted.addAll(sort(less));
    sorted.add(pivot);
    sorted.addAll(sort(greater));

    return sorted;
  }

  /**
   * A naive implementation where the pivot is always chosen as the last element of the list.
   * <p>
   * This approach can lead to the worst-case time complexity of O(n²) when the pivot is
   * consistently the smallest or largest element in the partition, resulting in an unbalanced tree.
   * <p>
   * A more optimal strategy would be choosing the pivot by selecting the median of the first, middle, and last elements.
   */
  private Integer pickPivotNaive(List<Integer> input) {
    return input.getLast();
  }
}
