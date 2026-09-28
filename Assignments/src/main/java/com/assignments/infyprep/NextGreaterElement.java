package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
  // First strictly greater value to the right, or -1. O(n) time, O(n) space.
  public static int[] nextGreater(int[] nums) {
    int[] result = new int[nums.length];
    Deque<Integer> candidates = new ArrayDeque<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      // Smaller or equal values cannot be the next greater candidate.
      while (!candidates.isEmpty() && candidates.peek() <= nums[i]) {
        candidates.pop();
      }
      result[i] = candidates.isEmpty() ? -1 : candidates.peek();
      candidates.push(nums[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(
        "[4, 5, 2, 25] -> "
            + Arrays.toString(nextGreater(new int[] {4, 5, 2, 25}))
            + " (expected: [5, 25, 25, -1])");
    System.out.println(
        "[2, 2, 3] -> "
            + Arrays.toString(nextGreater(new int[] {2, 2, 3}))
            + " (expected: [3, 3, -1])");
  }
}
