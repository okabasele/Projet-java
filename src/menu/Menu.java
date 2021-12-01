package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import util.Utilitaires;
import model.Cargo;
import model.Enterprise;
import model.Fusee;
import model.Navette;
import model.Planete;
import model.Vaisseaux;

public class Menu {

	//Les variables propres a l'application
	static boolean appliOn = true ;
	public static int countUC = 0;
	public static int nbTour = 1;
	public static HashMap<String,String> hmapPlanets = new HashMap<String,String>();
	public static HashMap<String, Integer> hmapVaisseaux = new HashMap<String, Integer>();
	
	public static HashMap<Integer,Vaisseaux> hmapShips= new HashMap<Integer,Vaisseaux>();
	public static ArrayList<Planete> alPlanets = new ArrayList<Planete>();
	// Il faudra créer un menu pour créer des vaisseaux
	// charger les vaisseaux en voyageur 
	//les envoyer et les décharger.
	
	public static void menuPrincipal() {
		System.out.println(TextConst.WELCOME);
		System.out.println(TextConst.BONJOUR);
		do {
			//choose
			System.out.println("");
			Utilitaires.subMenuBanner("Tour "+nbTour);

			System.out.println(TextConst.MENUCHOIX);
			int menu = Utilitaires.readInt();
			
			switch(menu) {
			case 1: //create
				menuCreate();
				break;
			
			case 2: //read
				menuRead();
				break;
			
			case 3: //update
				menuUpdate();
				break;
							
			case 4: //exit
				System.out.println(TextConst.EXIT);
				appliOn=false;
				break;
			
			default:
				System.out.println(TextConst.ERREUR);
				break;
			}
			isGameCleared();
			nbTour++;
					
		}while(appliOn);
	}
	
	public static void menuCreate() {
		Utilitaires.menuBannerWithUC(TextConst.MENUCREATE);
		//CHOISIR LE TYPE DU VAISSEAU
		System.out.println(TextConst.MENUCREATECHOIX);
		int choix = Utilitaires.readInt();
		int nextAvailableInt = Utilitaires.getNextAvalaibleIntFromSet(hmapShips.keySet());
		switch (choix) {
		case 1:
			//creer un vaisseau
			Fusee f = new Fusee(nextAvailableInt);
			//ajouter dans le hashmap qui stocke tout les vaisseaux
			hmapShips.put(nextAvailableInt,f);
			//l'ajouter dans l'arraylist de vaisseaux de la Terre
			Utilitaires.addShipToPlanet("Terre", f);
			break;
		case 2:
			Navette n = new Navette(nextAvailableInt);
			hmapShips.put(nextAvailableInt,n);
			Utilitaires.addShipToPlanet("Terre", n);
			break;
		case 3:
			Cargo c =new Cargo(nextAvailableInt);
			hmapShips.put(nextAvailableInt,c);
			Utilitaires.addShipToPlanet("Terre", c);
			break;
		case 4:
			Enterprise e= new Enterprise(nextAvailableInt);
			hmapShips.put(nextAvailableInt,e);
			Utilitaires.addShipToPlanet("Terre", e);
			break;
		default:
			System.out.println(TextConst.ERREUR);
			break;
		}
	}
	
	public static void menuRead() {
		Utilitaires.menuBannerWithUC(TextConst.MENUREAD);
		String fmt = "|%1$10s|%2$30s|%3$30s|%4$36s|%n";
		System.out.format(" %1$10s %2$30s %3$20s %4$20s%n", "__________","______________________________","______________________________","____________________________________");
		System.out.format("| %1$7s  |%2$30s|%3$30s|          %4$16s          |%n", "Planete","Distance Terre ","Population/Capacité d'acceuil","Vaisseaux a bord");
		System.out.format("| %1$7s  |%2$30s|%3$30s|  %4$16s   |%n", "","(UA)","","(type, passagers/capacite) : id");
		System.out.format(fmt, "__________","______________________________","______________________________","____________________________________");
		for (Planete planet : alPlanets) {
			
			if (planet.getShips().size() != 0) {
				for(String ship : planet.getShipsFormat())
				if (ship.equals(planet.getShipsFormat().get(0))) {
					System.out.format(fmt,planet.getNom(),planet.getDistanceTerre(),planet.getPopDepart()+"/"+planet.getCapaciteAccueil(),ship);
				} else {
					System.out.format(fmt,"","","",ship);
				}
			} else {

				System.out.format(fmt,planet.getNom(),planet.getDistanceTerre(),planet.getPopDepart()+"/"+planet.getCapaciteAccueil(),"");
			}
			System.out.format("|%1$10s|%2$30s|%3$20s|%4$20s|%n", "__________","______________________________","______________________________","____________________________________");

		}

	}
	

	
	public static void menuUpdate() {
		Utilitaires.menuBannerWithUC(TextConst.MENUUPDATE);
		
		//CHOISIR UN VAISSEAU
		 System.out.println("Choisissez un vaisseau");
		 for (Entry<Integer, Vaisseaux> entry : hmapShips.entrySet()) {
                 System.out.println(entry.getKey() +":"+ entry.getValue());
         }
		  int choix =  Utilitaires.readInt();
		  if(hmapShips.containsKey(choix)) {
			//LE CHARGER EN VOYAGEUR
			  Vaisseaux ship =hmapShips.get(choix);
			  Planete depart = Utilitaires.getPlanetByName(ship.getPosition());
			  if(depart.getPopDepart()-ship.getCapacite()>=0) {
				  ship.setNbrPassagers(ship.getCapacite());
			  }else {
				  ship.setNbrPassagers(depart.getPopDepart());
			  }
		      Utilitaires.setPopulationPlanet(ship.getPosition(), -ship.getNbrPassagers());
		      depart.getShips().remove(ship);
		      Utilitaires.writeDataInFile("Le vaisseau ("+ship.getType()+", id="+ ship.getId()+") a quitté la planète "+ship.getPosition()+ "avec "+ship.getNbrPassagers()+" passagers a bord.");
	            System.out.println("Le vaisseau ("+ship.getType()+", id="+ ship.getId()+") a quitté la planète "+ship.getPosition()+ "avec "+ship.getNbrPassagers()+" passagers a bord.");
	            Utilitaires.updateCountUC();
		   // CHOISIR LA DESTINATION DU VAISSEAU ET L'ENVOYER
		      System.out.println("choisissez la destination du vaisseau");
			  for(Planete planete : alPlanets) {
				  System.out.println(planete.getNom());
			  }
			  boolean shipNotInPlanet = true; 
			  do {
				  
				  String destination = Utilitaires.saisieString();
				  Planete p = Utilitaires.getPlanetByName(destination); 
				  if(alPlanets.contains(p)) {
					  
					  if(p.getPopDepart()+ship.getNbrPassagers()<=p.getCapaciteAccueil()) {
						//DECHARGER LE VAISSEAU A SON ARRIVEE
						  Utilitaires.addShipToPlanet(p.getNom(),ship);
						  Utilitaires.setPopulationPlanet(ship.getPosition(), ship.getNbrPassagers());
						  Utilitaires.writeDataInFile("Les "+ship.getNbrPassagers()+" passagers du vaisseau ( "+ship.getType()+", id="+ ship.getId()+") ont embarqué sur la planete "+ship.getPosition());
				            System.out.println("Les "+ship.getNbrPassagers()+" passagers du vaisseau ( "+ship.getType()+", id="+ ship.getId()+") ont embarqué sur la planete "+ship.getPosition());
				           Utilitaires.updateCountUC();
						  ship.setNbrPassagers(0);
						  shipNotInPlanet = false;
						  
					  }
				  }
				  if(shipNotInPlanet) {
					  System.out.println("Veuillez réessayer s'il vous plaît");
				  }
			  }while(shipNotInPlanet);
			  
		  }else {
			  System.out.println(TextConst.ERREUR);
		  }
	}
	
	 public static void isGameCleared() {
	        if(Utilitaires.getPlanetByName("Terre").getPopDepart() == 0) {
	        	System.out.println("Félicitations!!");
	        	System.out.println("Il n'y a plus personnes sur Terre");
	        	Utilitaires.writeDataInFile("Vous avez dépensé "+countUC+"UC");
	        	System.out.println("Vous avez dépensé "+countUC+"UC");
	        	Utilitaires.writeDataInFile("Vous fini le jeu en "+nbTour+" tours.");
	        	System.out.println("Vous fini le jeu en "+nbTour+" tours.");
	            appliOn=false;
	        }
	    }
	

}
