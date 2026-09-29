package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import DrivesFactory.DriverFactory;
import Pages.LogInPage;
import Utilities.ConfigReader;
import Utilities.ScreenshotUtils;


public class BaseTest {
	 
	protected WebDriver driver;

	    protected ConfigReader config;

	    @BeforeMethod

	    public void setUp() {

	        config = new ConfigReader();

	        driver = DriverFactory.getDriver(
	                config.getProperty("browser"));

	        if (Boolean.parseBoolean(
	                config.getProperty("maximize"))) {

	            driver.manage().window().maximize();

	        }

	        driver.manage().timeouts().implicitlyWait(

	                Duration.ofSeconds(

	                        Long.parseLong(

	                                config.getProperty("implicitWait")

	                        )

	                )

	        );

	        driver.get("https://u2jawz-o044rhvzc-arcadawebapps2.vercel.app/");
	        
	    
	        
	        
	  

     
	    }

	    @AfterMethod

	    public void tearDown(ITestResult result) {

	    	 if (driver != null) {
	    		 
	             if (result.getStatus() == ITestResult.FAILURE) {
	  
	                 String testName = result.getMethod().getMethodName();
	  
	                 ScreenshotUtils.captureScreenshot(driver, testName);
	             }

	            driver.quit();

	        }

	    }

 }


