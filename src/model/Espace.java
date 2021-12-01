package model;

import java.util.ArrayList;

import menu.Menu;
import util.Utilitaires;
public class Espace {


	public Espace() {
		super();
		Utilitaires.fillHashMapPlanets();
		Utilitaires.fillHashMapVaisseaux();
		Utilitaires.initArrayListPlanets();
		Utilitaires.deleteAllDataFromFile();
	}
	
	public void initApp() {
		Menu.menuPrincipal();
	}
	
}
