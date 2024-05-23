package com.google;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Node<E> {
  E val;
  Node<E> next;

  Node(E element, Node<E> next) {
    this.val = element;
    this.next = next;
  }
}
