package com.datastructures;

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
    return k;
  }

  public int removeDuplicatesOptimal(int[] input) {
    if (input == null || input.length == 0) {
      return 0;
    }
    int leftPointer = 1;
    for (int i = 1; i < input.length; i++) {
      if (input[i] != input[i - 1]) {
        input[leftPointer] = input[i];
        leftPointer++;
      }
    }
    return leftPointer;
  }

  /**
   * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
   * The order of the elements may be changed. Then return the number of elements in nums that is not equal to val.
   * Consider the number of elements in nums which are not equal to val be k. To get accepted, you need to do the following things:
   * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
   * Return k.
   */
  public int removeElement(int[] nums, int val) {
    var leftPointer = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[leftPointer] = nums[i];
        leftPointer++;
      }
    }
    return leftPointer;
  }

  /**
   * Given an integer array nums of length n, you want to create an array of length 2n where newNums[i] == nums[i] and newNums[i + n] == nums[i] for 0 <= i < n
   */
  public int[] getConcatenation(int[] nums) {
    var output = new int[nums.length * 2];
    for (int i = 0; i < nums.length; i++) {
      output[i] = nums[i];
      output[nums.length + i] = nums[i];
    }
    return output;
  }


  private void shift(int[] input, int shiftUntil) {
    var previous = input[input.length - 1];
    for (int i = input.length - 2; i > shiftUntil; i--) {
      var current = input[i];
      input[i] = previous;
      previous = current;
    }
  }
}
