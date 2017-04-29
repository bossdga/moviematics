package ie.fleetmatics.moviematics.model;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by bossdga on 28/04/2017.
 */
public class BundleFactory {

    /**
     * Method that creates and returns a bundle
     * @param type
     * @param extras
     * @return
     */
    public static Bundle createBundle(ContentType type, Intent extras) {
        Bundle bundle = null;

        switch (type) {
            case MOVIE:
                bundle = extras.getBundleExtra("movieBundle");
                break;
            case TVSHOW:
                bundle = extras.getBundleExtra("tvShowBundle");
                break;
            case PERSON:
                bundle = extras.getBundleExtra("peopleBundle");
                break;
        }

        return bundle;
    }

}
