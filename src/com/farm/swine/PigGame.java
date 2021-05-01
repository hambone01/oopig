package com.farm.swine;

import java.util.Scanner;

public class PigGame {
    public static final int GOAL_SCORE = 100;
    private PigPlayer p1;
    private PigPlayer p2;

    private Scanner in = new Scanner(System.in);
    public static Die die = new Die();

    int p1Score = 0;
    int p2Score = 0;
    int turnTotal = 0;

    public PigGame() {
    }

    /**
     * @param player1
     * @param player2
     */
    PigGame(PigPlayer player1, PigPlayer player2) {
        p1 = player1;
        p2 = player2;
    }

    /**
     *
     */
    public void play() {
        while (p1Score < GOAL_SCORE && p2Score < GOAL_SCORE) {
            scoreBoard();
            if (p2Score <= GOAL_SCORE) {
                System.out.println("It is player 1's turn.");
                if (p1 instanceof UserPigPlayer) {
                    p1Score += takeUserTurn(p1, p1Score, p2Score,"Human");
                } else {
                    p1Score += takeUserTurn(p1, p1Score, p2Score,"Computer");
                }
            }
            scoreBoard();
            if (p1Score <= GOAL_SCORE) {
                System.out.println("It is player 2's turn.");
                if (p2 instanceof UserPigPlayer) {
                    p2Score += takeUserTurn(p2, p2Score, p1Score, "User");
                } else {
                    p2Score += takeHoldAtTwentyTurn(p2, p2Score, p1Score);
                }
            }
        }
    }

    /**
     * @param player
     * @param myScore
     * @param opScore
     */
    private int takeHoldAtTwentyTurn(PigPlayer player, int myScore, int opScore) {
        int thisScore = 0;
        do {
            int roll = die.nextRoll();
            System.out.println("Roll: " + roll);
            if (roll != 1) {
                thisScore += roll;
            } else {
                thisScore = 0;
                break;
            }
        } while (player.isRolling(myScore + thisScore, opScore, turnTotal));

        System.out.println("Turn total: " + thisScore);
        System.out.println("New Score: " + (myScore + thisScore));
        return thisScore;

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
                if(user.equals("Human")) {
                    System.out.println("Turn total: " + thisScore + " Roll/Hold?");
                    if (!in.nextLine().equals("")) {
                        break;
                    }
                }
            } else {
                thisScore = 0;
                break;
            }
        } while (player.isRolling(myScore + thisScore, opScore, turnTotal));

        System.out.println("Turn total: " + thisScore);
        System.out.println("New Score: " + (myScore + thisScore));
        return thisScore;
    }

    private void scoreBoard() {
        System.out.println(String.format("Player 1 score: %d", p1Score));
        System.out.println(String.format("Player 2 score: %d", p2Score));
    }
}
