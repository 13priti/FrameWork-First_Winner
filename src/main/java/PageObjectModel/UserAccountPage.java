package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {
	
	WebDriver driver;
	
	public  UserAccountPage(WebDriver driver) {
		this.driver = driver;
		
	PageFactory.initElements(driver,this);	
		
	}
	
	@FindBy(linkText="Edit your account information")
	 private WebElement Edityouraccountinformation;
	
	
	
	public WebElement Edityouraccountinformation() {
		return Edityouraccountinformation;
	}

}
