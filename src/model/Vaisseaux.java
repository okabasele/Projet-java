package model;

public class Vaisseaux {
	
	String type;
	String position;
	int nbrPassagers;
	
	int capacite;
	int consommation;
	int coutCreation;
	
	
	public Vaisseaux(String type) {
		super();
		this.type = type;
		this.nbrPassagers = 0;
		position = "Terre";

	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getnbrPassagers() {
		return nbrPassagers;
	}


	public void setnbrPassagers(int nbrPassagers) {
		nbrPassagers = nbrPassagers;
	}





	public String getposition() {
		return position;
	}


	public void setposition(String position) {
		position = position;
	}


	public int getcapacite() {
		return capacite;
	}


	public void setcapacite(int capacite) {
		capacite = capacite;
	}


	public int getconsommation() {
		return consommation;
	}


	public void setconsommation(int consommation) {
		consommation = consommation;
	}


	public int getcoutCreation() {
		return coutCreation;
	}


	public void setcoutCreation(int coutCreation) {
		coutCreation = coutCreation;
	}


	@Override
	public String toString() {
		return "Vaisseaux [type=" + type + ", nbrPassagers=" + nbrPassagers + ", position=" + position + ", capacite="
				+ capacite + ", consommation=" + consommation + ", coutCreation=" + coutCreation + "]";
	}
	
	

	
}
