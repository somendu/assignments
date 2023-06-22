/**
 * 
 */
package com.practice.datastructure;

public class linkedl {

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
				linkedl.Node newNode = null;
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

		linkedl linkedl = new linkedl();
		linkedl.Node list = linkedl.new Node("a");

		list.addfirst("a");
		list.addfirst("is");
		list.addfirst("This");
	}
}
