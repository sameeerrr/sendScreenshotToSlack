import io.restassured.http.ContentType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SlackIncomingWebhook {

    public static void slackWebhookPostRequest(String channelName, String imageUrl, String pretext) throws IOException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + File.separator + "config.properties");
        properties.load(fileInputStream);

        given().
                baseUri(properties.getProperty("slackBaseUri")).
                contentType(ContentType.JSON).
                when().body("{\n" +
                "\t\"channel\": \""+channelName+"\",\n" +
                "\t\"attachments\": [{\n" +
                "\t\t\"image_url\": \"" + imageUrl + "\",\n" +
                "\t  \"pretext\": \"" + pretext + "\"\n" +
                "\t}],\n" +
                "\t\"username\": \"sameer\"\n" +
                "}\n").post().
                then().statusCode(200);
    }

}
