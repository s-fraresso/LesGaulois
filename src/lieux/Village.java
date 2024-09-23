package lieux;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois villageois[];
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public boolean ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois++] = gaulois;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		if (numVillageois < nbVillageois) {
			return villageois[numVillageois];
		}
		else {
			System.out.println("Le villageois recherché n'existe pas.");
			return null;
		}
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
}
