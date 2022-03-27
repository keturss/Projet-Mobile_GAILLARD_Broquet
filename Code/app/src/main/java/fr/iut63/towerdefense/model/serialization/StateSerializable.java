package fr.iut63.towerdefense.model.serialization;

import java.io.Serializable;

/**
 * State sérialisable
 */
public class StateSerializable implements Serializable {

    private final String pseudo;
    private final int level;
    private final int score;
    private final int time;
    private final boolean victory;

    /**
     * Données de la partie qui seront Serialisées
     *
     * @param pseudo  String
     * @param level   int
     * @param score   int
     * @param time    int
     * @param victory boolean
     */
    public StateSerializable(String pseudo, int level, int score, int time, boolean victory) {
        this.pseudo = pseudo;
        this.level = level;
        this.score = score;
        this.time = time;
        this.victory = victory;
    }

    public String getPseudo(){return pseudo;}

    public int getLevel() {return level;}

    public int getScore() {return score;}

    public int getTime() {return time;}

    public boolean isVictory() {return victory;}
}
