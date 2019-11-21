/**
 * 
 */
package com.assignments.cod1.threee;

/**
 * @author somendu
 *
 */
public class FrogJmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getMinJump(10, 85, 30));

	}

	public static double getMinJumpLoop(int X, int Y, int D) {

		int minJump = 0;

		for (int count = X; count < Y;) {
			count = count + D;
			minJump++;
		}

		return minJump;
	}

	public static double getMinJump(int X, int Y, int D) {

		int minJump = 0;

		minJump = (int) Math.ceil((Y - X) / (float) D);

		return minJump;
	}
}
