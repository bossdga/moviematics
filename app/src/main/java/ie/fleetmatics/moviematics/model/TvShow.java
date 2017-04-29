package ie.fleetmatics.moviematics.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Class that represents a TvShow
 */
public class TvShow extends BaseContent {

    private String overview;
    private String date;
    private List<String> genres;

    public TvShow() {
        super();
    }

    protected TvShow(Parcel in) {
        super(in);
        overview = in.readString();
        date = in.readString();
        genres = in.readArrayList(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(overview);
        dest.writeString(date);
        dest.writeList(genres);
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

}