package com.company.kalah.support;

/**
 * @author somendu
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String path = "/api/games/242737/pits/13";

		final int secondLast = path.length() - 5;
		final String output = path.substring(0, path.lastIndexOf("/", secondLast));
		System.out.println(output);
	}

}
