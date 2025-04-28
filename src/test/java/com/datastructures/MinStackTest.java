package com.datastructures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MinStackTest {

  @Test
  void should_pass_leetcode_example_1() {
    var sut = new MinStack();

    sut.push(-2);
    sut.push(0);
    sut.push(-3);
    assertThat(sut.getMin()).isEqualTo(-3);
    sut.pop();
    assertThat(sut.top()).isEqualTo(0);
    assertThat(sut.getMin()).isEqualTo(-2);
  }

  @Test
  void should_pass_leetcode_example_27() {
    var sut = new MinStack();
    sut.push(-10);
    sut.push(14);
    assertThat(sut.getMin()).isEqualTo(-10);
    assertThat(sut.getMin()).isEqualTo(-10);
    sut.push(-20);
    assertThat(sut.getMin()).isEqualTo(-20);
    assertThat(sut.getMin()).isEqualTo(-20);
    assertThat(sut.top()).isEqualTo(-20);
    assertThat(sut.getMin()).isEqualTo(-20);
    sut.pop();
    sut.push(10);
    sut.push(-7);
    assertThat(sut.getMin()).isEqualTo(-10);
    sut.push(-7);
    sut.pop();
    assertThat(sut.top()).isEqualTo(-7);
    assertThat(sut.getMin()).isEqualTo(-10);
  }

  @Test
  void should_shift_an_arraylist() {
    var sut = new MinStack();
    var list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    var shifted = sut.shift(list);

    assertThat(shifted).isEqualTo(Arrays.asList(1, 1, 2, 3));
  }
}