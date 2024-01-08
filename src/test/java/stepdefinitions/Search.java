package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;	
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
	}

	@When("user enters the valid product {string} on the search feild")
	public void user_enters_the_valid_product_on_the_search_feild(String validProductText) {
	    
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProductText);
		
	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
	    
		searchResultsPage = homePage.clicksOnSearchButton();
		
	}

	@Then("Searched valid product should get displayed in the search results")
	public void searched_valid_product_should_get_displayed_in_the_search_results() {
	    
		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		
	}
	
	@When("user enters the invalid product {string} on the search feild")
	public void user_enters_the_invalid_product_on_the_search_feild(String invalidProductText) {
		
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProductText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	    
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultsPage.getTextOfNoProductMatchingWarningMessage() );
		Assert.fail();
	}

	@When("user do not enter any product name into the feild")
	public void user_do_not_enter_any_product_name_into_the_feild() {
	    
		homePage = new HomePage(driver);
		homePage.clicksOnSearchButton();
	}

}
