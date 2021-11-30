package model;

import java.util.ArrayList;
import java.util.HashMap;

import util.Utilitaires;

public class Planete {

	String nom;
	int distanceTerre;
	int capaciteAccueil;
	int popDepart;
	ArrayList<Vaisseaux> ships = new ArrayList<Vaisseaux>();
	
	
	public ArrayList<Vaisseaux> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Vaisseaux> ships) {
		this.ships = ships;
	}

	public Planete(String nom) {
		super();
		this.nom = nom;
		HashMap<String,String> hmap = Utilitaires.findPlanetesProperties(nom);
		this.distanceTerre = Integer.valueOf(hmap.get("DistanceTerre"));
		this.capaciteAccueil = Integer.valueOf(hmap.get("CapaciteAcceuil"));
		this.popDepart = Integer.valueOf(hmap.get("PopulationDepart"));
	}

	public String getNom() {
		return nom;
	}
	public int getDistanceTerre() {
		return distanceTerre;
	}

	public int getCapaciteAccueil() {
		return capaciteAccueil;
	}
	public int getPopDepart() {
		return popDepart;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setDistanceTerre(int distanceTerre) {
		this.distanceTerre = distanceTerre;
	}


	public void setCapaciteAccueil(int capaciteAccueil) {
		this.capaciteAccueil = capaciteAccueil;
	}


	public void setPopDepart(int popDepart) {
		this.popDepart = popDepart;
	}

	@Override
	public String toString() {
		return "Planete [nom=" + nom + ", distanceTerre=" + distanceTerre + ", capaciteAccueil=" + capaciteAccueil
				+ ", popDepart=" + popDepart + ", ships=" + ships + "]";
	}


	
	
	
	
}
