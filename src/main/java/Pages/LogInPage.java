package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitUtility;

public class LogInPage {


	    private WebDriver driver;

	    // =========================================================
	    // ACCOUNT MENU
	    // =========================================================

	    private By AccountMenuButton =
	            By.id("account-menu-button");
	    
	    private By LoggedInAccountMenu =
	            By.cssSelector("button[data-logged-in='true']");
	    

	    private By HeaderSignInLink =
	            By.cssSelector(
	                    "[data-testid='header-signin-link']"
	            );

	 // =========================================================
	 // LOGIN PAGE - TABS
	 // =========================================================

	 private By SignInTab =
	         By.cssSelector("[data-testid='signin-tab']");


	// =========================================================
	// LOGIN FORM
	// =========================================================



	private By EmailField =
	        By.cssSelector("[data-testid='login-email']");

	private By PasswordField =
	        By.cssSelector("[data-testid='login-password']");
	
	private By LoginErrorMessage =
	        By.cssSelector("[data-testid='login-error-message']");


	    
	    // =========================================================
	    // LOGIN PAGE
	    // =========================================================

	    private By UseDemoAccountButton =
	            By.cssSelector(
	                    "[data-testid='use-demo-account-button']"
	            );

	    private By LoginSubmitButton =
	            By.cssSelector(
	                    "[data-testid='login-submit-button']"
	            );
	    
	    private By AccountMenuLabel =
	            By.cssSelector("[data-testid='account-menu-label']");
	    
	    private By AccountMenuYourAccount =
	            By.cssSelector("[data-testid='account-menu-your-account']");
	    
	    //=================Login using google login ==============//
	    
	    private By GoogleSignInButton =
	            By.cssSelector("[data-testid='google-signin-button']");
	   
	    
	    private By GoogleAccount =
	            By.cssSelector(
	                "div[role='link'][data-button-type='multipleChoiceIdentifier']"
	            );
	    
	    private By ToastDismissButton =
	            By.cssSelector("[data-testid='toast-dismiss-button']");
	    
	    
	    

	    // =========================================================
	    // CONSTRUCTOR
	    // =========================================================

	    public LogInPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // =========================================================
	    // ACCOUNT MENU
	    // =========================================================
	    
	    public void clickSignInTab() {
	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        SignInTab,
	                        10
	                )
	                .click();
	    }
	    
	    public void enterEmail(String email) {

	        WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        EmailField,
	                        10
	                )
	                .clear();

	        if (email != null && !email.trim().isEmpty()) {
	            WaitUtility
	                    .waitForElementToBeVisible(
	                            driver,
	                            EmailField,
	                            10
	                    )
	                    .sendKeys(email);
	        }
	    }

	    public void enterPassword(String password) {

	        WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        PasswordField,
	                        10
	                )
	                .clear();

	        if (password != null && !password.trim().isEmpty()) {
	            WaitUtility
	                    .waitForElementToBeVisible(
	                            driver,
	                            PasswordField,
	                            10
	                    )
	                    .sendKeys(password);
	        }
	    }
	    public void clickAccountMenu() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        AccountMenuButton,
	                        10
	                )
	                .click();
	    }
	    
	    public void clickLoggedInAccountMenu() {
	    	
	    	           WaitUtility.
	    	           waitForElementClickable
	    
	    	         (driver,
	    	          LoggedInAccountMenu,  
	    	          10)
	   .click();
	    
	    }

	    public boolean isSignInLinkDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeaderSignInLink,
	                        10
	                )
	                .isDisplayed();
	    }

	    public void clickSignInLink() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        HeaderSignInLink,
	                        10
	                )
	                .click();
	    }
	    
	    public void clickYourAccount() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        AccountMenuYourAccount,
	                        10
	                )
	                .click();
	    }

	    // =========================================================
	    // DEMO ACCOUNT
	    // =========================================================

	    public boolean isDemoAccountButtonDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        UseDemoAccountButton,
	                        10
	                )
	                .isDisplayed();
	    }

	    public void clickUseDemoAccount() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        UseDemoAccountButton,
	                        10
	                )
	                .click();
	    }

	    // =========================================================
	    // LOGIN
	    // =========================================================

	    public boolean isLoginSubmitButtonDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        LoginSubmitButton,
	                        10
	                )
	                .isDisplayed();
	    }

	    public void clickLoginSubmit() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        LoginSubmitButton,
	                        10
	                )
	                .click();
	    }
	    
	    public String getAccountMenuLabel() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        AccountMenuLabel,
	                        10
	                )
	                .getText()
	                .trim();
	    }
	    
	    public void clickGoogleSignIn() {
	    	WaitUtility.waitForElementClickable(
	    			driver,
	    			GoogleSignInButton,
                    10
            ).click();
	    }
	    
	    public void clickGoogleAccount() {
	    	WaitUtility.waitForElementClickable(
	    			driver,
	    			GoogleAccount,
	    			 10 )
	                .click();
	    
	    }
	    
	    
	 // =========================================================
	 // LOGIN STATUS
	 // =========================================================
	    public String getLoginStatus() {

	        return WaitUtility
	                .waitForAttributeValue(
	                        driver,
	                        AccountMenuButton,
	                        "data-logged-in",
	                        "true",
	                        10
	                )
	                .getAttribute("data-logged-in");
	    }
	    // =========================================================
	    // COMPLETE DEMO LOGIN
	    // =========================================================
	    public void loginWithDemoAccount() {

	        clickAccountMenu();
	        clickSignInLink();
	        clickSignInTab();
	        clickUseDemoAccount();
	        clickLoginSubmit();
	    }

	    // =========================================================
	    // LOGIN VERIFICATION
	    // =========================================================
	    public boolean isUserLoggedIn() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        LoggedInAccountMenu,
	                        10
	                )
	                .isDisplayed();
	    }	
	    
	 // =========================================================
	 // LOGIN ERROR MESSAGE
	 // =========================================================

	 public String getLoginErrorMessage() {

	     return WaitUtility
	             .waitForElementToBeVisible(
	                     driver,
	                     LoginErrorMessage,
	                     10
	             )
	             .getText()
	             .trim();
	 }
	 
	 public void dismissWelcomeToast() {

		    WaitUtility.waitForElementClickable(
		            driver,
		            ToastDismissButton,
		            10
		    ).click();
		}
	  
	    }

