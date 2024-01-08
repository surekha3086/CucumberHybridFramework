package hooks;

import java.util.Properties;
import io.cucumber.java.After;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	
	static WebDriver driver;
	private static ConfigReader configReader;
	
	@Before
	public static void setup() {

		configReader = new ConfigReader();
        Properties prop = configReader.initilizsProperties();
        driver = DriverFactory.initilizeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url")); 

	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName = scenario.getName().replace(" ", "_");
		
		if(scenario.isFailed()) {
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "img/png", scenarioName);
		}
		driver.quit();
	}

}
