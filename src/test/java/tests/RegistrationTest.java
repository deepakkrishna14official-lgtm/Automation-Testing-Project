package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LogInPage;
import Pages.RegisterPage;
import Utilities.ExcelUtility;

public class RegistrationTest extends BaseTest {

    // =========================================================
    // EXCEL DATA PROVIDER
    // =========================================================

    @DataProvider(name = "Registration Credentials")
    public Object[][] registrationData() {

        String filePath =
                "src/test/resources/LogInData Ecommerce.xlsx";

        String sheetName = "Registration Credentials";

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
    // REGISTRATION TEST USING EXCEL DATA
    // =========================================================

    @Test(dataProvider = "Registration Credentials")
    public void verifyRegistration(
            String testCase,
            String email,
            String password,
            String expectedResult) {

        LogInPage loginPage =
                new LogInPage(driver);

        RegisterPage registrationPage =
                new RegisterPage(driver);

        // =====================================================
        // NAVIGATE TO REGISTRATION PAGE
        // =====================================================

        loginPage.clickAccountMenu();

        loginPage.clickSignInLink();

        registrationPage.clickSignUpTab();


        // =====================================================
        // ENTER REGISTRATION DATA FROM EXCEL
        // =====================================================

        registrationPage.enterEmail(email);

        registrationPage.enterPassword(password);


        // =====================================================
        // SUBMIT REGISTRATION
        // =====================================================

        registrationPage.clickRegistrationSubmit();


        // =====================================================
        // SUCCESSFUL REGISTRATION
        // =====================================================

   

        	 Assert.assertEquals(
                     loginPage.getLoginStatus(),
                     "true",
                     "Register status is not true for: " + testCase
             );
        }

      
}