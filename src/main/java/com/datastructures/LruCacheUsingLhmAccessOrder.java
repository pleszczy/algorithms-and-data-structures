package com.datastructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheUsingLhmAccessOrder<K, V> extends LinkedHashMap<K, V> {
  private final int capacity;

  public LruCacheUsingLhmAccessOrder(int capacity) {
    super(capacity, 1.0f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size() > capacity;
  }
}