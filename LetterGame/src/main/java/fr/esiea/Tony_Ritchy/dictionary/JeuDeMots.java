package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import dictionary.Dictionary;

public class JeuDeMots {
	private Dictionary dictionary;

	private LetterGenerator randomLetter;
	private SharedBag sharedBag;
	private Players player1;
	private Players player2;

	private Players currentPlayer;
	private Scanner scan;

	public LetterGameEngine() {

		String entry = "";

		while (!entry.equals("q")) {

			System.out.println("Bonjour (appuyez sur h for aide)\n");
			scan = new Scanner(System.in);
			entry = scan.next();

			switch (entry) {

			case "h": // help : afficher l'aide

				System.out.println("h: affiche l'aide");
				System.out.println("d: débute le jeu");
				System.out.println("q: quitter");

				break;

			case "d": // start a new game
				startGame();
				play();
				break;

			case "q":
				break;
			}
		}

	}

	public static void main(String[] args) {
		LetterGameEngine LetterGameConsole = new LetterGameEngine();
	}

	public void startGame() {
		dictionary = new Dictionary();
		String nom = "";
		String choix = "";
		boolean b = true;
		while (b) {
			System.out.println("Que voulez vous faire ?");
			System.out.println("entrez 1 pour 2 joueurs");
			System.out.println("entrez 2 pour jouer contre l'ordinateur");
			System.out.println("Entrez 1 ou 2.");
			scan = new Scanner(System.in);
			choix = scan.next();

			switch (choice) {
			case "1":
				System.out.println("Nom joueur 1 : ");
				scan = new Scanner(System.in);
				nom = scan.next();
				player1 = new Player(nom);
				System.out.println("Nom joueur 2 : ");
				scan = new Scanner(System.in);
				nom = scan.next();
				player2 = new Player(entry);
				b = false;
				break;

			case "2":
				System.out.println("Nom joueur 1 : ");
				scan = new Scanner(System.in);
				nom = scan.next();
				player1 = new Player(nom);
				player2 = new PlayerAI(dictionary, "player2", "AI");
				b = false;
				break;
			default:
				System.out.println("choix non reconnu");

			}

		}

		sharedBag = new SharedBag();
		randomLetter = new LetterGenerator();

		char p1Letter = ' ';
		char p2Letter = ' ';

		while (p1Letter == p2Letter) {
			p1Letter = player1.pick(randomLetter);
			p2Letter = player2.pick(randomLetter);
		}

		int p1LetterASCII = (int) p1Letter;
		int p2LetterASCII = (int) p2Letter;

		int highLetter = Math.min(p1LetterASCII, p2LetterASCII);

		if (highLetter == p1LetterASCII) {
			currentPlayer = player1;
		} else {
			currentPlayer = player2;
		}
		sharedBag.addLetter(p1Letter);
		sharedBag.addLetter(p2Letter);

		System.out.println("player1 draws " + p1Letter + " and player2 draws " + p2Letter + ".\n");
		System.out.println(currentPlayer + " begins.\n");

	}

	public void play() {
		String entry = "";
		String wordPlayer;
		char letterpicked;

		while (!entry.equals("q")) {

			if (currentPlayer.getbWordFound() == false) {
				wordPlayer = "";
				System.out.println(currentPlayer + " draws twice");

				letterpicked = currentPlayer.pick(randomLetter);
				System.out.println(currentPlayer + " draws " + letterpicked);
				sharedBag.addLetter(letterpicked);
				letterpicked = currentPlayer.pick(randomLetter);
				System.out.println(currentPlayer + " draws " + letterpicked);
				sharedBag.addLetter(letterpicked);
				System.out.println("Letters in the bag : " + sharedBag.getlListOfLetterOnSharedBag());

				if (currentPlayer == player1) {
					System.out.println(player2 + " : " + player2.getWordsFound());

					wordPlayer = currentPlayer.makeword(sharedBag, player2.getWordsFound());
					traitementJeu(wordPlayer);
				} else {
					System.out.println(player1 + " : " + player1.getWordsFound());
					wordPlayer = currentPlayer.makeword(sharedBag, player1.getWordsFound());
					traitementJeu(wordPlayer);
				}

			} else {
				wordPlayer = "";
				System.out.println(currentPlayer + " draws once");

				letterpicked = currentPlayer.pick(randomLetter);
				System.out.println(currentPlayer + " draws " + letterpicked);
				sharedBag.addLetter(letterpicked);
				System.out.println("Letters in the bag : " + sharedBag.getlListOfLetterOnSharedBag());

				if (currentPlayer == player1) {
					System.out.println(player2 + " : " + player2.getWordsFound());
					wordPlayer = currentPlayer.makeword(sharedBag, player2.getWordsFound());
					traitementJeu(wordPlayer);
				} else {
					System.out.println(player1 + " : " + player1.getWordsFound());
					wordPlayer = currentPlayer.makeword(sharedBag, player1.getWordsFound());
					traitementJeu(wordPlayer);
				}
			}
		}
	}

	public void traitementJeu(String word) {

		boolean result = dictionary.isAword(word);

		if (!sharedBag.verifyletters(word)) {
			if (result == true) {

				System.out.println(word + " is in the dictionary. \n");
				currentPlayer.bWordFound = true;
				currentPlayer.addword(word);
				sharedBag.removeLetters(word);

			} else {
				if (!word.isEmpty()) {
					System.out.println(word + " isn't in the dictionary. \n");
				} else {
					System.out.println(currentPlayer + " didn't find a word. \n");
				}
				currentPlayer.setbWordFound(false);
				changePlayer();
			}
		} else {
			System.out.println(word + " incorrect. \n");
			currentPlayer.setbWordFound(false);
			changePlayer();
		}

	}

	public void changePlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
			player2.setbWordFound(false);
		} else {
			currentPlayer = player1;
			player1.setbWordFound(false);
		}
	}

}