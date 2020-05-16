/**
 * 
 */
package com.assignments.uber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author somendu
 *
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
		// 720 -
		assertEquals(14, productSum.getProdSum(123456));
	}

	@Test
	public void testProductSumSevenDigit() {
		assertEquals(14, productSum.getProdSum(1234));
	}

	@Test
	public void testProductSumEightDigit() {
		assertEquals(14, productSum.getProdSum(1234));
	}

	@Test
	public void testProductSumNineDigit() {
		assertEquals(14, productSum.getProdSum(1234));
	}

}
