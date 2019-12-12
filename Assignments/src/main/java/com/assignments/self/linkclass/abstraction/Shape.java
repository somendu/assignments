package com.assignments.self.linkclass.abstraction;

public abstract class Shape {

	String color;

	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public Shape(String color) {
		this.color = color;
	}

	abstract double getArea();

	abstract String draw();
}
