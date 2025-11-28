package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;

import pageObjects.MyAccount;
import testBase.Baseclass;

public class LoginTC extends Baseclass {
	 
	

	@Test(groups= {"Sanity","Master"})

	public void verify_login()
	{
	logger.info("**** Starting TC_002_LoginTest  ****");
	logger.debug("capturing application debug logs....");
	try
	{
	//Home page
	Homepage hp=new Homepage(driver);
	hp.clickMyAccount();
	logger.info("clicked on myaccount link on the home page..");
	hp.clickLogin(); //Login link under MyAccount
	logger.info("clicked on login link under myaccount..");

	//Login page
	LoginPage lp=new LoginPage(driver);
	logger.info("Entering valid email and password..");
	lp.Email(p.getProperty("Email"));
	lp.Pwd(p.getProperty("Pwd"));
	lp.Login(); //Login button
	logger.info("clicked on login button..");

	//My Account Page
	MyAccount macc=new MyAccount(driver);

	boolean targetPage=macc.isMyAccountExists();

	Assert.assertEquals(targetPage, true,"Login failed");
	}
	catch(Exception e)
	{
	Assert.fail();
	}

	logger.info("**** Finished LoginTC  ****");
	}
	}



