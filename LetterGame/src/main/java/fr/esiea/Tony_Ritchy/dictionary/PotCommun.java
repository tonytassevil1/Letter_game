package fr.esiea.Tony_Ritchy.dictionary;

import java.util.ArrayList;

public class PotCommun {

	private ArrayList al = new ArrayList();

	// affichage des lettres
	public void lettre() {

		for (char lettre : this.al) {
			System.out.println("lettres :" + lettre);
		}
	}

	public ajouterlettre(){
		
		lettre();
		
	}
}