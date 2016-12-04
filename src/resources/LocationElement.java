package resources;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class LocationElement {
	
	/**
	 * Set the values which are of importance to a certain location
	 */
	
	private double longitude;
	private double latitude;
	
	private String weatherStatus;
	@SuppressWarnings("unused")
	private String[] weightedWords;
	
	
	public void setWeightedWords(String[] weightedWords){
		this.weightedWords = weightedWords;
	}
	
	public void setLongitude(double longitude){
		this.longitude = longitude;
	}
	
	public void setLatitude(double latitude){
		this.latitude = latitude;
	}
	
	public void setWeatherStatus(String status){
		this.weatherStatus = status;
	}
	
	public double getLongitude(){
		return this.longitude;
	}
	
	public double getLatitude(){
		return this.latitude;
	}
	
	public String getWeatherStatus(){
		return this.weatherStatus;
	}
	
	//A method which should be run after you get all of the weighted words.
	//This method takes all of the words and decides which one is the most relevent. (Used most often)
	@SuppressWarnings("resource")
	public void findWeightedWord(){
		int freq = 0;
		Scanner keyboard = new Scanner(System.in);
	    String[] myPhrase = keyboard.nextLine().split(" ");
	    HashMap<String, Integer> frequency = new HashMap<String, Integer>();
	    for (String s : myPhrase){
	        if (frequency.containsKey(s)) frequency.replace(s, frequency.get(s) + 1);
	        else frequency.put(s, 1);
	    }
	    
	    for (Entry<String, Integer> entry : frequency.entrySet())
	    {
	        if (entry.getValue() > freq){
	        	freq = entry.getValue();
	        	weatherStatus = entry.getKey();
	        }
	    }
	}


}
