package testNGTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue="pageStepDefinitions",monochrome=false, dryRun=false,
		plugin= {"pretty", //"html:target/Cucumber.html","json:target/Cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunner extends AbstractTestNGCucumberTests{
	
}
 