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
		return villageois[numVillageois];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		on obtient cette exception car on essaye d'acc�der au 31�me �l�ment d'un tableau de 30 �l�ments
//		message de lev�e d'exception : Index 30 out of bounds for length 30
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Ast�rix", 6);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		On obtient null car Ast�rix est le seul villageois, le deuxi�me �l�ment de la liste n'existe pas.
		
	}
}
