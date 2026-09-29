package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.HomePage;


public class HomeTest  extends BaseTest {

	 private HomePage homePage;


	    // ============================================================
	    // SETUP
	    // ============================================================

	    @BeforeMethod
	    public void setUpHomePage() {

	        homePage = new HomePage(driver);
	    }


	    // ============================================================
	    // HEADER TESTS
	    // ============================================================

	    @Test
	    public void verifyHeaderElementsDisplayed() {

	        Assert.assertTrue(
	                homePage.isLogoDisplayed(),
	                "Kartly logo is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isSearchBarDisplayed(),
	                "Search bar is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isThemeToggleDisplayed(),
	                "Theme toggle is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isWishlistDisplayed(),
	                "Wishlist button is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isAccountMenuButtonDisplayed(),
	                "Account menu button is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isCartDisplayed(),
	                "Cart button is not displayed"
	        );
	    }


	    @Test
	    public void verifyCartAriaLabel() {

	        String cartLabel = homePage.getCartLabel();

	        Assert.assertNotNull(
	                cartLabel,
	                "Cart aria-label is missing"
	        );

	        Assert.assertFalse(
	                cartLabel.trim().isEmpty(),
	                "Cart aria-label is empty"
	        );
	    }


	    @Test
	    public void verifySearchFunctionality() {

	        homePage.enterSearchText("laptop");

	        homePage.clickSearchButton();

	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("search"),
	                "Search did not navigate to the search page"
	        );
	    }


	    @Test
	    public void verifyLogoNavigation() {

	        homePage.clickLogo();

	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("/"),
	                "Logo did not navigate to the homepage"
	        );
	    }


	    @Test
	    public void verifyWishlistNavigation() {

	        homePage.clickWishlist();

	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("wishlist"),
	                "Wishlist navigation failed"
	        );
	    }


	    @Test
	    public void verifyCartNavigation() {

	        homePage.clickCart();

	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("cart"),
	                "Cart navigation failed"
	        );
	    }


	    // ============================================================
	    // CATEGORY BAR TESTS
	    // ============================================================

	    @Test
	    public void verifyCategoryBarDisplayed() {

	        Assert.assertTrue(
	                homePage.isCategoryBarDisplayed(),
	                "Category bar is not displayed"
	        );
	    }


	    @Test
	    public void verifyCategoryCount() {

	        int categoryCount = homePage.getCategoryCount();

	        System.out.println("Category count found by Selenium: " + categoryCount);

	        Assert.assertEquals(
	                categoryCount,
	                15,
	                "Expected 15 categories but found " + categoryCount
	        );
	    }

	    @Test
	    public void verifyCategoryLinksDisplayed() {

	        String[] categoryIds = {
	                "smartphones",
	                "laptops",
	                "electronics",
	                "audio",
	                "watches",
	                "accessories",
	                "clothing",
	                "footwear",
	                "home",
	                "books",
	                "beauty",
	                "sports",
	                "grocery"
	        };

	        for (String categoryId : categoryIds) {

	            Assert.assertTrue(
	                    homePage.isCategoryDisplayed(categoryId),
	                    "Category is not displayed: " + categoryId
	            );
	        }
	    }


	    @Test
	    public void verifyCategoryNavigation() {

	        homePage.clickCategory("smartphones");

	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("/c/smartphones"),
	                "Smartphones category navigation failed"
	        );
	    }


	    // ============================================================
	    // TOP NAVIGATION TESTS
	    // ============================================================

	    @Test
	    public void verifyTopNavigationLinksDisplayed() {

	        Assert.assertTrue(
	                homePage.isTodaysDealsDisplayed(),
	                "Today's Deals navigation link is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isTrendingNowDisplayed(),
	                "Trending Now navigation link is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isNewArrivalsDisplayed(),
	                "New Arrivals navigation link is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isBestSellersDisplayed(),
	                "Best Sellers navigation link is not displayed"
	        );
	    }


	    // ============================================================
	    // HERO SECTION TESTS
	    // ============================================================

	    @Test
	    public void verifyHeroSectionDisplayed() {

	        Assert.assertTrue(
	                homePage.isHeroSlideDisplayed(),
	                "Hero slide is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isHeroDotsDisplayed(),
	                "Hero navigation dots are not displayed"
	        );
	    }


	    @Test
	    public void verifyHeroPreviousAndNextButtonsDisplayed() {

	        Assert.assertTrue(
	                homePage.isHeroPreviousButtonDisplayed(),
	                "Hero Previous button is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isHeroNextButtonDisplayed(),
	                "Hero Next button is not displayed"
	        );
	    }


	    @Test
	    public void verifyHeroNextButtonFunctionality() {

	        int initialSlide =
	                homePage.getActiveSlideNumber();

	        Assert.assertTrue(
	                initialSlide >= 1 && initialSlide <= 4,
	                "No valid active hero slide found"
	        );

	        homePage.clickHeroNextButton();

	        int nextSlide =
	                homePage.getActiveSlideNumber();

	        Assert.assertTrue(
	                nextSlide >= 1 && nextSlide <= 4,
	                "Hero slide did not have a valid active state after clicking Next"
	        );
	    }


	    @Test
	    public void verifyHeroPreviousButtonFunctionality() {

	        int initialSlide =
	                homePage.getActiveSlideNumber();

	        Assert.assertTrue(
	                initialSlide >= 1 && initialSlide <= 4,
	                "No valid active hero slide found"
	        );

	        homePage.clickHeroPreviousButton();

	        int previousSlide =
	                homePage.getActiveSlideNumber();

	        Assert.assertTrue(
	                previousSlide >= 1 && previousSlide <= 4,
	                "Hero slide did not have a valid active state after clicking Previous"
	        );
	    }


	    // ============================================================
	    // TODAY'S DEALS TESTS
	    // ============================================================

	    @Test
	    public void verifyTodaysDealsSection() {

	        Assert.assertTrue(
	                homePage.isTodaysDealsSectionDisplayed(),
	                "Today's Deals section is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isTodaysDealsHeadingDisplayed(),
	                "Today's Deals heading is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isTodaysDealsDescriptionDisplayed(),
	                "Today's Deals description is not displayed"
	        );
	    }


	    @Test
	    public void verifyTodaysDealsContent() {

	        Assert.assertEquals(
	                homePage.getTodaysDealsHeading(),
	                "Today's Deals",
	                "Today's Deals heading is incorrect"
	        );

	        Assert.assertEquals(
	                homePage.getTodaysDealsDescription(),
	                "Hand-picked price drops, refreshed daily",
	                "Today's Deals description is incorrect"
	        );
	    }


	    @Test
	    public void verifyTodaysDealsCountdownDisplayed() {

	        Assert.assertTrue(
	                homePage.isTodaysDealsCountdownDisplayed(),
	                "Today's Deals countdown is not displayed"
	        );

	        Assert.assertFalse(
	                homePage.getTodaysDealsCountdown().trim().isEmpty(),
	                "Today's Deals countdown is empty"
	        );
	    }


	    @Test
	    public void verifyTodaysDealsViewAllDisplayed() {

	        Assert.assertTrue(
	                homePage.isTodaysDealsViewAllDisplayed(),
	                "Today's Deals View All link is not displayed"
	        );
	    }


	    // ============================================================
	    // TRENDING NOW TESTS
	    // ============================================================

	    @Test
	    public void verifyTrendingNowSection() {

	        Assert.assertTrue(
	                homePage.isTrendingNowSectionDisplayed(),
	                "Trending Now section is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isTrendingNowTitleDisplayed(),
	                "Trending Now title is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isTrendingNowSubtitleDisplayed(),
	                "Trending Now subtitle is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isTrendingSeeAllDisplayed(),
	                "Trending See Everything link is not displayed"
	        );
	    }


	    @Test
	    public void verifyTrendingNowContent() {

	        Assert.assertEquals(
	                homePage.getTrendingNowTitle(),
	                "Trending Now",
	                "Trending Now title is incorrect"
	        );

	        Assert.assertEquals(
	                homePage.getTrendingNowSubtitle(),
	                "What Kartly shoppers are loving this week",
	                "Trending Now subtitle is incorrect"
	        );
	    }


	    // ============================================================
	    // NEW ARRIVALS TESTS
	    // ============================================================

	    @Test
	    public void verifyNewArrivalsSection() {

	        Assert.assertTrue(
	                homePage.isNewArrivalsSectionDisplayed(),
	                "New Arrivals section is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isNewArrivalsTitleDisplayed(),
	                "New Arrivals title is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isNewArrivalsViewAllDisplayed(),
	                "New Arrivals View All link is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isNewArrivalsCarouselDisplayed(),
	                "New Arrivals carousel is not displayed"
	        );
	    }


	    @Test
	    public void verifyNewArrivalsContent() {

	        Assert.assertEquals(
	                homePage.getNewArrivalsTitle(),
	                "New Arrivals",
	                "New Arrivals title is incorrect"
	        );

	        Assert.assertEquals(
	                homePage.getNewArrivalsSubtitle(),
	                "Fresh on Kartly this month",
	                "New Arrivals subtitle is incorrect"
	        );

	        Assert.assertEquals(
	                homePage.getNewArrivalsViewAllText(),
	                "View all",
	                "New Arrivals View All text is incorrect"
	        );
	    }


	    @Test
	    public void verifyNewArrivalsViewAllUrl() {

	        String actualUrl =
	                homePage.getNewArrivalsViewAllUrl();

	        Assert.assertTrue(
	                actualUrl.contains("/search?badge=new&sort=newest"),
	                "New Arrivals View All URL is incorrect"
	        );
	    }


	    // ============================================================
	    // RECOMMENDED SECTION TESTS
	    // ============================================================

	    @Test
	    public void verifyRecommendedSection() {

	        Assert.assertTrue(
	                homePage.isRecommendedSectionDisplayed(),
	                "Recommended section is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isRecommendedTitleDisplayed(),
	                "Recommended title is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isRecommendedProductGridDisplayed(),
	                "Recommended product grid is not displayed"
	        );
	    }


	    @Test
	    public void verifyRecommendedContent() {

	        Assert.assertEquals(
	                homePage.getRecommendedTitle(),
	                "Recommended for you",
	                "Recommended title is incorrect"
	        );

	        Assert.assertEquals(
	                homePage.getRecommendedSubtitle(),
	                "Based on what's popular with shoppers like you",
	                "Recommended subtitle is incorrect"
	        );
	    }


	    // ============================================================
	    // FOOTER PROMISES TESTS
	    // ============================================================

	    @Test
	    public void verifyFooterPromises() {

	        Assert.assertTrue(
	                homePage.isFooterPromisesDisplayed(),
	                "Footer promises section is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterDeliveryDisplayed(),
	                "Free express delivery promise is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterReturnsDisplayed(),
	                "Returns promise is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterPaymentsDisplayed(),
	                "Secure payments promise is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterSupportDisplayed(),
	                "Customer support promise is not displayed"
	        );
	    }


	    // ============================================================
	    // FOOTER MAIN SECTION TESTS
	    // ============================================================

	    @Test
	    public void verifyFooterBrandDisplayed() {

	        Assert.assertTrue(
	                homePage.isFooterBrandDisplayed(),
	                "Footer brand is not displayed"
	        );
	    }


	    @Test
	    public void verifyFooterSocialLinksDisplayed() {

	        Assert.assertTrue(
	                homePage.isFooterSocialLinksDisplayed(),
	                "Footer social links section is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterInstagramDisplayed(),
	                "Instagram link is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterTwitterDisplayed(),
	                "Twitter link is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterFacebookDisplayed(),
	                "Facebook link is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterYoutubeDisplayed(),
	                "YouTube link is not displayed"
	        );
	    }


	    @Test
	    public void verifyFooterNavigationColumnsDisplayed() {

	        Assert.assertTrue(
	                homePage.isFooterShopColumnDisplayed(),
	                "Footer Shop column is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterDiscoverColumnDisplayed(),
	                "Footer Discover column is not displayed"
	        );

	        Assert.assertTrue(
	                homePage.isFooterYourKartlyColumnDisplayed(),
	                "Footer Your Kartly column is not displayed"
	        );
	    }
	}