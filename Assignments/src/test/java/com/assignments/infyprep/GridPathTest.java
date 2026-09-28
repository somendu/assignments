package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridPathTest {
  @Test
  void countsOpenGridPaths() {
    assertEquals(6, GridPath.countPaths(new int[3][3]));
    assertEquals(1, GridPath.countPaths(new int[][] {{0}}));
    assertEquals(1, GridPath.countPaths(new int[1][4]));
    assertEquals(1, GridPath.countPaths(new int[4][1]));
  }

  @Test
  void routesAroundObstaclesWithoutChangingGrid() {
    int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    assertEquals(2, GridPath.countPaths(grid));
    assertArrayEquals(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, grid);
  }

  @Test
  void returnsZeroForBlockedEndpointsAndBarriers() {
    assertEquals(0, GridPath.countPaths(new int[][] {{1}}));
    assertEquals(0, GridPath.countPaths(new int[][] {{0, 0}, {0, 1}}));
    assertEquals(0, GridPath.countPaths(new int[][] {{0, 1, 0}}));
    assertEquals(0, GridPath.countPaths(new int[][] {{0}, {1}, {0}}));
  }

  @Test
  void handlesEmptyGrids() {
    assertEquals(0, GridPath.countPaths(new int[0][]));
    assertEquals(0, GridPath.countPaths(new int[2][0]));
  }

  @Test
  void rejectsMalformedGridsAndInvalidCells() {
    assertThrows(
        IllegalArgumentException.class, () -> GridPath.countPaths(new int[][] {{0}, {0, 0}}));
    assertThrows(IllegalArgumentException.class, () -> GridPath.countPaths(new int[][] {null}));
    assertThrows(IllegalArgumentException.class, () -> GridPath.countPaths(new int[][] {{2}}));
  }

  @Test
  void reportsLongOverflowInsteadOfWrapping() {
    assertEquals(35345263800L, GridPath.countPaths(new int[20][20]));
    assertThrows(ArithmeticException.class, () -> GridPath.countPaths(new int[35][35]));
  }
}
