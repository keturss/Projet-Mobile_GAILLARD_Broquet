package fr.iut63.towerdefense.UI.util.data;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import fr.iut63.towerdefense.UI.util.save.ILoad;
import fr.iut63.towerdefense.model.gamelogic.GameState;

public class Stub implements ILoad {

    @Override
    public Serializable load(FileInputStream file) {
        ArrayList<GameState> scores = new ArrayList<>();
        scores.add(new GameState("Matteo"));
        scores.add(new GameState("Victor"));
        scores.add(new GameState("LEO"));
        scores.add(new GameState("Pierre"));
        scores.add(new GameState("Antoine"));
        scores.add(new GameState("Bernard"));
        scores.add(new GameState("Lucas"));
        return scores;
    }

}
