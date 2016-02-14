package xyz.thedevspot.voiperinho.helpers;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by foi on 14/02/16.
 */
public class ResourceUtils {

    public static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static String readFromFile(String fileName) {
        InputStream is = ResourceUtils.class.getClassLoader().getResourceAsStream(fileName);
        return convertStreamToString(is);
    }
}
