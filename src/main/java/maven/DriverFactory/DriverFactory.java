package maven.DriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver =new ThreadLocal<WebDriver>();
	
	public WebDriver init_Driver(String browser) {
		
		System.out.println("Hey buddy your are using "+browser+" browser");
		
		if(browser.equals("chrome")) {

                         WebDriverManager.chromedriver().setup();
	    WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

			
			
		}else if(browser.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}else {
			System.out.println("Hey buddy you have to use proper browser");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	

}
