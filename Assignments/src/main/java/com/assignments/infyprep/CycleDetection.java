package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CycleDetection {
  // Edges are {from,to}; vertices are 0..vertices-1.
  // Directed: Kahn's topological sort, O(V+E) time and space.
  public static boolean hasDirectedCycle(int vertices, int[][] edges) {
    validate(vertices, edges);
    List<List<Integer>> graph = new ArrayList<>();
    for (int v = 0; v < vertices; v++) {
      graph.add(new ArrayList<>());
    }
    int[] indegree = new int[vertices];
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      indegree[edge[1]]++;
    }
    Deque<Integer> queue = new ArrayDeque<>();
    for (int v = 0; v < vertices; v++) {
      if (indegree[v] == 0) {
        queue.addLast(v);
      }
    }
    int processed = 0;
    while (!queue.isEmpty()) {
      int vertex = queue.removeFirst();
      processed++;
      for (int neighbor : graph.get(vertex)) {
        if (--indegree[neighbor] == 0) {
          queue.addLast(neighbor);
        }
      }
    }
    return processed != vertices;
  }

  // Undirected: union-find, O(V + E*alpha(V)) time, O(V) auxiliary space.
  // List each undirected edge once. Self-loops and parallel edges count as cycles.
  public static boolean hasUndirectedCycle(int vertices, int[][] edges) {
    validate(vertices, edges);
    int[] parent = new int[vertices];
    int[] size = new int[vertices];
    for (int v = 0; v < vertices; v++) {
      parent[v] = v;
      size[v] = 1;
    }
    for (int[] edge : edges) {
      int rootA = find(parent, edge[0]);
      int rootB = find(parent, edge[1]);
      if (rootA == rootB) {
        return true;
      }
      if (size[rootA] < size[rootB]) {
        int temporary = rootA;
        rootA = rootB;
        rootB = temporary;
      }
      parent[rootB] = rootA;
      size[rootA] += size[rootB];
    }
    return false;
  }

  private static int find(int[] parent, int vertex) {
    while (vertex != parent[vertex]) {
      parent[vertex] = parent[parent[vertex]]; // Path compression by halving.
      vertex = parent[vertex];
    }
    return vertex;
  }

  private static void validate(int vertices, int[][] edges) {
    if (vertices < 0) {
      throw new IllegalArgumentException("Vertex count must be nonnegative");
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
    }
  }

  public static void main(String[] args) {
    int[][] triangle = {{0, 1}, {1, 2}, {2, 0}};
    int[][] chain = {{0, 1}, {1, 2}};
    System.out.println(
        "Directed 0->1->2->0 -> " + hasDirectedCycle(3, triangle) + " (expected: true)");
    System.out.println("Directed 0->1->2 -> " + hasDirectedCycle(3, chain) + " (expected: false)");
    System.out.println(
        "Undirected triangle -> " + hasUndirectedCycle(3, triangle) + " (expected: true)");
    System.out.println(
        "Undirected chain -> " + hasUndirectedCycle(3, chain) + " (expected: false)");
  }
}
