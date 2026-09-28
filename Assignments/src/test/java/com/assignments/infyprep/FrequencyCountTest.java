package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FrequencyCountTest {
  private static final int[] NUMBERS = {1, 2, 2, 3, 1, 2};

  @Test
  void countsRepeatedNumbersWithMerge() {
    assertEquals(Map.of(1, 2, 2, 3, 3, 1), FrequencyCount.countNumbers(NUMBERS));
  }

  @Test
  void countsRepeatedNumbersWithGetOrDefault() {
    assertEquals(Map.of(1, 2, 2, 3, 3, 1), FrequencyCount.countNumbersWithGetOrDefault(NUMBERS));
  }

  @Test
  void countsRepeatedNumbersWithStreams() {
    assertEquals(Map.of(1, 2L, 2, 3L, 3, 1L), FrequencyCount.countNumbersWithStreams(NUMBERS));
  }

  @Test
  void allNumberApproachesPreserveFirstSeenOrder() {
    int[] input = {3, -1, 3, 0};
    List<Integer> expected = List.of(3, -1, 0);
    assertEquals(expected, new ArrayList<>(FrequencyCount.countNumbers(input).keySet()));
    assertEquals(
        expected, new ArrayList<>(FrequencyCount.countNumbersWithGetOrDefault(input).keySet()));
    assertEquals(expected, new ArrayList<>(FrequencyCount.countNumbersWithStreams(input).keySet()));
  }

  @Test
  void countsCharactersIncludingCaseAndWhitespace() {
    assertEquals(Map.of('b', 1, 'a', 3, 'n', 2), FrequencyCount.countCharacters("banana"));
    assertEquals(Map.of('a', 2, 'A', 1, ' ', 1), FrequencyCount.countCharacters("a Aa"));
    assertEquals(
        Map.of('b', 1L, 'a', 3L, 'n', 2L), FrequencyCount.countCharactersWithStreams("banana"));
  }

  @Test
  void characterApproachesPreserveFirstSeenOrder() {
    List<Character> expected = List.of('b', 'a', 'n');
    assertEquals(expected, new ArrayList<>(FrequencyCount.countCharacters("banana").keySet()));
    assertEquals(
        expected, new ArrayList<>(FrequencyCount.countCharactersWithStreams("banana").keySet()));
  }

  @Test
  void handlesEmptyInputs() {
    assertTrue(FrequencyCount.countNumbers(new int[0]).isEmpty());
    assertTrue(FrequencyCount.countNumbersWithGetOrDefault(new int[0]).isEmpty());
    assertTrue(FrequencyCount.countNumbersWithStreams(new int[0]).isEmpty());
    assertTrue(FrequencyCount.countCharacters("").isEmpty());
    assertTrue(FrequencyCount.countCharactersWithStreams("").isEmpty());
  }
}
