package com.google;

public class ReverseBinaryTree {


  /**
   * Input:
   * <pre>
   *         1
   *        / \
   *       2   3
   *      / \ / \
   *     4  5 6  7
   *    / \
   *   8   9
   * </pre>
   * <p>
   *
   * Expected output:
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
  public <E> BinaryTreeNode<E> solution(BinaryTreeNode<E> root) {
    return root;
  }
}
