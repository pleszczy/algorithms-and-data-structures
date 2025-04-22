package com.algorithms.search;

import static com.utils.TreeUtils.binaryTreeProper;
import static org.assertj.core.api.Assertions.assertThat;

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
}