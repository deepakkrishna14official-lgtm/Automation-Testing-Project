package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitUtility;

public class EmptyCartPage {
	
	private WebDriver driver;
	
	
	//=========== empty cart =======//

	private By CartEmptyState =
	By.cssSelector("[data-testid='cart-empty-state']");

	private By CartEmptyStateTitle =
	By.cssSelector("[data-testid='cart-empty-state-title']");


	private By CartStartShoppingLink =
	        By.cssSelector("[data-testid='cart-start-shopping-link']");


	//==================== Constructor ====================

	public EmptyCartPage(WebDriver driver) {
	    this.driver = driver;
	}
	
	//=========== Empty cart Page =========//


	public boolean isCartEmptyStateDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    CartEmptyState,
	                    10)
	            .isDisplayed();
	}

	public String getCartEmptyStateTitle() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    CartEmptyStateTitle,
	                    10)
	            .getText()
	            .trim();
	}

	public boolean isStartShoppingLinkDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    CartStartShoppingLink,
	                    10)
	            .isDisplayed();
	}


	public void clickStartShopping() {

	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    CartStartShoppingLink,
	                    10)
	            .click();
	}

}
