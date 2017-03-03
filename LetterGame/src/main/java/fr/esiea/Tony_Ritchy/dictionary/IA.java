package main.java.fr.esiea.Tony_Ritchy.dictionary;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IA extends Players {
	public Dictionary dictionary;
	private ArrayList<String> listeMots;

	public IA(Dictionary dictionary, String id, String name) {
		super(id, name);
		this.dictionary = dictionary;
		this.listeMots = new ArrayList<String>();
	}

	public String findword() {
		String motlepluslong = "";
		for (String word : listeMots) {
			if (dictionary.getDictionary().contains(word)) {
				if (motlepluslong.length() < word.length()) {
					motlepluslong = word;
				}
			}
		}
		return motlepluslong;
	}

	@Override
	public String makeword(PotCommun shareBag, ArrayList<String> lListPlayer) {
		listeMots.clear();
		listeMotssGenerator(shareBag.getListeLettres(), lListPlayer);
		String result = findword();
		return result;
	}

	public void listeMotssGenerator(ArrayList<Character> listeLettres, ArrayList<String> lListPlayer) {
		createwords(listeLettres, "");
	}

	public void createwords(ArrayList<Character> listelettres, String motformé) {
		String motformécopié = motformé;

		if (listelettres.isEmpty() == false) {
			for (int k = 0; k < listelettres.size(); k++) {
				ArrayList<Character> listelettrecopie = new ArrayList<Character>();
				listelettrecopie.addAll(listelettres);
				motformécopié = motformé + listelettres.get(k);

				for (int i = 0; i < dictionary.getDictionary().size(); i++) {
					if (dictionary.getDictionary().get(i).startsWith(motformécopié)) {
						if (dictionary.getDictionary().contains(motformécopié)) {
							listeMots.add(motformécopié);
						}
						if (listelettres.isEmpty() == false) {
							listelettrecopie.remove(k);
							createwords(listelettrecopie, motformécopié);
							i = dictionary.getDictionary().size();
						}
					}
				}
			}
		}
	}
}
