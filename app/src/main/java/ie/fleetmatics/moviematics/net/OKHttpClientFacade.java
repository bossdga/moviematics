package ie.fleetmatics.moviematics.net;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import ie.fleetmatics.moviematics.constants.Constants;
import ie.fleetmatics.moviematics.model.Movie;
import ie.fleetmatics.moviematics.model.Person;
import ie.fleetmatics.moviematics.model.TvShow;
import ie.fleetmatics.moviematics.util.HTTPUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * This is a facade to provide a simplified interface to a larger body of code
 *
 */
public class OKHttpClientFacade implements BaseClientFacade {

    private static final OkHttpClient client = new OkHttpClient();

    /**
     * Creates and returns a request
     * @param url
     * @return
     */
    private Request getRequest(String url) {
        Request.Builder builder = new Request.Builder().url(HTTPUtils.getAbsoluteUrl(url));
        builder.addHeader("Accept", "application/json, */*");
        Request request = builder.build();

        return request;
    }

    /**
     * Creates and Observable object from the collection
     * @return
     */
    @Override
    public Observable<List<Movie>> getMoviesRequest(String sortBy, int pageNumber) {
        final Request request = getRequest("/3/discover/movie?api_key=" + Constants.API_KEY + "&sort_by=" + sortBy + "&page=" + pageNumber);
        return Observable.create(new Observable.OnSubscribe<List<Movie>>() {
            @Override
            public void call(Subscriber<? super List<Movie>> subscriber) {
                try {
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(jsonData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonManager jsonManager = new JsonManager();

                    subscriber.onNext(jsonManager.getMovies(jsonObject));
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    /**
     * Creates and Observable object from the collection
     * @return
     */
    @Override
    public Observable<List<TvShow>> getTvShowsRequest(String sortBy, int pageNumber) {
        final Request request = getRequest("/3/discover/tv?api_key=" + Constants.API_KEY + "&sort_by=" + sortBy + "&page=" + pageNumber);
        return Observable.create(new Observable.OnSubscribe<List<TvShow>>() {
            @Override
            public void call(Subscriber<? super List<TvShow>> subscriber) {
                try {
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(jsonData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonManager jsonManager = new JsonManager();

                    subscriber.onNext(jsonManager.getTvShows(jsonObject));
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    /**
     * Creates and Observable object from the collection
     * @return
     */
    @Override
    public Observable<List<Person>> getPeopleRequest(String sortBy, int pageNumber) {
        final Request request = getRequest("/3/person/popular?api_key=" + Constants.API_KEY + "&page=" + pageNumber);
        return Observable.create(new Observable.OnSubscribe<List<Person>>() {
            @Override
            public void call(Subscriber<? super List<Person>> subscriber) {
                try {
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(jsonData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonManager jsonManager = new JsonManager();

                    subscriber.onNext(jsonManager.getPeople(jsonObject));
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    /**
     * Creates and Observable object
     * @return
     */
    @Override
    public Observable<Movie> getMovieDetailsRequest(int id) {
        final Request request = getRequest("/3/movie/" + id + "?api_key=" + Constants.API_KEY);
        return Observable.create(new Observable.OnSubscribe<Movie>() {
            @Override
            public void call(Subscriber<? super Movie> subscriber) {
                try {
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(jsonData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonManager jsonManager = new JsonManager();

                    subscriber.onNext(jsonManager.getMovieDetails(jsonObject));
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    /**
     * Creates and Observable object
     * @return
     */
    @Override
    public Observable<TvShow> getTvShowDetailsRequest(int id) {
        final Request request = getRequest("/3/tv/" + id + "?api_key=" + Constants.API_KEY);
        return Observable.create(new Observable.OnSubscribe<TvShow>() {
            @Override
            public void call(Subscriber<? super TvShow> subscriber) {
                try {
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(jsonData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonManager jsonManager = new JsonManager();

                    subscriber.onNext(jsonManager.getTvShowDetails(jsonObject));
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    /**
     * Creates and Observable object
     * @return
     */
    @Override
    public Observable<Person> getPersonDetailsRequest(int id) {
        final Request request = getRequest("/3/person/" + id + "?api_key=" + Constants.API_KEY);
        return Observable.create(new Observable.OnSubscribe<Person>() {
            @Override
            public void call(Subscriber<? super Person> subscriber) {
                try {
                    Response response = client.newCall(request).execute();
                    String jsonData = response.body().string();

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(jsonData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonManager jsonManager = new JsonManager();

                    subscriber.onNext(jsonManager.getPersonDetails(jsonObject));
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}