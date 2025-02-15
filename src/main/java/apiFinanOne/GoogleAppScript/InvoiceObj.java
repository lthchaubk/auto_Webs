package apiFinanOne.GoogleAppScript;

public class InvoiceObj {
    private static String invoiceNumber;
    private static String dueDate;
    private static int dueAmount;
    private static String sentAt;

    InvoiceObj(String invoiceNumber, String dueDate, int dueAmount, String sentAt){
        this.invoiceNumber = invoiceNumber;
        this.dueDate = dueDate;
        this.dueAmount = dueAmount;
        this.sentAt = sentAt;
    }

    public static String getInvoiceNumber(){
        return invoiceNumber;
    }
    public String getDueDate(){
        return dueDate;
    }
    public int getDueAmount(){
        return dueAmount;
    }
    public String getSentAt(){
        return sentAt;
    }
}
