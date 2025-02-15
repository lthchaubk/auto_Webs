/* (C)2024 */
package finanOS.emailTemplate;

import finanOS.base.Sidebar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.common.Log;

public class RemoveEmailTemplatePopup extends Sidebar {
    private static final String Header = "";
    private static final String Body = "";

    /**
     * Header
     */
    @FindBy(css = Header + "")
    private WebElement POPUP_TITLE;

    /**
     * Body
     */
    @FindBy(css = Body + "")
    private WebElement REMOVE_EMAIL_TEXT;
    @FindBy(css = Body + "")
    private WebElement REJECT_BTN;
    @FindBy(css = Body + "")
    private WebElement ACCEPT_BTN;
    @FindBy(css = Body + "")
    private WebElement CAN_NOT_REMOVE_ERROR_MESSAGE;

    public RemoveEmailTemplatePopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Object: POPUP_TITLE
     */
    public boolean isDisplayPopupTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = POPUP_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of POPUP_TITLE");
        }
        return isDisplay;
    }

    public String getPopupTitle() {
        String text = "";
        try {
            text = POPUP_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of POPUP_TITLE");
        }
        return text;
    }

    /**
     * Object: REMOVE_EMAIL_TEXT
     */
    public boolean isDisplayRemoveEmailText() {
        boolean isDisplay = false;
        try {
            isDisplay = REMOVE_EMAIL_TEXT.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of REMOVE_EMAIL_TEXT");
        }
        return isDisplay;
    }

    public String getRemoveEmailText() {
        String text = "";
        try {
            text = REMOVE_EMAIL_TEXT.getText();
        } catch (Exception e) {
            Log.addLog("css of REMOVE_EMAIL_TEXT");
        }
        return text;
    }

    /**
     * Object: REJECT_BTN
     */
    public boolean isDisplayRejectButton() {
        boolean isDisplay = false;
        try {
            isDisplay = REJECT_BTN.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of REJECT_BTN");
        }
        return isDisplay;
    }

    public String getRejectButtonText() {
        String text = "";
        try {
            text = REJECT_BTN.getText();
        } catch (Exception e) {
            Log.addLog("css of REJECT_BTN");
        }
        return text;
    }

    public void clickOnRejectButton() {
        try {
            REJECT_BTN.click();
        } catch (Exception e) {
            Log.addLog("css of REJECT_BTN");
        }
    }

    /**
     * Object: ACCEPT_BTN
     */
    public boolean isDisplayAcceptButton() {
        boolean isDisplay = false;
        try {
            isDisplay = ACCEPT_BTN.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of ACCEPT_BTN");
        }
        return isDisplay;
    }

    public String getAcceptButtonText() {
        String text = "";
        try {
            text = ACCEPT_BTN.getText();
        } catch (Exception e) {
            Log.addLog("css of ACCEPT_BTN");
        }
        return text;
    }

    public void clickOnAcceptButton() {
        try {
            ACCEPT_BTN.click();
        } catch (Exception e) {
            Log.addLog("css of ACCEPT_BTN");
        }
    }

    /**
     * Object: CAN_NOT_REMOVE_ERROR_MESSAGE
     */
    public boolean isDisplayCanNotRemoveErrorMsg() {
        boolean isDisplay = false;
        try {
            isDisplay = CAN_NOT_REMOVE_ERROR_MESSAGE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CAN_NOT_REMOVE_ERROR_MESSAGE");
        }
        return isDisplay;
    }

    public String getCanNotRemoveErrorMsg() {
        String text = "";
        try {
            text = CAN_NOT_REMOVE_ERROR_MESSAGE.getText();
        } catch (Exception e) {
            Log.addLog("css of CAN_NOT_REMOVE_ERROR_MESSAGE");
        }
        return text;
    }

    /**
     * ==============================================================================================================
     * Common
     */
    public boolean isDisplay() {
        return isDisplayPopupTitle() && getPopupTitle().toLowerCase().equals("quản lý mẫu email");
    }
}
