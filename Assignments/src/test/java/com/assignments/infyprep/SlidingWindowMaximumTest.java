package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class SlidingWindowMaximumTest {
  @Test
  void findsMaximumForEveryWindow() {
    assertArrayEquals(
        new int[] {3, 3, 5, 5, 6, 7},
        SlidingWindowMaximum.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
  }

  @Test
  void supportsSingleElementAndFullLengthWindows() {
    assertArrayEquals(new int[] {4, 2}, SlidingWindowMaximum.maxSlidingWindow(new int[] {4, 2}, 1));
    assertArrayEquals(new int[] {4}, SlidingWindowMaximum.maxSlidingWindow(new int[] {4, 2}, 2));
  }

  @Test
  void expiresOldMaximaAndHandlesEqualValues() {
    assertArrayEquals(
        new int[] {9, 2, 3}, SlidingWindowMaximum.maxSlidingWindow(new int[] {9, 1, 2, 3}, 2));
    assertArrayEquals(
        new int[] {2, 2}, SlidingWindowMaximum.maxSlidingWindow(new int[] {2, 2, 2}, 2));
    assertArrayEquals(
        new int[] {-2, -1}, SlidingWindowMaximum.maxSlidingWindow(new int[] {-3, -2, -1}, 2));
  }

  @Test
  void rejectsInvalidWindowSizes() {
    assertThrows(
        IllegalArgumentException.class,
        () -> SlidingWindowMaximum.maxSlidingWindow(new int[] {1}, 0));
    assertThrows(
        IllegalArgumentException.class,
        () -> SlidingWindowMaximum.maxSlidingWindow(new int[] {1}, -1));
    assertThrows(
        IllegalArgumentException.class,
        () -> SlidingWindowMaximum.maxSlidingWindow(new int[] {1}, 2));
    assertThrows(
        IllegalArgumentException.class, () -> SlidingWindowMaximum.maxSlidingWindow(new int[0], 1));
  }

  @Test
  void matchesDirectWindowScan() {
    Random random = new Random(43);
    for (int trial = 0; trial < 100; trial++) {
      int[] input = random.ints(1 + random.nextInt(10), -20, 21).toArray();
      for (int k = 1; k <= input.length; k++) {
        int[] expected = new int[input.length - k + 1];
        for (int start = 0; start < expected.length; start++) {
          expected[start] = Integer.MIN_VALUE;
          for (int i = start; i < start + k; i++)
            expected[start] = Math.max(expected[start], input[i]);
        }
        assertArrayEquals(
            expected,
            SlidingWindowMaximum.maxSlidingWindow(input, k),
            "Trial " + trial + ", k=" + k);
      }
    }
  }
}
