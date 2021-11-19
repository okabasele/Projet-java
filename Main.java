package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	
	static HashMap<String,Integer> expressions = new HashMap<String,Integer>();

	public static void main(String[] args) {}
	
	public static void fillHashMap() {
		try (Scanner s = new Scanner(new File("test.txt"))) {
	        while (s.hasNextLine()) {
	            String fullLine = s.nextLine();
	            String[] expArray = fullLine.split("(=)");
	            System.out.println("fullLine : "+fullLine);
	            expressions.put(expArray[0], Integer.valueOf(expArray[1]));
	            System.out.println("expArray : "+expArray[0] + "  :  " + expArray[1]);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println("expressions : " + expressions);
	}
	
	public static void findAttribut(String toFind) {
	    for (Entry<String, Integer> entry : expressions.entrySet()) {
	    	if (entry.getKey().startsWith(toFind)) {
	    		System.out.println(entry);
	    	}
	    	
	    }
	}
}
