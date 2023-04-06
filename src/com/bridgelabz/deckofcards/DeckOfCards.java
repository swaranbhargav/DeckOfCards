package com.bridgelabz.deckofcards;

import java.util.*;

public class DeckOfCards {
	private final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
	private final String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	private List<String> deck;

	public DeckOfCards() {
		deck = new ArrayList<>();
		for (String suit : suits) {
			for (String rank : ranks) {
				deck.add(rank + " of " + suit);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck, new Random());
	}

	public List<String> getDeck() {
		return deck;
	}

	public String[][] dealCards(int numPlayers, int numCards) {
		String[][] cards = new String[numPlayers][numCards];
		for (int i = 0; i < numCards; i++) {
			for (int j = 0; j < numPlayers; j++) {
				cards[j][i] = deck.remove(0);
			}
		}
		return cards;
	}

	public static void main(String[] args) {
		DeckOfCards deck = new DeckOfCards();
		deck.shuffle();
		String[][] cards = deck.dealCards(4, 9);
		for (int i = 0; i < 4; i++) {
			System.out.println("Player " + (i + 1) + " cards:");
			for (int j = 0; j < 9; j++) {
				System.out.println(cards[i][j]);
			}
			System.out.println();
		}

	}

}
