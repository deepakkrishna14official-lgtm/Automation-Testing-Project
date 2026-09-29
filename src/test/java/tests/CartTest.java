package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchPage;

public class CartTest extends BaseTest {

    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;
    
    private final String PRODUCT_ID =
            "pulseon-hive-tablet-graphite-61";

    private final String PRODUCT_NAME =
            "Pulseon Hive Tablet (Graphite)";


    @BeforeMethod
    public void cartPageSetup() {

        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        
        

       
        homePage.enterSearchText("tablet");
        homePage.clickSearchButton();

        
        searchPage.clickPulseonHiveTablet();

       
        productPage.clickAddToCart();

        
        homePage.clickCart();
    }

    @Test
    public void verifyCartPageDisplayed() {

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page should be displayed"
        );
        
    }
        
        @Test
        public void verifyCartItemList() {

            Assert.assertTrue(
                    cartPage.isCartItemListDisplayed(),
                    "Cart item list should be displayed"
            );

            Assert.assertEquals(
                    cartPage.getCartItemRowCount(),
                    1,
                    "Cart should contain one product"
            );
        }


        // =========================================================
        // PRODUCT DETAILS
        // =========================================================

        @Test
        public void verifyProductInCart() {

            Assert.assertEquals(
                    cartPage.getCartItemTitle(PRODUCT_ID),
                    PRODUCT_NAME,
                    "Correct product should be displayed in cart"
            );
        }


        @Test
        public void verifyCartItemPriceDisplayed() {

            String price =
                    cartPage.getCartItemPrice(PRODUCT_ID);

            Assert.assertFalse(
                    price.isEmpty(),
                    "Product price should be displayed in cart"
            );
        }


        // =========================================================
        // QUANTITY
        // =========================================================

        @Test
        public void verifyInitialCartQuantity() {

            Assert.assertTrue(
                    cartPage.isCartQuantityStepperDisplayed(PRODUCT_ID),
                    "Quantity stepper should be displayed"
            );

            Assert.assertEquals(
                    cartPage.getCartItemQuantity(PRODUCT_ID),
                    1,
                    "Initial product quantity should be 1"
            );
        }


        @Test
        public void verifyIncreaseCartQuantity() {

            cartPage.increaseCartItemQuantity(PRODUCT_ID);

            Assert.assertEquals(
                    cartPage.getCartItemQuantity(PRODUCT_ID),
                    2,
                    "Product quantity should increase to 2"
            );
        }


        @Test
        public void verifyDecreaseCartQuantity() {

            // First increase quantity to 2
            cartPage.increaseCartItemQuantity(PRODUCT_ID);

            Assert.assertEquals(
                    cartPage.getCartItemQuantity(PRODUCT_ID),
                    2,
                    "Product quantity should be 2"
            );

            // Then decrease quantity
            cartPage.decreaseCartItemQuantity(PRODUCT_ID);

            Assert.assertEquals(
                    cartPage.getCartItemQuantity(PRODUCT_ID),
                    1,
                    "Product quantity should decrease to 1"
            );
        }


        // =========================================================
        // REMOVE ITEM
        // =========================================================

        @Test
        public void verifyRemoveItemButtonDisplayed() {

            Assert.assertTrue(
                    cartPage.isRemoveItemButtonDisplayed(PRODUCT_ID),
                    "Remove item button should be displayed"
            );
        }


        @Test
        public void verifyRemoveProductFromCart() {

            cartPage.removeCartItem(PRODUCT_ID);

            Assert.assertTrue(
                    cartPage.isCartEmptyStateDisplayed(),
                    "Cart should display empty state after removing product"
            );
        }


        // =========================================================
        // PRICE SUMMARY
        // =========================================================

        @Test
        public void verifyCartTotalDisplayed() {

            Assert.assertFalse(
                    cartPage.getCartSummaryTotal().isEmpty(),
                    "Cart total should be displayed"
            );
        }


        @Test
        public void verifyCartTotalValue() {

            Assert.assertTrue(
                    cartPage.getCartTotal() > 0,
                    "Cart total should be greater than zero"
            );
        }


        @Test
        public void verifyCartSummary() {

            Assert.assertFalse(
                    cartPage.getCartSummaryMrp().isEmpty(),
                    "Cart MRP should be displayed"
            );

            Assert.assertFalse(
                    cartPage.getCartSummaryDiscount().isEmpty(),
                    "Cart discount should be displayed"
            );

            Assert.assertFalse(
                    cartPage.getCartSummaryShipping().isEmpty(),
                    "Shipping information should be displayed"
            );

            Assert.assertFalse(
                    cartPage.getCartSummarySavings().isEmpty(),
                    "Cart savings should be displayed"
            );

            Assert.assertFalse(
                    cartPage.getCartSummaryTotal().isEmpty(),
                    "Cart total should be displayed"
            );
        }


        // =========================================================
        // CHECKOUT
        // =========================================================

        @Test
        public void verifyProceedToCheckoutButton() {

            Assert.assertTrue(
                    cartPage.isProceedToCheckoutButtonDisplayed(),
                    "Proceed to Checkout button should be displayed"
            );
        
    
    }
    
    
}