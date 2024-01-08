package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropmenu;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBoxFeild;
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public void ClickOnMyAccount() {
		
		elementUtils = new ElementUtils(driver);
		elementUtils.clickOnElement(myAccountDropmenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//myAccountDropmenu.click();
	}
	
	public LoginPage clickOnLoginOption() {
		
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterOption() {
		
		elementUtils.clickOnElement(registerOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//registerOption.click();
		return new RegisterPage(driver);
	}

	public void enterProductIntoSearchBox(String ProductText) {
		
		elementUtils.typeTextIntoElement(searchBoxFeild, ProductText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		// searchBoxFeild.sendKeys(ProductText);
	}
	
	public SearchResultsPage clicksOnSearchButton() {
		
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//searchButton.click();
		return new SearchResultsPage(driver);
	}
}
