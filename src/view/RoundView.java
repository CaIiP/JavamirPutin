package view;

// initial variables
import controller.CommunalPileController;
import controller.PlayerController;
import model.Card;
import model.CommunalPile;
import model.Player;
import model.Round;
import model.TestLog;
import model.TopTrumpsModel;

/*
 * This shows the view of rounds played in the logic, the previous round attributes
 */
public class RoundView {
	private Round round;

	public String getRoundString(Round round) {

		String roundString = String.format("");
		String Attribute = "";
		if (round.getIndex() == 1) {
			Attribute = round.getDeck().getSize();
		} else if (round.getIndex() == 2) {
			Attribute = round.getDeck().getSpeed();
		} else if (round.getIndex() == 3) {
			Attribute = round.getDeck().getRange();
		} else if (round.getIndex() == 4) {
			Attribute = round.getDeck().getFirepower();
		} else if (round.getIndex() == 5) {
			Attribute = round.getDeck().getCargo();
		}

		String score = String.format("");
		score += String.format("%n");
		roundString += score;

		System.out.println();
		String winLost = String.format("%n");
		Player user = round.getPlayers()[0];
		roundString += winLost;

		String winnerDraw = String.format("%n");
		if (round.isDraw()) {
			winnerDraw += String.format("This round was a draw.%n");
		} else {
			winnerDraw += String.format("%s won the previous round%n", round.getWinner().getName());
		}
		roundString += winnerDraw;
		System.out.println(roundString);
		return roundString;
	}

	// Function that is used to show the cards in play of the round and also to
	// indicate which cards were left after playing the round.
	public void startHovering(Round round) {
		System.out.println("---------------------------");
		Card[] cardsArray = { null, null, null, null, null };
		for (int i = 0; i < round.getPlayers().length; i++) {
			if (round.getPlayers()[i].getHand().length != 0) {

				Card takenCard = round.getPlayers()[i].getHand()[0];
				Card[] newHand = new Card[round.getPlayers()[i].getHand().length - 1];
				for (int j = 0; j < newHand.length; j++) {
					newHand[j] = round.getPlayers()[i].getHand()[j + 1];
				}
				round.getPlayers()[i].setHand(newHand);
				if (round.getPlayers()[i].getHand().length == 0) {
					round.getPlayers()[i].setKeepPlaying(false);
				}

				Card c = takenCard;
				cardsArray[i] = c;
			}
		}

		round.setCards(cardsArray);

// currents card to play
		for (Card Card : round.getCards()) {
			if (Card != null) {
				String nameValue = Card.getName();
				String att1Value = Integer.toString(Card.getSize());
				String att2Value = Integer.toString(Card.getSpeed());
				String att3Value = Integer.toString(Card.getRange());
				String att4Value = Integer.toString(Card.getFirepower());
				String att5Value = Integer.toString(Card.getCargo());

				String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
						att1Value, att2Value, att3Value, att4Value, att5Value);

			}
		}
		/*
		 * Category selected by the player and value of every players card for that
		 * category
		 */

		String Attribute = "";
		if (round.getIndex() == 1) {
			Attribute = round.getDeck().getSize();
		} else if (round.getIndex() == 2) {
			Attribute = round.getDeck().getSpeed();
		} else if (round.getIndex() == 3) {
			Attribute = round.getDeck().getRange();
		} else if (round.getIndex() == 4) {
			Attribute = round.getDeck().getFirepower();
		} else if (round.getIndex() == 5) {
			Attribute = round.getDeck().getCargo();
		}
		System.out.println("Category selected: " + Attribute);
		System.out.println("Values:");
		for (int i = 0; i < round.getPlayers().length; i++) {
			Player p = round.getPlayers()[i];
			if (p.getHand().length > 0) {
				System.out.println(p.getName() + ": " + round.getPrevValues()[i]);

			}
		}

		boolean drawR = false;
		int maxScore = 50;
		int[] playerScores = new int[maxScore];
		// attributes of all players in a round identifier
		for (int i = 0; i < round.getPlayers().length; i++) {
			if (round.getCards()[i] != null) {
				Card c = round.getCards()[i];
				int AttributeR = -1;
				if (round.getIndex() == 1) {
					AttributeR = c.getSize();
				} else if (round.getIndex() == 2) {
					AttributeR = c.getSpeed();
				} else if (round.getIndex() == 3) {
					AttributeR = c.getRange();
				} else if (round.getIndex() == 4) {
					AttributeR = c.getFirepower();
				} else if (round.getIndex() == 5) {
					AttributeR = c.getCargo();
				}
				int score = AttributeR;
				if (score == 0) {
					playerScores[score]++;
				} else {
					playerScores[score - 1]++;
				}

			}
		}
		// to identif if its a dra or not.
		for (int i = maxScore - 1; i >= 0; i--) {
			if (playerScores[i] == 1) {
				break;
			} else if (playerScores[i] > 1) {
				drawR = true;
				break;
			}
		}

		round.setDraw(drawR);
		int topS = 0;
		for (int i = 0; i < round.getPlayers().length; i++) {
			if ((round.getPlayers()[i].getHand().length + 1) > 0) {
				try {
					Card c = round.getCards()[i];
					int AttributeW = -1;
					if (round.getIndex() == 1) {
						AttributeW = c.getSize();
					} else if (round.getIndex() == 2) {
						AttributeW = c.getSpeed();
					} else if (round.getIndex() == 3) {
						AttributeW = c.getRange();
					} else if (round.getIndex() == 4) {
						AttributeW = c.getFirepower();
					} else if (round.getIndex() == 5) {
						AttributeW = c.getCargo();
					}
					if (AttributeW == topS) {
						round.setWinner(null);
					} else if (AttributeW > topS) {
						topS = AttributeW;
						round.setWinner(round.getPlayers()[i]);
					}
				} catch (Exception e) {
					System.out.println("" + round.getPlayers()[i].getName() + " has no cards left.");
				}
			}
		}
		/*
		 * this process is the one that places the card in the communal pile or the
		 * cards been given to player if he wins round.
		 */
		if (round.getWinner() == null) {// W inner view
			CommunalPileController communalPileC = new CommunalPileController();
			for (Card c : round.getCards()) {
				if (c != null) {
					communalPileC.giveCard(c, round.getPile());
				}
			}
		} else {
			PlayerController playerC = new PlayerController();
			for (Card c : round.getCards()) {
				if (c != null) {
					playerC.giveCard(c, round.getWinner());
				}
			}
			for (Card c : round.getPile().getCards()) {
				if (c != null) {
					playerC.giveCard(c, round.getWinner());
				}
			}
			round.setPile(new CommunalPile());
		}
// Players hand information while playing a round and the cards value at play in a current round
		for (Player p : round.getPlayers()) {
			if (p.getHand().length > 0) {

				String attribute1PHandName = round.getDeck().getSize();
				String attribute2PHandName = round.getDeck().getSpeed();
				String attribute3PHandName = round.getDeck().getRange();
				String attribute4PHandName = round.getDeck().getFirepower();
				String attribute5PHandName = round.getDeck().getCargo();
				String attributePHandNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s",
						"", attribute1PHandName, attribute2PHandName, attribute3PHandName, attribute4PHandName,
						attribute5PHandName);
				for (Card hand : p.getHand()) {
					String nameValue = hand.getName();
					String att1Value = Integer.toString(hand.getSize());
					String att2Value = Integer.toString(hand.getSpeed());
					String att3Value = Integer.toString(hand.getRange());
					String att4Value = Integer.toString(hand.getFirepower());
					String att5Value = Integer.toString(hand.getCargo());
					String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s",
							nameValue, att1Value, att2Value, att3Value, att4Value, att5Value);
				}
				System.out.println();
			}
		}
	}

	public Round getRound() {
		return this.round;

	}

}
