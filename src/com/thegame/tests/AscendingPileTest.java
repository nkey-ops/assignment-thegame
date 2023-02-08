package com.thegame.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.thegame.pile.AscendingPile;
import com.thegame.pile.DiscardPile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AscendingPileTest {

    DiscardPile pile;
	
    // Setup
	@BeforeEach
	public void setup() {
		pile=new AscendingPile(25);
	}

	@Test
	void discardWhenCardNumberIsGreaterTopCard() {
		//Invoke discard method and analyze results
		assertTrue(pile.discard(35));
		//Invoke getTopCard method
		int top = pile.getTopCard();
		//Analyze getting expected Top card or not
		assertEquals(35, top);
		
	}
	
	@Test
	void shouldNotDiscardWhenCardNumberIsLessThanTopCardByTen() {
		//Invoke discard method and analyze results
		assertFalse(pile.discard(21));
		//Invoke getTopCard method
		int top = pile.getTopCard();
		//Analyze getting expected Top card or not
		assertNotEquals(21, top);
		
	}
	
	@Test
	void shouldDiscardWhenCardNumberIsLessThanTopCardByTen() {
		//Invoke discard method and analyze results
		assertTrue(pile.discard(15));
		//Invoke getTopCard method
		int top = pile.getTopCard();
		//Analyze getting expected Top card or not
		assertEquals(15, top);
		
	}
	
	@Test
	void getRulesShouldReturnAscendingPileRules() {
		//Check Ascending rules
		assertEquals("Cards must be discarded in ascending order unless the card is exactly 10 less than the top card",
				pile.getRules());
	}

}


