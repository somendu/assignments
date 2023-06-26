/**
 * 
 */
package com.company.assessment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author somendu
 *
 */
public class AssessTest {

	@Test
	public void testStringList() {

		List<String> pricingList = new ArrayList<String>();

		pricingList.add("Q");
		pricingList.add("R");
		pricingList.add("S");

		String result = pricingList.stream().map(s -> String.valueOf(s)).collect(Collectors.joining(","));

		assertEquals("Q,R,S", result);

	}

}
