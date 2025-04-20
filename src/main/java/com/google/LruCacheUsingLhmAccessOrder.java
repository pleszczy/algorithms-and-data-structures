package com.google;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheUsingLhmAccessOrder extends LinkedHashMap<String, String> {
  private final int capacity;

  public LruCacheUsingLhmAccessOrder(int capacity) {
    super(capacity, 1.0f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
    return size() > capacity;
  }
}
