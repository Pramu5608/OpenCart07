package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"master","sanity"})
	public void verify_Login() {
		try {
		HomePage hp = new HomePage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();
		
		loginPage lp = new loginPage(driver);
		lp.Setemail(p.getProperty("email"));
		lp.Setpassword(p.getProperty("password"));
		lp.clickbtnLogin();
		
		MyAccountPage Myp = new MyAccountPage(driver);
		
		boolean targetPage = Myp.TxtmyAccountDisplayed();
		
		Assert.assertEquals(targetPage, true,"login failed");
		
		//or
		//Assert.assertTrue(targetPage);
		//or
//		if(Myp.TxtmyAccountDisplayed()) {
//			Assert.assertTrue(true);
//		}
//		else {
//			
//			Assert.assertTrue(false);
//		}
		}
		catch(Exception e) {
			Assert.fail();
		}
	}

}
