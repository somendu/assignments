package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConnectedComponentsTest {
  @Test
  void countsDisconnectedGroups() {
    assertEquals(2, ConnectedComponents.countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
  }

  @Test
  void countsIsolatedVerticesAndEmptyGraph() {
    assertEquals(3, ConnectedComponents.countComponents(3, new int[0][]));
    assertEquals(0, ConnectedComponents.countComponents(0, new int[0][]));
    assertEquals(1, ConnectedComponents.countComponents(1, new int[0][]));
  }

  @Test
  void treatsEdgesAsUndirectedRegardlessOfInputOrder() {
    assertEquals(1, ConnectedComponents.countComponents(4, new int[][] {{1, 0}, {2, 1}, {3, 2}}));
  }

  @Test
  void handlesCyclesSelfLoopsAndRepeatedEdges() {
    assertEquals(
        2,
        ConnectedComponents.countComponents(
            4, new int[][] {{0, 1}, {1, 2}, {2, 0}, {0, 1}, {3, 3}}));
  }

  @Test
  void rejectsInvalidGraphDescriptions() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ConnectedComponents.countComponents(-1, new int[0][]));
    assertThrows(
        IllegalArgumentException.class,
        () -> ConnectedComponents.countComponents(2, new int[][] {{0, 2}}));
    assertThrows(
        IllegalArgumentException.class,
        () -> ConnectedComponents.countComponents(2, new int[][] {{-1, 0}}));
    assertThrows(
        IllegalArgumentException.class,
        () -> ConnectedComponents.countComponents(2, new int[][] {{0}}));
    assertThrows(
        IllegalArgumentException.class,
        () -> ConnectedComponents.countComponents(2, new int[][] {null}));
  }
}
