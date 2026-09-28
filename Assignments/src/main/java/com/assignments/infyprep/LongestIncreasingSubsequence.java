package com.assignments.infyprep;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
  // Strictly increasing; equal values do not extend a subsequence.
  // DP: O(n^2) time, O(n) space. dp[i] is the best length ending at i.
  public static int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int longest = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      longest = Math.max(longest, dp[i]);
    }
    return longest;
  }

  // Binary search: O(n log n) time, O(n) space; tails is not the actual subsequence.
  public static int lengthOfLISBinarySearch(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int num : nums) {
      int left = 0, right = size;
      while (left < right) {
        int middle = left + (right - left) / 2;
        if (tails[middle] < num) {
          left = middle + 1;
        } else {
          right = middle;
        }
      }
      tails[left] = num;
      if (left == size) {
        size++;
      }
    }
    return size;
  }

  public static void main(String[] args) {
    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    System.out.println(Arrays.toString(nums) + ", DP -> " + lengthOfLIS(nums) + " (expected: 4)");
    System.out.println(
        Arrays.toString(nums)
            + ", binary search -> "
            + lengthOfLISBinarySearch(nums)
            + " (expected: 4)");
    System.out.println("[7,7,7] -> " + lengthOfLIS(new int[] {7, 7, 7}) + " (expected: 1)");
    System.out.println("[] -> " + lengthOfLIS(new int[0]) + " (expected: 0)");
  }
}
