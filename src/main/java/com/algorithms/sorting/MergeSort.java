package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the MergeSort algorithm.
 * <p>
 * [3, 2, 4, 1, 6]
 * /           \
 * [3, 2, 4]        [1, 6]
 * /      \         /   \
 * [3, 2]     [4]     [1]   [6]
 * /   \
 * [3]   [2]
 * <p>
 * Merging process:
 * - Merge [3] and [2] => [2, 3]
 * - Merge [2, 3] and [4] => [2, 3, 4]
 * - Merge [1] and [6] => [1, 6]
 * - Merge [2, 3, 4] and [1, 6] => [1, 2, 3, 4, 6]
 * <p>
 * Final sorted array:
 * [1, 2, 3, 4, 6]
 */
public class MergeSort {
  public List<Integer> sort(List<Integer> input) {
    if (input.size() <= 1) {
      return input;
    }
    var middleIndex = input.size() / 2;
    var sortedLeft = sort(input.subList(0, middleIndex));
    var sortedRight = sort(input.subList(middleIndex, input.size()));

    return merge(sortedLeft, sortedRight);
  }

  private List<Integer> merge(List<Integer> sortedLeft, List<Integer> sortedRight) {
    var merged = new ArrayList<Integer>(sortedLeft.size() + sortedRight.size());
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < sortedLeft.size() && rightIndex < sortedRight.size()) {
      if (sortedLeft.get(leftIndex) <= sortedRight.get(rightIndex)) {
        merged.add(sortedLeft.get(leftIndex++));
      } else {
        merged.add(sortedRight.get(rightIndex++));
      }
    }
    addRemainingElements(sortedLeft, leftIndex, merged);
    addRemainingElements(sortedRight, rightIndex, merged);
    return merged;
  }

  // Could be replaced and inlined with merged.addAll(list.subList(index, list.size()));
  private void addRemainingElements(List<Integer> sortedLeft, int leftIndex, ArrayList<Integer> merged) {
    while (leftIndex < sortedLeft.size()) {
      merged.add(sortedLeft.get(leftIndex));
      leftIndex++;
    }
  }
}