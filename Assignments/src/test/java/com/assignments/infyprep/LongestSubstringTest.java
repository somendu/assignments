package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestSubstringTest {
  @Test
  void findsLongestSubstringInExamples() {
    assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    assertEquals(1, LongestSubstring.lengthOfLongestSubstring("bbbbb"));
    assertEquals(3, LongestSubstring.lengthOfLongestSubstring("pwwkew"));
  }

  @Test
  void neverMovesWindowBackward() {
    assertEquals(2, LongestSubstring.lengthOfLongestSubstring("abba"));
    assertEquals(5, LongestSubstring.lengthOfLongestSubstring("tmmzuxt"));
  }

  @Test
  void handlesEmptyAndUniqueStrings() {
    assertEquals(0, LongestSubstring.lengthOfLongestSubstring(""));
    assertEquals(1, LongestSubstring.lengthOfLongestSubstring("a"));
    assertEquals(6, LongestSubstring.lengthOfLongestSubstring("abcdef"));
  }

  @Test
  void treatsCaseAndWhitespaceAsDistinctCharacters() {
    assertEquals(3, LongestSubstring.lengthOfLongestSubstring("a A"));
  }

  @Test
  void rejectsNull() {
    assertThrows(NullPointerException.class, () -> LongestSubstring.lengthOfLongestSubstring(null));
  }
}
