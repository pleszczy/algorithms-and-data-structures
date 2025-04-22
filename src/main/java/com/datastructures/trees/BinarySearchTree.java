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
      if (root.left() != null && root.right() != null) {
        // TODO: Figure out how to create a new new node with both left and right nodes and a value from left
        var left = root.left();
        var right = root.right();
        return new TreeNode<>(root.right().value(), null, root.left());
      }
      if (root.left() != null) {
        return root.left();
      }
      if (root.right() != null) {
        return root.right();
      }
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
