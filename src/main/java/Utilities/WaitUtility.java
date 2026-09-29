package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public static WebElement waitForElementToBeVisible
	(WebDriver driver, By locator, int timeoutInSeconds) {
		
	WebDriverWait wait = 
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForElementClickable(
	            WebDriver driver, By locator, int seconds) {

	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(seconds));

	        return wait.until(
	                ExpectedConditions.elementToBeClickable(locator));
	    }
	
	   public static boolean waitForElementPresent(
	            WebDriver driver, By locator, int seconds) {

	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(seconds));

	        try {
	            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	            return true;
	        } catch (TimeoutException e) {
	            return false;
	        }
	    }

	    public static boolean waitForUrlContains(
	            WebDriver driver, String url, int seconds) {

	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(seconds));

	        return wait.until(
	                ExpectedConditions.urlContains(url));
	    }
	    
	    
	    
	    public static WebElement waitForAttributeValue(
	            WebDriver driver,
	            By locator,
	            String attribute,
	            String expectedValue,
	            int timeout) {

	        WebDriverWait wait =
	                new WebDriverWait(
	                        driver,
	                        Duration.ofSeconds(timeout)
	                );

	        wait.until(
	                ExpectedConditions.attributeToBe(
	                        locator,
	                        attribute,
	                        expectedValue
	                )
	        );

	        return driver.findElement(locator);
	    }
	    
	    public static WebElement waitForAttributeToBe(
	            WebDriver driver,
	            By locator,
	            String attribute,
	            String value,
	            int timeout) {

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	        
	        // Wait for the attribute condition to be true
	        wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
	        
	        // Return the element once verified
	        return driver.findElement(locator);
	    }
	    
	    

}
