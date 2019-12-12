package com.assignments.self.linkclass.abstraction;

public class Rectangle extends Shape {

	double length;
	double width;

	public Rectangle(String color, double length, double width) {

		super(color);

		this.length = length;
		this.width = width;

	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public String draw() {
		return "A " + color + " Rectangle " + "of Length " + length + " and Width " + width + " is drawn";
	}

}
