package com.farm.swine;
import java.util.Random;

public class OOPig {

    /**
     * Dependencies/Uses
     * OOPig --> PigGame
     * --> PigPlayer
     * --> HoldAt20PigPlayer
     *
     * @param args
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        PigGame pigGame;
        if (rnd.nextBoolean()) {
            System.out.println("You will be player 1");
            pigGame = new PigGame(new UserPigPlayer(),new HoldAt20PigPlayer());

        } else {
            System.out.println("You will be player 2");
            pigGame = new PigGame(new HoldAt20PigPlayer(),new UserPigPlayer());
        }

        System.out.println("Enter nothing to roll; enter anything to hold.");
        pigGame.play();
    }
}
