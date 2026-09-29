package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



import Utilities.WaitUtility;

public class HomePage {
	private WebDriver driver;
	
	
	private By Logo = By.id("home-logo");

	private By SearchInput = By.id("search-input");

	private By SearchButton = By.id("search-button");
	
	private By LoggedSearchButton =
	        By.cssSelector("button[aria-label='Submit search']");
	
	private By ThemeToggle = By.id("theme-toggle");
    
	private By WishlistButton =
	        By.id("header-wishlist-link");
	
	private By AccountMenuButton =
	        By.id("account-menu-button");

	private By Cart = By.id("header-cart-link");
	

private By CategoryBar =
        By.id("category-bar-track");

private By CategoryLinks =
        By.cssSelector("#category-bar-track a[data-category-id]");

private By ScrollLeftButton =
        By.cssSelector("button[data-scroll-direction='left']");

private By ScrollRightButton =
        By.cssSelector("button[data-scroll-direction='right']");

private By TodaysDeals =
By.cssSelector("[data-testid='nav-link-todays-deals']");

private By TrendingNow =
By.cssSelector("[data-testid='nav-link-trending-now']");

private By NewArrivals =
By.cssSelector("[data-testid='nav-link-new-arrivals']");

private By BestSellers =
By.cssSelector("[data-testid='nav-link-best-sellers']");

private By HeroSlide =
By.cssSelector("[data-testid='hero-slide']");

private By HeroDots =
By.cssSelector("[data-testid='hero-dots']");

private By HeroDot1 =
By.cssSelector("[data-testid='hero-dot-1']");

private By HeroDot2 =
By.cssSelector("[data-testid='hero-dot-2']");

private By HeroDot3 =
By.cssSelector("[data-testid='hero-dot-3']");

private By HeroDot4 =
By.cssSelector("[data-testid='hero-dot-4']");

private By HeroPreviousButton =
By.cssSelector("[data-testid='hero-prev-button']");

private By HeroNextButton =
By.cssSelector("[data-testid='hero-next-button']");



private By getCategoryLocator(String categoryId) {

    return By.cssSelector(
            "#category-bar-track a[data-category-id='" + categoryId + "']"
    );
}
private By TodaysDealsSection = By.id("todays-deals");

private By TodaysDealsHeading = By.cssSelector("#todays-deals h2");

private By TodaysDealsDescription = By.cssSelector("#todays-deals p");

private By TodaysDealsViewAll = By.cssSelector("#todays-deals a[href*='badge=deal']");

private By TodaysDealsCountdown = By.cssSelector("#todays-deals span.flex.items-center.gap-1.font-display.font-bold");



//=====================================================
//TRENDING NOW SECTION
//=====================================================

private By TrendingNowSection =
By.cssSelector("[data-testid='section-trending-now']");

private By TrendingNowTitle =
By.cssSelector("[data-testid='section-trending-now-title']");

private By TrendingNowSubtitle =
By.cssSelector("[data-testid='section-trending-now-subtitle']");

private By TrendingSeeEverythingLink =
By.cssSelector("[data-testid='trending-see-all-link']");


//-------------------------------//
// New Arrivals Section//
//-------------------------------//


private By NewArrivalsSection =
        By.cssSelector("[data-testid='section-new-arrivals']");

private By NewArrivalsTitle =
        By.cssSelector("[data-testid='section-new-arrivals-title']");

private By NewArrivalsSubtitle =
        By.cssSelector("[data-testid='section-new-arrivals-subtitle']");

private By NewArrivalsViewAll =
        By.cssSelector("[data-testid='new-arrivals-view-all-link']");

private By NewArrivalsCarousel =
        By.cssSelector("[data-testid='new-arrivals-carousel']");



//==================== RECOMMENDED SECTION ====================

private By RecommendedSection =
     By.cssSelector("[data-testid='section-recommended']");

private By RecommendedTitle =
     By.cssSelector("[data-testid='section-recommended-title']");

private By RecommendedSubtitle =
     By.cssSelector("[data-testid='section-recommended-subtitle']");

private By RecommendedProductGrid =
     By.cssSelector("[data-testid='recommended-product-grid']");

//============================================================
//FOOTER PROMISES
//============================================================

private By FooterPromises =
     By.cssSelector("[data-testid='footer-promises']");

private By FooterPromiseDelivery =
     By.cssSelector("[data-testid='footer-promise-delivery']");

private By FooterPromiseReturns =
     By.cssSelector("[data-testid='footer-promise-returns']");

private By FooterPromisePayments =
     By.cssSelector("[data-testid='footer-promise-payments']");

private By FooterPromiseSupport =
     By.cssSelector("[data-testid='footer-promise-support']");

//============================================================
//FOOTER MAIN SECTION
//============================================================

private By FooterBrand =
By.cssSelector("[data-testid='footer-brand']");

private By FooterSocialLinks =
By.cssSelector("[data-testid='footer-social-links']");

private By FooterInstagram =
By.cssSelector("[data-testid='footer-social-instagram']");

private By FooterTwitter =
By.cssSelector("[data-testid='footer-social-twitter']");

private By FooterFacebook =
By.cssSelector("[data-testid='footer-social-facebook']");

private By FooterYoutube =
By.cssSelector("[data-testid='footer-social-youtube']");

private By FooterShopColumn =
By.cssSelector("[data-testid='footer-column-shop']");

private By FooterDiscoverColumn =
By.cssSelector("[data-testid='footer-column-discover']");

private By FooterYourKartlyColumn =
By.cssSelector("[data-testid='footer-column-your-kartly']");



//==================== Constructor ====================
	
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	    public boolean isLogoDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(driver, Logo, 10)
	                .isDisplayed();
	    }
	    public void clickLogo() {

	        WaitUtility
	                .waitForElementClickable(driver, Logo, 10)
	                .click();
	    }
	    
	    public boolean isSearchBarDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(driver, SearchInput, 10)
	                .isDisplayed();
	    }
	    public void enterSearchText(String searchText) {

	        WebElement search = WaitUtility
	                .waitForElementToBeVisible(driver, SearchInput, 10);

	        search.clear();
	        search.sendKeys(searchText);
	    }
	    public void clickSearchButton() {

	        WaitUtility
	                .waitForElementClickable(driver, SearchButton, 10)
	                .click();
	    }
	    
	    public void clickLoggedSearchButton() {

	        WaitUtility
	                .waitForElementClickable(driver, LoggedSearchButton, 10)
	                .click();
	    }
	    public boolean isThemeToggleDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(driver, ThemeToggle, 10)
	                .isDisplayed();
	    }
	    public void clickThemeToggle() {

	        WaitUtility
	                .waitForElementClickable(driver, ThemeToggle, 10)
	                .click();
	    }

	    public boolean isWishlistDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(driver, WishlistButton, 10)
	                .isDisplayed();
	    }

	    public void clickWishlist() {

	        WaitUtility
	                .waitForElementClickable(driver, WishlistButton, 10)
	                .click();
	    }
	    public boolean isAccountMenuButtonDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(driver, AccountMenuButton, 10)
	                .isDisplayed();
	    }
	    public void clickAccountMenuButton() {

	        WaitUtility
	                .waitForElementClickable(driver, AccountMenuButton, 10)
	                .click();
	    }
	    public boolean isCartDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(driver, Cart, 10)
	                .isDisplayed();
	    }
	    public void clickCart() {

	        WaitUtility
	                .waitForElementClickable(driver, Cart, 10)
	                .click();
	    }

	    public String getCartLabel() {

	        return WaitUtility
	                .waitForElementToBeVisible(driver, Cart, 10)
	                .getAttribute("aria-label");
	    }
	    public boolean isCategoryBarDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        CategoryBar,
	                        10
	                )
	                .isDisplayed();
	    }
	    public int getCategoryCount() {

	        return driver.findElements(CategoryLinks).size();
	    }
	    
	    public boolean isCategoryDisplayed(String categoryId) {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        getCategoryLocator(categoryId),
	                        10
	                )
	                .isDisplayed();
	    }
	    
	    public void clickCategory(String categoryId) {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        getCategoryLocator(categoryId),
	                        10
	                )
	                .click();
	    }
	    
	    public String getCategoryName(String categoryId) {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        getCategoryLocator(categoryId),
	                        10
	                )
	                .getText();
	    }
	  
	    public boolean isTodaysDealsDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDeals,
	                        10
	                )
	                .isDisplayed();
	    }


	    public boolean isTrendingNowDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TrendingNow,
	                        10
	                )
	                .isDisplayed();
	    }


	    public boolean isNewArrivalsDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        NewArrivals,
	                        10
	                )
	                .isDisplayed();
	    }


	    public boolean isBestSellersDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        BestSellers,
	                        10
	                )
	                .isDisplayed();
	    }
	    public void clickTodaysDeals() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        TodaysDeals,
	                        10
	                )
	                .click();
	    }


	    public void clickTrendingNow() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        TrendingNow,
	                        10
	                )
	                .click();
	    }


	    public void clickNewArrivals() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        NewArrivals,
	                        10
	                )
	                .click();
	    }


	    public void clickBestSellers() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        BestSellers,
	                        10
	                )
	                .click();
	    }
	    public void clickScrollLeft() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        ScrollLeftButton,
	                        10
	                )
	                .click();
	    }


	    public void clickScrollRight() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        ScrollRightButton,
	                        10 ).click();
	    }
	    public boolean isHeroSlideDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroSlide,
	                        10
	                )
	                .isDisplayed();
	    }
	    
	    public boolean isHeroDotsDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroDots,
	                        10
	                )
	                .isDisplayed();
	    }
	    public boolean isSlide1Displayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroDot1,
	                        10
	                )
	                .isDisplayed();
	    }
	    public boolean isSlide2Displayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroDot2,
	                        10
	                )
	                .isDisplayed();
	    }
	    
	    public boolean isSlide3Displayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroDot3,
	                        10
	                )
	                .isDisplayed();
	    }
	    
	    public boolean isSlide4Displayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroDot4,
	                        10
	                )
	                .isDisplayed();
	    }
	    public int getActiveSlideNumber() {

	        By[] slideDots = {
	                HeroDot1,
	                HeroDot2,
	                HeroDot3,
	                HeroDot4
	        };

	        for (int i = 0; i < slideDots.length; i++) {

	            String selected =
	                    WaitUtility
	                            .waitForElementToBeVisible(
	                                    driver,
	                                    slideDots[i],
	                                    10
	                            )
	                            .getAttribute("aria-selected");

	            if ("true".equals(selected)) {
	                return i + 1;
	            }
	        }

	        return 0;
	    }
	    
	    public boolean isHeroPreviousButtonDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroPreviousButton,
	                        10
	                )
	                .isDisplayed();
	    }
	    
	    public void clickHeroPreviousButton() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        HeroPreviousButton,
	                        10
	                )
	                .click();
	    }
	    public boolean isHeroNextButtonDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        HeroNextButton,
	                        10
	                )
	                .isDisplayed();
	    }
	    public void clickHeroNextButton() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        HeroNextButton,
	                        10
	                )
	                .click();
	    }
	    public boolean isTodaysDealsSectionDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDealsSection,
	                        10
	                )
	                .isDisplayed();
	    }
	    public boolean isTodaysDealsHeadingDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDealsHeading,
	                        10
	                )
	                .isDisplayed();
	    }
	    public String getTodaysDealsHeading() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDealsHeading,
	                        10
	                )
	                .getText();
	    }
	    public boolean isTodaysDealsDescriptionDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDealsDescription,
	                        10
	                )
	                .isDisplayed();
	    }
	    public String getTodaysDealsDescription() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDealsDescription,
	                        10
	                )
	                .getText();
	    }
	    public boolean isTodaysDealsViewAllDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDealsViewAll,
	                        10
	                )
	                .isDisplayed();
	    }
	    
	    public void clickTodaysDealsViewAll() {

	        WaitUtility
	                .waitForElementClickable(
	                        driver,
	                        TodaysDealsViewAll,
	                        10
	                )
	                .click();
	    }
	    
	    public boolean isTodaysDealsCountdownDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TodaysDealsCountdown,
	                        10
	                )
	                .isDisplayed();
	    }
	    
	    public String getTodaysDealsCountdown() { 
	    	return WaitUtility.waitForElementToBeVisible
	    			(driver,TodaysDealsCountdown,10).getText();
	    }
	    
	    
	 // =====================================================
	 // TRENDING NOW METHODS
	 // =====================================================
	    
	    public boolean isTrendingNowSectionDisplayed() {

	        return WaitUtility
	                .waitForElementToBeVisible(
	                        driver,
	                        TrendingNowSection,
	                        10
	                )
	                .isDisplayed();
	    }
	    public boolean isTrendingNowTitleDisplayed() { 
	    	 return WaitUtility
		                .waitForElementToBeVisible(
		                        driver,
		                        TrendingNowTitle,
		                        10
		                )
		                .isDisplayed();
		    }
	    
	    public String getTrendingNowTitle() {
	    	return WaitUtility.waitForElementToBeVisible(driver,TrendingNowTitle,10)
	    			.getText();
	    }
	    
	    public boolean isTrendingNowSubtitleDisplayed() {
	    	 return WaitUtility
		                .waitForElementToBeVisible(
		                        driver,
		                        TrendingNowSubtitle,
		                        10
		                )
		                .isDisplayed();
		    }
	    
	    public String getTrendingNowSubtitle() {
	    	return WaitUtility.waitForElementToBeVisible
	    			(driver,TrendingNowSubtitle,10).getText();
	    }
	    
	    public boolean isTrendingSeeAllDisplayed() {
	    	 return WaitUtility
		                .waitForElementToBeVisible(
		                        driver,
		                        TrendingSeeEverythingLink,
		                        10
		                )
		                .isDisplayed();
		    }
	    
	    
	    public void clickTrendingSeeAll() {
           WaitUtility.waitForElementClickable
           (driver,TrendingSeeEverythingLink,10).click();
	    }
	  
	    
	    
	  
	 // ==================== NEW ARRIVALS METHODS ====================

	    public boolean isNewArrivalsSectionDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsSection,
	                10
	        ).isDisplayed();
	    }


	    public boolean isNewArrivalsTitleDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsTitle,
	                10
	        ).isDisplayed();
	    }


	    public String getNewArrivalsTitle() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsTitle,
	                10
	        ).getText();
	    }


	    public String getNewArrivalsSubtitle() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsSubtitle,
	                10
	        ).getText();
	    }


	    public boolean isNewArrivalsViewAllDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsViewAll,
	                10
	        ).isDisplayed();
	    }


	    public String getNewArrivalsViewAllText() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsViewAll,
	                10
	        ).getText();
	    }


	    public String getNewArrivalsViewAllUrl() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsViewAll,
	                10
	        ).getAttribute("href");
	    }


	    public void clickNewArrivalsViewAll() {

	        WaitUtility.waitForElementClickable(
	                driver,
	                NewArrivalsViewAll,
	                10
	        ).click();
	    }


	    public boolean isNewArrivalsCarouselDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                NewArrivalsCarousel,
	                10
	        ).isDisplayed();
	    }
	 // ================== RecommendedMethods =============

	    public boolean isRecommendedSectionDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                RecommendedSection,
	                10
	        ).isDisplayed();
	    }


	    public boolean isRecommendedTitleDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                RecommendedTitle,
	                10
	        ).isDisplayed();
	    }


	    public String getRecommendedTitle() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                RecommendedTitle,
	                10
	        ).getText();
	    }


	    public String getRecommendedSubtitle() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                RecommendedSubtitle,
	                10
	        ).getText();
	    }


	    public boolean isRecommendedProductGridDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                RecommendedProductGrid,
	                10
	        ).isDisplayed();
	    }
	    
	    // ================== FooterPromiseMethods =============
	    
	    public boolean isFooterPromisesDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                FooterPromises,
	                10
	        ).isDisplayed();
	    }


	    public boolean isFooterDeliveryDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                FooterPromiseDelivery,
	                10
	        ).isDisplayed();
	    }


	    public boolean isFooterReturnsDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                FooterPromiseReturns,
	                10
	        ).isDisplayed();
	    }


	    public boolean isFooterPaymentsDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                FooterPromisePayments,
	                10
	        ).isDisplayed();
	    }


	    public boolean isFooterSupportDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver,
	                FooterPromiseSupport,
	                10
	        ).isDisplayed();
	    }
	    
	 // ============================================================
	 // FOOTER MAIN SECTION METHODS
	 // ============================================================
	    
	    public boolean isFooterBrandDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterBrand, 10).isDisplayed();
	    }
	    
	    public boolean isFooterSocialLinksDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterSocialLinks, 10).isDisplayed();
	    }


	    public boolean isFooterInstagramDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterInstagram, 10).isDisplayed();
	    }


	    public boolean isFooterTwitterDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterTwitter, 10).isDisplayed();
	    }


	    public boolean isFooterFacebookDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterFacebook, 10).isDisplayed();
	    }


	    public boolean isFooterYoutubeDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterYoutube, 10).isDisplayed();
	    }


	    // -------------------- FOOTER NAVIGATION COLUMNS --------------------

	    public boolean isFooterShopColumnDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterShopColumn, 10).isDisplayed();
	    }


	    public boolean isFooterDiscoverColumnDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterDiscoverColumn, 10).isDisplayed();
	    }


	    public boolean isFooterYourKartlyColumnDisplayed() {

	        return WaitUtility.waitForElementToBeVisible(
	                driver, FooterYourKartlyColumn, 10).isDisplayed();
	    }
    
	    
}