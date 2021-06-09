package com.assignments.self.sj;

public class TrainBasic2 {
	public static void main(String[] args) {
		int a = 2, s = 3, d = 4, f = 5;
		boolean r, t = false;
		r = s > a && d > f;
		System.out.println(r);
		System.out.println(r);

		if ((s - a) == 1 || (d - f) == 1) {
			t = true;
		}
		System.out.println(t);
	}

}