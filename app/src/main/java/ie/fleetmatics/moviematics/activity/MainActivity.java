package ie.fleetmatics.moviematics.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;

import ie.fleetmatics.moviematics.R;
import ie.fleetmatics.moviematics.fragment.MovieFragment;
import ie.fleetmatics.moviematics.fragment.PeopleFragment;
import ie.fleetmatics.moviematics.fragment.TvShowFragment;

/**
 * Main Activity that holds several fragments
 */
public class MainActivity extends BaseActivity implements OnFragmentFinishedListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.SwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(onRefreshListener);

        setUpActionBar(R.string.title_activity_main, false);

        loadFragments();
    }

    /**
     * Listener for swipe to refresh functionality
     */
    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            loadFragments();
        }
    };

    @Override
    public void onFragmentFinished() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    /**
     * Method that load the fragments
     */
    private void loadFragments() {
        transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.movies_container, MovieFragment.newInstance("popularity.desc", 1));
        transaction.add(R.id.tvshows_container, TvShowFragment.newInstance("popularity.desc", 1));
        transaction.add(R.id.people_container, PeopleFragment.newInstance("popularity.desc", 1));

        transaction.commit();
    }

}