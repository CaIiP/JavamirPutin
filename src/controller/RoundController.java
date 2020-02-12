package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Card;
import model.CommunalPile;
import model.Deck;
import model.Game;
import model.Player;
import model.Round;
import view.RoundView;

public class RoundController {
	private PlayerController playerC;
	
	//initialise models
	private model.Player p;
	private model.Round r;
	private model.Deck	d;
	private model.CommunalPile currentPile;
	private model.Game Game;
	
	private String deckFile;
		
	//Function that is used to know which attribute was chosen for the selected round and thus be able to value that attribute of the game cards	
	public int getIndex(Player decidingPlayer,int ATTR) {
		System.out.println(decidingPlayer.getName());// It shows that player was selected for this round as the main
		Card topCard = decidingPlayer.getHand()[0];//An object is created that will have the card to play right now by the main user of this round
		int AttributeIndex = 0;
		int AttributeValue = 0;
		for (int i = 0; i < ATTR; i++) {
			int Attribute = -1;
			if (i == 1) {
				Attribute = topCard.getSize();
			} else if (i == 2) {
				Attribute = topCard.getSpeed();
			} else if (i == 3) {
				Attribute = topCard.getRange();
			} else if (i == 4) {
				Attribute = topCard.getFirepower();
			} else if (i == 5) {
				Attribute = topCard.getCargo();
			}
			if (Attribute > AttributeValue) {
				AttributeValue = Attribute;
				AttributeIndex = i;
			}
		}
		return AttributeIndex;
	}
	
	public RoundController(String deckFile, String user_name, int no_cards)	{
		user_name = p.getUser_name();
		no_cards = r.getNo_cards();
		boolean userWantsToQuit;
	}
	
	public void playerCreation(int numPlayers)	{
		p.setNewPlayers(new Player[numPlayers]);
		Player human = new Player(p.getUser_name());
		p.getNewPlayers()[0] = human;
		String[] CompPlayerNames = { "BotOne", "BotTwo", "BotThree", "BotFour" };
		for (int i = 1; i < numPlayers; i++) {
			p.getNewPlayers()[i] = new Player(CompPlayerNames[i - 1]);	//likely incorrect, revisit
		}
		p.setPlayers(p.getNewPlayers());
	}
	
	public void firstPlayer()	{
		Random r = new Random();
		int decidingPlayerIndex = r.nextInt(p.getPlayers().length);
		p.setDecidingPlayer(p.getPlayers()[decidingPlayerIndex]);	//revisit
		String whoseTurn = String.format("Current player turn: %s%n%n", p.getDecidingPlayer().getName());
		System.out.println(whoseTurn);
	}
	
	public void dealCards()	{
		for (int i = 0; i < r.getNo_cards(); i++) {
			Player player = p.getPlayers()[i % p.getNumPlayers()];
			playerC.giveCard(d.getDeck().get(i), p);	//Deck.get(i), revisit possibly
		}
	}
	
	public void checkHand()	{
		//check how many cards in human hand, if not empty display current card
		String UserCardInfo;
		Player user = p.getPlayers()[0];
		if (user.getHand().length == 0) {
			String s = String.format(p.getUser_name() + " have no cards left.\n\n");
			UserCardInfo = s;
		} else {
			Card UserCurrentCard = user.getHand()[0];
			String CardDescription = String.format("%s%n", UserCurrentCard.getName());
			String CardAttribute1 = String.format("%s: %s   ", d.getSize(), UserCurrentCard.getSize());
			String CardAttribute2 = String.format("%s: %s   ", d.getSpeed(),
					UserCurrentCard.getSpeed());
			String CardAttribute3 = String.format("%s: %s   ", d.getRange(),
					UserCurrentCard.getRange());
			String CardAttribute4 = String.format("%s: %s   ", d.getFirepower(),
					UserCurrentCard.getFirepower());
			String CardAttribute5 = String.format("%s: %s   %n%n", d.getCargo(),
					UserCurrentCard.getCargo());
			UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 + CardAttribute3 + CardAttribute4
					+ CardAttribute5;
		}
		System.out.println("Current card: " + UserCardInfo);

		//if human, select attribute, else play round with chosen bot selecting attribute
		if (p.getDecidingPlayer().getName().equals(p.getUser_name())) {
			UserPicking();
		} else {
			playRound(0);
		}

		//this is required for new game function
		System.out.println();
		String attribute1 = d.getSize();
		String attribute2 = d.getSpeed();
		String attribute3 = d.getRange();
		String attribute4 = d.getFirepower();
		String attribute5 = d.getCargo();
		String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
				attribute1, attribute2, attribute3, attribute4, attribute5);
		System.out.println(attributeNameString);
		for (int i = 0; i < r.getNo_cards(); i++) {
			Card CurrentCard = d.getDeck().get(i);
			String nameValue = CurrentCard.getName();
			String attribute1Val = Integer.toString(CurrentCard.getSize());
			String attribute2Val = Integer.toString(CurrentCard.getSpeed());
			String attribute3Val = Integer.toString(CurrentCard.getRange());
			String attribute4Val = Integer.toString(CurrentCard.getFirepower());
			String attribute5Val = Integer.toString(CurrentCard.getCargo());

			String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
					attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);
			System.out.println(attValString);
		}
		System.out.println();
		for (Player P : p.getPlayers()) {
			System.out.println("-------------------------------------");
			System.out.println("Cards belonging to: " + P.getName());
			String attrCard1 = d.getSize();
			String attrCard2 = d.getSpeed();
			String attrCard3 = d.getRange();
			String attrCard4 = d.getFirepower();
			String attrCard5 = d.getCargo();

			String attrCardsNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
					attrCard1, attrCard2, attrCard3, attrCard4, attrCard5);

			System.out.println(attrCardsNameString);
			for (Card hand : P.getHand()) {
				String nameValue = hand.getName();
				String attribute1Val = Integer.toString(hand.getSize());
				String attribute2Val = Integer.toString(hand.getSpeed());
				String attribute3Val = Integer.toString(hand.getRange());
				String attribute4Val = Integer.toString(hand.getFirepower());
				String attribute5Val = Integer.toString(hand.getCargo());

				String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s",
						nameValue, attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);

				System.out.println(attValString);
			}
		}
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
	
	//Function that is used for the human player to decide with what player attribute in the current round
		public void UserPicking() {
			//The user is requested to enter the corresponding values
			System.out.println(
					"Please choose what attribute you want to take for the round: Size choose 1, Speed choose 2, Cargo choose 3, Range choose 4, Firepower choose 5");
			String entradaTeclado;
			Scanner entradaEscaner = new Scanner(System.in);
			entradaTeclado = entradaEscaner.nextLine();

			if (isNumeric(entradaTeclado)) {
				switch (entradaTeclado) {
				case "1":
					playRound(1);
					break;
				case "2":
					playRound(2);
					break;
				case "3":
					playRound(3);
					break;
				case "4":
					playRound(4);
					break;
				case "5":
					playRound(5);
					break;
				default:
					System.out.println("You must choose an attribute based on those available to play");
					entradaEscaner.close();
					UserPicking();
					break;
				}
			} else {
				System.out.println("You must place a numeric value between the given values in order to play");
				entradaEscaner.close();
				UserPicking();
			}
		}
	
	//Function used to save the values of previous rounds
	public void saveValues(Player[] players,int Index,int[] prevValues) {
		Card[] cards = new Card[players.length];
		for (int i = 0; i < cards.length; i++) {
			if (players[i].getHand().length != 0) {
				cards[i] = players[i].getHand()[0];
				int Attribute = -1;
				if (Index == 1) {
					Attribute = cards[i].getSize();
				} else if (Index == 2) {
					Attribute = cards[i].getSpeed();
				} else if (Index == 3) {
					Attribute = cards[i].getRange();
				} else if (Index == 4) {
					Attribute = cards[i].getFirepower();
				} else if (Index == 5) {
					Attribute = cards[i].getCargo();
				}
				prevValues[i] = Attribute;
			}
		}
	}
	
	private void playRound(int trumpIndex) {
		Round CurrRound;
		RoundController roundC = new RoundController();
		RoundView roundV = new RoundView();
		CurrRound = new Round(p.getPlayers(), p.getDecidingPlayer(), currentPile, trumpIndex, d.getdeck(), r.getNo_cards());
		if (trumpIndex == 0) {
			CurrRound.setIndex(roundC.getIndex(p.getDecidingPlayer(), CurrRound.getATTR()));
		} else {
			CurrRound.setIndex(trumpIndex);
		}

		this.r.setRound(CurrRound);
		saveValues(this.r.getRound().getPlayers(), this.r.getRound().getIndex(), this.r.getRound().getPrevValues());
		roundV.startHovering(this.r.getRound());
		currentPile = r.getRound().getPile();
		if (!this.r.getRound().isDraw()) {
			this.p.setDecidingPlayer(this.r.getRound().getWinner());
		}
		String WhoseTurn = String.format("Current player turn: %s%n%n", this.p.getDecidingPlayer().getName());
		System.out.println(WhoseTurn);
		System.out.println("Cards in pile: " + this.r.getRound().getPile().getCards().length);

		this.r.setPrevRoundString(roundV.getRoundString(this.r.getRound()));
		String displayText = this.r.getPrevRoundString();
		System.out.println(displayText);
		if (this.r.getRound().isDraw()) {
			this.Game.setNumDraws(this.Game.getNumDraws() + 1);
			//dto.setDrawCounter(dto.getDrawCounter() + 1); //revisit, increase draw counter by 1 in event of a round draw
		}
		this.Game.setNumRounds(this.Game.getNumRounds() + 1);
		//dto.setRoundCounter(dto.getRoundCounter() + 1); //revisit, increase round counter every time a round is played

		Player user = this.p.getPlayers()[0];
		String UserCardInfo;
		if (user.getHand().length == 0) {
			String s = String.format(this.p.getUser_name() + " have no cards left.\n\n");
			UserCardInfo = s;
		} else {
			Card UserCurrentCard = user.getHand()[0];
			String CardDescription = String.format("%s%n", UserCurrentCard.getName());
			String CardAttribute1 = String.format("%s: %s   ", d.getSize(), UserCurrentCard.getSize());
			String CardAttribute2 = String.format("%s: %s   ", d.getSpeed(), UserCurrentCard.getSpeed());
			String CardAttribute3 = String.format("%s: %s   ", d.getRange(), UserCurrentCard.getRange());
			String CardAttribute4 = String.format("%s: %s   ", d.getFirepower(), UserCurrentCard.getFirepower());
			String CardAttribute5 = String.format("%s: %s   %n%n", d.getCargo(), UserCurrentCard.getCargo());
			UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 + CardAttribute3 + CardAttribute4
					+ CardAttribute5;
		}

		System.out.println("Cards left in hand: " + p.getPlayers()[0].getHand().length + "\nCurrent card: " + UserCardInfo);
		switch (this.p.getPlayers().length) {
		case 2:
			System.out.println("Bot 1 Cards left in hand:\n" + this.p.getPlayers()[1].getHand().length);
			break;
		case 3:
			System.out.println("Bot 1 Cards left in hand:\n" + this.p.getPlayers()[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + this.p.getPlayers()[2].getHand().length);
			break;
		case 4:
			System.out.println("Bot 1 Cards left in hand:\n" + this.p.getPlayers()[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + this.p.getPlayers()[2].getHand().length);
			System.out.println("Bot 3 Cards left in hand:\n" + this.p.getPlayers()[3].getHand().length);
			break;
		case 5:
			System.out.println("Bot 1 Cards left in hand:\n" + this.p.getPlayers()[1].getHand().length);
			System.out.println("Bot 2 Cards left in hand:\n" + this.p.getPlayers()[2].getHand().length);
			System.out.println("Bot 3 Cards left in hand:\n" + this.p.getPlayers()[3].getHand().length);
			System.out.println("Bot 4 Cards left in hand:\n" + this.p.getPlayers()[4].getHand().length);
			break;
		}

//		checkIfGameOver();
	}

}
