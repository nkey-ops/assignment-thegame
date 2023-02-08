package com.thegame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Deck {
    private final int[] cards;
    private int top;
    private Set<Integer> drawnCards = new HashSet<>();

    public Deck() {
        this(98);
    }

    public Deck(int size) {
        if (size <= 0 || size > 98)
            throw new IllegalArgumentException(
                    "Size cannot be equal or below zero or higher than 96");

        cards = new int[size];
        this.createCards(cards);
        this.shuffle();
    }


    /**
     * Shuffle the cards and store position of top.
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = this.cards.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = this.cards[i];
            this.cards[i] = this.cards[j];
            this.cards[j] = temp;
            this.top = j;
        }
        //Check if top card has already drawn or not
        if (remainingCardCount() != 0 && drawnCards.contains(this.cards[this.top])) {
            this.shuffle();
        }
    }


    public int drawCard() {
        if (remainingCardCount() > 0) {
            drawnCards.add(this.cards[this.top]);
            this.shuffle();
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.cards[this.top];
    }

    public int getTopCard() {
        return this.cards[this.top];
    }


    public int remainingCardCount() {
        return cards.length - drawnCards.size();
    }

    public Set<Integer> getDrawnCards() {
        return drawnCards;
    }

    public void setDrawnCards(Set<Integer> drawnCards) {
        this.drawnCards = drawnCards;
    }


    /**
     *  Create cards with values 2 to length of cards
     */
    public void createCards(int[] cards) {
        for (int i = 2; i < cards.length + 2; i++) {
            cards[i - 2] = i;
        }
        
    }

    @Override
    public String toString() {
        return "[" + remainingCardCount() + "]";
    }
}
