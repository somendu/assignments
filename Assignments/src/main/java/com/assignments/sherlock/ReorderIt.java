package com.assignments.sherlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public final class ReorderIt {
  private static final long MOD = 1_000_000_007L;

  private ReorderIt() {}

  public static void main(String[] args) {
    int[] n = {2, 2, 4};
    int[] p = {5, 2, 2};
    List<List<Integer>> a =
        Arrays.asList(Arrays.asList(5, 8), Arrays.asList(9, 2), Arrays.asList(6, 7, 1, 9));
    List<List<Integer>> b =
        Arrays.asList(Arrays.asList(9, 6), Arrays.asList(3, 1), Arrays.asList(1, 5, 8, 4));
    int[] expected = {0, 2, 24};

    for (int i = 0; i < expected.length; i++) {
      int actual = solve(n[i], p[i], a.get(i), b.get(i));
      System.out.println("Sample " + (i + 1) + ": " + actual + " (expected " + expected[i] + ")");
      if (actual != expected[i]) {
        throw new AssertionError("Sample " + (i + 1) + " failed");
      }
    }
  }

  public static int solve(int N, int P, List<Integer> A, List<Integer> B) {
    if (N <= 0 || A == null || B == null || A.size() != N || B.size() != N) {
      throw new IllegalArgumentException(
          "A and B must each contain N elements; N must be positive");
    }
    List<Integer> keepA = build(N, A, B);
    List<Integer> keepB = build(N, B, A);
    List<Integer> result = lexicographicallyLess(keepB, keepA) ? keepB : keepA;
    long hash = 0;
    long power = 1;
    for (int value : result) {
      hash = (hash + value * power) % MOD;
      power = power * P % MOD;
    }
    return (int) hash;
  }

  private static List<Integer> build(int n, List<Integer> fixed, List<Integer> movable) {
    TreeMap<Integer, Integer> available = new TreeMap<Integer, Integer>();
    for (int value : movable) {
      int residue = Math.floorMod(value, n);
      available.put(residue, available.containsKey(residue) ? available.get(residue) + 1 : 1);
    }
    List<Integer> result = new ArrayList<Integer>(n);
    for (int value : fixed) {
      int x = Math.floorMod(value, n);
      Integer y = available.ceilingKey((n - x) % n);
      if (y == null) y = available.firstKey();
      result.add((x + y) % n);
      int count = available.get(y);
      if (count == 1) available.remove(y);
      else available.put(y, count - 1);
    }
    return result;
  }

  private static boolean lexicographicallyLess(List<Integer> a, List<Integer> b) {
    for (int i = 0; i < a.size(); i++) {
      if (!a.get(i).equals(b.get(i))) return a.get(i) < b.get(i);
    }
    return false;
  }
}
