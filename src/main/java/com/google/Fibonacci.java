package com.google;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Fibonacci {
  // O(2ⁿ)
  public static long fibRecursive(int n) {
    if (n == 1) {
      return 0;
    }
    if (n < 3) {
      return 1;
    }
    return fibRecursive(n - 1) + fibRecursive(n - 2);
  }

  // O(n)
  public static long fibLoop(int n) {
    if (n == 1) {
      return 0;
    }
    if (n < 3) {
      return 1;
    }
    long prev = 0;
    long current = 1;
    for (int i = 3; i < n; i++) {
      long tmp = prev + current;
      prev = current;
      current = tmp;
    }

    return prev + current;
  }

  public static void main(String[] args) {
    var stopwatchA = Stopwatch.createStarted();
    IntStream.range(0, 46).forEach(it -> System.out.printf("%d : %d%n", it, fibRecursive(it)));
    stopwatchA.stop();
    var stopwatchB = Stopwatch.createStarted();
    IntStream.range(0, 46).forEach(it -> System.out.printf("%d : %d%n",it,  fibLoop(it)));
    stopwatchB.stop();
    System.out.printf("Recursion took %d ms%n", stopwatchA.elapsed(TimeUnit.MILLISECONDS));
    System.out.printf("Iteration took %d ms%n", stopwatchB.elapsed(TimeUnit.MILLISECONDS));
  }
}
