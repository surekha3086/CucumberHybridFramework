package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameFeild;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameFeild;
	
	@FindBy(id = "input-email")
	private WebElement emailAddressFeild;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneFeild;
	
	@FindBy(id = "input-password")
	private WebElement passwordFeild;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordFeild;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageAboutDuplicateEmail;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public void enterFirstNameFeild(String firstNameText) {
		
		elementUtils.typeTextIntoElement(firstNameFeild, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//firstNameFeild.sendKeys(firstNameText);
	}
	
	public void enterLastNameFeild(String lastNameText) {
		
		elementUtils.typeTextIntoElement(lastNameFeild, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//lastNameFeild.sendKeys(lastNameText);
	}
	
    public void enterEmailFeild(String emailAddressText) {
		
    	elementUtils.typeTextIntoElement(emailAddressFeild, emailAddressText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//emailAddressFeild.sendKeys(emailAddressText);
	}
	
    public void enterTelephoneFeild(String telephoneText) {
		
    	elementUtils.typeTextIntoElement(telephoneFeild, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//telephoneFeild.sendKeys(telephoneText);
	}
    
    public void enterPasswordFeild(String passwordText) {
		
    	elementUtils.typeTextIntoElement(passwordFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//passwordFeild.sendKeys(passwordText);
	}
    
    public void enterConfirmPasswordFeild(String confirmPasswordText) {
		
    	elementUtils.typeTextIntoElement(confirmPasswordFeild, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//confirmPasswordFeild.sendKeys(confirmPasswordText);
	}
    
    public void selectPrivacyPolicyCheckbox() {
    	
    	elementUtils.clickOnElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//privacyPolicyCheckbox.click();
    }
    
    public AccountSuccessPage clicksOnContiueButton() {
    	
    	elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//continueButton.click();
    	return new AccountSuccessPage(driver);
    }
    
    public String getTextOfwarningMessageAboutDuplicateEmail() {
    	
    	return elementUtils.getTextFromElement(warningMessageAboutDuplicateEmail, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//return warningMessageAboutDuplicateEmail.getText();
    }
    
    public String getTextOfFirstNameWarning() {
    	
    	return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//return firstNameWarning.getText();
    }
    
    public String getTextOfLastNameWarning() {
    	
    	return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//return lastNameWarning.getText();
    }
    
    public String getTextOfEmailWarning() {
    	
    	return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//return emailWarning.getText();
    }
    
    public String getTextOfTelephoneWarning() {
    	
    	return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//return telephoneWarning.getText();
    }
    
    public String getTextOfPasswordWarning() {
    	
    	return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	//return passwordWarning.getText();
    }
}
