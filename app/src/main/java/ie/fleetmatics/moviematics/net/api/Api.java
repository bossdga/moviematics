package ie.fleetmatics.moviematics.net.api;

import java.util.List;

import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.model.Person;
import ie.fleetmatics.moviematics.model.TvShow;
import rx.Observable;

/**
 * Interface that defines an Abstract Api with the actions it can perform
 */
public interface Api {

    /**
     * Gets a list of movies
     * @param sortBy
     * @param pageNumber
     * @return
     */
    Observable<List<Movie>> getMovies(String sortBy, int pageNumber);

    /**
     * Gets a list of tv shows
     * @param sortBy
     * @param pageNumber
     * @return
     */
    Observable<List<TvShow>> getTvShows(String sortBy, int pageNumber);

    /**
     * Gets a list of people
     * @param sortBy
     * @param pageNumber
     * @return
     */
    Observable<List<Person>> getPeople(String sortBy, int pageNumber);

    /**
     * Gets the movie details
     * @param id
     * @return
     */
    Observable<Movie> getMovieDetails(int id);

    /**
     * Gets the tv show details
     * @param id
     * @return
     */
    Observable<TvShow> getTvShowDetails(int id);

    /**
     * Gets the person details
     * @param id
     * @return
     */
    Observable<Person> getPersonDetails(int id);

}