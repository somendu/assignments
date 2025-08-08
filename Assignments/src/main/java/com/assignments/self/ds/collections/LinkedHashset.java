/**
 * 
 */
package com.assignments.self.ds.collections;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jan-2025
 */
public class LinkedHashset {
	public static void main(String args[]) {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("Ravi");
		set.add("Vijay");
		set.add("Ravi");
		set.add("Ajay");
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
