package controller;

import java.util.Scanner;


import model.Card;
import model.Player;
import model.Round;
import model.TestLog;
import model.TopTrumpsModel;
import model.DTO;
import view.RoundView;
import view.TopTrumpsCAView;


public class TopTrumpsCAController {
	DTO dto = new DTO(0, 0, 0, 0, 0, 0, 0, 0);
	int decidingPlayerIndex;
	private TestLog TestLog = new TestLog();
	private boolean writeGameLogsToFile;
	
	public TopTrumpsCAController(boolean writeGameLogsToFile) {
		this.writeGameLogsToFile = writeGameLogsToFile;
	}

	//method to create both computer and human players
	public void createplayers(TopTrumpsModel TopTrumps) {
		Player human = new Player(TopTrumps.getUser_name());// object human
		TopTrumps.getNewPlayers()[0] = human;
		for (int i = 1; i < TopTrumps.getNumPlayers(); i++) {
			TopTrumps.getNewPlayers()[i] = new Player(TopTrumps.getCompPlayerNames()[i - 1]);
		}
		TopTrumps.setPlayers(TopTrumps.getNewPlayers());
	}
	
	public Player getRandomPlayer(TopTrumpsModel TopTrumps) {
		decidingPlayerIndex = TopTrumps.getRand().nextInt(TopTrumps.getPlayers().length);
		return TopTrumps.getPlayers()[decidingPlayerIndex];
	}
	
	public Player getDecidingPlayer(TopTrumpsModel TopTrumps) {
		return TopTrumps.getPlayers()[decidingPlayerIndex];
	}
	
	//method to check if a string is a number
	public static boolean isNumeric(String s) {
		boolean result;
		try {
			Integer.parseInt(s);
			result = true;
		} catch (NumberFormatException excepcion) {
			result = false;
		}

		return result;
	}

	//method which allows the human player to select their desired card attribute
	public void UserPicking(TopTrumpsModel TopTrumpsModel ) {
		// The user is requested to enter the corresponding values
		System.out.println(
				"Please choose what attribute you want to take for the round: Size choose 1, Speed choose 2, Range choose 3, FirePower choose 4, Cargo choose 5");
		String attInput;
		Scanner attScanner = new Scanner(System.in);
		attInput = attScanner.nextLine();
		if (isNumeric(attInput)) {
			switch (attInput) {
			case "1":
				playRound(1,TopTrumpsModel);
				break;
			case "2":
				playRound(2,TopTrumpsModel);
				break;
			case "3":
				playRound(3,TopTrumpsModel);
				break;
			case "4":
				playRound(4,TopTrumpsModel);
				break;
			case "5":
				playRound(5,TopTrumpsModel);
				break;
			default:
				System.out.println("You must choose an attribute based on those available to play");
				UserPicking(TopTrumpsModel);
				break;
			}
		} else {
			System.out.println("You must place a numeric value between the given values in order to play");
			UserPicking(TopTrumpsModel);
		}
	}

	//method that checks if the game is over
	public void checkIfGameOver(TopTrumpsModel TopTrumpsModel) {
		int pass = 0;
		for (int i = 0; i < TopTrumpsModel.getNumPlayers(); i++) {
			Player user = TopTrumpsModel.getRound().getPlayers()[i];
			int length = user.getHand().length;
			if (length == 40) {
				System.out.println("Game over, Win " + user.getName());
				if (user.getName() == "Human")	{
					dto.setHumanWins(dto.getHumanWins() + 1);
				}
				else if (user.getName() == "BotOne")	{
					dto.setBot1wins(dto.getBot1wins() + 1);
				}
				else if (user.getName() == "BotTwo")	{
					dto.setBot2wins(dto.getBot2wins() + 1);
				}
				else if (user.getName() == "BotThree")	{
					dto.setBot3wins(dto.getBot3wins() + 1);
				}
				else {
					dto.setBot4wins(dto.getBot4wins() + 1);
				}
				System.out.println("If you want to play again please press 1. If you want to show the statistics of the game please press 2.");
				dto.setGameCounter(dto.getGameCounter()+1);		//increase gameCounter by 1 with each win

				
				//turn into endGameOptions
				String newGameInput;
				Scanner newGameScanner = new Scanner(System.in);
				newGameInput = newGameScanner.nextLine();
				if (isNumeric(newGameInput)) {
					if (Integer.parseInt(newGameInput) == 1) {
						TopTrumpsModel.setUserWantsToQuit(false);
					} else if (Integer.parseInt(newGameInput) == 2) {
						System.out.println("Show statistics here");
						TopTrumpsModel.statWrite(dto);
						TopTrumpsModel.statView();
						TopTrumpsModel.setUserWantsToQuit(true);
					} else {
						TopTrumpsModel.setUserWantsToQuit(true);
					}
				}
				pass = 1;
				break;
			}
		}
		
		//turn into nextStage method
		if (pass == 0) {
			if (TopTrumpsModel.getDecidingPlayer().getName().equals(TopTrumpsModel.getUser_name())) {
				UserPicking(TopTrumpsModel);
			} else {
				System.out.print("Press ENTER to continue to next round");
				new Scanner(System.in).nextLine();
			playRound(0,TopTrumpsModel);
			}
		}
	}

	//method that contains all logic for the round of a game
	public void playRound(int trumpIndex,TopTrumpsModel TopTrumpsModel) {
		Round CurrRound;
		RoundController roundC = new RoundController();
		RoundView roundV = new RoundView();
		
		//
		CurrRound = new Round(TopTrumpsModel.getPlayers(), TopTrumpsModel.getDecidingPlayer(), TopTrumpsModel.getCurrentPile(), trumpIndex, TopTrumpsModel.getDeck(), TopTrumpsModel.getNo_cards());
		if (trumpIndex == 0) {
			CurrRound.setIndex(roundC.getIndex(TopTrumpsModel.getDecidingPlayer(), CurrRound.getATTR()));
		} else {
			CurrRound.setIndex(trumpIndex);
		}

		TopTrumpsModel.setRound(CurrRound);
		roundC.saveValues(TopTrumpsModel.getRound().getPlayers(), TopTrumpsModel.getRound().getIndex(), TopTrumpsModel.getRound().getPrevValues());
		//log each players hand after round 
		TestLog.logUsersHand(TopTrumpsModel,  writeGameLogsToFile);
		roundV.startHovering(TopTrumpsModel.getRound());
		TestLog.logcurrentCardsInPlay(TopTrumpsModel, writeGameLogsToFile);
		TestLog.logCategorySelected(TopTrumpsModel, writeGameLogsToFile);
		TestLog.logCommonPile(TopTrumpsModel, writeGameLogsToFile);
	
		TopTrumpsModel.setCurrentPile(TopTrumpsModel.getRound().getPile());
		if (!TopTrumpsModel.getRound().isDraw()) {
			TopTrumpsModel.setDecidingPlayer(TopTrumpsModel.getRound().getWinner());
		}
		TopTrumpsCAView TopTrumpsCAView = new TopTrumpsCAView();
		TopTrumpsCAView.WhoseTurn(TopTrumpsModel);

		System.out.println("Cards in pile: " + TopTrumpsModel.getRound().getPile().getCards().length);

		TopTrumpsModel.setPrevRoundString(roundV.getRoundString(TopTrumpsModel.getRound()));
		
		TestLog.logWinner(TopTrumpsModel, writeGameLogsToFile);
		
		String displayText = TopTrumpsModel.getPrevRoundString();
		System.out.println(displayText);
		if (TopTrumpsModel.getRound().isDraw()) {
			TopTrumpsModel.getGame().setNumDraws(TopTrumpsModel.getGame().getNumDraws() + 1);
			dto.setDrawCounter(dto.getDrawCounter() + 1);	//Increases draw counter by 1 every time there is a draw
		}
		TopTrumpsModel.getGame().setNumRounds(TopTrumpsModel.getGame().getNumRounds() + 1);
		dto.setRoundCounter(dto.getRoundCounter() + 1);		//Increases round counter by 1 every time a round ends


		Player user = TopTrumpsModel.getPlayers()[0];
		String UserCardInfo;
		if (user.getHand().length == 0) {
			String s = String.format(TopTrumpsModel.getUser_name() + " have no cards left.\n\n");
			UserCardInfo = s;
		} else {
			Card UserCurrentCard = user.getHand()[0];
			String CardDescription = String.format("%s%n", UserCurrentCard.getName());
			String CardAttribute1 = String.format("%s: %s   ", TopTrumpsModel.getDeck().getSize(), UserCurrentCard.getSize());
			String CardAttribute2 = String.format("%s: %s   ", TopTrumpsModel.getDeck().getSpeed(), UserCurrentCard.getSpeed());
			String CardAttribute3 = String.format("%s: %s   ", TopTrumpsModel.getDeck().getRange(), UserCurrentCard.getRange());
			String CardAttribute4 = String.format("%s: %s   ", TopTrumpsModel.getDeck().getFirepower(),
					UserCurrentCard.getFirepower());
			String CardAttribute5 = String.format("%s: %s   %n%n", TopTrumpsModel.getDeck().getCargo(), UserCurrentCard.getCargo());
			UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 + CardAttribute3 + CardAttribute4
					+ CardAttribute5;
		}
		System.out
		.println("Cards left in hand: " + TopTrumpsModel.getPlayers()[0].getHand().length + "\nCurrent card: " + UserCardInfo);
		switch (TopTrumpsModel.getPlayers().length) {
		case 2:
			System.out.println("Bot 1 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[1].getHand().length);
			break;
		case 3:
			System.out.println("Bot 1 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[2].getHand().length);
			break;
		case 4:
			System.out.println("Bot 1 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[2].getHand().length);
			System.out.println("Bot 3 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[3].getHand().length);
			break;
		case 5:
			System.out.println("Bot 1 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[2].getHand().length);
			System.out.println("Bot 3 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[3].getHand().length);
			System.out.println("Bot 4 Cards left in hand:\n" + TopTrumpsModel.getPlayers()[4].getHand().length);
			break;
		}
		this.checkIfGameOver(TopTrumpsModel);
	
		
	}
	public TestLog getTestLog() {
		return TestLog;
	}

}
