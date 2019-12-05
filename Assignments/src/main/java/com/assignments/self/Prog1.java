package com.assignments.self;

class Animal {
	void run() {
		System.out.print("Animal run");
	}
}

class Dog extends Animal {
	void sound() {
		System.out.print("Bark");
	}

	public void run() {
		System.out.print(" Dog runs");
	}
}

class Prog1 {
	public static void main(String[] args) {
		Animal dog = new Dog();
		// error here
//		dog.sound();
		dog.run();
	}
}
