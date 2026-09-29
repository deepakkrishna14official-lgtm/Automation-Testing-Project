package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollUtility {

    private ScrollUtility() {
        // utility class, no instances
    }

    /**
     * Scrolls the element into view using Selenium's native Actions
     * (moveToElement), no JavaScript involved.
     * Use this before clicking elements that may be below the fold
     * (e.g. tabs revealed only after scrolling).
     */
    public static WebElement scrollToElement(WebDriver driver, By locator, int timeoutInSeconds) {

        WebElement element =
                WaitUtility.waitForElementToBeVisible(driver, locator, timeoutInSeconds);

        new Actions(driver)
                .moveToElement(element)
                .perform();

        return element;
    }

    /**
     * Overload for when you already have a WebElement handle.
     */
    public static WebElement scrollToElement(WebDriver driver, WebElement element) {

        new Actions(driver)
                .moveToElement(element)
                .perform();

        return element;
    }

    /**
     * Scrolls to an element and clicks it once it's clickable.
     * Handy combo method for tabs/buttons that need scrolling first.
     */
    public static void scrollToElementAndClick(WebDriver driver, By locator, int timeoutInSeconds) {

        scrollToElement(driver, locator, timeoutInSeconds);

        WaitUtility
                .waitForElementClickable(driver, locator, timeoutInSeconds)
                .click();
    }

}
