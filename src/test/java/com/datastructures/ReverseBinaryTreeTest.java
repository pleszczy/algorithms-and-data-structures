package com.datastructures;

import static com.datastructures.ReverseBinaryTreeTest.Constants.binaryTree;
import static com.datastructures.ReverseBinaryTreeTest.Constants.reversedBinaryTree;
import static org.assertj.core.api.Assertions.assertThat;

import com.datastructures.trees.ReverseBinaryTree;
import com.datastructures.trees.TreeNode;
import org.junit.jupiter.api.Test;

class ReverseBinaryTreeTest {

  @Test
  void should_reverse_a_binary_tree() {
    var sut = new ReverseBinaryTree();

    var actual = sut.solution(binaryTree());

    assertThat(actual).isEqualTo(reversedBinaryTree());
  }

  static class Constants {
    static TreeNode<Integer> leaf5 = leaf(5);
    static TreeNode<Integer> leaf6 = leaf(6);
    static TreeNode<Integer> leaf7 = leaf(7);
    static TreeNode<Integer> leaf8 = leaf(8);
    static TreeNode<Integer> leaf9 = leaf(9);

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
    static TreeNode<Integer> binaryTree() {
      var child4 = new TreeNode<>(4, leaf8, leaf9);
      var child2 = new TreeNode<>(2, child4, leaf5);
      var child3 = new TreeNode<>(3, leaf6, leaf7);
      return new TreeNode<>(1, child2, child3);
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
    static TreeNode<Integer> reversedBinaryTree() {
      var child4 = new TreeNode<>(4, leaf9, leaf8);
      var child2 = new TreeNode<>(2, leaf5, child4);
      var child3 = new TreeNode<>(3, leaf7, leaf6);
      return new TreeNode<>(1, child3, child2);
    }

    private static TreeNode<Integer> leaf(int value) {
      return new TreeNode<>(value, null, null);
    }
  }
}