package com.algorithms;

import java.util.Stack;

public class BaseballGame {
  //  Input: ops = ["5","-2","4","C","D","9","+","+"]
  //  Output: 27
  //  Explanation:
  //      "5" - Add 5 to the record, record is now [5].
  //      "-2" - Add -2 to the record, record is now [5, -2].
  //      "4" - Add 4 to the record, record is now [5, -2, 4].
  //      "C" - Invalidate and remove the previous score, record is now [5, -2].
  //      "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
  //      "9" - Add 9 to the record, record is now [5, -2, -4, 9].
  //      "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
  //      "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
  //  The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
  public int calPoints(String[] operations) {
    var callPoints = new Stack<Integer>();

    for (String operation : operations) {
      switch (operation) {
        case "C":
          callPoints.pop();
          break;
        case "D":
          var points = callPoints.peek();
          callPoints.push(2 * points);
          break;
        case "+":
          var n1 = callPoints.pop();
          var n2 = callPoints.pop();
          callPoints.push(n2);
          callPoints.push(n1);
          callPoints.push(n2 + n1);
          break;
        default:
          callPoints.push(Integer.valueOf(operation));
          break;
      }
    }

    int callPointsSum = 0;
    for (Integer number : callPoints) {
      callPointsSum += number;
    }
    return callPointsSum;
  }
}
