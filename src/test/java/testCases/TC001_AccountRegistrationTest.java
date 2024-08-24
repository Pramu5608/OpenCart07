package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"regression","master"})
	public void verify_account_registration() {
		logger.info("*********testStarted******");
		try {
		
		HomePage hp = new HomePage(driver);
		logger.info("*********clickMyAccount******");
		hp.clickMyAccount();
		logger.info("*********clickMyAccount******");
		hp.clickRegister();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString());
		regpage.setLastName(randomeString());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		String Password = randomeAlphaNumeric();
		
		regpage.setPassword(Password);
		regpage.setConfirmPassword(Password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		String confmsg = regpage.getConfirmationMsg();
		logger.info("*********Validation******");
		if(confmsg.equals("Your Account Has Been Created!")) 
		{
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("Test failed");
			logger.debug("Debugg...");
			Assert.assertTrue(false);
			
		}
		
		
	
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}

}
