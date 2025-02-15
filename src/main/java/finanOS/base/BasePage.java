package finanOS.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import utilities.common.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */

public class BasePage {
    public static WebDriver driver;
    Actions actions;

    public static ExtentReports extent;
    public static ExtentTest logger;
    public static Screenshot screenshot;

    private static boolean isPass = true;

    // report files
    private static String reportUrl = "";
    private static String uploadPath = "";
    private static String uploadFileName = "";

    // log files
    private static String logUrl = "";
    private static String logFileName = "";
    private static String logFilePath = "";

    /**
     * This function will scroll down until find the element
     * Notes:
     */
    public void scrollToFindElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * This function will scroll page
     * Notes:
     * x chỉ áp dụng cho scroll down (scroll đến đâu thì trên UI sẽ call API đến đó nên x sẽ tăng dần)
     */
    public static void scrollPage(String css, Direction direction) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        switch (direction) {
            case TOP:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollTo(0,0)");
                break;
            case LEFT:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollLeft = 0");
                break;
            case RIGHT:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollLeft = 1500");
                break;
            case BOTTOM:
            default:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollTo(0,5000)");
                break;
        }
    }

    public static void scrollPage(String css, Direction direction, int x) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        switch (direction) {
            case TOP:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollTo(0,0)");
                break;
            case LEFT:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollLeft = 0");
                break;
            case RIGHT:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollLeft = 1000");
                break;
            case BOTTOM:
            default:
                js.executeScript("document.getElementsByClassName('" + css + "')[0].scrollTo(0," + 2000 * x + ")");
                break;
        }
    }

    public static void scrollInElements(String elementsByClassName, Direction direction, int endX, int endY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        switch (direction){
            case TOP:
                endX = -endX;
                endY = -endY;
                break;
            case BOTTOM:
                break;
            default:
                Log.addLog("Only support TOP or BOTTOM");
                break;
        }
        js.executeScript("document.getElementsByClassName('" + elementsByClassName + "')[0].scrollBy(" + endX + "," + endY + ")");
    }

    /**
     * These function will action with PAGE DOWN/UP
     * Notes:
     */
    public void pressPageDown() {
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void pressPageUp() {
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
    }

    /**
     * This function will move mouse to element
     * Notes:
     */
    public void mouseHover(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This function will setup date picker
     * Notes:
     * - refer: https://rsuitejs.com/components/date-picker/
     */
    public static void setDatePicker(WebElement dateElement, String yyyy, String mm, String dd) {
        // setup year
        if (getCurrentYear(dateElement) != -1) {
            // action with year
            clickOnCurrentYear(dateElement);
            WebElement listYearElement = null;
            try {
                listYearElement = dateElement.findElement(By.cssSelector("div.rs-calendar-month-dropdown-row-wrapper"));
            } catch (Exception e) {
                Log.addLog("css of div.rs-calendar-month-dropdown-row-wrapper");
            }

            if (listYearElement != null) {
                boolean isFoundYear = false;
                int count = 0;
                Log.addLog("total year display: " + getTotalYearDisplay(listYearElement));
                while(true) {
                    for (int i = 0; i < getTotalYearDisplay(listYearElement); i++) {
                        Log.addLog("year " + getYearByPosition(listYearElement, i));
                        if (getYearByPosition(listYearElement, i).equals(yyyy)) {
                            isFoundYear = true;
                            Log.addLog("Found year " + yyyy);
                            // action with month
                            WebElement listMonthElement = null;
                            try {
                                listMonthElement = getYearElementByPosition(listYearElement, i).findElement(By.cssSelector("div.rs-calendar-month-dropdown-list"));
                            } catch (Exception e) {
                                Log.addLog("css of div.rs-calendar-month-dropdown-list");
                            }

                            if (listMonthElement != null) {
                                Log.addLog("total month display: " + getTotalMonthDisplay(listMonthElement));
                                for (int j = 0; j < getTotalMonthDisplay(listMonthElement); j++) {
                                    Log.addLog("month " + getMonthByPosition(listMonthElement, j));
                                    if (getMonthByPosition(listMonthElement, j).equals(mm)) {
                                        Log.addLog("Found month " + mm);
                                        clickOnMonthByPosition(listMonthElement, j);
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }

                    count++;
                    if ((isFoundYear || count >= 5)) {
                        break;
                    } else {
                        if(Generator.convertStringToInt(getYearByPosition(listYearElement,0)) > Generator.convertStringToInt(yyyy)){
                            Log.addLog("scroll up");
                            scrollInElements("rs-calendar-month-dropdown-row-wrapper", Direction.TOP,0,500);
                        } else {
                            Log.addLog("scroll down");
                            scrollInElements("rs-calendar-month-dropdown-row-wrapper", Direction.BOTTOM, 0, 500);
                        }
                        try {
                            Thread.sleep(Configs.ServerSleep);
                        } catch (Exception e){
                            Log.addLog("error when timeout");
                        }
                    }
                }
            } else {
                Log.addLog("Missing listYearElement, please check");
            }

            // action with date
            WebElement listDateElement = null;
            try {
                listDateElement = dateElement.findElement(By.cssSelector("div.rs-calendar-table"));
            } catch (Exception e) {
                Log.addLog("css of div.rs-calendar-table");
            }

            if (listDateElement != null) {
                Log.addLog("total date display: " + getTotalDateDisplay(listDateElement));
                for (int j = 0; j < getTotalDateDisplay(listDateElement); j++) {
                    if (getDateByPosition(listDateElement, j).equals(dd)) {
                        Log.addLog("Found date " + dd);
                        clickOnDateByPosition(listDateElement, j);
                        break;
                    }
                }
            }

        } else {
            // nothing happen
        }
    }

    private static int getCurrentYear(WebElement dateElement) {
        String currentYear = "-1";
        try {
            if (dateElement != null) {
                currentYear = dateElement.findElement(By.cssSelector("div.rs-calendar > div.rs-calendar-header > div > button:nth-child(2)")).getText();
                currentYear = currentYear.substring(currentYear.length() - 4, currentYear.length());
            }
        } catch (Exception e) {
            Log.addLog("Missing css of Current Month - Year");
        }
        return Generator.convertStringToInt(currentYear);
    }

    private String getCurrentMonth(WebElement dateElement) {
        String currentYear = "";
        try {
            if (dateElement != null) {
                currentYear = dateElement.findElement(By.cssSelector("div.rs-calendar > div.rs-calendar-header > div > button:nth-child(2)")).getText();
                currentYear = currentYear.substring(0, 3);
            }
        } catch (Exception e) {
            Log.addLog("Missing css of Current Month - Year");
        }
        return currentYear;
    }

    private static void clickOnCurrentYear(WebElement dateElement) {
        try {
            if (dateElement != null) {
                dateElement.findElement(By.cssSelector("div.rs-calendar > div.rs-calendar-header > div > button:nth-child(2)")).click();
            }
        } catch (Exception e) {
            Log.addLog("Missing css of Current Month - Year");
        }
    }

    private static WebElement getYearElementByPosition(WebElement element, int pos) {
        WebElement e = null;
        try {
            e = element.findElements(By.cssSelector("div.rs-calendar-month-dropdown-row")).get(pos);
        } catch (Exception exc) {
            Log.addLog("css of div.rs-calendar-month-dropdown-row");
        }
        return e;
    }

    private static int getTotalYearDisplay(WebElement element) {
        int total = 0;
        try {
            total = element.findElements(By.cssSelector("div.rs-calendar-month-dropdown-row")).size();
        } catch (Exception e) {
            Log.addLog("css of div.rs-calendar-month-dropdown-row");
        }
        return total;
    }

    private static String getYearByPosition(WebElement e, int pos) {
        WebElement element = getYearElementByPosition(e, pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector("div.rs-calendar-month-dropdown-year")).getText();
            } catch (Exception ex) {
                Log.addLog("div.rs-calendar-month-dropdown-year at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    private static WebElement getMonthElementByPosition(WebElement element, int pos) {
        WebElement e = null;
        try {
            e = element.findElements(By.cssSelector("div.rs-calendar-month-dropdown-cell")).get(pos);
        } catch (Exception exc) {
            Log.addLog("css of div.rs-calendar-month-dropdown-cell");
        }
        return e;
    }

    private static int getTotalMonthDisplay(WebElement element) {
        int total = 0;
        try {
            total = element.findElements(By.cssSelector("div.rs-calendar-month-dropdown-cell")).size();
        } catch (Exception e) {
            Log.addLog("css of div.rs-calendar-month-dropdown-cell");
        }
        return total;
    }

    private static String getMonthByPosition(WebElement e, int pos) {
        WebElement element = getMonthElementByPosition(e, pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector("span")).getText();
                if(Generator.convertStringToInt(text) < 10){
                    text = "0".concat(text);
                }
            } catch (Exception ex) {
                Log.addLog("span at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    private static void clickOnMonthByPosition(WebElement e, int pos) {
        WebElement element = getMonthElementByPosition(e, pos);
        if (element != null) {
            try {
                element.findElement(By.cssSelector("span")).click();
            } catch (Exception ex) {
                Log.addLog("span at " + pos);
            }
        }
    }

    private static WebElement getDateElementByPosition(WebElement element, int pos) {
        WebElement e = null;
        try {
            e = element.findElements(By.cssSelector("div.rs-calendar-table-cell")).get(pos);
        } catch (Exception exc) {
            Log.addLog("css of div.rs-calendar-table-cell");
        }
        return e;
    }

    private static int getTotalDateDisplay(WebElement element) {
        int total = 0;
        try {
            total = element.findElements(By.cssSelector("div.rs-calendar-table-cell > div.rs-calendar-table-cell-content")).size();
        } catch (Exception e) {
            Log.addLog("css of div.rs-calendar-table-cell > div.rs-calendar-table-cell-content");
        }
        return total;
    }

    private static String getDateByPosition(WebElement e, int pos) {
        WebElement element = getDateElementByPosition(e, pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector("span")).getText();
            } catch (Exception ex) {
                Log.addLog("span at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    private static void clickOnDateByPosition(WebElement e, int pos) {
        WebElement element = getDateElementByPosition(e, pos);
        if (element != null) {
            try {
                element.findElement(By.cssSelector("span")).click();
            } catch (Exception ex) {
                Log.addLog("span at " + pos);
            }
        }
    }

    /**
     * Clear() method
     * Note: use for methods that .clear() is not working
     */
    public void clearTextBox(WebElement element, String error) {
        try {
            String osName = System.getProperty("os.name");
            if (osName.toLowerCase().startsWith("mac")) {
                element.sendKeys(Keys.COMMAND + "A");
            } else {
                element.sendKeys(Keys.CONTROL + "A");
            }
            element.sendKeys(Keys.DELETE);
        } catch (Exception e) {
            Log.addLog(error);
        }
    }

    /**
     * These method use for commandLine mode
     * Note: Selenium - java ver 4.6.0 above remove WebDriverManager.chromedriver().setup();
     */
    public static void setUpCmdLine() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1400,800");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(Configs.env.getDomain());
    }

    public static void setupReportCmdLine(String testName) {
        String reportConfigFile = System.getProperty("user.dir") + "/Resources/ConfigFileNProperties/extent-config.xml";

        uploadFileName = testName + "_" + Generator.currentDate + ".html";
        uploadPath = System.getProperty("user.dir") + "/test-output/reportCML/" + uploadFileName;

        extent = new ExtentReports(uploadPath, true);
        extent.addSystemInfo("Host Name", Configs.env.toString())
                .addSystemInfo("Environment", Configs.env.getName())
                .addSystemInfo("User Name", Setting.author.toString());
        extent.loadConfig(new File(reportConfigFile));
        logFileName = Log.addLog(testName, "Start Test: " + testName);
        logFilePath = System.getProperty("user.dir") + "/test-output/log/" + logFileName;

        // Screenshot
        screenshot = new Screenshot(driver);
    }

    public static void endTestCmdLine(LogStatus logStatus, String testName) {
        if (logStatus == LogStatus.FAIL)
            isPass = false;

        if (extent != null) {
            extent.endTest(logger);
        }

        if (driver != null)
            driver.quit();

        extent.flush();
        extent.close();
        Log.addLog("********************** END TEST ************************\n");

        // upload to S3 - log
        if (Configs.isUploadToCloud) {
            boolean isUploaded = false;
            int retry = 10;
            while (!isUploaded) {
                try {
                    Thread.sleep(Configs.ServerDeepSleep);
                } catch (Exception e) {
                    Log.addLog("Error when system waiting file to upload");
                }

                isUploaded = FileUploadS3.uploadLogFileToS3(logFileName, logFilePath);

                if (retry <= 1)
                    break;
                retry--;
            }

            if (isUploaded) {
                try {
                    logUrl = FileUploadS3.getLogFileFromS3(logFileName);
                    Log.addLog("Uploaded log file to S3: " + logUrl);
                } catch (Exception e) {
                    Log.addLog("Can't get logUrl from S3");
                }
            }

//            Log.addLog("Debug log url: " + logUrl);
        }

        // upload to S3 - report
        if (Configs.isUploadToCloud) {
            boolean isUploaded = false;
            int retry = 10;
            while (!isUploaded) {
                try {
                    Thread.sleep(Configs.ServerDeepSleep);
                } catch (Exception e) {
                    Log.addLog("Error when system waiting file to upload");
                }

                isUploaded = FileUploadS3.uploadFileToS3(uploadFileName, uploadPath);

                if (retry <= 1)
                    break;
                retry--;
            }

            if (isUploaded) {
                try {
                    reportUrl = FileUploadS3.getFileFromS3(uploadFileName);
                    Log.addLog("Uploaded report file to S3: " + reportUrl);
                } catch (Exception e) {
                    Log.addLog("Can't get reportUrl from S3");
                }
            }
//            Log.addLog("Debug url: " + reportUrl);
        }

        // hook to slack
        if (Configs.isHookToLark) {
            LarkWebhook.postEndRequest("Test scenario: " + testName, reportUrl, logUrl, isPass);
        }
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println("hello - debug for date picker");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://rsuitejs.com/components/date-picker/");
//        driver.manage().window().maximize();
//        driver.findElement(By.cssSelector("#__next > div > div > div.page-context > div > div.main-container > div > div:nth-child(4) > div.rcv-container > div.rcv-render > div > div")).click();
//        Thread.sleep(Configs.ServerDeepSleep);
//        WebElement element = null;
//        try {
//            element = driver.findElement(By.cssSelector("div.rs-calendar"));
//        } catch (Exception e){
//            System.out.println("css of rs-calendar");
//        }
//
//        if(element != null){
//            setDatePicker(element, "2011","09","11");
//        }
//    }
}
