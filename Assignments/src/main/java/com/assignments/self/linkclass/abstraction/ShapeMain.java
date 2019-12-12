package com.assignments.self.linkclass.abstraction;

public class ShapeMain {

	public static void main(String[] args) {

		Circle circle = new Circle("red", 4);
		Rectangle rectangle = new Rectangle("green", 12, 12);

		System.out.println(circle.draw() + " of Area " + circle.getArea());
		System.out.println(rectangle.draw() + " of Area " + rectangle.getArea());

	}

}
