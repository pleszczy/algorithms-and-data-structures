package com.algorithms.search;

import static com.utils.TreeUtils.binaryTreeForRemovalTests;
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

  @Test
  void should_remove_leaf() {
    var bst = systemUnderTest.insert(binaryTreeProper(), 3);

    systemUnderTest.remove(bst, 3);

    var minimum = systemUnderTest.findMinimum(bst);
    assertThat(minimum)
        .isNotNull()
        .returns(2, TreeNode::value);
  }

  @Test
  void should_remove_node_with_single_child() {
    var bst = systemUnderTest.insert(binaryTreeProper(), 3);

    systemUnderTest.remove(bst, 2);

    assertThat(bst.left())
        .isNotNull()
        .returns(4, TreeNode::value);
  }

  @Test
  void should_remove_nodes_with_two_children() {
    var bst = binaryTreeForRemovalTests();

    systemUnderTest.remove(bst, 10);

    assertThat(bst.right())
        .isNotNull()
        .returns(7, TreeNode::value)
        .returns(8, integerTreeNode -> integerTreeNode.left().value())
        .returns(12, integerTreeNode1 -> integerTreeNode1.right().value());
  }

  @Test
  void should_traverse_tree_using_dfs() {
    var bst = binaryTreeForRemovalTests();

    var dfsTraversedTree = systemUnderTest.dfsInOrder(bst);

    assertThat(dfsTraversedTree)
        .containsExactly(2, 4, 5, 7, 8, 9, 10, 11, 12, 13);
  }

  @Test
  void should_traverse_tree_using_bfs() {
    var bst = binaryTreeForRemovalTests();

    var bfsTraversedTree = systemUnderTest.bfs(bst);

    assertThat(bfsTraversedTree)
        .containsExactly(5, 4, 10, 2, 8, 12, 7, 9, 11, 13);

  }
}