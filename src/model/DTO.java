package model;

public class DTO {
	private int gameCounter;
	private int roundCounter;
	private int humanWins;
	private int bot1Wins;
	private int bot2Wins;
	private int bot3Wins;
	private int bot4Wins;
	private int drawCounter;

	public DTO(int gc, int rc, int hw, int b1w, int b2w, int b3w, int b4w, int dc)	{
		this.gameCounter = gc;
		this.roundCounter = rc;
		this.humanWins = hw;
		this.bot1Wins = b1w;
		this.bot2Wins = b2w;
		this.bot3Wins = b3w;
		this.bot4Wins = b4w;
		this.drawCounter = dc;
	}

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
	public int getBot1wins() {
		return bot1Wins;
	}
	public void setBot1wins(int bot1wins) {
		this.bot1Wins = bot1wins;
	}
	public int getBot2wins() {
		return bot2Wins;
	}
	public void setBot2wins(int bot2wins) {
		this.bot2Wins = bot2wins;
	}
	public int getBot3wins() {
		return bot3Wins;
	}
	public void setBot3wins(int bot3wins) {
		this.bot3Wins = bot3wins;
	}
	public int getBot4wins() {
		return bot4Wins;
	}
	public void setBot4wins(int bot4wins) {
		this.bot4Wins = bot4wins;
	}
	public int getDrawCounter() {
		return drawCounter;
	}
	public void setDrawCounter(int drawCounter) {
		this.drawCounter = drawCounter;
	}
}

