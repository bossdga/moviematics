package ie.fleetmatics.moviematics.net.api;

import java.util.List;

import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.model.Person;
import ie.fleetmatics.moviematics.model.TvShow;
import ie.fleetmatics.moviematics.net.BaseClientFacade;
import rx.Observable;

/**
 * Class that implements the Api Interface and represents the actions that
 * can be performed
 */
public class ApiImpl implements Api {

    private BaseClientFacade client;

    public ApiImpl(BaseClientFacade client) {
        this.client = client;
    }

    /**
     * Gets a list of movies
     * @param sortBy
     * @param pageNumber
     * @return
     */
    @Override
    public Observable<List<Movie>> getMovies(String sortBy, int pageNumber) {
        return this.client.getMoviesRequest(sortBy, pageNumber);
    }

    /**
     * Gets a list of tv shows
     * @param sortBy
     * @param pageNumber
     * @return
     */
    @Override
    public Observable<List<TvShow>> getTvShows(String sortBy, int pageNumber) {
        return this.client.getTvShowsRequest(sortBy, pageNumber);
    }

    /**
     * Gets a list of people
     * @param sortBy
     * @param pageNumber
     * @return
     */
    @Override
    public Observable<List<Person>> getPeople(String sortBy, int pageNumber) {
        return this.client.getPeopleRequest(sortBy, pageNumber);
    }

    /**
     * Gets the movie details
     * @param id
     * @return
     */
    public Observable<Movie> getMovieDetails(int id) {
        return this.client.getMovieDetailsRequest(id);
    }

    /**
     * Gets the tv show details
     * @param id
     * @return
     */
    public Observable<TvShow> getTvShowDetails(int id) {
        return this.client.getTvShowDetailsRequest(id);
    }

    /**
     * Gets the person details
     * @param id
     * @return
     */
    public Observable<Person> getPersonDetails(int id) {
        return this.client.getPersonDetailsRequest(id);
    }

}