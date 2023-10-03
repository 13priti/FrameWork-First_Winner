package StepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjectModel.AccountCreatedPage;
import PageObjectModel.RegisterLandingPage;
import PageObjectModel.RegisterPage;
import Resources.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register extends Base {
	WebDriver driver;
	RegisterLandingPage RegisterLandingPage;
	RegisterPage RegisterPage;
	AccountCreatedPage AccountCreatedPage;


	@Given("^User open browser$")
	public void nvaigatingBrowser() throws IOException {
		driver = intializeDriver();
	}

	@And("^User navigates to Application Registration page$")
	public void navigationToRegistration() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		RegisterLandingPage = new RegisterLandingPage(driver);
		RegisterLandingPage.myAccountDropdown().click();
		RegisterLandingPage.RegisterOption().click();

		Thread.sleep(3000);
	}

	@When("^User provides the following details into the input fields$")
	public void credentials(DataTable data) {
		Map<String, String> dataMap = data.asMap(String.class, String.class);

		RegisterPage = new RegisterPage(driver);
		RegisterPage.Firstname().sendKeys(dataMap.get("firstname"));
		RegisterPage.Lastname().sendKeys(dataMap.get("lastname"));
		RegisterPage.Emailid().sendKeys(dataMap.get("emailid"));
		RegisterPage.Telephone().sendKeys(dataMap.get("telephone"));
		RegisterPage.Password().sendKeys(dataMap.get("password"));
		RegisterPage.confirmPassword().sendKeys(dataMap.get("Confirmpassword"));
	}

	@And("^User select the privacy policy option$")
	public void privacyPolicy() {
		RegisterPage.privacyPolicy().click();
	}

	@And("^Clicks on Continue button$")
	public void continuation() {
		RegisterPage.Continue().click();
	}

	@Then("^Verify user already registered or not$")
	public void Registration() {
		AccountCreatedPage = new AccountCreatedPage(driver);
		
		String actual_Result = null;
		try {
			if( AccountCreatedPage.SuccessDisplay().isDisplayed()){
			     actual_Result = "Account Registered Successfully!";
				
			}
		} catch (Exception e) {
			actual_Result = "Account already Registered!";
			System.out.println("Account already Registered!");
		} 
		
		Assert.assertNotNull(actual_Result, "test Pass");
		

	}

	@After("@Register")
	public void closure() {
		driver.close();
	} 

}
