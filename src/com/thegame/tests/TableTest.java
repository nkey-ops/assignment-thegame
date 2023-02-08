package com.thegame.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.thegame.*;
import com.thegame.pile.AscendingPile;
import com.thegame.pile.DescendingPile;
import com.thegame.pile.DiscardPile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {
	
	Deck deck;
	DiscardPile ascendingPile1;
	DiscardPile descendingPile1;
	DiscardPile descendingPile2;
	DiscardPile ascendingPile2;
	DiscardPile[] piles = new DiscardPile[4];
	
	/*
	 * Intialize all the objects required in unit tests.
	 */
	@BeforeEach
	public void setup() {
		deck = new Deck();
		ascendingPile1 = new AscendingPile(1);
		descendingPile1 = new DescendingPile(100);
		descendingPile2 = new DescendingPile(100);
		ascendingPile2 = new AscendingPile(1);
		piles[0] = ascendingPile1;
		piles[1] = descendingPile1;
		piles[2] = descendingPile2;
		piles[3] = ascendingPile2;
	}

	@Test
	void discardWhenCardNumberIsTwoAndPileNumberIsOneShouldReturnTrue() {
		Table table = new Table(piles,deck);
		assertTrue(table.discard(2, 1));
	}
	
	@Test
	void discardWhenCardNumberIsTwoAndPileNumberIsZeroShouldThrowException() {
		Table table = new Table(piles,deck);
		assertThrows(ArrayIndexOutOfBoundsException.class,()->table.discard(2, 0));
	}
	
	@Test
	void discardWhenCardNumberIsTwoAndPileNumberIsFiveShouldThrowException() {
		Table table = new Table(piles,deck);
		assertThrows(ArrayIndexOutOfBoundsException.class,()->table.discard(2, 5));
	}
	
	@Test
	void discardReturnsTrueWhenCardWasFound(){
		Deck deck1 = new Deck();
		DiscardMove discardMove = new DiscardMove(5, 1);
		Table table = new Table(piles, deck1);
		
		assertTrue(table.discard(discardMove));
	}

	@Test
	void discardReturnsFalseWhenCardWasNotFound(){
		Deck deck1 = new Deck();
		piles[0] = new AscendingPile(50);
		DiscardMove discardMove = new DiscardMove(2, 1);
	
		Table table = new Table(piles, deck1);
		
		assertFalse(table.discard(discardMove));
	}
	
	@Test
	void numberOfPiles(){
		Table table = new Table(piles, new Deck());
		
		assertEquals(4, table.numberOfPiles());
	}
	
	@Test
	void getTopCard(){
		Table table = new Table(piles, new Deck());
		
		assertEquals(1, table.getTopCard(1));
	}
}
