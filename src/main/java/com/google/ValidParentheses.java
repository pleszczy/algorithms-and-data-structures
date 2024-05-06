package com.google;

public class ValidParentheses {
  //  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
  //  determine if the input string is valid.
  //
  //  An input string is valid if:
  //    - Open brackets must be closed by the same type of brackets.
  //    - Open brackets must be closed in the correct order.
  //    - Every close bracket has a corresponding open bracket of the same type.
  public boolean isValid(String s) {
    var charArray = s.toCharArray();
    char prev = charArray[0];
    for (int i = 1; i < charArray.length; i = i + 2) {
      switch (charArray[i]) {
        case ')':
          if (prev != '(') {
            return false;
          }
          break;
        case '}':
          if (prev != '{') {
            return false;
          }
          break;
        case ']':
          if (prev != '[') {
            return false;
          }
          break;
        default:
          return false;
      }
      if (i < charArray.length - 1) {
        prev = charArray[i + 1];
      }
    }
    return true;
  }
}
