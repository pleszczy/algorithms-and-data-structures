package com.utils;

import com.datastructures.trees.TreeNode;

public class TreeUtils {
  public static TreeNode<Integer> leaf5 = leaf(5);
  public static TreeNode<Integer> leaf6 = leaf(6);
  public static TreeNode<Integer> leaf7 = leaf(7);
  public static TreeNode<Integer> leaf8 = leaf(8);
  public static TreeNode<Integer> leaf9 = leaf(9);

  /**
   * <pre>
   *         1
   *        / \
   *       2   3
   *      / \ / \
   *     4  5 6  7
   *    / \
   *   8   9
   * </pre>
   */
  public static TreeNode<Integer> treeA() {
    var child4 = new TreeNode<>(4, leaf8, leaf9);
    var child2 = new TreeNode<>(2, child4, leaf5);
    var child3 = new TreeNode<>(3, leaf6, leaf7);
    return new TreeNode<>(1, child2, child3);
  }

  /**
   * <pre>
   *           5
   *         /   \
   *        2     6
   *         \     \
   *          4     8
   *                 \
   *                  9
   * </pre>
   */
  public static TreeNode<Integer> binaryTreeA() {
    var leaf9 = leaf(9);
    var child8 = new TreeNode<>(8, null, leaf9);
    var child7 = leaf(7);
    var leaf4 = leaf(4);
    var child2 = new TreeNode<>(2, null, leaf4);
    var child6 = new TreeNode<>(6, child7, child8);
    return new TreeNode<>(5, child2, child6);
  }

  /**
   * <pre>
   *           5
   *        /     \
   *       4        10
   *        \    /    \
   *         2   8    12
   *             /\   /\
   *            7  9 11 13
   * </pre>
   */
  public static TreeNode<Integer> binaryTreeB() {
    var leaf2 = leaf(2);
    var leaf7 = leaf(7);
    var leaf9 = leaf(9);
    var leaf11 = leaf(11);
    var leaf13 = leaf(13);
    var child8 = new TreeNode<>(8, leaf7, leaf9);
    var child12 = new TreeNode<>(12, leaf11, leaf13);
    var child10 = new TreeNode<>(10, child8, child12);
    var child4 = new TreeNode<>(4, leaf2, null);
    return new TreeNode<>(5, child4, child10);
  }

  /**
   * <pre>
   *         1
   *        / \
   *       3   2
   *      / \ / \
   *     7  6 5  4
   *            / \
   *           9   8
   * </pre>
   */
  public static TreeNode<Integer> reversedTreeA() {
    var child4 = new TreeNode<>(4, leaf9, leaf8);
    var child2 = new TreeNode<>(2, leaf5, child4);
    var child3 = new TreeNode<>(3, leaf7, leaf6);
    return new TreeNode<>(1, child3, child2);
  }

  public static TreeNode<Integer> leaf(int value) {
    return new TreeNode<>(value, null, null);
  }

  /**
   * <pre>
   *           5
   *        /     \
   *       0        10
   *        \    /    \
   *         2   0    12
   *             /\   /\
   *            7  9 0 13
   *                    \
   *                     14
   * </pre>
   */
  public static TreeNode<Integer> treeB() {
    var leaf2 = leaf(2);
    var leaf7 = leaf(7);
    var leaf9 = leaf(9);
    var leaf11 = leaf(0);
    var leaf14 = leaf(14);
    var leaf13 = new TreeNode<>(13, null, leaf14);
    var child8 = new TreeNode<>(0, leaf7, leaf9);
    var child12 = new TreeNode<>(12, leaf11, leaf13);
    var child10 = new TreeNode<>(10, child8, child12);
    var child4 = new TreeNode<>(0, leaf2, null);
    return new TreeNode<>(5, child4, child10);
  }
}
