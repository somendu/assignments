/**
 * 
 */
package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 *
 * @since 21-Nov-2023
 */
public class MainSteps {

	@Given("User is on Netbanking Login Page")
	public void user_is_on_netbanking_login_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("User landed on Netbanking login page");
	}

	@When("User login into Application")
	public void user_login_into_application() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("User Login into Application");
	}

	@Then("Home page is displayed")
	public void home_page_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Home page is displayed");
	}

	@Then("Cards are displayed")
	public void cards_are_displayed() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Cards are displayed");
	}

}
