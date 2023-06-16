package parallel;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import maven.DriverFactory.DriverFactory;
import maven.util.ConfigReader;

public class AppHoks {
	
	WebDriver ldriver;
	ConfigReader configreader;
	Properties prop;
	DriverFactory driverFactory;
	String nameofbrowser;
	
	
	@Before(order=0)
public void init_properties() throws FileNotFoundException {
		
		configreader = new ConfigReader();
		prop=configreader.initialize_prop();
		 nameofbrowser =prop.getProperty("browser");
		
	}
	
	@Before(order=1)
	public void init_browser() {
		driverFactory = new DriverFactory();
		driverFactory.init_Driver(nameofbrowser);
		
	}
	
	@After(order=0)
	
	public void quict_browser() {
		
		driverFactory.getDriver().quit();
	}

	
	@After(order=1)
	
	public void getScrenshotiffail(Scenario sc) {
		if(sc.isFailed()) {
			
			String scenarioname =sc.getName().replaceAll(" ", "-");
			byte[] sourceofscrennshot=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourceofscrennshot, "img/png", scenarioname);
			
		}
		
	}
}
