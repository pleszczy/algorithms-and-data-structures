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
        mergedLists.add(listA.get(indexA++));
      } else {
        mergedLists.add(listB.get(indexB++));
      }
    }
    mergedLists.addAll(listA.subList(indexA, listA.size()));
    mergedLists.addAll(listB.subList(indexB, listB.size()));
    return mergedLists;
  }
}
