package com.algorithms;

import java.util.List;

public class SimpleArraySum {
  public int sumArray(int n, int[] array) {
    int output = 0;
    for (int i = 0; i < n; i++) {
      output += array[i];
    }
    return output;
  }

  public int sumArray(List<Integer> ar) {
    int output = 0;
    for (Integer integer : ar) {
      output += integer;
    }
    return output;
  }
}
