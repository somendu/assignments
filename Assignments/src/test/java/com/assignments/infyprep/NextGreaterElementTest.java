package com.assignments.infyprep;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NextGreaterElementTest {
  @Test
  void findsFirstGreaterValueToTheRight() {
    assertArrayEquals(
        new int[] {5, 25, 25, -1}, NextGreaterElement.nextGreater(new int[] {4, 5, 2, 25}));
    assertArrayEquals(
        new int[] {3, 4, 4, -1}, NextGreaterElement.nextGreater(new int[] {2, 3, 1, 4}));
  }

  @Test
  void requiresStrictlyGreaterValues() {
    assertArrayEquals(new int[] {3, 3, -1}, NextGreaterElement.nextGreater(new int[] {2, 2, 3}));
    assertArrayEquals(new int[] {-1, -1}, NextGreaterElement.nextGreater(new int[] {2, 2}));
  }

  @Test
  void handlesEmptySingletonAndDescendingInputs() {
    assertArrayEquals(new int[0], NextGreaterElement.nextGreater(new int[0]));
    assertArrayEquals(new int[] {-1}, NextGreaterElement.nextGreater(new int[] {7}));
    assertArrayEquals(new int[] {-1, -1, -1}, NextGreaterElement.nextGreater(new int[] {3, 2, 1}));
  }

  @Test
  void supportsNegativeValuesWithoutMutatingInput() {
    int[] input = {-3, -2, -1};
    assertArrayEquals(new int[] {-2, -1, -1}, NextGreaterElement.nextGreater(input));
    assertArrayEquals(new int[] {-3, -2, -1}, input);
  }
}
