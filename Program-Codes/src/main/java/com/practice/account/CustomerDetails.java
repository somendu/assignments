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
public class CustomerDetails {

	int accountNumber;
	String name;
	float balance;

	public CustomerDetails() {
		// TODO Auto-generated constructor stub
	}

	public CustomerDetails(int accountNumber, String name) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;

	}

	public CustomerDetails(int accountNumber, String name, float balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	/**
	 * @return the accountNumber
	 */

	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}

}
