package Runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@test", 
features = "./src/test/resources/parallel",
glue = "parallel",
monochrome =true,
dryRun =false,
plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)



public class RunnerJunit {
	
	
	

}
