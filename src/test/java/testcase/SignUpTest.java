package testcase;

import apiFinanOne.Mailinator.MailBox;
import finanOS.BaseTest;
import finanOS.home.HomePage;
import finanOS.login.owner.LoginPage;
import finanOS.register.SignUpInformationPage;
import finanOS.register.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.common.Generator;
import utilities.common.Log;
import utilities.common.Reports;

public class SignUpTest extends BaseTest {
    LoginPage loginPage;
    SignUpPage signUpPage;
    SignUpInformationPage signUpInformationPage;
    HomePage homePage;

    @Test (priority = 1)
    private void checkConditionToDisplaySignUpPage() throws Exception{
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);

        logger = extent.startTest("Check condition to display Register Page - from hyperlink at Login Page");

        Thread.sleep(Configs.ServerDeepSleep);
        String imgName = "sign_up_1_1";
        screenshot.takeScreenshot(imgName);

        if(loginPage.isDisplay()){
            Log.addInfoLog(logger,"Display Finan Book - Login Page, click on Sign up hyperlink",imgName);
            loginPage.clickOnSignUpLink();

            String imgName2 = "sign_up_1_2";
            screenshot.takeScreenshot(imgName2);

            Reports.reportWithIsDisplay(logger, signUpPage.isDisplay(), "Display Register Page, include:",imgName2);
            // bonus check all object display on UI
            Reports.reportWithIsDisplay(logger,signUpPage.isDisplayBackIcon(),"-- Back Icon");
            Reports.reportWithIsDisplay(logger,signUpPage.isDisplayPageTitle(),"-- Page Title: " + signUpPage.getPageTitle());
            Reports.reportWithIsDisplay(logger,signUpPage.isDisplayPhoneTab(),"-- Phone Tab: " + signUpPage.getPhoneTabText());
            Reports.reportWithIsDisplay(logger,signUpPage.isDisplayEmailTab(),"-- Email Tab: " + signUpPage.getEmailTabText());
            Reports.reportWithIsDisplay(logger,signUpPage.isDisplayTextBox(),"-- Text box");
            Reports.reportWithIsDisplay(logger,!signUpPage.isDisplayErrorMessage(),"-- Don't show error message");
            Reports.reportWithIsDisplay(logger,signUpPage.isDisplayContinueButton(),"-- Continue button: " + signUpPage.getContinueButtonText() + " - isEnable: " + signUpPage.isEnableContinueButton());

            Assert.assertTrue(signUpPage.isDisplay());
        } else {
            Log.addInfoLog(logger,"Don't display Login Page, end test",imgName);
            Assert.assertTrue(false);
        }
    }

    /**
     * Testcase:
     * 1. Condition to display UI
     * 2. All objects display on UI
     * 3. Interaction on every object
     */

    @Test(priority = 10)
    private void checkConditionToDisplaySignUpInformationUI() throws Exception{
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        signUpInformationPage = new SignUpInformationPage(driver);

        String email = Generator.getRandomMailinator();

        logger = extent.startTest("Check condition to display Register Information Page");

        Thread.sleep(Configs.ServerDeepSleep);
        String imgName = "sign_up_10_1";
        screenshot.takeScreenshot(imgName);

        if(loginPage.isDisplay()){
            Log.addInfoLog(logger,"Display Finan Book - Login Page, click on Sign up hyperlink",imgName);
            loginPage.clickOnSignUpLink();

            String imgName2 = "sign_up_10_2";
            screenshot.takeScreenshot(imgName2);

            if(signUpPage.isDisplay()){
                Log.addInfoLog(logger,"Display Sign Up Page - input phone/email page",imgName2);
                Log.addLog("Click on Email tab, and set email " + email);
                signUpPage.clickOnEmailTab();
                signUpPage.setTextBox(email);
                signUpPage.clickOnContinueButton();

                Thread.sleep(Configs.ServerSleep);
                String imgName3 = "sign_up_10_3";
                screenshot.takeScreenshot(imgName3);

                Reports.reportWithIsDisplay(logger, signUpInformationPage.isDisplay(), "Display Register Page - Input information, include:",imgName3);
                // bonus check all object display on UI
                Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayBackIcon(),"-- Back Icon");
                Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayPageTitle(),"-- Page Title: " + signUpInformationPage.getPageTitle());
                Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayPasswordLabel(),"-- Password Label: " + signUpInformationPage.getPasswordLabel());
                Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayConfirmPwdLabel(),"-- Confirm Password Label: " + signUpInformationPage.getConfirmPwdLabel());
                Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayBusinessLabel(),"-- Business Label: " + signUpInformationPage.getBusinessLabel());
                Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayUsernameLabel(),"-- Username Label: " + signUpInformationPage.getUsernameLabel());
                Reports.reportWithIsDisplay(logger,!signUpInformationPage.isDisplayReferLabel(),"-- Refer: " + signUpInformationPage.getReferLabel() + " - " + signUpInformationPage.getReferHyperlink());
                Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayContinueButton(),"-- Continue button: " + signUpInformationPage.getContinueButtonText() + " - isEnable: " + signUpInformationPage.isEnableContinueButton());

                Assert.assertTrue(signUpInformationPage.isDisplay());
            } else {
                Log.addInfoLog(logger,"Don't display Sign Up Page, end test",imgName2);
                Assert.assertTrue(false);
            }
        } else {
            Log.addInfoLog(logger,"Don't display Login Page, end test",imgName);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 20)
    private void checkConditionToDisplayOTPPopup() throws Exception{
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        signUpInformationPage = new SignUpInformationPage(driver);

        String email = Generator.getRandomMailinator();

        logger = extent.startTest("Check condition to display Register Information Page");

        Thread.sleep(Configs.ServerDeepSleep);
        String imgName = "sign_up_20_1";
        screenshot.takeScreenshot(imgName);

        if(loginPage.isDisplay()){
            Log.addInfoLog(logger,"Display Finan Book - Login Page, click on Sign up hyperlink",imgName);
            loginPage.clickOnSignUpLink();

            String imgName2 = "sign_up_20_2";
            screenshot.takeScreenshot(imgName2);

            if(signUpPage.isDisplay()){
                Log.addInfoLog(logger,"Display Sign Up Page - input phone/email page",imgName2);
                Log.addLog("Click on Email tab, and set email " + email);
                signUpPage.clickOnEmailTab();
                signUpPage.setTextBox(email);
                signUpPage.clickOnContinueButton();

                Thread.sleep(Configs.ServerSleep);
                String imgName3 = "sign_up_20_3";
                screenshot.takeScreenshot(imgName3);

                if(signUpInformationPage.isDisplay()){
                    Log.addInfoLog(logger,"Display Register Page - Input information page",imgName3);
                    Log.addLog("Set valid data & click on Continue");
                    signUpInformationPage.signUp("12345678",Generator.fakerFirstName(),Generator.fakerFirstName() + " " + Generator.fakerPhoneNum());

                    Thread.sleep(Configs.ServerSleep);
                    String imgName4 = "sign_up_20_4";
                    screenshot.takeScreenshot(imgName4);

                    Reports.reportWithIsDisplay(logger, signUpInformationPage.isDisplayOTPPopup(), "Display popup input OTP, include:",imgName4);
                    // bonus check all object display on UI
                    Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayPopupTitle(),"-- Popup Title: " + signUpInformationPage.getPopupTitle());
                    Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayPopupDescription(),"-- Popup Description: " + signUpInformationPage.getPopupDescription());
                    Reports.reportWithIsDisplay(logger,signUpInformationPage.isDisplayPopupTimeout(),"-- Timeout: " + signUpInformationPage.getPopupTimeout());

                    Assert.assertTrue(signUpInformationPage.isDisplayOTPPopup());
                } else {
                    Log.addInfoLog(logger,"Don't display Sign Up Information Page, end test",imgName3);
                    Assert.assertTrue(false);
                }
            } else {
                Log.addInfoLog(logger,"Don't display Sign Up Page, end test",imgName2);
                Assert.assertTrue(false);
            }
        } else {
            Log.addInfoLog(logger,"Don't display Login Page, end test",imgName);
            Assert.assertTrue(false);
        }
    }

    @Test(priority = 30)
    private void checkToRegisterNewAccountSuccessful() throws Exception{
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        signUpInformationPage = new SignUpInformationPage(driver);
        homePage = new HomePage(driver);

        String email = Generator.getRandomMailinator();; // "qagRbIAnmD@finanteam.testinator.com"

        logger = extent.startTest("Check condition to display Register Information Page");

        Thread.sleep(Configs.ServerDeepSleep);
        String imgName = "sign_up_30_1";
        screenshot.takeScreenshot(imgName);

        if(loginPage.isDisplay()){
            Log.addInfoLog(logger,"Display Finan Book - Login Page, click on Sign up hyperlink",imgName);
            loginPage.clickOnSignUpLink();

            String imgName2 = "sign_up_30_2";
            screenshot.takeScreenshot(imgName2);

            if(signUpPage.isDisplay()){
                Log.addInfoLog(logger,"Display Sign Up Page - input phone/email page",imgName2);
                Log.addLog("Click on Email tab, and set email " + email);
                signUpPage.clickOnEmailTab();
                signUpPage.setTextBox(email);
                signUpPage.clickOnContinueButton();

                Thread.sleep(Configs.ServerSleep);
                String imgName3 = "sign_up_30_3";
                screenshot.takeScreenshot(imgName3);

                if(signUpInformationPage.isDisplay()){
                    Log.addInfoLog(logger,"Display Register Page - Input information page",imgName3);
                    Log.addLog("Set valid data & click on Continue");
                    signUpInformationPage.signUp("12345678",Generator.fakerFirstName(),Generator.fakerFirstName() + " " + Generator.fakerPhoneNum());

                    Thread.sleep(Configs.ServerSleep);
                    String imgName4 = "sign_up_30_4";
                    screenshot.takeScreenshot(imgName4);

                    if(signUpInformationPage.isDisplayOTPPopup()){
                        Log.addInfoLog(logger,"Display Register Page - Input OTP Popup",imgName4);
                        String otp = MailBox.getOTP(email);
                        Log.addLog("input OTP: " + otp);

                        signUpInformationPage.setPopupInputOTP(otp);

                        Thread.sleep(Configs.ServerDeepSleep);
                        String imgName5 = "sign_up_30_5";
                        screenshot.takeScreenshot(imgName5);

                        Log.addInfoLog(logger,"Sign up successful",imgName5);

                        Assert.assertTrue(homePage.isDisplay());
                    } else {
                        Log.addInfoLog(logger,"Don't display Sign Up - Input OTP Popup, end test",imgName4);
                        Assert.assertTrue(false);
                    }
                } else {
                    Log.addInfoLog(logger,"Don't display Sign Up Information Page, end test",imgName3);
                    Assert.assertTrue(false);
                }
            } else {
                Log.addInfoLog(logger,"Don't display Sign Up Page, end test",imgName2);
                Assert.assertTrue(false);
            }
        } else {
            Log.addInfoLog(logger,"Don't display Login Page, end test",imgName);
            Assert.assertTrue(false);
        }
    }
}
