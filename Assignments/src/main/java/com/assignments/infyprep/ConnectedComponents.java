package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ConnectedComponents {
  // Undirected graph with vertices 0..vertices-1; each edge is {u,v}.
  // Includes isolated vertices. O(V+E) time and space, including adjacency lists.
  public static int countComponents(int vertices, int[][] edges) {
    if (vertices < 0) {
      throw new IllegalArgumentException("Vertex count must be nonnegative");
    }
    List<List<Integer>> graph = new ArrayList<>();
    for (int v = 0; v < vertices; v++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      if (edge == null
          || edge.length != 2
          || edge[0] < 0
          || edge[0] >= vertices
          || edge[1] < 0
          || edge[1] >= vertices) {
        throw new IllegalArgumentException("Each edge must contain two valid vertices");
      }
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    int components = 0;
    boolean[] visited = new boolean[vertices];
    Deque<Integer> queue = new ArrayDeque<>();
    for (int start = 0; start < vertices; start++) {
      if (visited[start]) {
        continue;
      }
      components++;
      visited[start] = true;
      queue.addLast(start);
      while (!queue.isEmpty()) {
        int vertex = queue.removeFirst();
        for (int neighbor : graph.get(vertex)) {
          if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.addLast(neighbor);
          }
        }
      }
    }
    return components;
  }

  public static void main(String[] args) {
    System.out.println(
        "V=5, edges=[[0,1],[1,2],[3,4]] -> "
            + countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}})
            + " (expected: 2)");
    System.out.println("V=3, no edges -> " + countComponents(3, new int[0][]) + " (expected: 3)");
    System.out.println("V=0, no edges -> " + countComponents(0, new int[0][]) + " (expected: 0)");
  }
}
