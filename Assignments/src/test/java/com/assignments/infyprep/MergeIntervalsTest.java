package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeIntervalsTest {
  @Test
  void mergesOverlapsAndKeepsSeparateIntervals() {
    assertArrayEquals(
        new int[][] {{1, 6}, {8, 10}, {15, 18}},
        MergeIntervals.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
  }

  @Test
  void mergesTouchingAndNestedIntervals() {
    assertArrayEquals(new int[][] {{1, 5}}, MergeIntervals.merge(new int[][] {{1, 4}, {4, 5}}));
    assertArrayEquals(
        new int[][] {{1, 10}}, MergeIntervals.merge(new int[][] {{5, 8}, {1, 10}, {2, 3}}));
  }

  @Test
  void handlesEmptyAndExtremeEndpoints() {
    assertArrayEquals(new int[0][], MergeIntervals.merge(new int[0][]));
    assertArrayEquals(
        new int[][] {
          {Integer.MIN_VALUE, Integer.MIN_VALUE}, {Integer.MAX_VALUE, Integer.MAX_VALUE}
        },
        MergeIntervals.merge(
            new int[][] {
              {Integer.MAX_VALUE, Integer.MAX_VALUE}, {Integer.MIN_VALUE, Integer.MIN_VALUE}
            }));
  }

  @Test
  void neitherMutatesNorAliasesInput() {
    int[][] input = {{5, 8}, {1, 6}};
    int[][] result = MergeIntervals.merge(input);
    assertArrayEquals(new int[][] {{5, 8}, {1, 6}}, input);
    result[0][0] = 99;
    assertArrayEquals(new int[][] {{5, 8}, {1, 6}}, input);
  }

  @Test
  void rejectsMalformedIntervals() {
    assertThrows(IllegalArgumentException.class, () -> MergeIntervals.merge(new int[][] {{3, 1}}));
    assertThrows(IllegalArgumentException.class, () -> MergeIntervals.merge(new int[][] {{1}}));
    assertThrows(IllegalArgumentException.class, () -> MergeIntervals.merge(new int[][] {null}));
  }
}
