package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import menu.Menu;

public class Utilitaires {


	
	public static void fillHashMapPlanets() {
		try (Scanner s = new Scanner(new File("planetes.properties"))) {
	        while (s.hasNextLine()) {
	            String fullLine = s.nextLine();
	            String[] expArray = fullLine.split("(=)");
	            Menu.hmapPlanets.put(expArray[0], expArray[1]);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public static HashMap<String,String> findPlanetesProperties(String toFind) {
		HashMap<String,String> properties = new HashMap<String,String>();
	    for (Entry<String, String> entry : Menu.hmapPlanets.entrySet()) {
	    	if (entry.getKey().startsWith(toFind)) {
	    		properties.put(entry.getKey().substring(toFind.length()), entry.getValue());
	    	}
	    }
	    return properties;
	}
	
	public static void menuBannerWithUC(String menu) {
		String fmt = "%1$20s %2$20s%n";
		String uc = String.valueOf(Menu.countUC)+"UC";
		System.out.println("================================");
		System.out.format(fmt,menu,uc);
		System.out.println("================================");
	}
	
	public static void subMenuBanner(String subMenu) {
		System.out.println("+"+subMenu+"+");
	}

	public static int readInt() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try {
			i = sc.nextInt();
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally {
			//sc.close();
		}
		return i;
	}
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		String s = "";
		
		try {
			s = sc.nextLine();
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally {
			//sc.close();
		}
		return s;
	}

}
