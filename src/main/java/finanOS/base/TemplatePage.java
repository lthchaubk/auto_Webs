package finanOS.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.common.Log;

/**
 * Create By: chaule
 * Create At: 28Jun2023
 * Notes:
 */
public class TemplatePage extends Sidebar {
    private static final String Header = "";
    private static final String Body = "";
    private static final String Footer = "";

    /**
     * Header
     */
    @FindBy(css = Header + "")
    private WebElement HEADER_ELEMENT_NAME;

    /**
     * Body
     */
    @FindBy(css = Body + "")
    private WebElement BODY_ELEMENT_NAME;

    /**
     * Footer
     */
    @FindBy(css = Footer + "")
    private WebElement FOOTER_ELEMENT_NAME;

    /**
     * ==============================================================================================================
     * Constructor
     */
    public TemplatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Object: OBJECT/ELEMENT NAME
     */
    public boolean isDisplayElementName() {
        boolean isDisplay = false;
        try {
            isDisplay = HEADER_ELEMENT_NAME.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of ELEMENT_NAME");
        }
        return isDisplay;
    }
    public String getElementName() {
        String text = "";
        try {
            text = HEADER_ELEMENT_NAME.getText();
        } catch (Exception e) {
            Log.addLog("css of ELEMENT_NAME");
        }
        return text;
    }
    public void clearElementName() {
        try {
            HEADER_ELEMENT_NAME.clear();
        } catch (Exception e) {
            Log.addLog("css of ELEMENT_NAME");
        }
    }
    public void clickOnElementName() {
        try {
            HEADER_ELEMENT_NAME.click();
        } catch (Exception e) {
            Log.addLog("css of ELEMENT_NAME");
        }
    }
    public void setElementName(String text) {
        try {
            HEADER_ELEMENT_NAME.sendKeys(text);
        } catch (Exception e) {
            Log.addLog("css of ELEMENT_NAME");
        }
    }

    /**
     * ==============================================================================================================
     * Common
     */
    public boolean isDisplay() {
        return isDisplayElementName();
    }
}
