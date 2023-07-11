package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverwait {
	
	WebDriver driver;
	
	public WebDriverwait(WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	
	public WebElement WebDriverwaitt(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement ele2 =wait.until(ExpectedConditions.visibilityOf(ele));
		return ele2;
	}

}
