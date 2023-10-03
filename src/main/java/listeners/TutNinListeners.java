package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import utilities.ExtentReporter;

public class TutNinListeners extends Base implements ITestListener {
	WebDriver driver = null;
	ExtentReports ext_repo = ExtentReporter.createExtentReport(); // declared globally so that can be used by all
																	// methods

	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	ExtentTest Extent_test;                        // declared globally so that can be used by all methods

	@Override
	public void onTestStart(ITestResult result) {
		String NameofTest = result.getName();
		Extent_test = ext_repo.createTest(NameofTest);
		extentTestThread.set(Extent_test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String NameofTest = result.getName();
		// Extent_test.log(Status.PASS, NameofTest+" is Successfully Pass");
		extentTestThread.get().log(Status.PASS, NameofTest + " is Successfully Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();

		// Extent_test.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// takeScreenshots(testName, driver);
			String ScreenshotPath = takeScreenshots(testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(ScreenshotPath, "FailedScenario");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		ext_repo.flush();
	}

}