/**
 * 
 */
package com.assignments.self.ds.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jan-2025
 */
public class ArrayDequeDemo {
	public static void main(String[] args) {
		// Creating Deque and adding elements
		Deque<String> deque = new ArrayDeque<String>();
		deque.add("Gautam");
		deque.add("Karan");
		deque.add("Ajay");
		// Traversing elements
		for (String str : deque) {
			System.out.println(str);
		}

		Set<String> stringSet = new HashSet<String>();
		stringSet.addAll(deque);

		Iterator<String> itrSet = stringSet.iterator();
		while (itrSet.hasNext()) {
			System.out.println("In HashSet : " + itrSet.next());
		}
	}
}
