package personnages;

public class Chaudron {

	private int quantitePotion;
	private int forcePotion;
		
	public void remplirChaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}
	public boolean resterpotion() {
		return quantitePotion>0;
	}
	
	public int prendreLouche() {
		
	}
}
