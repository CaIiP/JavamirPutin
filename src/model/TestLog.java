package model;

import java.util.logging.FileHandler;
import java.io.IOException;
import java.util.logging.*;
public class TestLog {
	//attributes
	private Logger log = Logger.getLogger(TestLog.class.getName());
	private FileHandler f;
	private String Separator = " ----------------------------------";
	//constructor 
	public TestLog() {
		try {
			f = new FileHandler("toptrumps.log");
			f.setFormatter(new SimpleFormatter());
			log.addHandler(f);
			log.setUseParentHandlers(false);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

	}


	//methods 

	public void logDeck(TopTrumpsModel TopTrumps, boolean writeGameLogsToFile) {
		if (writeGameLogsToFile == false ) {


			StringBuffer  sbDeck = new StringBuffer("Deck of Cards (Unshuffled):" +System.getProperty("line.separator") );			
			String attribute1 = TopTrumps.getDeck().getSize();
			String attribute2 = TopTrumps.getDeck().getSpeed();
			String attribute3 = TopTrumps.getDeck().getRange();
			String attribute4 = TopTrumps.getDeck().getFirepower();
			String attribute5 = TopTrumps.getDeck().getCargo();
			String attributeNameString = String.format("%20.20s %15.15s %15.15s "+  "%15.15s %15.15s %15.15s", "",
					attribute1, attribute2, attribute3, attribute4, attribute5);
			sbDeck.append(attributeNameString+ System.getProperty("line.separator"));

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
				sbDeck.append(attValString+ System.getProperty("line.separator"));
			}


			sbDeck.append(Separator);
			log.info(sbDeck.toString());
		}
	}



	public void logShuffledDeck(TopTrumpsModel TopTrumps,  boolean writeGameLogsToFile) {
		if (writeGameLogsToFile== false ) {
			StringBuffer  sbDeck = new StringBuffer("Shuffled Deck:" +System.getProperty("line.separator") );
			String attribute1 = TopTrumps.getDeck().getSize();
			String attribute2 = TopTrumps.getDeck().getSpeed();
			String attribute3 = TopTrumps.getDeck().getRange();
			String attribute4 = TopTrumps.getDeck().getFirepower();
			String attribute5 = TopTrumps.getDeck().getCargo();
			String attributeNameString = String.format("%20.20s %15.15s %15.15s "+  "%15.15s %15.15s %15.15s", "",
					attribute1, attribute2, attribute3, attribute4, attribute5);
			sbDeck.append(attributeNameString+ System.getProperty("line.separator"));

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
				sbDeck.append(attValString+ System.getProperty("line.separator"));
			}
			sbDeck.append(Separator);
			log.info(sbDeck.toString());
		}
	}



	public void logUsersHand(TopTrumpsModel TopTrumps, boolean writeGameLogsToFile) {
		if (writeGameLogsToFile== false ) {
			StringBuffer  sbHand = new StringBuffer("Players Current Hands:" +System.getProperty("line.separator") );
			sbHand.append(System.getProperty("line.separator"));
			sbHand.append("Player hands post-round: "+ System.getProperty("line.separator"));
			for (Player p : TopTrumps.getRound().getPlayers()) {
				if (p.getHand().length > 0) {
					sbHand.append(System.getProperty("line.separator")+ System.getProperty("line.separator"));
					sbHand.append("Cards in hand belonging to: " + p.getName()+ System.getProperty("line.separator"));
					sbHand.append( "   " +TopTrumps.getRound().getDeck().getSize()+ " ");
					sbHand.append(TopTrumps.getRound().getDeck().getSpeed()+ " ");
					sbHand.append(TopTrumps.getRound().getDeck().getRange()+ " ");
					sbHand.append(TopTrumps.getRound().getDeck().getFirepower()+ " ");
					sbHand.append(TopTrumps.getRound().getDeck().getCargo()+ System.getProperty("line.separator"));


					for (Card hand : p.getHand()) {
						sbHand.append(hand.getName()+ "   ");
						sbHand.append(Integer.toString(hand.getSize())+ "   ");
						sbHand.append(Integer.toString(hand.getSpeed())+ "   ");
						sbHand.append(Integer.toString(hand.getRange())+ "   ");
						sbHand.append(Integer.toString(hand.getFirepower())+ "   ");
						sbHand.append(Integer.toString(hand.getCargo())+ System.getProperty("line.separator"));
					}
				}
			}
			sbHand.append(Separator);
			log.info(sbHand.toString());
		}}


	public void logCommonPile(TopTrumpsModel TopTrumps,  boolean writeGameLogsToFile) {
		if (writeGameLogsToFile== false ) {
			StringBuffer  sbComPile = new StringBuffer("Common Pile :" +System.getProperty("line.separator") );
			if (TopTrumps.getRound().getPile().getCards().length > 0) {
				String attribute1CPileName = TopTrumps.getRound().getDeck().getSize();
				String attribute2CPileName = TopTrumps.getRound().getDeck().getSpeed();
				String attribute3CPileName = TopTrumps.getRound().getDeck().getRange();
				String attribute4CPileName = TopTrumps.getRound().getDeck().getFirepower();
				String attribute5CPileName = TopTrumps.getRound().getDeck().getCargo();
				String attributeCPileNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
						attribute1CPileName, attribute2CPileName, attribute3CPileName, attribute4CPileName,
						attribute5CPileName);

				sbComPile.append(attributeCPileNameString+ System.getProperty("line.separator"));
				for (int i = 0; i < TopTrumps.getRound().getPile().getCards().length; i++) {
					String nameValue = TopTrumps.getRound().getPile().getCards()[i].getName();
					String att1Value = Integer.toString(TopTrumps.getRound().getPile().getCards()[i].getSize());
					String att2Value = Integer.toString(TopTrumps.getRound().getPile().getCards()[i].getSpeed());
					String att3Value = Integer.toString(TopTrumps.getRound().getPile().getCards()[i].getRange());
					String att4Value = Integer.toString(TopTrumps.getRound().getPile().getCards()[i].getFirepower());
					String att5Value = Integer.toString(TopTrumps.getRound().getPile().getCards()[i].getCargo());

					String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
							att1Value, att2Value, att3Value, att4Value, att5Value);

					sbComPile.append(attValString+ System.getProperty("line.separator"));
				}
			}
			sbComPile.append(Separator);
			log.info(sbComPile.toString());
		}}






	public void logcurrentCardsInPlay(TopTrumpsModel TopTrumps,  boolean writeGameLogsToFile) {
		if (writeGameLogsToFile== false ) {
			StringBuffer  sbDeck = new StringBuffer("Current Cards in play:" +System.getProperty("line.separator") );
			String attribute1Name = TopTrumps.getRound().getDeck().getSize();
			String attribute2Name = TopTrumps.getRound().getDeck().getSpeed();
			String attribute3Name = TopTrumps.getRound().getDeck().getRange();
			String attribute4Name = TopTrumps.getRound().getDeck().getFirepower();
			String attribute5Name = TopTrumps.getRound().getDeck().getCargo();
			String attributeNameString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", "",
					attribute1Name, attribute2Name, attribute3Name, attribute4Name, attribute5Name);

			sbDeck.append(attributeNameString +System.getProperty("line.separator"));
			for (Card Card : TopTrumps.getRound().getCards()) {
				if (Card != null) {
					String nameValue = Card.getName();
					String att1Value = Integer.toString(Card.getSize());
					String att2Value = Integer.toString(Card.getSpeed());
					String att3Value = Integer.toString(Card.getRange());
					String att4Value = Integer.toString(Card.getFirepower());
					String att5Value = Integer.toString(Card.getCargo());

					String attValString = String.format("%20.20s %15.15s %15.15s " + "%15.15s %15.15s %15.15s", nameValue,
							att1Value, att2Value, att3Value, att4Value, att5Value);

					sbDeck.append(attValString+System.getProperty("line.separator"));
				}
			}
			sbDeck.append(Separator);
			log.info(sbDeck.toString());

		}}



	public void logCategorySelected(TopTrumpsModel TopTrumps,  boolean writeGameLogsToFile) {
		if (writeGameLogsToFile== false ) {
			StringBuffer  sbCat = new StringBuffer("Category Selection: " +System.getProperty("line.separator") );
			String Attribute = "";
			if (TopTrumps.getRound().getIndex() == 1) {
				Attribute = TopTrumps.getRound().getDeck().getSize();
			} else if (TopTrumps.getRound().getIndex() == 2) {
				Attribute = TopTrumps.getRound().getDeck().getSpeed();
			} else if (TopTrumps.getRound().getIndex() == 3) {
				Attribute = TopTrumps.getRound().getDeck().getRange();
			} else if (TopTrumps.getRound().getIndex() == 4) {
				Attribute = TopTrumps.getRound().getDeck().getFirepower();
			} else if (TopTrumps.getRound().getIndex() == 5) {
				Attribute = TopTrumps.getRound().getDeck().getCargo();
			}
			sbCat.append("Category selected: " + Attribute+System.getProperty("line.separator"));
			sbCat.append("Values:"+System.getProperty("line.separator"));
			for (int i = 0; i < TopTrumps.getRound().getPlayers().length; i++) {
				Player p = TopTrumps.getRound().getPlayers()[i];
				if (p.getHand().length > 0) {
					sbCat.append(p.getName() + ": " + TopTrumps.getRound().getPrevValues()[i]+System.getProperty("line.separator"));
				}
			}
			sbCat.append(Separator);
			log.info(sbCat.toString());
		}
	}





	public void logWinner(TopTrumpsModel TopTrumps,  boolean writeGameLogsToFile)
	{ if (writeGameLogsToFile== false ) {
		StringBuffer  sbWin = new StringBuffer("Player Winnner/Loser Notification: " +System.getProperty("line.separator") );
		String roundString = String.format("");
		String Attribute = "";
		if (TopTrumps.getRound().getIndex() == 1) {
			Attribute = TopTrumps.getRound().getDeck().getSize();
		} else if (TopTrumps.getRound().getIndex() == 2) {
			Attribute = TopTrumps.getRound().getDeck().getSpeed();
		} else if (TopTrumps.getRound().getIndex() == 3) {
			Attribute = TopTrumps.getRound().getDeck().getRange();
		} else if (TopTrumps.getRound().getIndex() == 4) {
			Attribute = TopTrumps.getRound().getDeck().getFirepower();
		} else if (TopTrumps.getRound().getIndex() == 5) {
			Attribute = TopTrumps.getRound().getDeck().getCargo();
		}

		String WinLost = String.format("%n");
		Player user = TopTrumps.getRound().getPlayers()[0];
		if (user.getHand().length == TopTrumps.getRound().getDeck().getDeck().size() - TopTrumps.getRound().getPile().getCards().length) {
			if (TopTrumps.getRound().getWinner() != null) {
				WinLost += String.format("YOU WON THE GAME!: " + TopTrumps.getRound().getWinner().getName());
			} else {
				WinLost += String.format("YOU WON THE GAME!:" + user.getName());
			}
		} else if (user.getHand().length == 0) {
			WinLost += String.format("YOU LOST THE GAME!:" + user.getName());
		}
		roundString += WinLost+  System.getProperty("line.separator");

		String WinnerDraw = String.format("%n");
		if (TopTrumps.getRound().isDraw()) {
			WinnerDraw += String.format("This round was a draw.%n%n");
		} else {
			WinnerDraw += String.format("%s won the previous round%n%n", TopTrumps.getRound().getWinner().getName());
		}
		roundString += WinnerDraw;
		sbWin.append(roundString);
		log.info(sbWin.toString());
	}
	}

}



