package com.thegame.tests;

import com.thegame.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void deal() {
        Hand hand = new Hand(1);
     
        assertTrue(hand.deal(1));    
    }

    @Test
    void isFull() {
        Hand hand = new Hand(1);
        hand.deal(1);
        
        assertTrue(hand.isFull());
    }

    @Test
    void isEmpty() {
        Hand hand = new Hand(1);
        
        assertTrue(hand.isEmpty());
    }

    @Test
    void remove() {
        Hand hand = new Hand(1);
        hand.deal(1);
    
        assertTrue(hand.remove(1));         
    }
}