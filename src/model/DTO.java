package model;

public class DTO {
	private int gameCounter;
	private int roundCounter;
	private int humanWins;
	private int botWins;
	private int drawCounter;
	
	
	public int getGameCounter() {
		return gameCounter;
	}
	public void setGameCounter(int gameCounter) {
		this.gameCounter = gameCounter;
	}
	public int getRoundCounter() {
		return roundCounter;
	}
	public void setRoundCounter(int roundCounter) {
		this.roundCounter = roundCounter;
	}
	public int getHumanWins() {
		return humanWins;
	}
	public void setHumanWins(int humanWins) {
		this.humanWins = humanWins;
	}
	public int getBotWins() {
		return botWins;
	}
	public void setBotWins(int botWins) {
		this.botWins = botWins;
	}
	public int getDrawCounter() {
		return drawCounter;
	}
	public void setDrawCounter(int drawCounter) {
		this.drawCounter = drawCounter;
	}
}

