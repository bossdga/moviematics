package ie.fleetmatics.moviematics.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Class that represents BaseContent
 */
public class BaseContent implements Parcelable {

    private int id;
    private String name;
    private String imageUrl;
    private double popularity;

    public BaseContent() {
        super();
    }

    public BaseContent(String name) {
        this.name = name;
    }

    protected BaseContent(Parcel in) {
        id = in.readInt();
        name = in.readString();
        imageUrl = in.readString();
        popularity = in.readDouble();
    }

    public static final Parcelable.Creator<BaseContent> CREATOR = new Parcelable.Creator<BaseContent>() {
        @Override
        public BaseContent createFromParcel(Parcel in) {
            return new BaseContent(in);
        }

        @Override
        public BaseContent[] newArray(int size) {
            return new BaseContent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeDouble(popularity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

}