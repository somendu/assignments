package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CycleDetectionTest {
  @Test
  void detectsDirectedCycleIncludingDisconnectedComponent() {
    assertTrue(CycleDetection.hasDirectedCycle(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}));
    assertTrue(CycleDetection.hasDirectedCycle(5, new int[][] {{0, 1}, {3, 4}, {4, 3}}));
  }

  @Test
  void acceptsDirectedAcyclicGraphsWithConvergingPaths() {
    assertFalse(CycleDetection.hasDirectedCycle(4, new int[][] {{0, 1}, {0, 2}, {1, 3}, {2, 3}}));
    assertFalse(CycleDetection.hasDirectedCycle(2, new int[][] {{0, 1}, {0, 1}}));
  }

  @Test
  void detectsUndirectedCyclesButAcceptsForests() {
    assertTrue(CycleDetection.hasUndirectedCycle(3, new int[][] {{0, 1}, {1, 2}, {2, 0}}));
    assertFalse(CycleDetection.hasUndirectedCycle(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
  }

  @Test
  void handlesSelfLoopsAndUndirectedParallelEdges() {
    assertTrue(CycleDetection.hasDirectedCycle(1, new int[][] {{0, 0}}));
    assertTrue(CycleDetection.hasUndirectedCycle(1, new int[][] {{0, 0}}));
    assertTrue(CycleDetection.hasUndirectedCycle(2, new int[][] {{0, 1}, {0, 1}}));
  }

  @Test
  void emptyAndEdgelessGraphsHaveNoCycles() {
    assertFalse(CycleDetection.hasDirectedCycle(0, new int[0][]));
    assertFalse(CycleDetection.hasUndirectedCycle(0, new int[0][]));
    assertFalse(CycleDetection.hasDirectedCycle(3, new int[0][]));
    assertFalse(CycleDetection.hasUndirectedCycle(3, new int[0][]));
  }

  @Test
  void rejectsInvalidVerticesAndEdges() {
    assertThrows(
        IllegalArgumentException.class, () -> CycleDetection.hasDirectedCycle(-1, new int[0][]));
    assertThrows(
        IllegalArgumentException.class, () -> CycleDetection.hasUndirectedCycle(-1, new int[0][]));
    for (int[][] edges : new int[][][] {{{0, 2}}, {{-1, 0}}, {{0}}, {null}}) {
      assertThrows(IllegalArgumentException.class, () -> CycleDetection.hasDirectedCycle(2, edges));
      assertThrows(
          IllegalArgumentException.class, () -> CycleDetection.hasUndirectedCycle(2, edges));
    }
  }
}
