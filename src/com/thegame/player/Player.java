package com.thegame.player;

import com.thegame.DiscardMove;
import com.thegame.MoveType;

public interface Player {
    /**
     * @return the type of the player's next move, e.g. discard or pass. 
     */
    MoveType nextMove();
    /**
     * @return the player's next discard move. This will only be called if the
     * player's next move is a discard.
     */
    DiscardMove discard();

    /**
     * @return the player's next discard move. This will only be called if the
     * player's next move is a discard. 
     */
    boolean deal(int card);

    /**
     * @return  returns true if the player's hand is full and false if it is not 
     */
    boolean handIsFull();

    /**
     * @return true if the player's hand is empty and false if it is not
     */
    boolean handIsEmpty();
    /**
     * @return true if the player's hand is empty and false if it is not
     */
    boolean confirmGameOver();
}
