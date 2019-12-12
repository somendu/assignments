package com.assignments.self.linkclass.abstraction;

public class Circle extends Shape {

	double radius;

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	@Override
	double getArea() {
		return Math.PI * (radius * radius);
	}

	@Override
	String draw() {

		return "A " + color + " Circle " + " of Radius " + radius + " is drawn";
	}

}
