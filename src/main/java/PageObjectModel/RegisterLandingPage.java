package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterLandingPage {

	WebDriver driver;
	public RegisterLandingPage(WebDriver driver) {
		this.driver = driver;
		
 PageFactory.initElements(driver,this);		
		
	}
	@FindBy(xpath = "//a[@Title='My Account']")    //Object for My Account
	private WebElement myAccountDropdown;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement RegisterOption;
	
	public WebElement myAccountDropdown() {      //Method for My Account
		return myAccountDropdown;
	}
	public WebElement RegisterOption () {           // Method for Login Option
		return RegisterOption;
	}
	
	
}

