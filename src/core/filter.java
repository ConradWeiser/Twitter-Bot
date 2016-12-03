package core;

import java.util.List;

import twitter4j.Status;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filter {
	private static final String FILENAME = "whiteList.txt";
	
	List<String> whitelistConditions = null;
	List<Status> filteredStatus = null;
	// 0 - Rainy
	// 1 - Freezing
	// 2 - Sunny
	// 3 - Humid
	// 4 - Stormy
	// 5 - Snowing
	// 6 - Gloomy
	// 7 - Cloudy
	int[] values = {0,0,0,0,0,0,0,0};
	
	public List<Status> getResults(){
		return filteredStatus;
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
	
	@SuppressWarnings("null")
	public void filterContent(List<Status> status){
		createFile();
		List<Status> filtered = null;
		for (Status element : status){
			for (int i = 0; i < whitelistConditions.size(); i++) {
				if (whitelistConditions.get(i).contains(element.getText())){
					filtered.add((Status) element);
					switch (whitelistConditions.get(i)){
						case "rain":
							values[0]++;
							break;
						case "freezing":
							values[1]++;
							break;
						case "sunny":
							values[2]++;
							break;
						case "humid":
							values[3]++;
							break;
						case "stormy":
							values[4]++;
							break;
						case "snow":
							values[5]++;
							break;
						case "gloomy":
							values[6]++;
							break;
						case "cloudy":
							values[7]++;
							break;
					}
				}
			}
		}
		filteredStatus = filtered;
		
		
		
		
	}
}
