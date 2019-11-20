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

		System.out.println(getMinJump(10, 85, 20));

	}

	public static double getMinJump(int X, int Y, int D) {

		int minJump = 0;

		minJump = (int) Math.ceil((Y - X) / (float) D);

		return minJump;
	}

}
