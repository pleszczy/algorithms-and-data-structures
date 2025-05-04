package com.algorithms;

import java.util.List;

/**
 * HackerRank warmup task: <a href="https://www.hackerrank.com/challenges/diagonal-difference/problem">diagonal-difference</a>
 * <p>
 * Given a square matrix, this function calculates the absolute difference between
 * the sums of its two diagonals.
 *
 * <p>For example, for the matrix:
 * <pre>
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * </pre>
 * - The left-to-right diagonal = 1 + 5 + 9 = 15
 * - The right-to-left diagonal = 3 + 5 + 9 = 17
 * <p>
 * The absolute difference is |15 - 17| = 2.
 * <p>Another example:
 * <pre>
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * </pre>
 * <p>
 * The left-to-right diagonal = 1 + 6 + 11 + 16 = 34<br>
 * The right-to-left diagonal = 4 + 7 + 10 + 13 = 34<br>
 * The absolute difference is |34 - 34| = 0
 * </p>
 *
 * <p>
 *
 * @param ar a 2D array of integers representing the square matrix
 * @returns the absolute difference between the sums of the matrix's two diagonals
 *
 * <p><strong>Constraints:</strong>
 * <ul>
 *   <li>The matrix is square, with dimensions n x n</li>
 *   <li>Each element arr[i][j] satisfies -100 <= arr[i][j] <= 100</li>
 * </ul>
 */
public class DiagonalDifference {
  public int diagonalDifference(List<List<Integer>> arr) {
    var rightDiagonalIndex = 0;
    var leftDiagonalIndex = arr.getFirst().size() - 1;
    var rightDiagonal = 0;
    var leftDiagonal = 0;

    for (var row : arr) {
      rightDiagonal += row.get(rightDiagonalIndex++);
      leftDiagonal += row.get(leftDiagonalIndex--);
    }

    return Math.abs(rightDiagonal - leftDiagonal);
  }
}
