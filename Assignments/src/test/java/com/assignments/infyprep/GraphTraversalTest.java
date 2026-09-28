package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class GraphTraversalTest {
  @Test
  void visitsInBreadthFirstAndDepthFirstOrder() {
    int[][] graph = {{1, 2}, {0, 3}, {0}, {1}, {}};
    assertEquals(List.of(0, 1, 2, 3), GraphTraversal.bfs(graph, 0));
    assertEquals(List.of(0, 1, 3, 2), GraphTraversal.dfs(graph, 0));
  }

  @Test
  void limitsTraversalToReachableVertices() {
    int[][] graph = {{1}, {0}, {}};
    assertEquals(List.of(0, 1), GraphTraversal.bfs(graph, 0));
    assertEquals(List.of(2), GraphTraversal.bfs(graph, 2));
    assertEquals(List.of(2), GraphTraversal.dfs(graph, 2));
  }

  @Test
  void visitsEachVertexOnceDespiteCyclesAndDuplicateEdges() {
    int[][] graph = {{0, 1, 1, 2}, {2}, {0}};
    assertEquals(List.of(0, 1, 2), GraphTraversal.bfs(graph, 0));
    assertEquals(List.of(0, 1, 2), GraphTraversal.dfs(graph, 0));
  }

  @Test
  void respectsDirectedEdges() {
    int[][] graph = {{1}, {2}, {}};
    assertEquals(List.of(1, 2), GraphTraversal.bfs(graph, 1));
    assertEquals(List.of(1, 2), GraphTraversal.dfs(graph, 1));
  }

  @Test
  void rejectsInvalidSourcesAndNeighbors() {
    assertThrows(IllegalArgumentException.class, () -> GraphTraversal.bfs(new int[0][], 0));
    assertThrows(IllegalArgumentException.class, () -> GraphTraversal.dfs(new int[][] {{}}, -1));
    assertThrows(
        IllegalArgumentException.class, () -> GraphTraversal.bfs(new int[][] {{2}, {}}, 0));
    assertThrows(
        IllegalArgumentException.class, () -> GraphTraversal.dfs(new int[][] {{}, null}, 0));
  }
}
