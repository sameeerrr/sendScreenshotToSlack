import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CommonMethods {

    public static String convertImageToBase64(String imagePath) throws IOException {
        File f = new File(imagePath);
        FileInputStream fis = new FileInputStream(f);
        byte byteArray[] = new byte[(int)f.length()];
        fis.read(byteArray);
        String imageStringInBase64 = Base64.encodeBase64String(byteArray);
        return imageStringInBase64;
    }
}
