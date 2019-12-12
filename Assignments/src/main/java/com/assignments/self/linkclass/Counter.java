package com.assignments.self.linkclass;

public class Counter {

	int count = 0;

	public static void main(String[] args) {

		Counter count = new Counter();
		count.incrementCount(5);
		System.out.println(count.count);
	}

	public void incrementCount(int amount) {
		this.count += amount;
	}

}
