package com.assignments.infyprep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  // Expected O(n) time, O(n) space. Return two distinct indices, or an empty array.
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      long complement = (long) target - nums[i];
      if (complement >= Integer.MIN_VALUE && complement <= Integer.MAX_VALUE) {
        Integer previous = seen.get((int) complement);
        if (previous != null) {
          return new int[] {previous, i};
        }
      }
      // Look up first so the same element cannot be used twice.
      seen.putIfAbsent(nums[i], i);
    }
    return new int[0];
  }

  public static void main(String[] args) {
    System.out.println(
        "[2, 7, 11, 15], target 9 -> "
            + Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9))
            + " (expected: [0, 1])");
    System.out.println(
        "[3, 3], target 6 -> "
            + Arrays.toString(twoSum(new int[] {3, 3}, 6))
            + " (expected: [0, 1])");
    System.out.println(
        "[1, 2], target 8 -> " + Arrays.toString(twoSum(new int[] {1, 2}, 8)) + " (expected: [])");
  }
}
