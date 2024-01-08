package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-email")
	private WebElement emailTextFeild;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextFeild;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageAboutCredentialsMismatch;
	
	public void enterEmailAddress(String emailAddressText) {
		
		elementUtils.typeTextIntoElement(emailTextFeild, emailAddressText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//emailTextFeild.sendKeys(emailAddressText);
	}
	
	public void enterPassword(String passwordText) {
		
		elementUtils.typeTextIntoElement(passwordTextFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordTextFeild.sendKeys(passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//loginButton.click();
		//we are creating the object in order to reduce the lines
		return new AccountPage(driver);
	}
	
	public String getWarningMessageOfCredentialsMismatch() {
		return elementUtils.getTextFromElement(warningMessageAboutCredentialsMismatch, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return warningMessageAboutCredentialsMismatch.getText();
	}

}
