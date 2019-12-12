package com.assignments.self.linkclass.link;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {

		LinkedList<String> linkedList = new LinkedList<String>();

		linkedList.add("Alpha");
		linkedList.add("Beta");
		linkedList.add("Charlie");
		linkedList.add("Delta");

		linkedList.addFirst("Zero");
		linkedList.addLast("Erna");

		linkedList.add(2, "Alpha2");

		System.out.println("First Element : " + linkedList.getFirst());

		System.out.println("Last Element : " + linkedList.getLast());

		System.out.println("Size: " + linkedList.size());

		System.out.println("All Elements : " + linkedList);

		System.out.println("Second Elements : " + linkedList.get(1));

		System.out.println("Index of Beta : " + linkedList.indexOf("Beta"));

	}

}
