package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.WaitUtility;

public class SearchPage {
	
    private WebDriver driver;
    
    //========Search Page Locators========//
	
	  private By ListingPage =
	            By.cssSelector("[data-testid='listing-page']");
	  

	    private By Breadcrumb =
	            By.cssSelector("[data-testid='breadcrumb']");

	    private By BreadcrumbHomeLink =
	            By.cssSelector("[data-testid='breadcrumb-home-link']");

	    private By BreadcrumbCurrent =
	            By.cssSelector("[data-testid='breadcrumb-current']");

	 // ==================== FILTERS ====================

	    private By FilterSidebar =
	            By.cssSelector("[data-testid='filter-sidebar']");

	    private By FilterPanel =
	            By.cssSelector("[data-testid='filter-panel']");

	    private By CategoryFilterGroup =
	            By.cssSelector("[data-testid='filter-group-category']");

	    private By PriceFilterGroup =
	            By.cssSelector("[data-testid='filter-group-price']");

	    private By BrandFilterGroup =
	            By.cssSelector("[data-testid='filter-group-brand']");

	    private By RatingFilterGroup =
	            By.cssSelector("[data-testid='filter-group-rating']");

	    private By BrandFilterList =
	            By.cssSelector("[data-testid='filter-brand-list']");

	    private By MinPriceInput =
	            By.cssSelector("[data-testid='filter-price-min-input']");

	    private By MaxPriceInput =
	            By.cssSelector("[data-testid='filter-price-max-input']");

	    private By InStockCheckbox =
	            By.cssSelector("[data-testid='filter-in-stock']");

	    private By ClearAllFiltersButton =
	            By.cssSelector("[data-testid='clear-all-filters-button']");
	    
	    	    
	 // ==================== LISTING TOOLBAR ====================

	    private By ListingToolbar =
	            By.cssSelector("[data-testid='listing-toolbar']");

	    private By ListingTitle =
	            By.cssSelector("[data-testid='listing-title']");

	    private By ResultsCount =
	            By.cssSelector("[data-testid='results-count']");

	    private By MobileFiltersButton =
	            By.cssSelector("[data-testid='mobile-filters-open-button']");

	    private By ActiveFilterCount =
	            By.cssSelector("[data-testid='active-filter-count']");

	    private By SortSelect =
	            By.cssSelector("[data-testid='sort-select']");

	 
	    private By GridViewButton =
	            By.cssSelector("[data-testid='view-mode-grid-button']");

	    private By ListViewButton =
	            By.cssSelector("[data-testid='view-mode-list-button']");
	    
	 // ==================== REUSABLE LOCATORS ====================

	    private By getPriceFilterLocator(String priceRange) {

	        return By.cssSelector(
	                "[data-testid='filter-price-"+priceRange+"']"
	        );
	    }
	    
	   
	    private By getPopularSearchLocator(String searchTerm) {

	        return By.cssSelector(
	                "[data-testid='popular-search-"+searchTerm+"']"
	        );
	    }
	    
	    
	    private By PulseonHiveTabletProduct =
	            By.cssSelector(
	                "[data-testid='product-title-pulseon-hive-tablet-graphite-61']"
	            );
	  


	   // ===================== CONSTRUCTOR ====================//

public SearchPage(WebDriver driver) {
    this.driver = driver;
}

public boolean isListingPageDisplayed() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    ListingPage,
                    10)
            .isDisplayed();
}

public boolean isBreadcrumbDisplayed() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    Breadcrumb,
                    10)
            .isDisplayed();
}


public boolean isBreadcrumbHomeDisplayed() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    BreadcrumbHomeLink,
                    10)
            .isDisplayed();
}


public String getBreadcrumbHomeText() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    BreadcrumbHomeLink,
                    10)
            .getText()
            .trim();
}


public String getBreadcrumbCurrentText() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    BreadcrumbCurrent,
                    10)
            .getText()
            .trim();
}

//==================== LISTING TOOLBAR METHODS ====================

public boolean isListingToolbarDisplayed() {
 return WaitUtility
         .waitForElementToBeVisible(driver, ListingToolbar, 10)
         .isDisplayed();
}

public boolean isListingTitleDisplayed() {
 return WaitUtility
         .waitForElementToBeVisible(driver, ListingTitle, 10)
         .isDisplayed();
}

public String getListingTitle() {
 return WaitUtility
         .waitForElementToBeVisible(driver, ListingTitle, 10)
         .getText()
         .trim();
}

public boolean isResultsCountDisplayed() {
 return WaitUtility
         .waitForElementToBeVisible(driver, ResultsCount, 10)
         .isDisplayed();
}

public String getResultsCountText() {
 return WaitUtility
         .waitForElementToBeVisible(driver, ResultsCount, 10)
         .getText()
         .trim();
}

public int getTotalResultsCount() {
	 
	 String total = WaitUtility
	            .waitForElementToBeVisible(driver, ResultsCount, 10)
	            .getAttribute("data-total");

	    return Integer.parseInt(total);
	}

public boolean isMobileFiltersButtonDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, MobileFiltersButton, 10)
            .isDisplayed();
}

public void clickMobileFiltersButton() {
    WaitUtility
            .waitForElementClickable(driver, MobileFiltersButton, 10)
            .click();
}

public int getActiveFilterCount() {
    String count =
            WaitUtility
                    .waitForElementToBeVisible(driver, ActiveFilterCount, 10)
                    .getText()
                    .trim();

    return Integer.parseInt(count);
}

public boolean isSortDropdownDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, SortSelect, 10)
            .isDisplayed();
}

public void selectSortOption(String option) {

    Select sortDropdown = new Select(
            WaitUtility
                    .waitForElementToBeVisible(driver, SortSelect, 10)
    );

    switch (option.toLowerCase()) {

        case "relevance":
            sortDropdown.selectByValue("relevance");
            break;

        case "popularity":
            sortDropdown.selectByValue("popular");
            break;

        case "price_low_to_high":
            sortDropdown.selectByValue("price_asc");
            break;

        case "price_high_to_low":
            sortDropdown.selectByValue("price_desc");
            break;

        case "rating":
            sortDropdown.selectByValue("rating");
            break;

        case "discount":
            sortDropdown.selectByValue("discount");
            break;

        case "newest":
            sortDropdown.selectByValue("newest");
            break;

        default:
            throw new IllegalArgumentException(
                    "Invalid sort option: " + option
            );
    }
}

public String getSelectedSortOption() {

    Select sortDropdown = new Select(
            WaitUtility
                    .waitForElementToBeVisible(driver, SortSelect, 10)
    );

    return sortDropdown
            .getFirstSelectedOption()
            .getAttribute("value");
}

public boolean isGridViewButtonDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, GridViewButton, 10)
            .isDisplayed();
}

public boolean isListViewButtonDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, ListViewButton, 10)
            .isDisplayed();
}

public void clickGridView() {
    WaitUtility
            .waitForElementClickable(driver, GridViewButton, 10)
            .click();
}

public void clickListView() {
    WaitUtility
            .waitForElementClickable(driver, ListViewButton, 10)
            .click();
}

public boolean isGridViewActive() {
    return "true".equals(
            WaitUtility
                    .waitForElementToBeVisible(driver, GridViewButton, 10)
                    .getAttribute("aria-pressed"));
}

public boolean isListViewActive() {
    return "true".equals(
            WaitUtility
                    .waitForElementToBeVisible(driver, ListViewButton, 10)
                    .getAttribute("aria-pressed"));
   }





//==================== FILTERS METHODS ====================
public boolean isCategoryFilterDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, CategoryFilterGroup, 10)
            .isDisplayed();
}


public boolean isBrandFilterDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, BrandFilterGroup, 10)
            .isDisplayed();
}

public boolean isRatingFilterDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, RatingFilterGroup, 10)
            .isDisplayed();
}

public boolean isBrandFilterListDisplayed() {
    return WaitUtility
            .waitForElementToBeVisible(driver, BrandFilterList, 10)
            .isDisplayed();
}

//==================== PRICE FILTER METHODS ====================

public boolean isPriceFilterDisplayed(String priceRange) {

 By priceFilter = getPriceFilterLocator(priceRange);

 return WaitUtility
         .waitForElementToBeVisible(
                 driver,
                 priceFilter,
                 10
         )
         .isDisplayed();
}


public void selectPriceFilter(String priceRange) {

 By priceFilter = getPriceFilterLocator(priceRange);

 WaitUtility
         .waitForElementClickable(
                 driver,
                 priceFilter,
                 10
         )
         .click();
}


public boolean isPriceFilterActive(String priceRange) {

    By priceFilter = getPriceFilterLocator(priceRange);

    return WaitUtility.waitForAttributeToBe(
            driver,
            priceFilter,
            "data-active",
            "true",
            10
    ).isDisplayed();
}

public String getPriceFilterText(String priceRange) {

 By priceFilter = getPriceFilterLocator(priceRange);

 return WaitUtility
         .waitForElementToBeVisible(
                 driver,
                 priceFilter,
                 10
         )
         .getText()
         .trim();
}
public void enterMinimumPrice(String minimumPrice) {

    WebElement minPriceInput =
            WaitUtility.waitForElementToBeVisible(
                    driver,
                    MinPriceInput,
                    10
            );

    minPriceInput.clear();
    minPriceInput.sendKeys(minimumPrice);
}


public String getMinimumPrice() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    MinPriceInput,
                    10
            )
            .getAttribute("value");
}
public void enterMaximumPrice(String maximumPrice) {

    WebElement maxPriceInput =
            WaitUtility.waitForElementToBeVisible(
                    driver,
                    MaxPriceInput,
                    10
            );

    maxPriceInput.clear();
    maxPriceInput.sendKeys(maximumPrice);
}


public String getMaximumPrice() {

    return WaitUtility
            .waitForElementToBeVisible(
                    driver,
                    MaxPriceInput,
                    10
            )
            .getAttribute("value");
}

//==================== POPULAR SEARCH METHODS ====================

public boolean isPopularSearchDisplayed(String searchTerm) {

 By popularSearch =
         getPopularSearchLocator(searchTerm);

 return WaitUtility
         .waitForElementToBeVisible(
                 driver,
                 popularSearch,
                 10
         )
         .isDisplayed();
}


public void clickPopularSearch(String searchTerm) {

 By popularSearch =
         getPopularSearchLocator(searchTerm);

 WaitUtility
         .waitForElementClickable(
                 driver,
                 popularSearch,
                 10
         )
         .click();
}


public boolean isPopularSearchActive(String searchTerm) {

 By popularSearch =
         getPopularSearchLocator(searchTerm);

 return "true".equals(
         WaitUtility
                 .waitForElementToBeVisible(
                         driver,
                         popularSearch,
                         10
                 )
                 .getAttribute("aria-pressed")
 );
}


public String getPopularSearchText(String searchTerm) {

 By popularSearch =
         getPopularSearchLocator(searchTerm);

 return WaitUtility
         .waitForElementToBeVisible(
                 driver,
                 popularSearch,
                 10
         )
         .getText()
         .trim();
}


//==================== URL METHODS ====================

public boolean isUrlParameterPresent(
     String parameter,
     String expectedValue) {

 String expectedParameter =
         parameter + "=" + expectedValue;

 return WaitUtility.waitForUrlContains(
         driver,
         expectedParameter,
         10
 );
}

//============for product page test
public void clickPulseonHiveTablet() {

    WaitUtility.waitForElementClickable(
            driver,
            PulseonHiveTabletProduct,
            10
    ).click();
}
}