package ie.fleetmatics.moviematics;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.net.FacadeFactory;
import ie.fleetmatics.moviematics.net.FacadeType;
import ie.fleetmatics.moviematics.net.api.ApiContext;
import ie.fleetmatics.moviematics.net.api.ApiImpl;
import rx.Observable;
import rx.observers.TestSubscriber;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ObservablesTest {

    private ApiContext apiContext;

    @Before
    public void setUp() {
        apiContext = ApiContext.getApiContextHolder();
        apiContext.setApi(new ApiImpl(FacadeFactory.createFacade(FacadeType.OK_HTTP)));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testWithBlocking() {
        Movie movie = apiContext.getMovieDetails(321612).toBlocking().first();
        assertNotNull(movie);
        assertEquals(movie.getName(), "Beauty and the Beast");
    }

    @Test
    public void testWithSubscriber() {
        Observable<Movie> obs = apiContext.getMovieDetails(321612);
        TestSubscriber<Movie> testSubscriber = new TestSubscriber<>();
        obs.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Movie> movies = testSubscriber.getOnNextEvents();
        assertEquals(movies.size(), 1);
        Assert.assertEquals(movies.get(0).getName(), "Beauty and the Beast");
    }

    @Test
    public void testComposition() {
        Observable<List<Movie>> obs = apiContext.getMovies("popularity.desc", 1);
        TestSubscriber<List<Movie>> testSubscriber = new TestSubscriber<>();
        obs.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<List<Movie>> lists = testSubscriber.getOnNextEvents();
        Assert.assertEquals("Only one list back", lists.size(), 1);
        List<Movie> movies = lists.get(0);
        Assert.assertEquals("Twenty elements list back", movies.size(), 20);
        Assert.assertEquals("The name is different", movies.get(0).getName(), "Beauty and the Beast");
    }

}
