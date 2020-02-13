package commandline;

import model.Card;
import model.CommunalPile;
import model.Game;
import model.Player;
import model.TopTrumpsModel;
import view.TopTrumpsCAView;
import model.Deck;

import java.util.ArrayList;
import java.util.Random;

import controller.Controller;
import controller.DeckController;
import controller.PlayerController;
import controller.TopTrumpsCAController;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {
	private static ArrayList<Card> Deck;
	private static String[] CompPlayerNames = { "BotOne", "BotTwo", "BotThree", "BotFour" };

	// main
	public static void main(String[] args) {
		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true")) {
			writeGameLogsToFile = true; // Command line selection
		}
		TopTrumpsModel TopTrumpsModel = new TopTrumpsModel(40,"Human",new Deck(Deck, "Size", "Speed", "Range", "FirePower", "Cargo"),new ArrayList<Card>(),5,"",false,new ArrayList<String>(),new DeckController(),CompPlayerNames,new Random());
		TopTrumpsCLIApplication TopTrumps = new TopTrumpsCLIApplication();
		
																											
		// Loop until the user wants to exit the game
		int index = 0;
		while (!TopTrumpsModel.isUserWantsToQuit()) {
			if(index != 0) {
				TopTrumps = new TopTrumpsCLIApplication();// The class
			//	TopTrumpsModel = new TopTrumpsModel(40,"Human",new Deck(Deck, "Size", "Speed", "Range", "FirePower", "Cargo"),new ArrayList<Card>(),5,"",true,new ArrayList<String>(),new DeckController(),CompPlayerNames,new Random());
			}
			
			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			TopTrumpsModel.setUserWantsToQuit(true);
			Controller C = new Controller(5); //start game with 5 players 
			index++;
		}
	}

	
	
	
	
	

}

