package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource/features",
                 glue = {"stepdefinitions", "hooks"},                
                 //to generate the report on cloud 
                 publish = true,
                 tags = "@testcases",
                 plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html"}
                 )
public class TestRunner {
	

}
