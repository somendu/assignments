package com.assignments.infyprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
  // Closed intervals: touching endpoints overlap. O(n log n) time, O(n) space.
  public static int[][] merge(int[][] intervals) {
    int[][] sorted = new int[intervals.length][];
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i] == null || intervals[i].length != 2 || intervals[i][0] > intervals[i][1]) {
        throw new IllegalArgumentException("Each interval must contain start <= end");
      }
      sorted[i] = intervals[i].clone(); // Keep the caller's input unchanged.
    }
    Arrays.sort(sorted, Comparator.comparingInt(interval -> interval[0]));
    List<int[]> merged = new ArrayList<>();
    for (int[] interval : sorted) {
      if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
        merged.add(interval);
      } else {
        int[] last = merged.get(merged.size() - 1);
        last[1] = Math.max(last[1], interval[1]);
      }
    }
    return merged.toArray(new int[0][]);
  }

  public static void main(String[] args) {
    System.out.println(
        "[[1,3],[2,6],[8,10],[15,18]] -> "
            + Arrays.deepToString(merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
            + " (expected: [[1, 6], [8, 10], [15, 18]])");
    System.out.println(
        "[[1,4],[4,5]] -> "
            + Arrays.deepToString(merge(new int[][] {{1, 4}, {4, 5}}))
            + " (expected: [[1, 5]])");
    System.out.println("[] -> " + Arrays.deepToString(merge(new int[0][])) + " (expected: [])");
  }
}
