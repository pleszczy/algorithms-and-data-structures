package com.google;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
  private final List<Integer> stack;

  public MinStack() {
    stack = new ArrayList<>();
  }

  public void push(int val) {
    stack.add(val);
  }

  public void pop() {
    stack.removeLast();
  }

  // gets the top element of the stack.
  int top() {
    return stack.getLast();
  }

  //  retrieves the minimum element in the stack.
  int getMin() {
    return stack.stream()
        .mapToInt(Integer::intValue)
        .min()
        .orElse(-1);
  }
}
