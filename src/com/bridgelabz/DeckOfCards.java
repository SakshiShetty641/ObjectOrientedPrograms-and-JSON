package com.bridgelabz;
import java.util.Arrays;
/**
 * Purpose - To shuffle the Cards and print the cards received by player
 * @author Sakshi Shetty
 * @version 16.0
 * @since 2021-08-16
 */
public class DeckOfCards {
	// Initializing the suits of the deck in a String array named 'SUITS'
	String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
	// Initializing the ranks of the deck in a String array named 'RANKS'
	String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	// Arrays for storing distributed player wise cards.
	String[] personOne;
	String[] personTwo;
	String[] personThree;
	String[] personFour;

	public DeckOfCards() {
		personOne = new String[9];
		personTwo = new String[9];
		personThree = new String[9];
		personFour = new String[9];
	}

	String[] deck;
	int totalCards;

	/**
	 * initialize deck. storing cards inside deck
	 */
	public void deckInitialize() {
		totalCards = SUITS.length * RANKS.length; // a deck consists of 4*13 cards
		deck = new String[totalCards];
		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				// deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
				deck[SUITS.length * i + j] = SUITS[j] + " " + RANKS[i];
			}
		}
	}

	/**
	 * Shuffling the cards. Using random function. Swapping and shuffling.
	 */
	public void shuffle() {
		for (int i = 0; i < totalCards; i++) {
			int r = i + (int) (Math.random() * (totalCards - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
	}

	/**
	 * print shuffled deck for 4 player.
	 */
	public void PrintDistribute() {
		int one = 0, two = 0, three = 0, four = 0;
		for (int i = 0; i < (deck.length - 16); i++) {

			if (i % 4 == 0) {
				personOne[one] = deck[i];
				one++;
			} else if (i % 4 == 1) {
				personTwo[two] = deck[i];
				two++;
			} else if (i % 4 == 2) {
				personThree[three] = deck[i];
				three++;
			} else if (i % 4 == 3) {
				personFour[four] = deck[i];
				four++;
			}
		}
		System.out.println("First person cards are: ");
		Arrays.stream(personOne).forEach(System.out::println);
		System.out.println();

		System.out.println("Second person cards are: ");
		Arrays.stream(personTwo).forEach(System.out::println);
		System.out.println();

		System.out.println("Third person cards are: ");
		Arrays.stream(personThree).forEach(System.out::println);
		System.out.println();

		System.out.println("Fourth person cards are: ");
		Arrays.stream(personFour).forEach(System.out::println);
		System.out.println();
	}

	public static void main(String[] args) {
		DeckOfCards cards = new DeckOfCards();
		cards.deckInitialize();
		cards.shuffle();
		cards.PrintDistribute();

	}
}
