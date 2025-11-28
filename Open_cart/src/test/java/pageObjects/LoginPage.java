package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {
    public LoginPage(WebDriver driver)
	{
	super(driver);
	}
   
    @FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	
	public void Email(String email) {
		txtemail.sendKeys(email);

		}

		public void Pwd(String pwd) {
		txtPwd.sendKeys(pwd);

		}

		public void Login() {
		login.click();

		}

	
}
