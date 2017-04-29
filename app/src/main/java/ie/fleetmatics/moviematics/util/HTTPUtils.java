package ie.fleetmatics.moviematics.util;

import ie.fleetmatics.moviematics.constants.Constants;

/**
 * This class is a HTTP Utility class
 */
public class HTTPUtils {

    /**
     * Returns the absolute url of the http call
     *
     * @param relativeUrl
     * @return
     */
    public static String getAbsoluteUrl(String relativeUrl) {
        System.out.println("Absolute URL: " + Constants.BASE_URL + relativeUrl);
        return Constants.BASE_URL + relativeUrl;
    }

}