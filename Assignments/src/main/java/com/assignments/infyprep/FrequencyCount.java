package com.assignments.infyprep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencyCount {
  // getOrDefault returns 0 when the number has not been seen before.
  public static Map<Integer, Integer> countNumbersWithGetOrDefault(int[] nums) {
    Map<Integer, Integer> counts = new LinkedHashMap<>();
    for (int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    return counts;
  }

  // merge inserts 1 for a new number and adds 1 to an existing count.
  public static Map<Integer, Integer> countNumbers(int[] nums) {
    Map<Integer, Integer> counts = new LinkedHashMap<>();
    for (int num : nums) {
      counts.merge(num, 1, Integer::sum);
    }
    return counts;
  }

  // Stream version: group equal numbers and count the values in each group.
  public static Map<Integer, Long> countNumbersWithStreams(int[] nums) {
    return IntStream.of(nums)
        .boxed()
        .collect(
            Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
  }

  // Case-sensitive; includes whitespace and counts Java char (UTF-16) units.
  public static Map<Character, Integer> countCharacters(String text) {
    Map<Character, Integer> counts = new LinkedHashMap<>();
    for (int i = 0; i < text.length(); i++) {
      counts.merge(text.charAt(i), 1, Integer::sum);
    }
    return counts;
  }

  // Convert character positions to a stream, then group and count characters.
  public static Map<Character, Long> countCharactersWithStreams(String text) {
    return IntStream.range(0, text.length())
        .mapToObj(text::charAt)
        .collect(
            Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
  }

  public static void main(String[] args) {
    int[] numbers = {1, 2, 2, 3, 1, 2};
    System.out.println(
        "getOrDefault -> "
            + countNumbersWithGetOrDefault(numbers)
            + " (expected: {1=2, 2=3, 3=1})");
    System.out.println("merge -> " + countNumbers(numbers) + " (expected: {1=2, 2=3, 3=1})");
    System.out.println(
        "streams -> " + countNumbersWithStreams(numbers) + " (expected: {1=2, 2=3, 3=1})");
    System.out.println("banana -> " + countCharacters("banana") + " (expected: {b=1, a=3, n=2})");
    System.out.println(
        "banana streams -> "
            + countCharactersWithStreams("banana")
            + " (expected: {b=1, a=3, n=2})");
  }
}
