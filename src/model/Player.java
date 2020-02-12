package model;

public class Player {
	//Instance variables
    //attributes
	private Card[] hand;
	private String name;
	private boolean keepPlaying;
	private boolean humanCheck;
	private int numPlayers;
	private Player decidingPlayer;
	private Player[] players;
	private Player[] newPlayers;
	private String user_name;
//	private boolean userWantsToQuit;


	// Constructor
	public Player(String name) {
		this.name = name;
		this.hand = new Card[0];
		this.keepPlaying = true;
		this.humanCheck = true;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public Card[] getHand() {
		return hand;
	}

	public void setHand(Card[] hand) {
		this.hand = hand;
	}

	public boolean isKeepPlaying() {
		return keepPlaying;
	}

	public void setKeepPlaying(boolean keepPlaying) {
		this.keepPlaying = keepPlaying;
	}
	
	public boolean getHumanCheck()	{
		return humanCheck;
	}
	
	public int getNumPlayers() {
		return numPlayers;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public Player getDecidingPlayer() {
		return decidingPlayer;
	}

	public void setDecidingPlayer(Player decidingPlayer) {
		this.decidingPlayer = decidingPlayer;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Player[] getNewPlayers() {
		return newPlayers;
	}

	public void setNewPlayers(Player[] newPlayers) {
		this.newPlayers = newPlayers;
	}
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
