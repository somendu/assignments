/**
 * 
 */
package com.assignments.self;

/**
 * @author somendu
 *
 */
public class BMI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(bmi(80, 1.80));

	}

	public static String bmi(double weight, double height) {

		StringBuilder returnString = new StringBuilder();

		double bmiValue = (weight / height) / 2 * 2;

		System.out.println(bmiValue);

		if (bmiValue <= 18.5) {
			returnString.append("Underweight");
		} else if (bmiValue <= 25.0) {
			returnString.append("Underweight");
		} else if (bmiValue <= 30.0) {
			returnString.append("Underweight");
		} else if (bmiValue > 30) {
			returnString.append("Obese");
		}

		return returnString.toString();
	}
}
