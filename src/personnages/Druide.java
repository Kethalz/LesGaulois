package personnages;

import java.security.PublicKey;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron = new Chaudron();
	
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;

	}
	
	public void fabriquerPotion( int quantitePotion , int forcePotion) {
		chaudron.remplirChaudron(quantitePotion, forcePotion);
		parler("J'ai concoct� "+ quantitePotion + " doses de potion magique. Elle a une force de "+ forcePotion );
	}
	
	public void booster( Gaulois ) {
		
	}
	
	
	
}

