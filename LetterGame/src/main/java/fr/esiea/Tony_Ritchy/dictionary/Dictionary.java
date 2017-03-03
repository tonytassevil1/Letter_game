package main.java.fr.esiea.Tony_Ritchy.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Dictionary implements IDictionary {
	private ArrayList<String> dictionary;

	public Dictionary() {
		dictionary = new ArrayList<String>();
		String chemin = System.getProperty("user.dir");
		chemin += "\\src\\main\\resources\\dico.txt";
		File file = new File(chemin);

		if (file.exists() == true) {
			System.out.println("dictionnaire trouvé");
		}
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String mot = null;
			while ((mot= r.readLine()) != null) {
				if (mot.length() > 1) {
					dictionary.add(mot);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isWord(String mot) {
		return dictionary.contains(mot);
	}

	public ArrayList<String> getDictionary() {
		return dictionary;
	}
}