package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

  /**
   * A naive solution assuming cardinality of 10 means numbers are 1 to 10
   */
  public List<Integer> sort(List<Integer> input, int cardinality) {
    var buckets = new int[cardinality];
    var output = new ArrayList<Integer>(input.size());

    for (var it : input) {
      buckets[it - 1]++;
    }

    for (var i = 0; i < cardinality; i++) {
      for (var j = 0; j < buckets[i]; j++) {
        output.add(i + 1);
      }
    }

    return output;
  }

  /**
   * The problem with this solution is that e.g.
   * for List.of(69, 42, 119, 58, 200, 1, 0, -99, -200) it will allocate an array with a size of 400.
   */
  public List<Integer> sortImproved(List<Integer> input) {
    var output = new ArrayList<Integer>(input.size());
    var min = Collections.min(input);
    var max = Collections.max(input);
    var range = max - min + 1;
    var buckets = new int[range];

    for (int num : input) {
      buckets[num - min]++;
    }


    for (var i = 0; i < range; i++) {
      for (var j = 0; j < buckets[i]; j++) {
        output.add(i + min);
      }
    }

    return output;
  }
}
