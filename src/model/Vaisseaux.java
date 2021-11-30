package model;

import java.util.HashMap;

import util.Utilitaires;

public class Vaisseaux {
	
	String type;
	String position;
	int nbrPassagers;
	int id;
	
	int capacite;
	int consommation;
	int coutCreation;
	
	
	public Vaisseaux(int id) {
		super();
		this.id=id;
		this.type= this.getClass().getSimpleName().toLowerCase();
		this.nbrPassagers = 0;
		position = "Terre";
		HashMap<String, Integer> hmap = Utilitaires.findVaisseauxProperties(type);
		this.capacite = hmap.get("CapaciteTransport");
		this.consommation = hmap.get("Consomation");
		this.coutCreation = hmap.get("CoutCreation");

	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public int getNbrPassagers() {
		return nbrPassagers;
	}



	public void setNbrPassagers(int nbrPassagers) {
		this.nbrPassagers = nbrPassagers;
	}



	public int getCapacite() {
		return capacite;
	}



	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}



	public int getConsommation() {
		return consommation;
	}



	public void setConsommation(int consommation) {
		this.consommation = consommation;
	}



	public int getCoutCreation() {
		return coutCreation;
	}



	public void setCoutCreation(int coutCreation) {
		this.coutCreation = coutCreation;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Vaisseaux [type=" + type + ", id=" + id +", position=" + position + ", nbrPassagers=" + nbrPassagers
				+ ", capacite=" + capacite + ", consommation=" + consommation + ", coutCreation=" + coutCreation + "]";
	}




	

	
}
