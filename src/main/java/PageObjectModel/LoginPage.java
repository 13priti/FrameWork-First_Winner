package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement EmailAddress;

	@FindBy(id = "input-password")
	private WebElement Password;

	@FindBy(css = "input[value = 'Login']")
	private WebElement LoginButton;

	public WebElement EmailAddress() {
		return EmailAddress;
	}

	public WebElement Password() {
		return Password;
	}

	public WebElement LoginButton() {
		return LoginButton;
	}

}
