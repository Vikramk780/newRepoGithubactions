package Pageclasses;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitHelper {
	
	WebDriver driver;
	
	public FluentWaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement fluentwait(WebElement ele) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);

	WebElement ele2=wait.until(ExpectedConditions.elementToBeClickable(ele));
	return ele2;
	}

}
