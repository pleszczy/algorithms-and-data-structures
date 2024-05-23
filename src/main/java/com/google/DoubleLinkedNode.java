package com.google;

public class DoubleLinkedNode<E> {
  E val;
  DoubleLinkedNode<E> next;
  DoubleLinkedNode<E> prev;

  DoubleLinkedNode(E element, DoubleLinkedNode<E> next, DoubleLinkedNode<E> prev) {
    this.val = element;
    this.next = next;
    this.prev = prev;
  }
}
