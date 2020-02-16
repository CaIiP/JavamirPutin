package view;

import model.Card;
import model.Player;
import model.TestLog;
import model.TopTrumpsModel;

public class TopTrumpsCAView {
	//private TestLog TestLog = new TestLog();
	public void WhoseTurn(TopTrumpsModel TopTrumps) {
		String WhoseTurn = String.format("Current player turn: %s%n%n", TopTrumps.getDecidingPlayer().getName());
		System.out.println(WhoseTurn);
		
	}
	//
	public void showCurrentCard(TopTrumpsModel TopTrumps) {
		String UserCardInfo;
		Player user = TopTrumps.getPlayers()[0];
		if (user.getHand().length == 0) {
			String s = String.format(TopTrumps.getUser_name() + " have no cards left.\n\n");
			UserCardInfo = s;
			//prints humans current card
		} else {
			Card UserCurrentCard = user.getHand()[0];
			String CardDescription = String.format("%s%n", UserCurrentCard.getName());
			String CardAttribute1 = String.format("%s: %s   ", TopTrumps.getDeck().getSize(), UserCurrentCard.getSize());
			String CardAttribute2 = String.format("%s: %s   ", TopTrumps.getDeck().getSpeed(),UserCurrentCard.getSpeed());
			String CardAttribute3 = String.format("%s: %s   ", TopTrumps.getDeck().getRange(),UserCurrentCard.getRange());
			String CardAttribute4 = String.format("%s: %s   ", TopTrumps.getDeck().getFirepower(),UserCurrentCard.getFirepower());
			String CardAttribute5 = String.format("%s: %s   %n%n", TopTrumps.getDeck().getCargo(),UserCurrentCard.getCargo());
			UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 + CardAttribute3 + CardAttribute4 + CardAttribute5;
		}
		System.out.println("Current card: " + UserCardInfo);
	// SHUFFLED DECK
		//PRINTS OUT ATTRIBUTE TITLES
		System.out.println();
		String attribute1 = TopTrumps.getDeck().getSize();
		String attribute2 = TopTrumps.getDeck().getSpeed();
		String attribute3 = TopTrumps.getDeck().getRange();
		String attribute4 = TopTrumps.getDeck().getFirepower();
		String attribute5 = TopTrumps.getDeck().getCargo();
		String attributeNameString = String.format("%20.20s %15.15s %15.15s "+  "%15.15s %15.15s %15.15s", "",
				attribute1, attribute2, attribute3, attribute4, attribute5);
		System.out.println(attributeNameString);
		//PRINTS OUT SHOUFFLED DECK of cards (name and values)
		for (int i = 0; i < TopTrumps.getNo_cards(); i++) {
			Card CurrentCard = TopTrumps.getdeck().get(i);
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
	}
	
	//prints current hands of all players
	public void CardsBelonging(TopTrumpsModel TopTrumps) {
		for (Player P : TopTrumps.getPlayers()) {
			System.out.println("-------------------------------------");
			System.out.println("Cards belonging to: " + P.getName());
			String attrCard1 = TopTrumps.getDeck().getSize();
			String attrCard2 = TopTrumps.getDeck().getSpeed();
			String attrCard3 = TopTrumps.getDeck().getRange();
			String attrCard4 = TopTrumps.getDeck().getFirepower();
			String attrCard5 = TopTrumps.getDeck().getCargo();

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
			System.out.println();
		}
	}

		
	}
	
	

