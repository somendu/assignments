package com.assignments.infyprep;

import java.util.Arrays;

public class ClimbingStairs {
  // Take 1 or 2 steps. There is one way to climb zero stairs: take no steps.
  // O(n) time, O(1) space. n <= 91 keeps the answer within a signed long.
  public static long climbStairs(int n) {
    validate(n);
    long previous = 1, current = 1;
    for (int step = 2; step <= n; step++) {
      long next = previous + current;
      previous = current;
      current = next;
    }
    return current;
  }

  // Recursion + memoization: O(n) time and O(n) space including call stack.
  public static long climbStairsMemoized(int n) {
    validate(n);
    long[] memo = new long[n + 1];
    Arrays.fill(memo, -1);
    return count(n, memo);
  }

  private static long count(int n, long[] memo) {
    if (n <= 1) {
      return 1;
    }
    if (memo[n] == -1) {
      memo[n] = count(n - 1, memo) + count(n - 2, memo);
    }
    return memo[n];
  }

  private static void validate(int n) {
    if (n < 0 || n > 91) {
      throw new IllegalArgumentException("n must be between 0 and 91");
    }
  }

  public static void main(String[] args) {
    System.out.println("n=5, iterative -> " + climbStairs(5) + " (expected: 8)");
    System.out.println("n=5, memoized -> " + climbStairsMemoized(5) + " (expected: 8)");
    System.out.println("n=0 -> " + climbStairs(0) + " (expected: 1)");
  }
}
