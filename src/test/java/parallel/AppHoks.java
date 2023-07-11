package parallel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
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
	
	public void getScrenshotiffail(Scenario sc) throws IOException {
		if(sc.isFailed()) {
			
			
//			TakesScreenshot ts = (TakesScreenshot) driverFactory.getDriver();
//			
//			File screen =ts.getScreenshotAs(OutputType.FILE);
//			File storage = new File("C:\\CodStudio\\ParallelBlog\\src\\test\\resources\\Screnshotss\\newiqsmage.png");
//			FileUtils.copyFile(screen, storage);
			
			String scenarioName = sc.getName().replaceAll(" ", "-");
			TakesScreenshot ts = (TakesScreenshot) driverFactory.getDriver();

			// Capture the screenshot as Base64 string
			String sourceOfScreenshot = ts.getScreenshotAs(OutputType.BASE64);

			// Attach the screenshot as an image
			byte[] screenshotBytes = Base64.getDecoder().decode(sourceOfScreenshot);
			sc.attach(screenshotBytes, "image/png", scenarioName);
			
		}
		
	}
}
