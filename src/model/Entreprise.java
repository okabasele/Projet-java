package model;

public class Entreprise extends Vaisseaux {
	
	String type;
	int Nbr_passagers = 0 ;
	int Position = 0 ;
	int Capacite = 0;
	int Consommation = 0;
	int Cout_creation = 0 ;
	
	
	public Entreprise(String type, int nbr_passagers, int position, int capacite, int consommation, int cout_creation) {
		super(type, nbr_passagers , position, capacite, consommation , cout_creation);
		this.type = type;
		Nbr_passagers = nbr_passagers;
		Position = position;
		Capacite = capacite;
		Consommation = consommation;
		Cout_creation = cout_creation;
	}


	

}
