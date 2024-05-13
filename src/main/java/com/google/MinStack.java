package com.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
  private final Stack<Integer> stack;
  private final List<Integer> minValues;

  public MinStack() {
    stack = new Stack<>();
    minValues = new ArrayList<>();
  }

  public void push(int num) {
    stack.add(num);
    if (!minValues.isEmpty()) {
      var first = minValues.getFirst();
      if (first >= num) {
        shift(minValues);
        minValues.set(0, num);
      }
    } else {
      minValues.add(num);
    }
  }

  public List<Integer> shift(List<Integer> input) {
    int current = input.getFirst();
    int next = input.getFirst();
    for (int i = 0; i < input.size(); i++) {
      if (input.size() > i + 1) {
        next = input.get(i + 1);
        input.set(i + 1, current);
        current = next;
      }
    }
    input.add(next);
    return input;
  }

  public void pop() {
    Integer last = stack.pop();
    minValues.remove(last);
  }

  int top() {
    return stack.getLast();
  }

  int getMin() {
    if (!minValues.isEmpty()) {
      return minValues.getFirst();
    } else {
      return stack.stream()
          .mapToInt(Integer::intValue)
          .min()
          .orElse(-1);
    }
  }
}
