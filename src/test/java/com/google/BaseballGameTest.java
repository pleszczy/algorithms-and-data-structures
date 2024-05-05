package com.google;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballGameTest {
  @Test
  void should_return_call_points_example_1() {
    var sut = new BaseballGame();

    var calPoints = sut.calPoints(new String[] {"5", "2", "C", "D", "+"});

    assertThat(calPoints).isEqualTo(30);
  }

  @Test
  void should_return_call_points_example_2() {
    var sut = new BaseballGame();

    var calPoints = sut.calPoints(new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"});

    assertThat(calPoints).isEqualTo(27);
  }

  @Test
  void should_return_call_points_example_3() {
    var sut = new BaseballGame();

    var calPoints = sut.calPoints(new String[] {"1", "C"});

    assertThat(calPoints).isEqualTo(0);
  }

}