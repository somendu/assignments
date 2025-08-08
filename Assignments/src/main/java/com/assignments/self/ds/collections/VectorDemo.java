/**
 * 
 */
package com.assignments.self.ds.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jan-2025
 */
public class VectorDemo {
	public static void main(String args[]) {
		Vector<String> v = new Vector<String>();
		v.add("Ayush");
		v.add("Amit");
		v.add("Ashish");
		v.add("Amit");
		Iterator<String> itr = v.iterator();
		while (itr.hasNext()) {
			System.out.println("In Vector : " + itr.next());
		}

		Set<String> stringSet = new HashSet<String>();
		stringSet.addAll(v);

		Iterator<String> itrSet = stringSet.iterator();
		while (itrSet.hasNext()) {
			System.out.println("In HashSet : " + itrSet.next());
		}
	}

}
