package com.google;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
  public List<Integer> sort(List<Integer> unsortedInput) {
    var unsorted = new ArrayList<>(unsortedInput);

    for (int i = 1; i < unsorted.size(); i++) {
      var current = unsorted.get(i);
      var j = i - 1;

      while (j >= 0 && unsorted.get(j) > current) {
        unsorted.set(j + 1, unsorted.get(j));
        j--;
      }
      unsorted.set(j + 1, current);
    }

    return unsorted;
  }
}
