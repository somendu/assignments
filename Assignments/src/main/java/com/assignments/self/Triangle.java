/**
 * 
 */
package com.assignments.self;

/**
 * @author somendu
 *
 */
public class Triangle {

	public static void main(String args[]) {
//		Scanner cmd = new Scanner(System.in);
//		System.out.println("Enter the number of rows of Floyd's triangle, you want to display");
//		int rows = cmd.nextInt();

		printPascalTriangle(5);
	}

	/** * Prints Floyd's triangle of a given row * * @param rows */
	public static void printFloydTriangle(int rows) {
		int number = 1;
		System.out.printf("Floyd's triangle of %d rows is : %n", rows);
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(number + " ");
				number++;
			}
			System.out.println();
		}
	}

	public static void printPascalTriangle(int rows) {
		for (int i = 0; i < rows; i++) {
			int number = 1;
			System.out.printf("%" + (rows - i) * 2 + "s", "");
			for (int j = 0; j <= i; j++) {
				System.out.printf("%4d", number);
				number = number * (i - j) / (j + 1);

			}
			System.out.println();
		}
	}

}
