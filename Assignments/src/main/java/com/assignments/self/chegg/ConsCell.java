/**
 * 
 */
package com.assignments.self.chegg;

/**
 * @author Somendu
 *
 * @since 08-Oct-2020
 */
/**
 * 
 * A ConsCell is an element in a linked list of
 * 
 * ints.
 * 
 */

public class ConsCell {

	private int head;

	private ConsCell tail;

	public ConsCell(int h, ConsCell t) {

		head = h;

		tail = t;

	}

	public int getHead() {

		return head;

	}

	public ConsCell getTail() {

		return tail;

	}

	public void setTail(ConsCell t) {

		tail = t;

	}

}
