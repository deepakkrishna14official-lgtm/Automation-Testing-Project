package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ScrollUtility;
import Utilities.WaitUtility;

public class ProductPage {
	
    private WebDriver driver;
    
    //========== Product details page locators ==========//
    private By ProductDetailsPage =
            By.cssSelector("[data-testid='product-details-page']");
    
    private By Breadcrumb =
            By.cssSelector("[data-testid='breadcrumb']");
    
    private By BreadcrumbHomeLink =
            By.cssSelector("[data-testid='breadcrumb-home-link']");
    
    private By BreadcrumbCategoryLink =
            By.cssSelector("[data-testid='breadcrumb-category-link']");
    
    private By BreadcrumbCurrent =
            By.cssSelector("[data-testid='breadcrumb-current']");
    
    //==========Product Gallery and Thumbnails locators ==========//
    
    private By ProductGallery =
            By.cssSelector("[data-testid='product-gallery']");
    

    private By ProductThumbnailList =
            By.cssSelector("[data-testid='product-thumbnail-list']");
    
    private By getProductThumbnailLocator(int index) {

        return By.cssSelector(
                "[data-testid='product-thumbnail-" + index + "']"
        );
    }
    
    private By getProductThumbnailImageLocator(int index) {

        return By.cssSelector(
                "[data-testid='product-thumbnail-image-" + index + "']"
        );
    }
    
    private By ProductMainImage =
            By.cssSelector("[data-testid='product-main-image']");
    
    private By ProductZoomHint =
            By.cssSelector("[data-testid='product-zoom-hint']");
    
    private By ProductWishlistButton =
            By.cssSelector("[data-testid='product-wishlist-toggle']");
    
    //========== Product page buttons locators ==========//
    
    private By AddToCartButton =
            By.cssSelector("[data-testid='add-to-cart-button']");

    private By BuyNowButton =
            By.cssSelector("[data-testid='buy-now-button']");
    
    
    
 // ================= PRODUCT INFORMATION =================

    private By ProductBrandLink =
            By.cssSelector("[data-testid='product-brand-link']");

    private By ProductTitle =
            By.cssSelector("[data-testid='product-title']");

    private By ProductRating =
            By.cssSelector("[data-testid='product-rating']");

    private By ProductRatingValue =
            By.cssSelector("[data-testid='product-rating-value']");

    private By ProductRatingSummary =
            By.cssSelector("[data-testid='product-rating-summary']");

    private By ProductPriceBlock =
            By.cssSelector("[data-testid='product-price-block']");

    private By ProductDealLabel =
            By.cssSelector("[data-testid='product-deal-label']");

    private By ProductPrice =
            By.cssSelector("[data-testid='product-price']");

    private By ProductMRP =
            By.cssSelector("[data-testid='product-mrp']");

    private By ProductDiscount =
            By.cssSelector("[data-testid='product-discount']");

    private By ProductSavings =
            By.cssSelector("[data-testid='product-savings']");

    private By ProductEMI =
            By.cssSelector("[data-testid='product-emi']");
    
 // Product Offers

    private By ProductOffersSection =
            By.cssSelector("[data-testid='product-offers-section']");

    private By ProductOffersList =
            By.cssSelector("[data-testid='product-offers-list']");

    private By getProductOfferLocator(int offerNumber) {
        return By.cssSelector(
                "[data-testid='product-offer-" + offerNumber + "']"
        );
    }
    
 // ================= PRODUCT VARIANTS =================

    private By ProductVariants =
            By.cssSelector("[data-testid='product-variants']");

    private By ProductColourSelector =
            By.cssSelector("[data-testid='product-colour-selector']");

    private By ProductSelectedColour =
            By.cssSelector("[data-testid='product-selected-colour']");

    private By ProductColourOptions =
            By.cssSelector(
                    "[data-testid^='product-colour-option-']"
            );
    
    private By ProductQtyStepper =
            By.cssSelector("[data-testid='product-qty-stepper']");

    private By ProductDecreaseButton =
            By.cssSelector("[data-testid='product-qty-decrease-button']");

    private By ProductQtyValue =
            By.cssSelector("[data-testid='product-qty-value']");

    private By ProductIncreaseButton =
            By.cssSelector("[data-testid='product-qty-increase-button']");
    
    private By CartCountBadge =
            By.cssSelector("[data-testid='cart-count-badge']");
    
 // ================= DELIVERY & SERVICES =================

    private By ProductDeliverySection =
            By.cssSelector("[data-testid='product-delivery-section']");

    private By DeliveryPincodeInput =
            By.cssSelector("[data-testid='delivery-pincode-input']");

    private By DeliveryPincodeCheckButton =
            By.cssSelector("[data-testid='delivery-pincode-check-button']");
    
    private By ProductServicePromises =
            By.cssSelector("[data-testid='product-service-promises']");

    private By ProductPromiseDelivery =
            By.cssSelector("[data-testid='product-promise-delivery']");

    private By ProductPromiseReturns =
            By.cssSelector("[data-testid='product-promise-returns']");

    private By ProductPromiseWarranty =
            By.cssSelector("[data-testid='product-promise-warranty']");

    private By ProductPromiseSeller =
            By.cssSelector("[data-testid='product-promise-seller']");
    
    //===========Product Information Tab==============//
    
    private By ProductTabAbout =
            By.cssSelector("[data-testid='product-tab-about']");

    private By ProductTabSpecs =
            By.cssSelector("[data-testid='product-tab-specs']");

    public By ProductTabReviews =
            By.cssSelector("[data-testid='product-tab-reviews']");

    private By ProductTabPanelAbout =
            By.cssSelector("[data-testid='product-tabpanel-about']");

    private By ProductTabPanelSpecs =
            By.cssSelector("[data-testid='product-tabpanel-specs']");

    public static By ProductTabPanelReviews =
            By.cssSelector("[data-testid='product-tabpanel-reviews']");
    
    //==========Product meta Section=========//
    
    private By ProductMetaSeller =
            By.cssSelector("[data-testid='product-meta-seller']");

    private By ProductMetaWarranty =
            By.cssSelector("[data-testid='product-meta-warranty']");

    private By ProductMetaReturns =
            By.cssSelector("[data-testid='product-meta-returns']");
    
    private By RelatedProductsScrollRight =
            By.cssSelector(
                    "[data-testid='related-products-carousel-scroll-right']"
            );
    
    private By RelatedProductsScrollLeft =
            By.cssSelector(
                    "[data-testid='related-products-carousel-scroll-left']"
            );
    
  //=========== Constructor===========//  
 
    public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
 
    //=========== Breadcrumb Methods ==============//
    
    public String getBreadcrumbCategory() {
        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        BreadcrumbCategoryLink,
                        10
                )
                .getText()
                .trim();
    }
  
    public String getBreadcrumbCategoryId() {
        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        BreadcrumbCategoryLink,
                        10
                )
                .getAttribute("data-category-id");
    }
    
    
   
    //=========== Product Gallery and Thumbnails Methods ==============//
    
    public boolean isProductGalleryDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductGallery,
                        10
                )
                .isDisplayed();
    }
    
    public boolean isProductThumbnailListDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductThumbnailList,
                        10
                )
                .isDisplayed();
    }

    public int getProductThumbnailCount() {

        String count =
                WaitUtility
                        .waitForElementToBeVisible(
                                driver,
                                ProductThumbnailList,
                                10
                        )
                        .getAttribute("data-count");

        return Integer.parseInt(count);
    }
    
    public void selectProductThumbnail(int index) {

        By thumbnail =
                getProductThumbnailLocator(index);

        WaitUtility
                .waitForElementClickable(
                        driver,
                        thumbnail,
                        10
                )
                .click();
    }
    
    public boolean isProductThumbnailSelected(int index) {

        By thumbnail =
                getProductThumbnailLocator(index);

        return "true".equals(
                WaitUtility
                        .waitForElementToBeVisible(
                                driver,
                                thumbnail,
                                10
                        )
                        .getAttribute("aria-selected")
        );
    }
    
    public String getProductThumbnailAltText(int index) {

        By thumbnailImage =
                getProductThumbnailImageLocator(index);

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        thumbnailImage,
                        10
                )
                .getAttribute("alt")
                .trim();
    }
    
    public boolean isProductMainImageDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductMainImage,
                        10
                )
                .isDisplayed();
    }
    
    public boolean isProductZoomHintDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductZoomHint,
                        10
                )
                .isDisplayed();
    }
    
    public boolean isProductWishlistButtonDisplayed() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductWishlistButton,
                        10
                )
                .isDisplayed();
    }
    
    public void clickProductWishlist() {

        WaitUtility
                .waitForElementClickable(
                        driver,
                        ProductWishlistButton,
                        10
                )
                .click();
    }
    
    public boolean isProductWishlisted() {

        return "true".equals(
                WaitUtility
                        .waitForElementToBeVisible(
                                driver,
                                ProductWishlistButton,
                                10
                        )
                        .getAttribute("aria-pressed")
        );
    }
    
    public String getProductMainImageAltText() {

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductMainImage,
                        10
                )
                .getAttribute("alt")
                .trim();
    }
    
    public int getActiveProductImageIndex() {

        String index =
                WaitUtility
                        .waitForElementToBeVisible(
                                driver,
                                ProductMainImage,
                                10
                        )
                        .getAttribute("data-active-index");

        return Integer.parseInt(index);
    }
    
    //=========== Product Page Buttons Methods ==============//
    
    public boolean isAddToCartButtonDisplayed() {
        return WaitUtility
                .waitForElementToBeVisible(driver, AddToCartButton, 10)
                .isDisplayed();
    }
    
    public void clickAddToCart() {
        WaitUtility
                .waitForElementClickable(driver, AddToCartButton, 10)
                .click();
    }
    
    public boolean isBuyNowButtonDisplayed() {
        return WaitUtility
                .waitForElementToBeVisible(driver, BuyNowButton, 10)
                .isDisplayed();
    }
    
    public void clickBuyNow() {
        WaitUtility
                .waitForElementClickable(driver, BuyNowButton, 10)
                .click();
    }
    
    public String getAddToCartButtonText() {
        return WaitUtility
                .waitForElementToBeVisible(driver, AddToCartButton, 10)
                .getText()
                .trim();
    }
    
    public String getBuyNowButtonText() {
        return WaitUtility
                .waitForElementToBeVisible(driver, BuyNowButton, 10)
                .getText()
                .trim();
    }
    
    //=========== Product Information Methods ==============//
    
    public boolean isProductBrandDisplayed() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductBrandLink, 10)
                .isDisplayed();
    }

    public String getProductBrand() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductBrandLink, 10)
                .getText()
                .trim();
    }


    public boolean isProductTitleDisplayed() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductTitle, 10)
                .isDisplayed();
    }

    public String getProductTitle() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductTitle, 10)
                .getText()
                .trim();
    }


    public double getProductRating() {
        String rating =
                WaitUtility
                        .waitForElementToBeVisible(driver, ProductRating, 10)
                        .getAttribute("data-rating");

        return Double.parseDouble(rating);
    }

    public String getProductRatingValue() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductRatingValue, 10)
                .getText()
                .trim();
    }

    public String getProductRatingSummary() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductRatingSummary, 10)
                .getText()
                .trim();
    }


    public String getProductPriceText() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductPrice, 10)
                .getText()
                .trim();
    }

    public String getProductPriceValue() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductPrice, 10)
                .getAttribute("data-price");
    }


    public String getProductMRPText() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductMRP, 10)
                .getText()
                .trim();
    }

    public String getProductMRPValue() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductMRP, 10)
                .getAttribute("data-mrp");
    }


    public String getProductDiscount() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductDiscount, 10)
                .getText()
                .trim();
    }

    public String getProductDealLabel() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductDealLabel, 10)
                .getText()
                .trim();
    }

    public String getProductSavings() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductSavings, 10)
                .getText()
                .trim();
    }

    public String getProductEMI() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductEMI, 10)
                .getText()
                .trim();
    }
    
    //=========== Product Offers Methods ==============//
    
    public boolean isProductOffersSectionDisplayed() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductOffersSection, 10)
                .isDisplayed();
    }


    public int getProductOfferCount() {
        return WaitUtility
                .waitForElementToBeVisible(driver, ProductOffersList, 10)
                .findElements(By.tagName("li"))
                .size();
    }


    public boolean isProductOfferDisplayed(int offerNumber) {
        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        getProductOfferLocator(offerNumber),
                        10)
                .isDisplayed();
    }


    public String getProductOfferText(int offerNumber) {
        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        getProductOfferLocator(offerNumber),
                        10)
                .getText()
                .trim();
    }
    
    //=========== Product Variants Methods ==============//
    
    private By getProductColourOptionLocator(String colour) {

        String colourId = colour
                .toLowerCase()
                .trim()
                .replace(" ", "-");

        return By.cssSelector(
                "[data-testid='product-colour-option-" + colourId + "']"
        );
    }


    public boolean isProductVariantsDisplayed() {
        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductVariants,
                        10)
                .isDisplayed();
    }


    public int getProductColourCount() {
        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductColourSelector,
                        10)
                .findElements(
                        By.cssSelector("[role='radio']")
                )
                .size();
    }


    public String getSelectedProductColour() {
        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        ProductSelectedColour,
                        10)
                .getText()
                .trim();
    }


    public void selectProductColour(String colour) {

        By colourOption =
                getProductColourOptionLocator(colour);

        WaitUtility
                .waitForElementClickable(
                        driver,
                        colourOption,
                        10)
                .click();
    }


    public boolean isProductColourSelected(String colour) {

        By colourOption =
                getProductColourOptionLocator(colour);

        return "true".equals(
                WaitUtility
                        .waitForElementToBeVisible(
                                driver,
                                colourOption,
                                10)
                        .getAttribute("aria-checked")
        );
    }


    public String getProductColourText(String colour) {

        By colourOption =
                getProductColourOptionLocator(colour);

        return WaitUtility
                .waitForElementToBeVisible(
                        driver,
                        colourOption,
                        10)
                .getText()
                .trim();
    }
    
    //=========== Product Quantity Stepper Methods ==============//
    

public int getProductQuantity() {

    String quantity =
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            ProductQtyValue,
                            10)
                    .getText()
                    .trim();

    return Integer.parseInt(
            quantity.split("\\s+")[0]
    );
}


public void increaseProductQuantity() {
    WaitUtility
            .waitForElementClickable(
                    driver,
                    ProductIncreaseButton,
                    10)
            .click();
}


public void decreaseProductQuantity() {
    WaitUtility
            .waitForElementClickable(
                    driver,
                    ProductDecreaseButton,
                    10)
            .click();
}


public boolean isIncreaseQuantityEnabled() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductIncreaseButton,
                    10)
            .isEnabled();
}


public boolean isDecreaseQuantityEnabled() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductDecreaseButton,
                    10)
            .isEnabled();
}
    //=========== Cart Count Badge Methods ==============//
public int getCartCount() {

    String count =
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            CartCountBadge,
                            10)
                    .getAttribute("data-count");

    return Integer.parseInt(count);
}

//=========== Delivery & Services Methods ==============//

public boolean isProductDeliverySectionDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductDeliverySection,
                    10)
            .isDisplayed();
}

public void enterDeliveryPincode(String pincode) {

	 ScrollUtility.scrollToElement(driver,DeliveryPincodeInput , 10);

    WebElement pincodeInput =
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            DeliveryPincodeInput,
                            10);

    pincodeInput.clear();
    pincodeInput.sendKeys(pincode);
}

public String getDeliveryPincode() {
	
	ScrollUtility.scrollToElement(driver,DeliveryPincodeInput , 10);
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    DeliveryPincodeInput,
                    10)
            .getAttribute("value");
}

public void clickCheckDeliveryAvailability() {
    WaitUtility
            .waitForElementClickable(
                    driver,
                    DeliveryPincodeCheckButton,
                    10)
            .click();
}

public boolean isProductServicePromisesDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductServicePromises,
                    10)
            .isDisplayed();
}

public String getDeliveryPromise() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductPromiseDelivery,
                    10)
            .getText()
            .trim();
}

public String getReturnsPromise() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductPromiseReturns,
                    10)
            .getText()
            .trim();
}

public String getWarrantyPromise() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductPromiseWarranty,
                    10)
            .getText()
            .trim();
}

public String getSellerPromise() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductPromiseSeller,
                    10)
            .getText()
            .trim();
}

//========Product information Tab==========//

public boolean isAboutTabDisplayed() {
	
	 ScrollUtility.scrollToElement(driver, ProductTabAbout, 10);
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductTabAbout,
                    10)
            .isDisplayed();
}
 

public void clickSpecificationsTab() {
    ScrollUtility.scrollToElement(driver, ProductTabSpecs, 10);

    WaitUtility
            .waitForElementClickable(
                    driver,
                    ProductTabSpecs,
                    10)
            .click();
}

public void clickReviewsTab() {
    ScrollUtility.scrollToElement(driver, ProductTabReviews, 10);

    WaitUtility
            .waitForElementClickable(
                    driver,
                    ProductTabReviews,
                    10)
            .click();
}

public boolean isAboutTabSelected() {
    return "true".equals(
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            ProductTabAbout,
                            10)
                    .getAttribute("aria-selected")
    );
}

public boolean isSpecificationsTabSelected() {
    return "true".equals(
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            ProductTabSpecs,
                            10)
                    .getAttribute("aria-selected")
    );
}

public boolean isReviewsTabSelected() {
    return "true".equals(
            WaitUtility
                    .waitForElementToBeVisible(
                            driver,
                            ProductTabReviews,
                            10)
                    .getAttribute("aria-selected")
    );
}

public boolean isAboutPanelDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductTabPanelAbout,
                    10)
            .isDisplayed();
}

public boolean isSpecificationsPanelDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductTabPanelSpecs,
                    10)
            .isDisplayed();
}

public boolean isReviewsPanelDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ProductTabPanelReviews,
                    10)
            .isDisplayed();
}

//============Product Meta Section===========//

public String getSellerDetails() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, ProductMetaSeller, 10)
            .getText()
            .trim();
}

public String getWarrantyDetails() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, ProductMetaWarranty, 10)
            .getText()
            .trim();
}

public String getReturnsDetails() {
    return WaitUtility
            .waitForElementToBeVisible(
                    driver, ProductMetaReturns, 10)
            .getText()
            .trim();
}

public void clickRelatedProductsScrollRight() {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    RelatedProductsScrollRight,
                    10)
            .click();
}

public void clickRelatedProductsScrollLeft() {

    WaitUtility
            .waitForElementClickable(
                    driver,
                    RelatedProductsScrollLeft,
                    10)
            .click();
}


}
