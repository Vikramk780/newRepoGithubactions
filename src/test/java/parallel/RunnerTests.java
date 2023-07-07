package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(tags = "@test", features = "./src/test/resources/parallel", glue = "parallel", //this parallel relavant to applicationhooks
monochrome =true,
dryRun =false,
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"


		
		
})
public class RunnerTests extends AbstractTestNGCucumberTests {
   @Override
   @DataProvider(parallel = true )
   public Object[][] scenarios() {
   return super.scenarios();
   }
}
