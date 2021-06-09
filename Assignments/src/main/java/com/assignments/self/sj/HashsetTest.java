/**
 * 
 */
package com.assignments.self.sj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author Somendu Maiti
 *
 * @Since 19-Apr-2021
 */
public class HashsetTest {

	public static void main(String args[]) {
		// Creating a HashSet
		HashSet<String> set = new HashSet<String>();

		// Adding elements into HashSet using add()
		set.add("geeks");
		set.add("practice");
		set.add("contribute");
		set.add("ide");

		System.out.println("Original HashSet: " + set);

		// Sorting HashSet using List
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);

		// Print the sorted elements of the HashSet
		System.out.println("HashSet elements " + "in sorted order " + "using List: " + list);
	}

}
