package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
 
	WebDriver driver;
	public AccountCreatedPage(WebDriver driver) {
		this.driver =driver;
		
	PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath = "//*[@class='breadcrumb']//a[text()='Success']")
	private WebElement SuccessDisplay;

  
    public WebElement SuccessDisplay() {
    	return SuccessDisplay;
    }
    

    
    
    
} 
