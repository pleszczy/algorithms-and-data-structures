package com.datastructures;

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

  public TreeNode<Integer> insert(TreeNode<Integer> root, Integer value) {
    if (root == null) {
      return new TreeNode<>(value, null, null);
    }

    if (value > root.value()) {
      root.right(insert(root.right(), value));
    }
    if (value < root.value()) {
      root.left(insert(root.left(), value));
    }
    return root;
  }
}
