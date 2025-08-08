package com.assignments.self.ds.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jan-2025
 */
public class StackDemo {
	public static void main(String args[]) {
		Stack<String> stack = new Stack<String>();
		stack.push("Ayush");
		stack.push("Garvit");
		stack.push("Amit");
		stack.push("Ashish");
		stack.push("Amit");
		// stack.pop();
		Iterator<String> itr = stack.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		Set<String> stringSet = new HashSet<String>();
		stringSet.addAll(stack);

		Iterator<String> itrSet = stringSet.iterator();
		while (itrSet.hasNext()) {
			System.out.println("In HashSet : " + itrSet.next());
		}
	}
}
