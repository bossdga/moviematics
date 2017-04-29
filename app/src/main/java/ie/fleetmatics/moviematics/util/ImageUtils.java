package ie.fleetmatics.moviematics.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Utility class to deal with images
 */
public class ImageUtils {

    /**
     * Sets an image to an ImageView from an url
     * @param context
     * @param image
     * @param url
     */
    public static void setImage(Context context, ImageView image, String url) {
        Picasso.with(context).load(url).into(image);
    }

}