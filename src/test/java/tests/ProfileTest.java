package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import Pages.LogInPage;
import Pages.ProfilePage;

public class ProfileTest extends BaseTest {

    private ProfilePage profilePage;

    @BeforeMethod
    public void profileSetup() throws InterruptedException {

        profilePage = new ProfilePage(driver);

        LogInPage logInPage = new LogInPage(driver);

        // ================= LOGIN =================

        logInPage.clickAccountMenu();
        logInPage.clickSignInLink();
        logInPage.clickUseDemoAccount();
        logInPage.clickLoginSubmit();

        // ================= ACCOUNT =================

        logInPage.clickLoggedInAccountMenu();

        // Click "Your account"
        logInPage.clickYourAccount();
    }


    // =========================================================
    // ACCOUNT HEADER
    // =========================================================

    @Test
    public void verifyAccountHeader() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                profilePage.isAccountHeaderDisplayed(),
                "Account header should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isUsernameDisplayed(),
                "Username should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isEmailDisplayed(),
                "Email should be displayed"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // USER INFORMATION
    // =========================================================

    @Test
    public void verifyUserInformation() {

        SoftAssert softAssert = new SoftAssert();

        String username = profilePage.getUsername();
        String email = profilePage.getEmail();

        softAssert.assertFalse(
                username.isEmpty(),
                "Username should not be empty"
        );

        softAssert.assertFalse(
                email.isEmpty(),
                "Email should not be empty"
        );

        softAssert.assertTrue(
                email.contains("@"),
                "Email should contain @"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // ACCOUNT STATISTICS
    // =========================================================

    @Test
    public void verifyAccountStatistics() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                profilePage.isOrdersStatDisplayed(),
                "Orders statistic should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isWishlistStatDisplayed(),
                "Wishlist statistic should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isCartStatDisplayed(),
                "Cart statistic should be displayed"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // ACCOUNT STATISTIC VALUES
    // =========================================================

    @Test
    public void verifyAccountStatisticValues() {

        SoftAssert softAssert = new SoftAssert();

        String ordersCount = profilePage.getOrdersCount();
        String wishlistCount = profilePage.getWishlistCount();
        String cartCount = profilePage.getCartCount();

        softAssert.assertTrue(
                ordersCount.matches("\\d+"),
                "Orders count should contain only numbers"
        );

        softAssert.assertTrue(
                wishlistCount.matches("\\d+"),
                "Wishlist count should contain only numbers"
        );

        softAssert.assertTrue(
                cartCount.matches("\\d+"),
                "Cart count should contain only numbers"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // ACCOUNT DETAILS
    // =========================================================

    @Test
    public void verifyAccountDetails() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                profilePage.isAccountDetailsDisplayed(),
                "Account details section should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isEmailDetailDisplayed(),
                "Email detail should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isMemberSinceDisplayed(),
                "Member since detail should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isSignInMethodDisplayed(),
                "Sign-in method detail should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isCoinsDisplayed(),
                "Kartly coins detail should be displayed"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // RECENT ORDER
    // =========================================================

    @Test
    public void verifyRecentOrder() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                profilePage.isRecentOrderDisplayed(),
                "Recent order should be displayed"
        );

        String orderCode = profilePage.getRecentOrderCode();

        softAssert.assertFalse(
                orderCode == null || orderCode.trim().isEmpty(),
                "Recent order should have an order code"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // ACCOUNT NAVIGATION
    // =========================================================

    @Test
    public void verifyAccountNavigationLinks() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                profilePage.getProfileNavLink().contains("/profile"),
                "Profile navigation should point to Profile page"
        );

        softAssert.assertTrue(
                profilePage.getOrdersNavLink().contains("/orders"),
                "Orders navigation should point to Orders page"
        );

        softAssert.assertTrue(
                profilePage.getAddressesNavLink().contains("/addresses"),
                "Addresses navigation should point to Addresses page"
        );

        softAssert.assertTrue(
                profilePage.getWishlistNavLink().contains("/wishlist"),
                "Wishlist navigation should point to Wishlist page"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // ORDERS NAVIGATION
    // =========================================================

    @Test
    public void verifyOrdersNavigation() {

        SoftAssert softAssert = new SoftAssert();

        profilePage.clickOrdersNav();

        softAssert.assertTrue(
                driver.getCurrentUrl().contains("/account/orders"),
                "Orders page should be opened"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // ADDRESSES NAVIGATION
    // =========================================================

    @Test
    public void verifyAddressesNavigation() {

        SoftAssert softAssert = new SoftAssert();

        profilePage.clickAddressesNav();

        softAssert.assertTrue(
                driver.getCurrentUrl().contains("/account/addresses"),
                "Addresses page should be opened"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // WISHLIST NAVIGATION
    // =========================================================

    @Test
    public void verifyWishlistNavigation() {

        SoftAssert softAssert = new SoftAssert();

        profilePage.clickWishlistNav();

        softAssert.assertTrue(
                driver.getCurrentUrl().contains("/wishlist"),
                "Wishlist page should be opened"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // RECENT ORDER NAVIGATION
    // =========================================================

    @Test
    public void verifyRecentOrderNavigation() {

        SoftAssert softAssert = new SoftAssert();

        profilePage.clickRecentOrder();

        softAssert.assertTrue(
                driver.getCurrentUrl().contains("/account/orders"),
                "Recent order should navigate to Orders page"
        );

        softAssert.assertAll();
    }


    // =========================================================
    // SIGN OUT
    // =========================================================

    @Test
    public void verifySignOutButton() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                profilePage.isSignOutButtonDisplayed(),
                "Sign out button should be displayed"
        );

        softAssert.assertTrue(
                profilePage.isSignOutButtonEnabled(),
                "Sign out button should be enabled"
        );

        softAssert.assertAll();
    }
}