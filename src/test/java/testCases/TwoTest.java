package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;

	@Test
	public void testtwo() throws IOException, InterruptedException {
		System.out.println("We are in test two");

		driver = intializeDriver();
		driver.get("https://www.facebook.com/login.php");
		Thread.sleep(2000);
		
		Assert.assertTrue(false);

		
	}
	@AfterMethod
	public void closure() {
		driver.close();
	}
}
