package com.assignments.infyprep;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
  // O(n) time, O(n) space. Only (), [] and {} are accepted; empty input is valid.
  public static boolean isValid(String text) {
    Deque<Character> expectedClosings = new ArrayDeque<>();
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      switch (ch) {
        case '(' -> expectedClosings.push(')');
        case '[' -> expectedClosings.push(']');
        case '{' -> expectedClosings.push('}');
        case ')', ']', '}' -> {
          if (expectedClosings.isEmpty() || expectedClosings.pop() != ch) {
            return false;
          }
        }
        default -> {
          return false;
        }
      }
    }

    return expectedClosings.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println("{[()]} -> " + isValid("{[()]}") + " (expected: true)");
    System.out.println("([)] -> " + isValid("([)]") + " (expected: false)");
    System.out.println("Empty string -> " + isValid("") + " (expected: true)");
  }
}
