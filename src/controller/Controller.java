package controller;

import model.Card;
import model.CommunalPile;
import model.Game;
import model.Player;
import model.TopTrumpsModel;
import view.TopTrumpsCAView;
import model.Deck;

import java.util.ArrayList;
import java.util.Random;


public class Controller {
	private static ArrayList<Card> Deck;
	private static String[] CompPlayerNames = { "BotOne", "BotTwo", "BotThree", "BotFour" };
	private TopTrumpsModel TopTrumpsModel = new TopTrumpsModel(40,"Human",new Deck(Deck, "Size", "Speed", "Range", "FirePower", "Cargo"),new ArrayList<Card>(),5,"",false,new ArrayList<String>(),new DeckController(),CompPlayerNames,new Random());
	private TopTrumpsCAController TopTrumpsCAController = new TopTrumpsCAController();
	
	private TopTrumpsCAView TopTrumpsCAView = new TopTrumpsCAView();
	private PlayerController playerC = new PlayerController();

	public Controller(int x) {

		TopTrumpsModel.setPrevRoundString("");// String variable that is used to show the results of the rounds that are
		TopTrumpsModel.getDeckC().generateDeck(TopTrumpsModel.getLines(), TopTrumpsModel.getdeck());
		TopTrumpsModel.getDeckC().shuffleDeck(TopTrumpsModel.getdeck()); // given
		TopTrumpsModel.setGame(new Game(0, 0)); // An object of the Game class is created
		TopTrumpsModel.setNumPlayers(x); // In this variable it is indicated how many players will be in the game,
		// including the human if this were the option chosen

		//creates array of players 
		TopTrumpsModel.setNewPlayers(new Player[TopTrumpsModel.getNumPlayers()]); // The variable that will handle all the players of
		// the new game is created.
		TopTrumpsCAController.createplayers(TopTrumpsModel);
		//picks first player
		TopTrumpsModel.setDecidingPlayer(TopTrumpsCAController.decidingPlayer(TopTrumpsModel)); 
		//sends first player to view
		TopTrumpsCAView.WhoseTurn(TopTrumpsModel);
		//creates common pile
		TopTrumpsModel.setCurrentPile(new CommunalPile());

		//dealing the cards 
		for (int i = 0; i < TopTrumpsModel.getNo_cards(); i++) {
			Player p = TopTrumpsModel.getPlayers()[i % TopTrumpsModel.getNumPlayers()];
			playerC.giveCard(TopTrumpsModel.getdeck().get(i), p);
		}
		//shows humans current card
		TopTrumpsCAView.showCurrentCard(TopTrumpsModel);
		//if human go to user picking
		//if bot go to play round
		if (TopTrumpsModel.getDecidingPlayer().getName().equals(TopTrumpsModel.getUser_name())) {
			TopTrumpsCAController.UserPicking(TopTrumpsModel);
		} else {
			TopTrumpsCAController.playRound(0,TopTrumpsModel);
		}
		TopTrumpsCAView.CardsBelonging(TopTrumpsModel);
	}

}
