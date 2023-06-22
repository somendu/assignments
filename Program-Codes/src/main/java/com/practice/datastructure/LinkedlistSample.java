/**
 * 
 */
package com.practice.datastructure;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 20-Jun-2023
 */

public class LinkedlistSample {

	Node head;

	class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}

		// add first
		public void addfirst(String data) {
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
				return;
			}

			newNode.next = head;
			head = newNode;
		}

		// add last
		public void addlast(String data) {
			if (head == null) {
				LinkedlistSample.Node newNode = null;
				head = newNode;
				return;
			}
			Node currNode = head;
			while (currNode != null) {
				currNode = currNode.next;
			}

		}

	}

	public static void main(String[] args) {
		LinkedlistSample listSample = new LinkedlistSample();
		LinkedlistSample.Node list = listSample.new Node("a");
		list.addfirst("a");
		list.addfirst("is");

		System.out.println(list.data);

	}

}