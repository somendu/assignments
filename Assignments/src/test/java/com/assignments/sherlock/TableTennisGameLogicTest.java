package com.assignments.sherlock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TableTennisGameLogicTest {
  @Test
  void alternatesServiceEveryTwoPoints() {
    assertEquals(3, TableTennisGameLogic.getSum(new int[] {0, 0, 1, 0, 2, 0, 3, 0, 3, 1, 5, 1}));
  }

  @Test
  void emptyGamesAndIncompletePair() {
    assertEquals(0, TableTennisGameLogic.getSum(new int[0]));
    assertThrows(IllegalArgumentException.class, () -> TableTennisGameLogic.getSum(new int[] {3}));
  }
}
