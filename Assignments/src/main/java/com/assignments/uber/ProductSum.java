/** */
package com.assignments.uber;

/**
 * @author somendu
 */
public class ProductSum {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ProductSum productSum = new ProductSum();

    productSum.getProdSum(12);
  }

  /** Returns the product of the decimal digits minus their sum, ignoring the sign. */
  public int getProdSum(int n) {
    long remaining = Math.abs((long) n);
    int product = 1;
    int sum = 0;

    do {
      int digit = (int) (remaining % 10);
      product *= digit;
      sum += digit;
      remaining /= 10;
    } while (remaining != 0);

    return product - sum;
  }
}
