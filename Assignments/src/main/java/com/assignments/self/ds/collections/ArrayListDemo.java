/**
 * 
 */
package com.assignments.self.ds.collections;

/**
 *<Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jan-2025
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArrayListDemo {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Ravi");// Adding object in arraylist
		list.add("Vijay");
		list.add("Ravi");
		list.add("Ajay");
//Traversing list through Iterator  
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println("In Arraylist : " + itr.next());
		}

		Set<String> stringSet = new HashSet<String>();

		stringSet.addAll(list);
		Iterator setItr = stringSet.iterator();
		while (setItr.hasNext()) {
			System.out.println("In Hashset : " + setItr.next());
		}
	}
}
