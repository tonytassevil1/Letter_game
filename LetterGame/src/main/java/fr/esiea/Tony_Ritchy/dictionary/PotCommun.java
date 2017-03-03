package main.java.fr.esiea.Tony_Ritchy.dictionary;

import java.util.ArrayList;
import java.util.List;

public class PotCommun {
	private ArrayList<Character> listeLettres;

	public PotCommun() {
		this.listeLettres = new ArrayList<Character>();
	}

	public boolean ajouterLettre(char lettre) {
		if (lettre == '\u0000') {
			return false;
		} else {
			this.listeLettres.add(lettre);
			return true;
		}
	}

	public void retirerMot(String wordToRemove) {
		for (char c : wordToRemove.toCharArray()) {
			for (int i = 0; i < this.listeLettres.size(); i++) {
				if (this.listeLettres.get(i) == c) {
					this.listeLettres.remove(i);
				}
			}
		}
	}

	public ArrayList<Character> getListeLettres() {
		return this.listeLettres;
	}

	public boolean verifierLettres(String word) {
		for (char c : word.toCharArray()) {
			if (!this.listeLettres.contains(c)) {
				return false;
			}
		}
		return true;
	}
}
