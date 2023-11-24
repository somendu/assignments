/**
 * 
 */
package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Demonstrate Hooks
 * 
 * @author Somendu Maiti
 *
 * @since 24-Nov-2023
 */
public class Hooks {

	@Before("@NetBanking")
	public void netBankingSetup() {

		System.out.println("****************************************NetBanking");
		System.out.println("Setup the Entries in Netbanking database");
	}

	@Before("@Mortgage")
	public void mortgageSetup() {
		System.out.println("****************************************Mortgage");
		System.out.println("Setup the Entries in Mortgage database");
	}

	@After
	public void tearDown() {
		System.out.println("Clear The Entries");
	}
}

//Before --> Background --> Scenario --> After