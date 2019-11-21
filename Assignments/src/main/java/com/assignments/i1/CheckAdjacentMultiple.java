package com.assignments.i1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author somendu
 *
 */
public class CheckAdjacentMultiple {

	public static void main(String[] args) {

		System.out.println(solution(6, 20));
	}

	public static int solution(int A, int B) {

		int keepCount = 0;

		List<Integer> integerList = new ArrayList<Integer>();

		for (int listCount = A; listCount <= B; listCount++) {

			integerList.add(listCount);

		}

		for (int keepCounter = 0; keepCounter < integerList.size(); keepCounter++) {

			if (checkConsInst(integerList.get(keepCounter))) {

				keepCount++;
			}

		}

		return keepCount;
	}

	private static boolean checkConsInst(int checkNumber) {

		int checkSqrt = (int) (Math.sqrt(checkNumber));

		if (checkSqrt * (checkSqrt + 1) == checkNumber) {

			return true;

		} else {

			return false;

		}

	}
}
