package com.thegame;

import com.thegame.pile.AscendingPile;
import com.thegame.pile.DescendingPile;
import com.thegame.pile.DiscardPile;
import com.thegame.player.Computer;
import com.thegame.player.Human;
import com.thegame.player.Player;

public class TheGame {
    private final Table table;
    private final Player player;

    public TheGame(Table table, Player player) {
        this.table = table;
        this.player = player;
    }

    public void play() {
        int turns = 0;
        while (!table.deckIsEmpty()) {
            System.out.printf(
                    "<---------------- Turn #%s ---------------->\n", ++turns);
            
            fillHand();

            if (doTurn())
                System.out.println("Nice move!\n");
            else
                break;
        }

        if (table.deckIsEmpty())
            System.out.println("You played all of your cards!\n" +
                    "Game over! You won!");
        else {
            System.out.println("Game over. You lost. Have a nice day!");
        }
    }

    /**
     * @return true if the player did not lose and false if did
     */
    private boolean doTurn() {
        int cardsPlayed = 0;
        
        while (!player.handIsEmpty()) {
            showInfo(cardsPlayed);

            MoveType moveType = player.nextMove();

            if (moveType == MoveType.DISCARD) {
                DiscardMove discard = player.discard();

                if (!table.discard(discard)) {
                    System.out.println("Cant discard. Repeat turn");
                    continue;
                }

                System.out.printf("Discarding %s onto pile %s.\n",
                        discard.getCard(), discard.getPileNumber());

                cardsPlayed++;
            } else {
                if (player.confirmGameOver()) {
                    return false;
                }
            }
        }
        
        return true;
    }

    private void showInfo(int cards) {
        System.out.println(table.toString());
        System.out.println(player.toString());
        System.out.printf("You have played %s cards\n", cards);
    }

    private void fillHand() {
        while (!player.handIsFull() && !table.deckIsEmpty()) {
            int drawnCard = table.draw();
            System.out.println("Dealing " + drawnCard + " to player.");
            player.deal(drawnCard);
        }
    }

    public static void main(String[] args) {
        System.out.println("Invalid Input & Pass to Quit (1-20)");
       
        DiscardPile[] piles = {new AscendingPile(1),
                new DescendingPile(20),
                new DescendingPile(20),
                new AscendingPile(1)};

        Table table = new Table(piles, new Deck(4));
        Human human = new Human(new Hand(3));


        TheGame theGame = new TheGame(table, human);
        theGame.play();


        System.out.println("\nPlay to Completion (1-20)");
      
        DiscardPile[] piles2 = {new AscendingPile(1),
                new DescendingPile(20),
                new DescendingPile(20),
                new AscendingPile(1)};

        Table table2 = new Table(piles2, new Deck(20));
        Human human2 = new Human(new Hand(8));



        TheGame theGame2 = new TheGame(table2, human2);
        theGame2.play();


        System.out.println("\nPlay to Completion with Computer(1-20)");
        DiscardPile[] piles3 = {new AscendingPile(1),
                new DescendingPile(20),
                new DescendingPile(20),
                new AscendingPile(1)};

        Table table3 = new Table(piles3, new Deck(20));
        Computer computer = new Computer(new Hand(8), table3);


       
        TheGame theGame3 = new TheGame(table3, computer);
        theGame3.play();
    }

}
