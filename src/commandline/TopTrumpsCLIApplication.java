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
				TopTrumpsModel = new TopTrumpsModel(40,"Human",new Deck(Deck, "Size", "Speed", "Range", "FirePower", "Cargo"),new ArrayList<Card>(),5,"",true,new ArrayList<String>(),new DeckController(),CompPlayerNames,new Random());
			}
			
			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			TopTrumpsModel.setUserWantsToQuit(true);
			TopTrumpsModel.setPrevRoundString("");// String variable that is used to show the results of the rounds that are
			TopTrumpsModel.getDeckC().generateDeck(TopTrumpsModel.getLines(), TopTrumpsModel.getdeck());
			TopTrumpsModel.getDeckC().shuffleDeck(TopTrumpsModel.getdeck()); // given
			TopTrumpsModel.setGame(new Game(0, 0)); // An object of the Game class is created
			TopTrumpsModel.setNumPlayers(5); // In this variable it is indicated how many players will be in the game,
										// including the human if this were the option chosen
			
			TopTrumpsCAController TopTrumpsCAController = new TopTrumpsCAController();
			TopTrumpsModel.setNewPlayers(new Player[TopTrumpsModel.getNumPlayers()]); // The variable that will handle all the players of
			// the new game is created.
			TopTrumpsCAController.createplayers(TopTrumpsModel);
			TopTrumpsModel.setDecidingPlayer(TopTrumpsCAController.decidingPlayer(TopTrumpsModel)); 
			
			
			TopTrumpsCAView TopTrumpsCAView = new TopTrumpsCAView();
			TopTrumpsCAView.WhoseTurn(TopTrumpsModel);
			TopTrumpsModel.setCurrentPile(new CommunalPile());
			
			PlayerController playerC = new PlayerController();
			for (int i = 0; i < TopTrumpsModel.getNo_cards(); i++) {
				Player p = TopTrumpsModel.getPlayers()[i % TopTrumpsModel.getNumPlayers()];
				playerC.giveCard(TopTrumpsModel.getdeck().get(i), p);
			}
			
			TopTrumpsCAView.showCurrentCard(TopTrumpsModel);

			if (TopTrumpsModel.getDecidingPlayer().getName().equals(TopTrumpsModel.getUser_name())) {
				TopTrumpsCAController.UserPicking(TopTrumps,TopTrumpsModel);
			} else {
				TopTrumpsCAController.playRound(0,TopTrumps,TopTrumpsModel);
			}
			TopTrumpsCAView.CardsBelonging(TopTrumpsModel);
			index++;
		}
	}

	
	
	
	
	

}
