package model;

public class GameStats {
	private int drawAvg;
	private int largestRoundNum;
	private int humanWins;
	private int botWins;
	private int totalNumGames;
	
	public int getDrawAvg() {
		return drawAvg;
	}
	public void setDrawAvg(int drawAvg) {
		this.drawAvg = drawAvg;
	}
	public int getLargestRoundNum() {
		return largestRoundNum;
	}
	public void setLargestRoundNum(int largestRoundNum) {
		this.largestRoundNum = largestRoundNum;
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
	public int getTotalNumGames() {
		return totalNumGames;
	}
	public void setTotalNumGames(int totalNumGames) {
		this.totalNumGames = totalNumGames;
	}
}

