package com.algorithms.search;

import com.datastructures.trees.TreeNode;

public class BinarySearchTree {

  public boolean search(TreeNode<Integer> tree, Integer target) {
    if (tree == null) {
      return false;
    }

    if (target > tree.value()) {
      return search(tree.right(), target);
    }
    if (target < tree.value()) {
      return search(tree.left(), target);
    }
    return true;
  }
}
