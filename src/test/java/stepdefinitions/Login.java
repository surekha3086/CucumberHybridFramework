package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	@Given("User navigate to login feature")
	public void user_navigate_to_login_feature() {
		
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.ClickOnMyAccount();
		loginPage = homePage.clickOnLoginOption(); 
	}
	
	@When("^User enter the valid email address (.+) into the feild$")
	public void user_enter_the_valid_email_address_into_the_feild(String emailAddressText) {
	    
		loginPage.enterEmailAddress(emailAddressText);
	}

	@And("^User entered the valid password (.+) into the feild$")
	public void user_entered_the_valid_password_into_the_feild(String passwordText) {
	    
		loginPage.enterPassword(passwordText);
	}

	@And("User click on login button")
	public void user_click_on_login_button() {
	    
		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should logged in successfully")
	public void user_should_logged_in_successfully() {

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformation());
	}

	@When("User enter the invalid email address into the feild")
	public void user_enter_the_invalid_email_address_into_the_feild() {
		
		commonUtils = new CommonUtils();
	    loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
	}

	@And("User entered the invalid password {string} into the feild")
	public void user_entered_the_invalid_password_into_the_feild(String invalidPasswordText) {
		
	    loginPage.enterPassword(invalidPasswordText);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	   
		Assert.assertTrue(loginPage.getWarningMessageOfCredentialsMismatch().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter any credentials into the feilds")
	public void user_dont_enter_any_credentials_into_the_feilds() {
	   
		loginPage.enterEmailAddress("");
		loginPage.enterEmailAddress("");
		
	}
	
}
