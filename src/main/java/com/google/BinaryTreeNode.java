package com.google;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class BinaryTreeNode<E> {
  int value;
  Node<E> left;
  Node<E> right;

  public BinaryTreeNode(int value, Node<E> left, Node<E> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}