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

  public int search(int low, int high) {
    while (low <= high) {
      var mid = (low + high) / 2;
      var result = compareToCorrectValue(mid);
      if (result > 0) {
        high = mid - 1;
      }
      if (result < 0) {
        low = mid + 1;
      }
      if (result == 0) {
        return mid;
      }
    }
    return -1;
  }

  // Suppressing as this is for exercising and not just using built-in utils
  @SuppressWarnings("UseCompareMethod")
  public int compareToCorrectValue(int n) {
    if (n > 10) {
      return 1;
    }
    if (n < 10) {
      return -1;
    }
    return 0;
  }
}