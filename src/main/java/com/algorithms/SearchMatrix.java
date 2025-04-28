package com.algorithms;

import com.algorithms.search.BinarySearch;

/**
 * You are given an m x n 2-D integer array matrix and an integer target.
 * <p>
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if the target exists within matrix or false otherwise.
 * <p>
 * Can you write a solution that runs in O(log(m * n)) time?
 */
public class SearchMatrix {
  public boolean searchMatrixBruteForce(int[][] matrix, int target) {
    for (int[] rows : matrix) {
      for (int element : rows) {
        if (element == target) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean searchMatrixBruteForceOptimized1(int[][] matrix, int target) {
    for (int[] rows : matrix) {
      if (target < rows[0]) {
        return false;
      }
      if (target > rows[rows.length - 1]) {
        continue;
      }
      for (int element : rows) {
        if (element == target) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * O(mlog(n)) time
   */
  public boolean searchMatrixOptimized2(int[][] matrix, int target) {
    var binarySearch = new BinarySearch();
    for (int[] rows : matrix) {
      if (target < rows[0]) {
        return false;
      }
      if (target > rows[rows.length - 1]) {
        continue;
      }
      if (binarySearch.search(rows, target) != -1) {
        return true;
      }
    }
    return false;
  }

}
