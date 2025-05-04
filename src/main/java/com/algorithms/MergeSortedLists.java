package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
  public List<Integer> mergeSortedLists(List<Integer> listA, List<Integer> listB) {
    var indexA = 0;
    var indexB = 0;
    List<Integer> mergedLists = new ArrayList<>(listA.size() + listB.size());

    while (indexA < listA.size() && indexB < listB.size()) {
      if (listA.get(indexA) < listB.get(indexB)) {
        mergedLists.add(listA.get(indexA));
        indexA++;
      } else {
        mergedLists.add(listB.get(indexB));
        indexB++;
      }
    }
    addRemaining(listA, indexA, mergedLists);
    addRemaining(listB, indexB, mergedLists);
    return mergedLists;
  }

  private static void addRemaining(List<Integer> listA, int indexA, List<Integer> mergedLists) {
    while (indexA < listA.size()) {
      mergedLists.add(listA.get(indexA));
      indexA++;
    }
  }
}
