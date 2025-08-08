/**
 * 
 */
package com.assignments.self.ds.collections;

import java.util.HashSet;
import java.util.Iterator;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jan-2025
 */
public class HashsetDemo {
	public static void main(String args[]) {
		// Creating HashSet and adding elements
		HashSet<String> set = new HashSet<String>();
		set.add("Ravi");
		set.add("Vijay");
		set.add("Ravi");
		set.add("Ajay");
		// Traversing elements
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
