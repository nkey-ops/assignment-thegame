package com.thegame.pile;

/**
 * @author user9672
 *
 */
public abstract class DiscardPile {
	
	private int topCard;
	
	private int cardCount;
	
	
	/**
	 * @param topCard
	 */
	public DiscardPile(int topCard) {
		this.topCard=topCard;
		this.cardCount++;
	}
	
	
	/**
	 * @return
	 */
	public int getTopCard() {
		return topCard;
	}

	
	/**
	 * @return
	 */
	public int getCardCount() {
		return cardCount;
	}
	
	/**
	 * @param topCard
	 */
	public void setTopCard(int topCard) {
		this.topCard = topCard;
	}

	/**
	 * @param cardCount
	 */
	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
	}

	
	/**
	 * @param card
	 * @return
	 */
	public abstract boolean discard(int card);
	
	/**
	 * @return
	 */
	public abstract String getRules();

}
