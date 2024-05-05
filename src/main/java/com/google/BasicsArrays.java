package com.google;

import java.util.Arrays;

public class BasicsArrays {
  // input: 1,2,3,5,6,7
  // output: 1,2,3,4,5,6
  public int[] insertMiddle(int[] input, int i, int n) {
    for (int it = input.length - 2; it > i - 1; it--) {
      input[it + 1] = input[it];
    }
    input[i] = n;
    return input;
  }

  // input: 1, 1, 2, 3, 4, 4, 5, 5, 6, 7, 7
  // output: 7 (number of unique numbers)
  public int removeDuplicates(int[] input) {
    int k = input.length;
    for (int i = input.length - 2; i >= 0; i--) {
      if (input[i] == input[i + 1]) {
        if (i + 2 < input.length) {
          shift(input, i);
        }
        k--;
      }
    }
    System.out.println(Arrays.toString(input));
    return k;
  }

  public void shift(int[] input, int shiftUtil) {
    var previous = input[input.length - 1];
    for (int i = input.length - 2; i > shiftUtil; i--) {
      var current = input[i];
      input[i] = previous;
      previous = current;
    }
  }
}
