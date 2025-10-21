package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	private String village;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}
	@Override
	public String toString() {
		return nom;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "+ romain.getNom());
		romain.recevoirCoup((effetPotion*force)/3);
		effetPotion--;
		if (effetPotion<1) {
			effetPotion=1;
		}
	}
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public void sePresenter(Gaulois gaulois, String village) {
		if(gaulois==village.getChef()) {
			System.out.println("Le Gaulois"+ getNom()+" : \"Bonjour, je m'appelle "+ getNom()+ ". Je suis l");
		}
		if(){
			System.out.println("Villageois");
		}
		else {
			System.out.println("Pas habitant");
		}
	}

}