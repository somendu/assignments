package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class MaximumCircularSubarraySumTest {
  @Test
  void choosesWrappedOrOrdinarySubarray() {
    assertEquals(10, MaximumCircularSubarraySum.maxSubarraySumCircular(new int[] {5, -3, 5}));
    assertEquals(3, MaximumCircularSubarraySum.maxSubarraySumCircular(new int[] {1, -2, 3, -2}));
  }

  @Test
  void requiresNonemptyResultForAllNegativeInput() {
    assertEquals(-2, MaximumCircularSubarraySum.maxSubarraySumCircular(new int[] {-3, -2, -3}));
    assertEquals(-5, MaximumCircularSubarraySum.maxSubarraySumCircular(new int[] {-5}));
    assertEquals(0, MaximumCircularSubarraySum.maxSubarraySumCircular(new int[] {0, 0}));
  }

  @Test
  void supportsSumsBeyondIntegerRange() {
    assertEquals(
        4294967294L,
        MaximumCircularSubarraySum.maxSubarraySumCircular(
            new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}));
  }

  @Test
  void rejectsEmptyInput() {
    assertThrows(
        IllegalArgumentException.class,
        () -> MaximumCircularSubarraySum.maxSubarraySumCircular(new int[0]));
  }

  @Test
  void matchesExhaustiveCircularSubarrays() {
    Random random = new Random(42);
    for (int trial = 0; trial < 100; trial++) {
      int[] input = random.ints(1 + random.nextInt(8), -9, 10).toArray();
      long expected = Long.MIN_VALUE;
      for (int start = 0; start < input.length; start++) {
        long sum = 0;
        for (int length = 1; length <= input.length; length++) {
          sum += input[(start + length - 1) % input.length];
          expected = Math.max(expected, sum);
        }
      }
      assertEquals(
          expected, MaximumCircularSubarraySum.maxSubarraySumCircular(input), "Trial " + trial);
    }
  }
}
