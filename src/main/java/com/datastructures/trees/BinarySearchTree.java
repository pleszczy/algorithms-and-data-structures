package com.datastructures.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

  /**
   * Depth-First Search
   */
  public List<Integer> dfsInOrder(TreeNode<Integer> root) {
    if (root == null) {
      return Collections.emptyList();
    }
    var output = new ArrayList<Integer>();
    output.addAll(dfsInOrder(root.left()));
    output.add(root.value());
    output.addAll(dfsInOrder(root.right()));
    return output;
  }

  /**
   * Breadth-First Search
   */
  public List<Integer> bfs(TreeNode<Integer> root) {
    if (root == null) {
      return Collections.emptyList();
    }
    var output = new ArrayList<Integer>();
    var queue = new LinkedList<TreeNode<Integer>>();
    queue.add(root);

    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node != null) {
        queue.add(node.left());
        queue.add(node.right());
        output.add(node.value());
      }
    }
    return output;
  }

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
        var minimumLeaf = findMinimum(root.left());
        remove(root.left(), minimumLeaf.value());
        minimumLeaf.left(root.left());
        minimumLeaf.right(root.right());
        return minimumLeaf;
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
