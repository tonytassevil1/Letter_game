package fr.esiea.unique.binome.name.dictionary;

public class Players {

	private String nomPlayer;
	//private int nbLettreMain;//Je ne sais pas combien de lettre peut avoir un joueur en main
	private char Lettre;

	//public Player(String pNom, int nbLettre, string pLettre){
	public Player(String pNom, string pLettre){
		nomPlayer = pNom;
		//nbLettreMain = nbLettre;
		Lettre = pLettre;
	
	}
	
	//Définit le nom du joueur
	public void setNom(String pNom){
	  nomPlayer = pNom;
	}
	
	//Retourne le nom du joueur
	public String getNom(){  
	return nomPlayer;
	}
	
	//Tire une littre 
	public void getLettre(String pLettre){
		plettre = Lettre ;
		
		lettre = "abcdefghijklmnopqrstuvwxyz"[rand() % 26];
	}



}