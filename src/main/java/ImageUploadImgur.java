import io.restassured.RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ImageUploadImgur {

    public static String uploadImageToImgur(String imageLocalPath) throws Exception {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + File.separator + "config.properties");
        properties.load(fileInputStream);

        RestAssured.baseURI="https://api.imgur.com/3/image";
        String imagePath = given().
                header("Authorization",properties.getProperty("authorization")).
                header("Content-Type","application/x-www-form-urlencoded; charset=UTF-8").
                formParam("image", CommonMethods.convertImageToBase64(imageLocalPath)).
                when().post().
                then().statusCode(200).
                extract().path("data.link");

        return imagePath;
    }
}
