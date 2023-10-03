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

import PageObjectModel.UserAccountPage;
import PageObjectModel.loginLandingPage;
import PageObjectModel.LoginPage;
import Resources.Base;

public class NinjaLoginTest extends Base {
	public WebDriver driver;               //global and public 
	Logger log;

	@BeforeMethod
	public void SetUp() throws IOException {
		
		log = LogManager.getLogger(NinjaLoginTest.class.getName());  // intializing log method--
		
		driver = intializeDriver();                  // as Base class is now parent class of NinjaLogin so we can extend
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	
	@Test(dataProvider = "LoginData")                               // connected this dataProvider with test method
	public void LoginTestCases(String email, String pswrd, String expectedResult) throws IOException {

		loginLandingPage landingpage = new loginLandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingpage.LoginOption().click();
		log.debug("Clicked on Login");

		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.EmailAddress().sendKeys(email);
		log.debug("Email addressed got entered");
		LoginPage.Password().sendKeys(pswrd);
		log.debug("Password got entered");
		LoginPage.LoginButton().click();
		log.debug("Clicked on Login Button");

		UserAccountPage AccountPage = new UserAccountPage(driver);
		String actual_Result = null;
		try {
			if (AccountPage.Edityouraccountinformation().isDisplayed()) {
				
				log.debug("User got logged in");
				actual_Result = "Successfull";
			}
		} catch (Exception e) {
			actual_Result = "Failure";
			 log.debug("User didn't got logged in");
		}
		Assert.assertEquals(actual_Result, expectedResult);
         log.info("Login Test got Passed");
	}

	@AfterMethod
	public void CloseTab() {
		log.debug("Browser got closed");
		driver.close();
	}

	@DataProvider
	public Object[][] LoginData() {
		Object[][] data = { { "priti13234@gmail.com", "@first123", "Failure" },
				{ "babysitting@gmail.com", "12345", "Successfull" } };
		return data;
	}

}
