package com.thegame.player;

import com.thegame.*;
import com.thegame.pile.AscendingPile;
import com.thegame.pile.DiscardPile;

public class Computer implements Player{

    private Hand hand;
    private Table table;
    
    public Computer(Hand hand, Table table) {
        this.hand = hand;
        this.table = table;
    }

    @Override
    public MoveType nextMove() {
        return getDiscardMoved() != null ? MoveType.DISCARD : MoveType.PASS;
    }

    @Override
    public DiscardMove discard() {
        DiscardMove discardMoved = getDiscardMoved();
        if(discardMoved == null)
            throw new IllegalStateException("Cant Discard a card");

        hand.remove(discardMoved.getCard());
        
        return discardMoved;
    }
    
    private DiscardMove getDiscardMoved(){
        int closestToTheTop = -1;
        int pile = -1;
        int range = Integer.MAX_VALUE;
        
        for (int card: hand.getCards()) {
            for (int i = 0; i < table.getPiles().length; i++) {
                DiscardPile discardPile = table.getPiles()[i];

                int topCard = table.getTopCard(i + 1);
                int cRange = Math.abs(card - topCard); 
                boolean isClosest = false;
                
                if (discardPile instanceof AscendingPile) {
                    if (card - topCard < range &&  card > topCard && (card <= closestToTheTop || closestToTheTop == -1))
                        isClosest = true;
                } else {
                    if (topCard - card < range && card < topCard && (card >= closestToTheTop || closestToTheTop == -1)) 
                        isClosest = true;
                }
                
                if(isClosest) {
                    range = Math.abs(card - topCard) ;
                    closestToTheTop = card;
                    pile = i;
                }
            }
        }

        return closestToTheTop != -1 ? new DiscardMove(closestToTheTop, pile + 1) : null;
    }
    
    @Override
    public boolean deal(int card) {
        if (card < 1 || card > 99)
            throw new IllegalArgumentException();
            
        return hand.deal(card);
    }

    @Override
    public boolean handIsFull() {
        return hand.isFull();
    }

    @Override
    public boolean handIsEmpty() {
        return hand.isEmpty();
    }

    @Override
    public boolean confirmGameOver() {
        return true;
    }

    @Override
    public String toString() {
            return "Computer: " + hand;
    }
}
