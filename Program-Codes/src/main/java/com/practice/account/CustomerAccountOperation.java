/**
 * 
 */
package com.practice.account;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 15-Jun-2023
 */
public class CustomerAccountOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CustomerDetails customerDetailsOne = new CustomerDetails();
		customerDetailsOne.setAccountNumber(72387);
		customerDetailsOne.setName("Somendu");
		customerDetailsOne.setBalance(7800);

		CustomerDetails customerDetailsTwo = new CustomerDetails(637623, "Aditi", 7800);

		System.out.println("Account 1 : " + customerDetailsOne.getAccountNumber());
		System.out.println("Account 2 : " + customerDetailsTwo.getAccountNumber());

		CustomerDetails customerDetailsThree = new CustomerDetails(8732887, "Rohit");

		System.out.println("Account 3 : " + customerDetailsThree.getAccountNumber());

	}

}
