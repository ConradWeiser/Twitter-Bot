package core;

import java.util.List;
import twitter4j.Status;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filter {
	private static final String FILENAME = "whitelist.txt";
	
	List<String> output = null;
	
	public List<String> createFile() {
		
		
		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				output.add(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return output;
	}
	
	@SuppressWarnings("null")
	public List<Status> filterContent(List<Status> status){
		List<Status> filtered = null;
		for (Status element : status){
			for (int i = 0; i < output.size(); i++) {
				if (output.get(i).contains(element.getText())){
					filtered.add((Status) element);
				}
			}
		}
		
		return filtered;
	}
}
