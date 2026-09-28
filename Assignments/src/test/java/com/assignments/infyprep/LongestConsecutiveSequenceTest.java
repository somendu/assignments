package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceTest {
  @Test
  void findsLongestRunInUnsortedInput() {
    assertEquals(
        4, LongestConsecutiveSequence.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    assertEquals(
        9, LongestConsecutiveSequence.longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
  }

  @Test
  void ignoresDuplicatesAndSupportsNegativeValues() {
    assertEquals(3, LongestConsecutiveSequence.longestConsecutive(new int[] {1, 2, 0, 1}));
    assertEquals(3, LongestConsecutiveSequence.longestConsecutive(new int[] {-2, -1, 0, 2}));
  }

  @Test
  void handlesEmptyAndSingleValue() {
    assertEquals(0, LongestConsecutiveSequence.longestConsecutive(new int[0]));
    assertEquals(1, LongestConsecutiveSequence.longestConsecutive(new int[] {7, 7}));
  }

  @Test
  void doesNotJoinIntegerLimitsThroughOverflow() {
    assertEquals(
        1,
        LongestConsecutiveSequence.longestConsecutive(
            new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));
    assertEquals(
        2,
        LongestConsecutiveSequence.longestConsecutive(
            new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE + 1}));
    assertEquals(
        2,
        LongestConsecutiveSequence.longestConsecutive(
            new int[] {Integer.MAX_VALUE - 1, Integer.MAX_VALUE}));
  }

  @Test
  void preservesInput() {
    int[] input = {3, 1, 2};
    LongestConsecutiveSequence.longestConsecutive(input);
    assertArrayEquals(new int[] {3, 1, 2}, input);
  }

  @Test
  void rejectsNull() {
    assertThrows(
        NullPointerException.class, () -> LongestConsecutiveSequence.longestConsecutive(null));
  }
}
