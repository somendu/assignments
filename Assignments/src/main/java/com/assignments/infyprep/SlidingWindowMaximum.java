package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
  // Decreasing deque of indices: O(n) time, O(k) auxiliary space.
  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (k < 1 || k > nums.length) {
      throw new IllegalArgumentException("Window size must be between 1 and array length");
    }
    int[] result = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
        deque.removeFirst();
      }
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peekFirst()];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        "[1,3,-1,-3,5,3,6,7], k=3 -> "
            + Arrays.toString(maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3))
            + " (expected: [3, 3, 5, 5, 6, 7])");
    System.out.println(
        "[4,2], k=1 -> "
            + Arrays.toString(maxSlidingWindow(new int[] {4, 2}, 1))
            + " (expected: [4, 2])");
  }
}
