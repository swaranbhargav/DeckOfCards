package com.bridgelabz.deckofcards;

import java.util.*;

public class DeckOfCards {
	public static void main(String[] args) {
		// Initialize the deck of cards
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		List<String> deck = new ArrayList<>();
		for (String suit : suits) {
			for (String rank : ranks) {
				deck.add(rank + " of " + suit);
			}
		}

		// Shuffle the deck of cards
		Collections.shuffle(deck, new Random());

		// Create players
		Player[] players = new Player[4];
		for (int i = 0; i < 4; i++) {
			List<String> playerDeck = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				playerDeck.add(deck.get(i * 9 + j));
			}
			players[i] = new Player("Player " + (i + 1), playerDeck);
		}

		// Sort the cards by rank for each player
		for (Player player : players) {
			player.sortDeckByRank();
		}

		// Arrange the players in a queue
		Queue<Player> playerQueue = new LinkedList<>();
		for (Player player : players) {
			playerQueue.offer(player);
		}

		// Print the players and the cards received by each player
		while (!playerQueue.isEmpty()) {
			Player player = playerQueue.poll();
			System.out.println(player.getName() + ":");
			Queue<String> cardQueue = player.getDeckAsQueue();
			while (!cardQueue.isEmpty()) {
				System.out.println(cardQueue.poll());
			}
			System.out.println();
		}
	}
}
