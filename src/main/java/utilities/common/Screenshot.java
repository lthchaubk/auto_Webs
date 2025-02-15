package utilities.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public class Screenshot {
    WebDriver driver;

    /**
     * img url for Report
     */
    public static final String PATH_TO_IMG = System.getProperty("user.dir") + "/test-output/img" + File.separator;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String filename) throws IOException {
        String fileName = "FinanBook_" + filename + "-" + Generator.currentDate + ".png";

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(PATH_TO_IMG + fileName));
    }

    public void takeNullDateScreenshot(String filename) throws IOException {
        String fileName = "FinanBook_" + filename + ".png";

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(PATH_TO_IMG + fileName));
    }
}
