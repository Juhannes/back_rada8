package ee.rada8.back_rada8.util;

public class PictureUtil {
    public static String byteArrayToString(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        } else {
            return new String(byteArray);
        }
    }
}
