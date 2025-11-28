package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	WebDriver driver;

	public Basepage(WebDriver driver)//parent class
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
}
