package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.ScrollUtility;
import Utilities.WaitUtility;

public class CheckOutPage {
	

    private WebDriver driver;

    // =========================================================
    // CHECKOUT PAGE
    // =========================================================

    private By CheckoutPage =
            By.cssSelector("[data-testid='checkout-page']");

    private By CheckoutHeading =
            By.cssSelector("[data-testid='checkout-heading']");


    // =========================================================
    // CHECKOUT STEPS
    // =========================================================

    private By CheckoutSteps =
            By.cssSelector("[data-testid='checkout-steps']");

    private By CheckoutAddressStep =
            By.cssSelector("[data-testid='checkout-step-address']");

    private By CheckoutPaymentStep =
            By.cssSelector("[data-testid='checkout-step-payment']");

    private By CheckoutReviewStep =
            By.cssSelector("[data-testid='checkout-step-review']");


    // =========================================================
    // DELIVERY ADDRESS
    // =========================================================

    private By CheckoutAddressSection =
            By.cssSelector("[data-testid='checkout-address-step']");

    private By CheckoutAddressHeading =
            By.cssSelector("[data-testid='checkout-address-heading']");

    private By SavedAddressList =
            By.cssSelector("[data-testid='saved-address-list']");

    private By SavedAddressOption =
            By.cssSelector("[data-testid='saved-address-1']");


    // =========================================================
    // ADD NEW ADDRESS
    // =========================================================

    private By AddNewAddressButton =
            By.cssSelector("[data-testid='add-new-address-button']");


    // =========================================================
    // CONTINUE TO PAYMENT
    // =========================================================

    private By ContinueToPaymentButton =
            By.cssSelector("[data-testid='continue-to-payment-button']");
    
 // =========================================================
 // PAYMENT SECTION
 // =========================================================

 private By CheckoutPaymentSection =
         By.cssSelector("[data-testid='checkout-payment-step']");

 private By CheckoutPaymentHeading =
         By.cssSelector("[data-testid='checkout-payment-heading']");

 private By PaymentMethodList =
         By.cssSelector("[data-testid='payment-method-list']");


 // =========================================================
 // PAYMENT METHODS
 // =========================================================

 private By UpiPaymentMethod =
         By.cssSelector("[data-testid='payment-method-upi']");

 private By CardPaymentMethod =
         By.cssSelector("[data-testid='payment-method-card']");

 private By NetBankingPaymentMethod =
         By.cssSelector("[data-testid='payment-method-netbanking']");

 private By WalletPaymentMethod =
         By.cssSelector("[data-testid='payment-method-wallet']");

 public By CodPaymentMethod =
         By.id("payment-option-cod");


 // =========================================================
 // PAYMENT RADIO BUTTONS
 // =========================================================

 private By UpiPaymentRadio =
         By.cssSelector("[data-testid='payment-option-upi']");

 private By CardPaymentRadio =
         By.cssSelector("[data-testid='payment-option-card']");

 private By NetBankingPaymentRadio =
         By.cssSelector("[data-testid='payment-option-netbanking']");

 private By WalletPaymentRadio =
         By.cssSelector("[data-testid='payment-option-wallet']");

 public  By CodPaymentoption =
         By.id("payment-option-cod");


 // =========================================================
 // UPI PAYMENT
 // =========================================================

 private By UpiPaymentFields =
         By.cssSelector("[data-testid='upi-payment-fields']");

 private By UpiIdInput =
         By.cssSelector("[data-testid='upi-id-input']");


 // =========================================================
 // PAYMENT NAVIGATION
 // =========================================================

 public By PaymentBackButton =
         By.cssSelector("[data-testid='payment-back-button']");

 private By ContinueToReviewButton =
         By.cssSelector("[data-testid='continue-to-review-button']");


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }


    // =========================================================
    // CHECKOUT PAGE METHODS
    // =========================================================

    public boolean isCheckoutPageDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutPage,
                        10
                )
                .isDisplayed();
    }


    public String getCheckoutHeading() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutHeading,
                        10
                )
                .getText()
                .trim();
    }


    // =========================================================
    // CHECKOUT STEPS
    // =========================================================

    public boolean isCheckoutStepsDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutSteps,
                        10
                )
                .isDisplayed();
    }


    public boolean isAddressStepDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutAddressStep,
                        10
                )
                .isDisplayed();
    }


    public boolean isPaymentStepDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutPaymentStep,
                        10
                )
                .isDisplayed();
    }


    public boolean isReviewStepDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutReviewStep,
                        10
                )
                .isDisplayed();
    }


    // =========================================================
    // DELIVERY ADDRESS METHODS
    // =========================================================

    public boolean isAddressSectionDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutAddressSection,
                        10
                )
                .isDisplayed();
    }


    public String getAddressSectionHeading() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        CheckoutAddressHeading,
                        10
                )
                .getText()
                .trim();
    }


    // =========================================================
    // SAVED ADDRESS
    // =========================================================

    public boolean isSavedAddressListDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        SavedAddressList,
                        10
                )
                .isDisplayed();
    }


    public boolean isSavedAddressDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        SavedAddressOption,
                        10
                )
                .isDisplayed();
    }


    public void selectSavedAddress() {

        WaitUtility
                .waitForElementClickable(
                        driver,
                        SavedAddressOption,
                        10
                )
                .click();
    }


    public boolean isSavedAddressSelected() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        SavedAddressOption,
                        10
                )
                .findElement(
                        By.cssSelector("input[type='radio']")
                )
                .isSelected();
    }

    // =========================================================
    // ADD NEW ADDRESS
    // =========================================================

    public boolean isAddNewAddressButtonDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        AddNewAddressButton,
                        10
                )
                .isDisplayed();
    }


    public void clickAddNewAddress() {

        WaitUtility
                .waitForElementClickable(
                        driver,
                        AddNewAddressButton,
                        10
                )
                .click();
    }


    // =========================================================
    // CONTINUE TO PAYMENT
    // =========================================================

    public boolean isContinueToPaymentButtonDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ContinueToPaymentButton,
                        10
                )
                .isDisplayed();
    }


    public boolean isContinueToPaymentButtonEnabled() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ContinueToPaymentButton,
                        10
                )
                .isEnabled();
    }


    public void clickContinueToPayment() {

        WaitUtility
                .waitForElementClickable(
                        driver,
                        ContinueToPaymentButton,
                        10
                )
                .click();
    }
    
 // =========================================================
 // PAYMENT SECTION METHODS
 // =========================================================

 public boolean isPaymentSectionDisplayed() {

     return WaitUtility
             .waitForElementToBeVisible(
                     driver,
                     CheckoutPaymentSection,
                     10
             )
             .isDisplayed();
 }


 public String getPaymentSectionHeading() {

     return WaitUtility
             .waitForElementToBeVisible(
                     driver,
                     CheckoutPaymentHeading,
                     10
             )
             .getText()
             .trim();
 }


 public boolean isPaymentMethodListDisplayed() {

     return WaitUtility
             .waitForElementToBeVisible(
                     driver,
                     PaymentMethodList,
                     10
             )
             .isDisplayed();
 }
 
 public boolean isUpiPaymentDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    UpiPaymentMethod,
	                    10
	            )
	            .isDisplayed();
	}


	public void selectUpiPayment() {

	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    UpiPaymentMethod,
	                    10
	            )
	            .click();
	}


	public boolean isUpiPaymentSelected() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    UpiPaymentRadio,
	                    10
	            )
	            .isSelected();
	}
	
	public boolean isCardPaymentDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    CardPaymentMethod,
	                    10
	            )
	            .isDisplayed();
	}


	public void selectCardPayment() {

	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    CardPaymentMethod,
	                    10
	            )
	            .click();
	}


	public boolean isCardPaymentSelected() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    CardPaymentRadio,
	                    10
	            )
	            .isSelected();
	}
	
	public boolean isNetBankingDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    NetBankingPaymentMethod,
	                    10
	            )
	            .isDisplayed();
	}


	public void selectNetBanking() {

	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    NetBankingPaymentMethod,
	                    10
	            )
	            .click();
	}


	public boolean isNetBankingSelected() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    NetBankingPaymentRadio,
	                    10
	            )
	            .isSelected();
	}
	
	public boolean isWalletPaymentDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    WalletPaymentMethod,
	                    10
	            )
	            .isDisplayed();
	}


	public void selectWalletPayment() {

	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    WalletPaymentMethod,
	                    10
	            )
	            .click();
	}


	public boolean isWalletPaymentSelected() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    WalletPaymentRadio,
	                    10
	            )
	            .isSelected();
	}
	
	public boolean isCodPaymentDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    CodPaymentMethod,
	                    10
	            )
	            .isDisplayed();
	}


	public void selectCodPayment() {
		ScrollUtility.scrollToElement(driver, CodPaymentoption, 10);
	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    CodPaymentoption,
	                    10
	            )
	            .click();
	}


	public boolean isCodPaymentSelected() {

	    ScrollUtility.scrollToElement(driver, CodPaymentoption, 10);
	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    CodPaymentoption,
	                    10
	            )
	            .isSelected();
	}
	
	// =========================================================
	// UPI FIELD
	// =========================================================

	public boolean isUpiPaymentFieldsDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    UpiPaymentFields,
	                    10
	            )
	            .isDisplayed();
	}


	public boolean isUpiIdInputDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    UpiIdInput,
	                    10
	            )
	            .isDisplayed();
	}


	public void enterUpiId(String upiId) {

	    WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    UpiIdInput,
	                    10
	            )
	            .clear();

	    WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    UpiIdInput,
	                    10
	            )
	            .sendKeys(upiId);
	}


	public String getUpiId() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    UpiIdInput,
	                    10
	            )
	            .getAttribute("value");
	}
	
	// =========================================================
	// PAYMENT NAVIGATION
	// =========================================================

	public boolean isPaymentBackButtonDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    PaymentBackButton,
	                    10
	            )
	            .isDisplayed();
	}


	public void clickPaymentBackButton() {

	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    PaymentBackButton,
	                    10
	            )
	            .click();
	}


	public boolean isContinueToReviewButtonDisplayed() {

	    return WaitUtility
	            .waitForElementToBeVisible(
	                    driver,
	                    ContinueToReviewButton,
	                    10
	            )
	            .isDisplayed();
	}


	public void clickContinueToReview() {

	    WaitUtility
	            .waitForElementClickable(
	                    driver,
	                    ContinueToReviewButton,
	                    10
	            )
	            .click();
	}
	
 
}


