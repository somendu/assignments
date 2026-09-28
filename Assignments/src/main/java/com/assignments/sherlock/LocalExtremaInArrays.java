package com.assignments.sherlock;

public final class LocalExtremaInArrays {
  private LocalExtremaInArrays() {}

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4, 1};
    System.out.println(numLocalExtrema(arr));
  }

  public static int numLocalExtrema(int[] arr) {
    if (arr == null || arr.length < 3) return 0;
    int count = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      if ((arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
          || (arr[i] < arr[i - 1] && arr[i] < arr[i + 1])) count++;
    }
    return count;
  }
}
