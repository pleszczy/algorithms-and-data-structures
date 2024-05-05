package com.google;

import static com.google.ReverseSingleLinkedListTest.Constants.linkedList;
import static com.google.ReverseSingleLinkedListTest.Constants.linkedListReversed;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReverseSingleLinkedListTest {
  @Test
  void should_reverse_linked_list() {
    var sut = new ReverseSingleLinkedList();

    var actual = sut.solution(linkedList());

    assertThat(actual).isEqualTo(linkedListReversed());
  }

  static class Constants {
    static Node<String> linkedList() {
      var d = new Node<>("d", null);
      var c = new Node<>("c", d);
      var b = new Node<>("b", c);
      return new Node<>("a", b);
    }

    static Node<String> linkedListReversed() {
      var a = new Node<>("a", null);
      var b = new Node<>("b", a);
      var c = new Node<>("c", b);
      return new Node<>("d", c);
    }
  }
}