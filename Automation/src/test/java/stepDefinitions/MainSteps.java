/**
 * 
 */
package stepDefinitions;

import java.util.List;

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

	@Given("setup the entries in database")
	public void setup_the_entries_in_database() {
		System.out.println("******************************");
		System.out.println("setup the entries in database");
	}

	@Given("launch the browser from config variables")
	public void launch_the_browser_from_config_variables() {
		System.out.println("setup the entries in database");
	}

	@Given("hit the home page url of banking site")
	public void hit_the_home_page_url_of_banking_site() {
		System.out.println("hit the home page url of banking site");
	}

	@Given("User is on Netbanking Login Page")
	public void user_is_on_netbanking_login_page() {

		System.out.println("User landed on Netbanking login page");
	}

//	@When("User login into Application with {string} and password {string}")
//	public void user_login_into_application_with_and_password(String username, String password) {
//		// Write code here that turns the phrase above into concrete actions
//		System.out.println("User Login into Application with username " + username + " and password " + password);
//	}

//	@When("User login into Application with {string} and password {string} Various")
//	public void user_login_into_application_with_and_password_various(String username, String password) {
//		// Write code here that turns the phrase above into concrete actions
//		System.out.println("User Login into Application with username " + username + " and password " + password);
//	}

	@Given("User is on Practice Login Page")
	public void user_is_on_practice_login_page() {
		System.out.println("Sign Up Page");
	}

	@When("User sign up  into Application")
	public void user_sign_up_into_application(List<String> data) {
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	}

	@When("^User login into Application with (.+) and password (.+)$")
	public void user_login_into_application_with_and_password_various(String username, String password) {

		System.out.println("User Login into Application with username " + username + " and password " + password);
	}

	@Then("Home page is displayed")
	public void home_page_is_displayed() {

		System.out.println("Home page is displayed");
	}

	@Then("Cards are displayed")
	public void cards_are_displayed() {

		System.out.println("Cards are displayed");
	}

}
