package com.algorithms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SimpleArraySumTest {
  private final SimpleArraySum systemUnderTest = new SimpleArraySum();

  @Test
  void should_sum_array() {
    assertThat(systemUnderTest.sumArray(5, new int[] {1, 2, 3, 4, 5})).isEqualTo(15);
    assertThat(systemUnderTest.sumArray(List.of(1, 2, 3, 4, 5))).isEqualTo(15);
  }
}