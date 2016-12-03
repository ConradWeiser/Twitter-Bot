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
	
	public List<Status> getResults(){
		return filteredStatus;
	}
	
	public void weightTweet(Status tweet){
		

		
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
				}
			}
		}
		filteredStatus = filtered;
	}
}
