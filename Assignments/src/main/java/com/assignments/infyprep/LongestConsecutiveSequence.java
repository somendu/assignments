package com.assignments.infyprep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LongestConsecutiveSequence {

  // Expected O(n) time with hash lookups and O(n) space; input is unchanged.
  public static int longestConsecutive(int[] nums) {
    Objects.requireNonNull(nums, "nums must not be null");
    Set<Integer> values = new HashSet<>();
    for (int value : nums) {
      values.add(value);
    }

    int longest = 0;
    for (int value : values) {
      // Only start counting at the beginning of a sequence.
      if (value != Integer.MIN_VALUE && values.contains(value - 1)) {
        continue;
      }

      int current = value;
      int length = 1;
      // Guard against overflow connecting MAX_VALUE to MIN_VALUE.
      while (current != Integer.MAX_VALUE && values.contains(current + 1)) {
        current++;
        length++;
      }
      longest = Math.max(longest, length);
    }
    return longest;
  }

  public static void main(String[] args) {
    int[][] samples = {
      {100, 4, 200, 1, 3, 2},
      {0, 3, 7, 2, 5, 8, 4, 6, 0, 1},
      {1, 2, 0, 1},
      {},
      {-2, -1, 0, 2},
      {Integer.MIN_VALUE, Integer.MAX_VALUE}
    };
    int[] expected = {4, 9, 3, 0, 3, 1};

    for (int i = 0; i < samples.length; i++) {
      System.out.printf(
          "Input: %s -> Output: %d (expected: %d)%n",
          Arrays.toString(samples[i]), longestConsecutive(samples[i]), expected[i]);
    }
  }
}
