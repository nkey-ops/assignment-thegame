package com.thegame.pile;

public class DescendingPile extends DiscardPile {

    private static final String RULES = "Cards must be discarded in descending order unless the card is exactly 10 greater than the top card";

    public DescendingPile(int topCard) {
        super(topCard);
    }


    @Override
    public boolean discard(int card) {
        if (card < this.getTopCard() || card == this.getTopCard() + 10) {
            this.setTopCard(card);
            return true;
        }
        return false;

    }

    @Override
    public String getRules() {
        return RULES;
    }

    @Override
    public String toString() {
        return "-{" + getTopCard() + "}";
    }

}
