package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjectModel.LoginPage;
import PageObjectModel.UserAccountPage;
import PageObjectModel.loginLandingPage;
import Resources.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Base {
	
	WebDriver driver;
	loginLandingPage landingpage;
	LoginPage LoginPage;
	UserAccountPage UserAccountPage;
	
	
	@Given("^User open any browser$")
	public void nvaigatingBrowser() throws IOException {
		driver = intializeDriver();
}
	@And("^User navigates to Application Login page$")
	public void navigation_to_LoginPage() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		landingpage = new loginLandingPage(driver);
		landingpage.myAccountDropdown().click();
		landingpage.LoginOption().click();

		Thread.sleep(2000);
		}
	@When("^User enters username as ([^\"]*) and password as ([^\"]*) into the fields$")
	public void credentials(String username, String password) {

		LoginPage = new LoginPage(driver);
		LoginPage.EmailAddress().sendKeys(username);
		LoginPage.Password().sendKeys(password);
	}
	
	@And("^User clicks on Login button$")
	public void Clicks_Login_button() {
		LoginPage.LoginButton().click();
	}
	
	@Then("^Verify user should be able to Login based upon ([^\"]*) login status$")
	public void Successful_Login(String expected_result) {
	    UserAccountPage = new UserAccountPage(driver);
	    String actual_Result = null;
		try {
			if (UserAccountPage.Edityouraccountinformation().isDisplayed()) {
				actual_Result = "Success";
			}
		} catch (Exception e) {
			actual_Result = "Failure";
	}
		Assert.assertEquals(actual_Result,expected_result);
	
	}
	
	@After("@Login")
	public void closure() {
		driver.close();
	}
	
	
	
	
}
