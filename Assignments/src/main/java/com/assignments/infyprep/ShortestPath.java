package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class ShortestPath {
  private record SearchResult(int[] distances, int[] parents) {}

  // Unweighted graph adjacency lists, vertices 0..V-1; works for directed graphs too.
  // BFS: O(V+E) time, O(V) auxiliary space. -1 denotes an unreachable vertex.
  public static int[] shortestDistances(int[][] graph, int source) {
    return search(graph, source).distances();
  }

  // Return one shortest path including both endpoints, or [] if unreachable.
  public static List<Integer> shortestPath(int[][] graph, int source, int target) {
    if (target < 0 || target >= graph.length) {
      throw new IllegalArgumentException("Target vertex is out of range");
    }
    SearchResult result = search(graph, source);
    List<Integer> path = new ArrayList<>();
    if (result.distances()[target] == -1) {
      return path;
    }
    for (int vertex = target; vertex != -1; vertex = result.parents()[vertex]) {
      path.add(vertex);
    }
    Collections.reverse(path);
    return path;
  }

  private static SearchResult search(int[][] graph, int source) {
    if (source < 0 || source >= graph.length) {
      throw new IllegalArgumentException("Source vertex is out of range");
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
    int[] distances = new int[graph.length];
    int[] parents = new int[graph.length];
    Arrays.fill(distances, -1);
    Arrays.fill(parents, -1);
    Deque<Integer> queue = new ArrayDeque<>();
    distances[source] = 0;
    queue.addLast(source);
    while (!queue.isEmpty()) {
      int vertex = queue.removeFirst();
      for (int neighbor : graph[vertex]) {
        if (distances[neighbor] == -1) {
          distances[neighbor] = distances[vertex] + 1;
          parents[neighbor] = vertex;
          queue.addLast(neighbor);
        }
      }
    }
    return new SearchResult(distances, parents);
  }

  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {0, 3}, {0, 3}, {1, 2, 4}, {3}, {}};
    System.out.println("Graph [[1,2],[0,3],[0,3],[1,2,4],[3],[]], source=0");
    System.out.println(
        "Distances -> "
            + Arrays.toString(shortestDistances(graph, 0))
            + " (expected: [0, 1, 1, 2, 3, -1])");
    System.out.println("Path 0 to 4 -> " + shortestPath(graph, 0, 4) + " (expected: [0, 1, 3, 4])");
    System.out.println("Path 0 to 5 -> " + shortestPath(graph, 0, 5) + " (expected: [])");
    System.out.println("Path 0 to 0 -> " + shortestPath(graph, 0, 0) + " (expected: [0])");
  }
}
