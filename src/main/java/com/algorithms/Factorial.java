package com.algorithms;

import java.util.stream.IntStream;

public class Factorial {
  public int factorialRecursive(int n) {
    if (n < 2) {
      return 1;
    }
    return n * factorialRecursive(n - 1);
  }

  public int factorialIterative(int n) {
    int factorial = 1;
    for (int i = 2; i <= n; i++) {
      factorial = factorial * i;
    }
    return factorial;
  }

  public int factorialReducing(int n) {
    return IntStream.rangeClosed(1, n)
        .reduce(1, (a, b) -> a * b);
  }
}
