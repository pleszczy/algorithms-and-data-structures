package com.algorithms;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
  //  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
  //  determine if the input string is valid.
  //
  //  An input string is valid if:
  //    - Open brackets must be closed by the same type of brackets.
  //    - Open brackets must be closed in the correct order.
  //    - Every close bracket has a corresponding open bracket of the same type.
  // for example: "{[]}
  //
  // O(n)
  public boolean isValid(String s) {
    var matchingParenthesis = new HashMap<Character, Character>();
    matchingParenthesis.put(')', '(');
    matchingParenthesis.put(']', '[');
    matchingParenthesis.put('}', '{');
    var stack = new Stack<Character>();

    for (char c : s.toCharArray()) {
      if (matchingParenthesis.containsKey(c)) {
        if (!stack.isEmpty() && stack.peek() == matchingParenthesis.get(c)) {
          stack.pop();
        } else {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
