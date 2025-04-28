package com.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MyLinkedListTest {

  @Test
  void should_pass_example_1() {
    var myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(3);
    myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3

    assertThat(myLinkedList.get(1)).isEqualTo(2);

    myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3

    assertThat(myLinkedList.get(1)).isEqualTo(3);
  }

  @Test
  void should_pass_example_2() {
    var myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(7); // 7
    myLinkedList.addAtTail(7); // 7,7
    myLinkedList.addAtHead(9); // 9,7,7
    myLinkedList.addAtTail(8); // 9,7,7,8
    myLinkedList.addAtHead(6); // 6,9,7,7,8

    assertThat(myLinkedList.get(0)).isEqualTo(6);
    assertThat(myLinkedList.get(1)).isEqualTo(9);
    assertThat(myLinkedList.get(2)).isEqualTo(7);
    assertThat(myLinkedList.get(3)).isEqualTo(7);
    assertThat(myLinkedList.get(4)).isEqualTo(8);
  }

  @Test
  void should_pass_example_3() {
    var myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(7); // 7
    myLinkedList.addAtHead(2); // 2,7
    myLinkedList.addAtHead(1); // 1,2, 7
    myLinkedList.addAtIndex(3, 3); // 1,2,7,3
    myLinkedList.deleteAtIndex(3); // 1,2,7
    myLinkedList.deleteAtIndex(0); // 2,7
    myLinkedList.addAtHead(2); // 2,2,7
    myLinkedList.addAtTail(6); // 2,2,7,6
    myLinkedList.addAtHead(4); // 4,2,2,7,6
    myLinkedList.addAtIndex(5, 0); // 4,2,2,7,6,0
    myLinkedList.addAtHead(6); // 6,4,2,2,7,6,0

    assertThat(myLinkedList.get(0)).isEqualTo(6);
    assertThat(myLinkedList.get(1)).isEqualTo(4);
    assertThat(myLinkedList.get(2)).isEqualTo(2);
    assertThat(myLinkedList.get(3)).isEqualTo(2);
    assertThat(myLinkedList.get(4)).isEqualTo(7);
    assertThat(myLinkedList.get(5)).isEqualTo(6);
    assertThat(myLinkedList.get(6)).isEqualTo(0);
  }
}