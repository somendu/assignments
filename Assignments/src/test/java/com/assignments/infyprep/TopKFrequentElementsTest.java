package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TopKFrequentElementsTest {
  @Test
  void ordersByDescendingFrequency() {
    assertArrayEquals(
        new int[] {1, 2}, TopKFrequentElements.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
  }

  @Test
  void breaksTiesByAscendingValue() {
    assertArrayEquals(
        new int[] {2, 4}, TopKFrequentElements.topKFrequent(new int[] {4, 4, 2, 2, 3}, 2));
    assertArrayEquals(
        new int[] {-2, 0, 5}, TopKFrequentElements.topKFrequent(new int[] {5, 0, -2}, 3));
    assertArrayEquals(
        new int[] {Integer.MIN_VALUE},
        TopKFrequentElements.topKFrequent(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE}, 1));
  }

  @Test
  void supportsZeroResultsAndEmptyInput() {
    assertArrayEquals(new int[0], TopKFrequentElements.topKFrequent(new int[] {1}, 0));
    assertArrayEquals(new int[0], TopKFrequentElements.topKFrequent(new int[0], 0));
  }

  @Test
  void rejectsInvalidK() {
    assertThrows(
        IllegalArgumentException.class, () -> TopKFrequentElements.topKFrequent(new int[] {1}, -1));
    assertThrows(
        IllegalArgumentException.class,
        () -> TopKFrequentElements.topKFrequent(new int[] {1, 1}, 2));
  }
}
