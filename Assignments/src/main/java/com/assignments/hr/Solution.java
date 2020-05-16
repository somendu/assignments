package com.assignments.hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the commonChild function below.
	static int commonChild(String s1, String s2) {

		int first = s1.length();
		int second = s2.length();

		int[][] result = new int[first + 1][second + 1];

		for (int countFirst = 0; countFirst < first; countFirst++) {
			result[first][0] = 0;
		}

		for (int countSecond = 0; countSecond < second; countSecond++) {
			result[0][countSecond] = 0;
		}

		for (int countOuter = 1; countOuter <= first; countOuter++) {
			for (int countInner = 1; countInner <= second; countInner++) {
				if (s1.charAt(countOuter - 1) == s2.charAt(countInner - 1)) {
					result[countOuter][countInner] = result[countOuter - 1][countInner - 1] + 1;
				} else {
					result[countOuter][countInner] = Math.max(result[countOuter - 1][countInner],
							result[countOuter][countInner - 1]);
				}
			}
		}

		return result[first][second];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = commonChild(s1, s2);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
