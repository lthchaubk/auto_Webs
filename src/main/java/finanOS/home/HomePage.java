package finanOS.home;

import finanOS.base.Sidebar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.common.Log;

import java.util.List;

/**
 * Author: Chaule
 * Created date: 16Jun2023
 */
public class HomePage extends Sidebar {
    private static final String Header = "";
    private static final String Body = "";
    private static final String Footer = "";

    /**
     * Header
     */

    /**
     * Body
     */
    @FindBy(css = Body + "#root > main > div > div > div > div > div > div:nth-child(1) > div > div")
    private WebElement QUICK_ACTION_LABEL;

    @FindBy(css = Body + "")
    private WebElement QUICK_ACTION_CREATE_INVOICE_BUTTON;

    @FindBy(css = Body + "")
    private WebElement QUICK_ACTION_CREATE_RECEIVABLE_BUTTON;

    @FindBy(css = Body + "")
    private WebElement QUICK_ACTION_CREATE_EXPENSE_BUTTON;

    @FindBy(css = Body + "")
    private WebElement QUICK_ACTION_CREATE_CONTACT_BUTTON;

    @FindBy(css = Body + "")
    private WebElement QUICK_ACTION_CREATE_PRODUCT_BUTTON;

    @FindBy(css = Body + "")
    private WebElement TODO_LIST_LABEL;

    @FindBy(css = Body + "")
    private List<WebElement> TODO_LIST;

    @FindBy(css = Body + "")
    private WebElement TOTAL_BALANCE_AMOUNT_LABEL;

    @FindBy(css = Body + "")
    private WebElement TOTAL_BALANCE_AMOUNT_VALUE;

    @FindBy(css = Body + "")
    private WebElement CASH_FLOW_INCOME_LABEL;

    @FindBy(css = Body + "")
    private WebElement CASH_FLOW_INCOME_VALUE;

    @FindBy(css = Body + "")
    private WebElement CASH_FLOW_EXPENSE_LABEL;

    @FindBy(css = Body + "")
    private WebElement CASH_FLOW_EXPENSE_VALUE;

    @FindBy(css = Body + "")
    private WebElement CASH_FLOW_GAP_LABEL;

    @FindBy(css = Body + "")
    private WebElement CASH_FLOW_GAP_VALUE;

    @FindBy(css = Body + "")
    private WebElement DEBT_LABEL;

    @FindBy(css = Body + "")
    private WebElement DEBT_INVOICE_LABEL;

    @FindBy(css = Body + "")
    private WebElement DEBT_INVOICE_VALUE;

    @FindBy(css = Body + "")
    private WebElement DEBT_CONTACT_LABEL;

    /**
     * Footer
     */

    /**
     * ==============================================================================================================
     * Constructor
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * OBJECT: QUICK_ACTION_LABEL
     */
    public boolean isDisplayQuickActionLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = QUICK_ACTION_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_LABEL");
        }
        return isDisplay;
    }

    public String getQuickActionLabel() {
        String text = "";
        try {
            text = QUICK_ACTION_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: QUICK_ACTION_CREATE_INVOICE_BUTTON
     */
    public boolean isDisplayQuickActionCreateInvoiceButton() {
        boolean isDisplay = false;
        try {
            isDisplay = QUICK_ACTION_CREATE_INVOICE_BUTTON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_INVOICE_BUTTON");
        }
        return isDisplay;
    }

    public String getQuickActionCreateInvoiceButton() {
        String text = "";
        try {
            text = QUICK_ACTION_CREATE_INVOICE_BUTTON.getText();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_INVOICE_BUTTON");
        }
        return text;
    }

    public void clickOnQuickActionCreateInvoiceButton() {
        try {
            QUICK_ACTION_CREATE_INVOICE_BUTTON.click();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_INVOICE_BUTTON");
        }
    }

    /**
     * OBJECT: CREATE_RECEIVABLE_BUTTON
     */
    public boolean isDisplayQuickActionCreateReceivableButton() {
        boolean isDisplay = false;
        try {
            isDisplay = QUICK_ACTION_CREATE_RECEIVABLE_BUTTON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_RECEIVABLE_BUTTON");
        }
        return isDisplay;
    }

    public String getQuickActionCreateReceivableButton() {
        String text = "";
        try {
            text = QUICK_ACTION_CREATE_RECEIVABLE_BUTTON.getText();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_RECEIVABLE_BUTTON");
        }
        return text;
    }

    public void clickOnQuickActionCreateReceivebleButton() {
        try {
            QUICK_ACTION_CREATE_RECEIVABLE_BUTTON.click();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_RECEIVABLE_BUTTON");
        }
    }

    /**
     * OBJECT: QUICK_ACTION_CREATE_EXPENSE_BUTTON
     */
    public boolean isDisplayQuickActionCreateExpenseButton() {
        boolean isDisplay = false;
        try {
            isDisplay = QUICK_ACTION_CREATE_EXPENSE_BUTTON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_EXPENSE_BUTTON");
        }
        return isDisplay;
    }

    public String getQuickActionCreateExpenseButton() {
        String text = "";
        try {
            text = QUICK_ACTION_CREATE_EXPENSE_BUTTON.getText();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_EXPENSE_BUTTON");
        }
        return text;
    }

    public void clickOnQuickActionCreateExpenseButton() {
        try {
            QUICK_ACTION_CREATE_EXPENSE_BUTTON.click();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_EXPENSE_BUTTON");
        }
    }

    /**
     * OBJECT: CREATE_CONTACT_BUTTON
     */
    public boolean isDisplayQuickActionCreateContactButton() {
        boolean isDisplay = false;
        try {
            isDisplay = QUICK_ACTION_CREATE_CONTACT_BUTTON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_EXPENSE_BUTTON");
        }
        return isDisplay;
    }

    public String getCreateQuickActionContactButton() {
        String text = "";
        try {
            QUICK_ACTION_CREATE_CONTACT_BUTTON.getText();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_CONTACT_BUTTON");
        }
        return text;
    }

    public void clickOnQuickActionCreateContactButton() {
        try {
            QUICK_ACTION_CREATE_CONTACT_BUTTON.click();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_CONTACT_BUTTON");
        }
    }

    /**
     * OBJECT: QUICK_ACTION_CREATE_PRODUCT_BUTTON
     */
    public boolean isDisplayQuickActionCreateProductButton() {
        boolean isDisplay = false;
        try {
            isDisplay = QUICK_ACTION_CREATE_PRODUCT_BUTTON.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_PRODUCT_BUTTON");
        }
        return isDisplay;
    }

    public String getQuickActionCreateProductButton() {
        String text = "";
        try {
            QUICK_ACTION_CREATE_PRODUCT_BUTTON.getText();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_PRODUCT_BUTTON");
        }
        return text;
    }

    public void clickOnQuickActionCreateProductButton() {
        try {
            QUICK_ACTION_CREATE_PRODUCT_BUTTON.click();
        } catch (Exception e) {
            Log.addLog("css of QUICK_ACTION_CREATE_PRODUCT_BUTTON");
        }
    }

    /**
     * OBJECT: TODO_LIST_LABEL
     */
    public boolean isDisplayTodoListLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = TODO_LIST_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of TODO_LIST_LABEL");
        }
        return isDisplay;
    }

    public String getTodoListLabel() {
        String text = "";
        try {
            TODO_LIST_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of TODO_LIST_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: TOTAL_BALANCE_AMOUNT_LABEL
     */
    public boolean isDisplayTotalBalanceAmountLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = TOTAL_BALANCE_AMOUNT_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of TOTAL_BALANCE_AMOUNT_LABEL");
        }
        return isDisplay;
    }

    public String getTotalBalanceAmountLabel() {
        String text = "";
        try {
            TOTAL_BALANCE_AMOUNT_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of TOTAL_BALANCE_AMOUNT_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: TOTAL_BALANCE_AMOUNT_VALUE
     */
    public boolean isDisplayTotalBalanceAmountValue() {
        boolean isDisplay = false;
        try {
            isDisplay = TOTAL_BALANCE_AMOUNT_VALUE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of TOTAL_BALANCE_AMOUNT_VALUE");
        }
        return isDisplay;
    }

    public String getTotalBalanceAmountValue() {
        String text = "";
        try {
            TOTAL_BALANCE_AMOUNT_VALUE.getText();
        } catch (Exception e) {
            Log.addLog("css of TOTAL_BALANCE_AMOUNT_VALUE");
        }
        return text;
    }

    /**
     * OBJECT: CASH_FLOW_INCOME_LABEL
     */
    public boolean isDisplayCashFlowIncomeLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = CASH_FLOW_INCOME_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_INCOME_LABEL");
        }
        return isDisplay;
    }

    public String getCashFlowIncomeLabel() {
        String text = "";
        try {
            CASH_FLOW_INCOME_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_INCOME_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: CASH_FLOW_INCOME_VALUE
     */
    public boolean isDisplayCashFlowIncomeValue() {
        boolean isDisplay = false;
        try {
            isDisplay = CASH_FLOW_INCOME_VALUE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_INCOME_VALUE");
        }
        return isDisplay;
    }

    public String getCashFlowIncomeValue() {
        String text = "";
        try {
            CASH_FLOW_INCOME_VALUE.getText();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_INCOME_VALUE");
        }
        return text;
    }

    /**
     * OBJECT: CASH_FLOW_EXPENSE_LABEL
     */
    public boolean isDisplayCashFlowExpenseLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = CASH_FLOW_EXPENSE_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_EXPENSE_LABEL");
        }
        return isDisplay;
    }

    public String getCashFlowExpenseLabel() {
        String text = "";
        try {
            CASH_FLOW_EXPENSE_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_EXPENSE_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: CASH_FLOW_EXPENSE_VALUE
     */
    public boolean isDisplayCashFlowExpenseValue() {
        boolean isDisplay = false;
        try {
            isDisplay = CASH_FLOW_EXPENSE_VALUE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_EXPENSE_VALUE");
        }
        return isDisplay;
    }

    public String getCashFlowExpenseValue() {
        String text = "";
        try {
            CASH_FLOW_EXPENSE_VALUE.getText();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_EXPENSE_VALUE");
        }
        return text;
    }

    /**
     * OBJECT: CASH_FLOW_GAP_LABEL
     */
    public boolean isDisplayCashFlowGapLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = CASH_FLOW_GAP_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_GAP_LABEL");
        }
        return isDisplay;
    }

    public String getCashFlowGapLabel() {
        String text = "";
        try {
            CASH_FLOW_GAP_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_GAP_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: CASH_FLOW_GAP_VALUE
     */
    public boolean isDisplayCashFlowGabValue() {
        boolean isDisplay = false;
        try {
            isDisplay = CASH_FLOW_GAP_VALUE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_GAP_VALUE");
        }
        return isDisplay;
    }

    public String getCashFlowGabValue() {
        String text = "";
        try {
            CASH_FLOW_GAP_VALUE.getText();
        } catch (Exception e) {
            Log.addLog("css of CASH_FLOW_GAP_VALUE");
        }
        return text;
    }

    /**
     * OBJECT: DEBT_LABEL
     */
    public boolean isDisplayDebtLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = DEBT_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of DEBT_LABEL");
        }
        return isDisplay;
    }

    public String getDebtLabel() {
        String text = "";
        try {
            DEBT_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of DEBT_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: DEBT_INVOICE_LABEL
     */
    public boolean isDisplayDebtInvoiceLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = DEBT_INVOICE_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of DEBT_INVOICE_LABEL");
        }
        return isDisplay;
    }

    public String getDebtInvoiceLabel() {
        String text = "";
        try {
            DEBT_INVOICE_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of DEBT_INVOICE_LABEL");
        }
        return text;
    }

    /**
     * OBJECT: DEBT_INVOICE_VALUE
     */
    public boolean isDisplayDebtInvoiceValue() {
        boolean isDisplay = false;
        try {
            isDisplay = DEBT_INVOICE_VALUE.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of DEBT_INVOICE_VALUE");
        }
        return isDisplay;
    }

    public String getDebtInvoiceValue() {
        String text = "";
        try {
            DEBT_INVOICE_VALUE.getText();
        } catch (Exception e) {
            Log.addLog("css of DEBT_INVOICE_VALUE");
        }
        return text;
    }


    /**
     * OBJECT: DEBT_CONTACT_LABEL
     */
    public boolean isDisplayDebtContactLabel() {
        boolean isDisplay = false;
        try {
            isDisplay = DEBT_CONTACT_LABEL.isDisplayed();
        } catch (Exception e) {
            Log.addLog("css of DEBT_CONTACT_LABEL");
        }
        return isDisplay;
    }

    public String getDebtContactLabel() {
        String text = "";
        try {
            DEBT_CONTACT_LABEL.getText();
        } catch (Exception e) {
            Log.addLog("css of DEBT_CONTACT_LABEL");
        }
        return text;
    }

    /**
     * Common
     */
    public boolean isDisplay() {
//        System.out.println("debug : " + isDisplayPageTitle());
        switch (Configs.language) {
            case EN:
//                System.out.println("debug : " + getPageTitle().equals("Welcome to FinanBook"));
                return getPageTitle().equals("Dashboard");
            case VI:
            default:
//                System.out.println("debug : " + getPageTitle().equals("Chào mừng đến với FinanBook"));
                return getPageTitle().equals("Tổng quan");
        }
    }
}
