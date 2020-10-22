/**
 * 
 */
package com.assignments.self.chegg;

import java.util.Arrays;
import java.util.List;

/**
 * @author Somendu
 *
 * @since 08-Oct-2020
 */
public class IntList {

	private ConsCell start;

	public IntList(ConsCell s) {

		start = s;

	}

	public IntList cons(int h) {

		return new IntList(new ConsCell(h, start));

	}

	public int length() {

		int len = 0;

		ConsCell cell = start;

		while (cell != null) {

			len++;

			cell = cell.getTail();

		}

		return len;

	}

	public void print() {

		System.out.print("[");

		ConsCell a = start;

		while (a != null) {

			System.out.print(a.getHead());

			a = a.getTail();

			if (a != null)
				System.out.print(",");

		}

		System.out.println("]");

	}

	private void inOrder(ConsCell consCell) {
		if (consCell != null) {
			inOrder(consCell.getTail());
			System.out.print(consCell.getHead() + " ");
			inOrder(consCell.getTail());
		}
	}

	private void inOrderDesc(ConsCell consCell) {
		if (consCell != null) {
			inOrderDesc(consCell.getTail());
			System.out.print(consCell.getHead() + " ");
			inOrderDesc(consCell.getTail());
		}
	}

	public static void sort(IntList[] consCellInt) {

		List<IntList> intList = Arrays.asList(consCellInt);

		// intList.stream().map(intList ->
		// intList.g).sorted().collect(Collectors.toList());

	}

}
