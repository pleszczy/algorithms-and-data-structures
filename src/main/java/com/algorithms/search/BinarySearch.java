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
      if (end - start > 1) {
        return search(arr, target, index, end);
      } else {
        return -1;
      }
    }
  }

  public int search(int low, int high) {
    while (low <= high) {
      var mid = (low + high) / 2;
      var result = Integer.compare(mid, 10);
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

  public int searchUsingLoop(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    int mid;

    while (start <= end) {
      mid = (start + end) / 2;

      if (target == arr[mid]) {
        return mid;
      }

      if (target > arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}