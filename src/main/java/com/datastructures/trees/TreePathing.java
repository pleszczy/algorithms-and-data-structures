package com.datastructures.trees;

import java.util.Stack;

public class TreePathing {

  /**
   * Finding a path to a leaf. Path can't go through 0.
   */
  public boolean findingPath(TreeNode<Integer> root, Stack<Integer> path) {
    if (root == null || root.value() == 0) {
      return false;
    }
    path.push(root.value());
    if (root.left() == null && root.right() == null) {
      return true;
    }
    if (findingPath(root.left(), path)) {
      return true;
    }

    if (findingPath(root.right(), path)) {
      return true;
    }
    path.pop();
    return false;
  }
}
