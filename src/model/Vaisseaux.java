package model;

public class Vaisseaux {
	
	String type;
	int Nbr_passagers = 0 ;
	int Position = 0 ;
	int Capacite = 0;
	int Consommation = 0;
	int Cout_creation = 0 ;
	
	
	public Vaisseaux(String type, int nbr_passagers, int position, int capacite, int consommation, int cout_creation) {
		super();
		this.type = type;
		Nbr_passagers = nbr_passagers;
		Position = position;
		Capacite = capacite;
		Consommation = consommation;
		Cout_creation = cout_creation;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNbr_passagers() {
		return Nbr_passagers;
	}


	public void setNbr_passagers(int nbr_passagers) {
		Nbr_passagers = nbr_passagers;
	}


	public int getPosition() {
		return Position;
	}


	public void setPosition(int position) {
		Position = position;
	}


	public int getCapacite() {
		return Capacite;
	}


	public void setCapacite(int capacite) {
		Capacite = capacite;
	}


	public int getConsommation() {
		return Consommation;
	}


	public void setConsommation(int consommation) {
		Consommation = consommation;
	}


	public int getCout_creation() {
		return Cout_creation;
	}


	public void setCout_creation(int cout_creation) {
		Cout_creation = cout_creation;
	}


	@Override
	public String toString() {
		return "Vaisseaux [type=" + type + ", Nbr_passagers=" + Nbr_passagers + ", Position=" + Position + ", Capacite="
				+ Capacite + ", Consommation=" + Consommation + ", Cout_creation=" + Cout_creation + "]";
	}
	
	

	
}
