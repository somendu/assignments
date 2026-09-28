package com.assignments.sherlock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ReorderItTest {
  @Test
  void firstVisibleSample() {
    assertEquals(0, ReorderIt.solve(2, 5, Arrays.asList(5, 8), Arrays.asList(9, 6)));
  }

  @Test
  void secondVisibleSample() {
    assertEquals(2, ReorderIt.solve(2, 2, Arrays.asList(9, 2), Arrays.asList(3, 1)));
  }

  @Test
  void thirdVisibleSampleUsesAllNPositions() {
    assertEquals(24, ReorderIt.solve(4, 2, Arrays.asList(6, 7, 1, 9), Arrays.asList(1, 5, 8, 4)));
  }
}
