package com.google;

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
}
