package com.farm.swine;

import static com.farm.swine.PigGame.GOAL_SCORE;

public class HoldAt20PigPlayer implements PigPlayer {


    public HoldAt20PigPlayer() {
    }

    public boolean isRolling(int myScore,
                             int otherScore,
                             int turnTotal)
    {
        if(myScore == 0)
        {
            return true;
        }
        if(myScore >= GOAL_SCORE || (myScore%20)==0 )
        {
            return false;
        } else {
            return true;
        }
    }
}
