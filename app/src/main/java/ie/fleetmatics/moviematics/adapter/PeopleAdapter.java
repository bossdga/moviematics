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
import ie.fleetmatics.moviematics.activity.PeopleDetailActivity;
import ie.fleetmatics.moviematics.model.Person;
import ie.fleetmatics.moviematics.util.ImageUtils;
import ie.fleetmatics.moviematics.util.NumberUtils;

/**
 * Provide views to RecyclerView with data from people.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<Person> people = new ArrayList<>();
    private Context context;

    /**
     * Provide a reference to the type of views used (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name;
        private final TextView popularity;

        public ViewHolder(View v, final List<Person> people) {
            super(v);

            // Listener to set a click action for every row
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Person person = people.get(getAdapterPosition());

                    Bundle peopleBundle = new Bundle();
                    peopleBundle.putParcelable("people", person);

                    Intent intent = new Intent(v.getContext(), PeopleDetailActivity.class);
                    intent.putExtra("peopleBundle", peopleBundle);
                    v.getContext().startActivity(intent);
                }
            });

            image = (ImageView) v.findViewById(R.id.image);
            name = (TextView) v.findViewById(R.id.name);
            popularity = (TextView) v.findViewById(R.id.popularity);
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
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param people List<Person> containing the data to populate views to be used by RecyclerView.
     */
    public PeopleAdapter(List<Person> people, Context context) {
        this.people = people;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_people, viewGroup, false);

        return new PeopleAdapter.ViewHolder(v, people);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PeopleAdapter.ViewHolder viewHolder, final int position) {
        final Person person = people.get(position);

        ImageUtils.setImage(context, viewHolder.getImage(), person.getImageUrl());
        viewHolder.getName().setText(person.getName());
        viewHolder.getPopularity().setText(NumberUtils.getFormattedDouble(person.getPopularity()));
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return people.size();
    }

}