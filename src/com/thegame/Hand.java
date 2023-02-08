package com.thegame;

import java.util.Arrays;

public class Hand {
    private int[] cards;
    private int last = -1;

    public int[] getCards() {
        return Arrays.copyOf(cards, last + 1);
    }

    /**
     * @param capacity indicates the maximum number of cards
     */
    public Hand(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException(
                    "Capacity cannot be equal or below zero");

        this.cards = new int[capacity];
    }

    /**
     * Deals a card into the hand and returns true if the card was added to the
     * hand and false otherwise
     */
    public boolean deal(int card) {
        if (isFull()) return false;

        cards[++last] = card;

        return true;
    }

    /**
     * @return true if the hand contains the maximum number of cards and
     * false otherwise.
     */
    public boolean isFull() {
        return last == cards.length - 1;
    }

    /**
     * @return true if the hand contains the maximum number of cards and
     * false otherwise.
     */
    public boolean isEmpty() {
        return last == -1;
    }

    /**
     * Removes the specified card from the hand
     *
     * @param card the value of the card to remove
     */
    public boolean remove(int card) {
        if (isEmpty())
            throw new IllegalStateException("Hand is Empty");

        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == card) {
                cards[i] = cards[last];
                cards[last--] = 0;
                return true;
            }
        }
        
        return false;
    }

    /**
     * @return a string representation of the hand matching the format
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(cards, last + 1));
    }
}
