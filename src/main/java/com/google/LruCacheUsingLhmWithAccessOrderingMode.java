package com.google;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCacheUsingLhmWithAccessOrderingMode extends LinkedHashMap<String, String> {
  private final int capacity;

  public LruCacheUsingLhmWithAccessOrderingMode(int capacity) {
    super(capacity, 1.0f, true);
    this.capacity = capacity;
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
    return size() > capacity;
  }

  public static void main(String[] args) {
    var lruCache = new LruCacheUsingLhmWithAccessOrderingMode(3);
    lruCache.put("1", "1");
    lruCache.put("2", "2");
    lruCache.put("3", "3");
    lruCache.put("4", "4");
    lruCache.put("5", "5");
    lruCache.put("6", "6");
    System.out.println(lruCache.get("4"));
    lruCache.put("7", "7");
    System.out.println(lruCache);
  }
}
