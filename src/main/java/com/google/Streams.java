package com.google;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
  public static Map<Character, List<String>> groupByFirstChar(List<String> input) {
    return input.stream()
        .collect(Collectors.groupingBy(s -> s.charAt(0)));
  }

  public static List<Integer> mapToNumbers(List<String> input) {
    return input.stream()
        .mapToInt(String::hashCode)
        .boxed()
        .toList();
  }

  public static void main(String[] args) {
    var input = List.of("aa", "ab", "ac", "ba", "bb", "bc");
    System.out.println(groupByFirstChar(input));
    System.out.println(mapToNumbers(input));
  }

}
