package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MinimumHealthTest {
  private final MinimumHealth systemUnderTest = new MinimumHealth();

  @Test
  void should_return_correct_minimum_health() {
    var health = systemUnderTest.minimumHealth(List.of(1, 2), List.of(3, 4), 2);

    assertThat(health).isEqualTo(6);
  }

}