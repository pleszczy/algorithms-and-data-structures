package com.google;

import static com.google.ReverseBinaryTreeTest.Constants.binaryTree;
import static com.google.ReverseBinaryTreeTest.Constants.reversedBinaryTree;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReverseBinaryTreeTest {

  @Test
  void should_reverse_a_binary_tree() {
    ReverseBinaryTree sut = new ReverseBinaryTree();

    BinaryTreeNode<Integer> actual = sut.solution(binaryTree());

    assertThat(actual).isEqualTo(reversedBinaryTree());
  }

  static class Constants {
    static BinaryTreeNode<Integer> binaryTree() {
      return null;
    }

    static BinaryTreeNode<Integer> reversedBinaryTree() {
      return null;
    }
  }
}