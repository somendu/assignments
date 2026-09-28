package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequenceTest {
  private void assertBoth(int expected, int[] input) {
    int[] original = input.clone();
    assertEquals(expected, LongestIncreasingSubsequence.lengthOfLIS(input));
    assertEquals(expected, LongestIncreasingSubsequence.lengthOfLISBinarySearch(input));
    assertArrayEquals(original, input);
  }

  @Test
  void findsNoncontiguousIncreasingSubsequence() {
    assertBoth(4, new int[] {10, 9, 2, 5, 3, 7, 101, 18});
    assertBoth(4, new int[] {0, 1, 0, 3, 2, 3});
  }

  @Test
  void requiresStrictIncreaseAndHandlesDescendingValues() {
    assertBoth(1, new int[] {7, 7, 7});
    assertBoth(1, new int[] {3, 2, 1});
    assertBoth(3, new int[] {-3, -2, -1});
  }

  @Test
  void handlesEmptySingletonAndIntegerLimits() {
    assertBoth(0, new int[0]);
    assertBoth(1, new int[] {7});
    assertBoth(3, new int[] {Integer.MIN_VALUE, 0, Integer.MAX_VALUE});
  }

  @Test
  void matchesExhaustiveSubsequences() {
    Random random = new Random(47);
    for (int trial = 0; trial < 100; trial++) {
      int[] input = random.ints(random.nextInt(9), -5, 6).toArray();
      int expected = 0;
      for (int mask = 0; mask < (1 << input.length); mask++) {
        long previous = Long.MIN_VALUE;
        int length = 0;
        boolean increasing = true;
        for (int i = 0; i < input.length; i++)
          if ((mask & (1 << i)) != 0) {
            increasing &= input[i] > previous;
            previous = input[i];
            length++;
          }
        if (increasing) expected = Math.max(expected, length);
      }
      assertBoth(expected, input);
    }
  }
}
