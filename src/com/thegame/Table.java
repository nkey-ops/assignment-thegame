package com.thegame;

import com.thegame.pile.DiscardPile;

public class Table {

    private final DiscardPile[] piles;

    private final Deck deck;

    public DiscardPile[] getPiles() {
        return piles;
    }

    public Table(DiscardPile[] piles, Deck deck) {
        this.piles = piles;
        this.deck = deck;
    }


    public int draw() {
        return deck.drawCard();
    }

    public boolean discard(int card, int pileNumber) {
        //pileNumber should be in the range of 1 to pile array size
        if (pileNumber > this.piles.length || pileNumber < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.piles[pileNumber - 1].discard(card);
    }


    public boolean discard(DiscardMove discardMove) {
        int pileNumber = discardMove.getPileNumber();
        int card = discardMove.getCard();

        return discard(card, pileNumber);
    }


    public int numberOfPiles() {
        return piles.length;
    }

    public int getTopCard(int pileNumber) {
        if (pileNumber <= 0 || pileNumber > piles.length)
            throw new IllegalArgumentException("Pile number is improper");

        return piles[pileNumber - 1].getTopCard();
    }

    public boolean deckIsEmpty() {
        return deck.remainingCardCount() == 0;
    }

    @Override
    public String toString() {
        StringBuilder p = new StringBuilder("Discard Piles:\n");
        for (int i = 0; i < piles.length; i++) {
            String temp = "" + (i + 1) + ": " + piles[i];
            p.append(temp).append("\n");
        }

        String sDeck = String.format("Deck: %s", deck);
        return sDeck + "\n" + p;
    }


}
