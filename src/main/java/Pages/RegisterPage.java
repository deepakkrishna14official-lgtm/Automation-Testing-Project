package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitUtility;

public class RegisterPage {

    private WebDriver driver;

    // =========================================================
    // AUTHENTICATION TABS
    // =========================================================

    private By SignUpTab =
            By.cssSelector("[data-testid='signup-tab']");

    private By SignInTab =
            By.cssSelector("[data-testid='signin-tab']");


    // =========================================================
    // REGISTRATION FORM
    // =========================================================

    private By RegistrationForm =
            By.cssSelector(
                    "form[data-testid='login-form']"
            );

    private By EmailField =
            By.cssSelector(
                    "[data-testid='login-email']"
            );

    private By PasswordField =
            By.cssSelector(
                    "[data-testid='login-password']"
            );

    private By RegistrationSubmitButton =
            By.cssSelector(
                    "[data-testid='signup-submit-button']"
            );
    
    //=========error message========//
    private By RegistrationErrorMessage =
            By.cssSelector("[data-testid='login-error-message']");


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    // =========================================================
    // SIGN UP TAB
    // =========================================================

    public void clickSignUpTab() {

        WaitUtility
                .waitForElementClickable(
                        driver,
                        SignUpTab,
                        10
                )
                .click();
    }


    // =========================================================
    // SIGN IN TAB
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


    // =========================================================
    // REGISTRATION FORM
    // =========================================================

    public boolean isRegistrationFormDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        RegistrationForm,
                        10
                )
                .isDisplayed();
    }


    // =========================================================
    // EMAIL
    // =========================================================

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


    // =========================================================
    // PASSWORD
    // =========================================================

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


    // =========================================================
    // SUBMIT REGISTRATION
    // =========================================================

    public void clickRegistrationSubmit() {

        WaitUtility
                .waitForElementClickable(
                        driver,
                        RegistrationSubmitButton,
                        10
                )
                .click();
    }


    // =========================================================
    // COMPLETE REGISTRATION
    // =========================================================

    public void registerUser(
            String email,
            String password) {

        clickSignUpTab();

        enterEmail(email);
        enterPassword(password);

        clickRegistrationSubmit();
    }
    
    
    //==============Error method ===========//
    public String getRegistrationErrorMessage() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        RegistrationErrorMessage,
                        10
                )
                .getText()
                .trim();
    }
}