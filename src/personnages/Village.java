package personnages;

public class Village {
	
	private String nom;
	private int nbVillageois=0;
	private Gaulois chef;
	private Gaulois[] villageois;	
	private final int nbVillageoisMax;
	
	public String getNom() {
		return nom;
	}
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois<nbVillageoisMax) {
			this.villageois[nbVillageois]= gaulois ;
			nbVillageois++;
			gaulois.setVillage(this);
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois>nbVillageois) {
			System.out.println("Il n'y pas autant d'habitants dans notre village !");
			return null;
		}else {
			return villageois[numVillageois-1];
		}  
	}	
	
	public void afficherVillageois() {
		System.out.println("Dans le village " + getNom() + " du chef " + getChef().getNom() + " vivent les légendaires gaulois:");
		for (int i = 1; i < nbVillageois+1; i++) {
			System.out.println("- "+ trouverVillageois(i));
			
		}
	}
	
	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		this.nom = nom;
		this.chef = chef;
		this.nbVillageoisMax = nbVillageoisMax;
		this.villageois = new Gaulois[nbVillageoisMax];
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village villagedi = new Village("Village des Irréductibles", abraracourcix,30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		villagedi.ajouterVillageois(asterix);

		villagedi.afficherVillageois();
		
	}


}
