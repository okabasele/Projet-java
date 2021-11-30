package model;

import java.util.ArrayList;

import menu.Menu;
import util.Utilitaires;
public class Espace {

	
	public static ArrayList<Planete> alPlanets = new ArrayList<Planete>();

	public Espace() {
		super();
		Utilitaires.fillHashMapPlanets();
		Utilitaires.fillHashMapVaisseaux();
		initArrayListPlanets();
		Utilitaires.deleteAllDataFromFile();
	}
	
	public void initApp() {
		Menu.menuPrincipal();
	}
	
	void initArrayListPlanets() {
		alPlanets.add(new Planete("Mercure"));
		alPlanets.add(new Planete("Venus"));
		alPlanets.add(new Planete("Terre"));
		alPlanets.add(new Planete("Mars"));
		alPlanets.add(new Planete("Jupiter"));
		alPlanets.add(new Planete("Saturne"));
		alPlanets.add(new Planete("Uranus"));
		alPlanets.add(new Planete("Neptune"));
		alPlanets.add(new Planete("Pluton"));
	}
	
	public void readAlPlanets() {
		for (Planete p : alPlanets) {
			System.out.println(p.toString());
		}
	}
}
