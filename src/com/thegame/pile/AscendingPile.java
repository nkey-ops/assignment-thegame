package com.thegame.pile;

public class AscendingPile extends DiscardPile {
	private static final String RULES = "Cards must be discarded in ascending order unless the card is exactly 10 less than the top card";
	
	public AscendingPile(int topCard) {
		super(topCard);
	}

	@Override
	public boolean discard(int card) {
		//Check AscendingPile Rule and set card as Top card if condition satisfy.
		if(card>this.getTopCard()||card==this.getTopCard()-10) {
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
		return "+{" + getTopCard() + "}";
	}
	
}
