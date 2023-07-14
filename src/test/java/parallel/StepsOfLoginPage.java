package parallel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import Pageclasses.MavenLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import maven.DriverFactory.DriverFactory;
import maven.util.ConfigReader;

public class StepsOfLoginPage {
	
	Properties prop;
	ConfigReader configreader;
	WebDriver lDriver;
	Pageclasses.MavenLoginPage mavenLoginPage;
	DriverFactory driverFactory;
	
	
	@Given("user visits hrm website")
	public void user_visits_hrm_website() throws FileNotFoundException {
		prop =new Properties();
		
		configreader=new ConfigReader();
		
		prop=configreader.initialize_prop();
		
		driverFactory=new DriverFactory();
//		driverFactory.init_Driver(prop.getProperty("browser"));
		driverFactory.getDriver().get(prop.getProperty("website"));
		
	}

	@Then("User logs in to app")
	public void user_logs_in_to_app() throws IOException, InterruptedException {
		mavenLoginPage=new MavenLoginPage(DriverFactory.getDriver());
		mavenLoginPage.doLogin();
		String title=driverFactory.getDriver().getTitle();
	//Assert.assertEquals(title,"OrangeHRma");
		
		SoftAssert a = new SoftAssert();
		a.assertEquals(title, "OrangeHRm");
		driverFactory.getDriver().quit();
	}
	
//	@Then("Title should be {string}")
//	public void title_should_be(String string) {
//		
//	}
}
