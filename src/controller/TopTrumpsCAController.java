package controller;

import java.util.Scanner;

import commandline.TopTrumpsCLIApplication;
import model.Card;
import model.Player;
import model.Round;
import model.TopTrumpsModel;
import view.RoundView;
import view.TopTrumpsCAView;

public class TopTrumpsCAController {
	public void createplayers(TopTrumpsModel TopTrumps) {
		Player Human = new Player(TopTrumps.getUser_name());// object human
		TopTrumps.getNewPlayers()[0] = Human;

		for (int i = 1; i < TopTrumps.getNumPlayers(); i++) {
			TopTrumps.getNewPlayers()[i] = new Player(TopTrumps.getCompPlayerNames()[i - 1]);
		}
		TopTrumps.setPlayers(TopTrumps.getNewPlayers());
	}

	public Player decidingPlayer(TopTrumpsModel TopTrumps) {
		int decidingPlayerIndex = TopTrumps.getRand().nextInt(TopTrumps.getPlayers().length);

		return TopTrumps.getPlayers()[decidingPlayerIndex];

	}

	public static boolean isNumeric(String cadena) {
		boolean result;

		try {
			Integer.parseInt(cadena);
			result = true;
		} catch (NumberFormatException excepcion) {
			result = false;
		}

		return result;
	}

	// Function that is used for the human player to decide with what player
	// attribute in the current round
	public void UserPicking(TopTrumpsCLIApplication TopTrumps,TopTrumpsModel TopTrumpsModel) {
		// The user is requested to enter the corresponding values
		System.out.println(
				"Please choose what attribute you want to take for the round: Size choose 1, Speed choose 2, Range choose 3, FirePower choose 4, Cargo choose 5");
		String entradaTeclado;
		Scanner entradaEscaner = new Scanner(System.in);
		entradaTeclado = entradaEscaner.nextLine();

		if (isNumeric(entradaTeclado)) {
			switch (entradaTeclado) {
			case "1":
				playRound(1,TopTrumps,TopTrumpsModel);
				break;
			case "2":
				playRound(2,TopTrumps,TopTrumpsModel);
				break;
			case "3":
				playRound(3,TopTrumps,TopTrumpsModel);
				break;
			case "4":
				playRound(4,TopTrumps,TopTrumpsModel);
				break;
			case "5":
				playRound(5,TopTrumps,TopTrumpsModel);
				break;
			default:
				System.out.println("You must choose an attribute based on those available to play");
				UserPicking(TopTrumps,TopTrumpsModel);
				break;
			}
		} else {
			System.out.println("You must place a numeric value between the given values in order to play");
			UserPicking(TopTrumps,TopTrumpsModel);
		}
	}

	public void checkIfGameOver(TopTrumpsCLIApplication TopTrumps,TopTrumpsModel TopTrumpsModel) {
		int pass = 0;
		for (int i = 0; i < TopTrumpsModel.getNumPlayers(); i++) {
			Player user = TopTrumpsModel.getRound().getPlayers()[i];
			int length = user.getHand().length;
			if (length == 40) {
				System.out.println("Game over, Win " + user.getName());
				System.out.println(
						"If you want to play again option 1 if you want to show the statistics of the game option 2, if you select another option the game will end");
				String entradaTeclado;
				Scanner entradaEscaner = new Scanner(System.in);
				entradaTeclado = entradaEscaner.nextLine();
				if (isNumeric(entradaTeclado)) {
					if (Integer.parseInt(entradaTeclado) == 1) {
						TopTrumpsModel.setUserWantsToQuit(false);
					} else if (Integer.parseInt(entradaTeclado) == 2) {
						System.out.println("Show statistics here");
						TopTrumpsModel.setUserWantsToQuit(true);
					} else {
						TopTrumpsModel.setUserWantsToQuit(true);
					}
				}
				pass = 1;
				break;
			}
		}
		if (pass == 0) {
			if (TopTrumpsModel.getDecidingPlayer().getName().equals(TopTrumpsModel.getUser_name())) {
				UserPicking(TopTrumps,TopTrumpsModel);
			} else {
				playRound(0,TopTrumps,TopTrumpsModel);
			}
		}
	}

	public void playRound(int trumpIndex,TopTrumpsCLIApplication TopTrumps,TopTrumpsModel TopTrumpsModel) {
		Round CurrRound;
		RoundController roundC = new RoundController();
		RoundView roundV = new RoundView();
		CurrRound = new Round(TopTrumpsModel.getPlayers(), TopTrumpsModel.getDecidingPlayer(), TopTrumpsModel.getCurrentPile(), trumpIndex, TopTrumpsModel.getDeck(), TopTrumpsModel.getNo_cards());
		if (trumpIndex == 0) {
			CurrRound.setIndex(roundC.getIndex(TopTrumpsModel.getDecidingPlayer(), CurrRound.getATTR()));
		} else {
			CurrRound.setIndex(trumpIndex);
		}

		TopTrumpsModel.setRound(CurrRound);
		roundC.saveValues(TopTrumpsModel.getRound().getPlayers(), TopTrumpsModel.getRound().getIndex(), TopTrumpsModel.getRound().getPrevValues());
		roundV.startHovering(TopTrumpsModel.getRound());
		TopTrumpsModel.setCurrentPile(TopTrumpsModel.getRound().getPile());
		if (!TopTrumpsModel.getRound().isDraw()) {
			TopTrumpsModel.setDecidingPlayer(TopTrumpsModel.getRound().getWinner());
		}
		TopTrumpsCAView TopTrumpsCAView = new TopTrumpsCAView();
		TopTrumpsCAView.WhoseTurn(TopTrumpsModel);
		
		System.out.println("Cards in pile: " + TopTrumpsModel.getRound().getPile().getCards().length);

		TopTrumpsModel.setPrevRoundString(roundV.getRoundString(TopTrumpsModel.getRound()));
		String displayText = TopTrumpsModel.getPrevRoundString();
		System.out.println(displayText);
		if (TopTrumpsModel.getRound().isDraw()) {
			TopTrumpsModel.getGame().setNumDraws(TopTrumpsModel.getGame().getNumDraws() + 1);
		}
		TopTrumpsModel.getGame().setNumRounds(TopTrumpsModel.getGame().getNumRounds() + 1);

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

		this.checkIfGameOver(TopTrumps,TopTrumpsModel);
	}

}
