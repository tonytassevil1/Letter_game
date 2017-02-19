package fr.esiea.Tony_Ritchy.dictionary;

public class Points {

	public static int ptsJ1 = 0;
	public static int ptsJ2 = 0;
	

//Incremente les pts du joueur 1
	public void setPts1(int pts1){
	  ptsJ1 = pts1;
	}
	
	//Retourne le nom du joueur 1
	public String getPts1(){  
	return ptsJ1;
	}
	
//Incremente les pts du joueur 2
	public void setPts2(int pts2){
	  ptsJ2 = pts2;
	}
	
	//Retourne le nom du joueur 2
	public String getPts2(){  
	return ptsJ2;
	}




}