package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions
		(		tags="@Overall",
				features= {"src\\test\\resources\\Feature"},
				glue= {"StepDefination"},
				dryRun = false,
				monochrome=true,
				plugin= {"pretty","html:target/Htmlreport.html",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class OrangeTestrunner extends AbstractTestNGCucumberTests {

}