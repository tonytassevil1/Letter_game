package test.java.fr.esiea.Tony_Ritchy.dictionary;

import org.junit.Before;
import org.junit.Test;

import main.java.fr.esiea.Tony_Ritchy.dictionary.Players;
import main.java.fr.esiea.Tony_Ritchy.dictionary.PotCommun;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayersTest {
	private Players players = new Players("toto", "titi");	

	public void testPlayers() {
		assertTrue(players.toString() == "titi");
		assertFalse(players.toString() == "jojo");
		
		assertFalse(players.getmotTrouve());
		players.setmotTrouve(true);
		assertTrue(players.getmotTrouve());
		
		assertTrue(players.motsTrouves.size() == 0);
		players.ajouterMot("loi");
		assertTrue(players.motsTrouves.size() == 1);
	}
}
