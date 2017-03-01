
package com.tennis.tennisapp;

import java.util.Comparator;


public class ScoreData {
    private String game;
    private String score;

   
    public String getGame() {
        return game;
    }

    
    public void setGame(String game) {
        this.game = game;
    }

    public String getScore() {
        return score;
    }

  
    public void setScore(String score) {
        this.score = score;
    }


    public static Comparator<ScoreData> ScoreNoComparator = (ScoreData s1, ScoreData s2) -> {
        String ScoreData1 = s1.getGame().toUpperCase();
        String ScoreData2 = s2.getGame().toUpperCase();
        
        //ascending order
        return ScoreData1.compareTo(ScoreData2);
        
        //descending order
        //return ScoreData2.compareTo(ScoreData1);
    };
    
    
    @Override
    public String toString() {
        return "[ GameNo=" + game + ", Score=" + score+ "]";
    }

}
