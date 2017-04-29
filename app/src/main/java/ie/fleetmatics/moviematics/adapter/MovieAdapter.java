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
import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.util.ImageUtils;
import ie.fleetmatics.moviematics.util.NumberUtils;

/**
 * Provide views to RecyclerView with data from movies.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> movies = new ArrayList<>();
    private Context context;

    /**
     * Provide a reference to the type of views used (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name;
        private final TextView popularity;
        private final TextView date;


        public ViewHolder(View v, final List<Movie> movies) {
            super(v);

            // Listener to set a click action for every row
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movie movie = movies.get(getAdapterPosition());

                    Bundle movieBundle = new Bundle();
                    movieBundle.putParcelable("movie", movie);

                    Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);
                    intent.putExtra("movieBundle", movieBundle);
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
     * @param movies List<Movie> containing the data to populate views to be used by RecyclerView.
     */
    public MovieAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_movie, viewGroup, false);

        return new ViewHolder(v, movies);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final Movie movie = movies.get(position);

        ImageUtils.setImage(context, viewHolder.getImage(), movie.getImageUrl());
        viewHolder.getName().setText(movie.getName());
        viewHolder.getPopularity().setText(NumberUtils.getFormattedDouble(movie.getPopularity()));
        viewHolder.getDate().setText(movie.getDate());
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movies.size();
    }

}