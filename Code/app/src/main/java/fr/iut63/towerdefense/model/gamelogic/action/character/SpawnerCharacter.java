package fr.iut63.towerdefense.model.gamelogic.action.character;


import java.util.Scanner;

import fr.iut63.towerdefense.model.characters.monster.Basic;
import fr.iut63.towerdefense.model.characters.monster.Speed;
import fr.iut63.towerdefense.model.gamelogic.AdministratorLevel;
import fr.iut63.towerdefense.model.gamelogic.GameState;
import fr.iut63.towerdefense.model.gamelogic.action.ILevel;
import fr.iut63.towerdefense.model.gamelogic.action.ISpawner;

public class SpawnerCharacter implements ISpawner {

    private GameState game;
    private ILevel level;

    /**
     *Création du système de génération des ennemies en fonction des level recupérés
     * @param game GameState
     * @param level Level pointant sur le fichier des Characters
     */
    public SpawnerCharacter(GameState game, ILevel level) {
        this.game = game;
        this.level = level;
    }

    /**
     * Generation Characters in X timer
     * @param timer int Timer de la Boucle de Jeu
     */
    public void spawn(int timer) {
        if (level instanceof AdministratorLevel) {
            Scanner scannerFile = ((AdministratorLevel) level).getLevelFile();
            if (timer % 40 == 0 && scannerFile.hasNextLine()) {
                switch (scannerFile.next()) {
                    case "Basic":
                        game.getCharactersAlive().add(new Basic(5));
                        break;
                    case "Speed":
                        game.getCharactersAlive().add(new Speed(3));
                        break;
                    default:
                        game.getCharactersAlive().add(new Basic(3));
                        break;
                }
            } else if (!scannerFile.hasNextLine()) {
                level.nextLevel();
            }
        }
    }
}
