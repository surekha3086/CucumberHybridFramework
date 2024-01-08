package stepdefinitions;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register{
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("User navigate to register account page")
	public void user_navigate_to_register_account_page() {

	    driver = DriverFactory.getDriver();
	    HomePage homePage = new HomePage(driver);
	    homePage.ClickOnMyAccount();
	    registerPage = homePage.clickOnRegisterOption();
		
	}

	@When("User enters the below feilds")
	public void user_enters_the_below_feilds(DataTable dataTable) {
		
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		//we dont need to create the object since the object is already created on homepage it will returns registration page
		//registerPage = new RegisterPage(driver);
		registerPage.enterFirstNameFeild(map.get("firstName"));
		registerPage.enterLastNameFeild(map.get("lastName"));
		//In order to make the commonUtils page non static we have create object in the places where it is implemented 
		commonUtils = new CommonUtils();
		registerPage.enterEmailFeild(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephoneFeild(map.get("telephone"));
		registerPage.enterPasswordFeild(map.get("password"));
		registerPage.enterConfirmPasswordFeild(map.get("confirmpassword"));
		
	}
	
	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
	   
	   registerPage.selectPrivacyPolicyCheckbox();
	}
	
	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {

		accountSuccessPage = registerPage.clicksOnContiueButton();
	}
	
	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
				
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
		
	}
	
	@When("User enters the below feilds with duplicate email")
	public void user_enters_the_below_feilds_with_duplicate_email(DataTable dataTable) {
		
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstNameFeild(map.get("firstName"));
		registerPage.enterLastNameFeild(map.get("lastName"));
		registerPage.enterEmailFeild(map.get("email"));
		registerPage.enterTelephoneFeild(map.get("telephone"));
		registerPage.enterPasswordFeild(map.get("password"));
		registerPage.enterConfirmPasswordFeild(map.get("confirmpassword"));
		
	}

	
	@Then("User should get a proper warning message about duplicate email")
	public void user_should_get_a_proper_warning_message_about_duplicate_email() {
	    
		Assert.assertTrue(registerPage.getTextOfwarningMessageAboutDuplicateEmail().contains("Warning: E-Mail Address is already registered!"));
		
	}

	@When("User dont enter any account details")
	public void user_dont_enter_any_account_details() {
		
		registerPage.enterFirstNameFeild("");
		registerPage.enterLastNameFeild("");
		registerPage.enterEmailFeild("");
		registerPage.enterTelephoneFeild("");
		registerPage.enterPasswordFeild("");
		registerPage.enterConfirmPasswordFeild("");
		
	}

	@Then("User should get proper warning message for every mandatory feild")
	public void user_should_get_proper_warning_message_for_every_mandatory_feild() {
	   
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getTextOfFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getTextOfLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getTextOfEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTextOfTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getTextOfPasswordWarning());
	}

}
