package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(tags = "@test", features = "./src/test/resources/parallel", glue = "parallel")
public class RunnerTests extends AbstractTestNGCucumberTests {
   @Override
   @DataProvider(parallel = false)
   public Object[][] scenarios() {
   return super.scenarios();
   }
}