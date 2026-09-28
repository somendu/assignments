package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {
  @Test
  void acceptsBalancedAndNestedBrackets() {
    assertTrue(ValidParentheses.isValid("()[]{}"));
    assertTrue(ValidParentheses.isValid("{[()]}"));
    assertTrue(ValidParentheses.isValid(""));
  }

  @Test
  void rejectsMismatchedNesting() {
    assertFalse(ValidParentheses.isValid("([)]"));
    assertFalse(ValidParentheses.isValid("(]"));
  }

  @Test
  void rejectsUnmatchedOpeningOrClosingBrackets() {
    assertFalse(ValidParentheses.isValid("("));
    assertFalse(ValidParentheses.isValid(")"));
    assertFalse(ValidParentheses.isValid("())"));
  }

  @Test
  void rejectsCharactersOutsideBracketAlphabet() {
    assertFalse(ValidParentheses.isValid("(a)"));
    assertFalse(ValidParentheses.isValid(" "));
  }
}
