package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LogInPage;
import Utilities.ExcelUtility;

public class LoginTest extends BaseTest {

    // =========================================================
    // EXCEL DATA PROVIDER
    // =========================================================

    @DataProvider(name = "Login Creadential")
    public Object[][] loginData() {

        String filePath = "src/test/resources/LogInData Ecommerce.xlsx";

        String sheetName = "Login Creadential";

        ExcelUtility excel =
                new ExcelUtility(filePath, sheetName);

        int rowCount = excel.getRowCount();

        int columnCount = excel.getColumnCount();

        Object[][] data =
                new Object[rowCount - 1][columnCount];

        // Start from row 1 because row 0 contains headers
        for (int i = 1; i < rowCount; i++) {

            for (int j = 0; j < columnCount; j++) {

                data[i - 1][j] =
                        excel.getCellData(i, j);
            }
        }

        excel.closeWorkbook();

        return data;
    }
    
    // =========================================================
    // LOGIN TEST USING EXCEL DATA
    // =========================================================

    @Test(dataProvider = "Login Creadential")
    public void verifyLogin(
            String testCase,
            String email,
            String password,
            String expectedResult) {

        LogInPage loginPage = new LogInPage(driver);

        // Open Account menu
        loginPage.clickAccountMenu();

        // Click Sign In
        loginPage.clickSignInLink();

        // Select Sign In tab
        loginPage.clickSignInTab();

        // Enter credentials from Excel
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        // Submit login
        loginPage.clickLoginSubmit();

        // =====================================================
        // VALID LOGIN
        // =====================================================
       

            Assert.assertEquals(
                    loginPage.getLoginStatus(),
                    "true",
                    "Login status is not true for: " + testCase
            );

        }
    
   

    // =========================================================
    // DEMO ACCOUNT LOGIN
    // =========================================================

    @Test
    public void verifyDemoAccountLogin() {

        LogInPage loginPage =
                new LogInPage(driver);

        loginPage.loginWithDemoAccount();

        Assert.assertTrue(
                loginPage.isUserLoggedIn(),
                "Demo account login failed."
        );
    }

    
}