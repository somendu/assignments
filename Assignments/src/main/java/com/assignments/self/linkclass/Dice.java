package com.assignments.self.linkclass;

import java.util.Random;

public class Dice {

	static int siddesOfDice = 6;
	int faceValue = 0; // instance variable

	public int roll() {
		Random random = new Random();
		this.faceValue = random.nextInt(siddesOfDice) + 1;
		return this.faceValue;
	}

	public static void changeNumSidesOfDice(int newNumberOfSides) {
		Dice.siddesOfDice = newNumberOfSides;
	}

	public int getFaceValue() {
		return this.faceValue;
	}

	public static void main(String[] args) {

//		System.out.println(Dice.siddesOfDice);

		Dice.changeNumSidesOfDice(8);

		Dice dice1 = new Dice();
		Dice dice2 = new Dice();

		System.out.println();
		System.out.println("Eight Sides: ");

		for (int i = 0; i < 10; i++) {
			System.out.println("First Dice: " + dice1.roll());
			System.out.println("Second Dice: " + dice2.roll());
		}

		System.out.println();
		System.out.println("Face Value First Dice: " + dice1.faceValue);
		System.out.println("Face Value Second Dice: " + dice2.faceValue);

	}

}
