package com.google;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Node<E> {
  E item;
  Node<E> next;

  Node(E element, Node<E> next) {
    this.item = element;
    this.next = next;
  }
}
