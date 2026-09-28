package com.assignments.infyprep;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NthLargest {

  public static void main(String[] args) {

    int[] nums = new int[] {3, 2, 1, 5, 6, 4};
    int nMax = 3;

    nthGreater(nums, nMax);
  }

  private static void nthGreater(int[] nums, int nMax) {
    Arrays.sort(nums);

    int nthLargest = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int num : nums) {
      heap.offer(num);

      if (heap.size() > nMax) {
        heap.poll();
      }
    }

    System.out.println(heap.peek());
  }
}
