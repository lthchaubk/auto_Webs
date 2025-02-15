package utilities.common;

import com.mongodb.util.JSON;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LarkWebhook {
    private static final String larkWebhook = "";
    private static final String channel = "";

    public static void postEndRequest(String message, String reportUrl, String logUrl, boolean isPass) {
        RestAssured.baseURI = "https://open.larksuite.com/";
        RestAssured.basePath = "";

        String color, report;
        if (isPass) {
            color = "green";
            report = " <font color='green'>is **PASSED**</font>";
        } else {
            color = "red";
            report = " <font color='red'>is **FAILED**</font>";
        }

        Map<String, Object> field1 = new HashMap<>();
        field1.put("tag","markdown");
        field1.put("content","**Report:** [view here](" + reportUrl + ")");

        Map<String, Object> field2 = new HashMap<>();
        field2.put("tag","markdown");
        field2.put("content","**Log:** [view here](" + logUrl + ")");

        Map<String, Object> textx1 = new HashMap<>();
        textx1.put("tag","lark_md");
        textx1.put("content","**\uD83D\uDDF3 Run by：**\n " + Configs.user.getLarkIcon() + " " + Configs.user.getLarkID() + " " + Configs.user.getLarkIcon()); //<at id=@aa></at>

        Map<String, Object> fieldx1 = new HashMap<>();
        fieldx1.put("is_short",true);
        fieldx1.put("text",textx1);

        Map<String, Object> textx4 = new HashMap<>();
        textx4.put("tag","lark_md");
        textx4.put("content","**Environment：**\n" + Configs.env.getName());

        Map<String, Object> fieldx4 = new HashMap<>();
        fieldx4.put("is_short",true);
        fieldx4.put("text",textx4);

        Map<String, Object> textx5 = new HashMap<>();
        textx5.put("tag","lark_md");
        textx5.put("content","**Result：**\n" + report);

        Map<String, Object> fieldx5 = new HashMap<>();
        fieldx5.put("is_short",true);
        fieldx5.put("text",textx5);

        List<Object> fields = new ArrayList<>();
        fields.add(fieldx1);
        fields.add(fieldx4);
        fields.add(fieldx5);

        Map<String, Object> field3 = new HashMap<>();
        field3.put("tag","div");
        field3.put("fields",fields);

        List<Object> elements = new ArrayList<>();
        elements.add(field1);
        elements.add(field2);
        elements.add(field3);

        Map<String, Object> title = new HashMap<>();
        title.put("content",message);
        title.put("tag","plain_text");

        Map<String, Object> header = new HashMap<>();
        header.put("template",color);
        header.put("title",title);

        Map<String, Object> config = new HashMap<>();
        config.put("wide_screen_mode", true);

        Map<String, Object> card = new HashMap<>();
        card.put("config", config);
        card.put("elements", elements);
        card.put("header",header);

        Map<String, Object> payload = new HashMap<>();
        payload.put("msg_type","interactive");
        payload.put("card",card);

//        System.out.println("payload: " + JSON.serialize(payload));
        Response resp = given().relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .body(JSON.serialize(payload))
                .post(larkWebhook);
//        int respCode = resp.getStatusCode();
//        System.out.println("respCode: " + respCode);
//        resp.prettyPrint();
    }

    public static void main(String[] args){
        postEndRequest("test message","test report url","test log url",true);
    }
}
