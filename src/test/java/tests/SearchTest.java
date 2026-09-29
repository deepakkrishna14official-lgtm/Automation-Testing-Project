package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import DataProviders.SearchAndPincodeData;
import Pages.HomePage;
import Pages.SearchPage;

public class SearchTest extends BaseTest {

    private HomePage homePage;
    private SearchPage searchPage;

  
    @BeforeMethod
    public void initializePages(Object[] testData) {

        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);

        String searchTerm =
                (testData != null && testData.length > 0)
                        ? (String) testData[0]
                        : "laptop";

        homePage.enterSearchText(searchTerm);
        homePage.clickSearchButton();
    }


    // =========================================================
    // SEARCH RESULTS
    // =========================================================
    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySearchResultsDisplayed(String searchTerm) {

        Assert.assertTrue(
                searchPage.isListingPageDisplayed(),
                "Search listing page should be displayed"
        );
    }

    

    // =========================================================
    // SORT DROPDOWN
    // =========================================================

    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortDropdownDisplayed(String searchTerm) {

        Assert.assertTrue(
                searchPage.isSortDropdownDisplayed(),
                "Sort dropdown should be displayed"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortByRelevance(String searchTerm) {

        searchPage.selectSortOption("relevance");

        Assert.assertEquals(
                searchPage.getSelectedSortOption(),
                "relevance",
                "Relevance sorting was not selected"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortByPopularity(String searchTerm) {

        searchPage.selectSortOption("popularity");

        Assert.assertEquals(
                searchPage.getSelectedSortOption(),
                "popular",
                "Popularity sorting was not selected"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortByPriceLowToHigh(String searchTerm) {

        searchPage.selectSortOption("price_low_to_high");

        Assert.assertEquals(
                searchPage.getSelectedSortOption(),
                "price_asc",
                "Price Low to High sorting was not selected"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortByPriceHighToLow(String searchTerm) {

        searchPage.selectSortOption("price_high_to_low");

        Assert.assertEquals(
                searchPage.getSelectedSortOption(),
                "price_desc",
                "Price High to Low sorting was not selected"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortByRating(String searchTerm) {

        searchPage.selectSortOption("rating");

        Assert.assertEquals(
                searchPage.getSelectedSortOption(),
                "rating",
                "Customer Rating sorting was not selected"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortByDiscount(String searchTerm) {

        searchPage.selectSortOption("discount");

        Assert.assertEquals(
                searchPage.getSelectedSortOption(),
                "discount",
                "Biggest Discount sorting was not selected"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifySortByNewest(String searchTerm) {

        searchPage.selectSortOption("newest");

        Assert.assertEquals(
                searchPage.getSelectedSortOption(),
                "newest",
                "Newest First sorting was not selected"
        );
    }


    // =========================================================
    // GRID / LIST VIEW
    // =========================================================

    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyGridView(String searchTerm) {

        Assert.assertTrue(
                searchPage.isGridViewButtonDisplayed(),
                "Grid view button should be displayed"
        );

        searchPage.clickGridView();

        Assert.assertTrue(
                searchPage.isGridViewActive(),
                "Grid view should be active"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyListView(String searchTerm) {

        Assert.assertTrue(
                searchPage.isListViewButtonDisplayed(),
                "List view button should be displayed"
        );

        searchPage.clickListView();

        Assert.assertTrue(
                searchPage.isListViewActive(),
                "List view should be active"
        );
    }


    // =========================================================
    // PRICE FILTER
    // =========================================================

    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyPriceFiltersDisplayed(String searchTerm) {

        Assert.assertTrue(
                searchPage.isPriceFilterDisplayed("0-500"),
                "Under 500 price filter should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPriceFilterDisplayed("500-2000"),
                "500-20000 price filter should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPriceFilterDisplayed("2000-10000"),
                "2000-10000 price filter should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPriceFilterDisplayed("10000-50000"),
                "100000-500000 price filter should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPriceFilterDisplayed("50000-500000"),
                "Above 50000 price filter should be displayed"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyPriceFilterSelection(String searchTerm) {

        searchPage.selectPriceFilter("2000-10000");

        Assert.assertTrue(
                searchPage.isPriceFilterActive("2000-10000"),
                "2000-10000 filter should be active"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyPriceFilterAndUrl(String searchTerm) {

        searchPage.selectPriceFilter("10000-50000");

        Assert.assertTrue(
                searchPage.isPriceFilterActive("10000-50000"),
                "10000-50000 filter should be active"
        );

        Assert.assertTrue(
                searchPage.isUrlParameterPresent(
                        "minPrice",
                        "10000"
                ),
                "URL should contain minPrice=10000"
        );

        Assert.assertTrue(
                searchPage.isUrlParameterPresent(
                        "maxPrice",
                        "50000"
                ),
                "URL should contain maxPrice=50000"
        );
    }


    // =========================================================
    // PRICE INPUT
    // =========================================================

    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyMinimumPriceInput(String searchTerm) {

        searchPage.enterMinimumPrice("15000");

        Assert.assertEquals(
                searchPage.getMinimumPrice(),
                "15000",
                "Minimum price value is incorrect"
        );
    }


    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyMaximumPriceInput(String searchTerm) {

        searchPage.enterMaximumPrice("40000");

        Assert.assertEquals(
                searchPage.getMaximumPrice(),
                "40000",
                "Maximum price value is incorrect"
        );
    }


    // =========================================================
    // FILTER GROUPS
    // =========================================================

    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyFilterGroupsDisplayed(String searchTerm) {

        Assert.assertTrue(
                searchPage.isCategoryFilterDisplayed(),
                "Category filter should be displayed"
        );

        Assert.assertTrue(
                searchPage.isBrandFilterDisplayed(),
                "Brand filter should be displayed"
        );

        Assert.assertTrue(
                searchPage.isRatingFilterDisplayed(),
                "Rating filter should be displayed"
        );

        Assert.assertTrue(
                searchPage.isBrandFilterListDisplayed(),
                "Brand filter list should be displayed"
        );
    }


    // =========================================================
    // POPULAR SEARCHES
    // =========================================================

    @Test(dataProvider = "searchTerms", dataProviderClass = SearchAndPincodeData.class)
    public void verifyPopularSearches(String searchTerm) {

        Assert.assertTrue(
                searchPage.isPopularSearchDisplayed("earbuds"),
                "Earbuds popular search should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPopularSearchDisplayed("sneakers"),
                "Sneakers popular search should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPopularSearchDisplayed("serum"),
                "Serum popular search should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPopularSearchDisplayed("watch"),
                "Watch popular search should be displayed"
        );

        Assert.assertTrue(
                searchPage.isPopularSearchDisplayed("sofa"),
                "Sofa popular search should be displayed"
        );
    }
}