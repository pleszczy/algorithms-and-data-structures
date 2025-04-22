package com.algorithms.search;

import static com.utils.TreeUtils.binaryTreeProper;
import static org.assertj.core.api.Assertions.assertThat;

import com.datastructures.trees.BinarySearchTree;
import com.datastructures.trees.TreeNode;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
  BinarySearchTree systemUnderTest = new BinarySearchTree();

  @Test
  void should_find_a_number_in_bst() {
    var bst = binaryTreeProper();

    var results = systemUnderTest.search(bst, 8);

    assertThat(results).isTrue();
  }

  @Test
  void should_not_find_a_number_in_bst() {
    var bst = binaryTreeProper();

    var results = systemUnderTest.search(bst, 7);

    assertThat(results).isFalse();
  }

  @Test
  void should_insert_at_leaf() {
    var bst = binaryTreeProper();
    var root = systemUnderTest.insert(bst, 3);

    var node4 = root.left().right();
    var node3 = node4.left();
    assertThat(node3)
        .isNotNull()
        .returns(3, TreeNode::value)
        .returns(null, TreeNode::left)
        .returns(null, TreeNode::right);
  }

  @Test
  void should_find_minimum() {
    var bst = binaryTreeProper();

    var minimum = systemUnderTest.findMinimum(bst);

    assertThat(minimum)
        .isNotNull()
        .returns(2, TreeNode::value);
  }
}