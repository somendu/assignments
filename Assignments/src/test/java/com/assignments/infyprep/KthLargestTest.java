package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class KthLargestTest {
  @Test
  void findsKthLargestIncludingDuplicates() {
    assertEquals(5, KthLargest.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
    assertEquals(4, KthLargest.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    assertEquals(5, KthLargest.findKthLargest(new int[] {5, 5, 1}, 2));
  }

  @Test
  void supportsExtremeRanksAndNegativeValues() {
    assertEquals(-1, KthLargest.findKthLargest(new int[] {-3, -1, -2}, 1));
    assertEquals(-3, KthLargest.findKthLargest(new int[] {-3, -1, -2}, 3));
    assertEquals(7, KthLargest.findKthLargest(new int[] {7}, 1));
  }

  @Test
  void rejectsInvalidRank() {
    assertThrows(IllegalArgumentException.class, () -> KthLargest.findKthLargest(new int[] {1}, 0));
    assertThrows(IllegalArgumentException.class, () -> KthLargest.findKthLargest(new int[] {1}, 2));
    assertThrows(IllegalArgumentException.class, () -> KthLargest.findKthLargest(new int[0], 1));
  }

  @Test
  void matchesSortedReferenceAndPreservesInput() {
    Random random = new Random(44);
    for (int trial = 0; trial < 100; trial++) {
      int[] input = random.ints(1 + random.nextInt(10), -20, 21).toArray();
      int[] original = input.clone();
      int[] sorted = input.clone();
      Arrays.sort(sorted);
      for (int k = 1; k <= input.length; k++) {
        assertEquals(sorted[sorted.length - k], KthLargest.findKthLargest(input, k));
      }
      assertArrayEquals(original, input);
    }
  }
}
