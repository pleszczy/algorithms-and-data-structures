package com.google;

public class MyLinkedList {
  private final DoubleLinkedNode<Integer> head;
  private final DoubleLinkedNode<Integer> tail;

  public MyLinkedList() {
    head = new DoubleLinkedNode<>(0, null, null);
    tail = new DoubleLinkedNode<>(0, null, head);
    head.next = tail;
  }

  public int get(int index) {
    int position = 1;
    DoubleLinkedNode<Integer> current = head.next;
    while (position <= index && current != null) {
      current = current.next;
      position++;
    }

    if (current != null && current != tail) {
      return current.val;
    } else {
      return -1;
    }
  }

  public void addAtHead(int val) {
    var next = head.next;
    head.next = new DoubleLinkedNode<>(val, next, head);
    next.prev = head.next;
  }

  public void addAtTail(int val) {
    var prev = tail.prev;
    prev.next = new DoubleLinkedNode<>(val, tail, prev);
    tail.prev = prev.next;
  }

  public void addAtIndex(int index, int val) {
    int position = 1;
    DoubleLinkedNode<Integer> next = head.next;
    while (position <= index && next != null) {
      next = next.next;
      position++;
    }
    if (next != null) {
      if (next == tail) {
        addAtTail(val);
      } else {
        var prev = next.prev;
        var current = new DoubleLinkedNode<>(val, next, prev);
        prev.next = current;
        next.prev = current;
      }
    }
  }

  public void deleteAtIndex(int index) {
    int position = 1;
    DoubleLinkedNode<Integer> current = head.next;
    while (position <= index && current != null) {
      current = current.next;
      position++;
    }
    if (current != null && current != tail) {
      var prev = current.prev;
      var next = current.next;
      prev.next = next;
      next.prev = prev;
    }
  }
}
