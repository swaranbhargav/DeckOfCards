package com.bridgelabz.deckofcards;

import java.util.*;

public class Player {

	private String name;
	private List<String> deck;

	public Player(String name, List<String> deck) {
		this.name = name;
		this.deck = deck;
	}

	public String getName() {
		return name;
	}

	public void sortDeckByRank() {
		for (int i = 0; i < deck.size(); i++) {
			int minIndex = i;
			for (int j = i + 1; j < deck.size(); j++) {
				String card1 = deck.get(j);
				String card2 = deck.get(minIndex);
				int rank1 = getRank(card1);
				int rank2 = getRank(card2);
				if (rank1 < rank2) {
					minIndex = j;
				}
			}
			String temp = deck.get(i);
			deck.set(i, deck.get(minIndex));
			deck.set(minIndex, temp);
		}
	}

	private int getRank(String card) {
		String rankString = card.substring(0, card.indexOf(" "));
		if (rankString.equals("Ace")) {
			return 14;
		} else if (rankString.equals("King")) {
			return 13;
		} else if (rankString.equals("Queen")) {
			return 12;
		} else if (rankString.equals("Jack")) {
			return 11;
		} else {
			return Integer.parseInt(rankString);
		}
	}

	public Queue<String> getDeckAsQueue() {
		Queue<String> queue = new LinkedList<>();
		for (String card : deck) {
			queue.offer(card);
		}
		return queue;
	}

}
