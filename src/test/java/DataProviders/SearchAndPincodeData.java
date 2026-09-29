package DataProviders;

import org.testng.annotations.DataProvider;

public class SearchAndPincodeData {

  
    @DataProvider(name = "searchTerms")
    public Object[][] getSearchTerms() {

        return new Object[][] {
                { "Tablet" },
                { "Laptop" },
                { "Headphones" }
                
        };
    }

  
    @DataProvider(name = "deliveryPincodes")
    public Object[][] getDeliveryPincodes() {

        return new Object[][] {
                { "600089" },
                { "560001" },
                { "110001" }
        };
    }
}