package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public static void initArrayListPlanets() {
		Menu.alPlanets.add(new Planete("Mercure"));
		Menu.alPlanets.add(new Planete("Venus"));
		Menu.alPlanets.add(new Planete("Terre"));
		Menu.alPlanets.add(new Planete("Mars"));
		Menu.alPlanets.add(new Planete("Jupiter"));
		Menu.alPlanets.add(new Planete("Saturne"));
		Menu.alPlanets.add(new Planete("Uranus"));
		Menu.alPlanets.add(new Planete("Neptune"));
		Menu.alPlanets.add(new Planete("Pluton"));
	}
	
	public static void readAlPlanets() {
		for (Planete p : Menu.alPlanets) {
			System.out.println(p.toString());
		}
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
			Planete merc = Menu.alPlanets.get(0);
			merc.getShips().add(ship);
			Menu.alPlanets.set(0, merc);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Venus":
			ship.setPosition(planetName);
			Planete venus = Menu.alPlanets.get(1);
			venus.getShips().add(ship);
			Menu.alPlanets.set(1, venus);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Terre":
			ship.setPosition(planetName);
			Planete Terre = Menu.alPlanets.get(2);
			Terre.getShips().add(ship);
			Menu.alPlanets.set(2, Terre);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			break;
		case "Mars":
			ship.setPosition(planetName);
			Planete mars = Menu.alPlanets.get(3);
			mars.getShips().add(ship);
			Menu.alPlanets.set(3, mars);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Jupiter":
			ship.setPosition(planetName);
			Planete jupt = Menu.alPlanets.get(4);
			jupt.getShips().add(ship);
			Menu.alPlanets.set(4, jupt);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Saturne":
			ship.setPosition(planetName);
			Planete sat = Menu.alPlanets.get(5);
			sat.getShips().add(ship);
			Menu.alPlanets.set(5, sat);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Uranus":
			ship.setPosition(planetName);
			Planete ur = Menu.alPlanets.get(6);
			ur.getShips().add(ship);
			Menu.alPlanets.set(6, ur);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Neptune":
			ship.setPosition(planetName);
			Planete nep = Menu.alPlanets.get(7);
			nep.getShips().add(ship);
			Menu.alPlanets.set(7, nep);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		case "Pluton":
			ship.setPosition(planetName);
			Planete plu = Menu.alPlanets.get(8);
			plu.getShips().add(ship);
			Menu.alPlanets.set(8, plu);
			updateCountUC();
			loadingBar(TextConst.LOADINGBAR);
			writeDataInFile("Un vaisseau (type="+ship.getType()+", id="+ ship.getId()+ ") a été ajouté à la planète "+planetName);
			System.out.println("Un vaisseau ("+ship.getType()+") a été ajouté à la planète "+planetName);
			break;
		default: 
			System.out.println(TextConst.ERREUR);
			break;
		}
	}
	
	public static void updateCountUC() {
		Menu.countUC += 1;
	}
	
	public static Planete getPlanetByName(String planetName) {

        switch(planetName) {
        case "Mercure":
            Planete merc = Menu.alPlanets.get(0);
            return merc;
        case "Venus":
            Planete venus = Menu.alPlanets.get(1);
            return venus;
        case "Terre":
            Planete terre = Menu.alPlanets.get(2);
            return terre;
        case "Mars":
            Planete mars = Menu.alPlanets.get(3);
            return mars;
        case "Jupiter":
            Planete jupt = Menu.alPlanets.get(4);
            return jupt;
        case "Saturne":
            Planete sat = Menu.alPlanets.get(5);
            return sat;
        case "Uranus":
            Planete ur = Menu.alPlanets.get(6);
            return ur;
        case "Neptune":
            Planete nep = Menu.alPlanets.get(7);
            return nep;
        case "Pluton":
            Planete plu = Menu.alPlanets.get(8);
            return plu;
        default: 
            System.out.println(TextConst.ERREUR);
            break;
        }
return null;
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
	
	public static void setPopulationPlanet(String planetName, int pop) {

        switch(planetName) {
        case "Mercure":
            Planete merc = Menu.alPlanets.get(0);
            merc.setPopDepart(merc.getPopDepart()+pop);
            break;
        case "Venus":
            Planete venus = Menu.alPlanets.get(1);
            venus.setPopDepart(venus.getPopDepart()+pop);
            break;
        case "Terre":
            Planete terre = Menu.alPlanets.get(2);
            terre.setPopDepart(terre.getPopDepart()+pop);
            break;
        case "Mars":
            Planete mars = Menu.alPlanets.get(3);
            mars.setPopDepart(mars.getPopDepart()+pop);
            break;
        case "Jupiter":
            Planete jupt = Menu.alPlanets.get(4);
            jupt.setPopDepart(jupt.getPopDepart()+pop);
            break;
        case "Saturne":
            Planete sat = Menu.alPlanets.get(5);
            sat.setPopDepart(sat.getPopDepart()+pop);
            break;
        case "Uranus":
            Planete ur = Menu.alPlanets.get(6);
            ur.setPopDepart(ur.getPopDepart()+pop);
            break;
        case "Neptune":
            Planete nep = Menu.alPlanets.get(7);
            nep.setPopDepart(nep.getPopDepart()+pop);
            break;
        case "Pluton":
            Planete plu = Menu.alPlanets.get(8);
            plu.setPopDepart(plu.getPopDepart()+pop);
            break;
        default: 
            System.out.println(TextConst.ERREUR);
            break;
        }
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String now = dateFormat.format(new Date());
		try {
			writer = new BufferedWriter(new FileWriter("./output.txt",true));
		      writer.write(now +" : "+ strToWrite+"\n");  //pour ajouter : writer.append(strToWrite);
		      writer.close();
		} catch (IOException e) {
			      e.printStackTrace();
		}
	}
	
	public static void deleteAllDataFromFile() {
		FileOutputStream writer = null;
		try {
			writer = new FileOutputStream("./output.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			writer.write(("").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
