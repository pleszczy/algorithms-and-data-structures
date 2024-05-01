package com.google;

public class FindPairMatchingSum {

  // O(n2)
  public int[] findPairSumSlowSolution(int[] numbers, int sum) {
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
  public int[] findPairSumFasterSolution(int[] numbers, int sum) {
    for (int number : numbers) {
      int index = binarySearch(numbers, 0, numbers.length - 1, sum - number);
      if (index != -1) {
        return new int[] {number, numbers[index]};
      }
    }
    return new int[] {};
  }

  // O(n)
  public int[] findPairSumOptimalSolution(int[] numbers, int sum) {
    int right = numbers.length - 1;
    for (int i = 0; i < right; i++) {
      while (numbers[i] + numbers[right] > sum && right < numbers.length - 1) {
        right = right - 1;
      }

      if (numbers[i] + numbers[right] == sum) {
        return new int[] {numbers[i], numbers[right]};
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
