package Pageclasses;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import maven.util.ConfigReader;

public class MavenLoginPage {
	
	Properties prop;
	ConfigReader configreader;
	
	
	WebDriver lDriver;
	
	
	public MavenLoginPage(WebDriver rdriver) {
		lDriver=rdriver;
		
		PageFactory.initElements(lDriver, this);
		
	}
	
	@FindBy(css="input[name=\"username\"]")
	private WebElement loginfield;	
	
	@FindBy(css="input[name=\"password\"]")
	private WebElement passwordfield;
	
	@FindBy(css="button[type=\"submit\"]")
	private WebElement loginbtn;
	
	
	public void doLogin() throws FileNotFoundException {
		configreader=new ConfigReader();
		prop=configreader.initialize_prop();
		loginfield.sendKeys(prop.getProperty("username"));
		passwordfield.sendKeys(prop.getProperty("password"));
		loginbtn.click();
		
	}

}
