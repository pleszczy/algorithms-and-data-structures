package com.algorithms;

import java.util.List;

/**
 * HackerRank warmup task: <a href="https://www.hackerrank.com/challenges/simple-array-sum/problem">simple-array-sum</a>
 * <p>
 * Given an array of integers, computes and returns the sum of its elements.
 * <p>
 * For example, if the array is {@code [1, 2, 3]}, the result will be {@code 6}.
 * </p>
 *
 * <p><b>Constraints:</b></p>
 * <ul>
 *   <li>0 &lt; ar.length ≤ 1000</li>
 *   <li>0 &lt; ar[i] ≤ 1000 for each element in the array</li>
 * </ul>
 *
 * <p><b>Input Format:</b></p>
 * <ol>
 *   <li>The first line contains an integer, {@code n}, denoting the size of the array.</li>
 *   <li>The second line contains {@code n} space-separated integers representing the array's elements.</li>
 * </ol>
 * @param ar an array of integers
 * @return the sum of the elements in the array
 *
 */
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
