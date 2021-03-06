package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import model.Card;
import model.Player;

public class RoundController {
	
	
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
}
