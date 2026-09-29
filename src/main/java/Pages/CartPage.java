package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitUtility;

public class CartPage {
	
	private WebDriver driver;
	

private By CartPage =
        By.cssSelector("[data-testid='cart-page']");

private By CartHeading =
        By.cssSelector("[data-testid='cart-heading']");

private By CartItemCount =
        By.cssSelector("[data-testid='cart-item-count']");

private By CartItemList =
By.cssSelector("[data-testid='cart-item-list']");

private By CartItems =
By.cssSelector("article[data-testid^='cart-item-']");

private By getCartItemTitleLocator(String productId) {
    return By.cssSelector(
            "[data-testid='cart-item-title-" + productId + "']"
    );
}

private By getCartItemPriceLocator(String productId) {
    return By.cssSelector(
            "[data-testid='cart-item-price-" + productId + "']"
    );
}

private By CartPriceSummary =
By.cssSelector("[data-testid='cart-price-summary']");

private By CartSummaryMrp =
By.cssSelector("[data-testid='cart-summary-mrp']");

private By CartSummaryDiscount =
By.cssSelector("[data-testid='cart-summary-discount']");

private By CartSummaryShipping =
By.cssSelector("[data-testid='cart-summary-shipping']");

private By CartSummaryTotal =
By.cssSelector("[data-testid='cart-summary-total']");

private By ProceedToCheckoutButton =
By.cssSelector("[data-testid='proceed-to-checkout-button']");

private By CartSummarySavings =
By.cssSelector("[data-testid='cart-summary-savings']");

//=========== Quantity Control ========//

private By getCartQuantityStepperLocator(String productId) {

    return By.cssSelector(
            "[data-testid='cart-qty-stepper-" + productId + "']"
    );
}

private By getCartQuantityDecreaseLocator(String productId) {

    return By.cssSelector(
            "[data-testid='cart-qty-decrease-" + productId + "']"
    );
}

private By getCartQuantityValueLocator(String productId) {

    return By.cssSelector(
            "[data-testid='cart-qty-value-" + productId + "']"
    );
}

private By getCartQuantityIncreaseLocator(String productId) {

    return By.cssSelector(
            "[data-testid='cart-qty-increase-" + productId + "']"
    );
}

//========= move and delete items ========//

private By getSaveForLaterLocator(String productId) {

    return By.cssSelector(
            "[data-testid='cart-save-for-later-" + productId + "']"
    );
}

private By getMoveToWishlistLocator(String productId) {

    return By.cssSelector(
            "[data-testid='cart-move-to-wishlist-" + productId + "']"
    );
}

private By getRemoveItemLocator(String productId) {

    return By.cssSelector(
            "[data-testid='cart-remove-item-" + productId + "']"
    );
}

//========empty cart====//

private By CartEmptyState =
By.cssSelector("[data-testid='cart-empty-state']");


//==================== Constructor ====================

public CartPage(WebDriver driver) {
    this.driver = driver;
}


public boolean isCartPageDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, CartPage, 10)
            .isDisplayed();
}

public String getCartHeading() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, CartHeading, 10)
            .getText()
            .trim();
}

public int getCartItemCount() {

    String countText =
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            CartItemCount,
                            10)
                    .getText()
                    .trim();

    return Integer.parseInt(
            countText.replaceAll("[^0-9]", "")
    );
}

public boolean isCartItemListDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, CartItemList, 10)
            .isDisplayed();
}

public int getCartItemRowCount() {
    return driver.findElements(CartItems).size();
}

public String getCartItemTitle(String productId) {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    getCartItemTitleLocator(productId),
                    10)
            .getText()
            .trim();
}

public String getCartItemPrice(String productId) {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    getCartItemPriceLocator(productId),
                    10)
            .getText()
            .trim();
}

public String getCartSummaryMrp() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, CartSummaryMrp, 10)
            .getText()
            .trim();
}

public String getCartSummaryTotal() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, CartSummaryTotal, 10)
            .getText()
            .trim();
}

public int getCartTotal() {

    String total =
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            CartSummaryTotal,
                            10)
                    .getAttribute("data-total");

    return Integer.parseInt(total);
}

public void clickProceedToCheckout() {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    ProceedToCheckoutButton,
                    10)
            .click();
}

public boolean isProceedToCheckoutButtonDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProceedToCheckoutButton,
                    10)
            .isDisplayed();
}

public String getCartSummaryDiscount() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    CartSummaryDiscount,
                    10)
            .getText()
            .trim();
}

public String getCartSummaryShipping() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    CartSummaryShipping,
                    10)
            .getText()
            .trim();
}

public String getCartSummarySavings() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    CartSummarySavings,
                    10)
            .getText()
            .trim();
}

//======== quantity control method =====//
public boolean isCartQuantityStepperDisplayed(String productId) {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    getCartQuantityStepperLocator(productId),
                    10)
            .isDisplayed();
}

public int getCartItemQuantity(String productId) {

    String quantity =
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            getCartQuantityValueLocator(productId),
                            10)
                    .getText()
                    .trim();

    return Integer.parseInt(quantity);
}

public void increaseCartItemQuantity(String productId) {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    getCartQuantityIncreaseLocator(productId),
                    10)
            .click();
}

public void decreaseCartItemQuantity(String productId) {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    getCartQuantityDecreaseLocator(productId),
                    10)
            .click();
}

public void removeCartItem(String productId) {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    getRemoveItemLocator(productId),
                    10)
            .click();
}

public boolean isRemoveItemButtonDisplayed(String productId) {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    getRemoveItemLocator(productId),
                    10)
            .isDisplayed();
}
public void saveCartItemForLater(String productId) {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    getSaveForLaterLocator(productId),
                    10)
            .click();
}

public void moveCartItemToWishlist(String productId) {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    getMoveToWishlistLocator(productId),
                    10)
            .click();
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



}

