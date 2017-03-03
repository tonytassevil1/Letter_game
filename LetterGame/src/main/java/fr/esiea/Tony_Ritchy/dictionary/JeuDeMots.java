package main.java.fr.esiea.Tony_Ritchy.dictionary;

import java.util.Random;
import java.util.Scanner;

public class JeuDeMots {
	private Dictionary dictionary;
	private PotCommun potCommun;
	private Players player1;
	private Players player2;
	private Players currentPlayer;
	private Scanner scan;

	public JeuDeMots() {
		String entry = "";

		while (!entry.equals("q")) {
			System.out.println("j: pour jouer");
			System.out.println("q: pour quitter");
			scan = new Scanner(System.in);
			entry = scan.next();

			switch (entry) {
			case "j":
				initialisation();
				jouer();
				break;

			case "q":
				break;
			}
		}
	}

	public static void main(String[] args) {
		JeuDeMots JeuDeMots = new JeuDeMots();
	}

	public void initialisation() {
		dictionary = new Dictionary();
		String entry = "";
		String choice = "";
		boolean b = true;
		while (b) {
			System.out.println("'1' pour 2 joueurs humains");
			System.out.println("'2' pour jouer contre l'IA");
			scan = new Scanner(System.in);
			choice = scan.next();

			switch (choice) {
			case "1":
				System.out.println("Nom joueur 1 : ");
				scan = new Scanner(System.in);
				entry = scan.next();
				player1 = new Players("player1", entry);
				System.out.println("Nom joueur 2: ");
				scan = new Scanner(System.in);
				entry = scan.next();
				player2 = new Players("player2", entry);
				b = false;
				break;

			case "2":
				System.out.println("Nom joueur 1 : ");
				scan = new Scanner(System.in);
				entry = scan.next();
				player1 = new Players("player1", entry);
				player2 = new IA(dictionary, "player2", "AI");
				b = false;
				break;

			default:
				System.out.println("entree non reconnu");
			}
		}

		potCommun = new PotCommun();

		char p1Letter = ' ';
		char p2Letter = ' ';

		while (p1Letter == p2Letter) {
			p1Letter = pioche();
			p2Letter = pioche();
		}

		int p1LetterASCII = (int) p1Letter;
		int p2LetterASCII = (int) p2Letter;
		int highLetter = Math.min(p1LetterASCII, p2LetterASCII);

		if (highLetter == p1LetterASCII) {
			currentPlayer = player1;
		} else {
			currentPlayer = player2;
		}
		potCommun.ajouterLettre(p1Letter);
		potCommun.ajouterLettre(p2Letter);

		System.out.println("joueur 1 pioche " + p1Letter + " pioche " + p2Letter + ".\n");
		System.out.println(currentPlayer + " begins.\n");
	}

	public void jouer() {
		String entree = "";
		String wordPlayer;
		char letterpicked;

		while (!entree.equals("q")) {
			if (currentPlayer.getmotTrouve() == false) {
				wordPlayer = "";
				System.out.println(currentPlayer + " pioche");
				letterpicked = pioche();
				System.out.println(currentPlayer + " a pioche " + letterpicked);
				potCommun.ajouterLettre(letterpicked);
				letterpicked = pioche();
				System.out.println(currentPlayer + " a pioche " + letterpicked);
				potCommun.ajouterLettre(letterpicked);
				System.out.println("Letters in the bag : " + potCommun.getListeLettres());

				if (currentPlayer == player1) {
					System.out.println(player2 + " : " + player2.getMotsTrouves());
					wordPlayer = currentPlayer.makeword(potCommun, player2.getMotsTrouves());
					traitementJeu(wordPlayer);
				} else {
					System.out.println(player1 + " : " + player1.getMotsTrouves());
					wordPlayer = currentPlayer.makeword(potCommun, player1.getMotsTrouves());
					traitementJeu(wordPlayer);
				}
			} else {
				if(currentPlayer.motsTrouves.size() == 10) {
					System.out.println(currentPlayer + " a gagné");
					entree = "q";
				}
				else {
					wordPlayer = "";
					System.out.println(currentPlayer + " pioche");

					letterpicked = pioche();
					System.out.println(currentPlayer + " draws " + letterpicked);
					potCommun.ajouterLettre(letterpicked);
					System.out.println("Letters in the bag : " + potCommun.getListeLettres());

					if (currentPlayer == player1) {
						System.out.println(player2 + " : " + player2.getMotsTrouves());
						wordPlayer = currentPlayer.makeword(potCommun, player2.getMotsTrouves());
						traitementJeu(wordPlayer);
					} else {
						System.out.println(player1 + " : " + player1.getMotsTrouves());
						wordPlayer = currentPlayer.makeword(potCommun, player1.getMotsTrouves());
						traitementJeu(wordPlayer);
					}
				}
			}
		}
	}

	public void traitementJeu(String word) {
		boolean result = dictionary.isWord(word);

		if (potCommun.verifierLettres(word)) {
			if (result == true) {
				System.out.println(word + " is in the dictionary. \n");
				if(player1.motsTrouves.contains(word) || player2.motsTrouves.contains(word)) {
					System.out.println("mot deja trouvé\n");
				} else {
					currentPlayer.ajouterMot(word);	
					currentPlayer.motTrouve = true;
					potCommun.retirerMot(word);
				}
			} else {
				if (!word.isEmpty()) {
					System.out.println(word + " isn't in the dictionary. \n");
				} else {
					System.out.println(currentPlayer + " didn't find a word. \n");
				}
				currentPlayer.setmotTrouve(false);
				tourSuivant();
			}
		} else {
			System.out.println(word + " n'est pas disponible, lettres pas dans le pot commun. \n");
			currentPlayer.setmotTrouve(false);
			tourSuivant();
		}
	}

	public void tourSuivant() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
			player2.setmotTrouve(false);
		} else {
			currentPlayer = player1;
			player1.setmotTrouve(false);
		}
	}
	

	public char pioche() {
		Random rand = new Random();
		char lettre;
		String listeLettres = "abcdefghijklmnopqrstuvwxyz";
		int longueur = listeLettres.length();
		int i = rand.nextInt(longueur);
		lettre = listeLettres.charAt(i);
		return lettre;
	}
}