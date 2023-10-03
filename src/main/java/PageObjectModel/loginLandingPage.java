package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginLandingPage {
	WebDriver driver;

	public loginLandingPage(WebDriver driver) { // Constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@Title='My Account']")    //Object for My Account
	private WebElement myAccountDropdown;

	@FindBy(xpath = "//a[text() = 'Login']")      //Object for Login Option
	private WebElement LoginOption;
	
	
	
	
 
	public WebElement myAccountDropdown() {      //Method for My Account
		return myAccountDropdown;
	}
	public WebElement LoginOption() {           // Method for Login Option
		return LoginOption;
	}
	
}
