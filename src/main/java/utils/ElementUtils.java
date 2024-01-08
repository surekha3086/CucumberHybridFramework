package utils;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	private Alert alert;
	
	public ElementUtils(WebDriver driver) {
		
		this.driver = driver;
	}
	 
	public void clickOnElement(WebElement element, long durationInSecends) {
				 
		 WebElement webElement = waitForElement(element, durationInSecends);
		 webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
		
	}
	
	public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(element);
		select.selectByVisibleText(dropDownOption);
		
	}

	public void acceptAlert(long durationInSeconds ) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
		
	}
	
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		
		WebElement webElement  = waitForVisibilityOfElement(element, durationInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = null;
		try {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	public void javaScriptClick(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeAsyncScript("arguments[0].click();", webElement);
	}
	
	public void javaScriptType(WebElement element, long durationInSeconds, String TypeInText) {
		
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeAsyncScript("arguments[0].value = '"+TypeInText+"'", webElement);
		
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
		
		try {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		return webElement.isDisplayed();
		} catch (Throwable e) {
			return false;
		}
		
	}
}
