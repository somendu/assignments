package com.assignments.infyprep;

public class SubsetSum {
  // Nonnegative integers; each position is usable once. Empty subset makes target 0.
  // O(n*target) time, O(target) space; suitable for moderate targets.
  public static boolean hasSubsetSum(int[] nums, int target) {
    if (target < 0 || target == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Target must be nonnegative and below Integer.MAX_VALUE");
    }
    for (int num : nums) {
      if (num < 0) {
        throw new IllegalArgumentException("Values must be nonnegative");
      }
    }
    boolean[] possible = new boolean[target + 1];
    possible[0] = true;
    for (int num : nums) {
      // Descending sums prevent reusing the current element.
      for (int sum = target; sum >= num; sum--) {
        possible[sum] |= possible[sum - num];
      }
    }
    return possible[target];
  }

  public static void main(String[] args) {
    System.out.println(
        "[3,34,4,12,5,2], target=9 -> "
            + hasSubsetSum(new int[] {3, 34, 4, 12, 5, 2}, 9)
            + " (expected: true)");
    System.out.println(
        "[2,4], target=3 -> " + hasSubsetSum(new int[] {2, 4}, 3) + " (expected: false)");
    System.out.println("[3], target=6 -> " + hasSubsetSum(new int[] {3}, 6) + " (expected: false)");
    System.out.println("[], target=0 -> " + hasSubsetSum(new int[0], 0) + " (expected: true)");
  }
}
