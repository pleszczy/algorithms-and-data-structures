package com.google;

import java.util.Objects;

public class Node<E> {
  E item;
  Node<E> next;

  Node(E element, Node<E> next) {
    this.item = element;
    this.next = next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node<?> node = (Node<?>) o;
    return Objects.equals(item, node.item) && Objects.equals(next, node.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item, next);
  }

  @Override
  public String toString() {
    return "Node{" +
        "item=" + item +
        ", next=" + next +
        '}';
  }
}
