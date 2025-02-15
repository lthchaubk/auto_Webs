/* (C)2024 */
package finanOS.emailTemplate;

import finanOS.base.Sidebar;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.common.Log;

public class CreateOrUpdateEmailTemplatePopup extends Sidebar {
    private static final String Header = "";
    private static final String Body = "";

    /**
     * Header
     */
    @FindBy(css = Header + "")
    private WebElement PAGE_TITLE;
    @FindBy(css = Header + "")
    private WebElement CLOSE_ICON_BTN;

    /**
     * Body
     */
    @FindBy(css = Body + "")
    private WebElement NAME_EMAIL_TITLE;
    @FindBy(css = Body + "")
    private WebElement NAME_EMAIL_TEXT_BOX;
    @FindBy(css = Body + "")
    private WebElement NAME_EMAIL_ERROR_MESSAGE;
    @FindBy(css = Body + "")
    private WebElement SUB_NAME_TITLE;
    @FindBy(css = Body + "")
    private WebElement SUB_NAME_TEXT_BOX;
    @FindBy(css = Body + "")
    private WebElement SUB_NAME_MANDATORY_ERROR_MESSAGE;
    @FindBy(css = Body + "")
    private WebElement CONTENT_TITLE;
    @FindBy(css = Body + "")
    private WebElement CONTENT_TEXT_BOX;
    @FindBy(css = Body + "")
    private WebElement CONTENT_MANDATORY_ERROR_MESSAGE;
    @FindBy(css = Body + "")
    private WebElement SUGGESTION_POPUP_TITLE;
    @FindBy(css = Body + "")
    private WebElement SUGGESTION_POPUP_CONTENT;
    @FindBy(css = Body + "")
    private List<WebElement> LIST_SUGGESTION;
    @FindBy(css = Body + "")
    private WebElement EMAIL_DEFAULT_OPTION;
    @FindBy(css = Body + "")
    private WebElement BACK_BTN;
    @FindBy(css = Body + "")
    private WebElement CONFIRM_BTN;

    public CreateOrUpdateEmailTemplatePopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Object: PAGE_TITLE
     */
    public boolean isDisplayPageTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = PAGE_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of PAGE_TITLE");
        }
        return isDisplay;
    }

    public String getPageTitle() {
        String text = "";
        try {
            text = PAGE_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of PAGE_TITLE");
        }
        return text;
    }

    /**
     * Object: CLOSE_ICON_BTC
     */
    public boolean isDisplayCloseIconButton() {
        boolean isDisplay = false;
        try {
            isDisplay = CLOSE_ICON_BTN.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CLOSE_ICON_BTN");
        }
        return isDisplay;
    }

    public String getCloseIconButton() {
        String text = "";
        try {
            text = CLOSE_ICON_BTN.getText();
        } catch (Exception e) {
            Log.addLog("css of CLOSE_ICON_BTN");
        }
        return text;
    }

    public void clickOnCloseIconButton() {
        try {
            CLOSE_ICON_BTN.click();
        } catch (Exception e) {
            Log.addLog("css of CLOSE_ICON_BTN");
        }
    }

    /**
     * Object: NAME_EMAIL_TITLE
     */
    public boolean isDisplayNameEmailTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = NAME_EMAIL_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TITLE");
        }
        return isDisplay;
    }

    public String getNameEmailTitle() {
        String text = "";
        try {
            text = NAME_EMAIL_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TITLE");
        }
        return text;
    }

    /**
     * Object: NAME_EMAIL_TEXT_BOX
     */
    public boolean isDisplayNameEmailTextBox() {
        boolean isDisplay = false;
        try {
            isDisplay = NAME_EMAIL_TEXT_BOX.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TEXT_BOX");
        }
        return isDisplay;
    }

    public String getNameEmailTextBox() {
        String text = "";
        try {
            text = NAME_EMAIL_TEXT_BOX.getText();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TEXT_BOX");
        }
        return text;
    }

    public void setNameEmailTextBox(String text) {
        try {
            NAME_EMAIL_TEXT_BOX.sendKeys(text);
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TEXT_BOX");
        }
    }

    public void clearNameEmailTextBox() {
        try {
            NAME_EMAIL_TEXT_BOX.clear();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TEXT_BOX");
        }
    }

    /**
     * Object: NAME_EMAIL_ERROR_MESSAGE
     */
    public boolean isDisplayNameEmailMandatoryErrorMsg() {
        boolean isDisplay = false;
        try {
            isDisplay = NAME_EMAIL_ERROR_MESSAGE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_ERROR_MESSAGE");
        }
        return isDisplay;
    }

    public String getNameEmailMandatoryErrorMsg() {
        String text = "";
        try {
            text = NAME_EMAIL_ERROR_MESSAGE.getText();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_ERROR_MESSAGE");
        }
        return text;
    }

    /**
     * Object: SUB_NAME_TITLE
     */
    public boolean isDisplaySubNameTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = SUB_NAME_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_TITLE");
        }
        return isDisplay;
    }

    public String getSubNameTitle() {
        String text = "";
        try {
            text = SUB_NAME_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_TITLE");
        }
        return text;
    }

    /**
     * Object: SUB_NAME_TEXT_BOX
     */
    public boolean isDisplaySubNameTextBox() {
        boolean isDisplay = false;
        try {
            isDisplay = SUB_NAME_TEXT_BOX.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_TEXT_BOX");
        }
        return isDisplay;
    }

    public String getSubNameTextBox() {
        String text = "";
        try {
            text = SUB_NAME_TEXT_BOX.getText();
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_TEXT_BOX");
        }
        return text;
    }

    public void setSubNameTextBox(String text) {
        try {
            SUB_NAME_TEXT_BOX.sendKeys(text);
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_TEXT_BOX");
        }
    }

    public void clearSubNameTextBox() {
        try {
            SUB_NAME_TEXT_BOX.clear();
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_TEXT_BOX");
        }
    }

    /**
     * Object: SUB_NAME_MANDATORY_ERROR_MESSAGE
     */
    public boolean isDisplaySubNameMandatoryErrorMsg() {
        boolean isDisplay = false;
        try {
            isDisplay = SUB_NAME_MANDATORY_ERROR_MESSAGE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_MANDATORY_ERROR_MESSAGE");
        }
        return isDisplay;
    }

    public String getSubNameMandatoryErrorMsg() {
        String text = "";
        try {
            text = SUB_NAME_MANDATORY_ERROR_MESSAGE.getText();
        } catch (Exception e) {
            Log.addLog("css of SUB_NAME_MANDATORY_ERROR_MESSAGE");
        }
        return text;
    }

    /**
     * Object: CONTENT_TITLE
     */
    public boolean isDisplayContentTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = CONTENT_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CONTENT_TITLE");
        }
        return isDisplay;
    }

    public String getContentTitle() {
        String text = "";
        try {
            text = CONTENT_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of CONTENT_TITLE");
        }
        return text;
    }

    /**
     * Object: CONTENT_TEXT_BOX
     */
    public boolean isDisplayContentTextBox() {
        boolean isDisplay = false;
        try {
            isDisplay = CONTENT_TEXT_BOX.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CONTENT_TEXT_BOX");
        }
        return isDisplay;
    }

    public String getContentTextBox() {
        String text = "";
        try {
            text = CONTENT_TEXT_BOX.getText();
        } catch (Exception e) {
            Log.addLog("css of CONTENT_TEXT_BOX");
        }
        return text;
    }

    public void setContentTextBox(String text) {
        try {
            CONTENT_TEXT_BOX.sendKeys(text);
        } catch (Exception e) {
            Log.addLog("css of CONTENT_TEXT_BOX");
        }
    }

    public void clearContentTextBox() {
        try {
            CONTENT_TEXT_BOX.clear();
        } catch (Exception e) {
            Log.addLog("css of CONTENT_TEXT_BOX");
        }
    }

    /**
     * Object: CONTENT_MANDATORY_ERROR_MESSAGE
     */
    public boolean isDisplayContentMandatoryErrorMsg() {
        boolean isDisplay = false;
        try {
            isDisplay = CONTENT_MANDATORY_ERROR_MESSAGE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CONTENT_MANDATORY_ERROR_MESSAGE");
        }
        return isDisplay;
    }

    public String getContentMandatoryErrorMsg() {
        String text = "";
        try {
            text = CONTENT_MANDATORY_ERROR_MESSAGE.getText();
        } catch (Exception e) {
            Log.addLog("css of CONTENT_MANDATORY_ERROR_MESSAGE");
        }
        return text;
    }

    /**
     * Object: SUGGESTION_POPUP_TITLE
     */
    public boolean isDisplaySuggestionPopupTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = SUGGESTION_POPUP_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of SUGGESTION_POPUP_TITLE");
        }
        return isDisplay;
    }

    public String getSuggestionPopupTitle() {
        String text = "";
        try {
            text = SUGGESTION_POPUP_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of SUGGESTION_POPUP_TITLE");
        }
        return text;
    }

    /**
     * Object: SUGGESTION_POPUP_CONTENT
     */
    public boolean isDisplaySuggestionPopupContent() {
        boolean isDisplay = false;
        try {
            isDisplay = SUGGESTION_POPUP_CONTENT.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of SUGGESTION_POPUP_CONTENT");
        }
        return isDisplay;
    }

    public String getSuggestionPopupContent() {
        String text = "";
        try {
            text = SUGGESTION_POPUP_CONTENT.getText();
        } catch (Exception e) {
            Log.addLog("css of SUGGESTION_POPUP_CONTENT");
        }
        return text;
    }

    /**
     * Object: LIST_SUGGESTION
     */
    private WebElement getRecordElement(int pos) {
        WebElement element = null;
        try {
            element = LIST_SUGGESTION.get(pos);
        } catch (Exception e) {
            Log.addLog("css of LIST_RECORD at " + pos);
        }
        return element;
    }

    public int getTotalRecordTable() {
        int total = 0;
        try {
            total = LIST_SUGGESTION.size();
        } catch (Exception e) {
            Log.addLog("css of LIST_SUGGESTION");
        }
        return total;
    }

    public void clickOnRecordByPosition(int pos) {
        WebElement element = getRecordElement(pos);
        if (element != null) {
            element.click();
        }
    }

    /**
     * Object: EMAIL_DEFAULT_OPTION
     */
    public boolean isDisplayEmailDefaultOption() {
        boolean isDisplay = false;
        try {
            isDisplay = EMAIL_DEFAULT_OPTION.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of EMAIL_DEFAULT_OPTION");
        }
        return isDisplay;
    }

    public String getEmailDefaultOption() {
        String text = "";
        try {
            text = EMAIL_DEFAULT_OPTION.getText();
        } catch (Exception e) {
            Log.addLog("css of EMAIL_DEFAULT_OPTION");
        }
        return text;
    }

    public void clickOnEmailDefaultOption() {
        try {
            EMAIL_DEFAULT_OPTION.click();
        } catch (Exception e) {
            Log.addLog("css of EMAIL_DEFAULT_OPTION");
        }
    }

    /**
     * Object: BACK_BTN
     */
    public boolean isDisplayBackBtn() {
        boolean isDisplay = false;
        try {
            isDisplay = BACK_BTN.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of BACK_BTN");
        }
        return isDisplay;
    }

    public String getBackBtn() {
        String text = "";
        try {
            text = BACK_BTN.getText();
        } catch (Exception e) {
            Log.addLog("css of BACK_BTN");
        }
        return text;
    }

    public void clickOnBackBtn() {
        try {
            BACK_BTN.click();
        } catch (Exception e) {
            Log.addLog("css of BACK_BTN");
        }
    }

    /**
     * Object: CONFIRM_BTN
     */
    public boolean isDisplayConfirmBtn() {
        boolean isDisplay = false;
        try {
            isDisplay = CONFIRM_BTN.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CONFIRM_BTN");
        }
        return isDisplay;
    }

    public String getConfirmBtn() {
        String text = "";
        try {
            text = CONFIRM_BTN.getText();
        } catch (Exception e) {
            Log.addLog("css of CONFIRM_BTN");
        }
        return text;
    }

    public void clickOnConfirmBtn() {
        try {
            CONFIRM_BTN.click();
        } catch (Exception e) {
            Log.addLog("css of CONFIRM_BTN");
        }
    }

    /**
     * ==============================================================================================================
     * Common
     */
    public boolean isDisplayCreateEmailTemplate() {
        return isDisplayPageTitle() && getPageTitle().toLowerCase().equals("tạo mẫu email");
    }
    public boolean isDisplayUpdateEmailTemplate() {
        return isDisplayPageTitle() && getPageTitle().toLowerCase().equals("sửa mẫu email");
    }
}

