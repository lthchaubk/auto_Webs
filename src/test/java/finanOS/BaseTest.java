package finanOS;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.common.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static Screenshot screenshot;

    private static String className;
    private static boolean isPass = true;
    private static String reportConfigFile = System.getProperty("user.dir") + "/Resources/ConfigFileNProperties/extent-config.xml";

    // report files
    private static String reportUrl = "";
    private static String uploadPath = "";
    private static String uploadFileName = "";

    // log files
    private static String logUrl = "";
    private static String logFileName = "";
    private static String logFilePath = "";

    /**
     * Note for other drivers: -----------------------------------
     * WebDriver driver = new SafariDriver(); => Safari, IE don't support basic auth HTTP
     * ------------------------------------------------------------
     * System.setProperty("webdriver.gecko.driver","WebDriver/geckodriver.exe");
     * or move geckodriver to "/usr/local/bin" => don't need to use System.setProperty()
     * driver = new FirefoxDriver();
     */
    @BeforeMethod
    public void setUp(Method method) {
        /**
         * 2 options to set up chromedriver when having the new version
         * 1. Download new version > up to folder "/Users/[]/Documents/GitHub/AutoWeb/WebDriver/chromedriver"
         * > setUp: System.setProperty("webdriver.chrome.driver", "/Users/[]/Documents/GitHub/AutoWeb/WebDriver/chromedriver");
         * 2. add WebDriverManager library into pom file => this option only setup 1 time
         * > setUp: WebDriverManager.chromedriver().setup();
         */
        switch (Configs.browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
//                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/driver/chromedriver");
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                break;
            default:
                Log.addLog("Missing browser configs!!!");
                break;
        }

        if (Configs.isHeadlessMode) {
            switch (Configs.browser){
                case CHROME:
                    Log.addLog("Run with headless mode");

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("headless");
                    chromeOptions.addArguments("window-size=1400,800");
                    chromeOptions.addArguments("disable-gpu");
                    chromeOptions.addArguments("no-sandbox");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case SAFARI:
                    Log.addLog("Safari can't run with headless mode");
                    driver = new SafariDriver();
                    break;
                default:
                    Log.addLog("Missing browser configs!!!");
                    break;
            }
        } else {
            switch (Configs.browser){
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                default:
                    Log.addLog("Missing browser configs!!!");
                    break;
            }
        }

        driver.get(Configs.env.getDomain());

        if (MobileWeb.isMobileWeb) {
            // setup mobile web - Pixel 2
            driver.manage().window().setSize(MobileWeb.pixel2);
        } else {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        screenshot = new Screenshot(driver);
    }

    @BeforeTest
    public void startReport() throws Exception {
        className = this.getClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);

        uploadFileName = className + "_" + Generator.currentDate + ".html";
        uploadPath = System.getProperty("user.dir") + Configs.env.getReportPath() + uploadFileName;
        extent = new ExtentReports(uploadPath, true);
        extent
                .addSystemInfo("Host Name", Configs.env.toString())
                .addSystemInfo("Environment", Configs.env.getName())
                .addSystemInfo("User Name", Setting.author.toString());
        extent.loadConfig(new File(reportConfigFile));
        logFileName = Log.addLog(className, "Start Test: " + className);
        logFilePath = System.getProperty("user.dir") + "/test-output/log/" + logFileName;

        // hook to Lark
        if (Configs.isHookToLark) {
            // implement later
//            LarkWebhook.postStartRequest("START TEST: " + className, "Finan Book");
        }
    }

    @AfterTest
    public void endReport() {
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
                } catch (Exception e) {
                    Log.addLog("Can't get reportUrl from S3");
                }
            }

//            Log.addLog("Debug url: " + reportUrl);
        }

        // hook to Lark
        if (Configs.isHookToLark) {
            LarkWebhook.postEndRequest(className, reportUrl, logUrl, isPass);
        }
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws Exception {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            screenshot.takeScreenshot(testResult.getName());
            Reports.reportWithIsDisplay(logger, false, "Failed at " + testResult.getName(), testResult.getName());
            Reports.reportWithStatus(logger, false, "Failed by " + testResult.getThrowable());

            isPass = false;

            if (ScreenRecording.screenRecorder != null) {
//                Reports.reportWithVideo(logger,false,"Report video",testResult.getName());
                ScreenRecording.stopRecording();
            }
        } else if (testResult.getStatus() == ITestResult.SUCCESS) {
            Reports.reportWithStatus(logger, true, testResult.getName() + " - Passed");

            if (ScreenRecording.screenRecorder != null) {
//                Reports.reportWithVideo(logger,true,"Report video",testResult.getName());
                ScreenRecording.stopRecording();
            }
        } else {
            logger.log(LogStatus.SKIP, "Skipped is " + testResult.getName());

            if (ScreenRecording.screenRecorder != null) {
                ScreenRecording.stopRecording();
            }
        }

        // hook to Lark
        if (Configs.isHookToLark) {
            // implement later
//            if ((Configs.onlyHookFailed && testResult.getStatus() == ITestResult.FAILURE) || !Configs.onlyHookFailed) {
//                LarkWebhook.postRequest(testResult, "Testcase - " + testResult.getName());
//            }
        }

        if (extent != null) {
            extent.endTest(logger);
        }

        Log.addLog("================ NEXT TESTCASE ======================");
        if (driver != null)
            driver.quit();
    }
}
