package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClimbingStairsTest {
  @Test
  void countsKnownResultsInBothImplementations() {
    long[] expected = {1, 1, 2, 3, 5, 8, 13, 21};
    for (int n = 0; n < expected.length; n++) {
      assertEquals(expected[n], ClimbingStairs.climbStairs(n));
      assertEquals(expected[n], ClimbingStairs.climbStairsMemoized(n));
    }
  }

  @Test
  void supportsLargestRepresentableInput() {
    assertEquals(7540113804746346429L, ClimbingStairs.climbStairs(91));
    assertEquals(7540113804746346429L, ClimbingStairs.climbStairsMemoized(91));
  }

  @Test
  void implementationsAgreeThroughoutSupportedRange() {
    for (int n = 0; n <= 91; n++) {
      assertEquals(ClimbingStairs.climbStairs(n), ClimbingStairs.climbStairsMemoized(n), "n=" + n);
    }
  }

  @Test
  void rejectsNegativeAndOverflowingInputs() {
    for (int n : new int[] {-1, 92, Integer.MAX_VALUE}) {
      assertThrows(IllegalArgumentException.class, () -> ClimbingStairs.climbStairs(n));
      assertThrows(IllegalArgumentException.class, () -> ClimbingStairs.climbStairsMemoized(n));
    }
  }
}
