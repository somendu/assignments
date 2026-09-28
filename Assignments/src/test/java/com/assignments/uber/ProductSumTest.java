/** */
package com.assignments.uber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author somendu
 */
public class ProductSumTest {

  ProductSum productSum = new ProductSum();

  @Test
  public void testProductSumTwoDigit() {

    assertEquals(-1, productSum.getProdSum(12));
  }

  @Test
  public void testProductSumThreeDigit() {
    assertEquals(0, productSum.getProdSum(123));
  }

  @Test
  public void testProductSumFourDigit() {
    // 24 - 10
    assertEquals(14, productSum.getProdSum(1234));
  }

  @Test
  public void testProductSumFiveDigit() {
    // 120 - 15
    assertEquals(105, productSum.getProdSum(12345));
  }

  @Test
  public void testProductSumSixDigit() {
    // 720 - 21
    assertEquals(699, productSum.getProdSum(123456));
  }

  @Test
  public void testProductSumSevenDigit() {
    assertEquals(5012, productSum.getProdSum(1234567));
  }

  @Test
  public void testProductSumEightDigit() {
    assertEquals(40284, productSum.getProdSum(12345678));
  }

  @Test
  public void testProductSumNineDigit() {
    assertEquals(362835, productSum.getProdSum(123456789));
  }

  @Test
  public void testProductSumZero() {
    assertEquals(0, productSum.getProdSum(0));
  }

  @Test
  public void testProductSumSingleDigit() {
    assertEquals(0, productSum.getProdSum(7));
  }

  @Test
  public void testProductSumWithZeroDigit() {
    assertEquals(-6, productSum.getProdSum(105));
  }

  @Test
  public void testProductSumNegativeNumber() {
    assertEquals(14, productSum.getProdSum(-1234));
  }

  @Test
  public void testProductSumMinimumInteger() {
    // Digits of 2147483648: product 1,032,192 minus sum 47.
    assertEquals(1032145, productSum.getProdSum(Integer.MIN_VALUE));
  }
}
