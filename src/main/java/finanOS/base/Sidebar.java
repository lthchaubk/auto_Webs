package finanOS.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.common.Log;

/**
 * Refactor by: chaule
 * Refactor at: 5Jan2024
 * Refactor note: to easy to action, all elements will handle static
 */

public class Sidebar extends BasePage {

    private static final String LeftAside = "//*[@id='root']//aside";
    private static final String Header = "//*[@id='root']//header";

    /** ----------------- LEFT NAVIGATOR ----------------- */
    @FindBy(xpath = LeftAside + "")
    private WebElement EXPAND_COLLAPSE_ICON;
    @FindBy(xpath = LeftAside + "//div[2]//a/span[2]")
    private WebElement SUMMARY;
    @FindBy(xpath = LeftAside + "")
    private WebElement ACCOUNT;
    @FindBy(xpath = LeftAside + "")
    private WebElement TRANSACTION;
    @FindBy(xpath = LeftAside + "")
    private WebElement INVOICE_INCOMING;
    @FindBy(xpath = LeftAside + "")
    private WebElement INVOICE_OUTGOING;
    @FindBy(xpath = LeftAside + "")
    private WebElement TRANSFER_MONEY;
    @FindBy(xpath = LeftAside + "")
    private WebElement REPORT;
    /** ------------- REPORT --------------- */
    @FindBy(xpath = LeftAside + "")
    private WebElement REPORT_PAYMENT_ACCOUNT;
    @FindBy(xpath = LeftAside + "")
    private WebElement REPORT_CASH_FLOW;
    @FindBy(xpath = LeftAside + "")
    private WebElement REPORT_RECEIVABLE;
    /** ------------- REPORT --------------- */
    @FindBy(xpath = LeftAside + "")
    private WebElement PRODUCT;
    @FindBy(xpath = LeftAside + "")
    private WebElement CONTACT;
    @FindBy(xpath = LeftAside + "")
    private WebElement SETTING;
    /** ------------- SETTING --------------- */
    @FindBy(xpath = LeftAside + "")
    private WebElement SETTING_STAFF;
    @FindBy(xpath = LeftAside + "")
    private WebElement SETTING_ROLE_N_PERMISSION;
    @FindBy(xpath = LeftAside + "")
    private WebElement SETTING_COA;
    @FindBy(xpath = LeftAside + "")
    private WebElement SETTING_TAX;
    /** ------------- SETTING --------------- */

    /** ----------------- TOP NAVIGATOR ----------------- */
    @FindBy(xpath = "//*[@id=\"default-header-title\"]/div/span")
    private WebElement PAGE_TITLE;
    @FindBy(xpath = Header + "/div[2]/div[1]/button")
    private WebElement SUPPORT_ICON;
    @FindBy(xpath = Header + "/div[2]/div[2]/button")
    private WebElement FEEDBACK_ICON;
    @FindBy(xpath = Header + "")
    private WebElement NOTIFICATION_ICON;
    @FindBy(xpath = Header + "")
    private WebElement NOTIFICATION_NUMBER;
    @FindBy(xpath = Header + "/div[2]/button")
    private WebElement ACCOUNT_ICON;
    /** ------------- ACCOUNT --------------- */
    /** ------------- ACCOUNT --------------- */

    /** ----------------- LEFT NAVIGATOR ----------------- */
    /**
     * Object: EXPAND_COLLAPSE_ICON
     */
    public boolean isDisplayExpandCollapseIcon() {
        boolean isDisplayed = false;
        try {
            isDisplayed = EXPAND_COLLAPSE_ICON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of EXPAND_COLLAPSE_ICON");
        }
        return isDisplayed;
    }
    public void clickOnExpandCollapseIcon(){
        try {
            EXPAND_COLLAPSE_ICON.click();
        } catch (Exception e) {
            Log.addLog("xpath EXPAND_COLLAPSE_ICON");
        }
    }
    /**
     * Object: SUMMARY
     */
    public boolean isDisplaySummary() {
        boolean isDisplayed = false;
        try {
            isDisplayed = SUMMARY.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of SUMMARY");
        }
        return isDisplayed;
    }
    public String getSummary(){
        String text = "";
        try {
            text = SUMMARY.getText();
        } catch (Exception e) {
            Log.addLog("xpath of SUMMARY");
        }
        return text;
    }
    public void clickOnSummary(){
        try {
            SUMMARY.click();
        } catch (Exception e) {
            Log.addLog("xpath SUMMARY");
        }
    }

    /**
     * Object: ACCOUNT
     */
    public boolean isDisplayAccountOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = ACCOUNT.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of ACCOUNT");
        }
        return isDisplayed;
    }
    public String getAccountOption(){
        String text = "";
        try {
            text = ACCOUNT.getText();
        } catch (Exception e) {
            Log.addLog("xpath of ACCOUNT");
        }
        return text;
    }
    public void clickOnAccountOption(){
        try {
            ACCOUNT.click();
        } catch (Exception e) {
            Log.addLog("xpath ACCOUNT");
        }
    }

    /**
     * Object: TRANSACTION
     */
    public boolean isDisplayTransactionOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = TRANSACTION.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of TRANSACTION");
        }
        return isDisplayed;
    }
    public String getTransactionOption(){
        String text = "";
        try {
            text = TRANSACTION.getText();
        } catch (Exception e) {
            Log.addLog("xpath of TRANSACTION");
        }
        return text;
    }
    public void clickOnTransactionOption(){
        try {
            TRANSACTION.click();
        } catch (Exception e) {
            Log.addLog("xpath TRANSACTION");
        }
    }

    /**
     * Object: INVOICE_INCOMING
     */
    public boolean isDisplayInvoiceIncoming() {
        boolean isDisplayed = false;
        try {
            isDisplayed = INVOICE_INCOMING.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of INVOICE_INCOMING");
        }
        return isDisplayed;
    }
    public String getInvoiceIncoming(){
        String text = "";
        try {
            text = INVOICE_INCOMING.getText();
        } catch (Exception e) {
            Log.addLog("xpath of INVOICE_INCOMING");
        }
        return text;
    }
    public void clickOnInvoiceIncoming(){
        try {
            INVOICE_INCOMING.click();
        } catch (Exception e) {
            Log.addLog("xpath INVOICE_INCOMING");
        }
    }

    /**
     * Object: INVOICE_OUTGOING
     */
    public boolean isDisplayInvoiceOutgoing() {
        boolean isDisplayed = false;
        try {
            isDisplayed = INVOICE_OUTGOING.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of INVOICE_OUTGOING");
        }
        return isDisplayed;
    }
    public String getInvoiceOutgoing(){
        String text = "";
        try {
            text = INVOICE_OUTGOING.getText();
        } catch (Exception e) {
            Log.addLog("xpath of INVOICE_OUTGOING");
        }
        return text;
    }
    public void clickOnInvoiceOutgoing(){
        try {
            INVOICE_OUTGOING.click();
        } catch (Exception e) {
            Log.addLog("xpath INVOICE_OUTGOING");
        }
    }

    /**
     * Object: TRANSFER_MONEY
     */
    public boolean isDisplayTransferMoney() {
        boolean isDisplayed = false;
        try {
            isDisplayed = TRANSFER_MONEY.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of TRANSFER_MONEY");
        }
        return isDisplayed;
    }
    public String getTransferMoney(){
        String text = "";
        try {
            text = TRANSFER_MONEY.getText();
        } catch (Exception e) {
            Log.addLog("xpath of TRANSFER_MONEY");
        }
        return text;
    }
    public void clickOnTransferMoney(){
        try {
            TRANSFER_MONEY.click();
        } catch (Exception e) {
            Log.addLog("xpath TRANSFER_MONEY");
        }
    }

    /**
     * Object: REPORT
     */
    public boolean isDisplayReportOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = REPORT.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT");
        }
        return isDisplayed;
    }
    public String getReportOption(){
        String text = "";
        try {
            text = REPORT.getText();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT");
        }
        return text;
    }
    public void clickOnReportOption(){
        try {
            REPORT.click();
        } catch (Exception e) {
            Log.addLog("xpath REPORT");
        }
    }

    /**
     * Object: REPORT_PAYMENT_ACCOUNT
     */
    public boolean isDisplayReportPaymentAccountOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = REPORT_PAYMENT_ACCOUNT.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT_PAYMENT_ACCOUNT");
        }
        return isDisplayed;
    }
    public String getReportPaymentAccountOption(){
        String text = "";
        try {
            text = REPORT_PAYMENT_ACCOUNT.getText();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT_PAYMENT_ACCOUNT");
        }
        return text;
    }
    public void clickOnReportPaymentAccountOption(){
        try {
            REPORT_PAYMENT_ACCOUNT.click();
        } catch (Exception e) {
            Log.addLog("xpath REPORT_PAYMENT_ACCOUNT");
        }
    }

    /**
     * Object: REPORT_CASH_FLOW
     */
    public boolean isDisplayReportCashFlowOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = REPORT_CASH_FLOW.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT_CASH_FLOW");
        }
        return isDisplayed;
    }
    public String getReportCashFlowOption(){
        String text = "";
        try {
            text = REPORT_CASH_FLOW.getText();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT_CASH_FLOW");
        }
        return text;
    }
    public void clickOnReportCashFlowOption(){
        try {
            REPORT_CASH_FLOW.click();
        } catch (Exception e) {
            Log.addLog("xpath REPORT_CASH_FLOW");
        }
    }

    /**
     * Object: REPORT_RECEIVABLE
     */
    public boolean isDisplayReportReceivableOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = REPORT_RECEIVABLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT_RECEIVABLE");
        }
        return isDisplayed;
    }
    public String getReportReceivableOption(){
        String text = "";
        try {
            text = REPORT_RECEIVABLE.getText();
        } catch (Exception e) {
            Log.addLog("xpath of REPORT_RECEIVABLE");
        }
        return text;
    }
    public void clickOnReportReceivableOption(){
        try {
            REPORT_RECEIVABLE.click();
        } catch (Exception e) {
            Log.addLog("xpath REPORT_RECEIVABLE");
        }
    }

    /**
     * Object: PRODUCT
     */
    public boolean isDisplayProductOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = PRODUCT.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of PRODUCT");
        }
        return isDisplayed;
    }
    public String getProductOption(){
        String text = "";
        try {
            text = PRODUCT.getText();
        } catch (Exception e) {
            Log.addLog("xpath of PRODUCT");
        }
        return text;
    }
    public void clickOnProductOption(){
        try {
            PRODUCT.click();
        } catch (Exception e) {
            Log.addLog("xpath PRODUCT");
        }
    }

    /**
     * Object: CONTACT
     */
    public boolean isDisplayContactOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = CONTACT.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of CONTACT");
        }
        return isDisplayed;
    }
    public String getContactOption(){
        String text = "";
        try {
            text = CONTACT.getText();
        } catch (Exception e) {
            Log.addLog("xpath of CONTACT");
        }
        return text;
    }
    public void clickOnContactOption(){
        try {
            CONTACT.click();
        } catch (Exception e) {
            Log.addLog("xpath CONTACT");
        }
    }

    /**
     * Object: SETTING
     */
    public boolean isDisplaySettingOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = SETTING.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING");
        }
        return isDisplayed;
    }
    public String getSettingOption(){
        String text = "";
        try {
            text = SETTING.getText();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING");
        }
        return text;
    }
    public void clickOnSettingOption(){
        try {
            SETTING.click();
        } catch (Exception e) {
            Log.addLog("xpath SETTING");
        }
    }

    /**
     * Object: SETTING_STAFF
     */
    public boolean isDisplayStaffOption() {
        boolean isDisplayed = false;
        try {
            isDisplayed = SETTING_STAFF.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_STAFF");
        }
        return isDisplayed;
    }
    public String getStaffOption(){
        String text = "";
        try {
            text = SETTING_STAFF.getText();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_STAFF");
        }
        return text;
    }
    public void clickOnStaffOption(){
        try {
            SETTING_STAFF.click();
        } catch (Exception e) {
            Log.addLog("xpath SETTING_STAFF");
        }
    }

    /**
     * Object: SETTING_ROLE_N_PERMISSION
     */
    public boolean isDisplayRoleNPermission() {
        boolean isDisplayed = false;
        try {
            isDisplayed = SETTING_ROLE_N_PERMISSION.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_ROLE_N_PERMISSION");
        }
        return isDisplayed;
    }
    public String getRoleNPermission(){
        String text = "";
        try {
            text = SETTING_ROLE_N_PERMISSION.getText();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_ROLE_N_PERMISSION");
        }
        return text;
    }
    public void clickOnRoleNPermission(){
        try {
            SETTING_ROLE_N_PERMISSION.click();
        } catch (Exception e) {
            Log.addLog("xpath SETTING_ROLE_N_PERMISSION");
        }
    }

    /**
     * Object: SETTING_COA
     */
    public boolean isDisplaySettingCoa() {
        boolean isDisplayed = false;
        try {
            isDisplayed = SETTING_COA.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_COA");
        }
        return isDisplayed;
    }
    public String getSettingCoa(){
        String text = "";
        try {
            text = SETTING_COA.getText();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_COA");
        }
        return text;
    }
    public void clickOnSettingCoa(){
        try {
            SETTING_COA.click();
        } catch (Exception e) {
            Log.addLog("xpath SETTING_COA");
        }
    }

    /**
     * Object: SETTING_TAX
     */
    public boolean isDisplaySettingTax() {
        boolean isDisplayed = false;
        try {
            isDisplayed = SETTING_TAX.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_TAX");
        }
        return isDisplayed;
    }
    public String getSettingTax(){
        String text = "";
        try {
            text = SETTING_TAX.getText();
        } catch (Exception e) {
            Log.addLog("xpath of SETTING_TAX");
        }
        return text;
    }
    public void clickOnSettingTax(){
        try {
            SETTING_TAX.click();
        } catch (Exception e) {
            Log.addLog("xpath SETTING_TAX");
        }
    }

    /** ----------------- TOP NAVIGATOR ----------------- */
    /**
     * Object: PAGE_TITLE
     */
    public boolean isDisplayPageTitle() {
        boolean isDisplayed = false;
        try {
            isDisplayed = PAGE_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of PAGE_TITLE");
        }
        return isDisplayed;
    }
    public String getPageTitle(){
        String text = "";
        try {
            text = PAGE_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("xpath of PAGE_TITLE");
        }
        return text;
    }

    /**
     * Object: SUPPORT_ICON
     */
    public boolean isDisplaySupportIcon() {
        boolean isDisplayed = false;
        try {
            isDisplayed = SUPPORT_ICON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath of Support Icon");
        }
        return isDisplayed;
    }
    public String getSupportLabel(){
        String text = "";
        try {
            text = SUPPORT_ICON.getText();
        } catch (Exception e) {
            Log.addLog("xpath of Support Icon");
        }
        return text;
    }
    public void clickOnSupportIcon() {
        try {
            SUPPORT_ICON.click();
        } catch (Exception e) {
            Log.addLog("xpath Support Icon");
        }
    }

    /**
     * Object: FEEDBACK_ICON
     */
    public boolean isDisplayFeedbackIcon() {
        boolean isDisplayed = false;
        try {
            isDisplayed = FEEDBACK_ICON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath Feedback Icon");
        }
        return isDisplayed;
    }
    public String getFeedbackLabel(){
        String text = "";
        try {
            text = FEEDBACK_ICON.getText();
        } catch (Exception e) {
            Log.addLog("xpath of Feedback Icon");
        }
        return text;
    }
    public void clickOnFeedbackIcon() {
        try {
            FEEDBACK_ICON.click();
        } catch (Exception e) {
            Log.addLog("xpath Feedback Icon");
        }
    }

    /**
     * Object: NOTIFICATION_ICON
     */
    public boolean isDisplayNotificationIcon() {
        boolean isDispalyed = false;
        try {
            isDispalyed = NOTIFICATION_ICON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath Notification Icon");
        }
        return isDispalyed;
    }
    public String getNotificationNumber(){
        String text = "";
        try {
            text = NOTIFICATION_NUMBER.getText();
        } catch (Exception e) {
            Log.addLog("xpath of Notification Number Icon");
        }
        return text;
    }
    public void clickOnNotificationIcon() {
        try {
            NOTIFICATION_ICON.click();
        } catch (Exception e) {
            Log.addLog("xpath Notification Icon");
        }
    }

    /**
     * Object: ACCOUNT_ICON
     */
    public boolean isDisplayAccountIcon() {
        boolean isDisplayed = false;
        try {
            isDisplayed = ACCOUNT_ICON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("xpath AccountIcon");
        }
        return isDisplayed;
    }
    public void clickOnAccountIcon() {
        try {
            ACCOUNT_ICON.click();
        } catch (Exception e) {
            Log.addLog("xpath AccountIcon - " + e.getMessage());
        }
    }

//    /**
//     * Object: EN_BUTTON
//     */
//    public boolean isDisplayENButton() {
//        boolean isDisplay = false;
//        try {
//            isDisplay = EN_BUTTON.isDisplayed();
//        } catch (Exception e) {
//            Log.addLog("xpath of Switch button language- " + e.getMessage());
//        }
//        return isDisplay;
//    }
//    public String getENButton() {
//        String text = "";
//        try {
//            text = EN_BUTTON.getText();
//        } catch (Exception e) {
//            Log.addLog("xpath of Switch button language");
//        }
//        return text;
//    }
//    public void clickOnENButton() {
//        try {
//            EN_BUTTON.click();
//        } catch (Exception e) {
//            Log.addLog("xpath of Switch button language");
//        }
//    }
//
//    /**
//     * Object: VN_BUTTON
//     */
//    public boolean isDisplayVNButton() {
//        boolean isDisplay = false;
//        try {
//            isDisplay = VN_BUTTON.isDisplayed();
//        } catch (Exception e) {
//            Log.addLog("xpath of Switch button language- " + e.getMessage());
//        }
//        return isDisplay;
//    }
//    public String getVNButton() {
//        String text = "";
//        try {
//            text = VN_BUTTON.getText();
//        } catch (Exception e) {
//            Log.addLog("xpath of Switch button language");
//        }
//        return text;
//    }
//    public void clickOnVNbutton() {
//        try {
//            VN_BUTTON.click();
//        } catch (Exception e) {
//            Log.addLog("xpath of Switch button language");
//        }
//    }
//
//    public boolean isSidenavHeaderDisplayed() {
//        boolean isSidenavHeaderDisplayed = false;
//        try {
//            isSidenavHeaderDisplayed = SIDENAV_HEADER.isDisplayed();
//        } catch (Exception e) {
//            Log.addLog("xpath of LOGO icon");
//        }
//        return isSidenavHeaderDisplayed;
//    }

    /**
     * Common
     */
    public boolean isDisplaySideBar() {
        return isDisplaySummary() && isDisplayAccountOption() && isDisplayAccountIcon();
    }
}