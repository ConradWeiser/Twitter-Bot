package resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MapCreator {
	
	private static List<LocationElement> elementList;
	private File file = new File("C:/mapData.csv");
		
	public MapCreator(List<LocationElement> elementList){
		
		MapCreator.elementList = elementList;
		
		//Check to see if the file we're writing to exists. If not, create it
		if(!file.exists()) {
			try {
				file.createNewFile();
				initializeFile();
				writeFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//Method which makes the header for the file.
	private void initializeFile(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("id,");
		sb.append("map_id,");
		sb.append("address,");
		sb.append("description,");
		sb.append("pic,");
		sb.append("link,");
		sb.append("icon,");
		sb.append("lat,");
		sb.append("lng,");
		sb.append("anim,");
		sb.append("title,");
		sb.append("infoopen,");
		sb.append("category");
		sb.append("\n");
		
		writeLine(sb.toString());
		
	}

	//Method which takes the list of location elements and maps them to a file
	private void writeFile(){
		
		//For each element, write data
		int counter = 0;
		for(LocationElement currentElement : elementList){
			
			//Create a StringBuilder to put together the proper line
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(counter) + ",");
			sb.append("1,");
			sb.append(",");
			sb.append(",");
			sb.append(",");
			sb.append(",");
			//Change the line below this with a valid image URL to change the icon
			sb.append(",");
			sb.append(String.valueOf(currentElement.getLatitude()) + ",");
			sb.append(String.valueOf(currentElement.getLongitude()) + ",");
			sb.append(",");
			sb.append(",");
			sb.append(",");
			sb.append(",");
			sb.append("\n");
			
			writeLine(sb.toString());
			
			
		}
	}
	//Method which writes data to the file
	private void writeLine(String line){
		FileWriter fw;
		try {
			fw = new FileWriter(file);

		BufferedWriter bw = new BufferedWriter(fw);
		
		//Write the lines content
		bw.write(line);
		bw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
