package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {
  @Test
  void countsSeparateLandMassesWithoutMutatingGrid() {
    char[][] grid = {
      "11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()
    };
    assertEquals(3, NumberOfIslands.numIslands(grid));
    assertArrayEquals(
        new char[][] {
          "11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()
        },
        grid);
  }

  @Test
  void diagonalContactDoesNotConnectIslands() {
    assertEquals(2, NumberOfIslands.numIslands(new char[][] {{'1', '0'}, {'0', '1'}}));
  }

  @Test
  void handlesAllLandAndAllWater() {
    assertEquals(1, NumberOfIslands.numIslands(new char[][] {{'1', '1'}, {'1', '1'}}));
    assertEquals(0, NumberOfIslands.numIslands(new char[][] {{'0', '0'}}));
    assertEquals(1, NumberOfIslands.numIslands(new char[][] {{'1'}}));
  }

  @Test
  void handlesEmptyAndSingleRowGrids() {
    assertEquals(0, NumberOfIslands.numIslands(new char[0][]));
    assertEquals(0, NumberOfIslands.numIslands(new char[2][0]));
    assertEquals(3, NumberOfIslands.numIslands(new char[][] {"10101".toCharArray()}));
  }

  @Test
  void rejectsMalformedGridsAndInvalidCells() {
    assertThrows(
        IllegalArgumentException.class,
        () -> NumberOfIslands.numIslands(new char[][] {{'1'}, {'0', '1'}}));
    assertThrows(
        IllegalArgumentException.class, () -> NumberOfIslands.numIslands(new char[][] {null}));
    assertThrows(
        IllegalArgumentException.class, () -> NumberOfIslands.numIslands(new char[][] {{'x'}}));
  }
}
