package com.thegame;

public class DiscardMove {
    private final int card;
    private final int pileNumber;
    
    public DiscardMove(int card, int pileNumber){
        if (card < 2 || card > 98)
            throw new IllegalArgumentException();
      
        this.card = card;
        this.pileNumber = pileNumber;
    }

    public int getCard() {
        return card;
    }

    public int getPileNumber() {
        return pileNumber;
    }
}
