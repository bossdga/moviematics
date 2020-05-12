# MOVIEMATICS

This app displays lists of the most popular movies, tv shows and people to help users decide what to watch next. When the user selects one movie, tv show or people, then it shows the detail page.

The app basically has a main activity that holds three fragments to build three scrollable lists, one for popular movies, one for popular TV shows and one for popular people. Every fragment is responsible of calling the API endpoint, build the list and show the content.

We are using three fragments for that, one for popular movies, one for popular TV shows and one for popular people. Each fragment will receive a parameter, so we can reuse them.

Then we have three more activities that hold one fragment each to build the details page for every popular movie, TV show or person.

We also have a base activity and a base fragment that implement common functionality for easy reuse among all the activities and fragments.

The API model follows a Strategy pattern to be able to switch between different APIs in real time. This means that if in the future you want to switch the http client, it will be easier to do so as it is decoupled (the app is ready for that). Also this way you can have different API implementations and maybe separate them in movies api, tv shows api, people api, etc.

The model consists of a BaseContent class that implements common functionality. Then we have Movie, TvShow and People classes extending BaseContent.

Here we are using 3 RecyclerViews inside a NestedScrollView to make the whole screen scrollable. The only caveat is that you will have to call the RecyclerView NestedScrollingEnabled(false) method. Another possibility that came into my mind later on, would be to benefit from the getItemViewType method from the RecycerView.Adapter class that returns the view type of the item at a position. This way you can just inflate different views and you wouldn’t have to deal with nested scrolls. This is just an idea that couldn’t explore more to test the viability.

Activities:  
BaseActivity: Activity that implements common functionality.  
MainActivity: Activity that holds several fragments.  
MovieDetailActivity: Activity that holds a fragment to show the movie details.  
TvShowDetailActivity: Activity that holds a fragment to show the tv show details.  
PeopleDetailActivity: Activity that holds a fragment to show the person details.  

Adapters:  
MovieAdapter: Adapter responsible of building the list movies.  
TvShowAdapter: Adapter responsible of building the list of tv shows.  
PeopleShowAdapter: Adapter responsible of building the list of people.  

Fragments:  
BaseFragment: Fragment that implements common functionality.  
MovieFragment: Fragment responsible of calling the API, fetch and showing the list of movies.  
TvShowFragment: Fragment responsible of calling the API, fetch and showing the list of tv shows.  
PeopleFragment: Fragment responsible of calling the API, fetch and showing the list of people.  
MovieDetailFragment: Fragment responsible of calling the API, fetch and showing the movie details.  
TvShowDetailFragment: Fragment responsible of calling the API, fetch and showing the tv show details.  
PeopleDetailFragment: Fragment responsible of calling the API, fetch and showing the person details.  

Model:  
ContentType: Enum declaring all the content types.  
BaseContent: Class that represents content.  
Movie: Class that represents a Movie.  
TvShow: Class that represents a TvShow.  
Person: Class that represents a Person.  

Net:  
Api: Interface that defines an Abstract Api with the actions it can perform.  
ApiContext: This class deals with API and implements what actions can be done.  
ApiImpl: Class that implements the Api Interface and represents the actions that can be performed.  
BaseClientFacade: Interface that represents a Facade to make HTTP Requests.  
OKHttpClientFacade: Facade to provide a simplified interface to a larger body of code. It deals with the HTTP requests and responses using OkHttp.  
FacadeType: Enum declaring all the facade types.  
FacadeFactory: Factory to create different facades.  
JsonManager: This class is responsible parsing JSON Objects and return the right object for a later process.  

Utils:  
HTTPUtils: HTTP Utility class.  
MessageUtils: Utility class to simplify the use of messages.  
ImageUtils: Utility class to simplify the use of images.  
NumberUtils: Utility class to format numbers.  
ProgressDialogHandler: Interface that defines the states for the ProgressDialog.  

Constants:
Constants: Main constants for the app.
