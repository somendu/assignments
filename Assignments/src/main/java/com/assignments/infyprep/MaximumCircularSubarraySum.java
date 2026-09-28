package com.assignments.infyprep;

public class MaximumCircularSubarraySum {
  // Nonempty subarray, at most one wrap. Kadane's algorithm: O(n) time, O(1) space.
  public static long maxSubarraySumCircular(int[] nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("At least one number is required");
    }
    long total = nums[0];
    long maxEnding = nums[0], maxSum = nums[0];
    long minEnding = nums[0], minSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      maxEnding = Math.max(nums[i], maxEnding + nums[i]);
      minEnding = Math.min(nums[i], minEnding + nums[i]);
      maxSum = Math.max(maxSum, maxEnding);
      minSum = Math.min(minSum, minEnding);
      total += nums[i];
    }
    // An all-negative array must not select the empty wrapped subarray.
    return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
  }

  public static void main(String[] args) {
    System.out.println(
        "[5, -3, 5] -> " + maxSubarraySumCircular(new int[] {5, -3, 5}) + " (expected: 10)");
    System.out.println(
        "[-3, -2, -3] -> " + maxSubarraySumCircular(new int[] {-3, -2, -3}) + " (expected: -2)");
    System.out.println(
        "[1, -2, 3, -2] -> " + maxSubarraySumCircular(new int[] {1, -2, 3, -2}) + " (expected: 3)");
  }
}
