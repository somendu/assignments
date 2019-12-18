package com.assignments.self.ocjp;

public class Prog5 {
	static Integer I;

	public static void main(String args[]) {
		String s;
		try {
			s = I.toString();
		} finally {
			try {
				int i = Integer.parseInt(args[0]);
			} catch (NumberFormatException E) {
				System.out.print("NumberFormat ");
			} finally {
				System.out.print("Fin2 ");
			}
			System.out.print("Fin1 ");
		}
	}
}
