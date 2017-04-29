package ie.fleetmatics.moviematics.activity;

import android.os.Bundle;

import ie.fleetmatics.moviematics.R;

public class TvShowDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        setUpActionBar(R.string.title_activity_tvshow_detail, true);
    }

}
