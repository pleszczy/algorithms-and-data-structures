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
   * <p>
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
  public <E> TreeNode<E> solution(TreeNode<E> node) {
    if (node != null) {
      var left = node.left;
      node.left = node.right;
      node.right = left;
      solution(node.left);
      solution(node.right);
    }
    return node;
  }
}
