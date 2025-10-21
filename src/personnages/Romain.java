package personnages;

public class Romain {
	private String nom;
	private int force;
	
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
	public static void main(String[] args) {
		Romain minus = new Romain ("minus", 6);
	}
	

}