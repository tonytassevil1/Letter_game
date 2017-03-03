package main.java.fr.esiea.Tony_Ritchy.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Players {
	private String id;
	private String name;
	public ArrayList<Character> currentLetters;
	public ArrayList<String> motsTrouves;
	public boolean motTrouve;

	public Players(String id, String name) {
		currentLetters = new ArrayList<Character>();
		motsTrouves = new ArrayList<String>();
		this.id = id;
		this.name = name;
		this.motTrouve = false;
	}

	public String toString() {
		return name;
	}

	public boolean getmotTrouve() {
		return (this.motTrouve);
	}

	public void setmotTrouve(boolean b) {
		this.motTrouve = b;
	}

	public ArrayList<String> getMotsTrouves() {
		return motsTrouves;
	}

	public void ajouterMot(String pword) {
		motsTrouves.add(pword);
	}

	public String makeword(PotCommun potCommun, ArrayList<String> lListPlayer) {
		String entry = "";
		System.out.println("Your list : " + getMotsTrouves());
		System.out.println("enter the word : ");
		Scanner scan = new Scanner(System.in);
		entry = scan.next();
		return entry;
	}
}
