package test.java.fr.esiea.Tony_Ritchy.dictionary;

import org.junit.Before;
import org.junit.Test;

import main.java.fr.esiea.Tony_Ritchy.dictionary.Players;
import main.java.fr.esiea.Tony_Ritchy.dictionary.PotCommun;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

public class PotCommunTest {
	private PotCommun potCommun = new PotCommun();	

	public void testPotCommun() {
		assertTrue(potCommun.getListeLettres().size() == 0);
		
		potCommun.ajouterLettre('b');
		potCommun.ajouterLettre('o');
		potCommun.ajouterLettre('i');
		potCommun.ajouterLettre('s');

		assertTrue(potCommun.getListeLettres().size() == 4);
		assertTrue(potCommun.verifierLettres("bois"));
		assertFalse(potCommun.verifierLettres("boisa"));
		
		potCommun.retirerMot("bois");

		assertTrue(potCommun.getListeLettres().size() == 0);
	}
}
