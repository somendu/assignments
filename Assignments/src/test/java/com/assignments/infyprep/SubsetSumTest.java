package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class SubsetSumTest {
  @Test
  void findsReachableAndUnreachableTargets() {
    assertTrue(SubsetSum.hasSubsetSum(new int[] {3, 34, 4, 12, 5, 2}, 9));
    assertFalse(SubsetSum.hasSubsetSum(new int[] {2, 4}, 3));
  }

  @Test
  void cannotReuseAnElementButCanUseEqualElementsAtDifferentPositions() {
    assertFalse(SubsetSum.hasSubsetSum(new int[] {3}, 6));
    assertTrue(SubsetSum.hasSubsetSum(new int[] {3, 3}, 6));
  }

  @Test
  void handlesEmptySubsetsAndZeroValues() {
    assertTrue(SubsetSum.hasSubsetSum(new int[0], 0));
    assertFalse(SubsetSum.hasSubsetSum(new int[0], 1));
    assertTrue(SubsetSum.hasSubsetSum(new int[] {0, 0, 2}, 2));
    assertTrue(SubsetSum.hasSubsetSum(new int[] {0, 0}, 0));
  }

  @Test
  void rejectsUnsupportedTargetsAndNegativeElements() {
    assertThrows(IllegalArgumentException.class, () -> SubsetSum.hasSubsetSum(new int[] {1}, -1));
    assertThrows(
        IllegalArgumentException.class,
        () -> SubsetSum.hasSubsetSum(new int[] {1}, Integer.MAX_VALUE));
    assertThrows(IllegalArgumentException.class, () -> SubsetSum.hasSubsetSum(new int[] {-1}, 0));
  }

  @Test
  void matchesExhaustiveSubsets() {
    Random random = new Random(48);
    for (int trial = 0; trial < 100; trial++) {
      int[] input = random.ints(random.nextInt(9), 0, 10).toArray();
      int target = random.nextInt(25);
      boolean expected = false;
      for (int mask = 0; mask < (1 << input.length); mask++) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) if ((mask & (1 << i)) != 0) sum += input[i];
        expected |= sum == target;
      }
      assertEquals(expected, SubsetSum.hasSubsetSum(input, target), "Trial " + trial);
    }
  }
}
