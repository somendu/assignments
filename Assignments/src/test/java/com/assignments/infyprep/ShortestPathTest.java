package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class ShortestPathTest {
  @Test
  void findsDistancesAndReconstructsPath() {
    int[][] graph = {{1, 2}, {0, 3}, {0, 3}, {1, 2, 4}, {3}, {}};
    assertArrayEquals(new int[] {0, 1, 1, 2, 3, -1}, ShortestPath.shortestDistances(graph, 0));
    assertEquals(List.of(0, 1, 3, 4), ShortestPath.shortestPath(graph, 0, 4));
  }

  @Test
  void handlesUnreachableVerticesAndSourceEqualToTarget() {
    int[][] graph = {{1}, {}, {}};
    assertEquals(List.of(), ShortestPath.shortestPath(graph, 0, 2));
    assertEquals(List.of(0), ShortestPath.shortestPath(graph, 0, 0));
    assertArrayEquals(new int[] {-1, -1, 0}, ShortestPath.shortestDistances(graph, 2));
  }

  @Test
  void respectsEdgeDirectionAndHandlesCyclesAndDuplicates() {
    int[][] graph = {{0, 1, 1}, {2}, {1}};
    assertArrayEquals(new int[] {0, 1, 2}, ShortestPath.shortestDistances(graph, 0));
    assertArrayEquals(new int[] {-1, 1, 0}, ShortestPath.shortestDistances(graph, 2));
  }

  @Test
  void rejectsInvalidVerticesAndMalformedGraphs() {
    assertThrows(
        IllegalArgumentException.class, () -> ShortestPath.shortestDistances(new int[0][], 0));
    assertThrows(
        IllegalArgumentException.class, () -> ShortestPath.shortestDistances(new int[][] {{}}, -1));
    assertThrows(
        IllegalArgumentException.class, () -> ShortestPath.shortestPath(new int[][] {{}}, 0, 1));
    assertThrows(
        IllegalArgumentException.class,
        () -> ShortestPath.shortestDistances(new int[][] {{2}, {}}, 0));
    assertThrows(
        IllegalArgumentException.class,
        () -> ShortestPath.shortestDistances(new int[][] {null}, 0));
  }

  @Test
  void matchesFloydWarshallOnSmallRandomGraphs() {
    Random random = new Random(49);
    for (int trial = 0; trial < 50; trial++) {
      int size = 1 + random.nextInt(7);
      int[][] graph = new int[size][];
      int[][] distances = new int[size][size];
      for (int from = 0; from < size; from++) {
        Arrays.fill(distances[from], 1000);
        distances[from][from] = 0;
        List<Integer> neighbors = new ArrayList<>();
        for (int to = 0; to < size; to++)
          if (random.nextInt(4) == 0) {
            neighbors.add(to);
            distances[from][to] = Math.min(distances[from][to], 1);
          }
        graph[from] = neighbors.stream().mapToInt(Integer::intValue).toArray();
      }
      for (int via = 0; via < size; via++)
        for (int from = 0; from < size; from++)
          for (int to = 0; to < size; to++) {
            distances[from][to] =
                Math.min(distances[from][to], distances[from][via] + distances[via][to]);
          }
      for (int source = 0; source < size; source++) {
        int[] expected = Arrays.stream(distances[source]).map(d -> d == 1000 ? -1 : d).toArray();
        assertArrayEquals(expected, ShortestPath.shortestDistances(graph, source));
        for (int target = 0; target < size; target++) {
          List<Integer> path = ShortestPath.shortestPath(graph, source, target);
          assertEquals(expected[target] == -1 ? 0 : expected[target] + 1, path.size());
          if (!path.isEmpty()) {
            assertEquals(source, path.get(0).intValue());
            assertEquals(target, path.get(path.size() - 1).intValue());
            for (int step = 1; step < path.size(); step++) {
              int next = path.get(step);
              assertTrue(Arrays.stream(graph[path.get(step - 1)]).anyMatch(v -> v == next));
            }
          }
        }
      }
    }
  }
}
