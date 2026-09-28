package com.assignments.sherlock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LocalExtremaInArraysTest {
  @Test
  void countsIllustrativeExample() {
    assertEquals(3, LocalExtremaInArrays.numLocalExtrema(new int[] {1, 3, 2, 4, 1}));
  }

  @Test
  void excludesEndpointsAndEqualNeighbors() {
    assertEquals(0, LocalExtremaInArrays.numLocalExtrema(new int[] {5, 5, 5}));
    assertEquals(0, LocalExtremaInArrays.numLocalExtrema(new int[] {3, 1}));
    assertEquals(1, LocalExtremaInArrays.numLocalExtrema(new int[] {-1, -3, -2}));
  }
}
