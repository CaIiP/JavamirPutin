package controller;

import model.Card;

import model.CommunalPile;
import model.Game;
import model.Player;
import model.TopTrumpsModel;
import view.TopTrumpsCAView;
import model.Deck;
import model.TestLog;
import java.util.ArrayList;
import java.util.Random;


public class Controller {
	//attributes 
	private static ArrayList<Card> Deck;
	private static String[] CompPlayerNames = { "BotOne", "BotTwo", "BotThree", "BotFour" };
	private TopTrumpsModel topTrumpsModel = new TopTrumpsModel(40,"Human",new Deck(Deck, "Size", "Speed", "Range", "FirePower", "Cargo"),new ArrayList<Card>(),5,"",false,new ArrayList<String>(),new DeckController(),CompPlayerNames,new Random());
	private TopTrumpsCAController topTrumpsCAController;
	private RoundController roundC = new RoundController();
	private TopTrumpsCAView TopTrumpsCAView = new TopTrumpsCAView();
	private PlayerController playerC = new PlayerController();
	private boolean writeGameLogsToFile;
	
	//testlog 

	
	//constructor 
	public Controller(int x, boolean writeGameLogsToFile) {

	
		topTrumpsModel.setPrevRoundString("");// String variable that is used to show the results of the rounds that are
		topTrumpsModel.getDeckC().generateDeck(topTrumpsModel.getLines(), topTrumpsModel.getdeck());
		topTrumpsCAController = new TopTrumpsCAController(writeGameLogsToFile);
		topTrumpsCAController.getTestLog().logDeck(topTrumpsModel, writeGameLogsToFile);
		
		topTrumpsModel.getDeckC().shuffleDeck(topTrumpsModel.getdeck());
		topTrumpsCAController.getTestLog().logShuffledDeck(topTrumpsModel, writeGameLogsToFile);// given
		
		topTrumpsModel.setGame(new Game(0, 0)); // An object of the Game class is created
		topTrumpsModel.setNumPlayers(x); // In this variable it is indicated how many players will be in the game,
		// including the human if this were the option chosen

	
		//creates array of players 
		topTrumpsModel.setNewPlayers(new Player[topTrumpsModel.getNumPlayers()]); // The variable that will handle all the players of
		// the new game is created.
		topTrumpsCAController.createplayers(topTrumpsModel);
		//picks first player
		topTrumpsModel.setDecidingPlayer(topTrumpsCAController.getRandomPlayer(topTrumpsModel)); 
		//sends first player to view
		TopTrumpsCAView.WhoseTurn(topTrumpsModel);
		//creates common pile
		topTrumpsModel.setCurrentPile(new CommunalPile());

		
		//dealing the cards 
		for (int i = 0; i < topTrumpsModel.getNo_cards(); i++) {
			Player p = topTrumpsModel.getPlayers()[i % topTrumpsModel.getNumPlayers()];
			playerC.giveCard(topTrumpsModel.getdeck().get(i), p);
		}
	
	}
	public void playingGame() {
		//shows humans current card
		TopTrumpsCAView.showCurrentCard(topTrumpsModel);
		//if human go to user picking
		//if bot go to play round

		if (topTrumpsModel.getDecidingPlayer().getName().equals(topTrumpsModel.getUser_name())) {
			topTrumpsCAController.UserPicking(topTrumpsModel);
		} else {

			topTrumpsCAController.playRound(0,topTrumpsModel);
		}

		TopTrumpsCAView.CardsBelonging(topTrumpsModel);
		//topTrumpsCAController.getTestLog().logUsersHand(topTrumpsModel);
	}

	public TopTrumpsCAController getCAController()	{
		return topTrumpsCAController;
	}

	public TopTrumpsModel getTopTrumpsModel()	{
		return topTrumpsModel;
	}
	public boolean getWriteGameLogsToFile() {
		return writeGameLogsToFile;
		
	}
}
