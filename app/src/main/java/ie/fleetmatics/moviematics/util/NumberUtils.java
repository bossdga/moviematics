package ie.fleetmatics.moviematics.util;

/**
 * This class is a number Utility class
 */
public class NumberUtils {

    /**
     * Returns a formatted two decimals double
     * @param number
     * @return
     */
    public static String getFormattedDouble(double number) {
        return String.format("%.02f", number);
    }

}
