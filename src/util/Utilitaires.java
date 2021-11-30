package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import menu.Menu;
import menu.TextConst;
import model.Espace;
import model.Planete;
import model.Vaisseaux;

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
	
	public static void fillHashMapVaisseaux() {
		try (Scanner s = new Scanner(new File("vaisseaux.properties"))) {
	        while (s.hasNextLine()) {
	            String fullLine = s.nextLine();
	            String[] expArray = fullLine.split("(=)");
	            Menu.hmapVaisseaux.put(expArray[0], Integer.valueOf(expArray[1]));
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public static HashMap<String, Integer> findVaisseauxProperties(String toFind) {
		HashMap<String, Integer> properties = new HashMap<String, Integer>();
	    for (Entry<String, Integer> entry : Menu.hmapVaisseaux.entrySet()) {
	 
	    	if (entry.getKey().startsWith(toFind)) {
	    		properties.put(entry.getKey().substring(toFind.length()), entry.getValue());
	    		
	 
	    	}
	    	
	    }
	    return properties;
	}
	
	public static void menuBannerWithUC(String menuBan) {
		String fmt = "%1$20s %2$20s%n";
		String uc = String.valueOf(Menu.countUC)+"UC";

		System.out.println("================================");
		System.out.format(fmt,menuBan,uc);
		System.out.println("================================");
	}
	
	public static void subMenuBanner(String subMenu) {
		System.out.println("+"+subMenu+"+");
	}

	
	public static void addShipToPlanet(String planetName, Vaisseaux ship) {

		switch(planetName) {
		case "Mercure":
			ship.setPosition(planetName);
			Planete merc = Espace.alPlanets.get(0);
			merc.getShips().add(ship);
			Espace.alPlanets.set(0, merc);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Venus":
			ship.setPosition(planetName);
			Planete venus = Espace.alPlanets.get(1);
			venus.getShips().add(ship);
			Espace.alPlanets.set(1, venus);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Terre":
			ship.setPosition(planetName);
			Planete Terre = Espace.alPlanets.get(2);
			Terre.getShips().add(ship);
			Espace.alPlanets.set(2, Terre);
			Menu.updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			break;
		case "Mars":
			ship.setPosition(planetName);
			Planete mars = Espace.alPlanets.get(3);
			mars.getShips().add(ship);
			Espace.alPlanets.set(3, mars);
			
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Jupiter":
			ship.setPosition(planetName);
			Planete jupt = Espace.alPlanets.get(4);
			jupt.getShips().add(ship);
			Espace.alPlanets.set(4, jupt);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Saturne":
			ship.setPosition(planetName);
			Planete sat = Espace.alPlanets.get(5);
			sat.getShips().add(ship);
			Espace.alPlanets.set(5, sat);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Uranus":
			ship.setPosition(planetName);
			Planete ur = Espace.alPlanets.get(6);
			ur.getShips().add(ship);
			Espace.alPlanets.set(6, ur);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Neptune":
			ship.setPosition(planetName);
			Planete nep = Espace.alPlanets.get(7);
			nep.getShips().add(ship);
			Espace.alPlanets.set(7, nep);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Pluton":
			ship.setPosition(planetName);
			Planete plu = Espace.alPlanets.get(8);
			plu.getShips().add(ship);
			Espace.alPlanets.set(8, plu);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
			default: 
			System.out.println(TextConst.ERREUR);
			break;
		}
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
	

	public static void loadingBar(String anim) {
		  StringBuilder sb = new StringBuilder(anim);
		  for(int tour=0;tour<2;tour++) {
			  
			  for(int i=0;i<20;i++) {
				  if(i < 10) {
					  sb.insert(sb.indexOf("[")+i+1, " ");
					  sb.deleteCharAt(sb.lastIndexOf(" "));
				  } else {
					  sb.insert(sb.indexOf(">")+i-10+1, " ");
					  sb.deleteCharAt(sb.indexOf(" "));
				  }
				  System.out.print(sb+"\r");	
				  try {
					  Thread.sleep(100);
				  } catch (InterruptedException e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
				  }
			  }
		  }  
	}

	//Prendre une clé disponible dans le set de clé Integer.
	public static int getNextAvalaibleIntFromSet(Set<Integer> setInt) {
		int i = 1;
		while (setInt.contains(i)) {
			i++;
		}
		return i;
	}
	
	public static void writeDataInFile(String strToWrite) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("./output.txt"));
		      writer.write(strToWrite);  //pour ajouter : writer.append(strToWrite);
		      writer.close();
		} catch (IOException e) {
			      e.printStackTrace();
		}
	}
	


}
