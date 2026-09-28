package com.assignments.sherlock;

public final class TableTennisGameLogic {
  private TableTennisGameLogic() {}

  public static void main(String[] args) {
    int[] scores = {0, 0, 2, 0, 3, 1};
    System.out.println(getSum(scores));
  }

  // Consecutive pairs are (A's score, B's score); no count prefix is included.
  public static int getSum(int[] array) {
    if (array == null || array.length % 2 != 0) {
      throw new IllegalArgumentException("Expected an even number of score values");
    }
    int count = 0;
    for (int i = 0; i < array.length; i += 2) {
      long points = (long) array[i] + array[i + 1];
      if ((points / 2) % 2 == 0) count++;
    }
    return count;
  }
}
