/**
 * 
 */
package main.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description>
 * 
 * @author Somendu
 * @since Apr 3, 2020
 */
public class GenericCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		char[] list = { '?', 'a', 'B', 'c', '5', 'd', 'E', 'F', 'g', '%', '#', 'H' };

		List<Character> charList = new ArrayList<Character>();

		for (char charSingle : list) {
			charList.add(charSingle);
		}

		List<String> stringList = lettersAndNumbers(charList);

		for (String string : stringList) {
			System.out.println(string);
		}

	}

	public static List<String> lettersAndNumbers(List<Character> list) {
		List<String> returnList = new ArrayList<String>();
		for (Character character : list) {
			if (Character.isUpperCase(character)) {
				returnList.add("U{" + character + "}");
			} else if (Character.isLowerCase(character)) {
				returnList.add("L{" + character + "}");
			} else if (Character.isDigit(character)) {
				returnList.add("N{" + character + "}");
			}
		}
		return returnList;
	}

	public static int modify(List<Integer> list) {
		return 0;
	}
}
