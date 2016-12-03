package core;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

import java.util.List;

import commands.Commands;

public class Main {
	
	//Store the twitter object to use within the class
	private static Twitter twitter = null;
	private static List<Status> list = null;
	
	private static void initialize(){
		//Get the settings to access the server.
		Config configbuilder = new Config();
		Configuration config = configbuilder.getSettings().build();
		
		TwitterFactory tf = new TwitterFactory(config);
		twitter = tf.getInstance();
	}
	
	public static Twitter getTwitter() {
		return twitter;
	}
	
	public static void main(String[] args) {

		initialize();
		
		//Create the commands instance
		Commands command = new Commands();
		filter filter = new filter();
		
		//filter.createFile();
		
		
		
		
	}



}
