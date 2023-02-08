package com.thegame.tests;

import static org.junit.jupiter.api.Assertions.*;

import com.thegame.pile.DescendingPile;
import com.thegame.pile.DiscardPile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
@Testable
class DescendingPileTest {
	
	DiscardPile pile;
	
	//Setup
	@BeforeEach
	public void setup() {
		pile=new DescendingPile(25);
	}

	@Test
	void discardWhenCardNumberIsExactlyGreaterThanTen() {
		//Invoke discard method and analyze results
		assertTrue(pile.discard(35));
		//Invoke getTopCard method
		int top = pile.getTopCard();
		//Analyze getting expected Top card or not
		assertEquals(35, top);
		
	}
	
	@Test
	void discardWhenCardNumberIsLessThanTopCard() {
		//Invoke discard method and analyze results
		assertTrue(pile.discard(21));
		//Invoke getTopCard method
		int top = pile.getTopCard();
		//Analyze getting expected Top card or not
		assertEquals(21, top);
		
	}
	
	@Test
	void shouldNotDiscardWhenCardNumberIsGreaterThanTopCardButNotByTen() {
		//Invoke discard method and analyze results
		assertFalse(pile.discard(28));
		//Invoke getTopCard method
		int top = pile.getTopCard();
		//Analyze getting expected Top card or not
		assertNotEquals(28, top);
		
	}
	
	@Test
	void getRulesShouldReturnDescendingPileRules() {
		//Check Rules
		assertEquals("Cards must be discarded in descending order unless the card is exactly 10 greater than the top card",
				pile.getRules());
	}
	

}
