package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotUtils {

    // All screenshots are saved inside this folder
    private static final String SCREENSHOT_FOLDER = "ScreenShots/";

    public static void captureScreenshot(WebDriver driver, String testName) {

        try {
            // Create the screenshots folder if it doesn't already exist
            File folder = new File(SCREENSHOT_FOLDER);
            if (!folder.exists()) {
                folder.mkdirs();
            }

          
            File sourceFile =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

      
            String timestamp =
                    new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());

            String fileName = testName + "_" + timestamp + ".png";

            File destinationFile = new File(SCREENSHOT_FOLDER + fileName);

            
            FileUtils.copyFile(sourceFile, destinationFile);

            System.out.println("Screenshot saved at: " + destinationFile.getPath());

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot for test: " + testName);
            e.printStackTrace();
        }
    }
}