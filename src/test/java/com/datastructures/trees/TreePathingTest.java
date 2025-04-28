package com.datastructures.trees;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.utils.TreeUtils;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class TreePathingTest {
  TreePathing systemUnderTest = new TreePathing();

  @Test
  void should_return_path_from_root_to_leaf() {
    var tree = TreeUtils.treeB();
    var path = new Stack<Integer>();

    var foundPath = systemUnderTest.findingPath(tree, path);

    assertAll(
        () -> assertThat(foundPath).isTrue(),
        () -> assertThat(path).containsExactly(5, 10, 12, 13, 14)
    );
  }
}