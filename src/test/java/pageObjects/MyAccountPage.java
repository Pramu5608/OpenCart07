package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {

      super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement TxtMyAccount;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	
	public boolean TxtmyAccountDisplayed() {
		try {
		return (TxtMyAccount.isDisplayed());
		}
		catch(Exception e) {
			
			
			return false;
		}
		
	}
	public void clickLogout() {
		lnkLogout.click();
		}

}
