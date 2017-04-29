package ie.fleetmatics.moviematics.net;

public class FacadeFactory {

	/**
     * Method than returns the right facade
	 *
	 * @param facadeType
	 * @return
	 */
	public static BaseClientFacade createFacade(FacadeType facadeType) {
		switch (facadeType) {
			case OK_HTTP:
				return new OKHttpClientFacade();
			case URL_CONNECTION:
				// return a client using HttpURLConnection
			default:
				return new OKHttpClientFacade();
		}
	}

}