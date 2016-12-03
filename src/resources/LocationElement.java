package resources;

public class LocationElement {
	
	/**
	 * Set the values which are of importance to a certain location
	 */
	
	private double longitude;
	private double latitude;
	
	private String weatherStatus;
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
	

}
