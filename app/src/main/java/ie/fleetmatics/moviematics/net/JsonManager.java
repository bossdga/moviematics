package ie.fleetmatics.moviematics.net;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ie.fleetmatics.moviematics.constants.Constants;
import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.model.Person;
import ie.fleetmatics.moviematics.model.TvShow;

/**
 * This class is responsible parsing JSON Objects and return the right object
 * for a later process
 */
class JsonManager {

    /**
     * Parses the response and builds a collection of Movie objects
     * @param response
     * @return
     */
    public List<Movie> getMovies(JSONObject response) {
        List<Movie> movies = new ArrayList<>();
        try {
            JSONArray moviesArray = response.getJSONArray("results");
            for (int i = 0; i < moviesArray.length(); i++) {
                Movie movie = new Movie();
                JSONObject movieObject = moviesArray.getJSONObject(i);
                movie.setId(movieObject.optInt("id"));
                movie.setName(movieObject.optString("title"));
                movie.setImageUrl(Constants.IMAGE_BASE_URL + movieObject.optString("poster_path"));
                movie.setPopularity(movieObject.optDouble("popularity"));
                movie.setDate(movieObject.optString("release_date"));
                movie.setOverview(movieObject.optString("overview"));

                movies.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movies;
    }

    /**
     * Parses the response and builds a collection of TvShow objects
     * @param response
     * @return
     */
    public List<TvShow> getTvShows(JSONObject response) {
        List<TvShow> tvShows = new ArrayList<>();
        try {
            JSONArray tvShowsArray = response.getJSONArray("results");
            for (int i = 0; i < tvShowsArray.length(); i++) {
                TvShow tvShow = new TvShow();
                JSONObject tvShowObject = tvShowsArray.getJSONObject(i);
                tvShow.setId(tvShowObject.optInt("id"));
                tvShow.setName(tvShowObject.optString("name"));
                tvShow.setImageUrl(Constants.IMAGE_BASE_URL + tvShowObject.optString("poster_path"));
                tvShow.setPopularity(tvShowObject.optDouble("popularity"));
                tvShow.setDate(tvShowObject.optString("first_air_date"));
                tvShow.setOverview(tvShowObject.optString("overview"));

                tvShows.add(tvShow);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tvShows;
    }

    /**
     * Parses the response and builds a collection of Person objects
     * @param response
     * @return
     */
    public List<Person> getPeople(JSONObject response) {
        List<Person> people = new ArrayList<>();
        try {
            JSONArray peopleArray = response.getJSONArray("results");
            for (int i = 0; i < peopleArray.length(); i++) {
                Person person = new Person();
                JSONObject personObject = peopleArray.getJSONObject(i);
                person.setId(personObject.optInt("id"));
                person.setName(personObject.optString("name"));
                person.setImageUrl(Constants.IMAGE_BASE_URL + personObject.optString("profile_path"));
                person.setPopularity(personObject.optDouble("popularity"));

                people.add(person);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return people;
    }

    /**
     * Parses the response and builds a Movie object
     * @param response
     * @return
     */
    public Movie getMovieDetails(JSONObject response) {
        Movie movie = new Movie();
        movie.setId(response.optInt("id"));
        movie.setName(response.optString("title"));
        movie.setImageUrl(Constants.IMAGE_BASE_URL + response.optString("poster_path"));
        movie.setPopularity(response.optDouble("popularity"));
        movie.setDate(response.optString("release_date"));
        movie.setOverview(response.optString("overview"));
        List<String> genres = new ArrayList<>();
        try {
            JSONArray genresArray = response.getJSONArray("genres");
            for (int i = 0; i < genresArray.length(); i++) {
                JSONObject genreObject = genresArray.getJSONObject(i);
                genres.add(genreObject.optString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        movie.setGenres(genres);

        return movie;
    }

    /**
     * Parses the response and builds a TvShow object
     * @param response
     * @return
     */
    public TvShow getTvShowDetails(JSONObject response) {
        TvShow tvShow = new TvShow();
        tvShow.setId(response.optInt("id"));
        tvShow.setName(response.optString("name"));
        tvShow.setImageUrl(Constants.IMAGE_BASE_URL + response.optString("poster_path"));
        tvShow.setPopularity(response.optDouble("popularity"));
        tvShow.setDate(response.optString("first_air_date"));
        tvShow.setOverview(response.optString("overview"));
        List<String> genres = new ArrayList<>();
        try {
            JSONArray genresArray = response.getJSONArray("genres");
            for (int i = 0; i < genresArray.length(); i++) {
                JSONObject genreObject = genresArray.getJSONObject(i);
                genres.add(genreObject.optString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        tvShow.setGenres(genres);

        return tvShow;
    }

    /**
     * Parses the response and builds a Person object
     * @param response
     * @return
     */
    public Person getPersonDetails(JSONObject response) {
        Person person = new Person();
        person.setId(response.optInt("id"));
        person.setName(response.optString("name"));
        person.setImageUrl(Constants.IMAGE_BASE_URL + response.optString("profile_path"));
        person.setPopularity(response.optDouble("popularity"));

        return person;
    }

}