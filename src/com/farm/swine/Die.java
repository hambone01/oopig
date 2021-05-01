package com.farm.swine;

import java.util.Random;

public class Die {
    private int[] outcomes;
    private int sides;
    private int min;
    private Random rnd = new Random();

    public Die() {
        outcomes = new int[]{1, 2, 3, 4, 5, 6};
        min = 1;
        sides = 6;
    }

    public Die(int[] outcomes) {
        this.outcomes = outcomes;
    }

    public Die(int sides, int min) {
        this.sides = sides;
        this.min = min;
    }
    public int nextRoll(){
        return outcomes[rnd.nextInt(sides)];
      //  return 10;
    }
}
