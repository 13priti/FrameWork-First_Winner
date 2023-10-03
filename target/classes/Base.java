package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	public Properties prop;            // Declared Globally so that can be used in all classes---

	@SuppressWarnings("deprecation") // Explained below--
	
	public WebDriver intializeDriver() throws IOException {

		prop = new Properties();
		String propPath = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		
        String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
	

	public String takeScreenshots(String testName,WebDriver driver ) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		return destinationFilePath;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
/*
 * The @SuppressWarnings("deprecation") annotation is used to suppress warnings
 * related to the use of deprecated methods or classes in Java. When you see
 * this annotation in your code, it means that the code is intentionally using a
 * method or class that has been marked as deprecated, and the annotation is
 * used to tell the compiler not to generate a warning for that specific usage.
 * 
 * Here's what each part of @SuppressWarnings("deprecation") means:
 * 
 * @SuppressWarnings: This is an annotation in Java used to instruct the
 * compiler to suppress specific warnings.
 * 
 * "deprecation": This is the argument provided to @SuppressWarnings. In this
 * case, it indicates that you want to suppress warnings related to the use of
 * deprecated elements in your code. Deprecated elements in Java are typically
 * methods or classes that are no longer recommended for use because they may
 * have been replaced with better alternatives or because they are considered
 * obsolete or potentially problematic. When you use a deprecated method or
 * class without suppression, the Java compiler generates a warning to alert you
 * to the potential issues.
 * 
 */
