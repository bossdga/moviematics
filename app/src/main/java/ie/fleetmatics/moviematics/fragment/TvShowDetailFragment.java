package ie.fleetmatics.moviematics.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ie.fleetmatics.moviematics.R;
import ie.fleetmatics.moviematics.model.ContentType;
import ie.fleetmatics.moviematics.model.TvShow;
import ie.fleetmatics.moviematics.util.ImageUtils;
import ie.fleetmatics.moviematics.util.MessageUtils;
import ie.fleetmatics.moviematics.util.NumberUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowDetailFragment extends BaseFragment {

    private ImageView image;
    private TextView name;
    private TextView popularity;
    private TextView date;
    private TextView overview;
    private TextView genre;

    private CompositeSubscription mSubscription = new CompositeSubscription();

    private TvShow tvShow;

    public TvShowDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tvshow_detail, container, false);

        tvShow = getBundle(ContentType.TVSHOW).getParcelable("tvShow");

        image = (ImageView) rootView.findViewById(R.id.image);
        name = (TextView) rootView.findViewById(R.id.name);
        popularity = (TextView) rootView.findViewById(R.id.popularity);
        date = (TextView) rootView.findViewById(R.id.date);
        overview = (TextView) rootView.findViewById(R.id.overview);
        genre = (TextView) rootView.findViewById(R.id.genre);

        showProgressDialog();

        addObserver(mSubscription);

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSubscription.unsubscribe();
    }

    /**
     * Method that sets an Observer object to listen on the list of tv shows
     * @param subscription
     */
    private void addObserver(CompositeSubscription subscription) {
        subscription.add(apiContext.getTvShowDetails(tvShow.getId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TvShow>() {
                    @Override
                    public void onCompleted() {
                        //MessageUtils.showMessage(getActivity(), R.string.call_successful, Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideProgressDialog();
                        MessageUtils.showMessage(getActivity(), R.string.call_error, Toast.LENGTH_LONG);
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(TvShow tvShow) {
                        String genres = "";
                        ImageUtils.setImage(getActivity(), image, tvShow.getImageUrl());
                        name.setText(tvShow.getName());
                        popularity.setText(NumberUtils.getFormattedDouble(tvShow.getPopularity()));
                        date.setText(tvShow.getDate());
                        overview.setText(tvShow.getOverview());
                        for (String genre: tvShow.getGenres()) {
                            genres += genre + " | ";
                        }
                        genre.setText(genres);
                        hideProgressDialog();
                    }
                }));
    }

}
