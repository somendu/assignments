/**
 * 
 */
package com.assignments.udemy.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Somendu
 *
 * @since 09-Sep-2020
 */
public class SortColl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> stringlist = new ArrayList<>();

		stringlist.add(1);
		stringlist.add(2);
		stringlist.add(3);
		stringlist.add(4);
		stringlist.add(5);
		stringlist.add(6);
		stringlist.add(7);
		stringlist.add(8);
		stringlist.add(9);
		stringlist.add(10);

//		System.out.println("Before : " + stringlist);
//		Collections.sort(stringlist);
//		System.out.println("After : " + stringlist);

		Collections.reverse(stringlist);
		Collections.rotate(stringlist, 3);

		Collections.swap(stringlist, 5, 4);

		System.out.println("Rotate : " + stringlist);
	}

}
