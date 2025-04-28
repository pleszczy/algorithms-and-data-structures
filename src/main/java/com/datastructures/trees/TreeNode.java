package com.datastructures.trees;

import static java.lang.System.lineSeparator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@EqualsAndHashCode
@Getter
@Setter
@Accessors(fluent = true)
public class TreeNode<E> {
  private int value;
  private TreeNode<E> left;
  private TreeNode<E> right;

  public TreeNode(int value, TreeNode<E> left, TreeNode<E> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(lineSeparator());
    prettyPrint(sb, "", this);
    return sb.toString();
  }

  private void prettyPrint(StringBuilder builder, String prefix, TreeNode<E> node) {
    if (node != null) {
      builder.append(prefix).append("|-- ").append(node.value).append(lineSeparator());
      prettyPrint(builder, prefix + "    ", node.left);
      prettyPrint(builder, prefix + "    ", node.right);
    }
  }
}