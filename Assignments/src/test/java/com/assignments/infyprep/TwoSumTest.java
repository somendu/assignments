package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoSumTest {
  @Test
  void returnsOriginalIndices() {
    assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {2, 7, 11, 15}, 9));
    assertArrayEquals(new int[] {1, 2}, TwoSum.twoSum(new int[] {3, 2, 4}, 6));
  }

  @Test
  void usesDistinctPositionsForDuplicateValues() {
    assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {3, 3}, 6));
    assertArrayEquals(new int[0], TwoSum.twoSum(new int[] {3}, 6));
  }

  @Test
  void returnsEmptyWhenNoPairExists() {
    assertArrayEquals(new int[0], TwoSum.twoSum(new int[] {1, 2}, 8));
    assertArrayEquals(new int[0], TwoSum.twoSum(new int[0], 0));
  }

  @Test
  void supportsNegativesAndZero() {
    assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {-3, 3}, 0));
    assertArrayEquals(new int[] {0, 1}, TwoSum.twoSum(new int[] {0, 0}, 0));
  }

  @Test
  void doesNotMatchOverflowedSums() {
    assertArrayEquals(
        new int[0], TwoSum.twoSum(new int[] {Integer.MAX_VALUE, 1}, Integer.MIN_VALUE));
    assertArrayEquals(
        new int[] {0, 1}, TwoSum.twoSum(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}, -1));
  }
}
