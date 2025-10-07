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
	
	public void booster(Gaulois gaulois) {
		boolean contientPotion = chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();
		
		if (contientPotion) {
			if(nomGaulois=="Ob�lix") {
				parler("Non, "+nomGaulois+" Non!... Et tu le sais tr�s bien !");
			}else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens "+ nomGaulois + " un peu de potion magique.");
			}
		}else {
			parler("D�sol�" + nomGaulois + "il n'y a plus une seule goutte de potion.");
		}
	}
	
	
	
}
