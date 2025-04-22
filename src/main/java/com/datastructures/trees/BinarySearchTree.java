package com.datastructures.trees;

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

  public TreeNode<Integer> remove(TreeNode<Integer> root, Integer value) {
    if (root.value() == value) {
      return null;
    }

    if (value > root.value() && root.right() != null) {
      root.right(remove(root.right(), value));
    }
    if (value < root.value() && root.left() != null) {
      root.left(remove(root.left(), value));
    }
    return root;
  }

  public TreeNode<Integer> findMinimum(TreeNode<Integer> root) {
    var current = root;
    while (current.left() != null) {
      current = current.left();
    }
    return current;
  }
}
