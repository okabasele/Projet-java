package menu;

import java.util.HashMap;

import util.Utilitaires;
import model.Cargo;
import model.Espace;

public class Menu {

	//Les variables propres a l'application
	static boolean appliOn = true ;
	public static int countUC;
	public static HashMap<String,String> hmapPlanets = new HashMap<String,String>();
	public static HashMap<String, Integer> hmapVaisseaux = new HashMap<String, Integer>();
	
	// Il faudra créer un menu pour créer des vaisseaux
	// charger les vaisseaux en voyageur 
	//les envoyer et les décharger.
	
	public static void menuPrincipal() {
		System.out.println(TextConst.BONJOUR);
		do {
			//choose
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
					
		}while(appliOn);
	}
	
	public static void menuCreate() {
		Utilitaires.menuBannerWithUC(TextConst.MENUCREATE);
		//CHOISIR LE TYPE DU VAISSEAU
		int ship = Utilitaires.readInt();
		switch (ship) {
		case 1:
			//creer un vaisseau
			//l'ajouter dans l'arraylist de vaisseaux de la Terre
			Cargo c =new Cargo();
			Espace.alPlanets.get(2).setShips(Espace.alPlanets.get(2).getShips().add(c));
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default:
			System.out.println(TextConst.ERREUR);
			break;
		}
	}
	
	public static void menuRead() {
		Utilitaires.menuBannerWithUC(TextConst.MENUREAD);

		//VUE SPACIALE
		//PLANETE Terre : pop restante, nb de vaisseaux
		//LES PLANETES : pop/capacite, nombre de vaisseaux
		
	}
	

	
	public static void menuUpdate() {
		Utilitaires.menuBannerWithUC(TextConst.MENUUPDATE);
		
		//CHOISIR UN VAISSEAU
		//LE CHARGER EN VOYAGEUR
		// CHOISIR LA DESTINATION DU VAISSEAU ET L'ENVOYER
		//DECHARGER LE VAISSEAU A SON ARRIVEE
		
	}
}
