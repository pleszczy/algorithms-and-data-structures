package com.datastructures;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LruCacheUsingLinkedListTest {
  private final LruCacheUsingLinkedList<String, String> systemUnderTest = new LruCacheUsingLinkedList<>(3);

  @Test
  void should_return_least_recently_used_entries() {
    systemUnderTest.put("1", "1");
    systemUnderTest.put("2", "2");
    systemUnderTest.put("3", "3");
    systemUnderTest.put("4", "4");
    systemUnderTest.put("5", "5");
    systemUnderTest.put("6", "6");
    systemUnderTest.get("4");
    systemUnderTest.put("7", "7");

    assertThat(systemUnderTest).containsExactly(
        entry("7", "7"),
        entry("4", "4"),
        entry("6", "6")
    );
  }
}