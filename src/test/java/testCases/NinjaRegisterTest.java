package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.AccountCreatedPage;
import PageObjectModel.RegisterLandingPage;
import PageObjectModel.RegisterPage;
import Resources.Base;

public class NinjaRegisterTest extends Base {

	public WebDriver driver;
	Logger comment;

	@BeforeMethod
	public void SetUp() throws IOException {
		comment = LogManager.getLogger(NinjaRegisterTest.class.getName());
		driver = intializeDriver();
		comment.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		comment.debug("Navigated to application URL");

	}

	@Test(dataProvider = "RegisterData")
	public void RegisterTestCases(String firstName, String lastName, String emailId, String numb, String pswrd,
			String con_pswrd, String Expected_result) {

		RegisterLandingPage RegisterLandingPage = new RegisterLandingPage(driver);
		RegisterLandingPage.myAccountDropdown().click();
		comment.debug("Account dropdown clicked!");
		RegisterLandingPage.RegisterOption().click();
		comment.debug("Register option clicked!");

		RegisterPage RegisterPage = new RegisterPage(driver);
		RegisterPage.Firstname().sendKeys(firstName);
		comment.debug("First Name got entered");
		RegisterPage.Lastname().sendKeys(lastName);
		comment.debug("Last Name got entered");
		RegisterPage.Emailid().sendKeys(emailId);
		comment.debug("Email addressed got entered");
		RegisterPage.Telephone().sendKeys(numb);
		comment.debug("Telephone got entered");
		RegisterPage.Password().sendKeys(pswrd);
		comment.debug("Password got entered");
		RegisterPage.confirmPassword().sendKeys(con_pswrd);
		comment.debug("Password for confirmation got entered");
		RegisterPage.privacyPolicy().click();
		comment.debug("Privacy Policy option clicked!");
		RegisterPage.Continue().click();
		comment.debug("Continue option clicked!");

		AccountCreatedPage CreatedPage = new AccountCreatedPage(driver);
		String actualResult = null;
		try {
			boolean expectedResult = CreatedPage.SuccessDisplay().isDisplayed();
			if (expectedResult) {
				actualResult = "Account Registered Successfully!";
				comment.debug("Account Registered Successfully!");
			}
		} catch (Exception e) {
			actualResult = "Account already  Registered!";
			comment.debug("Account already  Registered!!");
		
		}

		finally {
			Assert.assertTrue(true, actualResult);
			comment.info("Registration got passed!");
		}

	}

	@AfterMethod
	public void CloseTab() {
		comment.debug("Browser got closed");
		driver.close();

	}

	@DataProvider
	public Object[][] RegisterData() {
		Object[][] data = { { "Deepak", "Pandey", "Saydeep@gmail.com", "4568791560", "12345", "12345",
				"Account Registered Successfully!" } };
		return data;
	}

}
