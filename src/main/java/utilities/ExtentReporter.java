package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

static	ExtentReports extent;             //Globally declaration of ExtentReports so that can be used in all methods

	public static ExtentReports createExtentReport() {
		
		String epFormationPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";  //path of new folder creation and file name into it
		
		ExtentSparkReporter SparkReporter = new ExtentSparkReporter(epFormationPath);  // Create ExtentSparkReporter Object    
		SparkReporter.config().setReportName("TutorialsNinja Login Page Automation Results");
		SparkReporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();                             // Create ExtentReports Object
		extent.attachReporter(SparkReporter);                     // Attach the reporter to the ExtentReports instance
		extent.setSystemInfo("Operating System","Windows 11");
		extent.setSystemInfo("Tested By","Priti Pandey");
		
		return extent;   
		
}
}
