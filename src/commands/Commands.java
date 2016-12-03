package commands;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public class Commands {
	
	private Twitter twitter = null;
	
	public Commands(){
		//Get the twitter instance
		twitter = core.Main.getTwitter();
	}
	
	public void searchQuery(String queryInput){
		try{
			Query query = new Query(queryInput);
			QueryResult result;
			
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
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
