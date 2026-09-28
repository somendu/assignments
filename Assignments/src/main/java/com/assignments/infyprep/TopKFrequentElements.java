package com.assignments.infyprep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
  // Expected O(n + u log(k+1)) time, O(u+k) space for u distinct values.
  // Output: descending frequency; ties use ascending numeric value.
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num : nums) {
      counts.merge(num, 1, Integer::sum);
    }
    if (k < 0 || k > counts.size()) {
      throw new IllegalArgumentException("k must be between 0 and the number of distinct values");
    }
    if (k == 0) {
      return new int[0];
    }
    // The least desirable retained value is at the heap root.
    Comparator<Integer> order =
        (a, b) -> {
          int byCount = Integer.compare(counts.get(a), counts.get(b));
          return byCount != 0 ? byCount : Integer.compare(b, a);
        };
    PriorityQueue<Integer> heap = new PriorityQueue<>(order);
    for (int num : counts.keySet()) {
      heap.offer(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      result[i] = heap.remove();
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        "[1,1,1,2,2,3], k=2 -> "
            + Arrays.toString(topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2))
            + " (expected: [1, 2])");
    System.out.println(
        "[4,4,2,2,3], k=2 -> "
            + Arrays.toString(topKFrequent(new int[] {4, 4, 2, 2, 3}, 2))
            + " (expected: [2, 4])");
  }
}
