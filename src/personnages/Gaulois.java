package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesObtenus = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesObtenus != null && i < tropheesObtenus.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesObtenus[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée.");
	}
	
	public void faireUneDonation(Musee musee) {
		if (nbTrophees == 0) {
			parler("Je n'ai aucun trophée à donner.");
		}
		else {
			parler("Je donne au musée tous mes trophées : " + listerTrophees());
			for (int i = 0; i < nbTrophees; ++i) {
				musee.donnerTrophee(this, trophees[i]);
			}
		}
	}
	
	private String listerTrophees() {
		String listeTrophees = "";
		for (int i = 0; i < nbTrophees; ++i) {
			listeTrophees += "\n- " + trophees[i];
		}
		return listeTrophees;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain minus = new Romain("Minus", 6);
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		
	}
}
