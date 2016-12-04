package core;

import java.util.List;

import twitter4j.Status;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import resources.LocationElement;

public class filter {
	private static final String FILENAME = "whiteList.txt";
	private static final String[] weatherTypes = null;
	
	List<String> whitelistConditions = null;
	List<LocationElement> filteredLocations = null;
		
	public filter(){
		
		//When the object is created, fill in the Weather Types with all of the possible data. We can move this
		//elsewhere later.
		weatherTypes[0] = "Rain";
		weatherTypes[1] = "Snow";
		weatherTypes[2] = "Sleet";
		weatherTypes[3] = "Hail";
		weatherTypes[4] = "Cold";
		weatherTypes[5] = "Humid";
		weatherTypes[6] = "Gloomy";		
		
	}
	

	
	public List<LocationElement> getLocationElements(){
		return filteredLocations;
	}
	
	private void weightTweet(Status tweet){
		
		//Create a new array to store each word of the tweet in
		String[] parsedString = tweet.getText().split(" ");
		
		//Create a new object which we'll save the location and weather as.
		LocationElement newElement = new LocationElement();
		
		//For each word in the tweet, compare it to the list of weather types we have. If it contains it, add it to the Element
		for(String word : parsedString){
			for(String weatherType : weatherTypes){
				if(word.contains(weatherType)){
					newElement.setWeatherStatus(weatherType);
				}
			}
		}

		//Add the longitude and latitude to the element
		newElement.setLongitude(tweet.getGeoLocation().getLongitude());
		newElement.setLatitude(tweet.getGeoLocation().getLatitude());
		
		//TODO: Run the method to concatinate all of the elements which have gotten to set the active one
		
	}
	
	public void createFile() {
		
		
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				whitelistConditions.add(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void filterContent(List<Status> status){
		createFile();
		for (Status element : status){
			for (int i = 0; i < whitelistConditions.size(); i++) {
				if (whitelistConditions.get(i).contains(element.getText())){
					//If it contains text we're looking for, send it to the weighting method
					weightTweet(element);
				}
			}
		}
	}
}
