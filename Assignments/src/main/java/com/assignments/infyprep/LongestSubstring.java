package com.assignments.infyprep;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LongestSubstring {

  // O(n) time and O(min(n, alphabet size)) space; Java char (UTF-16) units.
  public static int lengthOfLongestSubstring(String s) {
    Objects.requireNonNull(s, "s must not be null");
    Map<Character, Integer> lastSeen = new HashMap<>();
    int left = 0;
    int longest = 0;

    for (int right = 0; right < s.length(); right++) {
      Integer previousIndex = lastSeen.put(s.charAt(right), right);
      if (previousIndex != null) {
        // Move past a duplicate without moving the window backward.
        left = Math.max(left, previousIndex + 1);
      }
      longest = Math.max(longest, right - left + 1);
    }
    return longest;
  }

  public static void main(String[] args) {
    String[] samples = {"abcabcbb", "bbbbb", "pwwkew", "", "abba"};
    int[] expected = {3, 1, 3, 0, 2};

    for (int i = 0; i < samples.length; i++) {
      System.out.printf(
          "Input: \"%s\" -> Output: %d (expected: %d)%n",
          samples[i], lengthOfLongestSubstring(samples[i]), expected[i]);
    }
  }
}
