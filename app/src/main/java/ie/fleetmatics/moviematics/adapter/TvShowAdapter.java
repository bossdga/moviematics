package ie.fleetmatics.moviematics.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ie.fleetmatics.moviematics.R;
import ie.fleetmatics.moviematics.activity.MovieDetailActivity;
import ie.fleetmatics.moviematics.activity.TvShowDetailActivity;
import ie.fleetmatics.moviematics.model.TvShow;
import ie.fleetmatics.moviematics.util.ImageUtils;
import ie.fleetmatics.moviematics.util.NumberUtils;

/**
 * Provide views to RecyclerView with data from tvShows.
 */
public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    private List<TvShow> tvShows = new ArrayList<>();
    private Context context;

    /**
     * Provide a reference to the type of views used (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name;
        private final TextView popularity;
        private final TextView date;


        public ViewHolder(View v, final List<TvShow> tvShows) {
            super(v);

            // Listener to set a click action for every row
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TvShow tvShow = tvShows.get(getAdapterPosition());

                    Bundle tvShowBundle = new Bundle();
                    tvShowBundle.putParcelable("tvShow", tvShow);

                    Intent intent = new Intent(v.getContext(), TvShowDetailActivity.class);
                    intent.putExtra("tvShowBundle", tvShowBundle);
                    v.getContext().startActivity(intent);
                }
            });

            image = (ImageView) v.findViewById(R.id.image);
            name = (TextView) v.findViewById(R.id.name);
            popularity = (TextView) v.findViewById(R.id.popularity);
            date = (TextView) v.findViewById(R.id.date);
        }

        public ImageView getImage() {
            return image;
        }

        public TextView getName() {
            return name;
        }

        public TextView getPopularity() {
            return popularity;
        }

        public TextView getDate() {
            return date;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param tvShows List<TvShow> containing the data to populate views to be used by RecyclerView.
     */
    public TvShowAdapter(List<TvShow> tvShows, Context context) {
        this.tvShows = tvShows;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TvShowAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_tvshow, viewGroup, false);

        return new TvShowAdapter.ViewHolder(v, tvShows);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TvShowAdapter.ViewHolder viewHolder, final int position) {
        final TvShow tvShow = tvShows.get(position);

        ImageUtils.setImage(context, viewHolder.getImage(), tvShow.getImageUrl());
        viewHolder.getName().setText(tvShow.getName());
        viewHolder.getPopularity().setText(NumberUtils.getFormattedDouble(tvShow.getPopularity()));
        viewHolder.getDate().setText(tvShow.getDate());
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tvShows.size();
    }

}