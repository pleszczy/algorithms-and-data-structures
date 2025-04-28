package com.datastructures;

import static com.utils.TreeUtils.reversedTreeA;
import static com.utils.TreeUtils.treeA;
import static org.assertj.core.api.Assertions.assertThat;

import com.datastructures.trees.ReverseBinaryTree;
import org.junit.jupiter.api.Test;

class ReverseBinaryTreeTest {

  @Test
  void should_reverse_a_binary_tree() {
    var sut = new ReverseBinaryTree();

    var actual = sut.solution(treeA());

    assertThat(actual).isEqualTo(reversedTreeA());
  }

}