package com.thegame.player;

import com.thegame.DiscardMove;
import com.thegame.Hand;
import com.thegame.MoveType;

import java.util.Scanner;

public class Human implements Player {
    private Hand hand;
    private Scanner scanner;
    

    public Human(Hand hand) {
        this.hand = hand;
    }

    /**
     * Prompts the human user to choose their next move (discard or
     * pass). The user should enter "d" to discard and "p" to pass. If the user enters an
     * invalid option, prints an error message and prompts them again.
     */
    @Override
    public MoveType nextMove() {
        String message = "d(iscard) or p(ass) >> ";

        System.out.print(message);

        scanner = new Scanner(System.in);
        
        while (!scanner.hasNext("[dp]")) {
            System.out.println("Invalid move try again");
            System.out.print(message);
            scanner.nextLine();
        }

        boolean isDiscard = scanner.nextLine().equals("d");

        return isDiscard ? MoveType.DISCARD : MoveType.PASS;
    }

    /**
     * Prompts the user to enter a card value from their hand and the
     * number of the pile into which they would like to discard. If the user enters
     * non-integer values, prints an error message and prompts them again
     */
    @Override
    public DiscardMove discard() {
        scanner = new Scanner(System.in);

        System.out.print("card number >> ");
        int card = scanner.nextInt();

        System.out.print("pile number >> ");
        int pile = scanner.nextInt();

        hand.remove(card);
        
        return new DiscardMove(card, pile);
    }

    /**
     * Deals a card into the player's hand
     */
    @Override
    public boolean deal(int card) {
        if (card < 1 || card > 99)
            throw new IllegalArgumentException();

        return hand.deal(card);
    }

    /**
     * @return true if the player's hand is full and false if it is not.
     */
    @Override
    public boolean handIsFull() {
        return hand.isFull();
    }

    /**
     * @return true if the player's hand is empty and false if it is not.
     */
    @Override
    public boolean handIsEmpty() {
        return hand.isEmpty();
    }

    /**
     * Prompts the user to confirm that they would like to end the game early.
     */
    @Override
    public boolean confirmGameOver() {
        scanner = new Scanner(System.in);
        System.out.print(
                "Are you sure? This will end the game." +
                        "\nY/N? >> ");

        while (!scanner.hasNext("[ynYN]")) {
            scanner.nextLine();
            System.out.println("Invalid input try again");
            System.out.print("Y/N? >> ");
        }

        return scanner.next().equals("y");
    }

    /**
     * returns a string in the format "Human: hand" where hand is
     * the string representation of the player's hand
     */
    @Override
    public String toString() {
        return "Human: " + hand;
    }
}
