package fr.iut63.towerdefense.model.serialization;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Rang des scores sérializable
 */
public class ScoreRankingSerializable implements Serializable {


    private final List<StateSerializable> ranking = new ArrayList<>();

    public List<StateSerializable> getRanking() {
        return ranking;
    }
}
