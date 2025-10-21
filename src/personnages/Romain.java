package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	
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
	public void recevoirCoup(int forceCoup) {
		// TODO Auto-generated method stub
		int forceAvantCoup = force;
		assert forceCoup>0;
		force = force - forceCoup;
		if (force<=0){
			force=0;
			parler("J'abandonne");
		}
		else {
			parler("Aïe");
		}
		assert force<forceAvantCoup;
		assert isInvariantVerified();
	}
	private boolean isInvariantVerified() {
		return getForce()>=0;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2:
				parler("Le soldat "+ nom + " est déjà bien protégé !");
				return;
			case 1:
				if (equipements[0]== equipement) {
					parler("Le soldat " + nom + " possède déjà un " + equipement +" !");
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
		Romain minus = new Romain ("minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
	

}