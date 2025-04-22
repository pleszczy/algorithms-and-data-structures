package com.algorithms.search;

public class BinarySearch {
  public int search(int[] arr, int target) {
    return search(arr, target, 0, arr.length);
  }

  public int search(int[] arr, int target, int start, int end) {
    var index = (end - start) / 2 + start;
    var middle = arr[index];
    if (target == middle) {
      return index;
    }
    if (target < middle) {
      return search(arr, target, start, index);
    } else {
      return search(arr, target, index, end);
    }
  }
}