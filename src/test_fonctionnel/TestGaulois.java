package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Village;

public class TestGaulois {

	public static void main(String[] args) {
		
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		
		Village village = new Village("Village des irr�ductibles", abraracourcix, 30);
		abraracourcix.setVillage(village);
		
		Gaulois asterix = new Gaulois ("Ast�rix", 8);
		village.ajouterVillageois(asterix);
		
		Gaulois obelix = new Gaulois ("Ob�lix", 25);
		village.ajouterVillageois(obelix);
		
		Gaulois doublepolemix = new Gaulois ("Doublepol�mix", 4);
		
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}
	
}
