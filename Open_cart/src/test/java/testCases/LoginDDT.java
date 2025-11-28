package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.Baseclass;
import utilities.Dataprovider;

public class LoginDDT extends Baseclass
{
	

	



		@Test(dataProvider="LoginData",dataProviderClass=Dataprovider.class)

		public void verify_loginDDT(String email, String password, String exp)

		{

			logger.info("**** Starting TC_003_LoginDDT *****");

			

			try {

		

			//Home page

				Homepage hp=new Homepage(driver);

				hp.clickMyAccount();

				hp.clickLogin(); //Login link under MyAccount

					

				//Login page

				LoginPage lp=new LoginPage(driver);

				lp.Email(email);

				lp.Pwd(password);

				lp.Login(); //Login button

					

				//My Account Page

				MyAccount macc=new MyAccount(driver);

				boolean targetPage=macc.isMyAccountExists();

				

				if(exp.equalsIgnoreCase("Valid"))

				{

					if(targetPage==true)

					{

						macc.logout();

						Assert.assertTrue(true);

					}

					else

					{

						Assert.assertTrue(false);

					}

				}

				

				if(exp.equalsIgnoreCase("Invalid"))

				{

					if(targetPage==true)

					{

						macc.logout();

						Assert.assertTrue(false);

					}

					else

					{

						Assert.assertTrue(true);

					}

				}

			}

			catch(Exception e)

			{

				Assert.fail("An exception occurred: " + e.getMessage());

			}

				

			logger.info("**** Finished TC_003_LoginDDT *****");

		}


}