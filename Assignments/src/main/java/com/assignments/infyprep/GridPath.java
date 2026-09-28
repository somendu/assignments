package com.assignments.infyprep;

public class GridPath {
  // Count top-left to bottom-right paths, moving only right/down.
  // Rectangular grid: 0 = open, 1 = obstacle. O(rows*cols) time, O(cols) space.
  // Throws ArithmeticException if the path count exceeds long range.
  public static long countPaths(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    if (grid[0] == null) {
      throw new IllegalArgumentException("Grid rows must not be null");
    }
    int columns = grid[0].length;
    for (int[] row : grid) {
      if (row == null || row.length != columns) {
        throw new IllegalArgumentException("Grid must be rectangular");
      }
      for (int cell : row) {
        if (cell != 0 && cell != 1) {
          throw new IllegalArgumentException("Cells must be 0 or 1");
        }
      }
    }
    if (columns == 0) {
      return 0;
    }
    long[] dp = new long[columns];
    dp[0] = 1;
    for (int[] row : grid) {
      for (int col = 0; col < columns; col++) {
        if (row[col] == 1) {
          dp[col] = 0;
        } else if (col > 0) {
          // Old dp[col] comes from above; dp[col-1] comes from the left.
          dp[col] = Math.addExact(dp[col], dp[col - 1]);
        }
      }
    }
    return dp[columns - 1];
  }

  public static void main(String[] args) {
    System.out.println("Open 3x3 grid -> " + countPaths(new int[3][3]) + " (expected: 6)");
    System.out.println(
        "3x3 with center blocked -> "
            + countPaths(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})
            + " (expected: 2)");
    System.out.println(
        "Blocked start [[1]] -> " + countPaths(new int[][] {{1}}) + " (expected: 0)");
  }
}
