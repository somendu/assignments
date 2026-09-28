package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GraphTraversal {
  // Adjacency lists: graph[v] contains v's neighbors, vertices are 0..V-1.
  // Traverse only vertices reachable from start, following listed neighbor order.
  // Both traversals take O(V+E) time (including validation), O(V) auxiliary space.
  public static List<Integer> bfs(int[][] graph, int start) {
    validate(graph, start);
    List<Integer> order = new ArrayList<>();
    boolean[] visited = new boolean[graph.length];
    Deque<Integer> queue = new ArrayDeque<>();
    queue.addLast(start);
    visited[start] = true; // Mark on enqueue to avoid duplicate work.
    while (!queue.isEmpty()) {
      int vertex = queue.removeFirst();
      order.add(vertex);
      for (int neighbor : graph[vertex]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.addLast(neighbor);
        }
      }
    }
    return order;
  }

  // Recursive DFS demonstrates backtracking; very deep graphs can exhaust the stack.
  public static List<Integer> dfs(int[][] graph, int start) {
    validate(graph, start);
    List<Integer> order = new ArrayList<>();
    visit(graph, start, new boolean[graph.length], order);
    return order;
  }

  private static void visit(int[][] graph, int vertex, boolean[] visited, List<Integer> order) {
    visited[vertex] = true;
    order.add(vertex);
    for (int neighbor : graph[vertex]) {
      if (!visited[neighbor]) {
        visit(graph, neighbor, visited, order);
      }
    }
  }

  private static void validate(int[][] graph, int start) {
    if (start < 0 || start >= graph.length) {
      throw new IllegalArgumentException("Start vertex is out of range");
    }
    for (int[] neighbors : graph) {
      if (neighbors == null) {
        throw new IllegalArgumentException("Neighbor lists must not be null");
      }
      for (int neighbor : neighbors) {
        if (neighbor < 0 || neighbor >= graph.length) {
          throw new IllegalArgumentException("Neighbor vertex is out of range");
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {0, 3}, {0}, {1}, {}};
    System.out.println("Graph [[1,2],[0,3],[0],[1],[]], start=0");
    System.out.println("BFS -> " + bfs(graph, 0) + " (expected: [0, 1, 2, 3])");
    System.out.println("DFS -> " + dfs(graph, 0) + " (expected: [0, 1, 3, 2])");
    System.out.println("BFS from isolated vertex 4 -> " + bfs(graph, 4) + " (expected: [4])");
  }
}
