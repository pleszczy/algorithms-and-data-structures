package com.utils;

public class Arrays {
  private static int[] subArray(int[] arr, int start, int end) {
    int[] output = new int[end - start];
    int j = 0;
    for (int i = start; i <= end; i++) {
      output[j] = arr[i];
      j++;
    }
    return output;
  }
}
