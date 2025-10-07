package personnages;

public class Chaudron {

	private int quantitePotion;
	private int forcePotion;
		
	public void remplirChaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}
	public boolean resterPotion() {
		return quantitePotion>0;
	}
	
	public int prendreLouche() {
		quantitePotion--;
		if (quantitePotion==0) {
			forcePotion=0;
		}
		return forcePotion;
	}
}