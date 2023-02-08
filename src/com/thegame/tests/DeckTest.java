package com.thegame.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import com.thegame.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
class DeckTest {
	
	Deck deck;
	
	//Setup
	@BeforeEach
	void setup(){
		deck= new Deck();
	}

	
	@Test 
	void remainingCardCountTestWhen1cardsDrawn() {
		Set<Integer> set = new HashSet<>();
		set.add(25);
		//Invoke setDrawnCards method
		deck.setDrawnCards(set);
		//Analyze the results
		assertEquals(97, deck.remainingCardCount());
	}
	
	@Test
	void drawCardThrowsExceptionWhenRemainingCountIsZero() {
		//add all values to drawncard to make remaining count zero
		Set<Integer> set = new HashSet<>();
		for(int i=2;i<100;i++) {
			set.add(i);
		}
		//Invoke setDrawnCards method
		deck.setDrawnCards(set);
		//Analyze the results
		assertThrows(ArrayIndexOutOfBoundsException.class,()->deck.drawCard());

	}
	
	@Test
	void drawCardNotThrowsExceptionWhenRemainingCountIsNotZero() {
		//add all values to drawncard to make remaining count to non zero
		Set<Integer> set = new HashSet<>();
		for(int i=2;i<50;i++) {
			set.add(i);
		}
		//Invoke setDrawnCards method
		deck.setDrawnCards(set);
		//Analyze the results
		Assertions.assertTrue(deck.drawCard()>1&&deck.drawCard()<99);
	}
}
