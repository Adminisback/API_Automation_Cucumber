package cucumberOptions_TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Cucumber_Features",plugin="json:target/jsonReports/cucumber-report.json", glue= {"Cucumber_StepDefinitions"})
public class Test_Runner {

	//,tags= "@deletePlace"
}
