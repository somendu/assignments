/**
 * 
 */
package com.assignments.self.ds.collections;

import java.util.HashSet;
/**
 *<Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jan-2025
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListDemo {
	public static void main(String args[]) {
		LinkedList<String> al = new LinkedList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println("In LinkedList : " + itr.next());
		}

		Set<String> stringSet = new HashSet<String>();
		stringSet.addAll(al);

		Iterator<String> itrSet = stringSet.iterator();
		while (itrSet.hasNext()) {
			System.out.println("In HashSet : " + itrSet.next());
		}

	}
}