/**
 * 
 */
package com.assignments.k1;

/**
 * @author somendu
 *
 */
public class CreditCardMask {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		System.out.println(maskCardNumberTwo("1234123412341234", "xxxx-xxxx-xxxx-####"));

//		System.out.println(polishNotation("3.3 2.7 +"));
	}

	/**
	 * Applies the specified mask to the card number.
	 *
	 * @param cardNumber The card number in plain format
	 * @param mask       The number mask pattern. Use # to include a digit from the
	 *                   card number at that position, use x to skip the digit at
	 *                   that position
	 *
	 * @return The masked card number
	 */
	public static String maskCardNumber(String cardNumber, String mask) {

		// format the number
		int index = 0;
		StringBuilder maskedNumber = new StringBuilder();
		for (int i = 0; i < mask.length(); i++) {
			char c = mask.charAt(i);
			if (c == '#') {
				maskedNumber.append(cardNumber.charAt(index));
				index++;
			} else if (c == 'x') {
				maskedNumber.append(c);
				index++;
			} else {
				maskedNumber.append(c);
			}
		}

		// return the masked number
		return maskedNumber.toString();
	}

	public static String maskify(String creditCardNumber) {

		StringBuilder output = new StringBuilder();

		if (creditCardNumber.length() > 6) {

			for (int cardLength = 0; cardLength < creditCardNumber.length(); cardLength++) {
				if (Character.isDigit(creditCardNumber.charAt(cardLength)) && cardLength > 1
						&& cardLength < creditCardNumber.length() - 4) {
					output.append("#");
				} else {
					output.append(creditCardNumber.charAt(cardLength));
				}
			}

		} else {
			return creditCardNumber;
		}

		return output.toString();
	}

}
