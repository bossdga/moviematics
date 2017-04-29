package ie.fleetmatics.moviematics.net.api;

import java.util.List;

import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.model.Person;
import ie.fleetmatics.moviematics.model.TvShow;
import rx.Observable;

/**
 * This class deals with API and implements what actions can be done
 */
public class ApiContext {

    private static class ApiContextHolder {
        public static final ApiContext holder = new ApiContext();
    }

    public static ApiContext getApiContextHolder() {
        return ApiContextHolder.holder;
    }

    private Api api;

    /**
     * Sets the api
     *
     * @param api
     */
    public void setApi(Api api) {
        this.api = api;
    }

    /**
     * Gets a list of movies
     * @param sortBy
     * @param pageNumber
     * @return
     */
    public Observable<List<Movie>> getMovies(String sortBy, int pageNumber) {
        return this.api.getMovies(sortBy, pageNumber);
    }

    /**
     * Gets a list of tv shows
     * @param sortBy
     * @param pageNumber
     * @return
     */
    public Observable<List<TvShow>> getTvShows(String sortBy, int pageNumber) {
        return this.api.getTvShows(sortBy, pageNumber);
    }

    /**
     * Gets a list of people
     * @param sortBy
     * @param pageNumber
     * @return
     */
    public Observable<List<Person>> getPeople(String sortBy, int pageNumber) {
        return this.api.getPeople(sortBy, pageNumber);
    }

    /**
     * Gets the movie details
     * @param id
     * @return
     */
    public Observable<Movie> getMovieDetails(int id) {
        return this.api.getMovieDetails(id);
    }

    /**
     * Gets the tv show details
     * @param id
     * @return
     */
    public Observable<TvShow> getTvShowDetails(int id) {
        return this.api.getTvShowDetails(id);
    }

    /**
     * Gets the person details
     * @param id
     * @return
     */
    public Observable<Person> getPersonDetails(int id) {
        return this.api.getPersonDetails(id);
    }

}