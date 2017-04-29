package ie.fleetmatics.moviematics.net;

import java.util.List;

import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.model.Person;
import ie.fleetmatics.moviematics.model.TvShow;
import rx.Observable;

/**
 * This Interface provide HTTP functionality to decouple from the client used
 */
public interface BaseClientFacade {

    Observable<List<Movie>> getMoviesRequest(String sortBy, int pageNumber);

    Observable<List<TvShow>> getTvShowsRequest(String sortBy, int pageNumber);

    Observable<List<Person>> getPeopleRequest(String sortBy, int pageNumber);

    Observable<Movie> getMovieDetailsRequest(int id);

    Observable<TvShow> getTvShowDetailsRequest(int id);

    Observable<Person> getPersonDetailsRequest(int id);

}
