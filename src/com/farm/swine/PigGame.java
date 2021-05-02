package com.farm.swine;

import java.util.Scanner;

/**
 * Plays PIG game with two PigPlayers
 * The game can be played between two "Human" players or it can be
 * played between one "Human" and one "Computer" player.
 *
 * The "Computer" player will never score more than 20 points per single
 * turn.
 *
 * The "Human" player will always get to choose whether or not to proceed
 * with the next Die roll.
 */
public class PigGame {

    protected static final String COMPUTER = "Computer";
    protected static final int GOAL_SCORE = 100;
    protected static final String HUMAN = "Human";
    private final Scanner in = new Scanner(System.in);
    private final static Die die = new Die();
    private PigPlayer p1;
    private PigPlayer p2;

    int p1Score = 0;
    int p2Score = 0;


    public PigGame() {
        p1 = new UserPigPlayer();
        p2 = new UserPigPlayer();
    }

    /**
     * @param player1  HoldAt20PigPlayer OR UserPigPlayer
     * @param player2  HoldAt20PigPlayer OR UserPigPlayer
     */
    PigGame(PigPlayer player1, PigPlayer player2) {
        p1 = player1;
        p2 = player2;
    }

    /**
     * Plays a game.
     * play always executes first player, then second player.
     */
    public void play() {
        // Plays until someone scores a GOAL
        while (p1Score < GOAL_SCORE && p2Score < GOAL_SCORE) {
            scoreBoard();
            execPlayerOneTurn();
            scoreBoard();
            execPlayerTwoTurn();
        }
    }
    /**
     *
     */
    private void execPlayerTwoTurn() {
        // Player two's turn
        if (p1Score <= GOAL_SCORE) {
            System.out.println("It is player 2's turn.");
            if (p2 instanceof UserPigPlayer) {
                p2Score += takeUserTurn(p2, p2Score, p1Score, HUMAN);
            } else {
                p2Score += takeUserTurn(p2, p2Score, p1Score, COMPUTER);
            }
        }
    }
    /**
     *
     */
    private void execPlayerOneTurn() {
        // Player one's turn
        if (p2Score <= GOAL_SCORE) {
            System.out.println("It is player 1's turn.");
            if (p1 instanceof UserPigPlayer) {
                p1Score += takeUserTurn(p1, p1Score, p2Score, HUMAN);
            } else {
                p1Score += takeUserTurn(p1, p1Score, p2Score, COMPUTER);
            }
        }
    }
    /**
     * @param player
     * @param myScore
     * @param opScore
     * @param user
     */
    private int takeUserTurn(PigPlayer player, int myScore, int opScore, String user) {
        int thisScore = 0;
        do {
            int roll = die.nextRoll();
            System.out.println("Roll: " + roll);
            if (roll != 1) {
                thisScore += roll;
                if (user.equals(HUMAN)) {
                    System.out.print("Turn total: " + thisScore + " Roll/Hold? ");
                    if (!in.nextLine().equals("")) {
                        break;
                    }
                }
            } else {
                thisScore = 0;
                break;
            }
        } while (player.isRolling(myScore + thisScore, opScore, thisScore));

        System.out.println("Turn total: " + thisScore);
        System.out.println("New Score: " + (myScore + thisScore));
        return thisScore;
    }

    /**
     * Convenience function to print overall scores
     */
    private void scoreBoard() {
        System.out.println(String.format("Player 1 score: %d", p1Score));
        System.out.println(String.format("Player 2 score: %d", p2Score));
    }
}
