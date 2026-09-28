package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinChangeTest {
  @Test
  void findsMinimumCoinsWithUnlimitedReuse() {
    assertEquals(3, CoinChange.coinChange(new int[] {1, 2, 5}, 11));
    assertEquals(4, CoinChange.coinChange(new int[] {2, 5, 10}, 27));
  }

  @Test
  void avoidsGreedyChoiceTrap() {
    // Greedy chooses 4+1+1; the optimum is 3+3.
    assertEquals(2, CoinChange.coinChange(new int[] {1, 3, 4}, 6));
  }

  @Test
  void returnsMinusOneWhenImpossible() {
    assertEquals(-1, CoinChange.coinChange(new int[] {2}, 3));
    assertEquals(-1, CoinChange.coinChange(new int[0], 3));
  }

  @Test
  void zeroAmountNeedsNoCoins() {
    assertEquals(0, CoinChange.coinChange(new int[] {1}, 0));
    assertEquals(0, CoinChange.coinChange(new int[0], 0));
  }

  @Test
  void acceptsUnsortedDuplicateDenominationsWithoutMutation() {
    int[] coins = {5, 1, 2, 2};
    assertEquals(3, CoinChange.coinChange(coins, 11));
    assertArrayEquals(new int[] {5, 1, 2, 2}, coins);
  }

  @Test
  void rejectsInvalidAmountsAndDenominations() {
    assertThrows(IllegalArgumentException.class, () -> CoinChange.coinChange(new int[] {1}, -1));
    assertThrows(
        IllegalArgumentException.class,
        () -> CoinChange.coinChange(new int[] {1}, Integer.MAX_VALUE));
    assertThrows(IllegalArgumentException.class, () -> CoinChange.coinChange(new int[] {0}, 1));
    assertThrows(IllegalArgumentException.class, () -> CoinChange.coinChange(new int[] {-2}, 0));
  }
}
