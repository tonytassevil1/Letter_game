package fr.esiea.Tony_Ritchy.dictionary;

import java.util.ArrayList;

public class Jeux {

	String PotCommun = "";

	Players joueur1 = new Players();

	Players joueur2 = new Players();

	public void premierTourDeJeu() {

		char j1 = joueur1.getLettre();

		char j2 = joueur2.getLettre();

		PotCommun += j1 + j2;

		System.out.println(PotCommun);

		int i = premieracommence(j1, j2);

		if (i == 1) {
			// Joueur 1
			tour(joueur1);
		}

		else {
			// Joueur 2
			tour(joueur2);

		}
	}

	public int premieracommence(char j1, char j2)

	{

		if (j1 == j2) {

			System.out.println("Le joueur 1 & 2 ont tire la meme lettre. Joueur 1 commence.\n");

		}

		else if (j1 > j2) {

			System.out.println("Le joueur " + j1 + " commence.\n");

		}

		else {

			System.out.println("Le joueur " + j2 + " commence.\n");

			return 2;
		}

		return 1;
	}

	public void tour(Players selection) {

		PotCommun += selection.getLettre();
		PotCommun += selection.getLettre();

		// Fin du tour

		if (selection.idPlayer == 2) {

			tour(joueur1);

		}

		else {

			tour(joueur2);

		}

	}
}
