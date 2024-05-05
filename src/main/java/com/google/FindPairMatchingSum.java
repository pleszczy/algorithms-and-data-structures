package com.google;

import java.util.HashSet;

public class FindPairMatchingSum {
  // O(n2)
  public int[] solution(int[] numbers, int sum) {
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
  public int[] fasterSolution(int[] numbers, int sum) {
    for (int number : numbers) {
      var index = binarySearch(numbers, 0, numbers.length - 1, sum - number);
      if (index != -1) {
        return new int[] {number, numbers[index]};
      }
    }
    return new int[] {};
  }

  // O(n)
  public int[] optimalSolution(int[] numbers, int sum) {
    var right = numbers.length - 1;
    for (int i = 0; i <= right; i++) {
      while (numbers[i] + numbers[right] > sum && right > 0) {
        right -= 1;
      }

      if (numbers[i] + numbers[right] == sum) {
        return new int[] {numbers[i], numbers[right]};
      }
    }
    return new int[] {};
  }

  // O(n) + support of unordered input data
  public int[] optimalSolutionForUnorderedInput(int[] numbers, int sum) {
    var seenNumbers = new HashSet<>(numbers.length);
    for (int number : numbers) {
      var complement = sum - number;
      if (seenNumbers.contains(complement)) {
        return new int[] {complement, number};
      }
      seenNumbers.add(number);
    }
    return new int[] {};
  }

  private int binarySearch(int[] array, int left, int right, int target) {
    if (right >= left) {
      var mid = left + (right - left) / 2;

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
