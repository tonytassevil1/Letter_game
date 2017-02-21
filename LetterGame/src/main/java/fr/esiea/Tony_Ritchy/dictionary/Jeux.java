package fr.esiea.Tony_Ritchy.dictionary;

import java.util.ArrayList;

public class Jeux
{
	
String PotCommun= "";
	
Joueur joueur1 = new Joueur();
	
Joueur joueur2 = new Joueur();
	
	
public void premierTourDeJeu()
	{
		
char j1 = joueur1.getLettre();
		
char j2 = joueur2.getLettre();
		
		
PotCommun += j1 + j2;
		
System.out.println(PotCommun);
		
		
int i = quiCommence(j1, j2);
		
		
if (i == 1) { //Joueur 1
			
tourDeJeu(joueur1);
		
}
		
else { 
//Joueur 2
			
tourDeJeu(joueur2);
		
}
	}
	
	
public int quiCommence(char j1, char j2)
	
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
	
	
public void tourDeJeu(Joueur joueurSelectionne) {
		
PotCommun += joueurSelectionne.getLettre();
		
PotCommun += joueurSelectionne.getLettre();
		
		
		
//TODO TOUR DU JEU
		
		
//Fin du tour
		
if(joueurSelectionne.idJoueur == 2)
		
{
			
tourDeJeu(joueur1);
		
}
		
else
		
{
			
tourDeJeu(joueur2);
		
}
	
}
}
