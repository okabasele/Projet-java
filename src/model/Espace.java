package model;

import java.util.ArrayList;

import util.Utilitaires;
public class Espace {

	
	ArrayList<Planete> alPlanets = new ArrayList<Planete>();

	public Espace() {
		super();
		Utilitaires.fillHashMapPlanets();;
		initArrayListPlanets();
	}
	
	void initArrayListPlanets() {
		this.alPlanets.add(new Planete("Mercure"));
		this.alPlanets.add(new Planete("Venus"));
		this.alPlanets.add(new Planete("Terre"));
		this.alPlanets.add(new Planete("Mars"));
		this.alPlanets.add(new Planete("Jupiter"));
		this.alPlanets.add(new Planete("Saturne"));
		this.alPlanets.add(new Planete("Uranus"));
		this.alPlanets.add(new Planete("Neptune"));
		this.alPlanets.add(new Planete("Pluton"));
	}
	
	public void readAlPlanets() {
		for (Planete p : alPlanets) {
			System.out.println(p.toString());
		}
	}
}
