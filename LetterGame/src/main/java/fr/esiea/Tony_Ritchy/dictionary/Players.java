package fr.esiea.Tony_Ritchy.dictionary;

import java.util.Random;

public class Players {

	private String nomPlayer;
	private static int compteur = 1;
	public final int idPlayer;
	//private int nbLettreMain;//Je ne sais pas combien de lettre peut avoir un joueur en main
	//private char lettre;

	//public Player(String pNom, int nbLettre, string pLettre){
	public Player(String pNom, string pLettre){
		nomPlayer = pNom;
		this.idPlayer = compteur++;
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
	public char getLettre(){
		return "abcdefghijklmnopqrstuvwxyz"[rand() % 26];
		
	}



}