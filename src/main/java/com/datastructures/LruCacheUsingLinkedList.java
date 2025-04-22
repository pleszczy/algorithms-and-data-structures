package com.datastructures;

import java.util.LinkedList;
import java.util.Map;

public class LruCacheUsingLinkedList<K, V> extends LinkedList<Map.Entry<K, V>> {
  private final int capacity;

  public LruCacheUsingLinkedList(int capacity) {
    super();
    this.capacity = capacity;
  }

  public V get(K key) {
    for (var it = this.iterator(); it.hasNext(); ) {
      Map.Entry<K, V> entry = it.next();
      if (entry.getKey().equals(key)) {
        it.remove();
        this.addFirst(entry);
        return entry.getValue();
      }
    }
    return null;
  }

  public void put(K key, V value) {
    removeExisting(key);
    this.addFirst(Map.entry(key, value));
    if (this.size() > capacity) {
      this.removeLast();
    }
  }

  private void removeExisting(K key) {
    for (var it = this.iterator(); it.hasNext(); ) {
      Map.Entry<K, V> entry = it.next();
      if (entry.getKey().equals(key)) {
        it.remove();
        break;
      }
    }
  }
}
