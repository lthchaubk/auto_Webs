package apiFinanOne.Mailinator;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.common.Log;

import static io.restassured.RestAssured.given;

public class MailBox {
    private static final String domain = "finanteam.testinator.com";
    private static final String token = ""; // update token from https://www.mailinator.com/
    private static String getListMail(String inbox){
        RestAssured.baseURI = "https://api.mailinator.com/";
        RestAssured.basePath = "api/v2/domains/private/inboxes/" + inbox;

        Response resp = given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .param("token",token)
                .get();
//        resp.prettyPrint();

        String msgId = "";
        try {
            msgId = resp.jsonPath().getJsonObject("msgs[0].id");
        } catch (Exception e) {
            System.out.println("Can't get msgId, please check");
        }
        return msgId;
    }

    private static String getOTP(String inbox, String msgId){
        RestAssured.baseURI = "https://api.mailinator.com/";
        RestAssured.basePath = "api/v2/domains/" + domain + "/inboxes/" + inbox + "/messages/" + msgId;

        Response resp = given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .param("token",token)
                .get();
//        resp.prettyPrint();

        String bodyMessage = "";
        try {
            bodyMessage = resp.jsonPath().getJsonObject("parts[1].body");
        } catch (Exception e) {
            System.out.println("Can't get bodyMessage, please check");
        }
//        System.out.println("bodyMessage: " + bodyMessage);

        String newMess = bodyMessage.substring(bodyMessage.indexOf("hoàn tất xác minh bằng mã sau:"), bodyMessage.indexOf("hoàn tất xác minh bằng mã sau:") + 1000).replaceAll(" ", "");
//        System.out.println("newMess: " + newMess);
        String otp = newMess.substring(newMess.indexOf("\">\r\n") + 4,newMess.indexOf("\">\r\n") + 10);

        return otp;
    }

    public static String getOTP(String inbox){
        // remove @finanteam.testinator.com
        try {
            inbox = inbox.substring(0,inbox.indexOf("@"));
        } catch (Exception e){
            inbox = "";
            System.out.println("email is wrong format: " + inbox);
        }

        String otp = "";
        if(!inbox.equals("")) {
            try {
                String msg_id = getListMail(inbox);
                otp = getOTP(inbox, msg_id);
            } catch (Exception e) {
                Log.addLog("Can't get OTP of email " + inbox + "@finanteam.testinator.com");
            }
        }
        return otp;
    }

    public static void main(String[] args){
        String inbox = "qagRbIAnmD@finanteam.testinator.com";
        String otp  = getOTP(inbox);
        System.out.println("otp: " + otp);
    }
}