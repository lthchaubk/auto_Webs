package testcase;

import finanOS.BaseTest;
import finanOS.home.HomePage;
import finanOS.login.owner.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.common.Accounts;
import utilities.common.Log;
import utilities.common.Reports;

/**
 * Author: chaule
 * Created_at: 16Jun2023
 * Testcase: https://sobanhang.larksuite.com/wiki/NPggwsd2tiIHrCk2DC5uDFevsqc
 * Note:
 */
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    Accounts accounts;

    @Test(priority = 1)
    private void checkLoginSuccessful() throws Exception {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accounts = Configs.account;
        logger = extent.startTest("Check login successful");

        Thread.sleep(Configs.ServerSleep);
        String imgName = "login_case1_1";
        screenshot.takeScreenshot(imgName);

        if(loginPage.isDisplay()){
            Log.addInfoLog(logger,"Display Finan Book - Login Page, set username & pwd",imgName);
            loginPage.setPhoneOrEmailTextBox(accounts.getEmail());
            loginPage.setPwdTextBox(accounts.getPwd());

            String imgName2 = "login_case1_2";
            screenshot.takeScreenshot(imgName2);
            Log.addInfoLog(logger,"Click on Continue button",imgName2);
            loginPage.clickOnLoginButton();

            Log.addLog("Debug homePage display: " + homePage.isDisplay()); // Log này để gọi homePage và nhận implicit wait
            Thread.sleep(Configs.ServerDeepSleep); // explicit wait để load data cho element

            String imgName3 = "login_case1_3";
            screenshot.takeScreenshot(imgName3);
            Reports.reportWithIsDisplay(logger, homePage.isDisplay(), "Login successful, display Home Page", imgName3);
        } else {
            Log.addWarningLog(logger,"Don't display Finan Book - Login Page, at PhoneTab, set phone number",imgName);
        }

        Assert.assertTrue(homePage.isDisplay());
    }

//    @Test(priority = 2)
//    private void checkLoginSuccessfulWithEmail() throws Exception {
//        loginPage = new LoginPage(driver);
//        homePage = new HomePage(driver);
//        accounts = Configs.account;
//        logger = extent.startTest("Check login successful with Email");
//
//        Thread.sleep(Configs.ServerDeepSleep);
//        String imgName = "login_case2_1";
//        screenshot.takeScreenshot(imgName);
//
//        if(loginPage.isDisplay()){
//            Log.addInfoLog(logger,"Display Finan Book - Login Page, at PhoneTab, click on Email tab",imgName);
//            loginPage.clickOnEmailTab();
//
//            String imgName1 = "login_case2_2";
//            screenshot.takeScreenshot(imgName1);
//            Log.addInfoLog(logger,"Display Finan Book - Login Page, at Email Tab, set email",imgName1);
//
//            loginPage.setEmailTextBox(accounts.getEmail());
//
//            String imgName2 = "login_case2_3";
//            screenshot.takeScreenshot(imgName2);
//            Log.addInfoLog(logger,"Click on Continue button",imgName2);
//
//            loginPage.clickOnContinueButton();
//
//            String imgName3 = "login_case1_4";
//            screenshot.takeScreenshot(imgName3);
//            if(loginPage.isDisplayPasswordTitle()){
//                Log.addInfoLog(logger,"Input password []");
//                loginPage.setPwdTextBox(accounts.getPwd());
//                Thread.sleep(Configs.ServerSleep);
//
//                String imgName5 = "login_case1_6";
//                screenshot.takeScreenshot(imgName5);
//                Log.addInfoLog(logger,"Click Continue to login", imgName5);
//                loginPage.clickOnLoginButton();
//                Thread.sleep(30000);
//
//                String imgName4 = "login_case1_5";
//                screenshot.takeScreenshot(imgName4);
//
//                Reports.reportWithIsDisplay(logger, homePage.isDisplay(), "Login successful, display Home Page", imgName4);
//            }
//        } else {
//            Log.addWarningLog(logger,"Don't display Finan Book - Login Page, at PhoneTab, set phone number",imgName);
//        }
//
//        Assert.assertTrue(homePage.isDisplay());
//    }
}


