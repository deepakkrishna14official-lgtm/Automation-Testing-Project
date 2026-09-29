package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.LogInPage;
import Pages.ProductPage;
import Pages.SearchPage;
import Utilities.WaitUtility;

public class CheckOutTest extends BaseTest {

    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;


    @BeforeMethod
    public void checkoutSetup()  {

    	 homePage = new HomePage(driver);
    	    searchPage = new SearchPage(driver);
    	    productPage = new ProductPage(driver);
    	    cartPage = new CartPage(driver);
    	    checkOutPage = new CheckOutPage(driver);

    	    LogInPage logInPage = new LogInPage(driver);

    	    // =========================================================
    	    // LOGIN
    	    // =========================================================


    	    logInPage.clickAccountMenu();
    	    logInPage.clickSignInLink();
    	    logInPage.clickUseDemoAccount();
    	    logInPage.clickLoginSubmit();
    	    logInPage.dismissWelcomeToast();

    	    Assert.assertTrue(
    	    	    driver.findElement(By.cssSelector("[data-logged-in='true']")).isDisplayed(),
    	    	    "Login failed: Account button with data-logged-in='true' is not displayed."
    	    	);
    	    
    
    	   
    	    // =========================================================
    	    // OPEN CART
    	    // =========================================================

    	    homePage.clickCart();

    	    System.out.println("CART OPENED");

    	    // =========================================================
    	    // PROCEED TO CHECKOUT
    	    // =========================================================

    	    cartPage.clickProceedToCheckout();

    	    System.out.println("CHECKOUT BUTTON CLICKED");

    	    // =========================================================
    	    // VERIFY CHECKOUT
    	    // =========================================================

    	    Assert.assertTrue(
    	            checkOutPage.isCheckoutPageDisplayed(),
    	            "Checkout page should be displayed"
    	    );

    	    System.out.println("CHECKOUT PAGE SUCCESS");
    	}
    // =========================================================
    // CHECKOUT PAGE
    // =========================================================

    @Test
    public void verifyCheckoutHeading() {

        Assert.assertEquals(
                checkOutPage.getCheckoutHeading(),
                "Checkout",
                "Checkout heading should be displayed correctly"
        );
    }

    @Test
    public void verifyCheckoutStepsDisplayed() {

        Assert.assertTrue(
                checkOutPage.isCheckoutStepsDisplayed(),
                "Checkout progress steps should be displayed"
        );
    }

    @Test
    public void verifyCheckoutAddressStepDisplayed() {

        Assert.assertTrue(
                checkOutPage.isAddressStepDisplayed(),
                "Delivery address step should be displayed"
        );
    }

    @Test
    public void verifyCheckoutPaymentStepDisplayed() {

        Assert.assertTrue(
                checkOutPage.isPaymentStepDisplayed(),
                "Payment step should be displayed"
        );
    }

    @Test
    public void verifyCheckoutReviewStepDisplayed() {

        Assert.assertTrue(
                checkOutPage.isReviewStepDisplayed(),
                "Review order step should be displayed"
        );
    }

    // =========================================================
    // DELIVERY ADDRESS
    // =========================================================

    @Test
    public void verifyDeliveryAddressSection() {

        Assert.assertTrue(
                checkOutPage.isAddressSectionDisplayed(),
                "Delivery address section should be displayed"
        );
    }

    @Test
    public void verifyDeliveryAddressHeading() {

        Assert.assertEquals(
                checkOutPage.getAddressSectionHeading(),
                "Where should we deliver?",
                "Delivery address heading should be displayed correctly"
        );
    }

    @Test
    public void verifySavedAddressListDisplayed() {

        Assert.assertTrue(
                checkOutPage.isSavedAddressListDisplayed(),
                "Saved address list should be displayed"
        );
    }

    @Test
    public void verifySavedAddressDisplayed() {

        Assert.assertTrue(
                checkOutPage.isSavedAddressDisplayed(),
                "Saved delivery address should be displayed"
        );
    }

    @Test
    public void verifySavedAddressSelectedByDefault() {

        Assert.assertTrue(
                checkOutPage.isSavedAddressSelected(),
                "Saved address should be selected by default"
        );
    }

    @Test
    public void verifyAddNewAddressButtonDisplayed() {

        Assert.assertTrue(
                checkOutPage.isAddNewAddressButtonDisplayed(),
                "Add New Address button should be displayed"
        );
    }

    @Test
    public void verifyContinueToPaymentButtonDisplayed() {

        Assert.assertTrue(
                checkOutPage.isContinueToPaymentButtonDisplayed(),
                "Continue to Payment button should be displayed"
        );
    }

    @Test
    public void verifyContinueToPaymentButtonEnabled() {

        Assert.assertTrue(
                checkOutPage.isContinueToPaymentButtonEnabled(),
                "Continue to Payment button should be enabled"
        );
    }

    // =========================================================
    // PAYMENT NAVIGATION
    // =========================================================

    @Test
    public void verifyNavigationToPayment() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isPaymentSectionDisplayed(),
                "Payment section should be displayed after continuing"
        );
    }

    // =========================================================
    // PAYMENT SECTION
    // =========================================================

    @Test
    public void verifyPaymentSectionDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isPaymentSectionDisplayed(),
                "Payment section should be displayed"
        );
    }

    @Test
    public void verifyPaymentSectionHeading() {

        checkOutPage.clickContinueToPayment();

        Assert.assertEquals(
                checkOutPage.getPaymentSectionHeading(),
                "How would you like to pay?",
                "Payment section heading should be displayed correctly"
        );
    }

    @Test
    public void verifyPaymentMethodListDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isPaymentMethodListDisplayed(),
                "Payment method list should be displayed"
        );
    }

    // =========================================================
    // PAYMENT METHODS
    // =========================================================

    @Test
    public void verifyUpiPaymentDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isUpiPaymentDisplayed(),
                "UPI payment option should be displayed"
        );
    }

    @Test
    public void verifyCardPaymentDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isCardPaymentDisplayed(),
                "Card payment option should be displayed"
        );
    }

    @Test
    public void verifyNetBankingDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isNetBankingDisplayed(),
                "Net Banking payment option should be displayed"
        );
    }

    @Test
    public void verifyWalletPaymentDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isWalletPaymentDisplayed(),
                "Wallet payment option should be displayed"
        );
    }

    @Test
    public void verifyCodPaymentDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isCodPaymentDisplayed(),
                "Cash on Delivery option should be displayed"
        );
    }

    // =========================================================
    // DEFAULT PAYMENT METHOD
    // =========================================================

    @Test
    public void verifyUpiSelectedByDefault() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isUpiPaymentSelected(),
                "UPI should be selected by default"
        );
    }

    // =========================================================
    // PAYMENT METHOD SELECTION
    // =========================================================

    @Test
    public void verifyCardPaymentSelection() {

        checkOutPage.clickContinueToPayment();

        checkOutPage.selectCardPayment();

        Assert.assertTrue(
                checkOutPage.isCardPaymentSelected(),
                "Card payment should be selected"
        );

        Assert.assertFalse(
                checkOutPage.isUpiPaymentSelected(),
                "UPI should be deselected when Card is selected"
        );
    }

    @Test
    public void verifyNetBankingPaymentSelection() {

        checkOutPage.clickContinueToPayment();

        checkOutPage.selectNetBanking();

        Assert.assertTrue(
                checkOutPage.isNetBankingSelected(),
                "Net Banking should be selected"
        );
    }

    @Test
    public void verifyWalletPaymentSelection() {

        checkOutPage.clickContinueToPayment();

        checkOutPage.selectWalletPayment();

        Assert.assertTrue(
                checkOutPage.isWalletPaymentSelected(),
                "Wallet payment should be selected"
        );
    }

    @Test
    public void verifyCodPaymentSelection() {

        checkOutPage.clickContinueToPayment();

        // Wait until COD option is clickable using your WaitUtility
        WaitUtility.waitForElementClickable(driver, checkOutPage.CodPaymentMethod, 10);

        checkOutPage.selectCodPayment();

        Assert.assertTrue(
                checkOutPage.isCodPaymentSelected(),
                "Cash on Delivery should be selected"
        );
    }
    // =========================================================
    // UPI
    // =========================================================

    @Test
    public void verifyUpiPaymentFieldsDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isUpiPaymentFieldsDisplayed(),
                "UPI payment fields should be displayed"
        );
    }

    @Test
    public void verifyUpiIdInputDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isUpiIdInputDisplayed(),
                "UPI ID input should be displayed"
        );
    }

    @Test
    public void verifyEnterUpiId() {

        checkOutPage.clickContinueToPayment();

        String upiId = "demo@upi";

        checkOutPage.enterUpiId(upiId);

        Assert.assertEquals(
                checkOutPage.getUpiId(),
                upiId,
                "Entered UPI ID should be displayed in the input"
        );
    }

    // =========================================================
    // PAYMENT BACK BUTTON
    // =========================================================

    @Test
    public void verifyPaymentBackButtonDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isPaymentBackButtonDisplayed(),
                "Payment Back button should be displayed"
        );
    }

    
  

    // =========================================================
    // REVIEW BUTTON
    // =========================================================

    @Test
    public void verifyContinueToReviewButtonDisplayed() {

        checkOutPage.clickContinueToPayment();

        Assert.assertTrue(
                checkOutPage.isContinueToReviewButtonDisplayed(),
                "Continue to Review button should be displayed"
        );
    }
}