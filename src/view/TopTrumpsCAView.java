package view;

import model.Card;
import model.Player;
import model.TestLog;
import model.TopTrumpsModel;

public class TopTrumpsCAView {

	public void whoseTurn(TopTrumpsModel TopTrumps) {
		String whoseTurn = String.format("Current player turn: %s%n", TopTrumps.getDecidingPlayer().getName());
		System.out.println(whoseTurn);
	}

	public void showCurrentCard(TopTrumpsModel TopTrumps) {
		String UserCardInfo;
		Player user = TopTrumps.getPlayers()[0];
		if (user.getHand().length == 0) {
			String s = String.format(TopTrumps.getUser_name() + " have no cards left.\n\n");
			UserCardInfo = s;
			// prints humans current card
		} else {
			Card UserCurrentCard = user.getHand()[0];
			String CardDescription = String.format("%s%n", UserCurrentCard.getName());
			String CardAttribute1 = String.format("%s: %s   ", TopTrumps.getDeck().getSize(),
					UserCurrentCard.getSize());
			String CardAttribute2 = String.format("%s: %s   ", TopTrumps.getDeck().getSpeed(),
					UserCurrentCard.getSpeed());
			String CardAttribute3 = String.format("%s: %s   ", TopTrumps.getDeck().getRange(),
					UserCurrentCard.getRange());
			String CardAttribute4 = String.format("%s: %s   ", TopTrumps.getDeck().getFirepower(),
					UserCurrentCard.getFirepower());
			String CardAttribute5 = String.format("%s: %s   %n", TopTrumps.getDeck().getCargo(),
					UserCurrentCard.getCargo());
			UserCardInfo = CardDescription + CardAttribute1 + CardAttribute2 + CardAttribute3 + CardAttribute4
					+ CardAttribute5;
		}
		System.out.println("Current card: " + UserCardInfo);

	}

	//  current hands of players to words form
	public void cardsBelonging(TopTrumpsModel TopTrumps) {
		for (Player P : TopTrumps.getPlayers()) {
			for (Card hand : P.getHand()) {
				String nameValue = hand.getName();
				String attribute1Val = Integer.toString(hand.getSize());
				String attribute2Val = Integer.toString(hand.getSpeed());
				String attribute3Val = Integer.toString(hand.getRange());
				String attribute4Val = Integer.toString(hand.getFirepower());
				String attribute5Val = Integer.toString(hand.getCargo());

				String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
						attribute1Val, attribute2Val, attribute3Val, attribute4Val, attribute5Val);

				System.out.println(attValString);
			}
		}
	}

}
