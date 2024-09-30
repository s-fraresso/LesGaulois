package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private static final int NB_TROPHEES_MAX = 200;
	
	private Trophee[] trophees = new Trophee[NB_TROPHEES_MAX];
	private int nbTrophees = 0;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophees++] = new Trophee(gaulois, equipement);
	}
	
	public String extraireInstructionsOCaml() {
		String instruction = "let musee = [";
		for (int i = 0; i < nbTrophees; ++i) {
			instruction += "\n\t\"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement() + "\"";
			if (i < nbTrophees - 1) {
				instruction += ";";
			}
		}
		instruction += "\n]";
		return instruction;
	}
}
