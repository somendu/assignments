package com.assignments.infyprep;

public class HouseRobber {
  // Linear street, nonnegative amounts: cannot select adjacent houses.
  // O(n) time, O(1) space. long avoids overflow when adding int amounts.
  public static long rob(int[] houses) {
    long twoBack = 0, oneBack = 0;
    for (int amount : houses) {
      if (amount < 0) {
        throw new IllegalArgumentException("House amounts must be nonnegative");
      }
      long best = Math.max(oneBack, twoBack + amount);
      twoBack = oneBack;
      oneBack = best;
    }
    return oneBack;
  }

  public static void main(String[] args) {
    System.out.println("[1,2,3,1] -> " + rob(new int[] {1, 2, 3, 1}) + " (expected: 4)");
    System.out.println("[2,7,9,3,1] -> " + rob(new int[] {2, 7, 9, 3, 1}) + " (expected: 12)");
    System.out.println("[] -> " + rob(new int[0]) + " (expected: 0)");
  }
}
