package commandline;

import model.Card;
import model.CommunalPile;
import model.Deck;
import model.Game;
import model.Player;
import model.Round;
import model.DTO;
import model.Database;
import view.RoundView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import controller.DeckController;
import controller.PlayerController;
import controller.RoundController;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	private ArrayList<Card> Deck = new ArrayList<Card>();
	private boolean userWantsToQuit; // flag to check whether the user wants to quit the application
	private ArrayList<String> lines = new ArrayList<String>();
	
	//initialise controllers
	private DeckController deckC;
	private RoundController roundC;
	private PlayerController playerC;
	
	//initialise models
	private model.Player p;
	private model.Round r;
	


	// main
	public static void main(String[] args) {
		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		//				if (args[0].equalsIgnoreCase("true"))
		writeGameLogsToFile = true; // Command line selection
		RoundController TopTrumps = new RoundController("StarCitizenDeck.txt", "Human", 40);// The class
		// // played
		// Loop until the user wants to exit the game
		int index = 0;
		while (!TopTrumps.userWantsToQuit) {
			if(index != 0) {
				TopTrumps = new RoundController("StarCitizenDeck.txt", "Human", 40);// The class
			}

			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			TopTrumps.userWantsToQuit = true;
			TopTrumps.prevRoundString = "";// String variable that is used to show the results of the rounds that are
			TopTrumps.deckC.generateDeck(TopTrumps.lines, TopTrumps.Deck);
			TopTrumps.deckC.shuffleDeck(TopTrumps.Deck); // given
			TopTrumps.Game = new Game(0, 0); // An object of the Game class is created
			/*
			 * System.out.println
			 * ("Please choose with how many players you want to play between 2 and 5.");
			 * String entradaTeclado; Scanner entradaEscaner = new Scanner (System.in);
			 * entradaTeclado = entradaEscaner.nextLine (); if(isNumeric(entradaTeclado)){
			 * if(entradaTeclado == "1"){ System.out.println
			 * ("Please choose with how many players you want to play between 2 and 5.");
			 * TopTrumps.userWantsToQuit=true; } else if(Integer.parseInt(entradaTeclado) >
			 * 5){ System.out.println ("You cannot play more than 5 players");
			 * TopTrumps.userWantsToQuit=true; }else{
			 */

			TopTrumps.currentPile = new CommunalPile();


				index++;
			}
		}

	private void checkIfGameOver() {
		int pass = 0;
		for (int i = 0; i < this.p.getNumPlayers(); i++) {
			Player user = this.r.getRound().getPlayers()[i];
			int length = user.getHand().length;
			if (length == 40) {
				System.out.println("Game over, the winner is " + user.getName());
				//dto.setGameCounter(dto.getGameCounter() + 1); //revisit, method to increase gameCounter by 1 when game is over
				if (user.getHumanCheck() == true)	{
					//dto.setHumanWins(dto.getHumanWins()+1); //revisit, method to increase human win counter when game is won by human player
				}
				else {
					//dto.setBotWins(dto.getBotWins()+1);	//revisit, method to increase bot win counter when game is won by bot player
				}
				//database.dbWriteStats(dto);		//method to write stats to database at end of game
				System.out.println("If you want to play again, please select option 1. If you want to show the statistics of the game, please select option 2. If you select another option the game will end");
				String entradaTeclado; Scanner entradaEscaner = new Scanner (System.in);
				entradaTeclado = entradaEscaner.nextLine (); 
				if(roundC.isNumeric(entradaTeclado)){
					switch (entradaTeclado) {
					case "1":
						this.userWantsToQuit=false; 
						break;
					case "2":
						System.out.println ("Show statistics here");
//						System.out.println(database.dbgetStats()); //revisit, gets stats from database when show statistics is selected
						this.userWantsToQuit = true;
						break;
					default:
						System.out.println("You must choose an attribute based on those available to play");
						entradaEscaner.close();
						roundC.UserPicking();
						break;



						//if(Integer.parseInt(entradaTeclado) == 1){ 
						//this.userWantsToQuit=false; 
						//} else if(Integer.parseInt(entradaTeclado) == 2){ 
						//System.out.println ("Show statistics here");
						//System.out.println(database.dbgetStats()); //revisit, gets stats from database when show statistics is selected
						//this.userWantsToQuit = true;
						//}else{
						//this.userWantsToQuit = true;
					}
				}
				pass = 1;
				break;
			}
		}
		if (pass == 0) {
			if (p.getDecidingPlayer().getName().equals(p.getUser_name())) {
				UserPicking();
			} else {
				playRound(0);
			}
		}
	}

		checkIfGameOver();
	}
}
