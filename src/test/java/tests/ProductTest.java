package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseTest;
import DataProviders.SearchAndPincodeData;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchPage;

public class ProductTest extends BaseTest {


    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;



    @BeforeMethod
    public void productPageSetup() {

        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);

        homePage.enterSearchText("Tablet");
        homePage.clickSearchButton();
        homePage.clickSearchButton();

        searchPage.clickPulseonHiveTablet();
    }
        
    @Test
    public void verifyProductPageLoads() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isProductGalleryDisplayed(),
                "Product gallery should be displayed"
        );

        softAssert.assertTrue(
                productPage.isProductMainImageDisplayed(),
                "Product main image should be displayed"
        );

        softAssert.assertTrue(
                productPage.isProductTitleDisplayed(),
                "Product title should be displayed"
        );

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductInformation() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isProductBrandDisplayed(),
                "Product brand should be displayed"
        );

        softAssert.assertTrue(
                productPage.isProductTitleDisplayed(),
                "Product title should be displayed"
        );

        softAssert.assertFalse(
                productPage.getProductBrand().isEmpty(),
                "Product brand should not be empty"
        );

        softAssert.assertFalse(
                productPage.getProductTitle().isEmpty(),
                "Product title should not be empty"
        );

        double rating = productPage.getProductRating();

        softAssert.assertTrue(
                rating >= 0 && rating <= 5,
                "Product rating should be between 0 and 5"
        );

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductPriceInformation() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        String price = productPage.getProductPriceValue();
        String mrp = productPage.getProductMRPValue();

        softAssert.assertFalse(
                price.isEmpty(),
                "Product price should be available"
        );

        softAssert.assertFalse(
                mrp.isEmpty(),
                "Product MRP should be available"
        );

        softAssert.assertTrue(
                Double.parseDouble(price) > 0,
                "Product price should be greater than zero"
        );

        softAssert.assertTrue(
                Double.parseDouble(mrp) > 0,
                "Product MRP should be greater than zero"
        );

        softAssert.assertFalse(
                productPage.getProductDiscount().isEmpty(),
                "Product discount should be displayed"
        );

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductGallery() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isProductGalleryDisplayed(),
                "Product gallery should be displayed"
        );

        softAssert.assertTrue(
                productPage.isProductThumbnailListDisplayed(),
                "Product thumbnail list should be displayed"
        );

        int thumbnailCount = productPage.getProductThumbnailCount();

        softAssert.assertTrue(
                thumbnailCount > 0,
                "At least one product thumbnail should be available"
        );

        softAssert.assertTrue(
                productPage.isProductMainImageDisplayed(),
                "Main product image should be displayed"
        );

        softAssert.assertAll();
    }
   
    @Test
    public void verifyProductThumbnailSelection() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        productPage.selectProductThumbnail(2);

        softAssert.assertTrue(
                productPage.isProductThumbnailSelected(2),
                "Second product thumbnail should be selected"
        );

        softAssert.assertEquals(
                productPage.getActiveProductImageIndex(),
                2,
                "Main product image should change to the selected thumbnail"
        );

        softAssert.assertAll();
    }
    
    
    @Test
    public void verifyAddToCart() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isAddToCartButtonDisplayed(),
                "Add to Cart button should be displayed"
        );

        softAssert.assertEquals(
                productPage.getAddToCartButtonText(),
                "Add to cart",
                "Add to Cart button text is incorrect"
        );

        productPage.clickAddToCart();

        softAssert.assertTrue(
                productPage.getCartCount() > 0,
                "Cart count should increase after adding product"
        );

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductQuantityControls() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        productPage.clickAddToCart();

        softAssert.assertEquals(
                productPage.getProductQuantity(),
                1,
                "Initial cart quantity should be 1"
        );

        productPage.increaseProductQuantity();

        softAssert.assertEquals(
                productPage.getProductQuantity(),
                2,
                "Quantity should increase to 2"
        );

        productPage.decreaseProductQuantity();

        softAssert.assertEquals(
                productPage.getProductQuantity(),
                1,
                "Quantity should decrease back to 1"
        );

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductColourSelection() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isProductVariantsDisplayed(),
                "Product variants should be displayed"
        );

        softAssert.assertTrue(
                productPage.getProductColourCount() > 0,
                "At least one colour option should be available"
        );

        productPage.selectProductColour("Graphite");

        softAssert.assertTrue(
                productPage.isProductColourSelected("Graphite"),
                "Graphite colour should be selected"
        );

        softAssert.assertAll();
    }
    
    

    @Test(dataProvider = "deliveryPincodes",dataProviderClass = SearchAndPincodeData.class)
    public void verifyDeliveryPincodeInput(String pincode) {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isProductDeliverySectionDisplayed(),
                "Delivery section should be displayed"
        );

        productPage.enterDeliveryPincode(pincode);

        softAssert.assertEquals(
                productPage.getDeliveryPincode(),
                pincode,
                "Entered pincode should be displayed correctly"
        );

        productPage.clickCheckDeliveryAvailability();

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductInformationTabs() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isAboutTabDisplayed(),
                "About tab should be displayed"
        );

        productPage.clickSpecificationsTab();

        softAssert.assertTrue(
                productPage.isSpecificationsTabSelected(),
                "Specifications tab should be selected"
        );

        softAssert.assertTrue(
                productPage.isSpecificationsPanelDisplayed(),
                "Specifications panel should be displayed"
        );

        productPage.clickReviewsTab();

        softAssert.assertTrue(
                productPage.isReviewsTabSelected(),
                "Reviews tab should be selected"
        );

        softAssert.assertTrue(
                productPage.isReviewsPanelDisplayed(),
                "Reviews panel should be displayed"
        );

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductOffers() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isProductOffersSectionDisplayed(),
                "Product offers section should be displayed"
        );

        int offerCount = productPage.getProductOfferCount();

        softAssert.assertTrue(
                offerCount > 0,
                "At least one product offer should be displayed"
        );

        for (int i = 1; i <= offerCount; i++) {

            softAssert.assertTrue(
                    productPage.isProductOfferDisplayed(i),
                    "Offer " + i + " should be displayed"
            );

            softAssert.assertFalse(
                    productPage.getProductOfferText(i).isEmpty(),
                    "Offer " + i + " should contain text"
            );
        }

        softAssert.assertAll();
    }
    
    @Test
    public void verifyProductMetaInformation() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertFalse(
                productPage.getSellerDetails().isEmpty(),
                "Seller information should be displayed"
        );

        softAssert.assertFalse(
                productPage.getWarrantyDetails().isEmpty(),
                "Warranty information should be displayed"
        );

        softAssert.assertFalse(
                productPage.getReturnsDetails().isEmpty(),
                "Returns information should be displayed"
        );

        softAssert.assertAll();
    }
    
    @Test
    public void verifyBuyNowButton() {

        productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(
                productPage.isBuyNowButtonDisplayed(),
                "Buy Now button should be displayed"
        );

        softAssert.assertEquals(
                productPage.getBuyNowButtonText(),
                "Buy now",
                "Buy Now button text is incorrect"
        );

        softAssert.assertAll();
    }
}