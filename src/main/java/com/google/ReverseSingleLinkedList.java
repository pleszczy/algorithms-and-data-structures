package com.google;

import java.util.Stack;

public class ReverseSingleLinkedList {
  // Input: a -> b -> c -> d
  // Expected output: d -> c -> b -> a
  public <E> Node<E> solution(Node<E> head) {
    Node<E> previous = null;
    Node<E> current = head;
    Node<E> next;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }

  public <E> Node<E> solutionUsingStack(Node<E> head) {
    var nodes = new Stack<Node<E>>();
    var current = head;

    while (current != null) {
      nodes.push(current);
      current = current.next;
    }

    var newHead = nodes.pop();
    var previous = newHead;

    while (!nodes.isEmpty()) {
      current = nodes.pop();
      current.next = null;
      previous.next = current;
      previous = current;
    }
    return newHead;
  }
}
