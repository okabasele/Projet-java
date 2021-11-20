package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Utilitaires {

	//static HashMap<String,Integer> hmapShips = new HashMap<String,Integer>();
	public static HashMap<String,String> hmapPlanets = new HashMap<String,String>();
	
	public static void fillHashMap(HashMap<String,String> hmap, String filePath) {
		try (Scanner s = new Scanner(new File(filePath))) {
	        while (s.hasNextLine()) {
	            String fullLine = s.nextLine();
	            String[] expArray = fullLine.split("(=)");
	            hmap.put(expArray[0], expArray[1]);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public static HashMap<String,String> findPlanetesProperties(String toFind) {
		HashMap<String,String> properties = new HashMap<String,String>();
	    for (Entry<String, String> entry : hmapPlanets.entrySet()) {
	    	if (entry.getKey().startsWith(toFind)) {
	    		properties.put(entry.getKey().substring(toFind.length()), entry.getValue());
	    	}
	    }
	    return properties;
	}
}
