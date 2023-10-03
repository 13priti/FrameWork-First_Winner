package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement Firstname;

	@FindBy(id = "input-lastname")
	private WebElement Lastname;

	@FindBy(id = "input-email")
	private WebElement Emailid;

	@FindBy(id = "input-telephone")
	private WebElement Telephone;

	@FindBy(id = "input-password")
	private WebElement Password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement Continue;

	public WebElement Firstname() {
		return Firstname;
	}

	public WebElement Lastname() {
		return Lastname;
	}

	public WebElement Emailid() {
		return Emailid;
	}

	public WebElement Telephone() {
		return Telephone;
	}

	public WebElement Password() {
		return Password;
	}

	public WebElement confirmPassword() {
		return confirmPassword;
	}

	public WebElement privacyPolicy() {
		return privacyPolicy;
	}
    public WebElement Continue() {
    	return Continue;
    }
}
