package com.farm.swine;


import static com.farm.swine.PigGame.GOAL_SCORE;

public class UserPigPlayer implements PigPlayer {



    public UserPigPlayer() {
        System.out.println("Enter nothing to roll; enter anything to hold.");
    }
    /**
     *
     * @param myScore
     * @param otherScore
     * @param turnTotal
     * @return
     */
    public boolean isRolling(int myScore,
                             int otherScore,
                             int turnTotal)
    {
        if(myScore>=GOAL_SCORE && otherScore <GOAL_SCORE){
            // GOAL
            return false;
        }
        return true;
    }
}
