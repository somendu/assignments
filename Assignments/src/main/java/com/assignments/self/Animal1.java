package com.assignments.self;

interface Walk {
	public default int getSpeed() {
		return 5;
	}
}

interface Run {
	public default int getSpeed() {
		return 10;
	}
}

public class Animal1 implements Walk, Run {
	public int getSpeed() {
		return 6;
	}

	public static void main(String args[]) {
		Animal1 an = new Animal1();
		System.out.println(an.getSpeed());
	}

}
