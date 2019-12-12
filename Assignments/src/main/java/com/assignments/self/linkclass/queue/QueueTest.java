package com.assignments.self.linkclass.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<String> stringQueue = new LinkedList<String>();

		stringQueue.add("Alpha");
		stringQueue.add("Beta");
		stringQueue.add("Charlie");
		stringQueue.add("Delta");

		System.out.println("Size: " + stringQueue.size());

		System.out.println("All Elements : " + stringQueue);

		System.out.println(stringQueue.peek());

//		for (int i = 0; i < stringQueue.size(); i++) {
//			stringQueue.remove();
//			System.out.println(stringQueue);
//		}

		System.out.println(stringQueue.remove());

		System.out.println(stringQueue);

	}

}
