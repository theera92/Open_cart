package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Regpage;
import testBase.Baseclass;

public class Testcase extends Baseclass {
	@Test(groups= {"Regression","Master"})
	public void verify_acc_page()
	{

logger.info("***** Starting TC001_AccountRegistrationTest  ****");
logger.debug("This is a debug log message");
try
{
		Homepage h=new Homepage(driver);
		h.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		h.clickRegister();
		logger.info("Clicked on Register Link.. ");
		Regpage Regpage=new Regpage(driver);
		logger.info("Providing customer details...");
		Regpage.setFirstName(randomeString().toUpperCase());
		Regpage.setLastName(randomeString().toUpperCase());
		Regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		Regpage.setTelephone(randomeNumber());

		String password=randomAlphaNumeric();

		Regpage.setPassword(password);
		Regpage.setConfirmPassword(password);

	Regpage.setPrivacyPolicy();
		Regpage.clickContinue();
		logger.info("Validating expected message..");

		String confmsg=Regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("Test passed");
}
catch (Exception e)
{
logger.error("Test failed: " + e.getMessage());
Assert.fail("Test failed: " + e.getMessage());
}    
finally
{
logger.info("***** Finished TC001_AccountRegistrationTest *****");
}

}

}
