package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + ":";
	}
//	public void recevoirCoup(int forceCoup) {
//		// TODO Auto-generated method stub
//		int forceAvantCoup = force;
//		assert forceCoup>0;
//		force = force - forceCoup;
//		if (force<=0){
//			force=0;
//			parler("J'abandonne");
//		}
//		else {
//			parler("Aïe");
//		}
//		assert force<forceAvantCoup;
//		assert isInvariantVerified();
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 1) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");

		}
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else if (equipements[i] != null){
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}

			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup>resistanceEquipement) {
			forceCoup -= resistanceEquipement;
		}else {
			forceCoup = 0;
		}
		
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	private boolean isInvariantVerified() {
		return getForce() >= 0;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2:
			parler("Le soldat " + nom + " est déjà bien protégé !");
			return;
		case 1:
			if (equipements[0] == equipement) {
				parler("Le soldat " + nom + " possède déjà un " + equipement + " !");
				return;
			}
		case 0:
			equiper(equipement);
		}

	}

	private void equiper(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		parler("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	public static void main(String[] args) {
		Romain minus = new Romain("minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}