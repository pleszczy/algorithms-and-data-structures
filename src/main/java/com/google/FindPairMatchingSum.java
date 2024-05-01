package com.google;

public class FindPairMatchingSum {

  // O(n2)
  public int[] findPairSum(int[] numbers, int sum) {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        if (numbers[i] + numbers[j] == sum) {
          return new int[] {numbers[i], numbers[j]};
        }
      }
    }
    return new int[] {};
  }

  // O(n*logn)
  public int[] findPairSumUsingBinarySearch(int[] numbers, int sum) {
    for (int number : numbers) {
      int index = binarySearch(numbers, 0, numbers.length-1, sum - number);
      if (index != -1) {
        return new int[] {number, numbers[index]};
      }
    }
    return new int[] {};
  }

  private int binarySearch(int[] array, int left, int right, int target) {
    if (right >= left) {
      int mid = left + (right - left) / 2;

      if (array[mid] == target) {
        return mid;
      }
      if (target < array[mid]) {
        return binarySearch(array, left, mid - 1, target);
      }
      return binarySearch(array, mid + 1, right, target);
    }
    return -1;
  }
}
