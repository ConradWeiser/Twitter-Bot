package commands;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.HashMap;
import java.util.List;

public class Commands {
	
	private Twitter twitter = null;
	private HashMap<Place, String> locationList = null;
	
	public Commands(){
		//Get the twitter instance
		twitter = core.Main.getTwitter();
	}
	
	private void getLocation(Status tweet){

		double longitude = tweet.getGeoLocation().getLongitude();
		double latitude = tweet.getGeoLocation().getLatitude();
		
		GeoQuery query = new GeoQuery(new GeoLocation(longitude, latitude));
		ResponseList<Place> places;
		try {
			places = twitter.reverseGeoCode(query);
			if (places.size() == 0){
				System.out.println("No location associated with the specified lat/lang");
			}
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}
	
	public void searchQuery(String queryInput){
		try{
			Query query = new Query(queryInput);
			QueryResult result;
			
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
					//TODO: Filter these outputs instead of printing to console
					System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
				}
			} while ((query = result.nextQuery()) != null);
			System.exit(0);			
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
			System.exit(-1);
		}
	}


}
