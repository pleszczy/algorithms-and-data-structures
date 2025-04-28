package com.datastructures;

import java.util.LinkedHashMap;

public class LruCacheUsingLhm {
  private final int capacity;
  private final LinkedHashMap<String, String> cache;

  public LruCacheUsingLhm(int capacity) {
    this.capacity = capacity;
    cache = new LinkedHashMap<>(capacity, 1.0f);
  }

  public static void main(String[] args) {
    var lruCache = new LruCacheUsingLhm(3);
    lruCache.add("1", "1");
    lruCache.add("2", "2");
    lruCache.add("3", "3");
    lruCache.add("4", "4");
    lruCache.add("5", "5");
    lruCache.add("6", "6");
    System.out.println(lruCache.get("4"));
    lruCache.add("7", "7");
    lruCache.print();
  }

  public void add(String key, String value) {
    if (cache.size() >= capacity) {
      cache.remove(cache.firstEntry().getKey());
    }
    cache.putLast(key, value);
  }

  public String get(String key) {
    var value = cache.get(key);
    cache.remove(key);
    cache.putLast(key, value);
    return value;
  }

  public void print() {
    System.out.println(cache);
  }
}
