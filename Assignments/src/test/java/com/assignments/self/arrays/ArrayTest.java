/**
 * 
 */
package com.assignments.self.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.assignments.self.arrays.DuplicateChar;

/**
 * @author somendu
 *
 */

public class ArrayTest {

	@Test
	public void testArray() {

		assertEquals('b', DuplicateChar.getFirstNonRepeatedChar("abcdefghija"));

	}
}
