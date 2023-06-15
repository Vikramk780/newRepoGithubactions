package Runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@test", features = "./src/test/resources/parallel", glue = "parallel")



public class RunnerJunit {
	
	
	

}
