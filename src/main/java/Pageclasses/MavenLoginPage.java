package Pageclasses;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven.util.ConfigReader;

public class MavenLoginPage  {
	
	Properties prop;
	ConfigReader configreader;
	FluentWaitHelper fluentWaitHelper;
	WebDriverwait webDriverwait;
	
	
	WebDriver lDriver;
	
	
	public MavenLoginPage(WebDriver rdriver) {
		lDriver=rdriver;
		
		PageFactory.initElements(lDriver, this);
		
		fluentWaitHelper = new FluentWaitHelper(lDriver);
		webDriverwait = new WebDriverwait(lDriver);
		
	}
	
	
	
	@FindBy(css="input[name=\"username\"]")
	private WebElement loginfield;	
	
	@FindBy(css="input[name=\"password\"]")
	private WebElement passwordfield;
	
	@FindBy(css="button[type=\"submitt\"]")
	private WebElement loginbtn;
	
	
	public void doLogin() throws IOException, InterruptedException {
		configreader=new ConfigReader();
		prop=configreader.initialize_prop();
		loginfield.sendKeys(prop.getProperty("username"));
		passwordfield.sendKeys(prop.getProperty("password"));
		fluentWaitHelper.fluentwait(loginbtn).click();
		
		
		//loginbtn.click();
		
	}

}
