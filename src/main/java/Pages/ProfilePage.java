package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitUtility;

public class ProfilePage {

	  private WebDriver driver;

	    // =========================================================
	    // LOCATORS
	    // =========================================================

	    private By AccountHeader =
	            By.cssSelector("[data-testid='account-header']");

	    private By AccountUsername =
	            By.cssSelector("[data-testid='account-username']");

	    private By AccountEmail =
	            By.cssSelector("[data-testid='account-email']");

	    private By AccountSignOutButton =
	            By.cssSelector("[data-testid='account-signout-button']");
	    
	    private By AccountPage =
	            By.cssSelector("[data-testid='account-page']");
	    
	    //============ Account Stats ======//
	    
	
	    private By OrdersStat =
	            By.cssSelector("[data-testid='account-stat-orders']");

	    private By WishlistStat =
	            By.cssSelector("[data-testid='account-stat-wishlist']");

	    private By CartStat =
	            By.cssSelector("[data-testid='account-stat-cart']");

	    private By OrdersValue =
	            By.cssSelector("[data-testid='account-stat-value-orders']");

	    private By WishlistValue =
	            By.cssSelector("[data-testid='account-stat-value-wishlist']");

	    private By CartValue =
	            By.cssSelector("[data-testid='account-stat-value-cart']");
	    
	    
	    //=============== Account Details =================//
	    
	    private By AccountDetails =
	            By.cssSelector("[data-testid='account-details']");

	    private By AccountDetailEmail =
	            By.cssSelector("[data-testid='account-detail-email']");

	    private By AccountDetailMemberSince =
	            By.cssSelector("[data-testid='account-detail-member-since']");

	    private By AccountDetailSignInMethod =
	            By.cssSelector("[data-testid='account-detail-signin-method']");

	    private By AccountDetailCoins =
	            By.cssSelector("[data-testid='account-detail-coins']");
	    
	    //==================Account Navigation=============//
	    
	    private By AccountNav =
	            By.cssSelector("[data-testid='account-nav']");

	    private By ProfileNav =
	            By.cssSelector("[data-testid='account-nav-profile']");

	    private By OrdersNav =
	            By.cssSelector("[data-testid='account-nav-orders']");

	    private By AddressesNav =
	            By.cssSelector("[data-testid='account-nav-addresses']");

	    private By WishlistNav =
	            By.cssSelector("[data-testid='account-nav-wishlist']");
	    
	    //==================Recent Orders ==================//
	    
	    private By RecentOrder =
	            By.cssSelector("[data-testid='account-recent-order']");

	
	    // =========================================================
	    // CONSTRUCTOR
	    // =========================================================

	    public ProfilePage(WebDriver driver) {
	        this.driver = driver;
	    }


	    // =========================================================
	    // ACCOUNT HEADER
	    // =========================================================

	    public boolean isAccountHeaderDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountHeader,
	                        10
	                )
	                .isDisplayed();
	    }


	    // =========================================================
	    // USERNAME
	    // =========================================================

	    public boolean isUsernameDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountUsername,
	                        10
	                )
	                .isDisplayed();
	    }

	    public String getUsername() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountUsername,
	                        10
	                )
	                .getText()
	                .trim();
	    }


	    // =========================================================
	    // EMAIL
	    // =========================================================

	    public boolean isEmailDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountEmail,
	                        10
	                )
	                .isDisplayed();
	    }

	    public String getEmail() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountEmail,
	                        10
	                )
	                .getText()
	                .trim();
	    }


	    // =========================================================
	    // SIGN OUT
	    // =========================================================

	    public boolean isSignOutButtonDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountSignOutButton,
	                        10
	                )
	                .isDisplayed();
	    }

	    public boolean isSignOutButtonEnabled() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountSignOutButton,
	                        10
	                )
	                .isEnabled();
	    }

	    public void clickSignOut() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        AccountSignOutButton,
	                        10
	                )
	                .click();
	    }
	    
	    public boolean isAccountPageDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountPage,
	                        10
	                )
	                .isDisplayed();
	    }
	
//================= Account Stats Method ==============//
	    
	    public boolean isOrdersStatDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, OrdersStat, 10).isDisplayed();
	    }

	    public String getOrdersCount() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, OrdersValue, 10).getText().trim();
	    }
	    
	    public void clickOrdersStat() {
	        WaitUtility.waitForElementClickable(
	                driver, OrdersStat, 10).click();
	    }
	    
	    public boolean isWishlistStatDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, WishlistStat, 10).isDisplayed();
	    }
	    
	    public String getWishlistCount() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, WishlistValue, 10).getText().trim();
	    }

	    public void clickWishlistStat() {
	        WaitUtility.waitForElementClickable(
	                driver, WishlistStat, 10).click();
	    }
	    
	    public boolean isCartStatDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, CartStat, 10).isDisplayed();
	    }
	    
	    public String getCartCount() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, CartValue, 10).getText().trim();
	    }

	    public void clickCartStat() {
	        WaitUtility.waitForElementClickable(
	                driver, CartStat, 10).click();
	    }
	    
	  //================Account details ================//
	    
	    public boolean isAccountDetailsDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, AccountDetails, 10).isDisplayed();
	    }

	    public boolean isEmailDetailDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, AccountDetailEmail, 10).isDisplayed();
	    }

	    public boolean isMemberSinceDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, AccountDetailMemberSince, 10).isDisplayed();
	    }

	    public boolean isSignInMethodDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, AccountDetailSignInMethod, 10).isDisplayed();
	    }

	    public boolean isCoinsDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, AccountDetailCoins, 10).isDisplayed();
	    }
	    
	    //================= Recent Orders ================//
	    
	    public boolean isRecentOrderDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, RecentOrder, 10).isDisplayed();
	    }
	    
	    
	    public String getRecentOrderCode() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, RecentOrder, 10)
	                .getAttribute("data-order-code");
	    }
	    
	    public void clickRecentOrder() {

	        WaitUtility.waitForElementClickable(
	                driver, RecentOrder, 10).click();
	    }
	  
	    //============Account Navigation =============//
	    
	    public boolean isAccountNavigationDisplayed() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, AccountNav, 10).isDisplayed();
	    }
	    
	    public void clickProfileNav() {
	        WaitUtility.waitForElementClickable(
	                driver, ProfileNav, 10).click();
	    }

	    public void clickOrdersNav() {
	        WaitUtility.waitForElementClickable(
	                driver, OrdersNav, 10).click();
	    }

	    public void clickAddressesNav() {
	        WaitUtility.waitForElementClickable(
	                driver, AddressesNav, 10).click();
	    }

	    public void clickWishlistNav() {
	        WaitUtility.waitForElementClickable(
	                driver, WishlistNav, 10).click();
	    }
	    
	    public String getProfileNavLink() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, ProfileNav, 10)
	                .getAttribute("href");
	    }

	    public String getOrdersNavLink() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, OrdersNav, 10)
	                .getAttribute("href");
	    }

	    public String getAddressesNavLink() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, AddressesNav, 10)
	                .getAttribute("href");
	    }

	    public String getWishlistNavLink() {
	        return WaitUtility.waitForElementToBeVisible(
	                driver, WishlistNav, 10)
	                .getAttribute("href");
	    }
	    
}
