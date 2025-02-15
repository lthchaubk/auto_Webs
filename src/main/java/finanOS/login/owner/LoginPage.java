package finanOS.login.owner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import finanOS.base.BasePage;
import utilities.common.Log;

import java.util.List;

/**
 * Author: Chaule
 * Created date: 16Jun2023
 * PRD:
 * Figma: https://www.figma.com/design/Ne8WNLRy35Hk7v9VmkuLNF/Kanban-13?node-id=456-34818&p=f&t=scVAmmIozVHNlDpR-0
 */


public class LoginPage extends BasePage {
    // Left Page
//    private static final String LeftPagePath = "#root > main > div > header";
//    @FindBy(css = LeftPagePath + " > div > div > button")
//    private WebElement LEFT_LOGO;
//    @FindBy(css = LeftPagePath + "")
//    private WebElement LEFT_IMAGE;
//    @FindBy(css = LeftPagePath + "")
//    private WebElement LEFT_SCROLLABLE;
//    @FindBy(css = LeftPagePath + "")
//    private WebElement LEFT_FOOTER;

    // Right Page
    private static final String RightPagePath = "#__next > div > div > div";
    @FindBy(css = RightPagePath + " > div > div")
    private WebElement LANGUAGE_ICON;
    @FindBy(css = RightPagePath + "")
    private List<WebElement> LANGUAGE_DROPDOWN_LIST;
    private static final String language_name = "";
    @FindBy(css = RightPagePath + " > div:nth-child(2) > div > div > div > div")
    private WebElement PAGE_TITLE;
    @FindBy(css = "form > div > div > div > div > input")
    private WebElement PHONE_OR_EMAIL_TEXT_BOX;
    @FindBy(css = "form > div > div > div > p")
    private WebElement PHONE_OR_EMAIL_ERROR_MESSAGE;
    @FindBy (css = "form > div > div:nth-child(2) > div > div > input")
    private WebElement PASSWORD_TEXT_BOX;
    @FindBy(css = "form > div > div:nth-child(2) > div > p")
    private WebElement PASSWORD_ERROR_MESSAGE;
    @FindBy (css = "form > div > span")
    private WebElement FORGOT_PASSWORD_HYPERLINK;
    @FindBy(css = "form > div > button > div")
    private WebElement LOGIN_BUTTON;
    @FindBy (css = RightPagePath + " > div > div > div > span")
    private WebElement SIGN_UP_HYPERLINK;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Object: LANGUAGE_ICON
     */
    public boolean isDisplayLanguageIcon() {
        boolean isDisplay = false;
        try {
            isDisplay = LANGUAGE_ICON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("cssSelector of LANGUAGE_ICON - " + e.getMessage());
        }
        return isDisplay;
    }
    public void clickOnLanguageIcon() {
        try {
            LANGUAGE_ICON.click();
        } catch (Exception e) {
            Log.addLog("cssSelector of LANGUAGE_ICON");
        }
    }

    /**
     * Object: LANGUAGE_DROPDOWN_LIST
     */
    private WebElement getLanguageElement(int pos) { /* method get vị trí element */
        WebElement element = null;
        try {
            element = LANGUAGE_DROPDOWN_LIST.get(pos);
        } catch (Exception e) {
            Log.addLog("css of LANGUAGE_DROPDOWN_LIST at "+ pos);
        }
        return element;
    }
    public int getTotalLanguages() {
        int total = 0;
        try {
            total = LANGUAGE_DROPDOWN_LIST.size();
        } catch (Exception e) {
            Log.addLog("css of LANGUAGE_DROPDOWN_LIST");
        }
        return total;
    }
    public String getLanguageByPosition(int pos){
        WebElement element = getLanguageElement(pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector(language_name)).getText();
            } catch (Exception e) {
                Log.addLog("css of language_name at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }
    public void clickOnLanguageByPosition(int pos) {
        WebElement element = getLanguageElement(pos); /* gọi method get vị trí */
        if (element != null){
            element.click();
        }
    }
    public void clickOnLanguageByLanguageCode(String languageCode){
        boolean isFound = false;
        for (int i = 0; i < getTotalLanguages(); i++) {
            if (getLanguageByPosition(i).toLowerCase().equals(languageCode.toLowerCase())) {
                isFound = true;
                clickOnLanguageByPosition(i);
                break;
            }
        }

        if (!isFound) {
            Log.addLog("Nothing Language on this page have languageCode is " + languageCode);
        }
    }

    /**
     * Object: PAGE_TITLE
     */
    public boolean isDisplayPageTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = PAGE_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("cssSelector of PAGE_TITLE");
        }
        return isDisplay;
    }
    public String getPageTitle() {
        String text = "";
        try {
            text = PAGE_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("cssSelector of PAGE_TITLE");
        }
        return text;
    }

    /**
     * Object: PHONE_OR_EMAIL_TEXT_BOX
     */
    public boolean isDisplayPhoneOrEmailTextBox() {
        boolean isDisplay = false;
        try {
            isDisplay = PHONE_OR_EMAIL_TEXT_BOX.isDisplayed();
        } catch (Exception e) {
            Log.addLog("cssSelector of PHONE_OR_EMAIL_TEXT_BOX");
        }
        return isDisplay;
    }
    public String getPhoneOrEmailTextBoxValue() {
        String text = "";
        try {
            text = PHONE_OR_EMAIL_TEXT_BOX.getText();
        } catch (Exception e) {
            Log.addLog("cssSelector of PHONE_OR_EMAIL_TEXT_BOX");
        }
        return text;
    }
    public void clearPhoneOrEmailTextBox() {
        try {
            PHONE_OR_EMAIL_TEXT_BOX.clear();
        } catch (Exception e) {
            Log.addLog("cssSelector of PHONE_OR_EMAIL_TEXT_BOX");
        }
    }
    public void setPhoneOrEmailTextBox(String username){
        try {
            PHONE_OR_EMAIL_TEXT_BOX.sendKeys(username);
        } catch (Exception e) {
            Log.addLog("cssSelector of PHONE_OR_EMAIL_TEXT_BOX " + e.getMessage());
        }
    }

    /**
     * Object: PHONE_OR_EMAIL_ERROR_MESSAGE
     */
    public boolean isDisplayPhoneOrEmailErrorMessage() {
        boolean isDisplay = false;
        try {
            isDisplay = PHONE_OR_EMAIL_ERROR_MESSAGE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("cssSelector of PHONE_OR_EMAIL_ERROR_MESSAGE");
        }
        return isDisplay;
    }
    public String getPhoneOrEmailErrorMessage() {
        String text = "";
        try {
            text = PHONE_OR_EMAIL_ERROR_MESSAGE.getText();
        } catch (Exception e) {
            Log.addLog("cssSelector of PHONE_OR_EMAIL_ERROR_MESSAGE");
        }
        return text;
    }

    /**
     * Object: PASSWORD_TEXT_BOX
     */
    public boolean isDisplayPwdTextBox() {
        boolean isDisplay = false;
        try {
            isDisplay = PASSWORD_TEXT_BOX.isDisplayed();
        } catch (Exception e) {
            Log.addLog("cssSelector of PASSWORD_TEXT_BOX");
        }
        return isDisplay;
    }
    public String getPwdTextBoxValue() {
        String text = "";
        try {
            text = PASSWORD_TEXT_BOX.getText();
        } catch (Exception e) {
            Log.addLog("cssSelector of PASSWORD_TEXT_BOX");
        }
        return text;
    }
    public void clearPwdTextBox() {
        try {
            PASSWORD_TEXT_BOX.clear();
        } catch (Exception e) {
            Log.addLog("cssSelector of PASSWORD_TEXT_BOX");
        }
    }
    public void setPwdTextBox(String pwd){
        try {
            PASSWORD_TEXT_BOX.sendKeys(pwd);
        } catch (Exception e) {
            Log.addLog("cssSelector of PASSWORD_TEXT_BOX");
        }
    }

    /**
     * Object: PASSWORD_ERROR_MESSAGE
     */
    public boolean isDisplayPwdErrorMessage() {
        boolean isDisplay = false;
        try {
            isDisplay = PASSWORD_ERROR_MESSAGE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("cssSelector of PASSWORD_ERROR_MESSAGE");
        }
        return isDisplay;
    }
    public String getPwdErrorMessage() {
        String text = "";
        try {
            text = PASSWORD_ERROR_MESSAGE.getText();
        } catch (Exception e) {
            Log.addLog("cssSelector of PASSWORD_ERROR_MESSAGE");
        }
        return text;
    }

    /**
     * Object: FORGOT_PASSWORD_HYPERLINK
     */
    public boolean isDisplayForgotPwdLink(){
        boolean isDisplay = false;
        try {
            isDisplay = FORGOT_PASSWORD_HYPERLINK.isDisplayed();
        } catch (Exception e){
            Log.addLog("cssSelector of Forgot Pwd");
        }
        return isDisplay;
    }
    public String getForgotPwdText(){
        String text = "";
        try {
            text = FORGOT_PASSWORD_HYPERLINK.getText();
        } catch (Exception e){
            Log.addLog("cssSelector of Forgot Pwd");
        }
        return text;
    }
    public void clickOnForgotPwdLink(){
        try {
            FORGOT_PASSWORD_HYPERLINK.click();
        } catch (Exception e){
            Log.addLog("cssSelector of Forgot Pwd");
        }
    }

    /**
     * Object: LOGIN_BUTTON
     */
    public boolean isDisplayLoginButton(){
        boolean isDisplay = false;
        try {
            isDisplay = LOGIN_BUTTON.isDisplayed();
        } catch (Exception e){
            Log.addLog("cssSelector of LOGIN_BUTTON");
        }
        return isDisplay;
    }
    public String getLoginButton(){
        String text = "";
        try {
            text = LOGIN_BUTTON.getText();
        } catch (Exception e){
            Log.addLog("cssSelector of LOGIN_BUTTON");
        }
        return text;
    }
    public void clickOnLoginButton(){
        try {
            LOGIN_BUTTON.click();
        } catch (Exception e){
            Log.addLog("cssSelector of LOGIN_BUTTON");
        }
    }

    /**
     * Object: SIGN_UP_HYPERLINK
     */
    public boolean isDisplaySignUpLink(){
        boolean isDisplay = false;
        try {
            isDisplay = SIGN_UP_HYPERLINK.isDisplayed();
        } catch (Exception e){
            Log.addLog("cssSelector of SIGN_UP_HYPERLINK");
        }
        return isDisplay;
    }
    public String getSignUpLinkText(){
        String text = "";
        try {
            text = SIGN_UP_HYPERLINK.getText();
        } catch (Exception e){
            Log.addLog("cssSelector of SIGN_UP_HYPERLINK");
        }
        return text;
    }
    public void clickOnSignUpLink(){
        try {
            SIGN_UP_HYPERLINK.click();
        } catch (Exception e){
            Log.addLog("cssSelector of SIGN_UP_HYPERLINK");
        }
    }

//    /**
//     * Object: OTP Popup
//     */
//    public boolean isDisplayOtpPopup(){
//        boolean isDisplay = false;
//        try{
//            isDisplay = OTP_POPUP.isDisplayed();
//        } catch (Exception e){
//            Log.addLog("cssSelector of OTP Popup");
//        }
//        return isDisplay;
//    }
//
//    /**
//     * Object: OTP Popup - Title
//     */
//    public boolean isDisplayOTPPopupTitle(){
//        boolean isDisplay = false;
//        try{
//            isDisplay = OTP_POPUP_TITLE.isDisplayed();
//        } catch (Exception e){
//            Log.addLog("cssSelector of OTP Popup Title");
//        }
//        return isDisplay;
//    }
//    public String getDisplayOTPPopupTitle(){
//        String text = "";
//        try{
//            text = OTP_POPUP_TITLE.getText();
//        } catch (Exception e){
//            Log.addLog("cssSelector of OTP Popup Title");
//        }
//        return text;
//    }
//
//    /**
//     * Object: OTP Popup - Desc
//     */
//    public boolean isDisplayOTPPopupDesc(){
//        boolean isDisplay = false;
//        try{
//            isDisplay = OTP_POPUP_DESC.isDisplayed();
//        } catch (Exception e){
//            Log.addLog("cssSelector of OTP Popup Desc");
//        }
//        return isDisplay;
//    }
//    public String getDisplayOTPPopupDesc(){
//        String text = "";
//        try{
//            text = OTP_POPUP_DESC.getText();
//        } catch (Exception e){
//            Log.addLog("cssSelector of OTP Popup Desc");
//        }
//        return text;
//    }
//
//    /**
//     * Object: OTP Popup - Value
//     */
//    public boolean isDisplayOTPPopupValue(){
//        boolean isDisplay = false;
//        try{
//            isDisplay = OTP_POPUP_VALUE.isDisplayed();
//        } catch (Exception e){
//            Log.addLog("cssSelector of OTP Popup Value");
//        }
//        return isDisplay;
//    }
//    public void setOTP(String otp){
//        try{
//            OTP_POPUP_VALUE.sendKeys(otp);
//        } catch (Exception e){
//            Log.addLog("cssSelector of OTP Popup Value");
//        }
//    }

    /**
     * Common
     */
    public boolean isDisplay() {
//        System.out.println("debug : " + isDisplayPageTitle());
//        System.out.println("debug : " + isDisplayLoginButton());
        switch (Configs.language) {
            case EN:
//                System.out.println("debug : " + getPageTitle().equals("Welcome to FinanBook"));
                return isDisplayPageTitle() && isDisplayLoginButton() && getPageTitle().equals("Welcome to FinanBook");
            case VI:
            default:
//                System.out.println("debug : " + getPageTitle().equals("Chào mừng đến với FinanBook"));
                return isDisplayPageTitle() && isDisplayLoginButton() && getPageTitle().equals("Chào mừng đến với FinanBook");
        }
    }
}


