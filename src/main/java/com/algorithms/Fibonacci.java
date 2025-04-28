package com.algorithms;

import com.google.common.base.Stopwatch;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Fibonacci {
  private static final Map<Integer, BigInteger> lruCache = new LinkedHashMap<>(256, 1.0f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, BigInteger> eldest) {
      return this.size() > 256;
    }
  };

  // O(2ⁿ)
  public static long fibRecursive(int n) {
    if (n == 0) {
      return 0;
    }
    if (n <= 2) {
      return 1;
    }
    return fibRecursive(n - 1) + fibRecursive(n - 2);
  }

  public static BigInteger fibRecursiveMemoized(int n) {
    if (lruCache.containsKey(n)) {
      return lruCache.get(n);
    }
    if (n == 0) {
      lruCache.put(n, BigInteger.ZERO);
      return BigInteger.ZERO;
    }
    if (n <= 2) {
      lruCache.put(n, BigInteger.ONE);
      return BigInteger.ONE;
    }
    var fib = fibRecursiveMemoized(n - 1).add(fibRecursiveMemoized(n - 2));
    lruCache.put(n, fib);
    return fib;
  }

  // O(n)
  public static long fibLoop(int n) {
    if (n == 0) {
      return 0;
    }
    if (n <= 2) {
      return 1;
    }
    long prev = 0;
    long current = 1;
    for (int i = 2; i < n; i++) {
      long nextCurrent = prev + current;
      prev = current;
      current = nextCurrent;
    }

    return prev + current;
  }

  public static void main(String[] args) {
    var stopwatchA = Stopwatch.createStarted();
    IntStream.range(0, 47).forEach(it -> System.out.printf("%d : %d%n", it, fibRecursive(it)));
    stopwatchA.stop();
    System.out.printf("Recursion took %d ms%n", stopwatchA.elapsed(TimeUnit.MILLISECONDS));
    var stopwatchB = Stopwatch.createStarted();
    IntStream.range(0, 47).forEach(it -> System.out.printf("%d : %d%n", it, fibRecursiveMemoized(it)));
    stopwatchB.stop();
    System.out.printf("Recursion+cache took %d ms%n", stopwatchB.elapsed(TimeUnit.MILLISECONDS));
    var stopwatchC = Stopwatch.createStarted();
    IntStream.range(0, 47).forEach(it -> System.out.printf("%d : %d%n", it, fibLoop(it)));
    stopwatchC.stop();
    System.out.printf("Iteration took %d ms%n", stopwatchC.elapsed(TimeUnit.MILLISECONDS));
  }
}
