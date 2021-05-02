package com.farm.swine;

import static com.farm.swine.PigGame.GOAL_SCORE;

public class HoldAt20PigPlayer implements PigPlayer {


    public HoldAt20PigPlayer() {
    }

    public boolean isRolling(int myScore,
                             int otherScore,
                             int turnTotal)
    {
        if(turnTotal >= 20 )
        {
            return false;
        } else {
            return true;
        }
    }
}
