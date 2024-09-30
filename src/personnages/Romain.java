package personnages;

public class Romain {
	private static final String SOLDAT = "Le soldat ";

	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert this.force >= 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public boolean getVainqueur() {
		return vainqueur;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (forceCoup != 0) {
			if (force > 0) {
				parler("Aïe");
				equipementEjecte = ejecterEquipement();
			} else {
				parler("J'abandonne...");
			}	
		}
		
		if (force == oldForce) {
			vainqueur = true;
			parler("Tu ne m'impressionnes pas, vil gaulois !");
		}
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; ++i) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			enfilerEquipement(equipement);
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println(SOLDAT + nom + " possède déjà un " + equipement + " !");
			}
			else {
				enfilerEquipement(equipement);
			}
			break;
		default:
			System.out.println(SOLDAT + nom + " est déjà bien protégé !");
		}
	}
	
	private void enfilerEquipement(Equipement equipement) {
		equipements[nbEquipement++] = equipement;
		System.out.println(SOLDAT + nom + " s'équipe avec un " + equipement + ".");
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
