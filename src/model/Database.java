package model;
import java.sql.*;

public class Database {
	private Connection connection = null;
	Statement statement = null;

	//database connection information
	private String username = "m_19_2040455p";
	private String password = "2040455p";
	private String dbURL = "jdbc:postgresql://yacata.dcs.gla.ac.uk:5432";
	
	//variables for writing stats to database
	private int totalGames;
	private int totalDraws;
	private int totalRounds;
	private int totalHumanWins;
	private int totalBot1Wins;
	private int totalBot2Wins;
	private int totalBot3Wins;
	private int totalBot4Wins;
	
	//SQL query for writing stats to database
	String Q_writeStats = "INSERT INTO game_stats VALUES(" + totalGames + ", " + totalDraws + ", " + totalRounds + ", " + totalHumanWins + ", " + totalBot1Wins + ", " + totalBot2Wins + ", " + totalBot3Wins + ", " + totalBot4Wins+ ")";

	//variables for getting stats from database
	private int	gDrawAvg = 0;
	private int gLargestRoundNum = 0;
	private int gHumanWins = 0;
	private int gBotWins = 0;
	private int gTotalNumGames = 0;
	
	//variables for storing stats from database
	private int drawAvg = 0;
	private int largestRoundNum = 0;
	private int humanWins = 0;
	private int botWins = 0;
	private int totalNumGames = 0;

	//SQL queries for retrieving stats from database
	String Q_getGamesPlayed = "SELECT COUNT (game_total) AS totalGames FROM game_stats";
	String Q_getBotWins = "SELECT COUNT (bot_win_total) AS botTotal FROM game_stats";
	String Q_getHumanWins = "SELECT COUNT (human_win_total) AS humanTotal FROM game_stats";
	String Q_getAvgDrawNum = "SELECT AVG(draw_total) AS drawAverage FROM game_stats";
	String Q_getLongestGame = "SELECT MAX(rounds_in_game) AS mostRounds FROM game_stats";
	

	public Connection dbConnect()	{	//Method that connects to database
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbURL, username, password);
		}
		catch (SQLException e) {
			System.out.println("Database connection failed");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Database connection failed");
		}
		if (connection != null) {
			System.out.println("Database connection successful");
		}
		else {
			System.out.println("Database connection failed");
		}
		return connection;
	}

	public void dbDisconnect()	{	//method that disconnects from database
		try	{
			connection.close();
		} 
		catch (SQLException e)	{
			System.out.println("Disconnection from database failed");
		}	
	}

	public void dbWriteStats (DTO dto)	{	//writes game statistics to database

		totalGames = dto.getGameCounter();	//total number of games played
		totalDraws = dto.getDrawCounter();		//total number of draws in a game
		totalRounds = dto.getRoundCounter();	//total number of rounds in a game
		totalHumanWins = dto.getHumanWins();		//total number of human player wins
		totalBot1Wins = dto.getBot1wins();			//total number of bot 1 wins
		totalBot2Wins = dto.getBot2wins();			//total number of bot 2 wins
		totalBot3Wins = dto.getBot3wins();			//total number of bot 3 wins
		totalBot4Wins = dto.getBot4wins();			//total number of bot 4 wins
		
		try	{
			statement = connection.createStatement();
			statement.executeUpdate(Q_writeStats);
			statement.close();
		}
		catch (Exception e)	{
		}
	}

	public GameStats dbgetStats ()	{	//calls methods which pull stats from database and sets variables to the corresponding database values
		GameStats gs = new GameStats();
		try	{
			drawAvg = getDrawAvg();
			largestRoundNum = getLongestGame();
			humanWins = getHumanWins();
			botWins = getBotWins();
			totalNumGames = getGamesPlayed();
		}
		catch (Exception e)	{	
			
		}
		gs.setDrawAvg(drawAvg);
		gs.setLargestRoundNum(largestRoundNum);
		gs.setHumanWins(humanWins);
		gs.setBotWins(botWins);
		gs.setTotalNumGames(totalNumGames);
		
		return gs;
	}

	public int getBotWins()	{	//gets the total number of non-human player wins from database
		try	{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Q_getBotWins);		
			while(rs.next())	{
				gBotWins = rs.getInt("botTotal");
			}
		}
		catch (SQLException e)	{

		}
		return gBotWins;
	}

	public int getHumanWins() {	//gets the total number of human player wins from database
		try	{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Q_getHumanWins);
			while(rs.next())	{
				gHumanWins = rs.getInt("humanTotal");
			}
		}
		catch (SQLException e)	{

		}
		return gHumanWins;
	}

	public int getGamesPlayed() {	//gets the total number of games played from database
		try	{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Q_getGamesPlayed);
			while(rs.next())	{
				gTotalNumGames = rs.getInt("totalGames");
			}
		}
		catch (SQLException e)	{

		}
		return gTotalNumGames;
	}

	public int getDrawAvg()	{	//gets the average number of rounds which end in a draw from database
		try	{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Q_getAvgDrawNum);
			while(rs.next())	{
				gDrawAvg = rs.getInt("drawAverage");
			}
		}
		catch (SQLException e)	{

		}
		return gDrawAvg;
	}

	public int getLongestGame() {	//gets how many rounds were played in the longest game from database
		try	{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Q_getLongestGame);
			while(rs.next())	{
				gLargestRoundNum = rs.getInt("mostRounds");
			}
		}
		catch (SQLException e)	{

		}	
		return gLargestRoundNum;
	}
}