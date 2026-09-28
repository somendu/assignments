package com.assignments.infyprep;

import java.util.Arrays;

public class CoinChange {
  // Minimum coins with unlimited reuse; -1 if impossible. Positive denominations only.
  // O(amount * coins.length) time, O(amount) space; suitable for moderate amounts.
  public static int coinChange(int[] coins, int amount) {
    if (amount < 0 || amount == Integer.MAX_VALUE) {
      throw new IllegalArgumentException("Amount must be nonnegative and below Integer.MAX_VALUE");
    }
    for (int coin : coins) {
      if (coin <= 0) {
        throw new IllegalArgumentException("Coin denominations must be positive");
      }
    }
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int sum = 1; sum <= amount; sum++) {
      for (int coin : coins) {
        if (coin <= sum && dp[sum - coin] != amount + 1) {
          dp[sum] = Math.min(dp[sum], dp[sum - coin] + 1);
        }
      }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    System.out.println(
        "coins=[1,2,5], amount=11 -> " + coinChange(new int[] {1, 2, 5}, 11) + " (expected: 3)");
    System.out.println(
        "coins=[2], amount=3 -> " + coinChange(new int[] {2}, 3) + " (expected: -1)");
    System.out.println("coins=[1], amount=0 -> " + coinChange(new int[] {1}, 0) + " (expected: 0)");
  }
}
