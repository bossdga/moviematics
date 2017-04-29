package ie.fleetmatics.moviematics.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Class that represents a Person
 */
public class Person extends BaseContent {

    private List<BaseContent> workList;

    public Person() {
        super();
    }

    protected Person(Parcel in) {
        super(in);
        workList = in.readArrayList(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeList(workList);
    }

    public List<BaseContent> getWorkList() {
        return workList;
    }

    public void setWorkList(List<BaseContent> workList) {
        this.workList = workList;
    }

}