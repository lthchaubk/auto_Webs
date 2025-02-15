/* (C)2024 */
package finanOS.emailTemplate;

import finanOS.base.Sidebar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.common.Log;

public class EmailTemplateListPage extends Sidebar {
    private static final String Header = "";
    private static final String Body = "";
    private static final String EmailTemplateCheckpoint = "";
    private static final String EmailTemplateNameTittle = "";
    private static final String EmailTemplateSubTittle = "";
    private static final String EmailTemplateMoreActionIcon = "";
    private static final String EmailTemplateEditByPosition = "";
    private static final String EmailTemplateRemoveByPosition = "";
    private static final String EmailTemplateDefaultByPosition = "";

    /**
     * Header
     */
    @FindBy(css = Header + "")
    private WebElement PAGE_TITLE;
    @FindBy(css = Header + "")
    private WebElement BACK_BUTTON;

    /**
     * Left Menu
     */
    @FindBy(css = Body + "")
    private WebElement NEW_INVOICE_NOTIFY_MENU_LIST;
    @FindBy(css = Body + "")
    private WebElement INVOICE_REMIND_MENU_LIST;

    /**
     * Right Body
     */
    @FindBy(css = Body + "")
    private WebElement NEW_INVOICE_NOTIFY_TITLE;
    @FindBy(css = Body + "")
    private WebElement INVOICE_REMIND_TITLE;
    @FindBy(css = Body + "")
    private WebElement CREATE_BUTTON;
    @FindBy(css = Body + "")
    private WebElement NAME_EMAIL_TEMPLATE_TITLE;
    @FindBy(css = Body + "")
    private WebElement SUB_EMAIL_TITLE;
    @FindBy(css = Body + "")
    private WebElement ACTION_TITLE;
    @FindBy(css = Body + "")
    private List<WebElement> LIST_RECORD;

    public EmailTemplateListPage(WebDriver driver) {
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
     * Object: BACK_BUTTON
     */
    public boolean isDisplayBackButton() {
        boolean isDisplay = false;
        try {
            isDisplay = BACK_BUTTON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of BACK_BUTTON");
        }
        return isDisplay;
    }

    public String getBackButtonText() {
        String text = "";
        try {
            text = BACK_BUTTON.getText();
        } catch (Exception e) {
            Log.addLog("css of BACK_BUTTON");
        }
        return text;
    }

    public void clickOnBackButton() {
        try {
            BACK_BUTTON.click();
        } catch (Exception e) {
            Log.addLog("css of BACK_BUTTON");
        }
    }

    /**
     * Object: Left Menu: NEW_INVOICE_NOTIFY_MENU_LIST
     */
    public boolean isDisplayNewInvoiceNotifyMenuList() {
        boolean isDisplay = false;
        try {
            isDisplay = NEW_INVOICE_NOTIFY_MENU_LIST.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of NEW_INVOICE_NOTIFY_MENU_LIST");
        }
        return isDisplay;
    }

    public String getNewInvoiceNotifyMenuList() {
        String text = "";
        try {
            text = NEW_INVOICE_NOTIFY_MENU_LIST.getText();
        } catch (Exception e) {
            Log.addLog("css of NEW_INVOICE_NOTIFY_MENU_LIST");
        }
        return text;
    }

    public void clickOnNewInvoiceNotifyMenuList() {
        try {
            NEW_INVOICE_NOTIFY_MENU_LIST.click();
        } catch (Exception e) {
            Log.addLog("css of NEW_INVOICE_NOTIFY_MENU_LIST");
        }
    }

    /**
     * Object: Left Menu: INVOICE_REMIND_MENU_LIST
     */
    public boolean isDisplayInvoiceRemindMenuList() {
        boolean isDisplay = false;
        try {
            isDisplay = INVOICE_REMIND_MENU_LIST.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of INVOICE_REMIND_MENU_LIST");
        }
        return isDisplay;
    }

    public String getInvoiceRemindMenuList() {
        String text = "";
        try {
            text = INVOICE_REMIND_MENU_LIST.getText();
        } catch (Exception e) {
            Log.addLog("css of INVOICE_REMIND_MENU_LIST");
        }
        return text;
    }

    public void clickOnInvoiceRemindMenuList() {
        try {
            INVOICE_REMIND_MENU_LIST.click();
        } catch (Exception e) {
            Log.addLog("css of INVOICE_REMIND_MENU_LIST");
        }
    }

    /**
     * Object: Right body: NEW_INVOICE_NOTIFY_TITLE
     */
    public boolean isDisplayNewInvoiceNotifyTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = NEW_INVOICE_NOTIFY_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of NEW_INVOICE_NOTIFY_TITLE");
        }
        return isDisplay;
    }

    public String getNewInvoiceNotifyTitle() {
        String text = "";
        try {
            text = NEW_INVOICE_NOTIFY_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of NEW_INVOICE_NOTIFY_TITLE");
        }
        return text;
    }

    /**
     * Object: Right body: INVOICE_REMIND_TITLE
     */
    public boolean isDisplayInvoiceRemindTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = INVOICE_REMIND_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of INVOICE_REMIND_TITLE");
        }
        return isDisplay;
    }

    public String getInvoiceRemindTitle() {
        String text = "";
        try {
            text = INVOICE_REMIND_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of INVOICE_REMIND_TITLE");
        }
        return text;
    }

    /**
     * Object: Right body: CREATE_BUTTON
     */
    public boolean isDisplayCreateButton() {
        boolean isDisplay = false;
        try {
            isDisplay = CREATE_BUTTON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CREATE_BUTTON");
        }
        return isDisplay;
    }

    public String getCreateButtonText() {
        String text = "";
        try {
            text = CREATE_BUTTON.getText();
        } catch (Exception e) {
            Log.addLog("css of CREATE_BUTTON");
        }
        return text;
    }

    public void clickOnCreateButton() {
        try {
            CREATE_BUTTON.click();
        } catch (Exception e) {
            Log.addLog("css of CREATE_BUTTON");
        }
    }

    /**
     * Object: Right body: NAME_EMAIL_TEMPLATE_TITLE
     */
    public boolean isDisplayNameEmailTemplateTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = NAME_EMAIL_TEMPLATE_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TEMPLATE_TITLE");
        }
        return isDisplay;
    }

    public String getNameEmailTemplateTitle() {
        String text = "";
        try {
            text = NAME_EMAIL_TEMPLATE_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of NAME_EMAIL_TEMPLATE_TITLE");
        }
        return text;
    }

    /**
     * Object: Right body: SUB_EMAIL_TITLE
     */
    public boolean isDisplaySubEmailTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = SUB_EMAIL_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of SUB_EMAIL_TITLE");
        }
        return isDisplay;
    }

    public String getNameSubEmailTitle() {
        String text = "";
        try {
            text = SUB_EMAIL_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of SUB_EMAIL_TITLE");
        }
        return text;
    }

    /**
     * Object: Right body: ACTION_TITLE
     */
    public boolean isDisplayActionTitle() {
        boolean isDisplay = false;
        try {
            isDisplay = ACTION_TITLE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of ACTION_TITLE");
        }
        return isDisplay;
    }

    public String getActionTitle() {
        String text = "";
        try {
            text = ACTION_TITLE.getText();
        } catch (Exception e) {
            Log.addLog("css of ACTION_TITLE");
        }
        return text;
    }

    /**
     * --------------------------------------------------------------
     * Object: Right body: Records - LIST_RECORD
     */
    private WebElement getRecordElementByPosition(int pos) {
        WebElement element = null;
        try {
            element = LIST_RECORD.get(pos);
        } catch (Exception e) {
            Log.addLog("css of LIST_RECORD at " + pos);
        }
        return element;
    }

    public int getTotalRecordTable() {
        int total = 0;
        try {
            total = LIST_RECORD.size();
        } catch (Exception e) {
            Log.addLog("css of LIST_RECORD");
        }
        return total;
    }

    public void clickOnRecordByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            element.click();
        }
    }

    /**
     * --- EmailTemplateCheckpoint ---
     */
    public void clickOnEmailTemplateCheckpointByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            try {
                element.findElement(By.cssSelector(EmailTemplateCheckpoint)).click();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateCheckpoint at " + pos);
            }
        }
    }

    /**
     * --- EmailTemplateNameTittle ---
     */
    public boolean isDisplayEmailTemplateNameTittle(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        boolean isDisplay = false;
        try {
            isDisplay = element.findElement(By.cssSelector(EmailTemplateNameTittle)).isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of EmailTemplateNameTittle at" + pos);
        }
        return isDisplay;
    }

    public String getEmailTemplateNameTittleByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector(EmailTemplateNameTittle)).getText();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateNameTittle at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    /**
     * --- EmailTemplateSubTittle ---
     */
    public boolean isDisplayEmailTemplateSubTittleByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        boolean isDisplay = false;
        try {
            isDisplay = element.findElement(By.cssSelector(EmailTemplateSubTittle)).isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of EmailTemplateSubTittle at" + pos);
        }
        return isDisplay;
    }

    public String getEmailTemplateSubTittleByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector(EmailTemplateSubTittle)).getText();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateSubTittle at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    /**
     * --- EmailTemplateMoreActionIcon ---
     */
    public boolean isDisplayEmailTemplateMoreActionIconByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        boolean isDisplay = false;
        try {
            isDisplay =
                    element.findElement(By.cssSelector(EmailTemplateMoreActionIcon)).isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of EmailTemplateMoreActionIcon at" + pos);
        }
        return isDisplay;
    }

    public void clickOnEmailTemplateMoreActionIconByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            try {
                element.findElement(By.cssSelector(EmailTemplateMoreActionIcon)).click();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateMoreActionIcon at " + pos);
            }
        }
    }

    /**
     * --- EmailTemplateEditByPosition ---
     */
    public boolean isDisplayEmailTemplateEditByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        boolean isDisplay = false;
        try {
            isDisplay =
                    element.findElement(By.cssSelector(EmailTemplateEditByPosition)).isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of EmailTemplateEditByPosition at" + pos);
        }
        return isDisplay;
    }

    public String getEmailTemplateEditByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector(EmailTemplateEditByPosition)).getText();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateEditByPosition at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    public void clickOnEmailTemplateEditByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            try {
                element.findElement(By.cssSelector(EmailTemplateEditByPosition)).click();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateEditByPosition at " + pos);
            }
        }
    }

    /**
     * --- EmailTemplateDefaultByPosition ---
     */
    public boolean isDisplayEmailTemplateDefaultByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        boolean isDisplay = false;
        try {
            isDisplay =
                    element.findElement(By.cssSelector(EmailTemplateDefaultByPosition))
                            .isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of EmailTemplateDefaultByPosition at" + pos);
        }
        return isDisplay;
    }

    public String getEmailTemplateDefaultByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            String text = "";
            try {
                text =
                        element.findElement(By.cssSelector(EmailTemplateDefaultByPosition))
                                .getText();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateDefaultByPosition at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    public void clickOnEmailTemplateDefaultByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            try {
                element.findElement(By.cssSelector(EmailTemplateDefaultByPosition)).click();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateDefaultByPosition at " + pos);
            }
        }
    }

    /**
     * --- EmailTemplateRemoveByPosition ---
     */
    public boolean isDisplayEmailTemplateRemoveByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        boolean isDisplay = false;
        try {
            isDisplay =
                    element.findElement(By.cssSelector(EmailTemplateRemoveByPosition))
                            .isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of EmailTemplateRemoveByPosition at" + pos);
        }
        return isDisplay;
    }

    public String getEmailTemplateRemoveByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            String text = "";
            try {
                text = element.findElement(By.cssSelector(EmailTemplateRemoveByPosition)).getText();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateRemoveByPosition at " + pos);
            }
            return text;
        } else {
            return "";
        }
    }

    public void clickOnEmailTemplateRemoveByPosition(int pos) {
        WebElement element = getRecordElementByPosition(pos);
        if (element != null) {
            try {
                element.findElement(By.cssSelector(EmailTemplateRemoveByPosition)).click();
            } catch (Exception e) {
                Log.addLog("css of EmailTemplateRemoveByPosition at " + pos);
            }
        }
    }

    /**
     * ==============================================================================================================
     * Common
     */
    public boolean isDisplay() {
        return isDisplayPageTitle() && getPageTitle().toLowerCase().equals("quản lý mẫu email");
    }
}
