package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import model.Card;

public class DeckController {

//	Constructor and load the deck in the game
	public void generateDeck(ArrayList<String> lines,ArrayList<Card> deck) {
		try (BufferedReader br = new BufferedReader(new FileReader("StarCitizenDeck.txt")))	{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}
		}catch (IOException e)	{
			e.printStackTrace();
		}
		boolean firstRun = true;
		//System.out.println("Unshuffled deck:");
		//System.out.println();
		for (String line : lines) {
			if (firstRun) {
				firstRun = false;
				continue;
			}
			//System.out.println(line);
			deck.add(new Card(line));
		} 
	}


	//method to shuffle the deck following deck generation
	public void shuffleDeck(ArrayList<Card> deck) {
		Collections.shuffle(deck);

	}
}
