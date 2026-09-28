package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
  // Rectangular grid: '1' is land, '0' is water. Only four-directional adjacency.
  // BFS: O(rows*cols) time and space. Does not mutate the input grid.
  public static int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    if (grid[0] == null) {
      throw new IllegalArgumentException("Grid rows must not be null");
    }
    int columns = grid[0].length;
    for (char[] row : grid) {
      if (row == null || row.length != columns) {
        throw new IllegalArgumentException("Grid must be rectangular");
      }
      for (char cell : row) {
        if (cell != '0' && cell != '1') {
          throw new IllegalArgumentException("Cells must be '0' or '1'");
        }
      }
    }
    boolean[][] visited = new boolean[grid.length][columns];
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Deque<int[]> queue = new ArrayDeque<>();
    int islands = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < columns; col++) {
        if (grid[row][col] != '1' || visited[row][col]) {
          continue;
        }
        islands++;
        visited[row][col] = true;
        queue.addLast(new int[] {row, col});
        while (!queue.isEmpty()) {
          int[] cell = queue.removeFirst();
          for (int[] direction : directions) {
            int nextRow = cell[0] + direction[0];
            int nextCol = cell[1] + direction[1];
            if (nextRow >= 0
                && nextRow < grid.length
                && nextCol >= 0
                && nextCol < columns
                && grid[nextRow][nextCol] == '1'
                && !visited[nextRow][nextCol]) {
              visited[nextRow][nextCol] = true;
              queue.addLast(new int[] {nextRow, nextCol});
            }
          }
        }
      }
    }
    return islands;
  }

  public static void main(String[] args) {
    char[][] grid = {
      "11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(), "00011".toCharArray()
    };
    System.out.println("[11000,11000,00100,00011] -> " + numIslands(grid) + " (expected: 3)");
    System.out.println(
        "Diagonal land [10,01] -> "
            + numIslands(new char[][] {{'1', '0'}, {'0', '1'}})
            + " (expected: 2)");
    System.out.println("Empty grid -> " + numIslands(new char[0][]) + " (expected: 0)");
  }
}
