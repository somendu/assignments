package com.assignments.infyprep;

import java.util.PriorityQueue;

public class KthLargest {
  // Duplicates count separately. O(n log(k+1)) time, O(k) space; input unchanged.
  public static int findKthLargest(int[] nums, int k) {
    if (k < 1 || k > nums.length) {
      throw new IllegalArgumentException("k must be between 1 and array length");
    }
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int num : nums) {
      heap.offer(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }
    return heap.element();
  }

  public static void main(String[] args) {
    System.out.println(
        "[3,2,1,5,6,4], k=2 -> "
            + findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2)
            + " (expected: 5)");
    System.out.println(
        "[3,2,3,1,2,4,5,5,6], k=4 -> "
            + findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)
            + " (expected: 4)");
  }
}
