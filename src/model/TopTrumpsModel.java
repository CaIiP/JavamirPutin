package model;

import java.util.ArrayList;
import java.util.Random;

import controller.DeckController;
import controller.RoundController;

public class TopTrumpsModel {
	//	//Instance variables
    //attributes
	private int no_cards;
	private String user_name = "Human";
	private ArrayList<Card> Deck;
	private Deck deck;
	private Player[] Players;
	private Player decidingPlayer; 
	private Player[] NewPlayers;
	private Game Game;
	private Round Round;
	private CommunalPile currentPile;
	private int numPlayers;
	private String prevRoundString;
	private boolean userWantsToQuit; // flag to check whether the user wants to quit the application
	private ArrayList<String> lines;
	private DeckController deckC;
	private String[] CompPlayerNames;
	private Random rand;
	private Database database = new Database();
	private GameStats gameStats;
	
	
//constructor
	public TopTrumpsModel(int no_cards, String user_name,Deck deck, ArrayList<Card> Deck, int numPlayers, String prevRoundString,
			boolean userWantsToQuit, ArrayList<String> lines, DeckController deckC, String[] compPlayerNames,
			Random rand) {
		super();
		this.no_cards = no_cards;
		this.user_name = user_name;
		this.deck = deck;
		this.Deck = Deck;
		this.numPlayers = numPlayers;
		this.prevRoundString = prevRoundString;
		this.userWantsToQuit = userWantsToQuit;
		this.lines = lines;
		this.deckC = deckC;
		CompPlayerNames = compPlayerNames;
		this.rand = rand;
	}
	
	public void statWrite(DTO dto)	{
		database.dbConnect();
		database.dbWriteStats(dto);
		database.dbDisconnect();
		
	}
	
	
	public void statView()	{
		database.dbConnect();
		gameStats = database.dbgetStats();
		System.out.println(gameStats);
		database.dbDisconnect();
	}

	// getters and setters
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @return the newPlayers
	 */
	public Player[] getNewPlayers() {
		return NewPlayers;
	}

	/**
	 * @param newPlayers the newPlayers to set
	 */
	public void setNewPlayers(Player[] newPlayers) {
		this.NewPlayers = newPlayers;
	}

	/**
	 * @return the numPlayers
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * @param numPlayers the numPlayers to set
	 */
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	/**
	 * @return the compPlayerNames
	 */
	public String[] getCompPlayerNames() {
		return CompPlayerNames;
	}

	/**
	 * @param compPlayerNames the compPlayerNames to set
	 */
	public void setCompPlayerNames(String[] compPlayerNames) {
		CompPlayerNames = compPlayerNames;
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return Players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(Player[] players) {
		Players = players;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public Player getDecidingPlayer() {
		return decidingPlayer;
	}

	public void setDecidingPlayer(Player decidingPlayer) {
		this.decidingPlayer = decidingPlayer;
	}

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * @return the no_cards
	 */
	public int getNo_cards() {
		return no_cards;
	}
	
	/**
	 * @return the deck
	 */
	public ArrayList<Card> getdeck() {
		return Deck;
	}

	/**
	 * @return the round
	 */
	public Round getRound() {
		return Round;
	}

	/**
	 * @param round the round to set
	 */
	public void setRound(Round round) {
		Round = round;
	}

	/**
	 * @return the userWantsToQuit
	 */
	public boolean isUserWantsToQuit() {
		return userWantsToQuit;
	}

	/**
	 * @param userWantsToQuit the userWantsToQuit to set
	 */
	public void setUserWantsToQuit(boolean userWantsToQuit) {
		this.userWantsToQuit = userWantsToQuit;
	}

	/**
	 * @return the currentPile
	 */
	public CommunalPile getCurrentPile() {
		return currentPile;
	}

	/**
	 * @param currentPile the currentPile to set
	 */
	public void setCurrentPile(CommunalPile currentPile) {
		this.currentPile = currentPile;
	}

	/**
	 * @return the prevRoundString
	 */
	public String getPrevRoundString() {
		return prevRoundString;
	}

	/**
	 * @param prevRoundString the prevRoundString to set
	 */
	public void setPrevRoundString(String prevRoundString) {
		this.prevRoundString = prevRoundString;
	}

	/**
	 * @return the game
	 */
	public Game getGame() {
		return Game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		Game = game;
	}

	/**
	 * @return the deckC
	 */
	public DeckController getDeckC() {
		return deckC;
	}

	/**
	 * @param deckC the deckC to set
	 */
	public void setDeckC(DeckController deckC) {
		this.deckC = deckC;
	}

	/**
	 * @return the lines
	 */
	public ArrayList<String> getLines() {
		return lines;
	}

	/**
	 * @param lines the lines to set
	 */
	public void setLines(ArrayList<String> lines) {
		this.lines = lines;
	}

	public void setNo_cards(int no_cards) {
		this.no_cards = no_cards;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
