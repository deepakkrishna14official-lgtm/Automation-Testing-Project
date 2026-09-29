package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.EmptyCartPage;
import Pages.HomePage;

public class EmptyCartTest extends BaseTest {

    private HomePage homePage;
    private EmptyCartPage emptyCartPage;

    // =========================================================
    // TEST SETUP
    // =========================================================

    @BeforeMethod
    public void emptyCartSetup() {

        homePage = new HomePage(driver);
        emptyCartPage = new EmptyCartPage(driver);

        // Open Cart from the header
        homePage.clickCart();

        // Verify Cart page is opened
        Assert.assertTrue(
                emptyCartPage.isCartEmptyStateDisplayed(),
                "Empty cart state should be displayed"
        );
    }

    // =========================================================
    // EMPTY CART
    // =========================================================

    @Test
    public void verifyEmptyCartStateDisplayed() {

        Assert.assertTrue(
                emptyCartPage.isCartEmptyStateDisplayed(),
                "Empty cart state should be displayed"
        );
    }

    @Test
    public void verifyEmptyCartTitle() {

        Assert.assertEquals(
                emptyCartPage.getCartEmptyStateTitle(),
                "Your cart is feeling light",
                "Correct empty cart title should be displayed"
        );
    }

    @Test
    public void verifyStartShoppingLinkDisplayed() {

        Assert.assertTrue(
                emptyCartPage.isStartShoppingLinkDisplayed(),
                "Start Shopping link should be displayed"
        );
    }

    @Test
    public void verifyStartShoppingNavigation() {

        emptyCartPage.clickStartShopping();

        Assert.assertTrue(
                driver.getCurrentUrl().endsWith("/"),
                "User should be navigated to the Home page"
        );
    }
}