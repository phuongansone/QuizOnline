package util;

/**
 *
 * @author andtpse62827
 */
public class StringUtil {
    public static int parseInt(String number, int defaultValue) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
