package apiFinanOne.GoogleAppScript;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class MailBox {
    private static final String emailConfig = "";
    public static InvoiceObj getListInvoice(){
        RestAssured.baseURI = "https://script.google.com/";
        RestAssured.basePath = "";

        Response resp = given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .get();

        InvoiceObj invoiceObj = null;
        try {
            invoiceObj = new InvoiceObj(resp.jsonPath().getJsonObject("data[0].invoice_number"),
                    resp.jsonPath().getJsonObject("data[0].due_date"),
                    resp.jsonPath().getJsonObject("data[0].due_amount"),
                    resp.jsonPath().getJsonObject("data[0].sent_at"));
        } catch (Exception e){
            System.out.println("Nothing invoice sent to " + emailConfig);
            resp.prettyPrint();
        }

        return invoiceObj;
    }

    public static String getLastOTP(){
        RestAssured.baseURI = "https://script.google.com/";
        RestAssured.basePath = "";

        Response resp = given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .get();

        String otp = "";
        try {
            otp = resp.jsonPath().getJsonObject("data.otp");
        } catch (Exception e){
            System.out.println("Nothing otp sent to " + emailConfig);
            resp.prettyPrint();
        }
        return otp;
    }

    public static boolean makeReadMail(String invoiceNumber, String domain){
        RestAssured.baseURI = "https://script.google.com/";
        RestAssured.basePath = "";

        Response resp = given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .param("invoice_number",invoiceNumber)
                .param("domain",domain)
                .get();
        resp.prettyPrint();

        boolean isRead = false;
        try {
            if(resp.jsonPath().getJsonObject("data").equals("completed")){
                isRead = true;
            }
        } catch (Exception e){
            System.out.println("Can't make read invoice " + invoiceNumber + " at email " + emailConfig);
            resp.prettyPrint();
        }

        return isRead;
    }

    public static void main(String[] args) {
//        InvoiceObj invoiceObj = getListInvoice();
//        System.out.println(invoiceObj.getInvoiceNumber());
//        System.out.println(invoiceObj.getDueDate());
//        System.out.println(invoiceObj.getDueAmount());
//        System.out.println(invoiceObj.getSentAt());

//        String otp = getLastOTP();
//        System.out.println("otp: " + otp);

        boolean makeRead = makeReadMail("HD-aT7A3O","notifications@finan.one");
        System.out.println("is read: " + makeRead);
    }
}
