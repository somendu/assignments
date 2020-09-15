/**
 * 
 */
package com.assignments.udemy;

/**
 * @author Somendu
 *
 * @since 02-Sep-2020
 */
public class Car {

	String color;
	String type;

	static int carCount;
	int serialNumber;

	public Car() {
		carCount++;
		serialNumber = carCount;
	}

	public Car(String color, String type) {
		carCount++;
		serialNumber = carCount;
		this.color = color;
		this.type = type;
	}

	void start() {
		System.out.println("Get Started!");
	}

	void printDescription() {
		System.out.println("This is a " + color + " " + type);
	}

	void printSerialNumber() {
		System.out.println("Serial number for " + color + " " + type + " is " + serialNumber);
	}

	public static void main(String[] args) {
		Car myCar1, myCar2, myCar3;

		myCar1 = new Car();
		myCar2 = new Car("Green", "Hatchback");
		myCar3 = new Car("Red", "Electric");

		myCar1.color = "Blue";
		myCar1.type = "Sedan";

		myCar1.printSerialNumber();
		myCar2.printSerialNumber();
		myCar3.printSerialNumber();

	}
}
