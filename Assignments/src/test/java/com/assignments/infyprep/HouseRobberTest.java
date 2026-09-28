package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class HouseRobberTest {
  @Test
  void selectsNonAdjacentHouses() {
    assertEquals(4, HouseRobber.rob(new int[] {1, 2, 3, 1}));
    assertEquals(12, HouseRobber.rob(new int[] {2, 7, 9, 3, 1}));
    assertEquals(4, HouseRobber.rob(new int[] {2, 1, 1, 2}));
  }

  @Test
  void handlesEmptySingletonAndZeroAmounts() {
    assertEquals(0, HouseRobber.rob(new int[0]));
    assertEquals(7, HouseRobber.rob(new int[] {7}));
    assertEquals(0, HouseRobber.rob(new int[] {0, 0, 0}));
  }

  @Test
  void accumulatesBeyondIntegerRange() {
    assertEquals(4294967294L, HouseRobber.rob(new int[] {Integer.MAX_VALUE, 0, Integer.MAX_VALUE}));
  }

  @Test
  void rejectsNegativeAmounts() {
    assertThrows(IllegalArgumentException.class, () -> HouseRobber.rob(new int[] {1, -1}));
  }

  @Test
  void matchesExhaustiveNonAdjacentSelections() {
    Random random = new Random(46);
    for (int trial = 0; trial < 100; trial++) {
      int[] houses = random.ints(random.nextInt(9), 0, 10).toArray();
      long expected = 0;
      for (int mask = 0; mask < (1 << houses.length); mask++) {
        if ((mask & (mask << 1)) != 0) continue;
        long sum = 0;
        for (int i = 0; i < houses.length; i++) if ((mask & (1 << i)) != 0) sum += houses[i];
        expected = Math.max(expected, sum);
      }
      assertEquals(expected, HouseRobber.rob(houses), "Trial " + trial);
    }
  }
}
