package menu;

import java.util.ArrayList;
import java.util.HashMap;

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
		//LES PLANETES : pop/capacite, ships
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

		}
		System.out.format("|%1$10s|%2$30s|%3$20s|%4$20s|%n", "__________","______________________________","______________________________","____________________________________");

	}
	

	
	public static void menuUpdate() {
		Utilitaires.menuBannerWithUC(TextConst.MENUUPDATE);
		
		//CHOISIR UN VAISSEAU
		//LE CHARGER EN VOYAGEUR
		// CHOISIR LA DESTINATION DU VAISSEAU ET L'ENVOYER
		//DECHARGER LE VAISSEAU A SON ARRIVEE
		
	}
	

}
